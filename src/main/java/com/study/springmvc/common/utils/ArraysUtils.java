package com.study.springmvc.common.utils;

public class ArraysUtils {
	public static <T> boolean isEmpty(T[] c){
		return c==null||c.length==0;
	}
	
	public static boolean isEmpty(char[] c){
		return c==null||c.length==0;
	}
}
