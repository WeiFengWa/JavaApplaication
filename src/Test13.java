import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test13 {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        JFrame frame = new JFrame();
        frame.setBounds(500, 0, 600, 800);
        frame.setBackground(Color.GREEN);
        frame.setTitle("打地鼠");

        // TitleBar
        JPanel titleBar = new MyPanel("images/mouse3.jpg", 600, 80);

        // Main
        JPanel main = new JPanel();
        main.setLayout(null);
        main.setLocation(0, 100);
        main.setPreferredSize(new Dimension(450, 780));

        // Player
        JPanel player = new MyPanel("images/mouse1.png", 100, 100);
        player.setBounds(175, 340, 100, 100);

        main.add(player);

        // Menu
        JPanel menu = new JPanel();
        menu.setBackground(Color.green);
        menu.setLayout(null);
        menu.setPreferredSize(new Dimension(150, 780));
        menu.setLocation(450, 80);

        // StartBut
        JButton startBut = new JButton("开始游戏");
        startBut.setBounds(30, 25, 100, 40);

        // HelpBut
        JButton helpBut = new JButton("游戏帮助");
        helpBut.setBounds(30, 70, 100, 40);

        // ExitBut
        JButton exitBut = new JButton("退出游戏");
        exitBut.setBounds(30, 115, 100, 40);

        // ScoreView
        JLabel scoreView = new JLabel("分数：");
        scoreView.setBounds(30, 160, 80, 40);
        JLabel scoreValue = new JLabel("0");
        scoreValue.setBounds(80, 160, 100, 40);

        // TimeView
        JLabel timeView = new JLabel("时间：");
        timeView.setBounds(30, 205, 80, 40);
        JLabel timeValue = new JLabel("00:00:00");
        timeValue.setBounds(80, 205, 100, 40);

        menu.add(startBut);
        menu.add(helpBut);
        menu.add(exitBut);

        menu.add(scoreView);
        menu.add(scoreValue);

        menu.add(timeView);
        menu.add(timeValue);

        frame.add(titleBar, BorderLayout.NORTH);
        frame.add(main, BorderLayout.WEST);
        frame.add(menu, BorderLayout.EAST);

        frame.setVisible(true);
    }

    public static class MyPanel extends JPanel {

        private String src;
        private int w, h;

        public MyPanel(String src, int w, int h) {
            this.src = src;
            this.w = w;
            this.h = h;
            this.setPreferredSize(new Dimension(w, h));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon img = new ImageIcon(src);
            g.drawImage(img.getImage(), 0, 0, w, h, null);
        }
    }

}
