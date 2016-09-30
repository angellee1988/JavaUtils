package com;

import java.util.HashSet;
import java.util.Set;

public class TestList {

	public static void main(String[] args) {
		Set<String> list = new HashSet<String>() ;
		
		list.add("22222") ;
		list.add("22333") ;
		for (String str : list) {
			System.out.println(str);
			list.clear(); 
		}
	}
}
