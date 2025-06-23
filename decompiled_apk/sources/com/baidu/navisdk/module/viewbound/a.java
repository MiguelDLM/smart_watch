package com.baidu.navisdk.module.viewbound;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.framework.interfaces.y;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.worker.c;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class a {
    private static a h = null;
    private static volatile boolean i = false;

    /* renamed from: a, reason: collision with root package name */
    private int f7614a;
    private int b;
    private ArrayList<Bundle> c = new ArrayList<>();
    private ArrayList<Bundle> d = new ArrayList<>();
    private ArrayList<y> e = new ArrayList<>();
    private f f = new C0302a("RGUIViewBoundManager-" + a.class.getSimpleName(), null);
    private f g = new b("RGUIViewBoundManager-" + a.class.getSimpleName(), null);

    /* renamed from: com.baidu.navisdk.module.viewbound.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0302a extends f<String, String> {
        public C0302a(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            a.this.a(500);
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends f<String, String> {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            a.this.a(0);
            return null;
        }
    }

    public static a e() {
        if (h == null) {
            synchronized (a.class) {
                try {
                    if (h == null) {
                        h = new a();
                    }
                } finally {
                }
            }
        }
        return h;
    }

    private boolean f() {
        int g = g();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGUIViewBoundManager", "isAllowPost,ret:" + g);
        }
        if (g >= 0) {
            return true;
        }
        return false;
    }

    private int g() {
        String str;
        String str2;
        String str3 = "top";
        String str4 = "left";
        if (this.d.size() != this.c.size()) {
            for (int i2 = 0; this.d.size() > 0 && i2 < this.d.size(); i2++) {
                Bundle bundle = this.d.get(i2);
                if (!a(bundle.getInt("left", 0), bundle.getInt("top", 0), bundle.getInt("right", 0), bundle.getInt("bottom", 0))) {
                    g gVar = g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e("setUIViewBound", "isAllowPost-> 检查ui范围超出屏幕，抛弃本次post!");
                        return -2;
                    }
                    return -2;
                }
            }
            return 0;
        }
        if (this.d.size() > 0) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < this.d.size()) {
                Bundle bundle2 = this.c.get(i3);
                Bundle bundle3 = this.d.get(i3);
                if (bundle2 != null && bundle3 != null) {
                    int i5 = bundle2.getInt(str4, 0);
                    int i6 = bundle2.getInt(str3, 0);
                    int i7 = bundle2.getInt("right", 0);
                    int i8 = bundle2.getInt("bottom", 0);
                    int i9 = bundle3.getInt(str4, 0);
                    str2 = str4;
                    int i10 = bundle3.getInt(str3, 0);
                    str = str3;
                    int i11 = bundle3.getInt("right", 0);
                    int i12 = bundle3.getInt("bottom", 0);
                    if (!a(i9, i10, i11, i12)) {
                        g gVar2 = g.PRO_NAV;
                        if (gVar2.d()) {
                            gVar2.e("setUIViewBound", "isAllowPost-> 检查ui范围超出屏幕，抛弃本次post!");
                            return -3;
                        }
                        return -3;
                    }
                    if (i5 == i9 && i6 == i10 && i7 == i11 && i8 == i12) {
                        i4++;
                    }
                } else {
                    str = str3;
                    str2 = str4;
                }
                i3++;
                str4 = str2;
                str3 = str;
            }
            if (i4 != this.c.size()) {
                return 1;
            }
            return -4;
        }
        return -1;
    }

    private void h() {
        View[] B;
        if (!this.e.isEmpty()) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                y yVar = this.e.get(i2);
                if (yVar != null && (B = yVar.B()) != null && B.length > 0) {
                    Rect rect = new Rect();
                    for (int i3 = 0; i3 < B.length; i3++) {
                        View view = B[i3];
                        if (view != null) {
                            view.getGlobalVisibleRect(rect);
                            a(rect);
                            g gVar = g.PRO_NAV;
                            if (gVar.d()) {
                                gVar.e("RGUIViewBoundManager", B[i3].getClass().getName() + " :" + rect.left + "," + rect.right + ", " + rect.top + "," + rect.bottom + "," + B[i3].getTag());
                            }
                        }
                    }
                }
            }
        }
    }

    public void b() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGUIViewBoundManager", "clearUIViewBound");
        }
        this.c.clear();
        this.d.clear();
        this.e.clear();
        BNMapController.getInstance().setUIViewBound(this.c, -1);
    }

    public void c() {
        d();
        b();
    }

    public void d() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGUIViewBoundManager", "resetData");
        }
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.f7614a = 0;
        this.b = 0;
        i = false;
        a();
    }

    public Bundle a(int i2, Rect rect) {
        Bundle bundle;
        Bundle bundle2 = null;
        if (rect == null) {
            return null;
        }
        try {
            bundle = new Bundle();
        } catch (Exception e) {
            e = e;
        }
        try {
            bundle.putInt("type", i2);
            bundle.putInt("left", Math.max(rect.left + this.f7614a, 0));
            bundle.putInt("top", Math.max(rect.top + this.b, 0));
            bundle.putInt("right", Math.max(rect.right + this.f7614a, 0));
            bundle.putInt("bottom", Math.max(rect.bottom + this.b, 0));
            return bundle;
        } catch (Exception e2) {
            e = e2;
            bundle2 = bundle;
            if (!g.PRO_NAV.d()) {
                return bundle2;
            }
            LogUtil.printException("generateViewLocationBundle", e);
            return bundle2;
        }
    }

    private void a(Rect... rectArr) {
        Bundle a2;
        if (rectArr == null || rectArr.length <= 0) {
            return;
        }
        for (Rect rect : rectArr) {
            if (rect != null && ((rect.left > 0 || rect.top > 0 || rect.bottom > 0 || rect.right > 0) && (a2 = a(0, rect)) != null)) {
                this.d.add(a2);
            }
        }
    }

    public a a(y... yVarArr) {
        if (yVarArr != null && yVarArr.length > 0) {
            for (y yVar : yVarArr) {
                if (yVar != null && !this.e.contains(yVar)) {
                    this.e.add(yVar);
                }
            }
        }
        return e();
    }

    public a a(int i2, int i3) {
        this.f7614a = i2;
        this.b = i3;
        return e();
    }

    public void a(long j) {
        if (i) {
            return;
        }
        i = true;
        if (j == 0) {
            c.a().a(this.g, new e(2, 0), 0L);
        } else {
            c.a().a(this.f, new e(2, 0), j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        if (i) {
            i = false;
            h();
            boolean f = f();
            if (f) {
                BNMapController.getInstance().setUIViewBound(this.d, i2);
            }
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("setUIViewBound", "isAllowPost = " + f + ", mTempRectList.size= " + this.d.size());
                LogUtil.printList("RGUIViewBoundManager", "setUIViewBound", "mTempRectList", this.d);
            }
            this.c.clear();
            this.c.addAll(this.d);
            this.d.clear();
            this.e.clear();
        }
    }

    public void a() {
        c.a().a((com.baidu.navisdk.util.worker.g) this.f, true);
        c.a().a((com.baidu.navisdk.util.worker.g) this.g, true);
        i = false;
    }

    private boolean a(int i2, int i3, int i4, int i5) {
        int absoluteWidth = ScreenUtil.getInstance().getAbsoluteWidth();
        int absoluteHeight = ScreenUtil.getInstance().getAbsoluteHeight();
        com.baidu.navisdk.framework.interfaces.pronavi.b h2 = com.baidu.navisdk.framework.interfaces.c.p().h();
        return (h2 == null || !h2.x0()) ? i2 >= 0 && i3 >= 0 && i4 <= absoluteWidth && i5 <= absoluteHeight : h2.y0() ? i2 >= 0 && i3 >= 0 && i4 <= absoluteWidth && i5 <= absoluteHeight : i2 >= 0 && i3 >= 0 && i4 <= absoluteHeight && i5 <= absoluteWidth;
    }
}
