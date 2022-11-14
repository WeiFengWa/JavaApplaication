import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test14 {
    public static void main(String[] args) {
        // String number = "\\d+";
        // String email = "[a-zA-Z].*@.+.com";
        // String phone = "\\d{4}-\\d{7}";
        // String idCard = "\\d{15}(\\d{1}|\\d{3}|X|\\d{2}X)";
        // Pattern pattern = Pattern.compile(number);
        // Matcher matcher = pattern.matcher("0");
        // System.out.println(matcher.matches());
		String s = "/^[1-9]\\d{5}(?:18|19|20)\\d{2}(?:0[1-9]|10|11|12)(?:0[1-9]|[1-2]\\d|30|31)\\d{3}[\\dXx]$/";
        Pattern p = Pattern.compile(s);
        Matcher m = p.matcher("123");
        System.out.println(m.matches());
    }
}
