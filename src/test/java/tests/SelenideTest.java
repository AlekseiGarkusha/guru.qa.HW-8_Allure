package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

  @Test
  @Feature("Issue в репозитории")
  @Story("Создание Issue")
  @Owner("AlexeyGarkusha")
  @Severity(SeverityLevel.BLOCKER)
  @Link(value = "GitHub", url = "https://github.com")
  @DisplayName("Создание Issue для автоматизированного пользователя")
  public void testIssueSearch() throws InterruptedException {
    open("https://github.com/");
    $(".header-search-button").click();
    $("#query-builder-test").sendKeys("Garkusha1991" + Keys.ENTER);

    $(".prc-ActionList-ItemLabel-81ohH").shouldBe(visible).click();

    $(withText("#1")).should(Condition.exist);
  }

}
