package com.zhyyu.learn.commons.lang;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * test NumberUtils
 * @author Administrator
 *
 */
public class NumberUtilsTest {

	public static void main(String[] args) {
		int max = NumberUtils.max(2, 1, 3);
		System.out.println(max);
	}
	
}
