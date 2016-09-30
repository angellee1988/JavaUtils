package util;

import org.apache.commons.lang.StringUtils;

/**
 * 常量类
 * @author 金砖
 *
 */
public class Constants {


    /**
     * 在sso中更新记录，在business_user中插入记录
     */
    public final static String UPDATE_SSO_INSERT_USERS="updateinsert";
    /**
     * 常量，表示要在sso和business中分别插入记录
     */
    public final static String INSERT_SSO_INSERT_USERS="inserttwo";
	/**
	 * 分配配置邀约部门常量
	 */
	public final static Integer BOSS_SUCCESS_AUCTION_AUTO_COMPELETE_EMP = !"".equals(PropertiesUtils.getContextProperty("BOSS_SUCCESS_AUCTION_AUTO_COMPELETE_EMP"))?Integer.valueOf(PropertiesUtils.getContextProperty("BOSS_SUCCESS_AUCTION_AUTO_COMPELETE_EMP")):34;
	
	/**
	 * 检测邀约 部门常量 邀约专员职位ID
	 */
	public final static Integer BOSS_INVITATION_AUTO_COMPELETE_EMP = !"".equals(PropertiesUtils.getContextProperty("BOSS_INVITATION_AUTO_COMPELETE_EMP"))?Integer.valueOf(PropertiesUtils.getContextProperty("BOSS_INVITATION_AUTO_COMPELETE_EMP")):96;
	/**
	 * 检测邀约 部门常量 调度专员职位ID
	 */
	public final static Integer BOSS_INVITATION_SCHEDULE_EMP = !"".equals(PropertiesUtils.getContextProperty("BOSS_INVITATION_SCHEDULE_EMP"))?Integer.valueOf(PropertiesUtils.getContextProperty("BOSS_INVITATION_SCHEDULE_EMP")):115;
	
	/**
	 * 检测邀约 部门常量 调度专员角色ID
	 */
	public final static Integer BOSS_INVITATION_SCHEDULE_ROLE_ID = !"".equals(PropertiesUtils.getContextProperty("BOSS_INVITATION_SCHEDULE_ROLE_ID"))?Integer.valueOf(PropertiesUtils.getContextProperty("BOSS_INVITATION_SCHEDULE_ROLE_ID")):20;
	
	/**
	 * 报名接口地址
	 */
	public final static String TTP_SIGNUP_API_ADDR = !"".equals(PropertiesUtils.getContextProperty("TTP_SIGNUP_API_ADDR"))?PropertiesUtils.getContextProperty("TTP_SIGNUP_API_ADDR"):"http://sandbox.openapi.ttpai.cn/api/v1.1/ttp_sign_up" ;
	
	/**发车相关的jobid**/
    public final static String AFTERSALE_DEPART_JOB_IDS=PropertiesUtils.getContextProperty("AFTERSALE_DEPART_JOB_IDS");
    /**手续相关的jobid**/
    public final static String AFTERSALE_PROCEDURES_JOB_IDS=PropertiesUtils.getContextProperty("AFTERSALE_PROCEDURES_JOB_IDS");
	/**接待相关的jobid**/
    public final static String RECEPTION_JOB_IDS=PropertiesUtils.getContextProperty("RECEPTION_JOB_IDS");
    /**回调老crm开关  Y为需要 N为不需要**/
    public final static String NEED_CALLBACK_CRM_OLD=PropertiesUtils.getContextProperty("NEED_CALLBACK_CRM_OLD");
    
	/**检测师jobid**/
    public final static String CHECER_ROLE_IDS=PropertiesUtils.getContextProperty("CHECER_ROLE_IDS");
    /**商拓jobid**/
    public final static String BUSINESS_ROLE_IDS=PropertiesUtils.getContextProperty("BUSINESS_ROLE_IDS");
    /**邀约jobid**/
    public final static String INVAITION_ROLE_IDS=PropertiesUtils.getContextProperty("INVAITION_ROLE_IDS"); 
    /**发车roleid**/
    public final static String DEPART_ROLE_IDS=PropertiesUtils.getContextProperty("DEPART_ROLE_IDS");
    /**手续roleid**/
    public final static String PROCEDURE_ROLE_IDS=PropertiesUtils.getContextProperty("PROCEDURE_ROLE_IDS");
    /**已开通代办手续城市id**/
    public final static String OPEN_COMMISSION_CITYS=PropertiesUtils.getContextProperty("OPEN_COMMISSION_CITYS");
    /**商家资料管理中能看到商家手机号的账户**/
    public final static String BUSINESS_WHITE_LIST=PropertiesUtils.getContextProperty("BUSINESS_WHITE_LIST");
	/**
	 * 其他经销商ID
	 */
	public final static Integer BOSS_SUCCESS_AUCTION_OTHER_DEALER_ID=16431;
	
