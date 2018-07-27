package com.zhyyu.learn.commons.lang;

import org.apache.commons.lang3.Range;

/**
 * test Range
 * @author Administrator
 *
 */
public class RangeTest {

	public static void main(String[] args) {
		Range<Integer> intRange = Range.between(new Integer(1), new Integer(5));
		System.out.println(intRange.contains(new Integer(3)));
		System.out.println(intRange.isEndedBy(new Integer(5)));
		System.out.println(intRange.isBefore(new Integer(8)));
	}
	
}
