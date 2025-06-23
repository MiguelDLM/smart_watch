package com.sma.smartv3.ui.status.fragment;

import androidx.core.content.ContextCompat;
import com.github.mikephil.charting.data.Entry;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.HeartRateDao;
import com.sma.smartv3.db.entity.HeartRate;
import com.sma.smartv3.model.HRDataParse;
import com.sma.smartv3.model.HRDayData;
import com.sma.smartv3.ui.status.base.StatusBaseMonthFragment;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.UtilsKt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class HeartRateMonthFragment extends StatusBaseMonthFragment<HeartRate> {

    @OXOo.OOXIXo
    private final HeartRateDao mHeartRateDao = MyDb.INSTANCE.getMDatabase().heartRateDao();

    @OXOo.OOXIXo
    private final List<HRDayData> hrDayDataList = new ArrayList();

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    public void filterData(@OXOo.OOXIXo List<? extends HeartRate> data) {
        IIX0o.x0xO0oo(data, "data");
        super.filterData(data);
        HRDataParse.INSTANCE.filterDayData(getMActivity(), data, getMonthData(), this.hrDayDataList, getValues());
        updateChartData(getValues());
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment, com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        setAxisMinimum(30.0f);
        super.initView();
        getImage().setImageResource(R.drawable.icon_hr);
        getValueUnit().setText(R.string.bpm);
        getOneTV().setText(R.string.ave_hr);
        getOneUnit().setText(R.string.bpm);
        getTwoTV().setText(R.string.monitoring_results);
        getTwoUnit().setText("");
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    public void onDataChange(@OXOo.OOXIXo List<HeartRate> data) {
        IIX0o.x0xO0oo(data, "data");
        filterData(data);
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    @OXOo.OOXIXo
    public List<HeartRate> onTimePeriodChange(@OXOo.OOXIXo Calendar calendar, int i, @OXOo.OOXIXo TimePeriod timePeriod) {
        IIX0o.x0xO0oo(calendar, "calendar");
        IIX0o.x0xO0oo(timePeriod, "timePeriod");
        long[] o002 = com.sma.smartv3.util.xoIox.o00(calendar, timePeriod, i);
        setMonthDays(com.sma.smartv3.util.xoIox.Oo(o002[0]));
        clearCache(o002[0]);
        return this.mHeartRateDao.getHeartRates(o002[0], o002[1]);
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    public void setChartRenderer() {
        xxx00.II0xO0 iI0xO0 = new xxx00.II0xO0(getBarChart(), getBarChart().getAnimator(), getBarChart().getViewPortHandler());
        iI0xO0.X0IIOO(oIxOXo.oxoX.I0Io(getMActivity(), R.color.line_color));
        iI0xO0.O0xOxO(new int[]{ContextCompat.getColor(getMActivity(), R.color.hr_show_1), ContextCompat.getColor(getMActivity(), R.color.hr_show_2)});
        iI0xO0.oI0IIXIo(1);
        getBarChart().setRenderer(iI0xO0);
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    public void setColor(@OXOo.OOXIXo o0xxxXXxX.II0xO0 value) {
        IIX0o.x0xO0oo(value, "value");
        value.o0IXXIx(CollectionsKt__CollectionsKt.X00IoxXI(0, Integer.valueOf(ContextCompat.getColor(getMActivity(), R.color.colorAccent))));
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    @OXOo.OOXIXo
    public String setDataLabel() {
        return "HR month Data";
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    public void updateItemData(@OXOo.OOXIXo Entry e) {
        IIX0o.x0xO0oo(e, "e");
        HRDayData hRDayData = this.hrDayDataList.get((int) e.xxIXOIIO());
        getNowValue().setText(UtilsKt.OOXIXo(hRDayData.getMin(), hRDayData.getMax()));
        getOneValue().setText(UtilsKt.OxxIIOOXO(hRDayData.getAvg()));
        getTwoValue().setText(hRDayData.getStatus());
    }
}
