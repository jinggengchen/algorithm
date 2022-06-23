package HW机试;

// 分配面试官

/**
 * 有M个面试官，每个面试官熟悉的编程语言是一个列表，比如[“Java”, “C++”, “Golang”]表示该面试官熟悉Java、C++和Golang三种语言。
 * 有N个面试者，按照面试者的机试选择的语言分配面试官进行面试。现在给定每个面试官最多面试x个人，每个面试者必须被不同的面试官面试2次，
 * 请问能否给出一个匹配使得所有的面试者都能被面试到。
 */

/**
 * 输入
 * 第一行输入3个整数，M,N,x。其中0<=M<=100，0<=N<=1000
 * 然后是M行，输入M个面试官熟悉的语言列表，多个语言之间以空格分割，语言字符串本身不存在空格
 * 然后是N行，输入N个面试者的机试所使用的语言。
 * 输出
 * 第一行输出字符串true或者false，表示能否匹配。
 * 如果能匹配，从第二行起输出一个二维数组match，如果第i个面试官面试第j个面试者，match[i][j]== 1，否则match[i][j]==0。
 * 二维数组元素之间采用单个空格分割。如果有多种匹配，只需要输出其中一种正确的匹配即可。
 */

/**
 * 4 6 4
 * Java C++ Python (4个面试官可以面试的语言)
 * Python
 * C++ Java
 * Python
 * Java (6个候选人的考试语言)
 * Python
 * C++
 * Python
 * C++
 * Java
 */

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

/**
 * true
 * 1 0 1 0 1 1
 * 0 1 0 1 0 0
 * 1 0 1 0 1 1
 * 0 1 0 1 0 0
 */
public class fenpeimianshiguan {
    private static int M, N, x;
    private static Boolean flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        x = sc.nextInt();

        sc.nextLine();
        ArrayList<String[]> list = new ArrayList<String[]>();

        for (int i = 0; i < M; i++) {
            list.add(sc.nextLine().split(" "));
        }
        int[][] mat = new int[M][N];
        int[][] res = new int[M][N];

        // 首先用一个而为数组表示当前面试关能否面试该同学，能面试1 不能面试0
        // mat[i][j] 表示第i个面试官能不能面试第j个同学。也就是遍历一下i面试官的语言是否等于j同学的语言
        for (int i = 0; i < N; i++) {
            String language = sc.nextLine();
            for (int j = 0; j < M; j++) {
                String[] strings = list.get(j);
                for (String string : strings) {
                    if (language.equals(string)) {
                        mat[j][i] = 1;
                    }
                }
            }
        }

        // 每行相加 <= 4 表示每个面试官最多面试4个同学
        // 每列相加 = 2 表示每个同学必须被两个面试官所面试
        dfs(mat, res, 0);
        if (!flag) {
            System.out.println(false);
        }
    }

    // 数组每一行相加 <= x
    // 数组每一列相加 == 2
    private static void dfs(int[][] mat,int[][] res, int lock) {
        if (lock >= M * N) {
            // 判断行是否大于x
            for (int i = 0; i < M; i++) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    sum += res[i][j];
                }
                if (sum > x) {
                    return;
                }
            }
            // 判断列是否==2
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < M; j++) {
                    sum += res[j][i];
                }
                if (sum != 2) {
                    return;
                }
            }
            flag = true;
            System.out.println(true);
            for (int i = 0; i < M; i++) {
                System.out.println(Arrays.toString(res[i]));
            }
            return;
        }
        int X = lock / N;
        int Y = lock % N;
        if (mat[X][Y] == 1) {
            res[X][Y] = 0;
            dfs(mat, res , lock + 1);
            res[X][Y] = 1;
            dfs(mat, res , lock + 1);
        } else {
            dfs(mat, res, lock + 1);
        }

    }


}
