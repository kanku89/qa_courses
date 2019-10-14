package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;


public class ContactCreationTest extends TestBase {

  @Test
  public void testNewContact() {
    app.getNavigationHelper().addNewContact();
    app.getContactHelper().fillContactData(new ContactData("First Name", "Last Name", "Address", "Mobile", "Mail"));
    app.getGeneralHelper().submitForm();
    app.getContactHelper().returnToHome();
  }


}