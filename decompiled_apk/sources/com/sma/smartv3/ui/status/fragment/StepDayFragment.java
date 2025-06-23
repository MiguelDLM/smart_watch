package com.sma.smartv3.ui.status.fragment;

import androidx.core.content.ContextCompat;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.Activity;
import com.sma.smartv3.ui.status.base.ActivityBaseDayFragment;
import com.sma.smartv3.util.UtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class StepDayFragment extends ActivityBaseDayFragment {
    @Override // com.sma.smartv3.ui.status.base.ActivityBaseDayFragment
    public void filterData(@OXOo.OOXIXo List<Activity> data) {
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
        int i5 = 0;
        while (it2.hasNext()) {
            ArrayList<Activity> value2 = it2.next().getValue();
            if (value2.isEmpty()) {
                i = 0;
            } else {
                Iterator<Activity> it3 = value2.iterator();
                i = 0;
                int i6 = 0;
                while (it3.hasNext()) {
                    int mStep = it3.next().getMStep();
                    if (i6 <= mStep) {
                        if (i6 == 0 && i5 != 0 && mStep >= i5) {
                            i2 = mStep - i5;
                        } else {
                            i2 = mStep - i6;
                        }
                        i += i2;
                    }
                    i6 = mStep;
                }
                i5 = ((Activity) CollectionsKt___CollectionsKt.O0O0Io00X(value2)).getMStep();
            }
            getValues().add(new BarEntry(i4, i));
            i4++;
        }
        Iterator<Activity> it4 = data.iterator();
        int i7 = 0;
        while (it4.hasNext()) {
            int mStep2 = it4.next().getMStep();
            if (i7 <= mStep2) {
                i3 += mStep2 - i7;
            }
            i7 = mStep2;
        }
        getOneValue().setText(UtilsKt.IIXOooo(String.valueOf(i3)));
    }

    @Override // com.sma.smartv3.ui.status.base.ActivityBaseDayFragment, com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getImage().setImageResource(R.drawable.icon_step_info);
        getValueUnit().setText(R.string.steps);
        getOneTV().setText(R.string.total_steps);
        getTotalUnit().setText(R.string.steps);
        getTwoTV().setText(R.string.current_device_total_steps);
        getTwoUnit().setText(R.string.steps);
    }

    @Override // com.sma.smartv3.ui.status.base.ActivityBaseDayFragment
    public void setColor(@OXOo.OOXIXo o0xxxXXxX.II0xO0 value) {
        IIX0o.x0xO0oo(value, "value");
        value.xOOxIO(ContextCompat.getColor(getMActivity(), R.color.step_show_1), ContextCompat.getColor(getMActivity(), R.color.step_show_2));
    }

    @Override // com.sma.smartv3.ui.status.base.ActivityBaseDayFragment
    @OXOo.OOXIXo
    public String setDataLabel() {
        return "Step day Data";
    }

    @Override // com.sma.smartv3.ui.status.base.ActivityBaseDayFragment
    public void updateItemData(@OXOo.OOXIXo Entry e) {
        IIX0o.x0xO0oo(e, "e");
        getNowValue().setText(UtilsKt.IIXOooo(String.valueOf((int) e.I0Io())));
    }
}
