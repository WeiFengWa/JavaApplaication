import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test16 {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("src/hello.text");
            byte[] bytes = new byte[in.available()];
            InputStreamReader reader = new InputStreamReader(in, "UTF-8");
            BufferedReader buffer = new BufferedReader(reader);
            char[] chars = new char[6];
            int len = buffer.read(chars);
            while (len != -1) {
                System.out.println(new String(chars).substring(0, 5));
                chars = new char[6];
                len = buffer.read(chars);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
