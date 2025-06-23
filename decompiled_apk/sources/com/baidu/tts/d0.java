package com.baidu.tts;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.SynthesizerTool;
import com.baidu.tts.emstatistics.TtsStatsUploadBag;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.m;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.ResourceTools;
import com.baidu.tts.tools.SharedPreferencesUtils;
import com.bestmafen.baseble.connector.AbsBleConnector;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class d0 extends a0 {
    public static long g;
    public static HashMap<String, a> h = new HashMap<>();
    public b b;
    public long[] c = new long[1];
    public String d = "";
    public Context e = null;
    public String f = null;

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f10068a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;

        public String toString() {
            return "OfflineResource{speaker='" + this.f10068a + "', type='" + this.b + "', textFilePath='" + this.c + "', speechFilePath='" + this.d + "', subganFilePath='" + this.e + "', tacFilePath='" + this.f + "', tacSubganSpeakerAttr='" + this.g + "'}";
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends t4<b> {
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String n;
        public String o;
        public String p;
        public String q;
        public boolean u;
        public String g = "1";
        public String r = "5";
        public String s = "1";
        public String t = "0";

        public int a(String str) {
            if (DataTool.isLong(str)) {
                this.g = str;
                return 0;
            }
            x2 x2Var = x2.D0;
            return -406;
        }

        public long b() {
            try {
                return Long.parseLong(this.t);
            } catch (Exception e) {
                LoggerProxy.d("OfflineSynthesizer", "parseLong exception = " + e.getMessage());
                return 0L;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Callable<TtsError>, EmbeddedSynthesizerEngine.OnNewDataListener {

        /* renamed from: a, reason: collision with root package name */
        public y4 f10069a;
        public int h;
        public int b = 0;
        public u2 c = u2.HZ16K;
        public long d = 0;
        public long e = 0;
        public long f = 0;
        public long g = 0;
        public int i = 0;

        public c(y4 y4Var) {
            this.h = 0;
            Executors.newCachedThreadPool(new a3("bdtts-OfflineSynthesizer"));
            this.f10069a = y4Var;
            this.h = y4Var.b();
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TtsError call() throws Exception {
            long j;
            long j2;
            byte[] bArr;
            LoggerProxy.d("OfflineSynthesizer", "start offline Synthesizer " + this.f10069a.i);
            m.a a2 = j.a().a(d0.this.b);
            if (a2 != null) {
                if (a2.b()) {
                    String str = d0.this.b.c;
                    if (str.matches("\\d+(.\\d+)?")) {
                        EmbeddedSynthesizerEngine.bdTTSSetParamFloat(d0.this.c[0], 1, Float.parseFloat(str));
                    }
                    String str2 = d0.this.b.f10171a;
                    if (str2.matches("\\d+(.\\d+)?")) {
                        EmbeddedSynthesizerEngine.bdTTSSetParamFloat(d0.this.c[0], 2, Float.parseFloat(str2));
                    }
                    String str3 = d0.this.b.b;
                    if (str3.matches("\\d+(.\\d+)?")) {
                        EmbeddedSynthesizerEngine.bdTTSSetParamFloat(d0.this.c[0], 3, Float.parseFloat(str3));
                    }
                    String str4 = d0.this.b.r;
                    if (str4.matches("\\d+(.\\d+)?")) {
                        EmbeddedSynthesizerEngine.bdTTSSetParamFloat(d0.this.c[0], 4, Float.parseFloat(str4));
                    }
                    long j3 = 0;
                    LoggerProxy.d("OfflineSynthesizer", "engineResult = " + EmbeddedSynthesizerEngine.bdTTSSetParam(d0.this.c[0], 0, 0L));
                    d0 d0Var = d0.this;
                    long j4 = d0Var.c[0];
                    b bVar = d0Var.b;
                    bVar.getClass();
                    try {
                        j = Long.parseLong(bVar.g);
                    } catch (Exception e) {
                        LoggerProxy.d("OfflineSynthesizer", "parseLong exception = " + e.getMessage());
                        j = 0L;
                    }
                    EmbeddedSynthesizerEngine.bdTTSSetParam(j4, 6, j);
                    long bdTTSGetParam = EmbeddedSynthesizerEngine.bdTTSGetParam(d0.this.c[0], 6);
                    LoggerProxy.d("OfflineSynthesizer", "获取vocoder level " + bdTTSGetParam);
                    d0 d0Var2 = d0.this;
                    long j5 = d0Var2.c[0];
                    b bVar2 = d0Var2.b;
                    bVar2.getClass();
                    try {
                        j3 = Long.parseLong(bVar2.e);
                    } catch (Exception unused) {
                    }
                    EmbeddedSynthesizerEngine.bdTTSSetParam(j5, 5, j3);
                    d0 d0Var3 = d0.this;
                    long j6 = d0Var3.c[0];
                    b bVar3 = d0Var3.b;
                    bVar3.getClass();
                    try {
                        j2 = Long.parseLong(bVar3.s);
                    } catch (Exception e2) {
                        LoggerProxy.d("OfflineSynthesizer", "parseLong exception = " + e2.getMessage());
                        j2 = 0;
                    }
                    EmbeddedSynthesizerEngine.bdTTSSetParam(j6, 7, j2);
                    d0 d0Var4 = d0.this;
                    EmbeddedSynthesizerEngine.bdTTSSetParam(d0Var4.c[0], 20, d0Var4.b.b());
                    LoggerProxy.d("OfflineSynthesizer", "获取vocoder level " + bdTTSGetParam + " enalbeWm " + d0.this.b.b());
                    EmbeddedSynthesizerEngine.setOnNewDataListener(this);
                    this.f10069a.b = "gbk";
                    long bdTTSGetParam2 = EmbeddedSynthesizerEngine.bdTTSGetParam(d0.this.c[0], 8);
                    if (bdTTSGetParam2 == 24000) {
                        this.c = u2.HZ24K;
                        if (u0.d) {
                            u0.a((int) bdTTSGetParam2);
                        }
                    } else if (bdTTSGetParam2 == Cea608Decoder.MIN_DATA_CHANNEL_TIMEOUT_MS) {
                        this.c = u2.HZ16K;
                        if (u0.d) {
                            u0.a((int) bdTTSGetParam2);
                        }
                    }
                    LoggerProxy.d("OfflineSynthesizer", " sampleRate:" + bdTTSGetParam2 + " sampleRateEnum:" + this.c.f10176a + " enableAec:" + u0.d);
                    y4 y4Var = this.f10069a;
                    y4Var.getClass();
                    try {
                        bArr = y4Var.f10206a.substring(y4Var.j).getBytes(y4Var.b);
                    } catch (UnsupportedEncodingException e3) {
                        e3.printStackTrace();
                        bArr = null;
                    }
                    LoggerProxy.d("OfflineSynthesizer", "before bdttssynthesis");
                    this.f = System.currentTimeMillis();
                    int bdTTSSynthesis = EmbeddedSynthesizerEngine.bdTTSSynthesis(d0.this.c[0], bArr, bArr.length);
                    LoggerProxy.d("OfflineSynthesizer", "get last empty synthesizer audio " + this.f10069a.i + ", progress " + this.i);
                    this.b = 0 - (this.b + 1);
                    x4 a3 = x4.a(this.f10069a);
                    a3.b = 1;
                    a3.h = k2.PCM;
                    a3.g = new byte[0];
                    a3.f = this.i;
                    a3.k = this.c;
                    int i = this.b;
                    a3.d = this.f10069a.i;
                    a3.e = i;
                    a3.c = bdTTSSynthesis;
                    l1.a().a(a3);
                    LoggerProxy.d("OfflineSynthesizer", "after bdttssynthesis result = " + bdTTSSynthesis + ", sn=" + this.f10069a.i);
                    try {
                        this.f10069a.b(TtsStatsUploadBag.KEY_SPEAKER, new JSONObject(d0.this.d).optString(TtsStatsUploadBag.KEY_SPEAKER, "null"));
                        this.f10069a.b(TtsStatsUploadBag.KEY_AUDIO_DURATION, Long.valueOf(this.d));
                        this.f10069a.b(TtsStatsUploadBag.KEY_ENGINE_VERSION, SynthesizerTool.getEngineVersion() + "");
                        this.f10069a.b("appid", d0.this.b.p);
                        this.f10069a.b(TtsStatsUploadBag.KEY_OFFLINE_CODE, Integer.valueOf(bdTTSSynthesis));
                        this.f10069a.b(TtsStatsUploadBag.KEY_FIRST_RESPONSE_TIME, Long.valueOf(this.e));
                    } catch (Throwable th) {
                        LoggerProxy.d("OfflineSynthesizer", "offline mtj exception! e=" + th.getMessage());
                        th.printStackTrace();
                    }
                    if (bdTTSSynthesis == 0) {
                        SharedPreferencesUtils.putLong(d0.this.e, "Success_Count", SharedPreferencesUtils.getLong(d0.this.e, "Success_Count", 0L) + 1);
                        return null;
                    }
                    SharedPreferencesUtils.putLong(d0.this.e, "Fail_Count", SharedPreferencesUtils.getLong(d0.this.e, "Fail_Count", 0L) + 1);
                    TtsError a4 = c3.a().a(x2.Y);
                    a4.setCode(bdTTSSynthesis);
                    a4.setMessage(null);
                    a4.setThrowable(null);
                    return a4;
                }
                return a2.e;
            }
            return c3.a().a(x2.R);
        }

        @Override // com.baidu.tts.jni.EmbeddedSynthesizerEngine.OnNewDataListener
        public int onNewData(byte[] bArr, int i) {
            this.i = i + this.h;
            LoggerProxy.d("OfflineSynthesizer", "get synthesizer audio " + this.f10069a.i + ", progress " + this.i);
            this.b = this.b + 1;
            x4 a2 = x4.a(this.f10069a);
            a2.b = 1;
            a2.h = k2.PCM;
            a2.g = bArr;
            a2.f = this.i;
            a2.k = this.c;
            int i2 = this.b;
            a2.d = this.f10069a.i;
            a2.e = i2;
            if (l1.a().a(a2) == -2) {
                LoggerProxy.d("OfflineSynthesizer", "offline engine putdata interrupted!");
                return -1;
            }
            if (this.b == 1) {
                this.e = System.currentTimeMillis() - this.f;
            }
            this.g += bArr.length;
            if (bArr.length == 0) {
                System.currentTimeMillis();
                this.d = (this.g * AbsBleConnector.TIMEOUT) / (this.c.f10176a * 16);
            }
            if (Thread.currentThread().isInterrupted()) {
                LoggerProxy.d("OfflineSynthesizer", "interrupted to interrupt syn");
                return -1;
            }
            return 0;
        }
    }

    @Override // com.baidu.tts.a0
    public int a(v4 v4Var) {
        String str = v4Var.b;
        String str2 = v4Var.f10183a;
        boolean isEmpty = TextUtils.isEmpty(str);
        if (!TextUtils.isEmpty(str2) && !isEmpty) {
            int loadEnglishEngine = EmbeddedSynthesizerEngine.loadEnglishEngine(ResourceTools.stringToByteArrayAddNull(str2), ResourceTools.stringToByteArrayAddNull(str), this.c[0]);
            LoggerProxy.d("OfflineSynthesizer", "loadEnglishModel ret=" + loadEnglishEngine);
            return loadEnglishEngine;
        }
        x2 x2Var = x2.D0;
        return -406;
    }

    @Override // com.baidu.tts.a0
    public int b(u4 u4Var) {
        return EmbeddedSynthesizerEngine.bdTTSDomainDataInit(ResourceTools.stringToByteArrayAddNull(u4Var.f10178a), this.c[0]);
    }

    @Override // com.baidu.tts.a0
    public TtsError b() {
        EmbeddedSynthesizerEngine.bdTTSEngineUninit(this.c[0]);
        g = 0L;
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tts.a0
    public <OfflineSynthesizerParams> void a(OfflineSynthesizerParams offlinesynthesizerparams) {
        this.b = (b) offlinesynthesizerparams;
    }

    /* JADX WARN: Code restructure failed: missing block: B:98:0x0175, code lost:
    
        com.baidu.tts.chainofresponsibility.logger.LoggerProxy.e("OfflineSynthesizer", "speakerId or styleId is empty");
        r0 = com.baidu.tts.c3.a().a(com.baidu.tts.x2.j0);
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x03a3 A[RETURN] */
    @Override // com.baidu.tts.a0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.baidu.tts.aop.tts.TtsError a() {
        /*
            Method dump skipped, instructions count: 935
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.d0.a():com.baidu.tts.aop.tts.TtsError");
    }

    @Override // com.baidu.tts.a0
    public TtsError a(y4 y4Var) throws InterruptedException {
        int indexOf = y4Var.f10206a.indexOf("<");
        if (indexOf > -1) {
            String substring = y4Var.f10206a.substring(indexOf + 1, y4Var.f10206a.indexOf(">"));
            int indexOf2 = y4Var.f10206a.indexOf("<" + substring + ">");
            int indexOf3 = y4Var.f10206a.indexOf("</" + substring + ">");
            if (this.b.u && indexOf3 > indexOf2 && !TextUtils.isEmpty(substring)) {
                return c3.a().a(x2.i0);
            }
        }
        try {
            if (l1.a().b()) {
                return c3.a().a(x2.E0);
            }
            c cVar = new c(y4Var);
            int i = y4Var.j;
            TtsError call = cVar.call();
            y4Var.b(TtsStatsUploadBag.KEY_SYN_TEXT, y4Var.f10206a.substring(i));
            return call;
        } catch (InterruptedException e) {
            LoggerProxy.d("OfflineSynthesizer", "offline syn call interrupted!");
            throw e;
        } catch (Exception e2) {
            LoggerProxy.d("OfflineSynthesizer", "offline syn call exception! e=" + e2.getMessage());
            TtsError a2 = c3.a().a(x2.X);
            a2.setThrowable(e2);
            return a2;
        }
    }

    public final String a(String str) {
        this.d = EmbeddedSynthesizerEngine.bdTTSGetDatParam(str);
        LoggerProxy.d("OfflineSynthesizer", "before bdTTSEngineInit SpeechInfo: " + this.d);
        SharedPreferencesUtils.putString(this.e, "offline_speechDatInfo", this.d);
        try {
            return new JSONObject(this.d).optString("authorize");
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tts.a0
    public int a(u4 u4Var) {
        return EmbeddedSynthesizerEngine.bdTTSDomainDataUninit(this.c[0]);
    }
}
