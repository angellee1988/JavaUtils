package util;

import javax.servlet.http.HttpServletRequest;

/**   
 * @Description:TODO 
 * @author: rickycoder
 * @date:   2014年12月24日 下午7:48:45   
 * 久兴信息技术(上海)有限公司   
 */
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
