package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

public class ContactUpdateTest extends TestBase {

  @Test
  public void testUpdateContact() {
    app.getNavigationHelper().goHome();
    app.getContactHelper().editContact();
    app.getContactHelper().clearAllContactData();
    app.getContactHelper().fillContactData(new ContactData("New First Name", "New Last Name", "New Address", "New Mobile", "New Email"));
    app.getContactHelper().updateContact();
    app.getContactHelper().returnToHome();
  }

}