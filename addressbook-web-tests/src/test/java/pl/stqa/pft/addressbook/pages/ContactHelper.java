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

  public void clearAllContactData() {
    clearField("name", "firstname");
    clearField("name", "lastname");
    clearField("name", "address");
    clearField("name", "mobile");
    clearField("name", "email");
  }

  public void returnToHome() {
    clickOnElement("link", "home page");
  }

  public void removeContact() {
    clickOnElement("xpath", "//form//input[@value='Delete']");
  }

  public void editContact() {
    clickOnElement("xpath", "//form//a[contains(@href,'edit')]");
  }

  public void updateContact() {
    clickOnElement("name", "update");
  }

}
