package com.qq.e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.managers.a;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes11.dex */
public abstract class AbstractAD<T> {

    /* renamed from: a, reason: collision with root package name */
    protected T f19399a;
    private volatile boolean e;
    private volatile boolean c = false;
    private volatile boolean d = false;
    private final Handler b = new Handler(Looper.getMainLooper());

    public abstract T a(Context context, POFactory pOFactory, String str, String str2, String str3);

    public abstract void a(T t);

    public abstract void b(int i);

    public final boolean b() {
        return this.c;
    }

    private void b(final Context context, final String str, final String str2) {
        this.e = true;
        if (a.b().d()) {
            final String a2 = a.b().a();
            if (com.qq.e.comm.a.a(context)) {
                this.d = true;
                a.g.execute(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            final POFactory pOFactory = a.b().c().getPOFactory();
                            AbstractAD.this.b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        POFactory pOFactory2 = pOFactory;
                                        if (pOFactory2 != null) {
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            AbstractAD abstractAD = AbstractAD.this;
                                            abstractAD.f19399a = (T) abstractAD.a(context, pOFactory2, a2, str, str2);
                                            AbstractAD.this.c = true;
                                            AbstractAD abstractAD2 = AbstractAD.this;
                                            T t = abstractAD2.f19399a;
                                            if (t == null) {
                                                abstractAD2.a(ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                            } else {
                                                abstractAD2.a((AbstractAD) t);
                                            }
                                        } else {
                                            AbstractAD.this.c = true;
                                            AbstractAD.this.a(200102);
                                        }
                                    } catch (Throwable th) {
                                        GDTLogger.e("初始化错误：初始化广告实例时发生异常", th);
                                        AbstractAD.this.c = true;
                                        AbstractAD.this.a(2001);
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            GDTLogger.e("初始化错误：初始化插件时发生异常", th);
                            AbstractAD.this.c = true;
                            AbstractAD.this.a(200102);
                        }
                    }
                });
                return;
            } else {
                GDTLogger.e("Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予");
                a(4002);
                return;
            }
        }
        a(2003);
    }

    public final void a(final int i) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            b(i);
        } else {
            this.b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractAD.this.b(i);
                }
            });
        }
    }

    public final void a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            b(context, str, "");
        } else {
            GDTLogger.e("初始化错误：参数错误context或posId为空");
            a(2001);
        }
    }

    public final void a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            b(context, str, str2);
        } else {
            GDTLogger.e("初始化错误：参数错误，context、posId、token 不可为空");
            a(2001);
        }
    }

    public final void a(String str) {
        GDTLogger.e(getClass().getSimpleName() + ":调用方法 " + str + "异常，广告实例还未初始化");
    }

    public final boolean a() {
        return this.e && this.d;
    }
}
