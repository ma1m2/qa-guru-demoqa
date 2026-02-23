package qa.msl.tests;

import org.junit.jupiter.api.Test;
import qa.msl.pages.TextBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static qa.msl.testdata.TestData.currentAddress;
import static qa.msl.testdata.TestData.permanentAddress;
import static qa.msl.testdata.TestData.userEmail;
import static qa.msl.testdata.TestData.userName;

public class TextBoxTests extends BaseTest{

  @Test
  public void fillFormTest() {
    TextBoxPage textBoxPage = new TextBoxPage();
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
  public void fillFormTest_chaining() {//fluent
    TextBoxPage textBoxPage = new TextBoxPage();
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
