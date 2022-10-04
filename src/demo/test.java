package demo;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入第一位数");
        int a = in.nextInt();
        System.out.println("请输入第一位数");
        int b = in.nextInt();
        System.out.println("请输入运算符");
        String ysf = in.next();
        System.out.println(util(ysf, a, b));
        util1(ysf, a, b);
    }

    public static String util(String s, int a, int b) {
        String str = a + s + b + "=";
        switch (s) {
            case "+":
                str += a + b;
                break;
            case "-":
                str += a - b;
                break;
            case "*":
                str += a * b;
                break;
            case "/":
                str += a / b;
                break;
            default:
                str += "输入错误";
                break;
        }
        return str;
    }

    public static void util1(String s, int a, int b) {
        String str = a + s + b + "=";
        switch (s) {
            case "+":
                str += a + b;
                break;
            case "-":
                str += a - b;
                break;
            case "*":
                str += a * b;
                break;
            case "/":
                str += a / b;
                break;
            default:
                str += "输入错误";
                break;
        }
        System.out.println(str);
    }
}
