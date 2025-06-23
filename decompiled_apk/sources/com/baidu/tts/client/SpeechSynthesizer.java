package com.baidu.tts.client;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.baidu.tts.a;
import com.baidu.tts.aop.tts.ITts;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.d0;
import com.baidu.tts.emstatistics.TtsStatsUpload;
import com.baidu.tts.i2;
import com.baidu.tts.q2;
import com.baidu.tts.t2;
import com.baidu.tts.tools.ConfigTool;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.ResourceTools;
import com.baidu.tts.tools.StringTool;
import com.baidu.tts.u0;
import com.baidu.tts.u4;
import com.baidu.tts.v2;
import com.baidu.tts.v4;
import com.baidu.tts.w4;
import com.baidu.tts.x2;
import com.huawei.openalliance.ad.constant.ah;
import com.huawei.openalliance.ad.constant.aw;
import com.iflytek.sparkchain.utils.constants.ErrorCode;
import com.sma.smartv3.ui.device.DeviceFileManager;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes8.dex */
public class SpeechSynthesizer {
    public static final String AUDIO_BITRATE_OPUS_128K;
    public static final String AUDIO_BITRATE_OPUS_16K;
    public static final String AUDIO_BITRATE_OPUS_32K;
    public static final String AUDIO_BITRATE_OPUS_64K;
    public static final String AUDIO_BITRATE_PCM;
    public static final String AUDIO_ENCODE_OPUS;
    public static final String AUDIO_ENCODE_PCM;
    public static final int AUDIO_SAMPLERATE_16K;
    public static final int AUDIO_SAMPLERATE_24K;
    public static final int AUDIO_SAMPLERATE_8K;
    public static final int ERROR_APP_ID_IS_INVALID;
    public static final int ERROR_LIST_IS_TOO_LONG;
    public static final int ERROR_QUEUE_IS_FULL;
    public static final int ERROR_TEXT_ENCODE_IS_WRONG;
    public static final int ERROR_TEXT_IS_EMPTY;
    public static final int ERROR_TEXT_IS_TOO_LONG;
    public static final String LANGUAGE_EN;
    public static final String LANGUAGE_ZH;
    public static final int MAX_LIST_SIZE = 100;
    public static final int MAX_ONLINE_REQUEST_TIMEOUT = 6000;
    public static final int MAX_QUEUE_SIZE = 15000;
    public static final int MIN_ONLINE_REQUEST_TIMEOUT = 200;
    public static final String MIX_MODE_DEFAULT;
    public static final String MIX_MODE_HIGH_SPEED_NETWORK;
    public static final String MIX_MODE_HIGH_SPEED_SYNTHESIZE;
    public static final String MIX_MODE_HIGH_SPEED_SYNTHESIZE_WIFI;
    public static final String PARAM_AUDIO_CTRL;
    public static final String PARAM_AUDIO_ENCODE;
    public static final String PARAM_AUDIO_RATE;
    public static final String PARAM_AUTH_SN;
    public static final String PARAM_BILINGUAL_MODE;
    public static final String PARAM_CITYID;
    public static final String PARAM_CLOSE_UPLOG = "false";
    public static final String PARAM_CLOSE_WM = "0";
    public static final String PARAM_CUSTOM_SYNTH;
    public static final String PARAM_INTERCEPT_SSML;
    public static final String PARAM_KEY;
    public static final String PARAM_KEY_ENABLE_UPLOG;
    public static final String PARAM_KEY_ENABLE_WM;
    public static final String PARAM_LANGUAGE;
    public static final String PARAM_LIP_CTRL;
    public static final String PARAM_LIP_ENABLE;
    public static final String PARAM_MIX_MODE;
    public static final String PARAM_MIX_MODE_TIMEOUT;
    public static final String PARAM_MIX_TIMEOUT_FOUR_SECOND;
    public static final String PARAM_MIX_TIMEOUT_ONE_SECOND;
    public static final String PARAM_MIX_TIMEOUT_THREE_SECOND;
    public static final String PARAM_MIX_TIMEOUT_TWO_SECOND;
    public static final String PARAM_OFFLINE_SPEED;
    public static final String PARAM_ONLINE_SPEED;
    public static final String PARAM_ONLINE_TIMEOUT;
    public static final String PARAM_OPEN_UPLOG = "true";
    public static final String PARAM_OPEN_WM = "1";
    public static final String PARAM_OPEN_XML;
    public static final String PARAM_PITCH;
    public static final String PARAM_PRODUCT_ID;
    public static final String PARAM_PROXY_HOST;
    public static final String PARAM_PROXY_PORT;
    public static final String PARAM_REC_PER = "rec_per";
    public static final String PARAM_REQUEST_ENABLE_DNS;
    public static final String PARAM_REQUEST_PROTOCOL;
    public static final String PARAM_SPEAKER;
    public static final String PARAM_SPEC;
    public static final String PARAM_SPEED;
    public static final String PARAM_STAT_PARAM;
    public static final String PARAM_TEXT_CTRL;
    public static final String PARAM_TEXT_POS;
    public static final String PARAM_TTS_CONVERT_MODEL_FILE;
    public static final String PARAM_TTS_EXT_SPEECH_MODEL_FILE;
    public static final String PARAM_TTS_LICENCE_FILE;
    public static final String PARAM_TTS_OFFLINE_RESOURCE;
    public static final String PARAM_TTS_OFFLINE_SPEAKER;
    public static final String PARAM_TTS_SPEECH_MODEL_FILE;
    public static final String PARAM_TTS_TAC_SUBGAN_SPEAKER_ATTR;
    public static final String PARAM_TTS_TEXT_MODEL_FILE;
    public static final String PARAM_URL;
    public static final String PARAM_USERID;
    public static final String PARAM_VOCODER_OPTIM_LEVEL;
    public static final String PARAM_VOLUME;
    public static final String REQUEST_DNS_OFF = "0";
    public static final String REQUEST_DNS_ON = "1";
    public static final String REQUEST_HTTP_DNS_ON = "2";
    public static final String REQUEST_PROTOCOL_HTTP = "http";
    public static final String REQUEST_PROTOCOL_HTTPS = "https";
    public static final String TEXT_ENCODE_BIG5;
    public static final String TEXT_ENCODE_GBK;
    public static final String TEXT_ENCODE_UTF8;
    public static volatile SpeechSynthesizer b;

