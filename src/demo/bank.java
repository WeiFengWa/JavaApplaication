package demo;

import java.util.Scanner;

public class bank {

    public static void main(String[] args) {// ATM页面
        /*
         * 模拟银行账户业务，进行余额查询，实现存款和取款
         */
        // 只需做选择即可
        Scanner input = new Scanner(System.in);
        BankCaozuo b1 = new BankCaozuo();// 先办卡才能去查询

        System.out.println("欢迎进入XX银行系统!");
        boolean is = true;
        while(is) {
            System.out.println("1、查询余额  2、存款  3、取款  4、退出系统");
            System.out.println("请选择：");
            int choose = input.nextInt();
            switch (choose) {
                case 1:
                    b1.showMoney();// 查看余额
                    break;
                case 2:
                    System.out.println("请输入您的存款：");
                    double cun = input.nextDouble();
                    b1.addMoney(cun);
                    System.out.println("存款成功");
                    b1.showMoney();
                    break;
                case 3:
                    System.out.println("请输入您的取款：");
                    double qu = input.nextDouble();
                    b1.quQian(qu);
                    break;
                case 4:
                    System.out.println("退出系统");
                    is = false;
                    break;
                default:
                    System.out.println("输入错了！重选！");
                    break;
            }
            // 实现循环操作：查询完还能继续存款取款等等直到你不需要操作了选择退出？
        }
    }

}
