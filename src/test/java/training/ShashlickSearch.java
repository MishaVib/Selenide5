package training;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

class ShashlickSearch {
    @BeforeEach
    void precondition(){
        Selenide.open("https://shashlik.club/");
    }
        @AfterEach
        void afterAll() {
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
        }
        @Test
        @DisplayName("showing results input")
    void shashlickSearch(){
        $(".search-field").setValue("Свиная шея").pressEnter();
        $(".content-area").shouldHave(text("Свиная шея"));


    }
@Disabled("not ready yet")
void shashlickSearch2(){
    $(".search-field").setValue("one").pressEnter();


}
}
