package com.sma.smartv3.ui.status.fragment.v2;

import OXOo.OOXIXo;
import XO0.XO;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import com.blankj.utilcode.util.SPUtils;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.Activity;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.ui.me.GoalSettingActivity;
import com.sma.smartv3.ui.status.base.ActivityBaseDayFragment;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oxxXoxO;
import o0xxxXXxX.II0xO0;

@XX({"SMAP\nStepDayV2Fragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StepDayV2Fragment.kt\ncom/sma/smartv3/ui/status/fragment/v2/StepDayV2Fragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,200:1\n19#2:201\n15#2:202\n*S KotlinDebug\n*F\n+ 1 StepDayV2Fragment.kt\ncom/sma/smartv3/ui/status/fragment/v2/StepDayV2Fragment\n*L\n49#1:201\n49#1:202\n*E\n"})
/* loaded from: classes12.dex */
public final class StepDayV2Fragment extends ActivityBaseDayFragment {
    private int countCR_Step;

    @OOXIXo
    private final String formatDecimal;

    @OOXIXo
    private final AppUser userProfile;

    @OOXIXo
    private final X0IIOO goalValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.fragment.v2.StepDayV2Fragment$goalValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = StepDayV2Fragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.step_v2_goal_value);
        }
    });

    @OOXIXo
    private final X0IIOO progressBar$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ProgressBar>() { // from class: com.sma.smartv3.ui.status.fragment.v2.StepDayV2Fragment$progressBar$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ProgressBar invoke() {
            View mView;
            mView = StepDayV2Fragment.this.getMView();
            return (ProgressBar) mView.findViewById(R.id.step_v2_goal_pb_progress);
        }
    });

    @OOXIXo
    private final X0IIOO goalTip$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.fragment.v2.StepDayV2Fragment$goalTip$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = StepDayV2Fragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.step_v2_goal_tip);
        }
    });

    @OOXIXo
    private final X0IIOO caloriesValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.v2.StepDayV2Fragment$caloriesValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = StepDayV2Fragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.step_v2_calories_value);
        }
    });

    @OOXIXo
    private final X0IIOO distanceValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.v2.StepDayV2Fragment$distanceValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = StepDayV2Fragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.step_v2_distance_value);
        }
    });

    @OOXIXo
    private final X0IIOO caloriesDeviceValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.v2.StepDayV2Fragment$caloriesDeviceValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = StepDayV2Fragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.step_v2_calories_value2);
        }
    });

    @OOXIXo
    private final X0IIOO distanceDeviceValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.v2.StepDayV2Fragment$distanceDeviceValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = StepDayV2Fragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.step_v2_distance_value2);
        }
    });

    public StepDayV2Fragment() {
        String str;
        if (ProductManager.f20544oIX0oI.Ioxxx()) {
            str = "%.2f";
        } else {
            str = "%.1f";
        }
        this.formatDecimal = str;
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.userProfile = (AppUser) (fromJson != null ? fromJson : appUser);
    }

    private final DINCondBold getCaloriesDeviceValue() {
        return (DINCondBold) this.caloriesDeviceValue$delegate.getValue();
    }

    private final DINCondBold getCaloriesValue() {
        return (DINCondBold) this.caloriesValue$delegate.getValue();
    }

    private final DINCondBold getDistanceDeviceValue() {
        return (DINCondBold) this.distanceDeviceValue$delegate.getValue();
    }

    private final DINCondBold getDistanceValue() {
        return (DINCondBold) this.distanceValue$delegate.getValue();
    }

    private final PFMedium getGoalTip() {
        return (PFMedium) this.goalTip$delegate.getValue();
    }

    private final PFMedium getGoalValue() {
        return (PFMedium) this.goalValue$delegate.getValue();
    }

    private final ProgressBar getProgressBar() {
        return (ProgressBar) this.progressBar$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(StepDayV2Fragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.getActivity(), (Class<?>) GoalSettingActivity.class));
    }

    @Override // com.sma.smartv3.ui.status.base.ActivityBaseDayFragment
    public void filterData(@OOXIXo List<Activity> data) {
        int i;
        int i2;
        IIX0o.x0xO0oo(data, "data");
        super.filterData(data);
        if (data.isEmpty()) {
            getTwoValue().setText(UtilsKt.IIXOooo("0"));
        } else {
            getTwoValue().setText(String.valueOf(data.get(data.size() - 1).getMStep()));
        }
        for (Activity activity : data) {
            Iterator<Map.Entry<Long, ArrayList<Activity>>> it = getFilterData().entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<Long, ArrayList<Activity>> next = it.next();
                    long longValue = next.getKey().longValue();
                    ArrayList<Activity> value = next.getValue();
                    if (activity.getMTime() <= longValue) {
                        value.add(activity);
                        break;
                    }
                }
            }
        }
        Iterator<Map.Entry<Long, ArrayList<Activity>>> it2 = getFilterData().entrySet().iterator();
        int i3 = 0;
        int i4 = 0;
        while (it2.hasNext()) {
            ArrayList<Activity> value2 = it2.next().getValue();
            if (value2.isEmpty()) {
                i = 0;
            } else {
                Iterator<Activity> it3 = value2.iterator();
                i = 0;
                int i5 = 0;
                while (it3.hasNext()) {
                    int mStep = it3.next().getMStep();
                    if (i5 <= mStep) {
                        if (i5 == 0 && i4 != 0 && mStep >= i4) {
                            i2 = mStep - i4;
                        } else {
                            i2 = mStep - i5;
                        }
                        i += i2;
                    }
                    i5 = mStep;
                }
                i4 = ((Activity) CollectionsKt___CollectionsKt.O0O0Io00X(value2)).getMStep();
            }
            getValues().add(new BarEntry(i3, i));
            i3++;
        }
        this.countCR_Step = 0;
        float f = 0.0f;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (Activity activity2 : data) {
            int mStep2 = activity2.getMStep();
            if (i7 <= mStep2) {
                this.countCR_Step += mStep2 - i7;
            }
            int mDistance = activity2.getMDistance();
            if (i8 <= mDistance) {
                f += TextConvertKt.ooOOo0oXI(mDistance - i8, this.userProfile.getUnit(), false, 4, null);
            }
            int mCalorie = activity2.getMCalorie() / 10000;
            if (i9 <= mCalorie) {
                i6 += mCalorie - i9;
            }
            i9 = mCalorie;
            i8 = mDistance;
            i7 = mStep2;
        }
        getOneValue().setText(UtilsKt.IIXOooo(String.valueOf(this.countCR_Step)));
        setGoalChange();
        getCaloriesValue().setText(UtilsKt.IIXOooo(String.valueOf(i6)));
        DINCondBold distanceValue = getDistanceValue();
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        float f2 = f / 10000.0f;
        String format = String.format(this.formatDecimal, Arrays.copyOf(new Object[]{Float.valueOf(f2)}, 1));
        IIX0o.oO(format, "format(...)");
        distanceValue.setText(UtilsKt.IIXOooo(format));
        getCaloriesDeviceValue().setText(UtilsKt.IIXOooo(String.valueOf(i6)));
        DINCondBold distanceDeviceValue = getDistanceDeviceValue();
        String format2 = String.format(this.formatDecimal, Arrays.copyOf(new Object[]{Float.valueOf(f2)}, 1));
        IIX0o.oO(format2, "format(...)");
        distanceDeviceValue.setText(UtilsKt.IIXOooo(format2));
    }

    public final int getCountCR_Step() {
        return this.countCR_Step;
    }

    @OOXIXo
    public final String getFormatDecimal() {
        return this.formatDecimal;
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.sma.smartv3.ui.status.base.ActivityBaseDayFragment, com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getImage().setImageResource(R.drawable.icon_step_info_v2);
        View findViewById = getMView().findViewById(R.id.step_v2_set_goal);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.status.fragment.v2.oIX0oI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StepDayV2Fragment.initView$lambda$0(StepDayV2Fragment.this, view);
                }
            });
        }
    }

    @Override // com.sma.smartv3.ui.status.base.ActivityBaseDayFragment, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_status_day_v2;
    }

    @XO(tag = x0xO0oo.f24663xoIxX)
    public final void onGoalChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        setGoalChange();
    }

    @Override // com.sma.smartv3.ui.status.base.ActivityBaseDayFragment
    public void setColor(@OOXIXo II0xO0 value) {
        IIX0o.x0xO0oo(value, "value");
        value.xOOxIO(ContextCompat.getColor(getMActivity(), R.color.step_show_1_v2), ContextCompat.getColor(getMActivity(), R.color.step_show_2_v2));
    }

    public final void setCountCR_Step(int i) {
        this.countCR_Step = i;
    }

    @Override // com.sma.smartv3.ui.status.base.ActivityBaseDayFragment
    @OOXIXo
    public String setDataLabel() {
        return "Step day Data";
    }

    @SuppressLint({"SetTextI18n"})
    public final void setGoalChange() {
        CharSequence text;
        PFMedium goalValue = getGoalValue();
        StringBuilder sb = new StringBuilder();
        if (IIX0o.Oxx0IOOO(getOneValue().getText(), HelpFormatter.DEFAULT_LONG_OPT_PREFIX)) {
            text = "0";
        } else {
            text = getOneValue().getText();
        }
        sb.append((Object) text);
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        BleCache bleCache = BleCache.INSTANCE;
        BleKey bleKey = BleKey.STEP_GOAL;
        sb.append(BleCache.getInt$default(bleCache, bleKey, 0, null, 6, null));
        goalValue.setText(sb.toString());
        getProgressBar().setMax(BleCache.getInt$default(bleCache, bleKey, 0, null, 6, null));
        getProgressBar().setProgress(this.countCR_Step);
        getGoalTip().setText(getString(R.string.implement_goal_reminder, Integer.valueOf(BleCache.getInt$default(bleCache, bleKey, 0, null, 6, null) - this.countCR_Step)));
    }

    @Override // com.sma.smartv3.ui.status.base.ActivityBaseDayFragment
    public void updateItemData(@OOXIXo Entry e) {
        IIX0o.x0xO0oo(e, "e");
        getNowValue().setText(UtilsKt.IIXOooo(String.valueOf((int) e.I0Io())));
    }
}
