package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;
import pl.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().goToGroups();
    Groups before = app.getGroupHelper().all();
    GroupData group = new GroupData().withName("Test2");
    app.getGroupHelper().createGroup(group);
    assertThat(app.getGroupHelper().groupsCount(), equalTo(before.size() + 1));
    Groups after = app.getGroupHelper().all();

    assertThat(after, equalTo(before
        .withAdded(group.withId(after.stream().mapToInt(GroupData::getId).max().getAsInt()))));

  }

}
