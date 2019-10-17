package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testRemoveContact() {
    app.getNavigationHelper().goHome();
    if(!app.getGeneralHelper().isThereAnElement()) {
      app.getContactHelper().createNewContact(new ContactData("This is", "Random text",
          "For precondition", "Form", "Left Mail"));
    }
    app.getGeneralHelper().markCheckbox();
    app.getContactHelper().removeContact();
    app.acceptAlert();
  }

}