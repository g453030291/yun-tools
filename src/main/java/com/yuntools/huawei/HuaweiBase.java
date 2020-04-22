package com.yuntools.huawei;

import com.yuntools.util.PropertiesUtil;

public class HuaweiBase {

	/************************** ocr *************************************/
	/**
	 * 通用文字识别
	 */
	protected static final String GENERAL_TEXT_URL = PropertiesUtil.getPropertiesValue("huawei.general.text.url");

	/**
	 * 通用文字识别
	 */
	protected static final String TABLE_URL = PropertiesUtil.getPropertiesValue("huawei.general.table.url");

	/**
	 * 通用文字识别
	 */
	protected static final String WEB_IMAGE_URL = PropertiesUtil.getPropertiesValue("huawei.web.image.url");

	/**
	 * 通用文字识别
	 */
	protected static final String AUTO_CLASSIFICATION_URL = PropertiesUtil.getPropertiesValue("huawei.auto.classification.url");

	/**
	 * 通用文字识别
	 */
	protected static final String HAND_WRITING_URL = PropertiesUtil.getPropertiesValue("huawei.hand.writing.url");

	/**
	 * 身份证识别
	 */
	protected static final String ID_CARD_URL = PropertiesUtil.getPropertiesValue("huawei.id.card.url");

	/**
	 * 行驶证识别
	 */
	protected static final String VEHICLE_LICENSE_URL = PropertiesUtil.getPropertiesValue("huawei.vehicle.license.url");

	/**
	 * 驾驶证识别
	 */
	protected static final String DRIVER_LICENSE_URL = PropertiesUtil.getPropertiesValue("huawei.vehicle.license.url");

	/**
	 * 护照识别
	 */
	protected static final String PASSPORT_URL = PropertiesUtil.getPropertiesValue("huawei.passport.url");

	/**
	 * 银行卡识别
	 */
	protected static final String BANKCARD_URL = PropertiesUtil.getPropertiesValue("huawei.bankcard.url");

	/**
	 * 营业执照识别
	 */
	protected static final String BUSINESS_LICENSE_URL = PropertiesUtil.getPropertiesValue("huawei.bankcard.url");



	protected HuaweiBaseData huaweiBaseData;

	/**
	 * 构建service类必传的参数
	 * @param huaweiBaseData
	 */
	public HuaweiBase(HuaweiBaseData huaweiBaseData) {
		this.huaweiBaseData = huaweiBaseData;
	}
}
