package com.baidu.navisdk.ui.chargelist.widget;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.chargelist.d;
import com.baidu.navisdk.ui.chargelist.data.beans.a;
import com.baidu.navisdk.ui.chargelist.data.beans.b;
import com.baidu.navisdk.ui.chargelist.data.beans.e;
import com.baidu.navisdk.ui.widget.BNRelativeLayout;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class ChargeListHeadLocation extends BNRelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f8398a;
    private TextView b;

    @xoIox
    public ChargeListHeadLocation(@OOXIXo Context context) {
        this(context, null, 0, 6, null);
    }

    private final void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.bnav_layout_charge_list_location_head, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.charge_list_head_location_img);
        IIX0o.oO(findViewById, "findViewById(R.id.charge_list_head_location_img)");
        this.f8398a = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.charge_list_head_info);
        IIX0o.oO(findViewById2, "findViewById(R.id.charge_list_head_info)");
        this.b = (TextView) findViewById2;
    }

    public final void a(boolean z, @OOXIXo b chargeWrapper) {
        IIX0o.x0xO0oo(chargeWrapper, "chargeWrapper");
        int i = 8;
        if (z) {
            setVisibility(8);
            return;
        }
        if (chargeWrapper instanceof e) {
            int d = chargeWrapper.d();
            if (d == 0 || d == 2 || d == 3) {
                TextView textView = this.b;
                if (textView == null) {
                    IIX0o.XOxIOxOx("headInfo");
                }
                textView.setText(((e) chargeWrapper).n());
                ImageView imageView = this.f8398a;
                if (imageView == null) {
                    IIX0o.XOxIOxOx("locationImg");
                }
                imageView.setBackgroundResource(d.f8373a.a(chargeWrapper.a()));
                setVisibility(0);
            }
            if (!TextUtils.isEmpty(((e) chargeWrapper).n())) {
                i = 0;
            }
            setVisibility(i);
            return;
        }
        if (chargeWrapper instanceof a) {
            TextView textView2 = this.b;
            if (textView2 == null) {
                IIX0o.XOxIOxOx("headInfo");
            }
            a aVar = (a) chargeWrapper;
            textView2.setText(aVar.i());
            ImageView imageView2 = this.f8398a;
            if (imageView2 == null) {
                IIX0o.XOxIOxOx("locationImg");
            }
            imageView2.setBackgroundResource(d.f8373a.a(chargeWrapper.a()));
            if (!TextUtils.isEmpty(aVar.i())) {
                i = 0;
            }
            setVisibility(i);
        }
    }

    @xoIox
    public ChargeListHeadLocation(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ChargeListHeadLocation(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public ChargeListHeadLocation(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        initView();
    }
}
