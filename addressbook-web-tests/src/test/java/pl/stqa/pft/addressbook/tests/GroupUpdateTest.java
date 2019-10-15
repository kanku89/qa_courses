package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;

public class GroupUpdateTest extends TestBase {

  @Test
  public void testRemoveGroup() {
    app.getNavigationHelper().goToGroups();
    app.getGeneralHelper().markCheckbox();
    app.getGroupHelper().editGroup();
    app.getGroupHelper().clearAllGroupData();
    app.getGroupHelper().fillNewGroup(new GroupData("This is totally new group", "This is group Header", "This is group footer"));
    app.getGroupHelper().clickOnUpdate();
    app.getGroupHelper().returnToGroupPage();
  }

}