package tags;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author Espen Kuvås
 *
 */
public class ShortTextTag extends SimpleTagSupport {
	
	private int maxChars;
	
	/**
	 * Sets the tag attribute maxChars.
	 * 
	 * @param maxChars
	 */
	public final void setMaxChars(final int maxChars) {
		this.maxChars = maxChars;
	}

	@Override
	public final void doTag() throws JspException, IOException {
		
        PageContext pageContext = (PageContext) getJspContext();
        JspWriter out = pageContext.getOut();

        StringWriter stringWriter = new StringWriter();
        JspFragment body = getJspBody();
        body.invoke(stringWriter);
        String bodyText = stringWriter.getBuffer().toString();
        
        if(bodyText.length() > maxChars) {
        	String result = bodyText.substring(0, maxChars) + " ...";
        	out.println(result);
        } else {
        	out.println(bodyText);
        }
        
        
		
	}
}
