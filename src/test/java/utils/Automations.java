package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import java.time.Duration;

public class Automations {

    private static WebDriver driver;
    private static WebDriverWait waits;

    //initiate the driver
    public static void init(WebDriver inputDriver){
        driver = inputDriver;
        waits = new WebDriverWait(inputDriver, Duration.ofSeconds(10));
    }

    public static void type(By locator, String text){
        WebElement element = waits.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(text);
    }

    public static void click(By locator){
        WebElement element = waits.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
    }

    public static void visit(String url){
        driver.get(url);
    }

    public static void sleep(int sec) {
        try{
            Thread.sleep(sec * 1000);
        }catch (InterruptedException ignore) {
            // DO NOTHING
        }
    }

    public static WebElement findElement(By locator) {
        WebElement elem = waits.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return elem;
    }

    //highlight an element on the page
    public static void highlight(By locator) {
        WebElement element = findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid red;');", element);
    }

    //switch iframe
    public static void frameClick(By frameLocation, By locator) {
        WebElement frame = findElement(frameLocation);
        driver.switchTo().frame(frame);
        click(locator);
        driver.switchTo().defaultContent();
        sleep(1);
    }

    //verify if element is visible and highlight it
    public static boolean isVisible(By locator) {
        WebElement elem = waits.until(ExpectedConditions.visibilityOfElementLocated(locator));
        highlight(locator);
        return elem.isDisplayed();
    }

}
