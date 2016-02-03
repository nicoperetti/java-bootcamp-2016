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

//    @Override
//    public String updateUser(String username, String lastname, String nickname) {
//        String result = "Invalid username!";
//        if (this.userRepository.exists(username)) {
//            User user = this.userRepository.findOne(username);
//            result = "You need to be login to update your user";
//            if (user.getlogin()) {
//                result = "update ";
//                if (lastname != "") {
//                    result += "lastname ";
//                    user.setLastName(lastname);
//                }
//                if (nickname != "") {
//                    result += ", nickname";
//                    user.setNickName(nickname);
//                }
//                this.userRepository.save(user);
//            }
//        }
//        return result;
//    }

    @Override
    public List<String> showProduct() {
        List<String> productlist = new ArrayList<String>();
        for (Product product: productRepository.findAll()) {
            productlist.add(product.toString());
        }
        return productlist;
    }

    @Override
    public List<String> findProductByName(String name) {
        List<String> result = new ArrayList<String>();
        List<Product> productlist = new ArrayList<Product>();
        productlist = productRepository.findByName(name);
        for (int i = 0; i < productlist.size(); i++) {
            result.add(productlist.get(i).toString());
        }
        return result;
    }

    @Override
    public List<String> findProductByCategory(String category) {
        List<String> result = new ArrayList<String>();
        List<Product> productlist = new ArrayList<Product>();
        productlist = productRepository.findByCategory(category);
        for (int i = 0; i < productlist.size(); i++) {
            result.add(productlist.get(i).toString());
        }
        return result;
    }
}
