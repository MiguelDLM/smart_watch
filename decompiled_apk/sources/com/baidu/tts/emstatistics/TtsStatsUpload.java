package com.baidu.tts.emstatistics;

import android.content.Context;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.i2;
import com.baidu.tts.tools.GetCUID;
import com.baidu.tts.tools.Utility;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import o0oIxXOx.oO;

/* loaded from: classes8.dex */
public class TtsStatsUpload {
    public static String TTSLOGURL = "https://upl.baidu.com/slp/upload_monitor?log_sn=";
    public static int e;
    public static TtsStatsUpload ttsStatsUpload;

    /* renamed from: a, reason: collision with root package name */
    public Context f10081a;
    public String c;
    public HttpURLConnection b = null;
    public boolean d = true;

    public static Map<String, String> a(Context context, String str) {
        HashMap hashMap = new HashMap();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            int i = e;
            e = i + 1;
            sb.append(i);
            hashMap.put("log-id", sb.toString());
            hashMap.put("real", URLEncoder.encode("1", "utf-8"));
            hashMap.put("uid", URLEncoder.encode(GetCUID.getCUID(context), "utf-8"));
            hashMap.put("appname", URLEncoder.encode(Utility.getAppName(context), "utf-8"));
            hashMap.put("sdk-version", URLEncoder.encode("3.2.7.163009b", "utf-8"));
            hashMap.put("data-collect-version", URLEncoder.encode(str + ".1.0.3"));
            hashMap.put(oO.f31192XO, URLEncoder.encode(Utility.getOS(), "utf-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        return hashMap;
    }

    public static TtsStatsUpload getInstance() {
        if (ttsStatsUpload == null) {
            ttsStatsUpload = new TtsStatsUpload();
        }
        return ttsStatsUpload;
    }

    public boolean checkIsUpload() {
        try {
            Context context = this.f10081a;
            i2.a();
            Map<String, String> a2 = a(context, i2.k);
            String str = TTSLOGURL + UUID.randomUUID().toString();
            this.c = str;
            a(str, a2, new byte[5], null);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public int dataCallBack(int i, byte[] bArr, int i2, boolean z) {
        try {
            Context context = this.f10081a;
            i2.a();
            Map<String, String> a2 = a(context, i2.k);
            this.c = TTSLOGURL + UUID.randomUUID().toString();
            LoggerProxy.d("TtsStatsUpload", "上传文件到: " + this.c);
            return a(this.c, a2, bArr, null);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public int dataCollectStat(byte[] bArr, i2.c cVar, String str) {
        try {
            Map<String, String> a2 = a(this.f10081a, str);
            String str2 = TTSLOGURL + UUID.randomUUID().toString();
            this.c = str2;
            return a(str2, a2, bArr, cVar);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public boolean isOnlineDoneFlag() {
        return this.d;
    }

    public void setContext(Context context) {
        this.f10081a = context;
    }

    public void setOnlineDoneFlag(boolean z) {
        this.d = z;
    }

    public void setTtsLogUrl(String str) {
        TTSLOGURL = str;
    }

    public void setUploadPermission(boolean z) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x015e, code lost:
    
        if (r11 != null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x01db, code lost:
    
        if (r10 != 200) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x01dd, code lost:
    
        com.baidu.tts.chainofresponsibility.logger.LoggerProxy.d("TtsStatsUpload", "Number of data uploaded to the file:" + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01f1, code lost:
    
        return 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01f2, code lost:
    
        if (r13 == null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01f6, code lost:
    
        ((com.baidu.tts.h2) r13).a(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01fa, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01fb, code lost:
    
        r10.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01d6, code lost:
    
        r11.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01d3, code lost:
    
        if (r10 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0194, code lost:
    
        r10 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0190, code lost:
    
        r8 = r11;
        r11 = r10;
        r10 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01b3, code lost:
    
        if (r10 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x018e, code lost:
    
        if (r10 == null) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.String r10, java.util.Map r11, byte[] r12, com.baidu.tts.i2.c r13) {
        /*
            Method dump skipped, instructions count: 525
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.emstatistics.TtsStatsUpload.a(java.lang.String, java.util.Map, byte[], com.baidu.tts.i2$c):int");
    }
}
