package Reporting;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Common.Browser;

public class HtmlReporting
{
	static File objFile = null;
	static FileWriter fw = null;
	static BufferedWriter bw = null;

	public static void createResult(String strScriptName, String strStepname, String strStatus) throws IOException
	{
		objFile = new File("Reports/test.html");
		String strdata= null;
		
		if(strStatus.equalsIgnoreCase("fail"))
		{
			TakesScreenshot ts= (TakesScreenshot)(Browser.getDriver());
			File Screenshot = ts.getScreenshotAs(OutputType.FILE);
			File Location = new File(".Reporting/"+strStepname+".jpg");
			FileUtils.copyFile(Screenshot,Location);
		}

		if(!objFile.exists())
		{
			objFile.createNewFile();

			fw = new FileWriter(objFile,true);
			bw = new BufferedWriter(fw);

			strdata = "<html><head><link rel="+"stylesheet"+" type="+"text/css"+" href="+"cssfile.css"+"><title>TestNG Report</title></head><body><img src="+"html5.gif+"+" alt="+"Mountain View"+" style="+"width:100px;height:100px;"+"><center><h4>  Basic Reporting form html</h4><table><tr> "+strScriptName+" </tr><tr><th>Step Name</th><th>Status</th><th>Time (ms)</th><th>ScreenShot</th></tr>";
			String strAddRow="<tr><td>"+strStepname+"</td>"+"<td>"+strStatus+"</td>"+"<td>"+"time"+"</td>"+"<td>"+"screenshot"+"</td></tr>";
			bw.write(strdata);
			bw.write(strAddRow);
			//bw.close();
		}
		else
		{
			fw = new FileWriter(objFile,true);
			bw = new BufferedWriter(fw);

			if(strScriptName.length()>0)
			{
				strdata = "<table><tr> "+strScriptName+" </tr><tr><th>Step Name</th><th>Status</th><th>Time (ms)</th><th>ScreenShot</th></tr>";
				bw.write(strdata);
				String strAddRow="<tr><td>"+strStepname+"</td>"+"<td>"+strStatus+"</td>"+"<td>"+"time"+"</td>"+"<td>"+"screenshot"+"</td></tr>";
				bw.write(strAddRow);
			}
			else
			{
				String strAddRow="<tr><td>"+strStepname+"</td>"+"<td>"+strStatus+"</td>"+"<td>"+"time"+"</td>"+"<td>"+"screenshot"+"</td></tr>";
				bw.write(strAddRow);
				bw.close();
			}

		}

		bw.close();

	}
}
