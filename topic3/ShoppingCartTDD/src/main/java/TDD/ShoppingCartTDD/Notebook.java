package TDD.ShoppingCartTDD;

public class Notebook extends Product {

	private double price;
	private String description;
	private double offer;
	
	public Notebook(float price, String desc, double offer) {
		this.price = price;
		description = desc;
		this.offer = offer;
	}
	
	@Override
	public double getprice() {
		double result = price;
		if (this.inoffer()) {
			result -= (price * offer);
		}
		return result;
	}

	@Override
	public String getdescription() {
		return description;
	}
	
	@Override
	public boolean inoffer() {
		boolean result = false;
		if (offer != 0) {
			result = true;
		}
		return result;
	}
	
	@Override
	public String toString() {
		double off = offer * 100;
		return "Notebook: " + description + ". Price: $" + price + " "+ off +"% off";
	}
}
