package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testRemoveGroup() {
    app.getNavigationHelper().goToGroups();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().removeGroup();
    app.getGroupHelper().returnToGroupPage();
  }

}