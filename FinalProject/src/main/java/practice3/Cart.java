package practice3;

import org.springframework.data.annotation.Id;
import java.util.*;

public class Cart {

    @Id
    private String username;
    private List<Product> productlist;
    private double subtotal;

    protected Cart() {}

    public Cart(String username) {
        this.username = username;
        this.subtotal = 0;
        this.productlist = new ArrayList<Product>();
    }

    public void addProductToCart(Product p) {
        productlist.add(p);
        this.subtotal += p.getPrice();
    }

    public List<Product> getProductList() {
        return this.productlist;
    }

    public double getSubtotal() {
        return this.subtotal;
    }

    public String getUsername() {
        return this.username;
    }


    @Override
    public String toString() {
        String products = "";
        for (int i = 0; i < productlist.size(); i++) {
            products += productlist.get(i).toString();
        }
        return String.format(
                "Cart[username=%s, subtotal='%f', amount=%d, products=%s]",
                username, subtotal, productlist.size(), products);
    }

}
