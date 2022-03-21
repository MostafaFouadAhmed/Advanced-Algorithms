package challenges;

public class BackSpaceString {

    public static void main(String[] args) {

        System.out.println(backspaceCompare("ab#c", "ad#c")); // true
        System.out.println(backspaceCompare("ab##", "c#d#")); // true
        System.out.println(backspaceCompare("a#c", "b")); // false
        System.out.println(backspaceCompare("a##c", "#a#c")); // true
        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f")); // true
        System.out.println(backspaceCompare("j##xfix", "j###xfix")); // true
    }

    // 0 ms & 40.6 MB ==> Best performance reached
    public static boolean backspaceCompare(String s, String t) {

        s = backedSpaceString(s);
        t = backedSpaceString(t);
        return s.equals(t);
    }

    private static String backedSpaceString(final String string) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {

            if(string.charAt(i) == '#' && sb.length() != 0) {
                sb.deleteCharAt(sb.length() - 1);
                continue;
            } else if (string.charAt(i) == '#' && sb.length() == 0) {
                continue;
            }
            sb.append(string.charAt(i));
        }
       return sb.toString();
    }
}
