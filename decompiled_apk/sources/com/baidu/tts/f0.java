package com.baidu.tts;

import XIXIX.OOXIXo;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.emstatistics.TtsStatsUpload;
import com.baidu.tts.emstatistics.TtsStatsUploadBag;
import com.baidu.tts.g0;
import com.baidu.tts.o;
import com.baidu.tts.tools.StringTool;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.concurrent.Callable;
import o0oIxXOx.XIxXXX0x0;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class f0 extends a0 {
    public static final String d = "f0";
    public e0 b;
    public double c;

    /* loaded from: classes8.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public String f10084a;
        public String b;
        public String c;

        public a(f0 f0Var, String str) {
            this.f10084a = str;
        }
    }

    @Override // com.baidu.tts.a0
    public int b(u4 u4Var) {
        x2 x2Var = x2.n;
        return -11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tts.a0
    public <OnlineSynthesizerParams> void a(OnlineSynthesizerParams onlinesynthesizerparams) {
        e0 e0Var = (e0) onlinesynthesizerparams;
        this.b = e0Var;
        String str = e0Var.s;
        g0.f = e0Var.r;
        g0.g = str;
        g0 g0Var = g0.b.f10093a;
        g0Var.getClass();
        if (g0.h) {
            return;
        }
        g0Var.b.postDelayed(g0Var.c, 1000L);
        g0.h = true;
    }

    @Override // com.baidu.tts.a0
    public TtsError a(y4 y4Var) throws InterruptedException {
        try {
            if (l1.a().b()) {
                return c3.a().a(x2.E0);
            }
            TtsError call = new b(y4Var).call();
            y4Var.a(TtsStatsUploadBag.KEY_SYN_TEXT, y4Var.f10206a.length() > y4Var.j ? y4Var.f10206a.substring(0, y4Var.j) : null);
            return call;
        } catch (InterruptedException e) {
            LoggerProxy.d(d, "ws syn call interrupted!");
            throw e;
        } catch (Exception e2) {
            LoggerProxy.d(d, "ws syn call exception! e=" + e2.getMessage());
            TtsError a2 = c3.a().a(x2.m);
            a2.setThrowable(e2);
            return a2;
        }
    }

    @Override // com.baidu.tts.a0
    public int a(u4 u4Var) {
        x2 x2Var = x2.n;
        return -11;
    }

    @Override // com.baidu.tts.a0
    public int a(w4 w4Var) {
        x2 x2Var = x2.n;
        return -11;
    }

    @Override // com.baidu.tts.a0
    public int a(v4 v4Var) {
        x2 x2Var = x2.n;
        return -11;
    }

    @Override // com.baidu.tts.a0
    public int a(HashMap<String, String> hashMap) {
        x2 x2Var = x2.n;
        return -11;
    }

    /* loaded from: classes8.dex */
    public class b implements Callable<TtsError>, z3 {

        /* renamed from: a, reason: collision with root package name */
        public y4 f10085a;
        public a b;
        public y3 c;
        public e0 d;
        public int e = 1;
        public volatile int f = 0;
        public u2 g = u2.HZ16K;
        public byte[] h = null;
        public boolean i = false;
        public boolean j = false;
        public boolean k = false;
        public int l = 0;
        public volatile boolean m = false;
        public long n = 0;
        public volatile TtsError o = null;
        public Object p = new Object();

        public b(y4 y4Var) {
            this.f10085a = y4Var;
            this.b = new a(f0.this, y4Var.c());
            this.c = new y3(this, this.f10085a.c());
            this.d = f0.this.b.a();
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0129  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0136  */
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.baidu.tts.aop.tts.TtsError call() throws java.lang.Exception {
            /*
                Method dump skipped, instructions count: 532
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.f0.b.call():com.baidu.tts.aop.tts.TtsError");
        }

        public void b() {
            LoggerProxy.i(f0.d, "[onFinish]notify");
            this.i = true;
            this.k = false;
            if (this.f == 0) {
                a(x2.N, null);
            }
            c();
        }

        public final void c() {
            synchronized (this.p) {
                LoggerProxy.i(f0.d, "stop tts synthesizer.");
                this.m = true;
                this.p.notifyAll();
            }
        }

        public final void a(TtsError ttsError) {
            if (ttsError == null) {
                return;
            }
            if (this.o == null) {
                LoggerProxy.d(f0.d, "set first tts error.");
                this.o = ttsError;
            } else {
                this.o.log();
                LoggerProxy.d(f0.d, "already has error, only log error.");
                ttsError.log();
            }
        }

        public void a(x4 x4Var) {
            this.f++;
            if (x4Var.j != null || x4Var.c != 0) {
                LoggerProxy.i(f0.d, "[onMessage] message has error, interrupted.");
                a(x4Var.j);
                c();
                return;
            }
            int i = x4Var.e;
            this.e = i;
            if (i < 0) {
                LoggerProxy.i(f0.d, "count is " + x4Var.e);
                this.k = true;
            }
            LoggerProxy.d(f0.d, "receive " + x4Var.e + " package");
            if (Math.abs(this.e) == 1) {
                this.f10085a.a(TtsStatsUploadBag.KEY_FIRST_RESPONSE_TIME, Long.valueOf(System.currentTimeMillis() - this.n));
            }
            if (this.e == 1) {
                this.g = x4Var.k;
                TtsStatsUpload.getInstance().setOnlineDoneFlag(false);
            } else {
                x4Var.k = this.g;
            }
            y4 y4Var = this.f10085a;
            int i2 = this.e;
            synchronized (y4Var) {
                JSONObject jSONObject = new JSONObject();
                y4Var.h = jSONObject;
                try {
                    jSONObject.put(TtsStatsUploadBag.KEY_TTS_PACKAGE_IDX, i2);
                    y4Var.h.put(TtsStatsUploadBag.KEY_QUERY_END_TIME, System.currentTimeMillis());
                    y4Var.g.put(y4Var.h);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            x4Var.i = this.f10085a;
            f0 f0Var = f0.this;
            if (f0Var.b.h == l2.c) {
                x4Var.f10198a = null;
            } else {
                x4Var.l = f0Var.c;
            }
            int a2 = l1.a().a(x4Var);
            LoggerProxy.d(f0.d, "Decoder ret : " + a2);
            if (a2 == -3) {
                a(x2.H, null);
            } else if (a2 == 0) {
                this.f10085a.j = x4Var.f;
            }
        }

        public final void a(x2 x2Var, Throwable th) {
            TtsError a2 = c3.a().a(x2Var);
            a2.setThrowable(th);
            a2.setSN(this.b.f10084a);
            a(a2);
        }

        public final byte[] a(String str, y4 y4Var, e0 e0Var) throws j5 {
            long j;
            double d;
            String str2 = null;
            if (e0Var == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            e3 e = e3.e();
            try {
                q2 q2Var = q2.SERIAL_NUMBER;
                jSONObject.put("sn", str);
                q2 q2Var2 = q2.CTP;
                e.getClass();
                try {
                    str2 = (String) e.c.get("ctp");
                } catch (Exception unused) {
                }
                q2 q2Var3 = q2.CTP;
                jSONObject.put("ctp", str2);
                String str3 = e0Var.g;
                if (!StringTool.isEmpty(str3)) {
                    q2 q2Var4 = q2.PRODUCT_ID;
                    jSONObject.put("pdt", Integer.parseInt(str3));
                }
                String str4 = e0Var.m;
                if (!StringTool.isEmpty(str4)) {
                    q2 q2Var5 = q2.KEY;
                    jSONObject.put("key", str4);
                }
                q2 q2Var6 = q2.MULTIPLEX;
                jSONObject.put("multiplex", 1);
                q2 q2Var7 = q2.TEXT;
                jSONObject.put("tex", y4Var.f10206a);
                String d2 = e.d();
                if (d2 != null) {
                    q2 q2Var8 = q2.CUID;
                    jSONObject.put("cuid", d2);
                }
                if (!StringTool.isEmpty(str3)) {
                    String str5 = f0.d;
                    LoggerProxy.d(str5, "before online auth");
                    o.a a2 = j.a().a(e0Var);
                    LoggerProxy.d(str5, "after online auth");
                    if (a2.a()) {
                        String str6 = a2.b;
                        q2 q2Var9 = q2.TOKEN;
                        jSONObject.put("tok", str6);
                    } else {
                        throw new j5();
                    }
                }
                q2 q2Var10 = q2.SPEED;
                jSONObject.put("spd", Float.valueOf(e0Var.f10171a));
                q2 q2Var11 = q2.PITCH;
                jSONObject.put("pit", Float.valueOf(e0Var.b));
                q2 q2Var12 = q2.VOLUME;
                jSONObject.put("vol", Float.valueOf(e0Var.c));
                q2 q2Var13 = q2.SPEAKER;
                jSONObject.put("per", Integer.valueOf(e0Var.j).intValue());
                q2 q2Var14 = q2.AUDIO_ENCODE;
                jSONObject.put("aue", Integer.valueOf(e0Var.h.f10129a).intValue());
                q2 q2Var15 = q2.VERSION;
                jSONObject.put("ver", "3.2.7.163009b");
                String str7 = e0Var.i.f10135a;
                int parseInt = StringTool.isEmpty(str7) ? 1 : Integer.parseInt(str7);
                q2 q2Var16 = q2.BITRATE;
                jSONObject.put("rate", parseInt);
                l2 a3 = l2.a(e0Var.h.f10129a);
                if (a3 != null) {
                    f0 f0Var = f0.this;
                    m2[] a4 = a3.a();
                    int length = a4.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            d = 0.0d;
                            break;
                        }
                        m2 m2Var = a4[i];
                        if (m2Var.f10135a.equalsIgnoreCase(str7)) {
                            d = m2Var.b;
                            break;
                        }
                        i++;
                    }
                    f0Var.c = d;
                }
                if (f0.this.c == OOXIXo.f3760XO) {
                    LoggerProxy.w(f0.d, "unsupported rate " + str7);
                }
                q2 q2Var17 = q2.LANGUAGE;
                jSONObject.put("lan", e0Var.d);
                q2 q2Var18 = q2.OPEN_XML;
                try {
                    j = Long.parseLong(e0Var.e);
                } catch (Exception unused2) {
                    j = 0;
                }
                jSONObject.put(XIxXXX0x0.f31179xoXoI, j);
                jSONObject.put("mode", 0);
                q2 q2Var19 = q2.PLATFORM;
                jSONObject.put("platform", "Android");
                String str8 = e0Var.u;
                if (str8 != null) {
                    q2 q2Var20 = q2.AUDIO_CTRL;
                    jSONObject.put("audio_ctrl", str8);
                }
                String str9 = e0Var.t;
                if (str9 != null) {
                    q2 q2Var21 = q2.TEXT_CTRL;
                    jSONObject.put("text_ctrl", str9);
                }
                String str10 = e0Var.v;
                if (str10 != null) {
                    q2 q2Var22 = q2.LIP_CTRL;
                    jSONObject.put("lip_ctrl", str10);
                }
                String str11 = e0Var.w;
                if (str11 != null) {
                    q2 q2Var23 = q2.LIP_ENABLE;
                    jSONObject.put("lip", str11);
                }
                String str12 = e0Var.x;
                if (str12 != null && !str12.isEmpty()) {
                    q2 q2Var24 = q2.STAT_PAM;
                    jSONObject.put("stat_pam", str12);
                }
                String str13 = e0Var.y;
                if (str13 != null && !str13.isEmpty()) {
                    q2 q2Var25 = q2.TEXT_POS;
                    jSONObject.put("text_pos", str13);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            byte[] bytes = jSONObject.toString().getBytes(Charset.forName("UTF-8"));
            LoggerProxy.d(f0.d, "request params: " + new String(bytes));
            return bytes;
        }
    }
}
