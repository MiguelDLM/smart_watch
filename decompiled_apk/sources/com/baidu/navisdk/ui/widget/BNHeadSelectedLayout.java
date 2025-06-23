package com.baidu.navisdk.ui.widget;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class BNHeadSelectedLayout extends BNLinearLayout {
    public TextView headFirstBtn;
    public TextView headSecondBtn;

    @xoIox
    public BNHeadSelectedLayout(@OOXIXo Context context) {
        this(context, null, 0, 6, null);
    }

    @OOXIXo
    public final TextView getHeadFirstBtn() {
        TextView textView = this.headFirstBtn;
        if (textView == null) {
            IIX0o.XOxIOxOx("headFirstBtn");
        }
        return textView;
    }

    @OOXIXo
    public final TextView getHeadSecondBtn() {
        TextView textView = this.headSecondBtn;
        if (textView == null) {
            IIX0o.XOxIOxOx("headSecondBtn");
        }
        return textView;
    }

    public final void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.bnav_layout_charge_head, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.charge_head_first_btn);
        IIX0o.oO(findViewById, "findViewById(R.id.charge_head_first_btn)");
        this.headFirstBtn = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.charge_head_second_btn);
        IIX0o.oO(findViewById2, "findViewById(R.id.charge_head_second_btn)");
        this.headSecondBtn = (TextView) findViewById2;
        setScaleX(1.2f);
        setScaleY(1.2f);
    }

    public final void setFirstBtnClickListener(@OOXIXo View.OnClickListener clickListener) {
        IIX0o.x0xO0oo(clickListener, "clickListener");
        TextView textView = this.headFirstBtn;
        if (textView == null) {
            IIX0o.XOxIOxOx("headFirstBtn");
        }
        textView.setOnClickListener(clickListener);
    }

    public final void setHeadFirstBtn(@OOXIXo TextView textView) {
        IIX0o.x0xO0oo(textView, "<set-?>");
        this.headFirstBtn = textView;
    }

    public final void setHeadSecondBtn(@OOXIXo TextView textView) {
        IIX0o.x0xO0oo(textView, "<set-?>");
        this.headSecondBtn = textView;
    }

    public final void setSecondBtnClickListener(@OOXIXo View.OnClickListener clickListener) {
        IIX0o.x0xO0oo(clickListener, "clickListener");
        TextView textView = this.headSecondBtn;
        if (textView == null) {
            IIX0o.XOxIOxOx("headSecondBtn");
        }
        textView.setOnClickListener(clickListener);
    }

    @xoIox
    public BNHeadSelectedLayout(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ BNHeadSelectedLayout(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public BNHeadSelectedLayout(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        initView();
    }
}
