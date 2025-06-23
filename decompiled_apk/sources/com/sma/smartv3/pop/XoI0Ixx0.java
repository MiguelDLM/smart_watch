package com.sma.smartv3.pop;

import android.app.Activity;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public final class XoI0Ixx0 extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21402II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21403OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public String f21404Oo;

    /* renamed from: oO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Integer f21405oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f21406oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public int f21407ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f21408x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Integer f21409x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21410xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21411xxIXOIIO;

    public /* synthetic */ XoI0Ixx0(Activity activity, int i, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(activity, (i2 & 2) != 0 ? R.layout.pop_message : i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void IO(XoI0Ixx0 xoI0Ixx0, Integer num, Oox.oIX0oI oix0oi, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            oix0oi = null;
        }
        xoI0Ixx0.X00IoxXI(num, oix0oi);
    }

    public static final void OI0(Oox.oIX0oI oix0oi, XoI0Ixx0 this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (oix0oi == null || ((Boolean) oix0oi.invoke()).booleanValue()) {
            this$0.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void XOxIOxOx(XoI0Ixx0 xoI0Ixx0, int i, Oox.oIX0oI oix0oi, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            oix0oi = null;
        }
        xoI0Ixx0.x0o(i, oix0oi);
    }

    public static final void xII(Oox.oIX0oI oix0oi, XoI0Ixx0 this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (oix0oi == null || ((Boolean) oix0oi.invoke()).booleanValue()) {
            this$0.dismiss();
        }
    }

    @OXOo.OOXIXo
    public final String IIX0o() {
        return this.f21408x0XOIxOo;
    }

    public final void IoOoX(int i) {
        this.f21406oOoXoXO = i;
        if (i == 0) {
            this.f21402II0XooXoX.setVisibility(8);
        } else {
            this.f21402II0XooXoX.setVisibility(0);
            this.f21402II0XooXoX.setText(this.f21406oOoXoXO);
        }
    }

    public final void X00IoxXI(@OXOo.oOoXoXO Integer num, @OXOo.oOoXoXO final Oox.oIX0oI<Boolean> oix0oi) {
        if (num == null) {
            this.f21410xoIox.setVisibility(8);
            return;
        }
        this.f21410xoIox.setVisibility(0);
        this.f21410xoIox.setText(num.intValue());
        this.f21410xoIox.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.oX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XoI0Ixx0.xII(Oox.oIX0oI.this, this, view);
            }
        });
    }

    @OXOo.oOoXoXO
    public final Integer XI0IXoo() {
        return this.f21405oO;
    }

    @OXOo.oOoXoXO
    public final Integer XIxXXX0x0() {
        return this.f21409x0xO0oo;
    }

    public final void Xx000oIo(@OXOo.OOXIXo String value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        this.f21408x0XOIxOo = value;
        if (TextUtils.isEmpty(value)) {
            this.f21402II0XooXoX.setVisibility(8);
        } else {
            this.f21402II0XooXoX.setVisibility(0);
            this.f21402II0XooXoX.setText(this.f21408x0XOIxOo);
        }
    }

    public final int XxX0x0xxx() {
        return this.f21406oOoXoXO;
    }

    public final void oOXoIIIo(int i) {
        this.f21407ooOOo0oXI = i;
        this.f21402II0XooXoX.setTextColor(i);
    }

    public final void oo(@OXOo.oOoXoXO String str) {
        this.f21404Oo = str;
        if (str == null) {
            this.f21411xxIXOIIO.setVisibility(8);
            return;
        }
        this.f21411xxIXOIIO.setVisibility(0);
        TextView textView = this.f21411xxIXOIIO;
        String str2 = this.f21404Oo;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(str2);
        textView.setText(str2);
    }

    public final void oo0xXOI0I(@OXOo.oOoXoXO Integer num) {
        this.f21409x0xO0oo = num;
        TextView textView = this.f21411xxIXOIIO;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(num);
        textView.setGravity(num.intValue());
    }

    @OXOo.OOXIXo
    public final TextView ooXIXxIX() {
        return this.f21403OOXIXo;
    }

    public final void x0o(int i, @OXOo.oOoXoXO final Oox.oIX0oI<Boolean> oix0oi) {
        this.f21403OOXIXo.setText(i);
        this.f21403OOXIXo.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.Xo0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XoI0Ixx0.OI0(Oox.oIX0oI.this, this, view);
            }
        });
    }

    public final void xI(@OXOo.oOoXoXO Integer num) {
        this.f21405oO = num;
        if (num == null) {
            this.f21411xxIXOIIO.setVisibility(8);
            return;
        }
        this.f21411xxIXOIIO.setVisibility(0);
        TextView textView = this.f21411xxIXOIIO;
        Integer num2 = this.f21405oO;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(num2);
        textView.setText(num2.intValue());
    }

    public final int xXxxox0I() {
        return this.f21407ooOOo0oXI;
    }

    @OXOo.oOoXoXO
    public final String xxX() {
        return this.f21404Oo;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XoI0Ixx0(@OXOo.OOXIXo Activity activity, int i) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        this.f21407ooOOo0oXI = ViewCompat.MEASURED_STATE_MASK;
        this.f21408x0XOIxOo = "";
        this.f21409x0xO0oo = 3;
        LayoutInflater.from(Oxx0IOOO()).inflate(i, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.tv_title);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21402II0XooXoX = (TextView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.tv_content);
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f21411xxIXOIIO = textView;
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        View findViewById3 = xxIXOIIO().findViewById(R.id.action1);
        kotlin.jvm.internal.IIX0o.oO(findViewById3, "findViewById(...)");
        this.f21410xoIox = (TextView) findViewById3;
        View findViewById4 = xxIXOIIO().findViewById(R.id.action2);
        kotlin.jvm.internal.IIX0o.oO(findViewById4, "findViewById(...)");
        this.f21403OOXIXo = (TextView) findViewById4;
    }
}
