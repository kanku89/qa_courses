package pl.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pl.stqa.pft.manits.appmanager.ApplicationManager;

import java.io.IOException;


public class TestBase {


  protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws IOException {
    app.init();

  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();

  }


}
