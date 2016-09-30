package util;

import org.apache.zookeeper.data.Stat;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 *字符串工具类  
 *@author zhouym 2015-07-27
 */
public class StringUtil {

	/**
     * @Title: isNotBlack
     * @Description: 字符串是否不是空串
     * @param @param str
     * @param @return
     * @return boolean
     * @throws
     */
    public static boolean isNotBlack(String str) {
        if (null == str) {
            return false;
        }
        str = str.trim();
        if (str.length() <= 0) {
            return false;
        }
        return true;
    }

    /**
     * @Title: isNumbic
     * @Description: str是否是字符串
     * @param @param str
     * @param @return
     * @return boolean
     * @throws
     */
    public static boolean isNumbic(String str) {
        if (null == str) {
            return false;
        }
        str = str.trim();
        for (int i = str.length(); --i >= 0;) {
            int chr = str.charAt(i);
            if (chr < 48 || chr > 57)
                return false;
        }
        return true;
    }

    public static boolean isBlack(String str) {
        return !StringUtil.isNotBlack(str);
    }

    public static String listJoin(List<String> stringList, String linkSymbol) {
        StringBuffer buffer = new StringBuffer();
        if (null == stringList || stringList.size() == 0) {
            return "";
        }
        int count = stringList.size();
        for (int i = 0; i < stringList.size(); i++) {
            buffer.append(stringList.get(i));
            if (i + 1 != count) {
                buffer.append(linkSymbol);
            }
        }
        return buffer.toString();
    }
    
    /**
     * 分割字符串，返回 int 类型
     * @param string
     * @return List<Integer>
     */
    public static List<Integer> splitReturnInteger(String string){
    	List<Integer> list = new ArrayList<Integer>();
    	if(string!=null){
    		String[] sourceStrArray = string.split(",");
        	if(sourceStrArray!=null && sourceStrArray.length>0){
        		for(String str : sourceStrArray){
        			list.add(Integer.parseInt(str));
        		}
        		return list;
        	}
    	}
    	return null;
    }
    
    /**
     * 分割字符串，返回 String 类型
     * @param string
     * @return List<String>
     */
    public static List<String> splitReturnString(String string){
    	List<String> list = new ArrayList<String>();
    	if(string!=null){
    		String[] sourceStrArray = string.split(",");
        	if(sourceStrArray!=null && sourceStrArray.length>0){
        		for(String str : sourceStrArray){
        			list.add(str);
        		}
        		return list;
        	}
    	}
    	return null;
    }


    public static String replacedStr(String place,String replaced,String content){
        return content.replace(place,replaced);
    }
}
