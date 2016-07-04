package com.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import world.dao.CityDao;
import world.domain.City;
import world.ConnectionManager;

@SuppressWarnings("serial")
public class GuiClass extends JFrame implements ActionListener {

	JLabel lb;
	JTextField tf;
	JButton btn;
	JTable table;
	CityDao dao = new CityDao();
	CityTableModel ctm = new CityTableModel();

	public void searchByName() {

		lb = new JLabel("Enter Name:");
		lb.setBounds(20, 20, 100, 20);
		tf = new JTextField(20);
		tf.setBounds(100, 20, 200, 20);

		btn = new JButton("Submit");
		btn.setBounds(350, 20, 100, 20);
		btn.addActionListener(this);

		table = new JTable();
		table.setBounds(30, 40, 200, 300);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 1000);
		setLayout(null);

		// Add components to the JFrame
		add(lb);
		add(tf);
		add(btn);

		List<City> citylist = dao.loadCities();
		ctm.setCities(citylist);
		setLayout(new BorderLayout(4, 4));
		add(scrolltable(ctm), BorderLayout.SOUTH);

		setVisible(true);

		// Set TextField Editable False
		tf.setEditable(true);

	}

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {

		String str = tf.getText();
		ConnectionManager con = new ConnectionManager();
		try {
			Connection conn = con.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from city where name=?");
			pstmt.setString(1, str);

			// Executing Query
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {

				List<City> list = dao.findByName(tf.getText());
				System.out.println(list.size());

				ctm.setCities(list);

			} else {
				JOptionPane.showMessageDialog(null, "Name not Found");
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

	}

	public JScrollPane scrolltable(AbstractTableModel model) {
		JTable tb = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(tb);
		return scrollpane;
	}

}
