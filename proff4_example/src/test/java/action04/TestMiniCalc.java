package action04;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestMiniCalc {

	@Test
	public void test1() {
		MiniCalc obj = new MiniCalc();
		int a = 10;
		int b = 20;
		int aWait = 200;
		int res = obj.multiply(a, b);
		
		if(res != aWait)
			fail("Not yet implemented");
	}
	@Test
	public void test2() {
		MiniCalc obj = new MiniCalc();
		int a = 0;
		int b = (int)(100*Math.random());
		int aWait = a * b;
		int res = obj.multiply(a, b);
		
		if(res != aWait)
			fail("Not yet implemented");
	}
	@Test
	public void test3() {
		MiniCalc obj = new MiniCalc();
		int a = (int)(100*Math.random());
		int b = (int)(100*Math.random());
		Integer aWait = a * b;
		Integer res = obj.multiply(a, b);
		
		if(res != aWait)
			assertArrayEquals(a+" * " + b,new Object[]{aWait}, new Object[]{res});
	}
}
