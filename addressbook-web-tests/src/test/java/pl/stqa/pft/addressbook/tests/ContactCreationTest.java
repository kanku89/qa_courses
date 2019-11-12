package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactCreationTest extends TestBase {

  @Test
  public void testNewContact() {
    app.getNavigationHelper().goHome();
    Contacts before = app.getContactHelper().all();
    app.getNavigationHelper().addNewContact();
    ContactData contact = new ContactData()
        .withFirstName("First Name")
        .withLastName("Last Name")
        .withAddress("Address")
        .withMobile("123456789")
        .withMail("mail@mail.com");
    app.getContactHelper().createNewContact(contact);
    Contacts after = app.getContactHelper().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(before, equalTo(after.withAdded(contact)));


  }

}