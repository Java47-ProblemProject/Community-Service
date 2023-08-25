package telran.community.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import telran.community.configuration.KafkaConsumer;


@Service
@RequiredArgsConstructor
public class CustomSecurity {
    final KafkaConsumer kafkaConsumer;
//    final SolutionRepository solutionRepository;
//
//    public boolean checkSolutionAuthorAndProblemId(String problemId, String solutionId, String authorId) {
//        Solution solution = solutionRepository.findById(solutionId).orElseThrow(NoSuchElementException::new);
//        ProfileDto profile = kafkaConsumer.getProfile();
//        ProblemServiceDataDto problem = kafkaConsumer.getProblemData();
//        return authorId.equals(profile.getEmail()) && authorId.equals(solution.getAuthorId()) && problemId.equals(problem.getProblemId());
//    }
//
//    public boolean checkProblemId(String problemId){
//        ProblemServiceDataDto problem = kafkaConsumer.getProblemData();
//        return problemId.equals(problem.getProblemId());
//    }
}
