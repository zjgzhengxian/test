package org.leonhardt.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AccessPanel extends JPanel {

	private JTextField textField_path;
	private File file;

	public AccessPanel() {
		GridBagLayout gbl_panel_visit = new GridBagLayout();
		gbl_panel_visit.columnWidths = new int[]{0, 0, 0};
		gbl_panel_visit.rowHeights = new int[]{0, 0, 0};
		gbl_panel_visit.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_panel_visit.rowWeights = new double[]{0.0, 0.0, 1.0};
		setLayout(gbl_panel_visit);

		JLabel label_path = new JLabel("保存文件地址：");
		GridBagConstraints gbc_label_path = new GridBagConstraints();
		gbc_label_path.fill = GridBagConstraints.VERTICAL;
		gbc_label_path.anchor = GridBagConstraints.EAST;
		gbc_label_path.insets = new Insets(10, 10, 10, 0);
		gbc_label_path.gridx = 0;
		gbc_label_path.gridy = 0;
		add(label_path, gbc_label_path);

		textField_path = new JTextField();
		GridBagConstraints gbc_textField_path = new GridBagConstraints();
		gbc_textField_path.insets = new Insets(10, 0, 10, 0);
		gbc_textField_path.fill = GridBagConstraints.BOTH;
		gbc_textField_path.gridx = 1;
		gbc_textField_path.gridy = 0;
		add(textField_path, gbc_textField_path);
		textField_path.setColumns(10);

		JButton button_path = new JButton("浏览");
		GridBagConstraints gbc_button_path = new GridBagConstraints();
		gbc_button_path.fill = GridBagConstraints.VERTICAL;
		gbc_button_path.insets = new Insets(10, 10, 10, 10);
		gbc_button_path.gridx = 2;
		gbc_button_path.gridy = 0;
		add(button_path, gbc_button_path);

		JButton button_visit = new JButton("开\u3000始");
		GridBagConstraints gbc_button_visit = new GridBagConstraints();
		gbc_button_visit.fill = GridBagConstraints.VERTICAL;
		gbc_button_visit.insets = new Insets(0, 10, 10, 0);
		gbc_button_visit.gridx = 0;
		gbc_button_visit.gridy = 1;
		add(button_visit, gbc_button_visit);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 10, 10, 10);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		button_path.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showSaveDialog(AccessPanel.this) == JFileChooser.APPROVE_OPTION) {
					file = fileChooser.getSelectedFile();
					if (!file.getName().endsWith(".txt")) {
						file = new File(file.getAbsolutePath() + ".txt");
					}
					textField_path.setText(file.getAbsolutePath());
				}
			}
		});

		button_visit.addActionListener(new ActionListener() {
			@SuppressWarnings("ResultOfMethodCallIgnored")
			@Override
			public void actionPerformed(ActionEvent event) {
				if (file == null) {
					JOptionPane.showMessageDialog(AccessPanel.this, "请选择保存文件！", "错误", JOptionPane.ERROR_MESSAGE);
					return;
				}
				file.getParentFile().mkdirs();
				if (!file.getParentFile().exists()) {
					JOptionPane.showMessageDialog(AccessPanel.this, "文件路径不存在或文件路径错误！", "错误", JOptionPane.ERROR_MESSAGE);
					return;
				}

			}
		});
	}
}