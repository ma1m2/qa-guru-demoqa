package qa.msl.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

  private final SelenideElement modalWindow = $(".modal-open");
  private final SelenideElement outputTable = $(".table-responsive");
  private final SelenideElement closeModal = $("#closeLargeModal");

  public ResultTableComponent checkModalWindowAppears() {
    modalWindow.should(appear);
    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    return this;
  }

  public ResultTableComponent checkOutput(String key, String value) {
    outputTable.$(byText(key)).parent().shouldHave(text(value));
    return this;
  }

  public void closeModalWindow() {
    closeModal.click();
  }
}
