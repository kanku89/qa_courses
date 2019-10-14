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

  public void returnToGroupPage() {
    clickOnElement("link", "group page");
  }

  public void selectGroup() {
    clickOnElement("name", "selected[]");
  }

  public void removeGroup() {
    clickOnElement("name", "delete");
  }


}
