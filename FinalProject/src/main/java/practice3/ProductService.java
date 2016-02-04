package practice3;

import java.util.*;

public interface ProductService {

    String addProduct(long id, String name, String category, double price);

    List<Product> showProduct();

    List<Product> findProductByName(String name);

    List<Product> findProductByCategory(String category);
}
