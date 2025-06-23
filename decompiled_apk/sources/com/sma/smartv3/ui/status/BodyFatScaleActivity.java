package com.sma.smartv3.ui.status;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.bestmafen.androidbase.base.BaseActivity;
import com.bestmafen.androidbase.extension.PermissionStatus;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.kuaishou.weapon.p0.g;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.WeightDao;
import com.sma.smartv3.db.entity.Weight;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.WeightMeasureDataKt;
import com.sma.smartv3.pop.XoI0Ixx0;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.view.text.PFMedium;
import com.vtrump.vtble.VTDevice;
import com.vtrump.vtble.o00;
import com.vtrump.vtble.xoXoI;
import java.util.Date;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import org.json.JSONException;
import org.json.JSONObject;

@XX({"SMAP\nBodyFatScaleActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BodyFatScaleActivity.kt\ncom/sma/smartv3/ui/status/BodyFatScaleActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,389:1\n19#2:390\n15#2:391\n11#2,2:392\n*S KotlinDebug\n*F\n+ 1 BodyFatScaleActivity.kt\ncom/sma/smartv3/ui/status/BodyFatScaleActivity\n*L\n53#1:390\n53#1:391\n270#1:392,2\n*E\n"})
/* loaded from: classes12.dex */
public final class BodyFatScaleActivity extends BaseActivity implements xoXoI.II0xO0 {

    @OXOo.OOXIXo
    private AppUser appUser;
    private boolean isDone;

    @OXOo.OOXIXo
    private final oIX0oI listener;

    @OXOo.oOoXoXO
    private xoXoI mBleManager;

    @OXOo.oOoXoXO
    private XoI0Ixx0 mErrorTipPopup;

    @OXOo.oOoXoXO
    private XoI0Ixx0 mPermissionBackgroundPopup;

    @OXOo.oOoXoXO
    private XoI0Ixx0 mPermissionPopup;

    @OXOo.oOoXoXO
    private XoI0Ixx0 mSaveTipPopup;

    @OXOo.oOoXoXO
    private o00 mVtDeviceScale;

    @OXOo.oOoXoXO
    private Weight mWeight;

    @OXOo.OOXIXo
    private final WeightDao mWeightDao;

