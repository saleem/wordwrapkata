package noTdd;

public class WordWrap {
   public static String wrap(String text, int width) {
       while (text.length() > width) {
           return wrap(text.substring(0, width-1) + "\n" + text.substring(width), width);
       }
       return text;
   }
}
