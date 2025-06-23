package xoX;

import XxXX.II0XooXoX;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.utils.URLEncodedUtils;
import com.huawei.hms.ads.dynamic.a;
import com.huawei.openalliance.ad.constant.aw;
import com.sma.smartv3.ui.me.O0OOX0IIx;
import com.tencent.open.a.b;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.II0xO0;
import java.io.IOException;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import kotlin.text.XIxXXX0x0;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class x0XOIxOo {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static x0XOIxOo f35116II0XooXoX;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public Handler f35120X0o0xo;

    /* renamed from: oxoX, reason: collision with root package name */
    public HandlerThread f35123oxoX;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Random f35122oIX0oI = new Random();

    /* renamed from: I0Io, reason: collision with root package name */
    public List<Serializable> f35117I0Io = Collections.synchronizedList(new ArrayList());

    /* renamed from: II0xO0, reason: collision with root package name */
    public List<Serializable> f35118II0xO0 = Collections.synchronizedList(new ArrayList());

    /* renamed from: XO, reason: collision with root package name */
    public Executor f35121XO = II0XooXoX.I0Io();

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public Executor f35119Oxx0IOOO = II0XooXoX.I0Io();

    /* loaded from: classes13.dex */
    public class I0Io implements Runnable {

        /* renamed from: IIXOooo, reason: collision with root package name */
        public final /* synthetic */ boolean f35124IIXOooo;

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ String f35125IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ String f35126Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ int f35127Oxx0xo;

        /* renamed from: OxxIIOOXO, reason: collision with root package name */
        public final /* synthetic */ long f35128OxxIIOOXO;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ long f35129XO;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public final /* synthetic */ long f35130oI0IIXIo;

        public I0Io(long j, String str, String str2, int i, long j2, long j3, boolean z) {
            this.f35129XO = j;
            this.f35126Oo = str;
            this.f35125IXxxXO = str2;
            this.f35127Oxx0xo = i;
            this.f35130oI0IIXIo = j2;
            this.f35128OxxIIOOXO = j3;
            this.f35124IIXOooo = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.f35129XO;
                Bundle bundle = new Bundle();
                String oIX0oI2 = xxIXOIIO.oIX0oI(XxXX.X0o0xo.oIX0oI());
                bundle.putString("apn", oIX0oI2);
                bundle.putString("appid", "1000067");
                bundle.putString("commandid", this.f35126Oo);
                bundle.putString(aw.as, this.f35125IXxxXO);
                StringBuilder sb = new StringBuilder();
                sb.append("network=");
                sb.append(oIX0oI2);
                sb.append(XIxXXX0x0.f29558oxoX);
                sb.append("sdcard=");
                int i = 1;
                sb.append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                sb.append(XIxXXX0x0.f29558oxoX);
                sb.append("wifi=");
                sb.append(xxIXOIIO.X0o0xo(XxXX.X0o0xo.oIX0oI()));
                bundle.putString("deviceInfo", sb.toString());
                int oIX0oI3 = 100 / x0XOIxOo.this.oIX0oI(this.f35127Oxx0xo);
                if (oIX0oI3 > 0) {
                    if (oIX0oI3 > 100) {
                        i = 100;
                    } else {
                        i = oIX0oI3;
                    }
                }
                bundle.putString("frequency", i + "");
                bundle.putString("reqSize", this.f35130oI0IIXIo + "");
                bundle.putString("resultCode", this.f35127Oxx0xo + "");
                bundle.putString("rspSize", this.f35128OxxIIOOXO + "");
                bundle.putString("timeCost", elapsedRealtime + "");
                bundle.putString("uin", com.tencent.connect.common.II0xO0.f26842oIX0oI);
                x0XOIxOo.this.f35118II0xO0.add(new b(bundle));
                int size = x0XOIxOo.this.f35118II0xO0.size();
                int II0xO02 = com.tencent.open.utils.oIX0oI.oxoX(XxXX.X0o0xo.oIX0oI(), null).II0xO0("Agent_ReportTimeInterval");
                if (II0xO02 == 0) {
                    II0xO02 = 10000;
                }
                if (!x0XOIxOo.this.Oxx0IOOO("report_cgi", size) && !this.f35124IIXOooo) {
                    if (!x0XOIxOo.this.f35120X0o0xo.hasMessages(1000)) {
                        Message obtain = Message.obtain();
                        obtain.what = 1000;
                        x0XOIxOo.this.f35120X0o0xo.sendMessageDelayed(obtain, II0xO02);
                    }
                }
                x0XOIxOo.this.xxIXOIIO();
                x0XOIxOo.this.f35120X0o0xo.removeMessages(1000);
            } catch (Exception e) {
                xx0.xxIXOIIO.xxIXOIIO("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", e);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class II0xO0 implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ boolean f35133Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Bundle f35134XO;

        public II0xO0(Bundle bundle, boolean z) {
            this.f35134XO = bundle;
            this.f35133Oo = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String o02 = com.tencent.open.utils.II0xO0.o0(xoIox.oxoX(XxXX.X0o0xo.oIX0oI()));
                String o03 = com.tencent.open.utils.II0xO0.o0(xoIox.X0o0xo(XxXX.X0o0xo.oIX0oI()));
                String o04 = com.tencent.open.utils.II0xO0.o0(xoIox.oIX0oI());
                String o05 = com.tencent.open.utils.II0xO0.o0(xoIox.XO(XxXX.X0o0xo.oIX0oI()));
                Bundle bundle = new Bundle();
                bundle.putString("uin", com.tencent.connect.common.II0xO0.f26842oIX0oI);
                bundle.putString(O0OOX0IIx.f23381X0o0xo, o02);
                bundle.putString("imsi", o03);
                bundle.putString("android_id", o05);
                bundle.putString("mac", o04);
                bundle.putString("platform", "1");
                bundle.putString("os_ver", Build.VERSION.RELEASE);
                bundle.putString(RequestParameters.POSITION, com.tencent.open.utils.II0xO0.XI0IXoo(XxXX.X0o0xo.oIX0oI()));
                bundle.putString("network", xxIXOIIO.oIX0oI(XxXX.X0o0xo.oIX0oI()));
                bundle.putString("language", xoIox.I0Io());
                bundle.putString(a.e, xoIox.II0xO0(XxXX.X0o0xo.oIX0oI()));
                bundle.putString("apn", xxIXOIIO.II0xO0(XxXX.X0o0xo.oIX0oI()));
                bundle.putString("model_name", Build.MODEL);
                bundle.putString("timezone", TimeZone.getDefault().getID());
                bundle.putString("sdk_ver", com.tencent.connect.common.II0xO0.f26901xoIox);
                bundle.putString("qz_ver", com.tencent.open.utils.II0xO0.XxX0x0xxx(XxXX.X0o0xo.oIX0oI(), com.tencent.connect.common.II0xO0.f26737II0xO0));
                bundle.putString("qq_ver", com.tencent.open.utils.II0xO0.XIxXXX0x0(XxXX.X0o0xo.oIX0oI(), "com.tencent.mobileqq"));
                bundle.putString("qua", com.tencent.open.utils.II0xO0.xI(XxXX.X0o0xo.oIX0oI(), XxXX.X0o0xo.I0Io()));
                bundle.putString("packagename", XxXX.X0o0xo.I0Io());
                bundle.putString("app_ver", com.tencent.open.utils.II0xO0.XxX0x0xxx(XxXX.X0o0xo.oIX0oI(), XxXX.X0o0xo.I0Io()));
                Bundle bundle2 = this.f35134XO;
                if (bundle2 != null) {
                    bundle.putAll(bundle2);
                }
                x0XOIxOo.this.f35117I0Io.add(new b(bundle));
                int size = x0XOIxOo.this.f35117I0Io.size();
                int II0xO02 = com.tencent.open.utils.oIX0oI.oxoX(XxXX.X0o0xo.oIX0oI(), null).II0xO0("Agent_ReportTimeInterval");
                if (II0xO02 == 0) {
                    II0xO02 = 10000;
                }
                if (!x0XOIxOo.this.Oxx0IOOO("report_via", size) && !this.f35133Oo) {
                    if (!x0XOIxOo.this.f35120X0o0xo.hasMessages(1001)) {
                        Message obtain = Message.obtain();
                        obtain.what = 1001;
                        x0XOIxOo.this.f35120X0o0xo.sendMessageDelayed(obtain, II0xO02);
                        return;
                    }
                    return;
                }
                x0XOIxOo.this.oOoXoXO();
                x0XOIxOo.this.f35120X0o0xo.removeMessages(1001);
            } catch (Exception e) {
                xx0.xxIXOIIO.xxIXOIIO("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class X0o0xo implements Runnable {
        public X0o0xo() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            try {
                Bundle OOXIXo2 = x0XOIxOo.this.OOXIXo();
                if (OOXIXo2 == null) {
                    return;
                }
                xx0.xxIXOIIO.IXxxXO("openSDK_LOG.ReportManager", "-->doReportVia, params: " + OOXIXo2.toString());
                int oIX0oI2 = oOoXoXO.oIX0oI();
                int i2 = 0;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                boolean z = false;
                int i3 = 0;
                long j = 0;
                long j2 = 0;
                do {
                    int i4 = i2 + 1;
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        II0xO0.C1091II0xO0 xoIox2 = HttpUtils.xoIox(XxXX.X0o0xo.oIX0oI(), "https://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report", "POST", OOXIXo2);
                                        try {
                                            i = com.tencent.open.utils.II0xO0.xXxxox0I(xoIox2.f26967oIX0oI).getInt("ret");
                                        } catch (JSONException unused) {
                                            i = -4;
                                        }
                                        if (i != 0) {
                                            if (!TextUtils.isEmpty(xoIox2.f26967oIX0oI)) {
                                            }
                                            j = xoIox2.f26966II0xO0;
                                            j2 = xoIox2.f26965I0Io;
                                            i2 = i4;
                                        }
                                        i4 = oIX0oI2;
                                        z = true;
                                        j = xoIox2.f26966II0xO0;
                                        j2 = xoIox2.f26965I0Io;
                                        i2 = i4;
                                    } catch (JSONException unused2) {
                                        i2 = i4;
                                        i3 = -4;
                                        j = 0;
                                        j2 = 0;
                                    }
                                } catch (HttpUtils.NetworkUnavailableException unused3) {
                                    x0XOIxOo.this.f35117I0Io.clear();
                                    xx0.xxIXOIIO.XO("openSDK_LOG.ReportManager", "doReportVia, NetworkUnavailableException.");
                                    return;
                                }
                            } catch (SocketTimeoutException unused4) {
                                elapsedRealtime = SystemClock.elapsedRealtime();
                                i2 = i4;
                                i3 = -8;
                                j = 0;
                                j2 = 0;
                            }
                        } catch (ConnectTimeoutException unused5) {
                            elapsedRealtime = SystemClock.elapsedRealtime();
                            i2 = i4;
                            i3 = -7;
                            j = 0;
                            j2 = 0;
                        } catch (Exception unused6) {
                            i2 = oIX0oI2;
                            i3 = -6;
                            j = 0;
                            j2 = 0;
                        }
                    } catch (HttpUtils.HttpStatusException e) {
                        try {
                            i3 = Integer.parseInt(e.getMessage().replace(HttpUtils.HttpStatusException.ERROR_INFO, ""));
                        } catch (Exception unused7) {
                        }
                    } catch (IOException e2) {
                        i3 = HttpUtils.Oxx0IOOO(e2);
                        i2 = i4;
                        j = 0;
                        j2 = 0;
                    }
                } while (i2 < oIX0oI2);
                x0XOIxOo.this.X0o0xo("mapp_apptrace_sdk", elapsedRealtime, j, j2, i3, null, false);
                if (z) {
                    ooOOo0oXI.II0xO0().oxoX("report_via");
                } else {
                    ooOOo0oXI.II0xO0().I0Io("report_via", x0XOIxOo.this.f35117I0Io);
                }
                x0XOIxOo.this.f35117I0Io.clear();
                xx0.xxIXOIIO.XO("openSDK_LOG.ReportManager", "-->doReportVia, uploadSuccess: " + z);
            } catch (Exception e3) {
                xx0.xxIXOIIO.xxIXOIIO("openSDK_LOG.ReportManager", "-->doReportVia, exception in serial executor.", e3);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class XO implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ boolean f35136IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ String f35137Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ String f35138Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Bundle f35139XO;

        public XO(Bundle bundle, String str, boolean z, String str2) {
            this.f35139XO = bundle;
            this.f35137Oo = str;
            this.f35136IXxxXO = z;
            this.f35138Oxx0xo = str2;
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x0136 A[Catch: Exception -> 0x000e, TRY_ENTER, TryCatch #2 {Exception -> 0x000e, blocks: (B:3:0x0004, B:5:0x0008, B:8:0x0011, B:11:0x0018, B:13:0x0041, B:14:0x0045, B:16:0x0053, B:17:0x0089, B:33:0x0136, B:35:0x013c, B:39:0x00e1, B:62:0x0119, B:68:0x0152, B:75:0x014f, B:110:0x0067, B:112:0x0075, B:113:0x0153, B:70:0x0144, B:72:0x014a), top: B:2:0x0004, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x013c A[Catch: Exception -> 0x000e, TRY_LEAVE, TryCatch #2 {Exception -> 0x000e, blocks: (B:3:0x0004, B:5:0x0008, B:8:0x0011, B:11:0x0018, B:13:0x0041, B:14:0x0045, B:16:0x0053, B:17:0x0089, B:33:0x0136, B:35:0x013c, B:39:0x00e1, B:62:0x0119, B:68:0x0152, B:75:0x014f, B:110:0x0067, B:112:0x0075, B:113:0x0153, B:70:0x0144, B:72:0x014a), top: B:2:0x0004, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0144 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 351
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: xoX.x0XOIxOo.XO.run():void");
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI extends Handler {
        public oIX0oI(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1000) {
                if (i == 1001) {
                    x0XOIxOo.this.oOoXoXO();
                }
            } else {
                x0XOIxOo.this.xxIXOIIO();
            }
            super.handleMessage(message);
        }
    }

    /* loaded from: classes13.dex */
    public class oxoX implements Runnable {
        public oxoX() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Bundle xoIox2 = x0XOIxOo.this.xoIox();
                if (xoIox2 == null) {
                    return;
                }
                int II0xO02 = com.tencent.open.utils.oIX0oI.oxoX(XxXX.X0o0xo.oIX0oI(), null).II0xO0("Common_HttpRetryCount");
                if (II0xO02 == 0) {
                    II0xO02 = 3;
                }
                xx0.xxIXOIIO.XO("openSDK_LOG.ReportManager", "-->doReportCgi, retryCount: " + II0xO02);
                int i = 0;
                do {
                    i++;
                    try {
                        try {
                            HttpClient II0XooXoX2 = HttpUtils.II0XooXoX(XxXX.X0o0xo.oIX0oI(), null, "https://wspeed.qq.com/w.cgi");
                            HttpPost httpPost = new HttpPost("https://wspeed.qq.com/w.cgi");
                            httpPost.addHeader("Accept-Encoding", "gzip");
                            httpPost.setHeader("Content-Type", URLEncodedUtils.CONTENT_TYPE);
                            httpPost.setEntity(new ByteArrayEntity(com.tencent.open.utils.II0xO0.OI0(HttpUtils.XO(xoIox2))));
                            int statusCode = II0XooXoX2.execute(httpPost).getStatusLine().getStatusCode();
                            xx0.xxIXOIIO.XO("openSDK_LOG.ReportManager", "-->doReportCgi, statusCode: " + statusCode);
                            if (statusCode != 200) {
                                break;
                            }
                            ooOOo0oXI.II0xO0().oxoX("report_cgi");
                            break;
                        } catch (Exception e) {
                            xx0.xxIXOIIO.xxIXOIIO("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e);
                        }
                    } catch (SocketTimeoutException e2) {
                        xx0.xxIXOIIO.xxIXOIIO("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e2);
                    } catch (ConnectTimeoutException e3) {
                        xx0.xxIXOIIO.xxIXOIIO("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e3);
                    }
                } while (i < II0xO02);
                ooOOo0oXI.II0xO0().I0Io("report_cgi", x0XOIxOo.this.f35118II0xO0);
                x0XOIxOo.this.f35118II0xO0.clear();
            } catch (Exception e4) {
                xx0.xxIXOIIO.xxIXOIIO("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception out.", e4);
            }
        }
    }

    public x0XOIxOo() {
        this.f35123oxoX = null;
        if (this.f35123oxoX == null) {
            HandlerThread handlerThread = new HandlerThread("opensdk.report.handlerthread", 10);
            this.f35123oxoX = handlerThread;
            handlerThread.start();
        }
        if (this.f35123oxoX.isAlive() && this.f35123oxoX.getLooper() != null) {
            this.f35120X0o0xo = new oIX0oI(this.f35123oxoX.getLooper());
        }
    }

    public static synchronized x0XOIxOo II0xO0() {
        x0XOIxOo x0xoixoo;
        synchronized (x0XOIxOo.class) {
            try {
                if (f35116II0XooXoX == null) {
                    f35116II0XooXoX = new x0XOIxOo();
                }
                x0xoixoo = f35116II0XooXoX;
            } catch (Throwable th) {
                throw th;
            }
        }
        return x0xoixoo;
    }

    public void I0Io(Bundle bundle, String str, boolean z) {
        if (bundle == null) {
            return;
        }
        xx0.xxIXOIIO.IXxxXO("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
        if (!II0XooXoX("report_via", str) && !z) {
            return;
        }
        this.f35121XO.execute(new II0xO0(bundle, z));
    }

    public boolean II0XooXoX(String str, String str2) {
        int oIX0oI2;
        xx0.xxIXOIIO.XO("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 100;
        if (str.equals("report_cgi")) {
            try {
                oIX0oI2 = oIX0oI(Integer.parseInt(str2));
                if (this.f35122oIX0oI.nextInt(100) < oIX0oI2) {
                    z = true;
                }
            } catch (Exception unused) {
                return false;
            }
        } else {
            if (str.equals("report_via")) {
                oIX0oI2 = oOoXoXO.II0xO0(str2);
                if (this.f35122oIX0oI.nextInt(100) < oIX0oI2) {
                    i = oIX0oI2;
                    z = true;
                }
            }
            xx0.xxIXOIIO.XO("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i);
            return z;
        }
        i = oIX0oI2;
        xx0.xxIXOIIO.XO("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i);
        return z;
    }

    public Bundle OOXIXo() {
        List<Serializable> oIX0oI2 = ooOOo0oXI.II0xO0().oIX0oI("report_via");
        if (oIX0oI2 != null) {
            this.f35117I0Io.addAll(oIX0oI2);
        }
        xx0.xxIXOIIO.XO("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.f35117I0Io.size());
        if (this.f35117I0Io.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Serializable serializable : this.f35117I0Io) {
            JSONObject jSONObject = new JSONObject();
            b bVar = (b) serializable;
            for (String str : bVar.f26942a.keySet()) {
                try {
                    String str2 = bVar.f26942a.get(str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put(str, str2);
                } catch (JSONException e) {
                    xx0.xxIXOIIO.xxIXOIIO("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e);
                }
            }
            jSONArray.put(jSONObject);
        }
        xx0.xxIXOIIO.IXxxXO("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        Bundle bundle = new Bundle();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            bundle.putString("data", jSONObject2.toString());
            return bundle;
        } catch (JSONException e2) {
            xx0.xxIXOIIO.xxIXOIIO("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0036, code lost:
    
        if (r0 == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x001a, code lost:
    
        if (r0 == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001d, code lost:
    
        r1 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean Oxx0IOOO(java.lang.String r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "report_cgi"
            boolean r0 = r5.equals(r0)
            r1 = 5
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L1f
            android.content.Context r0 = XxXX.X0o0xo.oIX0oI()
            com.tencent.open.utils.oIX0oI r0 = com.tencent.open.utils.oIX0oI.oxoX(r0, r2)
            java.lang.String r2 = "Common_CGIReportMaxcount"
            int r0 = r0.II0xO0(r2)
            if (r0 != 0) goto L1d
            goto L3a
        L1d:
            r1 = r0
            goto L3a
        L1f:
            java.lang.String r0 = "report_via"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L39
            android.content.Context r0 = XxXX.X0o0xo.oIX0oI()
            com.tencent.open.utils.oIX0oI r0 = com.tencent.open.utils.oIX0oI.oxoX(r0, r2)
            java.lang.String r2 = "Agent_ReportBatchCount"
            int r0 = r0.II0xO0(r2)
            if (r0 != 0) goto L1d
            goto L3a
        L39:
            r1 = 0
        L3a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "-->availableCount, report: "
            r0.append(r2)
            r0.append(r5)
            java.lang.String r5 = " | dataSize: "
            r0.append(r5)
            r0.append(r6)
            java.lang.String r5 = " | maxcount: "
            r0.append(r5)
            r0.append(r1)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "openSDK_LOG.ReportManager"
            xx0.xxIXOIIO.XO(r0, r5)
            if (r6 < r1) goto L64
            r5 = 1
            return r5
        L64:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: xoX.x0XOIxOo.Oxx0IOOO(java.lang.String, int):boolean");
    }

    public void X0o0xo(String str, long j, long j2, long j3, int i, String str2, boolean z) {
        xx0.xxIXOIIO.IXxxXO("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j + " | reqSize:" + j2 + " | rspSize: " + j3 + " | responseCode: " + i + " | detail: " + str2);
        if (!II0XooXoX("report_cgi", "" + i) && !z) {
            return;
        }
        this.f35119Oxx0IOOO.execute(new I0Io(j, str, str2, i, j2, j3, z));
    }

    public void XO(String str, String str2, Bundle bundle, boolean z) {
        II0XooXoX.II0xO0(new XO(bundle, str, z, str2));
    }

    public int oIX0oI(int i) {
        if (i == 0) {
            int II0xO02 = com.tencent.open.utils.oIX0oI.oxoX(XxXX.X0o0xo.oIX0oI(), null).II0xO0("Common_CGIReportFrequencySuccess");
            if (II0xO02 == 0) {
                return 10;
            }
            return II0xO02;
        }
        int II0xO03 = com.tencent.open.utils.oIX0oI.oxoX(XxXX.X0o0xo.oIX0oI(), null).II0xO0("Common_CGIReportFrequencyFailed");
        if (II0xO03 == 0) {
            return 100;
        }
        return II0xO03;
    }

    public void oOoXoXO() {
        this.f35121XO.execute(new X0o0xo());
    }

    public void oxoX(String str, long j, long j2, long j3, int i) {
        X0o0xo(str, j, j2, j3, i, "", false);
    }

    public Bundle xoIox() {
        if (this.f35118II0xO0.size() == 0) {
            return null;
        }
        b bVar = (b) this.f35118II0xO0.get(0);
        if (bVar == null) {
            xx0.xxIXOIIO.XO("openSDK_LOG.ReportManager", "-->prepareCgiData, the 0th cgireportitem is null.");
            return null;
        }
        String str = bVar.f26942a.get("appid");
        List<Serializable> oIX0oI2 = ooOOo0oXI.II0xO0().oIX0oI("report_cgi");
        if (oIX0oI2 != null) {
            this.f35118II0xO0.addAll(oIX0oI2);
        }
        xx0.xxIXOIIO.XO("openSDK_LOG.ReportManager", "-->prepareCgiData, mCgiList size: " + this.f35118II0xO0.size());
        if (this.f35118II0xO0.size() == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        try {
            bundle.putString("appid", str);
            bundle.putString("releaseversion", com.tencent.connect.common.II0xO0.f26862ooOOo0oXI);
            bundle.putString(DeviceRequestsHelper.DEVICE_INFO_DEVICE, Build.DEVICE);
            bundle.putString("qua", com.tencent.connect.common.II0xO0.f26777OOXIXo);
            bundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
            for (int i = 0; i < this.f35118II0xO0.size(); i++) {
                b bVar2 = (b) this.f35118II0xO0.get(i);
                bundle.putString(i + "_1", bVar2.f26942a.get("apn"));
                bundle.putString(i + "_2", bVar2.f26942a.get("frequency"));
                bundle.putString(i + "_3", bVar2.f26942a.get("commandid"));
                bundle.putString(i + "_4", bVar2.f26942a.get("resultCode"));
                bundle.putString(i + "_5", bVar2.f26942a.get("timeCost"));
                bundle.putString(i + "_6", bVar2.f26942a.get("reqSize"));
                bundle.putString(i + "_7", bVar2.f26942a.get("rspSize"));
                bundle.putString(i + "_8", bVar2.f26942a.get(aw.as));
                bundle.putString(i + "_9", bVar2.f26942a.get("uin"));
                bundle.putString(i + "_10", xoIox.Oxx0IOOO(XxXX.X0o0xo.oIX0oI()) + "&" + bVar2.f26942a.get("deviceInfo"));
            }
            xx0.xxIXOIIO.IXxxXO("openSDK_LOG.ReportManager", "-->prepareCgiData, end. params: " + bundle.toString());
            return bundle;
        } catch (Exception e) {
            xx0.xxIXOIIO.xxIXOIIO("openSDK_LOG.ReportManager", "-->prepareCgiData, exception.", e);
            return null;
        }
    }

    public void xxIXOIIO() {
        this.f35119Oxx0IOOO.execute(new oxoX());
    }
}
