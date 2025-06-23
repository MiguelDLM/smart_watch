package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.emstatistics.TtsStatsUpload;
import com.baidu.tts.emstatistics.TtsStatsUploadBag;
import com.baidu.tts.f0;
import com.baidu.tts.f4;
import com.baidu.tts.k4;
import com.baidu.tts.x3;
import com.google.android.exoplayer2.ExoPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class p4 implements k4.b {
    public static volatile p4 c;

    /* renamed from: a, reason: collision with root package name */
    public k4 f10150a = null;
    public HashMap<k4, WeakReference<j4>> b;

    public p4() {
        this.b = null;
        this.b = new HashMap<>();
    }

    public static p4 a() {
        if (c == null) {
            synchronized (p4.class) {
                try {
                    if (c == null) {
                        c = new p4();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public final void b() {
        LoggerProxy.d("WsConnectionService", "stop WsConnectionService start");
        if (this.f10150a != null) {
            Throwable th = new Throwable();
            j4 b = b(this.f10150a);
            if (b != null) {
                a(this.f10150a);
                b.f10116a.a(th, 0);
            }
            this.f10150a.b();
            k4 k4Var = this.f10150a;
            k4Var.getClass();
            LoggerProxy.d("ConnectPoint", "stopService");
            synchronized (k4Var) {
                try {
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                }
                if (!k4Var.m) {
                    k4Var.m = true;
                    LoggerProxy.d("ConnectPoint", "ConnectPoint stopService start.");
                    k4Var.d();
                    LoggerProxy.d("ConnectPoint", "CPT" + k4Var.f + " cancel.");
                    k4Var.h.cancel();
                    LoggerProxy.d("ConnectPoint", "ConnectPoint stopService mExecutorService " + k4.o + " mState " + k4Var.d);
                    if (k4.o != null) {
                        LoggerProxy.d("ConnectPoint", "stopService = " + k4Var.d);
                        if (k4Var.d == 1) {
                            k4.o.getQueue().drainTo(new ArrayList());
                        }
                        if (k4Var.d != 0 || k4Var.d != 3) {
                            k4Var.e();
                        }
                        k4.o.shutdown();
                        k4.o.awaitTermination(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
                        k4.o = null;
                    }
                    try {
                        k4Var.j.put("connect_point_end", System.currentTimeMillis());
                        LoggerProxy.d("ConnectPoint", "ConnectPoint stopped, details " + k4Var.j.toString());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    LoggerProxy.d("ConnectPoint", "ConnectPoint stopService end.");
                }
            }
            this.f10150a = null;
        }
        n4.d = null;
        LoggerProxy.d("WsConnectionService", "stop WsConnectionService end");
    }

    public int c(k4 k4Var) {
        String str;
        String str2;
        LoggerProxy.d("WsConnectionService", "onOpened");
        j4 b = b(k4Var);
        if (b == null || b.f10116a == null || !b.g) {
            return -1;
        }
        p4 a2 = a();
        WeakReference<j4> weakReference = b.b;
        j4 b2 = a2.b(a2.f10150a);
        synchronized (a2) {
            try {
                if (b2 == weakReference.get()) {
                    k4 k4Var2 = a2.f10150a;
                    if (k4Var2.f10120a == null) {
                        str = null;
                    } else {
                        str = ((n4) k4Var2.f10120a).c;
                    }
                } else {
                    str = null;
                }
            } finally {
            }
        }
        b.e = str;
        y3 y3Var = b.f10116a;
        y3Var.getClass();
        LoggerProxy.d(y3.l, "Channel[" + y3Var.e + "], opened");
        y3Var.f = true;
        y3Var.a(y3Var.g);
        f0.b bVar = (f0.b) y3Var.f10203a;
        bVar.getClass();
        try {
            LoggerProxy.i(f0.d, "[onReady] network is ready.");
            y4 y4Var = bVar.f10085a;
            j4 j4Var = bVar.c.b;
            if (j4Var != null) {
                str2 = j4Var.e;
            } else {
                str2 = null;
            }
            y4Var.a("url", str2);
            bVar.f10085a.a(TtsStatsUploadBag.KEY_NET_EXCEPTION, 0);
            bVar.f10085a.a(TtsStatsUploadBag.KEY_TP_READY_TIME, Long.valueOf(System.currentTimeMillis()));
            byte[] a3 = bVar.a(bVar.b.f10084a, bVar.f10085a, bVar.d);
            bVar.h = a3;
            y3 y3Var2 = bVar.c;
            y3Var2.b.a(y3Var2.d.a(1, y3Var2.e, a3));
            bVar.a((TtsError) null);
        } catch (j5 unused) {
            bVar.a(c3.a().a(x2.k));
        }
        if (bVar.o != null) {
            bVar.c();
        }
        return 0;
    }

    public final void a(k4 k4Var) {
        synchronized (this) {
            try {
                if (this.b.containsKey(k4Var)) {
                    this.b.remove(k4Var);
                    this.f10150a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int a(k4 k4Var, byte[] bArr, boolean z) {
        f4.a aVar;
        x4 x4Var;
        LoggerProxy.d("WsConnectionService", "onMessage isText =" + z);
        j4 b = b(k4Var);
        if (b == null) {
            return -1;
        }
        if (bArr[5] != b.d) {
            LoggerProxy.d(j4.h, "onMessage ignore message with idx " + ((int) bArr[5]));
            return -1;
        }
        if (b.f10116a != null) {
            LoggerProxy.d(j4.h, "onMessage bridge[" + b.d + "] receive message");
            y3 y3Var = b.f10116a;
            y3Var.getClass();
            LoggerProxy.d(y3.l, "Channel[" + y3Var.e + "], on message");
            x3 x3Var = y3Var.d;
            x3Var.getClass();
            if (bArr.length < 8) {
                LoggerProxy.d(f4.f10087a, "tts-ws-ltv receive empty message.");
                aVar = null;
            } else {
                aVar = new f4.a();
                int a2 = f4.a(bArr, 0) - 4;
                aVar.f10088a = a2;
                byte b2 = bArr[4];
                aVar.b = bArr[7];
                byte[] bArr2 = new byte[a2];
                aVar.c = bArr2;
                System.arraycopy(bArr, 8, bArr2, 0, a2);
            }
            if (aVar == null) {
                TtsError a3 = c3.a().a(x2.E);
                x4 x4Var2 = new x4();
                x4Var2.j = a3;
                ((f0.b) x3Var.f10196a).a(x4Var2);
            } else {
                x3.a aVar2 = x3Var.b;
                if (aVar2 != null) {
                    byte b3 = aVar.b;
                    if (b3 == 80) {
                        byte[] bArr3 = aVar.c;
                        if (bArr3 != null) {
                            int i = aVar.f10088a;
                            if (i < 4) {
                                x4Var = new x4();
                                x4Var.j = c3.a().a(x2.F);
                            } else {
                                int a4 = f4.a(bArr3, 0);
                                int i2 = a4 + 4;
                                if (i < i2) {
                                    x4Var = new x4();
                                    x4Var.j = c3.a().a(x2.G);
                                } else {
                                    try {
                                        String str = new String(bArr3, 4, a4, "utf-8");
                                        String str2 = x3.c;
                                        LoggerProxy.i(str2, "responseStr=" + str);
                                        x4 x4Var3 = new x4();
                                        try {
                                            JSONObject jSONObject = new JSONObject(str);
                                            q2 q2Var = q2.ERROR_NUMBER;
                                            int optInt = jSONObject.optInt("err_no");
                                            x4Var3.c = optInt;
                                            if (optInt != 0) {
                                                q2 q2Var2 = q2.ERROR_MESSAGE;
                                                String string = jSONObject.getString("err_msg");
                                                TtsError a5 = c3.a().a(x2.j);
                                                a5.setCode(optInt);
                                                a5.setMessage(string);
                                                a5.setThrowable(null);
                                                LoggerProxy.d(str2, "setTtsError" + a5.getMessage());
                                                x4Var3.j = a5;
                                            } else {
                                                q2 q2Var3 = q2.SERIAL_NUMBER;
                                                x4Var3.d = jSONObject.optString("sn");
                                                q2 q2Var4 = q2.INDEX;
                                                x4Var3.e = jSONObject.optInt("idx");
                                                q2 q2Var5 = q2.PERCENT;
                                                x4Var3.f = jSONObject.optInt("percent");
                                                q2 q2Var6 = q2.RESPONSE_SAMPLE_RATE;
                                                int optInt2 = jSONObject.optInt("samplerate");
                                                if (optInt2 == 8000) {
                                                    x4Var3.k = u2.HZ8K;
                                                } else if (optInt2 == 16000) {
                                                    x4Var3.k = u2.HZ16K;
                                                } else if (optInt2 == 24000) {
                                                    x4Var3.k = u2.HZ24K;
                                                }
                                                if (u0.d) {
                                                    u0.a(optInt2);
                                                }
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                            TtsError a6 = c3.a().a(x2.o);
                                            LoggerProxy.d(x3.c, "tts header ------->setTtsError" + a6.getMessage());
                                            x4Var3.j = a6;
                                        }
                                        if (x4Var3.j == null) {
                                            LoggerProxy.i(x3.c, "jsonLength=" + a4 + ",responsePkg.body=" + i);
                                            int i3 = (i - 4) - a4;
                                            if (i3 > 0) {
                                                byte[] bArr4 = new byte[i3];
                                                System.arraycopy(bArr3, i2, bArr4, 0, i3);
                                                x4Var3.g = bArr4;
                                            } else {
                                                x4Var3.g = new byte[0];
                                            }
                                        }
                                        x4Var = x4Var3;
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                        x4Var = new x4();
                                        TtsError a7 = c3.a().a(x2.j);
                                        LoggerProxy.d(x3.c, "setTtsError" + a7.getMessage());
                                        x4Var.j = a7;
                                    }
                                }
                            }
                            ((f0.b) x3.this.f10196a).a(x4Var);
                        }
                    } else if (b3 == 95) {
                        LoggerProxy.d(x3.c, "tts reach end.");
                        ((f0.b) x3.this.f10196a).b();
                        TtsStatsUpload.getInstance().setOnlineDoneFlag(true);
                        aVar2.f10197a = true;
                    } else {
                        LoggerProxy.d(x3.c, "unsupported type=" + ((int) aVar.b));
                    }
                }
            }
            if (!y3Var.d.b.f10197a) {
                y3Var.a(y3Var.g);
            } else {
                y3Var.h.cancel();
            }
        }
        return 0;
    }

    public final j4 b(k4 k4Var) {
        WeakReference<j4> weakReference;
        synchronized (this) {
            try {
                if (!this.b.containsKey(k4Var) || (weakReference = this.b.get(k4Var)) == null || weakReference.get() == null) {
                    return null;
                }
                return weakReference.get();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int a(k4 k4Var, Throwable th, int i, String str) {
        j4 b = b(k4Var);
        LoggerProxy.d("WsConnectionService", "onFailure t =" + th + " code= " + i + " reason =" + ((String) null) + " cb = " + b);
        if (b != null) {
            a(k4Var);
            b.f10116a.a(th, i);
            return 0;
        }
        this.f10150a = null;
        return -1;
    }
}
