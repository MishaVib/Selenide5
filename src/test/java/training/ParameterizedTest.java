package training;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class ParameterizedTest {
    @BeforeEach
    void precondition() {
        Selenide.open("https://ya.ru/");

    }
@AfterEach
void closeBrowser(){
        Selenide.closeWebDriver();
}
    @ValueSource(strings = {"Selenide", "JUnit 5"})
    @org.junit.jupiter.params.ParameterizedTest(name = "showing Selenide and Junit 5 in results \"{0}\"")


    void commonSearchTest(String testData) {
Selenide.$("#text").setValue(testData);
Selenide.$("button[type='submit']").click();
Selenide.$$("li.serp-item").find(text(testData)).shouldBe(visible);

    }
}
