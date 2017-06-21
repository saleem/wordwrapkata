package noTdd;

import java.util.AbstractMap;
import java.util.Map;


public class WordWrap {
   public static String wrap(String text, int width) {
       StringBuffer wrappedText = new StringBuffer(text.length());
       recursiveWrapper(text, wrappedText, width);
       return wrappedText.toString();
   }

   private static void recursiveWrapper(String text, StringBuffer wrappedText, int width) {
       if (text.length() > width) {
           Map.Entry<String, String> split = split(text, width);
           wrappedText.append(split.getKey()).append('\n');
           recursiveWrapper(split.getValue(), wrappedText, width);
       } else {
           wrappedText.append(text);
       }
   }

    private static Map.Entry<String, String> split(String text, int width) {
       String toAppend = text.substring(0, width);
       String remainder = text.substring(width);
       return new AbstractMap.SimpleImmutableEntry(toAppend, remainder);
    }


    public static void main(String[] args) {
       System.out.println(WordWrap.wrap("this is a long line of text", 5));
   }
}
