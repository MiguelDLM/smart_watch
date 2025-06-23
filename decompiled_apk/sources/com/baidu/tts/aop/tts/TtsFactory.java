package com.baidu.tts.aop.tts;

import com.baidu.tts.aop.AProxyFactory;
import com.baidu.tts.aop.IInterceptor;
import com.baidu.tts.aop.IInterceptorHandler;
import com.baidu.tts.d5;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class TtsFactory extends AProxyFactory<ITts> {
    @Override // com.baidu.tts.aop.IProxyFactory
    public IInterceptorHandler createInterceptorHandler() {
        TtsInterceptorHandler ttsInterceptorHandler = new TtsInterceptorHandler();
        ttsInterceptorHandler.registerMethods();
        return ttsInterceptorHandler;
    }

    @Override // com.baidu.tts.aop.IProxyFactory
    public List<IInterceptor> createInterceptors() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ArgsCheckInterceptor());
        arrayList.add(new StatisticsInterceptor());
        arrayList.add(new CallbackInterceptor());
        return arrayList;
    }

    @Override // com.baidu.tts.aop.IProxyFactory
    public ITts createProxied() {
        return new d5();
    }
}
