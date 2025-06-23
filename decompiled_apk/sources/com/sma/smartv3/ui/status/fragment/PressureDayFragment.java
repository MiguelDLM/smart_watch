package com.sma.smartv3.ui.status.fragment;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.blankj.utilcode.util.TimeUtils;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.PressureDao;
import com.sma.smartv3.db.entity.Pressure;
import com.sma.smartv3.model.PressureDataKt;
import com.sma.smartv3.model.PressureDataParse;
import com.sma.smartv3.model.PressureDayData;
import com.sma.smartv3.ui.status.base.BaseDetailDaysFragment;
import com.sma.smartv3.util.HeathReportsUtils;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.view.CustomBarChartView;
import com.sma.smartv3.view.segmentedbar.CircleThumbSegmentedBarView;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nPressureDayFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PressureDayFragment.kt\ncom/sma/smartv3/ui/status/fragment/PressureDayFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,234:1\n1855#2,2:235\n*S KotlinDebug\n*F\n+ 1 PressureDayFragment.kt\ncom/sma/smartv3/ui/status/fragment/PressureDayFragment\n*L\n193#1:235,2\n*E\n"})
/* loaded from: classes12.dex */
public final class PressureDayFragment extends BaseDetailDaysFragment<Pressure> {
    public o0xxxXXxX.II0xO0 setValue;

