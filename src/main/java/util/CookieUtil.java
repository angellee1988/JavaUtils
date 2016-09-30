package util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	private static final int COOKIE_MAX_AGE = 7 * 24 * 3600;
	
	/**
	 * 
	 * @Description: 根据名称删除cookie
	 * @author: simon.JY
	 * @param request
	 * @param response
	 * @param name
	 * @date: 2015年7月1日 下午5:13:45
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
	 * @author: simon.JY
	 * @param request
	 * @param name
	 * @return
	 * @date: 2015年7月1日 下午5:21:35
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
	 * @author: simon.JY
	 * @param request
	 * @param name
	 * @return
	 * @date: 2015年7月1日 下午5:21:35
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
	 * @author: simon.JY
	 * @param response
	 * @param name
	 * @param value  传入需要，URLEncoder.encode()处理的参数
	 * @param maxValue
	 * @param domain
	 * @date: 2015年7月1日 下午5:36:34
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
