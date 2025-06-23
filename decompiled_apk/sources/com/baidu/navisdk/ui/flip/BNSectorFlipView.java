package com.baidu.navisdk.ui.flip;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import com.baidu.navisdk.util.common.g;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class BNSectorFlipView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private a<? extends c> f8405a;
    private c b;
    private c c;
    private c d;
    private c e;
    private long f;
    private long g;
    private Runnable h;
    private com.baidu.navisdk.ui.flip.a i;
    private com.baidu.navisdk.ui.flip.a j;
    private Animation.AnimationListener k;

    /* loaded from: classes8.dex */
    public static abstract class a<VH extends c> {
        public abstract int a();

        @OOXIXo
        public abstract VH a(@OOXIXo ViewGroup viewGroup);

        public abstract boolean a(@OOXIXo c cVar);

        public abstract void b(@OOXIXo c cVar);

        public abstract void c(@OOXIXo c cVar);
    }

    /* loaded from: classes8.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        @OOXIXo
        private final View f8406a;

        public c(@OOXIXo View itemView) {
            IIX0o.x0xO0oo(itemView, "itemView");
            this.f8406a = itemView;
        }

        @OOXIXo
        public final View a() {
            return this.f8406a;
        }
    }

    /* loaded from: classes8.dex */
    public static final class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            BNSectorFlipView.this.d();
        }
    }

    /* loaded from: classes8.dex */
    public static final class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@oOoXoXO Animation animation) {
            View a2;
            View a3;
            View a4;
            if (BNSectorFlipView.this.j != null) {
                c cVar = BNSectorFlipView.this.e;
                if (cVar != null && (a4 = cVar.a()) != null) {
                    a4.setVisibility(8);
                }
                c cVar2 = BNSectorFlipView.this.d;
                if (cVar2 != null && (a3 = cVar2.a()) != null) {
                    a3.startAnimation(BNSectorFlipView.this.j);
                }
                c cVar3 = BNSectorFlipView.this.d;
                if (cVar3 != null && (a2 = cVar3.a()) != null) {
                    a2.setVisibility(0);
                }
                if (BNSectorFlipView.this.e != null) {
                    a aVar = BNSectorFlipView.this.f8405a;
                    IIX0o.ooOOo0oXI(aVar);
                    c cVar4 = BNSectorFlipView.this.e;
                    IIX0o.ooOOo0oXI(cVar4);
                    aVar.c(cVar4);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@oOoXoXO Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@oOoXoXO Animation animation) {
        }
    }

    static {
        new b(null);
    }

    @xoIox
    public BNSectorFlipView(@OOXIXo Context context) {
        this(context, null, 0, 6, null);
    }

    private final void a(Context context) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        int i;
        super.onAttachedToWindow();
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNSectorFlipView", "onAttachedToWindow");
        }
        a<? extends c> aVar = this.f8405a;
        if (aVar != null) {
            i = aVar.a();
        } else {
            i = 0;
        }
        if (i > 0) {
            b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNSectorFlipView", "onDetachedFromWindow");
        }
        c();
    }

    public final void setAdapter(@OOXIXo a<? extends c> adapter) {
        IIX0o.x0xO0oo(adapter, "adapter");
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNSectorFlipView", "setAdapter");
        }
        if (this.f8405a == null) {
            removeAllViews();
        }
        this.f8405a = adapter;
        if (adapter == null) {
            return;
        }
        IIX0o.ooOOo0oXI(adapter);
        this.b = adapter.a(this);
        a<? extends c> aVar = this.f8405a;
        IIX0o.ooOOo0oXI(aVar);
        c a2 = aVar.a(this);
        this.c = a2;
        if (a2 == null) {
            IIX0o.XOxIOxOx("mViewHolder2");
        }
        addView(a2.a());
        c cVar = this.c;
        if (cVar == null) {
            IIX0o.XOxIOxOx("mViewHolder2");
        }
        cVar.a().setVisibility(8);
        c cVar2 = this.b;
        if (cVar2 == null) {
            IIX0o.XOxIOxOx("mViewHolder1");
        }
        addView(cVar2.a());
        c cVar3 = this.b;
        if (cVar3 == null) {
            IIX0o.XOxIOxOx("mViewHolder1");
        }
        cVar3.a().setVisibility(0);
    }

    @xoIox
    public final void setTime(long j) {
        a(this, j, 0L, 2, null);
    }

    @xoIox
    public BNSectorFlipView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        View a2;
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNSectorFlipView", "startFlipAnimationV2");
        }
        c cVar = this.b;
        if (cVar == null) {
            IIX0o.XOxIOxOx("mViewHolder1");
        }
        if (cVar.a().getVisibility() == 8) {
            c cVar2 = this.c;
            if (cVar2 == null) {
                IIX0o.XOxIOxOx("mViewHolder2");
            }
            this.e = cVar2;
            c cVar3 = this.b;
            if (cVar3 == null) {
                IIX0o.XOxIOxOx("mViewHolder1");
            }
            this.d = cVar3;
        } else {
            c cVar4 = this.b;
            if (cVar4 == null) {
                IIX0o.XOxIOxOx("mViewHolder1");
            }
            this.e = cVar4;
            c cVar5 = this.c;
            if (cVar5 == null) {
                IIX0o.XOxIOxOx("mViewHolder2");
            }
            this.d = cVar5;
        }
        if (this.i == null) {
            com.baidu.navisdk.ui.flip.a aVar = new com.baidu.navisdk.ui.flip.a(true, 0.0f, 90.0f);
            this.i = aVar;
            aVar.setDuration(this.g);
            com.baidu.navisdk.ui.flip.a aVar2 = this.i;
            if (aVar2 != null) {
                aVar2.setInterpolator(new AccelerateInterpolator());
            }
        }
        if (this.j == null) {
            com.baidu.navisdk.ui.flip.a aVar3 = new com.baidu.navisdk.ui.flip.a(true, -90.0f, 0.0f);
            this.j = aVar3;
            aVar3.setDuration(this.g);
            com.baidu.navisdk.ui.flip.a aVar4 = this.j;
            if (aVar4 != null) {
                aVar4.setInterpolator(new DecelerateInterpolator());
            }
        }
        if (this.k == null) {
            this.k = new e();
        }
        com.baidu.navisdk.ui.flip.a aVar5 = this.i;
        if (aVar5 != null) {
            aVar5.setAnimationListener(this.k);
        }
        c cVar6 = this.e;
        if (cVar6 != null && (a2 = cVar6.a()) != null) {
            a2.startAnimation(this.i);
        }
        Runnable runnable = this.h;
        if (runnable != null) {
            postDelayed(runnable, this.f);
        }
    }

    private final void e() {
        View a2;
        View a3;
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNSectorFlipView", "stopFlipAnimation");
        }
        c cVar = this.b;
        if (cVar == null) {
            IIX0o.XOxIOxOx("mViewHolder1");
        }
        if (cVar != null) {
            c cVar2 = this.b;
            if (cVar2 == null) {
                IIX0o.XOxIOxOx("mViewHolder1");
            }
            cVar2.a().clearAnimation();
        }
        c cVar3 = this.c;
        if (cVar3 == null) {
            IIX0o.XOxIOxOx("mViewHolder2");
        }
        if (cVar3 != null) {
            c cVar4 = this.c;
            if (cVar4 == null) {
                IIX0o.XOxIOxOx("mViewHolder2");
            }
            cVar4.a().clearAnimation();
        }
        c cVar5 = this.d;
        if (cVar5 != null) {
            View a4 = cVar5.a();
            if (a4 != null) {
                a4.setVisibility(0);
            }
            c cVar6 = this.d;
            if (cVar6 != null && (a3 = cVar6.a()) != null) {
                a3.setTranslationY(0.0f);
            }
        }
        c cVar7 = this.e;
        if (cVar7 != null) {
            View a5 = cVar7.a();
            if (a5 != null) {
                a5.setVisibility(8);
            }
            c cVar8 = this.e;
            if (cVar8 != null && (a2 = cVar8.a()) != null) {
                a2.setTranslationY(0.0f);
            }
        }
        this.k = null;
        this.j = null;
        this.i = null;
    }

    public final void b() {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNSectorFlipView", "startFlip");
        }
        a<? extends c> aVar = this.f8405a;
        if (aVar != null) {
            IIX0o.ooOOo0oXI(aVar);
            c cVar = this.b;
            if (cVar == null) {
                IIX0o.XOxIOxOx("mViewHolder1");
            }
            if (!aVar.a(cVar)) {
                a<? extends c> aVar2 = this.f8405a;
                IIX0o.ooOOo0oXI(aVar2);
                c cVar2 = this.b;
                if (cVar2 == null) {
                    IIX0o.XOxIOxOx("mViewHolder1");
                }
                aVar2.c(cVar2);
            }
            a<? extends c> aVar3 = this.f8405a;
            IIX0o.ooOOo0oXI(aVar3);
            c cVar3 = this.c;
            if (cVar3 == null) {
                IIX0o.XOxIOxOx("mViewHolder2");
            }
            if (!aVar3.a(cVar3)) {
                a<? extends c> aVar4 = this.f8405a;
                IIX0o.ooOOo0oXI(aVar4);
                c cVar4 = this.c;
                if (cVar4 == null) {
                    IIX0o.XOxIOxOx("mViewHolder2");
                }
                aVar4.c(cVar4);
            }
            Runnable runnable = this.h;
            if (runnable == null) {
                this.h = new d();
            } else {
                boolean removeCallbacks = removeCallbacks(runnable);
                if (gVar.d()) {
                    gVar.e("BNSectorFlipView", "startFlip remove result: " + removeCallbacks);
                }
            }
            postDelayed(this.h, this.f);
            return;
        }
        throw new IllegalArgumentException("mAdapter == null");
    }

    public final void c() {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNSectorFlipView", "stopFlip");
        }
        Runnable runnable = this.h;
        if (runnable != null) {
            this.h = null;
            boolean removeCallbacks = removeCallbacks(runnable);
            if (gVar.d()) {
                gVar.e("BNSectorFlipView", "stopFlip result " + removeCallbacks);
            }
        }
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public BNSectorFlipView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f = 3000L;
        this.g = 500L;
        a(context);
    }

    public static /* synthetic */ void a(BNSectorFlipView bNSectorFlipView, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 3000;
        }
        if ((i & 2) != 0) {
            j2 = 500;
        }
        bNSectorFlipView.a(j, j2);
    }

    @xoIox
    public final void a(long j, long j2) {
        this.f = j;
        this.g = j2;
    }

    public final void a() {
        c cVar;
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNSectorFlipView", "showDefault");
        }
        e();
        c cVar2 = this.b;
        if (cVar2 == null) {
            IIX0o.XOxIOxOx("mViewHolder1");
        }
        if (cVar2.a().getVisibility() == 8) {
            cVar = this.c;
            if (cVar == null) {
                IIX0o.XOxIOxOx("mViewHolder2");
            }
        } else {
            cVar = this.b;
            if (cVar == null) {
                IIX0o.XOxIOxOx("mViewHolder1");
            }
        }
        a<? extends c> aVar = this.f8405a;
        if (aVar != null) {
            aVar.b(cVar);
        }
    }

    public /* synthetic */ BNSectorFlipView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @RequiresApi(21)
    public BNSectorFlipView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        IIX0o.x0xO0oo(context, "context");
        this.f = 3000L;
        this.g = 500L;
        a(context);
    }
}
