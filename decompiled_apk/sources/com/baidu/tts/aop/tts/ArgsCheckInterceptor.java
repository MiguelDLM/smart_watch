package com.baidu.tts.aop.tts;

import com.baidu.tts.aop.AInterceptor;
import com.baidu.tts.aop.AInterceptorHandler;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.c3;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.d5;
import com.baidu.tts.tools.ResourceTools;
import com.baidu.tts.x2;
import com.baidu.tts.x4;
import com.baidu.tts.y4;
import java.lang.reflect.Method;

/* loaded from: classes8.dex */
public class ArgsCheckInterceptor extends AInterceptor {
    @Override // com.baidu.tts.aop.AInterceptor
    public void a() {
        this.f10034a.add("speak");
        this.f10034a.add("synthesize");
    }

    @Override // com.baidu.tts.aop.AInterceptor
    public Object a(Object obj, Method method, Object[] objArr) {
        y4 y4Var = (y4) objArr[0];
        String str = y4Var.f10206a;
        LoggerProxy.d("ArgsCheckInterceptor", "text=" + str);
        if (ResourceTools.isTextValid(str) == null) {
            return AInterceptorHandler.DEFAULT;
        }
        x2 x2Var = x2.v0;
        x4 a2 = x4.a(y4Var);
        a2.j = c3.a().a(x2Var);
        TtsListener ttsListener = ((d5) obj).e.f10043a.b;
        if (ttsListener != null) {
            ttsListener.onError(a2);
        }
        return AInterceptorHandler.END;
    }
}
