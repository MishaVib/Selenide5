package training;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TestWithMethodSource {

    @BeforeEach
    void precondition() {
        open("https://www.netflix.com/by/login");
    }

    @AfterEach
    void closedBrowser() {
        closeWebDriver();
    }
    static Stream<Arguments> argumentsForTest() {
        return Stream.of(
                Arguments.of("+15", "Please enter a valid phone number."),
                Arguments.of("@", "Please enter a valid email.")
        );
    }

    @MethodSource(value = "argumentsForTest")
    @ParameterizedTest(name = "phoneNumberAndMailCheck")
    void validationPhoneAndEmailTest(String login, String message) {
        $("#id_userLoginId").setValue(login);
        $("#id_password").click();
        $$(".hybrid-login-form-main").find(text(message)).shouldBe(visible);
    }
}
