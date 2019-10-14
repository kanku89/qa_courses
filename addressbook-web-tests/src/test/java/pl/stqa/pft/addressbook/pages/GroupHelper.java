package pl.stqa.pft.addressbook.pages;

import org.openqa.selenium.WebDriver;
import pl.stqa.pft.addressbook.model.GroupData;


public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver driver) {
    super(driver);
  }

  public void createNewGroup() {
    clickOnElement("name", "new");
  }

  public void fillNewGroup(GroupData groupData) {
    sendKeys("name", "group_name", groupData.getName());
    sendKeys("name", "group_header", groupData.getHeader());
    sendKeys("name", "group_footer", groupData.getFooter());
  }

  public void clearAllGroupData() {
    clearField("name", "group_name");
    clearField("name", "group_header");
    clearField("name", "group_footer");
  }

  public void returnToGroupPage() {
    clickOnElement("link", "group page");
  }

  public void clickOnUpdate() {
    clickOnElement("name", "update");
  }

  public void selectGroup() {
    clickOnElement("name", "selected[]");
  }

  public void removeGroup() {
    clickOnElement("name", "delete");
  }

  public void editGroup() {
    clickOnElement("name", "edit");
  }


}