    @OXOo.OOXIXo
    private final X0IIOO barChart$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CustomBarChartView>() { // from class: com.sma.smartv3.ui.status.fragment.PressureDayFragment$barChart$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CustomBarChartView invoke() {
            View mView;
            mView = PressureDayFragment.this.getMView();
            return (CustomBarChartView) mView.findViewById(R.id.barChart);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO aveValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.PressureDayFragment$aveValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = PressureDayFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.aveValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mSbv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CircleThumbSegmentedBarView>() { // from class: com.sma.smartv3.ui.status.fragment.PressureDayFragment$mSbv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CircleThumbSegmentedBarView invoke() {
            View mView;
            mView = PressureDayFragment.this.getMView();
            return (CircleThumbSegmentedBarView) mView.findViewById(R.id.sbv);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO twoValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.PressureDayFragment$twoValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = PressureDayFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.twoValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO twoTV$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.fragment.PressureDayFragment$twoTV$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = PressureDayFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.twoTV);
        }
    });

    @OXOo.OOXIXo
    private final List<BarEntry> values = new ArrayList();

    @OXOo.OOXIXo
    private final PressureDao mPressureDao = MyDb.INSTANCE.getMDatabase().pressureDao();

    @OXOo.OOXIXo
    private final LinkedHashMap<Long, ArrayList<Pressure>> hourData = new LinkedHashMap<>();

    @OXOo.OOXIXo
    private final List<PressureDayData> pressureHourDataList = new ArrayList();
    private float highlight = 3.0f;

    @OXOo.OOXIXo
    private final X0IIOO healthLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.status.fragment.PressureDayFragment$healthLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = PressureDayFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.item_health_btn_layout);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO healthBtn$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.status.fragment.PressureDayFragment$healthBtn$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            View mView;
            mView = PressureDayFragment.this.getMView();
            return (Button) mView.findViewById(R.id.btn_common_heathy);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO healthTv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.fragment.PressureDayFragment$healthTv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = PressureDayFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.tv_common_heathy);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO healthTipLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.status.fragment.PressureDayFragment$healthTipLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = PressureDayFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.questions_healthy_tip_layout);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO healthQuestions$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.fragment.PressureDayFragment$healthQuestions$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = PressureDayFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.tv_common_healthy_questions);
        }
    });

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements ooOx.oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f24087II0xO0;

        public oIX0oI(SimpleDateFormat simpleDateFormat) {
            this.f24087II0xO0 = simpleDateFormat;
        }

        @Override // ooOx.oIX0oI
        public void II0xO0() {
        }

        @Override // ooOx.oIX0oI
        public void oIX0oI(@OXOo.OOXIXo Entry e, @OXOo.OOXIXo XI0oooXX.oxoX h) {
            IIX0o.x0xO0oo(e, "e");
            IIX0o.x0xO0oo(h, "h");
            PressureDayFragment.this.updateItemData(e);
            PressureDayFragment.this.getMCalendar().set(11, (int) e.xxIXOIIO());
            DINCondBold nowTimeDetails = PressureDayFragment.this.getNowTimeDetails();
            PressureDayFragment pressureDayFragment = PressureDayFragment.this;
            nowTimeDetails.setText(pressureDayFragment.getString(R.string.time_range, TimeUtils.millis2String(pressureDayFragment.getMCalendar().getTimeInMillis(), this.f24087II0xO0), TimeUtils.millis2String(PressureDayFragment.this.getMCalendar().getTimeInMillis() + 3600000, this.f24087II0xO0)));
        }
    }

    private final void filterData(List<Pressure> list) {
        this.values.clear();
        PressureDataParse.INSTANCE.filterHourData(getMActivity(), list, this.hourData, this.pressureHourDataList, this.values);
        xxx00.oIX0oI oix0oi = xxx00.oIX0oI.f35574oIX0oI;
        YAxis axisLeft = getBarChart().getAxisLeft();
        IIX0o.oO(axisLeft, "getAxisLeft(...)");
        YAxis axisRight = getBarChart().getAxisRight();
        IIX0o.oO(axisRight, "getAxisRight(...)");
        oix0oi.Oxx0IOOO(axisLeft, axisRight, 100.0f, 0.0f, ContextCompat.getColor(getMActivity(), R.color.line_color));
        updateChartData(this.values);
        if (!list.isEmpty()) {
            Pressure pressure = (Pressure) CollectionsKt___CollectionsKt.O0O0Io00X(list);
            if (pressure.getMValue() == 0) {
                Button healthBtn = getHealthBtn();
                if (healthBtn != null) {
                    healthBtn.setEnabled(false);
                    return;
                }
                return;
            }
            HeathReportsUtils heathReportsUtils = HeathReportsUtils.f24217oIX0oI;
            long mTime = pressure.getMTime();
            Button healthBtn2 = getHealthBtn();
            IIX0o.oO(healthBtn2, "<get-healthBtn>(...)");
            PFMedium healthTv = getHealthTv();
            IIX0o.oO(healthTv, "<get-healthTv>(...)");
            LinearLayout healthTipLayout = getHealthTipLayout();
            IIX0o.oO(healthTipLayout, "<get-healthTipLayout>(...)");
            PFMedium healthQuestions = getHealthQuestions();
            IIX0o.oO(healthQuestions, "<get-healthQuestions>(...)");
            heathReportsUtils.Io(ProductManager.oXoxo0x, mTime, healthBtn2, healthTv, healthTipLayout, healthQuestions, getMActivity());
            LinearLayout healthLayout = getHealthLayout();
            IIX0o.oO(healthLayout, "<get-healthLayout>(...)");
            Button healthBtn3 = getHealthBtn();
            IIX0o.oO(healthBtn3, "<get-healthBtn>(...)");
            PFMedium healthTv2 = getHealthTv();
            IIX0o.oO(healthTv2, "<get-healthTv>(...)");
            heathReportsUtils.x0o(healthLayout, healthBtn3, healthTv2, getMActivity(), ProductManager.oXoxo0x, String.valueOf(pressure.getMValue()), pressure.getMTime());
        }
    }

    private final DINCondBold getAveValue() {
        return (DINCondBold) this.aveValue$delegate.getValue();
    }

    private final CustomBarChartView getBarChart() {
        return (CustomBarChartView) this.barChart$delegate.getValue();
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

    private final CircleThumbSegmentedBarView getMSbv() {
        return (CircleThumbSegmentedBarView) this.mSbv$delegate.getValue();
    }

    private final PFMedium getTwoTV() {
        return (PFMedium) this.twoTV$delegate.getValue();
    }

    private final DINCondBold getTwoValue() {
        return (DINCondBold) this.twoValue$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateChartData(List<BarEntry> list) {
        if (getBarChart().getData() != 0 && ((o0xxxXXxX.oIX0oI) getBarChart().getData()).ooOOo0oXI() > 0) {
            T OOXIXo2 = ((o0xxxXXxX.oIX0oI) getBarChart().getData()).OOXIXo(0);
            IIX0o.x0XOIxOo(OOXIXo2, "null cannot be cast to non-null type com.github.mikephil.charting.data.BarDataSet");
            setSetValue((o0xxxXXxX.II0xO0) OOXIXo2);
            getSetValue().oX0ooo0I0(list);
            getSetValue().I0xX0();
            ((o0xxxXXxX.oIX0oI) getBarChart().getData()).XxX0x0xxx();
            getBarChart().X00IoxXI();
        } else {
            setSetValue(new o0xxxXXxX.II0xO0(list, setDataLabel()));
            getSetValue().o0IXXIx(CollectionsKt__CollectionsKt.X00IoxXI(0, Integer.valueOf(ContextCompat.getColor(getMActivity(), R.color.colorAccent))));
            o0xxxXXxX.oIX0oI oix0oi = new o0xxxXXxX.oIX0oI(getSetValue());
            oix0oi.oo0xXOI0I(false);
            getBarChart().setData(oix0oi);
        }
        getBarChart().II0XooXoX(1000);
        getBarChart().invalidate();
        for (BarEntry barEntry : list) {
            if (barEntry.I0Io() > 0.0f) {
                this.highlight = barEntry.xxIXOIIO();
            }
        }
        getBarChart().XIxXXX0x0(this.highlight, 0);
    }

    public final void clearCache(long j) {
        this.hourData.clear();
        for (int i = 1; i < 25; i++) {
            this.hourData.put(Long.valueOf((i * 3600 * 1000) + j), new ArrayList<>());
        }
    }

    public final float getHighlight() {
        return this.highlight;
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

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        getAveValue().setText("");
        getTwoTV().setText(R.string.monitoring_results);
        getTwoValue().setText("");
        xxx00.oIX0oI oix0oi = xxx00.oIX0oI.f35574oIX0oI;
        CustomBarChartView barChart = getBarChart();
        IIX0o.oO(barChart, "<get-barChart>(...)");
        oix0oi.oIX0oI(barChart);
        YAxis axisLeft = getBarChart().getAxisLeft();
        IIX0o.oO(axisLeft, "getAxisLeft(...)");
        YAxis axisRight = getBarChart().getAxisRight();
        IIX0o.oO(axisRight, "getAxisRight(...)");
        oix0oi.Oxx0IOOO(axisLeft, axisRight, 0.0f, 0.0f, ContextCompat.getColor(getMActivity(), R.color.line_color));
        XAxis xAxis = getBarChart().getXAxis();
        IIX0o.ooOOo0oXI(xAxis);
        Context context = getBarChart().getContext();
        IIX0o.oO(context, "getContext(...)");
        oix0oi.X0o0xo(xAxis, false, context);
        setRange(com.sma.smartv3.util.xoIox.OxI(null, TimePeriod.DAY, 0, 5, null));
        xAxis.OO(4.0f);
        xAxis.I0X0x0oIo(-1.0f);
        xAxis.xXOx(25.0f);
        SimpleDateFormat xXOx2 = com.sma.smartv3.util.xoIox.xXOx(false, 1, null);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 25; i++) {
            String millis2String = TimeUtils.millis2String(getRange()[0] + (i * 3600 * 1000), xXOx2);
            if (arrayList.size() > 12 && IIX0o.Oxx0IOOO(millis2String, "0")) {
                millis2String = com.tencent.connect.common.II0xO0.f26868oxOXxoXII;
            }
            IIX0o.ooOOo0oXI(millis2String);
            arrayList.add(millis2String);
        }
        xAxis.o0xxxXXxX(new ox.oOoXoXO(arrayList));
        CustomBarChartView barChart2 = getBarChart();
        barChart2.getDescription().Oxx0IOOO(false);
        barChart2.getLegend().Oxx0IOOO(false);
        barChart2.setScaleEnabled(false);
        xxx00.II0xO0 iI0xO0 = new xxx00.II0xO0(getBarChart(), getBarChart().getAnimator(), getBarChart().getViewPortHandler());
        iI0xO0.X0IIOO(oIxOXo.oxoX.I0Io(getMActivity(), R.color.line_color));
        iI0xO0.O0xOxO(new int[]{ContextCompat.getColor(getMActivity(), R.color.p_show_1), ContextCompat.getColor(getMActivity(), R.color.p_show_2)});
        iI0xO0.oI0IIXIo(5);
        getBarChart().setRenderer(iI0xO0);
        getBarChart().setOnChartValueSelectedListener(new oIX0oI(com.sma.smartv3.util.xoIox.oxXx0IX(false, 1, null)));
        Context requireContext = requireContext();
        IIX0o.oO(requireContext, "requireContext(...)");
        CircleThumbSegmentedBarView mSbv = getMSbv();
        IIX0o.oO(mSbv, "<get-mSbv>(...)");
        PressureDataKt.setPressureSbv(requireContext, mSbv);
        CircleThumbSegmentedBarView mSbv2 = getMSbv();
        IIX0o.oO(mSbv2, "<get-mSbv>(...)");
        PressureDataKt.setPressureSbvValue(mSbv2, 0.0f);
        super.initView();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_status_pressure_day;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    public void onDataChange(@OXOo.OOXIXo List<Pressure> data) {
        IIX0o.x0xO0oo(data, "data");
        filterData(data);
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    @OXOo.OOXIXo
    public List<Pressure> onTimePeriodChange(@OXOo.OOXIXo Calendar calendar, int i, @OXOo.OOXIXo TimePeriod timePeriod) {
        IIX0o.x0xO0oo(calendar, "calendar");
        IIX0o.x0xO0oo(timePeriod, "timePeriod");
        setRange(com.sma.smartv3.util.xoIox.o00(calendar, timePeriod, i));
        clearCache(getRange()[0]);
        return this.mPressureDao.getPressures(getRange()[0], getRange()[1]);
    }

    @OXOo.OOXIXo
    public final String setDataLabel() {
        return "Pressure day Data";
    }

    public final void setHighlight(float f) {
        this.highlight = f;
    }

    public final void setSetValue(@OXOo.OOXIXo o0xxxXXxX.II0xO0 iI0xO0) {
        IIX0o.x0xO0oo(iI0xO0, "<set-?>");
        this.setValue = iI0xO0;
    }

    public final void updateItemData(@OXOo.OOXIXo Entry e) {
        IIX0o.x0xO0oo(e, "e");
        CircleThumbSegmentedBarView mSbv = getMSbv();
        IIX0o.oO(mSbv, "<get-mSbv>(...)");
        PressureDataKt.setPressureSbvValue(mSbv, e.I0Io());
        PressureDayData pressureDayData = this.pressureHourDataList.get((int) e.xxIXOIIO());
        getNowValue().setText(UtilsKt.OOXIXo(pressureDayData.getMin(), pressureDayData.getMax()));
        getTwoValue().setText(UtilsKt.IIXOooo(pressureDayData.getStatus()));
        getAveValue().setText(UtilsKt.OxxIIOOXO(pressureDayData.getAvg()));
        CircleThumbSegmentedBarView mSbv2 = getMSbv();
        IIX0o.oO(mSbv2, "<get-mSbv>(...)");
        PressureDataKt.setPressureSbvValue(mSbv2, pressureDayData.getAvg());
    }
}
