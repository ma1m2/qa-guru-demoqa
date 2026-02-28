package qa.msl.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import qa.msl.pages.RegistrationPage;
import qa.msl.pages.TextBoxPage;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

  TextBoxPage textBoxPage = new TextBoxPage();
  RegistrationPage registrationPage = new RegistrationPage();

  @BeforeAll
  static void setUp() {
    Configuration.browserSize = "1920x1080";
    Configuration.pageLoadStrategy = "eager";
    Configuration.baseUrl = "https://demoqa.com/";
    Configuration.browser = "chrome";
    Configuration.timeout = 5000; //default 4000
  }

  /**
   * Закрытие драйвера должно происходить после каждого теста,
   * чтоб тесты не влияли друг на друга, тем самым каждый тест начинается «с чистого листа»
   */
  @AfterAll
  static void tearDown() {
    closeWebDriver();
  }

}
