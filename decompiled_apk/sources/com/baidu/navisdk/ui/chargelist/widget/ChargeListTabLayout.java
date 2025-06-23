package com.baidu.navisdk.ui.chargelist.widget;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.imageloader.ImageLoader;
import com.baidu.navisdk.imageloader.config.ImageDiskCacheStrategy;
import com.baidu.navisdk.model.datastruct.chargestation.d;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.ui.widget.BNRelativeLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class ChargeListTabLayout extends BNRelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private RelativeLayout f8403a;
    private ImageView b;
    private TextView c;
    private TextView d;
    private TextView e;

    /* loaded from: classes8.dex */
    public static final class a extends CustomTarget<Drawable> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f8404a;

        public a(View view) {
            this.f8404a = view;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@oOoXoXO Drawable drawable) {
        }
    }

    @xoIox
    public ChargeListTabLayout(@OOXIXo Context context) {
        this(context, null, 0, 6, null);
    }

    private final String a(int i) {
        return i != 2 ? i != 3 ? "https://lbsnavi.cdn.bcebos.com/base/online/20211229113452/nsdk_ne_bottom_tip_green_bg.png" : "https://lbsnavi.cdn.bcebos.com/base/online/20211215102009/nsdk_ne_bottom_tip_bg_red.png" : "https://lbsnavi.cdn.bcebos.com/base/online/20211215102025/nsdk_ne_bottom_tip_bg_yellow.png";
    }

    public final void setContainerClickListener(@OOXIXo View.OnClickListener clickListener) {
        IIX0o.x0xO0oo(clickListener, "clickListener");
        RelativeLayout relativeLayout = this.f8403a;
        if (relativeLayout == null) {
            IIX0o.XOxIOxOx("mContainerLayout");
        }
        relativeLayout.setOnClickListener(clickListener);
    }

    @xoIox
    public ChargeListTabLayout(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bnav_layout_charge_list_tab, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.charge_list_tab_container);
        IIX0o.oO(findViewById, "findViewById(R.id.charge_list_tab_container)");
        this.f8403a = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R.id.charge_list_tab_battery);
        IIX0o.oO(findViewById2, "findViewById(R.id.charge_list_tab_battery)");
        this.b = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.charge_list_tab_info_title);
        IIX0o.oO(findViewById3, "findViewById(R.id.charge_list_tab_info_title)");
        this.c = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.charge_list_tab_info_des);
        IIX0o.oO(findViewById4, "findViewById(R.id.charge_list_tab_info_des)");
        this.d = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.charge_list_tab_more);
        IIX0o.oO(findViewById5, "findViewById(R.id.charge_list_tab_more)");
        this.e = (TextView) findViewById5;
    }

    public /* synthetic */ ChargeListTabLayout(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public ChargeListTabLayout(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        a(context);
    }

    public final void a(@OOXIXo d tipContentData, boolean z) {
        IIX0o.x0xO0oo(tipContentData, "tipContentData");
        RelativeLayout relativeLayout = this.f8403a;
        if (relativeLayout == null) {
            IIX0o.XOxIOxOx("mContainerLayout");
        }
        a(relativeLayout, a(tipContentData.g()));
        ImageView imageView = this.b;
        if (imageView == null) {
            IIX0o.XOxIOxOx("mBatteryImg");
        }
        a(imageView, a(tipContentData.g(), tipContentData.f()));
        TextView textView = this.c;
        if (textView == null) {
            IIX0o.XOxIOxOx("mChargeInfoTitle");
        }
        textView.setText(Html.fromHtml(tipContentData.a()));
        TextView textView2 = this.d;
        if (textView2 == null) {
            IIX0o.XOxIOxOx("mChargeInfoDes");
        }
        textView2.setText(Html.fromHtml(tipContentData.h()));
        TextView textView3 = this.e;
        if (textView3 == null) {
            IIX0o.XOxIOxOx("mChargeInfoMore");
        }
        textView3.setVisibility(z ? 8 : 0);
    }

    private final void a(View view, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        Glide.with(getContext()).load(str).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into((RequestBuilder) new a(view));
    }

    private final void a(ImageView imageView, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        ImageLoader.with(getContext()).load(str).diskCacheStrategy(ImageDiskCacheStrategy.SOURCE).into(imageView);
    }

    private final String a(int i, int i2) {
        return f.c().S.a(i2).a(i);
    }
}
