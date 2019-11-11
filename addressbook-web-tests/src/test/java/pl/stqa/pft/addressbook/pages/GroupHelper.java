package pl.stqa.pft.addressbook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;


public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver driver) {
    super(driver);
  }

  public void clickOnNewGroup() {
    clickOnElement("name", "new");
  }

  public void fillGroupForm(GroupData groupData) {
    sendText("name", "group_name", groupData.getName());
    sendText("name", "group_header", groupData.getHeader());
    sendText("name", "group_footer", groupData.getFooter());
  }

  public void returnToGroupPage() {
    clickOnElement("link", "group page");
  }

  public void clickOnUpdate() {
    clickOnElement("name", "update");
  }

  public void submitGroupForm() {
    clickOnElement("name", "submit");
  }

  public void removeGroup() {
    clickOnElement("name", "delete");
  }

  public void clickOnGroupUpdate() {
    clickOnElement("name", "edit");
  }

  public void createGroup(GroupData groupData) {
    clickOnNewGroup();
    fillGroupForm(groupData);
    submitGroupForm();
    returnToGroupPage();
  }

  public void modifyGroup(int index, GroupData group) {
    selectGroup(index);
    clickOnGroupUpdate();
    fillGroupForm(group);
    clickOnUpdate();
    returnToGroupPage();
  }

  public void deleteGroup(int index) {
    selectGroup(index);
    removeGroup();
    returnToGroupPage();
  }

  public void selectGroup(int index) {
    driver.findElements(getByType("name", "selected[]")).get(index).click();
  }

  public List<GroupData> getGroupList() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = driver.findElements(getByType("css", "span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      GroupData group = new GroupData(id, name, null, null);
      groups.add(group);
    }
    return groups;

  }

}
