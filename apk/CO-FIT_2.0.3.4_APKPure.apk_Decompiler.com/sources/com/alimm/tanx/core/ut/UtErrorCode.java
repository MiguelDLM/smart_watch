package com.alimm.tanx.core.ut;

public enum UtErrorCode {
    IMP_URL_ERROR("8001", "曝光串数据异常"),
    VIDEO_DOWNLOAD_ERROR("8002", "视频素材下载失败"),
    REQUEST_URL_ERROR("8003", "请求的url不合法"),
    NETWORK_ERROR("8006", "网络异常请查看对应日志"),
    NETWORK_ONLY_ONE_NET_ERROR_EXCEPTION("8007", "onlyOneNet error"),
    DECRYPT_ERROR("8008", "解密异常"),
    OK_HTTP_ERROR("8009", "网络框架异常"),
    ERROR_NO_CACHED_ASSET("8010", "本地无缓存素材"),
    ERROR_AD_TIME_OUT("8011", "素材获取超时"),
    ERROR_AD_NOT_IN_DURING_RELEASE("8012", "该广告不在投放期"),
    ERROR_NO_BID_INFO("8013", "开屏广告对象bidInfo为空"),
    ERROR_RS_INVALID("8014", "开屏实时请求下来的广告素材的url为空，无法进行展示报错"),
    ERROR_IMG_LOAD("8015", "开屏图片加载框架加载图片出错"),
    ERROR_AD_LISTENER("8016", "开屏广告请求回调异常"),
    CRASH_H5_ERROR("8995", "H5异常"),
    ERROR_LOGIC("8996", "逻辑异常"),
    NETWORK_DOWNLOAD_EXCEPTION("8997", "下载出错"),
    NETWORK_HTTP_CODE_EXCEPTION("8998", "服务器返回的状态码不在200-299之间"),
    CRASH_ERROR("8999", "crash相关"),
    IMAGE_LOAD_NULL("6000", "imageLoad为空"),
    NETWORK_CONNECT_EXCEPTION("6001", "网络连接相关错误"),
    NETWORK_TIMEOUT("6002", "网络请求超时"),
    NETWORK_PARAM_ERROR("6003", "传入参数有误，清检请求传入参数（本地参数有误）"),
    DATA_PARSE_ERROR("6004", "服务端数据异常"),
    TIMER_OUT("6005", "计时器超时"),
    APP_DEVICE_NUMBER_NULL("6200", "设备号为空（imei/oaid）"),
    APP_KEY_NULL("6201", "appKey为空"),
    PID_NULL("6203", "pid为空"),
    MEDIA_UID_NULL("6204", "media_uid为空"),
    REQUEST_PARAM_ERROR("6205", "构建请求参数过程出现异常,请关注异常日志"),
    REQUEST_BEAN_ERROR("6206", "构建请求参数过程出现异常,构建requestBean == null"),
    REWARD_QUERY_FREQUENCY_OVERRUN("6401", "发奖接口频控限制"),
    REWARD_QUERY_NULL("6402", "查询成功，但没有奖励信息"),
    SERVER_RETURN_ERROR("server_", "服务器错误"),
    SERVER_RETURN_1("server_", "广告无填充"),
    ERROR_NO_AD_ITEM("9001", "开屏返回无广告节点"),
    ERROR_NO_AD_DURING_RELEASE("9002", "广告缓存数据失效"),
    ERROR_QUERY_REWARD("9003", "奖励查询过程出现问题"),
    JSON_PARSE_ERROR("9004", "JSON_PARSE过程异常"),
    CONFIG_SERVER_NOT_CODE("9005", "配置请求过程服务端没有返回错误码"),
    CONFIG_SERVER_CODE_PARSE_INTEGER_ERROR("9006", "配置接口解析状态码为int过程异常");
    
    private final String code;
    private final String msg;

    private UtErrorCode(String str, String str2) {
        this.code = str;
        this.msg = str2;
    }

    public String getCode() {
        return this.code;
    }

    public int getIntCode() {
        return Integer.parseInt(this.code);
    }

    public String getMsg() {
        return this.msg;
    }
}
