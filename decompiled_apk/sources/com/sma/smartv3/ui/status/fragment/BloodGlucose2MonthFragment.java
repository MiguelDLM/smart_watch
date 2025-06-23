package com.sma.smartv3.ui.status.fragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.BloodGlucose2Dao;
import com.sma.smartv3.db.entity.BloodGlucose2;
import com.sma.smartv3.model.BloodGlucose2DataKt;
import com.sma.smartv3.model.BloodGlucose2DataParse;
import com.sma.smartv3.model.BloodGlucose2DayData;
import com.sma.smartv3.ui.status.base.BaseDetailsMonthFragment;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.view.CustomBarChartView;
import com.sma.smartv3.view.segmentedbar.VerticalSegmentedBarView;
import com.sma.smartv3.view.text.DINCondBold;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBloodGlucose2MonthFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BloodGlucose2MonthFragment.kt\ncom/sma/smartv3/ui/status/fragment/BloodGlucose2MonthFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,204:1\n1855#2,2:205\n*S KotlinDebug\n*F\n+ 1 BloodGlucose2MonthFragment.kt\ncom/sma/smartv3/ui/status/fragment/BloodGlucose2MonthFragment\n*L\n192#1:205,2\n*E\n"})
/* loaded from: classes12.dex */
public final class BloodGlucose2MonthFragment extends BaseDetailsMonthFragment<BloodGlucose2> {
    private float axisMinimum;
    private float highlight;

    @OXOo.oOoXoXO
    private xxx00.II0xO0 infoBarChartRender;
    private float maxHeight;
    private List<String> monthDays;
    private o0xxxXXxX.II0xO0 setValue;

