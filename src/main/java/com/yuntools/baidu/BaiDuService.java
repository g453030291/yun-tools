package com.yuntools.baidu;

import com.yuntools.entity.BaiDuWords;
import com.yuntools.entity.IdCard;
import com.yuntools.util.HttpUtil;
import com.yuntools.util.PropertiesUtil;
import com.yuntools.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

public class BaiDuService {

	/**
	 * 通用文字识别
	 */
	private static final String GENERAL_BASIC_URL = PropertiesUtil.getPropertiesValue("baidu.general.basic.url");

	/**
	 * 通用文字识别（高精度含位置版）
	 */
	private static final String ACCURATE_URL = PropertiesUtil.getPropertiesValue("baidu.accurate.url");

	/**
	 * 身份证识别
	 */
	private static final String ID_CARD_URL = PropertiesUtil.getPropertiesValue("baidu.id.card.url");

	/**
	 * 银行卡识别
	 */
	private static final String BANK_CARD_URL = PropertiesUtil.getPropertiesValue("baidu.bank.card.url");

	private BaiDuBaseData baiDuBaseData;

	/**
	 * 构建service类必传的参数
	 * @param baiDuBaseData
	 */
	public BaiDuService(BaiDuBaseData baiDuBaseData) {
		this.baiDuBaseData = baiDuBaseData;
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

	/**
	 * 身份证识别
	 * @param idCard
	 * @return
	 */
	public String idCard(IdCard idCard){
		if(idCard == null
				|| StringUtil.isEmpty(idCard.getImage())
				||StringUtil.isEmpty(idCard.getId_card_side()) ){
			throw new NullPointerException("必传参数不能为空");
		}
		Map<String,String> map = new HashMap<>(6);
		map.put("image",idCard.getImage());
		map.put("id_card_side",idCard.getId_card_side());
		if(!StringUtil.isEmpty(idCard.getDetect_direction())){
			map.put("detect_direction",idCard.getDetect_direction().toString());
		}
		if(!StringUtil.isEmpty(idCard.getDetect_direction())){
			map.put("detect_risk",idCard.getDetect_risk().toString());
		}
		if(!StringUtil.isEmpty(idCard.getDetect_direction())){
			map.put("detect_photo",idCard.getDetect_photo().toString());
		}
		if(!StringUtil.isEmpty(idCard.getDetect_direction())){
			map.put("detect_rectify",idCard.getDetect_rectify().toString());
		}
		String result = HttpUtil.postRequest(ID_CARD_URL,map);
		return result;
	}

	/**
	 * 银行卡识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @param detect_direction 是否检测图像朝向，默认检测，即：true。可选值包括true - 检测朝向；false - 不检测朝向。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。
	 * @return
	 */
	public String bankCard(String image,String detect_direction){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(2);
		map.put("image",image);
		if(!StringUtil.isEmpty(detect_direction)){
			map.put("detect_direction",detect_direction);
		}
		String result = HttpUtil.postRequest(BANK_CARD_URL,map);
		return result;
	}



}
