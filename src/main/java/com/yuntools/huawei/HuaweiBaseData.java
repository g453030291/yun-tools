package com.yuntools.huawei;

/**
 * tencent 接口基础数据封装类
 * @author mantou
 */
public class HuaweiBaseData {

	/**
	 * IAM用户名
	 */
	private String name;

	/**
	 * 登录密码
	 */
	private String password;

	/**
	 * 账号名
	 */
	private String domainName;

	private String token;

	public HuaweiBaseData() {
	}

	public HuaweiBaseData(String name, String password, String domainName, String token) {
		this.name = name;
		this.password = password;
		this.domainName = domainName;
		this.token = token;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
