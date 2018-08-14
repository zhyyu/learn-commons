package com.zhyyu.learn.commons.text;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.text.StringSubstitutor;

/**
 * 测试 StringSubstitutor, 注意 StringSubstitutor 不是线程安全对象
 * @author zhyyu
 *
 */
public class StringSubstitutorTest {

	public static void main(String[] args) {
		String replaceSystemProperties = StringSubstitutor.replaceSystemProperties(
		        "You are running with java.version = ${java.version} and os.name = ${os.name}.");
		System.out.println(replaceSystemProperties);

		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("animal", "quick brown fox");
		valuesMap.put("target", "lazy dog");
		String templateString = "The ${animal} jumped over the ${target}.";
		StringSubstitutor sub = new StringSubstitutor(valuesMap);
		String resolvedString = sub.replace(templateString);
		System.out.println(resolvedString);
		
		
		Map<String, String> valuesMap2 = new HashMap<>();
		valuesMap2.put("animal", "quick brown fox");
		valuesMap2.put("target", "lazy dog");
		String templateString2 = "The #[@animal] jumped over the #[@target].";
		StringSubstitutor sub2 = new StringSubstitutor(valuesMap2, "#[@", "]");
		String resolvedString2 = sub2.replace(templateString2);
		System.out.println(resolvedString2);
	}

}
