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
    if (app.db().groups().size() == 0) {
      app.getNavigationHelper().goToGroups();
      app.getGroupHelper().createGroup(new GroupData().withName("Test 1"));
    }

  }

  @Test
  public void testRemoveGroup() {
    Groups before = app.db().groups();
    GroupData deletedGroup = before.iterator().next();
    app.getNavigationHelper().goToGroups();
    app.getGroupHelper().deleteGroup(deletedGroup);
    assertThat(app.getGroupHelper().groupsCount(), equalTo(before.size() - 1));
    Groups after = app.db().groups();

    assertThat(after, equalTo(before.without(deletedGroup)));

  }

}