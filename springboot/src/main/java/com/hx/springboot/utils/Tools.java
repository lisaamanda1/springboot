package com.hx.springboot.utils;

import java.util.Objects;

import com.hx.springboot.constant.Constant.Address;

public class Tools {
	
	public static String addressStringToCode(String addressString) {
		if(Objects.equals(addressString, Address.China.getName())) {
			return Address.China.getCode();
		}
		if(Objects.equals(addressString, Address.Japan.getName())) {
			return Address.Japan.getCode();
		}
		return "";
	}
	
	public static String addressCodeToString(String addressCode) {
		if(Objects.equals(addressCode, Address.China.getCode())) {
			return Address.China.getName();
		}
		if(Objects.equals(addressCode, Address.Japan.getCode())) {
			return Address.Japan.getName();
		}
		return "未知";
	}
	
	public static boolean isEmpty(String str) {
		if(str == null) {
			return true;
		}
		if(Objects.equals(str, "")) {
			return true;
		}
		return false;
	}
}
