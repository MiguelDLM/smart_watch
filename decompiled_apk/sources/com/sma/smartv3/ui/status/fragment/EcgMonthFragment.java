package com.sma.smartv3.ui.status.fragment;

import androidx.core.content.ContextCompat;
import com.github.mikephil.charting.data.Entry;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.ElectrocardiogramDao;
import com.sma.smartv3.db.entity.Electrocardiogram;
import com.sma.smartv3.model.ECGDataParse;
import com.sma.smartv3.model.ECGDayData;
import com.sma.smartv3.ui.status.base.StatusBaseMonthFragment;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.view.text.DINCondBold;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;

/* loaded from: classes12.dex */
public final class EcgMonthFragment extends StatusBaseMonthFragment<Electrocardiogram> {

    @OXOo.OOXIXo
    private final ElectrocardiogramDao mElectrocardiogram = MyDb.INSTANCE.getMDatabase().electrocardiogramDao();

    @OXOo.OOXIXo
    private final List<ECGDayData> hrDayDataList = new ArrayList();

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    public void filterData(@OXOo.OOXIXo List<? extends Electrocardiogram> data) {
        IIX0o.x0xO0oo(data, "data");
        super.filterData(data);
        ECGDataParse.INSTANCE.filterDayData(getMActivity(), data, getMonthData(), this.hrDayDataList, getValues());
        updateChartData(getValues());
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment, com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        setAxisMinimum(30.0f);
        super.initView();
        getImage().setImageResource(R.drawable.icon_ecg);
        getValueUnit().setText(R.string.bpm);
        getOneTV().setText(R.string.ave_hr);
        getOneUnit().setText(R.string.bpm);
        getTwoTV().setText(R.string.monitoring_results);
        getTwoUnit().setText("");
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    public void onDataChange(@OXOo.OOXIXo List<Electrocardiogram> data) {
        IIX0o.x0xO0oo(data, "data");
        filterData(data);
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    @OXOo.OOXIXo
    public List<Electrocardiogram> onTimePeriodChange(@OXOo.OOXIXo Calendar calendar, int i, @OXOo.OOXIXo TimePeriod timePeriod) {
        IIX0o.x0xO0oo(calendar, "calendar");
        IIX0o.x0xO0oo(timePeriod, "timePeriod");
        long[] o002 = com.sma.smartv3.util.xoIox.o00(calendar, timePeriod, i);
        setMonthDays(com.sma.smartv3.util.xoIox.Oo(o002[0]));
        clearCache(o002[0]);
        return this.mElectrocardiogram.getElectrocardiograms(o002[0], o002[1]);
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
        return "ecg month Data";
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    public void updateItemData(@OXOo.OOXIXo Entry e) {
        IIX0o.x0xO0oo(e, "e");
        ECGDayData eCGDayData = this.hrDayDataList.get((int) e.xxIXOIIO());
        DINCondBold nowValue = getNowValue();
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("%s - %s", Arrays.copyOf(new Object[]{UtilsKt.OxxIIOOXO(eCGDayData.getMin()), UtilsKt.OxxIIOOXO(eCGDayData.getMax())}, 2));
        IIX0o.oO(format, "format(...)");
        nowValue.setText(format);
        getOneValue().setText(UtilsKt.OxxIIOOXO(eCGDayData.getAvg()));
        getTwoValue().setText(eCGDayData.getStatus());
    }
}
