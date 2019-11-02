package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactUpdateTest extends TestBase {

  @Test
  public void testUpdateContact() {
    app.getNavigationHelper().goHome();
    if (!app.getGeneralHelper().isThereAnElement()) {
      app.getContactHelper().createNewContact(new ContactData(0, "Just", "Random", "Words",
          "For", "Test"));
    }
    List<ContactData> before = app.getContactHelper().getContactsList();
    app.getContactHelper().editContact();
    ContactData contact = new ContactData(0, "New First Name", "New Last Name",
        "New Address", "987654321", "mail2@mail.com");
    app.getContactHelper().fillContactData(contact);
    app.getContactHelper().updateContact();
    app.getContactHelper().returnToHome();
    List<ContactData> after = app.getContactHelper().getContactsList();

    Assert.assertEquals(after.size(), before.size());

    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    Comparator<? super ContactData> byFirstName = (g1, g2) -> CharSequence.compare(g1.getFirstName(), g2.getFirstName());
    Comparator<? super ContactData> byLastName = (g1, g2) -> CharSequence.compare(g1.getLastName(), g2.getLastName());
    before.sort(byLastName);
    after.sort(byLastName);
    Assert.assertEquals(before, after);

  }

}