package com.yuntools.face;

import com.yuntools.util.PropertiesUtil;

public class FacePlusBase {

	/************************** ocr *************************************/
	/**
	 * 通用文字识别
	 */
	protected static final String FACE_OCR_ID_CARD_URL = PropertiesUtil.getPropertiesValue("face.ocr.id.card");

	protected FacePlusBaseData facePlusBaseData;

	public FacePlusBase(FacePlusBaseData facePlusBaseData){
		this.facePlusBaseData = facePlusBaseData;
	}

}
