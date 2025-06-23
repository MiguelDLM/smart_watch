package com.baidu.tts;

import android.content.Context;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.d0;
import com.baidu.tts.m;
import com.baidu.tts.o;
import com.baidu.tts.tools.FileTools;
import com.baidu.tts.tools.ResourceTools;
import com.baidu.tts.tools.StringTool;
import com.facebook.login.widget.ToolTipPopup;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes8.dex */
public class j {
    public static volatile j c;

    /* renamed from: a, reason: collision with root package name */
    public l3<o, o.a> f10111a = new l3<>();
    public l3<m, m.a> b = new l3<>();

    /* loaded from: classes8.dex */
    public class a implements Callable<m.a> {

        /* renamed from: a, reason: collision with root package name */
        public d0.b f10112a;

        public a(d0.b bVar) {
            this.f10112a = bVar;
        }

        @Override // java.util.concurrent.Callable
        public m.a call() throws Exception {
            Context context;
            m.a aVar = new m.a();
            d3 b = e3.e().b();
            if (b == null) {
                aVar.a(c3.a().a(x2.F0));
                return aVar;
            }
            d0.b bVar = this.f10112a;
            String str = bVar.p;
            String str2 = bVar.f;
            String str3 = bVar.q;
            String str4 = bVar.o;
            if (StringTool.isEmpty(str4)) {
                if (b.c == null) {
                    WeakReference<Context> weakReference = b.f10071a;
                    if (weakReference == null) {
                        context = null;
                    } else {
                        context = weakReference.get();
                    }
                    b.c = FileTools.jointPathAndName(ResourceTools.getAppFilesDirPath(context), "baidu_tts_license");
                }
                str4 = b.c;
            }
            LoggerProxy.d("AuthClient", "appCode=" + str);
            LoggerProxy.d("AuthClient", "licenseFilePath=" + str4);
            m mVar = new m();
            mVar.f10132a = str;
            mVar.b = str2;
            mVar.c = str3;
            mVar.d = str4;
            return j.this.b.a(mVar);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Callable<o.a> {

        /* renamed from: a, reason: collision with root package name */
        public e0 f10113a;

        public b(e0 e0Var) {
            this.f10113a = e0Var;
        }

        @Override // java.util.concurrent.Callable
        public o.a call() throws Exception {
            e0 e0Var = this.f10113a;
            String str = e0Var.g;
            String str2 = e0Var.k;
            String str3 = e0Var.l;
            String str4 = e0Var.m;
            String str5 = e0Var.q;
            LoggerProxy.d("AuthClient", "pid=" + str);
            LoggerProxy.d("AuthClient", "key=" + str4);
            LoggerProxy.d("AuthClient", "ak=" + str2);
            LoggerProxy.d("AuthClient", "sk=" + str3);
            o oVar = new o();
            oVar.f10140a = str;
            oVar.b = str2;
            oVar.c = str3;
            oVar.d = str5;
            return j.this.f10111a.a(oVar);
        }
    }

    public static j a() {
        if (c == null) {
            synchronized (j.class) {
                try {
                    if (c == null) {
                        c = new j();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public o.a a(e0 e0Var) {
        o.a aVar = new o.a();
        try {
            return (o.a) a(new b(e0Var), ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            TtsError a2 = c3.a().a(x2.g);
            a2.setThrowable(e);
            aVar.a(a2);
            return aVar;
        } catch (CancellationException e2) {
            TtsError a3 = c3.a().a(x2.s);
            a3.setThrowable(e2);
            aVar.a(a3);
            return aVar;
        } catch (ExecutionException e3) {
            c3 a4 = c3.a();
            x2 x2Var = x2.h;
            Throwable cause = e3.getCause();
            TtsError a5 = a4.a(x2Var);
            a5.setThrowable(cause);
            aVar.a(a5);
            return aVar;
        } catch (TimeoutException e4) {
            TtsError a6 = c3.a().a(x2.i);
            a6.setThrowable(e4);
            aVar.a(a6);
            return aVar;
        }
    }

    public m.a a(d0.b bVar) {
        m.a aVar = new m.a();
        try {
            return (m.a) a(new a(bVar), ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            TtsError a2 = c3.a().a(x2.S);
            a2.setThrowable(e);
            aVar.a(a2);
            return aVar;
        } catch (CancellationException e2) {
            TtsError a3 = c3.a().a(x2.f0);
            a3.setThrowable(e2);
            aVar.a(a3);
            return aVar;
        } catch (ExecutionException e3) {
            c3 a4 = c3.a();
            x2 x2Var = x2.T;
            Throwable cause = e3.getCause();
            TtsError a5 = a4.a(x2Var);
            a5.setThrowable(cause);
            aVar.a(a5);
            return aVar;
        } catch (TimeoutException e4) {
            TtsError a6 = c3.a().a(x2.U);
            a6.setThrowable(e4);
            aVar.a(a6);
            return aVar;
        }
    }

    public final <T> T a(Callable<T> callable, long j) throws InterruptedException, ExecutionException, TimeoutException {
        FutureTask futureTask = new FutureTask(callable);
        Thread thread = new Thread(futureTask);
        thread.setName("bdtts-AuthClient");
        thread.start();
        return (T) futureTask.get(j, TimeUnit.MILLISECONDS);
    }
}
