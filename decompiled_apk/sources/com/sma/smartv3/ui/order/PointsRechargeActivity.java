package com.sma.smartv3.ui.order;

import OXOo.oOoXoXO;
import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.SpanUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.OrderManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.IXxxXO;
import com.sma.smartv3.model.AccountPoints;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.PointsPack;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.GetPointsPack;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.pop.XoI0Ixx0;
import com.sma.smartv3.pop.x0xO0oo;
import com.sma.smartv3.ui.me.WebViewActivity;
import com.sma.smartv3.util.Xo0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.OOXIXo;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.OxI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import oIxOXo.oxoX;
import x0xO.XO;

@OOXIXo(message = "需求变更, 已废弃")
@XX({"SMAP\nPointsRechargeActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PointsRechargeActivity.kt\ncom/sma/smartv3/ui/order/PointsRechargeActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 4 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,309:1\n19#2:310\n15#2:311\n93#2,2:312\n90#2:314\n151#3,11:315\n171#3:334\n208#4,7:326\n226#4:333\n*S KotlinDebug\n*F\n+ 1 PointsRechargeActivity.kt\ncom/sma/smartv3/ui/order/PointsRechargeActivity\n*L\n137#1:310\n137#1:311\n153#1:312,2\n153#1:314\n210#1:315,11\n210#1:334\n210#1:326,7\n210#1:333\n*E\n"})
/* loaded from: classes11.dex */
public final class PointsRechargeActivity extends BaseActivity {
    private boolean isNeedPayDialog;

    @oOoXoXO
    private XoI0Ixx0 mPayconfirmPopup;

    @oOoXoXO
    private x0xO0oo mRechargePointPopup;

    @oOoXoXO
    private PointsPack mSelectPointsPack;

    @OXOo.OOXIXo
    private final String TAG = "PointsRecharge";

