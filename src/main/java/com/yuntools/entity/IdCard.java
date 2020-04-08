package com.yuntools.entity;

public class IdCard {

	/**
	 * 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 */
	private String image;

	/**
	 * front：身份证含照片的一面；back：身份证带国徽的一面
	 */
	private String id_card_side;

	/**
	 * 是否检测图像旋转角度，默认检测，即：true。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:
	 * - true：检测旋转角度；
	 * - false：不检测旋转角度。
	 */
	private Boolean detect_direction;

	/**
	 * 是否开启身份证风险类型(身份证复印件、临时身份证、身份证翻拍、修改过的身份证)功能，默认不开启，即：false。可选值:true-开启；false-不开启
	 */
	private Boolean detect_risk;

	/**
	 * 是否检测头像内容，默认不检测。可选值：true-检测头像并返回头像的 base64 编码及位置信息
	 */
	private Boolean detect_photo;

	/**
	 * 是否进行完整性校验，默认为true，需上传各字段内容完善的图片方可识别；如果设置为false，则对于身份证切片（如仅身份证号区域）也可识别
	 */
	private Boolean detect_rectify;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getId_card_side() {
		return id_card_side;
	}

	public void setId_card_side(String id_card_side) {
		this.id_card_side = id_card_side;
	}

	public Boolean getDetect_direction() {
		return detect_direction;
	}

	public void setDetect_direction(Boolean detect_direction) {
		this.detect_direction = detect_direction;
	}

	public Boolean getDetect_risk() {
		return detect_risk;
	}

	public void setDetect_risk(Boolean detect_risk) {
		this.detect_risk = detect_risk;
	}

	public Boolean getDetect_photo() {
		return detect_photo;
	}

	public void setDetect_photo(Boolean detect_photo) {
		this.detect_photo = detect_photo;
	}

	public Boolean getDetect_rectify() {
		return detect_rectify;
	}

	public void setDetect_rectify(Boolean detect_rectify) {
		this.detect_rectify = detect_rectify;
	}
}
