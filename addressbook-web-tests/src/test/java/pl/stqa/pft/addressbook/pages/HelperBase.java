package pl.stqa.pft.addressbook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


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
    driver.findElement(getByType(locator_type, locator)).sendKeys(text);
  }

  protected void clickOnElement(String locator_type, String locator) {
    driver.findElement(getByType(locator_type, locator)).click();

  }
}
