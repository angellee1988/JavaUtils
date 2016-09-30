package util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 邮件或短信模板帮助类
 * @author 金砖
 *
 */
public class MessageTemplateUtil {
	/**
	 * 邮件或短信模板参数替换方法
	 * @param paramMap
	 * @param content
	 * @return
	 */
	public static String getContent(Map paramMap,String content,String templateParamNames){
		if(templateParamNames==null || "".equals(templateParamNames) ){
			return content;
		}
		Map resultMap = paramControl(paramMap, templateParamNames);
	    Set<String> set = resultMap.keySet();
	    Iterator<String> iter = set.iterator();
	    while(iter.hasNext()){
	        String key = iter.next();
	        String value = resultMap.get(key).toString();
	        content = content.replace("${" + key + "}", value);
	    }
		return content;
	}

	/**
	 * 补齐参数
	 * @param paramMap 参数Map
	 * @param templateParamName 模板参数名
	 * @return
	 */
	private static Map paramControl(Map paramMap,String templateParamNames){
		String[] paramNames = templateParamNames.split(",");
		Map resultMap = new HashMap();
		for(int i=0;i<paramNames.length;i++){
			String key = paramNames[i];
			if(paramMap.get(key)!=null){
				resultMap.put(key, paramMap.get(key).toString());
			}else{
				resultMap.put(key, "");
			}
		}
		return resultMap;
	}	
}
