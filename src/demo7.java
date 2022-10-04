import java.util.Scanner;

public class demo7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入java成绩");
        int java = in.nextInt();
        System.out.println("请输入c#成绩");
        int c = in.nextInt();
        System.out.println("请输入DB成绩");
        int db = in.nextInt();
        ScoreCalc scoreCalc = new ScoreCalc();
        System.out.println(scoreCalc.pjf(java, c, db));
    }

    public static class ScoreCalc {
        public String pjf(int java, int c,int db) {
            return "总成绩是" + (java + c + db) + "\n" + "平均分是" + (java + c + db) / 3d;
        }
    }
}
