package controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import model.local.CartItem;
import model.local.Product;

public class ShoppingCart {

	private List<CartItem> items;

	public ShoppingCart() {
		items = new ArrayList<CartItem>();
	}

	/**
	 * Add a product to the shopping cart.
	 * @param product
	 */
	public void addCartItem(Product product) {
		if (productExists(product)) {
			for (CartItem c : items) {
				if (c.getVare().getPno().equals(product.getPno())) {
					c.setQuantity(c.getQuantity() + 1);
				}
			}

		} else {
			CartItem c2 = new CartItem(product, "", 1);
			items.add(c2);
		}
	}

	/**
	 * Function to check if a product is already in the shopping cart.
	 * @param product
	 * @return
	 */
	public boolean productExists(Product product) {
		boolean found = false;
		if (items != null) {
			for (CartItem c : items) {
				if (c.getVare() == product) {
					found = true;
				}
			}
		}
		return found;
	}

	/**
	 * Returns the whole shopping cart.
	 * @return
	 */
	public List<CartItem> getItems() {
		return items;
	}

	/**
	 * Returns the total price of the shopping cart.
	 * @param locale
	 * @return
	 */
	public String getTotalPrice(Locale locale) {
		Double total_a = 0.00;

		for (CartItem i : items) {
			total_a += (i.getQuantity() * Double.parseDouble(i.getVare().getPriceInEuro()));
		}
		NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
		String price = formatter.format(total_a);
		return price;
	}
}
