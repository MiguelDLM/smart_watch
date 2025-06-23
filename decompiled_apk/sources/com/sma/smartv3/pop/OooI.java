package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.UtilsKt;
import java.util.Date;

/* loaded from: classes12.dex */
public final class OooI extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final EditText f21322II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21323OOXIXo;

    /* renamed from: oO, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f21324oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.x0xO0oo<? super String, ? super String, kotlin.oXIO0o0XI> f21325oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f21326ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f21327x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21328xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21329xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooI(@OXOo.OOXIXo Activity activity) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        this.f21326ooOOo0oXI = "";
        this.f21327x0XOIxOo = "";
        this.f21324oO = "";
        setClippingEnabled(true);
        oOoXoXO().setPadding(0, 0, 0, 0);
        setSoftInputMode(16);
        LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_save_translation, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.pop_translation_lan);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21329xxIXOIIO = (TextView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.pop_translation_to_lan);
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "findViewById(...)");
        this.f21328xoIox = (TextView) findViewById2;
        View findViewById3 = xxIXOIIO().findViewById(R.id.pop_translation_time);
        kotlin.jvm.internal.IIX0o.oO(findViewById3, "findViewById(...)");
        this.f21323OOXIXo = (TextView) findViewById3;
        View findViewById4 = xxIXOIIO().findViewById(R.id.pop_save_edit);
        kotlin.jvm.internal.IIX0o.oO(findViewById4, "findViewById(...)");
        EditText editText = (EditText) findViewById4;
        this.f21322II0XooXoX = editText;
        editText.setText(com.sma.smartv3.util.xoIox.I0Io().format(new Date()) + UtilsKt.oI0IIXIo(R.string.pop_save_recording_title));
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.sma.smartv3.pop.o0IXXIx
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean XIxXXX0x02;
                XIxXXX0x02 = OooI.XIxXXX0x0(OooI.this, textView, i, keyEvent);
                return XIxXXX0x02;
            }
        });
        xxIXOIIO().findViewById(R.id.action1).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.XoIxOXIXo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OooI.xxX(OooI.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.action2).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.OO0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OooI.XxX0x0xxx(OooI.this, view);
            }
        });
    }

    public static final boolean XIxXXX0x0(OooI this$0, TextView textView, int i, KeyEvent keyEvent) {
        Oox.x0xO0oo<? super String, ? super String, kotlin.oXIO0o0XI> x0xo0oo;
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (i == 6 && (x0xo0oo = this$0.f21325oOoXoXO) != null) {
            x0xo0oo.invoke(this$0.f21322II0XooXoX.getText().toString(), "");
            return false;
        }
        return false;
    }

    public static final void XxX0x0xxx(OooI this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Oox.x0xO0oo<? super String, ? super String, kotlin.oXIO0o0XI> x0xo0oo = this$0.f21325oOoXoXO;
        if (x0xo0oo != null) {
            x0xo0oo.invoke(this$0.f21322II0XooXoX.getText().toString(), "");
        }
        this$0.dismiss();
    }

    public static final void xxX(OooI this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    @OXOo.OOXIXo
    public final String IIX0o() {
        return this.f21326ooOOo0oXI;
    }

    public final void IO(@OXOo.OOXIXo String value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        this.f21324oO = value;
        this.f21323OOXIXo.setText(value);
    }

    @OXOo.OOXIXo
    public final TextView IoOoX() {
        return this.f21323OOXIXo;
    }

    public final void X00IoxXI(@OXOo.oOoXoXO Oox.x0xO0oo<? super String, ? super String, kotlin.oXIO0o0XI> x0xo0oo) {
        this.f21325oOoXoXO = x0xo0oo;
    }

    public final void Xx000oIo(@OXOo.OOXIXo String value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        this.f21326ooOOo0oXI = value;
        this.f21329xxIXOIIO.setText(value);
    }

    @OXOo.OOXIXo
    public final TextView oOXoIIIo() {
        return this.f21328xoIox;
    }

    @OXOo.OOXIXo
    public final TextView oo() {
        return this.f21329xxIXOIIO;
    }

    @OXOo.OOXIXo
    public final String oo0xXOI0I() {
        return this.f21327x0XOIxOo;
    }

    @OXOo.oOoXoXO
    public final Oox.x0xO0oo<String, String, kotlin.oXIO0o0XI> ooXIXxIX() {
        return this.f21325oOoXoXO;
    }

    @OXOo.OOXIXo
    public final String xI() {
        return this.f21324oO;
    }

    public final void xII(@OXOo.OOXIXo String value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        this.f21327x0XOIxOo = value;
        this.f21328xoIox.setText(value);
    }

    @OXOo.OOXIXo
    public final EditText xXxxox0I() {
        return this.f21322II0XooXoX;
    }
}
