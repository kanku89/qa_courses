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
    app.getNavigationHelper().goToGroups();
    if (!app.getGeneralHelper().isThereAnElement()) {
      app.getGroupHelper().createGroup(new GroupData().withName("Test 2"));
    }
  }

  @Test
  public void testUpdateGroup() {
    Groups before = app.getGroupHelper().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
        .withId(modifiedGroup.getId())
        .withName("Name")
        .withHeader("Header")
        .withFooter("Footer");
    app.getGroupHelper().modifyGroup(group);
    Groups after = app.getGroupHelper().all();
    assertThat(before, equalTo(after));

    assertThat(before, equalTo(before.without(modifiedGroup).withAdded(group)));

  }

}