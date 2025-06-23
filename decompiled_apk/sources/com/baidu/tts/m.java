package com.baidu.tts;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.tools.SharedPreferencesUtils;
import com.baidu.tts.tools.StringTool;
import com.google.android.exoplayer2.ExoPlayer;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes8.dex */
public class m implements k3<m, a> {

    /* renamed from: a, reason: collision with root package name */
    public String f10132a;
    public String b;
    public String c;
    public String d;

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        a aVar = new a();
        aVar.b = this.d;
        aVar.c = this.b;
        aVar.d = this.c;
        if (!aVar.a()) {
            Context c = e3.e().c();
            LoggerProxy.d("OfflineAuth", "+ downloadLicense");
            long j = SharedPreferencesUtils.getLong(c, SharedPreferencesUtils.LICENSE_EXPIRES, 0L);
            long currentTimeMillis = System.currentTimeMillis() - SharedPreferencesUtils.getLong(c, SharedPreferencesUtils.LICENSE_TIME, 0L);
            int i = -1;
            int i2 = SharedPreferencesUtils.getInt(c, SharedPreferencesUtils.LICENSE_LAST_ERROR_NO, -1);
            if (SharedPreferencesUtils.getString(c, SharedPreferencesUtils.LICENSE_LAST_SN, "").equals(this.c) && ((i2 == -1006 || i2 == -1007 || i2 == -1008 || i2 == -1011) && currentTimeMillis <= 86400000)) {
                c3 a2 = c3.a();
                x2 x2Var = x2.l0;
                String str = "appCode=" + this.f10132a + "--licensePath=" + this.d + " SN=" + this.c;
                TtsError a3 = a2.a(x2Var);
                a3.setCode(-1);
                a3.setMessage(str);
                a3.setThrowable(null);
                aVar.a(a3);
            } else {
                if (currentTimeMillis > j) {
                    try {
                        FutureTask futureTask = new FutureTask(new l(this.f10132a, this.b, this.c, this.d));
                        Thread thread = new Thread(futureTask);
                        thread.setName("bdtts-offlineCall");
                        thread.start();
                        i = ((Integer) futureTask.get(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS)).intValue();
                    } catch (InterruptedException e) {
                        e = e;
                        LoggerProxy.d("OfflineAuth", e.toString());
                    } catch (ExecutionException e2) {
                        LoggerProxy.d("OfflineAuth", e2.getCause().toString());
                    } catch (TimeoutException e3) {
                        e = e3;
                        LoggerProxy.d("OfflineAuth", e.toString());
                    }
                }
                LoggerProxy.d("OfflineAuth", "- downloadLicense ret = " + i);
                if (i < 0) {
                    c3 a4 = c3.a();
                    x2 x2Var2 = x2.Q;
                    String str2 = "appCode=" + this.f10132a + "--licensePath=" + this.d;
                    TtsError a5 = a4.a(x2Var2);
                    a5.setCode(i);
                    a5.setMessage(str2);
                    a5.setThrowable(null);
                    aVar.a(a5);
                } else if (!aVar.a()) {
                    aVar.a(c3.a().a(x2.O));
                }
            }
        }
        return aVar;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        m mVar = (m) obj;
        String str = mVar.f10132a;
        String str2 = mVar.d;
        boolean isEqual = StringTool.isEqual(this.f10132a, str);
        boolean isEqual2 = StringTool.isEqual(this.d, str2);
        if (isEqual && isEqual2) {
            return 0;
        }
        return 1;
    }

    /* loaded from: classes8.dex */
    public static class a implements j3 {

        /* renamed from: a, reason: collision with root package name */
        public int f10133a = -1;
        public String b;
        public String c;
        public String d;
        public TtsError e;

        public void a(TtsError ttsError) {
            LoggerProxy.d("OfflineAuth", "this=" + this + "--error=" + ttsError.getDetailMessage());
            this.e = ttsError;
        }

        public boolean b() {
            int i = this.f10133a;
            if (i >= 0 && i < 10000) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.tts.j3
        public boolean a() {
            if (StringTool.isEmpty(this.b) || !new File(this.b).exists()) {
                return false;
            }
            e3 e = e3.e();
            Context c = e.c();
            String d = e.d();
            byte[] bArr = new byte[32];
            LoggerProxy.d("OfflineAuth", "verify license before " + this.b);
            this.f10133a = EmbeddedSynthesizerEngine.bdTTSVerifyLicense(c, 2, this.c, d, TextUtils.isEmpty(this.d) ? "" : this.d, this.b, bArr);
            LoggerProxy.d("OfflineAuth", "verify result=" + this.f10133a);
            String str = new String(bArr);
            LoggerProxy.d("OfflineAuth", "get idStr=" + str);
            try {
                int indexOf = str.indexOf("end");
                if (indexOf != -1) {
                    new g2(c, str.substring(0, indexOf)).start();
                }
            } catch (Exception e2) {
                LoggerProxy.d("OfflineAuth", "embedded statistics start exception=" + e2.toString());
            }
            return this.f10133a >= 0;
        }
    }
}
