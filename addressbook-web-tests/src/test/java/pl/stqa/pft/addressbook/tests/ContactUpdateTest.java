package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactUpdateTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.getNavigationHelper().goHome();
      app.getContactHelper().createNewContact(new ContactData().withFirstName("Just").withLastName("Random").withAddress("Words").withMobile("Words").withMail("for@test.com"));
    }

  }

  @Test
  public void testUpdateContact() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
        .withId(modifiedContact.getId())
        .withFirstName("New First Name")
        .withLastName("New Last Name")
        .withAddress("New Address")
        .withMobile("987654321")
        .withMail("mail2@mail.com");
    app.getContactHelper().modifyContact(contact);
//    assertThat(app.getContactHelper().contactsCount(), equalTo(before.size()));
    Contacts after = app.db().contacts();

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }


}