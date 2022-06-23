package com.hx.springboot.constant;

public class Constant {
	
	public enum Address {
		China("中国", "1"), Japan("日本", "4");
		
		private String name;
		private String code;
		
		private Address(String name, String code) {
			this.name = name;
			this.code = code;
		}
		
		public String getCode() {
			return code;
		}
		
		public String getName() {
			return name;
		}
	}
	
}
