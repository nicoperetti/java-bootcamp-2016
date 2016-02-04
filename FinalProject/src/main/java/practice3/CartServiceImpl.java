package practice3;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Component("cartService")
@Transactional
class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public String createCart(String username) {
        String result = "ok!";
        Cart newcart = new Cart(username);
        this.cartRepository.save(newcart);
        return result;
    }

    @Override
    public String addProductToCart(String username, Product product) {
        String result = "Ok!";
        Cart cart = this.cartRepository.findOne(username);
        cart.addProductToCart(product);
        this.cartRepository.save(cart);
        return result + cart.toString();
    }

    @Override
    public Cart showCart(String username) {
        Cart cart = this.cartRepository.findOne(username);
        return cart;
    }
}
