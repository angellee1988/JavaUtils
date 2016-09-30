package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class DateUtil {
	 // 默认显示日期的格式
    public static final String DATAFORMAT_STR = "yyyy-MM-dd";

    // 默认显示日期的格式
    public static final String YYYY_MM_DATAFORMAT_STR = "yyyy-MM";

    // 默认显示日期时间的格式
    public static final String DATATIMEF_STR = "yyyy-MM-dd HH:mm:ss";

    // 默认显示日期时间的格式
    public static final String DATATIMEF_STR2 = "yyyyMMdd HH:mm:ss";

    // 默认显示日期时间的格式 精确到毫秒
    public static final String DATATIMEF_STR_MIS = "yyyyMMddHHmmssSSS";

    // 默认显示日期时间的格式 精确到毫秒
    public static final String DATATIMEF_STR_MIS1 = "yyyy-MM-dd HH:mm:ss.SSS";

    // 默认显示日期时间的格式 精确到分钟
    public static final String DATATIMEF_STR_MI = "yyyy-MM-dd HH:mm";

    public static final String DATATIMEF_STR_MDHm = "MM.dd HH:mm";

    public static final String HH_STR = "HH";

    // 精确到秒
    public static final String DATATIMEF_STR_SEC = "yyyyMMddHHmmss";

    // 默认显示简体中文日期的格式
    public static final String ZHCN_DATAFORMAT_STR = "yyyy年MM月dd日";

    // 默认显示简体中文日期时间的格式
    public static final String ZHCN_DATATIMEF_STR = "yyyy年MM月dd日HH时mm分ss秒";

    // 默认显示简体中文日期时间的格式
    public static final String ZHCN_DATATIMEF_STR_4yMMddHHmm = "yyyy年MM月dd日HH时mm分";

    // 默认显示月份和日期的格式
    public static final String MONTHANDDATE_STR = "MM.dd";

    public static final String DATATIMEF_STR_MIN = "yyyyMMddHHmm";

    public static final String HOUR_END = " 23:59:59";

    public static final String HOUR_START = " 00:00:00";
    
    //一天的毫秒数
    public static final Long MSECOND_ONE_DAY = 1000*60*60*24L;
	
	public static String get4yMdHmsS(Date date) {
		return getDateFormate(date, "yyyy-MM-dd HH:mm:ss.SSS");
	}

	public static String get4yMdHms(Date date) {
		return getDateFormate(date, "yyyy-MM-dd HH:mm:ss");
	}
	
	public static String get4yMdHm(Date date) {
		return getDateFormate(date, "yyyy-MM-dd HH:mm");
	}

	public static String get4yMd(Date date) {
		return getDateFormate(date, "yyyy-MM-dd");
	}
	
	public static String get4yHh(Date date) {
		return getDateFormate(date, "hh:mm:ss");
	}
	
	public static String get4yMStr(Date date) {
		return getDateFormate(date, "yyyy年MM月");
	}
	
	public static Date parse4yMd(String str){
		return parseDate(str,"yyyy-MM-dd");
	}
	
	public static String getDateFormate(Date date, String formate) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat simpleDateFormate = new SimpleDateFormat(formate);
		return simpleDateFormate.format(date);
	}
	
	public static Date parseDate(String str, String formate){
		if(StringUtils.isBlank(str)){
			return null;
		}
		SimpleDateFormat simpleDateFormate = new SimpleDateFormat(formate);
		try {
			return simpleDateFormate.parse(str);
		} catch (ParseException e) {
		}
		return null;
	}
	
}