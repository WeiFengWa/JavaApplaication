import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Goods goods = new Goods();
        Scanner in = new Scanner(System.in);
        System.out.println("请输入账号:");
        String user = in.next();
        System.out.println("请输入密码：");
        String psw = in.next();
        if (goods.login(user, psw)) {
            System.out.println("登录成功！");
            goods.show();
            System.out.println("请输入你批发的商品编号：");
            int bh = in.nextInt();
            System.out.println("请输入批发量：");
            int pfl = in.nextInt();
            goods.buy(bh, pfl);
        } else {
            System.out.println("登录失败！");
        }
    }
}
