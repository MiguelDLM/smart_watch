package com.sma.smartv3.pop;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.blankj.utilcode.util.KeyboardUtils;
import com.sma.smartv3.biz.OrderManager;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public class x0xO0oo extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final View f21503II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f21504OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public SpannableStringBuilder f21505Oo;

    /* renamed from: oO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Integer f21506oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f21507oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f21508ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Integer f21509x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public String f21510x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21511xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21512xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0xO0oo(@OXOo.OOXIXo Activity activity, int i) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        x0xO0oo(false);
        LayoutInflater.from(Oxx0IOOO()).inflate(i, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.pop_center_prompt_closure);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21503II0XooXoX = findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.pop_center_prompt_img_title);
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "findViewById(...)");
        this.f21512xxIXOIIO = (TextView) findViewById2;
        View findViewById3 = xxIXOIIO().findViewById(R.id.pop_center_prompt_img_content);
        kotlin.jvm.internal.IIX0o.oO(findViewById3, "findViewById(...)");
        this.f21511xoIox = (TextView) findViewById3;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.oO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x0xO0oo.X0IIOO(x0xO0oo.this, view);
            }
        });
        this.f21507oOoXoXO = ViewCompat.MEASURED_STATE_MASK;
        this.f21508ooOOo0oXI = "";
        this.f21506oO = 17;
    }

    public static final void X0IIOO(x0xO0oo this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    public final int IIX0o() {
        return this.f21507oOoXoXO;
    }

    public final void IoOoX(@OXOo.oOoXoXO String str) {
        this.f21510x0xO0oo = str;
        if (str == null) {
            this.f21511xoIox.setVisibility(8);
            return;
        }
        this.f21511xoIox.setVisibility(0);
        TextView textView = this.f21511xoIox;
        String str2 = this.f21510x0xO0oo;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(str2);
        textView.setText(str2);
    }

    public final void X00IoxXI(@OXOo.OOXIXo String value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        this.f21508ooOOo0oXI = value;
        if (TextUtils.isEmpty(value)) {
            this.f21512xxIXOIIO.setVisibility(8);
        } else {
            this.f21512xxIXOIIO.setVisibility(0);
            this.f21512xxIXOIIO.setText(this.f21508ooOOo0oXI);
        }
    }

    @OXOo.oOoXoXO
    public final Integer XI0IXoo() {
        return this.f21509x0XOIxOo;
    }

    @OXOo.oOoXoXO
    public final Integer XIxXXX0x0() {
        return this.f21506oO;
    }

    public final void Xx000oIo(int i) {
        this.f21507oOoXoXO = i;
        this.f21512xxIXOIIO.setTextColor(i);
    }

    @OXOo.oOoXoXO
    public final String XxX0x0xxx() {
        return this.f21510x0xO0oo;
    }

    public final void oOXoIIIo(int i) {
        this.f21504OOXIXo = i;
        if (i == 0) {
            this.f21512xxIXOIIO.setVisibility(8);
        } else {
            this.f21512xxIXOIIO.setVisibility(0);
            this.f21512xxIXOIIO.setText(this.f21504OOXIXo);
        }
    }

    public final void oo(@OXOo.oOoXoXO SpannableStringBuilder spannableStringBuilder) {
        this.f21505Oo = spannableStringBuilder;
        if (spannableStringBuilder == null) {
            this.f21511xoIox.setVisibility(8);
            return;
        }
        this.f21511xoIox.setVisibility(0);
        TextView textView = this.f21511xoIox;
        SpannableStringBuilder spannableStringBuilder2 = this.f21505Oo;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(spannableStringBuilder2);
        textView.setText(spannableStringBuilder2);
    }

    public final void oo0xXOI0I(@OXOo.oOoXoXO Integer num) {
        this.f21506oO = num;
        TextView textView = this.f21511xoIox;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(num);
        textView.setGravity(num.intValue());
    }

    @OXOo.OOXIXo
    public final String ooXIXxIX() {
        return this.f21508ooOOo0oXI;
    }

    public final void xI(@OXOo.oOoXoXO Integer num) {
        this.f21509x0XOIxOo = num;
        if (num == null) {
            this.f21511xoIox.setVisibility(8);
            return;
        }
        this.f21511xoIox.setVisibility(0);
        TextView textView = this.f21511xoIox;
        Integer num2 = this.f21509x0XOIxOo;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(num2);
        textView.setText(num2.intValue());
    }

    public final int xXxxox0I() {
        return this.f21504OOXIXo;
    }

    @Override // OOOI.I0Io
    public void xoXoI(@OXOo.OOXIXo View anchor) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(anchor, "anchor");
        try {
            OrderManager.f20130oIX0oI.oo0xXOI0I(true);
            if (Oxx0IOOO().isFinishing()) {
                return;
            }
            showAtLocation(anchor, 80, 0, 0);
            oOXoIIIo.oIX0oI.I0Io(Oxx0IOOO(), 1.0f);
            oOoXoXO().setBackgroundResource(R.color.popup_root_bg_color);
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
    public final SpannableStringBuilder xxX() {
        return this.f21505Oo;
    }

    public /* synthetic */ x0xO0oo(Activity activity, int i, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(activity, (i2 & 2) != 0 ? R.layout.pop_center_prompt : i);
    }
}
