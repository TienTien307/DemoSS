package SS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Login01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://sej.paditech.org/login");
        Thread.sleep(1000);

//      thứ tự tab
        String tab1 = driver.getWindowHandle();

        //login
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tiennt@mailsac.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Abc.12345");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='g-recaptcha']//div//div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        //mở tab mới
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://mailsac.com/login");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='username']")).sendKeys("abc_12345");
        driver.findElement(By.xpath("//input[@placeholder='password']")).sendKeys("Abc.123456");
        driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='anything']")).sendKeys("tiennt");
        driver.findElement(By.xpath("//button[normalize-space()='Check the mail!']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//tbody/tr[2]/td[3]")).click();
        Thread.sleep(1000);Thread.sleep(1000);
        //lấy code xác thực
        String code = driver.findElement(By.xpath("//tbody/tr/td/h1//following::p[1]")).getText();
        code = code.substring(Math.max(code.length() - 6, 0));
        System.out.println(code);

        //quay lại tab1
        driver.switchTo().window(tab1);
        driver.findElement(By.xpath("//input[@placeholder='認証コード']")).sendKeys(code);
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
        Thread.sleep(2000);

        //Search
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='キャンペーンID、またはキャンペーン名']"));
        search.sendKeys("p1");
        search.submit();

        driver.quit();
    }

}
