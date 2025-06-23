package com.sma.smartv3.ui.status.fragment;

import androidx.core.content.ContextCompat;
import com.blankj.utilcode.util.LogUtils;
import com.github.mikephil.charting.data.Entry;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.SleepDao;
import com.sma.smartv3.db.entity.Sleep;
import com.sma.smartv3.model.SleepAllDayData;
import com.sma.smartv3.model.SleepAllDayDataParse;
import com.sma.smartv3.ui.status.base.StatusBaseMonthFragment;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.view.text.DINCondBold;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class SleepAllDayMonthFragment extends StatusBaseMonthFragment<Sleep> {

    @OXOo.OOXIXo
    private final SleepDao mSleepDao = MyDb.INSTANCE.getMDatabase().sleepDao();

    @OXOo.OOXIXo
    private final List<SleepAllDayData> sleepDayDataList = new ArrayList();

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends ox.x0xO0oo {
        @Override // ox.x0xO0oo
        @OXOo.OOXIXo
        public String II0XooXoX(float f) {
            if (f == 0.0f) {
                return String.valueOf((int) f);
            }
            StringBuilder sb = new StringBuilder();
            sb.append((int) f);
            sb.append('H');
            return sb.toString();
        }
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    public void filterData(@OXOo.OOXIXo List<? extends Sleep> data) {
        IIX0o.x0xO0oo(data, "data");
        super.filterData(data);
        this.sleepDayDataList.clear();
        getTwoValue().setText(HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
        int filterDayData = SleepAllDayDataParse.INSTANCE.filterDayData(getMActivity(), data, getMonthData(), this.sleepDayDataList, getValues());
        DINCondBold oneValue = getOneValue();
        IIX0o.oO(oneValue, "<get-oneValue>(...)");
        TextConvertKt.IIX0o(filterDayData, oneValue, getMActivity(), 0, 0, 24, null);
        updateChartData(getValues());
        if (getValues().size() == 0) {
            int size = getValues().size();
            DINCondBold nowValue = getNowValue();
            IIX0o.oO(nowValue, "<get-nowValue>(...)");
            TextConvertKt.IIX0o(size, nowValue, getMActivity(), 0, 0, 24, null);
        }
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment, com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        DINCondBold nowValue = getNowValue();
        if (nowValue != null) {
            nowValue.setText(HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
        }
        super.initView();
        getImage().setImageResource(R.drawable.icon_sleep);
        getValueUnit().setText("");
        getOneTV().setText(R.string.avg_sleep);
        getOneUnit().setText("");
        getTwoTV().setText(R.string.monitoring_results);
        getTwoUnit().setText("");
        getBarChart().getAxisRight().o0xxxXXxX(new oIX0oI());
        getNowTimeDetails().setVisibility(8);
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    public void onDataChange(@OXOo.OOXIXo List<Sleep> data) {
        IIX0o.x0xO0oo(data, "data");
        filterData(data);
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    @OXOo.OOXIXo
    public List<Sleep> onTimePeriodChange(@OXOo.OOXIXo Calendar calendar, int i, @OXOo.OOXIXo TimePeriod timePeriod) {
        IIX0o.x0xO0oo(calendar, "calendar");
        IIX0o.x0xO0oo(timePeriod, "timePeriod");
        long[] o002 = com.sma.smartv3.util.xoIox.o00(calendar, timePeriod, i);
        StringBuilder sb = new StringBuilder();
        sb.append("month => ");
        SimpleDateFormat OO0x0xX2 = com.sma.smartv3.util.xoIox.OO0x0xX();
        long j = o002[0];
        long j2 = com.sma.smartv3.util.xoIox.f24684IO;
        sb.append(OO0x0xX2.format(Long.valueOf(j - j2)));
        sb.append(" - ");
        sb.append(com.sma.smartv3.util.xoIox.OO0x0xX().format(Long.valueOf(o002[1])));
        LogUtils.d(sb.toString());
        setMonthDays(com.sma.smartv3.util.xoIox.Oo(o002[0]));
        clearCache(o002[0]);
        return this.mSleepDao.getSleeps(o002[0] - j2, o002[1]);
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    public void setColor(@OXOo.OOXIXo o0xxxXXxX.II0xO0 value) {
        IIX0o.x0xO0oo(value, "value");
        value.xOOxIO(ContextCompat.getColor(getMActivity(), R.color.sleep_show_5), ContextCompat.getColor(getMActivity(), R.color.sleep_show_7));
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    @OXOo.OOXIXo
    public String setDataLabel() {
        return "Sleep month Data";
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    public void updateItemData(@OXOo.OOXIXo Entry e) {
        IIX0o.x0xO0oo(e, "e");
        SleepAllDayData sleepAllDayData = this.sleepDayDataList.get((int) e.xxIXOIIO());
        int total = sleepAllDayData.getTotal();
        DINCondBold nowValue = getNowValue();
        IIX0o.oO(nowValue, "<get-nowValue>(...)");
        TextConvertKt.IIX0o(total, nowValue, getMActivity(), 0, 0, 24, null);
        getTwoValue().setText(sleepAllDayData.getEvaluation());
    }
}
