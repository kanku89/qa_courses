package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactUpdateTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().goHome();
    if (!app.getGeneralHelper().isThereAnElement()) {
      app.getContactHelper().createNewContact(new ContactData().withFirstName("Just").withLastName("Random").withAddress("Words").withMobile("Words").withMail("for@test.com"));
    }
  }

  @Test
  public void testUpdateContact() {
    Contacts before = app.getContactHelper().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
        .withId(modifiedContact.getId())
        .withFirstName("New First Name")
        .withLastName("New Last Name")
        .withAddress("New Address")
        .withMobile("987654321")
        .withMail("mail2@mail.com");
    app.getContactHelper().modifyContact(contact);
    Contacts after = app.getContactHelper().all();
    Assert.assertEquals(after.size(), before.size());
    assertThat(after.size(), equalTo(before.size()));

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

  }


}