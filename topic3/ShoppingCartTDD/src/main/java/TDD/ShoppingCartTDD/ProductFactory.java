package TDD.ShoppingCartTDD;

public class ProductFactory {

	public Product getProduct(String type, float price, String desc, double offer) {
		Product p;
		if (type.equals("SmartTV")) {
			p = new SmartTV(price, desc, offer);
		}
		else if (type.equals("Notebook")) {
			p = new Notebook(price, desc, offer);
		}
		else {
			p = new SmartPhone(price, desc, offer);
		}
		return p;
		
	}
}
