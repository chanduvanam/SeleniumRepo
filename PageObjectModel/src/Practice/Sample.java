package Practice;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class Sample {


	public void test()
	
	{
		String str ="a1b2c3d4e5f6";
		
		List<String> val = new ArrayList<String>();
		
		for(int i=0;i<str.length()-1;i=i+2)
		{
			System.out.println(str.substring(0)+ str.length());
			String out = str.substring(i, i+1);
			val.add(out);
		}
		System.out.println(val);
	}

}
