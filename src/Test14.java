import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test14 {
    public static void main(String[] args) {
        String number = "\\d+";
        String email = "[a-zA-Z].*@.+.com";
        String phone = "\\d{4}-\\d{7}";
        String idCard = "\\d{15}(\\d{1}|\\d{3}|X|\\d{2}X)";
        Pattern pattern = Pattern.compile(number);
        Matcher matcher = pattern.matcher("0");
        System.out.println(matcher.matches());
    }
}
