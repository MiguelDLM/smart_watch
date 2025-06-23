package com.sma.smartv3.ui.sport;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bestmafen.androidbase.base.BaseFragment;
import com.bestmafen.androidbase.extension.PermissionStatus;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.WorkoutDao;
import com.sma.smartv3.db.entity.Workout;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.ui.status.SportRecordsActivity;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.permission.PermissionHelper;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import com.szabh.smable3.component.BleConnector;
import java.util.Iterator;
import kotlin.oXIO0o0XI;

@kotlin.jvm.internal.XX({"SMAP\nBaseSportFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseSportFragment.kt\ncom/sma/smartv3/ui/sport/BaseSportFragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,148:1\n19#2:149\n15#2:150\n19#2:151\n15#2:152\n1855#3,2:153\n78#4,3:155\n81#4,5:159\n99#4,7:164\n106#4,3:172\n79#4,7:175\n109#4:182\n78#4,3:183\n81#4,5:187\n1#5:158\n1#5:171\n1#5:186\n*S KotlinDebug\n*F\n+ 1 BaseSportFragment.kt\ncom/sma/smartv3/ui/sport/BaseSportFragment\n*L\n53#1:149\n53#1:150\n124#1:151\n124#1:152\n126#1:153,2\n64#1:155,3\n64#1:159,5\n81#1:164,7\n81#1:172,3\n81#1:175,7\n81#1:182\n85#1:183,3\n85#1:187,5\n64#1:158\n81#1:171\n85#1:186\n*E\n"})
/* loaded from: classes12.dex */
public abstract class BaseSportFragment extends BaseFragment {

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mLocationServerPopup;
    private int mSportMode;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mWorkoutDao$delegate;

