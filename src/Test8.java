import javax.management.RuntimeErrorException;

public class Test8 {
    public static void main(String[] args) {
        test();
        try {
            test1();
        } catch (InterruptedException e) {
            System.out.println("线程出错啦" + e.getMessage());
        }
        System.out.println("运行结束");
    }

    public static void test() {
        int[] a = new int[2];
        try {
            System.out.println(a[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界啦" + e.getMessage());
        }
    }

    public static void test1() throws InterruptedException { 
        System.out.println("睡着啦");
        Thread.sleep(1000);
        System.out.println("睡醒啦");
    }
}
