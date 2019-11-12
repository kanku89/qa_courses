package pl.stqa.pft.addressbook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.stqa.pft.addressbook.model.GroupData;
import pl.stqa.pft.addressbook.model.Groups;

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

  public void modifyGroup(GroupData group) {
    selectGroupById(group.getId());
    clickOnGroupUpdate();
    fillGroupForm(group);
    clickOnUpdate();
    returnToGroupPage();
  }

  public void deleteGroup(GroupData group) {
    selectGroupById(group.getId());
    removeGroup();
    returnToGroupPage();
  }

  public void selectGroupById(int id) {
    driver.findElement(getByType("css", "input[value='" + id + "'")).click();
  }

  public Groups all() {
    Groups groups = new Groups();
    List<WebElement> elements = driver.findElements(getByType("css", "span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groups.add(new GroupData().withId(id).withName(name));
    }
    return groups;
  }

}
