package noTdd;

import java.util.AbstractMap;
import java.util.Map;


public class WordWrap {

    public static String wrap(String text, int width) {
        StringBuffer wrappedText = new StringBuffer(text.length());
        recursiveWrapper(text, wrappedText, width);
        return wrappedText.toString();
    }


    /**
     * Recursive function that wraps the given text in the given Stringbuffer, ensuring that:
     * 1. Every chunk (except possibly the last one) ends with a newline character '\n', and
     * 2. The length of every chunk, excluding any trailing newline character, does not exceed width
     *
     * @param text        - the text to wrap
     * @param wrappedText - the StringBuffer containing text that's already been wrapped
     * @param width       - the maximum length of each chunk
     */
    private static void recursiveWrapper(String text, StringBuffer wrappedText, int width) {
        if (text.length() > width) {
            Map.Entry<String, String> split = split(text, width);
            wrappedText.append(split.getKey()).append('\n');
            recursiveWrapper(split.getValue(), wrappedText, width);
        } else {
            wrappedText.append(text);
        }
    }


    /**
     * Splits the given text into two chunks and returns it as a Map.Entry pair
     *
     * @param text  - the text to split
     * @param width - the maximum length of the first chunk
     * @return Map.Entry - the first element (key) is a chunk from the beginning of text whose
     * length does not exceed width, the second element (value) is the remaining portion of text
     */
    private static Map.Entry<String, String> split(String text, int width) {
        String toAppend = splitNicely(text, width);
        String remainder = text.substring(toAppend.length());
        return new AbstractMap.SimpleImmutableEntry(toAppend, remainder);
    }


    private static String splitNicely(String text, int width) {
        String maxToAppend = text.substring(0, width);
        if (text.charAt(width) == ' ') {
            return maxToAppend.trim();
        }
        int lastSpace = maxToAppend.trim().lastIndexOf(' ');
        return lastSpace == -1 ? maxToAppend : maxToAppend.substring(0, lastSpace);
    }


    public static void main(String[] args) {
        System.out.println(WordWrap.wrap(
                "this is a long line of text this is a long line " +
                "of text this is a long line of text", 20));
    }
}
