package com.sma.smartv3.pop;

import android.app.Activity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public final class IIX0o extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21271II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f21272OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f21273oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f21274ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.oOoXoXO<? super String, Boolean> f21275x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f21276xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final EditText f21277xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IIX0o(@OXOo.OOXIXo Activity activity, int i) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        this.f21272OOXIXo = "";
        this.f21273oOoXoXO = 1;
        this.f21274ooOOo0oXI = "";
        setClippingEnabled(true);
        oOoXoXO().setPadding(0, 0, 0, 0);
        setSoftInputMode(16);
        LayoutInflater.from(Oxx0IOOO()).inflate(i, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.tv_title);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21271II0XooXoX = (TextView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.edt);
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "findViewById(...)");
        EditText editText = (EditText) findViewById2;
        this.f21277xxIXOIIO = editText;
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.sma.smartv3.pop.xxX
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                boolean XIxXXX0x02;
                XIxXXX0x02 = IIX0o.XIxXXX0x0(IIX0o.this, textView, i2, keyEvent);
                return XIxXXX0x02;
            }
        });
        xxIXOIIO().findViewById(R.id.action1).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.XxX0x0xxx
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IIX0o.xxX(IIX0o.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.action2).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.xXxxox0I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IIX0o.XxX0x0xxx(IIX0o.this, view);
            }
        });
    }

    public static final boolean XIxXXX0x0(IIX0o this$0, TextView textView, int i, KeyEvent keyEvent) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (i == 6) {
            this$0.oOXoIIIo();
            return false;
        }
        return false;
    }

    public static final void XxX0x0xxx(IIX0o this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.oOXoIIIo();
    }

    public static final void xxX(IIX0o this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    @OXOo.OOXIXo
    public final String IIX0o() {
        return this.f21274ooOOo0oXI;
    }

    public final void IO(@OXOo.oOoXoXO Oox.oOoXoXO<? super String, Boolean> oooxoxo) {
        this.f21275x0XOIxOo = oooxoxo;
    }

    @OXOo.OOXIXo
    public final TextView IoOoX() {
        return this.f21271II0XooXoX;
    }

    public final void X00IoxXI(int i) {
        this.f21273oOoXoXO = i;
        this.f21277xxIXOIIO.setInputType(i);
    }

    public final void Xx000oIo(@OXOo.OOXIXo String value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        this.f21274ooOOo0oXI = value;
        this.f21277xxIXOIIO.setText(value);
    }

    public final void oOXoIIIo() {
        String str;
        Oox.oOoXoXO<? super String, Boolean> oooxoxo = this.f21275x0XOIxOo;
        if (oooxoxo != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oooxoxo);
            Editable text = this.f21277xxIXOIIO.getText();
            if (text == null || (str = text.toString()) == null) {
                str = "";
            }
            if (!oooxoxo.invoke(str).booleanValue()) {
                return;
            }
        }
        this.f21277xxIXOIIO.setText((CharSequence) null);
        dismiss();
    }

    @OXOo.OOXIXo
    public final String oo() {
        return this.f21272OOXIXo;
    }

    public final int oo0xXOI0I() {
        return this.f21276xoIox;
    }

    public final int ooXIXxIX() {
        return this.f21273oOoXoXO;
    }

    public final void x0o(@OXOo.OOXIXo String value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        this.f21272OOXIXo = value;
        if (TextUtils.isEmpty(value)) {
            this.f21271II0XooXoX.setVisibility(8);
        } else {
            this.f21271II0XooXoX.setVisibility(0);
            this.f21271II0XooXoX.setText(this.f21272OOXIXo);
        }
    }

    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<String, Boolean> xI() {
        return this.f21275x0XOIxOo;
    }

    public final void xII(int i) {
        this.f21276xoIox = i;
        if (i == 0) {
            this.f21271II0XooXoX.setVisibility(8);
        } else {
            this.f21271II0XooXoX.setVisibility(0);
            this.f21271II0XooXoX.setText(this.f21276xoIox);
        }
    }

    @OXOo.OOXIXo
    public final EditText xXxxox0I() {
        return this.f21277xxIXOIIO;
    }

    public /* synthetic */ IIX0o(Activity activity, int i, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(activity, (i2 & 2) != 0 ? R.layout.pop_edit : i);
    }
}
