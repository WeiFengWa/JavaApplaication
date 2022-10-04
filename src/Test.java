import java.util.Scanner;

public class Test {

    private static User user;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        user = new User();
        run(in, true);
    }

    /**
     * 不喜欢用循环。。。😁
     * 
     * @param in         Scanner
     * @param isRegister 是否是注册
     */
    public static void run(Scanner in, Boolean isRegister) {
        System.out.println("请输入用户名：");
        String name = in.next().trim();
        System.out.println("请输入密码：");
        String password = in.next().trim();
        // true 注册，false 登录
        if (isRegister) {
            System.out.println("请再次输入密码：");
            // 判断两次密码是否一致
            if (!in.next().equals(password)) {
                System.out.println("两次输入密码不一致！");
                run(in, true);
                return;
            }
            // 调用注册
            if (!user.register(name, password)) {
                // 注册失败，重新注册
                run(in, true);
                return;
            }
            // 注册成功，调用登录
            System.out.println("\n*********登录********\n");
            run(in, false);
        } else {
            // 登录
            if (user.login(name, password)) {
                System.out.println("登录成功！");
            } else {
                // 登录失败，重新登录
                System.out.println("登录失败！请检查用户名或密码");
                run(in, false);
            }
        }
    }
}
