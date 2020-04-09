package com.yuntools.baidu;

import com.yuntools.util.PropertiesUtil;

public class BaiDuBase {

	/************************** ocr *************************************/
	/**
	 * 通用文字识别
	 */
	protected static final String GENERAL_BASIC_URL = PropertiesUtil.getPropertiesValue("baidu.general.basic.url");

	/**
	 * 通用文字识别（高精度含位置版）
	 */
	protected static final String ACCURATE_URL = PropertiesUtil.getPropertiesValue("baidu.accurate.url");

	/************************** 卡证文字识别 *************************************/

	/**
	 * 身份证识别
	 */
	protected static final String ID_CARD_URL = PropertiesUtil.getPropertiesValue("baidu.id.card.url");

	/**
	 * 银行卡识别
	 */
	protected static final String BANK_CARD_URL = PropertiesUtil.getPropertiesValue("baidu.bank.card.url");

	/**
	 * 营业执照识别
	 */
	protected static final String BUSINESS_LICENSE_URL = PropertiesUtil.getPropertiesValue("baidu.business.license.url");

	/**
	 * 名片识别
	 */
	protected static final String BUSINESS_CARD_URL = PropertiesUtil.getPropertiesValue("baidu.business.card.url");

	/**
	 * 护照识别
	 */
	protected static final String PASSPORT_URL = PropertiesUtil.getPropertiesValue("baidu.passport.url");

	/**
	 * 港澳通行证识别
	 */
	protected static final String HK_MACAU_EXITENTRYPERMIT_URL = PropertiesUtil.getPropertiesValue("baidu.hk.macau.exitentrypermit.url");

	/**
	 * 台湾通行证识别
	 */
	protected static final String TAIWAN_EXITENTRYPERMIT_URL = PropertiesUtil.getPropertiesValue("baidu.taiwan.exitentrypermit.url");

	/**
	 * 户口本识别
	 */
	protected static final String HOUSEHOLE_REGISTER_URL = PropertiesUtil.getPropertiesValue("baidu.household.register.url");

	/**
	 * 出生医学证明识别
	 */
	protected static final String BIRTH_CERTIFICATE_URL = PropertiesUtil.getPropertiesValue("baidu.birth.certificate.url");

	/************************** 票据文字识别 *************************************/

	/**
	 * 增值税发票识别
	 */
	protected static final String VAT_INVOICE_URL = PropertiesUtil.getPropertiesValue("baidu.vat.invoice.url");

	/**
	 * 定额发票识别
	 */
	protected static final String QUOTA_INVOICE_URL = PropertiesUtil.getPropertiesValue("baidu.quota.invoice.url");

	/**
	 * 通用机打发票识别
	 */
	protected static final String INVOICE_URL = PropertiesUtil.getPropertiesValue("baidu.invoice.url");

	/**
	 * 火车票识别
	 */
	protected static final String TRAIN_TICKET_URL = PropertiesUtil.getPropertiesValue("baidu.train.ticket.url");

	/**
	 * 出租车票识别
	 */
	protected static final String TAXI_RECEIPT_URL = PropertiesUtil.getPropertiesValue("baidu.taxi.receipt.url");

	/**
	 * 行程单识别
	 */
	protected static final String AIR_TICKET_URL = PropertiesUtil.getPropertiesValue("baidu.air.ticket.url");

	/**
	 * 通用票据识别
	 */
	protected static final String RECEIPT_URL = PropertiesUtil.getPropertiesValue("baidu.receipt.url");

	/**
	 * 保单识别
	 */
	protected static final String INSURANCE_DOCUMENTS_URL = PropertiesUtil.getPropertiesValue("baidu.insurance.documents.url");

	/**
	 * 彩票识别
	 */
	protected static final String LOTTERY_URL = PropertiesUtil.getPropertiesValue("baidu.lottery.url");

	/************************** 汽车文字识别 *************************************/

	/**
	 * 行驶证识别
	 */
	protected static final String VEHICLE_LICENSE_URL = PropertiesUtil.getPropertiesValue("baidu.vehicle.license.url");

	/**
	 * 驾驶证识别
	 */
	protected static final String DRIVING_LICENSE_URL = PropertiesUtil.getPropertiesValue("baidu.driving.license.url");

	/**
	 * 车牌识别
	 */
	protected static final String LICENSE_PLATE_URL = PropertiesUtil.getPropertiesValue("baidu.license.plate.url");

	/**
	 * VIN码识别
	 */
	protected static final String VIN_CODE_URL = PropertiesUtil.getPropertiesValue("baidu.vinCode.url");

	/**
	 * 机动车销售发票识别
	 */
	protected static final String VEHICLE_INVOICE_URL = PropertiesUtil.getPropertiesValue("baidu.vehicle.invoice.url");

	/**
	 * 车辆合格证识别
	 */
	protected static final String VEHICLE_CERTIFICATE_URL = PropertiesUtil.getPropertiesValue("baidu.vehicle.certificate.url");

	/************************** 教育文字识别 *************************************/

	/**
	 * 手写文字识别
	 */
	protected static final String HANDWRITING_URL = PropertiesUtil.getPropertiesValue("baidu.handwriting.url");

	/**
	 * 公式识别
	 */
	protected static final String FORMULA_URL = PropertiesUtil.getPropertiesValue("baidu.formula.url");

	/**
	 * 网络图片文字识别
	 */
	protected static final String WEB_IMAGE_URL = PropertiesUtil.getPropertiesValue("baidu.webimage.url");

	protected BaiDuBaseData baiDuBaseData;

	/**
	 * 构建service类必传的参数
	 * @param baiDuBaseData
	 */
	public BaiDuBase(BaiDuBaseData baiDuBaseData) {
		this.baiDuBaseData = baiDuBaseData;
	}

}
