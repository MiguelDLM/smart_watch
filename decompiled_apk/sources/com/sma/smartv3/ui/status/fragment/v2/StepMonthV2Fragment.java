package com.sma.smartv3.ui.status.fragment.v2;

import OXOo.OOXIXo;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.blankj.utilcode.util.SPUtils;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.google.gson.Gson;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.ActivityDao;
import com.sma.smartv3.db.entity.Activity;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.ui.status.base.StatusBaseMonthFragment;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.xoIox;
import com.sma.smartv3.view.text.DINCondBold;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oxxXoxO;
import o0xxxXXxX.II0xO0;

@XX({"SMAP\nStepMonthV2Fragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StepMonthV2Fragment.kt\ncom/sma/smartv3/ui/status/fragment/v2/StepMonthV2Fragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,160:1\n19#2:161\n15#2:162\n*S KotlinDebug\n*F\n+ 1 StepMonthV2Fragment.kt\ncom/sma/smartv3/ui/status/fragment/v2/StepMonthV2Fragment\n*L\n36#1:161\n36#1:162\n*E\n"})
/* loaded from: classes12.dex */
public final class StepMonthV2Fragment extends StatusBaseMonthFragment<Activity> {

    @OOXIXo
    private final String formatDecimal;

    @OOXIXo
    private final AppUser userProfile;

    @OOXIXo
    private final ActivityDao mActivityDao = MyDb.INSTANCE.getMDatabase().activityDao();

    @OOXIXo
    private final X0IIOO caloriesValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.v2.StepMonthV2Fragment$caloriesValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = StepMonthV2Fragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.step_v2_calories_value);
        }
    });

    @OOXIXo
    private final X0IIOO distanceValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.v2.StepMonthV2Fragment$distanceValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = StepMonthV2Fragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.step_v2_distance_value);
        }
    });

    public StepMonthV2Fragment() {
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

    private final DINCondBold getCaloriesValue() {
        return (DINCondBold) this.caloriesValue$delegate.getValue();
    }

    private final DINCondBold getDistanceValue() {
        return (DINCondBold) this.distanceValue$delegate.getValue();
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    public void filterData(@OOXIXo List<? extends Activity> data) {
        IIX0o.x0xO0oo(data, "data");
        super.filterData(data);
        float f = 0.0f;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (Activity activity : data) {
            getValues().add(new BarEntry(i2, activity.getMStep()));
            i += activity.getMStep();
            i3 += activity.getMCalorie();
            f += TextConvertKt.ooOOo0oXI(activity.getMDistance(), this.userProfile.getUnit(), false, 4, null);
            i2++;
        }
        getOneValue().setText(UtilsKt.IIXOooo(String.valueOf(i)));
        getTwoValue().setText(UtilsKt.IIXOooo(String.valueOf(i / i2)));
        getCaloriesValue().setText(UtilsKt.IIXOooo(String.valueOf(i3)));
        DINCondBold distanceValue = getDistanceValue();
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format(this.formatDecimal, Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
        IIX0o.oO(format, "format(...)");
        distanceValue.setText(UtilsKt.IIXOooo(format));
        updateChartData(getValues());
    }

    @OOXIXo
    public final String getFormatDecimal() {
        return this.formatDecimal;
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment, com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getImage().setImageResource(R.drawable.icon_step_info_v2);
        getValueUnit().setText(R.string.steps);
        getOneTV().setText(R.string.total_steps);
        getOneUnit().setText(R.string.steps);
        getTwoTV().setText(R.string.average_steps);
        getTwoUnit().setText(R.string.steps);
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_status_month_v2;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    public void onDataChange(@OOXIXo List<Activity> data) {
        IIX0o.x0xO0oo(data, "data");
        filterData(data);
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    @OOXIXo
    public List<Activity> onTimePeriodChange(@OOXIXo Calendar calendar, int i, @OOXIXo TimePeriod timePeriod) {
        IIX0o.x0xO0oo(calendar, "calendar");
        IIX0o.x0xO0oo(timePeriod, "timePeriod");
        long[] o002 = xoIox.o00(calendar, timePeriod, i);
        List<Activity> listASC = this.mActivityDao.getListASC(o002[0], o002[1]);
        setMonthDays(xoIox.Oo(o002[0]));
        clearCache(o002[0]);
        for (Activity activity : listASC) {
            Iterator<Map.Entry<Long, ArrayList<Activity>>> it = getMonthData().entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<Long, ArrayList<Activity>> next = it.next();
                    long longValue = next.getKey().longValue();
                    ArrayList<Activity> value = next.getValue();
                    if (activity.getMTime() < longValue) {
                        value.add(activity);
                        break;
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Long, ArrayList<Activity>>> it2 = getMonthData().entrySet().iterator();
        while (it2.hasNext()) {
            ArrayList<Activity> value2 = it2.next().getValue();
            if (value2.isEmpty()) {
                arrayList.add(new Activity(0, 0L, null, 0, 0, 0, 0, 0, 0, 0, 1023, null));
            } else {
                Iterator<Activity> it3 = value2.iterator();
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (it3.hasNext()) {
                    Activity next2 = it3.next();
                    int mStep = next2.getMStep();
                    if (i2 <= mStep) {
                        i5 += mStep - i2;
                    }
                    int mDistance = next2.getMDistance() / 10000;
                    if (i3 <= mDistance) {
                        i7 += mDistance - i3;
                    }
                    int mCalorie = next2.getMCalorie() / 10000;
                    if (i4 <= mCalorie) {
                        i6 += mCalorie - i4;
                    }
                    i4 = mCalorie;
                    i3 = mDistance;
                    i2 = mStep;
                }
                arrayList.add(new Activity(0, 0L, null, 0, 0, i5, i6, i7, 0, 0, 799, null));
            }
        }
        return arrayList;
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    public void setColor(@OOXIXo II0xO0 value) {
        IIX0o.x0xO0oo(value, "value");
        value.xOOxIO(ContextCompat.getColor(getMActivity(), R.color.step_show_1_v2), ContextCompat.getColor(getMActivity(), R.color.step_show_2_v2));
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    @OOXIXo
    public String setDataLabel() {
        return "Step Month Data";
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    public void updateItemData(@OOXIXo Entry e) {
        IIX0o.x0xO0oo(e, "e");
        getNowValue().setText(UtilsKt.IIXOooo(String.valueOf((int) e.I0Io())));
    }
}
