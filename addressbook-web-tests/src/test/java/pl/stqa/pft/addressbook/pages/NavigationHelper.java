package pl.stqa.pft.addressbook.pages;

import org.openqa.selenium.WebDriver;


public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void goToGroups() {
    clickOnElement("link", "groups");
  }

  public void addNewContact() {
    clickOnElement("link", "add new");
  }

  public void goHome() {
    clickOnElement("link", "home");
  }

}
