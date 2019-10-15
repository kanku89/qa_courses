package pl.stqa.pft.addressbook.pages;

import org.openqa.selenium.WebDriver;
import pl.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver driver) {
    super(driver);
  }

  public void fillContactData(ContactData contactData) {
    sendKeys("name", "firstname", contactData.getFirstName());
    sendKeys("name", "lastname", contactData.getLastName());
    sendKeys("name", "address", contactData.getAddress());
    sendKeys("name", "mobile", contactData.getMobile());
    sendKeys("name", "email", contactData.getMail());
  }

  public void returnToHome() {
    clickOnElement("link", "home page");
  }

  public void removeContact() {
    clickOnElement("xpath", "//form//input[@value='Delete']");
  }

}
