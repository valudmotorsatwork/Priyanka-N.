package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.DAO.DAO;
import com.google.gson.Gson;
import com.model.City;


@WebServlet("/DD")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO data = null;

	public GetServlet() 
	{
		super();
		data = new DAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{

		try
		{

			List<City> cities = data.getData();
			Gson gson = new Gson();
			response.setContentType("application/json");
			response.getWriter().write(gson.toJson(cities));

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		
		try 
		{
			Gson gson = new Gson();
			com.model.City city = parseRequest(request);
			String type = request.getQueryString();
			switch (type) 
			{

			case "update": 
			{
				data.doUpdate(city);
				break;
			}

			case "create": 
			{
				data.docreate(city);
				response.getWriter().write(gson.toJson(city));
				break;
			}
			case "destroy": 
			{
				data.doDelete(city);
				break;
			}

			}

		} catch (Exception e) 
		{
			System.err.println(" Enter valid value");
		}

	}

	private com.model.City parseRequest(HttpServletRequest request) 
	{
		com.model.City city = new City();
		city.setId(request.getParameter("id"));
		city.setName(request.getParameter("name"));
		city.setCountrycode(request.getParameter("countrycode"));
		city.setDistrict(request.getParameter("district"));
		city.setPopulation(request.getParameter("population"));
		return city;
	}

}
