package qa.msl.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import qa.msl.pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

  RegistrationPage registrationPage = new RegistrationPage();

  @BeforeAll
  static void setUp() {
    Configuration.browserSize = "1920x1080";
    Configuration.pageLoadStrategy = "eager";
    Configuration.baseUrl = "https://demoqa.com/";
    Configuration.browser = "chrome";
    Configuration.timeout = 5000; //default 4000
  }

  @AfterEach
  void tearDown() {
    closeWebDriver();
  }

}
