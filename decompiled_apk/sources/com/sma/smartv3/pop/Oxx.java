package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public final class Oxx extends OOOI.oxoX {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f21332IXxxXO = 1;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f21333Oo = new oIX0oI(null);

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f21334Oxx0xo = 2;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f21335oI0IIXIo = 3;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public TextView f21336II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OXOo.OOXIXo
    public TextView f21337OOXIXo;

    /* renamed from: oO, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f21338oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.oOoXoXO<? super Integer, Boolean> f21339oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f21340ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f21341x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f21342x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public TextView f21343xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public TextView f21344xxIXOIIO;

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Oxx(@OXOo.OOXIXo Activity activity) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        this.f21340ooOOo0oXI = "";
        this.f21341x0XOIxOo = "";
        this.f21338oO = "";
        this.f21342x0xO0oo = "";
        setClippingEnabled(true);
        oOoXoXO().setPadding(0, 0, 0, 0);
        setSoftInputMode(16);
        LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_save_translation_detail, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.pop_translation_detail_audio_duration);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21336II0XooXoX = (TextView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.pop_translation_detail_audio_text_number);
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "findViewById(...)");
        this.f21344xxIXOIIO = (TextView) findViewById2;
        View findViewById3 = xxIXOIIO().findViewById(R.id.pop_translation_detail_audio_file_size);
        kotlin.jvm.internal.IIX0o.oO(findViewById3, "findViewById(...)");
        this.f21343xoIox = (TextView) findViewById3;
        View findViewById4 = xxIXOIIO().findViewById(R.id.pop_translation_detail_audio_time);
        kotlin.jvm.internal.IIX0o.oO(findViewById4, "findViewById(...)");
        this.f21337OOXIXo = (TextView) findViewById4;
        xxIXOIIO().findViewById(R.id.action1).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.oIIxXoo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Oxx.xxX(Oxx.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.action2).setVisibility(8);
        xxIXOIIO().findViewById(R.id.pop_translation_detail_copy_text).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.oXX0IoI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Oxx.XxX0x0xxx(Oxx.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.pop_translation_detail_export).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.XXXI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Oxx.xXxxox0I(Oxx.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.pop_translation_detail_delete_audio).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.I0xX0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Oxx.IIX0o(Oxx.this, view);
            }
        });
    }

    public static final void IIX0o(Oxx this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Oox.oOoXoXO<? super Integer, Boolean> oooxoxo = this$0.f21339oOoXoXO;
        if (oooxoxo != null) {
            oooxoxo.invoke(3);
        }
        this$0.dismiss();
    }

    public static final void XxX0x0xxx(Oxx this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Oox.oOoXoXO<? super Integer, Boolean> oooxoxo = this$0.f21339oOoXoXO;
        if (oooxoxo != null) {
            oooxoxo.invoke(1);
        }
        this$0.dismiss();
    }

    public static final void xXxxox0I(Oxx this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Oox.oOoXoXO<? super Integer, Boolean> oooxoxo = this$0.f21339oOoXoXO;
        if (oooxoxo != null) {
            oooxoxo.invoke(2);
        }
        this$0.dismiss();
    }

    public static final void xxX(Oxx this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    public final void I0oOoX(@OXOo.oOoXoXO Oox.oOoXoXO<? super Integer, Boolean> oooxoxo) {
        this.f21339oOoXoXO = oooxoxo;
    }

    @OXOo.OOXIXo
    public final String IO() {
        return this.f21341x0XOIxOo;
    }

    public final void Io(@OXOo.OOXIXo String value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        this.f21340ooOOo0oXI = value;
        this.f21336II0XooXoX.setText(value);
    }

    @OXOo.OOXIXo
    public final String IoOoX() {
        return this.f21340ooOOo0oXI;
    }

    public final void OI0(@OXOo.OOXIXo TextView textView) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(textView, "<set-?>");
        this.f21337OOXIXo = textView;
    }

    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<Integer, Boolean> X00IoxXI() {
        return this.f21339oOoXoXO;
    }

    public final void XOxIOxOx(@OXOo.OOXIXo TextView textView) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(textView, "<set-?>");
        this.f21344xxIXOIIO = textView;
    }

    public final void XX(@OXOo.OOXIXo String value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        this.f21338oO = value;
        this.f21343xoIox.setText(value);
    }

    @OXOo.OOXIXo
    public final String Xx000oIo() {
        return this.f21338oO;
    }

    public final void o0(@OXOo.OOXIXo String value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        this.f21342x0xO0oo = value;
        this.f21337OOXIXo.setText(value);
    }

    @OXOo.OOXIXo
    public final String oOXoIIIo() {
        return this.f21342x0xO0oo;
    }

    @OXOo.OOXIXo
    public final TextView oo() {
        return this.f21337OOXIXo;
    }

    @OXOo.OOXIXo
    public final TextView oo0xXOI0I() {
        return this.f21344xxIXOIIO;
    }

    @OXOo.OOXIXo
    public final TextView ooXIXxIX() {
        return this.f21336II0XooXoX;
    }

    public final void oxxXoxO(@OXOo.OOXIXo String value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        this.f21341x0XOIxOo = value;
        this.f21344xxIXOIIO.setText(value);
    }

    public final void x0o(@OXOo.OOXIXo TextView textView) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(textView, "<set-?>");
        this.f21343xoIox = textView;
    }

    @OXOo.OOXIXo
    public final TextView xI() {
        return this.f21343xoIox;
    }

    public final void xII(@OXOo.OOXIXo TextView textView) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(textView, "<set-?>");
        this.f21336II0XooXoX = textView;
    }
}
