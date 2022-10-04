import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean status = true;
        while (status) {
            System.out.println("请输入身份证：");
            String id = in.next();
            System.out.println("请输入手机号：");
            String phone = in.next();
            System.out.println("请输入座机号：");
            String zjh = in.next();
            status = !verify(id, phone, zjh);
        }
    }

    /**
     * 校验
     * @param id
     * @param phone
     * @param zjh
     * @return
     */
    public static boolean verify(String id, String phone, String zjh) {
        if (id.length() != 16 && id.length() != 18) {
            System.out.println("身份证号码必须是16或18位！");
            return false;
        }
        if (phone.length() != 11) {
            System.out.println("手机号必须是11位！");
            return false;
        }
        if (zjh.indexOf("-") == -1 || zjh.length() != 12) {
            System.out.println("座机号应该包含'-',且长度为12位");
            return false;
        }
        String[] zj = zjh.split("-");
        if (zj[0].length() != 4 && zj[1].length() != 7) {
            System.out.println("座机号区号必须是4，电话号码必须是7位！");
            return false;
        }
        System.out.println("注册成功！");
        return true;
    }
}
