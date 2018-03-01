import java.util.Arrays;

/**
 * @author Jozef Duc
 * t.c. student 1.rocnika mag.aplikovanej informatiky  
 * i7-4792 2.2GHz
 * testAnagram  0,078
 * testPanagram 0,0000
 * testPalindom 0,0000
 */
public class Words {
    public static boolean palindrom(String s) {
        if (s == null) {

            return true;
        }

        s = s.toLowerCase().replaceAll("[^a-z]", "");

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {

                return false;
            }
        }

        return true;
    }

    public static boolean panagram(String s) {
        if (s == null) {

            return true;
        }

        s = s.toLowerCase().replaceAll("[^a-z]", "");

        for (char c = 'a'; c <= 'z'; c++) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {

                    count++;
                }
            }
            if (count != 1) {

                return false;
            }
        }

        return true;
    }

    public static boolean anagram(String s1, String s2) {
        if (s1 == null && s2 == null) {

            return true;
        }

        if (s1 == null || s2 == null) {

            return false;
        }

        s1 = s1.toLowerCase().replaceAll("[^a-z]", "");
        s2 = s2.toLowerCase().replaceAll("[^a-z]", "");

        if (s1.length() != s2.length()) {

            return false;
        }


        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1, c2);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

/** ine riesenie
 * i7-4792 2.2GHz
 * testAnagram 9,2 s 
 * testPanagam 0,0 s
 * test Palindrom 2,15
 */
/* 
public class Words {
    private static String clean(String s) {
        String s2 = s.toLowerCase();
        s2 = s2.replace(' ', '@');
        s2 = s2.replace(',', '@');
        s2 = s2.replace('.', '@');
        s2 = s2.replace(':', '@');
        s2 = s2.replace('"', '@');
        s2 = s2.replace('\'', '@');
        s2 = s2.replace('-', '@');
        s2 = s2.replace('!', '@');
        s2 = s2.replace(';', '@');
        String out = "";
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) != '@') {
                out += s2.charAt(i);
            }
        }
        return out;
    }
    public static boolean palindrom(String s) {
        String s2 = clean(s);
        for (int i = 0, j = s2.length() - 1; i < j; i++, j--) {
            if (s2.charAt(i) != s2.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    public static boolean panagram(String s) {
        String s2 = clean(s);
        if (s2.length() != 26) {
            return false;
        }
        for (char x = 'a'; x <= 'z'; x++) {
            if (s2.indexOf(x) == -1) {
                return false;
            }
        }
        return true;
    }
    private static String changeCharInPosition(int position, char ch, String str) {
        char[] charArray = str.toCharArray();
        charArray[position] = ch;
        return new String(charArray);
    }
    public static boolean anagram(String s1, String s2) {
        String ss1 = clean(s1);
        String ss2 = clean(s2);
        if (ss1.length() != ss2.length()) {
            return false;
        }
        if (ss1.equals(ss2)) {
            return false;
        }
        for (int i = 0; i < ss1.length(); i++) {
            int k = ss2.indexOf(ss1.charAt(i));
            if (k == -1) {
                return false;
            }
            ss2 = changeCharInPosition(k, '@', ss2);
        }
        return true;
    }
}
*/