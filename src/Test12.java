import javax.swing.JFrame;

public class Test12 {
    public static void main(String[] args) {
        My my = new My();
        my.setSize(400, 500);
    }



    public static class My extends JFrame {
        public My() {
            this.setSize(300, 300);
            this.setTitle("title");
            this.setVisible(true);
        }
    }
}
