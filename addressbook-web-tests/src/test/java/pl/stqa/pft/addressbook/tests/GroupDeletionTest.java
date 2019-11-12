package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;
import pl.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().goToGroups();
    if (!app.getGeneralHelper().isThereAnElement()) {
      app.getGroupHelper().createGroup(new GroupData().withName("Test 1"));
    }
  }

  @Test
  public void testRemoveGroup() {
    Groups before = app.getGroupHelper().all();
    GroupData deletedGroup = before.iterator().next();
    app.getGroupHelper().deleteGroup(deletedGroup);
    Groups after = app.getGroupHelper().all();
    assertThat(after.size(), equalTo(before.size() - 1));

    assertThat(before, equalTo(before.without(deletedGroup)));

  }

}