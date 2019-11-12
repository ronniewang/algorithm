package r.w.practice.recursion;

/**
 * @author ronniewang
 * 2019-10-29 16:46
 */
public class Permutation {

    public static void main(String[] args) {

        final String s = "abc";
        perm(s.toCharArray(), 0, s.length() - 1);
    }

    private static void perm(char[] s, int start, int end) {

        if (start == end) {
            System.out.println(s);
        }
        for (int i = start; i <= end; i++) {
            swap(s, start, i);
            perm(s, start + 1, end);
            swap(s, start, i);
        }
    }

    private static void swap(char[] s, int i, int j) {

        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
