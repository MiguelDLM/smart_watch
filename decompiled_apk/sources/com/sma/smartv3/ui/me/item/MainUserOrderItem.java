package com.sma.smartv3.ui.me.item;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.Utils;
import com.google.gson.Gson;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.OrderManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AIFunction;
import com.sma.smartv3.model.AIFunctionDataKt;
import com.sma.smartv3.model.AccountPoints;
import com.sma.smartv3.model.UserMember;
import com.sma.smartv3.model.UserOrderKt;
import com.sma.smartv3.model.VipBenefitType;
import com.sma.smartv3.ui.me.GoogleWebViewActivity;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.text.PFMedium;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nMainUserOrderItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainUserOrderItem.kt\ncom/sma/smartv3/ui/me/item/MainUserOrderItem\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n*L\n1#1,270:1\n93#2,2:271\n90#2:273\n93#2,2:274\n90#2:276\n1#3:277\n1#3:285\n87#4,7:278\n94#4,3:286\n70#4,7:289\n97#4:296\n*S KotlinDebug\n*F\n+ 1 MainUserOrderItem.kt\ncom/sma/smartv3/ui/me/item/MainUserOrderItem\n*L\n119#1:271,2\n119#1:273\n142#1:274,2\n142#1:276\n203#1:285\n203#1:278,7\n203#1:286,3\n203#1:289,7\n203#1:296\n*E\n"})
/* loaded from: classes11.dex */
public class MainUserOrderItem extends BaseDslItem {
    public View btPointsDetail;
    public View btRecharge;
    public View btUserOrder;
    private final boolean initEvent = true;
    public View layoutPoints;

