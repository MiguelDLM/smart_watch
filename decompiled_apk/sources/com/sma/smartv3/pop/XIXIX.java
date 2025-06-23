package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public final class XIXIX extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ImageView f21374II0XooXoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public boolean f21375xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ImageView f21376xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XIXIX(@OXOo.OOXIXo Activity activity, int i) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        this.f21375xoIox = true;
        setClippingEnabled(true);
        oOoXoXO().setPadding(0, 0, 0, 0);
        setSoftInputMode(16);
        LayoutInflater.from(Oxx0IOOO()).inflate(i, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.pop_recording_img);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        ImageView imageView = (ImageView) findViewById;
        this.f21376xxIXOIIO = imageView;
        Glide.with(Oxx0IOOO()).asGif().load(Integer.valueOf(R.drawable.pop_recording_animation_img)).into(imageView);
        View findViewById2 = xxIXOIIO().findViewById(R.id.pop_recording_clear_img);
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "findViewById(...)");
        this.f21374II0XooXoX = (ImageView) findViewById2;
    }

    @OXOo.OOXIXo
    public final ImageView O0xOxO() {
        return this.f21374II0XooXoX;
    }

    @OXOo.OOXIXo
    public final ImageView X0IIOO() {
        return this.f21376xxIXOIIO;
    }

    public final boolean XI0IXoo() {
        return this.f21375xoIox;
    }

    public final void XIxXXX0x0(boolean z) {
        this.f21375xoIox = z;
        if (z) {
            this.f21374II0XooXoX.setImageResource(R.drawable.pop_recording_clear_selector_img);
        } else {
            this.f21374II0XooXoX.setImageResource(R.drawable.pop_recording_clear_img);
        }
    }

    public /* synthetic */ XIXIX(Activity activity, int i, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(activity, (i2 & 2) != 0 ? R.layout.pop_recording : i);
    }
}
