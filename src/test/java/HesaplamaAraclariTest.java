import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sun.security.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;


public class HesaplamaAraclariTest{

    public String baseUrl = "https://ziraatbank.com.tr/tr";
    String driverPath = "src/test/resources/drivers/chromedriver.exe";
    public WebDriver driver ;

    public static final int vade= 12;
    public static final int tutar= 6000;


    @BeforeTest
    public void openMainPage(){
        System.out.println("launching chrome browser");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();

    }
    @Test(priority = 5)
    public void konutKredisi(){
        init();
        goHesaplamaAraclari();
        driver.findElement(By.linkText("Hesaplama Araçları")).click();
        driver.findElement(By.xpath("//*[@id=\"landingNav\"]/div[1]/div/div/div/div/div[1]/ul/li[3]/a")).click();
    }
    @Test(priority = 4)
    public void tasitKredisi(){
        init();
        goHesaplamaAraclari();
        driver.findElement(By.linkText("Hesaplama Araçları")).click();
        driver.findElement(By.xpath("//*[@id=\"landingNav\"]/div[1]/div/div/div/div/div[1]/ul/li[2]/a")).click();
    }

    @Test(priority = 3)
    public void ihtiyacKredisi(){
        init();
        goHesaplamaAraclari();
        driver.findElement(By.linkText("Hesaplama Araçları")).click();
        driver.findElement(By.xpath("//*[@id=\"landingNav\"]/div[1]/div/div/div/div/div[1]/ul/li[1]/a")).click();
        List<WebElement> options = driver.findElement(By.id("ddlCredit")).findElements(By.tagName("option"));
        for(WebElement option : options){

            System.out.println(option.getText());
            option.click();
            driver.findElement(By.id("calc-tutar")).sendKeys(String.valueOf(tutar));
            driver.findElement(By.id("calc-vade")).sendKeys(String.valueOf(vade));
            driver.findElement(By.cssSelector("btn btn-red calculation-button")).click();
            System.out.println(driver.findElement(By.id("faiz-orani")).getText());

        }
    }


    @Test(priority = 2)
    public void goHesaplamaAraclari() {

        driver.findElement(By.xpath("//*[@id='slider-container']/header/div[2]/div[2]/nav/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"landingNav\"]/div[1]/div[2]/div/h2/a")).click();
        driver.findElement(By.xpath("//*[@id=\'footer\']/div/div[1]/div/ul[1]/li[3]/ul/li[1]/a")).click();
    }

    @Test(priority = 1)
    public void init(){
        driver.navigate().to(baseUrl);
    }

}
