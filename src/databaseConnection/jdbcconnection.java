package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.TestNG;
//import org.testng.annotations.Test;
public class jdbcconnection {

	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		/*
		TestNG testSuite = new TestNG();
	    testSuite.setTestClasses(new Class[] { MyClass.class }); //it would be probably name of the class in which `main` method is located
	   // testSuite.addListener(new MyListener()); //optional
	    testSuite.setDefaultSuiteName("Test Suite");
	    testSuite.setDefaultTestName("Test Name");
	    testSuite.setOutputDirectory("/my/output/dir");
	    testSuite.run();
	    */
		String host="localhost";
		String port="3306";
		Connection con = DriverManager.getConnection("jdbc:mysql://" +host+ ":" +port+ "/demo", "root", "123456");
		Statement s= con.createStatement();
		ResultSet rs=s.executeQuery("select * from credentials where scenario = 'basic card'");
		while(rs.next())
		{
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver-win64\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys(rs.getString("username"));
		driver.findElement(By.id("password")).sendKeys(rs.getString("password"));
		//driver.findElement(By.id("Login")).click();
		
			//System.out.println(rs.getString("username"));
		//System.out.println(rs.getString("password"));
	}
	}
}
