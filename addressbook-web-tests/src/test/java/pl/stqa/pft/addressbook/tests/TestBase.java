package pl.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pl.stqa.pft.addressbook.model.GroupData;
import pl.stqa.pft.addressbook.model.Groups;
import pl.stqa.pft.addressbook.pages.ApplicationManager;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestBase {
  Logger logger = LoggerFactory.getLogger(GroupCreationTests.class);


  protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws IOException {
    app.init();

  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();

  }

  @BeforeMethod
  public void logTestStart(Method m) {
    logger.info("Start test " + m.getName());
  }

  @AfterMethod
  public void logTestStop(Method m) {
    logger.info("Stop test " + m.getName());
  }

  public void verificationGroupListInUI() {
    if (Boolean.getBoolean("verifyUI")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.getGroupHelper().all();
      assertThat(uiGroups, equalTo(dbGroups.stream()
          .map(g -> new GroupData().withId(g.getId()).withName(g.getName()))
          .collect(Collectors.toSet())));

    }
  }

}