	/**
	 * 其他经销商NAME
	 */
	public final static String BOSS_SUCCESS_AUCTION_OTHER_DEALER_NAME="其他经销商";
	
	/**
	 * 邀约确认违约金
	 */
    public static final Integer SUCCESS_AUCTION_SURE_VIOLATE_PRICE=2000;
	
	/**
	 * cookie中保存的信息----------------------------------分割线------------------------------------
	 */
    public final static String BOSS_COOKIE_ACCOUNT  = PropertiesUtils.getContextProperty("COOKIE_ACCOUNT");
    
    public final static String BOSS_COOKIE_ACCOUNT_NAME = PropertiesUtils.getContextProperty("COOKIE_ACCOUNT_NAME");
    
    public final static String BOSS_COOKIE_ACCOUNT_ADMINID = PropertiesUtils.getContextProperty("COOKIE_ACCOUNT_ADMINID");
    
    public final static String BOSS_COOKIE_ACCOUNT_TOKEN = PropertiesUtils.getContextProperty("COOKIE_ACCOUNT_TOKEN");
    
    public final static String BOSS_COOKIE_ACCOUNT_SKILL = PropertiesUtils.getContextProperty("COOKIE_ACCOUNT_SKILL");
    
    /**
     * cookie中保存的信息的key
     */
    public final static String BOSS_ACCOUNT_KEY_VALUE = PropertiesUtils.getContextProperty("ACCOUNT_KEY_VALUE");
    /**
     * cookie中保存的信息的分隔符
     */
    public final static String BOSS_COOKIE_SPT=":";
    
    //================================================cookie中的信息结束================================================================
    /**
     * utf-8编码
     */
    public final static String UTF8="utf-8";
    /**
     * 交互中参数默认的分隔符，
     */
    public final static String STR_SPT=",";
    
    /**
     * 标示json格式的error信息
     */
    public final static String ROSE_RETURN_ERROR="@error:";
    /**
     * 标示json格式的普通信息
     */
    public final static String ROSE_RETURN_JSON="@json:";
    /**
     * 标示json格式的成功信息
     */
    public final static String ROSE_SUCCESS_RETURN_JSON="@json:{}";
    /**
     * 用户默认密码
     */
    public final static String ACCOUNT_DEFAULT_PASSPORT=StringUtils.isBlank(PropertiesUtils.getContextProperty("ACCOUNT_PASSPORT"))?"123456a":PropertiesUtils.getContextProperty("ACCOUNT_PASSPORT");
    
    /**
     * 天润外呼通话记录====================================================天润start
     */
    public final static String TIANRUN_DIALOUT_HISTORY="http://p-ttpc.ccic2.com/interfaceAction/cdrObInterface!listCdrOb.action";
    /**
     * 天润来电通话记录
     */
    public final static String TIANRUN_RING_HISTORY="http://p-ttpc.ccic2.com/interfaceAction/cdrIbInterface!listCdrIb.action";
    /**
     * 天润账号
     */
    public final static String TIANRUN_LOGIN_USERNAME=PropertiesUtils.getContextProperty("TIANRUN_LOGIN_USERNAME");
    /**
     * 天润密码
     */
    public final static String TIANRUN_LOGIN_PASSPORT=PropertiesUtils.getContextProperty("TIANRUN_LOGIN_PASSPORT");
    /**
     * 天润主热线号码
     */
    public final static String TIANRUN_HOT_LINE=PropertiesUtils.getContextProperty("TIANRUN_HOT_LINE");
    /**
     * 永不下线的角色id
     */
    public final static Integer BOSS_TIANRUN_ONLINE_ROLEID= !"".equals(PropertiesUtils.getContextProperty("BOSS_TIANRUN_ONLINE_ROLEID"))?Integer.valueOf(PropertiesUtils.getContextProperty("BOSS_TIANRUN_ONLINE_ROLEID")):54;
    //===================================================================天润end
    
