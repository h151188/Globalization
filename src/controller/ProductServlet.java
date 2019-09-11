package controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataaccess.Database;
import model.local.Description;
import utils.CookieHelper;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Locale locale = CookieHelper.getLocale(request, response);
        
        List<Description> des = Database.findLocaleDescriptions(locale);
        request.setAttribute("des", des);
		request.getRequestDispatcher("WEB-INF/jsp/products.jsp").forward(request, response);
	}
}
