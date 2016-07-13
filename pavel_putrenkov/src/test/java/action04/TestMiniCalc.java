//package action04;
//
//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
//
//public class TestMiniCalc {
//	private MiniCalc obj;
//	
//	@Before
//	public void init(){
//		obj = new MiniCalc();
//	}
//	
//	@Test
//	public void test1() {
//		int a = 10;
//		int b = 20;
//		int aWait = 200;
//		int res = obj.multiply(a, b);
//		
//		if(res != aWait)
//			fail("Not yet implemented");
//	}
//	
//	@Test
//	public void test2() {
//		int a = 0;
//		int b = (int)(100*Math.random());
//		int aWait = a * b;
//		int res = obj.multiply(a, b);
//		
//		if(res != aWait)
//			fail("Not yet implemented");
//	}
//	
//	@Test
//	public void test3() {
//		int a = (int)(100*Math.random());
//		int b = (int)(100*Math.random());
//		Integer aWait = a * b;
//		Integer res = obj.multiply(a, b);
//		
//		if(res != aWait)
//			assertArrayEquals(a+" * " + b,new Object[]{aWait}, new Object[]{res});
//	}
//}
