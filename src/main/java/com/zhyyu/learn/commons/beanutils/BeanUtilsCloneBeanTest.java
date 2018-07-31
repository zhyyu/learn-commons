package com.zhyyu.learn.commons.beanutils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import lombok.Data;

/**
 * test BeanUtils.cloneBean
 * <br> 
 * OUTPUT:
 * BeanUtilsCloneBeanTest.MyClass1(i=1, integer=1, myClass2=com.zhyyu.learn.commons.beanutils.BeanUtilsCloneBeanTest$MyClass2@7852e922)
com.zhyyu.learn.commons.beanutils.BeanUtilsCloneBeanTest$MyClass2@7852e922
BeanUtilsCloneBeanTest.MyClass1(i=1, integer=1, myClass2=com.zhyyu.learn.commons.beanutils.BeanUtilsCloneBeanTest$MyClass2@7852e922)
com.zhyyu.learn.commons.beanutils.BeanUtilsCloneBeanTest$MyClass2@7852e922

CON:
BeanUtils.cloneBean 仅复制引用, 未new对象
 * @author zhyyu
 *
 */
public class BeanUtilsCloneBeanTest {

	public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		MyClass1 myClass1 = new MyClass1();
		myClass1.setI(1);
		myClass1.setInteger(new Integer(1));
		myClass1.setMyClass2(new MyClass2());
		
		System.out.println(myClass1);
		System.out.println(myClass1.getMyClass2());
		
		MyClass1 myClass11 = (MyClass1) BeanUtils.cloneBean(myClass1);
		System.out.println(myClass11);
		System.out.println(myClass11.getMyClass2());
	}
	
	@Data
	public static class MyClass1 {
		
		private int i;
		
		private Integer integer;
		
		private MyClass2 myClass2;
		
	}
	
	public static class MyClass2 {
		
	}
}
