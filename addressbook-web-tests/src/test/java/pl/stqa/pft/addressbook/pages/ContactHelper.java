package pl.stqa.pft.addressbook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
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

  public void selectContact(int index) {
    driver.findElements(getByType("name", "selected[]")).get(index).click();
  }

  public List<ContactData> getContactsList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = driver.findElements(getByType("name", "entry"));
    for (WebElement element : elements) {
      String FIRST_NAME = element.findElement(getByType("xpath", ".//td[3]")).getText();
      String LAST_NAME = element.findElement(getByType("xpath", ".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      ContactData contact = new ContactData(id, FIRST_NAME, LAST_NAME, null, null, null);
      contacts.add(contact);
    }
    return contacts;

  }
}
