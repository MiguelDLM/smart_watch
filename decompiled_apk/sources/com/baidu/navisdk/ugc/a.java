package com.baidu.navisdk.ugc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.navisdk.comapi.mapcontrol.MapParams;
import com.baidu.navisdk.framework.interfaces.q;
import com.baidu.navisdk.ugc.eventdetails.control.a;
import com.baidu.nplatform.comapi.MapItem;

/* loaded from: classes8.dex */
public class a implements q {

    /* renamed from: a, reason: collision with root package name */
    private b f8013a;
    private boolean d = false;
    private com.baidu.navisdk.ugc.eventdetails.control.a c = com.baidu.navisdk.ugc.eventdetails.control.a.I();
    private a.g b = new C0367a();

    /* loaded from: classes8.dex */
    public static abstract class b {
        public abstract Activity a();

        public void a(int i, Bundle bundle) {
        }

        public abstract int b();

        public boolean c() {
            return false;
        }

        public abstract boolean d();

        public abstract boolean e();

        public abstract void f();

        public boolean a(int i) {
            return false;
        }

        public String a(String str) {
            return com.baidu.navisdk.framework.b.d(str);
        }
    }

    public a(b bVar) {
        this.f8013a = bVar;
    }

    public boolean C() {
        return this.d;
    }

    public void b0() {
        com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.c;
        if (aVar != null) {
            aVar.z();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.p
    public boolean n0() {
        com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.c;
        if (aVar != null && aVar.w()) {
            return true;
        }
        return false;
    }

    public void o(int i) {
        com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.c;
        if (aVar != null) {
            aVar.d(i);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.p
    public void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.c;
        if (aVar != null) {
            aVar.a(i, i2, intent);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.p
    public void onDestroy() {
        com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.c;
        if (aVar != null) {
            aVar.y();
        }
        this.d = false;
    }

    public void v0() {
        com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.c;
        if (aVar != null) {
            aVar.A();
        }
    }

    /* renamed from: com.baidu.navisdk.ugc.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0367a extends a.g {
        public C0367a() {
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.control.a.g
        public String a(String str) {
            return a.this.f8013a != null ? a.this.f8013a.a(str) : str;
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.control.a.g
        public int b() {
            if (a.this.f8013a != null) {
                return a.this.f8013a.b();
            }
            return super.b();
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.control.a.g
        public boolean c() {
            if (a.this.f8013a != null) {
                return a.this.f8013a.c();
            }
            return super.c();
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.control.a.g
        public boolean d() {
            if (a.this.f8013a != null) {
                return a.this.f8013a.d();
            }
            return super.d();
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.control.a.g
        public boolean e() {
            if (a.this.f8013a != null) {
                return a.this.f8013a.e();
            }
            return super.e();
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.control.a.g
        public void f() {
            a.this.d = false;
            if (a.this.f8013a != null) {
                a.this.f8013a.f();
            }
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.control.a.g
        public boolean a(int i) {
            if (a.this.f8013a != null) {
                return a.this.f8013a.a(i);
            }
            return super.a(i);
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.control.a.g
        public void a(int i, Bundle bundle) {
            if (a.this.f8013a != null) {
                a.this.f8013a.a(i, bundle);
            }
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.control.a.g
        public Activity a() {
            if (a.this.f8013a != null) {
                return a.this.f8013a.a();
            }
            return null;
        }
    }

    public View a(Context context, String str, String str2, Bundle bundle, int i) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!bundle.containsKey("source")) {
            bundle.putInt("source", 10);
        }
        if (!bundle.containsKey("page")) {
            bundle.putInt("page", 4);
        }
        if (!bundle.containsKey(MapParams.PanoramaKeys.EVENT_TYPE)) {
            bundle.putInt(MapParams.PanoramaKeys.EVENT_TYPE, 0);
        }
        if (!bundle.containsKey(MapItem.KEY_JAM_INDEX)) {
            bundle.putInt(MapItem.KEY_JAM_INDEX, -1);
        }
        if (this.c == null) {
            this.c = com.baidu.navisdk.ugc.eventdetails.control.a.I();
        }
        this.d = true;
        boolean z = bundle.getBoolean("isOrientationChange", false);
        if (!z) {
            this.c.a(str, bundle, str2);
        }
        return this.c.a(context, this.b, i, z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.p
    public boolean a(int i) {
        com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.c;
        return aVar != null && aVar.e(i);
    }

    public void a(com.baidu.navisdk.comapi.ugc.a aVar) {
        com.baidu.navisdk.ugc.eventdetails.control.a aVar2 = this.c;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }
}
