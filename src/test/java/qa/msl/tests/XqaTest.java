package qa.msl.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class XqaTest {

  @BeforeAll
  static void setUp() {
    Configuration.browserSize = "1920x1080";
    Configuration.pageLoadStrategy = "eager";
    Configuration.browser = "chrome";
  }

  @Test
  void checkPracticeFormTest() {
    open("https://xqa.io/practice/practice-form");
    $(".fc-dialog-container").shouldBe(visible);
    $$(".fc-button-label").findBy(text("Consent")).click();

    $("#firstName").setValue("Sveta");
    $("#lastName").setValue("Lvovna");
    $("#userEmail").setValue("Lvovna@gmail.com");
    $("[name=gender][value=Female]").click();
    $("#userNumber").setValue("9057903858");
    $("#hobbies-Reading").click();
    $("#uploadPicture").uploadFromClasspath("img/anna.png");
    $("#currentAddress").scrollTo().click();
    $("#state").scrollTo().click();
    $("option[value=NCR]").click();
    $("#city").scrollTo().click();
    $("option[value=Delhi]").click();
    $("button#submit").scrollTo().click();
    $("#closeLargeModal").shouldBe(visible);
    $("#close-modal").click();
  }
}
