package com.sma.smartv3.ui.status.fragment;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.SleepDao;
import com.sma.smartv3.db.entity.Sleep;
import com.sma.smartv3.model.SleepDataParse;
import com.sma.smartv3.model.SleepDayData;
import com.sma.smartv3.ui.status.base.BaseDetailDaysFragment;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.view.text.DINCondBold;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class SleepDayFragment extends BaseDetailDaysFragment<Sleep> {
    private xxx00.II0xO0 infoBarChartRender;
    public o0xxxXXxX.II0xO0 setValue;

    @OXOo.OOXIXo
    private final X0IIOO barChart$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<BarChart>() { // from class: com.sma.smartv3.ui.status.fragment.SleepDayFragment$barChart$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final BarChart invoke() {
            View mView;
            mView = SleepDayFragment.this.getMView();
            return (BarChart) mView.findViewById(R.id.barChart);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO deepValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.SleepDayFragment$deepValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = SleepDayFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.deepValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO lightValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.SleepDayFragment$lightValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = SleepDayFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.lightValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO awakeValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.SleepDayFragment$awakeValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = SleepDayFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.awakeValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sleepStartTime$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.fragment.SleepDayFragment$sleepStartTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SleepDayFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.sleepStartTime);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sleepEndTime$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.fragment.SleepDayFragment$sleepEndTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SleepDayFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.sleepEndTime);
        }
    });

    @OXOo.OOXIXo
    private final List<BarEntry> values = new ArrayList();
    private final int block = 3;
    private final float blockHeight = 300.0f / 3;

    @OXOo.OOXIXo
    private final SleepDao mSleepDao = MyDb.INSTANCE.getMDatabase().sleepDao();

    private final void filterData(List<Sleep> list) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        this.values.clear();
        if (!list.isEmpty()) {
            SleepDayData filterData = SleepDataParse.INSTANCE.filterData(list, this.blockHeight, this.values);
            LogUtils.d(filterData.toString());
            i = filterData.getStatus().get(1);
            i2 = filterData.getStatus().get(2);
            i3 = filterData.getStatus().get(3);
            i4 = filterData.getTotal();
            if (i4 >= 60) {
                setXAxis(filterData.getStartTime(), i4);
            }
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        if ((i4 != 0 && i4 < 60) || this.values.isEmpty()) {
            this.values.clear();
            getSleepStartTime().setText("");
            getSleepEndTime().setText("");
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            if (i4 == 0) {
                getSleepStartTime().setText("");
                getSleepEndTime().setText("");
                getBarChart().getXAxis().o0xxxXXxX(new ox.oOoXoXO(CollectionsKt__CollectionsKt.ooXIXxIX()));
            }
            i5 = i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i5);
        sb.append(TokenParser.SP);
        sb.append(i2);
        sb.append(TokenParser.SP);
        sb.append(i3);
        sb.append(TokenParser.SP);
        sb.append(i4);
        LogUtils.d(sb.toString());
        DINCondBold deepValue = getDeepValue();
        IIX0o.oO(deepValue, "<get-deepValue>(...)");
        TextConvertKt.IIX0o(i5, deepValue, getMActivity(), 0, 0, 24, null);
        DINCondBold lightValue = getLightValue();
        IIX0o.oO(lightValue, "<get-lightValue>(...)");
        TextConvertKt.IIX0o(i2, lightValue, getMActivity(), 0, 0, 24, null);
        DINCondBold awakeValue = getAwakeValue();
        IIX0o.oO(awakeValue, "<get-awakeValue>(...)");
        TextConvertKt.IIX0o(i3, awakeValue, getMActivity(), 0, 0, 24, null);
        DINCondBold nowValue = getNowValue();
        IIX0o.oO(nowValue, "<get-nowValue>(...)");
        TextConvertKt.IIX0o(i4, nowValue, getMActivity(), 0, 0, 24, null);
        xxx00.II0xO0 iI0xO0 = null;
        if (1 <= i4 && i4 < 121) {
            xxx00.II0xO0 iI0xO02 = this.infoBarChartRender;
            if (iI0xO02 == null) {
                IIX0o.XOxIOxOx("infoBarChartRender");
            } else {
                iI0xO0 = iI0xO02;
            }
            iI0xO0.xxX(6.0f);
        } else {
            xxx00.II0xO0 iI0xO03 = this.infoBarChartRender;
            if (iI0xO03 == null) {
                IIX0o.XOxIOxOx("infoBarChartRender");
            } else {
                iI0xO0 = iI0xO03;
            }
            iI0xO0.xxX(2.0f);
        }
        updateChartData(this.values);
    }

    private final DINCondBold getAwakeValue() {
        return (DINCondBold) this.awakeValue$delegate.getValue();
    }

    private final BarChart getBarChart() {
        return (BarChart) this.barChart$delegate.getValue();
    }

    private final DINCondBold getDeepValue() {
        return (DINCondBold) this.deepValue$delegate.getValue();
    }

    private final DINCondBold getLightValue() {
        return (DINCondBold) this.lightValue$delegate.getValue();
    }

    private final TextView getSleepEndTime() {
        return (TextView) this.sleepEndTime$delegate.getValue();
    }

    private final TextView getSleepStartTime() {
        return (TextView) this.sleepStartTime$delegate.getValue();
    }

    private final void setXAxis(int i, int i2) {
        XAxis xAxis = getBarChart().getXAxis();
        IIX0o.x0XOIxOo(xAxis, "null cannot be cast to non-null type com.github.mikephil.charting.components.XAxis");
        int i3 = 0;
        SimpleDateFormat oxXx0IX2 = com.sma.smartv3.util.xoIox.oxXx0IX(false, 1, null);
        ArrayList arrayList = new ArrayList();
        if (i2 >= 0) {
            while (true) {
                arrayList.add("");
                if (i3 == i2) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        getSleepStartTime().setText(TimeUtils.millis2String(i * 1000, oxXx0IX2));
        getSleepEndTime().setText(TimeUtils.millis2String((i + (i2 * 60)) * 1000, oxXx0IX2));
        xAxis.o0xxxXXxX(new ox.oOoXoXO(arrayList));
        xAxis.f4025ooXIXxIX = 0.0f;
        xAxis.OO(arrayList.size() / 4);
        xAxis.f4006IIX0o = arrayList.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateChartData(List<BarEntry> list) {
        if (getBarChart().getData() != 0 && ((o0xxxXXxX.oIX0oI) getBarChart().getData()).ooOOo0oXI() > 0) {
            ((o0xxxXXxX.oIX0oI) getBarChart().getData()).xXxxox0I(0);
        }
        o0xxxXXxX.II0xO0 iI0xO0 = new o0xxxXXxX.II0xO0(list, "SleepData");
        iI0xO0.OOxOI(0.0f);
        iI0xO0.xxxI(0.0f);
        o0xxxXXxX.oIX0oI oix0oi = new o0xxxXXxX.oIX0oI(iI0xO0);
        oix0oi.oo0xXOI0I(false);
        getBarChart().setData(oix0oi);
        getBarChart().II0XooXoX(1000);
        getBarChart().invalidate();
    }

    @OXOo.OOXIXo
    public final o0xxxXXxX.II0xO0 getSetValue() {
        o0xxxXXxX.II0xO0 iI0xO0 = this.setValue;
        if (iI0xO0 != null) {
            return iI0xO0;
        }
        IIX0o.XOxIOxOx("setValue");
        return null;
    }

    @OXOo.OOXIXo
    public final List<BarEntry> getValues() {
        return this.values;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        xxx00.oIX0oI oix0oi = xxx00.oIX0oI.f35574oIX0oI;
        BarChart barChart = getBarChart();
        IIX0o.oO(barChart, "<get-barChart>(...)");
        oix0oi.oIX0oI(barChart);
        YAxis axisLeft = getBarChart().getAxisLeft();
        IIX0o.oO(axisLeft, "getAxisLeft(...)");
        YAxis axisRight = getBarChart().getAxisRight();
        IIX0o.oO(axisRight, "getAxisRight(...)");
        oix0oi.II0XooXoX(axisLeft, axisRight, 300.0f, ContextCompat.getColor(getMActivity(), R.color.line_color));
        BarChart barChart2 = getBarChart();
        barChart2.setDrawValueAboveBar(false);
        barChart2.setTouchEnabled(false);
        barChart2.setScaleEnabled(false);
        barChart2.getAxisRight().Ioxxx(4, true);
        barChart2.getDescription().Oxx0IOOO(false);
        barChart2.getLegend().Oxx0IOOO(false);
        XAxis xAxis = getBarChart().getXAxis();
        IIX0o.x0XOIxOo(xAxis, "null cannot be cast to non-null type com.github.mikephil.charting.components.XAxis");
        Context context = getBarChart().getContext();
        IIX0o.oO(context, "getContext(...)");
        oix0oi.X0o0xo(xAxis, false, context);
        xxx00.II0xO0 iI0xO0 = new xxx00.II0xO0(getBarChart(), getBarChart().getAnimator(), getBarChart().getViewPortHandler());
        this.infoBarChartRender = iI0xO0;
        iI0xO0.X0IIOO(oIxOXo.oxoX.I0Io(getMActivity(), R.color.line_color));
        xxx00.II0xO0 iI0xO02 = this.infoBarChartRender;
        xxx00.II0xO0 iI0xO03 = null;
        if (iI0xO02 == null) {
            IIX0o.XOxIOxOx("infoBarChartRender");
            iI0xO02 = null;
        }
        iI0xO02.XI0IXoo(this.blockHeight);
        xxx00.II0xO0 iI0xO04 = this.infoBarChartRender;
        if (iI0xO04 == null) {
            IIX0o.XOxIOxOx("infoBarChartRender");
            iI0xO04 = null;
        }
        iI0xO04.OxI(this.block);
        xxx00.II0xO0 iI0xO05 = this.infoBarChartRender;
        if (iI0xO05 == null) {
            IIX0o.XOxIOxOx("infoBarChartRender");
            iI0xO05 = null;
        }
        iI0xO05.O0xOxO(new int[]{ContextCompat.getColor(getMActivity(), R.color.sleep_show_5), ContextCompat.getColor(getMActivity(), R.color.sleep_show_6), ContextCompat.getColor(getMActivity(), R.color.sleep_show_3), ContextCompat.getColor(getMActivity(), R.color.sleep_show_4), ContextCompat.getColor(getMActivity(), R.color.sleep_show_1), ContextCompat.getColor(getMActivity(), R.color.sleep_show_2)});
        xxx00.II0xO0 iI0xO06 = this.infoBarChartRender;
        if (iI0xO06 == null) {
            IIX0o.XOxIOxOx("infoBarChartRender");
            iI0xO06 = null;
        }
        iI0xO06.oI0IIXIo(4);
        BarChart barChart3 = getBarChart();
        xxx00.II0xO0 iI0xO07 = this.infoBarChartRender;
        if (iI0xO07 == null) {
            IIX0o.XOxIOxOx("infoBarChartRender");
        } else {
            iI0xO03 = iI0xO07;
        }
        barChart3.setRenderer(iI0xO03);
        super.initView();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_status_sleep_day;
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
        setRange(com.sma.smartv3.util.xoIox.o00(calendar, timePeriod, i));
        LogUtils.d(getRange());
        SleepDao sleepDao = this.mSleepDao;
        long j = getRange()[0];
        long j2 = com.sma.smartv3.util.xoIox.f24684IO;
        return sleepDao.getSleeps(j - j2, getRange()[1] - j2);
    }

    @OXOo.OOXIXo
    public final String setDataLabel() {
        return "sleep day Data";
    }

    public final void setSetValue(@OXOo.OOXIXo o0xxxXXxX.II0xO0 iI0xO0) {
        IIX0o.x0xO0oo(iI0xO0, "<set-?>");
        this.setValue = iI0xO0;
    }
}
