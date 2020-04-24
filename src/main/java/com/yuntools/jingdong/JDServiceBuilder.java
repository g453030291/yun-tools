package com.yuntools.jingdong;

import com.yuntools.util.SHA256Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JDServiceBuilder {

	public static void main(String[] args) {
		//UTC时间
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDDHHmmssZ");
		String code = "POST" + "/n" + "/v1/resource%3Aactiono=%25&p0=p0&p1=p1&u=u" + "x-jdcloud-date:" + sdf.format(new Date()) + "x-jdcloud-nonce:testnonce" + "/n" + "x-my-header:test" + "/n" + "x-my-header_blank:blank";

	}

}
