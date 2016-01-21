package TDD.ShoppingCartTDD;

import java.util.*;

public class ShoppingCartI implements ShoppingCart{

	private double subtotal;
	private List<Product> productlist;
	
	public ShoppingCartI() {
		subtotal = 0;
		productlist = new ArrayList<Product>();
	}
	
	@Override
	public void addproduct(Product product) {
		productlist.add(product);
		subtotal += product.getprice();
	}

	@Override
	public void removeproduct(Product product) {
		
	}

	@Override
	public double getsubtotal() {
		return subtotal;
	}

	@Override
	public List<Product> getproductlist() {
		return null;
	}

	@Override
	public int getquantity() {
		return productlist.size();
	}

}
