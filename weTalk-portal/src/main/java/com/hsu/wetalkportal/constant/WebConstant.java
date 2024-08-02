package com.hsu.wetalkportal.constant;

public enum WebConstant {

    /**
     * 通用错误码
     */
    BAD_REQUEST(400,"参数不能为空：{}"),
    SUCCESS(0, "成功"),

    PARAMETER_NULL(1000, "请求参数存在空值"),

    PARAMETER_ERROR(1001, "请求参数错误"),

    APP_NULL(1002, "未查询到业务系统"),

    APP_PWD_ERROR(1003, "应用密码错误"),

    APP_NOT_OK(1004, "业务系统未启用"),

    NO_AUTHORISE_ERROR(1005, "您没有接口访问权限，请联系管理员"),

    DEPT_TOO_MUCH(1006, "一个部门最多只允许添加两级子部门"),

    TOKEN_TYPE_ERROR(1007, "token格式错误"),

    TOKEN_ANALISE_FAIL(1008, "token解析失败，可能原因：1.业务系统标识和token不一致；2.token已失效"),

    AUTH_DATA_NULL(1009, "token中未包含认证数据"),

    TOKEN_AND_APPCODE_NOT_SAME(1010, "token认证数据和业务系统标识不一致"),
    //1226漏洞修复
    SIGN_USER_NULL(1011, "用户不存在"),

    SIGN_USER_NOT_OK(1012, "该用户未启用"),

    PASSWORD_ERROR(1013, "账户名或密码错误"),

    DEPT_INFO_NULL(1014, "未查询到部门信息"),

    DEPT_NOT_MATCH_ORGANIZATION(1015, "部门与企业未绑定"),

    CAPTCHA_ERROR(1016, "图形验证码错误"),

    DEPT_NAME_EXIST(1017, "部门已存在"),

    SIGN_USER_SEAL_NOT_EXIST(1018, "未找到印章"),

    ROLE_INFO_NULL(1019, "未查询到角色信息"),

    USER_INFO_NULL(1020, "未查询到用户信息"),

    DEPT_HAS_CHILDREN(1021, "当前部门有子部门，无法直接删除"),

    PARENT_DEPT_ERROR(1022, "不能把当前部门绑定为父部门"),

    ORGANIZATION_ALREADY_EXISTS(1023, "企业已被注册"),

    ACCOUNT_OR_PWD_NULL(1024, "账户名或密码错误"),

    ORGANIZATION_INFO_NULL(1025, "未查询到企业信息"),

    ORGANIZATION_STATUS_NO_OK(1026, "企业不可用"),

    REFRESHTOKEN_ERROR(1027, "刷新token错误"),

    USER_SOURCE_TYPE_ERROR(1028, "用户来源类型错误"),

    SMS_CODE_EXPIRE(1029, "未发送验证码或验证码已过期"),

    SMS_CODE_ERROR(1030, "短信验证码错误"),

    FILE_UPLOAD_ERROR(1031, "文件上传失败"),

    ROLE_NAME_REPEAT(1032, "同一家企业下的角色名称不可重复"),

    ORGA_NOT_BIND_ROLE(1033, "该角色与企业未绑定"),

    FORMAT_PHONE_ERROR(1035, "手机号格式错误"),

    FORMAT_IDNO_ERROR(1036, "身份证号格式错误"),

    FORMAT_EMAIL_ERROR(1037, "邮箱格式错误"),

    AUTH_STATUS_IS_OK(1038, "用户已实名"),

    AUTH_STATUS_IS_NO(1039, "用户未实名"),

    PROTOCOL_STATUS_IS_NO(1040, "未勾选信息同步协议"),

    SMS_SEND_ERROR(1041, "短信验证码发送失败"),

    USER_NOT_BIND_ROLE(1042, "未查询到角色与用户的绑定关系"),

    SEAL_IS_NULL(1043, "未查询到印章"),

    SMS_LIMIT_TIMES(1044, "今日验证码获取次数已超上限"),

    LOGIN_FAIL_LOCKED(1045, "密码连续输入错误5次,账号密码登录方式已被禁用,请30分钟之后再试"),

    PASSWORD_RULE_CHECK(1046, "密码长度必须不低于8位，且至少包含一个数字和一个字母"),

    AUTH_STRATEGY_IS_NULL(1047, "未查询到该企业的认证策略信息"),

    CERTCHAINS_IS_NULL(1048, "未查询到要删除的所有证书链"),

    SIGN_MODULES_NULL(1049, "未查询到要删除的所有签名组件"),

    PULL_INFO_ERROR(1050, "拉取信息失败"),

    SMS_TYPE_ERROR(1051, "短信类型错误"),

