package practice3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/addproduct", method = RequestMethod.POST)
    public String addproduct(@RequestParam(value="name") String name,
                        @RequestParam(value="category") String category,
                        @RequestParam(value="price") double price) {
        return productService.addProduct(counter.incrementAndGet(), name, category, price);
    }

//    @RequestMapping(value = "/{username}/delete", method = RequestMethod.GET)
//    public String deleteuser(@PathVariable String username) {
//        return userService.deleteUser(username);
//    }

    @RequestMapping("/showproduct")
    public List<String> showproduct() {
        return productService.showProduct();
    }

    @RequestMapping("/findproductbyname")
    public List<String> findproductbyname(@RequestParam(value="name") String name) {
        return productService.findProductByName(name);
    }

    @RequestMapping("/findproductbycategory")
    public List<String> findproductbycategory(@RequestParam(value="category") String category) {
        return productService.findProductByCategory(category);
    }
}
