package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.LogUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public final class xOOxIO extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public ImageView f21520II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public AppCompatCheckBox f21521OOXIXo;

    /* renamed from: oO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Integer f21522oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public ImageView f21523oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public String f21524ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public String f21525x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Boolean f21526x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public TextView f21527xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public TextView f21528xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xOOxIO(@OXOo.OOXIXo Activity mActivity) {
        super(mActivity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(mActivity, "mActivity");
        LayoutInflater.from(mActivity).inflate(R.layout.pop_tip_translation, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.img_close);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21520II0XooXoX = (ImageView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.tv_tip_1);
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "findViewById(...)");
        this.f21528xxIXOIIO = (TextView) findViewById2;
        View findViewById3 = xxIXOIIO().findViewById(R.id.tv_tip_2);
        kotlin.jvm.internal.IIX0o.oO(findViewById3, "findViewById(...)");
        this.f21527xoIox = (TextView) findViewById3;
        View findViewById4 = xxIXOIIO().findViewById(R.id.tip_check);
        kotlin.jvm.internal.IIX0o.oO(findViewById4, "findViewById(...)");
        oo((AppCompatCheckBox) findViewById4);
        View findViewById5 = xxIXOIIO().findViewById(R.id.img_tip);
        kotlin.jvm.internal.IIX0o.oO(findViewById5, "findViewById(...)");
        this.f21523oOoXoXO = (ImageView) findViewById5;
        ImageView imageView = this.f21520II0XooXoX;
        if (imageView == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("img_close");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.xIXX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                xOOxIO.X0IIOO(xOOxIO.this, view);
            }
        });
    }

    public static final void X0IIOO(xOOxIO this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    public final void IIX0o(@OXOo.oOoXoXO Integer num) {
        this.f21522oO = num;
        ImageView imageView = this.f21523oOoXoXO;
        if (imageView == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("img_tip");
            imageView = null;
        }
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(num);
        imageView.setImageResource(num.intValue());
    }

    @OXOo.oOoXoXO
    public final Integer XI0IXoo() {
        return this.f21522oO;
    }

    @OXOo.oOoXoXO
    public final String XIxXXX0x0() {
        return this.f21524ooOOo0oXI;
    }

    @OXOo.oOoXoXO
    public final Boolean XxX0x0xxx() {
        return this.f21526x0xO0oo;
    }

    public final void oo(@OXOo.OOXIXo AppCompatCheckBox appCompatCheckBox) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(appCompatCheckBox, "<set-?>");
        this.f21521OOXIXo = appCompatCheckBox;
    }

    public final void oo0xXOI0I(@OXOo.oOoXoXO Boolean bool) {
        this.f21526x0xO0oo = bool;
        AppCompatCheckBox xXxxox0I2 = xXxxox0I();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(bool);
        xXxxox0I2.setChecked(bool.booleanValue());
    }

    public final void ooXIXxIX(@OXOo.oOoXoXO String str) {
        this.f21524ooOOo0oXI = str;
        TextView textView = this.f21528xxIXOIIO;
        if (textView == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("tv_tip_1");
            textView = null;
        }
        textView.setText(str);
    }

    public final void xI(@OXOo.oOoXoXO String str) {
        this.f21525x0XOIxOo = str;
        TextView textView = this.f21527xoIox;
        if (textView == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("tv_tip_2");
            textView = null;
        }
        textView.setText(str);
    }

    @OXOo.OOXIXo
    public final AppCompatCheckBox xXxxox0I() {
        AppCompatCheckBox appCompatCheckBox = this.f21521OOXIXo;
        if (appCompatCheckBox != null) {
            return appCompatCheckBox;
        }
        kotlin.jvm.internal.IIX0o.XOxIOxOx("tip_check");
        return null;
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

    @OXOo.oOoXoXO
    public final String xxX() {
        return this.f21525x0XOIxOo;
    }
}
