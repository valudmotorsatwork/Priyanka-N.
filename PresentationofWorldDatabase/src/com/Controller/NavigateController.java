package com.Controller;

import com.Model.*;
import com.DAO.*;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;


@WebServlet("/NavigateController")
public class NavigateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	   CityDAO cityDao;  
    public NavigateController() {
        super();
        cityDao = new CityDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int take= request.getParameter("take")==null ? 5: Integer.parseInt(request.getParameter("take")); 
		int skip= request.getParameter("skip")==null ? 0: Integer.parseInt(request.getParameter("skip"));
		DataSourceResult result = new DataSourceResult();
		result.setData(cityDao.loadAllCities(skip,take));
		result.setTotal(cityDao.getCount());
		Gson gson = new Gson();
		response.setContentType("application/json");
		response.getWriter().write(gson.toJson(result));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{
			if(request.getParameter("action").equals("Create"))
				cityDao.saveRecord(parseRequest(request));
			else if(request.getParameter("action").equals("Update"))
				cityDao.updateRecord(parseRequest(request));
			if(request.getParameter("action").equals("Delete"))
				cityDao.deleteRecord(request.getParameter("iD"));
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public City parseRequest(HttpServletRequest request)
	{
		City city = new City();
		city.setID(request.getParameter("iD"));
		city.setName(request.getParameter("name"));
		city.setCountryCode(request.getParameter("countryCode"));
		city.setDistrict(request.getParameter("district"));
		city.setPopulation(request.getParameter("population"));
		System.out.println(city.getName());
		return city;
	}
}
