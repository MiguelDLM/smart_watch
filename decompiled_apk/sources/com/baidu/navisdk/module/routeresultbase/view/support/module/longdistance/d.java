package com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.http.center.i;
import com.baidu.navisdk.util.http.center.l;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.baidu.nplatform.comapi.MapItem;
import com.garmin.fit.X0xOO;
import com.huawei.openalliance.ad.constant.x;
import com.kuaishou.weapon.p0.t;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import o0oIxXOx.XIxXXX0x0;
import o0oIxXOx.oO;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7528a;
    private f b;
    private InterfaceC0291d c;
    private final com.baidu.navisdk.util.worker.loop.a d;

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.a {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            if (message != null && message.what == 291) {
                if (message.arg1 == 0) {
                    LogUtil.e("LongDistanceController", "mFetchWeatherHandler: RET_OK --> ");
                    if (d.this.c != null) {
                        d.this.c.a(d.this.b);
                    }
                } else {
                    LogUtil.e("LongDistanceController", "mFetchWeatherHandler: RET_ERR --> " + message.arg1);
                    f fVar = new f(d.this);
                    fVar.f7533a = message.arg1;
                    if (d.this.c != null) {
                        d.this.c.a(fVar);
                    }
                }
                d.this.f7528a = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements CmdGeneralHttpRequestFunc.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7530a;
        final /* synthetic */ String b;

        public b(String str, String str2) {
            this.f7530a = str;
            this.b = str2;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public void a(byte[] bArr) {
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public List<l> getRequestParams() {
            ArrayList arrayList = new ArrayList();
            StringBuffer stringBuffer = new StringBuffer();
            try {
                arrayList.add(new i("cuid", a0.e()));
                stringBuffer.append("cuid=" + l0.b(a0.e()));
                arrayList.add(new i(oO.f31192XO, "2"));
                stringBuffer.append("&os=2");
                arrayList.add(new i("osv", a0.b));
                stringBuffer.append("&osv=" + l0.b(a0.b));
                arrayList.add(new i("sv", a0.c));
                stringBuffer.append("&sv=" + l0.b(a0.c));
                arrayList.add(new i(t.r, VDeviceAPI.getAppPackageName()));
                stringBuffer.append("&pcn=" + l0.b(VDeviceAPI.getAppPackageName()));
                arrayList.add(new i("mb", VDeviceAPI.getPhoneType()));
                stringBuffer.append("&mb=" + l0.b(VDeviceAPI.getPhoneType()));
                arrayList.add(new i(MapItem.KEY_ITEM_SID, "1"));
                stringBuffer.append("&sid=1");
                int c = com.baidu.navisdk.model.a.g().c();
                String str = "";
                if (c != Integer.MIN_VALUE) {
                    arrayList.add(new i("cityid", "" + c));
                    stringBuffer.append("&cityid=" + c);
                }
                Bundle bundle = new Bundle();
                BNRoutePlaner.getInstance().c(bundle);
                String string = bundle.getString("session");
                if (string != null) {
                    arrayList.add(new i("session_id", string));
                    stringBuffer.append("&session_id=" + l0.b(string));
                } else {
                    LogUtil.e("LongDistanceController", "fetchWeather: sessionId --> " + string);
                }
                arrayList.add(new i("city_list", this.f7530a));
                stringBuffer.append("&city_list=" + l0.b(this.f7530a));
                arrayList.add(new i("eta_list", this.b));
                stringBuffer.append("&eta_list=" + l0.b(this.b));
                com.baidu.navisdk.util.http.a.a(arrayList);
                String urlParamsSign = JNITrajectoryControl.sInstance.getUrlParamsSign(com.baidu.navisdk.module.cloudconfig.d.a(arrayList));
                if (!TextUtils.isEmpty(urlParamsSign)) {
                    str = urlParamsSign;
                }
                arrayList.add(new i(HttpConstants.SIGN, str));
                stringBuffer.append("&sign=" + URLEncoder.encode(str, "utf-8"));
                LogUtil.e("LongDistanceController", "fetchWeather: --> " + ((Object) stringBuffer));
                return arrayList;
            } catch (UnsupportedEncodingException unused) {
                LogUtil.e("LongDistanceController", "fetchWeather: --> UnsupportedEncodingException");
                return null;
            }
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public int getRequestType() {
            return 1;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public String getUrl() {
            return com.baidu.navisdk.util.http.b.d().b("GetWeather");
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public boolean parseResponseJSON(JSONObject jSONObject) {
            return d.this.a(jSONObject);
        }
    }

    /* loaded from: classes7.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public int f7531a;
        public String b;
        public String c;
        public String d;
        public String e;
        public boolean f;

        public c(d dVar) {
        }

        public String toString() {
            return "CityWeather{cityId=" + this.f7531a + ", cityName='" + this.b + ", weather='" + this.c + ", temperature='" + this.d + ", iconUrl='" + this.e + ", alarm=" + this.f + '}';
        }
    }

    /* renamed from: com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.d$d, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0291d {
        void a(f fVar);
    }

    /* loaded from: classes7.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private static final d f7532a = new d(null);
    }

    /* loaded from: classes7.dex */
    public class f {

        /* renamed from: a, reason: collision with root package name */
        public int f7533a = Integer.MIN_VALUE;
        public String b = null;
        public int c = 0;
        public SparseArray<c> d = null;

        public f(d dVar) {
        }

        public String toString() {
            return "WeatherData{errno=" + this.f7533a + ", errmsg='" + this.b + ", date=" + this.c + ", weatherMap=" + this.d + '}';
        }
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    private d() {
        this.f7528a = false;
        this.b = null;
        this.c = null;
        this.d = new a("LDC");
    }

    public static d a() {
        return e.f7532a;
    }

    public synchronized void a(String str, String str2, InterfaceC0291d interfaceC0291d) {
        LogUtil.e("LongDistanceController", "fetchWeather: --> mIsFetchingWeather: " + this.f7528a + ", cityList: " + str);
        if (!this.f7528a && !TextUtils.isEmpty(str)) {
            this.f7528a = true;
            this.c = interfaceC0291d;
            com.baidu.navisdk.cmdrequest.i iVar = new com.baidu.navisdk.cmdrequest.i(com.baidu.navisdk.cmdrequest.c.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, this.d, X0xOO.f13580O0OOX0IIx, 3000);
            CmdGeneralHttpRequestFunc.a(iVar, new b(str, str2));
            com.baidu.navisdk.cmdrequest.b.a().a(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            LogUtil.e("LongDistanceController", "parseFetchWeatherJson: --> " + jSONObject);
            f fVar = new f(this);
            try {
                fVar.f7533a = jSONObject.optInt("errno");
                fVar.b = jSONObject.optString("errmsg");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("LongDistanceController", "parseFetchWeatherJson --> dataJson = " + optJSONObject);
                }
                if (optJSONObject != null) {
                    if (optJSONObject.has(XIxXXX0x0.f31178xoIox)) {
                        fVar.c = optJSONObject.optInt(XIxXXX0x0.f31178xoIox);
                    }
                    if (optJSONObject.has("list")) {
                        JSONArray jSONArray = optJSONObject.getJSONArray("list");
                        fVar.d = new SparseArray<>();
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("LongDistanceController", "parseFetchWeatherJson --> list = " + jSONArray);
                        }
                        if (jSONArray == null) {
                            return false;
                        }
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject optJSONObject2 = jSONArray.optJSONObject(i);
                            if (LogUtil.LOGGABLE) {
                                LogUtil.e("LongDistanceController", "parseFetchWeatherJson --> item = " + optJSONObject2);
                            }
                            if (optJSONObject2 != null) {
                                c cVar = new c(this);
                                cVar.f7531a = optJSONObject2.optInt("id");
                                if (optJSONObject2.has("city")) {
                                    cVar.b = optJSONObject2.optString("city");
                                }
                                cVar.c = optJSONObject2.optString("weather");
                                cVar.d = optJSONObject2.optString("temp");
                                cVar.f = optJSONObject2.optInt("critical") == 1;
                                cVar.e = optJSONObject2.optString(x.cD);
                                fVar.d.put(cVar.f7531a, cVar);
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                LogUtil.e("LongDistanceController", "parseFetchWeatherJson: Exception --> " + e2.getMessage());
            }
            this.b = fVar;
            if (LogUtil.LOGGABLE) {
                LogUtil.e("LongDistanceController", "parseFetchWeatherJson --> weatherData = " + fVar);
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }
}
