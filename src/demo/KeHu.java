package demo;

import java.util.Scanner;

public class KeHu {

    private String[] list;

    public void add(String name) {
        if (list == null) {
            list = new String[1];
            list[0] = name;
        } else {
            String[] newList = new String[list.length + 1];
            for (int i = 0; i < newList.length; i++) {
                if (i == list.length) {
                    newList[i] = name;
                } else {
                    newList[i] = list[i];
                }
            }
            list = null;
            list = newList;
        }
    }

    /**
     * 显示用户列表，并修改
     */
    public void showNames() {
        System.out.println("客户姓名列表");
        for (String name : list) {
            System.out.print(name + "\t");
        }
        System.out.println();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("是否修改用户名字：(y/n)");
            if("y".equals(in.next())) {
                System.out.println("请输入要修改名字的用户：");
                String o = in.next();
                System.out.println("请输入要修改成的名字：");
                String n = in.next();
                upName(o, n);
            } else {
                System.out.println("结束程序");
                break;
            }
        }
    }

    public void upName(String oldName, String newName) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(oldName)) {
                list[i] = newName;
                System.out.println("修改成功");
                return;
            }
        }
        System.out.println("没有该用户");
    }

}
