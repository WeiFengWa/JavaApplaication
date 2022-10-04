package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        KeHu kehu = new KeHu();
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("请输入客户姓名");
            String name = in.next();
            if("n".equals(name)) {
                kehu.showNames();
                break;
            } else {
                kehu.add(name);
            }
        }

    }
}
