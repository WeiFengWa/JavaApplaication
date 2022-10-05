import java.util.Scanner;

public class Test9 {
    public static void main(String[] args) {
        try {
            test();
        } catch (SexException e) {
            e.printStackTrace();
        }
    }

    public static void test() throws SexException {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入你的性别");
        switch (in.next()) {
            case "男":
                System.out.println("加入男子组");
                break;
            case "女":
                System.out.println("加入女子组");
                break;
            default:
                throw new SexException("请输入正确的性别");
        }
    }
}
