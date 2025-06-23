package com.baidu.navisdk.pronavi.hd;

import OXOo.oOoXoXO;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.baidu.navisdk.util.common.g;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class a extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    private final int f7720a;

    /* renamed from: com.baidu.navisdk.pronavi.hd.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0315a {
        private C0315a() {
        }

        public /* synthetic */ C0315a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new C0315a(null);
    }

    public a(int i) {
        this.f7720a = i;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(@oOoXoXO View view, @oOoXoXO Outline outline) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNViewOutlineProvider", "getOutline: ");
        }
        Rect rect = new Rect();
        if (view != null) {
            view.getGlobalVisibleRect(rect);
        }
        Rect rect2 = new Rect(0, 0, rect.right - rect.left, (rect.bottom - rect.top) + this.f7720a);
        if (outline != null) {
            outline.setRoundRect(rect2, this.f7720a);
        }
    }
}
