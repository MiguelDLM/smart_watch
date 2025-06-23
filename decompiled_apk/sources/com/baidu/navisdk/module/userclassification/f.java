package com.baidu.navisdk.module.userclassification;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.j;
import com.baidu.navisdk.util.common.g;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final HashSet<com.baidu.navisdk.module.userclassification.e> f7597a;
    private final HashMap<String, JSONObject> b;
    private final com.baidu.navisdk.module.userclassification.d c;
    private final com.baidu.navisdk.module.userclassification.a d;
    private final AtomicInteger e;
    private JSONObject f;
    private JSONObject g;
    private volatile boolean h;
    private long i;
    private boolean j;
    private Handler k;
    private HandlerThread l;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            f.this.a(message);
        }
    }

    /* loaded from: classes7.dex */
    public class d extends com.baidu.navisdk.util.worker.lite.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.module.userclassification.e f7601a;
        final /* synthetic */ Set b;
        final /* synthetic */ Map c;
        final /* synthetic */ boolean d;
        final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(f fVar, String str, com.baidu.navisdk.module.userclassification.e eVar, Set set, Map map, boolean z, long j) {
            super(str);
            this.f7601a = eVar;
            this.b = set;
            this.c = map;
            this.d = z;
            this.e = j;
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            g gVar = g.COMMON;
            if (gVar.d()) {
                gVar.e(com.baidu.navisdk.util.worker.g.TAG, "notifyConfigsListener::thread --> listener = " + this.f7601a + ", configKeys = " + this.b);
            }
            this.f7601a.a(this.c, this.d, this.e);
        }
    }

    /* loaded from: classes7.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        JSONObject f7602a;
        JSONObject b;

        public e(JSONObject jSONObject, JSONObject jSONObject2) {
            this.f7602a = jSONObject;
            this.b = jSONObject2;
        }
    }

    /* renamed from: com.baidu.navisdk.module.userclassification.f$f, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0299f {

        /* renamed from: a, reason: collision with root package name */
        private static final f f7603a = new f(null);
    }

    public /* synthetic */ f(a aVar) {
        this();
    }

    private void c(Message message) {
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("UserClassConfigRepository", "registerConfigListenerInner --> message = " + message);
        }
        Object obj = message.obj;
        if (obj instanceof com.baidu.navisdk.module.userclassification.e) {
            this.f7597a.add((com.baidu.navisdk.module.userclassification.e) obj);
        }
    }

    private void d(Message message) {
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("UserClassConfigRepository", "unregisterConfigListenerInner --> message = " + message);
        }
        Object obj = message.obj;
        if (!(obj instanceof com.baidu.navisdk.module.userclassification.e)) {
            return;
        }
        this.f7597a.remove((com.baidu.navisdk.module.userclassification.e) obj);
    }

    private f() {
        this.f7597a = new HashSet<>();
        this.b = new HashMap<>();
        this.c = new com.baidu.navisdk.module.userclassification.d();
        this.d = new com.baidu.navisdk.module.userclassification.a();
        this.e = new AtomicInteger(0);
        if (j.c()) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("UserClassConfigRepository");
        this.l = handlerThread;
        handlerThread.start();
        this.k = new a(this.l.getLooper());
    }

    /* loaded from: classes7.dex */
    public class c implements com.baidu.navisdk.module.userclassification.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7600a;
        final /* synthetic */ String b;

        public c(Context context, String str) {
            this.f7600a = context;
            this.b = str;
        }

        @Override // com.baidu.navisdk.module.userclassification.b
        public void a(@NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
            g gVar = g.COMMON;
            if (gVar.d()) {
                gVar.e("UserClassConfigRepository", "requestCloudConfigs::onConfigsLoaded! userGroup = " + jSONObject2);
            }
            f fVar = f.this;
            if (jSONObject2 == null) {
                jSONObject2 = fVar.g;
            }
            fVar.a(jSONObject, jSONObject2, true);
        }

        @Override // com.baidu.navisdk.module.userclassification.b
        public void a(int i, @Nullable JSONObject jSONObject) {
            g gVar = g.COMMON;
            if (gVar.d()) {
                gVar.e("UserClassConfigRepository", "requestCloudConfigs::onDataNotAvailable --> errorCode = " + i + ", userGroup = " + jSONObject);
            }
            if (i != 304) {
                f.this.a(this.f7600a, this.b);
                return;
            }
            f fVar = f.this;
            JSONObject jSONObject2 = fVar.f;
            if (jSONObject == null) {
                jSONObject = f.this.g;
            }
            fVar.a(jSONObject2, jSONObject, true);
        }
    }

    public void b(com.baidu.navisdk.module.userclassification.e eVar) {
        Handler handler;
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("UserClassConfigRepository", "unregisterConfigListener --> listener = " + eVar);
        }
        if (eVar == null || (handler = this.k) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage(2);
        obtainMessage.obj = eVar;
        this.k.sendMessage(obtainMessage);
    }

    public static f a() {
        return C0299f.f7603a;
    }

    private void c(com.baidu.navisdk.module.userclassification.e eVar) {
        a(eVar, false);
    }

    public void a(com.baidu.navisdk.module.userclassification.e eVar) {
        Handler handler;
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("UserClassConfigRepository", "registerConfigListener --> listener = " + eVar);
        }
        if (eVar == null || (handler = this.k) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage(1);
        obtainMessage.obj = eVar;
        this.k.sendMessage(obtainMessage);
        if (this.h) {
            a(eVar, true);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements com.baidu.navisdk.module.userclassification.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7599a;

        public b(Context context) {
            this.f7599a = context;
        }

        @Override // com.baidu.navisdk.module.userclassification.b
        public void a(@NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
            g gVar = g.COMMON;
            if (gVar.d()) {
                gVar.e("UserClassConfigRepository", "requestConfigs::onConfigsLoaded! userGroup = " + jSONObject2);
            }
            String optString = jSONObject.optString("etag", "");
            if (!TextUtils.isEmpty(optString)) {
                f.this.f = jSONObject;
            } else {
                f.this.f = null;
            }
            f.this.g = jSONObject2;
            f.this.a(this.f7599a, optString);
        }

        @Override // com.baidu.navisdk.module.userclassification.b
        public void a(int i, @Nullable JSONObject jSONObject) {
            g gVar = g.COMMON;
            if (gVar.d()) {
                gVar.e("UserClassConfigRepository", "requestConfigs::onDataNotAvailable --> errorCode = " + i + ", userGroup = " + jSONObject);
            }
            f.this.f = null;
            f.this.g = jSONObject;
            f.this.a(this.f7599a, "");
        }
    }

    private void b(Message message) {
        this.j = message.arg1 == 0;
        this.b.clear();
        Object obj = message.obj;
        if (!(obj instanceof e)) {
            b();
            return;
        }
        e eVar = (e) obj;
        this.b.put("usergroup", eVar.f7602a);
        JSONObject jSONObject = eVar.b;
        if (jSONObject == null) {
            b();
        } else {
            a(jSONObject);
            b();
        }
    }

    public void a(@NonNull Context context) {
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("UserClassConfigRepository", "requestConfigs --> context = " + context);
        }
        this.h = false;
        this.i = 0L;
        this.j = false;
        this.e.set(0);
        this.c.a(context, "", new b(context));
    }

    private void b() {
        this.i = System.currentTimeMillis();
        this.h = true;
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("UserClassConfigRepository", "notifyAllConfigsListener --> configsSize = " + this.b.size() + ", mUpdateTime = " + this.i + ", isFromOnline = " + this.j);
        }
        Iterator<com.baidu.navisdk.module.userclassification.e> it = this.f7597a.iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.module.userclassification.e next = it.next();
            if (next != null) {
                c(next);
            }
        }
    }

    @Nullable
    public JSONObject a(String str) {
        if (this.h) {
            return (JSONObject) new HashMap(this.b).get(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str) {
        g gVar = g.COMMON;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("requestCloudConfigs --> context = ");
            sb.append(context);
            sb.append(", etag = ");
            sb.append(str);
            sb.append(", onlineRequestCount = ");
            sb.append(this.e.get());
            sb.append(", mLocalConfigsIsNull = ");
            sb.append(this.f == null);
            gVar.e("UserClassConfigRepository", sb.toString());
        }
        if (this.e.getAndIncrement() >= 3) {
            if (gVar.d()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("requestCloudConfigs --> cloud request more than 3, and local configs is ");
                sb2.append(this.f == null ? "null" : "not null");
                gVar.e("UserClassConfigRepository", sb2.toString());
            }
            a(this.f, this.g, false);
            return;
        }
        this.d.a(context, str, new c(context, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2, boolean z) {
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("UserClassConfigRepository", "parseConfigData --> configs = " + jSONObject + ", isFromOnline = " + z);
        }
        Handler handler = this.k;
        if (handler == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage(0);
        obtainMessage.arg1 = !z ? 1 : 0;
        obtainMessage.obj = new e(jSONObject2, jSONObject);
        this.k.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        int i = message.what;
        if (i == 0) {
            b(message);
        } else if (i == 1) {
            c(message);
        } else {
            if (i != 2) {
                return;
            }
            d(message);
        }
    }

    private void a(@NonNull JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            if (optJSONObject != null) {
                this.b.put(next, optJSONObject);
            }
        }
    }

    private void a(com.baidu.navisdk.module.userclassification.e eVar, boolean z) {
        HashMap hashMap;
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("UserClassConfigRepository", "notifyConfigsListener --> listener = " + eVar + ", isUpdated = " + this.h + ", isSync = " + z);
        }
        if (eVar == null || !this.h) {
            return;
        }
        boolean z2 = this.j;
        long j = this.i;
        Set<String> a2 = eVar.a();
        if (a2 != null && !a2.isEmpty()) {
            hashMap = new HashMap();
            for (String str : a2) {
                hashMap.put(str, this.b.get(str));
            }
        } else {
            hashMap = new HashMap(this.b);
        }
        HashMap hashMap2 = hashMap;
        if (z) {
            g gVar2 = g.COMMON;
            if (gVar2.d()) {
                gVar2.e("UserClassConfigRepository", "notifyConfigsListener --> listener = " + eVar + ", configKeys = " + a2);
            }
            eVar.a(hashMap2, z2, j);
            return;
        }
        com.baidu.navisdk.util.worker.lite.a.a((com.baidu.navisdk.util.worker.lite.b) new d(this, "UserClassConfigRepository::notifyConfigListener", eVar, a2, hashMap2, z2, j), 10002);
    }
}
