package telran.community.kafka;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
import telran.community.dao.CommunityCustomRepository;
import telran.community.dao.CommunityRepository;
import telran.community.kafka.accounting.ProfileDto;
import telran.community.kafka.kafkaData.problemDataDto.ProblemMethodName;
import telran.community.kafka.kafkaData.problemDataDto.ProblemServiceDataDto;
import telran.community.security.JwtTokenService;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;


@Getter
@Configuration
@RequiredArgsConstructor
public class KafkaConsumer {
    private final CommunityCustomRepository communityCustomRepository;
    private final CommunityRepository communityRepository;
    private final KafkaProducer kafkaProducer;
    private final JwtTokenService jwtTokenService;
    private ProfileDto profile;
    private String token;
    private ProblemServiceDataDto problemData;

    @Bean
    @Transactional
    protected Consumer<Map<String, ProfileDto>> receiveProfile() {
        return data -> {
            if (!data.isEmpty()) {
                Map.Entry<String, ProfileDto> entry = data.entrySet().iterator().next();
                if (entry.getValue().getUsername().equals("DELETED_PROFILE")) {
                    //profile was deleted ->
                    jwtTokenService.deleteCurrentProfileToken(entry.getValue().getEmail());
                    Set<String> problemsToRemove = entry.getValue().getActivities().entrySet().stream()
                            .filter(e -> "PROBLEM".equals(e.getValue().getType()) && e.getValue().getAction().contains("AUTHOR"))
                            .map(Map.Entry::getKey)
                            .collect(Collectors.toSet());
                    entry.getValue().getCommunities().stream()
                            .map(communityRepository::findById)
                            .filter(Optional::isPresent)
                            .map(Optional::get)
                            .forEach(c -> {
                                c.removeMember(entry.getValue().getEmail());
                                c.setTotalMembers();
                                problemsToRemove.forEach(c::removeProblem);
                                c.setTotalProblems();
                                communityRepository.save(c);
                            });
                    this.profile = null;
                    this.token = null;
                } else {
                    this.profile = entry.getValue();
                    if (!entry.getKey().isEmpty()) {
                        this.token = entry.getKey();
                    }
                    jwtTokenService.setCurrentProfileToken(this.profile.getEmail(), this.token);
                    System.out.println("Token pushed - " + this.token);
                    entry.getValue().getCommunities().stream()
                            .map(communityRepository::findById)
                            .filter(Optional::isPresent)
                            .map(Optional::get)
                            .forEach(c -> {
                                if (!c.getMembers().contains(entry.getValue().getEmail())) {
                                    c.addMember(entry.getValue().getEmail());
                                    c.setTotalMembers();
                                    communityRepository.save(c);
                                }
                            });
                }
            }

        };
    }

    @Bean
    @Transactional
    protected Consumer<ProblemServiceDataDto> receiveDataFromProblem() {
        return data -> {
            String problemId = data.getProblemId();
            ProblemMethodName method = data.getMethodName();
            Set<String> communities = data.getCommunities();
            if (method.equals(ProblemMethodName.ADD_PROBLEM) || method.equals(ProblemMethodName.EDIT_PROBLEM)) {
                communities.stream()
                        .map(communityRepository::findById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .forEach(c -> {
                            if (!c.getProblems().contains(problemId)) {
                                c.addProblem(problemId);
                                c.setTotalProblems();
                                communityRepository.save(c);
                            }
                        });
            }
            if (method.equals(ProblemMethodName.DELETE_PROBLEM)) {
                communities.stream()
                        .map(communityRepository::findById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .forEach(c -> {
                            c.removeProblem(problemId);
                            c.setTotalProblems();
                            communityRepository.save(c);
                        });
            }
        };
    }
}
