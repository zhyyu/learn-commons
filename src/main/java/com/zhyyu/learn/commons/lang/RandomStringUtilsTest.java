package com.zhyyu.learn.commons.lang;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * test RandomStringUtils
 * @author Administrator
 *
 */
public class RandomStringUtilsTest {

	public static void main(String[] args) {
		char[] chars = {'a' , 'b', 'c'};
		int count = 10;
		
		System.out.println(RandomStringUtils.random(count));
		System.out.println(RandomStringUtils.random(count, true, true));
		System.out.println(RandomStringUtils.random(count, false, true));
		System.out.println(RandomStringUtils.random(count, chars));
		System.out.println(RandomStringUtils.randomAlphabetic(count));
		System.out.println(RandomStringUtils.randomAscii(count));
		System.out.println(RandomStringUtils.randomGraph(count));
		System.out.println(RandomStringUtils.randomNumeric(count));
		System.out.println(RandomStringUtils.randomPrint(count));
	}
	
}
