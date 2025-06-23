package com.sma.smartv3.pop.dial;

import OXOo.OOXIXo;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.ResourcesIdInfo;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class oxoX extends BaseDialPop {

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OOXIXo
    public final RecyclerView f21452OOXIXo;

    /* renamed from: oO, reason: collision with root package name */
    @OOXIXo
    public final TextView f21453oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OOXIXo
    public final Button f21454oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OOXIXo
    public final TextView f21455ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @OOXIXo
    public final TextView f21456x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    @OOXIXo
    public final RelativeLayout f21457xoIox;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oxoX(@OOXIXo Activity activity, @OOXIXo List<ResourcesIdInfo> colors, @OOXIXo com.sma.smartv3.util.OOXIXo<Integer> callback) {
        super(activity, colors, callback);
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(colors, "colors");
        IIX0o.x0xO0oo(callback, "callback");
        LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_dial_number, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.dialSelect0);
        IIX0o.oO(findViewById, "findViewById(...)");
        this.f21457xoIox = (RelativeLayout) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.rv);
        IIX0o.oO(findViewById2, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.f21452OOXIXo = recyclerView;
        View findViewById3 = xxIXOIIO().findViewById(R.id.confirmButton);
        IIX0o.oO(findViewById3, "findViewById(...)");
        Button button = (Button) findViewById3;
        this.f21454oOoXoXO = button;
        button.setVisibility(8);
        View findViewById4 = xxIXOIIO().findViewById(R.id.tv0);
        IIX0o.oO(findViewById4, "findViewById(...)");
        this.f21455ooOOo0oXI = (TextView) findViewById4;
        View findViewById5 = xxIXOIIO().findViewById(R.id.tv1);
        IIX0o.oO(findViewById5, "findViewById(...)");
        this.f21456x0XOIxOo = (TextView) findViewById5;
        View findViewById6 = xxIXOIIO().findViewById(R.id.tv2);
        IIX0o.oO(findViewById6, "findViewById(...)");
        this.f21453oO = (TextView) findViewById6;
        recyclerView.setLayoutManager(X0IIOO());
        recyclerView.setAdapter(O0xOxO());
    }

    @OOXIXo
    public final TextView IIX0o() {
        return this.f21453oO;
    }

    @OOXIXo
    public final Button XI0IXoo() {
        return this.f21454oOoXoXO;
    }

    @OOXIXo
    public final RelativeLayout XIxXXX0x0() {
        return this.f21457xoIox;
    }

    @OOXIXo
    public final TextView XxX0x0xxx() {
        return this.f21455ooOOo0oXI;
    }

    public final void ooXIXxIX(int i) {
        this.f21455ooOOo0oXI.setTextColor(i);
        this.f21456x0XOIxOo.setTextColor(i);
        this.f21453oO.setTextColor(i);
    }

    @OOXIXo
    public final TextView xXxxox0I() {
        return this.f21456x0XOIxOo;
    }

    @OOXIXo
    public final RecyclerView xxX() {
        return this.f21452OOXIXo;
    }
}
