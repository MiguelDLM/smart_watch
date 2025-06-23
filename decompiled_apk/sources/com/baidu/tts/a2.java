package com.baidu.tts;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.tools.DataTool;
import java.util.concurrent.Future;

/* loaded from: classes8.dex */
public class a2 {
    public static volatile a2 c;

    /* renamed from: a, reason: collision with root package name */
    public e2 f10031a = e2.a();
    public e1 b;

    public static a2 a() {
        if (c == null) {
            synchronized (a2.class) {
                try {
                    if (c == null) {
                        c = new a2();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public int b(String str) {
        b2 b2Var;
        e2 e2Var = this.f10031a;
        c2 b = e2Var.b(str);
        if (b != null) {
            b2Var = e2Var.a(b.a());
        } else {
            b2Var = null;
        }
        return b2Var.d;
    }

    public d2 c(String str) {
        e2 e2Var = this.f10031a;
        e2Var.getClass();
        try {
            d2 d2Var = new d2(str);
            d2 putIfAbsent = e2Var.f10079a.putIfAbsent(str, d2Var);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
            return d2Var;
        } catch (Exception unused) {
            return null;
        }
    }

    public long a(String str) {
        e2 e2Var = this.f10031a;
        c2 b = e2Var.b(str);
        return (b != null ? e2Var.a(b.a()) : null).b;
    }

    public void a(String str, String str2) {
        e2 e2Var = this.f10031a;
        c2 b = e2Var.b(str);
        b2 a2 = b != null ? e2Var.a(b.a()) : null;
        if (a2 != null) {
            boolean isSetEmpty = DataTool.isSetEmpty(a2.h);
            LoggerProxy.d("FsFileInfoFlyweight", "unregisterObserver 1isEmpty=" + isSetEmpty);
            if (isSetEmpty) {
                return;
            }
            a2.h.remove(str2);
            boolean isSetEmpty2 = DataTool.isSetEmpty(a2.h);
            LoggerProxy.d("FsFileInfoFlyweight", "unregisterObserver 2isEmpty=" + isSetEmpty2);
            if (!isSetEmpty2 || a2.g == null) {
                return;
            }
            LoggerProxy.d("FsFileInfoFlyweight", "unregisterObserver stop");
            v1 v1Var = a2.g;
            v1Var.getClass();
            LoggerProxy.d("EngineDownloadHandler", "before stop");
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("stop fileId=");
                b2 b2Var = v1Var.b.f10165a.f10169a;
                sb.append(b2Var != null ? b2Var.f : null);
                LoggerProxy.d("EngineDownloadHandler", sb.toString());
            } catch (Exception unused) {
            }
            Future<Void> future = v1Var.f10180a;
            if (future != null) {
                LoggerProxy.d("EngineDownloadHandler", "unDone = " + future.cancel(true));
            }
            LoggerProxy.d("EngineDownloadHandler", "after stop");
            a2.g = null;
            if (a2.d == 4 || a2.d == 5) {
                a2.d = 8;
                a2.e = 8;
                a().b.a(a2.f10041a, a2.e);
            }
        }
    }
}
