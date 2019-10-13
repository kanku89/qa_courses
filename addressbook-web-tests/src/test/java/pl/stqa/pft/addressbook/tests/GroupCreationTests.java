package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    addGroup.goToGroups();
    addGroup.createNewGroup();
    addGroup.fillNewGroup(new GroupData("This is a group", "test", "test"));
    addGroup.submitGroupCreation();
    addGroup.goToGroupPage();
  }

}
