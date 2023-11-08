package com.hk.calboard.utils;

public class Util {
	
	//한자리를 두자리로 변환
	public  static String isTwo(String str) {
		return str.length()<2?"0"+str:str; // 5 --> "05", 10 --> "10"
	}
}
