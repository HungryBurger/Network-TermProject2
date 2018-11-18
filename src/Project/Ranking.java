package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ranking extends JFrame {
	public Ranking() {
		setLayout(new BorderLayout());
		String[] a = { "Rank", "ID", "VICTORY", "SCORE" };
		String[][] b = new String[10][4];
		String rank_id, rank_victory, rank_score;
		Dimension dim = new Dimension(1065, 750);

		setPreferredSize(dim);
		pack();
		setResizable(false);
		DefaultTableModel model = new DefaultTableModel(b, a) {
			// Å×ÀÌºí ¼öÁ¤ ¹æÁö.
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);

		JTable table = new JTable(model);
		table.setBackground(new Color(50, 50, 50)); // table ¼Ó »ö±ò
		table.setForeground(Color.white);
		table.setAutoCreateColumnsFromModel(true);
		table.getTableHeader().setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 30)); // header ÆùÆ®
		table.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 35));
		table.getColumn("Rank").setPreferredWidth(10);
		table.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);
		table.getColumn("ID").setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setCellRenderer(celAlignCenter);
		table.getColumn("VICTORY").setPreferredWidth(10);
		table.getColumnModel().getColumn(2).setCellRenderer(celAlignCenter);
		table.getColumn("SCORE").setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setCellRenderer(celAlignCenter);
		table.setRowHeight(35);

		JScrollPane sc = new JScrollPane(table);
		this.add(sc, BorderLayout.CENTER);
		JButton b1 = new JButton();
		b1.setBackground(Color.white);
		JButton b2 = new JButton();
		b2.setBackground(Color.white);
		JButton b3 = new JButton();
		b3.setBackground(Color.black);
		this.add(b1, BorderLayout.LINE_START);
		this.add(b2, BorderLayout.LINE_END);
		ImageIcon img = new ImageIcon("./Image/rank_head.jpg");
		JButton head = new JButton(img);
		head.setBackground(Color.black);
		this.add(head, BorderLayout.PAGE_START);
		this.add(b3, BorderLayout.PAGE_END);
		sc.setPreferredSize(new java.awt.Dimension(210, 200));

		add(sc);
		table.getTableHeader().setReorderingAllowed(false);

		setTitle("Ranking Page");
		setVisible(true);
		System.out.println("This is Rankingpage");
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		try {
			String line = Login.in.readLine();
			System.out.println(line);
			if (line.equals("ranking")) {
				for (int i = 0; i < 4; i++) {
					rank_id = Login.in.readLine();
					rank_victory = Login.in.readLine();
					rank_score = Login.in.readLine();
					System.out.println(rank_id);
					System.out.println(rank_victory);
					System.out.println(rank_score);
					m.insertRow(i, new Object[] { Integer.toString(i + 1), rank_id, rank_victory, rank_score });
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}