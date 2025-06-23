package com.sma.smartv3.ui.sport;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.bestmafen.androidbase.base.BaseActivity;
import com.bestmafen.androidbase.base.BaseFragment;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.LocationDao;
import com.sma.smartv3.db.dao.WorkoutDao;
import com.sma.smartv3.db.entity.Location;
import com.sma.smartv3.db.entity.Workout;
import com.sma.smartv3.model.CustomLatLng;
import com.sma.smartv3.model.EvaluationKt;
import com.sma.smartv3.ui.sport.course.model.SportDetailViewModel;
import com.sma.smartv3.view.text.PFMedium;
import java.util.ArrayList;
import java.util.List;
import kotlin.oXIO0o0XI;

@kotlin.jvm.internal.XX({"SMAP\nSportDetailV2Activity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportDetailV2Activity.kt\ncom/sma/smartv3/ui/sport/SportDetailV2Activity\n+ 2 BaseFragment.kt\ncom/bestmafen/androidbase/base/BaseFragment$Companion\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,211:1\n80#2,9:212\n89#2,3:222\n75#2,3:225\n80#2,9:228\n89#2,3:238\n75#2,3:241\n1#3:221\n1#3:237\n*S KotlinDebug\n*F\n+ 1 SportDetailV2Activity.kt\ncom/sma/smartv3/ui/sport/SportDetailV2Activity\n*L\n81#1:212,9\n81#1:222,3\n81#1:225,3\n82#1:228,9\n82#1:238,3\n82#1:241,3\n81#1:221\n82#1:237\n*E\n"})
/* loaded from: classes12.dex */
public final class SportDetailV2Activity extends BaseActivity {

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mDeletePopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.oOXoIIIo mEvaluationPopup;
    private Workout mWorkout;
    public SportDetailV2ChartFragment sportDetailChartFragment;
    public SportDetailV2MapFragment sportDetailMapFragment;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleCenter$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2Activity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) SportDetailV2Activity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2Activity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) SportDetailV2Activity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleOtherRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2Activity$abhTitleOtherRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) SportDetailV2Activity.this.findViewById(R.id.abh_title_other_right);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<NestedScrollView>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2Activity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final NestedScrollView invoke() {
            return (NestedScrollView) SportDetailV2Activity.this.findViewById(R.id.root_View);
        }
    });
    private boolean initializationEvaluate = true;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO topPanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2Activity$topPanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return SportDetailV2Activity.this.findViewById(R.id.top_panel);
        }
    });

    @OXOo.OOXIXo
    private final SportDetailViewModel mSportViewModel = (SportDetailViewModel) new ViewModelProvider.NewInstanceFactory().create(SportDetailViewModel.class);

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mWorkoutDao$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WorkoutDao>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2Activity$mWorkoutDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final WorkoutDao invoke() {
            return MyDb.INSTANCE.getMDatabase().workoutDao();
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mLocationDao$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LocationDao>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2Activity$mLocationDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final LocationDao invoke() {
            return MyDb.INSTANCE.getMDatabase().locationDao();
        }
    });
    private boolean isLocationEmpty = true;

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements Observer, kotlin.jvm.internal.XI0IXoo {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Oox.oOoXoXO f23807XO;

        public oIX0oI(Oox.oOoXoXO function) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(function, "function");
            this.f23807XO = function;
        }

        public final boolean equals(@OXOo.oOoXoXO Object obj) {
            if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.XI0IXoo)) {
                return kotlin.jvm.internal.IIX0o.Oxx0IOOO(getFunctionDelegate(), ((kotlin.jvm.internal.XI0IXoo) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.XI0IXoo
        @OXOo.OOXIXo
        public final kotlin.IIXOooo<?> getFunctionDelegate() {
            return this.f23807XO;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f23807XO.invoke(obj);
        }
    }

    private final LocationDao getMLocationDao() {
        return (LocationDao) this.mLocationDao$delegate.getValue();
    }

    private final WorkoutDao getMWorkoutDao() {
        return (WorkoutDao) this.mWorkoutDao$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(SportDetailV2Activity this$0, View view, int i, int i2, int i3, int i4) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (i2 + this$0.getRootView().getHeight() >= this$0.getRootView().getChildAt(0).getMeasuredHeight()) {
            this$0.initializationEvaluateNumber();
        }
    }

    private final void initializationEvaluateNumber() {
        if (this.initializationEvaluate) {
            com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
            int i = xo0.XO().getInt(com.sma.smartv3.util.XoI0Ixx0.f24486xXoOI00O, 0);
            if (i > 1) {
                onShowEvaluationStatus();
            }
            xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24486xXoOI00O, i + 1);
        }
        this.initializationEvaluate = false;
    }

    private final void intiObserve() {
        this.mSportViewModel.getMarkLiveData().observe(this, new oIX0oI(new Oox.oOoXoXO<ArrayList<CustomLatLng>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2Activity$intiObserve$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(ArrayList<CustomLatLng> arrayList) {
                invoke2(arrayList);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<CustomLatLng> arrayList) {
                SportDetailV2MapFragment sportDetailMapFragment = SportDetailV2Activity.this.getSportDetailMapFragment();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(arrayList);
                sportDetailMapFragment.onLoadMarkView(arrayList);
            }
        }));
    }

    private final void showDeletePopup() {
        if (this.mDeletePopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.delete_reminder);
            xoI0Ixx0.xI(Integer.valueOf(R.string.delete_reminder_hint));
            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2Activity$showDeletePopup$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    SportDetailV2Activity.this.sportDetailDelete();
                    SportDetailV2Activity.this.finish();
                    return Boolean.TRUE;
                }
            });
            this.mDeletePopup = xoI0Ixx0;
        }
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = this.mDeletePopup;
        if (xoI0Ixx02 != null) {
            xoI0Ixx02.IIXOooo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sportDetailDelete() {
        StringBuilder sb = new StringBuilder();
        sb.append("detail source ");
        Workout workout = this.mWorkout;
        if (workout == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout = null;
        }
        sb.append(workout.getMSource());
        LogUtils.d(sb.toString());
        Workout workout2 = this.mWorkout;
        if (workout2 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout2 = null;
        }
        workout2.setMIsSync(0);
        Workout workout3 = this.mWorkout;
        if (workout3 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout3 = null;
        }
        workout3.setMIsDelete(1);
        WorkoutDao mWorkoutDao = getMWorkoutDao();
        Workout workout4 = this.mWorkout;
        if (workout4 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout4 = null;
        }
        mWorkoutDao.update(workout4);
        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24642ox, null, 2, null);
    }

    public final PFMedium getAbhTitleCenter() {
        return (PFMedium) this.abhTitleCenter$delegate.getValue();
    }

    public final ImageView getAbhTitleOtherRight() {
        return (ImageView) this.abhTitleOtherRight$delegate.getValue();
    }

    public final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    public final boolean getInitializationEvaluate() {
        return this.initializationEvaluate;
    }

    @OXOo.OOXIXo
    public final SportDetailViewModel getMSportViewModel() {
        return this.mSportViewModel;
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity
    public int getMStatusStyle() {
        return 1;
    }

    public final NestedScrollView getRootView() {
        return (NestedScrollView) this.rootView$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final SportDetailV2ChartFragment getSportDetailChartFragment() {
        SportDetailV2ChartFragment sportDetailV2ChartFragment = this.sportDetailChartFragment;
        if (sportDetailV2ChartFragment != null) {
            return sportDetailV2ChartFragment;
        }
        kotlin.jvm.internal.IIX0o.XOxIOxOx("sportDetailChartFragment");
        return null;
    }

    @OXOo.OOXIXo
    public final SportDetailV2MapFragment getSportDetailMapFragment() {
        SportDetailV2MapFragment sportDetailV2MapFragment = this.sportDetailMapFragment;
        if (sportDetailV2MapFragment != null) {
            return sportDetailV2MapFragment;
        }
        kotlin.jvm.internal.IIX0o.XOxIOxOx("sportDetailMapFragment");
        return null;
    }

    public final View getTopPanel() {
        return (View) this.topPanel$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        boolean z = false;
        Workout workoutById = getMWorkoutDao().getWorkoutById(getMArg1());
        this.mWorkout = workoutById;
        Workout workout = null;
        if (workoutById == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workoutById = null;
        }
        LogUtils.d(String.valueOf(workoutById));
        LocationDao mLocationDao = getMLocationDao();
        Workout workout2 = this.mWorkout;
        if (workout2 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout2 = null;
        }
        long mStart = workout2.getMStart();
        Workout workout3 = this.mWorkout;
        if (workout3 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
        } else {
            workout = workout3;
        }
        List<Location> location = mLocationDao.getLocation(mStart, workout.getMEnd());
        if (location.isEmpty() || location.size() < 2) {
            z = true;
        }
        this.isLocationEmpty = z;
        initFragment();
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    public final void initFragment() {
        BaseFragment.oIX0oI oix0oi = BaseFragment.Companion;
        int mArg1 = getMArg1();
        Workout workout = this.mWorkout;
        if (workout == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout = null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", mArg1);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", workout);
        BaseFragment baseFragment = (BaseFragment) SportDetailV2MapFragment.class.newInstance();
        baseFragment.setArguments(bundle);
        setSportDetailMapFragment((SportDetailV2MapFragment) baseFragment);
        int mArg12 = getMArg1();
        Workout workout2 = this.mWorkout;
        if (workout2 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout2 = null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("mArg0", null);
        bundle2.putInt("mArg1", mArg12);
        bundle2.putParcelable("mArg2", null);
        bundle2.putSerializable("mArg3", workout2);
        BaseFragment baseFragment2 = (BaseFragment) SportDetailV2ChartFragment.class.newInstance();
        baseFragment2.setArguments(bundle2);
        setSportDetailChartFragment((SportDetailV2ChartFragment) baseFragment2);
        intiObserve();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        getAbhTitleCenter().setText(setTitle());
        getAbhTitleRight().setVisibility(0);
        getAbhTitleRight().setImageResource(R.drawable.icon_title_other_right);
        getAbhTitleOtherRight().setVisibility(0);
        getAbhTitleOtherRight().setImageResource(R.drawable.ic_share_v2);
        if (Build.VERSION.SDK_INT >= 23) {
            getRootView().setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.sma.smartv3.ui.sport.Xx000oIo
                @Override // android.view.View.OnScrollChangeListener
                public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    SportDetailV2Activity.initView$lambda$0(SportDetailV2Activity.this, view, i, i2, i3, i4);
                }
            });
        } else {
            initializationEvaluateNumber();
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_sport_detail_v2;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getSupportFragmentManager().beginTransaction().replace(R.id.sport_detail_v2_map_fragment, getSportDetailMapFragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.sport_detail_v2_chart_fragment, getSportDetailChartFragment()).commit();
    }

    public final void onShowEvaluationStatus() {
        com.sma.smartv3.pop.oOXoIIIo ooxoiiio;
        if (EvaluationKt.isShowEvaluationDialog() && getMWorkoutDao().getList().size() >= 2) {
            if (this.mEvaluationPopup == null) {
                this.mEvaluationPopup = new com.sma.smartv3.pop.oOXoIIIo(this, 0, 2, null);
            }
            com.sma.smartv3.pop.oOXoIIIo ooxoiiio2 = this.mEvaluationPopup;
            if ((ooxoiiio2 == null || !ooxoiiio2.isShowing()) && (ooxoiiio = this.mEvaluationPopup) != null) {
                NestedScrollView rootView = getRootView();
                kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                ooxoiiio.xoXoI(rootView);
            }
        }
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public void onTitleRightClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        showDeletePopup();
    }

    public final void onTitleRightOtherClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.util.Oxx0IOOO oxx0IOOO = com.sma.smartv3.util.Oxx0IOOO.f24316oIX0oI;
        View topPanel = getTopPanel();
        kotlin.jvm.internal.IIX0o.oO(topPanel, "<get-topPanel>(...)");
        final Bitmap II0xO02 = oxx0IOOO.II0xO0(topPanel);
        getSportDetailChartFragment().showQCCode(new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2Activity$onTitleRightOtherClick$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(boolean z) {
                SportDetailV2Activity.this.getSportDetailMapFragment().setChartFragmentBitmap(SportDetailV2Activity.this.getSportDetailChartFragment().getBitmap(), SportDetailV2Activity.this.getMArg1());
                SportDetailV2Activity.this.getSportDetailMapFragment().share(II0xO02);
            }
        });
    }

    public final void setInitializationEvaluate(boolean z) {
        this.initializationEvaluate = z;
    }

    public final void setSportDetailChartFragment(@OXOo.OOXIXo SportDetailV2ChartFragment sportDetailV2ChartFragment) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sportDetailV2ChartFragment, "<set-?>");
        this.sportDetailChartFragment = sportDetailV2ChartFragment;
    }

    public final void setSportDetailMapFragment(@OXOo.OOXIXo SportDetailV2MapFragment sportDetailV2MapFragment) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sportDetailV2MapFragment, "<set-?>");
        this.sportDetailMapFragment = sportDetailV2MapFragment;
    }

    @OXOo.OOXIXo
    public final String setTitle() {
        ProductManager productManager = ProductManager.f20544oIX0oI;
        Workout workout = this.mWorkout;
        if (workout == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout = null;
        }
        return productManager.xIXX(workout.getMMode());
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24607XI0oooXX)
    public final void syncDapSportDetailExperience(int i) {
        Workout workout = this.mWorkout;
        Workout workout2 = null;
        if (workout == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout = null;
        }
        workout.setMFeel(i);
        WorkoutDao mWorkoutDao = getMWorkoutDao();
        Workout workout3 = this.mWorkout;
        if (workout3 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
        } else {
            workout2 = workout3;
        }
        mWorkoutDao.update(workout2);
    }
}
