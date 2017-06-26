package tdd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordWrap {

    public static String wrap(String text, int width) {
        if (text.length() <= width) {
            return text;
        }
        String toAppend = splitNicely(text, width).trim();
        String remainder = text.substring(toAppend.length()).trim();
        return toAppend + "\n" + wrap(remainder, width);
    }

    private static String splitNicely(String text, int width) {
        String maxToAppend = text.substring(0, width);
        int splitLocation = splitLocation(maxToAppend);
        return splitLocation == -1 ? maxToAppend : text.substring(0, splitLocation);
    }

    private static int splitLocation(String maxToAppend) {
        int location = getLocationOfLastUpperCaseWord(maxToAppend);
        return location == -1 ? maxToAppend.lastIndexOf(' ') : location;
    }

    private static int getLocationOfLastUpperCaseWord(String maxToAppend) {
        int location = -1;
        Matcher matcher = Pattern.compile(" [A-Z]").matcher(maxToAppend);
        while (matcher.find()) {
            location = matcher.start();
        }
        return location;
    }
}
