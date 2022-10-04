import java.util.Scanner;

/**
 * @Description TODO
 * @Date 2022/9/6 13:10
 * @Created by WeiFeng
 */
public class demo {
    public static void main(String[] args) {
        System.out.println("请输入5位会员的积分");
        Scanner in = new Scanner(System.in);
        int[] jfs = new int[5];
        for (int i = 0; i < jfs.length; i++) {
            System.out.println("第" + (i + 1) + "位会员：");
            jfs[i] = in.nextInt();
        }
        int[] newJfs = new int[jfs.length];
        for (int i = 0; i < jfs.length; i++) {
            newJfs[i] = jfs[i] + 500;
        }

        System.out.println("序号\t历史积分\t新年积分");
        for (int i = 0; i < newJfs.length; i++) {
            System.out.println(i + "\t" + jfs[i] + "\t\t" + newJfs[i]);
        }
    }
}
