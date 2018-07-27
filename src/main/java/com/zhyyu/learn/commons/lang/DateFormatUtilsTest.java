package com.zhyyu.learn.commons.lang;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * test DateFormatUtils
 * @author Administrator
 *
 */
public class DateFormatUtilsTest {

	public static void main(String[] args) {
		String dateStr = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
		System.out.println(dateStr);
		
		String dateStr8601 = DateFormatUtils.ISO_8601_EXTENDED_DATETIME_FORMAT.format(new Date());
		System.out.println(dateStr8601);
	}
	
}
