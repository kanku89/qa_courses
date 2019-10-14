package pl.stqa.pft.addressbook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver driver) {
    super(driver);
  }

  public void returnToGroupPage() {
    driver.findElement(By.linkText("group page")).click();
  }

  public void submitGroupCreation() {
    driver.findElement(By.name("submit")).click();
  }

  public void fillNewGroup(GroupData groupData) {
    sendKeys("name", "group_name", groupData.getName());
    sendKeys("name", "group_header", groupData.getHeader());
    sendKeys("name", "group_footer", groupData.getFooter());
  }

  public void createNewGroup() {
    driver.findElement(By.name("new")).click();
  }
}
