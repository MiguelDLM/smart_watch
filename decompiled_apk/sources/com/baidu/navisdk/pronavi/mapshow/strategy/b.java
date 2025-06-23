package com.baidu.navisdk.pronavi.mapshow.strategy;

import OXOo.OOXIXo;
import android.app.Activity;
import android.graphics.Rect;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class b extends com.baidu.navisdk.pronavi.mapshow.strategy.a {
    private int c;
    private int d;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new a(null);
    }

    public b(int i, int i2) {
        super(i, i2);
        this.c = Integer.MIN_VALUE;
        this.d = Integer.MIN_VALUE;
    }

    @Override // com.baidu.navisdk.pronavi.mapshow.i.a
    @OOXIXo
    public String a() {
        return "RGARNaviMapShowStrategy";
    }

    @Override // com.baidu.navisdk.pronavi.mapshow.i.a
    @OOXIXo
    public Rect a(int i, @OOXIXo Activity activity) {
        int b;
        int c;
        int i2;
        IIX0o.x0xO0oo(activity, "activity");
        int i3 = 0;
        if (i == 2) {
            if (this.c == Integer.MIN_VALUE) {
                this.c = com.baidu.navisdk.ui.routeguide.utils.b.a(false);
            }
            c = b();
            b = c();
            i3 = c - this.c;
            i2 = 0;
        } else {
            if (this.d == Integer.MIN_VALUE) {
                this.d = com.baidu.navisdk.ui.routeguide.utils.b.a(true);
            }
            b = b();
            c = c();
            i2 = b - this.d;
        }
        return new Rect(i3, i2, c, b);
    }
}
