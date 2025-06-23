package com.sma.smartv3.ui.sport.course;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.base.BaseFragment;
import com.bestmafen.androidbase.extension.PermissionStatus;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.WorkoutDao;
import com.sma.smartv3.db.entity.Workout;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.CourseList;
import com.sma.smartv3.pop.XoI0Ixx0;
import com.sma.smartv3.ui.me.GoalSettingActivity;
import com.sma.smartv3.ui.sport.SportGoalSetActivity;
import com.sma.smartv3.ui.sport.SportOnGoingGpsActivity;
import com.sma.smartv3.ui.sport.SportSettingActivity;
import com.sma.smartv3.ui.status.SportRecordsActivity;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.permission.PermissionHelper;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import com.szabh.smable3.component.BleConnector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nBaseSportV2Fragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseSportV2Fragment.kt\ncom/sma/smartv3/ui/sport/course/BaseSportV2Fragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n*L\n1#1,219:1\n19#2:220\n15#2:221\n19#2:222\n15#2:223\n50#2,3:226\n53#2:232\n55#2,2:234\n1855#3,2:224\n1549#3:229\n1620#3,2:230\n1622#3:233\n1#4:236\n1#4:240\n1#4:249\n1#4:258\n1#4:271\n1#4:286\n78#5,3:237\n81#5,5:241\n78#5,3:246\n81#5,5:250\n78#5,3:255\n81#5,5:259\n99#5,7:264\n106#5,3:272\n79#5,7:275\n109#5:282\n78#5,3:283\n81#5,5:287\n*S KotlinDebug\n*F\n+ 1 BaseSportV2Fragment.kt\ncom/sma/smartv3/ui/sport/course/BaseSportV2Fragment\n*L\n80#1:220\n80#1:221\n160#1:222\n160#1:223\n185#1:226,3\n185#1:232\n185#1:234,2\n162#1:224,2\n185#1:229\n185#1:230,2\n185#1:233\n92#1:240\n95#1:249\n98#1:258\n117#1:271\n121#1:286\n92#1:237,3\n92#1:241,5\n95#1:246,3\n95#1:250,5\n98#1:255,3\n98#1:259,5\n117#1:264,7\n117#1:272,3\n117#1:275,7\n117#1:282\n121#1:283,3\n121#1:287,5\n*E\n"})
/* loaded from: classes12.dex */
public abstract class BaseSportV2Fragment extends BaseFragment {

    @OXOo.oOoXoXO
    private List<CourseList> mCourseList;

    @OXOo.oOoXoXO
    private XoI0Ixx0 mLocationServerPopup;
    private int mSportMode;

    @OXOo.OOXIXo
    private final X0IIOO mWorkoutDao$delegate;

    @OXOo.OOXIXo
    private AppUser userProfile;

