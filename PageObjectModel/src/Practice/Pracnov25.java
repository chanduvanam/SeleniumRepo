package Practice;

import org.testng.annotations.Test;

public class Pracnov25 {
	
	public  enum fruits
	{
		 Banana,Graphs,Orange;
	}
	@Test
	public void sampleTest()
	{
		testfruits(fruits.Banana);
	}
	
	public void testfruits(fruits f)
	{
	switch (f) {
	case Banana:
		System.out.println("banana");
		break;

	default:
		System.out.println("Default is Apple");
		break;
	}
	}
}
