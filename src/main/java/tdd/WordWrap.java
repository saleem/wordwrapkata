package tdd;

public class WordWrap {

    public static String wrap(String text, int width) {
        if (text.length() <= width) {
            return text;
        }
        return text.substring(0, width) + "\n" + wrap(text.substring(width), width);
    }
}
