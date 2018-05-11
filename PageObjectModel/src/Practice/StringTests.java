package Practice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import org.testng.annotations.Test;

public class StringTests {

	@Test
	public void test()
	{
		int[] ar = {12,4,51,3,7};
		SortNumericArray(ar);
		//String re = stringReverse("srinivas");
		//int rev = intReverseNumber(12345);
		//int[] ar = {12,4,51,3,7};
		//int[] a = sortWithoneloop(ar);
		//String s = ReplaceCharctersinString("srinivas",'*');
		//String s = sortString("tester");
		//String s1 =separateVowelsAndConsonents("testingtools");
		//String s1 =strReplaceWordInSentence("I Love Hyderabad","Hyderabad","Cyberabad");
		//	int a = FindNumberOfOccurencsinString("apple",'p');
		//String s = RemoveDuplicateCharacters("SRINIVAS");
		//WorkkignWithDates("CDATE_TODAY");
		//swapping(20,30);
		/*Map<String,String> o = new HashMap<String,String>();
		o.put("key1", "Value1");
		o.put("key6", "Value6");
		o.put("key2", "Value2");

		o.put("key3", "Value3");o.put("key4", "Value4");

		o.put("key5", "Value5");
		ConvertMapToArraylist(o);*/

		List<String> objlist = new ArrayList<String>();
		objlist.add("one");
		objlist.add("two");
		objlist.add("one");
		objlist.add("two");
		objlist.add("one");
		objlist.add("two");
		Set<String> objSet  = convertListToSet(objlist);
	}
	//string reverse without using default methods
	public String stringReverse(String str)
	{
		boolean blnStatus = false;
		String strReverse="";
		String[] sp = str.split("i");
		char[] ch=str.toCharArray();
		for(int i= ch.length-1;i>=0;i--)
		{
			strReverse = strReverse+ch[i];
		}
		System.out.println("Original :-" +str +"Reverse :-" +strReverse);
		return strReverse;
	}
	//Reverse of the number 
	public int intReverseNumber(int number)
	{
		int ReverseNumber =0;
		int Reminder =0;
		while(number >= 1)
		{ 
			Reminder = number%10;
			ReverseNumber = (ReverseNumber *10)+Reminder;
			number = number/10;
		}
		return ReverseNumber;
	}
	//sorting of numeric array
	public int[] SortNumericArray(int[] numArray)
	{
		int Temp =0;
		for(int i=0;i<=numArray.length-1;i++)
		{
			for(int j=i+1;j<=numArray.length-1;j++)
				if(numArray[i]> numArray[j])
				{
					Temp=numArray[i];
					numArray[i]= numArray[j];
					numArray[j]= Temp;
				}

		}


		return numArray;
	}
	//Sorting string
	public String sortString(String str)
	{
		char[] c = str.toLowerCase().toCharArray();
		char Temp;
		String newString="";
		for(int i=0;i<c.length-1;i++)
		{
			for(int j=i+1;j<=c.length-1;j++)
			{
				if(Integer.valueOf(c[i]) > Integer.valueOf(c[j]))
				{
					Temp =c[i];
					c[i]= c[j];
					c[j]=Temp;
				}
			}
		}
		for(int i=0;i<=c.length-1;i++)
		{
			newString= newString+String.valueOf(c[i]);
		}
		return newString;
	}
	//Replacing character in a string	
	public String ReplaceCharctersinString(String str,char ReplceChar)
	{
		String strReplacemethod = str.replace('i', '*');
		String newString="";
		char[] ch = str.toCharArray();
		for(int i=0;i<=ch.length-1;i++)
		{
			if(ch[i]=='i')
			{
				ch[i]=ReplceChar;
			}
		}
		for(int j=0;j<=ch.length-1;j++)
		{
			newString=newString+String.valueOf(ch[j]);
		}
		return newString;
	}

