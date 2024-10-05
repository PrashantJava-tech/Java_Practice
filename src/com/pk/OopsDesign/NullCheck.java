package com.pk.OopsDesign;

import java.util.Objects;

public class NullCheck {
	
	public static void main(String[] args) {
		
		Object value = "";
		
		System.out.println("value= "+value);
		System.out.println("Objects.isNull(value)= "+Objects.isNull(value));
		System.out.println("value== null "+( null == value));
		System.out.println("value== '' "+( "" == value));
		//System.out.println("value== '' "+ObjectUtils.isEmpty(value));
	}

}
