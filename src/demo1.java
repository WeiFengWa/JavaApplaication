import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description TODO
 * @Date 2022/9/6 12:21
 * @Created by WeiFeng
 */
public class demo1 {
    public static void main(String[] args) {
        System.out.println("请输入8给字母");
        Scanner in = new Scanner(System.in);
        String[] strs = new String[8];
        for (int i = 0; i < strs.length; i++) {
            System.out.println("第" + (i + 1) + "个字母：");
            strs[i] = in.next();
        }
        System.out.print("\n输入的字母：");
        for (String str : strs) {
            System.out.print(str + " ");
        }
        Arrays.sort(strs);
        System.out.print("\n升序后：");
        for (String str : strs) {
            System.out.print(str + " ");
        }
        System.out.println("\n输入要插入的字母：");
        String s = in.next();
        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            int position = s.compareToIgnoreCase(strs[i]);
            System.out.println(position);
            if (position < 0) {
                index = i;
                System.out.println(index);
                break;
            } else {
                index = i + 1;
            }
        }
        String[] newStrs = new String[strs.length + 1];
        for (int i = 0; i < strs.length; i++) {
            newStrs[i] = strs[i];
        }
        newStrs[index] = s;
        for (int i = index; i < newStrs.length - 1; i++) {
            newStrs[i + 1] = strs[i];
        }
        System.out.print("\n插入后：");
        for (String newStr : newStrs) {
            System.out.print(newStr + " ");
        }
    }
}
