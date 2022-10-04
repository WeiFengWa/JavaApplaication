import java.util.Scanner;

/**
 * @Description TODO
 * @Date 2022/9/13 9:03
 * @Created by WeiFeng
 */
public class demo4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String name;
        int age;
        while (true) {
            System.out.println("请输入姓名：");
            name  = in.next();
            if ("n".equals(name)) {
                break;
            } else {
                System.out.println("请输入年龄：");
                age = in.nextInt();
                Youke youke = new Youke(name, age);
                youke.show();
            }
        }
    }

    public static class Youke {
        private String name;
        private int age;

        public Youke(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void show() {
            System.out.println(name + "的年龄为：" + age + "岁， 门票价格为：" + ((age >= 18) ? 20 : "免费"));
        }
    }
}
