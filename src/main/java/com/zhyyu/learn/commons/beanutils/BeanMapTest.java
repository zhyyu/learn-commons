package com.zhyyu.learn.commons.beanutils;

import java.util.Iterator;

import org.apache.commons.beanutils.BeanMap;

/**
 * test BeanMap
 * @author Administrator
 *
 */
public class BeanMapTest {

	public static void main(String[] args) {
		System.out.println("========================");
		MyClass myClass = new MyClass();
		BeanMap beanMap = new BeanMap(myClass);
		System.out.println(beanMap.containsKey("key1"));
		System.out.println("========================");
		
		System.out.println("========================");
		myClass.setKey1("value1");
		System.out.println(beanMap.containsValue("value1"));
		System.out.println("========================");
		
		System.out.println("========================");
		System.out.println(beanMap.get("key1"));
		System.out.println("========================");
		
		System.out.println("========================");
		System.out.println(beanMap.getType("key1"));
		System.out.println("========================");
		
		System.out.println("========================");
		Iterator<String> keyIterator = beanMap.keyIterator();
		while (keyIterator.hasNext()) {
			System.out.println(keyIterator.next());
		}
		System.out.println("========================");
		
		System.out.println("========================");
		System.out.println(beanMap.keySet());
		System.out.println("========================");
		
		System.out.println("========================");
		beanMap.put("key1", "value11");
		System.out.println(beanMap.get("key1"));
		System.out.println("========================");
		 
		System.out.println("========================");
		System.out.println(beanMap.size());
		System.out.println("========================");
		
		System.out.println("========================");
		System.out.println(beanMap.toString());
		System.out.println("========================");
		
		System.out.println("========================");
		System.out.println(beanMap.values());
		System.out.println("========================");
	}
	
	public static class MyClass {
		private String key1;
		private String key2;
		
		public String getKey1() {
			return key1;
		}
		public void setKey1(String key1) {
			this.key1 = key1;
		}
		public String getKey2() {
			return key2;
		}
		public void setKey2(String key2) {
			this.key2 = key2;
		}
	}
	
}
