package com.sma.smartv3.util;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* loaded from: classes12.dex */
public final class o0xxxXXxX {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final TextView f24504I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ViewGroup f24505II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Context f24506oIX0oI;

    public o0xxxXXxX(@OXOo.OOXIXo Context mContext, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(mContext, "mContext");
        this.f24506oIX0oI = mContext;
        View inflate = LayoutInflater.from(mContext).inflate(i, (ViewGroup) null);
        kotlin.jvm.internal.IIX0o.x0XOIxOo(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        this.f24505II0xO0 = viewGroup;
        this.f24504I0Io = (TextView) viewGroup.findViewById(R.id.text1);
    }

    @OXOo.OOXIXo
    public final Bitmap II0xO0(@OXOo.oOoXoXO CharSequence charSequence) {
        TextView textView = this.f24504I0Io;
        if (textView != null) {
            textView.setText(charSequence);
        }
        return oIX0oI();
    }

    @OXOo.OOXIXo
    public final Bitmap oIX0oI() {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f24505II0xO0.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredWidth = this.f24505II0xO0.getMeasuredWidth();
        int measuredHeight = this.f24505II0xO0.getMeasuredHeight();
        this.f24505II0xO0.layout(0, 0, measuredWidth, measuredHeight);
        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        kotlin.jvm.internal.IIX0o.oO(createBitmap, "createBitmap(...)");
        createBitmap.eraseColor(0);
        this.f24505II0xO0.draw(new Canvas(createBitmap));
        return createBitmap;
    }
}
