package com.sma.smartv3.ui.status.fragment;

import android.content.Context;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.ElectrocardiogramDao;
import com.sma.smartv3.db.entity.Electrocardiogram;
import com.sma.smartv3.model.ECGDataParse;
import com.sma.smartv3.model.ECGDayData;
import com.sma.smartv3.ui.status.base.BaseDetailDaysFragment;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.view.MyLineChart;
import com.sma.smartv3.view.text.DINCondBold;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class EcgDayFragment extends BaseDetailDaysFragment<Electrocardiogram> {
    public LineDataSet setValue;
    private float xTargetNumber;

    @OXOo.OOXIXo
    private final String TAG = "EcgDayFragment";

    @OXOo.OOXIXo
    private final X0IIOO lineChart$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<MyLineChart>() { // from class: com.sma.smartv3.ui.status.fragment.EcgDayFragment$lineChart$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final MyLineChart invoke() {
            View mView;
            mView = EcgDayFragment.this.getMView();
            return (MyLineChart) mView.findViewById(R.id.lineChart);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO minEcgValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.EcgDayFragment$minEcgValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = EcgDayFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.minHrValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO maxEcgValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.EcgDayFragment$maxEcgValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = EcgDayFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.maxHrValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO avEcgValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.EcgDayFragment$avEcgValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = EcgDayFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.avHrValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO measurePanel$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.fragment.EcgDayFragment$measurePanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = EcgDayFragment.this.getMView();
            return mView.findViewById(R.id.measure_panel);
        }
    });

    @OXOo.OOXIXo
    private final List<Entry> values = new ArrayList();
    private final int dayMinute = com.sma.smartv3.util.xoIox.oIX0oI() * 60;

    @OXOo.OOXIXo
    private final ElectrocardiogramDao mElectrocardiogram = MyDb.INSTANCE.getMDatabase().electrocardiogramDao();
    private final float mAxisMaximum = 200.0f;

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements ooOx.oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f24069II0xO0;

        public oIX0oI(SimpleDateFormat simpleDateFormat) {
            this.f24069II0xO0 = simpleDateFormat;
        }

        @Override // ooOx.oIX0oI
        public void II0xO0() {
        }

        @Override // ooOx.oIX0oI
        public void oIX0oI(@OXOo.OOXIXo Entry e, @OXOo.OOXIXo XI0oooXX.oxoX h) {
            IIX0o.x0xO0oo(e, "e");
            IIX0o.x0xO0oo(h, "h");
            EcgDayFragment.this.updateItemData(e);
            int xxIXOIIO2 = (int) e.xxIXOIIO();
            Calendar calendar = Calendar.getInstance();
            int i = xxIXOIIO2 / 60;
            calendar.set(11, i / 60);
            calendar.set(12, i % 60);
            calendar.set(13, xxIXOIIO2 % 60);
            EcgDayFragment.this.getNowTimeDetails().setText(TimeUtils.millis2String(calendar.getTimeInMillis(), this.f24069II0xO0));
        }
    }

    private final void filterData(List<Electrocardiogram> list) {
        LogUtils.d(this.TAG + " filterData heartRates.size = " + list.size());
        this.values.clear();
        ECGDayData eCGDayData = new ECGDayData(0, 0, 0, null, 15, null);
        if (!list.isEmpty()) {
            eCGDayData = ECGDataParse.INSTANCE.filterMinuteData(getRange(), list, this.values);
        }
        getMinEcgValue().setText(UtilsKt.OxxIIOOXO(eCGDayData.getMin()));
        getMaxEcgValue().setText(UtilsKt.OxxIIOOXO(eCGDayData.getMax()));
        getAvEcgValue().setText(UtilsKt.OxxIIOOXO(eCGDayData.getAvg()));
        getNowValue().setText(UtilsKt.OxxIIOOXO(eCGDayData.getAvg()));
        MyLineChart lineChart = getLineChart();
        if (this.values.size() == 0) {
            lineChart.setDragEnabled(false);
            lineChart.setDisallowIntercept(false);
            lineChart.IoIOOxIIo(0.0f, 1.0f, 0.0f, 0.0f);
        } else {
            lineChart.setDisallowIntercept(true);
            lineChart.setDragEnabled(true);
            lineChart.IoIOOxIIo(150.0f, 1.0f, 0.0f, 0.0f);
        }
        updateChartData(this.values);
    }

    private final DINCondBold getAvEcgValue() {
        return (DINCondBold) this.avEcgValue$delegate.getValue();
    }

    private final MyLineChart getLineChart() {
        return (MyLineChart) this.lineChart$delegate.getValue();
    }

    private final DINCondBold getMaxEcgValue() {
        return (DINCondBold) this.maxEcgValue$delegate.getValue();
    }

    private final View getMeasurePanel() {
        return (View) this.measurePanel$delegate.getValue();
    }

    private final DINCondBold getMinEcgValue() {
        return (DINCondBold) this.minEcgValue$delegate.getValue();
    }

    private final void setLineChartXAxis() {
        XAxis xAxis = getLineChart().getXAxis();
        xxx00.oIX0oI oix0oi = xxx00.oIX0oI.f35574oIX0oI;
        IIX0o.ooOOo0oXI(xAxis);
        Context context = getLineChart().getContext();
        IIX0o.oO(context, "getContext(...)");
        oix0oi.X0o0xo(xAxis, true, context);
        int i = 0;
        setRange(com.sma.smartv3.util.xoIox.OxI(null, TimePeriod.DAY, 0, 5, null));
        this.xTargetNumber = this.dayMinute;
        getLineChart().getXAxis().OO(this.xTargetNumber / 6);
        xAxis.I0X0x0oIo(-1.0f);
        xAxis.xXOx(this.dayMinute + 1.0f);
        ArrayList arrayList = new ArrayList();
        int i2 = this.dayMinute;
        if (i2 >= 0) {
            while (true) {
                arrayList.add(String.valueOf((i / 60) / 60));
                if (i == i2) {
                    break;
                } else {
                    i++;
                }
            }
        }
        xAxis.o0xxxXXxX(new ox.oOoXoXO(arrayList));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateChartData(List<Entry> list) {
        float xxIXOIIO2;
        LogUtils.d(this.TAG + " updateChartData values.size = " + list.size());
        if (getLineChart().getData() != 0 && ((o0xxxXXxX.ooOOo0oXI) getLineChart().getData()).ooOOo0oXI() > 0) {
            T OOXIXo2 = ((o0xxxXXxX.ooOOo0oXI) getLineChart().getData()).OOXIXo(0);
            IIX0o.x0XOIxOo(OOXIXo2, "null cannot be cast to non-null type com.github.mikephil.charting.data.LineDataSet");
            setSetValue((LineDataSet) OOXIXo2);
            getSetValue().oX0ooo0I0(list);
            getSetValue().xox(LineDataSet.Mode.HORIZONTAL_BEZIER);
            getSetValue().I0xX0();
            ((o0xxxXXxX.ooOOo0oXI) getLineChart().getData()).XxX0x0xxx();
            getLineChart().X00IoxXI();
        } else {
            setSetValue(new LineDataSet(list, setDataLabel()));
            getSetValue().OX(ContextCompat.getColor(getMActivity(), R.color.hr_color));
            getSetValue().X0ooXIooI(ContextCompat.getColor(getMActivity(), R.color.hr_color));
            getSetValue().oXxx000(1.0f);
            getSetValue().xIXIOX(1.0f);
            getSetValue().Oxo00O(false);
            getSetValue().X0IOOI(false);
            getSetValue().ooOOo0oXI(false);
            getSetValue().oI(false);
            getSetValue().xox(LineDataSet.Mode.HORIZONTAL_BEZIER);
            o0xxxXXxX.ooOOo0oXI ooooo0oxi = new o0xxxXXxX.ooOOo0oXI(getSetValue());
            ooooo0oxi.oo0xXOI0I(false);
            getLineChart().setData(ooooo0oxi);
        }
        getLineChart().II0XooXoX(1000);
        getLineChart().invalidate();
        MyLineChart lineChart = getLineChart();
        if (list.size() == 0) {
            xxIXOIIO2 = 0.0f;
        } else {
            if (list.size() > 60) {
                getLineChart().xX0IIXIx0(list.get(list.size() - 50).xxIXOIIO());
            } else {
                getLineChart().xX0IIXIx0(list.get(0).xxIXOIIO());
            }
            xxIXOIIO2 = list.get(list.size() - 1).xxIXOIIO();
        }
        lineChart.XIxXXX0x0(xxIXOIIO2, 0);
    }

    public final float getMAxisMaximum() {
        return this.mAxisMaximum;
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

    public final float getXTargetNumber() {
        return this.xTargetNumber;
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        LogUtils.d(this.TAG + " initView");
        View measurePanel = getMeasurePanel();
        if (measurePanel != null) {
            measurePanel.setVisibility(8);
        }
        xxx00.oIX0oI oix0oi = xxx00.oIX0oI.f35574oIX0oI;
        MyLineChart lineChart = getLineChart();
        IIX0o.oO(lineChart, "<get-lineChart>(...)");
        oix0oi.II0xO0(lineChart);
        YAxis axisLeft = getLineChart().getAxisLeft();
        IIX0o.oO(axisLeft, "getAxisLeft(...)");
        YAxis axisRight = getLineChart().getAxisRight();
        IIX0o.oO(axisRight, "getAxisRight(...)");
        oix0oi.Oxx0IOOO(axisLeft, axisRight, 0.0f, 30.0f, ContextCompat.getColor(getMActivity(), R.color.line_color));
        setLineChartXAxis();
        MyLineChart lineChart2 = getLineChart();
        lineChart2.getDescription().Oxx0IOOO(false);
        lineChart2.getLegend().Oxx0IOOO(false);
        lineChart2.setScaleEnabled(false);
        lineChart2.getAxisLeft().xXOx(this.mAxisMaximum);
        lineChart2.getAxisRight().xXOx(this.mAxisMaximum);
        xxx00.I0Io i0Io = new xxx00.I0Io(getLineChart(), getLineChart().getAnimator(), getLineChart().getViewPortHandler());
        i0Io.xxX(oIxOXo.oxoX.I0Io(getMActivity(), R.color.line_color));
        getLineChart().setRenderer(i0Io);
        getLineChart().setOnChartValueSelectedListener(new oIX0oI(com.sma.smartv3.util.xoIox.IIX0o()));
        super.initView();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_status_ecg_day;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    public void onDataChange(@OXOo.OOXIXo List<Electrocardiogram> data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.d(this.TAG + " onDataChange");
        filterData(data);
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24567II0xO0)
    public final void onHeartRateChanged(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.XO("onHeartRateChanged! refresh");
        setMOffset(0);
        update(getMCalendar(), getMOffset(), getMTimePeriod());
        String IIXOooo2 = com.sma.smartv3.util.xoIox.IIXOooo(getMCalendar(), getMOffset(), getMTimePeriod());
        if (TimePeriod.DAY == getMTimePeriod()) {
            if (IIX0o.Oxx0IOOO(com.sma.smartv3.util.xoIox.oo0xXOI0I().format(new Date()), IIXOooo2)) {
                getTvCurrent().setText(R.string.today);
            } else {
                getTvCurrent().setText(IIXOooo2);
            }
        }
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    @OXOo.OOXIXo
    public List<Electrocardiogram> onTimePeriodChange(@OXOo.OOXIXo Calendar calendar, int i, @OXOo.OOXIXo TimePeriod timePeriod) {
        IIX0o.x0xO0oo(calendar, "calendar");
        IIX0o.x0xO0oo(timePeriod, "timePeriod");
        setRange(com.sma.smartv3.util.xoIox.o00(calendar, timePeriod, i));
        return this.mElectrocardiogram.getElectrocardiograms(getRange()[0], getRange()[1]);
    }

    @OXOo.OOXIXo
    public final String setDataLabel() {
        return "ecg day Data";
    }

    public final void setSetValue(@OXOo.OOXIXo LineDataSet lineDataSet) {
        IIX0o.x0xO0oo(lineDataSet, "<set-?>");
        this.setValue = lineDataSet;
    }

    public final void setXTargetNumber(float f) {
        this.xTargetNumber = f;
    }

    public final void updateItemData(@OXOo.OOXIXo Entry e) {
        IIX0o.x0xO0oo(e, "e");
        getNowValue().setText(String.valueOf((int) e.I0Io()));
    }
}
