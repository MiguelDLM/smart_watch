package com.sma.smartv3.ui.status.item;

import android.content.Context;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.BloodPressureDao;
import com.sma.smartv3.db.entity.BloodPressure;
import com.sma.smartv3.model.BPHourData;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.text.DINCondBold;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class BloodPressureItem extends BaseDslItem {
    private BarChart barChart;
    private DINCondBold bpLastTime;
    private DINCondBold dbp;
    private Context mContext;
    private DINCondBold noData;
    private long[] range;
    private DINCondBold sbp;

    @OXOo.OOXIXo
    private final BloodPressureDao mBloodPressureDao = MyDb.INSTANCE.getMDatabase().bloodPressureDao();

    @OXOo.OOXIXo
    private final LinkedHashMap<Long, BPHourData> dataMap = new LinkedHashMap<>();

    @OXOo.OOXIXo
    private final List<BarEntry> values = new ArrayList();
    private final boolean initEvent = true;

    private final void initChart(List<BloodPressure> list) {
        this.dataMap.clear();
        long[] jArr = this.range;
        long[] jArr2 = null;
        if (jArr == null) {
            IIX0o.XOxIOxOx("range");
            jArr = null;
        }
        long j = jArr[0];
        long[] jArr3 = this.range;
        if (jArr3 == null) {
            IIX0o.XOxIOxOx("range");
        } else {
            jArr2 = jArr3;
        }
        long oxoX2 = xx0o0O.x0XOIxOo.oxoX(j, jArr2[1], 3600000L);
        if (j <= oxoX2) {
            while (true) {
                this.dataMap.put(Long.valueOf(j), new BPHourData(0, 0, 0, 0, 0, 0, 0, 0, 255, null));
                if (j == oxoX2) {
                    break;
                } else {
                    j += 3600000;
                }
            }
        }
        for (BloodPressure bloodPressure : list) {
            Iterator<Map.Entry<Long, BPHourData>> it = this.dataMap.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<Long, BPHourData> next = it.next();
                    long longValue = next.getKey().longValue();
                    BPHourData value = next.getValue();
                    if (bloodPressure.getMTime() < longValue) {
                        if (value.getDbpMax() < bloodPressure.getMDiastolic()) {
                            value.setDbpMax(bloodPressure.getMDiastolic());
                        }
                        if (value.getDbpMin() > bloodPressure.getMDiastolic() || value.getDbpMin() == 0) {
                            value.setDbpMin(bloodPressure.getMDiastolic());
                        }
                        if (value.getSbpMax() < bloodPressure.getMSystolic()) {
                            value.setSbpMax(bloodPressure.getMSystolic());
                        }
                        if (value.getSbpMin() > bloodPressure.getMSystolic() || value.getSbpMin() == 0) {
                            value.setSbpMin(bloodPressure.getMSystolic());
                        }
                        value.setDbpTotal(value.getDbpTotal() + bloodPressure.getMDiastolic());
                        value.setDbpNum(value.getDbpNum() + 1);
                        value.setSbpTotal(value.getSbpTotal() + bloodPressure.getMSystolic());
                        value.setSbpNum(value.getSbpNum() + 1);
                    }
                }
            }
        }
        Iterator<Map.Entry<Long, BPHourData>> it2 = this.dataMap.entrySet().iterator();
        int i = 0;
        while (it2.hasNext()) {
            BPHourData value2 = it2.next().getValue();
            this.values.add(new BarEntry(i, new float[]{value2.getDbpMin(), value2.getSbpMax() - value2.getDbpMin()}));
            i++;
        }
        updateData(this.values);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateData(List<BarEntry> list) {
        BarChart barChart = this.barChart;
        BarChart barChart2 = null;
        if (barChart == null) {
            IIX0o.XOxIOxOx("barChart");
            barChart = null;
        }
        if (barChart.getData() != 0) {
            BarChart barChart3 = this.barChart;
            if (barChart3 == null) {
                IIX0o.XOxIOxOx("barChart");
                barChart3 = null;
            }
            if (((o0xxxXXxX.oIX0oI) barChart3.getData()).ooOOo0oXI() > 0) {
                BarChart barChart4 = this.barChart;
                if (barChart4 == null) {
                    IIX0o.XOxIOxOx("barChart");
                    barChart4 = null;
                }
                ((o0xxxXXxX.oIX0oI) barChart4.getData()).xXxxox0I(0);
            }
        }
        o0xxxXXxX.II0xO0 iI0xO0 = new o0xxxXXxX.II0xO0(list, "BP Data");
        Context context = this.mContext;
        if (context == null) {
            IIX0o.XOxIOxOx("mContext");
            context = null;
        }
        iI0xO0.o0IXXIx(CollectionsKt__CollectionsKt.X00IoxXI(0, Integer.valueOf(ContextCompat.getColor(context, R.color.colorAccent))));
        o0xxxXXxX.oIX0oI oix0oi = new o0xxxXXxX.oIX0oI(iI0xO0);
        oix0oi.oo0xXOI0I(false);
        BarChart barChart5 = this.barChart;
        if (barChart5 == null) {
            IIX0o.XOxIOxOx("barChart");
            barChart5 = null;
        }
        barChart5.setData(oix0oi);
        BarChart barChart6 = this.barChart;
        if (barChart6 == null) {
            IIX0o.XOxIOxOx("barChart");
        } else {
            barChart2 = barChart6;
        }
        barChart2.invalidate();
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OXOo.OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.bpChart);
        IIX0o.ooOOo0oXI(v);
        this.barChart = (BarChart) v;
        View v2 = itemHolder.v(R.id.bpLastTime);
        IIX0o.ooOOo0oXI(v2);
        this.bpLastTime = (DINCondBold) v2;
        View v3 = itemHolder.v(R.id.sbp);
        IIX0o.ooOOo0oXI(v3);
        this.sbp = (DINCondBold) v3;
        View v4 = itemHolder.v(R.id.dbp);
        IIX0o.ooOOo0oXI(v4);
        this.dbp = (DINCondBold) v4;
        View v5 = itemHolder.v(R.id.noData);
        IIX0o.ooOOo0oXI(v5);
        this.noData = (DINCondBold) v5;
        BarChart barChart = this.barChart;
        BarChart barChart2 = null;
        if (barChart == null) {
            IIX0o.XOxIOxOx("barChart");
            barChart = null;
        }
        Context context = barChart.getContext();
        IIX0o.oO(context, "getContext(...)");
        this.mContext = context;
        xxx00.oIX0oI oix0oi = xxx00.oIX0oI.f35574oIX0oI;
        BarChart barChart3 = this.barChart;
        if (barChart3 == null) {
            IIX0o.XOxIOxOx("barChart");
            barChart3 = null;
        }
        oix0oi.oIX0oI(barChart3);
        BarChart barChart4 = this.barChart;
        if (barChart4 == null) {
            IIX0o.XOxIOxOx("barChart");
            barChart4 = null;
        }
        YAxis axisLeft = barChart4.getAxisLeft();
        IIX0o.oO(axisLeft, "getAxisLeft(...)");
        BarChart barChart5 = this.barChart;
        if (barChart5 == null) {
            IIX0o.XOxIOxOx("barChart");
            barChart5 = null;
        }
        YAxis axisRight = barChart5.getAxisRight();
        IIX0o.oO(axisRight, "getAxisRight(...)");
        oix0oi.XO(axisLeft, axisRight, 200.0f, 30.0f);
        BarChart barChart6 = this.barChart;
        if (barChart6 == null) {
            IIX0o.XOxIOxOx("barChart");
            barChart6 = null;
        }
        barChart6.getLegend().Oxx0IOOO(false);
        barChart6.getDescription().Oxx0IOOO(false);
        barChart6.setTouchEnabled(false);
        barChart6.setDrawValueAboveBar(false);
        YAxis axisLeft2 = barChart6.getAxisLeft();
        Context context2 = this.mContext;
        if (context2 == null) {
            IIX0o.XOxIOxOx("mContext");
            context2 = null;
        }
        axisLeft2.ooOOo0oXI(oix0oi.I0Io(context2));
        BarChart barChart7 = this.barChart;
        if (barChart7 == null) {
            IIX0o.XOxIOxOx("barChart");
            barChart7 = null;
        }
        XAxis xAxis = barChart7.getXAxis();
        IIX0o.ooOOo0oXI(xAxis);
        Context context3 = this.mContext;
        if (context3 == null) {
            IIX0o.XOxIOxOx("mContext");
            context3 = null;
        }
        oix0oi.X0o0xo(xAxis, true, context3);
        this.range = com.sma.smartv3.util.xoIox.OxI(null, TimePeriod.DAY, 0, 5, null);
        xAxis.OO(1.0f);
        xAxis.XIo0oOXIx(7);
        xAxis.xXOx(24.0f);
        SimpleDateFormat O0Xx2 = com.sma.smartv3.util.xoIox.O0Xx(false, 1, null);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 25; i++) {
            long[] jArr = this.range;
            if (jArr == null) {
                IIX0o.XOxIOxOx("range");
                jArr = null;
            }
            String millis2String = TimeUtils.millis2String(jArr[0] + (i * 3600 * 1000), O0Xx2);
            IIX0o.oO(millis2String, "millis2String(...)");
            arrayList.add(millis2String);
        }
        xAxis.o0xxxXXxX(new ox.oOoXoXO(arrayList));
        BarChart barChart8 = this.barChart;
        if (barChart8 == null) {
            IIX0o.XOxIOxOx("barChart");
            barChart8 = null;
        }
        BarChart barChart9 = this.barChart;
        if (barChart9 == null) {
            IIX0o.XOxIOxOx("barChart");
            barChart9 = null;
        }
        Ioxxx.oIX0oI animator = barChart9.getAnimator();
        BarChart barChart10 = this.barChart;
        if (barChart10 == null) {
            IIX0o.XOxIOxOx("barChart");
            barChart10 = null;
        }
        xxx00.II0xO0 iI0xO0 = new xxx00.II0xO0(barChart8, animator, barChart10.getViewPortHandler());
        Context context4 = this.mContext;
        if (context4 == null) {
            IIX0o.XOxIOxOx("mContext");
            context4 = null;
        }
        iI0xO0.X0IIOO(oIxOXo.oxoX.I0Io(context4, R.color.line_color));
        iI0xO0.XIxXXX0x0(8);
        Context context5 = this.mContext;
        if (context5 == null) {
            IIX0o.XOxIOxOx("mContext");
            context5 = null;
        }
        iI0xO0.o00(oIxOXo.oxoX.I0Io(context5, R.color.bp_line_color));
        Context context6 = this.mContext;
        if (context6 == null) {
            IIX0o.XOxIOxOx("mContext");
            context6 = null;
        }
        int color = ContextCompat.getColor(context6, R.color.bp_secondary_color);
        Context context7 = this.mContext;
        if (context7 == null) {
            IIX0o.XOxIOxOx("mContext");
            context7 = null;
        }
        iI0xO0.O0xOxO(new int[]{color, ContextCompat.getColor(context7, R.color.bp_color)});
        iI0xO0.oI0IIXIo(3);
        BarChart barChart11 = this.barChart;
        if (barChart11 == null) {
            IIX0o.XOxIOxOx("barChart");
        } else {
            barChart2 = barChart11;
        }
        barChart2.setRenderer(iI0xO0);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public boolean getInitEvent() {
        return this.initEvent;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        this.values.clear();
        DINCondBold dINCondBold = null;
        long[] jArr = null;
        long[] OxI2 = com.sma.smartv3.util.xoIox.OxI(null, TimePeriod.DAY, 0, 5, null);
        this.range = OxI2;
        BloodPressureDao bloodPressureDao = this.mBloodPressureDao;
        if (OxI2 == null) {
            IIX0o.XOxIOxOx("range");
            OxI2 = null;
        }
        long j = OxI2[0];
        long[] jArr2 = this.range;
        if (jArr2 == null) {
            IIX0o.XOxIOxOx("range");
            jArr2 = null;
        }
        List<BloodPressure> bloodPressures = bloodPressureDao.getBloodPressures(j, jArr2[1]);
        if (bloodPressures.isEmpty()) {
            DINCondBold dINCondBold2 = this.bpLastTime;
            if (dINCondBold2 == null) {
                IIX0o.XOxIOxOx("bpLastTime");
                dINCondBold2 = null;
            }
            dINCondBold2.setText(R.string.data_none);
            DINCondBold dINCondBold3 = this.sbp;
            if (dINCondBold3 == null) {
                IIX0o.XOxIOxOx("sbp");
                dINCondBold3 = null;
            }
            dINCondBold3.setText(R.string.data_none);
            DINCondBold dINCondBold4 = this.dbp;
            if (dINCondBold4 == null) {
                IIX0o.XOxIOxOx("dbp");
                dINCondBold4 = null;
            }
            dINCondBold4.setText(R.string.data_none);
            BarChart barChart = this.barChart;
            if (barChart == null) {
                IIX0o.XOxIOxOx("barChart");
                barChart = null;
            }
            barChart.setVisibility(8);
            DINCondBold dINCondBold5 = this.noData;
            if (dINCondBold5 == null) {
                IIX0o.XOxIOxOx("noData");
                dINCondBold5 = null;
            }
            dINCondBold5.setVisibility(0);
            if (ProjectManager.f19822oIX0oI.xX0IIXIx0()) {
                BarChart barChart2 = this.barChart;
                if (barChart2 == null) {
                    IIX0o.XOxIOxOx("barChart");
                    barChart2 = null;
                }
                barChart2.getXAxis().I0oOIX(false);
                BarChart barChart3 = this.barChart;
                if (barChart3 == null) {
                    IIX0o.XOxIOxOx("barChart");
                    barChart3 = null;
                }
                barChart3.setVisibility(0);
                DINCondBold dINCondBold6 = this.noData;
                if (dINCondBold6 == null) {
                    IIX0o.XOxIOxOx("noData");
                    dINCondBold6 = null;
                }
                dINCondBold6.setVisibility(8);
                BloodPressureDao bloodPressureDao2 = this.mBloodPressureDao;
                long[] jArr3 = this.range;
                if (jArr3 == null) {
                    IIX0o.XOxIOxOx("range");
                    jArr3 = null;
                }
                long j2 = jArr3[0];
                long[] jArr4 = this.range;
                if (jArr4 == null) {
                    IIX0o.XOxIOxOx("range");
                } else {
                    jArr = jArr4;
                }
                initChart(bloodPressureDao2.getTestBloodPressures(j2, jArr[1]));
                return;
            }
            return;
        }
        BarChart barChart4 = this.barChart;
        if (barChart4 == null) {
            IIX0o.XOxIOxOx("barChart");
            barChart4 = null;
        }
        barChart4.getXAxis().I0oOIX(true);
        BarChart barChart5 = this.barChart;
        if (barChart5 == null) {
            IIX0o.XOxIOxOx("barChart");
            barChart5 = null;
        }
        barChart5.setVisibility(0);
        DINCondBold dINCondBold7 = this.noData;
        if (dINCondBold7 == null) {
            IIX0o.XOxIOxOx("noData");
            dINCondBold7 = null;
        }
        dINCondBold7.setVisibility(8);
        BloodPressure bloodPressure = (BloodPressure) CollectionsKt___CollectionsKt.O0O0Io00X(bloodPressures);
        DINCondBold dINCondBold8 = this.bpLastTime;
        if (dINCondBold8 == null) {
            IIX0o.XOxIOxOx("bpLastTime");
            dINCondBold8 = null;
        }
        dINCondBold8.setText(com.sma.smartv3.util.xoIox.oxxXoxO(false, false, 3, null).format(new Date(bloodPressure.getMTime())));
        DINCondBold dINCondBold9 = this.sbp;
        if (dINCondBold9 == null) {
            IIX0o.XOxIOxOx("sbp");
            dINCondBold9 = null;
        }
        dINCondBold9.setText(String.valueOf(bloodPressure.getMSystolic()));
        DINCondBold dINCondBold10 = this.dbp;
        if (dINCondBold10 == null) {
            IIX0o.XOxIOxOx("dbp");
        } else {
            dINCondBold = dINCondBold10;
        }
        dINCondBold.setText(String.valueOf(bloodPressure.getMDiastolic()));
        initChart(bloodPressures);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.status_item_blood_pressure;
    }

    @XO0.XO(tag = x0xO0oo.f24562I0Io)
    public final void onBloodPressureChanged(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onBloodPressureChanged");
        initView();
    }
}
