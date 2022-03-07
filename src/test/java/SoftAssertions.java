import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SoftAssertions {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1680x1050";
    }

    @Test
    void searching() {
        //1 - открыть гитхаб
        open("/selenide/selenide");

        //2 - открыть раздел wiki проекта
        $("#wiki-tab").click();

        //3 - в Pages есть SoftAssertions
        $("#wiki-body").shouldHave(text("Soft assertions"));

        //4 - откройте страницу SoftAssertions
        $(byText("Soft assertions")).click();

        //5 - проверьте что внутри есть пример кода для JUnit5
        $(".page").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
