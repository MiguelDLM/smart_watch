package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;
import java.util.List;

/* loaded from: classes12.dex */
public final class O0X extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21303II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f21304OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f21305oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.oOoXoXO<? super Integer, Boolean> f21306ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public OOOI.X0o0xo f21307xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final LinearLayout f21308xxIXOIIO;

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends OOOI.X0o0xo {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ O0X f21309II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ LayoutInflater f21310oIX0oI;

        public oIX0oI(LayoutInflater layoutInflater, O0X o0x) {
            this.f21310oIX0oI = layoutInflater;
            this.f21309II0xO0 = o0x;
        }

        @Override // OOOI.X0o0xo
        @OXOo.OOXIXo
        public View II0xO0(int i) {
            View inflate = this.f21310oIX0oI.inflate(R.layout.item_pop_resource_renewal, (ViewGroup) this.f21309II0xO0.f21308xxIXOIIO, false);
            kotlin.jvm.internal.IIX0o.oO(inflate, "apply(...)");
            return inflate;
        }

        @Override // OOOI.X0o0xo
        public int oIX0oI() {
            return 1;
        }

        @Override // OOOI.X0o0xo
        public void oxoX(@OXOo.OOXIXo View view, boolean z) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O0X(@OXOo.OOXIXo Activity activity, int i) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        this.f21304OOXIXo = -1;
        LayoutInflater from = LayoutInflater.from(activity);
        from.inflate(i, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.tv_title);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21303II0XooXoX = (TextView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.ll_choices);
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "findViewById(...)");
        this.f21308xxIXOIIO = (LinearLayout) findViewById2;
        xxIXOIIO().findViewById(R.id.action1).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.oXIO0o0XI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                O0X.XI0IXoo(O0X.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.action2).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.oOo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                O0X.XIxXXX0x0(O0X.this, view);
            }
        });
        oIX0oI oix0oi = new oIX0oI(from, this);
        this.f21307xoIox = oix0oi;
        int oIX0oI2 = oix0oi.oIX0oI();
        for (int i2 = 0; i2 < oIX0oI2; i2++) {
            this.f21308xxIXOIIO.addView(this.f21307xoIox.II0xO0(i2));
        }
    }

    public static final void XI0IXoo(O0X this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void XIxXXX0x0(O0X this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Oox.oOoXoXO<? super Integer, Boolean> oooxoxo = this$0.f21306ooOOo0oXI;
        if (oooxoxo != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oooxoxo);
            if (!oooxoxo.invoke(Integer.valueOf(this$0.f21304OOXIXo)).booleanValue()) {
                return;
            }
        }
        this$0.dismiss();
    }

    public final void IIX0o(@OXOo.oOoXoXO Oox.oOoXoXO<? super Integer, Boolean> oooxoxo) {
        this.f21306ooOOo0oXI = oooxoxo;
    }

    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<Integer, Boolean> XxX0x0xxx() {
        return this.f21306ooOOo0oXI;
    }

    public final void ooXIXxIX(int i) {
        this.f21305oOoXoXO = i;
        this.f21303II0XooXoX.setText(i);
    }

    public final int xXxxox0I() {
        return this.f21305oOoXoXO;
    }

    public /* synthetic */ O0X(Activity activity, int i, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(activity, (i2 & 2) != 0 ? R.layout.pop_resource_renewal : i);
    }

    public /* synthetic */ O0X(Activity activity, List list, int i, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(activity, list, (i2 & 4) != 0 ? R.layout.pop_resource_renewal : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public O0X(@OXOo.OOXIXo Activity activity, @OXOo.OOXIXo List<? extends Object> choice, int i) {
        this(activity, i);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        kotlin.jvm.internal.IIX0o.x0xO0oo(choice, "choice");
    }
}
