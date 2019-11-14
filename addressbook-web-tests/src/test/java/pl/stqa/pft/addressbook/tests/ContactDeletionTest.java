package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().goHome();
    if (!app.getGeneralHelper().isThereAnElement()) {
      app.getContactHelper().createNewContact(new ContactData().withFirstName("Just").withLastName("Random").withAddress("Words").withMobile("Words").withMail("for@test.com"));
    }
  }

  @Test
  public void testRemoveContact() {
    Contacts before = app.getContactHelper().all();

    ContactData deletedContact = before.iterator().next();
    app.getContactHelper().deleteContact(deletedContact);
    app.getNavigationHelper().goHome();
    app.getContactHelper().removeContact();
    app.acceptAlert();
    app.getNavigationHelper().goHome();
    app.getGeneralHelper().waiter();
    assertThat(app.getContactHelper().contactsCount(), equalTo(before.size() - 1));
    Contacts after = app.getContactHelper().all();

    assertThat(after, equalTo(before.without(deletedContact)));

  }

}