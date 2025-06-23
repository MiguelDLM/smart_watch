package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes12.dex */
public final class xoxXI extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final String[] f21547II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OXOo.OOXIXo
    public OOOI.X0o0xo f21548OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Set<Integer> f21549oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public int f21550ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.oOoXoXO<? super Set<Integer>, Boolean> f21551x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public final LinearLayout f21552xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21553xxIXOIIO;

    /* loaded from: classes12.dex */
    public final class II0xO0 implements View.OnClickListener {

        /* renamed from: XO, reason: collision with root package name */
        public final int f21555XO;

        public II0xO0(int i) {
            this.f21555XO = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@OXOo.OOXIXo View v) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(v, "v");
            if (xoxXI.this.f21549oOoXoXO.contains(Integer.valueOf(this.f21555XO))) {
                xoxXI.this.f21549oOoXoXO.remove(Integer.valueOf(this.f21555XO));
                OOOI.X0o0xo x0o0xo = xoxXI.this.f21548OOXIXo;
                View childAt = xoxXI.this.f21552xoIox.getChildAt(this.f21555XO);
                kotlin.jvm.internal.IIX0o.oO(childAt, "getChildAt(...)");
                x0o0xo.oxoX(childAt, false);
                return;
            }
            xoxXI.this.f21549oOoXoXO.add(Integer.valueOf(this.f21555XO));
            OOOI.X0o0xo x0o0xo2 = xoxXI.this.f21548OOXIXo;
            View childAt2 = xoxXI.this.f21552xoIox.getChildAt(this.f21555XO);
            kotlin.jvm.internal.IIX0o.oO(childAt2, "getChildAt(...)");
            x0o0xo2.oxoX(childAt2, true);
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends OOOI.X0o0xo {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ LayoutInflater f21556II0xO0;

        public oIX0oI(LayoutInflater layoutInflater) {
            this.f21556II0xO0 = layoutInflater;
        }

        @Override // OOOI.X0o0xo
        @OXOo.OOXIXo
        public View II0xO0(int i) {
            View inflate = this.f21556II0xO0.inflate(R.layout.item_pop_multi, (ViewGroup) xoxXI.this.f21552xoIox, false);
            xoxXI xoxxi = xoxXI.this;
            inflate.setOnClickListener(new II0xO0(i));
            ((TextView) inflate.findViewById(R.id.tv_value)).setText(xoxxi.IIX0o()[i]);
            kotlin.jvm.internal.IIX0o.oO(inflate, "apply(...)");
            return inflate;
        }

        @Override // OOOI.X0o0xo
        public int oIX0oI() {
            return xoxXI.this.IIX0o().length;
        }

        @Override // OOOI.X0o0xo
        public void oxoX(@OXOo.OOXIXo View view, boolean z) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
            ((CheckBox) view.findViewById(R.id.checkbox)).setChecked(z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xoxXI(@OXOo.OOXIXo Activity activity, @OXOo.OOXIXo String[] mChoices) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mChoices, "mChoices");
        this.f21547II0XooXoX = mChoices;
        this.f21549oOoXoXO = new LinkedHashSet();
        LayoutInflater from = LayoutInflater.from(activity);
        from.inflate(R.layout.pop_choice, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.tv_title);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21553xxIXOIIO = (TextView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.ll_choices);
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "findViewById(...)");
        this.f21552xoIox = (LinearLayout) findViewById2;
        xxIXOIIO().findViewById(R.id.action1).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.O0Xx
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                xoxXI.XI0IXoo(xoxXI.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.action2).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.I0oOIX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                xoxXI.XIxXXX0x0(xoxXI.this, view);
            }
        });
        oIX0oI oix0oi = new oIX0oI(from);
        this.f21548OOXIXo = oix0oi;
        int oIX0oI2 = oix0oi.oIX0oI();
        for (int i = 0; i < oIX0oI2; i++) {
            this.f21552xoIox.addView(this.f21548OOXIXo.II0xO0(i));
        }
    }

    public static final void XI0IXoo(xoxXI this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void XIxXXX0x0(xoxXI this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Oox.oOoXoXO<? super Set<Integer>, Boolean> oooxoxo = this$0.f21551x0XOIxOo;
        if (oooxoxo != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oooxoxo);
            if (!oooxoxo.invoke(this$0.f21549oOoXoXO).booleanValue()) {
                return;
            }
        }
        this$0.dismiss();
    }

    @OXOo.OOXIXo
    public final String[] IIX0o() {
        return this.f21547II0XooXoX;
    }

    public final void IoOoX(int i) {
        this.f21550ooOOo0oXI = i;
        this.f21553xxIXOIIO.setText(i);
    }

    public final void oo(@OXOo.oOoXoXO Oox.oOoXoXO<? super Set<Integer>, Boolean> oooxoxo) {
        this.f21551x0XOIxOo = oooxoxo;
    }

    public final void oo0xXOI0I(@OXOo.OOXIXo Set<Integer> choices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(choices, "choices");
        this.f21549oOoXoXO.clear();
        this.f21549oOoXoXO.addAll(choices);
        int oIX0oI2 = this.f21548OOXIXo.oIX0oI();
        for (int i = 0; i < oIX0oI2; i++) {
            OOOI.X0o0xo x0o0xo = this.f21548OOXIXo;
            View childAt = this.f21552xoIox.getChildAt(i);
            kotlin.jvm.internal.IIX0o.oO(childAt, "getChildAt(...)");
            x0o0xo.oxoX(childAt, this.f21549oOoXoXO.contains(Integer.valueOf(i)));
        }
    }

    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<Set<Integer>, Boolean> ooXIXxIX() {
        return this.f21551x0XOIxOo;
    }

    public final int xI() {
        return this.f21550ooOOo0oXI;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public xoxXI(@OXOo.OOXIXo android.app.Activity r2, int r3) {
        /*
            r1 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            android.content.res.Resources r0 = r2.getResources()
            java.lang.String[] r3 = r0.getStringArray(r3)
            java.lang.String r0 = "getStringArray(...)"
            kotlin.jvm.internal.IIX0o.oO(r3, r0)
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.pop.xoxXI.<init>(android.app.Activity, int):void");
    }
}