    SIGNMODULE_NAME_REPEAT(1052, "签名组件名称重复"),

    CRL_NAME_REPEAT(1053, "CRL名称重复"),

    CERTCHAIN_NAME_REPEAT(1054, "证书链名称重复"),

    TEXT_TOO_LARGE(1055, "只能上传大小为64KB以内的文件"),

    OPERATIONS_TOO_FREQUENT(1056, "操作频繁,请稍后再试！"),

    NAME_CONTAINS_SPECIALCHAR(1057, "名称不能包含特殊字符！"),

    CACHE_NOW_USER_NOT_SAME(1058, "待签署用户不一致"),

    FILE_DOWNLOAD_ERROR(1059, "文件下载失败"),

    CERT_IS_NULL(1060, "未查询到证书"),

    DOCUMENT_INFO_NULL(1100, "未查询到签署文件"),

    DOCUMENT_INFO_NOT_OK(1101, "签署文件未启用"),

    ATTACHMENT_DOCUMENT_INFO_NULL(1102, "未查询到附属文件"),

    ATTACHMENT_DOCUMENT_INFO_NOT_OK(1103, "附属文件未启用"),

    SPONSOR_PERSON_NULL(1104, "未查询到发起人"),

    SPONSOR_PERSON_NOT_OK(1105, "发起方未启用"),

    PARTICIPANT_USER_NULL(1109, "未查询到参与者"),

    PARTICIPANT_USER_NOT_OK(1110, "参与者未启用"),

    ENTERPRISE_NULL(1111, "未查询到企业"),

    ENTERPRISE_NOT_OK(1112, "企业未启用"),

    ENTERPRISE_NOT_SAME(1113, "传入的企业名称和查询结果不一致"),

    SIGN_USER_CERT_NOT_OK(1114, "用户证书未启用"),

    SIGN_URL_NULL(1115, "未查询到签署地址"),

    REDIS_DATA_NULL(1116, "签署数据不存在或已过期"),

    SIGNATURE_RECORD_NULL(1117, "未查询到签署记录"),

    FILE_TYPE_NOT_SUPPORT(1118, "不支持的文件格式"),

    SIGN_MODULE_FILE_ISEMPTY(1119, "文件为空"),

    SIGNATURE_RECORD_REVOKED(1120, "签署业务已被撤销"),

    AUTH_NOT_PASS(1121, "实名认证不通过"),

    SIGN_USER_SEAL_NOT_OK(1122, "用户印章未启用或未激活"),

    REQUEST_CACHE_PARAM_NULL(1123, "请求的缓存参数存在空值"),

    HAVE_NO_SEAL_PERM(1126, "没有印章权限"),
    HAVE_NO_LOG_PERM(1127, "未查询到该业务号下的日志"),

    BUSINESS_HAVA_DONE(1128, "该笔业务已完成"),

    BUSINESS_HAVA_REJECT(1129, "该笔业务因签署人拒绝已终止"),
    BUSINESS_HAVA_BACK(1130, "该笔业务已被撤销"),
    BUSINESS_HAVA_PAST(1131, "该笔业务已过期"),
    REQUEST_INDEX_HAVE_EXIST(1132, "index already exist"),
    SEAL_NOT_EXIST(1133, "根据印章地址获取印章为空"),
    SEAL_EXPIRE_TIME_SHORT(1134, "过期时间设置不能小于当前时间"),
    SERVICE_LOG_START_FAIL(1135, "无法获取发起业务失败的签署连接"),
    SIGN_TASK_NOT_EXIST(1136, "未查询到待签署的签署任务，请尝试发起"),
    BUSINESS_HAVE_NO_TASK(1138, "当前业务流水号下没有待签的签署业务"),
    BUSINESS_HAVE_NO_AWAIT_USER(1139, "当前业务流水号下没有待签用户"),
    BUSINESS_ID_CANNOT_BE_NULL(1150, "业务流水号不可为空"),
    CHECK_PRIVILEGE_ON_SEAL(1153, "校验权限异常"),

    PULL_OAUTH_PRE_ERROR(1154, "推送用户权限失败"),

    LOGIN_ID_SECRET_ERROR(1155, "应用标识错误"),

    QR_CODE_NULL(1127, "未获取到二维码"),

    SIGN_DATA_NULL(1128, "签署数据不存在或已过期"),
    SIGN_DATA_PARSE_NULL(1129, "解析签署文件失败"),
    RETURN_SUCCESS(0, "接收成功"),
    RETURN_ERROR(1, "接收失败"),

    SEAL_USER_IS_NULL(1134, "印章使用人为空"),

    SIGN_STATUS_ERROR(1135, "签署状态异常"),

