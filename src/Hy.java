
import java.util.Scanner;

public class Hy {// vip类的注册页面
    public static void main(String[] args) {
        // String类提供了length()方法，确定字符串的长度
        Vip vip = new Vip();
        // 注册Vip的时候编号长度不能少于6个数

        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("请输入会员编号");
            String hao = input.next();
            if (hao.length() >= 6) {
                while(true) {
                    System.out.println("请输入会员积分");
                    // 积分长度在6-12？
                    int jf = input.nextInt();
                    if((jf+"").length() < 6 || (jf + "").length() > 12) {
                        System.out.println("积分度应在6位-12位之间，重新输入！");
                    } else {
                        // 调用注册功能
                        vip.vipNumber = hao;
                        vip.jf = jf;
                        System.out.println("注册成功！");
                        break;
                    }
                }
                break;
            } else {
                System.out.println("您的账号长度小于6位：重新输入！");
                // 实现循环输入？
            }
        }
    }
}
