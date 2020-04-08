package calculator;

public class Main {

	public static void main(String[] args) {
		
		if(args.length > 0) {
			
			String path = args[0];
			Calculator calculator = new Calculator();
			double result = calculator.calculate(path);
			System.out.println(result);
			
		}
		else {
			
			System.out.println("Data file path missing.");
			
		}
	}

}
