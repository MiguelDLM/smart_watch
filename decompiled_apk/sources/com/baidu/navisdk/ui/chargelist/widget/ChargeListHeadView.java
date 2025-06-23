package com.baidu.navisdk.ui.chargelist.widget;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.chargelist.d;
import com.baidu.navisdk.ui.chargelist.data.beans.e;
import com.baidu.navisdk.ui.widget.BNRelativeLayout;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class ChargeListHeadView extends BNRelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public ChargeListItemView f8399a;
    private ChargeListHeadLocation b;

    @xoIox
    public ChargeListHeadView(@OOXIXo Context context) {
        this(context, null, 0, 6, null);
    }

    private final boolean a(int i) {
        return i == 2;
    }

    private final boolean b(int i) {
        return i == 2;
    }

    private final void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.bnav_layout_charge_list_view_head, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.charge_list_head_location_container);
        IIX0o.oO(findViewById, "findViewById(R.id.charge…_head_location_container)");
        this.b = (ChargeListHeadLocation) findViewById;
        View findViewById2 = findViewById(R.id.charge_list_head_item);
        IIX0o.oO(findViewById2, "findViewById(R.id.charge_list_head_item)");
        this.f8399a = (ChargeListItemView) findViewById2;
    }

    @OOXIXo
    public final ChargeListItemView getChargeListItemView() {
        ChargeListItemView chargeListItemView = this.f8399a;
        if (chargeListItemView == null) {
            IIX0o.XOxIOxOx("chargeListItemView");
        }
        return chargeListItemView;
    }

    public final void setChargeListItemView(@OOXIXo ChargeListItemView chargeListItemView) {
        IIX0o.x0xO0oo(chargeListItemView, "<set-?>");
        this.f8399a = chargeListItemView;
    }

    @xoIox
    public ChargeListHeadView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public final void a(int i, @OOXIXo e stationWrapper) {
        IIX0o.x0xO0oo(stationWrapper, "stationWrapper");
        com.baidu.navisdk.ui.chargelist.e.f8376a.a(this, b(i), d.a(d.f8373a, 1, stationWrapper.a(), false, 4, null));
        ChargeListItemView chargeListItemView = this.f8399a;
        if (chargeListItemView == null) {
            IIX0o.XOxIOxOx("chargeListItemView");
        }
        chargeListItemView.a(i, stationWrapper);
        ChargeListHeadLocation chargeListHeadLocation = this.b;
        if (chargeListHeadLocation == null) {
            IIX0o.XOxIOxOx("listHeadLocationContainer");
        }
        chargeListHeadLocation.a(a(i), stationWrapper);
    }

    public /* synthetic */ ChargeListHeadView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public ChargeListHeadView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        initView();
    }
}
