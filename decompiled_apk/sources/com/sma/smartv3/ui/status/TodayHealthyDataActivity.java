package com.sma.smartv3.ui.status;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.ActivityDao;
import com.sma.smartv3.db.entity.Activity;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.TodayHealthyDataKt;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nTodayHealthyDataActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TodayHealthyDataActivity.kt\ncom/sma/smartv3/ui/status/TodayHealthyDataActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n*L\n1#1,171:1\n19#2:172\n15#2:173\n1#3:174\n1#3:178\n1#3:187\n1#3:196\n1#3:205\n69#4,3:175\n72#4,5:179\n69#4,3:184\n72#4,5:188\n69#4,3:193\n72#4,5:197\n69#4,3:202\n72#4,5:206\n*S KotlinDebug\n*F\n+ 1 TodayHealthyDataActivity.kt\ncom/sma/smartv3/ui/status/TodayHealthyDataActivity\n*L\n59#1:172\n59#1:173\n76#1:178\n79#1:187\n82#1:196\n85#1:205\n76#1:175,3\n76#1:179,5\n79#1:184,3\n79#1:188,5\n82#1:193,3\n82#1:197,5\n85#1:202,3\n85#1:206,5\n*E\n"})
/* loaded from: classes12.dex */
public final class TodayHealthyDataActivity extends BaseActivity {

    @OXOo.OOXIXo
    private final AppUser mAppUser;

    @OXOo.OOXIXo
    private final X0IIOO abhTitleCenter$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.TodayHealthyDataActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) TodayHealthyDataActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mRecyclerView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.status.TodayHealthyDataActivity$mRecyclerView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            return (RecyclerView) TodayHealthyDataActivity.this.findViewById(R.id.status_item_today_health_data);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mStepValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.TodayHealthyDataActivity$mStepValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) TodayHealthyDataActivity.this.findViewById(R.id.ac_today_health_data_steps);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mCalorieValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.TodayHealthyDataActivity$mCalorieValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) TodayHealthyDataActivity.this.findViewById(R.id.ac_today_health_data_calorie);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mSleepValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.TodayHealthyDataActivity$mSleepValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) TodayHealthyDataActivity.this.findViewById(R.id.ac_today_health_data_sleep);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mDistanceValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.TodayHealthyDataActivity$mDistanceValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) TodayHealthyDataActivity.this.findViewById(R.id.ac_today_health_data_distance);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mDistanceUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.TodayHealthyDataActivity$mDistanceUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) TodayHealthyDataActivity.this.findViewById(R.id.ac_today_health_data_distanceUnit);
        }
    });

    @OXOo.OOXIXo
    private final ActivityDao mActivityDao = MyDb.INSTANCE.getMDatabase().activityDao();

    public TodayHealthyDataActivity() {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.mAppUser = (AppUser) (fromJson != null ? fromJson : appUser);
    }

    @RequiresApi(24)
    private final void initData() {
        String string;
        long[] OxI2 = com.sma.smartv3.util.xoIox.OxI(null, TimePeriod.DAY, 0, 5, null);
        Activity activity = this.mActivityDao.getActivity(OxI2[0], OxI2[1]);
        if (activity == null) {
            activity = new Activity(0, 0L, null, 0, 0, 0, 0, 0, 0, 0, 1023, null);
        }
        getMStepValue().setText(String.valueOf(activity.getMStep()));
        getMCalorieValue().setText(String.valueOf(activity.getMCalorie() / 10000));
        getMDistanceValue().setText(TextConvertKt.Oo(activity.getMDistance() / 10000, this.mAppUser.getUnit(), false, 4, null));
        PFMedium mDistanceUnit = getMDistanceUnit();
        if (this.mAppUser.getUnit() == 0) {
            string = getString(R.string.km);
        } else {
            string = getString(R.string.mi);
        }
        mDistanceUnit.setText(string);
        final TodayHealthyDataActivity$initData$mAdapter$1 todayHealthyDataActivity$initData$mAdapter$1 = new TodayHealthyDataActivity$initData$mAdapter$1(this, TodayHealthyDataKt.getItemHealthyData(true, new Oox.oOoXoXO<Integer, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.TodayHealthyDataActivity$initData$list$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num) {
                invoke(num.intValue());
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(int i) {
                android.app.Activity mContext;
                DINCondBold mSleepValue = TodayHealthyDataActivity.this.getMSleepValue();
                IIX0o.oO(mSleepValue, "<get-mSleepValue>(...)");
                TodayHealthyDataActivity todayHealthyDataActivity = TodayHealthyDataActivity.this;
                mContext = todayHealthyDataActivity.getMContext();
                TextConvertKt.xXxxox0I(i, mSleepValue, todayHealthyDataActivity, oI00o.X0o0xo.oxoX(mContext, 8.0f), R.color.black);
            }
        }));
        getMRecyclerView().setAdapter(todayHealthyDataActivity$initData$mAdapter$1);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.status.oI0IIXIo
            @Override // java.lang.Runnable
            public final void run() {
                TodayHealthyDataActivity.initData$lambda$5(TodayHealthyDataActivity$initData$mAdapter$1.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initData$lambda$5(TodayHealthyDataActivity$initData$mAdapter$1 mAdapter) {
        IIX0o.x0xO0oo(mAdapter, "$mAdapter");
        mAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(TodayHealthyDataActivity this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) StepActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(TodayHealthyDataActivity this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) CaloriesActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(TodayHealthyDataActivity this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) SleepActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(TodayHealthyDataActivity this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) DistanceActivity.class));
    }

    public final PFMedium getAbhTitleCenter() {
        return (PFMedium) this.abhTitleCenter$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final AppUser getMAppUser() {
        return this.mAppUser;
    }

    public final DINCondBold getMCalorieValue() {
        return (DINCondBold) this.mCalorieValue$delegate.getValue();
    }

    public final PFMedium getMDistanceUnit() {
        return (PFMedium) this.mDistanceUnit$delegate.getValue();
    }

    public final DINCondBold getMDistanceValue() {
        return (DINCondBold) this.mDistanceValue$delegate.getValue();
    }

    public final RecyclerView getMRecyclerView() {
        return (RecyclerView) this.mRecyclerView$delegate.getValue();
    }

    public final DINCondBold getMSleepValue() {
        return (DINCondBold) this.mSleepValue$delegate.getValue();
    }

    public final DINCondBold getMStepValue() {
        return (DINCondBold) this.mStepValue$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        getAbhTitleCenter().setText(getString(R.string.health_data));
        findViewById(R.id.llStep).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.status.oO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TodayHealthyDataActivity.initView$lambda$0(TodayHealthyDataActivity.this, view);
            }
        });
        findViewById(R.id.llCalories).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.status.x0xO0oo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TodayHealthyDataActivity.initView$lambda$1(TodayHealthyDataActivity.this, view);
            }
        });
        findViewById(R.id.llSleep).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.status.IXxxXO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TodayHealthyDataActivity.initView$lambda$2(TodayHealthyDataActivity.this, view);
            }
        });
        findViewById(R.id.llDistance).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.status.Oxx0xo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TodayHealthyDataActivity.initView$lambda$3(TodayHealthyDataActivity.this, view);
            }
        });
        getMRecyclerView().setLayoutManager(new LinearLayoutManager(this, 1, false));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_today_health_data;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        initData();
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
