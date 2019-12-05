package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;
import pl.stqa.pft.addressbook.model.GroupData;
import pl.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroupTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.getNavigationHelper().goHome();
      app.getContactHelper().createNewContact(new ContactData().withFirstName("Just").withLastName("Random").withAddress("Words").withMobile("Words").withMail("for@test.com"));
    }
    if (app.db().groups().size() == 0) {
      app.getNavigationHelper().goToGroups();
      app.getGroupHelper().createGroup(new GroupData().withName("Test 1"));
    }

  }

  @Test
  public void testAddContactToGroup() {
    Contacts before = app.db().contacts();
    ContactData contact = before.iterator().next();
    Groups beforeAdd = contact.getGroups();
    app.getNavigationHelper().goHome();
    app.getContactHelper().addContactToGroup(contact);
    Groups afterAdd = contact.getGroups();

    app.getContactHelper().modifyContact(contact);
    assertThat(afterAdd.size(), equalTo(beforeAdd.size() + 1));

  }
}
