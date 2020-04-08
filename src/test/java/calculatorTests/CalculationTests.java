package calculatorTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import calculator.Calculation;

/**
 * @author Szymon Wietowski
 *
 * Calculation class unit tests.
 */
public class CalculationTests {

	private Calculation calc;
	
	@Test
	public void testAdd() {
		
		givenACalculationWithVariable(20.0).
		whenAddVariable(10.0).
		thenResultIs(30.0).
		whenAddVariable(5.0).
		thenResultIs(35.0);
	}
	
	@Test
	public void testSubtract() {
		
		givenACalculationWithVariable(20.0).
		whenSubtractVariable(10.0).
		thenResultIs(10.0).
		whenSubtractVariable(5.0).
		thenResultIs(5.0);
	}
	
	@Test
	public void testMultiply() {
		
		givenACalculationWithVariable(20.0).
		whenMultiplyVariable(10.0).
		thenResultIs(200.0).
		whenMultiplyVariable(5.0).
		thenResultIs(1000.0);
	}
	
	@Test
	public void testDivide() {
		
		givenACalculationWithVariable(20.0).
		whenDivideVariable(10.0).
		thenResultIs(2.0).
		whenDivideVariable(5.0).
		thenResultIs(0.4);
	}
	
	@Test 
	public void testAddSubtractMultiplyAndDivide() {
		
		givenACalculationWithVariable(20.0).
		whenAddVariable(5.0).
		whenSubtractVariable(10.0).
		whenMultiplyVariable(2.0).
		whenDivideVariable(3.0).
		thenResultIs(10.0);
	}
	
	@Test 
	public void testApply() {
		
		givenACalculationWithVariable(0.0).
		whenApplyVariable(20.0).
		thenResultIs(20.0);
	}
	
	@Test
	public void testProcessOperationAddSubtractAndApply() {
		
		givenACalculationWithVariable(0.0).
		whenProcessOperation("add 10").
		whenProcessOperation("subtract 5").
		whenProcessOperation("apply 20").
		thenResultIs(25.0);
	}
	
	@Test
	public void testProcessOperationMultiplyDivideAndApply() {
		
		givenACalculationWithVariable(0.0).
		whenProcessOperation("multiply 10").
		whenProcessOperation("divide 5").
		whenProcessOperation("apply 20").
		thenResultIs(40.0);
	}
	
	@Test
	public void testProcessOperationAddSubtractMultiplyDivideAndApply() {
		
		givenACalculationWithVariable(0.0).
		whenProcessOperation("add 10").
		whenProcessOperation("subtract 5").
		whenProcessOperation("multiply 10").
		whenProcessOperation("divide 5").
		whenProcessOperation("apply 20").
		thenResultIs(50.0);
	}
	
	private CalculationTests givenACalculationWithVariable(double var) {
		
		calc = new Calculation(var);
		
		return this;
	}
	
	private CalculationTests whenAddVariable(double var) {
		
		calc.add(var);
		
		return this;
	}
	
	private CalculationTests whenSubtractVariable(double var) {
		
		calc.subtract(var);
		
		return this;
	}
	
	private CalculationTests whenMultiplyVariable(double var) {
		
		calc.multiply(var);
		
		return this;
	}
	
	private CalculationTests whenDivideVariable(double var) {
		
		calc.divide(var);
		
		return this;
	}
	
	private CalculationTests whenApplyVariable(double var) {
		
		calc.apply(var);
		
		return this;
	}
	
	private CalculationTests whenProcessOperation(String operation) {
		
		calc.processOperation(operation);
		
		return this;
	}
	
	private CalculationTests thenResultIs(double var) {
		
		assertEquals(var, calc.getResult(), 0);
		
		return this;
	}
}
