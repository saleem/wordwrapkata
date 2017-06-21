package noTdd;

public class WordWrap {
   public static String wrap(String text, int width) {
       StringBuffer wrappedText = new StringBuffer(text.length());
       recursiveWrapper(text, wrappedText, width);
       return wrappedText.toString();
   }

   private static void recursiveWrapper(String text, StringBuffer wrappedText, int width) {
       if (text.length() > width) {
           String toAppend = text.substring(0, width);
           String remainder = text.substring(width);
           wrappedText.append(toAppend).append('\n');
           recursiveWrapper(remainder, wrappedText, width);
       } else {
           wrappedText.append(text);
       }
   }

   public static void main(String[] args) {
       System.out.println(WordWrap.wrap("this is a long line of text", 4));
   }
}
