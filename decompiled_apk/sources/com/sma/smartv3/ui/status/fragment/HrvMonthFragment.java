package com.sma.smartv3.ui.status.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.HrvDao;
import com.sma.smartv3.db.entity.Hrv;
import com.sma.smartv3.model.HRVDataParse;
import com.sma.smartv3.model.HRVDayData;
import com.sma.smartv3.ui.status.base.BaseDetailsMonthFragment;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.view.text.DINCondBold;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class HrvMonthFragment extends BaseDetailsMonthFragment<Hrv> {
    private List<String> monthDays;
    public LineDataSet setValue;

    @OXOo.OOXIXo
    private final X0IIOO lineChart$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LineChart>() { // from class: com.sma.smartv3.ui.status.fragment.HrvMonthFragment$lineChart$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LineChart invoke() {
            View mView;
            mView = HrvMonthFragment.this.getMView();
            return (LineChart) mView.findViewById(R.id.lineChart);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO minValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.HrvMonthFragment$minValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = HrvMonthFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.minValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO maxValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.HrvMonthFragment$maxValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = HrvMonthFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.maxValue);
        }
    });

    @OXOo.OOXIXo
    private final List<Entry> values = new ArrayList();

    @OXOo.OOXIXo
    private final LinkedHashMap<Long, ArrayList<Hrv>> monthData = new LinkedHashMap<>();

    @OXOo.OOXIXo
    private final HrvDao mHrvDao = MyDb.INSTANCE.getMDatabase().hrvDao();

    @OXOo.OOXIXo
    private final List<HRVDayData> hrvDayDataList = new ArrayList();

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
            HrvMonthFragment.this.updateItemData(e);
            List list = HrvMonthFragment.this.monthDays;
            if (list == null) {
                IIX0o.XOxIOxOx("monthDays");
                list = null;
            }
            List<String> o02 = com.sma.smartv3.util.xoIox.o0((String) list.get((int) e.xxIXOIIO()));
            HrvMonthFragment.this.getNowTimeDetails().setText(o02.get(0) + IOUtils.DIR_SEPARATOR_UNIX + o02.get(1));
        }
    }

    private final void filterData(List<Hrv> list) {
        this.values.clear();
        HRVDataParse.INSTANCE.filterDayData(getMActivity(), list, this.monthData, this.hrvDayDataList, this.values);
        getMinValue().setText(UtilsKt.OxxIIOOXO(0));
        getMaxValue().setText(UtilsKt.OxxIIOOXO(0));
        getNowValue().setText(UtilsKt.OxxIIOOXO(0));
        updateChartData(this.values);
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

    private final void setChartxAxis() {
        XAxis xAxis = getLineChart().getXAxis();
        xxx00.oIX0oI oix0oi = xxx00.oIX0oI.f35574oIX0oI;
        IIX0o.ooOOo0oXI(xAxis);
        Context context = getLineChart().getContext();
        IIX0o.oO(context, "getContext(...)");
        int i = 0;
        oix0oi.X0o0xo(xAxis, false, context);
        xAxis.OO(5.0f);
        xAxis.I0X0x0oIo(0.0f);
        List<String> list = this.monthDays;
        List<String> list2 = null;
        if (list == null) {
            IIX0o.XOxIOxOx("monthDays");
            list = null;
        }
        xAxis.xXOx(list.size());
        ArrayList arrayList = new ArrayList();
        List<String> list3 = this.monthDays;
        if (list3 == null) {
            IIX0o.XOxIOxOx("monthDays");
        } else {
            list2 = list3;
        }
        Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            i++;
            it.next();
            arrayList.add(String.valueOf(i));
        }
        xAxis.o0xxxXXxX(new ox.oOoXoXO(arrayList));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateChartData(List<Entry> list) {
        float xxIXOIIO2;
        setChartxAxis();
        if (getLineChart().getData() != 0 && ((o0xxxXXxX.ooOOo0oXI) getLineChart().getData()).ooOOo0oXI() > 0) {
            T OOXIXo2 = ((o0xxxXXxX.ooOOo0oXI) getLineChart().getData()).OOXIXo(0);
            IIX0o.x0XOIxOo(OOXIXo2, "null cannot be cast to non-null type com.github.mikephil.charting.data.LineDataSet");
            setSetValue((LineDataSet) OOXIXo2);
            getSetValue().oX0ooo0I0(list);
            getSetValue().I0xX0();
            ((o0xxxXXxX.ooOOo0oXI) getLineChart().getData()).XxX0x0xxx();
            getLineChart().X00IoxXI();
        } else {
            setSetValue(new LineDataSet(list, setDataLabel()));
            getSetValue().OX(ContextCompat.getColor(getMActivity(), R.color.hrv_color));
            getSetValue().X0ooXIooI(ContextCompat.getColor(getMActivity(), R.color.hrv_color));
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
        if (list.size() == 0) {
            xxIXOIIO2 = 0.0f;
        } else {
            xxIXOIIO2 = list.get(list.size() - 1).xxIXOIIO();
        }
        lineChart.XIxXXX0x0(xxIXOIIO2, 0);
    }

    public final void clearCache(long j) {
        this.monthData.clear();
        List<String> list = this.monthDays;
        if (list == null) {
            IIX0o.XOxIOxOx("monthDays");
            list = null;
        }
        int size = list.size();
        int i = 1;
        if (1 > size) {
            return;
        }
        while (true) {
            this.monthData.put(Long.valueOf((86400 * i * 1000) + j), new ArrayList<>());
            if (i != size) {
                i++;
            } else {
                return;
            }
        }
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

    @OXOo.OOXIXo
    public final List<Entry> getValues() {
        return this.values;
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
        oix0oi.Oxx0IOOO(axisLeft, axisRight, 200.0f, 0.0f, ContextCompat.getColor(getMActivity(), R.color.line_color));
        this.monthDays = com.sma.smartv3.util.xoIox.Oo(getMCalendar().getTimeInMillis());
        setChartxAxis();
        LineChart lineChart2 = getLineChart();
        lineChart2.getDescription().Oxx0IOOO(false);
        lineChart2.getLegend().Oxx0IOOO(false);
        lineChart2.setScaleEnabled(false);
        xxx00.I0Io i0Io = new xxx00.I0Io(getLineChart(), getLineChart().getAnimator(), getLineChart().getViewPortHandler());
        i0Io.xxX(oIxOXo.oxoX.I0Io(getMActivity(), R.color.line_color));
        getLineChart().setRenderer(i0Io);
        getLineChart().setOnChartValueSelectedListener(new oIX0oI());
        getTvCurrent().setText(com.sma.smartv3.util.xoIox.IIXOooo(getMCalendar(), 0, getMTimePeriod()));
        super.initView();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_status_hrv_day;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    public void onDataChange(@OXOo.OOXIXo List<Hrv> data) {
        IIX0o.x0xO0oo(data, "data");
        filterData(data);
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    @OXOo.OOXIXo
    public List<Hrv> onTimePeriodChange(@OXOo.OOXIXo Calendar calendar, int i, @OXOo.OOXIXo TimePeriod timePeriod) {
        IIX0o.x0xO0oo(calendar, "calendar");
        IIX0o.x0xO0oo(timePeriod, "timePeriod");
        long[] o002 = com.sma.smartv3.util.xoIox.o00(calendar, timePeriod, i);
        this.monthDays = com.sma.smartv3.util.xoIox.Oo(o002[0]);
        clearCache(o002[0]);
        return this.mHrvDao.getHrv(o002[0], o002[1]);
    }

    @OXOo.OOXIXo
    public final String setDataLabel() {
        return "HRV month Data";
    }

    public final void setSetValue(@OXOo.OOXIXo LineDataSet lineDataSet) {
        IIX0o.x0xO0oo(lineDataSet, "<set-?>");
        this.setValue = lineDataSet;
    }

    public final void updateItemData(@OXOo.OOXIXo Entry e) {
        IIX0o.x0xO0oo(e, "e");
        HRVDayData hRVDayData = this.hrvDayDataList.get((int) e.xxIXOIIO());
        getMinValue().setText(UtilsKt.OxxIIOOXO(hRVDayData.getMin()));
        getMaxValue().setText(UtilsKt.OxxIIOOXO(hRVDayData.getMax()));
        getNowValue().setText(UtilsKt.OxxIIOOXO(hRVDayData.getAvg()));
    }
}
