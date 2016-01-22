package TDD.ShoppingCartTDD;

public class SmartPhone extends Product {

	private double price;
	private String description;
	private double offer;
	
	public SmartPhone(float price, String desc, double offer) {
		this.price = price;
		description = desc;
		this.offer = offer;
	}
	@Override
	public double getprice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getdescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean inoffer() {
		// TODO Auto-generated method stub
		return false;
	}

}
