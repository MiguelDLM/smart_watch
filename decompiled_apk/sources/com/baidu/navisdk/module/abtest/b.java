package com.baidu.navisdk.module.abtest;

import android.os.Bundle;
import android.os.Looper;
import com.baidu.navisdk.jni.nativeif.JNINaviManager;
import com.baidu.navisdk.module.abtest.model.j;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.c;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import com.baidu.navisdk.util.worker.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class b extends com.baidu.navisdk.module.statistics.abtest.a implements com.baidu.navisdk.framework.interfaces.a {
    private static Object b = new Object();

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, j> f6963a = Collections.synchronizedMap(new HashMap());

    /* loaded from: classes7.dex */
    public class a extends f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6964a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, int i) {
            super(str, str2);
            this.f6964a = i;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(g.TAG, "removeDataOnMainThread->");
            }
            b.this.p(this.f6964a);
            return null;
        }
    }

    private void C() {
        try {
            a(new com.baidu.navisdk.module.cloudconfig.g().e());
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("ABTest_initABTestDataFromLocal", e);
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i) {
        this.f6963a.remove(Integer.valueOf(i));
    }

    @Override // com.baidu.navisdk.framework.interfaces.a
    public void I() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ABTest", "onInit->");
        }
        C();
    }

    @Override // com.baidu.navisdk.module.statistics.abtest.a, com.baidu.navisdk.framework.interfaces.a
    public Bundle e(int i) {
        Bundle bundle = new Bundle();
        if (i <= 0) {
            return bundle;
        }
        boolean aBTestResultById = JNINaviManager.sInstance.getABTestResultById(i, bundle);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ABTest", "getABTestResultById->id=" + i + ", result=" + aBTestResultById + ", bundle=" + bundle);
        }
        return bundle;
    }

    @Override // com.baidu.navisdk.framework.interfaces.a
    public void j(int i) {
        this.f6963a.get(Integer.valueOf(i)).k();
    }

    @Override // com.baidu.navisdk.module.statistics.abtest.a
    public void o(int i) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("ABTestCenter", "removeDataOnMainThread->main thread");
            }
            p(i);
            return;
        }
        c.a().a((f) new a("ABTestCenter_removeDataOnMainThread", null, i), new e(99, 0));
    }

    @Override // com.baidu.navisdk.framework.interfaces.a
    public void a(JSONObject jSONObject) {
        boolean aBTestBuffer = JNINaviManager.sInstance.setABTestBuffer(jSONObject == null ? "" : jSONObject.toString());
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("onDataUpdate->abTestJson=");
            sb.append(jSONObject == null ? "null" : jSONObject.toString());
            sb.append(", result=");
            sb.append(aBTestBuffer);
            LogUtil.e("ABTest", sb.toString());
        }
        Map<Integer, j> map = this.f6963a;
        if (map == null || map.entrySet() == null || (r4 = this.f6963a.entrySet().iterator()) == null) {
            return;
        }
        for (Map.Entry<Integer, j> entry : this.f6963a.entrySet()) {
            if (entry != null && entry.getValue() != null) {
                entry.getValue().r();
            }
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.a
    public j g(int i) {
        j jVar = this.f6963a.get(Integer.valueOf(i));
        if (jVar == null) {
            synchronized (b) {
                try {
                    jVar = this.f6963a.get(Integer.valueOf(i));
                    if (jVar == null && (jVar = com.baidu.navisdk.module.abtest.a.a(i, this)) != null) {
                        this.f6963a.put(Integer.valueOf(i), jVar);
                    }
                } finally {
                }
            }
        }
        return jVar;
    }
}
