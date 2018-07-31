package com.zhyyu.learn.commons.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import lombok.Data;

/**
 * BeanUtilsDescribeAndPopulateTest
 * @author zhyyu
 *
 */
public class BeanUtilsDescribeAndPopulateTest {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		MyClassA myClassA = new MyClassA();
		myClassA.setI(1);
		myClassA.setMyClassB(new MyClassB());
		System.out.println(myClassA);
		
		Map<String, String> describe = BeanUtils.describe(myClassA);
		System.out.println(describe);
		
		
		Map<String, Object> properties = new HashMap<>();
		properties.put("i", 2);
		properties.put("myClassB", new MyClassB());
		BeanUtils.populate(myClassA, properties);
		System.out.println(myClassA);
	}
	
	@Data
	public static class MyClassA {
		private int i;
		private MyClassB myClassB;
	}
	
	@Data
	public static class MyClassB {
		private int i;
	}
	
}
