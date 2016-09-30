package util;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
/**
 * Json 线索select下拉框工具类
 * 
 * @Description: 本项目json/VO转换全都使用本工具类
 * @author: simon.JY
 * @date: 2015年7月10日
 * 久兴信息技术(上海)有限公司
 */
public class JsonUtilForSource {
	
	private static final SerializerFeature[] features = {SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteNullListAsEmpty,SerializerFeature.WriteNullBooleanAsFalse,SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.BrowserCompatible};
	
	/**
	 * 
	 * @Description: toJSONString
	 * @author: simon.JY
	 * @param object vo
	 * @param is2defvalue 表示是否显示值为null的字段
	 * @return
	 * @date: 2015年7月10日 下午12:05:42
	 *
	 */
	public static String toJSONString(Object object,Boolean is2defvalue){
		if(is2defvalue){
			return toJSONString(object, features);
		}else{
			return toJSONString(object, new SerializerFeature[0]);
		}
	}
	/**
	 * 
	 * @Description: 返回适合前端使用的Json字符串(推荐)
	 * @author: simon.JY
	 * @param object
	 * @return
	 * @date: 2015年7月11日 下午6:39:32
	 *
	 */
	public static String toJSONString(Object object){
		return toJSONString(object, features);
	}
	
	/**
	 * 
	 * @Description: 调用fastJson（toJSONString）
	 * @author: simon.JY
	 * @param object
	 * @param features
	 * @return
	 * @date: 2015年7月11日 下午6:43:47
	 *
	 */
	public static String toJSONString(Object object,SerializerFeature[] features) {
        return JSON.toJSONString(object, features);
    }
	
	
    public static final <T> T parseObject(String text, Class<T> clazz) {
        return parseObject(text, clazz, new Feature[0]);
    }
    
    /**
     * 
     * @Description: 调用fastJson（parseObject）
     * @author: simon.JY
     * @param text
     * @param clazz
     * @param features
     * @return
     * @date: 2015年7月11日 下午6:45:08
     *
     */
    private static final <T> T parseObject(String text, Class<T> clazz, Feature[] features) {
    	return JSON.parseObject(text, clazz, features);
    }
    
    /**
     * 
     * @Description: 调用fastJson（parseArray）
     * @author: simon.JY
     * @param text
     * @param clazz
     * @return
     * @date: 2015年8月13日 下午7:04:27
     *
     */
    public static final <T> List<T> parseArray(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz);
    }
    
}
