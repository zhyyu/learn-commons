package com.zhyyu.learn.commons.beanutils;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import lombok.Data;

/**
 * test ConvertUtils.convert
 * @author Administrator
 *;
 */
public class ConvertUtilsTest {

	public static void main(String[] args) {
		// construct myClassA
		MyClassA myClassA = new MyClassA();
		myClassA.setI(1);
		System.out.println(myClassA);
		
		// register converter
		ConvertUtils.register(new Converter() {
			@SuppressWarnings("unchecked")
			@Override
			public <T> T convert(Class<T> type, Object value) {
				try {
					T t = type.newInstance();
					BeanMap tBeanMap = new BeanMap(t);

					BeanMap vBeanMap = new BeanMap(value);
					
					tBeanMap.put("i", vBeanMap.get("i"));
					
					return (T) tBeanMap.getBean();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
				
				return null;
			}
		}, MyClassB.class);
		
		// test ConvertUtils
		MyClassB myClassB = (MyClassB) ConvertUtils.convert(myClassA, MyClassB.class);
		System.out.println(myClassB);
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
