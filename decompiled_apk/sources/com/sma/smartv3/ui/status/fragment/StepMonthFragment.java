package com.sma.smartv3.ui.status.fragment;

import androidx.core.content.ContextCompat;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.ActivityDao;
import com.sma.smartv3.db.entity.Activity;
import com.sma.smartv3.ui.status.base.StatusBaseMonthFragment;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.UtilsKt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class StepMonthFragment extends StatusBaseMonthFragment<Activity> {

    @OXOo.OOXIXo
    private final ActivityDao mActivityDao = MyDb.INSTANCE.getMDatabase().activityDao();

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    public void filterData(@OXOo.OOXIXo List<? extends Activity> data) {
        IIX0o.x0xO0oo(data, "data");
        super.filterData(data);
        int i = 0;
        int i2 = 0;
        for (Activity activity : data) {
            getValues().add(new BarEntry(i2, activity.getMStep()));
            i += activity.getMStep();
            i2++;
        }
        getOneValue().setText(UtilsKt.IIXOooo(String.valueOf(i)));
        getTwoValue().setText(UtilsKt.IIXOooo(String.valueOf(i / i2)));
        updateChartData(getValues());
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment, com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getImage().setImageResource(R.drawable.icon_step_info);
        getValueUnit().setText(R.string.steps);
        getOneTV().setText(R.string.total_steps);
        getOneUnit().setText(R.string.steps);
        getTwoTV().setText(R.string.average_steps);
        getTwoUnit().setText(R.string.steps);
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    public void onDataChange(@OXOo.OOXIXo List<Activity> data) {
        IIX0o.x0xO0oo(data, "data");
        filterData(data);
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    @OXOo.OOXIXo
    public List<Activity> onTimePeriodChange(@OXOo.OOXIXo Calendar calendar, int i, @OXOo.OOXIXo TimePeriod timePeriod) {
        IIX0o.x0xO0oo(calendar, "calendar");
        IIX0o.x0xO0oo(timePeriod, "timePeriod");
        long[] o002 = com.sma.smartv3.util.xoIox.o00(calendar, timePeriod, i);
        List<Activity> listASC = this.mActivityDao.getListASC(o002[0], o002[1]);
        setMonthDays(com.sma.smartv3.util.xoIox.Oo(o002[0]));
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
                while (it3.hasNext()) {
                    int mStep = it3.next().getMStep();
                    if (i2 <= mStep) {
                        i3 += mStep - i2;
                    }
                    i2 = mStep;
                }
                arrayList.add(new Activity(0, 0L, null, 0, 0, i3, 0, 0, 0, 0, 991, null));
            }
        }
        return arrayList;
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    public void setColor(@OXOo.OOXIXo o0xxxXXxX.II0xO0 value) {
        IIX0o.x0xO0oo(value, "value");
        value.xOOxIO(ContextCompat.getColor(getMActivity(), R.color.step_show_1), ContextCompat.getColor(getMActivity(), R.color.step_show_2));
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    @OXOo.OOXIXo
    public String setDataLabel() {
        return "Step Month Data";
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    public void updateItemData(@OXOo.OOXIXo Entry e) {
        IIX0o.x0xO0oo(e, "e");
        getNowValue().setText(UtilsKt.IIXOooo(String.valueOf((int) e.I0Io())));
    }
}
