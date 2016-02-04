package practice3;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Component("productService")
@Transactional
class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String addProduct(long id, String name, String category, double price) {
        String result = "ok!";
        Product newproduct = new Product(id, name, category, price);
        this.productRepository.save(newproduct);
        return result;
    }

    @Override
    public List<Product> showProduct() {
        List<Product> productlist = new ArrayList<Product>();
        productlist = productRepository.findAll();
        return productlist;
    }

    @Override
    public List<Product> findProductByName(String name) {
        List<Product> productlist = new ArrayList<Product>();
        productlist = productRepository.findByName(name);
        return productlist;
    }

    @Override
    public List<Product> findProductByCategory(String category) {
        List<Product> productlist = new ArrayList<Product>();
        productlist = productRepository.findByCategory(category);
        return productlist;
    }

    @Override
    public Product findOne(long id) {
        return this.productRepository.findOne(id);
    }
}
