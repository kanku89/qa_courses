package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testRemoveGroup() {
    app.getNavigationHelper().goToGroups();
    if (!app.getGeneralHelper().isThereAnElement()) {
      app.getGroupHelper().createGroup(new GroupData("Just", "For a", "Test"));
    }
    app.getGeneralHelper().markCheckbox();
    app.getGroupHelper().removeGroup();
    app.getGroupHelper().returnToGroupPage();
  }

}