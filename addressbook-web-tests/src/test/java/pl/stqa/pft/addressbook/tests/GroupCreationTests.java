package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().goToGroups();
    app.getGroupHelper().createGroup(new GroupData("This is new group", "This is header", "This is footer"));
  }

}
