package com.baidu.tts.aop;

import java.lang.reflect.Method;

/* loaded from: classes8.dex */
public interface IInterceptor {
    Object after(Object obj, Method method, Object[] objArr, Object obj2);

    Object before(Object obj, Method method, Object[] objArr);
}
