package pl.stqa.pft.addressbook.pages;

import org.openqa.selenium.WebDriver;
import pl.stqa.pft.addressbook.model.GroupData;


public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver driver) {
    super(driver);
  }

  public void clickOnNewGroup() {
    clickOnElement("name", "new");
  }

  public void fillGroupForm(GroupData groupData) {
    clearField("name", "group_name");
    sendKeys("name", "group_name", groupData.getName());
    clearField("name", "group_header");
    sendKeys("name", "group_header", groupData.getHeader());
    clearField("name", "group_footer");
    sendKeys("name", "group_footer", groupData.getFooter());
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

}
