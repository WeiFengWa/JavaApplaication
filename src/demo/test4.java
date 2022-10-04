package demo;

import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        HuiYuan hy = new HuiYuan();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("输入会员编号：(n.结束)");
            String bh = in.next();
            if (!"n".equals(bh)) {
                System.out.println("输入会员积分：");
                int jf = in.nextInt();
                hy = hy.add(bh, jf);
            } else {
                hy.show();
                while (true) {
                    System.out.println("请输入要查询的会员编号：(n.结束)");
                    String cx = in.next();
                    if (!"n".equals(cx)) {
                        hy.query(cx);
                    } else {
                        in.close();
                        System.out.println("程序结束");
                        return;
                    }

                }
            }
        }
    }
}
