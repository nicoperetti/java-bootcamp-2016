package practice3;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    public List<User> findByLastName(String lastName);

    public List<User> findByNickName(String nickName);
}
