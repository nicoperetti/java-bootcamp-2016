
public class AbstractFactory {
	public ConnectionFactory getConnectionFactory(String type) {
		if ("Connection".equals(type)) {
			return new ConnectionFactory(); 
		}
		else {
			return null;
		}
	}
}
