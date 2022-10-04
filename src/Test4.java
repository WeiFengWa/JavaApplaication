public class Test4 {
    public static void main(String[] args) {
        System.out.println(xd(1, 3));
        System.out.println(xd(1, 3.213));
        System.out.println(xd("hhhh", 3));

    }

    public static boolean xd(int a, int b) {
        return a == b;
    }

    public static boolean xd(int a, double b) {
        return a == b;
    }

    public static boolean xd(String a, int b) {
        return a.equals(b);
    }
}
