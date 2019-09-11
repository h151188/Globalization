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
import model.local.CartItem;
import model.local.Description;
import model.local.Product;
import utils.CookieHelper;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Locale locale = CookieHelper.getLocale(request, response);

		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		List<Description> descriptions = Database.findLocaleDescriptions(locale);
		
		// Sets the correct description according to locale 
		if(cart != null) {
			List<CartItem> items = cart.getItems();
			for (CartItem item : items) {
				for (Description des : descriptions) {
					if(item.getVare().getPno().equals(des.getPno().getPno())) {
						item.setDescription(des.getText());
					}
				}
			}
			request.setAttribute("items", items);
		}

		request.getRequestDispatcher("WEB-INF/jsp/cart.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Locale locale = CookieHelper.getLocale(request, response);
		String choice = request.getParameter("choice");

		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");	
		List<Product> products = Database.getProducts();
		
		if (choice.equals("delete")) {

		} else if (choice.equals("add")) {
			String product = request.getParameter("id");
			Product productToAdd = null;
			
			for(Product p : products) {
				if(p.getPno().equals(product)) {
					productToAdd = p;
				}
			}
			
			if(cart == null)  {
				cart = new ShoppingCart();
				cart.addCartItem(productToAdd);
			} else {
				cart.addCartItem(productToAdd);
			}
		}
	
		request.getSession().setAttribute("total_a", cart.getTotalPrice(locale));
		request.getSession().setAttribute("cart", cart);
		response.sendRedirect("cart");
	}

}
