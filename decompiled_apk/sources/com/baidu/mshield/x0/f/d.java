package com.baidu.mshield.x0.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public final class d extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String[] f6417a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Looper looper, String[] strArr) {
        super(looper);
        this.f6417a = strArr;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", null).invoke(null, null);
            Field declaredField = cls.getDeclaredField("mInstrumentation");
            declaredField.setAccessible(true);
            this.f6417a[0] = declaredField.get(invoke).getClass().getCanonicalName();
            Method declaredMethod = Class.forName("android.app.ActivityManagerNative").getDeclaredMethod("getDefault", null);
            declaredMethod.setAccessible(true);
            this.f6417a[1] = declaredMethod.invoke(null, null).getClass().getCanonicalName();
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
        }
        super.handleMessage(message);
    }
}
