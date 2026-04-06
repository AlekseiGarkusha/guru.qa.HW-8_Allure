package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import tests.steps.WebSteps;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepsTest {

  private final String REPOSITORY = "Garkusha1991";
  private final String ISSUE = "1";

  @Test
  @Feature("Issue в репозитории")
  @Story("Создание Issue")
  @Owner("AlexeyGarkusha")
  @Severity(SeverityLevel.BLOCKER)
  @Link(value = "GitHub", url = "https://github.com")
  @DisplayName("Создание Issue для автоматизированного пользователя")
  public void testLambdaSteps() {
    step("Открываем главную страницу",() -> {
      open("https://github.com/");
    });
    step("Ищем репозиторий", () -> {
      $(".header-search-button").click();
      $("#query-builder-test").sendKeys(REPOSITORY + Keys.ENTER);
    });
    step("Открываем таб Issue", () -> {
      $(".prc-ActionList-ItemLabel-81ohH").shouldBe(visible).click();
    });
    step("Проверяем, что Issue" + ISSUE + "существует", () -> {
      $(withText("#" + ISSUE)).should(Condition.exist);
    });
  }

  @Test
  @Feature("Issue в репозитории")
  @Story("Создание Issue")
  @Owner("AlexeyGarkusha")
  @Severity(SeverityLevel.BLOCKER)
  @Link(value = "GitHub", url = "https://github.com")
  @DisplayName("Создание Issue для автоматизированного пользователя - pageObject")
  public void testAnnotatedStep() {
    WebSteps webSteps = new WebSteps();

    webSteps
      .openMainPage()
      .finedRepository(REPOSITORY)
      .openIssueTab()
      .finedIssue(ISSUE);
  }
}
