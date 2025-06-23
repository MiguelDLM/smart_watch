package com.baidu.navisdk.ui.chargelist.widget;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.BNLinearLayout;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class ChargeListStationLayout extends BNLinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public TextView f8402a;
    public ImageView b;

    @xoIox
    public ChargeListStationLayout(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    @OOXIXo
    public final ImageView getStationImg() {
        ImageView imageView = this.b;
        if (imageView == null) {
            IIX0o.XOxIOxOx("stationImg");
        }
        return imageView;
    }

    @OOXIXo
    public final TextView getStationInfo() {
        TextView textView = this.f8402a;
        if (textView == null) {
            IIX0o.XOxIOxOx("stationInfo");
        }
        return textView;
    }

    public final void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.bnav_layout_charge_station_layout, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.charge_list_station_info);
        IIX0o.oO(findViewById, "findViewById(R.id.charge_list_station_info)");
        this.f8402a = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.charge_list_station_img);
        IIX0o.oO(findViewById2, "findViewById(R.id.charge_list_station_img)");
        this.b = (ImageView) findViewById2;
    }

    public final void setStationImg(@OOXIXo ImageView imageView) {
        IIX0o.x0xO0oo(imageView, "<set-?>");
        this.b = imageView;
    }

    public final void setStationInfo(@OOXIXo TextView textView) {
        IIX0o.x0xO0oo(textView, "<set-?>");
        this.f8402a = textView;
    }

    public /* synthetic */ ChargeListStationLayout(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public ChargeListStationLayout(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        initView();
    }
}
