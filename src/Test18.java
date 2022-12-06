import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class Test18 {
    static Connection conn = null;// 为了方便所有方法共用这个变量
    static JFrame jf;// 登录窗口
    static JFrame jf1;// 注册窗口
    static JFrame jf2;// 学生的主页窗口
    static JFrame jf3;// 学生的显示个人信息界面
    static JFrame jf4;// 学生的修改个人信息界面
    static int indexId;// 代表登录成功的人的id
    static String indexPwd;

    public static void main(String[] args) {
        // 登录页面 注册页面 首页
        login();
    }

    // 方法1：创建登录页面
    public static void login() {// static：同一类内：静态成员之间调用静态成员
        jdbc();
        // 登录界面：
        jf = new JFrame("登录界面");// 创建窗体的时候设置窗体标题
        jf.setBounds(500, 100, 300, 500);// 一次性设置位置和大小：x,y,w,h
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);// 设置默认关闭方式：退出的时候后台也终止

        JPanel jp1 = new JPanel();// 创建登录面板
        jp1.setBackground(Color.white);
        // 面板默认布局方式是：流式布局
        jp1.setLayout(null);// 绝对布局：里面的内容就可以按照自己想要的方式排版

        JLabel jl1 = new JLabel("请输入账号");
        jl1.setBounds(40, 100, 100, 30);
        JTextField jt1 = new JTextField("1");
        jt1.setBounds(140, 100, 100, 30);

        JLabel jl2 = new JLabel("请输入密码：");
        jl2.setBounds(40, 150, 100, 30);
        JTextField jt2 = new JTextField("abc");
        jt2.setBounds(140, 150, 100, 30);

        JRadioButton jr1 = new JRadioButton();
        jr1.setBounds(80, 200, 20, 30);
        jr1.setOpaque(false);
        JLabel jl3 = new JLabel("管理员");
        jl3.setBounds(100, 200, 50, 30);
        JRadioButton jr2 = new JRadioButton();
        jr2.setBounds(170, 200, 20, 30);
        jr2.setOpaque(false);
        JLabel jl4 = new JLabel("学生");
        jl4.setBounds(190, 200, 50, 30);

        ButtonGroup btg = new ButtonGroup();
        btg.add(jr1);
        ;
        btg.add(jr2);

        JButton jb1 = new JButton("登录");// 创建按钮的同时设置按钮的文本
        jb1.setBounds(60, 300, 60, 30);
        JButton jb2 = new JButton("注册");// 创建按钮的同时设置按钮的文本
        jb2.setBounds(170, 300, 60, 30);

        JLabel jl5 = new JLabel("111");// 专门放提示信息的
        jl5.setBounds(40, 380, 200, 50);

        // 点击登录的时候就连接数据库：
        jb1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 点击按钮的时候要处理的代码：
                // 4.2 获取预编译的sql对象:需要传入sql语句
                // 获取文本框的值
                if (jt1.getText().equals("") || jt2.getText().equals("")) {// 判断账号和密码是否有值
                    jl5.setText("请输入账号和密码");
                } else {
                    int id = Integer.parseInt(jt1.getText());// 将获取账号框的字符串转为数值
                    String pwd = jt2.getText();// 获取密码框的值
                    // 判断按钮组选择的是谁
                    if (btg.getSelection() != null) {// 判断按钮组是否为null:被选择说明不为null
                        if (jr1.isSelected()) {// 判断管理员是否被选择
                            // 执行的是管理员语句
                            try {
                                String sql2 = "select * from admin where id=? and pwd=? ";
                                PreparedStatement ptm = conn.prepareStatement(sql2);
                                ptm.setInt(1, id);
                                ptm.setString(2, pwd);
                                ResultSet rs = ptm.executeQuery();
                                if (rs.next()) {
                                    // System.out.println("登录成功");
                                    jl5.setText("登录成功:欢迎您：" + rs.getString("name"));
                                } else {
                                    jl5.setText("登录失败");
                                }
                            } catch (SQLException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                        }
                        if (jr2.isSelected()) {// 判断学生是否被选择
                            // 执行学生语句
                            try {
                                String sql2 = "select * from student where id=? and pwd=? ";
                                PreparedStatement ptm = conn.prepareStatement(sql2);
                                ptm.setInt(1, id);
                                ptm.setString(2, pwd);
                                ResultSet rs = ptm.executeQuery();
                                if (rs.next()) {
                                    // System.out.println("登录成功");
                                    jl5.setText("登录成功");
                                    indexId = id;// 把登录成功的人的id拿到
                                    jf.setVisible(false);// :隐藏登录窗口：后台依然运行
                                    jf.dispose();// 销毁当前这个窗口
                                    // 调用学生主页页面：
                                    indexStu();
                                } else {
                                    jl5.setText("登录失败");
                                }
                            } catch (SQLException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                        }

                    } else {
                        jl5.setText("请选择身份");
                    }

                }
            }
        });

        // 点击注册的时候：弹出注册窗口：把登录关闭即可
        jb2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 当你点击注册按钮的时候：要做什么操作
                jf.setVisible(false);// :隐藏登录窗口：后台依然运行
                jf.dispose();// 销毁当前这个窗口
                // 调用注册页面：
                zhuce();

            }
        });

        jp1.add(jb1);
        jp1.add(jb2);
        jp1.add(jl1);
        jp1.add(jt1);
        jp1.add(jl2);
        jp1.add(jt2);
        jp1.add(jl3);
        jp1.add(jr1);
        jp1.add(jl4);
        jp1.add(jr2);
        jp1.add(jl5);
        jf.add(jp1);// 面板添加给窗体：窗体默认的布局方式是边界布局

        jf.setVisible(true);// 设置窗体可见：默认是隐藏的false

    }

    // 方法2：注册页面
    public static void zhuce() {
        jf1 = new JFrame("注册界面");// 创建窗体的时候设置窗体标题
        jf1.setBounds(500, 100, 300, 500);// 一次性设置位置和大小：x,y,w,h
        jf1.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);// 设置默认关闭方式：退出的时候后台也终止

        JPanel jp2 = new JPanel();// 创建注册面板
        jp2.setBackground(Color.pink);
        // 面板默认布局方式是：流式布局
        jp2.setLayout(null);// 绝对布局：里面的内容就可以按照自己想要的方式排版
        // jp2.setVisible(false);//一开始设置隐藏
        // jp2.setOpaque(false);

        JLabel jl21 = new JLabel("请输入账号：");
        jl21.setBounds(40, 50, 100, 30);
        JTextField jt21 = new JTextField();
        jt21.setBounds(140, 50, 100, 30);

        JLabel jl22 = new JLabel("请输入名字：");
        jl22.setBounds(40, 90, 100, 30);
        JTextField jt22 = new JTextField();
        jt22.setBounds(140, 90, 100, 30);

        JLabel jl23 = new JLabel("请输入密码：");
        jl23.setBounds(40, 130, 100, 30);
        JTextField jt23 = new JTextField();
        jt23.setBounds(140, 130, 100, 30);

        JLabel jl24 = new JLabel("请输入年龄：");
        jl24.setBounds(40, 170, 100, 30);
        JTextField jt24 = new JTextField();
        jt24.setBounds(140, 170, 100, 30);

        JLabel jl25 = new JLabel("请输入性别：");
        jl25.setBounds(40, 210, 100, 30);
        JTextField jt25 = new JTextField();
        jt25.setBounds(140, 210, 100, 30);

        JLabel jl26 = new JLabel("请输入地址：");
        jl26.setBounds(40, 250, 100, 30);
        JTextField jt26 = new JTextField();
        jt26.setBounds(140, 250, 100, 30);

        JButton jb1 = new JButton("提交注册");// 创建按钮的同时设置按钮的文本
        jb1.setBounds(60, 300, 90, 30);
        JButton jb2 = new JButton("返回登录");// 创建按钮的同时设置按钮的文本
        jb2.setBounds(170, 300, 90, 30);

        JLabel jl27 = new JLabel("提示信息：");
        jl27.setBounds(40, 350, 200, 50);
        // 点击提交注册的时候：
        jb1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 点击提交注册的时候：处理代码写在这里
                String id = jt21.getText();// 获取的是账号的值 10
                int id1 = 0;
                if (id.equals("")) {
                    jl27.setText("账号不能为空");
                    return;// 可以结束代码的执行
                } else {
                    id1 = Integer.parseInt(id);// 将字符转为数值
                    try {
                        String sql = "select * from student where id=?";
                        PreparedStatement pts = conn.prepareStatement(sql);
                        pts.setInt(1, id1);
                        ResultSet rs = pts.executeQuery();
                        if (rs.next()) {
                            jl27.setText("账号已经存在！请重新输入！");
                            return;// 可以结束代码的执行
                        }
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                String name = jt22.getText();
                String pwd = jt23.getText();
                String age = jt24.getText();
                int age1 = Integer.parseInt(age);
                String sex = jt25.getText();
                String address = jt26.getText();
                String insertSql = "insert into student values(?,?,?,?,?,?);";
                PreparedStatement pts;
                try {
                    pts = conn.prepareStatement(insertSql);
                    pts.setInt(1, id1);
                    pts.setString(2, name);
                    pts.setString(3, pwd);
                    pts.setInt(4, age1);
                    pts.setString(5, sex);
                    pts.setString(6, address);
                    int count = pts.executeUpdate();
                    if (count > 0) {
                        jl27.setText("注册成功");
                        jt21.setText("");
                        jt22.setText("");
                        jt23.setText("");
                        jt24.setText("");
                        jt25.setText("");
                        jt26.setText("");
                    } else {
                        jl27.setText("注册失败");
                    }

                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
        });
        // 点击返回登录的
        jb2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 点击返回登录的时候：处理代码写在这里
                jf1.setVisible(false);
                jf1.dispose();
                login();

            }
        });

        jp2.add(jl21);
        jp2.add(jt21);
        jp2.add(jl22);
        jp2.add(jt22);
        jp2.add(jl23);
        jp2.add(jt23);
        jp2.add(jl24);
        jp2.add(jt24);
        jp2.add(jl25);
        jp2.add(jt25);
        jp2.add(jl26);
        jp2.add(jt26);
        jp2.add(jb2);
        jp2.add(jb1);
        jp2.add(jl27);

        jf1.add(jp2);

        jf1.setVisible(true);// 设置窗体可见：默认是隐藏的false

    }

    // 方法3：链接数据库
    public static void jdbc() {
        // 1、注册驱动:需要写上驱动位置
        // 这一句可能会报异常：所以我们需要处理一下
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 2、建立连接
        String url = "jdbc:mysql://127.0.0.1:3306/niit?useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String userpwd = "root";
        // 这一句可能会报异常：所以我们需要处理一下
        try {
            conn = DriverManager.getConnection(url, username, userpwd);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 方法4：学生的主页
    public static void indexStu() {
        // 来到学生主页我们需要做的是先获取到这个人的信息：
        jdbc();

        jf2 = new JFrame("学生主页");// 创建窗体的时候设置窗体标题
        jf2.setBounds(500, 100, 300, 500);// 一次性设置位置和大小：x,y,w,h
        jf2.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);// 设置默认关闭方式：退出的时候后台也终止
        jf2.setLayout(null);

        // 查询登录这个人的信息
        String sql = "select * from student where id=?";
        PreparedStatement pts = null;
        ResultSet rs = null;

        try {
            pts = conn.prepareStatement(sql);
            pts.setInt(1, indexId);
            rs = pts.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 显示登录这个人的信息的
        JLabel jl1 = null;
        try {
            if (rs.next()) {// 先遍历集合里面是否有值：有值再获取值
                jl1 = new JLabel("欢迎您！：" + rs.getString("name"));
            }

            jl1.setBounds(100, 50, 100, 30);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JButton jb1 = new JButton("查看个人信息");// 创建按钮的同时设置按钮的文本
        jb1.setBounds(60, 100, 200, 30);
        JButton jb2 = new JButton("修改个人信息");// 创建按钮的同时设置按钮的文本
        jb2.setBounds(60, 150, 200, 30);
        JButton jb3 = new JButton("注销（删除）个人信息");// 创建按钮的同时设置按钮的文本
        jb3.setBounds(60, 200, 200, 30);
        JButton jb4 = new JButton("退出登录");// 创建按钮的同时设置按钮的文本
        jb4.setBounds(60, 250, 200, 30);
        JButton jb5 = new JButton("修改密码");// 创建按钮的同时设置按钮的文本
        jb5.setBounds(60, 300, 200, 30);

        // 点击 查看个人信息 按钮 就跳转到查看个人信息界面
        jb1.addActionListener((e) -> {
            jf2.setVisible(false);
            jf2.dispose();
            showSelf();
        });

        // 点击 修改个人信息 按钮 就跳转到修改个人信息界面
        jb2.addActionListener((e) -> {
            jf2.setVisible(false);
            jf2.dispose();
            editSelf();
        });

        // 暂时不写：：点击 注销（删除）个人信息 按钮 就跳转到注销（删除）个人信息界面

        // 点击 退出登录 就回到 登录页面
        jb4.addActionListener((e) -> {
            jf2.setVisible(false);
            jf2.dispose();
            login();
        });

        //修改密码
        jb5.addActionListener((e) -> {
            jf2.setVisible(false);
            jf2.dispose();
            editPwd();
        });

        jf2.add(jl1);
        jf2.add(jb1);
        jf2.add(jb2);
        jf2.add(jb3);
        jf2.add(jb4);
        jf2.add(jb5);

        jf2.setVisible(true);
    }

    // 5：显示个人信息界面
    public static void showSelf() {
        jf3 = new JFrame("显示个人界面");// 创建窗体的时候设置窗体标题
        jf3.setBounds(500, 100, 300, 500);// 一次性设置位置和大小：x,y,w,h
        jf3.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);// 设置默认关闭方式：退出的时候后台也终止

        JPanel jp2 = new JPanel();// 创建注册面板
        jp2.setBackground(Color.pink);
        // 面板默认布局方式是：流式布局
        jp2.setLayout(null);// 绝对布局：里面的内容就可以按照自己想要的方式排版
        // jp2.setVisible(false);//一开始设置隐藏
        // jp2.setOpaque(false);

        JLabel jl21 = new JLabel("请输入账号：");
        jl21.setBounds(40, 50, 100, 30);
        JTextField jt21 = new JTextField();
        jt21.setBounds(140, 50, 100, 30);

        JLabel jl22 = new JLabel("请输入名字：");
        jl22.setBounds(40, 90, 100, 30);
        JTextField jt22 = new JTextField();
        jt22.setBounds(140, 90, 100, 30);

        JLabel jl23 = new JLabel("请输入密码：");
        jl23.setBounds(40, 130, 100, 30);
        JTextField jt23 = new JTextField();
        jt23.setBounds(140, 130, 100, 30);

        JLabel jl24 = new JLabel("请输入年龄：");
        jl24.setBounds(40, 170, 100, 30);
        JTextField jt24 = new JTextField();
        jt24.setBounds(140, 170, 100, 30);

        JLabel jl25 = new JLabel("请输入性别：");
        jl25.setBounds(40, 210, 100, 30);
        JTextField jt25 = new JTextField();
        jt25.setBounds(140, 210, 100, 30);

        JLabel jl26 = new JLabel("请输入地址：");
        jl26.setBounds(40, 250, 100, 30);
        JTextField jt26 = new JTextField();
        jt26.setBounds(140, 250, 100, 30);

        JButton jb1 = new JButton("返回个人主页");// 创建按钮的同时设置按钮的文本
        jb1.setBounds(75, 300, 150, 30);

        String sql = "select * from student where id=?";
        PreparedStatement pts = null;
        ResultSet rs = null;

        try {
            pts = conn.prepareStatement(sql);
            pts.setInt(1, indexId);
            rs = pts.executeQuery();
            if (rs.next()) {// 先遍历集合里面是否有值：有值再获取值
                jt21.setText(rs.getString("id"));
                jt22.setText(rs.getString("name"));
                jt23.setText(rs.getString("pwd"));
                jt24.setText(rs.getString("age"));
                jt25.setText(rs.getString("sex"));
                jt26.setText(rs.getString("address"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        jb1.addActionListener((e) -> {
            jf3.setVisible(false);
            jf3.dispose();
            indexStu();
        });

        jp2.add(jl21);
        jp2.add(jt21);
        jp2.add(jl22);
        jp2.add(jt22);
        jp2.add(jl23);
        jp2.add(jt23);
        jp2.add(jl24);
        jp2.add(jt24);
        jp2.add(jl25);
        jp2.add(jt25);
        jp2.add(jl26);
        jp2.add(jt26);
        jp2.add(jb1);

        jf3.add(jp2);

        jf3.setVisible(true);// 设置窗体可见：默认是隐藏的false
    }

    // 5：显示个人信息界面
    public static void editSelf() {
        jf4 = new JFrame("修改个人界面");// 创建窗体的时候设置窗体标题
        jf4.setBounds(500, 100, 300, 500);// 一次性设置位置和大小：x,y,w,h
        jf4.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);// 设置默认关闭方式：退出的时候后台也终止

        JPanel jp2 = new JPanel();// 创建注册面板
        jp2.setBackground(Color.pink);
        // 面板默认布局方式是：流式布局
        jp2.setLayout(null);// 绝对布局：里面的内容就可以按照自己想要的方式排版
        // jp2.setVisible(false);//一开始设置隐藏
        // jp2.setOpaque(false);

        JLabel jl22 = new JLabel("请输入名字：");
        jl22.setBounds(40, 90, 100, 30);
        JTextField jt22 = new JTextField();
        jt22.setBounds(140, 90, 100, 30);

        JLabel jl23 = new JLabel("请输入密码：");
        jl23.setBounds(40, 130, 100, 30);
        JTextField jt23 = new JTextField();
        jt23.setBounds(140, 130, 100, 30);

        JLabel jl24 = new JLabel("请输入年龄：");
        jl24.setBounds(40, 170, 100, 30);
        JTextField jt24 = new JTextField();
        jt24.setBounds(140, 170, 100, 30);

        JLabel jl25 = new JLabel("请输入性别：");
        jl25.setBounds(40, 210, 100, 30);
        JTextField jt25 = new JTextField();
        jt25.setBounds(140, 210, 100, 30);

        JLabel jl26 = new JLabel("请输入地址：");
        jl26.setBounds(40, 250, 100, 30);
        JTextField jt26 = new JTextField();
        jt26.setBounds(140, 250, 100, 30);

        JButton jb1 = new JButton("返回个人主页");// 创建按钮的同时设置按钮的文本
        jb1.setBounds(75, 300, 150, 30);

        JButton jb2 = new JButton("修改信息");// 创建按钮的同时设置按钮的文本
        jb2.setBounds(75, 350, 150, 30);

        JLabel jb3 = new JLabel();
        jb3.setBounds(75, 400, 150, 30);

        String sql = "select * from student where id=?";
        PreparedStatement pts = null;
        ResultSet rs = null;

        try {
            pts = conn.prepareStatement(sql);
            pts.setInt(1, indexId);
            rs = pts.executeQuery();
            if (rs.next()) {// 先遍历集合里面是否有值：有值再获取值
                jt22.setText(rs.getString("name"));
                indexPwd = rs.getString("pwd");
                jt23.setText(indexPwd);
                jt24.setText(rs.getString("age"));
                jt25.setText(rs.getString("sex"));
                jt26.setText(rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jb1.addActionListener((e) -> {
            jf4.setVisible(false);
            jf4.dispose();
            indexStu();
        });

        jb2.addActionListener((e) -> {
            String sql1 = "update student set name = ?, pwd = ?, age = ?, sex = ?, address = ? where id = " + indexId
                    + ";";
            try {
                PreparedStatement sta = conn.prepareStatement(sql1);
                sta.setString(1, jt22.getText());
                sta.setString(2, jt23.getText());
                sta.setInt(3, Integer.parseInt(jt24.getText()));
                sta.setString(4, jt25.getText());
                sta.setString(5, jt26.getText());
                jb3.setText(sta.executeUpdate() > 0 ? "修改成功" : "修改失败");
                if (!indexPwd.equals(jt23.getText())) {
                    jb3.setText("请重新登陆");
                    jf4.setVisible(false);
                    jf4.dispose();
                    login();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });

        jp2.add(jl22);
        jp2.add(jt22);
        jp2.add(jl23);
        jp2.add(jt23);
        jp2.add(jl24);
        jp2.add(jt24);
        jp2.add(jl25);
        jp2.add(jt25);
        jp2.add(jl26);
        jp2.add(jt26);
        jp2.add(jb1);
        jp2.add(jb2);
        jp2.add(jb3);

        jf4.add(jp2);

        jf4.setVisible(true);// 设置窗体可见：默认是隐藏的false
    }

    // 5：显示个人信息界面
    public static void editPwd() {
        jf4 = new JFrame("修改个人密码");// 创建窗体的时候设置窗体标题
        jf4.setBounds(500, 100, 300, 500);// 一次性设置位置和大小：x,y,w,h
        jf4.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);// 设置默认关闭方式：退出的时候后台也终止

        JPanel jp2 = new JPanel();// 创建注册面板
        jp2.setBackground(Color.pink);
        // 面板默认布局方式是：流式布局
        jp2.setLayout(null);// 绝对布局：里面的内容就可以按照自己想要的方式排版
        // jp2.setVisible(false);//一开始设置隐藏
        // jp2.setOpaque(false);

        JLabel jl23 = new JLabel("请输入密码：");
        jl23.setBounds(40, 130, 100, 30);
        JTextField jt23 = new JTextField();
        jt23.setBounds(140, 130, 100, 30);

        JButton jb1 = new JButton("返回个人主页");// 创建按钮的同时设置按钮的文本
        jb1.setBounds(75, 300, 150, 30);

        JButton jb2 = new JButton("修改密码");// 创建按钮的同时设置按钮的文本
        jb2.setBounds(75, 350, 150, 30);

        JLabel jb3 = new JLabel();
        jb3.setBounds(75, 400, 150, 30);

        jb1.addActionListener((e) -> {
            jf4.setVisible(false);
            jf4.dispose();
            indexStu();
        });

        jb2.addActionListener((e) -> {
            if (jt23.getText().equals("")) {
                jb3.setText("请输入新密码");
                return;
            }
            String sql1 = "update student set pwd = ? where id = " + indexId + ";";
            try {
                PreparedStatement sta = conn.prepareStatement(sql1);
                sta.setString(1, jt23.getText());
                jb3.setText(sta.executeUpdate() > 0 ? "修改成功" : "修改失败");
                jf4.setVisible(false);
                jf4.dispose();
                login();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });

        jp2.add(jl23);
        jp2.add(jt23);
        jp2.add(jb1);
        jp2.add(jb2);
        jp2.add(jb3);

        jf4.add(jp2);

        jf4.setVisible(true);// 设置窗体可见：默认是隐藏的false
    }

}
