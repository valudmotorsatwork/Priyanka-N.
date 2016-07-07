package com.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import world.dao.CityDao;
import world.domain.City;
import world.ConnectionManager;

@SuppressWarnings("serial")
public class GuiClass extends JFrame implements ActionListener {

	JLabel lb, lb1, lb2, lb3, lb4, lb5;
	JTextField tf, tf1, tf2, tf3, tf4, tf5;
	JButton btn, btn1, btn2, btn3;
	JTable table;
	Connection con;
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
		btn1 = new JButton("Insert");
		btn1.setBounds(20, 250, 100, 20);
		btn1.addActionListener(this);

		lb5 = new JLabel("Insert Data:");
		lb5.setBounds(20, 60, 100, 20);

		lb5 = new JLabel("City id:");
		lb5.setBounds(20, 90, 100, 20);
		tf5 = new JTextField(20);
		tf5.setBounds(100, 90, 200, 20);

		lb1 = new JLabel("Name:");
		lb1.setBounds(20, 120, 100, 20);
		tf1 = new JTextField(20);
		tf1.setBounds(100, 120, 200, 20);

		lb2 = new JLabel("District:");
		lb2.setBounds(20, 150, 100, 20);
		tf2 = new JTextField(20);
		tf2.setBounds(100, 150, 200, 20);

		lb3 = new JLabel("Country Code:");
		lb3.setBounds(20, 180, 100, 20);
		tf3 = new JTextField(20);
		tf3.setBounds(100, 180, 200, 20);

		lb4 = new JLabel("Population:");
		lb4.setBounds(20, 210, 100, 20);
		tf4 = new JTextField(20);
		tf4.setBounds(100, 210, 200, 20);

		btn2 = new JButton("Delete");
		btn2.setBounds(460, 20, 100, 20);
		btn2.addActionListener(this);

		btn3 = new JButton("Update");
		btn3.setBounds(150, 250, 100, 20);
		btn3.addActionListener(this);

		add(lb1);
		add(tf1);
		add(lb5);
		add(btn);

		add(lb2);
		add(tf2);
		add(lb3);
		add(tf3);
		add(lb4);
		add(tf4);
		add(btn1);
		add(lb5);
		add(tf5);
		add(btn2);
		add(btn3);
		setVisible(true);

		tf1.setEditable(true);
		List<City> citylist = dao.loadCities();
		ctm.setCities(citylist);
		setLayout(new BorderLayout(4, 4));
		add(scrolltable(ctm), BorderLayout.SOUTH);

		setVisible(true);
		tf.setEditable(true);
		tf1.setEditable(true);
		tf2.setEditable(true);
		tf3.setEditable(true);
		tf4.setEditable(true);

		// Set TextField Editable False
		tf.setEditable(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("Insert"))
			insertCity();
		else if (action.equals("Submit"))
			searchCity();
		else if (action.equals("Delete"))
			deleteCity();
		else if (action.equals("Update"))
			try {
				updateCity();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}

	}

	private void updateCity() throws SQLException {
		String sql = "Update City " + "SET id = '" + tf5.getText() + "'," + "name = '" + tf1.getText() + "',"
				+ "countrycode = '" + tf3.getText() + "'," + "district = '" + tf2.getText() + "'," + "population = '"
				+ tf4.getText() + "'" + "Where name = '" + tf1.getText() + "'";

		JOptionPane.showMessageDialog(null, sql, "Record Updated",

				JOptionPane.INFORMATION_MESSAGE);
		try {
			Statement st = con.createStatement();

			st.execute(sql);

			JOptionPane.showMessageDialog(null, "Record Update Succesfully.",

					"Record Updated", JOptionPane.INFORMATION_MESSAGE);
			// clearControls();

		} catch (Exception e)

		{

			JOptionPane.showMessageDialog(null, e.getMessage(), "Error",

					JOptionPane.ERROR_MESSAGE);

		}

	}

	@SuppressWarnings("static-access")
	private void deleteCity() {
		int ans = JOptionPane.showConfirmDialog(null, "Are you sure to delete the Record ?", "Delete Record",

				JOptionPane.YES_NO_OPTION);
		ConnectionManager con = new ConnectionManager();

		if (ans == JOptionPane.YES_OPTION)

		{
			String sql = "Delete FROM city where name = '" + tf.getText() + "'";
			try {
				Connection conn = con.getConnection();
				Statement stmt = conn.createStatement();
				stmt.execute(sql);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}

			JOptionPane.showMessageDialog(null, "Record Deleted", "Success",

					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Operation Canceled", "Cancel", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@SuppressWarnings("static-access")
	private void searchCity() {
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

	@SuppressWarnings("static-access")
	private void insertCity() {
		
		System.out.println("hello");
		String sql = "INSERT INTO city (id,name,countrycode,district,population)" + "  VALUES('" + tf5.getText() + "','"
				+ tf1.getText() + "'," + "'" + tf3.getText() + "'," + "'" + tf2.getText() + "'," + "'" + tf4.getText()
				+ "' )";
		ConnectionManager obj = new ConnectionManager();
		try {
			Connection conn = obj.getConnection();
			Statement stmt = conn.createStatement();
			
			stmt.execute(sql);
			JOptionPane.showMessageDialog(null, "Record Added Succesfully.", "Record Added",
					JOptionPane.INFORMATION_MESSAGE);

			

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error",

					JOptionPane.ERROR_MESSAGE);
		}
	}

	public JScrollPane scrolltable(AbstractTableModel model) {
		JTable tb = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(tb);
		return scrollpane;
	}

}
