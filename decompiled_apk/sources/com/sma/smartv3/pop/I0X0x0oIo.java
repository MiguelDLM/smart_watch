package com.sma.smartv3.pop;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public final class I0X0x0oIo extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21259II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f21260OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Integer f21261oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public String f21262ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f21263xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21264xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I0X0x0oIo(@OXOo.OOXIXo Activity activity) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        this.f21260OOXIXo = "";
        x0xO0oo(false);
        LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_load, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.tv_title);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21259II0XooXoX = (TextView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.tv_content);
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "findViewById(...)");
        this.f21264xxIXOIIO = (TextView) findViewById2;
    }

    public final void IIX0o(@OXOo.OOXIXo String value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        this.f21260OOXIXo = value;
        if (TextUtils.isEmpty(value)) {
            this.f21259II0XooXoX.setVisibility(8);
        } else {
            this.f21259II0XooXoX.setVisibility(0);
            this.f21259II0XooXoX.setText(this.f21260OOXIXo);
        }
    }

    @OXOo.oOoXoXO
    public final Integer O0xOxO() {
        return this.f21261oOoXoXO;
    }

    @OXOo.oOoXoXO
    public final String X0IIOO() {
        return this.f21262ooOOo0oXI;
    }

    public final int XI0IXoo() {
        return this.f21263xoIox;
    }

    @OXOo.OOXIXo
    public final String XIxXXX0x0() {
        return this.f21260OOXIXo;
    }

    public final void XxX0x0xxx(@OXOo.oOoXoXO String str) {
        this.f21262ooOOo0oXI = str;
        if (str == null) {
            this.f21264xxIXOIIO.setVisibility(8);
            return;
        }
        this.f21264xxIXOIIO.setVisibility(0);
        TextView textView = this.f21264xxIXOIIO;
        String str2 = this.f21262ooOOo0oXI;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(str2);
        textView.setText(str2);
    }

    public final void xXxxox0I(int i) {
        this.f21263xoIox = i;
        if (i == 0) {
            this.f21259II0XooXoX.setVisibility(8);
        } else {
            this.f21259II0XooXoX.setVisibility(0);
            this.f21259II0XooXoX.setText(this.f21263xoIox);
        }
    }

    public final void xxX(@OXOo.oOoXoXO Integer num) {
        this.f21261oOoXoXO = num;
        if (num == null) {
            this.f21264xxIXOIIO.setVisibility(8);
            return;
        }
        this.f21264xxIXOIIO.setVisibility(0);
        TextView textView = this.f21264xxIXOIIO;
        Integer num2 = this.f21261oOoXoXO;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(num2);
        textView.setText(num2.intValue());
    }
}
