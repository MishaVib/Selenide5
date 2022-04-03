package training;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ShashlickSearchParameterizedTest {

    @BeforeEach
    void precondition() {
        Selenide.open("https://shashlik.club/");
    }

    @AfterEach
    void afterAll() {
        Selenide.closeWebDriver();
    }

    @CsvSource({
            "баранина, Мякоть баранины",
            "свиная, Свиная шея",
    })
    @ParameterizedTest(name = "showing pork and mutton in results of goods")
    void searchResults(String testData, String expectedText) {
        $("#woocommerce-product-search-field-0").setValue(testData).pressEnter();
        $(".content-area").shouldHave(text(expectedText));

    }

    @ValueSource(strings = {"баранина", "свиная"})
    @ParameterizedTest(name = "showing pork and mutton in results")
    void shashlickSearchTest(String testData) {
        $(".search-field").setValue(testData).pressEnter();
        $(".content-area").shouldHave(text(testData));
    }
}
