package r.w.practice.dp;

public class Palindrome {

    public static void main(String[] args) {

//        String s = "abcba";
        String s = "aabbccbbdseessees";
        final String maxPalindrome = maxPalindrome(s);
        System.out.println("maxPalindrome = " + maxPalindrome);
    }

    private static String maxPalindrome(String s) {

        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException(s);
        }
        final int length = s.length();
        boolean[][] matrix = new boolean[length][length];
        int maxLength = 1;
        int start = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                final boolean isEqual = s.charAt(i) == s.charAt(j);
                if (i - j < 2) {
                    matrix[j][i] = isEqual;
                } else {
                    matrix[j][i] = matrix[j + 1][i - 1] && isEqual;
                }
                if (i - j + 1 > maxLength && matrix[j][i]) {
                    maxLength = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

}
