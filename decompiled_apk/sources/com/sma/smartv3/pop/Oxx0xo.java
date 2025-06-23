package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.LogUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public final class Oxx0xo extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public ImageView f21346II0XooXoX;

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Integer f21347xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public ImageView f21348xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Oxx0xo(@OXOo.OOXIXo Activity mActivity) {
        super(mActivity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(mActivity, "mActivity");
        LayoutInflater.from(mActivity).inflate(R.layout.pop_connect_img, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.img_close);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21346II0XooXoX = (ImageView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.img_connect);
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "findViewById(...)");
        this.f21348xxIXOIIO = (ImageView) findViewById2;
        ImageView imageView = this.f21346II0XooXoX;
        if (imageView == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("img_close");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.IXxxXO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Oxx0xo.X0IIOO(Oxx0xo.this, view);
            }
        });
    }

    public static final void X0IIOO(Oxx0xo this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    @OXOo.oOoXoXO
    public final Integer XI0IXoo() {
        return this.f21347xoIox;
    }

    public final void XIxXXX0x0(@OXOo.oOoXoXO Integer num) {
        this.f21347xoIox = num;
        if (num != null) {
            ImageView imageView = this.f21348xxIXOIIO;
            if (imageView == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("img_connect");
                imageView = null;
            }
            imageView.setImageResource(num.intValue());
        }
    }

    @Override // OOOI.I0Io
    public void xoXoI(@OXOo.OOXIXo View anchor) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(anchor, "anchor");
        try {
            if (Oxx0IOOO().isFinishing()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(anchor.getHeight());
            sb.append(TokenParser.SP);
            sb.append(oOoXoXO().getHeight());
            LogUtils.d(sb.toString());
            showAtLocation(anchor, 17, 0, (-anchor.getHeight()) / 4);
            oOXoIIIo.oIX0oI.I0Io(Oxx0IOOO(), 0.6f);
            KeyboardUtils.hideSoftInput(anchor);
            Oox.oIX0oI<kotlin.oXIO0o0XI> OOXIXo2 = OOXIXo();
            if (OOXIXo2 != null) {
                OOXIXo2.invoke();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
