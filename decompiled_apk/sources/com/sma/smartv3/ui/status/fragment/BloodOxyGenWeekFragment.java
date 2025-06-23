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
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.BloodOxygenDao;
import com.sma.smartv3.db.entity.BloodOxygen;
import com.sma.smartv3.model.BloodOxyGenDataParse;
import com.sma.smartv3.model.BloodOxyGenDayData;
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
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oxxXoxO;

@XX({"SMAP\nBloodOxyGenWeekFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BloodOxyGenWeekFragment.kt\ncom/sma/smartv3/ui/status/fragment/BloodOxyGenWeekFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,214:1\n1855#2,2:215\n*S KotlinDebug\n*F\n+ 1 BloodOxyGenWeekFragment.kt\ncom/sma/smartv3/ui/status/fragment/BloodOxyGenWeekFragment\n*L\n165#1:215,2\n*E\n"})
/* loaded from: classes12.dex */
public final class BloodOxyGenWeekFragment extends BaseDetailsWeekFragment<BloodOxygen> {
    private float highlight;
    public LineDataSet setValue;

    @OXOo.OOXIXo
    private final X0IIOO lineChart$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LineChart>() { // from class: com.sma.smartv3.ui.status.fragment.BloodOxyGenWeekFragment$lineChart$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LineChart invoke() {
            View mView;
            mView = BloodOxyGenWeekFragment.this.getMView();
            return (LineChart) mView.findViewById(R.id.lineChart);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO minValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.BloodOxyGenWeekFragment$minValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = BloodOxyGenWeekFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.minValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO maxValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.BloodOxyGenWeekFragment$maxValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = BloodOxyGenWeekFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.maxValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO avgValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.BloodOxyGenWeekFragment$avgValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = BloodOxyGenWeekFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.avValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO monitorRetVal$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.BloodOxyGenWeekFragment$monitorRetVal$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = BloodOxyGenWeekFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.monitoring_results_value);
        }
    });

    @OXOo.OOXIXo
    private final List<Entry> values = new ArrayList();

    @OXOo.OOXIXo
    private final LinkedHashMap<Long, ArrayList<BloodOxygen>> weekData = new LinkedHashMap<>();

    @OXOo.OOXIXo
    private final BloodOxygenDao mBloodOxyGenDao = MyDb.INSTANCE.getMDatabase().bloodOxygenDao();

    @OXOo.OOXIXo
    private final List<BloodOxyGenDayData> bloodOxyGenDayDataList = new ArrayList();

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
            BloodOxyGenWeekFragment.this.updateItemData(e);
            O00XxXI o00XxXI = BloodOxyGenWeekFragment.this.getWeekDay().get((int) e.xxIXOIIO());
            List<String> o02 = com.sma.smartv3.util.xoIox.o0(o00XxXI.X0o0xo());
            BloodOxyGenWeekFragment.this.getNowTimeDetails().setText(o02.get(0) + IOUtils.DIR_SEPARATOR_UNIX + o02.get(1) + TokenParser.SP + o00XxXI.XO());
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
        if (ProjectManager.f19822oIX0oI.IxX00()) {
            for (int i = 2; i < 9; i++) {
                this.weekData.put(Long.valueOf((i * 86400 * 1000) + j), new ArrayList<>());
            }
            return;
        }
        for (int i2 = 1; i2 < 8; i2++) {
            this.weekData.put(Long.valueOf((i2 * 86400 * 1000) + j), new ArrayList<>());
        }
    }

    public final void filterData(@OXOo.OOXIXo List<BloodOxygen> bloodOxyGens) {
        IIX0o.x0xO0oo(bloodOxyGens, "bloodOxyGens");
        this.values.clear();
        BloodOxyGenDataParse.INSTANCE.filterDayData(getMActivity(), bloodOxyGens, this.weekData, this.bloodOxyGenDayDataList, this.values);
        getMinValue().setText(UtilsKt.OxxIIOOXO(0));
        getMaxValue().setText(UtilsKt.OxxIIOOXO(0));
        getAvgValue().setText(UtilsKt.OxxIIOOXO(0));
        getNowValue().setText(UtilsKt.OxxIIOOXO(0));
        DINCondBold monitorRetVal = getMonitorRetVal();
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("%s", Arrays.copyOf(new Object[]{HelpFormatter.DEFAULT_LONG_OPT_PREFIX}, 1));
        IIX0o.oO(format, "format(...)");
        monitorRetVal.setText(format);
        updateChartData(this.values);
    }

    public final float getHighlight() {
        return this.highlight;
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
        oix0oi.Oxx0IOOO(axisLeft, axisRight, 100.0f, 0.0f, ContextCompat.getColor(getMActivity(), R.color.line_color));
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
        getTvCurrent().setText(com.sma.smartv3.util.xoIox.IIXOooo(getMCalendar(), 0, getMTimePeriod()));
        ((LinearLayout) getMView().findViewById(R.id.ll_max_value)).setVisibility(8);
        ((LinearLayout) getMView().findViewById(R.id.ll_min_value)).setVisibility(8);
        ((LinearLayout) getMView().findViewById(R.id.ll_monitoring_results_value)).setVisibility(0);
        super.initView();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_status_blood_oxygen_day;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    public void onDataChange(@OXOo.OOXIXo List<BloodOxygen> data) {
        IIX0o.x0xO0oo(data, "data");
        filterData(data);
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    @OXOo.OOXIXo
    public List<BloodOxygen> onTimePeriodChange(@OXOo.OOXIXo Calendar calendar, int i, @OXOo.OOXIXo TimePeriod timePeriod) {
        IIX0o.x0xO0oo(calendar, "calendar");
        IIX0o.x0xO0oo(timePeriod, "timePeriod");
        long[] o002 = com.sma.smartv3.util.xoIox.o00(calendar, timePeriod, i);
        setWeekDay(com.sma.smartv3.util.xoIox.XI0IXoo(o002[0]));
        clearCache(o002[0]);
        return this.mBloodOxyGenDao.getBloodOxygen(o002[0], o002[1]);
    }

    @OXOo.OOXIXo
    public final String setDataLabel() {
        return "BloodOxyGen week Data";
    }

    public final void setHighlight(float f) {
        this.highlight = f;
    }

    public final void setSetValue(@OXOo.OOXIXo LineDataSet lineDataSet) {
        IIX0o.x0xO0oo(lineDataSet, "<set-?>");
        this.setValue = lineDataSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateChartData(@OXOo.OOXIXo List<Entry> values) {
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
        for (Entry entry : values) {
            if (entry.I0Io() > 0.0f) {
                this.highlight = entry.xxIXOIIO();
            }
        }
        getLineChart().XIxXXX0x0(this.highlight, 0);
    }

    public final void updateItemData(@OXOo.OOXIXo Entry e) {
        IIX0o.x0xO0oo(e, "e");
        BloodOxyGenDayData bloodOxyGenDayData = this.bloodOxyGenDayDataList.get((int) e.xxIXOIIO());
        getMinValue().setText(UtilsKt.OxxIIOOXO(bloodOxyGenDayData.getMin()));
        getMaxValue().setText(UtilsKt.OxxIIOOXO(bloodOxyGenDayData.getMax()));
        getAvgValue().setText(UtilsKt.OxxIIOOXO(bloodOxyGenDayData.getAvg()));
        getNowValue().setText(UtilsKt.OxxIIOOXO(bloodOxyGenDayData.getAvg()));
        getMonitorRetVal().setText(bloodOxyGenDayData.getStatus());
    }
}
