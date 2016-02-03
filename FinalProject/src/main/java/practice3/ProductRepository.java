package practice3;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Long> {

    public List<Product> findByName(String name);

    public List<Product> findByCategory(String category);
}
