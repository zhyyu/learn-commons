package com.zhyyu.learn.commons.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * jsonStr to object test
 * @author Administrator
 *
 */
public class Json2ObjectTest {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		String jsonStr = "{\"code\":200,\"msg\":\"ok\",\"data\":{\"name1\":\"value1\",\"name2\":\"value2\"}}";
		
		JsonResp<RespData> jsonResp = readJsonStr(jsonStr, RespData.class);
		RespData respData = jsonResp.getData();
		
		System.out.println(jsonResp);
		System.out.println(respData);
	}
	
	private static <T> JsonResp<T> readJsonStr(String jsonStr, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(jsonStr);
		
		int code = root.get("code").asInt();
		String msg = root.get("msg").asText();
		
		String dataJsonStr = root.get("data").toString();
		T data = mapper.readValue(dataJsonStr, clazz);
		
		return (JsonResp<T>) JsonResp.builder().code(code).msg(msg).data(data).build();
	}
	
}