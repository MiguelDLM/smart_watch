package com.sma.smartv3.ui.status.fragment;

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
import com.sma.smartv3.ui.status.base.StatusBaseWeekFragment;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.view.text.DINCondBold;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oxxXoxO;

@XX({"SMAP\nDistanceWeekFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DistanceWeekFragment.kt\ncom/sma/smartv3/ui/status/fragment/DistanceWeekFragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,121:1\n19#2:122\n15#2:123\n*S KotlinDebug\n*F\n+ 1 DistanceWeekFragment.kt\ncom/sma/smartv3/ui/status/fragment/DistanceWeekFragment\n*L\n19#1:122\n19#1:123\n*E\n"})
/* loaded from: classes12.dex */
public final class DistanceWeekFragment extends StatusBaseWeekFragment<Activity> {

    @OXOo.OOXIXo
    private final String formatDecimal;

    @OXOo.OOXIXo
    private final ActivityDao mActivityDao;

    @OXOo.OOXIXo
    private final AppUser userProfile;

    public DistanceWeekFragment() {
        String str;
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.userProfile = (AppUser) (fromJson != null ? fromJson : appUser);
        this.mActivityDao = MyDb.INSTANCE.getMDatabase().activityDao();
        if (ProductManager.f20544oIX0oI.Ioxxx()) {
            str = "%.2f";
        } else {
            str = "%.1f";
        }
        this.formatDecimal = str;
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseWeekFragment
    public void filterData(@OXOo.OOXIXo List<? extends Activity> data) {
        IIX0o.x0xO0oo(data, "data");
        super.filterData(data);
        Iterator<? extends Activity> it = data.iterator();
        float f = 0.0f;
        int i = 0;
        while (it.hasNext()) {
            float ooOOo0oXI2 = TextConvertKt.ooOOo0oXI(it.next().getMDistance(), this.userProfile.getUnit(), false, 4, null);
            getValues().add(new BarEntry(i, ooOOo0oXI2));
            f += ooOOo0oXI2;
            i++;
        }
        DINCondBold oneValue = getOneValue();
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format(this.formatDecimal, Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
        IIX0o.oO(format, "format(...)");
        oneValue.setText(UtilsKt.IIXOooo(format));
        DINCondBold twoValue = getTwoValue();
        String format2 = String.format(this.formatDecimal, Arrays.copyOf(new Object[]{Float.valueOf(f / i)}, 1));
        IIX0o.oO(format2, "format(...)");
        twoValue.setText(UtilsKt.IIXOooo(format2));
        updateChartData(getValues());
    }

    @OXOo.OOXIXo
    public final String getFormatDecimal() {
        return this.formatDecimal;
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseWeekFragment, com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getImage().setImageResource(R.drawable.icon_distance_info);
        getValueUnit().setText(TextConvertKt.oI0IIXIo(this.userProfile.getUnit()));
        getOneTV().setText(R.string.total_distance);
        getOneUnit().setText(TextConvertKt.oI0IIXIo(this.userProfile.getUnit()));
        getTwoTV().setText(R.string.average_distance);
        getTwoUnit().setText(TextConvertKt.oI0IIXIo(this.userProfile.getUnit()));
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
        setWeekDay(com.sma.smartv3.util.xoIox.XI0IXoo(o002[0]));
        clearCache(o002[0]);
        for (Activity activity : listASC) {
            Iterator<Map.Entry<Long, ArrayList<Activity>>> it = getWeekData().entrySet().iterator();
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
        Iterator<Map.Entry<Long, ArrayList<Activity>>> it2 = getWeekData().entrySet().iterator();
        while (it2.hasNext()) {
            ArrayList<Activity> value2 = it2.next().getValue();
            if (value2.isEmpty()) {
                arrayList.add(new Activity(0, 0L, null, 0, 0, 0, 0, 0, 0, 0, 1023, null));
            } else {
                Iterator<Activity> it3 = value2.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it3.hasNext()) {
                    int mDistance = it3.next().getMDistance() / 10000;
                    if (i2 <= mDistance) {
                        i3 += mDistance - i2;
                    }
                    i2 = mDistance;
                }
                arrayList.add(new Activity(0, 0L, null, 0, 0, 0, 0, i3, 0, 0, 895, null));
            }
        }
        return arrayList;
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseWeekFragment
    public void setColor(@OXOo.OOXIXo o0xxxXXxX.II0xO0 value) {
        IIX0o.x0xO0oo(value, "value");
        value.xOOxIO(ContextCompat.getColor(getMActivity(), R.color.distance_show_1), ContextCompat.getColor(getMActivity(), R.color.distance_show_2));
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseWeekFragment
    @OXOo.OOXIXo
    public String setDataLabel() {
        return "Distance week Data";
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseWeekFragment
    public void updateItemData(@OXOo.OOXIXo Entry e) {
        IIX0o.x0xO0oo(e, "e");
        DINCondBold nowValue = getNowValue();
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format(this.formatDecimal, Arrays.copyOf(new Object[]{Float.valueOf(e.I0Io())}, 1));
        IIX0o.oO(format, "format(...)");
        nowValue.setText(UtilsKt.IIXOooo(format));
    }
}
