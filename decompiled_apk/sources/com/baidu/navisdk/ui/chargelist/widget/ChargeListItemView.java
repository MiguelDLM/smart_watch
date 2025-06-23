package com.baidu.navisdk.ui.chargelist.widget;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.chargelist.d;
import com.baidu.navisdk.ui.chargelist.data.beans.e;
import com.baidu.navisdk.ui.widget.BNFlowLayout;
import com.baidu.navisdk.ui.widget.BNRelativeLayout;
import com.baidu.navisdk.util.common.ScreenUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class ChargeListItemView extends BNRelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private int f8400a;
    public RelativeLayout b;
    public RelativeLayout c;
    public LinearLayout d;
    public TextView e;
    public ImageView f;
    public BNFlowLayout g;
    public BNFlowLayout h;
    public BNFlowLayout i;
    public TextView j;
    public TextView k;
    public View l;

    @xoIox
    public ChargeListItemView(@OOXIXo Context context) {
        this(context, null, 0, 6, null);
    }

    private final boolean c() {
        if (this.f8400a == 2) {
            return true;
        }
        return false;
    }

    private final void d(e eVar) {
        LinearLayout linearLayout = this.d;
        if (linearLayout == null) {
            IIX0o.XOxIOxOx("listStationContainer");
        }
        linearLayout.removeAllViews();
        if (!TextUtils.isEmpty(eVar.l())) {
            Context context = getContext();
            IIX0o.oO(context, "context");
            ChargeListStationLayout chargeListStationLayout = new ChargeListStationLayout(context, null, 0, 6, null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMarginEnd(ScreenUtil.getInstance().dip2px(4));
            chargeListStationLayout.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bnav_charge_station_fast_bg));
            chargeListStationLayout.getStationInfo().setText(eVar.l());
            chargeListStationLayout.getStationInfo().setTextColor(Color.parseColor("#FFFF7040"));
            chargeListStationLayout.getStationImg().setBackground(ContextCompat.getDrawable(getContext(), R.drawable.nsdk_energy_charge_fast));
            chargeListStationLayout.setLayoutParams(layoutParams);
            LinearLayout linearLayout2 = this.d;
            if (linearLayout2 == null) {
                IIX0o.XOxIOxOx("listStationContainer");
            }
            linearLayout2.addView(chargeListStationLayout);
        }
        if (!TextUtils.isEmpty(eVar.r())) {
            Context context2 = getContext();
            IIX0o.oO(context2, "context");
            ChargeListStationLayout chargeListStationLayout2 = new ChargeListStationLayout(context2, null, 0, 6, null);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMarginEnd(ScreenUtil.getInstance().dip2px(4));
            chargeListStationLayout2.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bnav_charge_station_slow_bg));
            chargeListStationLayout2.getStationInfo().setText(eVar.r());
            chargeListStationLayout2.getStationInfo().setTextColor(Color.parseColor("#FF1FCCA1"));
            chargeListStationLayout2.getStationImg().setBackground(ContextCompat.getDrawable(getContext(), R.drawable.nsdk_energy_charge_slow));
            chargeListStationLayout2.setLayoutParams(layoutParams2);
            LinearLayout linearLayout3 = this.d;
            if (linearLayout3 == null) {
                IIX0o.XOxIOxOx("listStationContainer");
            }
            linearLayout3.addView(chargeListStationLayout2);
        }
        int i = 8;
        if (!TextUtils.isEmpty(eVar.i())) {
            Context context3 = getContext();
            IIX0o.oO(context3, "context");
            ChargeListStationLayout chargeListStationLayout3 = new ChargeListStationLayout(context3, null, 0, 6, null);
            chargeListStationLayout3.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bnav_charge_station_watts_bg));
            chargeListStationLayout3.getStationInfo().setText(eVar.i());
            chargeListStationLayout3.getStationInfo().setTextColor(Color.parseColor("#FF878D99"));
            chargeListStationLayout3.getStationImg().setVisibility(8);
            LinearLayout linearLayout4 = this.d;
            if (linearLayout4 == null) {
                IIX0o.XOxIOxOx("listStationContainer");
            }
            linearLayout4.addView(chargeListStationLayout3);
        }
        LinearLayout linearLayout5 = this.d;
        if (linearLayout5 == null) {
            IIX0o.XOxIOxOx("listStationContainer");
        }
        LinearLayout linearLayout6 = this.d;
        if (linearLayout6 == null) {
            IIX0o.XOxIOxOx("listStationContainer");
        }
        if (linearLayout6.getChildCount() > 0) {
            i = 0;
        }
        linearLayout5.setVisibility(i);
    }

    private final void e(e eVar) {
        int i;
        int e = eVar.e();
        if (e != 0) {
            if (e != 1) {
                if (e != 2) {
                    if (e != 3) {
                        i = R.drawable.bnav_energy_item_normal_bg;
                    } else {
                        i = R.drawable.bnav_energy_item_bottom_radius_bg;
                    }
                } else {
                    i = R.drawable.bnav_energy_item_normal_bg;
                }
            } else {
                i = R.drawable.bnav_energy_item_top_radius_bg;
            }
        } else {
            i = R.drawable.bnav_energy_item_normal_radius_bg;
        }
        com.baidu.navisdk.ui.chargelist.e eVar2 = com.baidu.navisdk.ui.chargelist.e.f8376a;
        RelativeLayout relativeLayout = this.b;
        if (relativeLayout == null) {
            IIX0o.XOxIOxOx("chargeListItemContainer");
        }
        boolean c = c();
        if (eVar.g()) {
            i = d.f8373a.b(eVar.a());
        }
        eVar2.a(relativeLayout, c, i);
    }

    private final void f(e eVar) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(eVar.h())) {
            arrayList.add(eVar.h());
        }
        if (!TextUtils.isEmpty(eVar.q())) {
            arrayList.add(eVar.q());
        }
        if (arrayList.size() > 0) {
            BNFlowLayout bNFlowLayout = this.h;
            if (bNFlowLayout == null) {
                IIX0o.XOxIOxOx("chargeListInfoCost");
            }
            bNFlowLayout.setVisibility(0);
            BNFlowLayout bNFlowLayout2 = this.h;
            if (bNFlowLayout2 == null) {
                IIX0o.XOxIOxOx("chargeListInfoCost");
            }
            bNFlowLayout2.removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(getContext());
                textView.setText((CharSequence) arrayList.get(i));
                textView.setGravity(17);
                textView.setIncludeFontPadding(false);
                textView.setTextSize(1, 11.0f);
                com.baidu.navisdk.ui.chargelist.e.f8376a.a(textView, c(), R.color.bnav_charge_list_info_cost_color);
                BNFlowLayout bNFlowLayout3 = this.h;
                if (bNFlowLayout3 == null) {
                    IIX0o.XOxIOxOx("chargeListInfoCost");
                }
                bNFlowLayout3.addView(textView, layoutParams);
                if (i != arrayList.size() - 1) {
                    View view = new View(getContext());
                    view.setBackgroundColor(Color.parseColor("#FF7A8199"));
                    view.setTag(R.id.id_flow_layout_split_line, BNFlowLayout.SPLIT_LINE);
                    int dip2px = ScreenUtil.getInstance().dip2px(4);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ScreenUtil.getInstance().dip2px(1), ScreenUtil.getInstance().dip2px(10));
                    layoutParams2.setMargins(dip2px, ScreenUtil.getInstance().dip2px(1), dip2px, 0);
                    BNFlowLayout bNFlowLayout4 = this.h;
                    if (bNFlowLayout4 == null) {
                        IIX0o.XOxIOxOx("chargeListInfoCost");
                    }
                    bNFlowLayout4.addView(view, layoutParams2);
                }
            }
            return;
        }
        BNFlowLayout bNFlowLayout5 = this.h;
        if (bNFlowLayout5 == null) {
            IIX0o.XOxIOxOx("chargeListInfoCost");
        }
        bNFlowLayout5.setVisibility(8);
    }

    private final void g(e eVar) {
        if (eVar.o().size() > 0) {
            BNFlowLayout bNFlowLayout = this.i;
            if (bNFlowLayout == null) {
                IIX0o.XOxIOxOx("chargeListInfoDes");
            }
            bNFlowLayout.setVisibility(0);
            BNFlowLayout bNFlowLayout2 = this.i;
            if (bNFlowLayout2 == null) {
                IIX0o.XOxIOxOx("chargeListInfoDes");
            }
            bNFlowLayout2.removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, ScreenUtil.getInstance().dip2px(4), 0);
            int size = eVar.o().size();
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(getContext());
                textView.setText(eVar.o().get(i).b());
                textView.setGravity(17);
                textView.setPadding(ScreenUtil.getInstance().dip2px(4), 0, ScreenUtil.getInstance().dip2px(4), 0);
                if (eVar.o().get(i).a() == 1) {
                    textView.setTextAppearance(getContext(), R.style.BNCommonNeHighlightLabel);
                    com.baidu.navisdk.ui.chargelist.e.f8376a.a((View) textView, c(), R.drawable.bnav_charge_highlight_bg);
                } else {
                    textView.setTextAppearance(getContext(), R.style.BNCommonNeNormalLabel);
                    com.baidu.navisdk.ui.chargelist.e.f8376a.a((View) textView, c(), R.drawable.bnav_charge_normal_bg);
                }
                BNFlowLayout bNFlowLayout3 = this.i;
                if (bNFlowLayout3 == null) {
                    IIX0o.XOxIOxOx("chargeListInfoDes");
                }
                bNFlowLayout3.addView(textView, layoutParams);
                BNFlowLayout bNFlowLayout4 = this.i;
                if (bNFlowLayout4 == null) {
                    IIX0o.XOxIOxOx("chargeListInfoDes");
                }
                bNFlowLayout4.setVisibility(0);
            }
            return;
        }
        BNFlowLayout bNFlowLayout5 = this.i;
        if (bNFlowLayout5 == null) {
            IIX0o.XOxIOxOx("chargeListInfoDes");
        }
        bNFlowLayout5.setVisibility(8);
    }

    private final int getStationContainerVisible() {
        LinearLayout linearLayout = this.d;
        if (linearLayout == null) {
            IIX0o.XOxIOxOx("listStationContainer");
        }
        if (linearLayout.getChildCount() > 0) {
            return 0;
        }
        BNFlowLayout bNFlowLayout = this.h;
        if (bNFlowLayout == null) {
            IIX0o.XOxIOxOx("chargeListInfoCost");
        }
        if (bNFlowLayout.getChildCount() == 0) {
            BNFlowLayout bNFlowLayout2 = this.i;
            if (bNFlowLayout2 == null) {
                IIX0o.XOxIOxOx("chargeListInfoDes");
            }
            if (bNFlowLayout2.getChildCount() == 0) {
                return 4;
            }
        }
        return 8;
    }

    private final void h(e eVar) {
        if (eVar.k().size() > 0) {
            Iterator<String> it = eVar.k().iterator();
            while (it.hasNext()) {
                it.next();
                BNFlowLayout bNFlowLayout = this.g;
                if (bNFlowLayout == null) {
                    IIX0o.XOxIOxOx("chargeListInfoDetail");
                }
                bNFlowLayout.setVisibility(0);
                BNFlowLayout bNFlowLayout2 = this.g;
                if (bNFlowLayout2 == null) {
                    IIX0o.XOxIOxOx("chargeListInfoDetail");
                }
                bNFlowLayout2.removeAllViews();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                int size = eVar.k().size();
                for (int i = 0; i < size; i++) {
                    TextView textView = new TextView(getContext());
                    textView.setText(eVar.k().get(i));
                    textView.setGravity(17);
                    textView.setIncludeFontPadding(false);
                    textView.setTextSize(1, 12.0f);
                    com.baidu.navisdk.ui.chargelist.e.f8376a.a(textView, c(), R.color.bnav_charge_list_info_detail_color);
                    BNFlowLayout bNFlowLayout3 = this.g;
                    if (bNFlowLayout3 == null) {
                        IIX0o.XOxIOxOx("chargeListInfoDetail");
                    }
                    bNFlowLayout3.addView(textView, layoutParams);
                    if (i != eVar.k().size() - 1) {
                        View view = new View(getContext());
                        view.setBackgroundColor(Color.parseColor("#FF7A8199"));
                        view.setTag(R.id.id_flow_layout_split_line, BNFlowLayout.SPLIT_LINE);
                        int dip2px = ScreenUtil.getInstance().dip2px(4);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ScreenUtil.getInstance().dip2px(1), ScreenUtil.getInstance().dip2px(10));
                        layoutParams2.setMargins(dip2px, ScreenUtil.getInstance().dip2px(2), dip2px, 0);
                        BNFlowLayout bNFlowLayout4 = this.g;
                        if (bNFlowLayout4 == null) {
                            IIX0o.XOxIOxOx("chargeListInfoDetail");
                        }
                        bNFlowLayout4.addView(view, layoutParams2);
                    }
                }
            }
            return;
        }
        BNFlowLayout bNFlowLayout5 = this.g;
        if (bNFlowLayout5 == null) {
            IIX0o.XOxIOxOx("chargeListInfoDetail");
        }
        bNFlowLayout5.setVisibility(8);
    }

    private final void i(e eVar) {
        com.baidu.navisdk.ui.chargelist.e eVar2 = com.baidu.navisdk.ui.chargelist.e.f8376a;
        TextView textView = this.e;
        if (textView == null) {
            IIX0o.XOxIOxOx("chargeListInfoLocation");
        }
        eVar2.a(textView, c(), R.color.bnav_charge_list_info_location_color);
        TextView textView2 = this.e;
        if (textView2 == null) {
            IIX0o.XOxIOxOx("chargeListInfoLocation");
        }
        textView2.setText(eVar.p());
    }

    private final void j(e eVar) {
        int i;
        int i2;
        int i3;
        int i4;
        if (eVar.g()) {
            View view = this.l;
            if (view == null) {
                IIX0o.XOxIOxOx("chargeListDivider");
            }
            view.setVisibility(8);
            BNFlowLayout bNFlowLayout = this.g;
            if (bNFlowLayout == null) {
                IIX0o.XOxIOxOx("chargeListInfoDetail");
            }
            bNFlowLayout.setVisibility(0);
            LinearLayout linearLayout = this.d;
            if (linearLayout == null) {
                IIX0o.XOxIOxOx("listStationContainer");
            }
            linearLayout.setVisibility(getStationContainerVisible());
            BNFlowLayout bNFlowLayout2 = this.h;
            if (bNFlowLayout2 == null) {
                IIX0o.XOxIOxOx("chargeListInfoCost");
            }
            BNFlowLayout bNFlowLayout3 = this.h;
            if (bNFlowLayout3 == null) {
                IIX0o.XOxIOxOx("chargeListInfoCost");
            }
            if (bNFlowLayout3.getChildCount() > 0) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            bNFlowLayout2.setVisibility(i3);
            BNFlowLayout bNFlowLayout4 = this.i;
            if (bNFlowLayout4 == null) {
                IIX0o.XOxIOxOx("chargeListInfoDes");
            }
            BNFlowLayout bNFlowLayout5 = this.i;
            if (bNFlowLayout5 == null) {
                IIX0o.XOxIOxOx("chargeListInfoDes");
            }
            if (bNFlowLayout5.getChildCount() > 0) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            bNFlowLayout4.setVisibility(i4);
            if (a()) {
                TextView textView = this.j;
                if (textView == null) {
                    IIX0o.XOxIOxOx("chargeListGoRouteResult");
                }
                textView.setVisibility(8);
                ImageView imageView = this.f;
                if (imageView == null) {
                    IIX0o.XOxIOxOx("chargeListAddApproachImg");
                }
                imageView.setVisibility(8);
                RelativeLayout relativeLayout = this.c;
                if (relativeLayout == null) {
                    IIX0o.XOxIOxOx("chargeListNaviAddNodeContainer");
                }
                relativeLayout.setVisibility(0);
            } else {
                TextView textView2 = this.j;
                if (textView2 == null) {
                    IIX0o.XOxIOxOx("chargeListGoRouteResult");
                }
                textView2.setVisibility(0);
                ImageView imageView2 = this.f;
                if (imageView2 == null) {
                    IIX0o.XOxIOxOx("chargeListAddApproachImg");
                }
                imageView2.setVisibility(0);
                RelativeLayout relativeLayout2 = this.c;
                if (relativeLayout2 == null) {
                    IIX0o.XOxIOxOx("chargeListNaviAddNodeContainer");
                }
                relativeLayout2.setVisibility(8);
            }
        } else {
            int e = eVar.e();
            if (e != 0) {
                if (e != 1) {
                    if (e != 2) {
                        if (e == 3) {
                            View view2 = this.l;
                            if (view2 == null) {
                                IIX0o.XOxIOxOx("chargeListDivider");
                            }
                            view2.setVisibility(0);
                            BNFlowLayout bNFlowLayout6 = this.g;
                            if (bNFlowLayout6 == null) {
                                IIX0o.XOxIOxOx("chargeListInfoDetail");
                            }
                            bNFlowLayout6.setVisibility(0);
                            LinearLayout linearLayout2 = this.d;
                            if (linearLayout2 == null) {
                                IIX0o.XOxIOxOx("listStationContainer");
                            }
                            linearLayout2.setVisibility(8);
                            BNFlowLayout bNFlowLayout7 = this.h;
                            if (bNFlowLayout7 == null) {
                                IIX0o.XOxIOxOx("chargeListInfoCost");
                            }
                            bNFlowLayout7.setVisibility(8);
                            BNFlowLayout bNFlowLayout8 = this.i;
                            if (bNFlowLayout8 == null) {
                                IIX0o.XOxIOxOx("chargeListInfoDes");
                            }
                            bNFlowLayout8.setVisibility(8);
                            TextView textView3 = this.j;
                            if (textView3 == null) {
                                IIX0o.XOxIOxOx("chargeListGoRouteResult");
                            }
                            textView3.setVisibility(8);
                            if (a()) {
                                ImageView imageView3 = this.f;
                                if (imageView3 == null) {
                                    IIX0o.XOxIOxOx("chargeListAddApproachImg");
                                }
                                imageView3.setVisibility(8);
                                RelativeLayout relativeLayout3 = this.c;
                                if (relativeLayout3 == null) {
                                    IIX0o.XOxIOxOx("chargeListNaviAddNodeContainer");
                                }
                                relativeLayout3.setVisibility(0);
                            } else {
                                ImageView imageView4 = this.f;
                                if (imageView4 == null) {
                                    IIX0o.XOxIOxOx("chargeListAddApproachImg");
                                }
                                imageView4.setVisibility(0);
                                RelativeLayout relativeLayout4 = this.c;
                                if (relativeLayout4 == null) {
                                    IIX0o.XOxIOxOx("chargeListNaviAddNodeContainer");
                                }
                                relativeLayout4.setVisibility(8);
                            }
                        }
                    } else {
                        View view3 = this.l;
                        if (view3 == null) {
                            IIX0o.XOxIOxOx("chargeListDivider");
                        }
                        view3.setVisibility(0);
                        BNFlowLayout bNFlowLayout9 = this.g;
                        if (bNFlowLayout9 == null) {
                            IIX0o.XOxIOxOx("chargeListInfoDetail");
                        }
                        bNFlowLayout9.setVisibility(0);
                        LinearLayout linearLayout3 = this.d;
                        if (linearLayout3 == null) {
                            IIX0o.XOxIOxOx("listStationContainer");
                        }
                        linearLayout3.setVisibility(8);
                        BNFlowLayout bNFlowLayout10 = this.h;
                        if (bNFlowLayout10 == null) {
                            IIX0o.XOxIOxOx("chargeListInfoCost");
                        }
                        bNFlowLayout10.setVisibility(8);
                        BNFlowLayout bNFlowLayout11 = this.i;
                        if (bNFlowLayout11 == null) {
                            IIX0o.XOxIOxOx("chargeListInfoDes");
                        }
                        bNFlowLayout11.setVisibility(8);
                        TextView textView4 = this.j;
                        if (textView4 == null) {
                            IIX0o.XOxIOxOx("chargeListGoRouteResult");
                        }
                        textView4.setVisibility(8);
                        if (a()) {
                            ImageView imageView5 = this.f;
                            if (imageView5 == null) {
                                IIX0o.XOxIOxOx("chargeListAddApproachImg");
                            }
                            imageView5.setVisibility(8);
                            RelativeLayout relativeLayout5 = this.c;
                            if (relativeLayout5 == null) {
                                IIX0o.XOxIOxOx("chargeListNaviAddNodeContainer");
                            }
                            relativeLayout5.setVisibility(0);
                        } else {
                            ImageView imageView6 = this.f;
                            if (imageView6 == null) {
                                IIX0o.XOxIOxOx("chargeListAddApproachImg");
                            }
                            imageView6.setVisibility(0);
                            RelativeLayout relativeLayout6 = this.c;
                            if (relativeLayout6 == null) {
                                IIX0o.XOxIOxOx("chargeListNaviAddNodeContainer");
                            }
                            relativeLayout6.setVisibility(8);
                        }
                    }
                } else {
                    View view4 = this.l;
                    if (view4 == null) {
                        IIX0o.XOxIOxOx("chargeListDivider");
                    }
                    view4.setVisibility(0);
                    BNFlowLayout bNFlowLayout12 = this.g;
                    if (bNFlowLayout12 == null) {
                        IIX0o.XOxIOxOx("chargeListInfoDetail");
                    }
                    bNFlowLayout12.setVisibility(0);
                    LinearLayout linearLayout4 = this.d;
                    if (linearLayout4 == null) {
                        IIX0o.XOxIOxOx("listStationContainer");
                    }
                    linearLayout4.setVisibility(0);
                    BNFlowLayout bNFlowLayout13 = this.h;
                    if (bNFlowLayout13 == null) {
                        IIX0o.XOxIOxOx("chargeListInfoCost");
                    }
                    bNFlowLayout13.setVisibility(8);
                    BNFlowLayout bNFlowLayout14 = this.i;
                    if (bNFlowLayout14 == null) {
                        IIX0o.XOxIOxOx("chargeListInfoDes");
                    }
                    bNFlowLayout14.setVisibility(8);
                    if (a()) {
                        TextView textView5 = this.j;
                        if (textView5 == null) {
                            IIX0o.XOxIOxOx("chargeListGoRouteResult");
                        }
                        textView5.setVisibility(8);
                        ImageView imageView7 = this.f;
                        if (imageView7 == null) {
                            IIX0o.XOxIOxOx("chargeListAddApproachImg");
                        }
                        imageView7.setVisibility(8);
                        RelativeLayout relativeLayout7 = this.c;
                        if (relativeLayout7 == null) {
                            IIX0o.XOxIOxOx("chargeListNaviAddNodeContainer");
                        }
                        relativeLayout7.setVisibility(0);
                    } else {
                        TextView textView6 = this.j;
                        if (textView6 == null) {
                            IIX0o.XOxIOxOx("chargeListGoRouteResult");
                        }
                        textView6.setVisibility(0);
                        ImageView imageView8 = this.f;
                        if (imageView8 == null) {
                            IIX0o.XOxIOxOx("chargeListAddApproachImg");
                        }
                        imageView8.setVisibility(0);
                        RelativeLayout relativeLayout8 = this.c;
                        if (relativeLayout8 == null) {
                            IIX0o.XOxIOxOx("chargeListNaviAddNodeContainer");
                        }
                        relativeLayout8.setVisibility(8);
                    }
                }
            } else {
                View view5 = this.l;
                if (view5 == null) {
                    IIX0o.XOxIOxOx("chargeListDivider");
                }
                view5.setVisibility(8);
                BNFlowLayout bNFlowLayout15 = this.g;
                if (bNFlowLayout15 == null) {
                    IIX0o.XOxIOxOx("chargeListInfoDetail");
                }
                bNFlowLayout15.setVisibility(0);
                BNFlowLayout bNFlowLayout16 = this.h;
                if (bNFlowLayout16 == null) {
                    IIX0o.XOxIOxOx("chargeListInfoCost");
                }
                bNFlowLayout16.setVisibility(8);
                BNFlowLayout bNFlowLayout17 = this.i;
                if (bNFlowLayout17 == null) {
                    IIX0o.XOxIOxOx("chargeListInfoDes");
                }
                bNFlowLayout17.setVisibility(8);
                TextView textView7 = this.j;
                if (textView7 == null) {
                    IIX0o.XOxIOxOx("chargeListGoRouteResult");
                }
                textView7.setVisibility(8);
                if (eVar.d() == 1) {
                    LinearLayout linearLayout5 = this.d;
                    if (linearLayout5 == null) {
                        IIX0o.XOxIOxOx("listStationContainer");
                    }
                    linearLayout5.setVisibility(8);
                } else {
                    LinearLayout linearLayout6 = this.d;
                    if (linearLayout6 == null) {
                        IIX0o.XOxIOxOx("listStationContainer");
                    }
                    LinearLayout linearLayout7 = this.d;
                    if (linearLayout7 == null) {
                        IIX0o.XOxIOxOx("listStationContainer");
                    }
                    if (linearLayout7.getChildCount() > 0) {
                        i = 0;
                    } else {
                        i = 4;
                    }
                    linearLayout6.setVisibility(i);
                }
                if (a()) {
                    ImageView imageView9 = this.f;
                    if (imageView9 == null) {
                        IIX0o.XOxIOxOx("chargeListAddApproachImg");
                    }
                    imageView9.setVisibility(8);
                    RelativeLayout relativeLayout9 = this.c;
                    if (relativeLayout9 == null) {
                        IIX0o.XOxIOxOx("chargeListNaviAddNodeContainer");
                    }
                    relativeLayout9.setVisibility(0);
                } else {
                    ImageView imageView10 = this.f;
                    if (imageView10 == null) {
                        IIX0o.XOxIOxOx("chargeListAddApproachImg");
                    }
                    imageView10.setVisibility(0);
                    RelativeLayout relativeLayout10 = this.c;
                    if (relativeLayout10 == null) {
                        IIX0o.XOxIOxOx("chargeListNaviAddNodeContainer");
                    }
                    relativeLayout10.setVisibility(8);
                    TextView textView8 = this.j;
                    if (textView8 == null) {
                        IIX0o.XOxIOxOx("chargeListGoRouteResult");
                    }
                    if (eVar.d() == 1) {
                        i2 = 8;
                    } else {
                        i2 = 0;
                    }
                    textView8.setVisibility(i2);
                }
            }
        }
        if (a()) {
            LinearLayout linearLayout8 = this.d;
            if (linearLayout8 == null) {
                IIX0o.XOxIOxOx("listStationContainer");
            }
            linearLayout8.setVisibility(0);
            BNFlowLayout bNFlowLayout18 = this.h;
            if (bNFlowLayout18 == null) {
                IIX0o.XOxIOxOx("chargeListInfoCost");
            }
            bNFlowLayout18.setVisibility(8);
            BNFlowLayout bNFlowLayout19 = this.i;
            if (bNFlowLayout19 == null) {
                IIX0o.XOxIOxOx("chargeListInfoDes");
            }
            bNFlowLayout19.setVisibility(8);
        }
    }

    public final void a(int i, @OOXIXo e stationWrapper) {
        IIX0o.x0xO0oo(stationWrapper, "stationWrapper");
        this.f8400a = i;
        e(stationWrapper);
        i(stationWrapper);
        h(stationWrapper);
        d(stationWrapper);
        f(stationWrapper);
        g(stationWrapper);
        j(stationWrapper);
        a(stationWrapper.t(), stationWrapper.g());
    }

    @OOXIXo
    public final ImageView getChargeListAddApproachImg() {
        ImageView imageView = this.f;
        if (imageView == null) {
            IIX0o.XOxIOxOx("chargeListAddApproachImg");
        }
        return imageView;
    }

    @OOXIXo
    public final View getChargeListDivider() {
        View view = this.l;
        if (view == null) {
            IIX0o.XOxIOxOx("chargeListDivider");
        }
        return view;
    }

    @OOXIXo
    public final TextView getChargeListGoRouteResult() {
        TextView textView = this.j;
        if (textView == null) {
            IIX0o.XOxIOxOx("chargeListGoRouteResult");
        }
        return textView;
    }

    @OOXIXo
    public final BNFlowLayout getChargeListInfoCost() {
        BNFlowLayout bNFlowLayout = this.h;
        if (bNFlowLayout == null) {
            IIX0o.XOxIOxOx("chargeListInfoCost");
        }
        return bNFlowLayout;
    }

    @OOXIXo
    public final BNFlowLayout getChargeListInfoDes() {
        BNFlowLayout bNFlowLayout = this.i;
        if (bNFlowLayout == null) {
            IIX0o.XOxIOxOx("chargeListInfoDes");
        }
        return bNFlowLayout;
    }

    @OOXIXo
    public final BNFlowLayout getChargeListInfoDetail() {
        BNFlowLayout bNFlowLayout = this.g;
        if (bNFlowLayout == null) {
            IIX0o.XOxIOxOx("chargeListInfoDetail");
        }
        return bNFlowLayout;
    }

    @OOXIXo
    public final TextView getChargeListInfoLocation() {
        TextView textView = this.e;
        if (textView == null) {
            IIX0o.XOxIOxOx("chargeListInfoLocation");
        }
        return textView;
    }

    @OOXIXo
    public final RelativeLayout getChargeListItemContainer() {
        RelativeLayout relativeLayout = this.b;
        if (relativeLayout == null) {
            IIX0o.XOxIOxOx("chargeListItemContainer");
        }
        return relativeLayout;
    }

    @OOXIXo
    public final TextView getChargeListNaviAddNode() {
        TextView textView = this.k;
        if (textView == null) {
            IIX0o.XOxIOxOx("chargeListNaviAddNode");
        }
        return textView;
    }

    @OOXIXo
    public final RelativeLayout getChargeListNaviAddNodeContainer() {
        RelativeLayout relativeLayout = this.c;
        if (relativeLayout == null) {
            IIX0o.XOxIOxOx("chargeListNaviAddNodeContainer");
        }
        return relativeLayout;
    }

    @OOXIXo
    public final LinearLayout getListStationContainer() {
        LinearLayout linearLayout = this.d;
        if (linearLayout == null) {
            IIX0o.XOxIOxOx("listStationContainer");
        }
        return linearLayout;
    }

    public final int getShowFromType() {
        return this.f8400a;
    }

    public final void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.bnav_layout_charge_list_view_item, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.charge_list_item_container);
        IIX0o.oO(findViewById, "findViewById(R.id.charge_list_item_container)");
        this.b = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R.id.charge_list_navi_add_node_container);
        IIX0o.oO(findViewById2, "findViewById(R.id.charge…_navi_add_node_container)");
        this.c = (RelativeLayout) findViewById2;
        View findViewById3 = findViewById(R.id.charge_list_navi_add_node);
        IIX0o.oO(findViewById3, "findViewById(R.id.charge_list_navi_add_node)");
        this.k = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.charge_list_info_location);
        IIX0o.oO(findViewById4, "findViewById(R.id.charge_list_info_location)");
        this.e = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.charge_list_add_approach_img);
        IIX0o.oO(findViewById5, "findViewById(R.id.charge_list_add_approach_img)");
        this.f = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.charge_list_info_detail);
        IIX0o.oO(findViewById6, "findViewById(R.id.charge_list_info_detail)");
        this.g = (BNFlowLayout) findViewById6;
        View findViewById7 = findViewById(R.id.charge_list_info_station_container);
        IIX0o.oO(findViewById7, "findViewById(R.id.charge…t_info_station_container)");
        this.d = (LinearLayout) findViewById7;
        View findViewById8 = findViewById(R.id.charge_list_info_cost);
        IIX0o.oO(findViewById8, "findViewById(R.id.charge_list_info_cost)");
        this.h = (BNFlowLayout) findViewById8;
        View findViewById9 = findViewById(R.id.charge_list_info_des);
        IIX0o.oO(findViewById9, "findViewById(R.id.charge_list_info_des)");
        this.i = (BNFlowLayout) findViewById9;
        View findViewById10 = findViewById(R.id.charge_list_go_route_result);
        IIX0o.oO(findViewById10, "findViewById(R.id.charge_list_go_route_result)");
        this.j = (TextView) findViewById10;
        View findViewById11 = findViewById(R.id.charge_list_divider);
        IIX0o.oO(findViewById11, "findViewById(R.id.charge_list_divider)");
        this.l = findViewById11;
    }

    public final void setAddApproachNodeListener(@OOXIXo View.OnClickListener clickListener) {
        IIX0o.x0xO0oo(clickListener, "clickListener");
        ImageView imageView = this.f;
        if (imageView == null) {
            IIX0o.XOxIOxOx("chargeListAddApproachImg");
        }
        imageView.setOnClickListener(clickListener);
    }

    public final void setChargeListAddApproachImg(@OOXIXo ImageView imageView) {
        IIX0o.x0xO0oo(imageView, "<set-?>");
        this.f = imageView;
    }

    public final void setChargeListDivider(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.l = view;
    }

    public final void setChargeListGoRouteResult(@OOXIXo TextView textView) {
        IIX0o.x0xO0oo(textView, "<set-?>");
        this.j = textView;
    }

    public final void setChargeListInfoCost(@OOXIXo BNFlowLayout bNFlowLayout) {
        IIX0o.x0xO0oo(bNFlowLayout, "<set-?>");
        this.h = bNFlowLayout;
    }

    public final void setChargeListInfoDes(@OOXIXo BNFlowLayout bNFlowLayout) {
        IIX0o.x0xO0oo(bNFlowLayout, "<set-?>");
        this.i = bNFlowLayout;
    }

    public final void setChargeListInfoDetail(@OOXIXo BNFlowLayout bNFlowLayout) {
        IIX0o.x0xO0oo(bNFlowLayout, "<set-?>");
        this.g = bNFlowLayout;
    }

    public final void setChargeListInfoLocation(@OOXIXo TextView textView) {
        IIX0o.x0xO0oo(textView, "<set-?>");
        this.e = textView;
    }

    public final void setChargeListItemContainer(@OOXIXo RelativeLayout relativeLayout) {
        IIX0o.x0xO0oo(relativeLayout, "<set-?>");
        this.b = relativeLayout;
    }

    public final void setChargeListNaviAddNode(@OOXIXo TextView textView) {
        IIX0o.x0xO0oo(textView, "<set-?>");
        this.k = textView;
    }

    public final void setChargeListNaviAddNodeContainer(@OOXIXo RelativeLayout relativeLayout) {
        IIX0o.x0xO0oo(relativeLayout, "<set-?>");
        this.c = relativeLayout;
    }

    public final void setItemContainerListener(@OOXIXo View.OnClickListener clickListener) {
        IIX0o.x0xO0oo(clickListener, "clickListener");
        RelativeLayout relativeLayout = this.b;
        if (relativeLayout == null) {
            IIX0o.XOxIOxOx("chargeListItemContainer");
        }
        relativeLayout.setOnClickListener(clickListener);
    }

    public final void setJumpToRouteResultListener(@OOXIXo View.OnClickListener clickListener) {
        IIX0o.x0xO0oo(clickListener, "clickListener");
        TextView textView = this.j;
        if (textView == null) {
            IIX0o.XOxIOxOx("chargeListGoRouteResult");
        }
        textView.setOnClickListener(clickListener);
    }

    public final void setListStationContainer(@OOXIXo LinearLayout linearLayout) {
        IIX0o.x0xO0oo(linearLayout, "<set-?>");
        this.d = linearLayout;
    }

    public final void setNaviAddNodeListener(@OOXIXo View.OnClickListener clickListener) {
        IIX0o.x0xO0oo(clickListener, "clickListener");
        RelativeLayout relativeLayout = this.c;
        if (relativeLayout == null) {
            IIX0o.XOxIOxOx("chargeListNaviAddNodeContainer");
        }
        relativeLayout.setOnClickListener(clickListener);
    }

    public final void setShowFromType(int i) {
        this.f8400a = i;
    }

    @xoIox
    public ChargeListItemView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ChargeListItemView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public ChargeListItemView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f8400a = 1;
        initView();
    }

    private final boolean a() {
        return this.f8400a == 2;
    }

    private final void a(boolean z, boolean z2) {
        Drawable drawable;
        Drawable b;
        Drawable b2;
        if (z) {
            drawable = ContextCompat.getDrawable(getContext(), R.drawable.nsdk_energy_charge_normal_approach_add);
        } else {
            drawable = ContextCompat.getDrawable(getContext(), R.drawable.nsdk_energy_charge_approach_img);
        }
        if (c()) {
            if (z) {
                com.baidu.navisdk.ui.chargelist.e eVar = com.baidu.navisdk.ui.chargelist.e.f8376a;
                b = eVar.b(true, R.drawable.nsdk_energy_charge_approach_add);
                IIX0o.ooOOo0oXI(b);
                b2 = eVar.b(c(), R.drawable.bnav_charge_navi_normal_added_bg);
                IIX0o.ooOOo0oXI(b2);
                TextView textView = this.k;
                if (textView == null) {
                    IIX0o.XOxIOxOx("chargeListNaviAddNode");
                }
                textView.setTextColor(Color.parseColor("#FFFFFFFF"));
            } else if (z2) {
                b = com.baidu.navisdk.ui.chargelist.e.f8376a.b(true, R.drawable.nsdk_energy_charge_approach_selected);
                IIX0o.ooOOo0oXI(b);
                TextView textView2 = this.k;
                if (textView2 == null) {
                    IIX0o.XOxIOxOx("chargeListNaviAddNode");
                }
                textView2.setTextColor(Color.parseColor("#FFFFFFFF"));
                b2 = ContextCompat.getDrawable(getContext(), R.drawable.bnav_charge_navi_large_bg);
                IIX0o.ooOOo0oXI(b2);
            } else {
                com.baidu.navisdk.ui.chargelist.e eVar2 = com.baidu.navisdk.ui.chargelist.e.f8376a;
                b = eVar2.b(true, R.drawable.nsdk_energy_charge_approach_img);
                IIX0o.ooOOo0oXI(b);
                TextView textView3 = this.k;
                if (textView3 == null) {
                    IIX0o.XOxIOxOx("chargeListNaviAddNode");
                }
                textView3.setTextColor(Color.parseColor("#FF1FCCA1"));
                b2 = eVar2.b(c(), R.drawable.bnav_charge_navi_normal_bg);
                IIX0o.ooOOo0oXI(b2);
            }
            RelativeLayout relativeLayout = this.c;
            if (relativeLayout == null) {
                IIX0o.XOxIOxOx("chargeListNaviAddNodeContainer");
            }
            relativeLayout.setBackground(b2);
            b.setBounds(0, 0, ScreenUtil.getInstance().dip2px(12), ScreenUtil.getInstance().dip2px(12));
            TextView textView4 = this.k;
            if (textView4 == null) {
                IIX0o.XOxIOxOx("chargeListNaviAddNode");
            }
            textView4.setCompoundDrawables(b, null, null, null);
            TextView textView5 = this.k;
            if (textView5 == null) {
                IIX0o.XOxIOxOx("chargeListNaviAddNode");
            }
            textView5.setText(z ? "已添加" : "途经点");
            return;
        }
        ImageView imageView = this.f;
        if (imageView == null) {
            IIX0o.XOxIOxOx("chargeListAddApproachImg");
        }
        imageView.setBackground(drawable);
    }
}
