package com.baidu.tts.aop;

import java.util.List;

/* loaded from: classes8.dex */
public abstract class AProxyFactory<T> implements IProxyFactory<T> {
    @Override // com.baidu.tts.aop.IProxyFactory
    public T makeProxy() {
        T createProxied = createProxied();
        IInterceptorHandler createInterceptorHandler = createInterceptorHandler();
        List<IInterceptor> createInterceptors = createInterceptors();
        if (createInterceptorHandler != null && createInterceptors != null) {
            return (T) createInterceptorHandler.bind(createProxied, createInterceptors);
        }
        return createProxied;
    }
}
