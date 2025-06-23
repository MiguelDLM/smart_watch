package com.baidu.tts.aop;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class AInterceptorHandler implements IInterceptorHandler {
    public static final Object DEFAULT = 0;
    public static final Object END = 1;

    /* renamed from: a, reason: collision with root package name */
    public List<IInterceptor> f10035a;
    public Object b;
    public List<String> c = new ArrayList();

    @Override // com.baidu.tts.aop.IInterceptorHandler
    public Object bind(Object obj, List<IInterceptor> list) {
        this.b = obj;
        this.f10035a = list;
        Class<?> cls = obj.getClass();
        Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), this);
        LoggerProxy.d("AInterceptorHandler", "proxy=" + newProxyInstance);
        return newProxyInstance;
    }

    @Override // com.baidu.tts.aop.IInterceptorHandler
    public boolean canIntercept(String str) {
        return this.c.contains(str);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (canIntercept(method.getName())) {
            Object obj2 = this.b;
            Object obj3 = DEFAULT;
            int size = this.f10035a.size();
            for (int i = 0; i < size; i++) {
                obj3 = this.f10035a.get(i).before(obj2, method, objArr);
                if (obj3.equals(END)) {
                    break;
                }
            }
            if (obj3.equals(END)) {
                return null;
            }
            Object invoke = method.invoke(this.b, objArr);
            Object obj4 = this.b;
            for (int size2 = this.f10035a.size() - 1; size2 >= 0; size2--) {
                this.f10035a.get(size2).after(obj4, method, objArr, invoke);
            }
            return invoke;
        }
        return method.invoke(this.b, objArr);
    }

    @Override // com.baidu.tts.aop.IInterceptorHandler
    public void registerMethod(String str) {
        if (str != null) {
            this.c.add(str);
        }
    }

    @Override // com.baidu.tts.aop.IInterceptorHandler
    public void unregisterMethod(String str) {
        if (str != null) {
            this.c.remove(str);
        }
    }
}
