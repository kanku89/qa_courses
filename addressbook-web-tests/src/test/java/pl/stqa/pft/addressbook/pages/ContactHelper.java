package pl.stqa.pft.addressbook.pages;

import org.openqa.selenium.WebDriver;
import pl.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver driver) {
    super(driver);
  }

  public void fillContactData(ContactData contactData) {
    sendText("name", "firstname", contactData.getFirstName());
    sendText("name", "lastname", contactData.getLastName());
    sendText("name", "address", contactData.getAddress());
    sendText("name", "mobile", contactData.getMobile());
    sendText("name", "email", contactData.getMail());
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

  public void submitContactForm() {
    clickOnElement("name", "submit");
  }

  public void createNewContact(ContactData contactData) {
    fillContactData(contactData);
    submitContactForm();
    returnToHome();
  }
}
