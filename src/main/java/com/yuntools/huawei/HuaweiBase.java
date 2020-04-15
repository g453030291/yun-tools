package com.yuntools.huawei;

import com.yuntools.util.PropertiesUtil;

public class HuaweiBase {

	/************************** ocr *************************************/
	/**
	 * 通用文字识别
	 */
	protected static final String GENERAL_BASIC_URL = PropertiesUtil.getPropertiesValue("baidu.general.basic.url");

	protected HuaweiBaseData huaweiBaseData;

	/**
	 * 构建service类必传的参数
	 * @param huaweiBaseData
	 */
	public HuaweiBase(HuaweiBaseData huaweiBaseData) {
		this.huaweiBaseData = huaweiBaseData;
	}
}
