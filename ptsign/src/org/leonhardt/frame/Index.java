package org.leonhardt.frame;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;

public class Index extends JFrame {

	public static final Dimension DIMENSION = Toolkit.getDefaultToolkit().getScreenSize();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Index() {
		initGlobalFontSetting(new Font("微软雅黑", Font.PLAIN, 12));
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Dimension size = new Dimension(400, 300);
		setMinimumSize(size);
		setSize(size);
		setLocation((DIMENSION.width - size.width) / 2, (DIMENSION.height - size.height) / 2);
		getContentPane().setLayout(new CardLayout(0, 0));



		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);

		tabbedPane.addTab("访问PT站点", new AccessPanel());

		tabbedPane.addTab("浏览cookie", new CookieManagePanel());

		JPanel panel_about = new JPanel();
		tabbedPane.addTab("\u5173\u4E8E", null, panel_about, null);
		GridBagLayout gbl_panel_about = new GridBagLayout();
		gbl_panel_about.columnWidths = new int[]{0};
		gbl_panel_about.rowHeights = new int[]{0};
		gbl_panel_about.columnWeights = new double[]{0};
		gbl_panel_about.rowWeights = new double[]{0};
		panel_about.setLayout(gbl_panel_about);
	}

	// 设置全局字体
	private static void initGlobalFontSetting(Font font) {
		FontUIResource fontRes = new FontUIResource(font);
		for (Enumeration<?> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource) {
				UIManager.put(key, fontRes);
			}
		}
	}
}