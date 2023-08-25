package telran.community.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import telran.community.model.Community;


@Repository
@RequiredArgsConstructor
public class CommunityCustomRepository {
    private final MongoTemplate mongoTemplate;
    @Transactional
    public void deleteProblemByProblemId(String problemId) {
        Query query = new Query(Criteria.where("problems").is(problemId));
        Update update = new Update().pull("problems", problemId);
        mongoTemplate.updateMulti(query, update, Community.class);
    }
}
