package com.baidu.navisdk.util.statistic.core;

import android.content.Context;
import com.baidu.ar.base.MsgField;
import com.baidu.navisdk.comapi.statistics.d;
import com.baidu.navisdk.comapi.statistics.f;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.m0;
import com.baidu.navisdk.util.common.y;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.g;
import com.baidu.nplatform.comapi.MapItem;
import com.szabh.smable3.entity.Languages;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Properties;

/* loaded from: classes8.dex */
public class a extends f {
    private static volatile a n;
    private Properties j;
    private ArrayList<String> k;
    private int l;
    private int m;

    /* renamed from: com.baidu.navisdk.util.statistic.core.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0507a extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RoutePlanNode f9367a;
        final /* synthetic */ RoutePlanNode b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0507a(String str, String str2, RoutePlanNode routePlanNode, RoutePlanNode routePlanNode2, String str3, String str4, String str5, int i, int i2) {
            super(str, str2);
            this.f9367a = routePlanNode;
            this.b = routePlanNode2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = i;
            this.g = i2;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            int i;
            boolean z;
            String str;
            try {
                String b = a.this.b(this.f9367a);
                String b2 = a.this.b(this.b);
                String a2 = a.this.a(this.f9367a);
                String a3 = a.this.a(this.b);
                a.this.a(b, b2, a2, a3, this.c, this.d, this.e);
                Context a4 = com.baidu.navisdk.framework.a.c().a();
                boolean d = a4 == null ? true : y.d(a4);
                int i2 = (this.f * 16) + this.g;
                int i3 = 3;
                while (i3 > 0) {
                    if (d) {
                        a aVar = a.this;
                        String str2 = this.c;
                        String str3 = this.d;
                        String str4 = this.e;
                        String str5 = i2 + "";
                        z = d;
                        str = g.TAG;
                        i = i2;
                        if (aVar.a(b, b2, a2, a3, str2, str3, str4, str5) == 200) {
                            LogUtil.e(str, "NETWORK_NORMAL,Send Statistics Success! ");
                            return null;
                        }
                    } else {
                        i = i2;
                        z = d;
                        str = g.TAG;
                    }
                    i3--;
                    if (i3 > 0) {
                        LogUtil.e(str, "NETWORK ERROR, try again! ");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException unused) {
                        }
                    }
                    d = z;
                    i2 = i;
                }
                int i4 = i2;
                if (MapItem.KEY_IS_MAP_ITEM.equals(this.c)) {
                    a.this.b("navi_enter_offline_navi");
                } else if ("edog".equals(this.c)) {
                    a.this.b("navi_enter_edog");
                } else if ("yaw".equals(this.c)) {
                    a.this.b("navi_enter_yaw");
                } else if ("route_plan".equals(this.c)) {
                    a.this.b("navi_enter_route_plan");
                } else if ("download".equals(this.c)) {
                    a.this.b("navi_enter_download");
                } else if ("settings".equals(this.c)) {
                    a.this.b("navi_enter_settings");
                }
                a.this.c(b + " " + b2 + " " + a2 + " " + a3 + " " + this.c + " " + this.d + " " + this.e + " " + i4);
                return null;
            } catch (Exception unused2) {
                return null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends com.baidu.navisdk.util.worker.f<String, String> {
        public c(String str, String str2) {
            super(str, str2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
        
            r4.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
        
            r4.close();
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00b5 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00b6 A[Catch: Exception -> 0x0147, TryCatch #8 {Exception -> 0x0147, blocks: (B:3:0x0005, B:5:0x000d, B:7:0x0017, B:17:0x0035, B:23:0x003b, B:25:0x003f, B:27:0x0058, B:28:0x00ad, B:31:0x00b6, B:32:0x00bd, B:34:0x00c9, B:38:0x00e4, B:54:0x0105, B:40:0x010b, B:43:0x010f, B:46:0x0116, B:58:0x011c, B:66:0x005e, B:68:0x0062, B:69:0x00aa, B:106:0x0135, B:114:0x0146, B:111:0x013b, B:113:0x013f, B:90:0x007f, B:94:0x0085, B:96:0x0089, B:77:0x009c, B:81:0x00a2, B:83:0x00a6), top: B:2:0x0005, inners: #0, #1, #7, #9, #11 }] */
        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String execute() {
            /*
                Method dump skipped, instructions count: 328
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.statistic.core.a.c.execute():java.lang.String");
        }
    }

    public a(d dVar) {
        super(dVar);
        this.j = new Properties();
        this.k = null;
        this.l = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(o(), false);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write("".getBytes("utf-8"));
            fileOutputStream.flush();
            try {
                fileOutputStream.close();
            } catch (IOException e2) {
                e = e2;
                if (!LogUtil.LOGGABLE) {
                    return;
                }
                LogUtil.e("Statistics-BNCoreStat", e.getMessage());
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            if (LogUtil.LOGGABLE) {
                LogUtil.e("Statistics-BNCoreStat", e.getMessage());
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                    e = e4;
                    if (!LogUtil.LOGGABLE) {
                        return;
                    }
                    LogUtil.e("Statistics-BNCoreStat", e.getMessage());
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("Statistics-BNCoreStat", e5.getMessage());
                    }
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File o() {
        return new File(m0.j().c() + "/offlineStatLog.txt");
    }

    public static a p() {
        if (n == null) {
            synchronized (a.class) {
                try {
                    if (n == null) {
                        n = new a(com.baidu.navisdk.comapi.statistics.b.f());
                        LogUtil.e("Statistics-BNCoreStat", "kkkkk inited");
                        if (LogUtil.LOGGABLE) {
                            n.r();
                        }
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("Statistics-BNCoreStat", "onCreateView.network=" + y.d(com.baidu.navisdk.framework.a.c().a()));
                        }
                        if (n != null && y.d(com.baidu.navisdk.framework.a.c().a()) && n.q()) {
                            n.t();
                        }
                    }
                } catch (Throwable th) {
                    if (LogUtil.LOGGABLE) {
                        th.printStackTrace();
                    }
                } finally {
                }
            }
        }
        return n;
    }

    private boolean q() {
        File o = o();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-BNCoreStat", "isExistOfflineStatLogFile() e=" + o.exists());
        }
        return o.exists();
    }

    private void r() {
        String b2;
        FileInputStream fileInputStream;
        if (s() && (b2 = m0.j().b()) != null && b2.length() > 0) {
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(b2 + File.separator + "navi_simple.log");
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.j.load(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    e = e2;
                    if (!LogUtil.LOGGABLE) {
                        return;
                    }
                    e.printStackTrace();
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream2 = fileInputStream;
                if (LogUtil.LOGGABLE) {
                    e.printStackTrace();
                }
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e4) {
                        e = e4;
                        if (!LogUtil.LOGGABLE) {
                            return;
                        }
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e5) {
                        if (LogUtil.LOGGABLE) {
                            e5.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        }
    }

    private boolean s() {
        String b2 = m0.j().b();
        if (b2 != null && b2.length() > 0) {
            File file = new File(b2 + File.separator + "navi_simple.log");
            if (file.exists()) {
                return true;
            }
            try {
                return file.createNewFile();
            } catch (IOException unused) {
            }
        }
        return false;
    }

    private void t() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-BNCoreStat", "uploadOfflineStatLog() ");
        }
        com.baidu.navisdk.util.worker.c.a().c(new c("CarNavi-uploadOfflineStatLog", null), new e(202, 0));
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String h() {
        return "Statistics-BNCoreStat";
    }

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.util.http.center.f {
        public b() {
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            a.this.l = i;
            LogUtil.e("Statistics-BNCoreStat", " HttpHead 服务器返回状态failed:" + a.this.l);
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            a.this.l = i;
            LogUtil.e("Statistics-BNCoreStat", " HttpHead 服务器返回状态ok:" + a.this.l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        FileOutputStream fileOutputStream;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-BNCoreStat", "writeDataOfflineStatLogToFile() s=" + str);
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(o(), true);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            fileOutputStream.write(str.getBytes("utf-8"));
            fileOutputStream.write(System.getProperty("line.separator").getBytes());
            fileOutputStream.flush();
            try {
                fileOutputStream.close();
            } catch (IOException e2) {
                e = e2;
                if (!LogUtil.LOGGABLE) {
                    return;
                }
                LogUtil.e("navSDK", e.getMessage());
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            if (LogUtil.LOGGABLE) {
                LogUtil.e("Statistics-BNCoreStat", e.getMessage());
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                    e = e4;
                    if (!LogUtil.LOGGABLE) {
                        return;
                    }
                    LogUtil.e("navSDK", e.getMessage());
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("navSDK", e5.getMessage());
                    }
                }
            }
            throw th;
        }
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String d() {
        return this.m + "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        LogUtil.e("Statistics-BNCoreStat", "UserdataCollect behaviour:" + str);
        com.baidu.navisdk.framework.b.c(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(RoutePlanNode routePlanNode) {
        if (routePlanNode == null || routePlanNode.getGeoPoint() == null) {
            return "-1,-1";
        }
        return String.valueOf(routePlanNode.getLongitudeE6()) + "," + String.valueOf(routePlanNode.getLatitudeE6());
    }

    public void a(RoutePlanNode routePlanNode, RoutePlanNode routePlanNode2, String str, String str2, String str3) {
        a(routePlanNode, routePlanNode2, str, str2, str3, 1, 0);
    }

    public void a(RoutePlanNode routePlanNode, RoutePlanNode routePlanNode2, String str, String str2, String str3, int i, int i2) {
        try {
            com.baidu.navisdk.util.worker.c.a().c(new C0507a("sendNaviStatistics", null, routePlanNode, routePlanNode2, str, str2, str3, i2, i), new e(202, 0));
        } catch (Throwable th) {
            if (LogUtil.LOGGABLE) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        String str9 = a0.f9218a;
        String str10 = a0.b;
        String k = a0.k();
        String e = a0.e();
        String d = a0.d();
        this.l = 0;
        try {
            String str11 = com.baidu.navisdk.util.statistic.core.b.f9370a + "&mode=" + URLEncoder.encode("driving", "UTF-8") + "&da_src=" + URLEncoder.encode(str7, "UTF-8") + "&mb=" + URLEncoder.encode(str9, "UTF-8") + "&os=" + URLEncoder.encode(str10, "UTF-8") + "&sv=" + URLEncoder.encode(k, "UTF-8") + "&cuid=" + URLEncoder.encode(e, "UTF-8") + "&channel=" + URLEncoder.encode(d, "UTF-8") + "&ctm=" + URLEncoder.encode(String.valueOf(System.currentTimeMillis()), "UTF-8") + "&navi_city=" + URLEncoder.encode(String.valueOf(com.baidu.navisdk.framework.b.l()), "UTF-8") + "&sn=" + URLEncoder.encode(str, "UTF-8") + "&en=" + URLEncoder.encode(str2, "UTF-8") + "&sc=" + URLEncoder.encode(str3, "UTF-8") + "&ec=" + URLEncoder.encode(str4, "UTF-8") + "&nav_act=" + URLEncoder.encode(str5, "UTF-8") + "&nav_net=" + URLEncoder.encode(str6, "UTF-8") + "&nav_enter=" + URLEncoder.encode(str7, "UTF-8") + "&trip=" + URLEncoder.encode(str8, "UTF-8");
            LogUtil.e("Statistics-BNCoreStat", "URL:" + str11);
            com.baidu.navisdk.util.http.center.e eVar = new com.baidu.navisdk.util.http.center.e();
            eVar.f9300a = false;
            com.baidu.navisdk.util.http.center.b.a().a(str11, null, new b(), eVar);
            LogUtil.e("Statistics-BNCoreStat", str11 + " HttpHead 服务器返回状态ret:" + this.l);
        } catch (Throwable th) {
            if (LogUtil.LOGGABLE) {
                th.printStackTrace();
            }
        }
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(RoutePlanNode routePlanNode) {
        if (routePlanNode != null) {
            return String.valueOf(routePlanNode.mDistrictID);
        }
        return "-1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (MapItem.KEY_IS_MAP_ITEM.equals(str5)) {
            this.m = MsgField.MSG_SESSION_INVALID;
        } else if ("edog".equals(str5)) {
            this.m = MsgField.MSG_HIDE_UI_BTN;
        } else if ("yaw".equals(str5)) {
            this.m = MsgField.MSG_VPS_STATISTIC;
        } else if ("route_plan".equals(str5)) {
            this.m = MsgField.MSG_MARKER_CREATE_SESSION_BEGIN;
        } else if ("download".equals(str5)) {
            this.m = MsgField.MSG_MARKER_CREATE_SESSION_END;
        } else if ("settings".equals(str5)) {
            this.m = MsgField.MSG_MARKER_CREATE_SESSION_FAIL;
        }
        b("sn", str);
        b(Languages.DEFAULT_LANGUAGE, str2);
        b("sc", str3);
        b("ec", str4);
        b("nav_act", str5);
        b("nav_net", str6);
        b("nav_enter", str7);
        b("mode", "driving");
        b("da_src", str7);
        b("ctm", String.valueOf(System.currentTimeMillis()));
        b("navi_city", String.valueOf(com.baidu.navisdk.framework.b.l()));
        LogUtil.e("Statistics-BNCoreStat", "BNCoreStat-onEvent->id=" + d() + "naviAction " + str5 + " eventId " + this.m + " naviNet " + str6 + " naviEnter " + str7);
        super.k();
    }
}
