package qa.msl.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class TestDemoqa extends BaseTest{

  @Test
  void checkPracticeFormTest() {
    open("");
    $$(".card-body").findBy(text("Forms")).click();
    $$(".router-link").findBy(text("Practice Form")).click();
  }

}
