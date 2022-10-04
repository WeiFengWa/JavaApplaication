import java.util.Scanner;

/**
 * @Description TODO
 * @Date 2022/9/7 9:51
 * @Created by WeiFeng
 */
public class demo2 {
    public static void main(String[] args) {
        int[][] myf = new int[5][3];
        int yf = 0;
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < myf.length; i++) {
            System.out.println("欢迎光临第" + (i + 1) + "家店");
            for (int j = 0; j < myf[i].length; j++) {
                System.out.println("要买衣服吗？（y/n）");
                String m = in.next();
                if ("y".equals(m)) {
                    yf++;
                    System.out.println("买了一件衣服");
                } else {
                    System.out.println("离开");
                    break;
                }
            }
        }
        System.out.println("一共买了" + yf + "件衣服");
    }
}
