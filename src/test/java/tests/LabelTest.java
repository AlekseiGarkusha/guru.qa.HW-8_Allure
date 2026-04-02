package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelTest {

  @Test
  @Feature("Issue в репозитории")
  @Story("Создание Issue")
  @Owner("AlexeyGarkusha")
  @Severity(SeverityLevel.BLOCKER)
  @Link(value = "GitHub", url = "https://github.com")
  @DisplayName("Создание Issue для автоматизированного пользователя")
  void staticLabelsTest() {

  }

  @Test
  void dynamicLabelsTest() {

  }

}
