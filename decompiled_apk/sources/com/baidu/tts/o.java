package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.tools.CommonUtility;
import com.baidu.tts.tools.StringTool;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.apache.log4j.spi.LocationInfo;

/* loaded from: classes8.dex */
public class o implements k3<o, a> {

    /* renamed from: a, reason: collision with root package name */
    public String f10140a;
    public String b;
    public String c;
    public String d = "https";

    public final String a(String str, String str2, String str3) {
        String str4;
        HashMap hashMap = new HashMap();
        hashMap.put("grant_type", "client_credentials");
        hashMap.put("client_id", str);
        hashMap.put("client_secret", str2);
        try {
            str4 = CommonUtility.urlEncoded(hashMap);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            str4 = null;
        }
        return (str3 + "://openapi.baidu.com/oauth/2.0/token" + LocationInfo.NA) + str4;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        LoggerProxy.d("OnlineAuth", "enter online auth");
        a aVar = new a();
        if (StringTool.isEmpty(this.f10140a)) {
            try {
                String str = this.b;
                String str2 = this.c;
                if (!StringTool.isEmpty(str) && !StringTool.isEmpty(str2)) {
                    String a2 = a(this.b, this.c, this.d);
                    LoggerProxy.d("OnlineAuth", "url=" + a2);
                    new a4().a(a2, "", "POST", new n(this, aVar));
                }
                aVar.a(c3.a().a(x2.D0));
            } catch (Exception e) {
                TtsError a3 = c3.a().a(x2.d);
                a3.setThrowable(e);
                aVar.a(a3);
            }
        } else {
            aVar.f10141a = this.f10140a;
        }
        LoggerProxy.d("OnlineAuth", "end online auth");
        return aVar;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        o oVar = (o) obj;
        String str = oVar.f10140a;
        if (StringTool.isEmpty(this.f10140a)) {
            String str2 = oVar.b;
            String str3 = oVar.c;
            LoggerProxy.d("OnlineAuth", "mAK=" + this.b + "--mSK=" + this.c + "--ak2=" + str2 + "--sk2=" + str3);
            if (StringTool.isEqual(this.b, str2) && StringTool.isEqual(this.c, str3)) {
                return 0;
            }
        } else {
            LoggerProxy.d("OnlineAuth", "mProductId=" + this.f10140a + "--productId2=" + str);
            if (str != null) {
                return this.f10140a.compareTo(str);
            }
        }
        return 1;
    }

    /* loaded from: classes8.dex */
    public static class a implements j3 {

        /* renamed from: a, reason: collision with root package name */
        public String f10141a;
        public String b;
        public long c;
        public TtsError d;

        public void a(TtsError ttsError) {
            LoggerProxy.d("OnlineAuth", "this=" + this + "--error=" + ttsError.getDetailMessage());
            this.d = ttsError;
        }

        @Override // com.baidu.tts.j3
        public boolean a() {
            return !StringTool.isEmpty(this.f10141a) || (this.b != null && System.currentTimeMillis() < this.c);
        }
    }
}
