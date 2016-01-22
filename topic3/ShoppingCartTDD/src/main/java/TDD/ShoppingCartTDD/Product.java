package TDD.ShoppingCartTDD;

public abstract class Product {
	private int warranty = 12;
	private String state = "new";
	
	public abstract double getprice();
	
	public abstract String getdescription();
		
	public abstract boolean inoffer();
	
	public int warranty() {
		return warranty;
	}
	
	public String state() {
		return state;
	}
	
	public abstract String toString();
}
