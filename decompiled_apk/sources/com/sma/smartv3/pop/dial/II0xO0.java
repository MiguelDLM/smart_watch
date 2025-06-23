package com.sma.smartv3.pop.dial;

import OXOo.OOXIXo;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class II0xO0 extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OOXIXo
    public final Button f21433II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OOXIXo
    public final ImageView f21434OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OOXIXo
    public final ImageView f21435oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OOXIXo
    public final ImageView f21436ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @OOXIXo
    public final ImageView f21437x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    @OOXIXo
    public final ImageView f21438xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OOXIXo
    public final ImageView f21439xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public II0xO0(@OOXIXo Activity activity) {
        super(activity);
        IIX0o.x0xO0oo(activity, "activity");
        LayoutInflater.from(Oxx0IOOO()).inflate(ProductManager.f20544oIX0oI.Io(), xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.btn_bottom);
        IIX0o.oO(findViewById, "findViewById(...)");
        this.f21433II0XooXoX = (Button) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.dialSelect0);
        IIX0o.oO(findViewById2, "findViewById(...)");
        this.f21439xxIXOIIO = (ImageView) findViewById2;
        View findViewById3 = xxIXOIIO().findViewById(R.id.dialSelect1);
        IIX0o.oO(findViewById3, "findViewById(...)");
        this.f21438xoIox = (ImageView) findViewById3;
        View findViewById4 = xxIXOIIO().findViewById(R.id.dialSelect2);
        IIX0o.oO(findViewById4, "findViewById(...)");
        this.f21434OOXIXo = (ImageView) findViewById4;
        View findViewById5 = xxIXOIIO().findViewById(R.id.dialSelect3);
        IIX0o.oO(findViewById5, "findViewById(...)");
        this.f21435oOoXoXO = (ImageView) findViewById5;
        View findViewById6 = xxIXOIIO().findViewById(R.id.dialSelect4);
        IIX0o.oO(findViewById6, "findViewById(...)");
        this.f21436ooOOo0oXI = (ImageView) findViewById6;
        View findViewById7 = xxIXOIIO().findViewById(R.id.dialSelect5);
        IIX0o.oO(findViewById7, "findViewById(...)");
        this.f21437x0XOIxOo = (ImageView) findViewById7;
    }

    @OOXIXo
    public final ImageView O0xOxO() {
        return this.f21439xxIXOIIO;
    }

    @OOXIXo
    public final ImageView X0IIOO() {
        return this.f21438xoIox;
    }

    @OOXIXo
    public final ImageView XI0IXoo() {
        return this.f21434OOXIXo;
    }

    @OOXIXo
    public final ImageView XIxXXX0x0() {
        return this.f21435oOoXoXO;
    }

    @OOXIXo
    public final ImageView XxX0x0xxx() {
        return this.f21437x0XOIxOo;
    }

    @OOXIXo
    public final Button xXxxox0I() {
        return this.f21433II0XooXoX;
    }

    @OOXIXo
    public final ImageView xxX() {
        return this.f21436ooOOo0oXI;
    }
}
