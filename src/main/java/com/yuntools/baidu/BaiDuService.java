package com.yuntools.baidu;

import com.yuntools.entity.BaiDuWords;
import com.yuntools.util.HttpUtil;
import com.yuntools.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * baidu 通用文字识别
 * @author mantou
 */
public class BaiDuService extends BaiDuBase{

	/**
	 * 构建service类必传的参数
	 *
	 * @param baiDuBaseData
	 */
	public BaiDuService(BaiDuBaseData baiDuBaseData) {
		super(baiDuBaseData);
	}

	/**
	 * 文字识别
	 * @param words
	 * @return
	 */
	public String generalWords(BaiDuWords words){
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
			url = ACCURATE_URL+"?access_token=" + baiDuBaseData.getAccessToken();
		}else{
			url = GENERAL_BASIC_URL+"?access_token=" + baiDuBaseData.getAccessToken();
		}
		String result = HttpUtil.postRequest(url,map);
		return result;
	}

}
