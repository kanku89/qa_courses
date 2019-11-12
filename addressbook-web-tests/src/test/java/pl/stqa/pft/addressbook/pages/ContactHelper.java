package pl.stqa.pft.addressbook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;

import java.util.List;

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

  public void modifyContact(ContactData contact) {
    editContact();
    fillContactData(contact);
    updateContact();
    returnToHome();
  }

  public void deleteContact(ContactData contact) {
    selectContactById(contact.getId());
    removeContact();
    returnToHome();
  }

  public void selectContactById(int id) {
    driver.findElement(getByType("css", "input[value='" + id + "'")).click();
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = driver.findElements(getByType("name", "entry"));
    for (WebElement element : elements) {
      String FIRST_NAME = element.findElement(getByType("xpath", ".//td[3]")).getText();
      String LAST_NAME = element.findElement(getByType("xpath", ".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      contacts.add(new ContactData().withId(id).withFirstName(FIRST_NAME).withLastName(LAST_NAME));
    }
    return contacts;

  }

}
