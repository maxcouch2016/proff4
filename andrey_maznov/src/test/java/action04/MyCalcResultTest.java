package action04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyCalcResultTest {

	private MyCalc calc;
	private char[] expression;
	private int a;
	private int b;
	
	
	@Before
	public void init() {
		calc = new MyCalc();
		a = (int) (Math.random() * 1000);
		b = (int) (Math.random() * 1000);
	}
	
	@Test
	public void testResultPlus() {
		int expectedResult = a + b;
		expression = (Integer.toString(a) + "+" + Integer.toString(b) + "=").toCharArray();
		for (char c : expression) {
			calc.inChar(c);
		}
		if (!Integer.toString(expectedResult).equals(calc.getResult())) {
			fail("Result: " + calc.getResult() + " Expected: " + Integer.toString(expectedResult));
		}
	}
	
	@Test
	public void testResultMinus() {
		int expectedResult = a - b;
		expression = (Integer.toString(a) + "-" + Integer.toString(b) + "=").toCharArray();
		for (char c : expression) {
			calc.inChar(c);
		}
		if (!Integer.toString(expectedResult).equals(calc.getResult())) {
			fail("Result: " + calc.getResult() + " Expected: " + Integer.toString(expectedResult));
		}
	}
	
	@Test
	public void testResultMultiply() {
		int expectedResult = a * b;
		expression = (Integer.toString(a) + "*" + Integer.toString(b) + "=").toCharArray();
		for (char c : expression) {
			calc.inChar(c);
		}
		if (!Integer.toString(expectedResult).equals(calc.getResult())) {
			fail("Result: " + calc.getResult() + " Expected: " + Integer.toString(expectedResult));
		}
	}
	
	@Test
	public void testResultDevide() {
		int expectedResult = a / b;
		expression = (Integer.toString(a) + "/" + Integer.toString(b) + "=").toCharArray();
		for (char c : expression) {
			calc.inChar(c);
		}
		if (!Integer.toString(expectedResult).equals(calc.getResult())) {
			fail("Result: " + calc.getResult() + " Expected: " + Integer.toString(expectedResult));
		}
	}
	
	@Test
	public void testResultDevideByZero() {
		String expectedResult = Calcable.ByZero;
		expression = (Integer.toString(a) + "/" + 0 + "=").toCharArray();
		for (char c : expression) {
			calc.inChar(c);
		}
		if (!expectedResult.equals(calc.getResult())) {
			fail("Result: " + calc.getResult() + " Expected: " + expectedResult);
		}
	}

	@Test
	public void testResultWrongSymbols() {
		int expectedResult = a / b;
		expression = ("000000000000000" + Integer.toString(a) + "sdlkgjklsdjlg" + "sd/aasdfasdfacasdf0000000000a" + Integer.toString(b) + "sdfgdsg=").toCharArray();
		for (char c : expression) {
			calc.inChar(c);
		}
		if (!Integer.toString(expectedResult).equals(calc.getResult())) {
			fail("Result: " + calc.getResult() + " Expected: " + Integer.toString(expectedResult));
		}
	}
	
	@Test
	public void testResult() {
		
		int expectedResult = 0;
		
		char[] operations = {'+', '-', '/', '*'};
		
		for (int i = 0; i < 10; i++) {

			char operation = operations[(int) (Math.random() * 3)];

			if (operation == '+') {
				expectedResult = a + b;
			} else if (operation == '-') {
				expectedResult = a - b;
			} else if (operation == '*') {
				expectedResult = a * b;
			} else if (operation == '/') {
				expectedResult = a / b;
			}
			expression = (Integer.toString(a) + Character.toString(operation) + Integer.toString(b) + "=")
					.toCharArray();
			for (char c : expression) {
				calc.inChar(c);
			}
			if (!Integer.toString(expectedResult).equals(calc.getResult())) {
				fail("Result: " + calc.getResult() + " Expected: " + Integer.toString(expectedResult));
			}
			
		}
	}
	
	
	
}
