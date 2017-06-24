package tdd;

import org.junit.jupiter.api.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;


public class WordWrapTest {
    @Test
    @DisplayName("Wrapping a short word with a large width should not change the text")
    public void trivialCase(TestInfo testInfo) {
        assertThat(WordWrap.wrap("text", 10), is("text"));
    }

    @Test
    @DisplayName("Wrapping a long word with a short width chops up the word")
    public void oneLongWord() {
        assertThat(WordWrap.wrap("thisisoneunbelievablylongword", 10),
                is("thisisoneu\nnbelievabl\nylongword"));
    }
}
