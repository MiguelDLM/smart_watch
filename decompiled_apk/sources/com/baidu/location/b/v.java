package com.baidu.location.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.huawei.openalliance.ad.constant.bn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class v {
    private static long j = 12000;

    /* renamed from: a, reason: collision with root package name */
    public e f5665a;
    private Context b;
    private WebView c;
    private LocationClient d;
    private a e;
    private List<b> f;
    private boolean g;
    private long h;
    private BDLocation i;
    private f k;
    private boolean l;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        private String a(BDLocation bDLocation) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("latitude", bDLocation.getLatitude());
                jSONObject.put("longitude", bDLocation.getLongitude());
                jSONObject.put("radius", bDLocation.getRadius());
                jSONObject.put("errorcode", 1);
                if (bDLocation.hasAltitude()) {
                    jSONObject.put("altitude", bDLocation.getAltitude());
                }
                if (bDLocation.hasSpeed()) {
                    jSONObject.put(RouteGuideParams.RGKey.AssistInfo.Speed, bDLocation.getSpeed() / 3.6f);
                }
                if (bDLocation.getLocType() == 61) {
                    jSONObject.put("direction", bDLocation.getDirection());
                }
                if (bDLocation.getBuildingName() != null) {
                    jSONObject.put("buildingname", bDLocation.getBuildingName());
                }
                if (bDLocation.getBuildingID() != null) {
                    jSONObject.put("buildingid", bDLocation.getBuildingID());
                }
                if (bDLocation.getFloor() != null) {
                    jSONObject.put("floor", bDLocation.getFloor());
                }
                return jSONObject.toString();
            } catch (Exception unused) {
                return null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v9 */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str = 0;
            str = 0;
            switch (message.what) {
                case 1:
                    b bVar = (b) message.obj;
                    if (v.this.f != null) {
                        v.this.f.add(bVar);
                    }
                    if (v.this.d != null) {
                        if (v.this.d.requestLocation() != 0) {
                            long currentTimeMillis = System.currentTimeMillis() - v.this.h;
                            if (v.this.i != null && currentTimeMillis <= 10000) {
                                Message obtainMessage = v.this.e.obtainMessage(2);
                                obtainMessage.obj = v.this.i;
                                obtainMessage.sendToTarget();
                                return;
                            }
                        }
                        if (v.this.l) {
                            v.this.e.removeCallbacks(v.this.k);
                            v.this.l = false;
                        }
                        if (v.this.k == null) {
                            v vVar = v.this;
                            vVar.k = new f();
                        }
                        v.this.e.postDelayed(v.this.k, v.j);
                        v.this.l = true;
                        return;
                    }
                    return;
                case 2:
                    a(a((BDLocation) message.obj));
                    return;
                case 3:
                    if (v.this.f == null) {
                        v.this.f = new ArrayList();
                    } else {
                        v.this.f.clear();
                    }
                    v.this.d.registerLocationListener(v.this.f5665a);
                    return;
                case 4:
                    if (v.this.f != null) {
                        v.this.f.clear();
                        v.this.f = null;
                    }
                    v.this.d.unRegisterLocationListener(v.this.f5665a);
                    v.this.h = 0L;
                    v.this.i = null;
                    if (v.this.k != null && v.this.l) {
                        v.this.e.removeCallbacks(v.this.k);
                    }
                    v.this.l = false;
                    v.this.c.removeJavascriptInterface("BaiduLocAssistant");
                    return;
                case 5:
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("errorcode", 0);
                        str = jSONObject.toString();
                    } catch (Exception unused) {
                    }
                    if (str == 0) {
                        return;
                    }
                    break;
                case 6:
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("errorcode", 2);
                        str = jSONObject2.toString();
                    } catch (Exception unused2) {
                    }
                    if (str == 0) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            a(str);
        }

        private void a(String str) {
            if (v.this.l) {
                v.this.e.removeCallbacks(v.this.k);
                v.this.l = false;
            }
            if (v.this.f == null || v.this.f.size() <= 0) {
                return;
            }
            Iterator it = v.this.f.iterator();
            while (it.hasNext()) {
                try {
                    b bVar = (b) it.next();
                    if (bVar.b() != null) {
                        v.this.c.loadUrl(x0xO.II0xO0.f34059xoIox + bVar.b() + "('" + str + "')");
                    }
                    it.remove();
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b {
        private String b;
        private String c;
        private long d;

        public b(String str) {
            this.b = null;
            this.c = null;
            this.d = 0L;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("action")) {
                    this.b = jSONObject.getString("action");
                }
                if (jSONObject.has(bn.f.L)) {
                    this.c = jSONObject.getString(bn.f.L);
                }
                if (jSONObject.has("timeout")) {
                    long j = jSONObject.getLong("timeout");
                    if (j >= 1000) {
                        long unused = v.j = j;
                    }
                }
                this.d = System.currentTimeMillis();
            } catch (Exception unused2) {
                this.b = null;
                this.c = null;
            }
        }

        public String a() {
            return this.b;
        }

        public String b() {
            return this.c;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private static final v f5668a = new v();
    }

    /* loaded from: classes7.dex */
    public class d {
        private d() {
        }

        @JavascriptInterface
        public void sendMessage(String str) {
            if (str == null || !v.this.g) {
                return;
            }
            b bVar = new b(str);
            if (bVar.a() == null || !bVar.a().equals("requestLoc") || v.this.e == null) {
                return;
            }
            Message obtainMessage = v.this.e.obtainMessage(1);
            obtainMessage.obj = bVar;
            obtainMessage.sendToTarget();
        }

        @JavascriptInterface
        public void showLog(String str) {
        }
    }

    /* loaded from: classes7.dex */
    public class e extends BDAbstractLocationListener {
        public e() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Message obtainMessage;
            String str;
            if (!v.this.g || bDLocation == null) {
                return;
            }
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            int locType = bDLocation2.getLocType();
            String coorType = bDLocation2.getCoorType();
            if (locType == 61 || locType == 161 || locType == 66) {
                if (coorType != null) {
                    if (coorType.equals("gcj02")) {
                        bDLocation2 = LocationClient.getBDLocationInCoorType(bDLocation2, "gcj2wgs");
                    } else {
                        if (coorType.equals("bd09")) {
                            str = BDLocation.BDLOCATION_BD09_TO_GCJ02;
                        } else if (coorType.equals("bd09ll")) {
                            str = BDLocation.BDLOCATION_BD09LL_TO_GCJ02;
                        }
                        bDLocation2 = LocationClient.getBDLocationInCoorType(LocationClient.getBDLocationInCoorType(bDLocation2, str), "gcj2wgs");
                    }
                }
                v.this.h = System.currentTimeMillis();
                v.this.i = new BDLocation(bDLocation2);
                obtainMessage = v.this.e.obtainMessage(2);
                obtainMessage.obj = bDLocation2;
            } else {
                obtainMessage = v.this.e.obtainMessage(5);
            }
            obtainMessage.sendToTarget();
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        private f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.l = false;
            v.this.e.obtainMessage(6).sendToTarget();
        }
    }

    private v() {
        this.b = null;
        this.d = null;
        this.f5665a = new e();
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = 0L;
        this.i = null;
        this.k = null;
        this.l = false;
    }

    public void b() {
        if (this.g) {
            this.e.obtainMessage(4).sendToTarget();
            this.g = false;
        }
    }

    public static v a() {
        return c.f5668a;
    }

    public void a(Context context, WebView webView, LocationClient locationClient) {
        if (this.g) {
            return;
        }
        this.b = context;
        this.c = webView;
        this.d = locationClient;
        a aVar = new a(Looper.getMainLooper());
        this.e = aVar;
        aVar.obtainMessage(3).sendToTarget();
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setSavePassword(false);
        this.c.removeJavascriptInterface("searchBoxJavaBridge_");
        this.c.removeJavascriptInterface("accessibility");
        this.c.removeJavascriptInterface("accessibilityTraversal");
        a(this.c);
        this.g = true;
    }

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    private void a(WebView webView) {
        webView.addJavascriptInterface(new d(), "BaiduLocAssistant");
    }
}
