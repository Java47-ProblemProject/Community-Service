package telran.community.configuration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
import telran.community.dao.CommunityCustomRepository;
import telran.community.dao.CommunityRepository;
import telran.community.dto.accounting.ProfileDto;
import telran.community.dto.kafkaData.problemDataDto.ProblemMethodName;
import telran.community.dto.kafkaData.problemDataDto.ProblemServiceDataDto;

import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;


@Getter
@Configuration
@RequiredArgsConstructor
public class KafkaConsumer {
    final CommunityCustomRepository communityCustomRepository;
    final CommunityRepository communityRepository;
    final KafkaProducer kafkaProducer;
    ProfileDto profile;
    ProblemServiceDataDto problemData;

    @Bean
    @Transactional
    protected Consumer<ProfileDto> receiveProfile() {
        return data -> {
            if (data.getUsername().equals("DELETED_PROFILE")) {
                //profile was deleted ->
                data.getCommunities().stream()
                        .map(communityRepository::findById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .forEach(c -> {
                            c.removeMember(data.getEmail());
                            c.setTotalMembers();
                            communityRepository.save(c);
                        });
                this.profile = new ProfileDto();
            } else {
                this.profile = data;
                data.getCommunities().stream()
                        .map(communityRepository::findById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .forEach(c -> {
                            c.addMember(data.getEmail());
                            c.setTotalMembers();
                            communityRepository.save(c);
                        });
            }
        };
    }

    @Bean
    @Transactional
    protected Consumer<ProblemServiceDataDto> receiveDataFromProblem() {
        return data -> {
            String problemId = data.getProblemId();
            ProblemMethodName method = data.getMethodName();
            System.out.println("Problem received - " + problemId + method);
            Set<String> communities = data.getCommunities();
            if(method.equals(ProblemMethodName.ADD_PROBLEM) || method.equals(ProblemMethodName.EDIT_PROBLEM)){
                communities.forEach(System.out::println);
                communities.stream()
                        .map(communityRepository::findById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .forEach(c -> {
                            c.addProblem(problemId);
                            c.setTotalProblems();
                            communityRepository.save(c);
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