	//Separating vowels and consonents in string
	public String separateVowelsAndConsonents(String str)
	{
		char[] ch = str.toLowerCase().toCharArray();
		String strVowel ="";
		String strConsonent ="";

		for(int i=0;i<=ch.length-1;i++)
		{
			if(ch[i]== 'a'|| ch[i]=='e'||ch[i]== 'i'|| ch[i]=='o' || ch[i]=='u')
			{
				strVowel = strVowel+String.valueOf(ch[i]);
			}
			else
			{
				strConsonent=strConsonent+String.valueOf(ch[i]);
			}
		}
		return strVowel+strConsonent;

	}
	//Replacing word in String
	public String strReplaceWordInSentence(String Sentence,String Mainword,String ReplaceWord)
	{
		String[] splitSentence = Sentence.split(" ");
		String StrReturn="";
		for(int i=0;i<=splitSentence.length-1;i++)
		{
			if(splitSentence[i].equalsIgnoreCase(Mainword))
			{
				splitSentence[i]= ReplaceWord;
			}
		}
		for(int i=0;i<=splitSentence.length-1;i++)
		{
			StrReturn=StrReturn+" "+splitSentence[i];
		}
		return StrReturn;
	}
	//find the number of occurrences
	public int FindNumberOfOccurencsinString(String str,char ch)
	{
		int count =0;
		char[] c = str.toCharArray();

		for(int i=0;i<=c.length-1;i++)
		{
			if(c[i]==ch)
			{
				count++;
			}
		}
		return count;
	}

	//Removing characters that repeting more than once

	public String RemoveDuplicateCharacters(String str)
	{
		char[] ch = str.toCharArray();
		String updated="";
		int count =0;
		for(int i =0;i<=ch.length-1;i++)
		{
			for(int j=i+1;j<=ch.length-1;j++)
			{
				if(ch[i]==ch[j])
				{
					count =count+1;
					//break; //break to avoid to go to next if
				}
				if(count==2)
				{
					ch[j]='*';
				}
			}
			if(count>0)
			{
				ch[i]='*';

			}
			count=0;

		}

		for(int k=0;k<=ch.length-1;k++)
		{
			updated=updated+String.valueOf(ch[k]);
		}

		return updated;
	}

	public String WorkingWithDates(String strValue)
	{

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy"); //have to set the format in which date have to displa
		Calendar c = Calendar.getInstance(); //getting the instance of calander
		if(strValue.equalsIgnoreCase("CDATE_TODAY"))
		{
			strValue = sdf.format(c.getTime()); // to get the date in required sdf format
		}
		if(strValue.contains("CDATE_TODAY#"))
		{
			int intDays = Integer.parseInt(strValue.split("#")[1]);
			c.add(c.DATE, intDays); //to add days to current date.
			strValue = sdf.format(c.getTime());
		}
		if(strValue.contains("CDATE_TODAY_"))
		{
			int intDays = Integer.parseInt(strValue.split("_")[1]);
			c.add(c.DATE, -intDays);
			strValue = sdf.format(c.getTime());
		}

		return strValue;
	}
	public String WorkingWithTime(String strValue)
	{

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy"); //have to set the format in which date have to displa
		Calendar c = Calendar.getInstance(); //getting the instance of calander
		if(strValue.equalsIgnoreCase("CDATE_TODAY"))
		{
			strValue = sdf.format(c.getTime()); // to get the date in required sdf format
		}
		if(strValue.contains("CDATE_TODAY#"))
		{
			int intDays = Integer.parseInt(strValue.split("#")[1]);
			c.add(c.DATE, intDays); //to add days to current date.
			strValue = sdf.format(c.getTime());
		}
		if(strValue.contains("CDATE_TODAY_"))
		{
			int intDays = Integer.parseInt(strValue.split("_")[1]);
			c.add(c.DATE, -intDays);
			strValue = sdf.format(c.getTime());
		}

		return strValue;
	}
	public void swapping(int a ,int b)
	{
		b = (a+b) - (a=b);
		System.out.println("value of a "+a );
		System.out.println("VAlue of b "+b);
	}

	public List<String[]> ConvertMapToArraylist(Map<String,String> objMap)
	{


		List<String[]> objList = new ArrayList<String[]>();
		if(objMap.isEmpty() || objMap == null)
		{
			objList= null;
			return objList;
		}

		for(String s: objMap.keySet())
		{
			String[] str = new String[2];
			str[0] =s;
			str[1]= objMap.get(s);
			objList.add(str);
		}


		for(String[] test : objList)
		{
			System.out.println(test[0]+test[1]);
		}
		return objList;
	}

	public Set<String> convertListToSet(List<String> objlist)
	{
		Set<String> objSet = new HashSet<String>();
		for(String s: objlist)
		{
			objSet.add(s);

		}
		Iterator<String> obj = objSet.iterator();

		while(obj.hasNext())
		{
System.out.println("value"+ obj.next());

		};
		return objSet;
	}

}
