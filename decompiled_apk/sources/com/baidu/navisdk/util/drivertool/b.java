package com.baidu.navisdk.util.drivertool;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.alimm.tanx.core.constant.TanxAdType;
import com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpPostDataFunc;
import com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.y;
import com.facebook.internal.AnalyticsEvents;
import com.garmin.fit.OxXXx0X;
import com.realsil.sdk.core.bluetooth.impl.BluetoothClassImpl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class b {
    private static b J;

    /* renamed from: a, reason: collision with root package name */
    private h f9264a;
    private com.baidu.navisdk.util.drivertool.view.b b;
    private com.baidu.navisdk.util.drivertool.view.c c;
    private BNDebugModelDialog f;
    public String r;
    private com.baidu.navisdk.util.drivertool.model.a d = new com.baidu.navisdk.util.drivertool.model.a();
    private final com.baidu.navisdk.util.drivertool.model.a e = new com.baidu.navisdk.util.drivertool.model.a();
    public List<String> g = new ArrayList();
    public List<String> h = new ArrayList();
    public List<String> i = new ArrayList();
    public List<String> j = new ArrayList();
    public List<String> k = new ArrayList();
    public Map<String, String> l = new HashMap();
    public Map<String, String> m = new HashMap();
    public Map<String, String> n = new HashMap();
    public Map<String, ArrayList<String>> o = new HashMap();
    public String p = null;
    public String q = null;
    public String s = "0";
    public String t = "0";
    public String u = null;
    public String v = null;
    public Boolean w = Boolean.FALSE;
    public String x = null;
    private final List<String> y = new ArrayList();
    private final List<String> z = new ArrayList();
    private int A = 0;
    public String B = null;
    public boolean C = false;
    public boolean D = false;
    public boolean E = false;
    public boolean F = true;
    public boolean G = false;
    public Handler H = new a("DTM");
    private final k I = new k();

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.a {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            boolean z;
            int i = message.what;
            int i2 = message.arg1;
            if (i2 == 0) {
                z = true;
            } else {
                z = false;
            }
            if (i == 1406) {
                if (z) {
                    b.this.m();
                }
                LogUtil.e("drivingTool", "ret is " + z + "TYPE_UPDATE_TASKLIST");
                return;
            }
            if (i == 1407) {
                if (z) {
                    b.this.l();
                } else {
                    b.this.b(true);
                }
                LogUtil.e("drivingTool", "ret is " + z + "TYPE_UPDATE_ROUTELIST");
                return;
            }
            if (i == 1408) {
                if (z) {
                    b.this.j();
                    b.this.k();
                }
                LogUtil.e("drivingTool", "ret is " + z + "TYPE_UPDATE_ISSUELIST");
                return;
            }
            if (i == 1409) {
                if (z) {
                    com.baidu.navisdk.util.drivertool.view.b unused = b.this.b;
                }
                LogUtil.e("drivingTool", "ret is " + z + "TYPE_UPDATE_PERSONRELIABLE");
                return;
            }
            if (i == 1410) {
                LogUtil.e("drivingTool", "ret is " + z + "TYPE_UPLOAD_LOCALFILE");
                if (z) {
                    com.baidu.navisdk.cmdrequest.j jVar = (com.baidu.navisdk.cmdrequest.j) message.obj;
                    JSONObject jSONObject = (JSONObject) jVar.b;
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("errno");
                        com.baidu.navisdk.util.drivertool.d.a("asyn upload errno is " + optString);
                        if (optString != null && !optString.equals("0")) {
                            if (b.this.c != null) {
                                b.this.c.a("上传文件" + ((String) b.this.z.get(b.this.A)) + "失败");
                                throw null;
                            }
                            return;
                        }
                    }
                    b.this.a((k) jVar.f6695a.m);
                    com.baidu.navisdk.util.drivertool.d.a("上传文件" + ((String) b.this.z.get(b.this.A)) + "成功");
                    if (b.this.c != null) {
                        b.this.c.b("上传文件" + ((String) b.this.z.get(b.this.A)) + "成功");
                        throw null;
                    }
                } else if (b.this.c != null) {
                    b.this.c.a("上传文件" + ((String) b.this.z.get(b.this.A)) + "失败");
                    throw null;
                }
                b.e(b.this);
                if (b.this.A < b.this.z.size()) {
                    b bVar = b.this;
                    bVar.a((String) bVar.y.get(b.this.A), (String) b.this.z.get(b.this.A), b.this.A);
                    return;
                }
                return;
            }
            if (i == 1003) {
                if (i2 == 0) {
                    b.this.B = ((com.baidu.navisdk.model.modelfactory.e) com.baidu.navisdk.model.modelfactory.c.a().a("PoiSearchModel")).b().e;
                    LogUtil.e("drivingTool", "mName " + b.this.B);
                } else {
                    b.this.B = "未知";
                }
                int parseInt = Integer.parseInt(b.this.d.e);
                if (parseInt == 3) {
                    com.baidu.navisdk.util.drivertool.e.l().f();
                } else if (parseInt == 2) {
                    com.baidu.navisdk.util.drivertool.f.c().b();
                }
            }
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0496b implements CmdGeneralHttpRequestFunc.b {
        public C0496b() {
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public void a(byte[] bArr) {
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public List<com.baidu.navisdk.util.http.center.l> getRequestParams() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.baidu.navisdk.util.http.center.i("ignoreLogin", "1"));
            return arrayList;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public int getRequestType() {
            return 1;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public String getUrl() {
            if (com.baidu.navisdk.util.drivertool.d.f9277a) {
                return com.baidu.navisdk.util.drivertool.c.b;
            }
            return "https://10.99.23.21:8088/naviServerAdmin/getdttasklist";
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public boolean parseResponseJSON(JSONObject jSONObject) {
            b.this.b(jSONObject);
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements CmdGeneralHttpRequestFunc.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.cmdrequest.i f9267a;

        public c(com.baidu.navisdk.cmdrequest.i iVar) {
            this.f9267a = iVar;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public void a(byte[] bArr) {
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public List<com.baidu.navisdk.util.http.center.l> getRequestParams() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.baidu.navisdk.util.http.center.i("task_id", b.this.p));
            b.this.g();
            arrayList.add(new com.baidu.navisdk.util.http.center.i("city_id", b.this.u));
            arrayList.add(new com.baidu.navisdk.util.http.center.i("create_new_flag", b.this.s));
            arrayList.add(new com.baidu.navisdk.util.http.center.i("ignoreLogin", "1"));
            LogUtil.e("drivingTool", "asynPullRoadList getRequestParams= " + arrayList);
            return arrayList;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public int getRequestType() {
            return 1;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public String getUrl() {
            if (com.baidu.navisdk.util.drivertool.d.f9277a) {
                return com.baidu.navisdk.util.drivertool.c.c;
            }
            return "https://10.99.23.21:8088/naviServerAdmin/getdtrouteid";
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public boolean parseResponseJSON(JSONObject jSONObject) {
            String str;
            j jVar = (j) this.f9267a.m;
            if (jVar != null) {
                str = jVar.f9273a;
            } else {
                str = null;
            }
            b.this.b(jSONObject, str);
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements CmdGeneralHttpRequestFunc.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.cmdrequest.i f9268a;

        public d(com.baidu.navisdk.cmdrequest.i iVar) {
            this.f9268a = iVar;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public void a(byte[] bArr) {
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public List<com.baidu.navisdk.util.http.center.l> getRequestParams() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.baidu.navisdk.util.http.center.i("task_id", b.this.p));
            arrayList.add(new com.baidu.navisdk.util.http.center.i("route_id", b.this.q));
            arrayList.add(new com.baidu.navisdk.util.http.center.i("cuid", a0.e()));
            arrayList.add(new com.baidu.navisdk.util.http.center.i("create_new_flag", b.this.t));
            arrayList.add(new com.baidu.navisdk.util.http.center.i("ignoreLogin", "1"));
            LogUtil.e("drivingTool", "asynPullIssueList getRequestParams= " + arrayList);
            return arrayList;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public int getRequestType() {
            return 1;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public String getUrl() {
            if (com.baidu.navisdk.util.drivertool.d.f9277a) {
                return com.baidu.navisdk.util.drivertool.c.d;
            }
            return "https://10.99.23.21:8088/naviServerAdmin/getdtproblemid";
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public boolean parseResponseJSON(JSONObject jSONObject) {
            String str;
            i iVar = (i) this.f9268a.m;
            if (iVar != null) {
                str = iVar.f9272a;
            } else {
                str = null;
            }
            b.this.a(jSONObject, str);
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class e implements CmdGeneralHttpRequestFunc.b {
        public e() {
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public void a(byte[] bArr) {
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public List<com.baidu.navisdk.util.http.center.l> getRequestParams() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.baidu.navisdk.util.http.center.i("task_id", b.this.p));
            arrayList.add(new com.baidu.navisdk.util.http.center.i("ignoreLogin", "1"));
            LogUtil.e("drivingTool", "asynPullReliablePerson getRequestParams= " + arrayList);
            return arrayList;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public int getRequestType() {
            return 1;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public String getUrl() {
            if (com.baidu.navisdk.util.drivertool.d.f9277a) {
                return com.baidu.navisdk.util.drivertool.c.e;
            }
            return "https://10.99.23.21:8088/naviServerAdmin/getdttaskdetailconfig";
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public boolean parseResponseJSON(JSONObject jSONObject) {
            b.this.a(jSONObject);
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class f implements CmdGeneralHttpPostDataFunc.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9270a;

        public f(String str) {
            this.f9270a = str;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpPostDataFunc.a
        public List<com.baidu.navisdk.util.http.center.l> a() {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(new com.baidu.navisdk.util.http.center.i("ignoreLogin", "1"));
                arrayList.add(new com.baidu.navisdk.util.http.center.i("task_id", b.this.e.f9285a));
                arrayList.add(new com.baidu.navisdk.util.http.center.i("route_id", b.this.e.b));
                if (!TextUtils.isEmpty(b.this.e.d)) {
                    String[] split = b.this.e.d.trim().split("\\|");
                    String str = b.this.e.d;
                    if (split != null && split.length > 0) {
                        str = split[0];
                    }
                    arrayList.add(new com.baidu.navisdk.util.http.center.i("problem_id", str));
                } else {
                    arrayList.add(new com.baidu.navisdk.util.http.center.i("problem_id", b.this.e.d));
                }
                if (b.this.c(b.this.e.f)) {
                    arrayList.add(new com.baidu.navisdk.util.http.center.i("problem_describe", URLEncoder.encode(b.this.e.f, "UTF-8")));
                }
                if (b.this.c(b.this.e.g)) {
                    arrayList.add(new com.baidu.navisdk.util.http.center.i("problem_type", b.this.e.g));
                }
                if (b.this.c(b.this.e.h)) {
                    arrayList.add(new com.baidu.navisdk.util.http.center.i("person_liable", b.this.e.h));
                }
                if (b.this.c(b.this.e.i)) {
                    arrayList.add(new com.baidu.navisdk.util.http.center.i("status", b.this.e.i));
                }
                arrayList.add(new com.baidu.navisdk.util.http.center.i("extends_info", b.this.e.j));
                arrayList.add(new com.baidu.navisdk.util.http.center.i("problem_poi", b.this.e.k));
                arrayList.add(new com.baidu.navisdk.util.http.center.i("problem_time", b.this.e.l));
                arrayList.add(new com.baidu.navisdk.util.http.center.i("cuid", b.this.e.c));
                arrayList.add(new com.baidu.navisdk.util.http.center.i("session_id", b.this.e.n));
                LogUtil.e("drivingTool", "asynupload file prarams" + b.this.e.toString());
                com.baidu.navisdk.util.drivertool.d.a("asynupload file prarams" + this.f9270a + b.this.e.toString());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return arrayList;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpPostDataFunc.a
        public String b() {
            if (String.valueOf(4).equals(b.this.e.e)) {
                b.this.e.e = String.valueOf(2);
            }
            b bVar = b.this;
            return bVar.d(bVar.e.e);
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpPostDataFunc.a
        public File c() {
            return com.baidu.navisdk.util.drivertool.d.a(this.f9270a, 480, 800);
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpPostDataFunc.a
        public int getRequestType() {
            return 1;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpPostDataFunc.a
        public String getUrl() {
            if (com.baidu.navisdk.util.drivertool.d.f9277a) {
                return com.baidu.navisdk.util.drivertool.c.f;
            }
            return "https://10.99.23.21:8088/naviServerAdmin/submitdtrouteproblem";
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpPostDataFunc.a
        public boolean parseResponseJSON(JSONObject jSONObject) {
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class g implements DialogInterface.OnDismissListener {
        public g() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.n().G = false;
            b.this.b.b(true);
            b.n().a(true);
        }
    }

    /* loaded from: classes8.dex */
    public interface h {
        int a();

        void a(boolean z);
    }

    /* loaded from: classes8.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        public String f9274a;
        public String b;
        public String c;
    }

    /* loaded from: classes8.dex */
    public class l extends AsyncTask<String, String, String> {
        private l() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(String... strArr) {
            b.this.b(strArr[0]);
            return null;
        }

        public /* synthetic */ l(b bVar, a aVar) {
            this();
        }
    }

    private b() {
    }

    public static /* synthetic */ int e(b bVar) {
        int i2 = bVar.A + 1;
        bVar.A = i2;
        return i2;
    }

    public static b n() {
        if (J == null) {
            J = new b();
        }
        return J;
    }

    private byte[] o() {
        try {
            return System.getProperty("line.separator").getBytes("utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return new byte[0];
        }
    }

    private void p() {
        com.baidu.navisdk.util.drivertool.model.a aVar = this.e;
        aVar.f9285a = null;
        aVar.b = null;
        aVar.c = null;
        aVar.d = null;
        aVar.e = null;
        aVar.f = null;
        aVar.g = null;
        aVar.h = null;
        aVar.i = null;
        aVar.j = null;
        aVar.k = null;
        aVar.l = null;
        aVar.m = null;
        aVar.n = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x00a0 -> B:23:0x00a3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void q() {
        /*
            Method dump skipped, instructions count: 192
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.drivertool.b.q():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x00b2 -> B:22:0x00b5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void r() {
        /*
            Method dump skipped, instructions count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.drivertool.b.r():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0073 -> B:18:0x0076). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void s() {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.baidu.navisdk.util.drivertool.d.d()
            r0.append(r1)
            java.lang.String r1 = java.io.File.separator
            r0.append(r1)
            java.lang.String r1 = "issue-store.dat"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            r0 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.util.List<java.lang.String> r0 = r4.j     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            if (r0 == 0) goto L58
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            if (r0 <= 0) goto L58
            java.util.List<java.lang.String> r0 = r4.j     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
        L35:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            if (r1 == 0) goto L58
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            byte[] r1 = r1.getBytes(r3)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r2.write(r1)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            java.lang.String r1 = ","
            byte[] r1 = r1.getBytes(r3)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r2.write(r1)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            goto L35
        L54:
            r0 = move-exception
            goto L7a
        L56:
            r0 = move-exception
            goto L5e
        L58:
            r2.close()     // Catch: java.io.IOException -> L5c
            goto L76
        L5c:
            r0 = move-exception
            goto L73
        L5e:
            r1 = r0
            r0 = r2
            goto L64
        L61:
            r1 = move-exception
            goto L7c
        L63:
            r1 = move-exception
        L64:
            java.lang.String r2 = "drivingTool"
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L77
            com.baidu.navisdk.util.common.LogUtil.e(r2, r1)     // Catch: java.lang.Throwable -> L77
            if (r0 == 0) goto L76
            r0.close()     // Catch: java.io.IOException -> L5c
            goto L76
        L73:
            r0.printStackTrace()
        L76:
            return
        L77:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L7a:
            r1 = r0
            r0 = r2
        L7c:
            if (r0 == 0) goto L86
            r0.close()     // Catch: java.io.IOException -> L82
            goto L86
        L82:
            r0 = move-exception
            r0.printStackTrace()
        L86:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.drivertool.b.s():void");
    }

    public int i() {
        List<String> list;
        String str;
        String[] split;
        Map<String, String> map = this.l;
        if (map != null && map.size() > 0 && (list = this.g) != null && list.size() > 0) {
            String lastDrivingInfo = BNSettingManager.getLastDrivingInfo();
            String str2 = null;
            if (lastDrivingInfo != null && (split = lastDrivingInfo.split(",")) != null && split.length > 0) {
                str = split[0];
            } else {
                str = null;
            }
            Iterator<Map.Entry<String, String>> it = this.l.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, String> next = it.next();
                if (next.getValue().equals(str)) {
                    str2 = next.getKey();
                    break;
                }
            }
            if (str2 != null) {
                for (int i2 = 0; i2 < this.g.size(); i2++) {
                    if (str2.equals(this.g.get(i2))) {
                        return i2;
                    }
                }
            }
        }
        return -1;
    }

    public void j() {
        com.baidu.navisdk.util.drivertool.view.b bVar = this.b;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void k() {
        com.baidu.navisdk.util.drivertool.view.b bVar;
        if (n().t.equals("1") && (bVar = this.b) != null) {
            bVar.b();
        }
    }

    public void l() {
        BNDebugModelDialog bNDebugModelDialog = this.f;
        if (bNDebugModelDialog != null) {
            bNDebugModelDialog.updatRouteListView();
        }
    }

    public void m() {
        BNDebugModelDialog bNDebugModelDialog = this.f;
        if (bNDebugModelDialog != null) {
            bNDebugModelDialog.updateTaskListView();
        }
    }

    /* loaded from: classes8.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public String f9272a;

        private i() {
            this.f9272a = "0";
        }

        public /* synthetic */ i(a aVar) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public String f9273a;

        private j() {
            this.f9273a = "0";
        }

        public /* synthetic */ j(a aVar) {
            this();
        }
    }

    public void d() {
        com.baidu.navisdk.cmdrequest.i iVar = new com.baidu.navisdk.cmdrequest.i(com.baidu.navisdk.cmdrequest.c.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, this.H, 1406, 10000);
        CmdGeneralHttpRequestFunc.a(iVar, new C0496b());
        com.baidu.navisdk.cmdrequest.b.a().a(iVar);
    }

    public boolean e() {
        return this.C && this.D;
    }

    public void f() {
        com.baidu.navisdk.util.drivertool.model.a aVar = this.d;
        aVar.d = null;
        aVar.f = null;
        aVar.g = null;
        aVar.h = null;
        aVar.i = null;
    }

    public void g() {
        h hVar = this.f9264a;
        if (hVar != null) {
            this.u = String.valueOf(hVar.a());
        }
    }

    public com.baidu.navisdk.util.drivertool.model.a h() {
        if (this.d == null) {
            this.d = new com.baidu.navisdk.util.drivertool.model.a();
        }
        return this.d;
    }

    public void c() {
        b(false);
        com.baidu.navisdk.cmdrequest.i iVar = new com.baidu.navisdk.cmdrequest.i(com.baidu.navisdk.cmdrequest.c.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, this.H, 1407, 10000);
        j jVar = new j(null);
        jVar.f9273a = this.s;
        iVar.a(jVar);
        CmdGeneralHttpRequestFunc.a(iVar, new c(iVar));
        com.baidu.navisdk.cmdrequest.b.a().a(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(String str) {
        int parseInt = Integer.parseInt(str);
        if (parseInt != 3) {
            if (parseInt == 2) {
                return AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO;
            }
            if (parseInt == 1) {
                return "video";
            }
            if (parseInt != 4) {
                return null;
            }
        }
        return TanxAdType.SPLASH_STRING;
    }

    public void b(boolean z) {
        BNDebugModelDialog bNDebugModelDialog = this.f;
        if (bNDebugModelDialog != null) {
            bNDebugModelDialog.setRouteSpinnerCLickable(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject) {
        JSONArray jSONArray;
        if (jSONObject == null) {
            return;
        }
        LogUtil.e("drivingTool", "parseTaskListResult jsonObj= " + jSONObject);
        try {
            if (jSONObject.getInt("errno") != 0 || (jSONArray = jSONObject.getJSONArray("data")) == null) {
                return;
            }
            this.g.clear();
            this.g.add("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -");
            n().l.clear();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                String string = jSONObject2.getString("task_name");
                if (!this.g.contains(string)) {
                    this.g.add(string);
                    n().l.put(string, jSONObject2.getString("task_id"));
                }
            }
        } catch (Exception unused) {
        }
    }

    public void a(BNDebugModelDialog bNDebugModelDialog) {
        this.f = bNDebugModelDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar) {
        if (kVar == null) {
            return;
        }
        LogUtil.e("drivingTool", "deleteLocalFile " + kVar.f9274a + "type= " + kVar.c);
        String str = kVar.f9274a;
        String str2 = kVar.c;
        int parseInt = str2 != null ? Integer.parseInt(str2) : 0;
        if (parseInt == 4) {
            new File(kVar.b).delete();
            return;
        }
        com.baidu.navisdk.util.drivertool.d.c(parseInt);
        new File(str.substring(0, str.length() - 4) + ".index").delete();
    }

    public void c(int i2) {
        ArrayList<String> arrayList;
        Map<String, ArrayList<String>> map = this.o;
        if (map == null || map.size() <= 0 || (arrayList = this.o.get(String.valueOf(i2))) == null || arrayList.size() <= 0) {
            return;
        }
        this.k.clear();
        this.k.add("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -");
        this.n.clear();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String[] split = it.next().split(",");
            this.k.add(split[1]);
            this.n.put(split[1], split[0]);
        }
        com.baidu.navisdk.util.drivertool.view.b bVar = this.b;
        if (bVar != null) {
            bVar.c();
        }
    }

    public void a(boolean z) {
        h hVar = this.f9264a;
        if (hVar != null) {
            hVar.a(z);
        }
    }

    public boolean a(String str) {
        List<String> list;
        if (this.t.equals("0") || (list = this.j) == null) {
            return false;
        }
        return list.get(list.size() - 1).equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return;
        }
        LogUtil.e("drivingTool", "parseRoadList jsonObj= " + jSONObject);
        try {
            if (jSONObject.getInt("errno") == 0) {
                if (TextUtils.isEmpty(str)) {
                    str = this.s;
                }
                if (str.equals("1")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    String string = jSONObject2.getString("route_name");
                    String string2 = jSONObject2.getString("route_id");
                    this.q = string2;
                    this.h.add(string);
                    this.i.add(string);
                    this.m.put(string, string2);
                    return;
                }
                if (str.equals("0")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    this.h.clear();
                    this.m.clear();
                    if (!this.h.contains("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -")) {
                        this.h.add("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -");
                    }
                    this.s = "0";
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                        String string3 = jSONObject3.getString("route_name");
                        this.h.add(string3);
                        this.m.put(string3, jSONObject3.getString("route_id"));
                    }
                }
            }
        } catch (Exception e2) {
            LogUtil.e("drivingTool", e2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str) {
        return (str == null || str.equals("null")) ? false : true;
    }

    public void a() {
        Context a2 = com.baidu.navisdk.framework.a.c().a();
        if (a2 != null && y.d(a2)) {
            com.baidu.navisdk.cmdrequest.i iVar = new com.baidu.navisdk.cmdrequest.i(com.baidu.navisdk.cmdrequest.c.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, this.H, BluetoothClassImpl.Device.PERIPHERAL_POINTING, 10000);
            i iVar2 = new i(null);
            iVar2.f9272a = this.t;
            iVar.m = iVar2;
            CmdGeneralHttpRequestFunc.a(iVar, new d(iVar));
            com.baidu.navisdk.cmdrequest.b.a().a(iVar);
            return;
        }
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return;
        }
        LogUtil.e("drivingTool", "parseIssueList jsonObj = " + jSONObject);
        try {
            if (jSONObject.getInt("errno") == 0) {
                if (TextUtils.isEmpty(str)) {
                    str = this.t;
                }
                if (str.equals("1")) {
                    String string = jSONObject.getString("data");
                    this.d.d = string;
                    this.j.add(string);
                } else if (str.equals("0")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    this.j.clear();
                    this.j.add("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        String string2 = jSONArray.getString(i2);
                        if (i2 == 0) {
                            this.d.d = string2;
                        }
                        this.j.add(string2);
                    }
                }
                s();
            }
        } catch (Exception e2) {
            LogUtil.e("drivingTool", e2.toString());
        }
    }

    public void b() {
        Context a2 = com.baidu.navisdk.framework.a.c().a();
        if (a2 != null && y.d(a2)) {
            com.baidu.navisdk.cmdrequest.i iVar = new com.baidu.navisdk.cmdrequest.i(com.baidu.navisdk.cmdrequest.c.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, this.H, 1409, 10000);
            CmdGeneralHttpRequestFunc.a(iVar, new e());
            com.baidu.navisdk.cmdrequest.b.a().a(iVar);
            return;
        }
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            LogUtil.e("drivingTool", "parseReliblePerson jsonObj = " + jSONObject);
            if (jSONObject.getInt("errno") != 0 || (jSONObject2 = jSONObject.getJSONObject("data")) == null) {
                return;
            }
            JSONObject jSONObject3 = jSONObject2.getJSONObject("person_liable");
            Iterator<String> keys = jSONObject3.keys();
            this.k.clear();
            this.n.clear();
            this.o.clear();
            this.k.add("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -");
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject4 = (JSONObject) jSONObject3.get(next);
                Iterator<String> keys2 = jSONObject4.keys();
                ArrayList<String> arrayList = new ArrayList<>();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    String str = (String) jSONObject4.get(next2);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(next2);
                    stringBuffer.append(",");
                    stringBuffer.append(str);
                    arrayList.add(stringBuffer.toString());
                }
                this.o.put(next, arrayList);
            }
            LogUtil.e("dingbin", this.o.toString());
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00bf -> B:14:0x00c2). Please report as a decompilation issue!!! */
    public void b(int i2) {
        String str;
        FileOutputStream fileOutputStream;
        if (i2 == 4) {
            str = com.baidu.navisdk.util.drivertool.a.c().a();
        } else {
            str = com.baidu.navisdk.util.drivertool.d.d() + File.separator + this.v + ".index";
        }
        File file = new File(str);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            a(fileOutputStream, this.p);
            a(fileOutputStream, this.q);
            a(fileOutputStream, this.d.d);
            a(fileOutputStream, String.valueOf(i2));
            a(fileOutputStream, this.d.f);
            a(fileOutputStream, this.d.g);
            a(fileOutputStream, this.d.h);
            a(fileOutputStream, this.d.i);
            a(fileOutputStream, this.d.j);
            a(fileOutputStream, this.d.k);
            a(fileOutputStream, this.d.l);
            a(fileOutputStream, this.d.m);
            a(fileOutputStream, a0.e());
            a(fileOutputStream, this.d.n);
            if (i2 == 4) {
                a(fileOutputStream, com.baidu.navisdk.util.drivertool.a.c().b);
            }
            fileOutputStream.close();
        } catch (Exception e4) {
            e = e4;
            fileOutputStream2 = fileOutputStream;
            LogUtil.e("drivingTool", e.toString());
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i2) {
        a(str, str2);
        this.I.b = str;
        new l(this, null).execute(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0144 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x012f -> B:36:0x0132). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.lang.String r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.drivertool.b.a(java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        LogUtil.e("drivingTool", "uploadLocalFile dataPath= " + str);
        com.baidu.navisdk.cmdrequest.i iVar = new com.baidu.navisdk.cmdrequest.i(com.baidu.navisdk.cmdrequest.c.K_COMMAND_KEY_GENERAL_HTTPPOST_DATA_FUNC, 7, this.H, OxXXx0X.f13141o0, 10000);
        k kVar = this.I;
        kVar.f9274a = str;
        kVar.c = this.e.e;
        iVar.a(kVar);
        CmdGeneralHttpPostDataFunc.a(iVar, new f(str));
        com.baidu.navisdk.cmdrequest.b.a().a(iVar);
    }

    public void a(Context context) {
        boolean d2 = y.d(context);
        com.baidu.navisdk.poisearch.c.a(com.baidu.navisdk.util.logic.h.a(), d2 ? 1 : 0, 10000, this.H);
    }

    private void a(FileOutputStream fileOutputStream, String str) throws IOException {
        if (!TextUtils.isEmpty(str)) {
            fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
        } else {
            fileOutputStream.write("null".getBytes(StandardCharsets.UTF_8));
        }
        fileOutputStream.write(o());
    }

    public com.baidu.navisdk.util.drivertool.view.b a(int i2) {
        Activity b = com.baidu.navisdk.framework.a.c().b();
        if (b == null) {
            return null;
        }
        if (i2 == 4) {
            com.baidu.navisdk.util.drivertool.a.c().f9263a.clear();
            n().G = true;
        } else {
            n().G = false;
        }
        com.baidu.navisdk.util.drivertool.view.b bVar = new com.baidu.navisdk.util.drivertool.view.b(b, i2);
        this.b = bVar;
        bVar.setOnDismissListener(new g());
        this.b.setCanceledOnTouchOutside(false);
        return this.b;
    }
}
