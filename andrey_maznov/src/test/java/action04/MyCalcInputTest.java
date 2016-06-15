package action04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyCalcInputTest {
	
	private MyCalc calc;
	private char[] expression;
	
	@Before
	public void init() {
		calc = new MyCalc();
	}
	
	@Test
	public void test1FirstNumberInput() {
		int expectedResult = (int) (Math.random() * 1000);
		expression = Integer.toString(expectedResult).toCharArray();
		for (char c : expression) {
			calc.inChar(c);
		}
		if (!Integer.toString(expectedResult).equals(calc.getResult())) {
			fail("Result: " + calc.getResult() + " Expected: " + Integer.toString(expectedResult));
		}
	}
	
	@Test
	public void test2FirstNumberInput() {
		int expectedResult = (int) (Math.random() * 1000);
		expression = ("0000000000000" + Integer.toString(expectedResult)).toCharArray();
		for (char c : expression) {
			calc.inChar(c);
		}
		if (!Integer.toString(expectedResult).equals(calc.getResult())) {
			fail("Result: " + calc.getResult() + " Expected: " + Integer.toString(expectedResult));
		}
	}
	
	@Test
	public void test3FirstNumberInput() {
		String expectedResult = "9032834";
		expression = "0sj0d9032klsjg8j34gklsguso".toCharArray();
		for (char c : expression) {
			calc.inChar(c);
		}
		if (!expectedResult.equals(calc.getResult())) {
			fail("Result: " + calc.getResult() + " Expected: " + expectedResult);
		}
	}
	
	@Test
	public void test4FirstNumberInput() {
		String expectedResult = "9032834";
		expression = "0sj0d9   0 32klsj     g8j34gklsguso".toCharArray();
		for (char c : expression) {
			calc.inChar(c);
		}
		if (!expectedResult.equals(calc.getResult())) {
			fail("Result: " + calc.getResult() + " Expected: " + expectedResult);
		}
	}
	
	@Test
	public void test1SecondNumberInput() {
		int expectedResult = (int) (Math.random() * 1000);
		expression = (Integer.toString((int) (Math.random() * 1000)) + "/" + Integer.toString(expectedResult)).toCharArray();
		for (char c : expression) {
			calc.inChar(c);
		}
		if (expectedResult != calc.getTemp()) {
			fail("Result: " + calc.getTemp() + " Expected: " + Integer.toString(expectedResult));
		}
	}
	
	@Test
	public void test2SecondNumberInput() {
		
		int expectedResult = (int) (Math.random() * 1000);
		expression = (Integer.toString((int) (Math.random() * 1000)) + "/" + ("0000000000000" + Integer.toString(expectedResult))).toCharArray();
		for (char c : expression) {
			calc.inChar(c);
		}
		if (expectedResult != calc.getTemp()) {
			fail("Result: " + calc.getTemp() + " Expected: " + Integer.toString(expectedResult));
		}
	}
	
	@Test
	public void test3SecondNumberInput() {
		int expectedResult = 9032834;
		expression = (Integer.toString((int) (Math.random() * 1000)) + "/" + "0sj0d9032klsjg8j34gklsguso").toCharArray();
		for (char c : expression) {
			calc.inChar(c);
		}
		if (expectedResult != calc.getTemp()) {
			fail("Result: " + calc.getTemp() + " Expected: " + Integer.toString(expectedResult));
		}
	}
	
	@Test
	public void test4SecondNumberInput() {
		int expectedResult = 9032834;
		expression = (Integer.toString((int) (Math.random() * 1000)) + "/" + "       0 sj0d90         32klsjg8j34gklsguso").toCharArray();
		for (char c : expression) {
			calc.inChar(c);
		}
		if (expectedResult != calc.getTemp()) {
			fail("Result: " + calc.getTemp() + " Expected: " + Integer.toString(expectedResult));
		}
	}
	
	@Test
	public void test1OperationInput() {
		char expectedResult = '-';
		expression = (Integer.toString((int) (Math.random() * 1000)) + Character.toString(expectedResult) + Integer.toString((int) (Math.random() * 1000))).toCharArray();
		for (char c : expression) {
			calc.inChar(c);
		}
		if (expectedResult != calc.getOperation()) {
			fail("Result: " + calc.getOperation() + " Expected: " + expectedResult);
		}
	}
	
	@Test
	public void test2OperationInput() {
		char expectedResult = '+';
		expression = (Integer.toString((int) (Math.random() * 1000)) + Character.toString(expectedResult) + Integer.toString((int) (Math.random() * 1000))).toCharArray();
		for (char c : expression) {
			calc.inChar(c);
		}
		if (expectedResult != calc.getOperation()) {
			fail("Result: " + calc.getOperation() + " Expected: " + expectedResult);
		}
	}
	
	@Test
	public void test3OperationInput() {
		char expectedResult = '*';
		expression = (Integer.toString((int) (Math.random() * 1000)) + Character.toString(expectedResult) + Integer.toString((int) (Math.random() * 1000))).toCharArray();
		for (char c : expression) {
			calc.inChar(c);
		}
		if (expectedResult != calc.getOperation()) {
			fail("Result: " + calc.getOperation() + " Expected: " + expectedResult);
		}
	}
	
	@Test
	public void test4OperationInput() {
		char expectedResult = '/';
		expression = (Integer.toString((int) (Math.random() * 1000)) + Character.toString(expectedResult) + Integer.toString((int) (Math.random() * 1000))).toCharArray();
		for (char c : expression) {
			calc.inChar(c);
		}
		if (expectedResult != calc.getOperation()) {
			fail("Result: " + calc.getOperation() + " Expected: " + expectedResult);
		}
	}
	
	@Test
	public void test5OperationInput() {
		char expectedResult = '0';
		expression = (Integer.toString((int) (Math.random() * 1000)) + "%     3^    &8" + Integer.toString((int) (Math.random() * 1000))).toCharArray();
		for (char c : expression) {
			calc.inChar(c);
		}
		if (expectedResult != calc.getOperation()) {
			fail("Result: " + calc.getOperation() + " Expected: " + expectedResult);
		}
	}
	
	@Test
	public void test6OperationInput() {
		char expectedResult = '+';
		expression = (Integer.toString((int) (Math.random() * 1000)) + "%3& 8           +" + Integer.toString((int) (Math.random() * 1000))).toCharArray();
		for (char c : expression) {
			calc.inChar(c);
		}
		if (expectedResult != calc.getOperation()) {
			fail("Result: " + calc.getOperation() + " Expected: " + expectedResult);
		}
	}
	
	@Test
	public void test7OperationInput() {
		char expectedResult = '/';
		expression = (Integer.toString((int) (Math.random() * 1000)) + "          " + Character.toString(expectedResult) + Integer.toString((int) (Math.random() * 1000))).toCharArray();
		for (char c : expression) {
			calc.inChar(c);
		}
		if (expectedResult != calc.getOperation()) {
			fail("Result: " + calc.getOperation() + " Expected: " + expectedResult);
		}
	}
	
}
