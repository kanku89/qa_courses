package pl.stqa.pft.addressbook.pages;

import org.openqa.selenium.WebDriver;


public class GeneralHelper extends HelperBase {

  public GeneralHelper(WebDriver driver) {
    super(driver);
  }

  public void submitForm() {
    clickOnElement("name", "submit");
  }

  public void markCheckbox() {
    clickOnElement("name", "selected[]");
  }

  public boolean isThereAnElement() {
    return isElementPresent("name", "selected[]");
  }

}