package com.sma.smartv3.pop;

import android.app.Activity;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public final class XX0xXo extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final EditText f21392II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.oOoXoXO<? super String, Boolean> f21393OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f21394xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ViewGroup f21395xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XX0xXo(@OXOo.OOXIXo Activity activity) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        this.f21394xoIox = 2;
        LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_password, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.edt);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        EditText editText = (EditText) findViewById;
        this.f21392II0XooXoX = editText;
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.sma.smartv3.pop.XIo0oOXIx
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean XIxXXX0x02;
                XIxXXX0x02 = XX0xXo.XIxXXX0x0(XX0xXo.this, textView, i, keyEvent);
                return XIxXXX0x02;
            }
        });
        View findViewById2 = xxIXOIIO().findViewById(R.id.number_panel);
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "findViewById(...)");
        ViewGroup viewGroup = (ViewGroup) findViewById2;
        this.f21395xxIXOIIO = viewGroup;
        xxIXOIIO().findViewById(R.id.action2).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.Ioxxx
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XX0xXo.xxX(XX0xXo.this, view);
            }
        });
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View childAt = this.f21395xxIXOIIO.getChildAt(i);
            if (childAt instanceof Button) {
                childAt.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.xxIO
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        XX0xXo.XxX0x0xxx(childAt, this, view);
                    }
                });
            }
        }
    }

    public static final boolean XIxXXX0x0(XX0xXo this$0, TextView textView, int i, KeyEvent keyEvent) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (i == 6) {
            this$0.oo0xXOI0I();
            return false;
        }
        return false;
    }

    public static final void XxX0x0xxx(View view, XX0xXo this$0, View view2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        String obj = ((Button) view).getText().toString();
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(obj, "DEL")) {
            Editable text = this$0.f21392II0XooXoX.getText();
            kotlin.jvm.internal.IIX0o.oO(text, "getText(...)");
            if (text.length() > 0) {
                text.delete(text.length() - 1, text.length());
                this$0.f21392II0XooXoX.setText(text);
                return;
            }
            return;
        }
        this$0.f21392II0XooXoX.append(obj);
    }

    private final void oo0xXOI0I() {
        String str;
        Oox.oOoXoXO<? super String, Boolean> oooxoxo = this.f21393OOXIXo;
        if (oooxoxo != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oooxoxo);
            Editable text = this.f21392II0XooXoX.getText();
            if (text == null || (str = text.toString()) == null) {
                str = "";
            }
            if (!oooxoxo.invoke(str).booleanValue()) {
                return;
            }
        }
        this.f21392II0XooXoX.setText((CharSequence) null);
        dismiss();
    }

    public static final void xxX(XX0xXo this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.oo0xXOI0I();
    }

    public final int IIX0o() {
        return this.f21394xoIox;
    }

    public final void IoOoX(@OXOo.oOoXoXO Oox.oOoXoXO<? super String, Boolean> oooxoxo) {
        this.f21393OOXIXo = oooxoxo;
    }

    public final void oo(int i) {
        this.f21394xoIox = i;
        this.f21392II0XooXoX.setInputType(i);
    }

    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<String, Boolean> ooXIXxIX() {
        return this.f21393OOXIXo;
    }

    @OXOo.OOXIXo
    public final ViewGroup xI() {
        return this.f21395xxIXOIIO;
    }

    @OXOo.OOXIXo
    public final EditText xXxxox0I() {
        return this.f21392II0XooXoX;
    }
}
