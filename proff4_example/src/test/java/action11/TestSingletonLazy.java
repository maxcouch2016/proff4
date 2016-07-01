package action11;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSingletonLazy {
	@Test
	public void test1(){
		SingletonLazy obj1 = SingletonLazy.getInstance();
		SingletonLazy obj2 = SingletonLazy.getInstance();
		//assertEquals(obj1, obj2);
		assertTrue(obj1 == obj2);
	}
}
