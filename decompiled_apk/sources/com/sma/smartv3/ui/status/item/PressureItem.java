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
import com.sma.smartv3.db.dao.PressureDao;
import com.sma.smartv3.db.entity.Pressure;
import com.sma.smartv3.model.PressureDataKt;
import com.sma.smartv3.model.PressureDayData;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.text.DINCondBold;
import com.szabh.smable3.component.BleConnector;
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
public final class PressureItem extends BaseDslItem {
    private BarChart barChart;
    private Context mContext;
    private DINCondBold noData;
    private long[] range;
    private DINCondBold tvTime;
    private DINCondBold tvValue;

    @OXOo.OOXIXo
    private final PressureDao mPressureDao = MyDb.INSTANCE.getMDatabase().pressureDao();

    @OXOo.OOXIXo
    private final LinkedHashMap<Long, ArrayList<Pressure>> filterData = new LinkedHashMap<>();

    @OXOo.OOXIXo
    private final List<BarEntry> values = new ArrayList();
    private final boolean initEvent = true;

    private final void initChart(List<Pressure> list) {
        BarChart barChart;
        char c = 0;
        this.filterData.clear();
        int i = 1;
        while (true) {
            barChart = null;
            long[] jArr = null;
            if (i >= 25) {
                break;
            }
            LinkedHashMap<Long, ArrayList<Pressure>> linkedHashMap = this.filterData;
            long[] jArr2 = this.range;
            if (jArr2 == null) {
                IIX0o.XOxIOxOx("range");
            } else {
                jArr = jArr2;
            }
            linkedHashMap.put(Long.valueOf(jArr[0] + (i * 3600 * 1000)), new ArrayList<>());
            i++;
        }
        for (Pressure pressure : list) {
            Iterator<Map.Entry<Long, ArrayList<Pressure>>> it = this.filterData.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<Long, ArrayList<Pressure>> next = it.next();
                    long longValue = next.getKey().longValue();
                    ArrayList<Pressure> value = next.getValue();
                    if (pressure.getMTime() <= longValue) {
                        value.add(pressure);
                        break;
                    }
                }
            }
        }
        ArrayList<PressureDayData> arrayList = new ArrayList();
        Iterator<Map.Entry<Long, ArrayList<Pressure>>> it2 = this.filterData.entrySet().iterator();
        while (it2.hasNext()) {
            ArrayList<Pressure> value2 = it2.next().getValue();
            PressureDayData pressureDayData = new PressureDayData(0, 0, 0, null, 15, null);
            if (value2.size() != 0) {
                Iterator<Pressure> it3 = value2.iterator();
                int i2 = 0;
                while (it3.hasNext()) {
                    Pressure next2 = it3.next();
                    if (pressureDayData.getMin() == 0 || pressureDayData.getMin() > next2.getMValue()) {
                        pressureDayData.setMin(next2.getMValue());
                    }
                    if (pressureDayData.getMax() < next2.getMValue()) {
                        pressureDayData.setMax(next2.getMValue());
                    }
                    i2 += next2.getMValue();
                }
                pressureDayData.setAvg(i2 / value2.size());
            }
            arrayList.add(pressureDayData);
        }
        float f = 0.0f;
        int i3 = 0;
        int i4 = 0;
        for (PressureDayData pressureDayData2 : arrayList) {
            float min = pressureDayData2.getMin();
            float max = pressureDayData2.getMax();
            float avg = pressureDayData2.getAvg();
            List<BarEntry> list2 = this.values;
            float[] fArr = new float[2];
            fArr[c] = 0.0f;
            fArr[1] = avg;
            Context context = this.mContext;
            if (context == null) {
                IIX0o.XOxIOxOx("mContext");
                context = null;
            }
            list2.add(new BarEntry(f, fArr, PressureDataKt.getBarColors(context, pressureDayData2.getAvg())));
            if (i3 < max) {
                i3 = (int) max;
            }
            if (i4 == 0) {
                i4 = pressureDayData2.getAvg();
            }
            if (min != 0.0f && i4 > min) {
                i4 = (int) min;
            }
            pressureDayData2.getAvg();
            f += 1.0f;
            c = 0;
        }
        xxx00.oIX0oI oix0oi = xxx00.oIX0oI.f35574oIX0oI;
        BarChart barChart2 = this.barChart;
        if (barChart2 == null) {
            IIX0o.XOxIOxOx("barChart");
            barChart2 = null;
        }
        YAxis axisLeft = barChart2.getAxisLeft();
        IIX0o.oO(axisLeft, "getAxisLeft(...)");
        BarChart barChart3 = this.barChart;
        if (barChart3 == null) {
            IIX0o.XOxIOxOx("barChart");
        } else {
            barChart = barChart3;
        }
        YAxis axisRight = barChart.getAxisRight();
        IIX0o.oO(axisRight, "getAxisRight(...)");
        oix0oi.XO(axisLeft, axisRight, 100.0f, 0.0f);
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
        o0xxxXXxX.II0xO0 iI0xO0 = new o0xxxXXxX.II0xO0(list, "");
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
        View v = itemHolder.v(R.id.pressureBarChart);
        IIX0o.ooOOo0oXI(v);
        this.barChart = (BarChart) v;
        View v2 = itemHolder.v(R.id.pressureLastTime);
        IIX0o.ooOOo0oXI(v2);
        this.tvTime = (DINCondBold) v2;
        View v3 = itemHolder.v(R.id.pressureLastValue);
        IIX0o.ooOOo0oXI(v3);
        this.tvValue = (DINCondBold) v3;
        View v4 = itemHolder.v(R.id.noData);
        IIX0o.ooOOo0oXI(v4);
        this.noData = (DINCondBold) v4;
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
        oix0oi.XO(axisLeft, axisRight, 100.0f, 0.0f);
        BarChart barChart6 = this.barChart;
        if (barChart6 == null) {
            IIX0o.XOxIOxOx("barChart");
            barChart6 = null;
        }
        barChart6.setTouchEnabled(false);
        barChart6.getDescription().Oxx0IOOO(false);
        barChart6.getLegend().Oxx0IOOO(false);
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
        BarChart barChart8 = this.barChart;
        if (barChart8 == null) {
            IIX0o.XOxIOxOx("barChart");
            barChart8 = null;
        }
        Context context3 = barChart8.getContext();
        IIX0o.oO(context3, "getContext(...)");
        oix0oi.X0o0xo(xAxis, true, context3);
        this.range = com.sma.smartv3.util.xoIox.OxI(null, TimePeriod.DAY, 0, 5, null);
        xAxis.f4025ooXIXxIX = 0.0f;
        xAxis.f4006IIX0o = 24.0f;
        SimpleDateFormat xXOx2 = com.sma.smartv3.util.xoIox.xXOx(false, 1, null);
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i < 25; i++) {
            long[] jArr = this.range;
            if (jArr == null) {
                IIX0o.XOxIOxOx("range");
                jArr = null;
            }
            String millis2String = TimeUtils.millis2String(jArr[0] + (i * 3600 * 1000), xXOx2);
            IIX0o.oO(millis2String, "millis2String(...)");
            arrayList.add(millis2String);
        }
        xAxis.o0xxxXXxX(new ox.oOoXoXO(arrayList));
        BarChart barChart9 = this.barChart;
        if (barChart9 == null) {
            IIX0o.XOxIOxOx("barChart");
            barChart9 = null;
        }
        BarChart barChart10 = this.barChart;
        if (barChart10 == null) {
            IIX0o.XOxIOxOx("barChart");
            barChart10 = null;
        }
        Ioxxx.oIX0oI animator = barChart10.getAnimator();
        BarChart barChart11 = this.barChart;
        if (barChart11 == null) {
            IIX0o.XOxIOxOx("barChart");
            barChart11 = null;
        }
        xxx00.II0xO0 iI0xO0 = new xxx00.II0xO0(barChart9, animator, barChart11.getViewPortHandler());
        Context context4 = this.mContext;
        if (context4 == null) {
            IIX0o.XOxIOxOx("mContext");
            context4 = null;
        }
        iI0xO0.X0IIOO(oIxOXo.oxoX.I0Io(context4, R.color.line_color));
        Context context5 = this.mContext;
        if (context5 == null) {
            IIX0o.XOxIOxOx("mContext");
            context5 = null;
        }
        int color = ContextCompat.getColor(context5, R.color.p_show_1);
        Context context6 = this.mContext;
        if (context6 == null) {
            IIX0o.XOxIOxOx("mContext");
            context6 = null;
        }
        iI0xO0.O0xOxO(new int[]{color, ContextCompat.getColor(context6, R.color.p_show_2)});
        iI0xO0.oI0IIXIo(5);
        BarChart barChart12 = this.barChart;
        if (barChart12 == null) {
            IIX0o.XOxIOxOx("barChart");
        } else {
            barChart2 = barChart12;
        }
        barChart2.setRenderer(iI0xO0);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public boolean getInitEvent() {
        return this.initEvent;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        setItemHidden(!BleConnector.INSTANCE.isBound());
        this.values.clear();
        DINCondBold dINCondBold = null;
        long[] jArr = null;
        long[] OxI2 = com.sma.smartv3.util.xoIox.OxI(null, TimePeriod.DAY, 0, 5, null);
        this.range = OxI2;
        PressureDao pressureDao = this.mPressureDao;
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
        List<Pressure> pressures = pressureDao.getPressures(j, jArr2[1]);
        if (pressures.isEmpty()) {
            DINCondBold dINCondBold2 = this.tvTime;
            if (dINCondBold2 == null) {
                IIX0o.XOxIOxOx("tvTime");
                dINCondBold2 = null;
            }
            dINCondBold2.setText(R.string.data_none);
            DINCondBold dINCondBold3 = this.tvValue;
            if (dINCondBold3 == null) {
                IIX0o.XOxIOxOx("tvValue");
                dINCondBold3 = null;
            }
            dINCondBold3.setText(R.string.data_none);
            BarChart barChart = this.barChart;
            if (barChart == null) {
                IIX0o.XOxIOxOx("barChart");
                barChart = null;
            }
            barChart.setVisibility(8);
            DINCondBold dINCondBold4 = this.noData;
            if (dINCondBold4 == null) {
                IIX0o.XOxIOxOx("noData");
                dINCondBold4 = null;
            }
            dINCondBold4.setVisibility(0);
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
                DINCondBold dINCondBold5 = this.noData;
                if (dINCondBold5 == null) {
                    IIX0o.XOxIOxOx("noData");
                    dINCondBold5 = null;
                }
                dINCondBold5.setVisibility(8);
                PressureDao pressureDao2 = this.mPressureDao;
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
                initChart(pressureDao2.getTestPressures(j2, jArr[1]));
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
        DINCondBold dINCondBold6 = this.noData;
        if (dINCondBold6 == null) {
            IIX0o.XOxIOxOx("noData");
            dINCondBold6 = null;
        }
        dINCondBold6.setVisibility(8);
        DINCondBold dINCondBold7 = this.tvTime;
        if (dINCondBold7 == null) {
            IIX0o.XOxIOxOx("tvTime");
            dINCondBold7 = null;
        }
        dINCondBold7.setText(com.sma.smartv3.util.xoIox.oxxXoxO(false, false, 3, null).format(new Date(((Pressure) CollectionsKt___CollectionsKt.O0O0Io00X(pressures)).getMTime())));
        DINCondBold dINCondBold8 = this.tvValue;
        if (dINCondBold8 == null) {
            IIX0o.XOxIOxOx("tvValue");
        } else {
            dINCondBold = dINCondBold8;
        }
        dINCondBold.setText(String.valueOf(((Pressure) CollectionsKt___CollectionsKt.O0O0Io00X(pressures)).getMValue()));
        initChart(pressures);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.status_item_pressure;
    }

    @XO0.XO(tag = x0xO0oo.f24639ooOOo0oXI)
    public final void onPressureChanged(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onPressureChanged");
        initView();
    }
}
