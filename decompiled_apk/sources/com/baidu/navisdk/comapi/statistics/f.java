package com.baidu.navisdk.comapi.statistics;

import O0OOX0IIx.I0Io;
import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.l0;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public abstract class f extends com.baidu.navisdk.module.statistics.a {

    /* renamed from: a, reason: collision with root package name */
    private d f6737a;
    private File b;
    private String e;
    private String f;
    private long g;
    private long h;
    private Map<String, String> c = new ConcurrentHashMap();
    private Map<String, String> d = new ConcurrentHashMap();
    private Handler i = new a(h());

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.a {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            if (message.what == 100) {
                f.this.a((String) message.obj, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6739a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, String str3) {
            super(str, str2);
            this.f6739a = str3;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            f.this.b(this.f6739a);
            return null;
        }
    }

    public f(d dVar) {
        this.f6737a = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (this.f6737a == null || l0.c(str)) {
            return;
        }
        File file = this.b;
        if (file == null || !file.exists()) {
            this.b = this.f6737a.a(a());
            if (LogUtil.LOGGABLE) {
                String h = h();
                StringBuilder sb = new StringBuilder();
                sb.append("createCacheFile-> mCacheFile:");
                File file2 = this.b;
                sb.append(file2 == null ? null : file2.getAbsolutePath());
                LogUtil.e(h, sb.toString());
            }
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(h(), "writeToFile->mTmpStatStr=" + str);
        }
        File file3 = this.b;
        if (file3 == null || !file3.exists()) {
            return;
        }
        this.f6737a.a(file3.getAbsolutePath(), str, false);
    }

    @Deprecated
    private void n() {
        if (!this.c.containsKey("tm_ms")) {
            b("tm_ms", this.h + "");
        }
    }

    private void o() {
        Handler handler = this.i;
        if (handler != null) {
            handler.removeMessages(100);
        }
    }

    private long p() {
        if (this.g == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.h = currentTimeMillis;
            this.g = currentTimeMillis / 1000;
        }
        return this.g;
    }

    public void c(int i) {
        b("scene", String.valueOf(i));
        a(false);
    }

    public abstract String d();

    public int e() {
        return 1;
    }

    public d f() {
        return this.f6737a;
    }

    public Map<String, String> g() {
        return this.c;
    }

    public abstract String h();

    public int i() {
        String d = d();
        com.baidu.navisdk.comapi.statistics.a b2 = b();
        List<String> f = b2.f();
        if (f != null && f.contains(d)) {
            return 0;
        }
        List<String> b3 = b2.b();
        if (b3 != null && b3.contains(d)) {
            return 3;
        }
        List<String> e = b2.e();
        if (e == null || !e.contains(d)) {
            return 0;
        }
        return 1;
    }

    public boolean j() {
        d dVar = this.f6737a;
        if (dVar != null && dVar.b(d())) {
            return true;
        }
        return false;
    }

    public final void k() {
        b(0);
    }

    public void l() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(h(), "reset-> ");
        }
        this.c.clear();
        this.d.clear();
        this.b = null;
        this.g = 0L;
        this.h = 0L;
        this.e = null;
        this.f = null;
    }

    public String m() {
        JSONObject a2;
        if (!l0.c(this.e)) {
            a2 = c(this.e, this.f);
        } else {
            if (!this.c.containsKey(TTDownloadField.TT_REFER)) {
                this.c.put(TTDownloadField.TT_REFER, this.f6737a.c() + "");
            }
            a2 = a(this.c, this.d);
        }
        return a2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        if (j()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(h(), "writeToFile->isIgnored=true,return !");
            }
        } else {
            if (z) {
                com.baidu.navisdk.util.worker.c.a().c(new b(h() + "-writeToFile", null, str), new com.baidu.navisdk.util.worker.e(202, 0));
                return;
            }
            b(str);
        }
    }

    public String c() {
        return d();
    }

    public JSONObject c(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            return a(new JSONObject(str), !l0.c(str2) ? new JSONObject(str2) : null);
        } catch (Exception e) {
            if (!LogUtil.LOGGABLE) {
                return jSONObject;
            }
            e.printStackTrace();
            LogUtil.printException(h(), e);
            return jSONObject;
        }
    }

    public String a() {
        if (this.f6737a == null) {
            return null;
        }
        p();
        return this.f6737a.b() + "/" + c() + "_" + this.g + ".txt";
    }

    public String a(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(h(), "flush->isForce=" + z);
        }
        if (j()) {
            if (!LogUtil.LOGGABLE) {
                return "";
            }
            LogUtil.e(h(), "flush->isIgnored = true, return !");
            return "";
        }
        p();
        n();
        String m = m();
        Handler handler = this.i;
        if (handler != null) {
            if (!z) {
                if (!handler.hasMessages(100)) {
                    Message obtainMessage = this.i.obtainMessage();
                    obtainMessage.what = 100;
                    obtainMessage.obj = m;
                    this.i.sendMessageDelayed(obtainMessage, 5000L);
                }
            } else {
                handler.removeMessages(100);
                a(m, true);
            }
        }
        return m;
    }

    public void b(String str, String str2) {
        if (l0.c(str)) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        this.c.put(str, str2);
    }

    public void b(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(h(), "onEvent->Id=" + d() + ",isIgnored:" + j() + ", uploadScene:" + i);
            if (!this.c.containsKey(TTDownloadField.TT_REFER)) {
                LogUtil.e(h(), d() + "-onEvent refer is not contains");
            } else {
                LogUtil.e(h(), d() + "-onEvent refer: " + this.c.get(TTDownloadField.TT_REFER));
            }
        }
        o();
        if (this.f6737a != null && !j()) {
            n();
            this.f6737a.a(a(i));
        }
        l();
    }

    public com.baidu.navisdk.comapi.statistics.a b() {
        return this.f6737a.a();
    }

    public void a(String str, String str2) {
        if (l0.c(str)) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        this.d.put(str, str2);
    }

    public void a(String str) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(h(), "addCompleStatStr-> statStr:" + str);
        }
        this.e = str;
    }

    private JSONObject a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map == null) {
            return jSONObject;
        }
        HashMap hashMap = new HashMap(map);
        try {
            for (String str : hashMap.keySet()) {
                String str2 = (String) hashMap.get(str);
                jSONObject.put(str, str2 != null ? str2.trim() : "");
            }
        } catch (JSONException e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException(h() + "_getParam", e);
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public g a(int i) {
        g gVar = new g();
        File file = this.b;
        gVar.a(file != null ? file.getAbsolutePath() : a());
        gVar.a(Integer.parseInt(d()));
        gVar.b(m());
        gVar.b(i != 1 ? i() : 1);
        return gVar;
    }

    public JSONObject a(Map<String, String> map, Map<String, String> map2) {
        return a(a(map), a(map2));
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("lt", e());
            jSONObject3.put("tm", this.g);
            jSONObject3.put(I0Io.f1285X0o0xo, d() + "");
            jSONObject3.put("ActParam", jSONObject);
            if (jSONObject2 != null && jSONObject2.length() > 0) {
                jSONObject3.put("bu", jSONObject2);
            }
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
                LogUtil.printException(h(), e);
            }
        }
        return jSONObject3;
    }
}
