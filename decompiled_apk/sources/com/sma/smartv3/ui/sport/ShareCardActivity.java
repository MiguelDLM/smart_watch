package com.sma.smartv3.ui.sport;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.bestmafen.androidbase.base.BaseFragment;
import com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity;
import com.google.android.material.tabs.TabLayout;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.LocationDao;
import com.sma.smartv3.db.dao.WorkoutDao;
import com.sma.smartv3.db.entity.Location;
import com.sma.smartv3.db.entity.Workout;
import com.sma.smartv3.view.text.PFMedium;
import java.util.ArrayList;
import java.util.List;

@kotlin.jvm.internal.XX({"SMAP\nShareCardActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShareCardActivity.kt\ncom/sma/smartv3/ui/sport/ShareCardActivity\n+ 2 BaseFragment.kt\ncom/bestmafen/androidbase/base/BaseFragment$Companion\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,143:1\n80#2,9:144\n89#2,3:154\n75#2,3:157\n80#2,9:160\n89#2,3:170\n75#2,3:173\n80#2,9:176\n89#2,3:186\n75#2,3:189\n80#2,9:192\n89#2,3:202\n75#2,3:205\n80#2,9:208\n89#2,3:218\n75#2,3:221\n80#2,9:224\n89#2,3:234\n75#2,3:237\n80#2,9:240\n89#2,3:250\n75#2,3:253\n1#3:153\n1#3:169\n1#3:185\n1#3:201\n1#3:217\n1#3:233\n1#3:249\n37#4,2:256\n*S KotlinDebug\n*F\n+ 1 ShareCardActivity.kt\ncom/sma/smartv3/ui/sport/ShareCardActivity\n*L\n47#1:144,9\n47#1:154,3\n47#1:157,3\n48#1:160,9\n48#1:170,3\n48#1:173,3\n49#1:176,9\n49#1:186,3\n49#1:189,3\n50#1:192,9\n50#1:202,3\n50#1:205,3\n52#1:208,9\n52#1:218,3\n52#1:221,3\n53#1:224,9\n53#1:234,3\n53#1:237,3\n54#1:240,9\n54#1:250,3\n54#1:253,3\n47#1:153\n48#1:169\n49#1:185\n50#1:201\n52#1:217\n53#1:233\n54#1:249\n114#1:256,2\n*E\n"})
/* loaded from: classes12.dex */
public final class ShareCardActivity extends BaseFragmentPagerActivity implements ViewPager.OnPageChangeListener {
    private DetailCaloriesCardFragment mDetailCaloriesCardFragment;
    private DetailCustomizeCardFragment mDetailCustomizeCardFragment;
    private DetailDataCardFragment mDetailDataCardFragment;
    private DetailMapCardFragment mDetailMapCardFragment;
    private DetailRouteCardFragment mDetailRouteCardFragment;
    private Workout mWorkout;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO table$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TabLayout>() { // from class: com.sma.smartv3.ui.sport.ShareCardActivity$table$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TabLayout invoke() {
            return (TabLayout) ShareCardActivity.this.findViewById(R.id.table);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleCenter$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.ShareCardActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) ShareCardActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.ShareCardActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) ShareCardActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mLocationDao$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LocationDao>() { // from class: com.sma.smartv3.ui.sport.ShareCardActivity$mLocationDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final LocationDao invoke() {
            return MyDb.INSTANCE.getMDatabase().locationDao();
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mWorkoutDao$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WorkoutDao>() { // from class: com.sma.smartv3.ui.sport.ShareCardActivity$mWorkoutDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final WorkoutDao invoke() {
            return MyDb.INSTANCE.getMDatabase().workoutDao();
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

    public final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    public final TabLayout getTable() {
        return (TabLayout) this.table$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        boolean z;
        this.mWorkout = getMWorkoutDao().getWorkoutById(getMArg1());
        LocationDao mLocationDao = getMLocationDao();
        Workout workout = this.mWorkout;
        if (workout == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout = null;
        }
        long mStart = workout.getMStart();
        Workout workout2 = this.mWorkout;
        if (workout2 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout2 = null;
        }
        List<Location> location = mLocationDao.getLocation(mStart, workout2.getMEnd());
        if (!location.isEmpty() && location.size() >= 2) {
            z = false;
        } else {
            z = true;
        }
        this.isLocationEmpty = z;
        if (!z) {
            BaseFragment.oIX0oI oix0oi = BaseFragment.Companion;
            Workout workout3 = this.mWorkout;
            if (workout3 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
                workout3 = null;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("mArg0", null);
            bundle2.putParcelable("mArg2", null);
            bundle2.putSerializable("mArg3", workout3);
            BaseFragment baseFragment = (BaseFragment) DetailMapCardFragment.class.newInstance();
            baseFragment.setArguments(bundle2);
            this.mDetailMapCardFragment = (DetailMapCardFragment) baseFragment;
            Workout workout4 = this.mWorkout;
            if (workout4 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
                workout4 = null;
            }
            Bundle bundle3 = new Bundle();
            bundle3.putString("mArg0", null);
            bundle3.putParcelable("mArg2", null);
            bundle3.putSerializable("mArg3", workout4);
            BaseFragment baseFragment2 = (BaseFragment) DetailCaloriesCardFragment.class.newInstance();
            baseFragment2.setArguments(bundle3);
            this.mDetailCaloriesCardFragment = (DetailCaloriesCardFragment) baseFragment2;
            Workout workout5 = this.mWorkout;
            if (workout5 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
                workout5 = null;
            }
            Bundle bundle4 = new Bundle();
            bundle4.putString("mArg0", null);
            bundle4.putParcelable("mArg2", null);
            bundle4.putSerializable("mArg3", workout5);
            BaseFragment baseFragment3 = (BaseFragment) DetailRouteCardFragment.class.newInstance();
            baseFragment3.setArguments(bundle4);
            this.mDetailRouteCardFragment = (DetailRouteCardFragment) baseFragment3;
            Workout workout6 = this.mWorkout;
            if (workout6 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
                workout6 = null;
            }
            Bundle bundle5 = new Bundle();
            bundle5.putString("mArg0", null);
            bundle5.putParcelable("mArg2", null);
            bundle5.putSerializable("mArg3", workout6);
            BaseFragment baseFragment4 = (BaseFragment) DetailCustomizeCardFragment.class.newInstance();
            baseFragment4.setArguments(bundle5);
            this.mDetailCustomizeCardFragment = (DetailCustomizeCardFragment) baseFragment4;
            return;
        }
        BaseFragment.oIX0oI oix0oi2 = BaseFragment.Companion;
        Workout workout7 = this.mWorkout;
        if (workout7 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout7 = null;
        }
        Bundle bundle6 = new Bundle();
        bundle6.putString("mArg0", null);
        bundle6.putParcelable("mArg2", null);
        bundle6.putSerializable("mArg3", workout7);
        BaseFragment baseFragment5 = (BaseFragment) DetailDataCardFragment.class.newInstance();
        baseFragment5.setArguments(bundle6);
        this.mDetailDataCardFragment = (DetailDataCardFragment) baseFragment5;
        Workout workout8 = this.mWorkout;
        if (workout8 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout8 = null;
        }
        Bundle bundle7 = new Bundle();
        bundle7.putString("mArg0", null);
        bundle7.putParcelable("mArg2", null);
        bundle7.putSerializable("mArg3", workout8);
        BaseFragment baseFragment6 = (BaseFragment) DetailCaloriesCardFragment.class.newInstance();
        baseFragment6.setArguments(bundle7);
        this.mDetailCaloriesCardFragment = (DetailCaloriesCardFragment) baseFragment6;
        Workout workout9 = this.mWorkout;
        if (workout9 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout9 = null;
        }
        Bundle bundle8 = new Bundle();
        bundle8.putString("mArg0", null);
        bundle8.putParcelable("mArg2", null);
        bundle8.putSerializable("mArg3", workout9);
        BaseFragment baseFragment7 = (BaseFragment) DetailCustomizeCardFragment.class.newInstance();
        baseFragment7.setArguments(bundle8);
        this.mDetailCustomizeCardFragment = (DetailCustomizeCardFragment) baseFragment7;
    }

    @Override // com.bestmafen.androidbase.viewpager.oIX0oI
    @OXOo.OOXIXo
    public List<Fragment> initFragments() {
        ArrayList arrayList = new ArrayList();
        DetailCustomizeCardFragment detailCustomizeCardFragment = null;
        if (!this.isLocationEmpty) {
            DetailMapCardFragment detailMapCardFragment = this.mDetailMapCardFragment;
            if (detailMapCardFragment == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mDetailMapCardFragment");
                detailMapCardFragment = null;
            }
            arrayList.add(detailMapCardFragment);
            DetailCaloriesCardFragment detailCaloriesCardFragment = this.mDetailCaloriesCardFragment;
            if (detailCaloriesCardFragment == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mDetailCaloriesCardFragment");
                detailCaloriesCardFragment = null;
            }
            arrayList.add(detailCaloriesCardFragment);
            DetailRouteCardFragment detailRouteCardFragment = this.mDetailRouteCardFragment;
            if (detailRouteCardFragment == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mDetailRouteCardFragment");
                detailRouteCardFragment = null;
            }
            arrayList.add(detailRouteCardFragment);
            DetailCustomizeCardFragment detailCustomizeCardFragment2 = this.mDetailCustomizeCardFragment;
            if (detailCustomizeCardFragment2 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mDetailCustomizeCardFragment");
            } else {
                detailCustomizeCardFragment = detailCustomizeCardFragment2;
            }
            arrayList.add(detailCustomizeCardFragment);
        } else {
            DetailDataCardFragment detailDataCardFragment = this.mDetailDataCardFragment;
            if (detailDataCardFragment == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mDetailDataCardFragment");
                detailDataCardFragment = null;
            }
            arrayList.add(detailDataCardFragment);
            DetailCaloriesCardFragment detailCaloriesCardFragment2 = this.mDetailCaloriesCardFragment;
            if (detailCaloriesCardFragment2 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mDetailCaloriesCardFragment");
                detailCaloriesCardFragment2 = null;
            }
            arrayList.add(detailCaloriesCardFragment2);
            DetailCustomizeCardFragment detailCustomizeCardFragment3 = this.mDetailCustomizeCardFragment;
            if (detailCustomizeCardFragment3 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mDetailCustomizeCardFragment");
            } else {
                detailCustomizeCardFragment = detailCustomizeCardFragment3;
            }
            arrayList.add(detailCustomizeCardFragment);
        }
        return arrayList;
    }

    @Override // com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity, com.bestmafen.androidbase.base.oIX0oI
    @SuppressLint({"SuspiciousIndentation"})
    public void initView() {
        super.initView();
        getAbhTitleCenter().setText(getString(R.string.share));
        ArrayList arrayList = new ArrayList();
        if (!this.isLocationEmpty) {
            String string = getString(R.string.map);
            kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
            arrayList.add(string);
            String string2 = getString(R.string.calories);
            kotlin.jvm.internal.IIX0o.oO(string2, "getString(...)");
            arrayList.add(string2);
            String string3 = getString(R.string.route);
            kotlin.jvm.internal.IIX0o.oO(string3, "getString(...)");
            arrayList.add(string3);
            String string4 = getString(R.string.eq_user);
            kotlin.jvm.internal.IIX0o.oO(string4, "getString(...)");
            arrayList.add(string4);
        } else {
            String string5 = getString(R.string.data);
            kotlin.jvm.internal.IIX0o.oO(string5, "getString(...)");
            arrayList.add(string5);
            String string6 = getString(R.string.calories);
            kotlin.jvm.internal.IIX0o.oO(string6, "getString(...)");
            arrayList.add(string6);
            String string7 = getString(R.string.eq_user);
            kotlin.jvm.internal.IIX0o.oO(string7, "getString(...)");
            arrayList.add(string7);
        }
        getMFragmentPagerAdapter().setTitles((CharSequence[]) arrayList.toArray(new String[0]));
        getTable().setBackgroundColor(oIxOXo.oxoX.I0Io(getMContext(), R.color.view_page_tablayout_bg));
        getTable().setupWithViewPager(getMViewPager());
        getMViewPager().addOnPageChangeListener(this);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_share_map_card;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment fragment = null;
        if (!this.isLocationEmpty) {
            if (getMViewPager().getCurrentItem() == 2) {
                DetailRouteCardFragment detailRouteCardFragment = this.mDetailRouteCardFragment;
                if (detailRouteCardFragment == null) {
                    kotlin.jvm.internal.IIX0o.XOxIOxOx("mDetailRouteCardFragment");
                } else {
                    fragment = detailRouteCardFragment;
                }
                fragment.onActivityResult(i, i2, intent);
                return;
            }
            if (getMViewPager().getCurrentItem() == 3) {
                DetailCustomizeCardFragment detailCustomizeCardFragment = this.mDetailCustomizeCardFragment;
                if (detailCustomizeCardFragment == null) {
                    kotlin.jvm.internal.IIX0o.XOxIOxOx("mDetailCustomizeCardFragment");
                } else {
                    fragment = detailCustomizeCardFragment;
                }
                fragment.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        if (getMViewPager().getCurrentItem() == 1) {
            DetailDataCardFragment detailDataCardFragment = this.mDetailDataCardFragment;
            if (detailDataCardFragment == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mDetailDataCardFragment");
            } else {
                fragment = detailDataCardFragment;
            }
            fragment.onActivityResult(i, i2, intent);
            return;
        }
        if (getMViewPager().getCurrentItem() == 2) {
            DetailCustomizeCardFragment detailCustomizeCardFragment2 = this.mDetailCustomizeCardFragment;
            if (detailCustomizeCardFragment2 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mDetailCustomizeCardFragment");
            } else {
                fragment = detailCustomizeCardFragment2;
            }
            fragment.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i == 2 && !this.isLocationEmpty) {
            DetailRouteCardFragment detailRouteCardFragment = this.mDetailRouteCardFragment;
            if (detailRouteCardFragment == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mDetailRouteCardFragment");
                detailRouteCardFragment = null;
            }
            detailRouteCardFragment.getSnapShot();
        }
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
