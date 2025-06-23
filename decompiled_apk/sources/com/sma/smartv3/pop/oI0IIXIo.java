package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.LogUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.UtilsKt;

/* loaded from: classes12.dex */
public final class oI0IIXIo extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public TextView f21462II0XooXoX;

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.oOoXoXO
    public String f21463xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public TextView f21464xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oI0IIXIo(@OXOo.OOXIXo Activity mActivity) {
        super(mActivity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(mActivity, "mActivity");
        LayoutInflater.from(mActivity).inflate(R.layout.pop_count_down, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.tv_num);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21462II0XooXoX = (TextView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.tv_detail);
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "findViewById(...)");
        this.f21464xxIXOIIO = (TextView) findViewById2;
    }

    @OXOo.oOoXoXO
    public final String O0xOxO() {
        return this.f21463xoIox;
    }

    public final void X0IIOO(@OXOo.oOoXoXO String str) {
        this.f21463xoIox = str;
        TextView textView = this.f21462II0XooXoX;
        TextView textView2 = null;
        if (textView == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("tv_num");
            textView = null;
        }
        textView.setText(str);
        TextView textView3 = this.f21464xxIXOIIO;
        if (textView3 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("tv_detail");
        } else {
            textView2 = textView3;
        }
        textView2.setText(str + UtilsKt.oI0IIXIo(R.string.count_down_detail));
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
