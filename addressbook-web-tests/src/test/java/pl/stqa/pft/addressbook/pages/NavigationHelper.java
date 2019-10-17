package pl.stqa.pft.addressbook.pages;

import org.openqa.selenium.WebDriver;


public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void goToGroups() {
    if (!isElementPresent("xpath", "//h1[.='Groups']") | !isElementPresent("name", "new")) {
      clickOnElement("link", "groups");
    }
  }

  public void addNewContact() {
    if (!isElementPresent("xpath", "//h1[.='Edit / add address book entry']")) {
      clickOnElement("link", "add new");
    }
  }

  public void goHome() {
    if (!isElementPresent("name", "MainForm")) {
      clickOnElement("link", "home");
    }
  }
}