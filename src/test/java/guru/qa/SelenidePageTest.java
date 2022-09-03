package guru.qa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenidePageTest {

    @Test
    void shouldFindSoftAssertionsPage() {

        //открываем страницу
        open("https://github.com/");
        // вводим в поле поиска selenide и нажимаем на enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        // ищем Wiki и переходим в нее
        $("[data-search-type=Wikis]").click();
        // проверяем, что в результатах поиска есть статья SoftAssertions
        $("#wiki_search_results").shouldHave(text("SoftAssertions"));
        //переходим в статью
        $("[title=SoftAssertions]").click();
        //ищем в статье пример кода на JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
