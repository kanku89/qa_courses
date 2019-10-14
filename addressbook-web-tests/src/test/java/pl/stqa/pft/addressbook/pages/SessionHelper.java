package pl.stqa.pft.addressbook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver driver) {
    super(driver);
  }

  public void login(String user, String password) {
    sendKeys("name","user", user);
    sendKeys("name", "pass", password);
    driver.findElement(By.xpath("//form//input[@value='Login']")).click();
  }
}
