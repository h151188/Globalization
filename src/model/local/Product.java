package model.local;

import java.util.Locale;
import java.text.NumberFormat;

public class Product {
	private static final double USDCURRENCY = 1.16;
	private static final double NOKCURRENCY = 1.16;
	
	private String pno;
	private String pName;
	private String priceInEuro;
	private String imageFile;
	private Double localePrice;
	
	public Product() {
		this(null,null,null,null);
	}
	
	public Product(String pno, String pName, String priceInEuro, String imageFile) {
		this.pno = pno;
		this.pName = pName;
		this.priceInEuro = priceInEuro;
		this.imageFile = imageFile;
	}

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getPriceInEuro() {
		return priceInEuro;
	}

	public void setPriceInEuro(String priceInEuro) {
		this.priceInEuro = priceInEuro;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
	
	public String getLocalePrice(Locale locale) {
		System.out.println("Called");
		NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
		Double priceInEuroDouble = Double.parseDouble(this.priceInEuro);
		Double result;
		if(locale.equals("no_no")) {
			result = priceInEuroDouble * NOKCURRENCY;
		} else if (locale.equals("en_us")) {
			result = priceInEuroDouble * USDCURRENCY;
		} else {
			result = priceInEuroDouble;
		}
		String svar = String.valueOf(formatter.format(result));

		return svar;
	}
}