package com.Controller;
import java.util.*;
import com.DAO.*;
import com.Model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;


@WebServlet("/LanguageController")
public class LanguageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CountryLanguageDAO langDao;
    
    public LanguageController() {
        super();
        langDao = new CountryLanguageDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		List<CountryLanguage> lang = langDao.loadLingo();
		Gson gson = new Gson();
		response.getWriter().write(gson.toJson(lang));
		response.setContentType("application/json");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
