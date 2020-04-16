package com.yuntools.entity;

import java.util.Map;

/**
 * http response数据封装(与okhttp框架解耦)
 * @author mantou
 */
public class ResponseData {

	private Map<String,Object> headers;

	private String responseBody;

	public Map<String, Object> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, Object> headers) {
		this.headers = headers;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}
}
