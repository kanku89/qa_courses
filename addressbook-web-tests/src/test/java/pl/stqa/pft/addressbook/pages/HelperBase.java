package pl.stqa.pft.addressbook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;


public class HelperBase {

  protected WebDriver driver;

  public HelperBase(WebDriver driver) {
    this.driver = driver;
  }

  protected By getByType(String locator_type, String locator) {
    switch (locator_type) {
      case "id":
        return By.id(locator);
      case "xpath":
        return By.xpath(locator);
      case "css":
        return By.cssSelector(locator);
      case "class":
        return By.className(locator);
      case "link":
        return By.linkText(locator);
      default:
        return By.name(locator);
    }
  }

  protected void sendKeys(String locator_type, String locator, String text) {
    WebElement element = driver.findElement(getByType(locator_type, locator));

    try {
      element.sendKeys(text);
    } catch (WebDriverException e) {
      System.out.println("Cannot send keys to the field! Error: " + e);

    }
  }

  protected void clickOnElement(String locator_type, String locator) {
    WebElement element = driver.findElement(getByType(locator_type, locator));

    try {
      element.click();
    } catch (WebDriverException e) {
      System.out.println("Element is not clickable! Error: " + e);

    }
  }

  protected void clearField(String locator_type, String locator) {
    WebElement element = driver.findElement(getByType(locator_type, locator));

    try {
      element.clear();
    } catch (WebDriverException e) {
      System.out.println("Cannot clear field! Error: " + e);
    }
  }


}
