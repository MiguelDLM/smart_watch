package com.sma.smartv3.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.sma.smartv3.co_fit.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import skin.support.widget.SkinCompatLinearLayout;

@XX({"SMAP\nAbhSettingsHeader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbhSettingsHeader.kt\ncom/sma/smartv3/view/AbhSettingsHeader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,70:1\n1#2:71\n*E\n"})
/* loaded from: classes12.dex */
public final class AbhSettingsHeader extends SkinCompatLinearLayout {

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.oOoXoXO<? super Boolean, oXIO0o0XI> f24748IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f24749IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f24750Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final CheckBox f24751Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f24752OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f24753oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f24754xoXoI;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public AbhSettingsHeader(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public static final void II0xO0(AbhSettingsHeader this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.setChecked(!this$0.f24752OxxIIOOXO);
    }

    public final boolean I0Io() {
        return this.f24752OxxIIOOXO;
    }

    @OXOo.OOXIXo
    public final CheckBox getCheckEnabled() {
        return this.f24751Oxx0xo;
    }

    @OXOo.OOXIXo
    public final String getMDescription() {
        return this.f24754xoXoI;
    }

    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<Boolean, oXIO0o0XI> getMListener() {
        return this.f24748IIXOooo;
    }

    @OXOo.OOXIXo
    public final TextView getTvTitle() {
        return this.f24750Oo;
    }

    public final void setChecked(boolean z) {
        this.f24752OxxIIOOXO = z;
        this.f24750Oo.setEnabled(z);
        this.f24751Oxx0xo.setChecked(z);
        ViewParent parent = getParent();
        IIX0o.x0XOIxOo(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        for (View view : ViewGroupKt.getChildren((ViewGroup) parent)) {
            if (view instanceof AbhSettingsItem) {
                ((AbhSettingsItem) view).setEnabled(z);
            }
        }
        if (this.f24753oI0IIXIo) {
            return;
        }
        this.f24753oI0IIXIo = true;
        Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo = this.f24748IIXOooo;
        if (oooxoxo != null) {
            oooxoxo.invoke(Boolean.valueOf(this.f24752OxxIIOOXO));
        }
        this.f24753oI0IIXIo = false;
    }

    public final void setMDescription(@OXOo.OOXIXo String value) {
        IIX0o.x0xO0oo(value, "value");
        this.f24754xoXoI = value;
        this.f24749IXxxXO.setText(value);
    }

    public final void setMListener(@OXOo.oOoXoXO Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        this.f24748IIXOooo = oooxoxo;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public AbhSettingsHeader(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ AbhSettingsHeader(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public AbhSettingsHeader(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f24752OxxIIOOXO = true;
        this.f24754xoXoI = "";
        LayoutInflater.from(context).inflate(R.layout.abh_settings_header, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.sma.smartv3.R.styleable.AbhSettingsHeader);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        String string = obtainStyledAttributes.getString(1);
        string = string == null ? "" : string;
        String string2 = obtainStyledAttributes.getString(0);
        String str = string2 != null ? string2 : "";
        View findViewById = findViewById(R.id.tv_title);
        TextView textView = (TextView) findViewById;
        textView.setText(string);
        IIX0o.oO(findViewById, "apply(...)");
        this.f24750Oo = textView;
        View findViewById2 = findViewById(R.id.tv_description);
        TextView textView2 = (TextView) findViewById2;
        textView2.setText(str);
        textView2.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        IIX0o.oO(findViewById2, "apply(...)");
        this.f24749IXxxXO = textView2;
        View findViewById3 = findViewById(R.id.check_enabled);
        IIX0o.oO(findViewById3, "findViewById(...)");
        this.f24751Oxx0xo = (CheckBox) findViewById3;
        obtainStyledAttributes.recycle();
        setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.view.oIX0oI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AbhSettingsHeader.II0xO0(AbhSettingsHeader.this, view);
            }
        });
    }
}
