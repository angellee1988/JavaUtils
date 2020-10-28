package util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * UTF编码解码
 */
public class UTFCodeUtil {

	public static String encode(String content){
		String enStr = "";
		try {
			enStr = URLEncoder.encode(content,"UTF-8") ;
		} catch (UnsupportedEncodingException e) {
			enStr = "" ;
			e.printStackTrace();
		}
		return enStr ;
	}
	
	public static String decode(String content){
		String deStr = "";
		try {
			deStr = URLDecoder.decode(content,"UTF-8") ;
		} catch (UnsupportedEncodingException e) {
			deStr = "" ;
			e.printStackTrace();
		}
		return deStr ;
	}
}
