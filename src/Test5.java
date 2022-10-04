public class Test5 {
    public static void main(String[] args) {
        System.out.println(js(10.12, 11.2, "+"));
    }

    public static String js(int a, int b, String ysf) {
        String s = a + ysf + b + " = ";
        switch (ysf) {
            case "+":
                s += a + b;
                break;
            case "-":
                s += a - b;
                break;
            case "*":
                s += a * b;
                break;
            case "/":
                s += a / b;
                break;
            default:
                s += "运算符错误！";
                break;
        }
        return s;
    }

    public static String js(double a, double b, String ysf) {
        String s = a + ysf + b + " = ";
        switch (ysf) {
            case "+":
                s += a + b;
                break;
            case "-":
                s += a - b;
                break;
            case "*":
                s += a * b;
                break;
            case "/":
                s += a / b;
                break;
            default:
                s += "运算符错误！";
                break;
        }
        return s;
    }

    public static String js(int a, double b, String ysf) {
        String s = a + ysf + b + " = ";
        switch (ysf) {
            case "+":
                s += a + b;
                break;
            case "-":
                s += a - b;
                break;
            case "*":
                s += a * b;
                break;
            case "/":
                s += a / b;
                break;
            default:
                s += "运算符错误！";
                break;
        }
        return s;
    }

    public static String js(double a, int b, String ysf) {
        String s = a + ysf + b + " = ";
        switch (ysf) {
            case "+":
                s += a + b;
                break;
            case "-":
                s += a - b;
                break;
            case "*":
                s += a * b;
                break;
            case "/":
                s += a / b;
                break;
            default:
                s += "运算符错误！";
                break;
        }
        return s;
    }
}
