package qa.msl.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class FillFormTest {

  @BeforeAll
  static void setup() {
    //WebDriverManager.chromedriver().driverVersion("145.0.7632.77").setup();
    Configuration.browserSize = "1920x1080";
    Configuration.pageLoadStrategy = "eager";
    Configuration.browser = "chrome";
  }

  @Test
  void testFillForm() throws InterruptedException {
    open("https://app.qa.guru/automation-practice-form/");
    $("[data-testid=ClearIcon]").shouldBe(visible).click();
    $("input[data-testid=firstName]").setValue("Sveta");
    $("input[data-testid=lastName]").setValue("Lvovna");
    $("input[data-testid=email]").setValue("asd@gmail.com");
    $("input[data-testid=phone]").setValue("456456456");
    //Language
    $("input[data-testid=language]").parent().click();
    $("[data-value='English']").click();
/*    //Календарь
    //$("input[data-testid=dateOfBirth]").click();
    $("[data-testid='CalendarIcon']").click();
    //choose year
    $(".MuiPickersFadeTransitionGroup-root.css-1bx5ylf").click();
    $(".MuiPickersYear-root.css-j9zntq").$(byText("1964"))
            .scrollTo().shouldBe(visible).click();;
    //choose month
    $(".MuiPickersMonth-monthButton").$(byText("Jul")).click();
    //choose day  .MuiDayCalendar-weekContainer.css-mvmu1r
    $(".MuiDayCalendar-weekContainer.css-mvmu1r").$(byText("26")).click();*/

    $("input[data-testid=gender][value=Female]").click();
    $("input[data-testid=hobbies][value=Sports]").click();
    $("input[data-testid=hobbies][value=Reading]").click();
    Thread.sleep(3000);
/*    //Предметы
    $("input[data-testid=subjects]").click();
    $("li").$(byText("English")).shouldBe(visible).click();
    //Штат, город
    $("input[data-testid=stateCity]").click();
    $("li").$(byText("New York")).shouldBe(visible).click();
    $("#city-select").click();
    $("option").$(byText("New York")).shouldBe(visible).click();
    //Slider
    $("span[data-index='0']").click();
    $("textarea[data-testid=address]").setValue("klklljlkjlj");
    $("[data-testid='UploadFileIcon']").uploadFromClasspath("");
    $("button[type='submit']").uploadFromClasspath("");*/
  }

  //@Test
  //It doesn't work with VPN either.
  public void demoqaFillForm() {
    open("https://demoqa.com/automation-practice-form");
    $(".card mt-4 top-card").click();
    $(".element-list.accordion-collapse.collapse.show").click();
    $("#firstName").setValue("Sveta");
    $("#lastName").setValue("Chess");
    $("#userEmail").setValue("sveta@gmail.com");
    $("#gender-radio-2").click();
    $("#userNumber").setValue("9057903858");
    $("select.react-datepicker__month-select").click();
    $("option[value=July]").click();
    $("select.react-datepicker__year-select").click();
    $("option[value=1964]").click();
    $("[role=gridcell]").$(byText("26")).shouldBe(visible).click();
    $("#subjectsInput").setValue("Chemistry").pressEnter();
    $("#hobbies-checkbox-2").click();
    $("#uploadPicture").uploadFromClasspath("img/anna.png");
    $("#currentAddress").setValue("ljlkjlkjlkjlkj").pressEnter();
    $("#state").$(byText("NCR")).shouldBe(visible).click();
    $("#city").$(byText("Noida")).shouldBe(visible).click();
    $("#submit").scrollTo().click();
    $("body.modal-open").$("#example-modal-sizes-title-lg")
            .shouldBe(text("Thanks for submitting the form"));
    $("#closeLargeModal").click();
  }
}
