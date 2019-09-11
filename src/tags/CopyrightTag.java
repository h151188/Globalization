package tags;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Converts an integer to roman letters
 *
 * @author Espen Kuvås
 * @author http://java.candidjava.com/tutorial/Java-program-to-convert-integer-to-roman-letters.htm
 */

public class CopyrightTag extends SimpleTagSupport {

	private int since;
	private static int[] bases = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	private static HashMap<Integer, String> map = new HashMap<Integer, String>();

	/**
	 * Sets the tag attribute since.
	 *
	 * @param since
	 *            
	 */
	public final void setSince(final int since) {
		this.since = since;
	}

	@Override
	public final void doTag() throws JspException, IOException {

		setup();

		String result = new String();
		for (int i : bases) {
			while (since >= i) {
				result += map.get(i);
				since -= i;
			}
		}
		
		int year = Calendar.getInstance().get(Calendar.YEAR); 

		String result2 = new String();
		for (int i : bases) {
			while (year >= i) {
				result2 += map.get(i);
				year -= i;
			}
		}
		
		PageContext pageContext = (PageContext) getJspContext();
		JspWriter out = pageContext.getOut();
		out.print("\u00a9 " + result + "-" + result2 + " HVL");


	}

	private static void setup() {
		map.put(1, "I");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(9, "IX");
		map.put(10, "X");
		map.put(40, "XL");
		map.put(50, "L");
		map.put(90, "XC");
		map.put(100, "C");
		map.put(400, "CD");
		map.put(500, "D");
		map.put(900, "CM");
		map.put(1000, "M");
	}

}
