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
public class AppController {

    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    private final AtomicLong counter = new AtomicLong();

//-----------------------------User Controller -------------------------------
    @RequestMapping(value="/adduser", method = RequestMethod.POST)
    public String adduser(@RequestParam(value="userName") String userName,
                        @RequestParam(value="password") String pass,
                        @RequestParam(value="lastName", defaultValue="Peretti") String lastName,
                        @RequestParam(value="nickName", defaultValue="Nico") String nickName) {
        return userService.addUser(userName, pass, lastName, nickName);
    }

    @RequestMapping(value = "/{username}/update", method = RequestMethod.GET)
    public String updateuser(@PathVariable String username,
                        @RequestParam(value="lastName", defaultValue="") String lastName,
                        @RequestParam(value="nickName", defaultValue="") String nickName) {
        String result = "Invalid username or may be your are not logged";
        if (userService.validUsername(username) && userService.isLogged(username)) {
            result = userService.updateUser(username, lastName, nickName);
        }
        return result;
    }

    @RequestMapping(value = "/{username}/delete", method = RequestMethod.GET)
    public String deleteuser(@PathVariable String username) {
        String result = "Invalid username or may be your are not logged";
        if (userService.validUsername(username) && userService.isLogged(username)) {
            result = userService.deleteUser(username);
        }
        return result;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value="username", defaultValue="") String username,
                        @RequestParam(value="password", defaultValue="") String password) {
        String result = "Invalid username";
        if (userService.validUsername(username)) {
            result = userService.login(username, password);
        }
        return result;
    }

    @RequestMapping(value = "/{username}/logout", method = RequestMethod.GET)
    public String login(@PathVariable String username) {
        String result = "Invalid username or may be your are not logged";
        if (userService.validUsername(username) && userService.isLogged(username)) {
            result = userService.logout(username);
        }
        return result;
    }

    @RequestMapping("/showuser")
    public List<User> showuser() {
        return userService.showUser();
    }

    @RequestMapping("/finduserbyname")
    public List<User> finduserbyname(@RequestParam(value="lastName", defaultValue="Peretti") String lastName) {
        return userService.findUserByLastName(lastName);
    }

    @RequestMapping("/finduserbynickname")
    public List<User> finduserbynickname(@RequestParam(value="nickName", defaultValue="Peretti") String nickName) {
        return userService.findUserByNickName(nickName);
    }
//-----------------------------User Controller ---------------------------------
//------------------------------------------------------------------------------
//-----------------------------Product Controller ------------------------------

    // user filter to add product DOIT
    @RequestMapping(value="/addproduct", method = RequestMethod.POST)
    public String addproduct(@RequestParam(value="name") String name,
                        @RequestParam(value="category") String category,
                        @RequestParam(value="price") double price) {
        return productService.addProduct(counter.incrementAndGet(), name, category, price);
    }

    @RequestMapping("/showproduct")
    public List<Product> showproduct() {
        return productService.showProduct();
    }

    @RequestMapping("/findproductbyname")
    public List<Product> findproductbyname(@RequestParam(value="name") String name) {
        return productService.findProductByName(name);
    }


    @RequestMapping("/findproductbycategory")
    public List<Product> findproductbycategory(@RequestParam(value="category") String category) {
        return productService.findProductByCategory(category);
    }
//-----------------------------Product Controller ------------------------------
//------------------------------------------------------------------------------
//-----------------------------Cart Controller ---------------------------------

    @RequestMapping(value="{username}/createcart", method = RequestMethod.POST)
    public String createcart(@PathVariable String username) {
        return cartService.createCart(username);
    }

    @RequestMapping(value="{username}/addproducttocart", method = RequestMethod.POST)
    public String addproducttocart(@PathVariable String username,
                            @RequestParam(value="productid") long productid) {
        Product product = productService.findOne(productid);
        return cartService.addProductToCart(username, product);
    }

    @RequestMapping(value="{username}/removeproductfromcart", method = RequestMethod.POST)
    public String removeproductfromcart(@PathVariable String username,
                            @RequestParam(value="productid") long productid) {
        Product product = productService.findOne(productid);
        return cartService.removeProductFromCart(username, product);
    }

    @RequestMapping(value="{username}/deletecart", method = RequestMethod.GET)
    public String deletecart(@PathVariable String username) {
        return cartService.deleteCart(username);
    }

    @RequestMapping(value="{username}/showcart", method = RequestMethod.GET)
    public Cart showcart(@PathVariable String username) {
        return cartService.showCart(username);
    }


    @RequestMapping(value="{username}/buyproductfromcart", method = RequestMethod.GET)
    public String buyproductfromcart(@PathVariable String username) {
        return cartService.buyProductFromCart(username);
    }
//-----------------------------Cart Controller ---------------------------------

}
