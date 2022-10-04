package demo;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入行高");
        int hg = in.nextInt();
        System.out.println("请输入打印的字符");
        String s = in.next();
        draw(hg, s);
    }

    public static void draw(int hg, String s) {
        for (int i = 1; i <= hg; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(s);
            }
            System.out.println();
        }
    }
}
