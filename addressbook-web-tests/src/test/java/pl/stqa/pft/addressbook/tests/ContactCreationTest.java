package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;


public class ContactCreationTest extends TestBase {

  @Test
  public void testNewContact() {
    app.getNavigationHelper().addNewContact();
    app.getContactHelper().createNewContact(new ContactData("First Name", "Last Name",
        "Address", "123456789", "mail@mail.com"));

  }


}