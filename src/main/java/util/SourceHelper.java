/**
 * 2015年10月19日	Administrator
 */
package util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

/**
 * @author Administrator
 *
 */
public class SourceHelper {
	public final static String COMMA=",";
	/**
	 * 根据特定的分隔符切割获取id集合
	 * @param word
	 * @param filter
	 * @return
	 */
	public static List<Integer> spiltStringToList(String word,String filter) {
		if(!StringUtils.hasText(word)){
			return null;
		}
		if(!StringUtils.hasText(filter)){
			filter=COMMA;
		}
		String[] ids=word.split(filter);
		List<Integer> idss=new ArrayList<Integer>(ids.length);
		for (String id : ids) {
			try {
				idss.add(Integer.valueOf(id));
			} catch (NumberFormatException e) {
			}
		}
		return idss;
	}
}
