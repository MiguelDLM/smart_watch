package com.sma.smartv3.ui.status.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.BloodGlucoseDao;
import com.sma.smartv3.db.entity.BloodGlucose;
import com.sma.smartv3.model.BloodGlucoseDataParse;
import com.sma.smartv3.model.BloodGlucoseDayData;
import com.sma.smartv3.ui.status.base.BaseDetailsWeekFragment;
import com.sma.smartv3.util.O00XxXI;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.view.text.DINCondBold;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;

/* loaded from: classes12.dex */
public final class BloodGlucoseWeekFragment extends BaseDetailsWeekFragment<BloodGlucose> {
    public LineDataSet setValue;

    @OXOo.OOXIXo
    private final X0IIOO lineChart$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LineChart>() { // from class: com.sma.smartv3.ui.status.fragment.BloodGlucoseWeekFragment$lineChart$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LineChart invoke() {
            View mView;
            mView = BloodGlucoseWeekFragment.this.getMView();
            return (LineChart) mView.findViewById(R.id.lineChart);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO minValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.BloodGlucoseWeekFragment$minValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = BloodGlucoseWeekFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.minValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO maxValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.BloodGlucoseWeekFragment$maxValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = BloodGlucoseWeekFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.maxValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO avgValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.BloodGlucoseWeekFragment$avgValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = BloodGlucoseWeekFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.avValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO monitorRetVal$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.BloodGlucoseWeekFragment$monitorRetVal$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = BloodGlucoseWeekFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.monitoring_results_value);
        }
    });

    @OXOo.OOXIXo
    private final List<Entry> values = new ArrayList();

    @OXOo.OOXIXo
    private final LinkedHashMap<Long, ArrayList<BloodGlucose>> weekData = new LinkedHashMap<>();

    @OXOo.OOXIXo
    private final BloodGlucoseDao mBloodGlucoseDao = MyDb.INSTANCE.getMDatabase().bloodGlucoseDao();

    @OXOo.OOXIXo
    private final List<BloodGlucoseDayData> bloodGlucoseDayDataList = new ArrayList();

    /* loaded from: classes12.dex */
    public static final class II0xO0 extends ox.oOoXoXO {
        @Override // ox.oOoXoXO, ox.x0xO0oo
        @OXOo.OOXIXo
        public String II0XooXoX(float f) {
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(f / 10.0f)}, 1));
            IIX0o.oO(format, "format(...)");
            return format;
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements ooOx.oIX0oI {
        public oIX0oI() {
        }

        @Override // ooOx.oIX0oI
        public void II0xO0() {
        }

        @Override // ooOx.oIX0oI
        public void oIX0oI(@OXOo.OOXIXo Entry e, @OXOo.OOXIXo XI0oooXX.oxoX h) {
            IIX0o.x0xO0oo(e, "e");
            IIX0o.x0xO0oo(h, "h");
            BloodGlucoseWeekFragment.this.updateItemData(e);
            O00XxXI o00XxXI = BloodGlucoseWeekFragment.this.getWeekDay().get((int) e.xxIXOIIO());
            List<String> o02 = com.sma.smartv3.util.xoIox.o0(o00XxXI.X0o0xo());
            BloodGlucoseWeekFragment.this.getNowTimeDetails().setText(o02.get(0) + IOUtils.DIR_SEPARATOR_UNIX + o02.get(1) + TokenParser.SP + o00XxXI.XO());
        }
    }

    private final DINCondBold getAvgValue() {
        return (DINCondBold) this.avgValue$delegate.getValue();
    }

    private final LineChart getLineChart() {
        return (LineChart) this.lineChart$delegate.getValue();
    }

    private final DINCondBold getMaxValue() {
        return (DINCondBold) this.maxValue$delegate.getValue();
    }

    private final DINCondBold getMinValue() {
        return (DINCondBold) this.minValue$delegate.getValue();
    }

    private final DINCondBold getMonitorRetVal() {
        return (DINCondBold) this.monitorRetVal$delegate.getValue();
    }

    public final void clearCache(long j) {
        this.weekData.clear();
        for (int i = 1; i < 8; i++) {
            this.weekData.put(Long.valueOf((86400 * i * 1000) + j), new ArrayList<>());
        }
    }

    public final void filterData(@OXOo.OOXIXo List<BloodGlucose> bloodGlucoses) {
        IIX0o.x0xO0oo(bloodGlucoses, "bloodGlucoses");
        this.values.clear();
        BloodGlucoseDataParse.INSTANCE.filterDayData(getMActivity(), bloodGlucoses, this.weekData, this.bloodGlucoseDayDataList, this.values);
        getMinValue().setText(UtilsKt.xoIox(0));
        getMaxValue().setText(UtilsKt.xoIox(0));
        getAvgValue().setText(UtilsKt.xoIox(0));
        getNowValue().setText(UtilsKt.xoIox(0));
        DINCondBold monitorRetVal = getMonitorRetVal();
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("%s", Arrays.copyOf(new Object[]{HelpFormatter.DEFAULT_LONG_OPT_PREFIX}, 1));
        IIX0o.oO(format, "format(...)");
        monitorRetVal.setText(format);
        updateChartData(this.values);
    }

    @OXOo.OOXIXo
    public final LineDataSet getSetValue() {
        LineDataSet lineDataSet = this.setValue;
        if (lineDataSet != null) {
            return lineDataSet;
        }
        IIX0o.XOxIOxOx("setValue");
        return null;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        xxx00.oIX0oI oix0oi = xxx00.oIX0oI.f35574oIX0oI;
        LineChart lineChart = getLineChart();
        IIX0o.oO(lineChart, "<get-lineChart>(...)");
        oix0oi.II0xO0(lineChart);
        YAxis axisLeft = getLineChart().getAxisLeft();
        IIX0o.oO(axisLeft, "getAxisLeft(...)");
        YAxis axisRight = getLineChart().getAxisRight();
        IIX0o.oO(axisRight, "getAxisRight(...)");
        oix0oi.Oxx0IOOO(axisLeft, axisRight, 80.0f, 0.0f, ContextCompat.getColor(getMActivity(), R.color.line_color));
        setWeekDay(com.sma.smartv3.util.xoIox.XI0IXoo(getMCalendar().getTimeInMillis()));
        XAxis xAxis = getLineChart().getXAxis();
        IIX0o.ooOOo0oXI(xAxis);
        Context context = getLineChart().getContext();
        IIX0o.oO(context, "getContext(...)");
        oix0oi.X0o0xo(xAxis, false, context);
        xAxis.IoOoo(true);
        xAxis.OO(1.0f);
        xAxis.I0X0x0oIo(-1.0f);
        xAxis.xXOx(7.0f);
        ArrayList arrayList = new ArrayList();
        Iterator<O00XxXI> it = getWeekDay().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().XO());
        }
        xAxis.o0xxxXXxX(new ox.oOoXoXO(arrayList));
        LineChart lineChart2 = getLineChart();
        lineChart2.getDescription().Oxx0IOOO(false);
        lineChart2.getLegend().Oxx0IOOO(false);
        lineChart2.setScaleEnabled(false);
        xxx00.I0Io i0Io = new xxx00.I0Io(getLineChart(), getLineChart().getAnimator(), getLineChart().getViewPortHandler());
        i0Io.xxX(oIxOXo.oxoX.I0Io(getMActivity(), R.color.line_color));
        getLineChart().setRenderer(i0Io);
        getLineChart().setOnChartValueSelectedListener(new oIX0oI());
        getLineChart().getAxisRight().o0xxxXXxX(new II0xO0());
        getTvCurrent().setText(com.sma.smartv3.util.xoIox.IIXOooo(getMCalendar(), 0, getMTimePeriod()));
        ((LinearLayout) getMView().findViewById(R.id.ll_max_value)).setVisibility(8);
        ((LinearLayout) getMView().findViewById(R.id.ll_min_value)).setVisibility(8);
        ((LinearLayout) getMView().findViewById(R.id.ll_monitoring_results_value)).setVisibility(0);
        super.initView();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_status_blood_glucose_week;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    public void onDataChange(@OXOo.OOXIXo List<BloodGlucose> data) {
        IIX0o.x0xO0oo(data, "data");
        filterData(data);
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    @OXOo.OOXIXo
    public List<BloodGlucose> onTimePeriodChange(@OXOo.OOXIXo Calendar calendar, int i, @OXOo.OOXIXo TimePeriod timePeriod) {
        IIX0o.x0xO0oo(calendar, "calendar");
        IIX0o.x0xO0oo(timePeriod, "timePeriod");
        long[] o002 = com.sma.smartv3.util.xoIox.o00(calendar, timePeriod, i);
        setWeekDay(com.sma.smartv3.util.xoIox.XI0IXoo(o002[0]));
        clearCache(o002[0]);
        return this.mBloodGlucoseDao.getListDesc(o002[0], o002[1]);
    }

    @OXOo.OOXIXo
    public final String setDataLabel() {
        return "BloodOxyGen week Data";
    }

    public final void setSetValue(@OXOo.OOXIXo LineDataSet lineDataSet) {
        IIX0o.x0xO0oo(lineDataSet, "<set-?>");
        this.setValue = lineDataSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateChartData(@OXOo.OOXIXo List<Entry> values) {
        float xxIXOIIO2;
        IIX0o.x0xO0oo(values, "values");
        if (getLineChart().getData() != 0 && ((o0xxxXXxX.ooOOo0oXI) getLineChart().getData()).ooOOo0oXI() > 0) {
            T OOXIXo2 = ((o0xxxXXxX.ooOOo0oXI) getLineChart().getData()).OOXIXo(0);
            IIX0o.x0XOIxOo(OOXIXo2, "null cannot be cast to non-null type com.github.mikephil.charting.data.LineDataSet");
            setSetValue((LineDataSet) OOXIXo2);
            getSetValue().oX0ooo0I0(values);
            getSetValue().I0xX0();
            ((o0xxxXXxX.ooOOo0oXI) getLineChart().getData()).XxX0x0xxx();
            getLineChart().X00IoxXI();
        } else {
            setSetValue(new LineDataSet(values, setDataLabel()));
            getSetValue().OX(ContextCompat.getColor(getMActivity(), R.color.bog_color));
            getSetValue().X0ooXIooI(ContextCompat.getColor(getMActivity(), R.color.bog_color));
            getSetValue().oXxx000(2.0f);
            getSetValue().xIXIOX(1.0f);
            getSetValue().X0IOOI(false);
            getSetValue().ooOOo0oXI(false);
            getSetValue().oI(true);
            Drawable drawable = ContextCompat.getDrawable(getMActivity(), R.drawable.shape_hr);
            IIX0o.x0XOIxOo(drawable, "null cannot be cast to non-null type android.graphics.drawable.Drawable");
            getSetValue().xIx0XO(drawable);
            o0xxxXXxX.ooOOo0oXI ooooo0oxi = new o0xxxXXxX.ooOOo0oXI(getSetValue());
            ooooo0oxi.oo0xXOI0I(false);
            getLineChart().setData(ooooo0oxi);
        }
        getLineChart().II0XooXoX(1000);
        getLineChart().invalidate();
        LineChart lineChart = getLineChart();
        if (values.size() == 0) {
            xxIXOIIO2 = 0.0f;
        } else {
            xxIXOIIO2 = values.get(values.size() - 1).xxIXOIIO();
        }
        lineChart.XIxXXX0x0(xxIXOIIO2, 0);
    }

    public final void updateItemData(@OXOo.OOXIXo Entry e) {
        IIX0o.x0xO0oo(e, "e");
        BloodGlucoseDayData bloodGlucoseDayData = this.bloodGlucoseDayDataList.get((int) e.xxIXOIIO());
        getMinValue().setText(UtilsKt.xoIox(bloodGlucoseDayData.getMin()));
        getMaxValue().setText(UtilsKt.xoIox(bloodGlucoseDayData.getMax()));
        getAvgValue().setText(UtilsKt.xoIox(bloodGlucoseDayData.getAvg()));
        getNowValue().setText(UtilsKt.xoIox(bloodGlucoseDayData.getAvg()));
        getMonitorRetVal().setText(bloodGlucoseDayData.getStatus());
    }
}
