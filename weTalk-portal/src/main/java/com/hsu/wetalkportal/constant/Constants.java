package com.hsu.wetalkportal.constant;

/**
 * 通用常量信息
 *
 * @author custle
 */
public class Constants {
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * 通用成功标识
     */
    public static final String SUCCESS = "0";

    /**
     * 通用失败标识
     */
    public static final String FAIL = "1";

    /**
     * 通用成功标识
     */
    public static final int SUCCESS_INT = 0;

    /**
     * 通用失败标识
     */
    public static final int FAIL_INT = 1;

    /**
     * ResultUtil中成功定义
     */
    public static final int RESULT_SUCCESS = 0;

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 自动去除表前缀
     */
    public static final String AUTO_REOMVE_PRE = "true";

    /**
     * 当前记录起始索引
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static final String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static final String IS_ASC = "isAsc";

    /**
     * 登录标识
     */
    public static final String LOGIN_CODE = "login_code";
    /**
     * 名称是否唯一的返回结果码
     */
    public final static String UNIQUE = "0";
    public final static String NOT_UNIQUE = "1";

    /**
     * 缓存前缀
     */
    public static final String REDIS_PREFIX_KEY = "sign_";

    public static final String REDIS_PORTAL_PREFIX_KEY = "sign_portal";

    /**
     * 用户导入错误提示
     */
    public static final String EMPTY_ERROR_MSG = "第%s行用户必填项为空，未导入该行用户。";
    public static final String ACCOUNT_ERROR_MSG = "第%s行用户账号已存在，未导入该行用户。";
    public static final String MAIL_EXIST_MSG = "第%s行用户邮箱已存在，未导入该行用户。";
    public static final String MAIL_ERROR_MSG = "第%s行用户邮箱格式错误，未导入该行用户。";
    public static final String PHONE_ERROR_MSG = "第%s行用户手机号已存在，未导入该行用户。";
    public static final String IDNO_ERROR_MSG = "第%s行用户证件号已存在，未导入该行用户。";

    /**
     * 导入用户起始行数
     */
    public static final Integer EXCEL_IMPORT_USER_START_LINE = 11;

    /**
     * jwt有效时间
     */
    public static final Integer JWT_TIME = 120;

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 测试证书签发密钥
     */

    public static final int TEST_CA_INDEX = 1;
    /**
     * 证书默认有效期
     */
    public static final int validity = 3;

    /** 根证书有效期 */
    public static final int ROOT_CERT_PERIOD = 20;
    /** P7B */
    public static final int DOWNLOAD_P7B = 1;
    /** CER */
    public static final int DOWNLOAD_CER = 2;


    /**
     * 10分钟
     */
    public static final int CODE_TIME_HALF_HOUR = 10 * 60;


}
