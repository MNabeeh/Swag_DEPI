package ExcelDataReader;

public class Helper {

    public class Helpers {
        public static String replaceAllSpaces(String text, Boolean print) {
            try {
                String regex = "[\\n\\t \\u00a0\\s+]";
                String textAfterReplaced = text.replaceAll(regex, "");
                if (print) {
                    System.out.println("Replace All: [ " + regex + " ] from [ " + text + " ] to Be [ " + textAfterReplaced + " ]");
                }
                return textAfterReplaced.trim();
            } catch (Exception e) {
                System.out.println("Error while replacing text [ " + text + " ] : " + e.getMessage());
                return text;
            }
        }
    }





}
