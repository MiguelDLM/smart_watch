package com.baidu.tts.aop;

import java.util.List;

/* loaded from: classes8.dex */
public interface IProxyFactory<T> {
    IInterceptorHandler createInterceptorHandler();

    List<IInterceptor> createInterceptors();

    T createProxied();

    T makeProxy();
}
