package com.sma.smartv3.ui.status.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.HeartRateDao;
import com.sma.smartv3.db.entity.HeartRate;
import com.sma.smartv3.model.HRDataParse;
import com.sma.smartv3.model.HRDayData;
import com.sma.smartv3.ui.status.RealTimeMeasurementActivity;
import com.sma.smartv3.ui.status.base.BaseDetailDaysFragment;
import com.sma.smartv3.util.HeathReportsUtils;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import com.szabh.smable3.component.BleConnector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class HeartRateDayFragment extends BaseDetailDaysFragment<HeartRate> {
    public LineDataSet setValue;

    @OXOo.OOXIXo
    private final X0IIOO lineChart$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LineChart>() { // from class: com.sma.smartv3.ui.status.fragment.HeartRateDayFragment$lineChart$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LineChart invoke() {
            View mView;
            mView = HeartRateDayFragment.this.getMView();
            return (LineChart) mView.findViewById(R.id.lineChart);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO minHrValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.HeartRateDayFragment$minHrValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = HeartRateDayFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.minHrValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO maxHrValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.HeartRateDayFragment$maxHrValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = HeartRateDayFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.maxHrValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO avHrValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.HeartRateDayFragment$avHrValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = HeartRateDayFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.avHrValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO measurePanel$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.fragment.HeartRateDayFragment$measurePanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = HeartRateDayFragment.this.getMView();
            return mView.findViewById(R.id.measure_panel);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO btnMeasure$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.fragment.HeartRateDayFragment$btnMeasure$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = HeartRateDayFragment.this.getMView();
            return mView.findViewById(R.id.btn_measure);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO healthLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.status.fragment.HeartRateDayFragment$healthLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = HeartRateDayFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.item_health_btn_layout);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO healthBtn$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.status.fragment.HeartRateDayFragment$healthBtn$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            View mView;
            mView = HeartRateDayFragment.this.getMView();
            return (Button) mView.findViewById(R.id.btn_common_heathy);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO healthTv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.fragment.HeartRateDayFragment$healthTv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = HeartRateDayFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.tv_common_heathy);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO healthTipLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.status.fragment.HeartRateDayFragment$healthTipLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = HeartRateDayFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.questions_healthy_tip_layout);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO healthQuestions$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.fragment.HeartRateDayFragment$healthQuestions$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = HeartRateDayFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.tv_common_healthy_questions);
        }
    });

    @OXOo.OOXIXo
    private final List<Entry> values = new ArrayList();
    private final int dayMinute = com.sma.smartv3.util.xoIox.oIX0oI();

    @OXOo.OOXIXo
    private HeartRateDao mHeartRateDao = MyDb.INSTANCE.getMDatabase().heartRateDao();

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements ooOx.oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f24071II0xO0;

        public oIX0oI(SimpleDateFormat simpleDateFormat) {
            this.f24071II0xO0 = simpleDateFormat;
        }

        @Override // ooOx.oIX0oI
        public void II0xO0() {
        }

        @Override // ooOx.oIX0oI
        public void oIX0oI(@OXOo.OOXIXo Entry e, @OXOo.OOXIXo XI0oooXX.oxoX h) {
            IIX0o.x0xO0oo(e, "e");
            IIX0o.x0xO0oo(h, "h");
            HeartRateDayFragment.this.updateItemData(e);
            int xxIXOIIO2 = (int) e.xxIXOIIO();
            int i = xxIXOIIO2 / 60;
            HeartRateDayFragment.this.getMCalendar().set(11, i);
            HeartRateDayFragment.this.getMCalendar().set(12, xxIXOIIO2 - (i * 60));
            HeartRateDayFragment.this.getNowTimeDetails().setText(TimeUtils.millis2String(HeartRateDayFragment.this.getMCalendar().getTimeInMillis() - 60000, this.f24071II0xO0));
        }
    }

    private final void addLastData(List<HeartRate> list) {
        if (!this.values.isEmpty() && !list.isEmpty()) {
            Entry entry = (Entry) CollectionsKt___CollectionsKt.O0O0Io00X(this.values);
            StringBuilder sb = new StringBuilder();
            sb.append("last:");
            sb.append(((HeartRate) CollectionsKt___CollectionsKt.O0O0Io00X(list)).getMBpm());
            LogUtils.i("filterData", sb.toString());
            this.values.add(new Entry(entry.xxIXOIIO() + 1, ((HeartRate) CollectionsKt___CollectionsKt.O0O0Io00X(list)).getMBpm()));
        }
    }

    private final void filterData(List<HeartRate> list) {
        this.values.clear();
        HRDayData filterMinuteData = HRDataParse.INSTANCE.filterMinuteData(getRange(), list, this.values);
        getMinHrValue().setText(UtilsKt.OxxIIOOXO(filterMinuteData.getMin()));
        getMaxHrValue().setText(UtilsKt.OxxIIOOXO(filterMinuteData.getMax()));
        getAvHrValue().setText(UtilsKt.OxxIIOOXO(filterMinuteData.getAvg()));
        getNowValue().setText(UtilsKt.OxxIIOOXO(filterMinuteData.getAvg()));
        addLastData(list);
        updateChartData(this.values);
        if (!list.isEmpty()) {
            HeartRate heartRate = (HeartRate) CollectionsKt___CollectionsKt.O0O0Io00X(list);
            if (heartRate.getMBpm() == 0) {
                Button healthBtn = getHealthBtn();
                if (healthBtn != null) {
                    healthBtn.setEnabled(false);
                    return;
                }
                return;
            }
            HeathReportsUtils heathReportsUtils = HeathReportsUtils.f24217oIX0oI;
            long mTime = heartRate.getMTime();
            Button healthBtn2 = getHealthBtn();
            IIX0o.oO(healthBtn2, "<get-healthBtn>(...)");
            PFMedium healthTv = getHealthTv();
            IIX0o.oO(healthTv, "<get-healthTv>(...)");
            LinearLayout healthTipLayout = getHealthTipLayout();
            IIX0o.oO(healthTipLayout, "<get-healthTipLayout>(...)");
            PFMedium healthQuestions = getHealthQuestions();
            IIX0o.oO(healthQuestions, "<get-healthQuestions>(...)");
            heathReportsUtils.Io("heart_rate", mTime, healthBtn2, healthTv, healthTipLayout, healthQuestions, getMActivity());
            LinearLayout healthLayout = getHealthLayout();
            IIX0o.oO(healthLayout, "<get-healthLayout>(...)");
            Button healthBtn3 = getHealthBtn();
            IIX0o.oO(healthBtn3, "<get-healthBtn>(...)");
            PFMedium healthTv2 = getHealthTv();
            IIX0o.oO(healthTv2, "<get-healthTv>(...)");
            heathReportsUtils.x0o(healthLayout, healthBtn3, healthTv2, getMActivity(), "heart_rate", heartRate.getMBpm() + getString(R.string.bpm), heartRate.getMTime());
        }
    }

    private final DINCondBold getAvHrValue() {
        return (DINCondBold) this.avHrValue$delegate.getValue();
    }

    private final View getBtnMeasure() {
        return (View) this.btnMeasure$delegate.getValue();
    }

    private final Button getHealthBtn() {
        return (Button) this.healthBtn$delegate.getValue();
    }

    private final LinearLayout getHealthLayout() {
        return (LinearLayout) this.healthLayout$delegate.getValue();
    }

    private final PFMedium getHealthQuestions() {
        return (PFMedium) this.healthQuestions$delegate.getValue();
    }

    private final LinearLayout getHealthTipLayout() {
        return (LinearLayout) this.healthTipLayout$delegate.getValue();
    }

    private final PFMedium getHealthTv() {
        return (PFMedium) this.healthTv$delegate.getValue();
    }

    private final LineChart getLineChart() {
        return (LineChart) this.lineChart$delegate.getValue();
    }

    private final DINCondBold getMaxHrValue() {
        return (DINCondBold) this.maxHrValue$delegate.getValue();
    }

    private final View getMeasurePanel() {
        return (View) this.measurePanel$delegate.getValue();
    }

    private final DINCondBold getMinHrValue() {
        return (DINCondBold) this.minHrValue$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(final HeartRateDayFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        OI0.oIX0oI.f1507oIX0oI.XO("start measure");
        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.HeartRateDayFragment$initView$1$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(BleConnector bleConnector) {
                invoke2(bleConnector);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                IIX0o.x0xO0oo(it, "it");
                HeartRateDayFragment heartRateDayFragment = HeartRateDayFragment.this;
                Bundle bundle = new Bundle();
                bundle.putString("mArg0", null);
                bundle.putInt("mArg1", 0);
                bundle.putParcelable("mArg2", null);
                bundle.putSerializable("mArg3", null);
                Intent intent = new Intent(heartRateDayFragment.getActivity(), (Class<?>) RealTimeMeasurementActivity.class);
                intent.putExtras(bundle);
                heartRateDayFragment.startActivity(intent);
            }
        }, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateChartData(List<Entry> list) {
        float xxIXOIIO2;
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
            getSetValue().OX(ContextCompat.getColor(getMActivity(), R.color.hr_color));
            getSetValue().X0ooXIooI(ContextCompat.getColor(getMActivity(), R.color.hr_color));
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

    @Override // com.bestmafen.androidbase.base.BaseFragment, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        if (ProductManager.f20544oIX0oI.oOIXoIXXI()) {
            View measurePanel = getMeasurePanel();
            if (measurePanel != null) {
                measurePanel.setVisibility(0);
            }
            View btnMeasure = getBtnMeasure();
            if (btnMeasure != null) {
                btnMeasure.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.status.fragment.XO
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HeartRateDayFragment.initView$lambda$0(HeartRateDayFragment.this, view);
                    }
                });
            }
        } else {
            View measurePanel2 = getMeasurePanel();
            if (measurePanel2 != null) {
                measurePanel2.setVisibility(8);
            }
        }
        xxx00.oIX0oI oix0oi = xxx00.oIX0oI.f35574oIX0oI;
        LineChart lineChart = getLineChart();
        IIX0o.oO(lineChart, "<get-lineChart>(...)");
        oix0oi.II0xO0(lineChart);
        if (ProjectManager.f19822oIX0oI.x0()) {
            YAxis axisLeft = getLineChart().getAxisLeft();
            IIX0o.oO(axisLeft, "getAxisLeft(...)");
            YAxis axisRight = getLineChart().getAxisRight();
            IIX0o.oO(axisRight, "getAxisRight(...)");
            oix0oi.Oxx0IOOO(axisLeft, axisRight, 210.0f, 0.0f, ContextCompat.getColor(getMActivity(), R.color.line_color));
        } else {
            YAxis axisLeft2 = getLineChart().getAxisLeft();
            IIX0o.oO(axisLeft2, "getAxisLeft(...)");
            YAxis axisRight2 = getLineChart().getAxisRight();
            IIX0o.oO(axisRight2, "getAxisRight(...)");
            oix0oi.Oxx0IOOO(axisLeft2, axisRight2, 0.0f, 30.0f, ContextCompat.getColor(getMActivity(), R.color.line_color));
        }
        XAxis xAxis = getLineChart().getXAxis();
        IIX0o.ooOOo0oXI(xAxis);
        Context context = getLineChart().getContext();
        IIX0o.oO(context, "getContext(...)");
        oix0oi.X0o0xo(xAxis, true, context);
        setRange(com.sma.smartv3.util.xoIox.OxI(null, TimePeriod.DAY, 0, 5, null));
        xAxis.OO(this.dayMinute / 6);
        xAxis.I0X0x0oIo(-10.0f);
        xAxis.xXOx(this.dayMinute + 10.0f);
        SimpleDateFormat xXOx2 = com.sma.smartv3.util.xoIox.xXOx(false, 1, null);
        ArrayList arrayList = new ArrayList();
        int i = this.dayMinute;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                String millis2String = TimeUtils.millis2String(getRange()[0] + (60000 * i2), xXOx2);
                if (arrayList.size() > 12 && IIX0o.Oxx0IOOO(millis2String, "0")) {
                    millis2String = com.tencent.connect.common.II0xO0.f26868oxOXxoXII;
                }
                IIX0o.ooOOo0oXI(millis2String);
                arrayList.add(millis2String);
                if (i2 == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        xAxis.o0xxxXXxX(new ox.oOoXoXO(arrayList));
        LineChart lineChart2 = getLineChart();
        lineChart2.getDescription().Oxx0IOOO(false);
        lineChart2.getLegend().Oxx0IOOO(false);
        lineChart2.setScaleEnabled(false);
        xxx00.I0Io i0Io = new xxx00.I0Io(getLineChart(), getLineChart().getAnimator(), getLineChart().getViewPortHandler());
        i0Io.xxX(oIxOXo.oxoX.I0Io(getMActivity(), R.color.line_color));
        getLineChart().setRenderer(i0Io);
        getLineChart().setOnChartValueSelectedListener(new oIX0oI(com.sma.smartv3.util.xoIox.oxXx0IX(false, 1, null)));
        super.initView();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_status_hr_day;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    public void onDataChange(@OXOo.OOXIXo List<HeartRate> data) {
        IIX0o.x0xO0oo(data, "data");
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
    public List<HeartRate> onTimePeriodChange(@OXOo.OOXIXo Calendar calendar, int i, @OXOo.OOXIXo TimePeriod timePeriod) {
        IIX0o.x0xO0oo(calendar, "calendar");
        IIX0o.x0xO0oo(timePeriod, "timePeriod");
        setRange(com.sma.smartv3.util.xoIox.o00(calendar, timePeriod, i));
        return this.mHeartRateDao.getHeartRates(getRange()[0], getRange()[1]);
    }

    @OXOo.OOXIXo
    public final String setDataLabel() {
        return "HR day Data";
    }

    public final void setSetValue(@OXOo.OOXIXo LineDataSet lineDataSet) {
        IIX0o.x0xO0oo(lineDataSet, "<set-?>");
        this.setValue = lineDataSet;
    }

    @SuppressLint({"SetTextI18n"})
    public final void updateItemData(@OXOo.OOXIXo Entry e) {
        IIX0o.x0xO0oo(e, "e");
        getNowValue().setText(String.valueOf((int) e.I0Io()));
    }
}
