import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class FailedScenariosTest {

    private WebDriver driver;
    JavascriptExecutor js;
    String red = "rgba(255, 0, 0, 1)";
    String interestError = "Interest must be a number between 0 and 100 !";
    String amountError = "Amount must be a number between 0 and 1000000 !";
    String confirmError = "You must agree to the processing !";

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
     * Amount out of bounds
     */
    @Test
    public void failedScenario1() {
        driver.get("http://itsovy.sk/testing/");
        WebElement error = driver.findElement(By.id("error"));

        driver.manage().window().setSize(new Dimension(800, 600));
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).sendKeys("1000000000");
        driver.findElement(By.id("interest")).click();
        driver.findElement(By.id("interest")).sendKeys("20");
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.id("period")).sendKeys(Keys.RIGHT);
        }
        driver.findElement(By.id("confirm")).click();
        driver.findElement(By.id("btnsubmit")).click();

        Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.getCssValue("color"), red);
        Assert.assertEquals(error.getText(), amountError);

    }

    /**
     * Negative Amount Given Error
     */
    @Test
    public void failedScenario2() {
        driver.get("http://itsovy.sk/testing/");
        WebElement error = driver.findElement(By.id("error"));

        driver.manage().window().setSize(new Dimension(800, 600));
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).sendKeys("-598165");
        driver.findElement(By.id("interest")).click();
        driver.findElement(By.id("interest")).sendKeys("10");
        for (int i = 0; i < 1; i++) {
            driver.findElement(By.id("period")).sendKeys(Keys.RIGHT);
        }
        driver.findElement(By.id("confirm")).click();
        driver.findElement(By.id("btnsubmit")).click();

        Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.getCssValue("color"), red);
        Assert.assertEquals(error.getText(), amountError);
    }


    /**
     * No confirm
     */
    @Test
    public void failedScenario3() {
        driver.get("http://itsovy.sk/testing/");
        WebElement error = driver.findElement(By.id("error"));

        driver.manage().window().setSize(new Dimension(800, 600));
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).sendKeys("10658");
        driver.findElement(By.id("interest")).click();
        driver.findElement(By.id("interest")).sendKeys("10");

        for (int i = 0; i < 1; i++) {
            driver.findElement(By.id("period")).sendKeys(Keys.RIGHT);
        }

        driver.findElement(By.id("btnsubmit")).click();

        Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.getCssValue("color"), red);
        Assert.assertEquals(error.getText(), confirmError);

    }

    /**
     * Interest over 100
     */
    @Test
    public void failedScenario4() {
        driver.get("http://itsovy.sk/testing/");
        WebElement error = driver.findElement(By.id("error"));

        driver.manage().window().setSize(new Dimension(800, 600));
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).sendKeys("10658");
        driver.findElement(By.id("interest")).click();
        driver.findElement(By.id("interest")).sendKeys("1000");

        for (int i = 0; i < 2; i++) {
            driver.findElement(By.id("period")).sendKeys(Keys.RIGHT);
        }

        driver.findElement(By.id("confirm")).click();
        driver.findElement(By.id("btnsubmit")).click();

        Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.getCssValue("color"), red);
        Assert.assertEquals(error.getText(), interestError);

    }

    /**
     * Negative Interest
     */
    @Test
    public void failedScenario5() {
        driver.get("http://itsovy.sk/testing/");
        WebElement error = driver.findElement(By.id("error"));

        driver.manage().window().setSize(new Dimension(800, 600));
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).sendKeys("10658");
        driver.findElement(By.id("interest")).click();
        driver.findElement(By.id("interest")).sendKeys("-1000");

        for (int i = 0; i < 4; i++) {
            driver.findElement(By.id("period")).sendKeys(Keys.RIGHT);
        }

        driver.findElement(By.id("confirm")).click();
        driver.findElement(By.id("btnsubmit")).click();

        Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.getCssValue("color"), red);
        Assert.assertEquals(error.getText(), interestError);
    }








}
