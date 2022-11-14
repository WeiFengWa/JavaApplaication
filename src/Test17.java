import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class Test17 {
    public static void main(String[] args) throws Exception{
        FileInputStream file = new FileInputStream("src/test.txt");

        FileReader reader = new FileReader("src/test.txt");
        char[] chars = new char[file.available()];
        reader.read(chars);
        String msg = new String(chars);
        reader.close();
        file.close();

        FileWriter writer = new FileWriter("src/test1.txt");
        writer.write(msg);
        writer.close();
    }
}