    @OXOo.OOXIXo
    private final X0IIOO root_view$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.sport.course.BaseSportV2Fragment$root_view$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            View mView;
            mView = BaseSportV2Fragment.this.getMView();
            return (RelativeLayout) mView.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO ivGpsSignal$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.course.BaseSportV2Fragment$ivGpsSignal$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            View mView;
            mView = BaseSportV2Fragment.this.getMView();
            return (ImageView) mView.findViewById(R.id.ivGpsSignal);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO distanceNow$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.sport.course.BaseSportV2Fragment$distanceNow$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = BaseSportV2Fragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.distanceNow);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO distanceUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.course.BaseSportV2Fragment$distanceUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = BaseSportV2Fragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.nowGoalUnit);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO gpsLl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.course.BaseSportV2Fragment$gpsLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = BaseSportV2Fragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.gpsLl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO cumulativeRunningLl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.course.BaseSportV2Fragment$cumulativeRunningLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = BaseSportV2Fragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.cumulativeRunningLl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportSet$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.course.BaseSportV2Fragment$sportSet$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = BaseSportV2Fragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.sportSet);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportHot$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.course.BaseSportV2Fragment$sportHot$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            View mView;
            mView = BaseSportV2Fragment.this.getMView();
            return (ImageView) mView.findViewById(R.id.sportHot);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecommendationCourse$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.course.BaseSportV2Fragment$sportRecommendationCourse$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = BaseSportV2Fragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.sportRecommendationCourse);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportStart$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageButton>() { // from class: com.sma.smartv3.ui.sport.course.BaseSportV2Fragment$sportStart$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageButton invoke() {
            View mView;
            mView = BaseSportV2Fragment.this.getMView();
            return (ImageButton) mView.findViewById(R.id.sportStart);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportGoalSet$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.course.BaseSportV2Fragment$sportGoalSet$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            View mView;
            mView = BaseSportV2Fragment.this.getMView();
            return (ImageView) mView.findViewById(R.id.sportGoalSet);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mRecyclerView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.sport.course.BaseSportV2Fragment$mRecyclerView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            View mView;
            mView = BaseSportV2Fragment.this.getMView();
            return (RecyclerView) mView.findViewById(R.id.sportRecommendationRecycler);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO ivBg$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.course.BaseSportV2Fragment$ivBg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            View mView;
            mView = BaseSportV2Fragment.this.getMView();
            return (ImageView) mView.findViewById(R.id.iv_bg);
        }
    });

    public BaseSportV2Fragment() {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.userProfile = (AppUser) (fromJson != null ? fromJson : appUser);
        this.mWorkoutDao$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WorkoutDao>() { // from class: com.sma.smartv3.ui.sport.course.BaseSportV2Fragment$mWorkoutDao$2
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
    public static final void initView$lambda$0(BaseSportV2Fragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.getActivity(), (Class<?>) GoalSettingActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(BaseSportV2Fragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.getActivity(), (Class<?>) SportSettingActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(BaseSportV2Fragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.getActivity(), (Class<?>) AllCourseActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(BaseSportV2Fragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        StringBuilder sb = new StringBuilder();
        sb.append("startSport2");
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
    public static final void initView$lambda$4(BaseSportV2Fragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
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
    public static final void initView$lambda$5(BaseSportV2Fragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.getActivity(), (Class<?>) SportRecordsActivity.class));
    }

    private final void onStartSport() {
        if (!UtilsKt.oo()) {
            locationServerRemind();
        } else if (ProductManager.f20544oIX0oI.IXxOIOO(this.mSportMode)) {
            PermissionHelper.oOoXoXO(PermissionHelper.f24522oIX0oI, getMActivity(), false, false, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.BaseSportV2Fragment$onStartSport$1
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
                        BaseSportV2Fragment.this.startSport();
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
        IIX0o.oO(permission, "permission(...)");
        String string = getString(R.string.activity_explain_title);
        IIX0o.oO(string, "getString(...)");
        String string2 = getString(R.string.activity_explain_content);
        IIX0o.oO(string2, "getString(...)");
        oOXoIIIo.X0o0xo.II0xO0(permission, string, string2, new Oox.oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.BaseSportV2Fragment$startSport$1
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
                BaseSportV2Fragment baseSportV2Fragment = BaseSportV2Fragment.this;
                int mSportMode = baseSportV2Fragment.getMSportMode();
                Bundle bundle = new Bundle();
                bundle.putString("mArg0", null);
                bundle.putInt("mArg1", mSportMode);
                bundle.putParcelable("mArg2", null);
                bundle.putSerializable("mArg3", null);
                Intent intent = new Intent(baseSportV2Fragment.getActivity(), (Class<?>) SportOnGoingGpsActivity.class);
                intent.putExtras(bundle);
                baseSportV2Fragment.startActivity(intent);
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

    public final RecyclerView getMRecyclerView() {
        return (RecyclerView) this.mRecyclerView$delegate.getValue();
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

    public final ImageView getSportHot() {
        return (ImageView) this.sportHot$delegate.getValue();
    }

    public final PFMedium getSportRecommendationCourse() {
        return (PFMedium) this.sportRecommendationCourse$delegate.getValue();
    }

    public final PFMedium getSportSet() {
        return (PFMedium) this.sportSet$delegate.getValue();
    }

    public final ImageButton getSportStart() {
        return (ImageButton) this.sportStart$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    public final void initRecyclerView() {
        Collection ooXIXxIX2;
        try {
            JsonArray asJsonArray = JsonParser.parseString(Xo0.f24349oIX0oI.XO().getString(com.sma.smartv3.util.XoI0Ixx0.f24377O0)).getAsJsonArray();
            IIX0o.ooOOo0oXI(asJsonArray);
            ooXIXxIX2 = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                ooXIXxIX2.add(new Gson().fromJson(it.next(), CourseList.class));
            }
        } catch (Exception unused) {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        this.mCourseList = CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
        getMRecyclerView().setAdapter(new BaseSportV2Fragment$initRecyclerView$mAdapter$1(this, requireActivity(), this.mCourseList));
    }

    public void initView() {
        getSportSet().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.course.X0o0xo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSportV2Fragment.initView$lambda$0(BaseSportV2Fragment.this, view);
            }
        });
        getSportHot().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.course.XO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSportV2Fragment.initView$lambda$1(BaseSportV2Fragment.this, view);
            }
        });
        getSportRecommendationCourse().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.course.Oxx0IOOO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSportV2Fragment.initView$lambda$2(BaseSportV2Fragment.this, view);
            }
        });
        getMRecyclerView().setLayoutManager(new LinearLayoutManager(requireActivity()));
        initRecyclerView();
        getSportStart().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.course.II0XooXoX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSportV2Fragment.initView$lambda$3(BaseSportV2Fragment.this, view);
            }
        });
        getSportGoalSet().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.course.xxIXOIIO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSportV2Fragment.initView$lambda$4(BaseSportV2Fragment.this, view);
            }
        });
        getCumulativeRunningLl().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.course.xoIox
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSportV2Fragment.initView$lambda$5(BaseSportV2Fragment.this, view);
            }
        });
        showDistance(new Object());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_gps_sport_v2;
    }

    public final void locationServerRemind() {
        if (this.mLocationServerPopup == null) {
            XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(getMActivity(), 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.location_server_notification);
            XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.settings, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.sport.course.BaseSportV2Fragment$locationServerRemind$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    BaseSportV2Fragment.this.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 6);
                    return Boolean.TRUE;
                }
            });
            this.mLocationServerPopup = xoI0Ixx0;
        }
        ToastUtils.showLong(R.string.no_location_authorization_key);
        XoI0Ixx0 xoI0Ixx02 = this.mLocationServerPopup;
        if (xoI0Ixx02 != null) {
            xoI0Ixx02.oI0IIXIo(R.id.root_view);
        }
    }

    public final void setMSportMode(int i) {
        this.mSportMode = i;
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24605X0o0xo)
    public final void showDistance(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
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
        getDistanceNow().setText(String.valueOf(TextConvertKt.ooOOo0oXI(i, this.userProfile.getUnit(), false, 4, null)));
        getDistanceUnit().setText(getString(TextConvertKt.oI0IIXIo(this.userProfile.getUnit())));
    }

    @XO0.XO(tag = "刷新页面")
    public final void showRecyclerViewData(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        initRecyclerView();
    }
}
