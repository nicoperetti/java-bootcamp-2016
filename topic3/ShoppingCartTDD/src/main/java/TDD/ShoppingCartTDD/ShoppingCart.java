package TDD.ShoppingCartTDD;

import java.util.*;

public interface ShoppingCart {
    
	public void addproduct(Product product);
	
	public void removeproduct(Product product);
	
	public float getsubtotal();
	
	public List<Product> getproductlist();
}
