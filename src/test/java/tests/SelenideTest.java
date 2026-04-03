package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

  @Test
  public void testIssueSearch() {
    SelenideLogger.addListener("allure", new AllureSelenide());

    open("https://github.com/");
    $(".header-search-button").click();
    $("#query-builder-test").sendKeys("eroshenkoam/allure-example" + Keys.ENTER);

    $(".prc-ActionList-ItemLabel-81ohH").shouldBe(visible).click();

    $(withText("#1")).should(Condition.exist);
  }
}