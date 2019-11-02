package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testRemoveContact() {
    app.getNavigationHelper().goHome();
    if(!app.getGeneralHelper().isThereAnElement()) {
      app.getContactHelper().createNewContact(new ContactData(0, "This is", "Random text",
          "For precondition", "Form", "Left Mail"));
    }
    List<ContactData> before = app.getContactHelper().getContactsList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().removeContact();
    app.acceptAlert();
    app.getNavigationHelper().goHome();

    List<ContactData> after = app.getContactHelper().getContactsList();

    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() -1);

    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    Comparator<? super ContactData> byFirstName = (g1, g2) -> CharSequence.compare(g1.getFirstName(), g2.getFirstName());
    Comparator<? super ContactData> byLastName = (g1, g2) -> CharSequence.compare(g1.getLastName(), g2.getLastName());
    before.sort(byLastName);
    after.sort(byLastName);
    Assert.assertEquals(before, after);
  }

}