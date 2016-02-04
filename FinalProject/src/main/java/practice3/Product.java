package practice3;

import org.springframework.data.annotation.Id;

public class Product {

    @Id
    private long id;
    private String name;
    private String category;
    private double price;

    protected Product() {}

    public Product(long id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(
                "Product[id=%d, name=%s, category='%s', price='%f']",
                id, name, category, price);
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }


    public String getCategory() {
        return this.category;
    }
}
