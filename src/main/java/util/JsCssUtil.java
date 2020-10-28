package util;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;



public class JsCssUtil implements Serializable{
	
	private static final String MAP_URL="http://cdn20.cdn.com/map.json";
	
	private static long timestamp;
	
	private static Map<String,String> map;
	
	private String version;
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getVersion(){
		
		if(Calendar.getInstance().getTimeInMillis()-timestamp>7200000){
			try {
				map = JsonUtil.parseJson(getResponse(MAP_URL),Map.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
			timestamp=Calendar.getInstance().getTimeInMillis();
		}
		if(null==map||null==map.get("v")) return "?v="+String.valueOf(new Date().getTime());
		return "?v="+map.get("v").toString();
	}
	
	
	public static String getResponse(String url) throws Exception{
		return HttpClientUtil.get(url) ;
	}

}
