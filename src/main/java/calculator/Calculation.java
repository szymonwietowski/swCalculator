package calculator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class Calculation {

	private double variable;
	private List<String[]> operations;
	
	public Calculation(double startVar) {
		this.variable = startVar;
		this.operations = new LinkedList<String[]>();
	}
	
	public double getResult() {
		return this.variable;
	}
	
	public void processOperation(String operationDesc) {
		
		String[] operationData = operationDesc.split(" ");
		
		if(operationData[0].equals("apply"))
			doOperation(operationData);
		else
			operations.add(operationData);
	}
	
	private void doOperation(String[] operationData) {
		try {
			Method operation = getClass().getMethod(operationData[0], double.class);
			double variable = Double.parseDouble(operationData[1]);
		
			operation.invoke(this, variable);
			
		} catch (NoSuchMethodException | SecurityException | 
				 IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			System.out.println("ERROR: Mathematical operation: '" + 
								operationData[0] + " " + operationData[1] + "' not supported.");
			System.out.println("ERROR MESSAGE: " + e.getMessage());
		}
	}
	
	public void add(double variable) {
		this.variable += variable;
	}
	
	public void subtract(double variable) {
		this.variable -= variable;
	}
	
	public void multiply(double variable) {
		this.variable *= variable;
	}
	
	public void divide(double variable) {
		this.variable /= variable;
	}
	
	public void apply(double variable) {
		this.variable = variable;
		this.operations.forEach(this::doOperation);
	}
}
