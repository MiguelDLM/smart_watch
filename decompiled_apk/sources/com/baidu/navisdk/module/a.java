package com.baidu.navisdk.module;

import XXO0.oIX0oI;
import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpPostFunc;
import com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.cmdrequest.j;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.trajectory.k;
import com.baidu.navisdk.framework.interfaces.pronavi.n;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.b;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.common.v;
import com.baidu.navisdk.util.common.x;
import com.baidu.navisdk.util.common.y;
import com.baidu.navisdk.util.http.center.i;
import com.baidu.navisdk.util.http.center.l;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.voicesquare.interfaces.VoiceInterfaceImplProxy;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.realsil.sdk.dfu.image.constants.SubBinId;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import o0oIxXOx.oO;
import org.apache.log4j.oOoXoXO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {
    private static final Object o = new Object();
    private static a p;
    private com.baidu.navisdk.model.modelfactory.f h;
    private long i;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Handler> f6955a = null;
    private int b = -1;
    private Handler c = null;
    private int d = -1;
    private Handler e = null;
    private int f = -1;
    private com.baidu.navisdk.model.modelfactory.b g = null;
    private final Handler j = new f("BAM");
    private final Runnable k = new g();
    public boolean l = false;
    private boolean m = false;
    public boolean n = false;

    /* loaded from: classes7.dex */
    public class b implements CmdGeneralHttpRequestFunc.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6956a;

        public b(int i) {
            this.f6956a = i;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public void a(byte[] bArr) {
            if (bArr != null) {
                LogUtil.e("BusinessActivityManager", "responseImage() what=" + this.f6956a);
                int i = this.f6956a;
                if (i != 1538) {
                    switch (i) {
                        case 1510:
                            a.this.g.n = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                            com.baidu.navisdk.module.business.c.a(a.this.g.m, "", bArr);
                            return;
                        case 1511:
                            a.this.g.p = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                            com.baidu.navisdk.module.business.c.a(a.this.g.o, "", bArr);
                            return;
                        case 1512:
                            a.this.g.x = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                            com.baidu.navisdk.module.business.c.a(a.this.g.w, "", bArr);
                            return;
                        case 1513:
                            a.this.g.F = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                            com.baidu.navisdk.module.business.c.a(a.this.g.E, "", bArr);
                            return;
                        default:
                            switch (i) {
                                case 1530:
                                    a.this.g.L = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                                    com.baidu.navisdk.module.business.c.a(a.this.g.G, "", bArr);
                                    return;
                                case 1531:
                                    a.this.g.M = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                                    com.baidu.navisdk.module.business.c.a(a.this.g.H, "", bArr);
                                    return;
                                case 1532:
                                    a.this.g.N = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                                    com.baidu.navisdk.module.business.c.a(a.this.g.I, "", bArr);
                                    return;
                                case 1533:
                                    a.this.g.P = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                                    com.baidu.navisdk.module.business.c.a(a.this.g.K, "", bArr);
                                    return;
                                case 1534:
                                    a.this.g.O = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                                    com.baidu.navisdk.module.business.c.a(a.this.g.J, "", bArr);
                                    return;
                                default:
                                    return;
                            }
                    }
                }
                a.this.g.e0 = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                com.baidu.navisdk.module.business.c.a(a.this.g.d0, "", bArr);
            }
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public List<l> getRequestParams() {
            return null;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public int getRequestType() {
            return 2;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public String getUrl() {
            if (a.this.g != null) {
                int i = this.f6956a;
                if (i != 1538) {
                    switch (i) {
                        case 1510:
                            return a.this.g.m;
                        case 1511:
                            return a.this.g.o;
                        case 1512:
                            return a.this.g.w;
                        case 1513:
                            return a.this.g.E;
                        default:
                            switch (i) {
                                case 1530:
                                    return a.this.g.G;
                                case 1531:
                                    return a.this.g.H;
                                case 1532:
                                    return a.this.g.I;
                                case 1533:
                                    return a.this.g.K;
                                case 1534:
                                    return a.this.g.J;
                                default:
                                    return null;
                            }
                    }
                }
                return a.this.g.d0;
            }
            return null;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public boolean parseResponseJSON(JSONObject jSONObject) {
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements CmdGeneralHttpRequestFunc.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6957a;

        public c(int i) {
            this.f6957a = i;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public void a(byte[] bArr) {
            if (bArr != null) {
                LogUtil.e("BusinessActivityManager", "responseImage() audio. what=" + this.f6957a);
                int i = this.f6957a;
                if (i != 1535) {
                    switch (i) {
                        case 1514:
                            a.this.g.g = com.baidu.navisdk.module.business.c.a(a.this.g.f, "", bArr);
                            return;
                        case 1515:
                            a.this.g.i = com.baidu.navisdk.module.business.c.a(a.this.g.h, "", bArr);
                            return;
                        case 1516:
                            a.this.g.u = com.baidu.navisdk.module.business.c.a(a.this.g.t, "", bArr);
                            return;
                        default:
                            return;
                    }
                }
                a.this.g.R = com.baidu.navisdk.module.business.c.a(a.this.g.Q, "", bArr);
            }
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public List<l> getRequestParams() {
            return null;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public int getRequestType() {
            return 2;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public String getUrl() {
            if (a.this.g != null) {
                int i = this.f6957a;
                if (i != 1535) {
                    switch (i) {
                        case 1514:
                            return a.this.g.f;
                        case 1515:
                            return a.this.g.h;
                        case 1516:
                            return a.this.g.t;
                        default:
                            return null;
                    }
                }
                return a.this.g.Q;
            }
            return null;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public boolean parseResponseJSON(JSONObject jSONObject) {
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public class f extends com.baidu.navisdk.util.worker.loop.a {
        public f(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            String str;
            String str2;
            LogUtil.e("BusinessActivityManager", "BusinessActivityManager onMessage , msg.what = " + message.what);
            int i = message.what;
            String str3 = null;
            Handler handler = null;
            if (1500 == i) {
                if (message.arg1 == 0) {
                    LogUtil.e("BusinessActivityManager", "handleMessage(): --> MSG_BUSINESSACTIVITY_REQUEST_RET");
                    if (a.this.f6955a != null) {
                        handler = (Handler) a.this.f6955a.get();
                    }
                    if (handler != null) {
                        handler.sendEmptyMessage(a.this.b);
                    }
                    if (a.this.g != null && a.this.g.f6946a == 0) {
                        if (a.this.g.c0 > 0) {
                            post(a.this.k);
                        }
                        a.this.l();
                        if (a.this.g.S > 0) {
                            Bundle bundle = new Bundle();
                            bundle.putInt("diffdist", a.this.g.S);
                            bundle.putInt("max_enve_count", a.this.g.T);
                            JNITrajectoryControl jNITrajectoryControl = JNITrajectoryControl.sInstance;
                            jNITrajectoryControl.checkNaviDistForBusiness(jNITrajectoryControl.getCurrentUUID(), bundle);
                            return;
                        }
                        return;
                    }
                    if (LogUtil.LOGGABLE) {
                        if (a.this.g == null) {
                            LogUtil.e("BusinessActivityManager", "onMessage: error --> model = null");
                            return;
                        }
                        LogUtil.e("BusinessActivityManager", "onMessage: error --> errno: " + a.this.g.f6946a + ", uploadMileageInter: " + a.this.g.c0);
                        return;
                    }
                    return;
                }
                return;
            }
            if (1620 == i) {
                if (a.this.g != null) {
                    a.this.g.g();
                    return;
                }
                return;
            }
            if (1621 == i) {
                com.baidu.navisdk.module.business.b.d().a(com.baidu.navisdk.framework.a.c().a(), false);
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "测试超时触发商业水滴显示");
                return;
            }
            if (1510 == i) {
                a.this.b(1511);
                return;
            }
            if (1511 == i) {
                a.this.b(1512);
                return;
            }
            if (1512 == i) {
                a.this.b(1513);
                return;
            }
            if (1513 == i) {
                a.this.a(1516);
                return;
            }
            if (1514 == i) {
                a.this.b(1510);
                com.baidu.navisdk.module.business.a.e().c();
                return;
            }
            if (1515 == i) {
                a.this.b(1530);
                return;
            }
            if (1516 == i) {
                a.this.a(1515);
                return;
            }
            if (1530 == i) {
                a.this.b(1531);
                return;
            }
            if (1531 == i) {
                a.this.b(1532);
                return;
            }
            if (1532 == i) {
                a.this.b(1533);
                return;
            }
            if (1533 == i) {
                a.this.b(1534);
                return;
            }
            if (1534 == i) {
                a.this.a(1535);
                return;
            }
            if (1535 == i) {
                a.this.b(SubBinId.Bbpro.DSP_APP_IMAGE);
                return;
            }
            if (1538 == i) {
                LogUtil.e("BusinessActivityManager", "reuqest completed.");
                return;
            }
            if (1501 != i) {
                if (1502 == i) {
                    if (a.this.c != null) {
                        a.this.c.obtainMessage(a.this.d).sendToTarget();
                        return;
                    }
                    return;
                }
                if (1503 == i) {
                    if (a.this.e != null) {
                        a.this.e.obtainMessage(a.this.f).sendToTarget();
                        return;
                    }
                    return;
                }
                if (1700 == i) {
                    LogUtil.e("BusinessActivityManager", "safety MSG_NAV_SAFETY_SHARE_START  --> msg.arg1: " + message.arg1);
                    n n = x.n();
                    if (n != null) {
                        n.h();
                    }
                    if (com.baidu.navisdk.framework.a.c().b() == null) {
                        LogUtil.e("BusinessActivityManager", "safety MSG_NAV_SAFETY_SHARE_START  --> getOuterActivity == null ");
                        return;
                    }
                    if (com.baidu.navisdk.framework.interfaces.c.p().i() != null) {
                        com.baidu.navisdk.framework.interfaces.c.p().i().e0();
                    }
                    if (message.arg1 == 0) {
                        try {
                            j jVar = (j) message.obj;
                            if (jVar != null) {
                                Object obj = jVar.b;
                                JSONObject jSONObject = (JSONObject) obj;
                                if (jSONObject != null) {
                                    int i2 = ((JSONObject) obj).getInt("errno");
                                    String string = ((JSONObject) jVar.b).getString("share_url");
                                    if (jSONObject.has("share_icon")) {
                                        str = ((JSONObject) jVar.b).getString("share_icon");
                                    } else {
                                        str = null;
                                    }
                                    if (jSONObject.has("share_title")) {
                                        str2 = ((JSONObject) jVar.b).getString("share_title");
                                    } else {
                                        str2 = null;
                                    }
                                    if (jSONObject.has("share_desc")) {
                                        str3 = ((JSONObject) jVar.b).getString("share_desc");
                                    }
                                    LogUtil.e("BusinessActivityManager", "safety  --> jSONObject: " + jSONObject);
                                    if (i2 == 0 && !l0.c(string)) {
                                        a.h().a(string, str, str2, str3);
                                        return;
                                    }
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if (!a.this.l) {
                        TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "分享请求失败,请稍后重试");
                        return;
                    }
                    return;
                }
                if (1701 == i) {
                    LogUtil.e("BusinessActivityManager", "safety MSG_NAV_SAFETY_SHARE_END  --> msg.arg1: " + message.arg1);
                    return;
                }
                if (1702 == i) {
                    LogUtil.e("BusinessActivityManager", "safety MSG_NAV_SAFETY_SHARE_CHANGE  --> msg.arg1: " + message.arg1);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String currentUUID = JNITrajectoryControl.sInstance.getCurrentUUID();
            if (currentUUID != null && currentUUID.length() > 0) {
                long trajectoryLength = JNITrajectoryControl.sInstance.getTrajectoryLength(currentUUID);
                if (com.baidu.navisdk.module.vehiclemanager.b.i().h()) {
                    com.baidu.navisdk.module.trucknavi.b.b().a(trajectoryLength, x.p());
                }
                if (a.this.g != null) {
                    if (trajectoryLength - a.this.i >= a.this.g.c0) {
                        if (LogUtil.LOGGABLE) {
                            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "导航中: 里程差: " + (trajectoryLength - a.this.i));
                        }
                        try {
                            Bundle bundle = new Bundle();
                            int postParamsForNavingUpload = JNITrajectoryControl.sInstance.getPostParamsForNavingUpload(currentUUID, bundle);
                            if (postParamsForNavingUpload != -1) {
                                a.this.g.n0 = bundle;
                                a aVar = a.this;
                                aVar.a(aVar.j, 100);
                                a.this.i = trajectoryLength;
                            } else {
                                if (LogUtil.LOGGABLE) {
                                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "导航中: getPostParams Error!");
                                    LogUtil.e("BusinessActivityManager", "mUploadMileaRunnable: getPostParamsForNavingUpload ret: " + postParamsForNavingUpload);
                                }
                                com.baidu.navisdk.util.statistic.userop.b.r().a("8.2.b", "2", null, "4");
                            }
                        } catch (Exception e) {
                            if (LogUtil.LOGGABLE) {
                                LogUtil.printException("mUploadMileaRunnable error:", e);
                            }
                            com.baidu.navisdk.util.statistic.userop.b.r().a("8.2.b", "2", null, "3");
                        }
                    } else {
                        LogUtil.e("BusinessActivityManager", "mUploadMileaRunnable: uuid: " + currentUUID + ", curMilea: " + trajectoryLength + ", mLastMilea: " + a.this.i + ", uploadMileageInter: " + a.this.g.c0);
                    }
                } else {
                    com.baidu.navisdk.util.statistic.userop.b.r().a("8.2.b", "2", null, "5");
                }
            } else {
                if (LogUtil.LOGGABLE) {
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "导航中: uuid Error!");
                    LogUtil.e("BusinessActivityManager", "mUploadMileaRunnable: uuid: " + currentUUID);
                }
                com.baidu.navisdk.util.statistic.userop.b.r().a("8.2.b", "2", null, "1");
            }
            a.this.j.postDelayed(a.this.k, 10000L);
        }
    }

    /* loaded from: classes7.dex */
    public class h implements CmdGeneralHttpPostFunc.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6962a;

        public h(int i) {
            this.f6962a = i;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpPostFunc.a
        public List<l> getRequestParams() {
            double d;
            double d2;
            double d3;
            double d4;
            com.baidu.navisdk.model.datastruct.g a2;
            double d5;
            double d6;
            String str = "";
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new i("cuid", a0.e()));
                arrayList.add(new i(oO.f31192XO, "0"));
                int i = this.f6962a;
                if (i == 0 || i == 2) {
                    RoutePlanNode o = a.this.h.o();
                    RoutePlanNode g = a.this.h.g();
                    if (o != null) {
                        d = o.mGeoPoint.getLongitudeE6() / 100000.0d;
                        d2 = o.mGeoPoint.getLatitudeE6() / 100000.0d;
                    } else {
                        d = -1.0d;
                        d2 = -1.0d;
                    }
                    if (g != null) {
                        double longitudeE6 = g.mGeoPoint.getLongitudeE6() / 100000.0d;
                        d4 = g.mGeoPoint.getLatitudeE6() / 100000.0d;
                        d3 = longitudeE6;
                    } else {
                        d3 = -1.0d;
                        d4 = -1.0d;
                    }
                    arrayList.add(new i("from_point", d + "," + d2));
                    arrayList.add(new i("to_point", d3 + "," + d4));
                    Bundle bundle = new Bundle();
                    BNRoutePlaner.getInstance().c(bundle);
                    String string = bundle.getString("session");
                    String string2 = bundle.getString("mrsl");
                    arrayList.add(new i("session_id", string));
                    arrayList.add(new i("mrsl", string2));
                }
                arrayList.add(new i("osv", "" + a0.i()));
                arrayList.add(new i("sv", a0.k()));
                arrayList.add(new i("action", "" + this.f6962a));
                if (com.baidu.navisdk.util.logic.g.j().h()) {
                    a2 = com.baidu.navisdk.util.logic.g.j().d();
                } else {
                    a2 = com.baidu.navisdk.util.logic.a.j().a();
                }
                if (a2 != null) {
                    d5 = a2.b;
                    d6 = a2.f6926a;
                } else {
                    d5 = -1.0d;
                    d6 = -1.0d;
                }
                arrayList.add(new i("current_point", d5 + "," + d6));
                com.baidu.navisdk.util.http.a.a(arrayList);
                String a3 = com.baidu.navisdk.module.cloudconfig.d.a(arrayList);
                String urlParamsSign = JNITrajectoryControl.sInstance.getUrlParamsSign(a3);
                if (!TextUtils.isEmpty(urlParamsSign)) {
                    str = urlParamsSign;
                }
                arrayList.add(new i(HttpConstants.SIGN, str));
                LogUtil.e("BusinessActivityManager", "safetyUpload() uploadPs=" + a3);
                return arrayList;
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpPostFunc.a
        public int getRequestType() {
            return 1;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpPostFunc.a
        public String getUrl() {
            return com.baidu.navisdk.util.http.b.d().b("tuanyuan");
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpPostFunc.a
        public boolean parseResponseJSON(JSONObject jSONObject) {
            return true;
        }
    }

    private a() {
        this.h = null;
        this.h = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
    }

    /* renamed from: com.baidu.navisdk.module.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0212a extends com.baidu.navisdk.util.http.center.f {
        public C0212a(a aVar) {
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BusinessActivityManager", "uploadVoiceData,onFailure, statusCode:" + i + ",responseString:" + str);
            }
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BusinessActivityManager", "uploadVoiceData,onSuccess, statusCode:" + i + ",responseString:" + str);
            }
        }
    }

    private String f() {
        if (com.baidu.navisdk.module.vehiclemanager.b.i().b() != 1) {
            return null;
        }
        return com.baidu.navisdk.module.routeresult.logic.plate.a.b().b(com.baidu.navisdk.module.vehiclemanager.b.i().a()).l;
    }

    private com.baidu.navisdk.comapi.trajectory.h g() {
        com.baidu.navisdk.comapi.trajectory.h hVar;
        if (com.baidu.navisdk.module.vehiclemanager.b.i().d()) {
            hVar = com.baidu.navisdk.comapi.trajectory.h.MOTOR;
        } else if (com.baidu.navisdk.module.vehiclemanager.b.i().h()) {
            hVar = com.baidu.navisdk.comapi.trajectory.h.TRUCK;
        } else {
            hVar = com.baidu.navisdk.comapi.trajectory.h.CAR;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BusinessActivityManager", "getCarType,carType:" + hVar);
        }
        return hVar;
    }

    public static a h() {
        if (p == null) {
            synchronized (o) {
                try {
                    if (p == null) {
                        p = new a();
                    }
                } finally {
                }
            }
        }
        return p;
    }

    private int i() {
        com.baidu.navisdk.framework.interfaces.commute.b e2 = com.baidu.navisdk.framework.interfaces.c.p().e();
        if (e2 != null && e2.d()) {
            return 2;
        }
        int l = x.l();
        if (3 == l) {
            return 3;
        }
        if (7 == l) {
            return 4;
        }
        return com.baidu.navisdk.module.pronavi.a.v ? 1 : 0;
    }

    private List<l> j() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(new i("cuid", a0.e() + ""));
            VoiceInterfaceImplProxy o2 = com.baidu.navisdk.framework.interfaces.c.p().o();
            String currentVoice = o2 != null ? o2.getCurrentVoice() : "";
            arrayList.add(new i("voice_id", currentVoice));
            StringBuffer stringBuffer = new StringBuffer();
            try {
                stringBuffer.append(URLEncoder.encode(a0.e() + "", "utf-8"));
                stringBuffer.append(URLEncoder.encode(currentVoice + "", "utf-8"));
                stringBuffer.append("04ddebf63cf72ei5c5b272f285161e3b");
            } catch (Exception e2) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BusinessActivityManager", "getUploadVoiceDataRequestParams,ascendParams:" + ((Object) stringBuffer) + ",e:" + e2);
                }
            }
            String a2 = a(stringBuffer.toString());
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BusinessActivityManager", "getUploadVoiceDataRequestParams,ascendParams:" + ((Object) stringBuffer) + ",signStr:" + a2);
            }
            arrayList.add(new i(HttpConstants.SIGN, a2));
            if (LogUtil.LOGGABLE) {
                for (int i = 0; i < arrayList.size(); i++) {
                    LogUtil.e("BusinessActivityManager", "getUploadVoiceDataRequestParams---> (" + ((l) arrayList.get(i)).a() + "," + ((l) arrayList.get(i)).b() + oIX0oI.I0Io.f4095I0Io);
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    private boolean k() {
        String str;
        if (!com.baidu.navisdk.framework.b.e0()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BusinessActivityManager", "用户未登陆");
            }
            return false;
        }
        VoiceInterfaceImplProxy o2 = com.baidu.navisdk.framework.interfaces.c.p().o();
        if (o2 != null) {
            str = o2.getCurrentVoice();
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BusinessActivityManager", "isNeedUploadVoiceData,非个性化语音");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        a(1514);
    }

    public void c() {
        if (this.g == null) {
            return;
        }
        h().a().f();
        h().a().e();
        h().a().s0 = -1;
        com.baidu.navisdk.module.business.b.d().a();
    }

    public void d() {
        LogUtil.e("BusinessActivityManager", "stopMileageCheck:  --> ");
        Handler handler = this.j;
        if (handler != null) {
            handler.removeCallbacks(this.k);
        }
    }

    public void e() {
        if (k()) {
            try {
                com.baidu.navisdk.util.http.center.b.a().a(com.baidu.navisdk.util.http.b.d().a("upload_on_voice_package_download_complete"), com.baidu.navisdk.util.http.center.c.a(j()), new C0212a(this), new com.baidu.navisdk.util.http.center.e());
            } catch (Throwable th) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("uploadVoiceData", "error:" + th);
                }
            }
        }
    }

    public void b(int i) {
        com.baidu.navisdk.model.modelfactory.b bVar = this.g;
        if (bVar == null) {
            return;
        }
        if (i != 1538) {
            switch (i) {
                case 1510:
                    if (TextUtils.isEmpty(bVar.m)) {
                        b(1511);
                        return;
                    }
                    com.baidu.navisdk.model.modelfactory.b bVar2 = this.g;
                    bVar2.n = com.baidu.navisdk.module.business.c.b(bVar2.m, "");
                    if (this.g.n != null) {
                        b(1511);
                        return;
                    }
                    break;
                case 1511:
                    if (TextUtils.isEmpty(bVar.o)) {
                        b(1512);
                        return;
                    }
                    com.baidu.navisdk.model.modelfactory.b bVar3 = this.g;
                    bVar3.p = com.baidu.navisdk.module.business.c.b(bVar3.o, "");
                    if (this.g.p != null) {
                        b(1512);
                        return;
                    }
                    break;
                case 1512:
                    if (TextUtils.isEmpty(bVar.w)) {
                        b(1513);
                        return;
                    }
                    com.baidu.navisdk.model.modelfactory.b bVar4 = this.g;
                    bVar4.x = com.baidu.navisdk.module.business.c.b(bVar4.w, "");
                    if (this.g.x != null) {
                        b(1513);
                        return;
                    }
                    break;
                case 1513:
                    if (TextUtils.isEmpty(bVar.E)) {
                        a(1516);
                        return;
                    }
                    com.baidu.navisdk.model.modelfactory.b bVar5 = this.g;
                    bVar5.F = com.baidu.navisdk.module.business.c.b(bVar5.E, "");
                    if (this.g.F != null) {
                        a(1516);
                        return;
                    }
                    break;
                default:
                    switch (i) {
                        case 1530:
                            if (TextUtils.isEmpty(bVar.G)) {
                                b(1531);
                                return;
                            }
                            com.baidu.navisdk.model.modelfactory.b bVar6 = this.g;
                            bVar6.L = com.baidu.navisdk.module.business.c.b(bVar6.G, "");
                            if (this.g.L != null) {
                                b(1531);
                                return;
                            }
                            break;
                        case 1531:
                            if (TextUtils.isEmpty(bVar.H)) {
                                b(1532);
                                return;
                            }
                            com.baidu.navisdk.model.modelfactory.b bVar7 = this.g;
                            bVar7.M = com.baidu.navisdk.module.business.c.b(bVar7.H, "");
                            if (this.g.M != null) {
                                b(1532);
                                return;
                            }
                            break;
                        case 1532:
                            if (TextUtils.isEmpty(bVar.I)) {
                                b(1533);
                                return;
                            }
                            com.baidu.navisdk.model.modelfactory.b bVar8 = this.g;
                            bVar8.N = com.baidu.navisdk.module.business.c.b(bVar8.I, "");
                            if (this.g.N != null) {
                                b(1533);
                                return;
                            }
                            break;
                        case 1533:
                            if (TextUtils.isEmpty(bVar.K)) {
                                b(1534);
                                return;
                            }
                            com.baidu.navisdk.model.modelfactory.b bVar9 = this.g;
                            bVar9.P = com.baidu.navisdk.module.business.c.b(bVar9.K, "");
                            if (this.g.P != null) {
                                b(1534);
                                return;
                            }
                            break;
                        case 1534:
                            if (TextUtils.isEmpty(bVar.J)) {
                                a(1535);
                                return;
                            }
                            com.baidu.navisdk.model.modelfactory.b bVar10 = this.g;
                            bVar10.O = com.baidu.navisdk.module.business.c.b(bVar10.J, "");
                            if (this.g.O != null) {
                                a(1535);
                                return;
                            }
                            break;
                        default:
                            return;
                    }
            }
        } else {
            if (TextUtils.isEmpty(bVar.d0)) {
                return;
            }
            com.baidu.navisdk.model.modelfactory.b bVar11 = this.g;
            bVar11.e0 = com.baidu.navisdk.module.business.c.b(bVar11.d0, "");
            if (this.g.e0 != null) {
                return;
            }
        }
        if (this.g != null) {
            com.baidu.navisdk.cmdrequest.i iVar = new com.baidu.navisdk.cmdrequest.i(com.baidu.navisdk.cmdrequest.c.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, this.j, i, 10000);
            CmdGeneralHttpRequestFunc.a(iVar, new b(i));
            com.baidu.navisdk.cmdrequest.b.a().a(iVar);
        }
    }

    public com.baidu.navisdk.model.modelfactory.b a() {
        if (this.g == null) {
            this.g = new com.baidu.navisdk.model.modelfactory.b();
        }
        return this.g;
    }

    public void a(int i) {
        com.baidu.navisdk.model.modelfactory.b bVar = this.g;
        if (bVar == null) {
            return;
        }
        if (i != 1535) {
            switch (i) {
                case 1514:
                    if (TextUtils.isEmpty(bVar.f)) {
                        b(1510);
                        com.baidu.navisdk.module.business.a.e().c();
                        return;
                    }
                    com.baidu.navisdk.model.modelfactory.b bVar2 = this.g;
                    bVar2.g = com.baidu.navisdk.module.business.c.a(bVar2.f, "");
                    if (!TextUtils.isEmpty(this.g.g)) {
                        b(1510);
                        com.baidu.navisdk.module.business.a.e().c();
                        return;
                    }
                    break;
                case 1515:
                    if (TextUtils.isEmpty(bVar.h)) {
                        b(1530);
                        return;
                    }
                    com.baidu.navisdk.model.modelfactory.b bVar3 = this.g;
                    bVar3.i = com.baidu.navisdk.module.business.c.a(bVar3.h, "");
                    if (!TextUtils.isEmpty(this.g.i)) {
                        b(1530);
                        return;
                    }
                    break;
                case 1516:
                    if (TextUtils.isEmpty(bVar.t)) {
                        a(1515);
                        return;
                    }
                    com.baidu.navisdk.model.modelfactory.b bVar4 = this.g;
                    bVar4.u = com.baidu.navisdk.module.business.c.a(bVar4.t, "");
                    if (!TextUtils.isEmpty(this.g.u)) {
                        a(1515);
                        return;
                    }
                    break;
                default:
                    return;
            }
        } else {
            if (TextUtils.isEmpty(bVar.Q)) {
                b(SubBinId.Bbpro.DSP_APP_IMAGE);
                return;
            }
            com.baidu.navisdk.model.modelfactory.b bVar5 = this.g;
            bVar5.R = com.baidu.navisdk.module.business.c.a(bVar5.Q, "");
            if (!TextUtils.isEmpty(this.g.R)) {
                b(SubBinId.Bbpro.DSP_APP_IMAGE);
                return;
            }
        }
        if (this.g != null) {
            com.baidu.navisdk.cmdrequest.i iVar = new com.baidu.navisdk.cmdrequest.i(com.baidu.navisdk.cmdrequest.c.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, this.j, i, 10000);
            CmdGeneralHttpRequestFunc.a(iVar, new c(i));
            com.baidu.navisdk.cmdrequest.b.a().a(iVar);
        }
    }

    /* loaded from: classes7.dex */
    public class d extends com.baidu.navisdk.util.http.center.f {
        public d() {
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            LogUtil.e("BusinessActivityManager", "uploadData().ok statusCode=" + i + ", s=" + str);
            com.baidu.navisdk.util.statistic.userop.b r = com.baidu.navisdk.util.statistic.userop.b.r();
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(i);
            r.a("8.2.c", "1", sb.toString(), null);
            if (str == null || str.length() <= 0) {
                return;
            }
            try {
                a.this.a(new JSONObject(str));
            } catch (JSONException e) {
                if (LogUtil.LOGGABLE) {
                    e.printStackTrace();
                }
                if (a.this.j != null) {
                    Message obtainMessage = a.this.j.obtainMessage();
                    obtainMessage.what = 1501;
                    obtainMessage.arg1 = -9999;
                    obtainMessage.sendToTarget();
                }
            }
            if (a.this.j != null) {
                Message obtainMessage2 = a.this.j.obtainMessage();
                obtainMessage2.what = 1501;
                obtainMessage2.arg1 = 0;
                obtainMessage2.sendToTarget();
            }
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            LogUtil.e("BusinessActivityManager", "uploadData().err statusCode=" + i + ", s=" + str);
            com.baidu.navisdk.util.statistic.userop.b r = com.baidu.navisdk.util.statistic.userop.b.r();
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(i);
            r.a("8.2.c", "2", sb.toString(), null);
            if (a.this.j != null) {
                Message obtainMessage = a.this.j.obtainMessage();
                obtainMessage.what = 1501;
                obtainMessage.arg1 = -9999;
                obtainMessage.sendToTarget();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends com.baidu.navisdk.util.http.center.f {
        public e() {
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            LogUtil.e("BusinessActivityManager", "uploadDataForNaving().ok statusCode=" + i + ", s=" + str);
            com.baidu.navisdk.util.statistic.userop.b r = com.baidu.navisdk.util.statistic.userop.b.r();
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(i);
            r.a("8.2.b", "1", sb.toString(), null);
            if (str == null || str.length() <= 0) {
                return;
            }
            try {
                a.this.b(new JSONObject(str));
            } catch (JSONException e) {
                if (LogUtil.LOGGABLE) {
                    e.printStackTrace();
                }
                if (a.this.j != null) {
                    Message obtainMessage = a.this.j.obtainMessage();
                    obtainMessage.what = 1502;
                    obtainMessage.arg1 = -9999;
                    obtainMessage.sendToTarget();
                }
            }
            if (a.this.j != null) {
                Message obtainMessage2 = a.this.j.obtainMessage();
                obtainMessage2.what = 1502;
                obtainMessage2.arg1 = 0;
                obtainMessage2.sendToTarget();
            }
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            LogUtil.e("BusinessActivityManager", "uploadDataForNaving().err statusCode=" + i + ", s=" + str);
            com.baidu.navisdk.util.statistic.userop.b r = com.baidu.navisdk.util.statistic.userop.b.r();
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(i);
            r.a("8.2.b", "2", sb.toString(), null);
            if (a.this.j != null) {
                Message obtainMessage = a.this.j.obtainMessage();
                obtainMessage.what = 1502;
                obtainMessage.arg1 = -9999;
                obtainMessage.sendToTarget();
            }
        }
    }

    public void a(boolean z) {
        com.baidu.navisdk.model.modelfactory.b bVar;
        if (z || (bVar = this.g) == null) {
            return;
        }
        bVar.f();
        this.g.e();
        com.baidu.navisdk.module.business.b.d().a();
    }

    public void a(Activity activity, double d2) {
        com.baidu.navisdk.model.modelfactory.b bVar;
        if (activity == null || (bVar = this.g) == null) {
            return;
        }
        if (!bVar.j) {
            LogUtil.e("BusinessActivityManager", "updateGPSSpeed() return for activity is not open.");
            return;
        }
        if (com.baidu.navisdk.module.business.b.d().b()) {
            LogUtil.e("BusinessActivityManager", "updateGPSSpeed() return for activity is showing.");
            return;
        }
        com.baidu.navisdk.model.modelfactory.b bVar2 = this.g;
        if (bVar2.r0 || bVar2.t0) {
            LogUtil.e("BusinessActivityManager", "updateGPSSpeed() return for isTrafficJam=" + this.g.r0 + ", isParking=" + this.g.t0);
            return;
        }
        int i = (int) ((d2 * 3.6d) + 0.5d);
        if (i > 20) {
            LogUtil.e("BusinessActivityManager", "updateGPSSpeed() return for speed over and hide views.");
            return;
        }
        if (!com.baidu.navisdk.module.business.b.d().b() && (h().a().B >= h().a().z || h().a().C >= h().a().A)) {
            LogUtil.e("BusinessActivityManager", "updateGPSSpeed() return . received=" + h().a().D + ", hasShowCount=" + h().a().B);
            return;
        }
        int trajectoryLength = (int) JNITrajectoryControl.sInstance.getTrajectoryLength(JNITrajectoryControl.sInstance.getCurrentUUID());
        LogUtil.e("BusinessActivityManager", "updateGPSSpeed() navidist=" + trajectoryLength);
        if (!a(i, trajectoryLength)) {
            int b2 = b(i, trajectoryLength);
            if (b2 == 0 || b2 == 1) {
                com.baidu.navisdk.module.business.b.d().a();
                return;
            } else {
                if (b2 == 2) {
                    com.baidu.navisdk.module.business.b.d().a((Context) activity, false);
                    return;
                }
                return;
            }
        }
        com.baidu.navisdk.module.business.b.d().a((Context) activity, false);
    }

    private int b(int i, int i2) {
        if (!this.g.a()) {
            LogUtil.e("BusinessActivityManager", "checkParking() check failed for disable");
            return 0;
        }
        if (i < 3 && i2 >= 200) {
            Bundle k = x.k();
            if (k != null && k.containsKey(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist) && 50 < k.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist)) {
                this.g.e();
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BusinessActivityManager", "checkParking() check failed. nextTurnDist=" + k.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist));
                }
                return 0;
            }
            com.baidu.navisdk.model.modelfactory.b bVar = this.g;
            if (bVar.u0 <= 0) {
                bVar.u0 = SystemClock.elapsedRealtime();
                LogUtil.e("BusinessActivityManager", "checkParking() check time 1 ");
                return 1;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.baidu.navisdk.model.modelfactory.b bVar2 = this.g;
            if (elapsedRealtime - bVar2.u0 > 5000) {
                bVar2.t0 = true;
                LogUtil.e("BusinessActivityManager", "checkParking() check ok speed=" + i);
                if (!LogUtil.LOGGABLE) {
                    return 2;
                }
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "停车触发商业水滴显示");
                return 2;
            }
            LogUtil.e("BusinessActivityManager", "checkParking() check time 2 ");
            return 1;
        }
        this.g.e();
        LogUtil.e("BusinessActivityManager", "checkParking() check failed. speed=" + i + ", naviDis=" + i2);
        return 0;
    }

    public boolean a(int i, int i2) {
        if (!this.g.b()) {
            LogUtil.e("BusinessActivityManager", "checkTrafficJam() check failed for disable");
            return false;
        }
        if (i < 20 && i2 >= 200) {
            Bundle m = x.m();
            if (m != null && m.containsKey(RouteGuideParams.RGKey.SimpleGuideInfo.TotalDist)) {
                int i3 = m.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalDist);
                if (i3 <= 0) {
                    this.g.f();
                    LogUtil.e("BusinessActivityManager", "checkTrafficJam() check failed for remainTotalDist=" + i3);
                    return false;
                }
                LogUtil.e("BusinessActivityManager", "checkTrafficJam() check failed for road condition is null");
                return false;
            }
            this.g.f();
            LogUtil.e("BusinessActivityManager", "checkTrafficJam() check failed for total guide info not exists");
            return false;
        }
        this.g.f();
        LogUtil.e("BusinessActivityManager", "checkTrafficJam() check failed for speed=" + i + ", naviDis=" + i2);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0538 A[Catch: Exception -> 0x03bb, TryCatch #2 {Exception -> 0x03bb, blocks: (B:76:0x0386, B:79:0x039c, B:81:0x03b2, B:82:0x03bf, B:84:0x03cf, B:86:0x03ff, B:87:0x0409, B:89:0x0420, B:90:0x042a, B:92:0x043a, B:94:0x0454, B:96:0x046e, B:98:0x0488, B:102:0x04a8, B:104:0x04b2, B:106:0x04cd, B:108:0x04ef, B:110:0x0513, B:112:0x0538, B:113:0x0542, B:115:0x0550, B:116:0x055b, B:119:0x0570, B:120:0x059a, B:128:0x0398), top: B:75:0x0386 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0550 A[Catch: Exception -> 0x03bb, TryCatch #2 {Exception -> 0x03bb, blocks: (B:76:0x0386, B:79:0x039c, B:81:0x03b2, B:82:0x03bf, B:84:0x03cf, B:86:0x03ff, B:87:0x0409, B:89:0x0420, B:90:0x042a, B:92:0x043a, B:94:0x0454, B:96:0x046e, B:98:0x0488, B:102:0x04a8, B:104:0x04b2, B:106:0x04cd, B:108:0x04ef, B:110:0x0513, B:112:0x0538, B:113:0x0542, B:115:0x0550, B:116:0x055b, B:119:0x0570, B:120:0x059a, B:128:0x0398), top: B:75:0x0386 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x056e  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x056f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0398 A[Catch: Exception -> 0x03bb, TryCatch #2 {Exception -> 0x03bb, blocks: (B:76:0x0386, B:79:0x039c, B:81:0x03b2, B:82:0x03bf, B:84:0x03cf, B:86:0x03ff, B:87:0x0409, B:89:0x0420, B:90:0x042a, B:92:0x043a, B:94:0x0454, B:96:0x046e, B:98:0x0488, B:102:0x04a8, B:104:0x04b2, B:106:0x04cd, B:108:0x04ef, B:110:0x0513, B:112:0x0538, B:113:0x0542, B:115:0x0550, B:116:0x055b, B:119:0x0570, B:120:0x059a, B:128:0x0398), top: B:75:0x0386 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02ce A[Catch: Exception -> 0x0284, TryCatch #4 {Exception -> 0x0284, blocks: (B:147:0x0280, B:56:0x028f, B:58:0x029d, B:60:0x02ce, B:61:0x02d8, B:63:0x02ee, B:64:0x02f8, B:66:0x030e, B:67:0x0318, B:69:0x032e, B:70:0x0347, B:72:0x035d, B:73:0x0376), top: B:146:0x0280 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02ee A[Catch: Exception -> 0x0284, TryCatch #4 {Exception -> 0x0284, blocks: (B:147:0x0280, B:56:0x028f, B:58:0x029d, B:60:0x02ce, B:61:0x02d8, B:63:0x02ee, B:64:0x02f8, B:66:0x030e, B:67:0x0318, B:69:0x032e, B:70:0x0347, B:72:0x035d, B:73:0x0376), top: B:146:0x0280 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x030e A[Catch: Exception -> 0x0284, TryCatch #4 {Exception -> 0x0284, blocks: (B:147:0x0280, B:56:0x028f, B:58:0x029d, B:60:0x02ce, B:61:0x02d8, B:63:0x02ee, B:64:0x02f8, B:66:0x030e, B:67:0x0318, B:69:0x032e, B:70:0x0347, B:72:0x035d, B:73:0x0376), top: B:146:0x0280 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x032e A[Catch: Exception -> 0x0284, TryCatch #4 {Exception -> 0x0284, blocks: (B:147:0x0280, B:56:0x028f, B:58:0x029d, B:60:0x02ce, B:61:0x02d8, B:63:0x02ee, B:64:0x02f8, B:66:0x030e, B:67:0x0318, B:69:0x032e, B:70:0x0347, B:72:0x035d, B:73:0x0376), top: B:146:0x0280 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x035d A[Catch: Exception -> 0x0284, TryCatch #4 {Exception -> 0x0284, blocks: (B:147:0x0280, B:56:0x028f, B:58:0x029d, B:60:0x02ce, B:61:0x02d8, B:63:0x02ee, B:64:0x02f8, B:66:0x030e, B:67:0x0318, B:69:0x032e, B:70:0x0347, B:72:0x035d, B:73:0x0376), top: B:146:0x0280 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x03b2 A[Catch: Exception -> 0x03bb, TryCatch #2 {Exception -> 0x03bb, blocks: (B:76:0x0386, B:79:0x039c, B:81:0x03b2, B:82:0x03bf, B:84:0x03cf, B:86:0x03ff, B:87:0x0409, B:89:0x0420, B:90:0x042a, B:92:0x043a, B:94:0x0454, B:96:0x046e, B:98:0x0488, B:102:0x04a8, B:104:0x04b2, B:106:0x04cd, B:108:0x04ef, B:110:0x0513, B:112:0x0538, B:113:0x0542, B:115:0x0550, B:116:0x055b, B:119:0x0570, B:120:0x059a, B:128:0x0398), top: B:75:0x0386 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x03ff A[Catch: Exception -> 0x03bb, TryCatch #2 {Exception -> 0x03bb, blocks: (B:76:0x0386, B:79:0x039c, B:81:0x03b2, B:82:0x03bf, B:84:0x03cf, B:86:0x03ff, B:87:0x0409, B:89:0x0420, B:90:0x042a, B:92:0x043a, B:94:0x0454, B:96:0x046e, B:98:0x0488, B:102:0x04a8, B:104:0x04b2, B:106:0x04cd, B:108:0x04ef, B:110:0x0513, B:112:0x0538, B:113:0x0542, B:115:0x0550, B:116:0x055b, B:119:0x0570, B:120:0x059a, B:128:0x0398), top: B:75:0x0386 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0420 A[Catch: Exception -> 0x03bb, TryCatch #2 {Exception -> 0x03bb, blocks: (B:76:0x0386, B:79:0x039c, B:81:0x03b2, B:82:0x03bf, B:84:0x03cf, B:86:0x03ff, B:87:0x0409, B:89:0x0420, B:90:0x042a, B:92:0x043a, B:94:0x0454, B:96:0x046e, B:98:0x0488, B:102:0x04a8, B:104:0x04b2, B:106:0x04cd, B:108:0x04ef, B:110:0x0513, B:112:0x0538, B:113:0x0542, B:115:0x0550, B:116:0x055b, B:119:0x0570, B:120:0x059a, B:128:0x0398), top: B:75:0x0386 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r32, int r33) {
        /*
            Method dump skipped, instructions count: 1496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.module.a.a(boolean, int):void");
    }

    public boolean b() {
        if (!com.baidu.navisdk.module.cloudconfig.f.c().c.D) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BusinessActivityManager", "isNeedUploadData,isAntiOpen:false");
            }
            return true;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            boolean z = !com.baidu.navisdk.util.logic.g.j().g();
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BusinessActivityManager", "isNeedUploadData,isNotMock:" + z);
            }
            return z;
        }
        if (a() != null) {
            boolean z2 = a().d;
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BusinessActivityManager", "isNeedUploadData,isNeedUploadDataFromLocal:" + z2);
            }
            if (!z2) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("7.3", "2", null, null);
            }
            return z2;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("7.3", "1", null, null);
        if (!LogUtil.LOGGABLE) {
            return false;
        }
        LogUtil.e("BusinessActivityManager", "isNeedUploadData,finally false");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(JSONObject jSONObject) {
        if (jSONObject == null || this.g == null) {
            return false;
        }
        try {
            LogUtil.e("BusinessActivityManager", "parseUploadJSONForNaving() json --> " + jSONObject);
            this.g.f6947o0 = jSONObject.getInt("errno");
            this.g.p0 = jSONObject.getString("errmsg");
            com.baidu.navisdk.util.statistic.userop.b.r().a("8.2.e", "1", "" + this.g.f6947o0, null);
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONArray jSONArray;
        String str;
        String str2;
        JSONArray jSONArray2;
        if (jSONObject == null || this.g == null) {
            return false;
        }
        try {
            LogUtil.e("BusinessActivityManager", "parseUploadJSON() uploadData --> " + jSONObject);
            this.g.V = jSONObject.getInt("errno");
            this.g.W = jSONObject.getString("errmsg");
            com.baidu.navisdk.util.statistic.userop.b r = com.baidu.navisdk.util.statistic.userop.b.r();
            String str3 = "list";
            StringBuilder sb = new StringBuilder();
            String str4 = "hicon";
            sb.append("");
            sb.append(this.g.V);
            r.a("8.2.e", "2", sb.toString(), null);
            JSONObject jSONObject3 = jSONObject.getJSONObject("data");
            if (jSONObject3 != null) {
                try {
                    this.g.X = jSONObject3.getString("tips");
                    this.g.Y = jSONObject3.getString("click_tips");
                } catch (Exception e2) {
                    if (LogUtil.LOGGABLE) {
                        e2.printStackTrace();
                    }
                }
            }
            if (jSONObject3 != null) {
                try {
                    if (jSONObject3.has("yellow_tip") && (jSONObject2 = jSONObject3.getJSONObject("yellow_tip")) != null && jSONObject2.has("is_show")) {
                        this.g.m0 = jSONObject2.getInt("is_show");
                    }
                } catch (Exception e3) {
                    if (!LogUtil.LOGGABLE) {
                        return true;
                    }
                    e3.printStackTrace();
                    return true;
                }
            }
            JSONObject jSONObject4 = jSONObject3 != null ? jSONObject3.getJSONObject("growth") : null;
            if (jSONObject4 == null) {
                return true;
            }
            if (jSONObject4.has("title")) {
                this.g.f0 = jSONObject4.getString("title");
            }
            if (jSONObject4.has(com.huawei.openalliance.ad.constant.x.cD)) {
                this.g.g0 = jSONObject4.getString(com.huawei.openalliance.ad.constant.x.cD);
            }
            if (jSONObject4.has("tips")) {
                this.g.h0 = jSONObject4.getString("tips");
            }
            if (jSONObject4.has("c_tips")) {
                this.g.i0 = jSONObject4.getString("c_tips");
            }
            if (jSONObject4.has("hlink")) {
                this.g.j0 = jSONObject4.getString("hlink");
            }
            if (jSONObject4.has(TypedValues.TransitionType.S_FROM)) {
                this.g.k0 = jSONObject4.getInt(TypedValues.TransitionType.S_FROM);
            }
            if (jSONObject4.has("to")) {
                this.g.l0 = jSONObject4.getInt("to");
            }
            if (!jSONObject4.has("privilege") || (jSONArray = jSONObject4.getJSONArray("privilege")) == null) {
                return true;
            }
            int length = jSONArray.length();
            int i = 0;
            while (i < length) {
                JSONObject jSONObject5 = jSONArray.getJSONObject(i);
                b.a aVar = new b.a();
                try {
                    aVar.f6948a = jSONObject5.getString("card_type");
                    aVar.b = jSONObject5.getString(ViewHierarchyConstants.HINT_KEY);
                    aVar.c = jSONObject5.getInt("unlock");
                    aVar.d = jSONObject5.getString("tip");
                    if (jSONObject5.has("hlink")) {
                        aVar.e = jSONObject5.getString("hlink");
                    }
                    str2 = str4;
                    try {
                        if (jSONObject5.has(str2)) {
                            aVar.f = jSONObject5.getString(str2);
                        }
                        str = str3;
                        try {
                            if (jSONObject5.has(str) && (jSONArray2 = jSONObject5.getJSONArray(str)) != null) {
                                int length2 = jSONArray2.length();
                                aVar.g = new String[length2];
                                for (int i2 = 0; i2 < length2; i2++) {
                                    aVar.g[i2] = jSONArray2.getString(i2);
                                }
                            }
                            this.g.q0.add(aVar);
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        str = str3;
                    }
                } catch (Exception unused3) {
                    str = str3;
                    str2 = str4;
                }
                i++;
                str4 = str2;
                str3 = str;
            }
            return true;
        } catch (Exception e4) {
            if (!LogUtil.LOGGABLE) {
                return true;
            }
            e4.printStackTrace();
            return true;
        }
    }

    public void a(Handler handler, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        double d2;
        double d3;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        double d4;
        double d5;
        String str12;
        String str13;
        String str14;
        com.baidu.navisdk.model.modelfactory.b bVar = this.g;
        if (bVar == null) {
            LogUtil.e("BusinessActivityManager", "uploadDataForNaving: return --> model = null");
            return;
        }
        this.c = handler;
        this.d = i;
        if (bVar.d() || TextUtils.isEmpty(com.baidu.navisdk.framework.b.e())) {
            str = "pcPoiID";
        } else {
            String e2 = com.baidu.navisdk.framework.b.e();
            Bundle bundle = new Bundle();
            str = "pcPoiID";
            JNITrajectoryControl.sInstance.getPostParamsForBdussUpdated(bundle, e2);
            LogUtil.e("BusinessActivityManager", "reload upload Data. uploadDataForNaving=" + bundle);
            this.g.n0 = bundle;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BusinessActivityManager", "uploadData: isNeedUploadData --> " + b());
            }
            String str15 = "0";
            if (b()) {
                str2 = "pcSoftVersion";
                str3 = "0";
            } else {
                str2 = "pcSoftVersion";
                str3 = "1";
            }
            arrayList.add(new i("hit", str3));
            if (this.g.n0 != null) {
                RoutePlanNode o2 = this.h.o();
                RoutePlanNode g2 = this.h.g();
                if (o2 != null) {
                    str4 = "pcSessionID";
                    str5 = "unKeyVesion";
                    double longitudeE6 = o2.mGeoPoint.getLongitudeE6() / 100000.0d;
                    d2 = o2.mGeoPoint.getLatitudeE6() / 100000.0d;
                    str6 = "bIsChangedKey";
                    d3 = longitudeE6;
                } else {
                    str4 = "pcSessionID";
                    str5 = "unKeyVesion";
                    str6 = "bIsChangedKey";
                    d2 = -1.0d;
                    d3 = -1.0d;
                }
                if (g2 != null) {
                    str9 = str6;
                    str7 = "pcNaviActInfo";
                    str8 = "pcGuid";
                    str10 = "pcFrom";
                    str11 = "pcCuid";
                    d5 = g2.mGeoPoint.getLatitudeE6() / 100000.0d;
                    d4 = g2.mGeoPoint.getLongitudeE6() / 100000.0d;
                } else {
                    str7 = "pcNaviActInfo";
                    str8 = "pcGuid";
                    str9 = str6;
                    str10 = "pcFrom";
                    str11 = "pcCuid";
                    d4 = -1.0d;
                    d5 = -1.0d;
                }
                String str16 = d3 + "," + d2;
                String str17 = d4 + "," + d5;
                arrayList.add(new i("aid", "0"));
                String str18 = "";
                arrayList.add(new i("as", this.g.n0.containsKey("pcDataSign") ? this.g.n0.getString("pcDataSign") : ""));
                arrayList.add(new i("atype", "0"));
                if (com.baidu.navisdk.model.a.g().d() != null) {
                    str15 = "" + com.baidu.navisdk.model.a.g().d().b;
                }
                arrayList.add(new i("cityid", str15));
                if (this.g.n0.containsKey("ulCreateTime")) {
                    str12 = "" + this.g.n0.getLong("ulCreateTime");
                } else {
                    str12 = "";
                }
                arrayList.add(new i(UserDataStore.CITY, str12));
                String str19 = str11;
                arrayList.add(new i("cuid", this.g.n0.containsKey(str19) ? this.g.n0.getString(str19) : ""));
                arrayList.add(new i("data_type", "" + k.TEMPORARY.a()));
                arrayList.add(new i("end_position", str17));
                String str20 = str10;
                arrayList.add(new i(TypedValues.TransitionType.S_FROM, this.g.n0.containsKey(str20) ? this.g.n0.getString(str20) : ""));
                String str21 = str8;
                arrayList.add(new i("guid", this.g.n0.containsKey(str21) ? this.g.n0.getString(str21) : ""));
                String str22 = str7;
                arrayList.add(new i("navi_act_info", this.g.n0.containsKey(str22) ? this.g.n0.getString(str22) : ""));
                String str23 = str9;
                if (this.g.n0.containsKey(str23)) {
                    str13 = "" + (this.g.n0.getBoolean(str23) ? 1 : 0);
                } else {
                    str13 = "";
                }
                arrayList.add(new i("pek", str13));
                String str24 = str5;
                if (this.g.n0.containsKey(str24)) {
                    str14 = "" + this.g.n0.getInt(str24);
                } else {
                    str14 = "";
                }
                arrayList.add(new i("pv", str14));
                arrayList.add(new i("qtv", "2"));
                arrayList.add(new i("session", TextUtils.isEmpty(this.g.v) ? "" : this.g.v));
                String str25 = str4;
                arrayList.add(new i(MapItem.KEY_ITEM_SID, this.g.n0.containsKey(str25) ? this.g.n0.getString(str25) : ""));
                arrayList.add(new i(UserDataStore.STATE, "" + this.g.c));
                arrayList.add(new i("start_position", str16));
                String str26 = str2;
                arrayList.add(new i("sv", this.g.n0.containsKey(str26) ? this.g.n0.getString(str26) : ""));
                String str27 = str;
                arrayList.add(new i("uid", this.g.n0.containsKey(str27) ? this.g.n0.getString(str27) : ""));
                arrayList.add(new i("nav_way", "" + i()));
                arrayList.add(new i("car_type", "" + g().a()));
                arrayList.add(new i("truck_type", "" + com.baidu.navisdk.module.trucknavi.logic.plate.c.g().a().f7582a));
                arrayList.add(new i("truck_ext", "" + com.baidu.navisdk.module.trucknavi.logic.plate.c.g().a().q));
                String f2 = f();
                if (f2 != null) {
                    arrayList.add(new i("car_brand", f2));
                }
                com.baidu.navisdk.util.http.a.a(arrayList);
                String a2 = com.baidu.navisdk.module.cloudconfig.d.a(arrayList);
                String urlParamsSign = JNITrajectoryControl.sInstance.getUrlParamsSign(a2);
                if (!TextUtils.isEmpty(urlParamsSign)) {
                    str18 = urlParamsSign;
                }
                arrayList.add(new i(HttpConstants.SIGN, str18));
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BusinessActivityManager", "uploadDataForNaving() uploadPs=" + a2 + "&sign=" + str18);
                }
            }
            com.baidu.navisdk.util.http.center.b.a().a(com.baidu.navisdk.util.http.b.d().b("BusinessUpload"), com.baidu.navisdk.util.http.center.c.a(arrayList), new e(), null);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4) {
        n b0;
        if (this.l) {
            LogUtil.e("BusinessActivityManager", "safety shareSafety  --> isCancelShareSafe: " + this.l);
            return;
        }
        h().n = true;
        com.baidu.navisdk.framework.interfaces.pronavi.i i = x.i();
        if (i != null) {
            i.g(false);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("OrientationUser", this.m);
        bundle.putString("LinkUrl", str);
        bundle.putString("ImgUrl", str2);
        bundle.putString(oOoXoXO.f33471xoIox, str3);
        bundle.putString("Desc", str4);
        com.baidu.navisdk.framework.b.h(bundle);
        com.baidu.navisdk.framework.interfaces.pronavi.b h2 = com.baidu.navisdk.framework.interfaces.c.p().h();
        if (h2 != null && h2.x0() && (b0 = h2.b0()) != null) {
            b0.e();
        }
        if (com.baidu.navisdk.framework.interfaces.c.p().i() != null) {
            com.baidu.navisdk.framework.interfaces.c.p().i().a(true);
        }
    }

    public void a(Activity activity, int i, boolean z) {
        int i2;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BusinessActivityManager", "safety safetyUpload  --> action: " + i + "  isShareSuc: " + this.n);
        }
        if (activity == null) {
            LogUtil.e("BusinessActivityManager", "safety safetyUpload context null");
            return;
        }
        if ((i == 1 || i == 2) && !this.n) {
            return;
        }
        if (!com.baidu.navisdk.module.cloudconfig.f.c().c.l) {
            TipTool.onCreateToastDialog(activity, "行程分享敬请期待...");
            return;
        }
        if (!y.d(activity)) {
            if (i == 0) {
                TipTool.onCreateToastDialog(activity, "无网或离线导航不能分享");
                return;
            }
            return;
        }
        if (i == 0 && !BNRouteGuider.getInstance().isCurDriveRouteOnline()) {
            TipTool.onCreateToastDialog(activity, "无网或离线导航不能分享");
            return;
        }
        this.m = z;
        if (i == 0) {
            this.l = false;
            if (z) {
                n n = x.n();
                if (n != null) {
                    n.c();
                }
            } else {
                com.baidu.navisdk.framework.interfaces.lightnavi.a i3 = com.baidu.navisdk.framework.interfaces.c.p().i();
                if (i3 != null) {
                    i3.Y();
                }
            }
            i2 = FeatureCodes.BODY_SEG;
        } else {
            i2 = (i != 1 && i == 2) ? 1702 : 1701;
        }
        com.baidu.navisdk.cmdrequest.i iVar = new com.baidu.navisdk.cmdrequest.i(com.baidu.navisdk.cmdrequest.c.K_COMMAND_KEY_GENERAL_HTTPPOST_FUNC, 7, this.j, i2, 10000);
        CmdGeneralHttpPostFunc.a(iVar, new h(i));
        com.baidu.navisdk.cmdrequest.b.a().a(iVar);
    }

    private String a(String str) {
        return v.b(str);
    }
}
