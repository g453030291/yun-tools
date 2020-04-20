package com.yuntools.huawei;

import com.yuntools.entity.ResponseData;
import com.yuntools.util.HttpUtil;
import com.yuntools.util.JsonUtil;
import com.yuntools.util.StringUtil;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 华为通用文字识别
 * @author mantou
 */
public class HuaweiOcrService extends HuaweiBase{

	/**
	 * 构建service类必传的参数
	 *
	 * @param huaweiBaseData
	 */
	public HuaweiOcrService(HuaweiBaseData huaweiBaseData) {
		super(huaweiBaseData);
	}

	/**
	 * 通用文字识别
	 * image和ur必须传一个,如果都传,默认识别image
	 * @param image 图片base64编码
	 * @param url 图片url地址
	 * @return
	 * @throws IOException
	 */
	public String generalText(String image,String url) throws IOException {
		Map<String,String> map = new HashMap<>(1);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}else if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}else {
			throw new NullPointerException("image 或 url不能为空");
		}
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(GENERAL_TEXT_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}

	public String generalTable(String image,String url) throws IOException {
		Map<String,String> map = new HashMap<>(1);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}else if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}else {
			throw new NullPointerException("image 或 url不能为空");
		}
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(GENERAL_TEXT_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}

}
