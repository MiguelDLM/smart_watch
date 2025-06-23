package com.baidu.navisdk.ui.chargelist.widget;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.chargelist.d;
import com.baidu.navisdk.ui.chargelist.data.beans.a;
import com.baidu.navisdk.ui.chargelist.data.beans.b;
import com.baidu.navisdk.ui.chargelist.e;
import com.baidu.navisdk.ui.widget.BNRelativeLayout;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class ChargeListSingleView extends BNRelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public ChargeListItemView f8401a;
    private ChargeListHeadLocation b;
    private RelativeLayout c;
    private TextView d;

    @xoIox
    public ChargeListSingleView(@OOXIXo Context context) {
        this(context, null, 0, 6, null);
    }

    private final boolean a(int i) {
        return i == 2;
    }

    private final boolean b(int i) {
        return i == 2;
    }

    private final void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.bnav_layout_charge_list_single, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.charge_list_single_head_location_container);
        IIX0o.oO(findViewById, "findViewById(R.id.charge…_head_location_container)");
        this.b = (ChargeListHeadLocation) findViewById;
        View findViewById2 = findViewById(R.id.charge_list_single_item);
        IIX0o.oO(findViewById2, "findViewById(R.id.charge_list_single_item)");
        this.f8401a = (ChargeListItemView) findViewById2;
        View findViewById3 = findViewById(R.id.charge_list_bubble_container);
        IIX0o.oO(findViewById3, "findViewById(R.id.charge_list_bubble_container)");
        this.c = (RelativeLayout) findViewById3;
        View findViewById4 = findViewById(R.id.charge_list_other_des);
        IIX0o.oO(findViewById4, "findViewById(R.id.charge_list_other_des)");
        this.d = (TextView) findViewById4;
    }

    @OOXIXo
    public final ChargeListItemView getChargeListItemView() {
        ChargeListItemView chargeListItemView = this.f8401a;
        if (chargeListItemView == null) {
            IIX0o.XOxIOxOx("chargeListItemView");
        }
        return chargeListItemView;
    }

    public final void setChargeListItemView(@OOXIXo ChargeListItemView chargeListItemView) {
        IIX0o.x0xO0oo(chargeListItemView, "<set-?>");
        this.f8401a = chargeListItemView;
    }

    @xoIox
    public ChargeListSingleView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public final void a(int i, @OOXIXo b wrapper) {
        int a2;
        IIX0o.x0xO0oo(wrapper, "wrapper");
        int d = wrapper.d();
        int i2 = 0;
        if (d != 0) {
            if (d != 1) {
                if ((d == 2 || d == 3) && (wrapper instanceof a)) {
                    int a3 = wrapper.a();
                    a aVar = (a) wrapper;
                    if (aVar.h().size() > 0) {
                        TextView textView = this.d;
                        if (textView == null) {
                            IIX0o.XOxIOxOx("des");
                        }
                        textView.setText(aVar.h().get(0));
                    } else {
                        TextView textView2 = this.d;
                        if (textView2 == null) {
                            IIX0o.XOxIOxOx("des");
                        }
                        textView2.setText("");
                    }
                    e eVar = e.f8376a;
                    TextView textView3 = this.d;
                    if (textView3 == null) {
                        IIX0o.XOxIOxOx("des");
                    }
                    eVar.a(textView3, b(i), d.f8373a.c(d));
                    ChargeListItemView chargeListItemView = this.f8401a;
                    if (chargeListItemView == null) {
                        IIX0o.XOxIOxOx("chargeListItemView");
                    }
                    chargeListItemView.setVisibility(8);
                    RelativeLayout relativeLayout = this.c;
                    if (relativeLayout == null) {
                        IIX0o.XOxIOxOx("listBubbleContainer");
                    }
                    relativeLayout.setVisibility(0);
                    ChargeListHeadLocation chargeListHeadLocation = this.b;
                    if (chargeListHeadLocation == null) {
                        IIX0o.XOxIOxOx("listHeadLocationContainer");
                    }
                    chargeListHeadLocation.a(a(i), wrapper);
                    i2 = a3;
                }
            } else if (wrapper instanceof com.baidu.navisdk.ui.chargelist.data.beans.e) {
                a2 = wrapper.a();
                ChargeListItemView chargeListItemView2 = this.f8401a;
                if (chargeListItemView2 == null) {
                    IIX0o.XOxIOxOx("chargeListItemView");
                }
                chargeListItemView2.setVisibility(0);
                RelativeLayout relativeLayout2 = this.c;
                if (relativeLayout2 == null) {
                    IIX0o.XOxIOxOx("listBubbleContainer");
                }
                relativeLayout2.setVisibility(8);
                ChargeListHeadLocation chargeListHeadLocation2 = this.b;
                if (chargeListHeadLocation2 == null) {
                    IIX0o.XOxIOxOx("listHeadLocationContainer");
                }
                chargeListHeadLocation2.setVisibility(8);
                ChargeListItemView chargeListItemView3 = this.f8401a;
                if (chargeListItemView3 == null) {
                    IIX0o.XOxIOxOx("chargeListItemView");
                }
                chargeListItemView3.a(i, (com.baidu.navisdk.ui.chargelist.data.beans.e) wrapper);
                i2 = a2;
            }
        } else if (wrapper instanceof com.baidu.navisdk.ui.chargelist.data.beans.e) {
            a2 = wrapper.a();
            ChargeListItemView chargeListItemView4 = this.f8401a;
            if (chargeListItemView4 == null) {
                IIX0o.XOxIOxOx("chargeListItemView");
            }
            chargeListItemView4.setVisibility(0);
            RelativeLayout relativeLayout3 = this.c;
            if (relativeLayout3 == null) {
                IIX0o.XOxIOxOx("listBubbleContainer");
            }
            relativeLayout3.setVisibility(8);
            ChargeListHeadLocation chargeListHeadLocation3 = this.b;
            if (chargeListHeadLocation3 == null) {
                IIX0o.XOxIOxOx("listHeadLocationContainer");
            }
            chargeListHeadLocation3.a(a(i), wrapper);
            ChargeListItemView chargeListItemView5 = this.f8401a;
            if (chargeListItemView5 == null) {
                IIX0o.XOxIOxOx("chargeListItemView");
            }
            chargeListItemView5.a(i, (com.baidu.navisdk.ui.chargelist.data.beans.e) wrapper);
            i2 = a2;
        }
        e eVar2 = e.f8376a;
        eVar2.a(this, b(i), d.f8373a.b(i2, wrapper.d(), a(i)));
        RelativeLayout relativeLayout4 = this.c;
        if (relativeLayout4 == null) {
            IIX0o.XOxIOxOx("listBubbleContainer");
        }
        eVar2.a(relativeLayout4, b(i), R.drawable.bnav_energy_item_normal_radius_bg);
    }

    public /* synthetic */ ChargeListSingleView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public ChargeListSingleView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        initView();
    }
}
