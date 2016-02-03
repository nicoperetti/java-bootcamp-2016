package practice3;

import java.util.*;

public interface ProductService {

    String addProduct(long id, String name, String category, double price);

    List<String> showProduct();

    List<String> findProductByName(String name);

    List<String> findProductByCategory(String category);
}
