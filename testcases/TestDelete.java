package testcases;

import io.cucumber.java.it.Ma;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestDelete {
    WebDriver driver=null;
    @BeforeMethod
    public void setUp() throws IOException, org.json.simple.parser.ParseException, ParseException {
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
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
    @Test
    public void deleteUser() throws IOException, ParseException, InterruptedException {

        String searchCompDataPath="src/main/resources/LoginData.json";
        FileReader fr=new FileReader(searchCompDataPath);
        JSONParser Parser=new JSONParser();
        Object ob= Parser.parse(fr);
        JSONObject jsonObject=(JSONObject) ob;
        JSONObject tc=(JSONObject) jsonObject.get("user1");
        String Username=(String) tc.get("username");
        String password=(String) tc.get("password");
        String expMsg="Valid";
        System.out.println(expMsg+" "+Username+" "+password);
        MainPage m = new MainPage(driver);
        m.setUname(Username);
        m.click();
        m.setPassword(password);
        m.clickLogin1();
        m.clickAccount();
        //m.clickSaveProfile();
        m.clickDel();
        // h.clickAddress();
        //h.clickClr();
        Thread.sleep(2000);
        driver.quit();

    }

}
