package com.baidu.tts.aop.tts;

import com.baidu.tts.aop.AInterceptor;
import com.baidu.tts.aop.AInterceptorHandler;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.lang.reflect.Method;

/* loaded from: classes8.dex */
public class StatisticsInterceptor extends AInterceptor {
    @Override // com.baidu.tts.aop.AInterceptor
    public void a() {
        this.f10034a.add("speak");
        this.f10034a.add("synthesize");
    }

    @Override // com.baidu.tts.aop.AInterceptor
    public Object a(Object obj, Method method, Object[] objArr) {
        LoggerProxy.d("StatisticsInterceptor", "statistics");
        return AInterceptorHandler.DEFAULT;
    }
}