    /* renamed from: a, reason: collision with root package name */
    public a f10052a = new a();

    static {
        x2 x2Var = x2.z0;
        ERROR_QUEUE_IS_FULL = -402;
        x2 x2Var2 = x2.A0;
        ERROR_LIST_IS_TOO_LONG = -403;
        x2 x2Var3 = x2.u0;
        ERROR_TEXT_IS_EMPTY = -300;
        x2 x2Var4 = x2.v0;
        ERROR_TEXT_IS_TOO_LONG = ah.I;
        x2 x2Var5 = x2.w0;
        ERROR_TEXT_ENCODE_IS_WRONG = ah.Z;
        x2 x2Var6 = x2.C0;
        ERROR_APP_ID_IS_INVALID = -405;
        PARAM_REQUEST_PROTOCOL = q2.a(q2.REQUEST_PROTOCOL);
        PARAM_REQUEST_ENABLE_DNS = q2.a(q2.REQUEST_ENABLE_DNS);
        PARAM_PROXY_HOST = q2.a(q2.PROXY_HOST);
        PARAM_PROXY_PORT = q2.a(q2.PROXY_PORT);
        PARAM_URL = q2.a(q2.URL);
        PARAM_AUDIO_CTRL = q2.a(q2.AUDIO_CTRL);
        PARAM_TEXT_CTRL = q2.a(q2.TEXT_CTRL);
        PARAM_LIP_CTRL = q2.a(q2.LIP_CTRL);
        PARAM_LIP_ENABLE = q2.a(q2.LIP_ENABLE);
        PARAM_STAT_PARAM = q2.a(q2.STAT_PAM);
        PARAM_TEXT_POS = q2.a(q2.TEXT_POS);
        PARAM_SPEED = q2.a(q2.SPEED);
        PARAM_OFFLINE_SPEED = q2.a(q2.OFFLINE_SPEED);
        PARAM_ONLINE_SPEED = q2.a(q2.ONLINE_SPEED);
        PARAM_PITCH = q2.a(q2.PITCH);
        PARAM_VOLUME = q2.a(q2.VOLUME);
        PARAM_SPEC = q2.a(q2.SPEC);
        PARAM_TTS_OFFLINE_RESOURCE = q2.a(q2.OFFLINE_RESOURCE_PATH);
        PARAM_TTS_OFFLINE_SPEAKER = q2.a(q2.OFFLINE_SPEAKER);
        PARAM_TTS_TEXT_MODEL_FILE = q2.a(q2.TEXT_DAT_PATH);
        PARAM_TTS_SPEECH_MODEL_FILE = q2.a(q2.SPEECH_DAT_PATH);
        PARAM_TTS_CONVERT_MODEL_FILE = q2.a(q2.CONVERT_DAT_PATH);
        PARAM_TTS_EXT_SPEECH_MODEL_FILE = q2.a(q2.SPEECH_EXT_DAT_PATH);
        PARAM_TTS_TAC_SUBGAN_SPEAKER_ATTR = q2.a(q2.TAC_SUBGAN_SPEAKER_ATTR);
        PARAM_TTS_LICENCE_FILE = q2.a(q2.TTS_LICENSE_FILE_PATH);
        PARAM_VOCODER_OPTIM_LEVEL = q2.a(q2.TTS_VOCODER_OPTIMIZATION);
        PARAM_INTERCEPT_SSML = q2.a(q2.INTERCEPT_SSML);
        PARAM_CUSTOM_SYNTH = q2.a(q2.CUSTOM_SYNTH);
        PARAM_OPEN_XML = q2.a(q2.OPEN_XML);
        PARAM_BILINGUAL_MODE = q2.a(q2.BILINGUAL_MODE);
        PARAM_PRODUCT_ID = q2.a(q2.PRODUCT_ID);
        PARAM_KEY = q2.a(q2.KEY);
        PARAM_AUTH_SN = q2.a(q2.AUTH_SERIAL_NUMBER);
        PARAM_LANGUAGE = q2.a(q2.LANGUAGE);
        PARAM_AUDIO_ENCODE = q2.a(q2.AUDIO_ENCODE);
        PARAM_AUDIO_RATE = q2.a(q2.BITRATE);
        PARAM_SPEAKER = q2.a(q2.SPEAKER);
        PARAM_MIX_MODE = q2.a(q2.MIX_MODE);
        MIX_MODE_DEFAULT = t2.DEFAULT.name();
        MIX_MODE_HIGH_SPEED_NETWORK = t2.HIGH_SPEED_NETWORK.name();
        PARAM_MIX_MODE_TIMEOUT = q2.a(q2.MIX_ONLINE_REQUEST_TIMEOUT);
        PARAM_ONLINE_TIMEOUT = q2.a(q2.ONLINE_REQUEST_TIMEOUT);
        PARAM_MIX_TIMEOUT_ONE_SECOND = v2.ONE_SECOND.name();
        PARAM_MIX_TIMEOUT_TWO_SECOND = v2.TWO_SECOND.name();
        PARAM_MIX_TIMEOUT_THREE_SECOND = v2.THREE_SECOND.name();
        PARAM_MIX_TIMEOUT_FOUR_SECOND = v2.FOUR_SECOND.name();
        MIX_MODE_HIGH_SPEED_SYNTHESIZE = t2.HIGH_SPEED_SYNTHESIZE.name();
        MIX_MODE_HIGH_SPEED_SYNTHESIZE_WIFI = t2.HIGH_SPEED_SYNTHESIZE_WIFI.name();
        LANGUAGE_ZH = "ZH";
        LANGUAGE_EN = DeviceFileManager.f21752xxIXOIIO;
        TEXT_ENCODE_GBK = "0";
        TEXT_ENCODE_BIG5 = "1";
        TEXT_ENCODE_UTF8 = "2";
        AUDIO_ENCODE_OPUS = "2";
        AUDIO_ENCODE_PCM = "4";
        AUDIO_SAMPLERATE_8K = 8000;
        AUDIO_SAMPLERATE_16K = 16000;
        AUDIO_SAMPLERATE_24K = ErrorCode.ERROR_TTS_INVALID_PARA;
        AUDIO_BITRATE_OPUS_16K = "16";
        AUDIO_BITRATE_OPUS_32K = "32";
        AUDIO_BITRATE_OPUS_64K = "64";
        AUDIO_BITRATE_OPUS_128K = "128";
        AUDIO_BITRATE_PCM = "0";
        PARAM_CITYID = q2.a(q2.CITYID);
        PARAM_USERID = q2.a(q2.USERID);
        PARAM_KEY_ENABLE_UPLOG = q2.a(q2.ENABLE_UPLOG);
        PARAM_KEY_ENABLE_WM = q2.a(q2.ENABLE_WM);
        b = null;
    }

