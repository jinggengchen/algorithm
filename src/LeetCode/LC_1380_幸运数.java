package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC_1380_幸运数 {

    public static void main(String[] args) {
        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        System.out.println(luckyNumbers(matrix));
    }

    public static List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList();
        int n = matrix.length;
        int m = matrix[0].length;
        int N = 55;
        int[] row = new int[N], col = new int[N];
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        for (int i =0; i < n; i ++){
            row[i] =100001;
            for(int j = 0; j < m; j++) {
                row[i] = Math.min(row[i], matrix[i][j]);
                col[j] = Math.max(col[j], matrix[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int t = matrix[i][j];
                if (t == row[i] && t == col[j]) res.add(t);
            }
        }
        return res;
    }
}
