package com.baidu.navisdk.comapi.statistics;

import android.content.Context;
import android.os.Message;
import com.baidu.navisdk.jni.nativeif.JNIStatisticsControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.common.n;
import com.baidu.navisdk.util.common.s;
import com.baidu.navisdk.util.common.y;
import com.baidu.navisdk.util.statistic.h;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class b extends d {
    private static h h;
    private static b i;

    /* renamed from: a, reason: collision with root package name */
    private final com.baidu.navisdk.comapi.statistics.c f6731a;
    JNIStatisticsControl b;
    private final e c;
    private final e d;
    private final com.baidu.navisdk.comapi.statistics.a e;
    private final com.baidu.navisdk.util.statistic.a f;
    private final n.b g;

    /* renamed from: com.baidu.navisdk.comapi.statistics.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0184b extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6732a;
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0184b(b bVar, String str, String str2, String str3, String str4) {
            super(str, str2);
            this.f6732a = str3;
            this.b = str4;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            s.b(this.f6732a, this.b);
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6733a;
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, String str3, String str4) {
            super(str, str2);
            this.f6733a = str3;
            this.b = str4;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (!y.d(com.baidu.navisdk.framework.a.c().a())) {
                return null;
            }
            if (b.this.f6731a.b(this.f6733a) && this.b != null) {
                File file = new File(this.b);
                boolean delete = file.exists() ? file.delete() : false;
                if (!LogUtil.LOGGABLE) {
                    return null;
                }
                LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "pushStatistics->上报成功，删除缓存文件, delFile=" + delete);
                return null;
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "pushStatistics->上报失败，缓存统计文件, file=" + this.b);
            }
            s.b(this.b, this.f6733a);
            return null;
        }
    }

    private b() {
        new HashMap();
        this.c = new e();
        this.d = new e();
        this.e = new com.baidu.navisdk.comapi.statistics.a();
        this.f = new com.baidu.navisdk.util.statistic.a();
        this.g = new a();
        this.b = JNIStatisticsControl.sInstance;
        this.f6731a = new com.baidu.navisdk.comapi.statistics.c();
    }

    @Deprecated
    private void b(String str, String str2) {
    }

    public static b f() {
        if (i == null) {
            i = new b();
        }
        return i;
    }

    private void g() {
        n.d().a(this.g);
        n.d().a(11, -1, -1, null, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics_BNStatisticsManager", "pushSessionInBatches->mBatchesSessiton.size=" + this.d.d());
        }
        e b = this.d.b();
        this.d.a();
        this.f6731a.a(b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics_BNStatisticsManager", "pushSessionWithNaviFinish->session.size=" + this.c.d() + ", mBatchesSessiton.size=" + this.d.d());
        }
        e eVar = new e();
        eVar.a(this.c.c());
        eVar.a(this.d.c());
        this.c.a();
        this.d.a();
        this.f6731a.a(eVar);
    }

    @Deprecated
    public void a(int i2) {
    }

    public void e() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics_BNStatisticsManager", "upLoadStatistics->");
        }
        if (y.d(com.baidu.navisdk.framework.a.c().a())) {
            n.d().a(13, -1, -1, null, 0L);
            n.d().a(1);
            n.d().a(1, 0, 0, null, 0L);
        }
    }

    @Override // com.baidu.navisdk.comapi.statistics.d
    public void c(String str) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics_BNStatisticsManager", "uploadHistoryStatistics-> historyFolderPath=" + str);
        }
        if (l0.c(str)) {
            return;
        }
        this.f6731a.c(str);
    }

    public void d() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics_BNStatisticsManager", "init->");
        }
        g();
        this.f.a();
        this.b.init(a0.d(), a0.e());
    }

    /* loaded from: classes7.dex */
    public class a extends n.b {
        public a() {
        }

        @Override // com.baidu.navisdk.util.common.n.b
        public void a() {
            a(12);
            a(13);
            a(11);
        }

        @Override // com.baidu.navisdk.util.common.n.b
        public void a(Message message) {
            switch (message.what) {
                case 11:
                    b.this.f6731a.b();
                    b.this.e();
                    return;
                case 12:
                    Object obj = message.obj;
                    if (obj == null || !(obj instanceof g)) {
                        return;
                    }
                    g gVar = (g) obj;
                    int d = gVar.d();
                    if (d == 1) {
                        b.this.a(gVar.a(), gVar.c(), false);
                        b.this.b(gVar);
                        int b = gVar.b();
                        if (50003 == gVar.b()) {
                            if (LogUtil.LOGGABLE) {
                                LogUtil.e("Statistics_BNStatisticsManager", "ONEVEN->导航结束，上传所有统计!");
                            }
                            b.this.i();
                            return;
                        } else {
                            if (LogUtil.LOGGABLE) {
                                LogUtil.e("Statistics_BNStatisticsManager", "ONEVEN->" + b + "添加到缓存集合，导航结束时一并上传!");
                                return;
                            }
                            return;
                        }
                    }
                    if (d == 3) {
                        b.this.a(gVar.a(), gVar.c(), false);
                        int d2 = b.this.d.d();
                        int a2 = b.this.a().a();
                        if (d2 < a2) {
                            b.this.d.a(gVar);
                            d2++;
                            if (LogUtil.LOGGABLE) {
                                LogUtil.e("Statistics_BNStatisticsManager", "ONEVEN->分批上传，size=" + d2);
                            }
                        }
                        if (d2 >= a2) {
                            b.this.h();
                            return;
                        }
                        return;
                    }
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("Statistics_BNStatisticsManager", "ONEVEN->实时上报!");
                    }
                    b.this.a(gVar.a(), gVar.c());
                    return;
                case 13:
                    if (y.d(com.baidu.navisdk.framework.a.c().a())) {
                        b bVar = b.this;
                        bVar.c(bVar.b());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void a(JSONObject jSONObject) {
        int optInt;
        if (jSONObject != null) {
            try {
                int optInt2 = jSONObject.optInt("max_content_size", 0);
                if (optInt2 > 0) {
                    this.e.b(optInt2);
                }
            } catch (Exception e) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.printException("Statistics_BNStatisticsManager", e);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("upload_config");
            if (optJSONObject != null) {
                try {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("real_time_upload");
                    if (optJSONObject2 != null) {
                        this.e.d(optJSONObject2.optString("ids", ""));
                    }
                } catch (Exception e2) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.printException("Statistics_BNStatisticsManager", e2);
                    }
                }
                try {
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject("batch_upload");
                    if (optJSONObject3 != null) {
                        this.e.a(optJSONObject3.optString("ids", ""));
                        int optInt3 = optJSONObject3.optInt("batch_max_count", 0);
                        if (optInt3 > 0) {
                            this.e.a(optInt3);
                        }
                    }
                } catch (Exception e3) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.printException("Statistics_BNStatisticsManager", e3);
                    }
                }
                try {
                    JSONObject optJSONObject4 = optJSONObject.optJSONObject("navi_finish_upload");
                    if (optJSONObject4 != null) {
                        this.e.c(optJSONObject4.optString("ids", ""));
                    }
                } catch (Exception e4) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.printException("Statistics_BNStatisticsManager", e4);
                    }
                }
            }
            try {
                JSONObject optJSONObject5 = jSONObject.optJSONObject("userOp_config");
                if (optJSONObject5 != null && (optInt = optJSONObject5.optInt("userOp_max_content_size", 0)) > 0) {
                    this.e.c(optInt);
                }
            } catch (Exception e5) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.printException("Statistics_BNStatisticsManager", e5);
                }
            }
            try {
                this.e.b(jSONObject.optString("ignored", ""));
            } catch (Exception e6) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.printException("Statistics_BNStatisticsManager", e6);
                }
            }
        }
    }

    @Override // com.baidu.navisdk.comapi.statistics.d
    public boolean b(String str) {
        List<String> c2 = a().c();
        return c2 != null && c2.contains(str);
    }

    @Override // com.baidu.navisdk.comapi.statistics.d
    public String b() {
        return this.f6731a.a();
    }

    public void b(g gVar) {
        if (gVar != null) {
            this.c.a(gVar);
        }
    }

    @Override // com.baidu.navisdk.comapi.statistics.d
    public int c() {
        com.baidu.navisdk.framework.interfaces.g d = com.baidu.navisdk.framework.interfaces.c.p().d();
        if (d != null) {
            return d.b();
        }
        return 1;
    }

    @Deprecated
    public void d(String str) {
        b(str, "1");
    }

    @Override // com.baidu.navisdk.comapi.statistics.d
    public com.baidu.navisdk.comapi.statistics.a a() {
        return this.e;
    }

    public void a(Context context, String str, String str2) {
        h hVar = h;
        if (hVar == null || context == null) {
            return;
        }
        hVar.a(context, str, str2);
    }

    @Override // com.baidu.navisdk.comapi.statistics.d
    public void a(g gVar) {
        if (gVar != null) {
            n.d().a(12, 0, 0, gVar, 0L);
        }
    }

    @Override // com.baidu.navisdk.comapi.statistics.d
    public void a(String str, String str2, boolean z) {
        if (z) {
            com.baidu.navisdk.util.worker.c.a().c(new C0184b(this, "Statistics_BNStatisticsManager-flush", null, str, str2), new com.baidu.navisdk.util.worker.e(202, 0));
        } else {
            s.b(str, str2);
        }
    }

    @Override // com.baidu.navisdk.comapi.statistics.d
    public File a(String str) {
        File file = null;
        try {
            File file2 = new File(str);
            try {
                if (!file2.exists()) {
                    if (!file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    if (!file2.createNewFile()) {
                        return null;
                    }
                }
                return file2;
            } catch (IOException e) {
                e = e;
                file = file2;
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.STATISTICS;
                if (!gVar.c()) {
                    return file;
                }
                gVar.c("createCacheFile cause=" + e.getCause() + "detail:" + e);
                return file;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    public void a(String str, String str2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics_BNStatisticsManager", "pushStatistics->cacheFilePath=" + str2);
        }
        if (l0.c(str2)) {
            return;
        }
        com.baidu.navisdk.util.worker.c.a().c(new c("Statistics_BNStatisticsManager-pushStatistics", null, str2, str), new com.baidu.navisdk.util.worker.e(202, 0));
    }
}
