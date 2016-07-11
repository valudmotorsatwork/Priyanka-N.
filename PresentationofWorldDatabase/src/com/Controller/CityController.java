package com.Controller;

import java.util.*;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.*;
import com.Model.*;
import com.DAO.*;

@WebServlet("/CityController")
public class CityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CityDAO cityDao;   
    CountryDAO cdao;
    public CityController() {
        super();
        cityDao = new CityDAO();
        cdao = new CountryDAO();
    }

	
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		List<City> cities = cityDao.loadCity();
		Gson gson = new Gson();
		response.setContentType("application/json");
		response.getWriter().write(gson.toJson(cities));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try 
		{
			if(request.getParameter("action").equals("Create"))
				cityDao.saveRecord(parseRequest(request));
			else if(request.getParameter("action").equals("Update"))
				cityDao.updateRecord(parseRequest(request));
			if(request.getParameter("action").equals("Delete"))
				cityDao.deleteRecord(request.getParameter("cityId"));
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public City parseRequest(HttpServletRequest request)
	{
		City city = new City();
		city.setID(request.getParameter("id"));
		city.setName(request.getParameter("name"));
		city.setCountryCode(request.getParameter("countryCode"));
		city.setDistrict(request.getParameter("district"));
		city.setPopulation(request.getParameter("population"));
		return city;
	}
}
