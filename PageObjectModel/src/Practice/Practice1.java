package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

public class Practice1 {

int Reversenumber =0;
String ReverseString="";
	
	@Test
	public void practicing()
	{/*
		System.out.println(RecursiveReverse(1234));
		System.out.println("______________________________");
		System.out.println(strRecursiveStringReverse("Happy new Year"));
		printStarsPattern1();
		printStarsPatten2();
		printStarsPattern3();*/
		RemoveDuplicates("srinivaspoduri");
		printinChange(1234);
		ArraytoArrayList();
		System.out.println(palendromeCheck("bodcob"));
	}
	public int RecursiveReverse(int Number)
	{
		if(Number<=9)
		{
			Reversenumber = Reversenumber*10+Number;
		}
		else
		{
			Reversenumber= Reversenumber*10+Number%10;
			RecursiveReverse(Number/10);
		}
		return Reversenumber;
	}
	
	public String strRecursiveStringReverse(String str)
	{
		if(str.length()==1)
		{
			ReverseString= ReverseString+str;
		}
		else
		{
			ReverseString = ReverseString+str.substring(str.length()-1, str.length());
			strRecursiveStringReverse(str.substring(0,str.length()-1));
		}
		return ReverseString;
	}
	
	public void printStarsPattern1()
	{
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(j);
			}
			System.out.println();
		}
	}
	
	public void printStarsPatten2()
	{
		for(int i=1;i<=5;i++)
		{
			for(int j=5;j>=i;j--)
			{
				System.out.print(j);
			}
			System.out.println();
		}
	}
public void printStarsPattern3()
{
	for(int i=1;i<=5;i++)
	{
		for(int j=5;j>=i;j--)
		{
			System.out.print(" ");
		}
		for(int k=i;k>=1;k--)
		{
			System.out.print(k);
		}
		System.out.println();
	}
}

public String RemoveDuplicates(String str)
{
	String strNewstring = "";
	for(int i=0;i<str.length();i++)
	{
		String x = str.substring(i, i+1);
		strNewstring = strNewstring+x;
		str= str.replace(x, "");
		i=0;
	}
	return strNewstring;
}

public void printinChange(int Number)
{
	int Tens=1;
	int value =0;
	String n="";
	while(Number>0)
	{
		n= String.valueOf(Number);
		for(int i=1;i<n.length();i++)
		{
			Tens= Tens*10;
		}
		System.out.print(Number/Tens*Tens);
		Number=Number%Tens;
		if(n.length()!=1)
		{
			System.out.println("+");
			Tens=1;
		}
	}
}

 public void ArraytoArrayList()
 {
	  String citynames[]={"Agra", "Mysore", "Chandigarh", "Bhopal","Agra", "Mysore", "Chandigarh", "Bhopal"};
	  ArrayList<String> citylist= new ArrayList<String>(Arrays.asList(citynames));
	  Set<String>objSet = new HashSet<String>(citylist);
	  String[] str = new String[objSet.size()-1];
	  str= objSet.toArray(str);
	  System.out.println(str);
 }
 
 public boolean palendromeCheck(String strx)
 {
	 boolean blnStatus =false;
	 for(int i=0;i<strx.length()/2;i++)
	 {
		 if(strx.substring(i, i+1).equalsIgnoreCase(strx.substring(strx.length()-(1+i), strx.length()-i)))
		 {
			 blnStatus = true;
		 }
		 else
		 {
			 blnStatus = false;
		 }
	 }
	 return blnStatus;
 }

}
