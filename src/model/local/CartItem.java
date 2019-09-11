package model.local;

public class CartItem {
	
	private Product vare;
	private String description;
	private Integer quantity;
	
	public CartItem() {
		this(null,null,null);
	}
	
	public CartItem(Product product, String description, Integer quantity) {
		this.vare = product;
		this.quantity = quantity;
		this.description = description;
	}

	public Product getVare() {
		return vare;
	}
	public void setVare(Product vare) {
		this.vare = vare;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalPrice() {
		return Double.parseDouble(vare.getPriceInEuro()) * this.quantity;
	}
}
