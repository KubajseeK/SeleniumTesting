import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SuccessScenariosTest {

    private WebDriver driver;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jacob\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
    }
    @After
    public void tearDown() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    @Test
    public void successScenario1() {
        driver.get("http://itsovy.sk/testing");
        driver.manage().window().setSize(new Dimension(800, 600));
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).sendKeys("3500");
        driver.findElement(By.id("interest")).click();
        driver.findElement(By.id("interest")).sendKeys("3");
        driver.findElement(By.id("period")).sendKeys("3");
        driver.findElement(By.id("period")).click();
        driver.findElement(By.id("confirm")).click();
        driver.findElement(By.id("btnsubmit")).click();
    }

    @Test
    public void successScenario2() {
        driver.get("http://itsovy.sk/testing");
        driver.manage().window().setSize(new Dimension(800, 600));
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).sendKeys("5000");
        driver.findElement(By.id("interest")).click();
        driver.findElement(By.id("interest")).sendKeys("2");
        driver.findElement(By.id("period")).sendKeys("1");
        driver.findElement(By.id("period")).click();
        driver.findElement(By.id("confirm")).click();
        driver.findElement(By.id("btnsubmit")).click();
    }
    @Test
    public void successScenario3() {
        driver.get("http://itsovy.sk/testing");
        driver.manage().window().setSize(new Dimension(800, 600));
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).sendKeys("49852.1");
        driver.findElement(By.id("interest")).click();
        driver.findElement(By.id("interest")).sendKeys("2.2");
        driver.findElement(By.id("period")).click();
        driver.findElement(By.id("period")).sendKeys("2");
        driver.findElement(By.cssSelector("input[value=\"n\"]")).click();
        driver.findElement(By.id("confirm")).click();
        driver.findElement(By.id("btnsubmit")).click();
    }
}
