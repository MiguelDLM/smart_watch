package com.baidu.tts.client;

import com.baidu.tts.chainofresponsibility.logger.ILoggerUploadCallBack;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.d0;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.tools.ResourceTools;
import com.baidu.tts.tools.StringTool;
import com.baidu.tts.y2;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class SynthesizerTool {
    public static int CheckDomainFile(String str) {
        if (!StringTool.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                return EmbeddedSynthesizerEngine.bdTTSCheckDomainFile(ResourceTools.stringToByteArrayAddNull(str));
            }
            return -12;
        }
        return -12;
    }

    public static long getDomainSampleRate(String str) {
        if (!StringTool.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                return EmbeddedSynthesizerEngine.bdTTSGetDomainSampleRate(ResourceTools.stringToByteArrayAddNull(str));
            }
            return -12L;
        }
        return -12L;
    }

    public static String getEngineInfo() {
        return EmbeddedSynthesizerEngine.bdTTSGetEngineParam();
    }

    public static int getEngineVersion() {
        try {
            return new JSONObject(getEngineInfo()).getInt("version");
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getModelInfo(String str) {
        if (!StringTool.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                return EmbeddedSynthesizerEngine.bdTTSGetDatParam(str);
            }
            return null;
        }
        return null;
    }

    public static long getOfflineSampleRate() {
        long j = d0.g;
        if (j != 0) {
            return EmbeddedSynthesizerEngine.bdTTSGetParam(j, 8);
        }
        return -1L;
    }

    public static long getSpeechSampleRate(String str) {
        if (!StringTool.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                return EmbeddedSynthesizerEngine.bdTTSGetSpeechSampleRate(ResourceTools.stringToByteArrayAddNull(str));
            }
            return -12L;
        }
        return -12L;
    }

    public static int matchResEngine(String str) {
        return EmbeddedSynthesizerEngine.bdTTSResEngineMatch(ResourceTools.stringToByteArrayAddNull(str));
    }

    public static void setGetLicenseServer(String str) {
        y2.GETLICENSE_V2_SERVER.f10202a = str;
    }

    public static void setLogUploadOnListener(ILoggerUploadCallBack iLoggerUploadCallBack) {
        LoggerProxy.setLoggerListener(iLoggerUploadCallBack);
    }

    public static void setModelServer(String str) {
        y2.MODEL_SERVER.f10202a = str;
    }

    public static boolean verifyModelFile(String str) {
        if (StringTool.isEmpty(str)) {
            return false;
        }
        try {
            if (EmbeddedSynthesizerEngine.bdTTSVerifyDataFile(ResourceTools.stringToByteArrayAddNull(str)) != 0) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