    @OXOo.OOXIXo
    private final X0IIOO rootView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.BodyFatScaleActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return BodyFatScaleActivity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO abhTitleRight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.BodyFatScaleActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) BodyFatScaleActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeightValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.BodyFatScaleActivity$tvWeightValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BodyFatScaleActivity.this.findViewById(R.id.tv_weightValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO llWeightMeasure$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.BodyFatScaleActivity$llWeightMeasure$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return BodyFatScaleActivity.this.findViewById(R.id.ll_weight_measure);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO llWeightMeasureInfo$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.BodyFatScaleActivity$llWeightMeasureInfo$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return BodyFatScaleActivity.this.findViewById(R.id.ll_weight_measure_info);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvMeasureTip$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.BodyFatScaleActivity$tvMeasureTip$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BodyFatScaleActivity.this.findViewById(R.id.tv_measure_tip);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvTip$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.BodyFatScaleActivity$tvTip$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return BodyFatScaleActivity.this.findViewById(R.id.tv_tip);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO btnMeasureWeight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.status.BodyFatScaleActivity$btnMeasureWeight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) BodyFatScaleActivity.this.findViewById(R.id.btn_measure_weight);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvGreet$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.BodyFatScaleActivity$tvGreet$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) BodyFatScaleActivity.this.findViewById(R.id.tv_greet);
        }
    });

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends o00.X0o0xo {
        public oIX0oI() {
        }

        @Override // com.vtrump.vtble.o00.X0o0xo
        public void oIX0oI(@OXOo.oOoXoXO String str) {
            Float f;
            int i;
            super.oIX0oI(str);
            oxxXoxO.oIX0oI oix0oi = (oxxXoxO.oIX0oI) GsonUtils.fromJson(str, oxxXoxO.oIX0oI.class);
            LogUtils.d("bodyFatScale.code = " + oix0oi.XO());
            if (oix0oi.XO() == 200) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("age", WeightMeasureDataKt.getAgeByBirth(BodyFatScaleActivity.this.appUser.getBirthday()));
                    jSONObject.put("height", Float.valueOf(BodyFatScaleActivity.this.appUser.getHeight()));
                    if (BodyFatScaleActivity.this.appUser.getGender() == 1) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    jSONObject.put("gender", i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtils.d(jSONObject);
                o00 o00Var = BodyFatScaleActivity.this.mVtDeviceScale;
                if (o00Var != null) {
                    o00Var.ox(jSONObject);
                    return;
                }
                return;
            }
            if (oix0oi.XO() == 0) {
                BodyFatScaleActivity.this.mWeight = new Weight(0, 0L, null, 0.0f, 0, 0, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, null, null, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, null, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, null, null, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, null, XIXIX.OOXIXo.f3760XO, null, 0, 0, 0, -1, 2097151, null);
                Weight weight = BodyFatScaleActivity.this.mWeight;
                if (weight != null) {
                    IIX0o.ooOOo0oXI(oix0oi);
                    weight.setBodyFatScale(oix0oi);
                }
                TextView tvWeightValue = BodyFatScaleActivity.this.getTvWeightValue();
                Weight weight2 = BodyFatScaleActivity.this.mWeight;
                if (weight2 != null) {
                    f = Float.valueOf(weight2.getMWeight());
                } else {
                    f = null;
                }
                tvWeightValue.setText(String.valueOf(f));
                BodyFatScaleActivity.this.handlerMeasureDoneState();
                LogUtils.d("Done - > " + oix0oi);
                return;
            }
            BodyFatScaleActivity bodyFatScaleActivity = BodyFatScaleActivity.this;
            IIX0o.ooOOo0oXI(oix0oi);
            bodyFatScaleActivity.handlerMeasureErrorState(oix0oi);
        }
    }

    public BodyFatScaleActivity() {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.appUser = (AppUser) (fromJson != null ? fromJson : appUser);
        this.mWeightDao = MyDb.INSTANCE.getMDatabase().weightDao();
        this.listener = new oIX0oI();
    }

    private final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    private final Button getBtnMeasureWeight() {
        return (Button) this.btnMeasureWeight$delegate.getValue();
    }

    private final View getLlWeightMeasure() {
        return (View) this.llWeightMeasure$delegate.getValue();
    }

    private final View getLlWeightMeasureInfo() {
        return (View) this.llWeightMeasureInfo$delegate.getValue();
    }

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    private final PFMedium getTvGreet() {
        return (PFMedium) this.tvGreet$delegate.getValue();
    }

    private final TextView getTvMeasureTip() {
        return (TextView) this.tvMeasureTip$delegate.getValue();
    }

    private final View getTvTip() {
        return (View) this.tvTip$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvWeightValue() {
        return (TextView) this.tvWeightValue$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlerMeasureDoneState() {
        this.isDone = true;
        getAbhTitleRight().setVisibility(0);
        getLlWeightMeasure().setVisibility(8);
        getLlWeightMeasureInfo().setVisibility(0);
        getBtnMeasureWeight().setEnabled(true);
        getBtnMeasureWeight().setText(R.string.measure_again_tip);
        getTvMeasureTip().setText(R.string.measure_connected_tip);
        getTvTip().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlerMeasureErrorState(oxxXoxO.oIX0oI oix0oi) {
        LogUtils.d("Error - > " + oix0oi);
        this.isDone = false;
        getAbhTitleRight().setVisibility(8);
        getLlWeightMeasure().setVisibility(0);
        getLlWeightMeasureInfo().setVisibility(8);
        getBtnMeasureWeight().setEnabled(true);
        getBtnMeasureWeight().setText(R.string.measure_again_tip);
        getTvMeasureTip().setText(R.string.measure_connected_tip);
        getTvTip().setVisibility(8);
        if (this.mErrorTipPopup == null) {
            XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.x0xO0oo(false);
            xoI0Ixx0.IoOoX(R.string.measure_error_tip);
            xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.give_up), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.status.BodyFatScaleActivity$handlerMeasureErrorState$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    BodyFatScaleActivity.this.finish();
                    return Boolean.TRUE;
                }
            });
            xoI0Ixx0.x0o(R.string.measure_again_tip, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.status.BodyFatScaleActivity$handlerMeasureErrorState$1$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    BodyFatScaleActivity.this.scan();
                    return Boolean.TRUE;
                }
            });
            this.mErrorTipPopup = xoI0Ixx0;
        }
        XoI0Ixx0 xoI0Ixx02 = this.mErrorTipPopup;
        if (xoI0Ixx02 != null) {
            View rootView = getRootView();
            IIX0o.oO(rootView, "<get-rootView>(...)");
            xoI0Ixx02.OxxIIOOXO(rootView);
        }
    }

    private final void handlerMeasureTimeoutState() {
        this.isDone = false;
        getAbhTitleRight().setVisibility(8);
        getLlWeightMeasure().setVisibility(0);
        getLlWeightMeasureInfo().setVisibility(8);
        getBtnMeasureWeight().setEnabled(true);
        getBtnMeasureWeight().setText(R.string.measure_again_tip);
        getTvMeasureTip().setText(R.string.measure_connected_timeout_tip);
        getTvTip().setVisibility(8);
    }

    private final void handlerMeasuringState() {
        this.isDone = false;
        getAbhTitleRight().setVisibility(8);
        getLlWeightMeasure().setVisibility(0);
        getLlWeightMeasureInfo().setVisibility(8);
        getBtnMeasureWeight().setEnabled(false);
        getBtnMeasureWeight().setText(R.string.measure_measuring_tip);
        getTvMeasureTip().setText(R.string.measure_connected_tip);
        getTvTip().setVisibility(0);
    }

    private final void handlerNoMeasureState() {
        this.isDone = false;
        getAbhTitleRight().setVisibility(8);
        getLlWeightMeasure().setVisibility(0);
        getLlWeightMeasureInfo().setVisibility(8);
        getBtnMeasureWeight().setEnabled(true);
        getBtnMeasureWeight().setText(R.string.btn_weigh);
        getTvMeasureTip().setText(R.string.measure_connected_tip);
        getTvTip().setVisibility(0);
    }

    private final void handlerUnconnectState() {
        this.isDone = false;
        getAbhTitleRight().setVisibility(8);
        getLlWeightMeasure().setVisibility(0);
        getLlWeightMeasureInfo().setVisibility(8);
        getBtnMeasureWeight().setEnabled(true);
        getBtnMeasureWeight().setText(R.string.measure_again_tip);
        getTvMeasureTip().setText(R.string.measure_unconnected_tip);
        getTvTip().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(BodyFatScaleActivity this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (!PermissionUtils.isGranted(g.g)) {
            this$0.requestLocationPermission();
        } else if (!BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            this$0.requestEnableBluetooth();
        } else {
            this$0.scan();
        }
    }

    @RequiresApi(29)
    private final void permissionBackgroundLocationRemind() {
        if (this.mPermissionBackgroundPopup == null) {
            XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.background_set_remind);
            XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.settings, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.status.BodyFatScaleActivity$permissionBackgroundLocationRemind$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    Activity mContext;
                    mContext = BodyFatScaleActivity.this.getMContext();
                    mContext.requestPermissions(new String[]{g.g, "android.permission.ACCESS_BACKGROUND_LOCATION"}, 3);
                    return Boolean.TRUE;
                }
            });
            this.mPermissionBackgroundPopup = xoI0Ixx0;
        }
        XoI0Ixx0 xoI0Ixx02 = this.mPermissionBackgroundPopup;
        if (xoI0Ixx02 != null) {
            View rootView = getRootView();
            IIX0o.oO(rootView, "<get-rootView>(...)");
            xoI0Ixx02.OxxIIOOXO(rootView);
        }
    }

    private final void requestEnableBluetooth() {
        oOXoIIIo.oIX0oI.IXxxXO(this, "android.bluetooth.adapter.action.REQUEST_ENABLE", 1, 0, 4, null);
    }

    private final void requestLocationPermission() {
        if (Build.VERSION.SDK_INT >= 29) {
            permissionBackgroundLocationRemind();
            return;
        }
        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.LOCATION);
        IIX0o.oO(permission, "permission(...)");
        oOXoIIIo.X0o0xo.I0Io(permission, null, null, new Oox.oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.BodyFatScaleActivity$requestLocationPermission$1

            /* loaded from: classes12.dex */
            public /* synthetic */ class oIX0oI {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public static final /* synthetic */ int[] f24029oIX0oI;

                static {
                    int[] iArr = new int[PermissionStatus.values().length];
                    try {
                        iArr[PermissionStatus.GRANTED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PermissionStatus.DENIED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f24029oIX0oI = iArr;
                }
            }

            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                invoke2(permissionStatus);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo PermissionStatus it) {
                IIX0o.x0xO0oo(it, "it");
                int i = oIX0oI.f24029oIX0oI[it.ordinal()];
                if (i == 1) {
                    BodyFatScaleActivity.this.scan();
                } else if (i != 2) {
                    BodyFatScaleActivity.this.permissionRemind();
                }
            }
        }, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void save() {
        Weight weight = this.mWeight;
        if (weight != null) {
            this.appUser.setWeight(weight.getMWeight());
            Xo0.f24349oIX0oI.XO().put(AppUser.class.getName(), new Gson().toJson(this.appUser));
            this.mWeightDao.insert(CollectionsKt__CollectionsKt.XOxIOxOx(weight));
            com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24634oOoXoXO, weight);
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24612XO, null, 2, null);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scan() {
        handlerMeasuringState();
        xoXoI xoxoi = this.mBleManager;
        if (xoxoi != null) {
            xoxoi.oxxXoxO();
        }
        xoXoI xoxoi2 = this.mBleManager;
        if (xoxoi2 != null) {
            xoxoi2.IOoo(30, CollectionsKt__CollectionsKt.Oxx0xo(new com.vtrump.vtble.X0IIOO((byte) 3, (byte) 3, (byte) 6, (byte) 15)));
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        xoXoI OOXIxO02 = xoXoI.OOXIxO0();
        this.mBleManager = OOXIxO02;
        if (OOXIxO02 != null) {
            OOXIxO02.xxOXOOoIX("7LKL5L3QEU1JFAGZ");
        }
        xoXoI xoxoi = this.mBleManager;
        if (xoxoi != null) {
            xoxoi.O0IxXx(this);
        }
        try {
            xoXoI xoxoi2 = this.mBleManager;
            if (xoxoi2 != null) {
                xoxoi2.XOxxooXI(this);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        String string;
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.measure_weight);
        getAbhTitleRight().setImageResource(R.drawable.ic_confirm);
        PFMedium tvGreet = getTvGreet();
        int hours = new Date().getHours();
        if (6 <= hours && hours < 11) {
            string = getString(R.string.greet_good_morning);
        } else {
            int hours2 = new Date().getHours();
            if (11 <= hours2 && hours2 < 13) {
                string = getString(R.string.greet_good_nooning);
            } else {
                int hours3 = new Date().getHours();
                if (13 <= hours3 && hours3 < 19) {
                    string = getString(R.string.greet_good_afternoon);
                } else {
                    string = getString(R.string.greet_good_evening);
                }
            }
        }
        tvGreet.setText(string);
        getBtnMeasureWeight().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.status.I0Io
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BodyFatScaleActivity.initView$lambda$0(BodyFatScaleActivity.this, view);
            }
        });
        handlerNoMeasureState();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_body_fat_scale;
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        xoXoI xoxoi = this.mBleManager;
        if (xoxoi != null) {
            xoxoi.XIXIxO();
        }
    }

    @Override // com.vtrump.vtble.xoXoI.II0xO0
    public void onDeviceAdvDiscovered(@OXOo.oOoXoXO VTDevice vTDevice) {
        LogUtils.d("onDeviceAdvDiscovered " + vTDevice);
        IIX0o.x0XOIxOo(vTDevice, "null cannot be cast to non-null type com.vtrump.vtble.VTDeviceScale");
        o00 o00Var = (o00) vTDevice;
        this.mVtDeviceScale = o00Var;
        if (o00Var != null) {
            o00Var.Ioxxx(this.listener);
        }
    }

    @Override // com.vtrump.vtble.xoXoI.II0xO0
    public void onDeviceConnected(@OXOo.oOoXoXO VTDevice vTDevice) {
        LogUtils.d("onDeviceConnected " + vTDevice);
        handlerNoMeasureState();
    }

    @Override // com.vtrump.vtble.xoXoI.II0xO0
    public void onDeviceDisconnected(@OXOo.oOoXoXO VTDevice vTDevice) {
        LogUtils.d("onDeviceDisconnected " + vTDevice);
        handlerUnconnectState();
    }

    @Override // com.vtrump.vtble.xoXoI.II0xO0
    public void onDeviceDiscovered(@OXOo.oOoXoXO VTDevice vTDevice, int i) {
        LogUtils.d("onDeviceDiscovered  " + vTDevice + "  -- " + i);
    }

    @Override // com.vtrump.vtble.xoXoI.II0xO0
    public void onDeviceServiceDiscovered(@OXOo.oOoXoXO VTDevice vTDevice) {
        LogUtils.d("onDeviceServiceDiscovered " + vTDevice);
        IIX0o.x0XOIxOo(vTDevice, "null cannot be cast to non-null type com.vtrump.vtble.VTDeviceScale");
        o00 o00Var = (o00) vTDevice;
        this.mVtDeviceScale = o00Var;
        if (o00Var != null) {
            o00Var.Ioxxx(this.listener);
        }
    }

    @Override // com.vtrump.vtble.xoXoI.II0xO0
    public void onInited() {
        LogUtils.d("onInited");
    }

    @Override // com.vtrump.vtble.xoXoI.II0xO0
    public void onScanStop() {
        LogUtils.d("onScanStop");
    }

    @Override // com.vtrump.vtble.xoXoI.II0xO0
    public void onScanTimeOut() {
        LogUtils.d("onScanTimeOut");
        handlerMeasureTimeoutState();
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        if (this.isDone) {
            if (this.mSaveTipPopup == null) {
                XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this, 0, 2, null);
                xoI0Ixx0.IoOoX(R.string.save_weight_tip);
                xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.give_up), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.status.BodyFatScaleActivity$onTitleLeftClick$1$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        BodyFatScaleActivity.this.finish();
                        return Boolean.TRUE;
                    }
                });
                xoI0Ixx0.x0o(R.string.save, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.status.BodyFatScaleActivity$onTitleLeftClick$1$2
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        BodyFatScaleActivity.this.save();
                        return Boolean.TRUE;
                    }
                });
                this.mSaveTipPopup = xoI0Ixx0;
            }
            XoI0Ixx0 xoI0Ixx02 = this.mSaveTipPopup;
            if (xoI0Ixx02 != null) {
                View rootView = getRootView();
                IIX0o.oO(rootView, "<get-rootView>(...)");
                xoI0Ixx02.OxxIIOOXO(rootView);
                return;
            }
            return;
        }
        finish();
    }

    public void onTitleRightClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        save();
    }

    public final void permissionRemind() {
        if (this.mPermissionPopup == null) {
            XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.permission_set_remind);
            XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.settings, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.status.BodyFatScaleActivity$permissionRemind$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    PermissionUtils.launchAppDetailsSettings();
                    return Boolean.TRUE;
                }
            });
            this.mPermissionPopup = xoI0Ixx0;
        }
        XoI0Ixx0 xoI0Ixx02 = this.mPermissionPopup;
        if (xoI0Ixx02 != null) {
            View rootView = getRootView();
            IIX0o.oO(rootView, "<get-rootView>(...)");
            xoI0Ixx02.OxxIIOOXO(rootView);
        }
    }
}
