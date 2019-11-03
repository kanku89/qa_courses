package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test
  public void testNewContact() {
    app.getNavigationHelper().goHome();
    List<ContactData> before = app.getContactHelper().getContactsList();
    app.getNavigationHelper().addNewContact();
    ContactData contact = new ContactData(0, "First Name", "Last Name",
        "Address", "123456789", "mail@mail.com");
    app.getContactHelper().createNewContact(contact);
    List<ContactData> after = app.getContactHelper().getContactsList();

    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    Comparator<? super ContactData> byFirstName = (g1, g2) -> CharSequence.compare(g1.getFirstName(), g2.getFirstName());
    Comparator<? super ContactData> byLastName = (g1, g2) -> CharSequence.compare(g1.getLastName(), g2.getLastName());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }


}