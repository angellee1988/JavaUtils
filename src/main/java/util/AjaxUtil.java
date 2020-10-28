package util;

import javax.servlet.http.HttpServletRequest;

public class AjaxUtil {
	/**
	 * 
	 * @Description: 判断是否是AJAX请求 
	 * @param request
	 * @return 
	 * @return: Boolean      
	 * @throws
	 */
	public static Boolean isAjax(HttpServletRequest request){
		String requestType=request.getHeader("X-Requested-With");
		return (null != requestType && requestType.equals("XMLHttpRequest"));
	}
	
	/**
	 * 
	 * @Description: 判断JSONP请求 
	 * @param request
	 * @return 
	 * @return: Boolean      
	 * @throws
	 */
	public static Boolean isJsonp(HttpServletRequest request){
		return (isAjax(request) && null!=request.getParameter("callback"));
	}

}
