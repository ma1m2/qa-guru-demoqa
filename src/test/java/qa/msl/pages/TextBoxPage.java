package qa.msl.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
  //Elements
  private final SelenideElement userNameInput = $("#userName");
  private final SelenideElement userEmailInput = $("#userEmail");
  private final SelenideElement currentAddress = $("#currentAddress");
  private final SelenideElement permanentAddress = $("#permanentAddress");
  private final SelenideElement submitButton = $("#submit");
  private final SelenideElement outputResults = $("#output");

  //Actions
  public TextBoxPage openPage(){
    open("/");//test-box
    $$(".card-body").findBy(text("Forms")).click();
    $(".group-header").click();
    $(byText("Text Box")).click();
    return this;
  }

  public TextBoxPage typeUserName(String value) {
    userNameInput.setValue(value);
    return this;
  }

  public TextBoxPage typeUserEmail(String value) {
    userEmailInput.setValue(value);
    return this;
  }

  public TextBoxPage typeCurrentAddress(String value) {
    currentAddress.setValue(value);
    return this;
  }

  public TextBoxPage typePermanentAddress(String value) {
    permanentAddress.setValue(value);
    return this;
  }

  public TextBoxPage submitForm() {
    submitButton.click();
    return this;
  }

  public TextBoxPage checkOutput(String key, String value) {
    outputResults.$(byId(key)).scrollTo().shouldHave(text(value));
    return this;
  }

}
