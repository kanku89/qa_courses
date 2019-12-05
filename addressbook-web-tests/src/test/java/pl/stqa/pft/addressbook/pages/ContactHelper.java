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

  public void addContactToGroup(ContactData contact) {
    selectContactById(contact.getId());
    toGroupButton();
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

  private Contacts contactsCache = null;

  public void createNewContact(ContactData contactData) {
    fillContactData(contactData);
    submitContactForm();
    contactsCache = null;
    returnToHome();
  }

  public void toGroupButton() {
    clickOnElement("name", "add");
  }

  public void modifyContact(ContactData contact) {
    editContact();
    fillContactData(contact);
    updateContact();
    contactsCache = null;
    returnToHome();
  }

  public void deleteContact(ContactData contact) {
    selectContactById(contact.getId());
    removeContact();
    contactsCache = null;
  }

  public int contactsCount() {
    return driver.findElements(By.name("selected[]")).size();
  }

  public void selectContactById(int id) {
    driver.findElement(getByType("css", "input[value='" + id + "'")).click();
  }

  public Contacts all() {
    if (contactsCache != null) {
      return new Contacts(contactsCache);
    }
    contactsCache = new Contacts();
    List<WebElement> rows = driver.findElements(getByType("name", "entry"));
    for (WebElement row : rows) {
      String FIRST_NAME = row.findElement(getByType("xpath", ".//td[3]")).getText();
      String LAST_NAME = row.findElement(getByType("xpath", ".//td[2]")).getText();
      String ADDRESS = row.findElement(getByType("xpath", ".//td[4]")).getText();
      String ALL_MAILS = row.findElement(getByType("xpath", ".//td[5]")).getText();
      String ALL_PHONES = row.findElement(getByType("xpath", ".//td[6]")).getText();
      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("id"));
      contactsCache.add(new ContactData()
          .withId(id)
          .withFirstName(FIRST_NAME)
          .withLastName(LAST_NAME)
          .withAddress(ADDRESS)
          .withAllMails(ALL_MAILS)
          .withAllPhones(ALL_PHONES)
          .withAllData(ALL_MAILS)
      );
    }
    return new Contacts(contactsCache);

  }

  public ContactData infoFromForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstName = driver.findElement(By.name("firstname")).getAttribute("value");
    String lastName = driver.findElement(By.name("lastname")).getAttribute("value");
    String home = driver.findElement(By.name("home")).getAttribute("value");
    String mobile = driver.findElement(By.name("mobile")).getAttribute("value");
    String work = driver.findElement(By.name("phone2")).getAttribute("value");
    String address = driver.findElement(By.name("address")).getAttribute("value");
    String address2 = driver.findElement(By.name("address2")).getAttribute("value");
    String mail = driver.findElement(By.name("email")).getAttribute("value");
    String mail2 = driver.findElement(By.name("email2")).getAttribute("value");
    String mail3 = driver.findElement(By.name("email3")).getAttribute("value");
    driver.navigate().back();
    return new ContactData()
        .withId(contact.getId())
        .withFirstName(firstName)
        .withLastName(lastName)
        .withAddress(address)
        .withAddress2(address2)
        .withMail(mail)
        .withMail2(mail2)
        .withMail3(mail3)
        .withHomePhone(home)
        .withMobile(mobile)
        .withWorkPhone(work);
  }

  public String infoFromProfile(ContactData contact) {
    initContactProfileById(contact.getId());
    String profileData = driver.findElement(By.id("content")).getText();
    driver.navigate().back();
    return profileData;

  }


  private void initContactModificationById(int id) {
    driver.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
  }

  public void initContactProfileById(int id) {
    driver.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[7]/a", id))).click();
  }

  private void initContactProfileUpdate() {
    driver.findElement(By.name("modifiy")).click();
  }

}
