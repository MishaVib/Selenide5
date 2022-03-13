package training;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ShashlickSearchParameterizedTest {

    @BeforeEach
    void precondition(){
        Selenide.open("https://shashlik.club/");
    }
    @AfterEach
    void afterAll() {
        Selenide.closeWebDriver();
    }
    @ValueSource(strings = {"свиная", "баранина"})
    @org.junit.jupiter.params.ParameterizedTest(name = "showing pork and mutton in results \"{0}\"")

    void shashlickSearchTest(String testData){
        $(".search-field").setValue(testData).pressEnter();
        $(".content-area").shouldHave(text(testData));
    }
    @CsvSource({
            "cвиная, Свиная шея",
            "баранина, Мякоть баранины",
    })
    @org.junit.jupiter.params.ParameterizedTest(name = "second test \"{0}\"")
void complexShashlickSearchTest(String testData, String expectedText){
        $(".search-field").setValue(testData).pressEnter();
        $(".content-area").shouldHave(text(expectedText));

}

}
