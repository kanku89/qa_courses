package pl.stqa.pft.addressbook.pages;

import org.openqa.selenium.WebDriver;


public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver driver) {
    super(driver);
  }

  public void login(String user, String password) {
    sendText("name", "user", user);
    sendText("name", "pass", password);
    clickOnElement("xpath", "//form//input[@value='Login']");
  }
}
