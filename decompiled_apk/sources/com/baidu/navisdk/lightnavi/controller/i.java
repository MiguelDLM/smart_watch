package com.baidu.navisdk.lightnavi.controller;

import android.os.Bundle;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static int f6884a;

    /* loaded from: classes7.dex */
    public static class b extends c {
        private b() {
            super();
        }

        @Override // com.baidu.navisdk.lightnavi.controller.i.c
        public String a() {
            return "BrowserState";
        }

        @Override // com.baidu.navisdk.lightnavi.controller.i.c
        public void a(int i, int i2, Bundle bundle) {
            super.a(i, i2, bundle);
            com.baidu.navisdk.lightnavi.controller.f.n().a(i, i2);
            throw null;
        }

        @Override // com.baidu.navisdk.lightnavi.controller.i.c
        public boolean a(boolean z) {
            if (z || com.baidu.navisdk.lightnavi.controller.f.n().d() == 1 || com.baidu.navisdk.lightnavi.controller.f.n().d() != 2) {
                return true;
            }
            LogUtil.e("LightNaviPageStateController", "during nearby search state,just wait");
            return false;
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends c {
        private d() {
            super();
        }

        @Override // com.baidu.navisdk.lightnavi.controller.i.c
        public String a() {
            return "NearbySearchState";
        }

        @Override // com.baidu.navisdk.lightnavi.controller.i.c
        public void b() {
            super.b();
            com.baidu.navisdk.lightnavi.controller.f.n().h();
            throw null;
        }

        @Override // com.baidu.navisdk.lightnavi.controller.i.c
        public void a(int i, int i2, Bundle bundle) {
            super.a(i, i2, bundle);
            com.baidu.navisdk.lightnavi.controller.f.n().a(i, i2, bundle);
            throw null;
        }

        @Override // com.baidu.navisdk.lightnavi.controller.i.c
        public boolean a(boolean z) {
            if (com.baidu.navisdk.lightnavi.controller.f.n().d() != 2) {
                return true;
            }
            LogUtil.e("LightNaviPageStateController", "toNearbySearchState again");
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends c {
        private e() {
            super();
        }

        @Override // com.baidu.navisdk.lightnavi.controller.i.c
        public String a() {
            return "OperateState";
        }

        @Override // com.baidu.navisdk.lightnavi.controller.i.c
        public void b() {
            super.b();
            com.baidu.navisdk.lightnavi.controller.f.n().i();
        }

        @Override // com.baidu.navisdk.lightnavi.controller.i.c
        public void a(int i, int i2, Bundle bundle) {
            super.a(i, i2, bundle);
            com.baidu.navisdk.lightnavi.controller.f.n().b(i, i2);
            throw null;
        }

        @Override // com.baidu.navisdk.lightnavi.controller.i.c
        public boolean a(boolean z) {
            if (com.baidu.navisdk.lightnavi.controller.f.n().g()) {
                LogUtil.e("LightNaviPageStateController", "yaw ing,just wait");
                return false;
            }
            if (com.baidu.navisdk.lightnavi.controller.f.n().e()) {
                LogUtil.e("LightNaviPageStateController", "cal ing,just wait");
                return false;
            }
            if (com.baidu.navisdk.lightnavi.controller.f.n().f()) {
                LogUtil.e("LightNaviPageStateController", "yaw cal fail,just wait");
                return false;
            }
            if (z) {
                return true;
            }
            if (com.baidu.navisdk.lightnavi.controller.f.n().d() == 2) {
                LogUtil.e("LightNaviPageStateController", "during nearby search state,just wait");
                return false;
            }
            if (com.baidu.navisdk.lightnavi.controller.f.n().d() != 0) {
                return true;
            }
            com.baidu.navisdk.lightnavi.controller.f.n().j();
            return false;
        }
    }

    /* loaded from: classes7.dex */
    public static class f extends c {
        private f() {
            super();
        }

        @Override // com.baidu.navisdk.lightnavi.controller.i.c
        public String a() {
            return "NearbySearchState";
        }

        @Override // com.baidu.navisdk.lightnavi.controller.i.c
        public void b() {
            super.b();
        }

        @Override // com.baidu.navisdk.lightnavi.controller.i.c
        public boolean a(boolean z) {
            return false;
        }

        @Override // com.baidu.navisdk.lightnavi.controller.i.c
        public void a(int i, int i2, Bundle bundle) {
            super.a(i, i2, bundle);
            com.baidu.navisdk.lightnavi.controller.f.n().c(i, i2);
            throw null;
        }
    }

    public static int a() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LightNaviPageStateController", "getCurPageStateType mCurPageStateType = " + f6884a);
        }
        return f6884a;
    }

    /* loaded from: classes7.dex */
    public static class c {
        private c() {
        }

        public String a() {
            String simpleName = getClass().getSimpleName();
            LogUtil.e("LightNaviPageStateController", simpleName + ":getName");
            return simpleName;
        }

        public void b() {
            LogUtil.e("LightNaviPageStateController", getClass().getSimpleName() + ":onExit");
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof c)) {
                return false;
            }
            return ((c) obj).a().equalsIgnoreCase(a());
        }

        public void a(int i, int i2, Bundle bundle) {
            LogUtil.e("LightNaviPageStateController", getClass().getSimpleName() + ":onEnter");
        }

        public boolean a(boolean z) {
            LogUtil.e("LightNaviPageStateController", getClass().getSimpleName() + ":canSwitch");
            return true;
        }
    }

    public static void a(int i, boolean z, int i2, Bundle bundle) {
        c a2;
        c a3;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LightNaviPageStateController", "changeState, from " + f6884a + "-to-" + i + ",bundle:" + bundle);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (i == -1 || (a2 = a(i)) == null) {
            return;
        }
        if (a2.a(z)) {
            int i3 = f6884a;
            if (i3 != -1 && i3 != i && (a3 = a(i3)) != null) {
                a3.b();
            }
            f6884a = i;
            a2.a(i, i2, bundle);
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LightNaviPageStateController", "changeState,can not switch from " + f6884a + "-to-" + i);
        }
    }

    public static c a(int i) {
        if (i == 0) {
            return new e();
        }
        if (i == 1) {
            return new b();
        }
        if (i == 2) {
            return new d();
        }
        if (i != 3) {
            return new e();
        }
        return new f();
    }
}
