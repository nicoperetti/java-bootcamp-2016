package TDD.ShoppingCartTDD;

import java.util.*;

public interface ShoppingCart {
    
	public void addproduct(Product product);
	
	public void removeproduct(Product product);
	
	public double getsubtotal();
	
	public List<Product> getproductlist();
	
	public int getquantity();
}
