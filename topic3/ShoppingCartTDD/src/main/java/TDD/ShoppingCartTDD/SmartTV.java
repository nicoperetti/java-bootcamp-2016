package TDD.ShoppingCartTDD;

public class SmartTV extends Product{

	private double price;
	private String description;
	private double offer;
	
	public SmartTV(float price, String desc, double offer) {
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
		return null;
	}
	
	@Override
	public boolean inoffer() {
		boolean result = false;
		if (offer != 0) {
			result = true;
		}
		return result;
	}
}
