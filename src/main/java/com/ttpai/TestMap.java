package com.ttpai;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		
		Map<Integer,String> map = new HashMap<Integer,String>() ;
		map.put(11, "sss") ;
		map.put(22, "sswww") ;
		
		
		System.out.println(map.get(33));
	}
}
