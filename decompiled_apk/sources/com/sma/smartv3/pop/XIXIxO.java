package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public final class XIXIxO extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.oIX0oI<kotlin.oXIO0o0XI> f21377II0XooXoX;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.oIX0oI<kotlin.oXIO0o0XI> f21378xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XIXIxO(@OXOo.OOXIXo Activity activity) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_select_pair, xxIXOIIO());
        xxIXOIIO().findViewById(R.id.btn_scan_qrcode).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.IoIOOxIIo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XIXIxO.XIxXXX0x0(XIXIxO.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.btn_add_device).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.oxIIX0o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XIXIxO.xxX(XIXIxO.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.o0oIxOo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XIXIxO.XxX0x0xxx(XIXIxO.this, view);
            }
        });
    }

    public static final void XIxXXX0x0(XIXIxO this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Oox.oIX0oI<kotlin.oXIO0o0XI> oix0oi = this$0.f21378xxIXOIIO;
        if (oix0oi != null) {
            oix0oi.invoke();
        }
    }

    public static final void XxX0x0xxx(XIXIxO this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void xxX(XIXIxO this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Oox.oIX0oI<kotlin.oXIO0o0XI> oix0oi = this$0.f21377II0XooXoX;
        if (oix0oi != null) {
            oix0oi.invoke();
        }
    }

    @OXOo.oOoXoXO
    public final Oox.oIX0oI<kotlin.oXIO0o0XI> IIX0o() {
        return this.f21377II0XooXoX;
    }

    public final void ooXIXxIX(@OXOo.oOoXoXO Oox.oIX0oI<kotlin.oXIO0o0XI> oix0oi) {
        this.f21378xxIXOIIO = oix0oi;
    }

    public final void xI(@OXOo.oOoXoXO Oox.oIX0oI<kotlin.oXIO0o0XI> oix0oi) {
        this.f21377II0XooXoX = oix0oi;
    }

    @OXOo.oOoXoXO
    public final Oox.oIX0oI<kotlin.oXIO0o0XI> xXxxox0I() {
        return this.f21378xxIXOIIO;
    }
}