    @OXOo.OOXIXo
    private final X0IIOO barChart$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CustomBarChartView>() { // from class: com.sma.smartv3.ui.status.fragment.BloodGlucose2MonthFragment$barChart$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CustomBarChartView invoke() {
            View mView;
            mView = BloodGlucose2MonthFragment.this.getMView();
            return (CustomBarChartView) mView.findViewById(R.id.barChart);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO segmentedbar$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<VerticalSegmentedBarView>() { // from class: com.sma.smartv3.ui.status.fragment.BloodGlucose2MonthFragment$segmentedbar$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final VerticalSegmentedBarView invoke() {
            View mView;
            mView = BloodGlucose2MonthFragment.this.getMView();
            return (VerticalSegmentedBarView) mView.findViewById(R.id.segmentedbar);
        }
    });

    @OXOo.OOXIXo
    private final List<BarEntry> values = new ArrayList();

    @OXOo.OOXIXo
    private final LinkedHashMap<Long, ArrayList<BloodGlucose2>> monthData = new LinkedHashMap<>();

    @OXOo.OOXIXo
    private final BloodGlucose2Dao mBloodGlucose2Dao = MyDb.INSTANCE.getMDatabase().bloodGlucose2Dao();

    @OXOo.OOXIXo
    private final List<BloodGlucose2DayData> bloodGlucoseDayDataList = new ArrayList();

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
            BloodGlucose2MonthFragment.this.updateItemData(e);
            DINCondBold nowTimeDetails = BloodGlucose2MonthFragment.this.getNowTimeDetails();
            List list = BloodGlucose2MonthFragment.this.monthDays;
            if (list == null) {
                IIX0o.XOxIOxOx("monthDays");
                list = null;
            }
            nowTimeDetails.setText((CharSequence) list.get((int) e.xxIXOIIO()));
        }
    }

    private final CustomBarChartView getBarChart() {
        return (CustomBarChartView) this.barChart$delegate.getValue();
    }

    private final VerticalSegmentedBarView getSegmentedbar() {
        return (VerticalSegmentedBarView) this.segmentedbar$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$2(BloodGlucose2MonthFragment this$0) {
        float f;
        IIX0o.x0xO0oo(this$0, "this$0");
        YAxis axisRight = this$0.getBarChart().getAxisRight();
        float f2 = axisRight.f4025ooXIXxIX;
        float f3 = axisRight.f4006IIX0o;
        xxx00.II0xO0 iI0xO0 = this$0.infoBarChartRender;
        float f4 = 0.0f;
        if (iI0xO0 != null) {
            f = iI0xO0.IIXOooo(f3);
        } else {
            f = 0.0f;
        }
        xxx00.II0xO0 iI0xO02 = this$0.infoBarChartRender;
        if (iI0xO02 != null) {
            f4 = iI0xO02.IIXOooo(f2);
        }
        float OOXIXo2 = (this$0.getBarChart().getViewPortHandler().OOXIXo() / this$0.getBarChart().getXAxis().f4006IIX0o) * ((o0xxxXXxX.oIX0oI) this$0.getBarChart().getData()).xII();
        ViewGroup.LayoutParams layoutParams = this$0.getSegmentedbar().getLayoutParams();
        IIX0o.x0XOIxOo(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.height = (int) (f4 - f);
        layoutParams2.topMargin = (int) f;
        layoutParams2.width = (int) OOXIXo2;
        this$0.getSegmentedbar().setLayoutParams(layoutParams2);
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

    public final void filterData(@OXOo.OOXIXo List<BloodGlucose2> data) {
        IIX0o.x0xO0oo(data, "data");
        this.values.clear();
        BloodGlucose2DataParse.INSTANCE.filterDayData(getMActivity(), data, this.monthData, this.bloodGlucoseDayDataList, this.values);
        updateChartData(this.values);
    }

    @OXOo.oOoXoXO
    public final xxx00.II0xO0 getInfoBarChartRender() {
        return this.infoBarChartRender;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        this.maxHeight = 90.0f;
        this.axisMinimum = 30.0f;
        this.monthDays = com.sma.smartv3.util.xoIox.Oo(getMCalendar().getTimeInMillis());
        getTvCurrent().setText(com.sma.smartv3.util.xoIox.xII().format(new Date()));
        xxx00.oIX0oI oix0oi = xxx00.oIX0oI.f35574oIX0oI;
        CustomBarChartView barChart = getBarChart();
        IIX0o.oO(barChart, "<get-barChart>(...)");
        oix0oi.oIX0oI(barChart);
        YAxis axisLeft = getBarChart().getAxisLeft();
        IIX0o.oO(axisLeft, "getAxisLeft(...)");
        YAxis axisRight = getBarChart().getAxisRight();
        IIX0o.oO(axisRight, "getAxisRight(...)");
        oix0oi.Oxx0IOOO(axisLeft, axisRight, this.maxHeight, this.axisMinimum, ContextCompat.getColor(getMActivity(), R.color.line_color));
        int i = 0;
        getBarChart().getAxisRight().I0oOIX(false);
        CustomBarChartView barChart2 = getBarChart();
        barChart2.setDrawValueAboveBar(false);
        barChart2.setScaleEnabled(false);
        barChart2.getDescription().Oxx0IOOO(false);
        barChart2.getLegend().Oxx0IOOO(false);
        XAxis xAxis = getBarChart().getXAxis();
        IIX0o.ooOOo0oXI(xAxis);
        Context context = getBarChart().getContext();
        IIX0o.oO(context, "getContext(...)");
        oix0oi.X0o0xo(xAxis, false, context);
        xAxis.OO(1.0f);
        ArrayList arrayList = new ArrayList();
        List<String> list = this.monthDays;
        if (list == null) {
            IIX0o.XOxIOxOx("monthDays");
            list = null;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            i++;
            it.next();
            arrayList.add(String.valueOf(i));
        }
        xAxis.o0xxxXXxX(new ox.oOoXoXO(arrayList));
        setChartRenderer();
        getBarChart().setOnChartValueSelectedListener(new oIX0oI());
        getSegmentedbar().setSegments(BloodGlucose2DataKt.getBloodGlucoseSegments());
        getBarChart().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sma.smartv3.ui.status.fragment.oIX0oI
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                BloodGlucose2MonthFragment.initView$lambda$2(BloodGlucose2MonthFragment.this);
            }
        });
        super.initView();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_status_blood_glucose2_month;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    public void onDataChange(@OXOo.OOXIXo List<BloodGlucose2> data) {
        IIX0o.x0xO0oo(data, "data");
        filterData(data);
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    @OXOo.OOXIXo
    public List<BloodGlucose2> onTimePeriodChange(@OXOo.OOXIXo Calendar calendar, int i, @OXOo.OOXIXo TimePeriod timePeriod) {
        IIX0o.x0xO0oo(calendar, "calendar");
        IIX0o.x0xO0oo(timePeriod, "timePeriod");
        long[] o002 = com.sma.smartv3.util.xoIox.o00(calendar, timePeriod, i);
        this.monthDays = com.sma.smartv3.util.xoIox.Oo(o002[0]);
        clearCache(o002[0]);
        return this.mBloodGlucose2Dao.getListForDay(o002[0], o002[1]);
    }

    public final void setChartRenderer() {
        xxx00.II0xO0 iI0xO0 = new xxx00.II0xO0(getBarChart(), getBarChart().getAnimator(), getBarChart().getViewPortHandler());
        this.infoBarChartRender = iI0xO0;
        iI0xO0.X0IIOO(oIxOXo.oxoX.I0Io(getMActivity(), R.color.line_color));
        xxx00.II0xO0 iI0xO02 = this.infoBarChartRender;
        if (iI0xO02 != null) {
            iI0xO02.oI0IIXIo(7);
        }
        getBarChart().setRenderer(this.infoBarChartRender);
    }

    public final void setColor(@OXOo.OOXIXo o0xxxXXxX.II0xO0 value) {
        IIX0o.x0xO0oo(value, "value");
        value.o0IXXIx(CollectionsKt__CollectionsKt.X00IoxXI(0, Integer.valueOf(ContextCompat.getColor(getMActivity(), R.color.colorAccent))));
    }

    @OXOo.OOXIXo
    public final String setDataLabel() {
        return "BloodGlucose month Data";
    }

    public final void setInfoBarChartRender(@OXOo.oOoXoXO xxx00.II0xO0 iI0xO0) {
        this.infoBarChartRender = iI0xO0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateChartData(@OXOo.OOXIXo List<BarEntry> values) {
        IIX0o.x0xO0oo(values, "values");
        o0xxxXXxX.II0xO0 iI0xO0 = null;
        if (getBarChart().getData() != 0 && ((o0xxxXXxX.oIX0oI) getBarChart().getData()).ooOOo0oXI() > 0) {
            T OOXIXo2 = ((o0xxxXXxX.oIX0oI) getBarChart().getData()).OOXIXo(0);
            IIX0o.x0XOIxOo(OOXIXo2, "null cannot be cast to non-null type com.github.mikephil.charting.data.BarDataSet");
            o0xxxXXxX.II0xO0 iI0xO02 = (o0xxxXXxX.II0xO0) OOXIXo2;
            this.setValue = iI0xO02;
            if (iI0xO02 == null) {
                IIX0o.XOxIOxOx("setValue");
                iI0xO02 = null;
            }
            iI0xO02.oX0ooo0I0(values);
            o0xxxXXxX.II0xO0 iI0xO03 = this.setValue;
            if (iI0xO03 == null) {
                IIX0o.XOxIOxOx("setValue");
            } else {
                iI0xO0 = iI0xO03;
            }
            iI0xO0.I0xX0();
            ((o0xxxXXxX.oIX0oI) getBarChart().getData()).XxX0x0xxx();
            getBarChart().X00IoxXI();
        } else {
            o0xxxXXxX.II0xO0 iI0xO04 = new o0xxxXXxX.II0xO0(values, setDataLabel());
            this.setValue = iI0xO04;
            setColor(iI0xO04);
            o0xxxXXxX.II0xO0 iI0xO05 = this.setValue;
            if (iI0xO05 == null) {
                IIX0o.XOxIOxOx("setValue");
            } else {
                iI0xO0 = iI0xO05;
            }
            o0xxxXXxX.oIX0oI oix0oi = new o0xxxXXxX.oIX0oI(iI0xO0);
            oix0oi.oo0xXOI0I(false);
            getBarChart().setData(oix0oi);
        }
        getBarChart().invalidate();
        this.highlight = values.size() / 2;
        for (BarEntry barEntry : values) {
            if (barEntry.I0Io() > 0.0f) {
                this.highlight = barEntry.xxIXOIIO();
            }
        }
        getBarChart().XIxXXX0x0(this.highlight, 0);
    }

    public final void updateItemData(@OXOo.OOXIXo Entry e) {
        IIX0o.x0xO0oo(e, "e");
        BloodGlucose2DayData bloodGlucose2DayData = this.bloodGlucoseDayDataList.get((int) e.xxIXOIIO());
        getNowValue().setText(UtilsKt.xxIXOIIO(bloodGlucose2DayData.getMin() / 10.0f, bloodGlucose2DayData.getMax() / 10.0f));
    }
}
