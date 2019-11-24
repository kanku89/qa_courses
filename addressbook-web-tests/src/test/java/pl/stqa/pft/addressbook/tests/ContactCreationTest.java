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
//    File photo = new File();
    ContactData contact = new ContactData()
        .withFirstName("First Name")
        .withLastName("Last Name")
        .withAddress("Address")
        .withMobile("123456789")
        .withMail("mail@mail.com");
//        .withPhoto(photo);
    app.getContactHelper().createNewContact(contact);
    assertThat(app.getContactHelper().contactsCount(), equalTo(before.size() + 1));
    Contacts after = app.getContactHelper().all();
    assertThat(after, equalTo(before.withAdded(contact)));
  }

}