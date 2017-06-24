package tdd;

public class WordWrap {

    public static String wrap(String text, int width) {
        if (text.length() <= width) {
            return text;
        }
        String toAppend = splitNicely(text, width);
        String remainder = text.substring(toAppend.length());
        return toAppend + "\n" + wrap(remainder, width);
    }

    private static String splitNicely(String text, int width) {
        String maxToAppend = text.substring(0, width);
        int indexOfLastSpace = maxToAppend.lastIndexOf(' ');
        return indexOfLastSpace == -1 ? maxToAppend : text.substring(0, indexOfLastSpace);
    }
}
