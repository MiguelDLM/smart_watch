package com.jd.ad.sdk.jad_uh;

import android.text.TextUtils;
import com.baidu.ar.base.MsgField;
import com.iflytek.sparkchain.utils.constants.ErrorCode;

/* loaded from: classes10.dex */
public enum jad_an {
    CRASH_ERROR(-100, "error"),
    /* JADX INFO: Fake field, exist only in values array */
    CACHE_EXEC_SQL_ERROR(11001, "exec sql error"),
    CACHE_CREATE_DB_ERROR(11002, "create db error"),
    /* JADX INFO: Fake field, exist only in values array */
    CACHE_QUERY_DB_ERROR(ErrorCode.MSP_ERROR_LOGIN_SESSIONID_ERROR, "query db error"),
    CACHE_SAVE_CACHE_OTHER_ERROR(ErrorCode.MSP_ERROR_LOGIN_UNLOGIN, "save cache error"),
    /* JADX INFO: Fake field, exist only in values array */
    CACHE_SAVE_DB_ERROR(ErrorCode.MSP_ERROR_LOGIN_INVALID_USER, "save db error"),
    CACHE_DELETE_CACHE_ERROR(ErrorCode.MSP_ERROR_LOGIN_INVALID_PWD, "delete cache error"),
    CACHE_LOAD_DISC_TO_MEMORY_ERROR(11007, "load cache error"),
    CACHE_READ_CACHE_ERROR(11008, "read cache error"),
    CACHE_DYNAMIC_RENDER_CREATE_TEMPLATE_DB_ERROR(11009, "create template db error"),
    CACHE_DYNAMIC_RENDER_QUERY_TEMPLATE_DB_ERROR(11010, "query template db error"),
    CACHE_PRELOAD_AD_CREATE_DB_TABLE_ERROR(11011, "create preload db table error"),
    CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR(11012, "query preload db table error"),
    UTILS_IO_STREAM_CLOSE_ERROR(12001, "io close error"),
    /* JADX INFO: Fake field, exist only in values array */
    UTILS_INVALID_MCC_MNC_ERROR(12002, "invalid mcc and mnc value"),
    UTILS_OADI_REFLECT_MDIDSDKHELPER_ERROR(12003, "init oaid reflect MdidSdkHelper class error"),
    UTILS_OADI_REFLECT_IIDENTIFIERLISTENER_ERROR(12004, "init oaid reflect IIdentifierListener class error"),
    UTILS_OADI_REFLECT_INITENTRY_ERROR(12005, "init oaid reflect InitEntry method error"),
    UTILS_OADI_REFLECT_ERROR(12006, "init oaid reflect error"),
    MULTIPLE_PROCESS_CONTENT_PROVIDER_QUERY_EVENT_ERROR(13001, "multiple process contentProvider query event error"),
    MULTIPLE_PROCESS_CONTENT_PROVIDER_QUERY_TEMPLATE_ERROR(13002, "multiple process contentProvider query template error"),
    MULTIPLE_PROCESS_CONTENT_PROVIDER_INSERT_SP_ERROR(13003, "multiple process contentProvider insert sp error"),
    MULTIPLE_PROCESS_CONTENT_PROVIDER_GET_TYPE_ERROR(13004, "multiple process contentProvider get type error"),
    MULTIPLE_PROCESS_CONTENT_PROVIDER_UPDATE_EVENT_ERROR(13005, "multiple process contentProvider update event error"),
    MULTIPLE_PROCESS_CONTENT_PROVIDER_UPDATE_TEMPLATE_ERROR(13006, "multiple process contentProvider update template error"),
    MULTIPLE_PROCESS_CONTENT_PROVIDER_DELETE_EVENT_ERROR(13007, "multiple process contentProvider delete event error"),
    MULTIPLE_PROCESS_CONTENT_PROVIDER_DELETE_SP_ERROR(13008, "multiple process contentProvider delete sp error"),
    MULTIPLE_PROCESS_SP_UPDATE_ERROR(13009, "multiple process update sp error"),
    /* JADX INFO: Fake field, exist only in values array */
    MULTIPLE_PROCESS_SP_REMOVE_ERROR(13010, "multiple process remove sp error"),
    MULTIPLE_PROCESS_SP_GET_ERROR(13011, "multiple process query sp error"),
    MULTIPLE_PROCESS_TEMPLATE_QUERY_ERROR(13012, "multiple process query template error"),
    MULTIPLE_PROCESS_EVENT_QUERY_ERROR(13013, "multiple process event query error"),
    MULTIPLE_PROCESS_PRELOAD_AD_QUERY_ERROR(13014, "multiple process preload ad query error"),
    MULTIPLE_PROCESS_PRELOAD_AD_UPDATE_ERROR(13015, "multiple process preload ad update error"),
    MULTIPLE_PROCESS_PRELOAD_AD_DELETE_ERROR(13016, "multiple process preload ad delete error"),
    AN_REQUEST_ERROR(30001, "an request error"),
    AN_REQUEST_OTHER_ERROR(MsgField.MSG_NO_NETWORK_FOR_DOWNLOAD_RES, "an request other error"),
    AN_REQUEST_JSON_ERROR(30003, "an request json error"),
    AN_RESULT_BODY_NULL_ERROR(30004, "an response body is null"),
    AN_RESPONSE_BODY_CONTENT_NULL_ERROR(30005, "an response data is null"),
    AN_RESPONSE_DATA_IO_ERROR(30006, "an response read data io error"),
    AN_RESPONSE_DATA_DES_ERROR(30007, "an response data decrypt error"),
    AN_RESPONSE_JSON_PARSER_ERROR(30008, "an response json parse error"),
    AN_RESPONSE_DATA_PROCESS_ERROR(30009, "an response data error"),
    AN_RESPONSE_DATA_PROCESS_OTHER_ERROR(30010, "an response data other error"),
    GW_REQUEST_REGISTER_AD_SERVICE_ERROR(31002, "ad load failed"),
    GW_REQUEST_URL_IS_NULL_ERROR(31003, "url is null"),
    GW_REQUEST_SLOT_ID_IS_NULL_ERROR(31004, "slot id is null"),
    GW_REQUEST_JSON_ERROR(31006, "load error"),
    GW_REQUEST_OTHER_ERROR(31007, "load error"),
    GW_REQUEST_TEMPLATE_SPLASH_FORBIDDEN_ERROR(31008, "ad load failed!"),
    GW_REQUEST_TEMPLATE_INTERSTITIAL_FORBIDDEN_ERROR(31009, "ad load failed!"),
    GW_REQUEST_TEMPLATE_BANNER_FORBIDDEN_ERROR(31010, "ad load failed!"),
    GW_REQUEST_TEMPLATE_FEED_FORBIDDEN_ERROR(31011, "ad load failed!"),
    GW_REQUEST_NATIVE_SPLASH_FORBIDDEN_ERROR(31012, "ad load failed!"),
    GW_REQUEST_NATIVE_INTERSTITIAL_FORBIDDEN_ERROR(31013, "ad load failed!"),
    GW_REQUEST_NATIVE_BANNER_FORBIDDEN_ERROR(31014, "ad load failed!"),
    GW_REQUEST_NATIVE_FEED_FORBIDDEN_ERROR(31015, "ad load failed!"),
    GW_REQUEST_FORBIDDEN_ERROR(31016, "ad load failed!"),
    GW_REQUEST_NET_IS_UNAVAILABLE_ERROR(31017, "Network is not available,please check network"),
    GW_REQUEST_PRELOAD_AD_DARA_EXCEEDED_UPPER_LIMIT_ERROR(31019, "The number of preload ad exceeded the upper limit"),
    /* JADX INFO: Fake field, exist only in values array */
    GW_REQUEST_PRELOAD_AD_DARA_CACHE_ERROR(31020, "request preload cache data failed"),
    GW_REQUEST_FORBID_PRELOAD_ERROR(31021, "forbid preload interface function"),
    GW_REQUEST_SIZE_ERROR(-700, "illegal width or height"),
    GW_RESPONSE_BODY_NULL_ERROR(32001, "gw response body is null"),
    GW_RESPONSE_BODY_DATA_NULL_ERROR(32002, "gw response data is null"),
    GW_RESPONSE_DES_ERROR_ERROR(32003, "gw response data decrypt error"),
    GW_RESPONSE_JSON_PARSER_ERROR(32004, "gw response json parse error"),
    GW_RESPONSE_DATA_IO_ERROR(32005, "gw response data io error"),
    GW_RESPONSE_OTHER_ERROR(32006, "gw response other error"),
    RENDER_DYNAMIC_GW_RESPONSE_TEMPLATE_ID_NULL_ERROR(33005, "gw response template_id is null"),
    RENDER_DYNAMIC_LOCAL_TEMPLATE_NULL_ERROR(33006, "dynamic render local template is null"),
    RENDER_DYNAMIC_LOCAL_TEMPLATE_JSON_NULL_ERROR(33007, "dynamic render local template_json is null"),
    RENDER_DYNAMIC_VIEW_INIT_VAR_REPLACE_ERROR(33008, "templateJSON replace vars error"),
    RENDER_DYNAMIC_VIEW_INIT_JSON_PARSE_ERROR(33009, "templateJSON parse error"),
    RENDER_DYNAMIC_VIEW_INIT_LOTTIE_PARSE_ERROR(33010, "lottie parse error"),
    RENDER_DYNAMIC_VIEW_INIT_LOAD_IMAGES_ERROR(33011, "load images error"),
    RENDER_DYNAMIC_VIEW_INIT_ADD_EVENT_ERROR(33012, "layers add event error"),
    RENDER_DYNAMIC_VIEW_PLAY_ERROR(33014, "lottie view is null when start play"),
    RENDER_DYNAMIC_INIT_VIEW_OTHER_ERROR(33015, "dynamic render view init exception"),
    EXPOSURE_SERVER_REPORT_ERROR(34002, "gw exposure server report failed"),
    INTERACTION_CLICK_OPEN_JD_ERROR(35001, "open app error "),
    URL_AC_LENGTH_EXCEEDS_2KB(35002, "url ac length exceeds 2kb"),
    OPEN_JD_URL_LENGTH_EXCEEDS_4KB(35003, "open jd url length exceeds 4kb"),
    /* JADX INFO: Fake field, exist only in values array */
    VIDEO_PLAY_ERRER(35101, "video play error");

    public int jad_an;
    public String jad_bo;

    jad_an(int i, String str) {
        this.jad_an = i;
        this.jad_bo = str;
    }

    public int jad_an() {
        return this.jad_an;
    }

    public String jad_an(String... strArr) {
        StringBuilder sb = new StringBuilder(this.jad_bo);
        if (strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    sb.append(":");
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }
}
