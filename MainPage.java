package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    WebDriver driver=null;
    public MainPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void setUname(String value) {
        String loc = "//input[@class='form-text-input']";
        WebElement e = this.driver.findElement(By.xpath(loc));
        e.sendKeys(value);


    }


    public void click() {
        String loc = "//button[@class='button form-button is-primary']";
        WebElement e = this.driver.findElement(By.xpath(loc));
        e.click();


    }
    public void setPassword(String value)
    {
        String loc="//input[@id='password']";
        WebElement e=this. driver.findElement(By.xpath(loc));
        e.sendKeys(value);


    }
    public void clickLogin1()
    {
        String loc="//button[@class='button form-button is-primary']";
        WebElement e=this. driver.findElement(By.xpath(loc));
        e.click();

    }

    public void clickAccount()
    {
        String loc="//div//a[@title='Update your profile, personal settings, and more']";
        WebElement e=this. driver.findElement(By.xpath(loc));
        e.click();

    }
    public void setClear()
    {
        String loc="//input[@id='first_name']";
        WebElement e=this. driver.findElement(By.xpath(loc));
        e.clear();

    }
    public void setFname(String value)
    {
        String loc="//input[@id='first_name']";
        WebElement e=this.driver.findElement(By.xpath(loc));
        e.sendKeys(value);


    }
    public void setLname(String value)
    {
        String loc="//input[@id='last_name']";
        WebElement e=this.driver.findElement(By.xpath(loc));
        e.sendKeys(value);

    }

    public void setPublicName(String value)
    {
        String loc="//input[@id='display_name']";
        WebElement e=this.driver.findElement(By.xpath(loc));
        e.sendKeys(value);

    }

    public void setAbout(String Value)
    {
        String loc="//textarea[@id='description']";
        WebElement e=this.driver.findElement(By.xpath(loc));
        e.sendKeys(Value);

    }

    public void clickSaveProfile()
    {
        String loc="//button[@type='submit']";
        WebElement e=this. driver.findElement(By.xpath(loc));
        e.click();

    }
    public void clickDel()
    {
        String loc="//button[@class='button profile-link__remove is-borderless']";
        WebElement e=this.driver.findElement(By.xpath(loc));
        e.click();

    }
    public void clickReader()
    {
        //String loc="//div//a[@class='masterbar__item masterbar__reader']";
        String loc="//*[@id='header']/div[1]/a[2]";
        WebElement e=this.driver.findElement(By.xpath(loc));
        e.click();

    }

    public void clickSearch()
    {
        String loc="//span[@class='sidebar__menu-link-text menu-link-text']";
        WebElement e=this.driver.findElement(By.xpath(loc));
        e.click();

    }
    public void clickSearchEnter(String value)
    {
        String loc="//input[@id='search-component-66a2e325-0063-4273-b57a-a1c5b29d348d']";
        WebElement e=this.driver.findElement(By.xpath(loc));
        e.sendKeys(value);

    }

}