    @OXOo.OOXIXo
    private final X0IIOO rootView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.order.PointsRechargeActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return PointsRechargeActivity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO layoutBg$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.order.PointsRechargeActivity$layoutBg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return PointsRechargeActivity.this.findViewById(R.id.points_recharge_bg_layout);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO ivAvatar$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.order.PointsRechargeActivity$ivAvatar$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) PointsRechargeActivity.this.findViewById(R.id.iv_avatar);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvNickname$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.order.PointsRechargeActivity$tvNickname$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) PointsRechargeActivity.this.findViewById(R.id.tv_nickname);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvPoints$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.order.PointsRechargeActivity$tvPoints$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) PointsRechargeActivity.this.findViewById(R.id.tv_points);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO rvPointsPack$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.order.PointsRechargeActivity$rvPointsPack$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            return (RecyclerView) PointsRechargeActivity.this.findViewById(R.id.rv_points_pack);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO cbPointsPrivacy$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AppCompatCheckBox>() { // from class: com.sma.smartv3.ui.order.PointsRechargeActivity$cbPointsPrivacy$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AppCompatCheckBox invoke() {
            return (AppCompatCheckBox) PointsRechargeActivity.this.findViewById(R.id.cb_points_privacy);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvPointsPrivacy$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.order.PointsRechargeActivity$tvPointsPrivacy$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) PointsRechargeActivity.this.findViewById(R.id.tv_points_privacy);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO btnRecharge$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.order.PointsRechargeActivity$btnRecharge$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) PointsRechargeActivity.this.findViewById(R.id.btn_recharge);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mUserCardView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CardView>() { // from class: com.sma.smartv3.ui.order.PointsRechargeActivity$mUserCardView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CardView invoke() {
            return (CardView) PointsRechargeActivity.this.findViewById(R.id.btRecharge);
        }
    });

    @OXOo.OOXIXo
    private List<PointsPack> mPointsPackList = new ArrayList();

    @OXOo.OOXIXo
    private String orderNum = "";

    @XX({"SMAP\nPointsRechargeActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PointsRechargeActivity.kt\ncom/sma/smartv3/ui/order/PointsRechargeActivity$initView$1\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,309:1\n87#2,7:310\n94#2,3:318\n70#2,7:321\n97#2:328\n1#3:317\n*S KotlinDebug\n*F\n+ 1 PointsRechargeActivity.kt\ncom/sma/smartv3/ui/order/PointsRechargeActivity$initView$1\n*L\n101#1:310,7\n101#1:318,3\n101#1:321,7\n101#1:328\n101#1:317\n*E\n"})
    /* loaded from: classes11.dex */
    public static final class oIX0oI extends ClickableSpan {
        public oIX0oI() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@OXOo.OOXIXo View widget) {
            IIX0o.x0xO0oo(widget, "widget");
            PointsRechargeActivity pointsRechargeActivity = PointsRechargeActivity.this;
            String str = "https://api.iot-solution.net/web/cn/smart_time_pro/webs/points_agreement.html?lang=" + ProjectManager.f19822oIX0oI.o00(PointsRechargeActivity.this);
            Bundle bundle = new Bundle();
            bundle.putString("mArg0", str);
            bundle.putInt("mArg1", 2);
            bundle.putParcelable("mArg2", null);
            bundle.putSerializable("mArg3", null);
            Intent intent = new Intent(pointsRechargeActivity, (Class<?>) WebViewActivity.class);
            intent.putExtras(bundle);
            pointsRechargeActivity.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@OXOo.OOXIXo TextPaint paint) {
            IIX0o.x0xO0oo(paint, "paint");
            paint.setColor(-16776961);
            paint.setUnderlineText(false);
        }
    }

    private final Button getBtnRecharge() {
        return (Button) this.btnRecharge$delegate.getValue();
    }

    private final AppCompatCheckBox getCbPointsPrivacy() {
        return (AppCompatCheckBox) this.cbPointsPrivacy$delegate.getValue();
    }

    private final ImageView getIvAvatar() {
        return (ImageView) this.ivAvatar$delegate.getValue();
    }

    private final View getLayoutBg() {
        return (View) this.layoutBg$delegate.getValue();
    }

    private final CardView getMUserCardView() {
        return (CardView) this.mUserCardView$delegate.getValue();
    }

    private final void getPayInfo() {
    }

    private final void getPointsPack() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " getPointsPack");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> pointsPackBody = RequestBodyKt.getPointsPackBody();
        final xxxI.II0xO0<PointsPack[]> iI0xO0 = new xxxI.II0xO0<PointsPack[]>() { // from class: com.sma.smartv3.ui.order.PointsRechargeActivity$getPointsPack$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                String str;
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                StringBuilder sb = new StringBuilder();
                str = PointsRechargeActivity.this.TAG;
                sb.append(str);
                sb.append(" handleError -> ");
                sb.append(error);
                oix0oi.oIX0oI(sb.toString());
                ToastUtils.showLong(error, new Object[0]);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@oOoXoXO PointsPack[] pointsPackArr) {
                String str;
                List list;
                List list2;
                RecyclerView rvPointsPack;
                OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                StringBuilder sb = new StringBuilder();
                str = PointsRechargeActivity.this.TAG;
                sb.append(str);
                sb.append(" handleResponse -> ");
                sb.append(pointsPackArr);
                oix0oi.oIX0oI(sb.toString());
                if (pointsPackArr != null) {
                    list = PointsRechargeActivity.this.mPointsPackList;
                    list.clear();
                    list2 = PointsRechargeActivity.this.mPointsPackList;
                    OxI.xxIO(list2, pointsPackArr);
                    rvPointsPack = PointsRechargeActivity.this.getRvPointsPack();
                    RecyclerView.Adapter adapter = rvPointsPack.getAdapter();
                    if (adapter != null) {
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        };
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetPointsPack.URL);
        netWorkUtils.printParam(convertBaseUrl + GetPointsPack.URL, pointsPackBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetPointsPack.URL;
        final xxxI.II0xO0<Response<PointsPack[]>> iI0xO02 = new xxxI.II0xO0<Response<PointsPack[]>>() { // from class: com.sma.smartv3.ui.order.PointsRechargeActivity$getPointsPack$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@oOoXoXO Response<PointsPack[]> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) pointsPackBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, PointsPack[].class), new ParsedRequestListener<Response<PointsPack[]>>() { // from class: com.sma.smartv3.ui.order.PointsRechargeActivity$getPointsPack$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<PointsPack[]> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", ");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView getRvPointsPack() {
        return (RecyclerView) this.rvPointsPack$delegate.getValue();
    }

    private final TextView getTvNickname() {
        return (TextView) this.tvNickname$delegate.getValue();
    }

    private final TextView getTvPoints() {
        return (TextView) this.tvPoints$delegate.getValue();
    }

    private final TextView getTvPointsPrivacy() {
        return (TextView) this.tvPointsPrivacy$delegate.getValue();
    }

    private final void initPointsPack() {
        getPointsPack();
        getRvPointsPack().setLayoutManager(new GridLayoutManager(this, 2));
        getRvPointsPack().setAdapter(new PointsRechargeActivity$initPointsPack$1(this, this.mPointsPackList));
    }

    private final void initUserPanel() {
        TextView tvNickname = getTvNickname();
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        tvNickname.setText(((AppUser) appUser).getNickname());
        getIvAvatar().setImageDrawable(oxoX.Oxx0IOOO(getIvAvatar().getContext(), R.drawable.pic_avatar_default));
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        if (IXxxXO.xxIXOIIO(oix0oi).exists()) {
            getIvAvatar().setImageURI(Uri.fromFile(IXxxXO.xxIXOIIO(oix0oi)));
        }
        showPoints();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(PointsRechargeActivity this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (!this$0.getCbPointsPrivacy().isChecked()) {
            ToastUtils.showLong(this$0.getString(R.string.privacy_tick_tip_v2), new Object[0]);
        } else if (this$0.mSelectPointsPack == null) {
            ToastUtils.showLong(this$0.getString(R.string.select_recharge_tip), new Object[0]);
        } else {
            this$0.getPayInfo();
        }
    }

    private final void showPayConfirm() {
        if (this.mPayconfirmPopup == null) {
            XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.x0xO0oo(false);
            xoI0Ixx0.IoOoX(R.string.payment_completed_tip);
            XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.yes_payment, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.order.PointsRechargeActivity$showPayConfirm$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    PointsRechargeActivity.this.getOrderStatus();
                    return Boolean.TRUE;
                }
            });
            this.mPayconfirmPopup = xoI0Ixx0;
        }
        XoI0Ixx0 xoI0Ixx02 = this.mPayconfirmPopup;
        if (xoI0Ixx02 != null) {
            View rootView = getRootView();
            IIX0o.oO(rootView, "<get-rootView>(...)");
            xoI0Ixx02.OxxIIOOXO(rootView);
        }
    }

    private final void showPoints() {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object fromJson = new Gson().fromJson(XO2.getString(com.sma.smartv3.util.x0xO0oo.f24568IIX0 + '_' + AccountPoints.class.getName()), (Class<Object>) AccountPoints.class);
        if (fromJson == null) {
            fromJson = AccountPoints.class.newInstance();
        }
        getTvPoints().setText(String.valueOf(((AccountPoints) fromJson).getPoints()));
    }

    @OXOo.OOXIXo
    public final String getOrderNum() {
        return this.orderNum;
    }

    public final void getOrderStatus() {
        OrderManager.f20130oIX0oI.IXxxXO(this.orderNum, "Points", new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.order.PointsRechargeActivity$getOrderStatus$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(boolean z) {
                if (z) {
                    PointsRechargeActivity.this.showRechargePointPopup();
                } else {
                    ToastUtils.showLong(R.string.pay_confirm_error);
                }
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        BarUtils.transparentStatusBar(this);
        BarUtils.addMarginTopEqualStatusBarHeight(findViewById(R.id.root_view));
        setNavBarColor(this, oxoX.I0Io(this, R.color.points_bg_color));
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.points_recharge);
        initUserPanel();
        initPointsPack();
        SpanUtils.with(getTvPointsPrivacy()).append(getString(R.string.points_privacy_tip1)).append(getString(R.string.points_privacy_tip2)).setClickSpan(new oIX0oI()).create();
        getBtnRecharge().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.order.II0xO0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PointsRechargeActivity.initView$lambda$0(PointsRechargeActivity.this, view);
            }
        });
        getLayoutBg().setBackgroundTintList(ColorStateList.valueOf(oxoX.I0Io(this, R.color.points_bg_color)));
        getMUserCardView().setBackgroundTintList(ColorStateList.valueOf(oxoX.I0Io(this, R.color.points_bg_color_secondary)));
    }

    public final boolean isNeedPayDialog() {
        return this.isNeedPayDialog;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_order_points_recharge;
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24583O0)
    public final void onOrderPayStatusChange(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " onOrderPayStatusChange");
        this.isNeedPayDialog = false;
        XoI0Ixx0 xoI0Ixx0 = this.mPayconfirmPopup;
        if (xoI0Ixx0 != null && xoI0Ixx0 != null) {
            xoI0Ixx0.dismiss();
        }
        getOrderStatus();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isNeedPayDialog) {
            this.isNeedPayDialog = false;
            showPayConfirm();
        }
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24568IIX0)
    public final void onUserPointsChange(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " onUserPointsChange");
        showPoints();
    }

    public final void setNeedPayDialog(boolean z) {
        this.isNeedPayDialog = z;
    }

    public final void setOrderNum(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.orderNum = str;
    }

    public final void showRechargePointPopup() {
        LogUtils.d("onGetFreePoints");
        if (this.mRechargePointPopup == null) {
            OrderManager.f20130oIX0oI.oo0xXOI0I(true);
            x0xO0oo x0xo0oo = new x0xO0oo(this, R.layout.pop_center_prompt_recharge_point);
            x0xo0oo.IoOoX(getString(R.string.recharge_points_arrived_tip));
            this.mRechargePointPopup = x0xo0oo;
        }
        x0xO0oo x0xo0oo2 = this.mRechargePointPopup;
        if (x0xo0oo2 != null) {
            View rootView = getRootView();
            IIX0o.oO(rootView, "<get-rootView>(...)");
            x0xo0oo2.xoXoI(rootView);
        }
    }
}
