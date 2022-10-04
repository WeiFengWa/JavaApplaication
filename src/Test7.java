import java.time.LocalDateTime;

/**
 * @Description TODO
 * @Date 2022/10/4 17:10
 * @Created by WeiFeng
 */
public class Test7 {

    public static void main(String[] args) {
        Psd psd = new Psd();
        psd.setName("海鲜披萨");
        psd.setSize("10x10");
        psd.setPrice("￥99");
        psd.setDate(LocalDateTime.now().toString());
        psd.show();
    }
}
