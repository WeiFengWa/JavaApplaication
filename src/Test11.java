import java.awt.*;

import javax.swing.*;

public class Test11 {
    public static void main(String[] args) {
        // 窗口
        JFrame jFrame = new JFrame();
        jFrame.setBounds(150, 100, 570, 500);
        jFrame.setTitle("QQ注册系统");
        // 面板
        JPanel jPanel = new JPanel();
        jPanel.setSize(570, 500);
        jPanel.setLayout(null);
        jFrame.add(jPanel);
        jPanel.setBackground(Color.white);
        jFrame.setResizable(false);
        jPanel.setBackground(Color.white);

        // Tittle 标签“QQ注册系统”
        JLabel jLabelTittle = new JLabel();
        jLabelTittle.setText("QQ注册");
        // 设置 Tittle 字体格式
        Font fontTittle = new Font("宋体", Font.BOLD, 26);
        jLabelTittle.setFont(fontTittle);
        jLabelTittle.setBounds(230, 60, 120, 30);
        jPanel.add(jLabelTittle);

        // 用户Email
        JLabel jLabelEmail = new JLabel();
        jLabelEmail.setText("Email地址：");
        jLabelEmail.setBounds(180, 100, 70, 30);
        jPanel.add(jLabelEmail);

        // 用户Email输入框
        JTextField jTextFieldEmail = new JTextField();
        jTextFieldEmail.setBounds(250, 100, 120, 30);
        jPanel.add(jTextFieldEmail);

        // 昵称
        JLabel jLabeluser = new JLabel();
        jLabeluser.setText("昵         称：");
        jLabeluser.setBounds(180, 140, 70, 30);
        jPanel.add(jLabeluser);

        // 昵称输入框
        JTextField jTextFielduser = new JTextField();
        jTextFielduser.setBounds(250, 140, 120, 30);
        jPanel.add(jTextFielduser);

        // 用户密码
        JLabel jLabelupwd = new JLabel();
        jLabelupwd.setText("密         码：");
        jLabelupwd.setBounds(180, 180, 70, 30);
        jPanel.add(jLabelupwd);

        // 密码输入框
        JTextField jTextFieldpwd = new JTextField();
        jTextFieldpwd.setBounds(250, 180, 120, 30);
        jPanel.add(jTextFieldpwd);

        // 确认用户密码
        JLabel jLabelupwd2 = new JLabel();
        jLabelupwd2.setText("确认密码：");
        jLabelupwd2.setBounds(180, 220, 70, 30);
        jPanel.add(jLabelupwd2);
        // 第二次密码输入框
        JTextField jTextFieldpwd2 = new JTextField();
        jTextFieldpwd2.setBounds(250, 220, 120, 30);
        jPanel.add(jTextFieldpwd2);

        // 性别选项
        JLabel jLabeluSex = new JLabel();
        jLabeluSex.setText("性         别：");
        jLabeluSex.setBounds(180, 260, 70, 30);
        jPanel.add(jLabeluSex);

        // 性别选择按钮-男
        JRadioButton jRadioButtonman = new JRadioButton();
        jRadioButtonman.setText("男");
        jRadioButtonman.setBounds(255, 260, 55, 30);
        jRadioButtonman.setBackground(Color.white);
        jPanel.add(jRadioButtonman);
        // 性别选择按钮-女
        JRadioButton jRadioButtonwoman = new JRadioButton();
        jRadioButtonwoman.setText("女");
        jRadioButtonwoman.setBounds(320, 260, 55, 30);
        jRadioButtonwoman.setBackground(Color.white);
        jPanel.add(jRadioButtonwoman);

        // 性别按钮组合，实现单选
        ButtonGroup Sex = new ButtonGroup();
        Sex.add(jRadioButtonman);
        Sex.add(jRadioButtonwoman);

        // 注册按钮
        JButton jButton = new JButton();
        jButton.setText("注册");
        jButton.setBounds(180, 310, 192, 30);
        jButton.setIcon(new ImageIcon("images/1.png"));
        jButton.setHorizontalTextPosition(SwingConstants.CENTER);
        jPanel.add(jButton);

        jFrame.setVisible(true);

        // 将面板添加到窗口
        jFrame.add(jPanel);

    }

}
