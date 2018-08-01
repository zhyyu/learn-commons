package com.zhyyu.learn.commons.beanutils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

import lombok.Data;

/**
 * test PropertyUtils
 * @author Administrator
 *
 */
public class PropertyUtilsTest {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		MyClassA myClassA = new MyClassA();
		myClassA.setI(1);
		System.out.println(myClassA);
		
		MyClassB myClassB = new MyClassB();
		PropertyUtils.copyProperties(myClassB, myClassA);
		System.out.println(myClassB);
		
		System.out.println(PropertyUtils.describe(myClassA));
		
		System.out.println(PropertyUtils.getProperty(myClassA, "i"));
		
		System.out.println(MyClassA.class);
	}
	
	@Data
	public static class MyClassA {
		private int i;
	}
	
	@Data
	public static class MyClassB {
		private int i;
	}
	
}
