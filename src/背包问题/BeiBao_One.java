package 背包问题;

/**
 * A类物品3元一个, B类物品4元一个,c类物品2元三个,现有100元钱想买100个物品,编
 */
public class BeiBao_One {
    public static void main(String[] args) {
        for (int i = 0; i < 33; i++) {
            for (int j = 0; j < 25; j++) {
                for (int k = 0; k < 100; k++) {
                    if (i + j + k == 100 && i * 3 + j * 4 + k * 2 / 3 == 100) {
                        System.out.println("i=" + i + ",j=" + j + ",k=" + k);
                    }
                }
            }
        }
    }
}
