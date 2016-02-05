package practice3;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@EnableMongoRepositories
public class ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;



    @Before
    public void init() {
        userRepository.deleteAll();
        productRepository.deleteAll();
        cartRepository.deleteAll();
    }

//--------------------Test for User Services-----------------------------------
    @Test
    public void testNewUserAndDelete() {
        String username = "nico33";
        String lognewuser = userService.addUser(username, "admin", "peretti", "nico");
        assertTrue(userRepository.exists(username));
        lognewuser = userService.deleteUser(username);
        assertFalse(userRepository.exists(username));

    }

    @Test
    public void testUpdateUser() {
        String username = "nico33";
        String lognewuser = userService.addUser(username, "admin", "peretti", "nico");
        assertTrue(userRepository.exists(username));
        lognewuser = userService.updateUser(username, "Peretti", "Jesus");
        assertEquals(userRepository.findOne(username).getLastname(), "Peretti");
        assertEquals(userRepository.findOne(username).getNickname(), "Jesus");
    }


    @Test
    public void testLoginAndLogout() {
        String username = "nico33";
        String lognewuser = userService.addUser(username, "admin", "peretti", "nico");
        assertTrue(userRepository.exists(username));
        String loglogin = userService.login(username, "admin");
        assertTrue(userRepository.findOne(username).getlogin());
        loglogin = userService.logout(username);
        assertFalse(userRepository.findOne(username).getlogin());
    }

//--------------------Test for Product Services---------------------------------
    @Test
    public void testAddProduct() {
        List<String> listname = Arrays.asList("Samsung", "Noblex", "Motorola");
        List<String> listcategory = Arrays.asList("Computer", "TV", "Smartphone");
        long id = 0;
        String name = "";
        String asd = "";
        for (int i = 0; i < listname.size(); i++) {
            name = listname.get(i);
            for (int j = 0; j < listcategory.size(); j++) {
                asd = productService.addProduct(id, name, listcategory.get(j), 1);
                id++;
            }
        }
        assertEquals(productService.showProduct().size(), 9);
        assertEquals(productService.findProductByName("Samsung").size(),3);
        assertEquals(productService.findProductByCategory("TV").size(),3);
    }

//--------------------Test for Cart Services------------------------------------

    @Test
    public void testCreateAndDeleteCart() {
        String username = "nico33";
        String lognewuser = userService.addUser(username, "admin", "peretti", "nico");
        String loglogin = userService.login(username, "admin");
        assertTrue(userRepository.exists(username));
        assertTrue(userRepository.findOne(username).getlogin());

        String lognewcart = cartService.createCart(username);
        assertTrue(cartRepository.exists(username));
        lognewcart = cartService.deleteCart(username);
        assertFalse(cartRepository.exists(username));
    }

    @Test
    public void testAddAndRemoveProductFromCart() {
        String username = "nico33";
        String lognewuser = userService.addUser(username, "admin", "peretti", "nico");
        String loglogin = userService.login(username, "admin");
        assertTrue(userRepository.exists(username));
        assertTrue(userRepository.findOne(username).getlogin());

        String lognewcart = cartService.createCart(username);
        Product product = new Product(1, "Samsung", "TV", 1000);
        lognewcart = cartService.addProductToCart(username, product);
        Cart cart = cartService.showCart(username);
        assertEquals(1, cart.getProductList().size());
        lognewcart = cartService.removeProductFromCart(username, product);
        cart = cartService.showCart(username);
        assertEquals(0, cart.getProductList().size());
    }

//----------------Integration from entiry application-----------------------
    @Test
    public void testAppIntegration() {
        // add product
        String asd = productService.addProduct(1, "Samsung", "TV", 1000);
        asd = productService.addProduct(2, "Noblex", "TV", 1000);
        asd = productService.addProduct(3, "Motorola", "Smartphone", 1000);
        Product product1 = productService.findOne(1);
        Product product2 = productService.findOne(2);
        Product product3 = productService.findOne(3);
        // create a user
        String username = "nico";
        String lognewuser = userService.addUser(username, "admin", "peretti", "nico");
        assertTrue(userRepository.exists(username));
        // login user
        String loglogin = userService.login(username, "admin");
        assertTrue(userRepository.findOne(username).getlogin());
        // create cart
        String lognewcart = cartService.createCart(username);
        assertTrue(cartRepository.exists(username));
        // Add product to cart
        asd = cartService.addProductToCart(username, product1);
        asd = cartService.addProductToCart(username, product2);
        asd = cartService.addProductToCart(username, product3);
        assertEquals(3, cartService.showCart(username).getProductList().size());
        // remove one product
        asd = cartService.removeProductFromCart(username, product3);
        assertEquals(2, cartService.showCart(username).getProductList().size());
        // buy product
        asd = cartService.buyProductFromCart(username);
        System.out.println(asd);
        assertFalse(cartRepository.exists(username));
        // logout user
        loglogin = userService.logout(username);
        assertFalse(userRepository.findOne(username).getlogin());
        //delete user
        lognewuser = userService.deleteUser(username);
        assertFalse(userRepository.exists(username));
    }
}
