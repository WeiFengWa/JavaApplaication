
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Test15 {

	public static void main(String[] args) {

		JFrame jFrame = new JFrame("QQ注册");// 创建窗体并且设置标题
		jFrame.setBounds(500, 100, 500, 500); // 色湖之窗体位置和大小
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗体默认关闭方式：关闭的同时终止后台运行
		jFrame.setLayout(null);// 设置窗体布局为空

		String language[] = { "简体中文", "英文", "繁体中文" };// 声明语言数组
		JComboBox<String> jComboBox = new JComboBox<String>(language);// 创建一个下拉列表框：并且属于数据的数据作为列表框的内容
		jComboBox.setBounds(350, 0, 100, 30);

		JLabel j1 = new JLabel("请输入用户名：");
		j1.setBounds(50, 100, 200, 30);

		JTextField jt1 = new JTextField();
		jt1.setBounds(250, 100, 150, 30);

		JLabel j2 = new JLabel("请输入密码：");
		j2.setBounds(50, 150, 200, 30);

		JTextField jt2 = new JTextField();
		jt2.setBounds(250, 150, 150, 30);
		// 如何知道到选中了那种语言：使用条目事件
		jComboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {// 监听下拉列标框内容是否发生变化
				int choose = jComboBox.getSelectedIndex();// 获取语言对应的下标
				// System.out.println(choose);
				// 1、指定语言和国家
				Locale la1 = null;
				switch (choose) {
					case 0:
						// 执行简体中文
						la1 = new Locale("zh", "CN");
						break;
					case 1:
						// 执行英文
						la1 = new Locale("en", "US");
						break;
					case 2:
						// 繁体中文
						la1 = new Locale("zh", "HK");
						break;
				}
				// 2、语言的格式化：其实提前将需要的语言属性文件准备好：这里只是去读取文件信息
				ResourceBundle rBundle = ResourceBundle.getBundle("res", la1);
				// 上面代码已经完成读取属性值
				// 接下来只需要改值即可
				jFrame.setTitle(rBundle.getString("title"));// 获取名为title的键对应的值赋给窗体标题
				j1.setText(rBundle.getString("ts1"));
				j2.setText(rBundle.getString("ts2"));

			}
		});

		

		jFrame.add(jComboBox);
		jFrame.add(j1);
		jFrame.add(jt1);
		jFrame.add(j2);
		jFrame.add(jt2);
		jFrame.setVisible(true);// 设置窗体显示

	}

}
