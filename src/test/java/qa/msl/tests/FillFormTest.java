package qa.msl.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static qa.msl.testdata.TestData.currentAddress;
import static qa.msl.testdata.TestData.firstName;
import static qa.msl.testdata.TestData.lastName;
import static qa.msl.testdata.TestData.phoneNumber;
import static qa.msl.testdata.TestData.userEmail;

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
    $("#dateOfBirthInput").scrollTo().click();
    $(".react-datepicker__year-select").scrollTo().click();
    $("select.react-datepicker__year-select option[value='1964']").click();
    $(".react-datepicker__month-select").click(); // Открыть выпадающий список
    $(".react-datepicker__month-select option[value='6']").click();
    $$("[role=gridcell]").findBy(text("26")).shouldBe(visible).click();

    $("#subjectsInput").setValue("Chemistry").pressEnter();
    $("#hobbies-checkbox-2").click();
    $("#uploadPicture").uploadFromClasspath("img/anna.png");
    $("#currentAddress").setValue(currentAddress).pressEnter();

    $("#state").scrollTo().click();
    $(byText("NCR")).click();
    $("#city").click();
    $(byText("Noida")).shouldBe(visible).click();
    $("#submit").scrollTo().click();

    $("body.modal-open")
            .$("#example-modal-sizes-title-lg").shouldBe(text("Thanks for submitting the form"));
    $("#closeLargeModal").click();
  }
}
