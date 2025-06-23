package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.navisdk.embed.R;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class w extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    private final TextView f8902a;

    @OOXIXo
    private final TextView b;

    @OOXIXo
    private TextView c;

    @OOXIXo
    private ImageView d;
    private int e;

    /* loaded from: classes8.dex */
    public static final class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@oOoXoXO Animation animation) {
            w.this.getMPassTextView().setVisibility(8);
            w.this.getMNumTextView().setVisibility(0);
            w.this.getMNumImageView().setAlpha(1.0f);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@oOoXoXO Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@oOoXoXO Animation animation) {
            w.this.getMPassTextView().setVisibility(0);
            w.this.getMNumTextView().setVisibility(4);
        }
    }

    @xoIox
    public w(int i, @OOXIXo Context context) {
        this(i, context, null, 0, 12, null);
    }

    public final void a(int i, boolean z) {
        a(i, z, "已通过", 14.0f);
    }

    public final void b(int i, boolean z) {
        a(i, z, "剩余", 15.0f);
    }

    @OOXIXo
    public final TextView getMLabelTextView() {
        return this.b;
    }

    @OOXIXo
    public final ImageView getMNumImageView() {
        return this.d;
    }

    @OOXIXo
    public final TextView getMNumTextView() {
        return this.f8902a;
    }

    @OOXIXo
    public final TextView getMPassTextView() {
        return this.c;
    }

    public final void setMNumImageView(@OOXIXo ImageView imageView) {
        IIX0o.x0xO0oo(imageView, "<set-?>");
        this.d = imageView;
    }

    public final void setMPassTextView(@OOXIXo TextView textView) {
        IIX0o.x0xO0oo(textView, "<set-?>");
        this.c = textView;
    }

    public /* synthetic */ w(int i, Context context, AttributeSet attributeSet, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 1 : i, context, (i3 & 4) != 0 ? null : attributeSet, (i3 & 8) != 0 ? 0 : i2);
    }

    private final void a(int i, boolean z, String str, float f) {
        if (z) {
            a();
        } else {
            this.c.setVisibility(8);
            this.f8902a.setVisibility(0);
            this.d.setAlpha(1.0f);
        }
        this.f8902a.setText(str + TokenParser.SP + i + " 个");
        a(f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public w(int i, @OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        IIX0o.x0xO0oo(context, "context");
        this.e = i;
        if (i != 2) {
            LayoutInflater.from(context).inflate(R.layout.nsdk_layout_rg_smart_traffic_green_light_road, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(R.layout.nsdk_layout_green_light_panel_land, (ViewGroup) this, true);
        }
        View findViewById = findViewById(R.id.green_light_num);
        IIX0o.oO(findViewById, "findViewById(R.id.green_light_num)");
        this.f8902a = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.green_light_label);
        IIX0o.oO(findViewById2, "findViewById(R.id.green_light_label)");
        this.b = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.green_light_num_ok);
        IIX0o.oO(findViewById3, "findViewById(R.id.green_light_num_ok)");
        this.c = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.nsdk_num_light_icon);
        IIX0o.oO(findViewById4, "findViewById(R.id.nsdk_num_light_icon)");
        this.d = (ImageView) findViewById4;
    }

    private final void a(float f) {
        if (this.e == 2) {
            return;
        }
        this.f8902a.setTextSize(2, f);
    }

    private final void a() {
        this.d.clearAnimation();
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.code_table_bg_alpha);
        IIX0o.oO(loadAnimation, "AnimationUtils.loadAnima…anim.code_table_bg_alpha)");
        loadAnimation.setAnimationListener(new a());
        this.d.startAnimation(loadAnimation);
    }
}
