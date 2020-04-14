package com.yuntools.util;

import okhttp3.*;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * http工具类
 * @author mantou
 */
public class HttpUtil {

	/**
	 * json格式
	 */
	private static final MediaType JSON = MediaType.get("application/json;charset=utf-8");

	/**
	 * 表单格式
	 */
	private static final MediaType FORM = MediaType.get("application/x-www-form-urlencoded");

	private static final OkHttpClient CLIENT = new OkHttpClient.Builder()
			.connectTimeout(1000, TimeUnit.MILLISECONDS)
			.readTimeout(1000,TimeUnit.MILLISECONDS)
			.build();

	/**
	 * get请求
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static String getRequest(String url) {
		if(StringUtil.isEmpty(url)){
			throw new NullPointerException("url为空");
		}
		Request request = new Request.Builder().url(url).build();
		try(Response response = CLIENT.newCall(request).execute()){
			return response.body().string();
		}catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * post请求,表单提交
	 * @param url
	 * @param map
	 * @return
	 */
	public static String postRequest(String url, Map<String,String> map) {
		if(StringUtil.isEmpty(url) || map == null || map.isEmpty()){
			throw new NullPointerException("url 或 map 为空");
		}
		FormBody.Builder builder = new FormBody.Builder();
		for (Map.Entry<String,String> entry : map.entrySet()){
			builder.add(entry.getKey(),entry.getValue());
		}
		RequestBody requestBody = builder.build();
		Request request = new Request.Builder()
				.url(url)
				.post(requestBody)
				.build();
		try (Response response = CLIENT.newCall(request).execute()){
			return response.body().string();
		}catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}

	public static String postRequest(String url,Map<String,String> map,Map<String,String> header) {
		if(StringUtil.isEmpty(url) || map == null || map.isEmpty()){
			throw new NullPointerException("url 或 map 为空");
		}
		FormBody.Builder builder = new FormBody.Builder();
		for (Map.Entry<String,String> entry : map.entrySet()){
			builder.add(entry.getKey(),entry.getValue());
		}
		RequestBody requestBody = builder.build();

		Headers.Builder headers = new Headers.Builder();
		for (Map.Entry<String,String> head : header.entrySet()){
			headers.add(head.getKey(),head.getValue());
		}
		Headers headerss = headers.build();
		Request request = new Request.Builder()
				.url(url)
				.headers(headerss)
				.post(requestBody)
				.build();
		try (Response response = CLIENT.newCall(request).execute()){
			return response.body().string();
		}catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * json格式数据的post请求
	 * @param url
	 * @param json
	 * @return
	 */
	public static String postJsonRequest(String url,String json) {
		if(StringUtil.isEmpty(url) || StringUtil.isEmpty(json)){
			throw new NullPointerException("url 或 json 为空");
		}
		RequestBody requestBody = RequestBody.create(json,JSON);
		Request request = new Request.Builder()
				.url(url)
				.post(requestBody)
				.build();
		try (Response response = CLIENT.newCall(request).execute()){
			return response.body().string();
		}catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}

}