    @oOoXoXO
    private View.OnClickListener mOnClick;
    public RecyclerView rvVipInterests;
    public PFMedium tvBenefitPackage;
    public PFMedium tvBenefitPackageTip;
    public TextView tvPoints;
    public TextView tvRecharge;
    public PFMedium tvWelfare;
    public ImageView welfareAnim;

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.btRecharge);
        IIX0o.ooOOo0oXI(v);
        setBtRecharge(v);
        View v2 = itemHolder.v(R.id.btPointsDetail);
        IIX0o.ooOOo0oXI(v2);
        setBtPointsDetail(v2);
        View v3 = itemHolder.v(R.id.btUserOrder);
        IIX0o.ooOOo0oXI(v3);
        setBtUserOrder(v3);
        TextView tv = itemHolder.tv(R.id.tv_points);
        IIX0o.ooOOo0oXI(tv);
        setTvPoints(tv);
        TextView tv2 = itemHolder.tv(R.id.tvRecharge);
        IIX0o.ooOOo0oXI(tv2);
        setTvRecharge(tv2);
        View v4 = itemHolder.v(R.id.me_points_layout);
        IIX0o.ooOOo0oXI(v4);
        setLayoutPoints(v4);
        View v5 = itemHolder.v(R.id.ImgWelfareAnim);
        IIX0o.ooOOo0oXI(v5);
        setWelfareAnim((ImageView) v5);
        View v6 = itemHolder.v(R.id.WelfareAnimtv);
        IIX0o.ooOOo0oXI(v6);
        setTvWelfare((PFMedium) v6);
        View v7 = itemHolder.v(R.id.user_order_ai_benefit_package);
        IIX0o.ooOOo0oXI(v7);
        setTvBenefitPackage((PFMedium) v7);
        View v8 = itemHolder.v(R.id.user_order_ai_benefit_package_tip);
        IIX0o.ooOOo0oXI(v8);
        setTvBenefitPackageTip((PFMedium) v8);
        View v9 = itemHolder.v(R.id.user_order_horizontal_recycler);
        IIX0o.ooOOo0oXI(v9);
        setRvVipInterests((RecyclerView) v9);
        itemHolder.click(R.id.btRecharge, this.mOnClick);
        itemHolder.click(R.id.btPointsDetail, this.mOnClick);
        itemHolder.click(R.id.btUserOrder, this.mOnClick);
        itemHolder.click(R.id.ImgWelfareAnim, this.mOnClick);
        itemHolder.click(R.id.WelfareAnimtv, this.mOnClick);
    }

    @OOXIXo
    public final View getBtPointsDetail() {
        View view = this.btPointsDetail;
        if (view != null) {
            return view;
        }
        IIX0o.XOxIOxOx("btPointsDetail");
        return null;
    }

    @OOXIXo
    public final View getBtRecharge() {
        View view = this.btRecharge;
        if (view != null) {
            return view;
        }
        IIX0o.XOxIOxOx("btRecharge");
        return null;
    }

    @OOXIXo
    public final View getBtUserOrder() {
        View view = this.btUserOrder;
        if (view != null) {
            return view;
        }
        IIX0o.XOxIOxOx("btUserOrder");
        return null;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public boolean getInitEvent() {
        return this.initEvent;
    }

    @OOXIXo
    public final View getLayoutPoints() {
        View view = this.layoutPoints;
        if (view != null) {
            return view;
        }
        IIX0o.XOxIOxOx("layoutPoints");
        return null;
    }

    @oOoXoXO
    public final View.OnClickListener getMOnClick() {
        return this.mOnClick;
    }

    @OOXIXo
    public final RecyclerView getRvVipInterests() {
        RecyclerView recyclerView = this.rvVipInterests;
        if (recyclerView != null) {
            return recyclerView;
        }
        IIX0o.XOxIOxOx("rvVipInterests");
        return null;
    }

    @OOXIXo
    public final PFMedium getTvBenefitPackage() {
        PFMedium pFMedium = this.tvBenefitPackage;
        if (pFMedium != null) {
            return pFMedium;
        }
        IIX0o.XOxIOxOx("tvBenefitPackage");
        return null;
    }

    @OOXIXo
    public final PFMedium getTvBenefitPackageTip() {
        PFMedium pFMedium = this.tvBenefitPackageTip;
        if (pFMedium != null) {
            return pFMedium;
        }
        IIX0o.XOxIOxOx("tvBenefitPackageTip");
        return null;
    }

    @OOXIXo
    public final TextView getTvPoints() {
        TextView textView = this.tvPoints;
        if (textView != null) {
            return textView;
        }
        IIX0o.XOxIOxOx("tvPoints");
        return null;
    }

    @OOXIXo
    public final TextView getTvRecharge() {
        TextView textView = this.tvRecharge;
        if (textView != null) {
            return textView;
        }
        IIX0o.XOxIOxOx("tvRecharge");
        return null;
    }

    @OOXIXo
    public final PFMedium getTvWelfare() {
        PFMedium pFMedium = this.tvWelfare;
        if (pFMedium != null) {
            return pFMedium;
        }
        IIX0o.XOxIOxOx("tvWelfare");
        return null;
    }

    @OOXIXo
    public final ImageView getWelfareAnim() {
        ImageView imageView = this.welfareAnim;
        if (imageView != null) {
            return imageView;
        }
        IIX0o.XOxIOxOx("welfareAnim");
        return null;
    }

    public final void initRecyclerView() {
        getRvVipInterests().setLayoutManager(new LinearLayoutManager(getRvVipInterests().getContext(), 0, false));
        getRvVipInterests().setAdapter(new MainUserOrderItem$initRecyclerView$mAdapter$1(this, getRvVipInterests().getContext(), UserOrderKt.getVipBenefitList()));
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        int getPointFlag;
        String str;
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        setItemHidden(!projectManager.ooOx());
        UtilsKt.x0o(getLayoutPoints(), Utils.getApp().getResources().getDimension(R.dimen.common_item_radius));
        if (projectManager.oIIxXoo()) {
            getTvWelfare().setText(UtilsKt.oI0IIXIo(R.string.free_use_ai_tip));
            SPUtils XO2 = Xo0.f24349oIX0oI.XO();
            Object fromJson = new Gson().fromJson(XO2.getString(x0xO0oo.f24656xOoOIoI + '_' + UserMember.class.getName()), (Class<Object>) UserMember.class);
            if (fromJson == null) {
                fromJson = UserMember.class.newInstance();
            }
            UserMember userMember = (UserMember) fromJson;
            getPointFlag = oOXoIIIo.I0Io.I0Io(userMember.getGetMemberFlag());
            if (userMember.getLatestDateTime() > 0) {
                getTvBenefitPackage().setVisibility(0);
                PFMedium tvBenefitPackageTip = getTvBenefitPackageTip();
                if (userMember.getServerDateTime() > userMember.getLatestDateTime()) {
                    str = UtilsKt.oI0IIXIo(R.string.ai_expired_tip);
                } else {
                    str = UtilsKt.oI0IIXIo(R.string.valid_until) + com.sma.smartv3.util.xoIox.Oxx0IOOO().format(new Date(userMember.getLatestDateTime()));
                }
                tvBenefitPackageTip.setText(str);
                getTvRecharge().setText(UtilsKt.oI0IIXIo(R.string.renew_now));
            } else {
                getTvWelfare().setText(UtilsKt.oI0IIXIo(R.string.free_use_ai_tip));
                getTvBenefitPackage().setVisibility(8);
                getTvBenefitPackageTip().setText(UtilsKt.oI0IIXIo(R.string.buy_ai_tip));
                getTvRecharge().setText(UtilsKt.oI0IIXIo(R.string.go_recharge));
            }
            getBtPointsDetail().setVisibility(8);
            getTvPoints().setVisibility(8);
        } else {
            SPUtils XO3 = Xo0.f24349oIX0oI.XO();
            Object fromJson2 = new Gson().fromJson(XO3.getString(x0xO0oo.f24568IIX0 + '_' + AccountPoints.class.getName()), (Class<Object>) AccountPoints.class);
            if (fromJson2 == null) {
                fromJson2 = AccountPoints.class.newInstance();
            }
            AccountPoints accountPoints = (AccountPoints) fromJson2;
            getPointFlag = accountPoints.getGetPointFlag();
            getTvRecharge().setText(UtilsKt.oI0IIXIo(R.string.go_recharge));
            getTvPoints().setText(Utils.getApp().getString(R.string.me_points, Integer.valueOf(accountPoints.getPoints())));
            getTvWelfare().setText(UtilsKt.oI0IIXIo(R.string.free_points));
            getTvBenefitPackageTip().setText(UtilsKt.oI0IIXIo(R.string.me_points_recharge_tip));
            getTvPoints().setVisibility(0);
            getTvBenefitPackage().setVisibility(8);
            getBtPointsDetail().setVisibility(0);
        }
        initRecyclerView();
        if (getPointFlag == 0) {
            getWelfareAnim().setVisibility(0);
            getWelfareAnim().clearAnimation();
            Drawable drawable = getWelfareAnim().getContext().getResources().getDrawable(R.drawable.welfare_animation_list);
            IIX0o.x0XOIxOo(drawable, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            getWelfareAnim().setImageDrawable(animationDrawable);
            animationDrawable.start();
            getTvWelfare().setVisibility(0);
        } else {
            getWelfareAnim().setVisibility(8);
            getTvWelfare().setVisibility(8);
        }
        pointDetailBg();
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.me_item_user_order;
    }

    @XO0.XO(tag = x0xO0oo.f24598Ox0O)
    public final void onGetFreePoints(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("onGetFreePoints");
        initView();
    }

    @XO0.XO(tag = x0xO0oo.f24563I0X0x0oIo)
    public final void onLoginDone(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        initView();
    }

    @XO0.XO(tag = x0xO0oo.f24635oX)
    public final void onThemeChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.d("onThemeChange");
        if (ProjectManager.f19822oIX0oI.oIIxXoo()) {
            getLayoutPoints().setBackground(oIxOXo.oxoX.Oxx0IOOO(getLayoutPoints().getContext(), R.drawable.shape_me_bottom_ll_bg));
        }
        pointDetailBg();
    }

    @XO0.XO(tag = x0xO0oo.f24656xOoOIoI)
    public final void onUserMemberChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("onUserMemberChange");
        initView();
    }

    @XO0.XO(tag = x0xO0oo.f24568IIX0)
    public final void onUserPointsChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("onUserPointsChange");
        initView();
    }

    public final void pointDetailBg() {
        getBtPointsDetail().setBackgroundTintList(ColorStateList.valueOf(oIxOXo.oxoX.I0Io(getBtPointsDetail().getContext(), R.color.points_secondary_bg_color)));
        getTvRecharge().setTextColor(oIxOXo.oxoX.I0Io(getTvRecharge().getContext(), R.color.points_go_recharge_color));
    }

    public final void setBtPointsDetail(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.btPointsDetail = view;
    }

    public final void setBtRecharge(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.btRecharge = view;
    }

    public final void setBtUserOrder(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.btUserOrder = view;
    }

    public final void setLayoutPoints(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.layoutPoints = view;
    }

    public final void setMOnClick(@oOoXoXO View.OnClickListener onClickListener) {
        this.mOnClick = onClickListener;
    }

    public final void setRvVipInterests(@OOXIXo RecyclerView recyclerView) {
        IIX0o.x0xO0oo(recyclerView, "<set-?>");
        this.rvVipInterests = recyclerView;
    }

    public final void setTvBenefitPackage(@OOXIXo PFMedium pFMedium) {
        IIX0o.x0xO0oo(pFMedium, "<set-?>");
        this.tvBenefitPackage = pFMedium;
    }

    public final void setTvBenefitPackageTip(@OOXIXo PFMedium pFMedium) {
        IIX0o.x0xO0oo(pFMedium, "<set-?>");
        this.tvBenefitPackageTip = pFMedium;
    }

    public final void setTvPoints(@OOXIXo TextView textView) {
        IIX0o.x0xO0oo(textView, "<set-?>");
        this.tvPoints = textView;
    }

    public final void setTvRecharge(@OOXIXo TextView textView) {
        IIX0o.x0xO0oo(textView, "<set-?>");
        this.tvRecharge = textView;
    }

    public final void setTvWelfare(@OOXIXo PFMedium pFMedium) {
        IIX0o.x0xO0oo(pFMedium, "<set-?>");
        this.tvWelfare = pFMedium;
    }

    public final void setWelfareAnim(@OOXIXo ImageView imageView) {
        IIX0o.x0xO0oo(imageView, "<set-?>");
        this.welfareAnim = imageView;
    }

    public final void toVipBenefitIntent(@OOXIXo Context context, int i) {
        IIX0o.x0xO0oo(context, "context");
        if (i == VipBenefitType.AI.getType()) {
            List<AIFunction> aIFunction = AIFunctionDataKt.getAIFunction();
            if (!aIFunction.isEmpty()) {
                AIFunctionDataKt.toAIFunction((Activity) context, aIFunction.get(0));
                return;
            }
            return;
        }
        if (i == VipBenefitType.AIGC.getType()) {
            toWatchFaceActivity(context, 1);
            return;
        }
        if (i == VipBenefitType.DIAL.getType()) {
            toWatchFaceActivity(context, 0);
            return;
        }
        if (i == VipBenefitType.BUY_VIP.getType()) {
            Activity activity = (Activity) context;
            String IIX0o2 = OrderManager.IIX0o(OrderManager.f20130oIX0oI, null, null, 3, null);
            Bundle bundle = new Bundle();
            bundle.putString("mArg0", IIX0o2);
            bundle.putInt("mArg1", 2);
            bundle.putParcelable("mArg2", null);
            bundle.putSerializable("mArg3", null);
            Intent intent = new Intent(activity, (Class<?>) GoogleWebViewActivity.class);
            intent.putExtras(bundle);
            activity.startActivity(intent);
        }
    }

    public final void toWatchFaceActivity(@OOXIXo Context context, int i) {
        IIX0o.x0xO0oo(context, "context");
        com.sma.smartv3.ble.I0Io.II0xO0(false, new MainUserOrderItem$toWatchFaceActivity$1(context, i), 1, null);
    }
}
