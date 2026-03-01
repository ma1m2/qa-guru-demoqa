package qa.msl.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static qa.msl.utils.RandomUtils.*;

public class TextBoxTests extends BaseTest{

  Faker faker = new Faker();
  String userName;
  String userEmail;
  String currentAddress;
  String permanentAddress;

  @BeforeEach
  public void prepareData() {
    userName = faker.name().name();
    userEmail = faker.internet().emailAddress();
    currentAddress = faker.address().fullAddress();
    permanentAddress = faker.address().fullAddress();
  }

  @Test
  public void fillFormTestWith_utils() {
    String userName = getRandomString(10);
    String userEmail = getRandomEmail();
    String currentAddress = getRandomString(25);
    String permanentAddress = getRandomString(25);

    textBoxPage.openPage()
            .typeUserName(userName)
            .typeUserEmail(userEmail)
            .typeCurrentAddress(currentAddress)
            .typePermanentAddress(permanentAddress)
            .submitForm()
            .checkOutput("name", userName)
            .checkOutput("email", userEmail)
            .checkOutput("currentAddress", currentAddress)
            .checkOutput("permanentAddress", permanentAddress);
  }

  @Test
  public void fillFormTestWith_faker() {
    textBoxPage.openPage()
            .typeUserName(userName)
            .typeUserEmail(userEmail)
            .typeCurrentAddress(currentAddress)
            .typePermanentAddress(permanentAddress)
            .submitForm()
            .checkOutput("name", userName)
            .checkOutput("email", userEmail)
            .checkOutput("currentAddress", currentAddress)
            .checkOutput("permanentAddress", permanentAddress);
  }

  @Test
  public void fillFormTest_chaining() {//fluent
    textBoxPage.openPage()
            .typeUserName(userName)
            .typeUserEmail(userEmail)
            .typeCurrentAddress(currentAddress)
            .typePermanentAddress(permanentAddress)
            .submitForm()
            .checkOutput("name", userName)
            .checkOutput("email", userEmail)
            .checkOutput("currentAddress", currentAddress)
            .checkOutput("permanentAddress", permanentAddress);
  }

  @Test
  public void fillFormTest() {
    textBoxPage.openPage();
    textBoxPage.typeUserName(userName);
    textBoxPage.typeUserEmail(userEmail);
    textBoxPage.typeCurrentAddress(currentAddress);
    textBoxPage.typePermanentAddress(permanentAddress);
    textBoxPage.submitForm();

    textBoxPage.checkOutput("name", userName);
    textBoxPage.checkOutput("email", userEmail);
    textBoxPage.checkOutput("currentAddress", currentAddress);
    textBoxPage.checkOutput("permanentAddress", permanentAddress);
  }

  @Test
  public void fillFormWithoutAddressTest() {
    open("/");//test-box
    $$(".card-body").findBy(text("Forms")).click();
    $(".group-header").click();
    $(byText("Text Box")).click();

    $("#userName").setValue(userName);
    $("#userEmail").setValue(userEmail);
    $("#submit").scrollTo().click();

    $("#output #name").scrollTo().shouldHave(text("Name:" + userName));
  }

}
