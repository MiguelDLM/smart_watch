package com.baidu.navisdk.ui.widget;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class BNMoreInfoTextView extends LinearLayout {

    @OOXIXo
    private final View mLayout;

    @OOXIXo
    private final View mShadowView;

    @OOXIXo
    private final TextView mTextView;

    public BNMoreInfoTextView(@oOoXoXO Context context, @oOoXoXO AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(R.layout.nsdk_more_info_layout, this);
        IIX0o.oO(inflate, "LayoutInflater.from(cont…k_more_info_layout, this)");
        this.mLayout = inflate;
        View findViewById = inflate.findViewById(R.id.more_info_text);
        IIX0o.oO(findViewById, "mLayout.findViewById(R.id.more_info_text)");
        this.mTextView = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.more_info_shadow);
        IIX0o.oO(findViewById2, "mLayout.findViewById(R.id.more_info_shadow)");
        this.mShadowView = findViewById2;
    }

    @OOXIXo
    public final View getMLayout() {
        return this.mLayout;
    }

    @OOXIXo
    public final View getMShadowView() {
        return this.mShadowView;
    }

    @OOXIXo
    public final TextView getMTextView() {
        return this.mTextView;
    }

    public final void setClickListener(@OOXIXo View.OnClickListener listener) {
        IIX0o.x0xO0oo(listener, "listener");
        this.mLayout.setOnClickListener(listener);
    }

    public final void setShadow(@OOXIXo Drawable drawable) {
        IIX0o.x0xO0oo(drawable, "drawable");
        this.mShadowView.setBackground(drawable);
    }

    public final void setText(@OOXIXo String content) {
        IIX0o.x0xO0oo(content, "content");
        this.mTextView.setText(content);
    }

    public final void setTextBackground(@OOXIXo String colorString) {
        IIX0o.x0xO0oo(colorString, "colorString");
        this.mTextView.setBackgroundColor(Color.parseColor(colorString));
    }

    public final void setTextColor(@OOXIXo String colorString) {
        IIX0o.x0xO0oo(colorString, "colorString");
        this.mTextView.setTextColor(Color.parseColor(colorString));
    }

    public final void setTextSize(int i) {
        this.mTextView.setTextSize(i);
    }
}