    public static SpeechSynthesizer getInstance() {
        LoggerProxy.d("SpeechSynthesizer==", "SpeechSynthesizer getInstance versionName:3.2.7.163009b");
        if (b == null) {
            synchronized (SpeechSynthesizer.class) {
                try {
                    if (b == null) {
                        b = new SpeechSynthesizer();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public AuthInfo auth(TtsMode ttsMode) {
        LoggerProxy.d("SpeechSynthesizer==", "auth  ttsMode: " + ttsMode.getMode());
        return this.f10052a.f10025a.auth(ttsMode.getTtsEnum());
    }

    public int batchSpeak(List<SpeechSynthesizeBag> list) {
        if (DataTool.isListEmpty(list)) {
            x2 x2Var = x2.D0;
            return -406;
        }
        a aVar = this.f10052a;
        aVar.getClass();
        if (list.size() <= 100) {
            return aVar.a(new a.b(list));
        }
        return ERROR_LIST_IS_TOO_LONG;
    }

    public int freeCustomResource() {
        LoggerProxy.d("SpeechSynthesizer==", "freeCustomResource: ");
        return this.f10052a.f10025a.freeCustomResource(null);
    }

    public synchronized int initTts(TtsMode ttsMode) {
        int detailCode;
        LoggerProxy.d("SpeechSynthesizer==", "VersionName: 3.2.7.163009b VersionName_CODE: 28 initTts ttsMode:" + ttsMode);
        a aVar = this.f10052a;
        aVar.f10025a.setMode(ttsMode.getTtsEnum());
        TtsError create = aVar.f10025a.create();
        if (create == null) {
            detailCode = 0;
        } else {
            detailCode = create.getDetailCode();
        }
        return detailCode;
    }

    public String libVersion() {
        this.f10052a.getClass();
        return "3.2.7.163009b";
    }

    public int loadCustomResource(String str) {
        LoggerProxy.d("SpeechSynthesizer==", "loadCustomResource: " + str);
        a aVar = this.f10052a;
        aVar.getClass();
        u4 u4Var = new u4();
        u4Var.f10178a = str;
        return aVar.f10025a.loadCustomResource(u4Var);
    }

    public int loadEnglishModel(String str, String str2) {
        a aVar = this.f10052a;
        aVar.getClass();
        v4 v4Var = new v4();
        v4Var.f10183a = str;
        v4Var.b = str2;
        return aVar.f10025a.loadEnglishModel(v4Var);
    }

    public int loadModel(String str) {
        if (TextUtils.isEmpty(str)) {
            x2 x2Var = x2.D0;
            return -406;
        }
        LoggerProxy.d("SpeechSynthesizer==", "loadModel speaker: " + str);
        a aVar = this.f10052a;
        aVar.getClass();
        d0.a aVar2 = d0.h.get(str);
        if (aVar2 != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(PARAM_TTS_TEXT_MODEL_FILE, aVar2.c);
            String str2 = aVar2.b;
            if (TextUtils.equals(str2, PrerollVideoResponse.NORMAL)) {
                hashMap.put(PARAM_TTS_SPEECH_MODEL_FILE, aVar2.d);
            } else if (TextUtils.equals(str2, "tacotron")) {
                hashMap.put(PARAM_TTS_SPEECH_MODEL_FILE, aVar2.e);
                hashMap.put(PARAM_TTS_EXT_SPEECH_MODEL_FILE, aVar2.f);
                hashMap.put(PARAM_TTS_TAC_SUBGAN_SPEAKER_ATTR, aVar2.g);
            } else {
                LoggerProxy.e("SpeechSynthesizerAdapter", str2 + " is not exist ");
            }
            return aVar.a(hashMap);
        }
        x2 x2Var2 = x2.D0;
        return -406;
    }

    public int loadSuitedModel(HashMap<String, String> hashMap) {
        if (DataTool.isMapEmpty(hashMap)) {
            x2 x2Var = x2.D0;
            return -406;
        }
        LoggerProxy.d("SpeechSynthesizer==", "loadModel: " + hashMap.toString());
        return this.f10052a.a(hashMap);
    }

    public synchronized int pause() {
        LoggerProxy.d("SpeechSynthesizer==", "pause");
        ITts iTts = this.f10052a.f10025a;
        if (iTts != null) {
            iTts.pause();
        }
        return 0;
    }

    public synchronized int release() {
        LoggerProxy.d("SpeechSynthesizer==", "release");
        a aVar = this.f10052a;
        aVar.getClass();
        ConfigTool.sPlayStreamType = 0;
        aVar.d();
        try {
            ITts iTts = aVar.f10025a;
            if (iTts != null) {
                iTts.destroy();
                aVar.f10025a = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        b = null;
        return 0;
    }

    public synchronized int resume() {
        LoggerProxy.d("SpeechSynthesizer==", aw.ag);
        ITts iTts = this.f10052a.f10025a;
        if (iTts != null) {
            iTts.resume();
        }
        return 0;
    }

    public int setApiKey(String str, String str2) {
        setParam(q2.API_KEY.name(), str);
        setParam(q2.SECRET_KEY.name(), str2);
        return 0;
    }

    public int setAppId(String str) {
        if (StringTool.isAllNumber(str)) {
            setParam(q2.APP_CODE.name(), str);
            return 0;
        }
        return ERROR_APP_ID_IS_INVALID;
    }

    public int setAudioAttributes(int i, int i2) {
        LoggerProxy.d("SpeechSynthesizer==", "setAudioAttributes usage:" + i + " contentType:" + i2);
        a aVar = this.f10052a;
        aVar.getClass();
        ConfigTool.sPlayStreamType = 2;
        ITts iTts = aVar.f10025a;
        if (iTts != null) {
            iTts.setAudioAttributes(i, i2);
            return 0;
        }
        return 0;
    }

    public int setAudioSampleRate(int i) {
        LoggerProxy.d("SpeechSynthesizer==", "setAudioSampleRate ");
        ITts iTts = this.f10052a.f10025a;
        if (iTts != null) {
            iTts.setAudioSampleRate(i);
            return 0;
        }
        return 0;
    }

    public int setAudioStreamType(int i) {
        LoggerProxy.d("SpeechSynthesizer==", "setAudioStreamType: " + i);
        a aVar = this.f10052a;
        aVar.getClass();
        ConfigTool.sPlayStreamType = 1;
        ITts iTts = aVar.f10025a;
        if (iTts != null) {
            iTts.setAudioStreamType(i);
            return 0;
        }
        return 0;
    }

    public void setContext(Context context) {
        LoggerProxy.d("SpeechSynthesizer==", "setContext");
        this.f10052a.f10025a.setContext(context);
    }

    public void setEnableAECPlay(boolean z) {
        LoggerProxy.d("SpeechSynthesizer==", "setEnableAECPlay " + z);
        u0.d = z;
    }

    public int setParam(String str, String str2) {
        LoggerProxy.d("SpeechSynthesizer==", "setParam key: " + str + " value:" + str2);
        a aVar = this.f10052a;
        aVar.getClass();
        try {
            return aVar.f10025a.setParam(q2.valueOf(str), str2);
        } catch (Exception unused) {
            x2 x2Var = x2.D0;
            return -406;
        }
    }

    public void setSpeechSynthesizerListener(SpeechSynthesizerListener speechSynthesizerListener) {
        LoggerProxy.d("SpeechSynthesizer==", "setSpeechSynthesizerListener");
        a aVar = this.f10052a;
        if (aVar.b != speechSynthesizerListener) {
            aVar.b = speechSynthesizerListener;
        }
    }

    public int setStereoVolume(float f, float f2) {
        LoggerProxy.d("SpeechSynthesizer==", "setStereoVolume: " + f + " " + f2);
        ITts iTts = this.f10052a.f10025a;
        if (iTts != null) {
            iTts.setStereoVolume(f, f2);
            return 0;
        }
        return 0;
    }

    public void setTtsLogEnable(boolean z) {
        i2.a().getClass();
        i2.j = z;
    }

    public void setTtsLogUrl(String str) {
        TtsStatsUpload.getInstance().setTtsLogUrl(str);
    }

    public int speak(String str) {
        return speak(str, null);
    }

    public synchronized int stop() {
        LoggerProxy.d("SpeechSynthesizer==", "stop");
        a aVar = this.f10052a;
        aVar.d();
        ITts iTts = aVar.f10025a;
        if (iTts != null) {
            iTts.stop();
        }
        return 0;
    }

    public int synthesize(String str) {
        return synthesize(str, null);
    }

    public int speak(SpeechSynthesizeBag speechSynthesizeBag) {
        try {
            return speak(speechSynthesizeBag.getText(), speechSynthesizeBag.getUtteranceId());
        } catch (Exception unused) {
            x2 x2Var = x2.D0;
            return -406;
        }
    }

    public int synthesize(SpeechSynthesizeBag speechSynthesizeBag) {
        try {
            return synthesize(speechSynthesizeBag.getText(), speechSynthesizeBag.getUtteranceId());
        } catch (Exception unused) {
            x2 x2Var = x2.D0;
            return -406;
        }
    }

    public int loadSuitedModel(String str) {
        if (TextUtils.isEmpty(str)) {
            x2 x2Var = x2.D0;
            return -406;
        }
        LoggerProxy.d("SpeechSynthesizer==", "modelId: " + str);
        a aVar = this.f10052a;
        String textModelFileAbsPath = aVar.b().getTextModelFileAbsPath(str);
        String speechModelFileAbsPath = aVar.b().getSpeechModelFileAbsPath(str);
        String speechExtModelFileAbsPath = aVar.b().getSpeechExtModelFileAbsPath(str);
        String tacSubganSpeakerAttr = aVar.b().getTacSubganSpeakerAttr(str);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(PARAM_TTS_TEXT_MODEL_FILE, textModelFileAbsPath);
        hashMap.put(PARAM_TTS_SPEECH_MODEL_FILE, speechModelFileAbsPath);
        hashMap.put(PARAM_TTS_EXT_SPEECH_MODEL_FILE, speechExtModelFileAbsPath);
        hashMap.put(PARAM_TTS_TAC_SUBGAN_SPEAKER_ATTR, tacSubganSpeakerAttr);
        return aVar.a(hashMap);
    }

    public int speak(String str, String str2) {
        return speak(str, str2, null);
    }

    public int synthesize(String str, String str2) {
        return synthesize(str, str2, null);
    }

    public int speak(String str, String str2, Bundle bundle) {
        LoggerProxy.d("SpeechSynthesizer==", "speak  text: " + str);
        a aVar = this.f10052a;
        aVar.getClass();
        a.c cVar = new a.c(str, str2);
        x2 isTextValid = ResourceTools.isTextValid(str);
        if (isTextValid == null) {
            return aVar.a(cVar);
        }
        return isTextValid.b;
    }

    public int synthesize(String str, String str2, Bundle bundle) {
        LoggerProxy.d("SpeechSynthesizer==", "synthesize  text: " + str);
        a aVar = this.f10052a;
        aVar.getClass();
        a.d dVar = new a.d(str, str2);
        x2 isTextValid = ResourceTools.isTextValid(str);
        if (isTextValid == null) {
            return aVar.a(dVar);
        }
        return isTextValid.b;
    }

    @Deprecated
    public int loadModel(String str, String str2) {
        LoggerProxy.d("SpeechSynthesizer==", "loadModel: " + str + " " + str2);
        a aVar = this.f10052a;
        aVar.getClass();
        w4 w4Var = new w4();
        w4Var.b = str;
        w4Var.c = null;
        w4Var.f10186a = str2;
        w4Var.d = null;
        return aVar.f10025a.loadModel(w4Var);
    }

    @Deprecated
    public int loadModel(String str, String str2, String str3, String str4) {
        LoggerProxy.d("SpeechSynthesizer==", "loadModel: " + str + " " + str3);
        a aVar = this.f10052a;
        aVar.getClass();
        w4 w4Var = new w4();
        w4Var.b = str;
        w4Var.c = str2;
        w4Var.f10186a = str3;
        w4Var.d = str4;
        return aVar.f10025a.loadModel(w4Var);
    }
}
