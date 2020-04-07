package com.yuntools.baidu;

import com.yuntools.entity.BaiDuWords;
import com.yuntools.entity.GeneralResult;
import com.yuntools.util.HttpUtil;
import com.yuntools.util.JsonUtil;
import com.yuntools.util.PropertiesUtil;
import com.yuntools.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

public class BaiDuService {

	private String clientId;

	private String clientSecret;

	/**
	 * access_token
	 */
	private String accessToken = null;

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	/**
	 * 通用文字识别
	 */
	private static final String GENERAL_BASIC_URL = PropertiesUtil.getPropertiesValue("baidu.general.basic.url");

	/**
	 * 通用文字识别（高精度含位置版）
	 */
	private static final String ACCURATE_URL = PropertiesUtil.getPropertiesValue("baidu.accurate.url");

	public GeneralResult generalWords(BaiDuWords words){
		if(StringUtil.isEmpty(words.getImage())){
			throw new NullPointerException("image不能为空");
		}
		String url = null;
		boolean flag = false;
		Map<String,String> map = new HashMap<>(7);
		map.put("image",words.getImage());
		if(!StringUtil.isEmpty(words.getUrl())){
			map.put("url",words.getUrl());
		}
		if(!StringUtil.isEmpty(words.getLanguage_type())){
			map.put("language_type",words.getLanguage_type());
		}
		if(!StringUtil.isEmpty(words.getDetect_direction())){
			map.put("detect_direction",words.getDetect_direction().toString());
		}
		if(!StringUtil.isEmpty(words.getDetect_language())){
			map.put("detect_language",words.getDetect_language().toString());
		}
		if(!StringUtil.isEmpty(words.getParagraph())){
			map.put("paragraph",words.getParagraph().toString());
		}
		if(!StringUtil.isEmpty(words.getProbability())){
			map.put("probability",words.getProbability().toString());
		}
		if(!StringUtil.isEmpty(words.getRecognize_granularity())){
			map.put("recognize_granularity",words.getRecognize_granularity());
			flag = true;
		}
		if(flag){
			url = GENERAL_BASIC_URL+"?access_token="+AuthService.getToken();
		}else{
			url = GENERAL_BASIC_URL+"?access_token="+AuthService.getToken();
		}
		String result = HttpUtil.postRequest(GENERAL_BASIC_URL+"?access_token="+AuthService.getToken(),map);
		GeneralResult generalResult = (GeneralResult) JsonUtil.fromJsonString(result,GeneralResult.class);
		return generalResult;
	}

}
