package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactUpdateTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().goHome();
    if (!app.getGeneralHelper().isThereAnElement()) {
      app.getContactHelper().createNewContact(new ContactData(0, "Just", "Random", "Words",
          "For", "Test"));
    }
  }

  @Test
  public void testUpdateContact() {
    List<ContactData> before = app.getContactHelper().getContactsList();
    ContactData contact = new ContactData(0, "New First Name", "New Last Name",
        "New Address", "987654321", "mail2@mail.com");
    app.getContactHelper().modifyContact(contact);
    List<ContactData> after = app.getContactHelper().getContactsList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.get(0));
    before.add(contact);

    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    Comparator<? super ContactData> byFirstName = (g1, g2) -> CharSequence.compare(g1.getFirstName(), g2.getFirstName());
    Comparator<? super ContactData> byLastName = (g1, g2) -> CharSequence.compare(g1.getLastName(), g2.getLastName());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }



}