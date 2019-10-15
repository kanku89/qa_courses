package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testRemoveGroup() {
    app.getNavigationHelper().goHome();
    app.getGeneralHelper().markCheckbox();
    app.getContactHelper().removeContact();
    app.acceptAlert();
  }

}