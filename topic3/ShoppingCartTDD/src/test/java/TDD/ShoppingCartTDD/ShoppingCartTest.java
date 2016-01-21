package TDD.ShoppingCartTDD;

import static org.junit.Assert.*;

import org.junit.Test;

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
		Product product = new SmartTV(3000, "Samsung TV 32´", 0.2);
		shoppingcart.addproduct(product);
		assertEquals(1, shoppingcart.getquantity());
	}
}
