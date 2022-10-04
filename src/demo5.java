import java.util.Scanner;

/**
 * @Description TODO
 * @Date 2022/9/13 9:46
 * @Created by WeiFeng
 */
public class demo5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Admin admin = new Admin("张三", "123456");
        admin.show();
        System.out.println("登录");
        boolean login = true;
        while (login) {
            System.out.println("请输入账号");
            String username = in.next();
            System.out.println("请输入密码");
            String password = in.next();
            if (admin.login(username, password)) {
                System.out.println("登录成功！");
                while (login) {
                    System.out.println("0.显示用户信息\n1.修改用户密码\n2.退出\n请选择：");
                    if (in.hasNextInt()) {
                        switch (in.nextInt()) {
                            case 0:
                                admin.show();
                                break;
                            case 1:
                                System.out.println("请输入新密码");
                                admin.setPassword(in.next());
                                admin.show();
                                break;
                            case 2:
                                login = false;
                                break;
                            default:
                                System.out.println("输入错误");
                                break;
                        }
                    } else {
                        System.out.println("输入错误");
                        in.next();
                    }
                }
            } else {
                System.out.println("账号或密码错误");
            }
        }
    }

    public static class Admin {
        private String name;
        private String password;

        public Admin(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean login(String name, String password) {
            return this.name.equals(name) && this.password.equals(password);
        }

        public void show() {
            System.out.println("账号：" + name + " 密码：" + password);
        }
    }
}
