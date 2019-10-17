package pl.stqa.pft.addressbook.pages;

import org.openqa.selenium.*;

import java.util.logging.Logger;


public class HelperBase {


  private static final Logger LOGGER = Logger.getLogger(HelperBase.class.getName());

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

  protected WebElement getElement(String locator_type, String locator) {
    WebElement element = null;
    try {
      element = driver.findElement(getByType(locator_type, locator));
    } catch (NoSuchElementException | ElementNotVisibleException |
        ElementNotSelectableException e) {
      LOGGER.info("Element not found with locator {locator}, error " + e);
    }
    return element;
  }

  protected boolean isElementPresent(String locator_type, String locator) {
    try {
      WebElement element = getElement(locator_type, locator);
      if (element != null) {
        return true;
      } else {
        LOGGER.info("Element not present with locator {locator}");
        return false;
      }
    } catch (WebDriverException e) {
      LOGGER.info("Element not found, error " + e);
      return false;
    }
  }

  protected void sendKeys(String locator_type, String locator, String text) {
    WebElement element = driver.findElement(getByType(locator_type, locator));
    String existingText = getText(locator_type, locator);

    if (!existingText.equals(text)) {
      try {
        element.sendKeys(text);
      } catch (WebDriverException e) {
        System.out.println("Cannot send keys to the field! Error: " + e);
      }
    }
  }

  protected void clickOnElement(String locator_type, String locator) {
    WebElement element = driver.findElement(getByType(locator_type, locator));

    try {
      element.click();
    } catch (WebDriverException e) {
      LOGGER.info("Element is not clickable! Error: " + e);
    }
  }

  protected void clearField(String locator_type, String locator) {
    WebElement element = driver.findElement(getByType(locator_type, locator));

    try {
      element.clear();
    } catch (WebDriverException e) {
      LOGGER.info("Cannot clear field! Error: " + e);
    }
  }

  protected String getText(String locator_type, String locator) {
    String text = null;
    WebElement element = null;
    try {
      if (locator != null) {
        element = getElement(locator_type, locator);
        text = element.getAttribute("value");
      }
      if (text.length() == 0) {
        text = element.getAttribute("innerText");
      }

    } catch (WebDriverException e) {
      LOGGER.info("Text not found in locator {locator}. Error: " + e);
    }
    return text;
  }
}