    PULL_USER_INFO_NULL(1142, "拉取用户信息为空"),

    UPDATE_PHONE_EXIST_ERROR(1143, "手机号已存在"),

    PHONE_NOT_MATCH(1144, "手机号与用户已绑定的手机号不一致"),


    INSIDE_USER_CANNOT_LOGIN(1145, "无访问权限"),

    EXTERNAL_USER_CANNOT_LOGIN(1145, "无访问权限"),

    SMS_AUTHENTICATION_INVALID(1046, "身份验证已失效,请再次认证"),

    MAIN_USER_NOT_EXIST(1048, "用户不存在"),

    USER_INFO_CAHNGE(1049, "用户信息已变更，请重新登录"),

    SIGN_PIC_NULL(1050, "未设置手写签名"),

    USER_CERT_NULL(1051, "用户证书不存在"),

    USER_CERT_STATUS_ERROR(1052, "用户证书未启用"),

    CERT_NOT_BELONG_USER(1053, "该证书不属于此用户"),

    SERVICE_LOG_NULL(1054, "未查询到接口调用日志"),

    OPER_LOG_NULL(1055, "未查询到操作日志"),

    USER_NAME_NULL(1056, "用户姓名不存在"),

    LOGIN_TOKEN_EXPIRE(1057, "登录token已过期"),

    ORGA_NOT_BIND_USER(1058, "用户未绑定该企业"),

    PHONE_LOGIN_FAIL_LOCKED(1059, "短信验证码连续输入错误5次,短信验证码登录方式已被禁用,请30分钟之后再试"),

    DEPTNO_IS_EXIST(1060, "部门编号已注册,请更换编号"),

    USERNAME_NOT_SAME(1061, "所填姓名与系统内已实名用户信息不匹配，无法添加"),

    CERT_NOT_EMPTY(1062, "请勿重复申请证书"),

    SEAL_TYPE_ERROR(1063, "印章类型错误"),

    ORGANIZATION_NAME_ALREADY_EXISTS(1064, "企业名称已存在"),

    ORGANIZATION_CODE_ALREADY_EXISTS(1065, "统一社会信用代码已存在"),

    SIGN_PASSWORD_ERROR(1066, "签署密码错误"),

    USER_INFO_ERROR(1067, "用户信息不匹配"),

    ORGANIZATION_INFO_ERROR(1068, "企业信息不匹配"),

    SIGN_PASSWORD_NULL(1069, "签署密码为空，请先前往用户中心设置签署密码"),

    USERUUID_IS_EXIST(1067, "该工号已被使用，请更换"),

    SEAL_REQUEST_WAIT_ERROR(1068, "印章已申请，请等待审核"),
    ORGANIZATION_USER_INFO_ERROR(1069, "经办人信息不匹配"),
    FLOW_TEMPLATE_GROUP_INFO_ERROR(1070, "流程分组名称修改失败"),
    FLOW_TEMPLATE_GROUP_Delete_ERROR(1071, "流程分组删除失败"),
    FLOW_TEMPLATE_GROUP_UPDATE_SORT_ERROR(1072, "流程分组排序修改失败"),
    FLOW_TEMPLATE_GROUP_CREATE_ERROR(1073, "流程分组创建失败"),
    FLOW_TEMPLATE_GROUP_CREATE_NAME_ERROR(1074, "流程分组名称已存在"),
    USER_PHONE_NOT_EXIST_ERROR(1075, "用户手机号不存在"),
    USER_UUID_NOT_EXIST_ERROR(1076, "用户工号不存在"),

    CAS_LOGIN_ERROR(1077, "统一认证登录失败，请重试"),
    USER_INFO_ISNULL(1078,"用户不存在"),
    /**
     * 请求异常
     */
    REQUEST_ERROR(9998, "请求异常"),
    /**
     * 系统错误
     */
    ERROR(9999, "系统错误"),
    ERROR1(9997, "参数错误"),
    ERROR2(9999, "请求超时，请稍后再试"),
    PARAM_ERROR_CODE(1059,"存在不合理参数"),
    APPROVER_IS_NULL(2001, "未获取到审批人信息"),
    INVALID_ORG_ID(2002, "组织机构ID无效"),
    ORGANIZATION_NOT_FOUND(2003, "组织机构不存在" ),
    APPROVAL_LOG_IS_NULL(2004,"未查询到审批记录" ),
    ADJUST_NUM_SIZE(2005, "请调整页码"),
    NEW_GROUP_INFO(2006,"请输入新的分组名称" ),

    APPINFO_IS_NULL(2007,"应用信息不存在"),
    APP_ISNOT_NULL(2008,"应用名称已存在" );

    private final int code;
    private final String msg;

    WebConstant(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

}
