package Common;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.ui.Select;

import com.sun.jna.platform.FileUtils;

import Logging.Log;
import Reporting.HtmlReporting;

public class CommonUtils {


	public boolean HoverMouse(WebElement eleWebElement)
	{
		boolean blnStatus = false;
		try
		{
			Thread.sleep(10000);
			if(eleWebElement.isEnabled())
			{
				Actions objActions = new Actions(Browser.getDriver());
				objActions.moveToElement(eleWebElement).perform();
				blnStatus = true;
			}
			else
			{
				blnStatus = false;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			blnStatus = false;
		}
		return blnStatus;
	}


	public boolean gFunc_SelectRadioButton(WebElement eleWebElement,String strAction)
	{
		boolean blnStatus = false;
		try
		{
			blnStatus  = gFunc_CheckElementExistence(eleWebElement);
			if(!blnStatus)
			{return false;

			}
			if(strAction.equalsIgnoreCase("Select"))
			{
				blnStatus = eleWebElement.isSelected();
				if(blnStatus)
				{
					Log.info(eleWebElement.getText()+"Radio button already selected state");
					return true;
				}
				else
				{
					eleWebElement.click();
					Log.info(eleWebElement.getText()+"Radio button  selected successfully");
					return true;
				}

			}

		}
		catch(Exception e)
		{
			Log.error("gFunc_SelectRadioButton:-"+e.toString()+ "occurred");
			return false;
		}
		return blnStatus;
	}

	public boolean gFunc_SelectCheckbox(WebElement eleWebElement,String strAction)
	{

		boolean blnStatus = false;
		try
		{
			blnStatus  = gFunc_CheckElementExistence(eleWebElement);
			if(!blnStatus)
			{return false;

			}
			if(strAction.equalsIgnoreCase("Select"))
			{
				blnStatus = eleWebElement.isSelected();
				if(blnStatus)
				{
					Log.info(eleWebElement.getText()+"checkbox already selected state");
					return true;
				}
				else
				{
					eleWebElement.click();
					Log.info(eleWebElement.getText()+"Checkbox  selected successfully");
					return true;
				}

			}
			else if(strAction.equalsIgnoreCase("UnSelect"))
			{
				blnStatus = eleWebElement.isSelected();
				if(blnStatus)
				{
					eleWebElement.click();
					Log.info(eleWebElement.getText()+"checkbox unselected successfully");
					return true;
				}
				else
				{
					Log.info(eleWebElement.getText()+"Checkbox  already unselected");
					return true;
				}

			}

		}
		catch(Exception e)
		{
			Log.error("gFunc_SelectCheckbox:-"+e.toString()+ "occurred");
			return false;
		}
		return blnStatus;
	}

	public boolean gFunc_SelectValueByindex(WebElement eleSelect,int index)
	{
		boolean blnStauts =false;
		try
		{
			blnStauts = gFunc_CheckElementExistence(eleSelect);
			if(!blnStauts)
			{
				Log.error("gFunc_SelectValueByindex"+eleSelect +"not exists");
				return false;
				
			}
			Select objSelect = new Select(eleSelect);
			objSelect.selectByIndex(index);
		    List<WebElement> objSelected = objSelect.getAllSelectedOptions();
		    System.out.println("count "+objSelected.size());
		    for(WebElement ele: objSelected)
		    {
		     if(ele.getAttribute("index").equalsIgnoreCase(String.valueOf(index)))
		     {
		    	 Log.info("Option"+eleSelect.getText() +"selected successfully");
		    	 blnStauts = true;
		    	 break;
		    	 
		     }
		    }
		}
		catch(Exception e)
		{
			Log.error("gFunc_SelectValueByindex:-"+e.toString()+ "occurred");
			return false;
		}
		return blnStauts;
	}
	
	public Map<String,String> gFunc_ReadTestData(String strsheetpath,String strsheetName,int RowNumber)
	{
		Map<String,String> objHashmap = new HashMap<String,String>();
		try
		{
			//Workbook workbook = null;
			//if()
		}
		catch(Exception e)
		{
			
		}
		return objHashmap; 
	}
	public boolean gFunc_PerformObjectAction(WebElement eleWebElement,enObjectType objenObjectType,String strValue)
	{
		boolean blnStatus = false;
		try
		{
			blnStatus = gFunc_CheckElementExistence(eleWebElement);
			if(!blnStatus)
			{
				Log.error("gFunc_PerformObjectAction :-Element Not found"+eleWebElement);
				return blnStatus;
			}
			switch(objenObjectType)
			{
			case Button:

				eleWebElement.click();
				Log.info("gFunc_PerformObjectAction :- Clicked on " + eleWebElement +"Successfully.");
				HtmlReporting.createResult("", "Clicked on Button successfully", "Pass");

				break;
			case Link:
				eleWebElement.click();
				Log.info("gFunc_PerformObjectAction :- Clicked on " + eleWebElement +"Successfully.");
				HtmlReporting.createResult("", "Clicked on link successfully", "Pass");
				break;
			case TextBox:
				eleWebElement.sendKeys(strValue);
				Log.info("gFunc_PerformObjectAction :- Value"+ strValue +"Entered in " + eleWebElement +"Successfully.");
				HtmlReporting.createResult("", "value entered successfully", "Pass");
				break;
			case RadioButton:
				break;
			case Checkbox:

				if(strValue.equalsIgnoreCase("True"))
				{
					if(!eleWebElement.isSelected())
					{
						eleWebElement.click();
						Log.info("gFunc_PerformObjectAction :- Clicked on " + eleWebElement +"Successfully.");
						HtmlReporting.createResult("", "Checkbox selected successfully", "Pass");
					}
					else
					{
						eleWebElement.click();
						Log.info("gFunc_PerformObjectAction :-Checkbox alread selected " + eleWebElement +".");
					}
				}
				else
				{
					if(eleWebElement.isSelected())
					{
						eleWebElement.click();
						Log.info("gFunc_PerformObjectAction :-Unchecked  " + eleWebElement +"Successfully.");
					}

				}
				break;
			case Image:
				break;
			default :

				eleWebElement.click();
			}


		}
		catch(Exception e)
		{

		}
		return blnStatus;
	}
	public enum enObjectType
	{
		Button,Checkbox,TextBox,RadioButton,Link,Image
	}
	public List getTableRows(String strTableXpath)
	{
		WebElement WebTable = Browser.getDriver().findElement(By.xpath(strTableXpath));
		List<WebElement> eleTableRows = WebTable.findElements(By.xpath(strTableXpath+"//tr"));
		return eleTableRows;

	}


	public int getTableRowCount(String strTableXpath)
	{
		WebElement WebTable = Browser.getDriver().findElement(By.xpath(strTableXpath));
		List<WebElement> eleTableRows = WebTable.findElements(By.xpath(strTableXpath+"//tr"));
		return eleTableRows.size();

	}
	public List getTableColumns(String strTableXpath)
	{
		WebElement WebTable = Browser.getDriver().findElement(By.xpath(strTableXpath));
		List<WebElement> lstTableColumns = WebTable.findElements(By.xpath(strTableXpath+"//th"));
		return lstTableColumns;
	}
	public int getTableColumnCount(String strTableXpath)
	{
		WebElement WebTable = Browser.getDriver().findElement(By.xpath(strTableXpath));
		List<WebElement> lstTableColumns = WebTable.findElements(By.xpath(strTableXpath+"//th"));
		return lstTableColumns.size();
	}

	public String[] getHeaderNames(String strTableXPath)
	{
		WebElement WebTable = Browser.getDriver().findElement(By.xpath(strTableXPath));
		List<WebElement> lstTableHeaders = WebTable.findElements(By.xpath(strTableXPath+"//th"));
		String[] strHeaderNames = new String[lstTableHeaders.size()];
		for(int i=0;i<=strHeaderNames.length-1;i++)
		{
			strHeaderNames[i] = lstTableHeaders.get(i).getText();
		}
		return strHeaderNames;
	}

	public int getRowWithCellText(String strTabaleXPath,String strCellText)
	{
		WebElement WebTable = Browser.getDriver().findElement(By.xpath(strTabaleXPath));
		List<WebElement> LstTableRows = Browser.getDriver().findElements(By.xpath(strTabaleXPath+"//tr"));
		int RowCount = LstTableRows.size();
		int MatchRowNumber =1;
		for(int i = 1;i<=RowCount-1;i++)
		{
			if(strCellText.equalsIgnoreCase(LstTableRows.get(i).getText().trim()))
			{
				MatchRowNumber = i;
				break;
			}
		}
		return MatchRowNumber;
	}

	public boolean PerformOperationsOnTable(String strTableXPath,String strUniqueColumnName,String strActionColumnName,String strSearchValue,String StrActionType)
	{
		boolean blnStatus = false;
		try
		{
			WebElement WebTable = Browser.getDriver().findElement(By.xpath(strTableXPath));
			int TableRows = getTableRowCount(strTableXPath);
			int TableColumnCount = getTableColumnCount(strTableXPath);
			List<WebElement> lstTableColumnsNames = getTableColumns(strTableXPath);
			int RequiredSearchColumn = 0;
			int RequiredActionColumn =0;
			String strDynamicXPATH=null;
			WebElement eleCell = null;
			//TableColumnCount-1 because index stats from 0
			for(int iColumnCounter = 0;iColumnCounter<=TableColumnCount-1;iColumnCounter++)
			{
				if(strUniqueColumnName.trim().equalsIgnoreCase(lstTableColumnsNames.get(iColumnCounter).getText()))
				{
					RequiredSearchColumn = iColumnCounter+1;
				}
				if(strActionColumnName.trim().equalsIgnoreCase(lstTableColumnsNames.get(iColumnCounter).getText()))
				{
					RequiredActionColumn = iColumnCounter+1;
				}

			}
			//iterating through rows to find search text and perform action

			for(int iRowCounter =2;iRowCounter<=TableRows;iRowCounter++)
			{
				strDynamicXPATH = strTableXPath+"//tr["+iRowCounter+"]/td["+RequiredSearchColumn+"]";
				eleCell = Browser.getDriver().findElement(By.xpath(strDynamicXPATH));
				if(eleCell.getText().trim().equalsIgnoreCase(strSearchValue.trim()))
				{
					if(StrActionType.length()>0)
					{
						strDynamicXPATH = strTableXPath+"//tr["+iRowCounter+"]/td["+RequiredActionColumn+"]/input";
						Browser.getDriver().findElement(By.xpath(strDynamicXPATH)).sendKeys(StrActionType);
						blnStatus = true;
					}
					else
					{
						strDynamicXPATH = strTableXPath+"//tr["+iRowCounter+"]/td["+RequiredActionColumn+"]/input";
						Browser.getDriver().findElement(By.xpath(strDynamicXPATH)).click();
						blnStatus = true;
					}


				}
				else
				{
					blnStatus = false;
				}
			}


		}catch(Exception e)
		{

		}
		return blnStatus;
	}
	public String getCelldataFromTable(String strTableXPath,int Row,int Column)
	{
		String strValue = null;
		try
		{
			
			String strCellXPATH = strTableXPath+"//tr["+Row+"]/td["+Column+"]";
			WebElement Cel = Browser.getDriver().findElement(By.xpath(strCellXPATH));
			strValue =  Cel.getText();
			
			
		}
		catch(Exception e)
		{
			
		}
		return strValue;
	}
	public boolean gFunc_CheckElementExistence(WebElement eleWebElement) throws NoAlertPresentException
    {
           boolean blnStatus = false;
           boolean blnIsDisplayed = false;
           boolean blnIsEnabled = false;

           try

           {
                 
                  try
                  {  //Checking for alert existence  if not then catch exception
                        if(Browser.getDriver().switchTo().alert() != null)
                        {
                               Browser.getDriver().switchTo().alert().accept();
                        }
                  }
                  catch(NoAlertPresentException nae)
                  {
                        System.out.println("No Alert popup displayed");
                  }    //Handling popup displayed as webpage
                        Set<String> objAfterPopupWindows = Browser.getDriver().getWindowHandles();
                        for(String s1: objAfterPopupWindows)
                        {
                               System.out.println(s1);
                               System.out.print(Browser.browserHandle);
                        }
                        if(objAfterPopupWindows.size() == 1)
                        {
                               System.out.println("No popup window Displayed");
                        }
                        else
                        {
                               for(String s: objAfterPopupWindows)
                               {
                                      if(!(s.equalsIgnoreCase(Browser.browserHandle)))
                                      {
                                             Browser.getDriver().switchTo().window(s).close();
                                             
                                      }

                               }
                               Browser.getDriver().switchTo().window(Browser.browserHandle);
                        }
                  if(eleWebElement.isDisplayed())
                  {

                        blnIsDisplayed = true;
                        Log.info("gFunc_CheckElementExistence : " +new Exception().getStackTrace()[1].getMethodName()+ " is displayed" );

                        if(eleWebElement.isEnabled())
                        {
                               blnIsEnabled = true;
                               Log.info("gFunc_CheckElementExistence : " +new Exception().getStackTrace()[1].getMethodName()+ " is Enabled" );
                        }
                        else
                        {
                               blnIsEnabled = false;
                               Log.info("gFunc_CheckElementExistence : " +new Exception().getStackTrace()[1].getMethodName()+ " is not Enabled" );
                        }
                  }
                  else
                  {
                        blnIsDisplayed = false;
                        Log.info("gFunc_CheckElementExistence : " +eleWebElement.getAttribute("placeholder")+ " is not displayed" );
                  }
                  blnStatus = blnIsDisplayed && blnIsEnabled ;
           }

           catch(Exception e)
           {
                  System.out.println("Element of type "+ eleWebElement +"is not exists");
                  blnStatus = false;
           }
           return blnStatus;

    }
	
	public boolean StrTakesScreenShot()
	{
		boolean blnStatus= false;
		try
		{
			TakesScreenshot objScreenshot = ((TakesScreenshot)Browser.getDriver());
			File objScreehnshot = objScreenshot.getScreenshotAs(OutputType.FILE);
			//
			return true;
		}
		catch(Exception e)
		{
			
		}
		return blnStatus;
		
	}
}
