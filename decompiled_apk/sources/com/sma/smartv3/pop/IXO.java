package com.sma.smartv3.pop;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public final class IXO extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final EditText f21281II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.x0xO0oo<? super String, ? super Integer, Boolean> f21282OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f21283oOoXoXO;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f21284xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f21285xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IXO(@OXOo.OOXIXo Activity activity, int i) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        this.f21285xxIXOIIO = "";
        this.f21284xoIox = 1;
        this.f21283oOoXoXO = -1;
        setClippingEnabled(true);
        oOoXoXO().setPadding(0, 0, 0, 0);
        setSoftInputMode(16);
        LayoutInflater.from(Oxx0IOOO()).inflate(i, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.edt);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        EditText editText = (EditText) findViewById;
        this.f21281II0XooXoX = editText;
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.sma.smartv3.pop.x0OIX00oO
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                boolean xxX2;
                xxX2 = IXO.xxX(IXO.this, textView, i2, keyEvent);
                return xxX2;
            }
        });
        final View findViewById2 = xxIXOIIO().findViewById(R.id.share_edit_white_view);
        final View findViewById3 = xxIXOIIO().findViewById(R.id.share_edit_black_view);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(findViewById2);
        Xx000oIo(findViewById2, -1, true);
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.XXoOx0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IXO.XxX0x0xxx(IXO.this, findViewById2, findViewById3, view);
            }
        });
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.IxIX0I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IXO.xXxxox0I(IXO.this, findViewById2, findViewById3, view);
            }
        });
        xxIXOIIO().findViewById(R.id.action2).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.oOoIIO0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IXO.IIX0o(IXO.this, view);
            }
        });
    }

    public static final void IIX0o(IXO this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.oOXoIIIo();
    }

    public static final void XxX0x0xxx(IXO this$0, View view, View view2, View view3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.f21283oOoXoXO = -1;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(view);
        this$0.Xx000oIo(view, -1, true);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(view2);
        this$0.Xx000oIo(view2, ViewCompat.MEASURED_STATE_MASK, false);
    }

    private final void oOXoIIIo() {
        String str;
        Oox.x0xO0oo<? super String, ? super Integer, Boolean> x0xo0oo = this.f21282OOXIXo;
        if (x0xo0oo != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(x0xo0oo);
            Editable text = this.f21281II0XooXoX.getText();
            if (text == null || (str = text.toString()) == null) {
                str = "";
            }
            if (!x0xo0oo.invoke(str, Integer.valueOf(this.f21283oOoXoXO)).booleanValue()) {
                return;
            }
        }
        this.f21281II0XooXoX.setText((CharSequence) null);
        dismiss();
    }

    public static final void xXxxox0I(IXO this$0, View view, View view2, View view3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.f21283oOoXoXO = ViewCompat.MEASURED_STATE_MASK;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(view);
        this$0.Xx000oIo(view, -1, false);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(view2);
        this$0.Xx000oIo(view2, ViewCompat.MEASURED_STATE_MASK, true);
    }

    public static final boolean xxX(IXO this$0, TextView textView, int i, KeyEvent keyEvent) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (i == 6) {
            this$0.oOXoIIIo();
            return false;
        }
        return false;
    }

    public final void IO(int i) {
        this.f21284xoIox = i;
        this.f21281II0XooXoX.setInputType(i);
    }

    public final int IoOoX() {
        return this.f21283oOoXoXO;
    }

    public final void X00IoxXI(@OXOo.OOXIXo String value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        this.f21285xxIXOIIO = value;
        this.f21281II0XooXoX.setText(value);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void Xx000oIo(@OXOo.OOXIXo View view, int i, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        if (z) {
            gradientDrawable.setStroke(6, Color.parseColor("#CF4000"));
        }
        view.setBackground(gradientDrawable);
    }

    @OXOo.oOoXoXO
    public final Oox.x0xO0oo<String, Integer, Boolean> oo() {
        return this.f21282OOXIXo;
    }

    public final int oo0xXOI0I() {
        return this.f21284xoIox;
    }

    @OXOo.OOXIXo
    public final EditText ooXIXxIX() {
        return this.f21281II0XooXoX;
    }

    public final void x0o(int i) {
        this.f21283oOoXoXO = i;
    }

    @OXOo.OOXIXo
    public final String xI() {
        return this.f21285xxIXOIIO;
    }

    public final void xII(@OXOo.oOoXoXO Oox.x0xO0oo<? super String, ? super Integer, Boolean> x0xo0oo) {
        this.f21282OOXIXo = x0xo0oo;
    }

    public /* synthetic */ IXO(Activity activity, int i, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(activity, (i2 & 2) != 0 ? R.layout.share_card_pop_edit : i);
    }
}
