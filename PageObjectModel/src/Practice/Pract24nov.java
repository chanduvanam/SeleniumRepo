package Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

public class Pract24nov {

	@Test
	public void tester() throws IOException
	{
		File objFile = new File("D:/sample");
		objFile.mkdirs();
		System.out.println(objFile.exists());
		if(!objFile.exists())
		{
			objFile.createNewFile();
		}
		System.out.println(objFile.exists());
		FileOutputStream fout = new FileOutputStream(objFile,true);
		String str= "abcdefgijk";
		byte[] bytes = str.getBytes();
		fout.write(bytes);
		fout.close();
		FileInputStream fin = new FileInputStream(objFile);
		int i =0;
		while((i=fin.read())!=-1)
		{
			
			System.out.println(i);
			System.out.println((char)i);
		}
		fin.close();
		System.out.println("------Using FileReader and File Writer----------");
		FileReader objReader = new FileReader(objFile);
		while((i=objReader.read())!=-1)
		{
			System.out.println((char)i);
		}
		objReader.close();
		FileWriter objWriter = new FileWriter(objFile,true);
		objWriter.write("srinivas poduri");
		objWriter.close();
		System.out.println("-------Using Buffered Reader and Writer----------");
		
		BufferedReader objBr = new BufferedReader(new FileReader(objFile));
		String strline = null;
		while((strline=objBr.readLine()) != null)
		{
			System.out.println(strline);
		}
		objBr.close();
		BufferedWriter objBw = new BufferedWriter(new FileWriter(objFile,true));
		objBw.write("vamsi poduri");
		objBw.close();
		System.out.println("--------------Final content----------------------");
		objBr = new BufferedReader(new FileReader(objFile));
		 strline = null;
		while((strline=objBr.readLine()) != null)
		{
			System.out.println(strline);
		}

	}
}
