package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public class xOOOX extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ProgressBar f21515II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f21516OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f21517oOoXoXO;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f21518xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21519xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xOOOX(@OXOo.OOXIXo Activity activity, int i) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        this.f21517oOoXoXO = "";
        x0xO0oo(false);
        LayoutInflater.from(Oxx0IOOO()).inflate(i, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.tv_title);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21519xxIXOIIO = (TextView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.progress_bar);
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "findViewById(...)");
        this.f21515II0XooXoX = (ProgressBar) findViewById2;
    }

    public final int O0xOxO() {
        return this.f21516OOXIXo;
    }

    public final int X0IIOO() {
        return this.f21518xoIox;
    }

    @OXOo.OOXIXo
    public final String XI0IXoo() {
        return this.f21517oOoXoXO;
    }

    public final void XIxXXX0x0(int i) {
        this.f21516OOXIXo = i;
        this.f21515II0XooXoX.setProgress(i);
    }

    public final void XxX0x0xxx(@OXOo.OOXIXo String value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        this.f21517oOoXoXO = value;
        this.f21519xxIXOIIO.setText(value);
    }

    public final void xxX(int i) {
        this.f21518xoIox = i;
        this.f21519xxIXOIIO.setText(i);
    }

    public /* synthetic */ xOOOX(Activity activity, int i, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(activity, (i2 & 2) != 0 ? R.layout.pop_progress : i);
    }
}
