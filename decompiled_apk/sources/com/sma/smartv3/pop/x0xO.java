package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.view.text.PFMedium;

/* loaded from: classes12.dex */
public final class x0xO extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ImageView f21500II0XooXoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public boolean f21501xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.oIX0oI<kotlin.oXIO0o0XI> f21502xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0xO(@OXOo.OOXIXo Activity activity) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        x0xO0oo(false);
        LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_pair_confirm, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.iv);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21500II0XooXoX = (ImageView) findViewById;
        xxIXOIIO().findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.xoIxX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x0xO.X0IIOO(x0xO.this, view);
            }
        });
        ProductManager productManager = ProductManager.f20544oIX0oI;
    }

    public static final void X0IIOO(x0xO this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.XI0IXoo();
    }

    public final void IIX0o(boolean z) {
        this.f21501xoIox = z;
        if (z) {
            PFMedium pFMedium = (PFMedium) xxIXOIIO().findViewById(R.id.pop_pair_confirm_tv_title);
            PFMedium pFMedium2 = (PFMedium) xxIXOIIO().findViewById(R.id.pop_pair_confirm_tv_tip);
            pFMedium.setText(UtilsKt.oI0IIXIo(R.string.tip));
            pFMedium2.setText(UtilsKt.oI0IIXIo(R.string.pair_confirm_content_v2));
        }
    }

    public final void XI0IXoo() {
        Oox.oIX0oI<kotlin.oXIO0o0XI> oix0oi = this.f21502xxIXOIIO;
        if (oix0oi != null) {
            oix0oi.invoke();
        }
    }

    @OXOo.OOXIXo
    public final ImageView XIxXXX0x0() {
        return this.f21500II0XooXoX;
    }

    public final boolean XxX0x0xxx() {
        return this.f21501xoIox;
    }

    public final void xXxxox0I(@OXOo.oOoXoXO Oox.oIX0oI<kotlin.oXIO0o0XI> oix0oi) {
        this.f21502xxIXOIIO = oix0oi;
    }

    @OXOo.oOoXoXO
    public final Oox.oIX0oI<kotlin.oXIO0o0XI> xxX() {
        return this.f21502xxIXOIIO;
    }
}
