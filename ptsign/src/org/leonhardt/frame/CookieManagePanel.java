package org.leonhardt.frame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CookieManagePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CookieManagePanel() {
		setLayout(new CardLayout());
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0 };
		gbl_panel.rowHeights = new int[] { 25, 0,25,0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0 };
		gbl_panel.rowWeights = new double[] { 0, 0,0,0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		JTable table = new JTable(2,2);
		table.setBorder(new LineBorder(Color.black));
		table.getColumnModel().getColumn(0).setPreferredWidth(170);
		table.setForeground(Color.darkGray);
		table.setBackground(Color.lightGray);
		table.setEnabled(false);
		table.setShowGrid(true);
		//table.setShowHorizontalLines(false);
		//table.setShowVerticalLines(false);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		table.setValueAt("aaa", 0, 0);
		table.setValueAt("bbb", 0, 1);
		table.updateUI();
		panel.add(table, gbc_table);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JTable table_1 = new JTable();
		table_1.setForeground(Color.darkGray);
		table_1.setBackground(Color.lightGray);
		table_1.setEnabled(false);
		table_1.setShowHorizontalLines(false);
		table_1.setShowVerticalLines(false);
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.fill = GridBagConstraints.BOTH;
		gbc_table_1.gridx = 0;
		gbc_table_1.gridy = 3;
		panel.add(table_1, gbc_table_1);
	}
}