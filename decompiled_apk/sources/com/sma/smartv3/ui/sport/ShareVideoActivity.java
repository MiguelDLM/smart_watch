package com.sma.smartv3.ui.sport;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.bestmafen.androidbase.base.BaseActivity;
import com.bestmafen.androidbase.base.BaseFragment;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.WorkoutDao;
import com.sma.smartv3.db.entity.Workout;

@kotlin.jvm.internal.XX({"SMAP\nShareVideoActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShareVideoActivity.kt\ncom/sma/smartv3/ui/sport/ShareVideoActivity\n+ 2 BaseFragment.kt\ncom/bestmafen/androidbase/base/BaseFragment$Companion\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,39:1\n80#2,9:40\n89#2,3:50\n75#2,3:53\n1#3:49\n*S KotlinDebug\n*F\n+ 1 ShareVideoActivity.kt\ncom/sma/smartv3/ui/sport/ShareVideoActivity\n*L\n19#1:40,9\n19#1:50,3\n19#1:53,3\n19#1:49\n*E\n"})
/* loaded from: classes12.dex */
public final class ShareVideoActivity extends BaseActivity {
    private Workout mWorkout;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mWorkoutDao$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WorkoutDao>() { // from class: com.sma.smartv3.ui.sport.ShareVideoActivity$mWorkoutDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final WorkoutDao invoke() {
            return MyDb.INSTANCE.getMDatabase().workoutDao();
        }
    });
    private SportDetailVideoMapFragment sportDetailMapFragment;

    private final WorkoutDao getMWorkoutDao() {
        return (WorkoutDao) this.mWorkoutDao$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        this.mWorkout = getMWorkoutDao().getWorkoutById(getMArg1());
        BaseFragment.oIX0oI oix0oi = BaseFragment.Companion;
        int mArg1 = getMArg1();
        Workout workout = this.mWorkout;
        if (workout == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout = null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("mArg0", null);
        bundle2.putInt("mArg1", mArg1);
        bundle2.putParcelable("mArg2", null);
        bundle2.putSerializable("mArg3", workout);
        BaseFragment baseFragment = (BaseFragment) SportDetailVideoMapFragment.class.newInstance();
        baseFragment.setArguments(bundle2);
        this.sportDetailMapFragment = (SportDetailVideoMapFragment) baseFragment;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        SportDetailVideoMapFragment sportDetailVideoMapFragment = this.sportDetailMapFragment;
        if (sportDetailVideoMapFragment == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("sportDetailMapFragment");
            sportDetailVideoMapFragment = null;
        }
        beginTransaction.replace(R.id.sport_detail_v2_map_fragment, sportDetailVideoMapFragment).commit();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_share_map_to_viedeo;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
