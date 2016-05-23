package WebPatrol;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebPatrolTest {
	
  private WebDriver m_driver;
  private String baseUrl;

  
  @Before
  public void setUp() throws Exception {
	baseUrl = "http://www.yahoo.co.jp/";
  }

  @Test
  public void test1() throws Exception {
	  
	this.m_driver = new FirefoxDriver();
	this.m_driver.manage().window().maximize();
	this.m_driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	this.testStart();
  }

  private void testStart() throws InterruptedException, IOException {

	this.m_driver.get(baseUrl);
	
	TakesScreenshot screen = (TakesScreenshot) m_driver;
	File srcFile = screen.getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(srcFile, new File("/home/bang/test/full.png"));
//	FileUtils.copyFile(srcFile, new File("C:\\usr\\local\\!a_toriumi\\tmp\\full.png"));
  }
  
  @After
  public void tearDown() throws Exception {
    this.m_driver.quit();
  }

}
