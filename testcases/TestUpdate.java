package testcases;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;


import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.bouncycastle.cms.RecipientId.password;

public class TestUpdate {
    WebDriver driver=null;
    @BeforeMethod
    public void setUp() throws IOException, org.json.simple.parser.ParseException
    {
        WebDriverManager.chromedriver().setup();
        String chromeDriverPath = "C:\\software\\chromedriver_ver113\\chromedriver\\chromedriver.exe";
        System.setProperty("webDriver.chrome.driver", chromeDriverPath);
        String LoginDataPath = "src/main/resources/LoginData.json";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        FileReader fr = new FileReader(LoginDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        String url = (String) jsonObject.get("url");
        System.out.println(url);
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException
    {
        Thread.sleep(1000);
        driver.quit();
    }
    @Test
    public void updateUser() throws IOException, ParseException, InterruptedException
    {

        String searchCompDataPath="src/main/resources/TestCases.json";
        FileReader fr=new FileReader(searchCompDataPath);
        JSONParser Parser=new JSONParser();
        Object ob= Parser.parse(fr);
        JSONObject jsonObject=(JSONObject) ob;
        JSONObject tc=(JSONObject) jsonObject.get("tc01");

        String Username=(String) tc.get("Username");
        String password=(String) tc.get("password");
        String expMsg="Valid";
        System.out.println(expMsg+" "+Username+" "+password);
        MainPage m= new MainPage(driver);
//driver.findElement(By.xpath("icon-set-after down-arrow ng-star-inserted")).click();

        m.setUname(Username);
        m.click();
        m.setPassword(password);
        m.clickLogin1();
        //Thread.sleep(2000);
        m.clickAccount();
        m.setClear();
        m.setFname("Ani");
        m.clickSaveProfile();
        System.out.println("success");
        Thread.sleep(2000);
        driver.quit();





    }
}