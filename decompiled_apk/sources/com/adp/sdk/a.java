package com.adp.sdk;

import android.content.Context;
import android.util.Log;
import com.adp.sdk.dto.AdInfo;
import com.adp.sdk.dto.AdItem;
import com.adp.sdk.listener.AdInfoListener;
import com.adp.sdk.utils.GsonUtils;
import com.sma.smartv3.network.BaiDu;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;
import okhttp3.Call;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f4703a;
    protected static AdInfo b;

    /* renamed from: com.adp.sdk.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0092a extends com.adp.sdk.utils.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.adp.sdk.utils.d f4704a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0092a(Context context, com.adp.sdk.utils.d dVar) {
            super(context);
            this.f4704a = dVar;
        }

        @Override // com.adp.sdk.utils.f
        public void a(Call call, Exception exc) {
        }

        @Override // com.adp.sdk.utils.f
        public void a(Call call, String str) {
            try {
                String string = new JSONObject(str).getString("result");
                this.f4704a.a(BaiDu.SERVICE_ID_KEY, string);
                ADP.serviceId = string;
            } catch (Exception unused) {
            }
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str) {
        AdInfo adInfo;
        String str2;
        com.adp.sdk.utils.d dVar = new com.adp.sdk.utils.d(context);
        String b2 = dVar.b(BaiDu.SERVICE_ID_KEY, "");
        if ("".equals(b2) && (adInfo = b) != null && adInfo.isGetServiceId()) {
            if (b.getIdServer() != null && b.getIdServer().length() > 0) {
                str2 = b.getIdServer();
            } else {
                str2 = "http://adsplus.cn:8083/ad/serial/";
            }
            com.adp.sdk.utils.g.a(str2 + str, null, new C0092a(context, dVar));
            return;
        }
        ADP.serviceId = b2;
    }

    public static a a() {
        if (f4703a == null) {
            f4703a = new a();
        }
        return f4703a;
    }

    /* loaded from: classes.dex */
    public static class b extends com.adp.sdk.utils.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f4705a;
        final /* synthetic */ AdInfoListener b;
        final /* synthetic */ String c;
        final /* synthetic */ Context d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, boolean z, AdInfoListener adInfoListener, String str, Context context2) {
            super(context);
            this.f4705a = z;
            this.b = adInfoListener;
            this.c = str;
            this.d = context2;
        }

        @Override // com.adp.sdk.utils.f
        public void a(Call call, Exception exc) {
            AdInfoListener adInfoListener;
            if (ADP.DEBUGLOG) {
                Log.e("-----", "---error--" + exc.toString());
            }
            if (!this.f4705a || (adInfoListener = this.b) == null) {
                return;
            }
            adInfoListener.error("-1", exc.getMessage());
        }

        @Override // com.adp.sdk.utils.f
        public void a(Call call, String str) {
            AdInfoListener adInfoListener;
            AdInfoListener adInfoListener2;
            AdInfoListener adInfoListener3;
            try {
                AdInfo adInfo = (AdInfo) GsonUtils.GsonToBean(str, AdInfo.class);
                a.b = adInfo;
                if (this.c.equals(adInfo.getAppId()) && "0".equals(a.b.getStatus())) {
                    new com.adp.sdk.utils.d(this.d).a("ADINFO" + this.c, str);
                    if (this.f4705a && (adInfoListener3 = this.b) != null) {
                        adInfoListener3.onAdLoadOk(a.b.getTencent(), a.b.getBytedance(), a.b.getAppname(), a.b.getKuaishou());
                    }
                } else if (this.f4705a && (adInfoListener2 = this.b) != null) {
                    adInfoListener2.error(a.b.getStatus(), a.b.getDes());
                }
                a.b(this.d, this.c);
            } catch (Exception e) {
                e.printStackTrace();
                if (!this.f4705a || (adInfoListener = this.b) == null) {
                    return;
                }
                adInfoListener.error("-1", "Network error or AppId is invalid!");
            }
        }
    }

    public void a(String str, Context context, AdInfoListener adInfoListener) {
        AdInfo adInfo;
        com.adp.sdk.utils.d dVar = new com.adp.sdk.utils.d(context);
        String b2 = dVar.b("ADINFO" + str, "");
        boolean z = true;
        if ("".equals(b2)) {
            a(str, "https://adsplus.oss-accelerate.aliyuncs.com/" + str + ".json", context, true, adInfoListener);
            return;
        }
        try {
            adInfo = (AdInfo) GsonUtils.GsonToBean(b2, AdInfo.class);
            b = adInfo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (adInfo != null && "0".equals(adInfo.getStatus()) && str.equals(b.getAppId())) {
            String b3 = dVar.b(BaiDu.SERVICE_ID_KEY, "");
            if (!"".equals(b3)) {
                ADP.serviceId = b3;
            }
            adInfoListener.onAdLoadOk(b.getTencent(), b.getBytedance(), b.getAppname(), b.getKuaishou());
            z = false;
        }
        a(str, "https://adsplus.oss-accelerate.aliyuncs.com/" + str + ".json", context, z, adInfoListener);
    }

    public static String b(AdItem adItem, Context context) {
        int i;
        if (context == null || adItem == null) {
            return "上下文或ad对象为空";
        }
        try {
            if (!a(Integer.parseInt(adItem.getRate()))) {
                return "灰度测试没有广告";
            }
        } catch (Exception unused) {
        }
        try {
            i = Integer.parseInt(adItem.getShowCount());
        } catch (Exception unused2) {
            i = 0;
        }
        if (i <= 0) {
            return null;
        }
        if (new com.adp.sdk.utils.i(context).a(new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(Calendar.getInstance().getTime()) + adItem.getAdUnitId()) >= i) {
            return "已经达到了当天展示的广告次数";
        }
        return null;
    }

    private static void a(String str, String str2, Context context, boolean z, AdInfoListener adInfoListener) {
        com.adp.sdk.utils.g.a(str2, null, new b(context, z, adInfoListener, str, context));
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
        if (context == null || adItem == null) {
            return;
        }
        String str = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(Calendar.getInstance().getTime()) + adItem.getAdUnitId();
        new com.adp.sdk.utils.i(context).a(str, new com.adp.sdk.utils.i(context).a(str) + 1);
    }
}
