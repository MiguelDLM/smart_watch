package com.baidu.tts;

import com.baidu.ar.constants.HttpConstants;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.ui.routeguide.fsm.RGState;
import com.baidu.navisdk.util.jar.style.StyleAttr;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tts.emstatistics.TtsStatsUploadBag;
import com.facebook.appevents.UserDataStore;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.ClientCookie;
import com.huawei.openalliance.ad.constant.bn;
import com.sma.smartv3.network.GetGomoreAuthKey;
import com.sma.smartv3.network.GetGooglePayCheckOrder;
import com.szabh.smable3.entity.Languages;
import o0oIxXOx.XIxXXX0x0;

/* loaded from: classes8.dex */
public enum q2 {
    STATE(null, "state", null),
    CODE(null, "code", null),
    DATA(null, "data", null),
    IVERSION(null, "iversion", null),
    URL("url", "url", null),
    MD5(null, "md5", null),
    LENGTH(null, "length", null),
    ABS_PATH(null, "absPath", null),
    ID("id", "id", null),
    IS_PID("is_pid", null, null),
    GENDER(null, "gender", null),
    DOMAIN(null, ClientCookie.DOMAIN_ATTR, null),
    QUALITY(null, "quality", null),
    DATA_COUNT(null, "data_count", null),
    DATA_LIST(null, "data_list", null),
    NAME(null, "name", null),
    VERSION_MIN(null, "version_min", null),
    VERSION_MAX(null, "version_max", null),
    TEXT_DATA_ID(null, "text_data_id", null),
    SPEECH_DATA_ID(null, "speech_data_id", null),
    SPEECH_EXT_DATA_ID(null, "speech_ext_data_id", null),
    TAC_SUBGAN_SPEAKER_ATTR(null, "tac_subgan_speaker_attr", null),
    FUNCTION("func", "function", ""),
    MODELSINFO("modelsinfo", "modelsinfo", ""),
    ERROR_NUMBER("err_no", "errorNumber", ""),
    ERROR_MESSAGE("err_msg", "errorMessage", ""),
    MIX_MODE(null, "mixMode", null),
    NOTIFICATION_COUNT_PER_SECOND("ncps", "notificationCountPerSecond", ""),
    PERCENT("pct", "percent", ""),
    APP_CODE("appid", "appCode", ""),
    AUTH_SERIAL_NUMBER("authSN", "authSerialNumber", ""),
    PACKAGE_NAME("pn", "packageName", "app_name"),
    PLATFORM("", "platform", ""),
    SPEED("spd", RouteGuideParams.RGKey.AssistInfo.Speed, ""),
    ONLINE_SPEED("spd", RouteGuideParams.RGKey.AssistInfo.Speed, ""),
    OFFLINE_SPEED("spd", RouteGuideParams.RGKey.AssistInfo.Speed, ""),
    INTERCEPT_SSML("inte", RGState.METHOD_NAME_INTERCEPT, ""),
    VOLUME("vol", "volume", ""),
    PITCH("pit", "pitch", ""),
    LANGUAGE("lan", "language", ""),
    TEXT_ENCODE("cod", "textEncode", ""),
    STREAM_TYPE(UserDataStore.STATE, "streamType", ""),
    AUDIO_ENCODE("aue", "audioEncode", ""),
    BITRATE("rate", "audioRate", ""),
    SPEAKER("per", TtsStatsUploadBag.KEY_SPEAKER, ""),
    STYLE("sty", "style", ""),
    BACKGROUND("bcg", StyleAttr.NAME_BACKGROUND, ""),
    PRODUCT_ID("pdt", GetGooglePayCheckOrder.PRODUCT_IT, ""),
    OFFLINE_RESOURCE_PATH("orp", "offlineResourcePath", ""),
    OFFLINE_SPEAKER("osr", "offlineSpeaker", ""),
    TEXT_DAT_PATH("tdp", "textDatPath", ""),
    SPEECH_DAT_PATH("sdp", "speechDatPath", ""),
    CONVERT_DAT_PATH("convert", "convertDatPath", ""),
    SPEECH_EXT_DAT_PATH("sedp", "speechExtDatPath", ""),
    TTS_LICENSE_FILE_PATH("tlfp", "ttsLicenseFilePath", ""),
    CUSTOM_SYNTH("cs", "custom_synth", ""),
    OPEN_XML(XIxXXX0x0.f31179xoXoI, "open_xml", ""),
    TTS_VOCODER_OPTIMIZATION("tvo", "ttsVocoderOptimzation", ""),
    SAMPLE_RATE("sr", "sampleRate", ""),
    SERIAL_NUMBER("sn", "serialNumber", ""),
    INDEX("idx", MapBundleKey.MapObjKey.OBJ_SL_INDEX, ""),
    TEXT("tex", "text", ""),
    CTP("ctp", "clientPath", ""),
    CUID("cuid", GetGomoreAuthKey.DEVICE_ID, "wise_cuid"),
    VERSION("ver", "version", "sdkversion"),
    NUMBER("num", "number", ""),
    ENGINE(Languages.DEFAULT_LANGUAGE, "engine", ""),
    TERRITORY("ter", "territory", ""),
    PUNCTUATION("puc", "punctuation", ""),
    CONTEXT("ctx", bn.f.o, ""),
    API_KEY("", "apiKey", ""),
    SECRET_KEY("", "secretKey", ""),
    TOKEN("tok", "token", ""),
    SPEC("spec", "spec", ""),
    KEY("key", "key", ""),
    PROXY_HOST(UserDataStore.PHONE, "proxyHost", ""),
    PROXY_PORT("pp", "proxyPort", ""),
    REQUEST_PROTOCOL("rp", "requestProtocol", ""),
    REQUEST_ENABLE_DNS(XIxXXX0x0.f31163OOXIXo, XIxXXX0x0.f31163OOXIXo, ""),
    SIGN(HttpConstants.SIGN, "", "appidmd5"),
    APPNAME("app", "", "app_package_name"),
    SELFDEF("selfDef", "", ""),
    STA("sta", "", ""),
    GETLICENSE_ERRNO("errno", "", ""),
    BILINGUAL_MODE("bmode", "bilingualmode", ""),
    MIX_ONLINE_REQUEST_TIMEOUT(null, "mix_online_request_timeout", null),
    ONLINE_REQUEST_TIMEOUT(null, "online_request_timeout", null),
    RESPONSE_CHANNEL("channel", "channel", ""),
    RESPONSE_SAMPLE_RATE("samplerate", "samplerate", ""),
    AUDIO_CTRL("audio_ctrl", "audio_ctrl", ""),
    TEXT_CTRL("text_ctrl", "text_ctrl", ""),
    LIP_CTRL("lip_ctrl", "lip_ctrl", ""),
    LIP_ENABLE("lip", "lip", ""),
    CUID_NUM("cuid_num", "cuid_num", ""),
    STAT_PAM("stat_pam", "stat_pam", ""),
    PHONE_MODEL("phone_model", "phone_model", ""),
    TEXT_POS("text_pos", "text_pos", ""),
    CITYID("cityid", "cityid", ""),
    USERID("userid", "userid", ""),
    ENABLE_UPLOG("eableuplog", "eableuplog", ""),
    ENABLE_WM("enablewm", "enable_water_mark", ""),
    MULTIPLEX("multiplex", "multiplex", "");


    /* renamed from: a, reason: collision with root package name */
    public final String f10157a;
    public final String b;
    public final String c;

    q2(String str, String str2, String str3) {
        this.f10157a = str;
        this.b = str2;
        this.c = str3;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.f10157a;
    }

    public static String a(q2 q2Var) {
        return q2Var.name();
    }
}
