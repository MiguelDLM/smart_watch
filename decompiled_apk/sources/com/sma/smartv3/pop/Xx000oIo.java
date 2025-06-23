package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public final class Xx000oIo extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21413II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public ListAdapter f21414OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f21415xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final GridView f21416xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Xx000oIo(@OXOo.OOXIXo Activity activity) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_grid, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.tv_title);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21413II0XooXoX = (TextView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.grid_view);
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "findViewById(...)");
        this.f21416xxIXOIIO = (GridView) findViewById2;
    }

    @OXOo.oOoXoXO
    public final ListAdapter O0xOxO() {
        return this.f21414OOXIXo;
    }

    public final int X0IIOO() {
        return this.f21415xoIox;
    }

    public final void XI0IXoo(@OXOo.oOoXoXO ListAdapter listAdapter) {
        this.f21414OOXIXo = listAdapter;
        this.f21416xxIXOIIO.setAdapter(listAdapter);
    }

    public final void XIxXXX0x0(int i) {
        this.f21415xoIox = i;
        this.f21413II0XooXoX.setText(i);
    }
}
