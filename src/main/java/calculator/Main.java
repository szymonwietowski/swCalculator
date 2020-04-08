package calculator;

import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		
		Optional<String> path = Optional.of(args[0]);
		
		if(path.isPresent()) {
			
			Calculator calculator = new Calculator();
			double result = calculator.calculate(path.get());
			System.out.println(result);
			
		}
		else {
			
			System.out.println("Data file path missing.");
			
		}
	}

}
