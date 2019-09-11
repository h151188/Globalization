package model.local;

public class Description {
	
	private Product pno;
	private String langCode;
	private String text;
	
	public Description() {
		this(null,null,null);
	}
	
	public Description(Product pno, String langCode, String text) {
		this.pno = pno;
		this.langCode = langCode;
		this.text = text;
	}

	public Product getPno() {
		return pno;
	}

	public void setPno(Product pno) {
		this.pno = pno;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
