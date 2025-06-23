package com.sma.smartv3.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.text.MyTypeface;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import skin.support.widget.SkinCompatLinearLayout;

/* loaded from: classes12.dex */
public final class AbhSettingsItem extends SkinCompatLinearLayout {

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public View f24755IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f24756IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f24757Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final EditText f24758Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public final boolean f24759OxxIIOOXO;

    /* renamed from: o00, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f24760o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ImageView f24761oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public View f24762xoXoI;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public AbhSettingsItem(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    @OXOo.OOXIXo
    public final EditText getEdtValue() {
        return this.f24758Oxx0xo;
    }

    @OXOo.OOXIXo
    public final String getMLeftText() {
        return this.f24760o00;
    }

    @OXOo.OOXIXo
    public final String getMRightText() {
        if (this.f24759OxxIIOOXO) {
            return this.f24758Oxx0xo.getText().toString();
        }
        return this.f24756IXxxXO.getText().toString();
    }

    @OXOo.OOXIXo
    public final String getRightText() {
        if (this.f24759OxxIIOOXO) {
            return this.f24758Oxx0xo.getText().toString();
        }
        return this.f24756IXxxXO.getText().toString();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f24757Oo.setEnabled(z);
        this.f24756IXxxXO.setEnabled(z);
        this.f24758Oxx0xo.setEnabled(z);
        this.f24761oI0IIXIo.setEnabled(z);
    }

    public final void setMLeftText(@OXOo.OOXIXo String value) {
        IIX0o.x0xO0oo(value, "value");
        this.f24757Oo.setText(value);
    }

    public final void setMRightText(@OXOo.OOXIXo String value) {
        IIX0o.x0xO0oo(value, "value");
        if (this.f24759OxxIIOOXO) {
            this.f24758Oxx0xo.setText(value);
        } else {
            this.f24756IXxxXO.setText(value);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public AbhSettingsItem(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ AbhSettingsItem(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public AbhSettingsItem(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f24760o00 = "";
        LayoutInflater.from(context).inflate(R.layout.abh_settings_item_view, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.tv_label);
        IIX0o.oO(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        this.f24757Oo = textView;
        View findViewById2 = findViewById(R.id.tv_value);
        IIX0o.oO(findViewById2, "findViewById(...)");
        TextView textView2 = (TextView) findViewById2;
        this.f24756IXxxXO = textView2;
        View findViewById3 = findViewById(R.id.edt_value);
        IIX0o.oO(findViewById3, "findViewById(...)");
        EditText editText = (EditText) findViewById3;
        this.f24758Oxx0xo = editText;
        View findViewById4 = findViewById(R.id.iv_enter);
        IIX0o.oO(findViewById4, "findViewById(...)");
        this.f24761oI0IIXIo = (ImageView) findViewById4;
        this.f24755IIXOooo = findViewById(R.id.top_line);
        this.f24762xoXoI = findViewById(R.id.bottom_line);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.sma.smartv3.R.styleable.AbhSettingsItem);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        String string = obtainStyledAttributes.getString(2);
        string = string == null ? "" : string;
        String string2 = obtainStyledAttributes.getString(3);
        String str = string2 != null ? string2 : "";
        boolean z = obtainStyledAttributes.getBoolean(1, false);
        this.f24759OxxIIOOXO = z;
        View view = this.f24755IIXOooo;
        if (view != null) {
            view.setVisibility(obtainStyledAttributes.getBoolean(4, true) ? 0 : 8);
        }
        View view2 = this.f24762xoXoI;
        if (view2 != null) {
            view2.setVisibility(obtainStyledAttributes.getBoolean(0, true) ? 0 : 8);
        }
        textView.setText(string);
        if (z) {
            textView2.setVisibility(8);
            editText.setVisibility(0);
            editText.setTypeface(OOxOI.oIX0oI.f1804oIX0oI.oIX0oI(MyTypeface.PF_MEDIUM, context));
            editText.setText(str);
        } else {
            editText.setVisibility(8);
            textView2.setVisibility(0);
            textView2.setText(str);
        }
        obtainStyledAttributes.recycle();
    }
}
