package com.baidu.tts;

import android.content.Context;
import com.baidu.tts.aop.tts.ITts;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.d0;
import com.baidu.tts.m;
import com.baidu.tts.o;
import com.baidu.tts.t0;
import com.baidu.tts.tools.DataTool;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* loaded from: classes8.dex */
public abstract class b5 implements ITts {

    /* renamed from: a, reason: collision with root package name */
    public d5 f10043a;

    public b5(d5 d5Var) {
        this.f10043a = d5Var;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public AuthInfo auth(w2 w2Var) {
        d5 d5Var = this.f10043a;
        d5Var.getClass();
        j a2 = j.a();
        z4 z4Var = d5Var.f10073a;
        a2.getClass();
        r4 r4Var = z4Var.f10209a;
        AuthInfo authInfo = new AuthInfo();
        authInfo.setTtsEnum(w2Var);
        int ordinal = w2Var.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal == 2) {
                    LoggerProxy.d("AuthClient", "enter authMix");
                    CountDownLatch countDownLatch = new CountDownLatch(2);
                    FutureTask futureTask = new FutureTask(new h(a2, r4Var, countDownLatch));
                    FutureTask futureTask2 = new FutureTask(new i(a2, r4Var, countDownLatch));
                    Thread thread = new Thread(futureTask);
                    thread.setName("bdtts-onlineThread");
                    thread.start();
                    Thread thread2 = new Thread(futureTask2);
                    thread2.setName("bdtts-offlineThread");
                    thread2.start();
                    try {
                        LoggerProxy.d("AuthClient", "+ await");
                        countDownLatch.await();
                        LoggerProxy.d("AuthClient", "- await");
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        futureTask.cancel(true);
                        futureTask2.cancel(true);
                    }
                    o.a aVar = new o.a();
                    LoggerProxy.d("AuthClient", "+ mix online get onlineResult=" + aVar);
                    try {
                        aVar = (o.a) futureTask.get();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        futureTask.cancel(true);
                        TtsError a3 = c3.a().a(x2.g);
                        a3.setThrowable(e);
                        aVar.a(a3);
                    } catch (CancellationException e2) {
                        TtsError a4 = c3.a().a(x2.s);
                        a4.setThrowable(e2);
                        aVar.a(a4);
                    } catch (ExecutionException e3) {
                        c3 a5 = c3.a();
                        x2 x2Var = x2.h;
                        Throwable cause = e3.getCause();
                        TtsError a6 = a5.a(x2Var);
                        a6.setThrowable(cause);
                        aVar.a(a6);
                    }
                    LoggerProxy.d("AuthClient", "- online get");
                    m.a aVar2 = new m.a();
                    LoggerProxy.d("AuthClient", "+ mix offline get offlineResult=" + aVar2);
                    try {
                        aVar2 = (m.a) futureTask2.get();
                    } catch (InterruptedException e4) {
                        Thread.currentThread().interrupt();
                        futureTask2.cancel(true);
                        TtsError a7 = c3.a().a(x2.S);
                        a7.setThrowable(e4);
                        aVar2.a(a7);
                    } catch (CancellationException e5) {
                        TtsError a8 = c3.a().a(x2.f0);
                        a8.setThrowable(e5);
                        aVar2.a(a8);
                    } catch (ExecutionException e6) {
                        c3 a9 = c3.a();
                        x2 x2Var2 = x2.T;
                        Throwable cause2 = e6.getCause();
                        TtsError a10 = a9.a(x2Var2);
                        a10.setThrowable(cause2);
                        aVar2.a(a10);
                    }
                    LoggerProxy.d("AuthClient", "- offline get");
                    AuthInfo authInfo2 = new AuthInfo();
                    authInfo2.setTtsEnum(w2.MIX);
                    authInfo2.setOnlineResult(aVar);
                    authInfo2.setOfflineResult(aVar2);
                    LoggerProxy.d("AuthClient", "end authMix");
                    return authInfo2;
                }
                return authInfo;
            }
            authInfo.setOfflineResult(a2.a(r4Var.b));
            return authInfo;
        }
        authInfo.setOnlineResult(a2.a(r4Var.f10162a));
        return authInfo;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public w2 getMode() {
        return this.f10043a.c;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public TtsListener getTtsListener() {
        return this.f10043a.b;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public z4 getTtsParams() {
        return this.f10043a.f10073a;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void setContext(Context context) {
        this.f10043a.getClass();
        e3 e = e3.e();
        e.getClass();
        e.b = new WeakReference<>(context);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void setMode(w2 w2Var) {
        this.f10043a.c = w2Var;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setParam(q2 q2Var, String str) {
        t2 t2Var;
        m2 m2Var;
        v2 v2Var;
        z4 z4Var = this.f10043a.f10073a;
        if (z4Var == null) {
            return 0;
        }
        r4 r4Var = z4Var.f10209a;
        d0.b bVar = r4Var.b;
        e0 e0Var = r4Var.f10162a;
        t0.a aVar = z4Var.b.f10159a;
        int ordinal = q2Var.ordinal();
        if (ordinal != 4) {
            if (ordinal != 21) {
                if (ordinal != 94) {
                    if (ordinal != 26) {
                        if (ordinal != 27) {
                            if (ordinal != 29) {
                                if (ordinal != 30) {
                                    if (ordinal != 67) {
                                        if (ordinal != 68) {
                                            if (ordinal != 70) {
                                                if (ordinal != 71) {
                                                    switch (ordinal) {
                                                        case 33:
                                                            r4 r4Var2 = z4Var.f10209a;
                                                            r4Var2.f10162a.f10171a = str;
                                                            r4Var2.b.f10171a = str;
                                                            return 0;
                                                        case 34:
                                                            z4Var.f10209a.f10162a.f10171a = str;
                                                            return 0;
                                                        case 35:
                                                            z4Var.f10209a.b.f10171a = str;
                                                            return 0;
                                                        case 36:
                                                            bVar.getClass();
                                                            bVar.u = Boolean.valueOf(str).booleanValue();
                                                            return 0;
                                                        case 37:
                                                            r4 r4Var3 = z4Var.f10209a;
                                                            r4Var3.f10162a.c = str;
                                                            r4Var3.b.c = str;
                                                            return 0;
                                                        case 38:
                                                            r4 r4Var4 = z4Var.f10209a;
                                                            r4Var4.f10162a.b = str;
                                                            r4Var4.b.b = str;
                                                            return 0;
                                                        case 39:
                                                            e0Var.d = str;
                                                            bVar.d = str;
                                                            return 0;
                                                        case 40:
                                                            n2[] values = n2.values();
                                                            for (int i = 0; i < 5 && !values[i].b.equals(str); i++) {
                                                            }
                                                            e0Var.getClass();
                                                            return 0;
                                                        case 41:
                                                            z4Var.b.f10159a.f10167a = Integer.parseInt(str);
                                                            return 0;
                                                        case 42:
                                                            l2 a2 = l2.a(str);
                                                            e0Var.getClass();
                                                            if (a2 != null) {
                                                                e0Var.h = a2;
                                                                return 0;
                                                            }
                                                            x2 x2Var = x2.D0;
                                                            return -406;
                                                        case 43:
                                                            m2[] values2 = m2.values();
                                                            int i2 = 0;
                                                            while (true) {
                                                                if (i2 < 5) {
                                                                    m2Var = values2[i2];
                                                                    if (!m2Var.f10135a.equals(str)) {
                                                                        i2++;
                                                                    }
                                                                } else {
                                                                    m2Var = null;
                                                                }
                                                            }
                                                            e0Var.i = m2Var;
                                                            return 0;
                                                        case 44:
                                                            e0Var.j = str;
                                                            return 0;
                                                        case 45:
                                                            e0Var.getClass();
                                                            return 0;
                                                        case 46:
                                                            e0Var.getClass();
                                                            return 0;
                                                        case 47:
                                                            e0Var.g = str;
                                                            bVar.f = str;
                                                            return 0;
                                                        case 48:
                                                            bVar.h = str;
                                                            return 0;
                                                        case 49:
                                                            bVar.i = str;
                                                            return 0;
                                                        case 50:
                                                            bVar.j = str;
                                                            return 0;
                                                        case 51:
                                                            bVar.l = str;
                                                            return 0;
                                                        case 52:
                                                            bVar.k = str;
                                                            return 0;
                                                        case 53:
                                                            bVar.m = str;
                                                            return 0;
                                                        case 54:
                                                            bVar.o = str;
                                                            return 0;
                                                        case 55:
                                                            bVar.getClass();
                                                            if (DataTool.isLong(str)) {
                                                                return 0;
                                                            }
                                                            x2 x2Var2 = x2.D0;
                                                            return -406;
                                                        case 56:
                                                            r4 r4Var5 = z4Var.f10209a;
                                                            r4Var5.getClass();
                                                            if (DataTool.isLong(str)) {
                                                                r4Var5.f10162a.e = str;
                                                                r4Var5.b.e = str;
                                                                return 0;
                                                            }
                                                            x2 x2Var3 = x2.D0;
                                                            return -406;
                                                        case 57:
                                                            return bVar.a(str);
                                                        case 58:
                                                            bVar.getClass();
                                                            return 0;
                                                        default:
                                                            switch (ordinal) {
                                                                case 73:
                                                                    bVar.r = str;
                                                                    return 0;
                                                                case 74:
                                                                    e0Var.m = str;
                                                                    return 0;
                                                                case 75:
                                                                    e0Var.o = str;
                                                                    return 0;
                                                                case 76:
                                                                    e0Var.p = Integer.parseInt(str);
                                                                    return 0;
                                                                case 77:
                                                                    e0Var.q = str;
                                                                    return 0;
                                                                case 78:
                                                                    e0Var.r = str;
                                                                    return 0;
                                                                default:
                                                                    switch (ordinal) {
                                                                        case 84:
                                                                            bVar.getClass();
                                                                            if (DataTool.isLong(str)) {
                                                                                bVar.s = str;
                                                                                return 0;
                                                                            }
                                                                            x2 x2Var4 = x2.D0;
                                                                            return 0;
                                                                        case 85:
                                                                            try {
                                                                                v2Var = v2.valueOf(str);
                                                                            } catch (Exception unused) {
                                                                                v2Var = v2.FOUR_SECOND;
                                                                            }
                                                                            z4Var.f10209a.f10162a.n = (int) v2Var.f10181a;
                                                                            return 0;
                                                                        case 86:
                                                                            int i3 = (int) 4000;
                                                                            try {
                                                                                int parseInt = Integer.parseInt(str);
                                                                                if (parseInt >= 200 && parseInt <= 6000) {
                                                                                    i3 = parseInt;
                                                                                } else {
                                                                                    LoggerProxy.e(z4.c, "ONLINE_REQUEST_TIMEOUT not effect " + str);
                                                                                }
                                                                            } catch (NumberFormatException unused2) {
                                                                                LoggerProxy.e(z4.c, "ONLINE_REQUEST_TIMEOUT not effect " + str);
                                                                            }
                                                                            z4Var.f10209a.f10162a.n = i3;
                                                                            return 0;
                                                                        default:
                                                                            switch (ordinal) {
                                                                                case 89:
                                                                                    e0Var.u = str;
                                                                                    return 0;
                                                                                case 90:
                                                                                    e0Var.t = str;
                                                                                    return 0;
                                                                                case 91:
                                                                                    e0Var.v = str;
                                                                                    return 0;
                                                                                case 92:
                                                                                    e0Var.w = str;
                                                                                    return 0;
                                                                                default:
                                                                                    switch (ordinal) {
                                                                                        case 96:
                                                                                            e0Var.y = str;
                                                                                            return 0;
                                                                                        case 97:
                                                                                            bVar.getClass();
                                                                                            return 0;
                                                                                        case 98:
                                                                                            bVar.getClass();
                                                                                            return 0;
                                                                                        case 99:
                                                                                            bVar.getClass();
                                                                                            try {
                                                                                                Boolean.valueOf(str).booleanValue();
                                                                                                return 0;
                                                                                            } catch (Exception e) {
                                                                                                LoggerProxy.d("OfflineSynthesizer", "parseBoolean exception = " + e.getMessage());
                                                                                                return 0;
                                                                                            }
                                                                                        case 100:
                                                                                            bVar.getClass();
                                                                                            if (DataTool.isLong(str)) {
                                                                                                bVar.t = str;
                                                                                                return 0;
                                                                                            }
                                                                                            x2 x2Var5 = x2.D0;
                                                                                            return 0;
                                                                                        default:
                                                                                            return 0;
                                                                                    }
                                                                            }
                                                                    }
                                                            }
                                                    }
                                                }
                                                e0Var.l = str;
                                                return 0;
                                            }
                                            e0Var.k = str;
                                            return 0;
                                        }
                                        e0Var.getClass();
                                        return 0;
                                    }
                                    e0Var.getClass();
                                    return 0;
                                }
                                bVar.q = str;
                                return 0;
                            }
                            bVar.p = str;
                            return 0;
                        }
                        aVar.getClass();
                        aVar.b = Integer.parseInt(str);
                        return 0;
                    }
                    try {
                        t2Var = t2.valueOf(str);
                    } catch (Exception unused3) {
                        t2Var = t2.DEFAULT;
                    }
                    z4Var.f10209a.c = t2Var;
                    return 0;
                }
                e0Var.x = str;
                return 0;
            }
            bVar.n = str;
            return 0;
        }
        e0Var.s = str;
        return 0;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void setTtsListener(TtsListener ttsListener) {
        d5 d5Var = this.f10043a;
        d5Var.getClass();
        if (ttsListener != null && ttsListener != d5Var.b) {
            d5Var.b = ttsListener;
            g gVar = d5Var.d;
            if (gVar != null) {
                gVar.a(ttsListener);
            }
        }
    }
}
