package 牛客;

public class NC_1_Solve {
    public static void main(String[] args) {
        System.out.println(solve("100", "321"));
    }
    public static String solve (String s, String t) {
        // write code here
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int i = c1.length - 1;
        int j = c2.length - 1;
        int c = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 ||j >= 0) {
            int n1 = i >= 0 ? c1[i--] - '0' : 0;
            int n2 = j >= 0 ? c2[j--] - '0' : 0;
            sb.append((n1 + n2 + c) % 10);
            c = (n1 + n2 + c) / 10;
        }
        if (c != 0) {
            sb.append(c);
        }
        sb.reverse();
        return sb.toString();
    }
}
