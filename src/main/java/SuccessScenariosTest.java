import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class SuccessScenariosTest {

    private WebDriver driver;
    JavascriptExecutor js;

    String green = "rgba(0, 100, 0, 1)";


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
    public void successScenario1() throws Exception{

        driver.get("http://itsovy.sk/testing");
        WebElement result = driver.findElement(By.id("result"));

        driver.manage().window().setSize(new Dimension(800, 600));
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).sendKeys("3500");
        driver.findElement(By.id("interest")).click();
        driver.findElement(By.id("interest")).sendKeys("3");

        for (int i = 2; i>1; i--) {
            driver.findElement(By.id("period")).sendKeys(Keys.RIGHT);
        }

        driver.findElement(By.id("confirm")).click();
        driver.findElement(By.id("btnsubmit")).click();

        Assert.assertEquals(result.getText(), "Total amount : 3670.02 , net profit : 170.02");
        Assert.assertEquals(result.getCssValue("color"), green);
    }

    @Test
    public void successScenario2() {
        driver.get("http://itsovy.sk/testing");
        WebElement result = driver.findElement(By.id("result"));

        driver.manage().window().setSize(new Dimension(800, 600));
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).sendKeys("5000");
        driver.findElement(By.id("interest")).click();
        driver.findElement(By.id("interest")).sendKeys("10");

        for (int i = 0; i < 4; i++) {
            driver.findElement(By.id("period")).sendKeys(Keys.RIGHT);
        }

        driver.findElement(By.id("confirm")).click();
        driver.findElement(By.id("btnsubmit")).click();

        Assert.assertEquals(result.getText(), "Total amount : 7346.64 , net profit : 2346.64");
        Assert.assertEquals(result.getCssValue("color"), green);
    }

    @Test
    public void successScenario3() {
        driver.get("http://itsovy.sk/testing");
        WebElement result = driver.findElement(By.id("result"));

        driver.manage().window().setSize(new Dimension(800, 600));
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).sendKeys("69420");
        driver.findElement(By.id("interest")).click();
        driver.findElement(By.id("interest")).sendKeys("20");

        for (int i = 0; i < 3; i++) {
            driver.findElement(By.id("period")).sendKeys(Keys.RIGHT);
        }

        driver.findElement(By.id("confirm")).click();
        driver.findElement(By.id("btnsubmit")).click();

        Assert.assertEquals(result.getText(), "Total amount : 125694.58 , net profit : 56274.58");
        Assert.assertEquals(result.getCssValue("color"), green);

    }
}
