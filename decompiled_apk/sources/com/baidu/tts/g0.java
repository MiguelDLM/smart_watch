package com.baidu.tts;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.tools.Utility;
import java.net.URL;

/* loaded from: classes8.dex */
public class g0 implements Handler.Callback {
    public static final String e = "g0";
    public static String f = null;
    public static String g = null;
    public static boolean h = false;

    /* renamed from: a, reason: collision with root package name */
    public HandlerThread f10091a;
    public Handler b;
    public Runnable c;
    public int d = 3000;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            String str2 = g0.f;
            String str3 = g0.g;
            if (str3 == null || str3.isEmpty()) {
                str3 = "wss://tts.baidu.com/ws/sdktts";
            }
            String replace = str3.replace("ws", "http");
            c4 a2 = c4.a();
            a2.f10048a = str2;
            String str4 = null;
            try {
                String host = new URL(replace).getHost();
                Utility.getNetType(Utility.getContext());
                str4 = a2.a(host);
                if (!str4.isEmpty()) {
                    str = replace.replace(host, str4);
                } else {
                    str = "";
                }
                if (!TextUtils.isEmpty(str) && replace != null) {
                    LoggerProxy.d(g0.e, "getDNSIP: newUrl:" + replace + ", ipUrl:" + str);
                    c4.a().a(replace, str);
                } else {
                    LoggerProxy.d(g0.e, "getDNSIP: IP" + str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(str4)) {
                g0.this.d = 240000;
            } else {
                g0.this.d = 3000;
            }
            g0 g0Var = g0.this;
            g0Var.b.postDelayed(g0Var.c, g0Var.d);
        }
    }

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final g0 f10093a = new g0();
    }

    public g0() {
        this.c = null;
        HandlerThread handlerThread = new HandlerThread("HandlerThread");
        this.f10091a = handlerThread;
        handlerThread.start();
        this.b = new Handler(this.f10091a.getLooper(), this);
        h = false;
        this.c = new a();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return true;
    }
}
