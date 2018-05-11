package TestCases;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Common.Browser;
import Common.CommonUtils;
import Common.SyncClass;
import Pages.CommonObjects;

import java.lang.reflect.*;

public class ClassDemo {

  public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
/* WebDriver driver = new FirefoxDriver();
    CommonObjects objCommon = PageFactory.initElements(driver, CommonObjects.class);*/
    
    String strmain = "this is anna anna";
    String strmatch="";
    String strnotmatch="";
    for(int i =0;i<= strmain.length()-1;i++)
    {
    	for(int j=i;j<=strmain.length()-1;j++)
    	{
    		String reverse = new StringBuffer(strmain.substring(i, j)).reverse().toString();
    		
    		if(reverse.equalsIgnoreCase(strmain.substring(i, j)))
    		{
    			strmatch= strmain.substring(i, j);
    		}
    		else
    		{
    			strnotmatch=strmain.substring(i, j);
    		}
    	}
    }
    
  } 
}
