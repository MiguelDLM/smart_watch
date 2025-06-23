package com.sma.smartv3.ui.status.base;

import OXOo.OOXIXo;
import XI0oooXX.oxoX;
import android.content.Context;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.core.content.ContextCompat;
import com.blankj.utilcode.util.TimeUtils;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.ActivityDao;
import com.sma.smartv3.db.entity.Activity;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.xoIox;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import o0xxxXXxX.II0xO0;
import ox.oOoXoXO;

@XX({"SMAP\nActivityBaseDayFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityBaseDayFragment.kt\ncom/sma/smartv3/ui/status/base/ActivityBaseDayFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,190:1\n1855#2,2:191\n*S KotlinDebug\n*F\n+ 1 ActivityBaseDayFragment.kt\ncom/sma/smartv3/ui/status/base/ActivityBaseDayFragment\n*L\n166#1:191,2\n*E\n"})
/* loaded from: classes12.dex */
public class ActivityBaseDayFragment extends BaseDetailDaysFragment<Activity> {
    public II0xO0 setValue;

    @OOXIXo
    private final X0IIOO barChart$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<BarChart>() { // from class: com.sma.smartv3.ui.status.base.ActivityBaseDayFragment$barChart$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final BarChart invoke() {
            View mView;
            mView = ActivityBaseDayFragment.this.getMView();
            return (BarChart) mView.findViewById(R.id.barChart);
        }
    });

    @OOXIXo
    private final X0IIOO oneValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.base.ActivityBaseDayFragment$oneValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = ActivityBaseDayFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.oneValue);
        }
    });

    @OOXIXo
    private final X0IIOO oneTV$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.base.ActivityBaseDayFragment$oneTV$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = ActivityBaseDayFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.oneTV);
        }
    });

    @OOXIXo
    private final X0IIOO totalUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.base.ActivityBaseDayFragment$totalUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = ActivityBaseDayFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.oneUnit);
        }
    });

    @OOXIXo
    private final X0IIOO twoValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.base.ActivityBaseDayFragment$twoValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = ActivityBaseDayFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.twoValue);
        }
    });

    @OOXIXo
    private final X0IIOO twoTV$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.base.ActivityBaseDayFragment$twoTV$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = ActivityBaseDayFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.twoTV);
        }
    });

    @OOXIXo
    private final X0IIOO twoUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.base.ActivityBaseDayFragment$twoUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = ActivityBaseDayFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.twoUnit);
        }
    });

    @OOXIXo
    private final List<BarEntry> values = new ArrayList();

    @OOXIXo
    private LinkedHashMap<Long, ArrayList<Activity>> filterData = new LinkedHashMap<>();

    @OOXIXo
    private final ActivityDao mActivityDao = MyDb.INSTANCE.getMDatabase().activityDao();
    private float highlight = 3.0f;

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements ooOx.oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f24047II0xO0;

        public oIX0oI(SimpleDateFormat simpleDateFormat) {
            this.f24047II0xO0 = simpleDateFormat;
        }

        @Override // ooOx.oIX0oI
        public void II0xO0() {
        }

        @Override // ooOx.oIX0oI
        public void oIX0oI(@OOXIXo Entry e, @OOXIXo oxoX h) {
            IIX0o.x0xO0oo(e, "e");
            IIX0o.x0xO0oo(h, "h");
            ActivityBaseDayFragment.this.updateItemData(e);
            ActivityBaseDayFragment.this.getMCalendar().set(11, (int) e.xxIXOIIO());
            DINCondBold nowTimeDetails = ActivityBaseDayFragment.this.getNowTimeDetails();
            ActivityBaseDayFragment activityBaseDayFragment = ActivityBaseDayFragment.this;
            nowTimeDetails.setText(activityBaseDayFragment.getString(R.string.time_range, TimeUtils.millis2String(activityBaseDayFragment.getMCalendar().getTimeInMillis(), this.f24047II0xO0), TimeUtils.millis2String(ActivityBaseDayFragment.this.getMCalendar().getTimeInMillis() + 3600000, this.f24047II0xO0)));
        }
    }

    private final BarChart getBarChart() {
        return (BarChart) this.barChart$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateChartData() {
        float f = 0.0f;
        for (BarEntry barEntry : this.values) {
            if (f < barEntry.I0Io()) {
                f = barEntry.I0Io();
            }
        }
        xxx00.oIX0oI oix0oi = xxx00.oIX0oI.f35574oIX0oI;
        YAxis axisLeft = getBarChart().getAxisLeft();
        IIX0o.oO(axisLeft, "getAxisLeft(...)");
        YAxis axisRight = getBarChart().getAxisRight();
        IIX0o.oO(axisRight, "getAxisRight(...)");
        oix0oi.oxoX(axisLeft, axisRight, f);
        if (getBarChart().getData() != 0 && ((o0xxxXXxX.oIX0oI) getBarChart().getData()).ooOOo0oXI() > 0) {
            T OOXIXo2 = ((o0xxxXXxX.oIX0oI) getBarChart().getData()).OOXIXo(0);
            IIX0o.x0XOIxOo(OOXIXo2, "null cannot be cast to non-null type com.github.mikephil.charting.data.BarDataSet");
            setSetValue((II0xO0) OOXIXo2);
            getSetValue().oX0ooo0I0(this.values);
            getSetValue().I0xX0();
            ((o0xxxXXxX.oIX0oI) getBarChart().getData()).XxX0x0xxx();
            getBarChart().X00IoxXI();
        } else {
            setSetValue(new II0xO0(this.values, setDataLabel()));
            setColor(getSetValue());
            o0xxxXXxX.oIX0oI oix0oi2 = new o0xxxXXxX.oIX0oI(getSetValue());
            oix0oi2.oo0xXOI0I(false);
            getBarChart().setData(oix0oi2);
        }
        getBarChart().II0XooXoX(1000);
        getBarChart().invalidate();
        for (BarEntry barEntry2 : this.values) {
            if (barEntry2.I0Io() > 0.0f) {
                this.highlight = barEntry2.xxIXOIIO();
            }
        }
        getBarChart().XIxXXX0x0(this.highlight, 0);
    }

    @CallSuper
    public void filterData(@OOXIXo List<Activity> data) {
        IIX0o.x0xO0oo(data, "data");
        this.values.clear();
    }

    @OOXIXo
    public final LinkedHashMap<Long, ArrayList<Activity>> getFilterData() {
        return this.filterData;
    }

    public final float getHighlight() {
        return this.highlight;
    }

    public final PFMedium getOneTV() {
        return (PFMedium) this.oneTV$delegate.getValue();
    }

    public final DINCondBold getOneValue() {
        return (DINCondBold) this.oneValue$delegate.getValue();
    }

    @OOXIXo
    public final II0xO0 getSetValue() {
        II0xO0 iI0xO0 = this.setValue;
        if (iI0xO0 != null) {
            return iI0xO0;
        }
        IIX0o.XOxIOxOx("setValue");
        return null;
    }

    public final PFMedium getTotalUnit() {
        return (PFMedium) this.totalUnit$delegate.getValue();
    }

    public final PFMedium getTwoTV() {
        return (PFMedium) this.twoTV$delegate.getValue();
    }

    public final PFMedium getTwoUnit() {
        return (PFMedium) this.twoUnit$delegate.getValue();
    }

    public final DINCondBold getTwoValue() {
        return (DINCondBold) this.twoValue$delegate.getValue();
    }

    @OOXIXo
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
        oix0oi.Oxx0IOOO(axisLeft, axisRight, 0.0f, 0.0f, ContextCompat.getColor(getMActivity(), R.color.line_color));
        BarChart barChart2 = getBarChart();
        barChart2.setDrawValueAboveBar(false);
        barChart2.setScaleEnabled(false);
        barChart2.getDescription().Oxx0IOOO(false);
        barChart2.getLegend().Oxx0IOOO(false);
        XAxis xAxis = getBarChart().getXAxis();
        IIX0o.ooOOo0oXI(xAxis);
        Context context = getBarChart().getContext();
        IIX0o.oO(context, "getContext(...)");
        oix0oi.X0o0xo(xAxis, false, context);
        setRange(xoIox.OxI(null, TimePeriod.DAY, 0, 5, null));
        xAxis.OO(4.0f);
        xAxis.I0X0x0oIo(-1.0f);
        xAxis.xXOx(25.0f);
        SimpleDateFormat xXOx2 = xoIox.xXOx(false, 1, null);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 25; i++) {
            String millis2String = TimeUtils.millis2String(getRange()[0] + (i * 3600 * 1000), xXOx2);
            if (arrayList.size() > 12 && IIX0o.Oxx0IOOO(millis2String, "0")) {
                millis2String = com.tencent.connect.common.II0xO0.f26868oxOXxoXII;
            }
            IIX0o.ooOOo0oXI(millis2String);
            arrayList.add(millis2String);
        }
        xAxis.o0xxxXXxX(new oOoXoXO(arrayList));
        xxx00.II0xO0 iI0xO0 = new xxx00.II0xO0(getBarChart(), getBarChart().getAnimator(), getBarChart().getViewPortHandler());
        iI0xO0.X0IIOO(oIxOXo.oxoX.I0Io(getMActivity(), R.color.line_color));
        getBarChart().setRenderer(iI0xO0);
        getBarChart().setOnChartValueSelectedListener(new oIX0oI(xoIox.oxXx0IX(false, 1, null)));
        super.initView();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_status_day;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    public void onDataChange(@OOXIXo List<Activity> data) {
        IIX0o.x0xO0oo(data, "data");
        filterData(data);
        updateChartData();
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    @OOXIXo
    public List<Activity> onTimePeriodChange(@OOXIXo Calendar calendar, int i, @OOXIXo TimePeriod timePeriod) {
        IIX0o.x0xO0oo(calendar, "calendar");
        IIX0o.x0xO0oo(timePeriod, "timePeriod");
        setRange(xoIox.o00(calendar, timePeriod, i));
        this.filterData.clear();
        for (int i2 = 1; i2 < 25; i2++) {
            this.filterData.put(Long.valueOf(getRange()[0] + (3600000 * i2)), new ArrayList<>());
        }
        return this.mActivityDao.getListASC(getRange()[0] + 1000, getRange()[1]);
    }

    public void setColor(@OOXIXo II0xO0 value) {
        IIX0o.x0xO0oo(value, "value");
    }

    @OOXIXo
    public String setDataLabel() {
        return "";
    }

    public final void setFilterData(@OOXIXo LinkedHashMap<Long, ArrayList<Activity>> linkedHashMap) {
        IIX0o.x0xO0oo(linkedHashMap, "<set-?>");
        this.filterData = linkedHashMap;
    }

    public final void setHighlight(float f) {
        this.highlight = f;
    }

    public final void setSetValue(@OOXIXo II0xO0 iI0xO0) {
        IIX0o.x0xO0oo(iI0xO0, "<set-?>");
        this.setValue = iI0xO0;
    }

    public void updateItemData(@OOXIXo Entry e) {
        IIX0o.x0xO0oo(e, "e");
    }
}