    /**
     * 图片上传配置=================================================图片=====
     */
    public final static String BOSS_TFS_URL= PropertiesUtils.getContextProperty("tfs_path_prefix", "http://pic001.ttpaicdn.com/images/");

    public static final String OLD_CRM_IMAGE_PATH = PropertiesUtils.getContextProperty("old_crm_image_path", "http://pic002.ttpaicdn.com/");// 老 CRM 图片路径 /group1/M00/00/4E/rB8JClORiZeAYP5WAAGf0B2zZgw296.jpg

    /**
     * 图片限制最大宽高
     */
    public final static Float BOSS_MAX_WIDTH=1200F;
    public final static Float BOSS_MAX_HIGHT=900F;
    /**
     * 图片限制大小k
     */
    public final static Integer BOSS_MAX_QUALITY=5242880;

    /**人工挖掘的验证码**/
    public final static String RGWJ_SIGN_CODE=PropertiesUtils.getContextProperty("RGWJ_SIGN_CODE");
    
    /**数据挖掘的SourceId 默认214**/
    public final static Integer SJWJ_SOURCE_ID=!"".equals(PropertiesUtils.getContextProperty("SJWJ_SOURCE_ID"))?Integer.valueOf(PropertiesUtils.getContextProperty("SJWJ_SOURCE_ID")):214;
    /**数据挖掘的来源文本（数据挖掘）**/
    public final static String SJWJ_SOURCE_TEXT=!"".equals(PropertiesUtils.getContextProperty("SJWJ_SOURCE_TEXT"))?PropertiesUtils.getContextProperty("SJWJ_SOURCE_TEXT"):"数据挖掘";
    
    /**数据挖掘的SourceId 默认214**/
    public final static String ZBJH_SOURCE=!"".equals(PropertiesUtils.getContextProperty("ZBJH_SOURCE"))?PropertiesUtils.getContextProperty("ZBJH_SOURCE"):"214-292";
    /**数据挖掘的SourceId 默认214**/
    public final static Integer ZBJH_CHANNEL_ID=!"".equals(PropertiesUtils.getContextProperty("ZBJH_CHANNEL_ID"))?Integer.valueOf(PropertiesUtils.getContextProperty("ZBJH_CHANNEL_ID")):292;
    /**数据挖掘的来源文本（数据挖掘）**/
    public final static String ZBJH_CHANNEL_TEXT=!"".equals(PropertiesUtils.getContextProperty("ZBJH_CHANNEL_TEXT"))?PropertiesUtils.getContextProperty("ZBJH_CHANNEL_TEXT"):"战败激活";
    /**
     * ==========================================后台请求天润接口常量定义============================================
     */
    public static final String TIAN_RUN_DEMAIN="http://p-ttpc.ccic2.com/interface/PreviewOutcall?";
    
    public static final String TIAN_RUN_OUTCALL="http://p-ttpc.ccic2.com/interface/PreviewOutcall";
    /**
     * 热线号码
     */
    public static final String HOTLINE="80203400";

    /**
     * 企业ID号
     */
    public static final String ENTERPRISEID=PropertiesUtils.getContextProperty("TIANRUN_ENTERPRISE_ID");

    /**
     * 登录密码
     */
    public static final String TIAN_RUN_PWD="ttp123456";

    /**
     * 坐席号码
     */
    public static final String CNO="2002";

    /**
     * 是否同步
     */
    public static final String CYNC="1";

    /**
     * 是否同步 异步
     */
    public static final String NON_CYNC="0";

    /**
     * 天润参数秘钥
     */
    public static final String TR_TOKEN_SALT_KEY= PropertiesUtils.getContextProperty("TR_TOKEN_SALT_KEY","tr_token");
    /**
     * sid加密key
     */
    public static final String SALT_KEY= PropertiesUtils.getContextProperty("SALT_KEY","pricesms");
}
