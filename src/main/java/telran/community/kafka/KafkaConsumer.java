package telran.community.kafka;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
import telran.community.dao.CommunityCustomRepository;
import telran.community.dao.CommunityRepository;
import telran.community.kafka.kafkaData.problemDataDto.ProblemMethodName;
import telran.community.kafka.kafkaData.problemDataDto.ProblemServiceDataDto;
import telran.community.kafka.profileDataDto.Activity;
import telran.community.kafka.profileDataDto.ProfileDataDto;
import telran.community.kafka.profileDataDto.ProfileMethodName;
import telran.community.security.JwtTokenService;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
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
    private final Map<String, ProfileDataDto> profiles = new ConcurrentHashMap<>();

    @Bean
    @Transactional
    protected Consumer<ProfileDataDto> receiveProfile() {
        return data -> {
            String email = data.getEmail();
            Map<String, Activity> activities = data.getActivities();
            Set<String> communities = data.getCommunities();
            ProfileMethodName methodName = data.getMethodName();
            ProfileDataDto profile = this.profiles.get(email);
            if (!profiles.containsKey(email)) {
                this.profiles.put(email, data);
                profile = data;
            }
            if (methodName.equals(ProfileMethodName.SET_PROFILE)) {
                jwtTokenService.setCurrentProfileToken(email, data.getToken());
                this.profiles.get(email).setToken("");
                checkAndSetCommunities(email, communities);
            } else if (methodName.equals(ProfileMethodName.UNSET_PROFILE)) {
                jwtTokenService.deleteCurrentProfileToken(email);
                this.profiles.remove(email);
            } else if (methodName.equals(ProfileMethodName.UPDATED_PROFILE)) {
                this.profiles.put(email, profile);
            } else if (methodName.equals(ProfileMethodName.EDIT_PROFILE_COMMUNITIES)) {
                checkAndSetCommunities(email, communities);
            } else if (methodName.equals(ProfileMethodName.DELETE_PROFILE)) {
                jwtTokenService.deleteCurrentProfileToken(email);
                deleteAllAuthorizedProblems(activities, communities, email);
                this.profiles.remove(email);
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
            if (method.equals(ProblemMethodName.ADD_PROBLEM) || method.equals(ProblemMethodName.EDIT_PROBLEM) || method.equals(ProblemMethodName.GET_PROBLEM)) {
                checkAndSetProblems(communities, problemId);
            }
            if (method.equals(ProblemMethodName.DELETE_PROBLEM)) {
                deleteAllProblems(communities, problemId);
            }
        };
    }

    private void checkAndSetCommunities(String email, Set<String> communities) {
        communities.stream()
                .map(communityRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(c -> {
                    if (!c.getMembers().contains(email)) {
                        c.addMember(email);
                        c.setTotalMembers();
                        communityRepository.save(c);
                    }
                });
    }

    private void deleteAllAuthorizedProblems(Map<String, Activity> activities, Set<String> communities, String email) {
        Set<String> problemsToRemove = activities.entrySet().stream()
                .filter(e -> "PROBLEM".equals(e.getValue().getType()) && e.getValue().getAction().contains("AUTHOR"))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        communities.stream()
                .map(communityRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(c -> {
                    c.removeMember(email);
                    c.setTotalMembers();
                    problemsToRemove.forEach(c::removeProblem);
                    c.setTotalProblems();
                    communityRepository.save(c);
                });
    }

    private void checkAndSetProblems(Set<String> communities, String problemId) {
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

    private void deleteAllProblems(Set<String> communities, String problemId) {
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
}
