package com.sma.smartv3.pop.dial;

import OXOo.OOXIXo;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.ResourcesIdInfo;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class I0Io extends BaseDialPop {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OOXIXo
    public final RecyclerView f21423IXxxXO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OOXIXo
    public final LinearLayout f21424OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    public final ImageView f21425Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OOXIXo
    public final Button f21426Oxx0xo;

    /* renamed from: oO, reason: collision with root package name */
    @OOXIXo
    public final ImageView f21427oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OOXIXo
    public final LinearLayout f21428oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OOXIXo
    public final LinearLayout f21429ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @OOXIXo
    public final ImageView f21430x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    @OOXIXo
    public final ImageView f21431x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    @OOXIXo
    public final LinearLayout f21432xoIox;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I0Io(@OOXIXo Activity activity, @OOXIXo List<ResourcesIdInfo> colors, @OOXIXo com.sma.smartv3.util.OOXIXo<Integer> callback) {
        super(activity, colors, callback);
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(colors, "colors");
        IIX0o.x0xO0oo(callback, "callback");
        LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_dial_control, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.dialSelect0);
        IIX0o.oO(findViewById, "findViewById(...)");
        this.f21432xoIox = (LinearLayout) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.dialSelect1);
        IIX0o.oO(findViewById2, "findViewById(...)");
        this.f21424OOXIXo = (LinearLayout) findViewById2;
        View findViewById3 = xxIXOIIO().findViewById(R.id.dialSelect2);
        IIX0o.oO(findViewById3, "findViewById(...)");
        this.f21428oOoXoXO = (LinearLayout) findViewById3;
        View findViewById4 = xxIXOIIO().findViewById(R.id.dialSelect3);
        IIX0o.oO(findViewById4, "findViewById(...)");
        this.f21429ooOOo0oXI = (LinearLayout) findViewById4;
        View findViewById5 = xxIXOIIO().findViewById(R.id.dialSelectStatus0);
        IIX0o.oO(findViewById5, "findViewById(...)");
        this.f21430x0XOIxOo = (ImageView) findViewById5;
        View findViewById6 = xxIXOIIO().findViewById(R.id.dialSelectStatus1);
        IIX0o.oO(findViewById6, "findViewById(...)");
        this.f21427oO = (ImageView) findViewById6;
        View findViewById7 = xxIXOIIO().findViewById(R.id.dialSelectStatus2);
        IIX0o.oO(findViewById7, "findViewById(...)");
        this.f21431x0xO0oo = (ImageView) findViewById7;
        View findViewById8 = xxIXOIIO().findViewById(R.id.dialSelectStatus3);
        IIX0o.oO(findViewById8, "findViewById(...)");
        this.f21425Oo = (ImageView) findViewById8;
        View findViewById9 = xxIXOIIO().findViewById(R.id.rv);
        IIX0o.oO(findViewById9, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) findViewById9;
        this.f21423IXxxXO = recyclerView;
        View findViewById10 = xxIXOIIO().findViewById(R.id.confirmButton);
        IIX0o.oO(findViewById10, "findViewById(...)");
        Button button = (Button) findViewById10;
        this.f21426Oxx0xo = button;
        button.setVisibility(8);
        recyclerView.setLayoutManager(X0IIOO());
        recyclerView.setAdapter(O0xOxO());
    }

    @OOXIXo
    public final ImageView IIX0o() {
        return this.f21430x0XOIxOo;
    }

    @OOXIXo
    public final Button XI0IXoo() {
        return this.f21426Oxx0xo;
    }

    @OOXIXo
    public final LinearLayout XIxXXX0x0() {
        return this.f21432xoIox;
    }

    @OOXIXo
    public final LinearLayout XxX0x0xxx() {
        return this.f21428oOoXoXO;
    }

    @OOXIXo
    public final RecyclerView oo() {
        return this.f21423IXxxXO;
    }

    @OOXIXo
    public final ImageView oo0xXOI0I() {
        return this.f21425Oo;
    }

    @OOXIXo
    public final ImageView ooXIXxIX() {
        return this.f21427oO;
    }

    @OOXIXo
    public final ImageView xI() {
        return this.f21431x0xO0oo;
    }

    @OOXIXo
    public final LinearLayout xXxxox0I() {
        return this.f21429ooOOo0oXI;
    }

    @OOXIXo
    public final LinearLayout xxX() {
        return this.f21424OOXIXo;
    }
}
