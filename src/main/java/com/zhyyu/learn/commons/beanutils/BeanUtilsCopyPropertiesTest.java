package com.zhyyu.learn.commons.beanutils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import lombok.Data;

/**
 * test BeanUtils.copyProperties
 * <br>
 * OUTPUT:
 * BeanUtilsCopyPropertiesTest.MyClassA(i=1, myClassC=com.zhyyu.learn.commons.beanutils.BeanUtilsCopyPropertiesTest$MyClassC@7852e922)
BeanUtilsCopyPropertiesTest.MyClassB(i=1, myClassC=com.zhyyu.learn.commons.beanutils.BeanUtilsCopyPropertiesTest$MyClassC@7852e922)

<br>
CON:
BeanUtils.copyProperties 仅复制引用
 * @author zhyyu
 *
 */
public class BeanUtilsCopyPropertiesTest {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		MyClassA myClassA = new MyClassA();
		myClassA.setI(1);
		myClassA.setMyClassC(new MyClassC());
		
		System.out.println(myClassA);
		
		MyClassB myClassB = new MyClassB();
		BeanUtils.copyProperties(myClassB, myClassA);
		
		System.out.println(myClassB);
	}

	@Data
	public static class MyClassA {
		private int i;
		private MyClassC myClassC;
	}
	
	@Data
	public static class MyClassB {
		private int i;
		private MyClassC myClassC;
	}
	
	public static class MyClassC {
		
	}
	
}
