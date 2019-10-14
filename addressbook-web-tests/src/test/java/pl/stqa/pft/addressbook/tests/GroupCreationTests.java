package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().goToGroups();
    app.getGroupHelper().createNewGroup();
    app.getGroupHelper().fillNewGroup(new GroupData("Send keys test", "with a description", "and something"));
    app.getGeneralHelper().submitForm();
    app.getGroupHelper().returnToGroupPage();
  }

}
