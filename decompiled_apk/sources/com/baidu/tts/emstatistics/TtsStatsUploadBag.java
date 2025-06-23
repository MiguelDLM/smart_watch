package com.baidu.tts.emstatistics;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class TtsStatsUploadBag {
    public static final String KEY_APP_ID = "appid";
    public static final String KEY_AUDIO_DURATION = "audio_duration";
    public static final String KEY_CONNECT_TIMEOUT = "ctimeout";
    public static final String KEY_DNS_ETIME = "dns_etime";
    public static final String KEY_DNS_STIME = "dns_stime";
    public static final String KEY_ENGINE_VERSION = "so_version";
    public static final String KEY_FIRST_RESPONSE_TIME = "time_first_bag";
    public static final String KEY_HTTP_STATUS_CODE = "status_code";
    public static final String KEY_NET_EXCEPTION = "net_exception";
    public static final String KEY_NET_TYPE = "net_type";
    public static final String KEY_OFFLINE_CODE = "offline_error_code";
    public static final String KEY_ONLINE_CODE = "online_ecode";
    public static final String KEY_ONLINE_MESSAGE = "online_msg";
    public static final String KEY_OPERATOR_NAME = "operator";
    public static final String KEY_PACKAGE_INFOS = "package_infos";
    public static final String KEY_QUERY_END_TIME = "query_etime";
    public static final String KEY_QUERY_START_TIME = "query_stime";
    public static final String KEY_READ_EXCEPTION = "read_exception";
    public static final String KEY_SPEAKER = "speaker";
    public static final String KEY_SYN_ETIME = "syn_etime";
    public static final String KEY_SYN_STIME = "syn_stime";
    public static final String KEY_SYN_TEXT = "syn_text";
    public static final String KEY_TP_READY_TIME = "tp_ready_time";
    public static final String KEY_TTS_PACKAGE_IDX = "tts_idx";
    public static final String KEY_URL = "url";
    public static final String KEY_USE_ONLINE = "use_online";
    public String b;
    public int c;
    public int d;
    public String f;
    public String g;
    public String i;
    public String l;
    public String n;
    public long o;

    /* renamed from: a, reason: collision with root package name */
    public int f10082a = 0;
    public int e = -1;
    public long h = 0;
    public String j = "";
    public int k = 0;
    public int m = 0;
    public String p = "{}";

    public Map<String, Object> getAttributes() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(MapBundleKey.MapObjKey.OBJ_SL_INDEX, Integer.valueOf(this.c));
        linkedHashMap.put("sn", this.n);
        linkedHashMap.put("error_code", Integer.valueOf(this.m));
        linkedHashMap.put("sub_error_code", Integer.valueOf(this.f10082a));
        linkedHashMap.put("error_des", this.j);
        linkedHashMap.put("tts_mode", Integer.valueOf(this.d));
        linkedHashMap.put(KEY_SPEAKER, this.l);
        linkedHashMap.put("timestamp", Long.valueOf(this.o));
        linkedHashMap.put(SDKConstants.PARAM_A2U_TIME_INTERVAL, Long.valueOf(this.h));
        linkedHashMap.put(KEY_NET_TYPE, this.b);
        linkedHashMap.put("pid", Integer.valueOf(this.e));
        linkedHashMap.put("ttsresult", Integer.valueOf(this.k));
        linkedHashMap.put("speech_info", this.f);
        linkedHashMap.put("phone_model", this.i);
        LoggerProxy.d("statistics", "cityid=" + this.g);
        linkedHashMap.put("cityid", this.g);
        linkedHashMap.put(ShareConstants.MEDIA_EXTENSION, this.p);
        return linkedHashMap;
    }

    public String getCityid() {
        return this.g;
    }

    public int getErrorCode() {
        return this.m;
    }

    public String getErrorDes() {
        return this.j;
    }

    public int getIndex() {
        return this.c;
    }

    public String getNetType() {
        return this.b;
    }

    public String getPhoneModel() {
        return this.i;
    }

    public int getPid() {
        return this.e;
    }

    public String getSn() {
        return this.n;
    }

    public String getSpeaker() {
        return this.l;
    }

    public String getSpeechInfo() {
        return this.f;
    }

    public int getSubErrorCode() {
        return this.f10082a;
    }

    public double getTimeInterval() {
        return this.h;
    }

    public long getTimestamp() {
        return this.o;
    }

    public int getTtsMode() {
        return this.d;
    }

    public int getTtsresult() {
        return this.k;
    }

    public void setCityid(String str) {
        this.g = str;
    }

    public void setErrorCode(int i) {
        this.m = i;
    }

    public void setErrorDes(String str) {
        this.j = str;
    }

    public void setExtension(String str) {
        if (!str.isEmpty()) {
            this.p = str;
        }
    }

    public void setIndex(int i) {
        this.c = i;
    }

    public void setNetType(String str) {
        this.b = str;
    }

    public void setPhoneModel(String str) {
        this.i = str;
    }

    public void setPid(int i) {
        this.e = i;
    }

    public void setSn(String str) {
        this.n = str;
    }

    public void setSpeaker(String str) {
        this.l = str;
    }

    public void setSpeechInfo(String str) {
        this.f = str;
    }

    public void setSubErrorCode(int i) {
        this.f10082a = i;
    }

    public void setTimeInterval(long j) {
        this.h = j;
    }

    public void setTimestamp(long j) {
        this.o = j;
    }

    public void setTtsMode(int i) {
        this.d = i;
    }

    public void setTtsresult(int i) {
        this.k = i;
    }
}
