package dataaccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.local.Description;
import model.local.Product;

@WebListener
public class Database implements ServletContextListener {

	private static List<Description> descriptions = new ArrayList<Description>();
	private static List<Product> products = new ArrayList<Product>();

	public void contextDestroyed(ServletContextEvent arg0) {}

	/**
	 * Initializes the database with products and descriptions locally at runtime.
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		Product p1 = new Product("1", "White Coffee Cup", "6.5", "images/white_coffee_cup.jpg");
		Product p2 = new Product("2", "Black Coffee Cup", "4.75", "images/black_coffee_cup.jpg");

		products.add(p1);
		products.add(p2);

		Description d1 = new Description(p1, "en_us", "A white cup with a plate. Made from high quality ceramic, perfect for family use, simple design");
		Description d2 = new Description(p2, "en_us", "A black cup with a plate. Made from high quality ceramic, perfect for family use, simple design");
		Description d3 = new Description(p1, "no_no", "Hvit Kaffekopp. Laget av høy kvalitet keramikk, perfekt for familiebruk, enkel design");
		Description d4 = new Description(p2, "no_no", "Svart Kaffekopp. Laget av høy kvalitet keramikk, perfekt for familiebruk, enkel design");
		Description d5 = new Description(p1, "es_es", "Una taza blanca con un plato. Hecho de cerámica de alta calidad, perfecto para uso familiar, diseño simple");
		Description d6 = new Description(p2, "es_es", "Una taza negra con un plato. Hecho de cerámica de alta calidad, perfecto para uso familiar, diseño simple");

		descriptions.add(d1);
		descriptions.add(d2);
		descriptions.add(d3);
		descriptions.add(d4);
		descriptions.add(d5);
		descriptions.add(d6);
	}

	/**
	 * Returns all descriptions.
	 * @return
	 */
	public static List<Description> getDescriptions() {
		return descriptions;
	}

	/**
	 * Returns all products.
	 * @return
	 */
	public static List<Product> getProducts() {
		return products;
	}

	/**
	 * Returns the locale descriptions.
	 * @param locale
	 * @return
	 */
	public static List<Description> findLocaleDescriptions(Locale locale) {
		List<Description> result = new ArrayList<Description>();

		for (Description d : descriptions) {
			if (d.getLangCode().equals(locale.getLanguage())) {
				result.add(d);
			}
		}

		return result;
	}
}
