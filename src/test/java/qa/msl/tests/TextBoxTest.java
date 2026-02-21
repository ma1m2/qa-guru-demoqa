package qa.msl.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

  String userName;
  String email;
  String currentAddress;
  String permanentAddress;

  @BeforeEach
  public void setUp() {
    userName = "Anna Moris";
    email = "anna@gmail.com";
    currentAddress = "current address";
    permanentAddress = "permanent address";
  }

  @BeforeAll
  static void setup() {
    Configuration.browserSize = "1920x1080";
    Configuration.pageLoadStrategy = "eager";
    Configuration.browser = "chrome";
    Configuration.baseUrl = "https://demoqa.com";
  }

  @Test
  public void testTextBox() {
    open("/");//test-box
    $$(".card-body").findBy(text("Forms")).click();
    $(".group-header").click();
    $(byText("Text Box")).click();
    $("#userName").setValue(userName);
    $("#userEmail").setValue(email);
    $("#currentAddress").setValue(currentAddress);
    $("#permanentAddress").setValue(permanentAddress);
    $("#submit").scrollTo().click();

    $("#output #name").scrollTo().shouldHave(text("Name:" + userName));

  }
}
