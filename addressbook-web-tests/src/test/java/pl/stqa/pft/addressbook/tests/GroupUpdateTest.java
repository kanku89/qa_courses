package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;

public class GroupUpdateTest extends TestBase {

  @Test
  public void testUpdateGroup() {
    app.getNavigationHelper().goToGroups();
    if (!app.getGeneralHelper().isThereAnElement()) {
      app.getGroupHelper().createGroup(new GroupData("Send keys test", "For a", "Test"));
    }
    app.getGeneralHelper().markCheckbox();
    app.getGroupHelper().clickOnGroupUpdate();
    app.getGroupHelper().fillGroupForm(new GroupData("Send keys test", "with a description", "and something"));
    app.getGroupHelper().clickOnUpdate();
    app.getGroupHelper().returnToGroupPage();
  }

}