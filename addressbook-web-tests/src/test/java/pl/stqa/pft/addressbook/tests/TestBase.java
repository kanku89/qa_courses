package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.stqa.pft.addressbook.pages.NewGroup;

public class TestBase {

  protected final NewGroup addGroup = new NewGroup();

  @BeforeMethod(alwaysRun = true)
    public void setUp() {
      addGroup.init();

    }

  @AfterMethod(alwaysRun = true)
    public void tearDown() {
      addGroup.stop();

    }

}
