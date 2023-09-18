package SS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Login02 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://sej.paditech.org/");
        Thread.sleep(1000);

        // Tạo một cookie mới
        Cookie cookie = new Cookie("sc2_pn_session", "eyJpdiI6InJBblovbVRWYXdGWjZBMWZsOHdCNkE9PSIsInZhbHVlIjoienZwY3BPVHNNKzFlSGV6OXJ1TDhVb2hDQmdUNmVSeEF5ZkYvMW95dTNRYUdqUS8zZ2NLQUNVRGFER2lxclR1MGpXVFZhTTFnN2VWdnp2dmVrcFRGUXoydDJ3UWlLUmQrc1RIV1ZENzdJWFU0TVBuUEJIenJQRi9abWJ6b2tENmQiLCJtYWMiOiJhOWNkNWE5NWFmMDFlM2I1YTRkNDY3OTg0YWFlYjdmNTgwMjg2OTIyYjU1YWQ2MGY5ZWE5OTMzODFiNmJmMjQzIiwidGFnIjoiIn0%3D");

        // Thêm cookie vào phiên làm việc hiện tại
        driver.manage().addCookie(cookie);

        driver.get("https://sej.paditech.org/admin/coupons");

        //create coupon
//        driver.findElement(By.xpath("//div[@class='flex gap-2 items-center']")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//label[@for='name']/following-sibling::div/div/input")).sendKeys("Auto");
//        driver.findElement(By.xpath("//input[@placeholder='開始日時']")).sendKeys("2023-09-20 00:00:00");
//        Thread.sleep(500);
//        driver.findElement(By.xpath("//input[@id='end_date']")).sendKeys("2023-09-25 00:00:00");
//        Thread.sleep(500);
//        driver.findElement(By.xpath("//label[@for='image_url']/following-sibling::div/div/div[2]/input")).sendKeys("https://www.pexels.com/photo/orange-cat-looking-for-food-18378055/");
//        driver.findElement(By.xpath("//input[@placeholder='C2101222']")).sendKeys("189");
//        Thread.sleep(500);
//        driver.findElement(By.xpath("//span[contains(text(),'保存して次へ')]")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//span[contains(text(),'登録完了する')]")).click();


        //edit
        driver.findElement(By.xpath("//tbody/tr[2]/td[8]/a[2]")).click();
        driver.findElement(By.xpath("//label[@for='image_url']/following-sibling::div/div/div[2]/input")).clear();
        driver.findElement(By.xpath("//label[@for='image_url']/following-sibling::div/div/div[2]/input")).sendKeys("https://images.pexels.com/photos/18378055/pexels-photo-18378055/free-photo-of-orange-cat-looking-for-food.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[contains(text(),'保存して次へ')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'登録完了する')]")).click();


        driver.quit();
    }

}
