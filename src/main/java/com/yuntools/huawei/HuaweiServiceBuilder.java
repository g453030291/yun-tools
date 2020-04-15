package com.yuntools.huawei;

import com.yuntools.baidu.BaiDuBaseData;
import com.yuntools.baidu.BaiDuService;
import com.yuntools.entity.Domain;
import com.yuntools.entity.HuaweiAuth;
import com.yuntools.util.HttpUtil;
import com.yuntools.util.JsonUtil;
import com.yuntools.util.PropertiesUtil;

import java.util.*;

/**
 * tencent 文字识别
 * @author mantou
 */
public class HuaweiServiceBuilder {

	private final static String CHARSET = "UTF-8";

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

	private BaiDuService baiDuService;

	private BaiDuBaseData baiDuBaseData;

	public HuaweiServiceBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public HuaweiServiceBuilder setPassword(String password) {
		this.password = password;
		return this;
	}

	public HuaweiServiceBuilder setDomainName(String domainName) {
		this.domainName = domainName;
		return this;
	}

	/**
	 * 通过接口获取token,有效期为24小时
	 * @param name
	 * @param password
	 * @param domainName
	 * @return
	 * 返回结果示例
	 * 请求:{"auth":{"identity":{"methods":["password"],"password":{"user":{"name":"hw16603709","password":"g453030291","domain":{"name":"hw16603709"}}}},"scope":{"domain":{"name":"hw16603709"}}}}
	 * 响应:{"token":{"expires_at":"2020-04-15T13:13:01.651000Z","methods":["password"],"catalog":[{"endpoints":[{"id":"33e1cbdd86d34e89a63cf8ad16a5f49f","interface":"public","region":"*","region_id":"*","url":"https://iam.myhuaweicloud.com/v3.0"}],"id":"100a6a3477f1495286579b819d399e36","name":"iam","type":"iam"},{"endpoints":[{"id":"73794891aa984c65bdaae558858e9838","interface":"public","region":"*","region_id":"*","url":"https://bss-intl.myhuaweicloud.com/v2"}],"id":"b209755f86f54fdcaaa3f8541307872f","name":"bss-intlv2","type":"bss-intlv2"},{"endpoints":[{"id":"6c91faa9890f40b397542561e3d87444","interface":"public","region":"*","region_id":"*","url":"https://cbc.ap-southeast-1.myhuaweicloud.com/v1.0"}],"id":"ad7396ee0eea4281a180c4230641b72f","name":"bss-intlv1","type":"bss-intlv1"},{"endpoints":[{"id":"112d074a052341838abc3feafbaeb748","interface":"public","region":"*","region_id":"*","url":"https://iam.myhuaweicloud.com/v3"}],"id":"1842ae22353d45a39a1eb89c22f0fe50","name":"keystone","type":"identity"},{"endpoints":[{"id":"27d37217babe4cbcbed410c664bcd79b","interface":"public","region":"*","region_id":"*","url":"https://dns.myhuaweicloud.com"}],"id":"17e8ce5e88d2427e96d566baeeb8ccc0","name":"","type":"dns"},{"endpoints":[{"id":"29319cf2052d4e94bcf438b55d143832","interface":"public","region":"*","region_id":"*","url":"https://bss.myhuaweicloud.com/v1.0"}],"id":"c6db69fabbd549908adcb861c7e47ca4","name":"bssv1","type":"bssv1"},{"endpoints":[{"id":"23e94bd1effc4ecb80d626b9c712f564","interface":"public","region":"*","region_id":"*","url":"https://bss.myhuaweicloud.com/v2"}],"id":"5ef8a34a653d495cac0db4378e161521","name":"bssv2","type":"bssv2"}],"domain":{"id":"0603c09f85800fcf0fd5c005a6113880","name":"hw16603709"},"roles":[{"id":"0","name":"te_admin"},{"id":"0","name":"secu_admin"},{"id":"0","name":"te_agency"},{"id":"0","name":"op_gated_eip_ipv6"},{"id":"0","name":"op_gated_v2x"},{"id":"0","name":"op_gated_ecs_spot_instance"},{"id":"0","name":"op_gated_ivas_vcr_vca"},{"id":"0","name":"op_gated_ief_nodegroup"},{"id":"0","name":"op_gated_cci_mountobsposix"},{"id":"0","name":"op_gated_ecs_ascend_kai1"},{"id":"0","name":"op_gated_dbs_ri"},{"id":"0","name":"op_gated_bms_hpc_h2large"},{"id":"0","name":"op_gated_evs_essd"},{"id":"0","name":"op_gated_iodps"},{"id":"0","name":"op_gated_batch_ecs_cluster"},{"id":"0","name":"op_gated_ecs_gpu_v100"},{"id":"0","name":"op_gated_cbs_qi"},{"id":"0","name":"op_gated_dws_poc"},{"id":"0","name":"op_gated_meeting_endpoint_buy"},{"id":"0","name":"op_gated_sis_sasr_en"},{"id":"0","name":"op_gated_VIS_Intl"},{"id":"0","name":"op_gated_ecs_gpu_p2s"},{"id":"0","name":"op_gated_evs_volume_recycle_bin"},{"id":"0","name":"op_gated_vcc"},{"id":"0","name":"op_gated_vcp"},{"id":"0","name":"op_gated_dpp"},{"id":"0","name":"op_gated_ocsmartcampus"},{"id":"0","name":"op_gated_bks"},{"id":"0","name":"op_gated_meeting_hardaccount_buy"},{"id":"0","name":"op_gated_multi_bind"},{"id":"0","name":"op_gated_nlp_mt"},{"id":"0","name":"op_gated_eip_pool"},{"id":"0","name":"op_gated_ief_function"},{"id":"0","name":"op_gated_a_ap-southeast-3d"},{"id":"0","name":"op_gated_project_del"},{"id":"0","name":"op_gated_m6mt"},{"id":"0","name":"op_gated_evs_retype"},{"id":"0","name":"op_gated_aad_free"},{"id":"0","name":"op_gated_elb_guaranteed"},{"id":"0","name":"op_gated_a_cn-southwest-2b"},{"id":"0","name":"op_gated_sfsturbo"},{"id":"0","name":"op_gated_cbr_turbo"},{"id":"0","name":"op_gated_hv_vendor"},{"id":"0","name":"op_gated_a_cn-north-4e"},{"id":"0","name":"op_gated_a_cn-north-4d"},{"id":"0","name":"op_gated_IEC"},{"id":"0","name":"op_gated_tas"},{"id":"0","name":"op_gated_sis_assess_multimodel"},{"id":"0","name":"op_gated_cce_mcp_thai"},{"id":"0","name":"op_gated_nlp_lg_tg"},{"id":"0","name":"op_gated_servicestage_mgr_dtm"},{"id":"0","name":"op_gated_a_cn-north-4f"},{"id":"0","name":"op_gated_cph"},{"id":"0","name":"op_gated_ModelArtsAscend910"},{"id":"0","name":"op_gated_meeting_history_custom_buy"},{"id":"0","name":"op_gated_ws"},{"id":"0","name":"op_gated_ecs_gpu_g5r"},{"id":"0","name":"op_gated_elb_migrate"},{"id":"0","name":"op_gated_cci_kunpeng"},{"id":"0","name":"op_gated_ri_dws"},{"id":"0","name":"op_gated_iotedge_campus"},{"id":"0","name":"op_gated_vgvas"},{"id":"0","name":"op_gated_vpc_flow_log"},{"id":"0","name":"op_gated_op_gated_ics"},{"id":"0","name":"op_gated_aad_beta_idc"},{"id":"0","name":"op_gated_csbs_rep_acceleration"},{"id":"0","name":"op_gated_ief_edgemesh"},{"id":"0","name":"op_gated_ais_api_image_anti_ad"},{"id":"0","name":"op_gated_dss_month"},{"id":"0","name":"op_gated_csg"},{"id":"0","name":"op_gated_ecs_c6x"},{"id":"0","name":"op_gated_sis_assess_audio"},{"id":"0","name":"op_gated_ufs"},{"id":"0","name":"op_gated_dec_month_user"},{"id":"0","name":"op_gated_vip_bandwidth"},{"id":"0","name":"op_gated_ecs_old_reource"},{"id":"0","name":"op_gated_dcs_ri"},{"id":"0","name":"op_gated_cce_burst_to_cci"},{"id":"0","name":"op_gated_vgivs"},{"id":"0","name":"op_gated_obs_dualstack"},{"id":"0","name":"op_gated_edcm"},{"id":"0","name":"op_gated_csbs_restore"},{"id":"0","name":"op_gated_ivscs"},{"id":"0","name":"op_gated_IWBPublicTest"},{"id":"0","name":"op_gated_ipv6_dualstack"},{"id":"0","name":"op_gated_vpn_vgw"},{"id":"0","name":"op_gated_irtc"},{"id":"0","name":"op_gated_cce_bms2"},{"id":"0","name":"op_gated_pca"},{"id":"0","name":"op_gated_vgws"},{"id":"0","name":"op_gated_cce_asm_hk"},{"id":"0","name":"op_gated_csbs_progressbar"},{"id":"0","name":"op_gated_iov-trial"},{"id":"0","name":"op_gated_rds_arm"},{"id":"0","name":"op_gated_ecs_c6x_virtio_net"},{"id":"0","name":"op_gated_evs_pool_ca"},{"id":"0","name":"op_gated_dds_arm"},{"id":"0","name":"op_gated_a_CN-SOUTH-3"},{"id":"0","name":"op_gated_ecs_offline_disk_4"},{"id":"0","name":"op_gated_bs"},{"id":"0","name":"op_gated_gss_free_trial"},{"id":"0","name":"op_gated_meeting_cloud_buy"},{"id":"0","name":"op_gated_eps"},{"id":"0","name":"op_gated_csbs_restore_all"},{"id":"0","name":"op_gated_l2cg"},{"id":"0","name":"op_gated_WeLink_endpoint_buy"},{"id":"0","name":"op_gated_quickbuy"},{"id":"0","name":"op_gated_fcs_pay"},{"id":"0","name":"op_gated_iotanalytics"},{"id":"0","name":"op_gated_maxhub_endpoint_buy"},{"id":"0","name":"op_gated_a_ap-southeast-1e"},{"id":"0","name":"op_gated_a_ap-southeast-1d"},{"id":"0","name":"op_gated_nlp_kg"},{"id":"0","name":"op_gated_a_ap-southeast-1f"},{"id":"0","name":"op_gated_ief_device_direct"},{"id":"0","name":"op_gated_dcs_dcs2_proxy"},{"id":"0","name":"op_gated_ecs_vgpu_g5"},{"id":"0","name":"op_gated_cs_arm_poc"},{"id":"0","name":"op_gated_ecs_ri"},{"id":"0","name":"op_gated_a_cn-south-1f"},{"id":"0","name":"op_gated_a_ap-southeast-1c"},{"id":"0","name":"op_gated_a_ru-northwest-2c"},{"id":"0","name":"op_gated_ulb_miit_test"},{"id":"0","name":"op_gated_ief_platinum"},{"id":"0","name":"op_gated_Video_Campus"}],"issued_at":"2020-04-14T13:13:01.651000Z","user":{"domain":{"id":"0603c09f85800fcf0fd5c005a6113880","name":"hw16603709"},"id":"0603c0a0a28026b61fa8c00588ce52f5","name":"hw16603709","password_expires_at":""}}}
	 * 登录华为账号:获取自己的账号信息
	 * 获取token详细文档:https://support.huaweicloud.com/api-iam/iam_30_0001.html
	 * postman示例:https://support.huaweicloud.com/iam_faq/iam_01_034.html
	 * 华为接口认证的两种模式:1.token;2.AK/SK;
	 * 详细介绍:https://support.huaweicloud.com/api-ocr/ocr_03_0005.html
	 * @throws Exception
	 */
	private static String getAccessToken(String name, String password,String domainName) throws Exception {
		String authTokenUrl = PropertiesUtil.getPropertiesValue("huawei.auth.tokens");
		//其它
		String url = "https://ocr.cn-north-4.myhuaweicloud.com";
		//英文海关单据识别、手写文字识别
		String url1 = "https://ocr.cn-north-1.myhuaweicloud.com";
		//网络图片识别
		String url2 = "https://ocr.cn-south-1.myhuaweicloud.com";

		Domain domain = new Domain();
		domain.setName(domainName);
		HuaweiAuth.Identity_scope.Identity identity = new HuaweiAuth.Identity_scope.Identity();
		HuaweiAuth.Identity_scope.Scope scope = new HuaweiAuth.Identity_scope.Scope();
		scope.setDomain(domain);
		identity.setMethods(Arrays.asList("password"));
		HuaweiAuth.Identity_scope.Identity.Password password1 = new HuaweiAuth.Identity_scope.Identity.Password();
		HuaweiAuth.Identity_scope.Identity.Password.User user = new HuaweiAuth.Identity_scope.Identity.Password.User();
		user.setName(name);
		user.setPassword(password);
		user.setDomain(domain);
		password1.setUser(user);
		identity.setPassword(password1);
		HuaweiAuth auth = new HuaweiAuth();
		HuaweiAuth.Identity_scope identity_scope = new HuaweiAuth.Identity_scope();
		identity_scope.setIdentity(identity);
		identity_scope.setScope(scope);
		auth.setAuth(identity_scope);
		String json = JsonUtil.toJsonString(auth);
		String result = HttpUtil.postJsonRequest(authTokenUrl,json);
		System.out.println(json);
		System.out.println(result);
		return null;
	}

	public HuaweiOcrService buildHuaweiService() throws Exception {
		String token = getAccessToken(name, password, domainName);
		HuaweiBaseData data = new HuaweiBaseData(name,password,domainName,token);
		return new HuaweiOcrService(data);
	}
//	public BaiDuService buildOcrService(){
//		baiDuBaseData = new BaiDuBaseData(clientId,clientSecret,getAccessToken(clientId,clientSecret));
//		baiDuService = new BaiDuService(baiDuBaseData);
//		return baiDuService;
//	}

}
