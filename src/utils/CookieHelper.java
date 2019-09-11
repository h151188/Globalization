package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

import java.util.Locale;

public class CookieHelper {
	public static Locale getLocale(HttpServletRequest request, HttpServletResponse response) {
		Locale locale = null;
		Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("locale")) {
                    // Set locale from cookie
                    Config.set(request.getSession(), Config.FMT_LOCALE, cookie.getValue());
                    locale = new Locale(cookie.getValue());
                }
            }
        } else {
            locale = request.getLocale();
            Config.set(request.getSession(), Config.FMT_LOCALE, locale.getLanguage());
            Cookie localeCookie = new Cookie("locale", locale.getLanguage());
            localeCookie.setMaxAge(365 * 24 * 60 * 60); // One year in seconds
            response.addCookie(localeCookie);
            // Cookie with locale sent to client
        }
        return locale;
	}

}
