package util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	private static final int COOKIE_MAX_AGE = 7 * 24 * 3600;
	
	/**
	 * 
	 * @Description: 根据名称删除cookie
	 *
	 */
	public static void removeCookie(HttpServletRequest request,
			HttpServletResponse response, String name) {
		if (null == name) {
			return;
		}
		Cookie cookie = getCookie(request, name);
		if (null != cookie) {
			cookie.setPath("/");
			cookie.setValue(null);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
	}
	
	/**
	 * 
	 * @Description: 根据Cookie名称得到Cookie对象，不存在该对象则返回Null
	 *
	 */
	public static Cookie getCookie(HttpServletRequest request, Object name) {
		Cookie[] cookies = request.getCookies();
		if (null == cookies || null == name) {
			return null;
		}
		Cookie cookie = null;
		for (Cookie c : cookies) {
			if (name.equals(c.getName())) {
				cookie = c;
				break;
			}
		}
		return cookie;
	}
	
	/**
	 * 
	 * @Description: 根据Cookie名称得到Cookie对象，不存在该对象则返回Null
	 *
	 */
	public static String getCookieValue(HttpServletRequest request, Object name) {
		Cookie[] cookies = request.getCookies();
		if (null == cookies || null == name) {
			return null;
		}
		Cookie cookie = null;
		for (Cookie c : cookies) {
			if (name.equals(c.getName())) {
				cookie = c;
				return cookie.getValue();
			}
		}
		return null;
	}

	/**
	 * 添加一条新的Cookie，默认7天过期时间(单位：秒)
	 * 
	 * @param response
	 * @param name
	 * @param value
	 */
	public static void setCookie(HttpServletResponse response, String name,
			String value,String domain) {
		setCookie(response, name, value, COOKIE_MAX_AGE, domain);
	}

	/**
	 * 
	 * @Description: 添加一条新的Cookie，可以指定过期时间(单位：秒)
	 *
	 */
	public static void setCookie(HttpServletResponse response, String name,
			String value, int maxValue, String domain) {
		if (null == name) {
			return;
		}
		if (null == value) {
			value = "";
		}
		Cookie cookie = new Cookie(name, value);
		cookie.setDomain(domain);
		cookie.setPath("/");
		if (maxValue != 0) {
			cookie.setMaxAge(maxValue);
		} else {
			cookie.setMaxAge(COOKIE_MAX_AGE);
		}
		response.addCookie(cookie);
	}

}
