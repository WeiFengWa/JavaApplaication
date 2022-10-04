package demo;

public class BankCaozuo {// 银行业务操作类
    // 至少提供哪些功能？：查询 余额存款 取款
    double money;

    // 查看余额：
    public void showMoney() {
        System.out.println("您当前的余额为：" + money);
    }

    // 存款：
    public void addMoney(double qian) {
        money = money + qian;
    }

    // 取款
    public void quQian(double qian) {
        // ?
        if(money < qian) {
            System.out.println("余额不足");
            System.out.println("当前余额" + money);
            return;
        }
        money -= qian;
        System.out.println("取款成功");
        showMoney();
    }
}
