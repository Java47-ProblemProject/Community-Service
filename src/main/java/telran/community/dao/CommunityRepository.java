package telran.community.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import telran.community.model.Community;

import java.util.Set;
import java.util.stream.Stream;

@Repository
public interface CommunityRepository extends MongoRepository<Community,String> {
}
