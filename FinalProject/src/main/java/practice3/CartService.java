package practice3;

import java.util.*;

public interface CartService {

    String createCart(String username);

    String addProductToCart(String username, Product product);

    Cart showCart(String username);
}
