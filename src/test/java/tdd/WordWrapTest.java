package tdd;

import org.junit.jupiter.api.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class WordWrapTest {
    @Test
    @DisplayName("Wrapping a short word with a large width should not change the text")
    public void trivialCase(TestInfo testInfo) {
        assertThat(WordWrap.wrap("text", 10), is("text"));
    }
}
