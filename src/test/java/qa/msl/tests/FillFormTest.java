package qa.msl.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static qa.msl.testdata.TestData.*;

public class FillFormTest extends BaseTest{

  @Test
  public void fillRequiredFieldsDemoqa() {
    open("/");//automation-practice-form
    $$(".card-body").findBy(text("Forms")).click();
    $$(".router-link").findBy(text("Practice Form")).click();

    $("#firstName").setValue(firstName);
    $("#lastName").setValue(lastName);
    $("#userEmail").setValue(userEmail);
    $("#gender-radio-2").click();
    $("#userNumber").setValue(phoneNumber);
    $("#currentAddress").setValue(currentAddress).pressEnter();
    $("#submit").scrollTo().click();

    $("body.modal-open")
            .$("#example-modal-sizes-title-lg").shouldBe(text("Thanks for submitting the form"));
    $("#closeLargeModal").click();
  }

  @Test
  public void demoqaFillForm() {
    open("/");//automation-practice-form
    $$(".card-body").findBy(text("Forms")).click();
    $$(".router-link").findBy(text("Practice Form")).click();

    $("#firstName").setValue(firstName);
    $("#lastName").setValue(lastName);
    $("#userEmail").setValue(userEmail);
    $("#gender-radio-2").click();
    $("#userNumber").setValue(phoneNumber);
    //Calendar
    $("#dateOfBirthInput").click();
    $(".react-datepicker__year-select").selectOption("1964");
    $(".react-datepicker__month-select").selectOption("July");
    $(".react-datepicker__day--026:not(.react-datepicker__day--outside-month)").click();

    $("#subjectsInput").setValue("Chemistry").pressEnter();
    $("#hobbies-checkbox-2").click();
    $("#uploadPicture").uploadFromClasspath("img/anna.png");
    $("#currentAddress").setValue(currentAddress).pressEnter();

    $("#state").scrollTo().click();
    $(byText("NCR")).click();
    $("#city").click();
    $(byText("Noida")).shouldBe(visible).click();
    $("#submit").scrollTo().click();

    $(".modal-open").should(appear);
    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    $(".table-responsive").shouldHave(text(firstName), text(lastName),
            text(userEmail), text(phoneNumber));
    $("#closeLargeModal").click();
  }
}
