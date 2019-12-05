package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;
import pl.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupUpdateTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.getNavigationHelper().goToGroups();
      app.getGroupHelper().createGroup(new GroupData().withName("Test 2"));
    }

  }

  @Test
  public void testUpdateGroup() {
    Groups before = app.db().groups();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
        .withId(modifiedGroup.getId())
        .withName("Name")
        .withHeader("Header")
        .withFooter("Footer");
    app.getNavigationHelper().goToGroups();
    app.getGroupHelper().modifyGroup(group);
//    assertThat(app.getGroupHelper().groupsCount(), equalTo(before));
    Groups after = app.db().groups();

    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));

    verificationGroupListInUI();
  }

}