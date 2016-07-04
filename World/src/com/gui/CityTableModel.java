package com.gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import world.domain.City;

@SuppressWarnings("serial")
public class CityTableModel extends AbstractTableModel {
	/** the city data to show in JTable */
	private List<City> cities;
	/** the column names to show in JTable */
	private static final String[] FIELD_NAMES = { "Name", "District", "Country", "Population" };

	public CityTableModel() {
		cities = new java.util.ArrayList<City>(); // to avoid NullPointer
	}

	public String getColumnName(int column) {
		if (column < FIELD_NAMES.length)
			return FIELD_NAMES[column];
		return ""; // unknown column
	}

	public int getColumnCount() {
		return FIELD_NAMES.length;
	}

	public int getRowCount() {
		return cities.size();
	}

	public Object getValueAt(int row, int col) {

		if (row >= cities.size())
			return "";
		City city = cities.get(row);
		switch (col) {
		case 0:
			return city.getName();
		case 1:
			return city.getDistrict();
		case 2:
			return city.getCountrycode();
		case 3:
			return city.getPopulation();
		default:
			return "";
		}
	}

	/**
	 * Set the list of cities to display in table.
	 * 
	 * @param cities
	 *            list of City data to display. Must not be null.
	 */
	public void setCities(List<City> cities) {
		assert cities != null;
		this.cities = cities;
		fireTableDataChanged();
	}
}
