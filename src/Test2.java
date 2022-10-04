import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        cs();
        // Scanner in = new Scanner(System.in);
        // System.out.println("请输入一个字符串:");
        // String str = in.next();
        // System.out.println("请输入要查找的字符:");
        // String s = in.next();
        // int count = str.length() - str.replace(s, "").length();
        // System.out.println("”" + str + "” 中包含 " + count + " 个 “" + s + "”");
    }

    public static void cs() {
        String s = "哈哈哈";
        String[] ss = s.split("哈");
        System.out.println(Arrays.toString(ss));
    }
}
