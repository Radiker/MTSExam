package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.ProjectConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BaseWebTest {

    public static final ProjectConfig cfg = ConfigFactory.create(ProjectConfig.class);

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "http://localhost:4444/wd/hub";
        //DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("enableVNC", true);
        //capabilities.setCapability("enableVideo", true);
        //Configuration.browserCapabilities = capabilities;
        Configuration.pageLoadTimeout = 180000;
    }

    @After
    public void afterTest() {
        Selenide.closeWebDriver();
    }

}
