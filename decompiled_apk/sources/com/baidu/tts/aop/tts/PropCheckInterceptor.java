package com.baidu.tts.aop.tts;

import com.baidu.tts.aop.AInterceptor;
import com.baidu.tts.aop.AInterceptorHandler;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SynthesizerTool;
import com.baidu.tts.q2;
import com.baidu.tts.tools.FileUtil;
import com.baidu.tts.tools.PropUtil;
import java.lang.reflect.Method;

/* loaded from: classes8.dex */
public class PropCheckInterceptor extends AInterceptor {
    @Override // com.baidu.tts.aop.AInterceptor
    public void a() {
        this.f10034a.add("setMode");
        this.f10034a.add("setParam");
        this.f10034a.add("speak");
        this.f10034a.add("synthesize");
    }

    @Override // com.baidu.tts.aop.AInterceptor
    public Object a(Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        LoggerProxy.d("PropCheckInterceptor", "method name: " + name);
        if ("setParam".equals(name)) {
            String name2 = ((q2) objArr[0]).name();
            if (LoggerProxy.needPrint(2) && PropUtil.needOfflineTag()) {
                if (SpeechSynthesizer.PARAM_TTS_TEXT_MODEL_FILE.equals(name2)) {
                    LoggerProxy.d("PropCheckInterceptor", "offline-textModelInfo: " + SynthesizerTool.getModelInfo((String) objArr[1]));
                } else if (SpeechSynthesizer.PARAM_TTS_SPEECH_MODEL_FILE.equals(name2)) {
                    LoggerProxy.d("PropCheckInterceptor", "offline-speechModelInfo: " + SynthesizerTool.getModelInfo((String) objArr[1]));
                }
            }
        } else if (LoggerProxy.needPrint(2)) {
            if (PropUtil.needOfflineTag()) {
                LoggerProxy.setNativeLogLevel(6);
                FileUtil.createDir("/sdcard/bds-tts/");
                LoggerProxy.saveNativeLogFile("/sdcard/bds-tts/bdtts_engine.log");
                LoggerProxy.d("PropCheckInterceptor", "offline-engineInfo: " + SynthesizerTool.getEngineInfo());
            }
            if (PropUtil.needSaveLog()) {
                LoggerProxy.setModeDevelop();
                LoggerProxy.d("PropCheckInterceptor", "setModeDevelop");
            }
        }
        return AInterceptorHandler.DEFAULT;
    }
}
