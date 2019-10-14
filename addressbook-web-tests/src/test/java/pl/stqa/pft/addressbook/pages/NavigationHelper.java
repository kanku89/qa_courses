package pl.stqa.pft.addressbook.pages;

import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void goToGroups() {
    clickOnElement("link", "groups");
    }
}
