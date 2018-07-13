package com.zhyyu.learn.commons.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JsonResp<T> {

	private Integer code;
	
	private String msg;
	
	private T data;
	
}
