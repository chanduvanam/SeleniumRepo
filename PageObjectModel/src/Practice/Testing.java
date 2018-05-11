package Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;



public class Testing {

	@Test
	public void test() throws IOException
	{
		File f = new File("C:\\Users\\srini\\Desktop\\SeleniumRunning\\sam.txt");
		File f1 = new File("C:\\Users\\srini\\Desktop\\SeleniumRunning\\tes.txt");
		if(!f.exists())
		{
			f.createNewFile();
			FileWriter fw = new FileWriter(f,true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("srinivas");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			while(br.readLine()!= null)
			{
				System.out.println(br.readLine());
			}
			fw.close();
			bw.close();
			fr.close();
			br.close();


		}
		else
		{
			FileWriter fw = new FileWriter(f,true);
			//BufferedWriter bw = new BufferedWriter(fw);
			String line=null;
			fw.write("srinivas");
			fw.close();
			//bw.close();
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			while((line=br.readLine())!= null)
			{
				System.out.println(line);

			}
			


		}
	}
}

