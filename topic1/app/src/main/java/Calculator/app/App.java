package Calculator.app;

/**
 * Hello world!
 *
 */
public class App {
	
	public int sum(int a, int b) {
		return a + b;
	}
	
	public int sub(int a, int b) {
		return a - b;
	} 
	
	public int mult(int a, int b) {
		return a * b;
	}
	
	public int div(int a, int b) throws Exception {
		if (b == 0) {
			throw new Exception("Divider cannot be zero"); 
		}
		return a / b;
	}
	
	public boolean equals(int a, int b) {
		boolean result = false;
		if (a == b) {
			result = true;
		}
		return result;
	}
}
