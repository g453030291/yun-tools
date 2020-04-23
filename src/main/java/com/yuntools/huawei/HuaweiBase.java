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

	/**
	 * 道路运输证识别
	 */
	protected static final String TRANSPORTATION_LICENSE_URL = PropertiesUtil.getPropertiesValue("huawei.transportation.license.url");

	/**
	 * 车牌识别
	 */
	protected static final String LICENSE_PLATE_URL = PropertiesUtil.getPropertiesValue("huawei.license.plate.url");

	/**
	 * 增值税发票识别
	 */
	protected static final String VAT_INVOICE_URL = PropertiesUtil.getPropertiesValue("huawei.vat.invoice.url");

	/**
	 * 机动车销售发票识别
	 */
	protected static final String MVS_INVOICE_URL = PropertiesUtil.getPropertiesValue("huawei.mvs.invoice.url");

	/**
	 * 出租车发票识别
	 */
	protected static final String TAXI_INVOICE_URL = PropertiesUtil.getPropertiesValue("huawei.taxi.invoice.url");

	/**
	 * 火车票识别
	 */
	protected static final String TRAIN_TICKET_URL = PropertiesUtil.getPropertiesValue("huawei.train.ticket.url");

	/**
	 * 定额发票识别
	 */
	protected static final String QUOTA_INVOICE_URL = PropertiesUtil.getPropertiesValue("huawei.quota.invoice.url");

	/**
	 * 车辆通行费发票识别
	 */
	protected static final String TOLL_INVOICE_URL = PropertiesUtil.getPropertiesValue("huawei.toll.invoice.url");

	/**
	 * 飞机行程单识别
	 */
	protected static final String FLIGHT_ITINERARY_URL = PropertiesUtil.getPropertiesValue("huawei.flight.itinerary.url");

	/**
	 * 英文海关单据识别
	 */
	protected static final String OCR_FORM_URL = PropertiesUtil.getPropertiesValue("huawei.ocr.form.url");





	protected HuaweiBaseData huaweiBaseData;

	/**
	 * 构建service类必传的参数
	 * @param huaweiBaseData
	 */
	public HuaweiBase(HuaweiBaseData huaweiBaseData) {
		this.huaweiBaseData = huaweiBaseData;
	}
}
