package com.adp.sdk;

import android.content.Context;
import android.util.Log;
import com.adp.sdk.dto.AdInfo;
import com.adp.sdk.dto.AdItem;
import com.adp.sdk.listener.AdInfoListener;
import com.adp.sdk.utils.GsonUtils;
import com.adp.sdk.utils.d;
import com.adp.sdk.utils.f;
import com.adp.sdk.utils.g;
import com.adp.sdk.utils.i;
import com.sma.smartv3.network.BaiDu;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import okhttp3.Call;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f709a;
    protected static AdInfo b;

    /* renamed from: com.adp.sdk.a$a  reason: collision with other inner class name */
    public static class C0012a extends f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f710a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0012a(Context context, d dVar) {
            super(context);
            this.f710a = dVar;
        }

        public void a(Call call, Exception exc) {
        }

        public void a(Call call, String str) {
            try {
                String string = new JSONObject(str).getString("result");
                this.f710a.a(BaiDu.SERVICE_ID_KEY, string);
                ADP.serviceId = string;
            } catch (Exception unused) {
            }
        }
    }

    private a() {
    }

    /* access modifiers changed from: private */
    public static void b(Context context, String str) {
        AdInfo adInfo;
        String str2;
        d dVar = new d(context);
        String b2 = dVar.b(BaiDu.SERVICE_ID_KEY, "");
        if (!"".equals(b2) || (adInfo = b) == null || !adInfo.isGetServiceId()) {
            ADP.serviceId = b2;
            return;
        }
        if (b.getIdServer() == null || b.getIdServer().length() <= 0) {
            str2 = "http://adsplus.cn:8083/ad/serial/";
        } else {
            str2 = b.getIdServer();
        }
        g.a(str2 + str, (Map<String, String>) null, new C0012a(context, dVar));
    }

    public static a a() {
        if (f709a == null) {
            f709a = new a();
        }
        return f709a;
    }

    public static class b extends f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f711a;
        final /* synthetic */ AdInfoListener b;
        final /* synthetic */ String c;
        final /* synthetic */ Context d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Context context, boolean z, AdInfoListener adInfoListener, String str, Context context2) {
            super(context);
            this.f711a = z;
            this.b = adInfoListener;
            this.c = str;
            this.d = context2;
        }

        public void a(Call call, Exception exc) {
            AdInfoListener adInfoListener;
            if (ADP.DEBUGLOG) {
                Log.e("-----", "---error--" + exc.toString());
            }
            if (this.f711a && (adInfoListener = this.b) != null) {
                adInfoListener.error("-1", exc.getMessage());
            }
        }

        public void a(Call call, String str) {
            AdInfoListener adInfoListener;
            AdInfoListener adInfoListener2;
            AdInfoListener adInfoListener3;
            try {
                AdInfo adInfo = (AdInfo) GsonUtils.GsonToBean(str, AdInfo.class);
                a.b = adInfo;
                if (this.c.equals(adInfo.getAppId())) {
                    if ("0".equals(a.b.getStatus())) {
                        d dVar = new d(this.d);
                        dVar.a("ADINFO" + this.c, str);
                        if (this.f711a && (adInfoListener3 = this.b) != null) {
                            adInfoListener3.onAdLoadOk(a.b.getTencent(), a.b.getBytedance(), a.b.getAppname(), a.b.getKuaishou());
                        }
                        a.b(this.d, this.c);
                    }
                }
                if (this.f711a && (adInfoListener2 = this.b) != null) {
                    adInfoListener2.error(a.b.getStatus(), a.b.getDes());
                }
                a.b(this.d, this.c);
            } catch (Exception e) {
                e.printStackTrace();
                if (this.f711a && (adInfoListener = this.b) != null) {
                    adInfoListener.error("-1", "Network error or AppId is invalid!");
                }
            }
        }
    }

    public void a(String str, Context context, AdInfoListener adInfoListener) {
        d dVar = new d(context);
        String b2 = dVar.b("ADINFO" + str, "");
        boolean z = true;
        if ("".equals(b2)) {
            a(str, "https://adsplus.oss-accelerate.aliyuncs.com/" + str + ".json", context, true, adInfoListener);
            return;
        }
        try {
            AdInfo adInfo = (AdInfo) GsonUtils.GsonToBean(b2, AdInfo.class);
            b = adInfo;
            if (adInfo != null) {
                if ("0".equals(adInfo.getStatus()) && str.equals(b.getAppId())) {
                    String b3 = dVar.b(BaiDu.SERVICE_ID_KEY, "");
                    if (!"".equals(b3)) {
                        ADP.serviceId = b3;
                    }
                    adInfoListener.onAdLoadOk(b.getTencent(), b.getBytedance(), b.getAppname(), b.getKuaishou());
                    z = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(str, "https://adsplus.oss-accelerate.aliyuncs.com/" + str + ".json", context, z, adInfoListener);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:2|3|(1:5)|6|7|10|(1:12)(2:13|(1:15)(1:16))) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0017 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0024 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(com.adp.sdk.dto.AdItem r5, android.content.Context r6) {
        /*
            if (r6 == 0) goto L_0x0060
            if (r5 != 0) goto L_0x0005
            goto L_0x0060
        L_0x0005:
            java.lang.String r0 = r5.getRate()     // Catch:{ Exception -> 0x0017 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0017 }
            boolean r0 = a(r0)     // Catch:{ Exception -> 0x0017 }
            if (r0 != 0) goto L_0x0017
            java.lang.String r5 = "灰度测试没有广告"
            return r5
        L_0x0017:
            java.lang.String r0 = r5.getShowCount()     // Catch:{ Exception -> 0x0020 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0020 }
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            r1 = 0
            if (r0 > 0) goto L_0x0025
            return r1
        L_0x0025:
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.util.Locale r3 = java.util.Locale.getDefault()
            java.lang.String r4 = "yyyyMMdd"
            r2.<init>(r4, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.util.Calendar r4 = java.util.Calendar.getInstance()
            java.util.Date r4 = r4.getTime()
            java.lang.String r2 = r2.format(r4)
            r3.append(r2)
            java.lang.String r5 = r5.getAdUnitId()
            r3.append(r5)
            java.lang.String r5 = r3.toString()
            com.adp.sdk.utils.i r2 = new com.adp.sdk.utils.i
            r2.<init>(r6)
            int r5 = r2.a(r5)
            if (r5 < r0) goto L_0x005f
            java.lang.String r5 = "已经达到了当天展示的广告次数"
            return r5
        L_0x005f:
            return r1
        L_0x0060:
            java.lang.String r5 = "上下文或ad对象为空"
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adp.sdk.a.b(com.adp.sdk.dto.AdItem, android.content.Context):java.lang.String");
    }

    private static void a(String str, String str2, Context context, boolean z, AdInfoListener adInfoListener) {
        g.a(str2, (Map<String, String>) null, new b(context, z, adInfoListener, str, context));
    }

    private static boolean a(int i) {
        if (i < 1 || i > 100) {
            i = 100;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 100; i2++) {
            if (i2 < i) {
                arrayList.add("有广告");
            } else {
                arrayList.add("没有广告");
            }
        }
        Collections.shuffle(arrayList);
        return "有广告".equals(arrayList.get(new Random().nextInt(100)));
    }

    public static void a(AdItem adItem, Context context) {
        if (context != null && adItem != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
            String str = simpleDateFormat.format(Calendar.getInstance().getTime()) + adItem.getAdUnitId();
            new i(context).a(str, new i(context).a(str) + 1);
        }
    }
}