    @OXOo.OOXIXo
    private AppUser userProfile;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO root_view$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.sport.BaseSportFragment$root_view$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            View mView;
            mView = BaseSportFragment.this.getMView();
            return (RelativeLayout) mView.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ivGpsSignal$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.BaseSportFragment$ivGpsSignal$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            View mView;
            mView = BaseSportFragment.this.getMView();
            return (ImageView) mView.findViewById(R.id.ivGpsSignal);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO distanceNow$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.sport.BaseSportFragment$distanceNow$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = BaseSportFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.distanceNow);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO distanceUnit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.BaseSportFragment$distanceUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = BaseSportFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.nowGoalUnit);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO gpsLl$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.BaseSportFragment$gpsLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = BaseSportFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.gpsLl);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO cumulativeRunningLl$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.BaseSportFragment$cumulativeRunningLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = BaseSportFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.cumulativeRunningLl);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO sportSet$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.BaseSportFragment$sportSet$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            View mView;
            mView = BaseSportFragment.this.getMView();
            return (ImageView) mView.findViewById(R.id.sportSet);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO sportStart$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageButton>() { // from class: com.sma.smartv3.ui.sport.BaseSportFragment$sportStart$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageButton invoke() {
            View mView;
            mView = BaseSportFragment.this.getMView();
            return (ImageButton) mView.findViewById(R.id.sportStart);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO sportGoalSet$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.BaseSportFragment$sportGoalSet$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            View mView;
            mView = BaseSportFragment.this.getMView();
            return (ImageView) mView.findViewById(R.id.sportGoalSet);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ivBg$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.BaseSportFragment$ivBg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            View mView;
            mView = BaseSportFragment.this.getMView();
            return (ImageView) mView.findViewById(R.id.iv_bg);
        }
    });

    public BaseSportFragment() {
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.userProfile = (AppUser) (fromJson != null ? fromJson : appUser);
        this.mWorkoutDao$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WorkoutDao>() { // from class: com.sma.smartv3.ui.sport.BaseSportFragment$mWorkoutDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final WorkoutDao invoke() {
                return MyDb.INSTANCE.getMDatabase().workoutDao();
            }
        });
    }

    private final WorkoutDao getMWorkoutDao() {
        return (WorkoutDao) this.mWorkoutDao$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(BaseSportFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.getActivity(), (Class<?>) SportSettingActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(BaseSportFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        StringBuilder sb = new StringBuilder();
        sb.append("startSport");
        BleConnector bleConnector = BleConnector.INSTANCE;
        sb.append(bleConnector.isBound());
        LogUtils.i(sb.toString());
        if (ProductManager.f20544oIX0oI.xIx()) {
            if (BluetoothAdapter.getDefaultAdapter().isEnabled() && bleConnector.isBound()) {
                this$0.onStartSport();
                return;
            } else {
                ToastUtils.showLong(R.string.ble_not_bind);
                return;
            }
        }
        this$0.onStartSport();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(BaseSportFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        int i = this$0.mSportMode;
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", i);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this$0.getActivity(), (Class<?>) SportGoalSetActivity.class);
        intent.putExtras(bundle);
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(BaseSportFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.getActivity(), (Class<?>) SportRecordsActivity.class));
    }

    private final void onStartSport() {
        if (!UtilsKt.oo()) {
            locationServerRemind();
        } else if (ProductManager.f20544oIX0oI.IXxOIOO(this.mSportMode)) {
            PermissionHelper.oOoXoXO(PermissionHelper.f24522oIX0oI, getMActivity(), false, false, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.BaseSportFragment$onStartSport$1
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
                        BaseSportFragment.this.startSport();
                    }
                }
            }, 6, null);
        } else {
            startSport();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startSport() {
        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.ACTIVITY_RECOGNITION);
        kotlin.jvm.internal.IIX0o.oO(permission, "permission(...)");
        String string = getString(R.string.activity_explain_title);
        kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
        String string2 = getString(R.string.activity_explain_content);
        kotlin.jvm.internal.IIX0o.oO(string2, "getString(...)");
        oOXoIIIo.X0o0xo.II0xO0(permission, string, string2, new Oox.oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.BaseSportFragment$startSport$1
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
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                BaseSportFragment baseSportFragment = BaseSportFragment.this;
                int mSportMode = baseSportFragment.getMSportMode();
                Bundle bundle = new Bundle();
                bundle.putString("mArg0", null);
                bundle.putInt("mArg1", mSportMode);
                bundle.putParcelable("mArg2", null);
                bundle.putSerializable("mArg3", null);
                Intent intent = new Intent(baseSportFragment.getActivity(), (Class<?>) SportOnGoingGpsActivity.class);
                intent.putExtras(bundle);
                baseSportFragment.startActivity(intent);
            }
        });
    }

    public final LinearLayout getCumulativeRunningLl() {
        return (LinearLayout) this.cumulativeRunningLl$delegate.getValue();
    }

    public final DINCondBold getDistanceNow() {
        return (DINCondBold) this.distanceNow$delegate.getValue();
    }

    public final PFMedium getDistanceUnit() {
        return (PFMedium) this.distanceUnit$delegate.getValue();
    }

    public final LinearLayout getGpsLl() {
        return (LinearLayout) this.gpsLl$delegate.getValue();
    }

    public final ImageView getIvBg() {
        return (ImageView) this.ivBg$delegate.getValue();
    }

    public final ImageView getIvGpsSignal() {
        return (ImageView) this.ivGpsSignal$delegate.getValue();
    }

    public final int getMSportMode() {
        return this.mSportMode;
    }

    public final RelativeLayout getRoot_view() {
        return (RelativeLayout) this.root_view$delegate.getValue();
    }

    public final ImageView getSportGoalSet() {
        return (ImageView) this.sportGoalSet$delegate.getValue();
    }

    public final ImageView getSportSet() {
        return (ImageView) this.sportSet$delegate.getValue();
    }

    public final ImageButton getSportStart() {
        return (ImageButton) this.sportStart$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    public void initView() {
        getSportSet().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.X0o0xo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSportFragment.initView$lambda$0(BaseSportFragment.this, view);
            }
        });
        getSportStart().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.XO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSportFragment.initView$lambda$1(BaseSportFragment.this, view);
            }
        });
        getSportGoalSet().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.Oxx0IOOO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSportFragment.initView$lambda$2(BaseSportFragment.this, view);
            }
        });
        getCumulativeRunningLl().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.II0XooXoX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSportFragment.initView$lambda$3(BaseSportFragment.this, view);
            }
        });
        showDistance(new Object());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_gps_sport;
    }

    public final void locationServerRemind() {
        if (this.mLocationServerPopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(getMActivity(), 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.location_server_notification);
            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.settings, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.sport.BaseSportFragment$locationServerRemind$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    BaseSportFragment.this.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 6);
                    return Boolean.TRUE;
                }
            });
            this.mLocationServerPopup = xoI0Ixx0;
        }
        ToastUtils.showLong(R.string.no_location_authorization_key);
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = this.mLocationServerPopup;
        if (xoI0Ixx02 != null) {
            xoI0Ixx02.oI0IIXIo(R.id.root_view);
        }
    }

    public final void setMSportMode(int i) {
        this.mSportMode = i;
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24605X0o0xo)
    public final void showDistance(@OXOo.OOXIXo Object data) {
        String valueOf;
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        this.userProfile = (AppUser) appUser;
        Iterator<T> it = getMWorkoutDao().getListByMode(this.mSportMode, 1).iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Workout) it.next()).getMDistance();
        }
        float ooOOo0oXI2 = TextConvertKt.ooOOo0oXI(i, this.userProfile.getUnit(), false, 4, null);
        DINCondBold distanceNow = getDistanceNow();
        if (ooOOo0oXI2 == 0.0f) {
            valueOf = "0";
        } else {
            valueOf = String.valueOf(ooOOo0oXI2);
        }
        distanceNow.setText(valueOf);
        getDistanceUnit().setText(getString(TextConvertKt.oI0IIXIo(this.userProfile.getUnit())));
    }
}
