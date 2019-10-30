package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupUpdateTest extends TestBase {

  @Test
  public void testUpdateGroup() {
    app.getNavigationHelper().goToGroups();
    if (!app.getGeneralHelper().isThereAnElement()) {
      app.getGroupHelper().createGroup(new GroupData("Send keys test", "For a", "Test"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().clickOnGroupUpdate();
    app.getGroupHelper().fillGroupForm(new GroupData(null, "with a description", null));
    app.getGroupHelper().clickOnUpdate();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(before.size(), after.size());

  }

}