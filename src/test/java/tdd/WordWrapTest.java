package tdd;

import org.junit.jupiter.api.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;


public class WordWrapTest {
    @Test
    @DisplayName("Wrapping a short word with a large width should not change the text")
    public void trivialCase() {
        assertThat(WordWrap.wrap("text", 10), is("text"));
    }

    @Test
    @DisplayName("Wrapping a long word with a short width chops up the word")
    public void oneLongWord() {
        assertThat(WordWrap.wrap("thisisoneunbelievablylongword", 10),
                is("thisisoneu\nnbelievabl\nylongword"));
    }

    @Test
    @DisplayName("When a nearby space exists, wrap there and remove the space instead of chopping the next word")
    public void wrapAtSpace() {
        assertThat(WordWrap.wrap("wrap this without chopping", 10),
                is ("wrap this\nwithout\nchopping"));
    }

    @Test
    @DisplayName("When wrapping, prefer that the new line starts with a word that begins with a Capital letter")
    public void preferUpperCaseWordsAfterNewLine() {
        assertThat(WordWrap.wrap("To wrap Or not To wrap That is The question", 10),
                is ("To wrap\nOr not\nTo wrap\nThat is\nThe\nquestion"));
    }

    @Test
    @DisplayName("Wrap the soliloquy!")
    public void wrapHamlet() {
        String soliloquy = "To be, or not to be--that is the question: Whether 'tis nobler in the mind to suffer The slings and arrows of outrageous fortune Or to take arms against a sea of troubles And by opposing end them. To die, to sleep-- No more--and by a sleep to say we end The heartache, and the thousand natural shocks That flesh is heir to. 'Tis a consummation Devoutly to be wished. To die, to sleep-- To sleep--perchance to dream: ay, there's the rub, For in that sleep of death what dreams may come When we have shuffled off this mortal coil, Must give us pause. There's the respect That makes calamity of so long life. For who would bear the whips and scorns of time, Th' oppressor's wrong, the proud man's contumely The pangs of despised love, the law's delay, The insolence of office, and the spurns That patient merit of th' unworthy takes, When he himself might his quietus make With a bare bodkin? Who would fardels bear, To grunt and sweat under a weary life, But that the dread of something after death, The undiscovered country, from whose bourn No traveller returns, puzzles the will, And makes us rather bear those ills we have Than fly to others that we know not of? Thus conscience does make cowards of us all, And thus the native hue of resolution Is sicklied o'er with the pale cast of thought, And enterprise of great pitch and moment With this regard their currents turn awry And lose the name of action. -- Soft you now, The fair Ophelia! -- Nymph, in thy orisons Be all my sins remembered.";

        String wrappedSoliloquy = WordWrap.wrap(soliloquy, 55);
        Matcher matcher = Pattern.compile("\\n").matcher(wrappedSoliloquy);
        int minimumExpectedLines = 10;
        for (int i = 1; i <= minimumExpectedLines; i++) {
            assertTrue(String.format("Could not find line-break number %d", i), matcher.find());
        }
        System.out.println(wrappedSoliloquy);
    }
}
