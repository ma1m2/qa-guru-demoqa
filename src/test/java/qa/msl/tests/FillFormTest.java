package qa.msl.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static qa.msl.testdata.TestData.city;
import static qa.msl.testdata.TestData.currentAddress;
import static qa.msl.testdata.TestData.day;
import static qa.msl.testdata.TestData.fileName;
import static qa.msl.testdata.TestData.firstName;
import static qa.msl.testdata.TestData.gender;
import static qa.msl.testdata.TestData.hobbie;
import static qa.msl.testdata.TestData.lastName;
import static qa.msl.testdata.TestData.month;
import static qa.msl.testdata.TestData.phoneNumber;
import static qa.msl.testdata.TestData.state;
import static qa.msl.testdata.TestData.subject;
import static qa.msl.testdata.TestData.userEmail;
import static qa.msl.testdata.TestData.year;

public class FillFormTest extends BaseTest{

  @Test
  public void fillRequiredFieldsDemoqa() {
    open("/");//automation-practice-form
    $$(".card-body").findBy(text("Forms")).click();
    $$(".router-link").findBy(text("Practice Form")).click();
    $(".text-center").shouldHave(text("Practice Form"));

    $("#firstName").setValue(firstName);
    $("#lastName").setValue(lastName);
    $("#userEmail").setValue(userEmail);
    $("#genterWrapper").$(byText(gender)).click();
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
    $(".text-center").shouldHave(text("Practice Form"));

    $("#firstName").setValue(firstName);
    $("#lastName").setValue(lastName);
    $("#userEmail").setValue(userEmail);
    $("#genterWrapper").$(byText(gender)).click();
    $("#userNumber").setValue(phoneNumber);
    //Calendar
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").selectOption(month);//selectOptionByValue("6");$(byText("July")).click();
    $(".react-datepicker__year-select").selectOption(year);
    $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();

    $("#subjectsInput").setValue(subject).pressEnter();
    $("#hobbiesWrapper").$(byText(hobbie)).click();
    $("#uploadPicture").uploadFromClasspath("img/" + fileName);//type="file"
    //$("#uploadPicture").uploadFile(new File("src/test/resources/img/anna.png"));
    $("#currentAddress").setValue(currentAddress).pressEnter();

    $("#state").scrollTo().click();
    $("#stateCity-wrapper").$(byText(state)).click();
    $("#city").click();
    $("#stateCity-wrapper").$(byText(city)).click();
    $("#submit").scrollTo().click();

    $(".modal-open").should(appear);
    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    $(".table-responsive").shouldHave(text(firstName + " " + lastName));
    $(".table-responsive").shouldHave(text(userEmail));
    $(".table-responsive").shouldHave(text(gender));
    $(".table-responsive").shouldHave(text(phoneNumber));
    $(".table-responsive").shouldHave(text(day+" "+month+","+year));
    $(".table-responsive").shouldHave(text(subject));
    $(".table-responsive").shouldHave(text(hobbie));
    $(".table-responsive").shouldHave(text(currentAddress));
    $(".table-responsive").shouldHave(text(fileName));
    $(".table-responsive").shouldHave(text(state+" "+city));
    $("#closeLargeModal").click();
  }
}
