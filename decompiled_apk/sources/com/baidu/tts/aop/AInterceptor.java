package com.baidu.tts.aop;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class AInterceptor implements IInterceptor {

    /* renamed from: a, reason: collision with root package name */
    public List<String> f10034a = new ArrayList();

    public AInterceptor() {
        a();
    }

    public abstract Object a(Object obj, Method method, Object[] objArr);

    public abstract void a();

    @Override // com.baidu.tts.aop.IInterceptor
    public Object after(Object obj, Method method, Object[] objArr, Object obj2) {
        return AInterceptorHandler.DEFAULT;
    }

    @Override // com.baidu.tts.aop.IInterceptor
    public Object before(Object obj, Method method, Object[] objArr) {
        if (this.f10034a.contains(method.getName())) {
            return a(obj, method, objArr);
        }
        return AInterceptorHandler.DEFAULT;
    }
}
