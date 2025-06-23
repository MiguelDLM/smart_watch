package com.sma.smartv3.ui.sport;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.bestmafen.androidbase.base.BaseFragment;
import com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.google.android.material.tabs.TabLayout;
import com.sma.smartv3.biz.fitness_site.FunctionKt;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.LocationDao;
import com.sma.smartv3.db.dao.WorkoutDao;
import com.sma.smartv3.db.entity.Location;
import com.sma.smartv3.db.entity.Workout;
import com.sma.smartv3.db.entity.WorkoutIndex;
import com.sma.smartv3.view.text.PFMedium;
import java.util.ArrayList;
import java.util.List;
import kotlin.oXIO0o0XI;

@kotlin.jvm.internal.XX({"SMAP\nSportDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportDetailActivity.kt\ncom/sma/smartv3/ui/sport/SportDetailActivity\n+ 2 BaseFragment.kt\ncom/bestmafen/androidbase/base/BaseFragment$Companion\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,170:1\n80#2,9:171\n89#2,3:181\n75#2,3:184\n80#2,9:187\n89#2,3:197\n75#2,3:200\n80#2,9:203\n89#2,3:213\n75#2,3:216\n1#3:180\n1#3:196\n1#3:212\n37#4,2:219\n*S KotlinDebug\n*F\n+ 1 SportDetailActivity.kt\ncom/sma/smartv3/ui/sport/SportDetailActivity\n*L\n60#1:171,9\n60#1:181,3\n60#1:184,3\n61#1:187,9\n61#1:197,3\n61#1:200,3\n62#1:203,9\n62#1:213,3\n62#1:216,3\n60#1:180\n61#1:196\n62#1:212\n89#1:219,2\n*E\n"})
/* loaded from: classes12.dex */
public final class SportDetailActivity extends BaseFragmentPagerActivity {
    private Workout mWorkout;
    public SportDetailChartFragment sportDetailChartFragment;
    public SportDetailFragment sportDetailFragment;
    public SportDetailMapFragment sportDetailMapFragment;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO table$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TabLayout>() { // from class: com.sma.smartv3.ui.sport.SportDetailActivity$table$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TabLayout invoke() {
            return (TabLayout) SportDetailActivity.this.findViewById(R.id.table);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleCenter$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.SportDetailActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) SportDetailActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.SportDetailActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) SportDetailActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleOtherRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.SportDetailActivity$abhTitleOtherRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) SportDetailActivity.this.findViewById(R.id.abh_title_other_right);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO topPanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.SportDetailActivity$topPanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return SportDetailActivity.this.findViewById(R.id.top_panel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mWorkoutDao$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WorkoutDao>() { // from class: com.sma.smartv3.ui.sport.SportDetailActivity$mWorkoutDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final WorkoutDao invoke() {
            return MyDb.INSTANCE.getMDatabase().workoutDao();
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mLocationDao$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LocationDao>() { // from class: com.sma.smartv3.ui.sport.SportDetailActivity$mLocationDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final LocationDao invoke() {
            return MyDb.INSTANCE.getMDatabase().locationDao();
        }
    });
    private boolean isLocationEmpty = true;

    private final LocationDao getMLocationDao() {
        return (LocationDao) this.mLocationDao$delegate.getValue();
    }

    private final WorkoutDao getMWorkoutDao() {
        return (WorkoutDao) this.mWorkoutDao$delegate.getValue();
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

    @OXOo.OOXIXo
    public final SportDetailChartFragment getSportDetailChartFragment() {
        SportDetailChartFragment sportDetailChartFragment = this.sportDetailChartFragment;
        if (sportDetailChartFragment != null) {
            return sportDetailChartFragment;
        }
        kotlin.jvm.internal.IIX0o.XOxIOxOx("sportDetailChartFragment");
        return null;
    }

    @OXOo.OOXIXo
    public final SportDetailFragment getSportDetailFragment() {
        SportDetailFragment sportDetailFragment = this.sportDetailFragment;
        if (sportDetailFragment != null) {
            return sportDetailFragment;
        }
        kotlin.jvm.internal.IIX0o.XOxIOxOx("sportDetailFragment");
        return null;
    }

    @OXOo.OOXIXo
    public final SportDetailMapFragment getSportDetailMapFragment() {
        SportDetailMapFragment sportDetailMapFragment = this.sportDetailMapFragment;
        if (sportDetailMapFragment != null) {
            return sportDetailMapFragment;
        }
        kotlin.jvm.internal.IIX0o.XOxIOxOx("sportDetailMapFragment");
        return null;
    }

    public final TabLayout getTable() {
        return (TabLayout) this.table$delegate.getValue();
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

    public final void initFragment() {
        BaseFragment.oIX0oI oix0oi = BaseFragment.Companion;
        Workout workout = this.mWorkout;
        if (workout == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout = null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", workout);
        BaseFragment baseFragment = (BaseFragment) SportDetailMapFragment.class.newInstance();
        baseFragment.setArguments(bundle);
        setSportDetailMapFragment((SportDetailMapFragment) baseFragment);
        Workout workout2 = this.mWorkout;
        if (workout2 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout2 = null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("mArg0", null);
        bundle2.putParcelable("mArg2", null);
        bundle2.putSerializable("mArg3", workout2);
        BaseFragment baseFragment2 = (BaseFragment) SportDetailChartFragment.class.newInstance();
        baseFragment2.setArguments(bundle2);
        setSportDetailChartFragment((SportDetailChartFragment) baseFragment2);
        Workout workout3 = this.mWorkout;
        if (workout3 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout3 = null;
        }
        Bundle bundle3 = new Bundle();
        bundle3.putString("mArg0", null);
        bundle3.putParcelable("mArg2", null);
        bundle3.putSerializable("mArg3", workout3);
        BaseFragment baseFragment3 = (BaseFragment) SportDetailFragment.class.newInstance();
        baseFragment3.setArguments(bundle3);
        setSportDetailFragment((SportDetailFragment) baseFragment3);
    }

    @Override // com.bestmafen.androidbase.viewpager.oIX0oI
    @OXOo.OOXIXo
    public List<Fragment> initFragments() {
        ArrayList arrayList = new ArrayList();
        if (!this.isLocationEmpty) {
            arrayList.add(getSportDetailMapFragment());
        }
        arrayList.add(getSportDetailChartFragment());
        arrayList.add(getSportDetailFragment());
        return arrayList;
    }

    @Override // com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getAbhTitleCenter().setText(setTitle());
        getAbhTitleRight().setVisibility(0);
        getAbhTitleRight().setImageResource(R.drawable.ic_share);
        ArrayList arrayList = new ArrayList();
        if (!this.isLocationEmpty) {
            String string = getString(R.string.track);
            kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
            arrayList.add(string);
        }
        String string2 = getString(R.string.chart);
        kotlin.jvm.internal.IIX0o.oO(string2, "getString(...)");
        arrayList.add(string2);
        String string3 = getString(R.string.detail);
        kotlin.jvm.internal.IIX0o.oO(string3, "getString(...)");
        arrayList.add(string3);
        getMFragmentPagerAdapter().setTitles((CharSequence[]) arrayList.toArray(new String[0]));
        getTable().setBackgroundColor(oIxOXo.oxoX.I0Io(getMContext(), R.color.view_page_tablayout_bg));
        getTable().setupWithViewPager(getMViewPager());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_sport_detail;
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public void onTitleRightClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.util.Oxx0IOOO oxx0IOOO = com.sma.smartv3.util.Oxx0IOOO.f24316oIX0oI;
        View topPanel = getTopPanel();
        kotlin.jvm.internal.IIX0o.oO(topPanel, "<get-topPanel>(...)");
        Bitmap II0xO02 = oxx0IOOO.II0xO0(topPanel);
        if (getSportDetailMapFragment().getUserVisibleHint() && !this.isLocationEmpty) {
            getSportDetailMapFragment().share(II0xO02);
            return;
        }
        if (getSportDetailChartFragment().getUserVisibleHint()) {
            getSportDetailChartFragment().share();
            share(II0xO02);
        } else if (getSportDetailFragment().getUserVisibleHint()) {
            getSportDetailFragment().share();
            share(II0xO02);
        }
    }

    public final void setSportDetailChartFragment(@OXOo.OOXIXo SportDetailChartFragment sportDetailChartFragment) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sportDetailChartFragment, "<set-?>");
        this.sportDetailChartFragment = sportDetailChartFragment;
    }

    public final void setSportDetailFragment(@OXOo.OOXIXo SportDetailFragment sportDetailFragment) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sportDetailFragment, "<set-?>");
        this.sportDetailFragment = sportDetailFragment;
    }

    public final void setSportDetailMapFragment(@OXOo.OOXIXo SportDetailMapFragment sportDetailMapFragment) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sportDetailMapFragment, "<set-?>");
        this.sportDetailMapFragment = sportDetailMapFragment;
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

    public final void share(@OXOo.OOXIXo Bitmap topBitmap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(topBitmap, "topBitmap");
        Bitmap bitmap = ImageUtils.getBitmap(com.sma.smartv3.initializer.IXxxXO.oxXx0IX(X00IoxXI.oIX0oI.f3233oIX0oI));
        Bitmap createBitmap = Bitmap.createBitmap(topBitmap.getWidth(), topBitmap.getHeight() + bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        kotlin.jvm.internal.IIX0o.oO(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(topBitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmap, 0.0f, topBitmap.getHeight(), (Paint) null);
        com.sma.smartv3.util.Oxx0IOOO.f24316oIX0oI.oxoX(this, createBitmap);
    }

    public final void testUploadStrava() {
        Workout workout = this.mWorkout;
        Workout workout2 = null;
        if (workout == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout = null;
        }
        int mMode = workout.getMMode();
        Workout workout3 = this.mWorkout;
        if (workout3 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
        } else {
            workout2 = workout3;
        }
        final WorkoutIndex workoutIndex = new WorkoutIndex(0, 2, workout2.getMEnd(), mMode, 0, 17, null);
        ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<Void>() { // from class: com.sma.smartv3.ui.sport.SportDetailActivity$testUploadStrava$1
            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public void onSuccess(@OXOo.oOoXoXO Void r1) {
            }

            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            @OXOo.oOoXoXO
            public Void doInBackground() {
                Application app = Utils.getApp();
                kotlin.jvm.internal.IIX0o.oO(app, "getApp(...)");
                final WorkoutIndex workoutIndex2 = WorkoutIndex.this;
                FunctionKt.Oxx0IOOO(app, workoutIndex2, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportDetailActivity$testUploadStrava$1$doInBackground$1
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
                            return;
                        }
                        MyDb.INSTANCE.getMDatabase().workoutIndexDao().insert(WorkoutIndex.this);
                    }
                });
                return null;
            }
        });
    }
}
