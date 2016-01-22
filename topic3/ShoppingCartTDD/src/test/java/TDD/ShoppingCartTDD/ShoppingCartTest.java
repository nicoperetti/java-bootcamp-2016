package TDD.ShoppingCartTDD;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class ShoppingCartTest {
	
	@Test
	public void testShoppingCartEmpty() {
		ShoppingCart shoppingcart = new ShoppingCartI();
		assertEquals(0, shoppingcart.getquantity());
	}

	@Test
	public void testShoppingCartSubtotalInit() {
		ShoppingCart shoppingcart = new ShoppingCartI();
		assertEquals(0, shoppingcart.getsubtotal(), 0.001);
	}
	
	@Test
	public void testShoppingCartAdd1Product() {
		ShoppingCart shoppingcart = new ShoppingCartI();
		ProductFactory pfactory = new ProductFactory();
		Product product = pfactory.getProduct("SmarTV", 3000, "Samsung TV 32´", 0.2);
		shoppingcart.addproduct(product);
		assertEquals(1, shoppingcart.getquantity());
	}
	
	@Test
	public void testShoppingCartRemove1Product() {
		ShoppingCart shoppingcart = new ShoppingCartI();
		ProductFactory pfactory = new ProductFactory();
		Product product = pfactory.getProduct("SmarTV", 3000, "Samsung TV 32´", 0.2);
		shoppingcart.addproduct(product);
		assertEquals(1, shoppingcart.getquantity());
		shoppingcart.removeproduct(product);
		assertEquals(0, shoppingcart.getquantity());
		assertEquals(0, shoppingcart.getsubtotal(), 0.001);
	}
	
	@Test
	public void testShoppingCartGetProductList() {
		ShoppingCart shoppingcart = new ShoppingCartI();
		ProductFactory pfactory = new ProductFactory();
		Product product;
		int i;
		List<Product> plist;
		for(i = 0; i < 10; i++) {
			product = pfactory.getProduct("SmartTV", 3000, "Samsung TV 32´", 0.2);
			shoppingcart.addproduct(product);
		}
		assertEquals(10, shoppingcart.getquantity());
		assertEquals(3000 * 0.8 * 10, shoppingcart.getsubtotal(), 0.001);
		plist = shoppingcart.getproductlist();
		for (i = 0; i < plist.size(); i++) {
			product = plist.get(i);
			System.out.println(product.toString());
		}
	}
}
