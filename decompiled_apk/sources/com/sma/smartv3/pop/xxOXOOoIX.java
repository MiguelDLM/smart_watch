package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;
import java.util.List;

@kotlin.jvm.internal.XX({"SMAP\nSingleChoicePopup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SingleChoicePopup.kt\ncom/sma/smartv3/pop/SingleChoicePopup\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,81:1\n37#2,2:82\n*S KotlinDebug\n*F\n+ 1 SingleChoicePopup.kt\ncom/sma/smartv3/pop/SingleChoicePopup\n*L\n31#1:82,2\n*E\n"})
/* loaded from: classes12.dex */
public final class xxOXOOoIX extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21563II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f21564OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f21565oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.oOoXoXO<? super Integer, Boolean> f21566ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public OOOI.X0o0xo f21567xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final LinearLayout f21568xxIXOIIO;

    /* loaded from: classes12.dex */
    public final class II0xO0 implements View.OnClickListener {

        /* renamed from: XO, reason: collision with root package name */
        public final int f21570XO;

        public II0xO0(int i) {
            this.f21570XO = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@OXOo.OOXIXo View v) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(v, "v");
            xxOXOOoIX.this.IIX0o(this.f21570XO);
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends OOOI.X0o0xo {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ xxOXOOoIX f21571I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ LayoutInflater f21572II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ String[] f21573oIX0oI;

        public oIX0oI(String[] strArr, LayoutInflater layoutInflater, xxOXOOoIX xxoxoooix) {
            this.f21573oIX0oI = strArr;
            this.f21572II0xO0 = layoutInflater;
            this.f21571I0Io = xxoxoooix;
        }

        @Override // OOOI.X0o0xo
        @OXOo.OOXIXo
        public View II0xO0(int i) {
            View inflate = this.f21572II0xO0.inflate(R.layout.item_pop_single, (ViewGroup) this.f21571I0Io.f21568xxIXOIIO, false);
            xxOXOOoIX xxoxoooix = this.f21571I0Io;
            String[] strArr = this.f21573oIX0oI;
            inflate.setOnClickListener(new II0xO0(i));
            ((TextView) inflate.findViewById(R.id.tv_value)).setText(strArr[i]);
            kotlin.jvm.internal.IIX0o.oO(inflate, "apply(...)");
            return inflate;
        }

        @Override // OOOI.X0o0xo
        public int oIX0oI() {
            return this.f21573oIX0oI.length;
        }

        @Override // OOOI.X0o0xo
        public void oxoX(@OXOo.OOXIXo View view, boolean z) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
            ((CheckBox) view.findViewById(R.id.checkbox)).setChecked(z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xxOXOOoIX(@OXOo.OOXIXo Activity activity, @OXOo.OOXIXo String[] mChoices, int i) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mChoices, "mChoices");
        this.f21564OOXIXo = -1;
        LayoutInflater from = LayoutInflater.from(activity);
        from.inflate(i, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.tv_title);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21563II0XooXoX = (TextView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.ll_choices);
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "findViewById(...)");
        this.f21568xxIXOIIO = (LinearLayout) findViewById2;
        xxIXOIIO().findViewById(R.id.action1).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.O0IxXx
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                xxOXOOoIX.XI0IXoo(xxOXOOoIX.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.action2).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.IoXIXo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                xxOXOOoIX.XIxXXX0x0(xxOXOOoIX.this, view);
            }
        });
        oIX0oI oix0oi = new oIX0oI(mChoices, from, this);
        this.f21567xoIox = oix0oi;
        int oIX0oI2 = oix0oi.oIX0oI();
        for (int i2 = 0; i2 < oIX0oI2; i2++) {
            this.f21568xxIXOIIO.addView(this.f21567xoIox.II0xO0(i2));
        }
    }

    public static final void XI0IXoo(xxOXOOoIX this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void XIxXXX0x0(xxOXOOoIX this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Oox.oOoXoXO<? super Integer, Boolean> oooxoxo = this$0.f21566ooOOo0oXI;
        if (oooxoxo != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oooxoxo);
            if (!oooxoxo.invoke(Integer.valueOf(this$0.f21564OOXIXo)).booleanValue()) {
                return;
            }
        }
        this$0.dismiss();
    }

    public final void IIX0o(int i) {
        boolean z;
        this.f21564OOXIXo = i;
        int oIX0oI2 = this.f21567xoIox.oIX0oI();
        for (int i2 = 0; i2 < oIX0oI2; i2++) {
            OOOI.X0o0xo x0o0xo = this.f21567xoIox;
            View childAt = this.f21568xxIXOIIO.getChildAt(i2);
            kotlin.jvm.internal.IIX0o.oO(childAt, "getChildAt(...)");
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            x0o0xo.oxoX(childAt, z);
        }
    }

    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<Integer, Boolean> XxX0x0xxx() {
        return this.f21566ooOOo0oXI;
    }

    public final void ooXIXxIX(@OXOo.oOoXoXO Oox.oOoXoXO<? super Integer, Boolean> oooxoxo) {
        this.f21566ooOOo0oXI = oooxoxo;
    }

    public final void xI(int i) {
        this.f21565oOoXoXO = i;
        this.f21563II0XooXoX.setText(i);
    }

    public final int xXxxox0I() {
        return this.f21565oOoXoXO;
    }

    public /* synthetic */ xxOXOOoIX(Activity activity, int i, int i2, int i3, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(activity, i, (i3 & 4) != 0 ? R.layout.pop_choice : i2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public xxOXOOoIX(@OXOo.OOXIXo android.app.Activity r2, int r3, int r4) {
        /*
            r1 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            android.content.res.Resources r0 = r2.getResources()
            java.lang.String[] r3 = r0.getStringArray(r3)
            java.lang.String r0 = "getStringArray(...)"
            kotlin.jvm.internal.IIX0o.oO(r3, r0)
            r1.<init>(r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.pop.xxOXOOoIX.<init>(android.app.Activity, int, int):void");
    }

    public /* synthetic */ xxOXOOoIX(Activity activity, List list, int i, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(activity, (List<String>) list, (i2 & 4) != 0 ? R.layout.pop_choice : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public xxOXOOoIX(@OXOo.OOXIXo Activity activity, @OXOo.OOXIXo List<String> choice, int i) {
        this(activity, (String[]) choice.toArray(new String[0]), i);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        kotlin.jvm.internal.IIX0o.x0xO0oo(choice, "choice");
    }
}
