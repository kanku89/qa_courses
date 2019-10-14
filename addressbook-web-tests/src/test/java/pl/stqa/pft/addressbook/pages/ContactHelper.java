package pl.stqa.pft.addressbook.pages;

import org.openqa.selenium.WebDriver;
import pl.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver driver) {
    super(driver);
  }

  public void fillContactData(ContactData contactData){
    sendKeys("name", "xx", contactData.getFirstName());
    sendKeys("name", "xx", contactData.getLastName());
    sendKeys("name", "xx", contactData.getAddress());
    sendKeys("name", "xx", contactData.getMobile());
    sendKeys("name", "xx", contactData.getMail());
  }

  public void returnToHome() {
    clickOnElement("name", "home page");
  }

}
