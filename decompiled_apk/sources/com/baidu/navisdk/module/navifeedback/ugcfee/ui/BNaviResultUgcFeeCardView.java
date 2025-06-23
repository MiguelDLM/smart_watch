package com.baidu.navisdk.module.navifeedback.ugcfee.ui;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class BNaviResultUgcFeeCardView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private TextView f7206a;
    private TextView b;
    private TextView c;

    @xoIox
    public BNaviResultUgcFeeCardView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ BNaviResultUgcFeeCardView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? -1 : i);
    }

    @xoIox
    public BNaviResultUgcFeeCardView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setBackgroundResource(R.drawable.bnav_bg_ugc_fee_card);
        LayoutInflater.from(context).inflate(R.layout.bnav_ugc_fee_card_layout, (ViewGroup) this, true);
        this.f7206a = (TextView) findViewById(R.id.tv_title);
        this.b = (TextView) findViewById(R.id.tv_estimate_fee);
        this.c = (TextView) findViewById(R.id.tv_real_fee);
    }
}
