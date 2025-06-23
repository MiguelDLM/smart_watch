package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.UtilsKt;
import java.util.List;

@kotlin.jvm.internal.XX({"SMAP\nSingleChoicePopup2.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SingleChoicePopup2.kt\ncom/sma/smartv3/pop/SingleChoicePopup2\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,85:1\n37#2,2:86\n*S KotlinDebug\n*F\n+ 1 SingleChoicePopup2.kt\ncom/sma/smartv3/pop/SingleChoicePopup2\n*L\n32#1:86,2\n*E\n"})
/* loaded from: classes12.dex */
public final class x0 extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21486II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f21487OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f21488oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.oOoXoXO<? super Integer, Boolean> f21489ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public OOOI.X0o0xo f21490xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final LinearLayout f21491xxIXOIIO;

    /* loaded from: classes12.dex */
    public final class II0xO0 implements View.OnClickListener {

        /* renamed from: XO, reason: collision with root package name */
        public final int f21493XO;

        public II0xO0(int i) {
            this.f21493XO = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@OXOo.OOXIXo View v) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(v, "v");
            x0.this.IIX0o(this.f21493XO);
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends OOOI.X0o0xo {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ x0 f21494I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ LayoutInflater f21495II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ Ix00oIoI[] f21496oIX0oI;

        public oIX0oI(Ix00oIoI[] ix00oIoIArr, LayoutInflater layoutInflater, x0 x0Var) {
            this.f21496oIX0oI = ix00oIoIArr;
            this.f21495II0xO0 = layoutInflater;
            this.f21494I0Io = x0Var;
        }

        @Override // OOOI.X0o0xo
        @OXOo.OOXIXo
        public View II0xO0(int i) {
            String str;
            View inflate = this.f21495II0xO0.inflate(R.layout.item_pop_single_2, (ViewGroup) this.f21494I0Io.f21491xxIXOIIO, false);
            x0 x0Var = this.f21494I0Io;
            Ix00oIoI[] ix00oIoIArr = this.f21496oIX0oI;
            inflate.setOnClickListener(new II0xO0(i));
            ((TextView) inflate.findViewById(R.id.tv_title)).setText(ix00oIoIArr[i].XO());
            int X0o0xo2 = ix00oIoIArr[i].X0o0xo();
            TextView textView = (TextView) inflate.findViewById(R.id.tv_sub_title);
            if (X0o0xo2 != 0) {
                str = UtilsKt.oI0IIXIo(X0o0xo2);
            } else {
                str = "";
            }
            textView.setText(str);
            kotlin.jvm.internal.IIX0o.oO(inflate, "apply(...)");
            return inflate;
        }

        @Override // OOOI.X0o0xo
        public int oIX0oI() {
            return this.f21496oIX0oI.length;
        }

        @Override // OOOI.X0o0xo
        public void oxoX(@OXOo.OOXIXo View view, boolean z) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
            ((CheckBox) view.findViewById(R.id.checkbox)).setChecked(z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(@OXOo.OOXIXo Activity activity, @OXOo.OOXIXo Ix00oIoI[] mChoices, int i) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mChoices, "mChoices");
        this.f21487OOXIXo = -1;
        LayoutInflater from = LayoutInflater.from(activity);
        from.inflate(i, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.tv_title);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21486II0XooXoX = (TextView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.ll_choices);
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "findViewById(...)");
        this.f21491xxIXOIIO = (LinearLayout) findViewById2;
        xxIXOIIO().findViewById(R.id.action1).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.xXoOI00O
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x0.XI0IXoo(x0.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.action2).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.x0OxxIOxX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x0.XIxXXX0x0(x0.this, view);
            }
        });
        oIX0oI oix0oi = new oIX0oI(mChoices, from, this);
        this.f21490xoIox = oix0oi;
        int oIX0oI2 = oix0oi.oIX0oI();
        for (int i2 = 0; i2 < oIX0oI2; i2++) {
            this.f21491xxIXOIIO.addView(this.f21490xoIox.II0xO0(i2));
        }
    }

    public static final void XI0IXoo(x0 this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void XIxXXX0x0(x0 this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Oox.oOoXoXO<? super Integer, Boolean> oooxoxo = this$0.f21489ooOOo0oXI;
        if (oooxoxo != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oooxoxo);
            if (!oooxoxo.invoke(Integer.valueOf(this$0.f21487OOXIXo)).booleanValue()) {
                return;
            }
        }
        this$0.dismiss();
    }

    public final void IIX0o(int i) {
        boolean z;
        this.f21487OOXIXo = i;
        int oIX0oI2 = this.f21490xoIox.oIX0oI();
        for (int i2 = 0; i2 < oIX0oI2; i2++) {
            OOOI.X0o0xo x0o0xo = this.f21490xoIox;
            View childAt = this.f21491xxIXOIIO.getChildAt(i2);
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
        return this.f21489ooOOo0oXI;
    }

    public final void ooXIXxIX(@OXOo.oOoXoXO Oox.oOoXoXO<? super Integer, Boolean> oooxoxo) {
        this.f21489ooOOo0oXI = oooxoxo;
    }

    public final void xI(int i) {
        this.f21488oOoXoXO = i;
        this.f21486II0XooXoX.setText(i);
    }

    public final int xXxxox0I() {
        return this.f21488oOoXoXO;
    }

    public /* synthetic */ x0(Activity activity, List list, int i, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(activity, (List<Ix00oIoI>) list, (i2 & 4) != 0 ? R.layout.pop_choice : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x0(@OXOo.OOXIXo Activity activity, @OXOo.OOXIXo List<Ix00oIoI> choice, int i) {
        this(activity, (Ix00oIoI[]) choice.toArray(new Ix00oIoI[0]), i);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        kotlin.jvm.internal.IIX0o.x0xO0oo(choice, "choice");
    }
}
