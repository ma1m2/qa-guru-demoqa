package qa.msl.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import qa.msl.pages.components.CalendarComponent;
import qa.msl.pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

  //Elements
  CalendarComponent calendarComponent =new CalendarComponent();
      //to open page
  private final ElementsCollection cardBody = $$(".card-body");
  private final ElementsCollection routerLink = $$(".router-link");
  private final SelenideElement textCenter = $(".text-center");
      //to fill form
  private final SelenideElement firstNameInput = $("#firstName");
  private final SelenideElement lastNameInput = $("#lastName");
  private final SelenideElement userEmailInput = $("#userEmail");
  private final SelenideElement genderContainer = $("#genterWrapper");
  private final SelenideElement userNumberInput = $("#userNumber");
  private final SelenideElement calendar = $("#dateOfBirthInput");
  private final SelenideElement subjectsInput = $("#subjectsInput");
  private final SelenideElement hobbyCheckboxes = $("#hobbiesWrapper");
  private final SelenideElement photoInput = $("#uploadPicture");
  private final SelenideElement currentAddress = $("#currentAddress");
  private final SelenideElement stateSelect = $("#state");
  private final SelenideElement citySelect = $("#city");
  private final SelenideElement stateCityContainer = $("#stateCity-wrapper");
  private final SelenideElement submitButton = $("#submit");

  //Actions
  public RegistrationPage openPage(){
    open("/");//automation-practice-form
    cardBody.findBy(text("Forms")).click();
    routerLink.findBy(text("Practice Form")).click();
    textCenter.shouldHave(text("Practice Form"));
    return this;
  }

  public RegistrationPage typeFirstName(String value) {
    firstNameInput.setValue(value);
    return this;
  }

  public RegistrationPage typeLastName(String value) {
    lastNameInput.setValue(value);
    return this;
  }

  public RegistrationPage typeUserEmail(String value) {
    userEmailInput.setValue(value);
    return this;
  }

  public RegistrationPage setGender(String value) {
    genderContainer.$(byText(value)).click();
    return this;
  }

  public RegistrationPage typeUserNumber(String value) {
    userNumberInput.setValue(value);
    return this;
  }

  public RegistrationPage setDateOfBirth(String day, String month, String year) {
    calendar.click();
    calendarComponent.setDate(day, month, year);
    return this;
  }

  public RegistrationPage setSubject(String value) {
    subjectsInput.setValue(value).pressEnter();
    return this;
  }

  public RegistrationPage setHobby(String value) {
    hobbyCheckboxes.$(byText(value)).click();
    return this;
  }

  public RegistrationPage uploadPhoto(String value) {
    photoInput.uploadFromClasspath("img/" + value);
    return this;
  }

  public RegistrationPage typeCurrentAddress(String value) {
    currentAddress.setValue(value).pressEnter();
    return this;
  }

  public RegistrationPage setState(String value) {
    stateSelect.scrollTo().click();
    stateCityContainer.$(byText(value)).click();
    return this;
  }

  public RegistrationPage setCity(String value) {
    citySelect.click();
    stateCityContainer.$(byText(value)).click();
    return this;
  }

  public RegistrationPage setStateAndCity(String state, String city) {
    setState(state);
    setCity(city);
    return this;
  }

  public ResultTableComponent submitForm() {
    submitButton.scrollTo().click();
    return new ResultTableComponent();
  }

}
