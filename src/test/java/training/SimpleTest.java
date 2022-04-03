package training;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleTest {
    @Test
    @DisplayName("Green")
    void simpleGreenTest() {
        assertTrue(3 > 2);
    }

    @Test
    @DisplayName("Red")
    void simpleRedTest() {
        assertTrue(3 < 2);
    }

    @Test
    @Disabled("bug: JIRA-12232")
    void simpleBrokenTest() {
        throw new IllegalStateException("Broken :(");
    }
}
