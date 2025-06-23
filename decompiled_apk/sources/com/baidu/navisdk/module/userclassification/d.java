package com.baidu.navisdk.module.userclassification;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.navisdk.util.common.LogUtil;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class d {

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.lite.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f7596a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, b bVar) {
            super(str);
            this.f7596a = bVar;
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            d.this.a(this.f7596a);
        }
    }

    public boolean a(@NonNull Context context, String str, @NonNull b bVar) {
        com.baidu.navisdk.util.worker.lite.a.a((com.baidu.navisdk.util.worker.lite.b) new a("LocalUserClassConfigResource::requestAllConfig", bVar), 10002);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LocalUserClassConfigResource", "requestLocalInner --> callback = " + bVar);
        }
        if (bVar == null) {
            return;
        }
        JSONObject d = c.d();
        if (d == null) {
            c.b();
        }
        JSONObject c = c.c();
        if (c == null) {
            c.a();
            bVar.a(10000, d);
        } else if (TextUtils.isEmpty(c.optString("etag", ""))) {
            c.a();
            bVar.a(20000, d);
        } else {
            bVar.a(c, d);
        }
    }
}
