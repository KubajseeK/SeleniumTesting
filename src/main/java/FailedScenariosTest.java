import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FailedScenariosTest {

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

    /**
     * No confirmation error
     */
    @Test
    public void failedScenario1() {
        driver.get("http://itsovy.sk/testing/");
        driver.manage().window().setSize(new Dimension(800, 600));
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).sendKeys("2000");
        driver.findElement(By.id("interest")).click();
        driver.findElement(By.id("interest")).sendKeys("2");
        driver.findElement(By.id("period")).sendKeys("2");
        driver.findElement(By.id("period")).click();
        driver.findElement(By.cssSelector("input[value=\"n\"]")).click();
        driver.findElement(By.id("btnsubmit")).click();

    }

    /**
     * Negative Amount Given Error
     */
    @Test
    public void failedScenario2() {
        driver.get("http://itsovy.sk/testing/");
        driver.manage().window().setSize(new Dimension(800, 600));
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).sendKeys("-5000");
        driver.findElement(By.id("interest")).click();
        driver.findElement(By.id("interest")).sendKeys("2");
        driver.findElement(By.id("period")).sendKeys("2");
        driver.findElement(By.id("period")).click();
        driver.findElement(By.cssSelector("input[value=\"n\"]")).click();
        driver.findElement(By.id("confirm")).click();
        driver.findElement(By.id("btnsubmit")).click();
    }


    /**
     * Amount Out Of Bounds Error
     */
    @Test
    public void failedScenario3() {
        driver.get("http://itsovy.sk/testing/");
        driver.manage().window().setSize(new Dimension(800, 600));
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).sendKeys("50000000");
        driver.findElement(By.id("interest")).click();
        driver.findElement(By.id("interest")).sendKeys("2");
        driver.findElement(By.id("period")).sendKeys("2");
        driver.findElement(By.id("period")).click();
        driver.findElement(By.cssSelector("input[value=\"n\"]")).click();
        driver.findElement(By.id("confirm")).click();
        driver.findElement(By.id("btnsubmit")).click();
    }

    /**
     * Interest over 100
     */
    @Test
    public void failedScenario4() {
        driver.get("http://itsovy.sk/testing/");
        driver.manage().window().setSize(new Dimension(800, 600));
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).sendKeys("5000");
        driver.findElement(By.id("interest")).click();
        driver.findElement(By.id("interest")).sendKeys("10000");
        driver.findElement(By.id("period")).sendKeys("2");
        driver.findElement(By.id("period")).click();
        driver.findElement(By.cssSelector("input[value=\"n\"]")).click();
        driver.findElement(By.id("confirm")).click();
        driver.findElement(By.id("btnsubmit")).click();
    }

    /**
     * Negative Interest
     */
    @Test
    public void failedScenario5() {
        driver.get("http://itsovy.sk/testing/");
        driver.manage().window().setSize(new Dimension(800, 600));
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).sendKeys("5000");
        driver.findElement(By.id("interest")).click();
        driver.findElement(By.id("interest")).sendKeys("-9");
        driver.findElement(By.id("period")).sendKeys("2");
        driver.findElement(By.id("period")).click();
        driver.findElement(By.cssSelector("input[value=\"n\"]")).click();
        driver.findElement(By.id("confirm")).click();
        driver.findElement(By.id("btnsubmit")).click();
    }








}
