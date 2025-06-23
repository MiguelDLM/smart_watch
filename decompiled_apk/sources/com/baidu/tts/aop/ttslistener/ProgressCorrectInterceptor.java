package com.baidu.tts.aop.ttslistener;

import android.text.TextUtils;
import com.baidu.tts.aop.AInterceptor;
import com.baidu.tts.aop.AInterceptorHandler;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.x4;
import java.lang.reflect.Method;

/* loaded from: classes8.dex */
public class ProgressCorrectInterceptor extends AInterceptor {
    @Override // com.baidu.tts.aop.AInterceptor
    public void a() {
        this.f10034a.add("onSynthesizeDataArrived");
        this.f10034a.add("onPlayProgressUpdate");
    }

    @Override // com.baidu.tts.aop.AInterceptor
    public Object a(Object obj, Method method, Object[] objArr) {
        x4 x4Var = (x4) objArr[0];
        if (x4Var != null) {
            String str = x4Var.i.e;
            if (!TextUtils.isEmpty(str)) {
                int length = str.length();
                int i = x4Var.f;
                int i2 = i > length ? i - length : 0;
                LoggerProxy.d("ProgressCorrectInterceptor", "prefixLength=" + length + "--progress=" + i);
                x4 a2 = x4Var.a();
                a2.f = i2;
                objArr[0] = a2;
            }
        }
        return AInterceptorHandler.DEFAULT;
    }
}
