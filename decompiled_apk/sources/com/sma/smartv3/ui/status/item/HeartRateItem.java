package com.sma.smartv3.ui.status.item;

import android.content.Context;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.HeartRateDao;
import com.sma.smartv3.db.entity.HeartRate;
import com.sma.smartv3.model.HRMinuteData;
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
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class HeartRateItem extends BaseDslItem {
    private LineChart lineChart;
    private Context mContext;
    private DINCondBold noData;
    private long[] range;
    private DINCondBold tvBpm;
    private DINCondBold tvTime;

    @OXOo.OOXIXo
    private final HeartRateDao mHeartRateDao = MyDb.INSTANCE.getMDatabase().heartRateDao();

    @OXOo.OOXIXo
    private final LinkedHashMap<Long, HRMinuteData> filterData = new LinkedHashMap<>();
    private final boolean initEvent = true;

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OXOo.OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.hrLineChart);
        IIX0o.ooOOo0oXI(v);
        this.lineChart = (LineChart) v;
        View v2 = itemHolder.v(R.id.hrLastTime);
        IIX0o.ooOOo0oXI(v2);
        this.tvTime = (DINCondBold) v2;
        View v3 = itemHolder.v(R.id.hrLastValue);
        IIX0o.ooOOo0oXI(v3);
        this.tvBpm = (DINCondBold) v3;
        View v4 = itemHolder.v(R.id.noData);
        IIX0o.ooOOo0oXI(v4);
        this.noData = (DINCondBold) v4;
        LineChart lineChart = this.lineChart;
        LineChart lineChart2 = null;
        if (lineChart == null) {
            IIX0o.XOxIOxOx("lineChart");
            lineChart = null;
        }
        Context context = lineChart.getContext();
        IIX0o.oO(context, "getContext(...)");
        this.mContext = context;
        xxx00.oIX0oI oix0oi = xxx00.oIX0oI.f35574oIX0oI;
        LineChart lineChart3 = this.lineChart;
        if (lineChart3 == null) {
            IIX0o.XOxIOxOx("lineChart");
            lineChart3 = null;
        }
        oix0oi.II0xO0(lineChart3);
        LineChart lineChart4 = this.lineChart;
        if (lineChart4 == null) {
            IIX0o.XOxIOxOx("lineChart");
            lineChart4 = null;
        }
        YAxis axisLeft = lineChart4.getAxisLeft();
        IIX0o.oO(axisLeft, "getAxisLeft(...)");
        LineChart lineChart5 = this.lineChart;
        if (lineChart5 == null) {
            IIX0o.XOxIOxOx("lineChart");
            lineChart5 = null;
        }
        YAxis axisRight = lineChart5.getAxisRight();
        IIX0o.oO(axisRight, "getAxisRight(...)");
        oix0oi.XO(axisLeft, axisRight, 200.0f, 30.0f);
        LineChart lineChart6 = this.lineChart;
        if (lineChart6 == null) {
            IIX0o.XOxIOxOx("lineChart");
            lineChart6 = null;
        }
        lineChart6.setTouchEnabled(false);
        lineChart6.getDescription().Oxx0IOOO(false);
        lineChart6.getLegend().Oxx0IOOO(false);
        YAxis axisLeft2 = lineChart6.getAxisLeft();
        Context context2 = this.mContext;
        if (context2 == null) {
            IIX0o.XOxIOxOx("mContext");
            context2 = null;
        }
        axisLeft2.ooOOo0oXI(oix0oi.I0Io(context2));
        LineChart lineChart7 = this.lineChart;
        if (lineChart7 == null) {
            IIX0o.XOxIOxOx("lineChart");
            lineChart7 = null;
        }
        XAxis xAxis = lineChart7.getXAxis();
        IIX0o.ooOOo0oXI(xAxis);
        LineChart lineChart8 = this.lineChart;
        if (lineChart8 == null) {
            IIX0o.XOxIOxOx("lineChart");
            lineChart8 = null;
        }
        Context context3 = lineChart8.getContext();
        IIX0o.oO(context3, "getContext(...)");
        oix0oi.X0o0xo(xAxis, true, context3);
        int oIX0oI2 = com.sma.smartv3.util.xoIox.oIX0oI();
        this.range = com.sma.smartv3.util.xoIox.OxI(null, TimePeriod.DAY, 0, 5, null);
        xAxis.I0X0x0oIo(0.0f);
        float f = oIX0oI2;
        xAxis.OO(f / 6);
        xAxis.xXOx(f);
        SimpleDateFormat O0Xx2 = com.sma.smartv3.util.xoIox.O0Xx(false, 1, null);
        ArrayList arrayList = new ArrayList();
        if (oIX0oI2 >= 0) {
            int i = 0;
            while (true) {
                long[] jArr = this.range;
                if (jArr == null) {
                    IIX0o.XOxIOxOx("range");
                    jArr = null;
                }
                String millis2String = TimeUtils.millis2String(jArr[0] + (60000 * i), O0Xx2);
                IIX0o.oO(millis2String, "millis2String(...)");
                arrayList.add(millis2String);
                if (i == oIX0oI2) {
                    break;
                } else {
                    i++;
                }
            }
        }
        xAxis.o0xxxXXxX(new ox.oOoXoXO(arrayList));
        LineDataSet lineDataSet = new LineDataSet(null, "");
        Context context4 = this.mContext;
        if (context4 == null) {
            IIX0o.XOxIOxOx("mContext");
            context4 = null;
        }
        lineDataSet.OX(ContextCompat.getColor(context4, R.color.hr_color));
        Context context5 = this.mContext;
        if (context5 == null) {
            IIX0o.XOxIOxOx("mContext");
            context5 = null;
        }
        lineDataSet.X0ooXIooI(ContextCompat.getColor(context5, R.color.hr_color));
        lineDataSet.oXxx000(2.0f);
        lineDataSet.xIXIOX(1.0f);
        Context context6 = this.mContext;
        if (context6 == null) {
            IIX0o.XOxIOxOx("mContext");
            context6 = null;
        }
        lineDataSet.xIx0XO(ContextCompat.getDrawable(context6, R.drawable.shape_hr));
        lineDataSet.X0IOOI(false);
        lineDataSet.ooOOo0oXI(false);
        lineDataSet.xox(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet.oI(true);
        o0xxxXXxX.ooOOo0oXI ooooo0oxi = new o0xxxXXxX.ooOOo0oXI(lineDataSet);
        ooooo0oxi.oo0xXOI0I(false);
        LineChart lineChart9 = this.lineChart;
        if (lineChart9 == null) {
            IIX0o.XOxIOxOx("lineChart");
        } else {
            lineChart2 = lineChart9;
        }
        lineChart2.setData(ooooo0oxi);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public boolean getInitEvent() {
        return this.initEvent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void initChart(@OXOo.OOXIXo List<HeartRate> list) {
        IIX0o.x0xO0oo(list, "list");
        this.filterData.clear();
        long[] jArr = this.range;
        LineChart lineChart = null;
        if (jArr == null) {
            IIX0o.XOxIOxOx("range");
            jArr = null;
        }
        long j = jArr[0];
        long[] jArr2 = this.range;
        if (jArr2 == null) {
            IIX0o.XOxIOxOx("range");
            jArr2 = null;
        }
        long oxoX2 = xx0o0O.x0XOIxOo.oxoX(j, jArr2[1], 60000L);
        if (j <= oxoX2) {
            while (true) {
                this.filterData.put(Long.valueOf(j), new HRMinuteData(0, 0));
                if (j == oxoX2) {
                    break;
                } else {
                    j += 60000;
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (HeartRate heartRate : list) {
            Iterator<Map.Entry<Long, HRMinuteData>> it = this.filterData.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<Long, HRMinuteData> next = it.next();
                    long longValue = next.getKey().longValue();
                    HRMinuteData value = next.getValue();
                    if (heartRate.getMTime() < longValue) {
                        value.setTotal(value.getTotal() + heartRate.getMBpm());
                        value.setNum(value.getNum() + 1);
                        break;
                    }
                }
            }
        }
        Iterator<Map.Entry<Long, HRMinuteData>> it2 = this.filterData.entrySet().iterator();
        float f = 0.0f;
        while (it2.hasNext()) {
            HRMinuteData value2 = it2.next().getValue();
            if (value2.getNum() != 0 && value2.getTotal() != 0) {
                arrayList.add(new Entry(f, value2.getTotal() / value2.getNum()));
            }
            f += 1.0f;
        }
        LineChart lineChart2 = this.lineChart;
        if (lineChart2 == null) {
            IIX0o.XOxIOxOx("lineChart");
            lineChart2 = null;
        }
        Object obj = ((o0xxxXXxX.ooOOo0oXI) lineChart2.getData()).Oo().get(0);
        IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type com.github.mikephil.charting.data.LineDataSet");
        List<T> xX2 = ((LineDataSet) obj).xX();
        xX2.clear();
        xX2.addAll(arrayList);
        LineChart lineChart3 = this.lineChart;
        if (lineChart3 == null) {
            IIX0o.XOxIOxOx("lineChart");
        } else {
            lineChart = lineChart3;
        }
        lineChart.invalidate();
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        DINCondBold dINCondBold = null;
        long[] jArr = null;
        long[] OxI2 = com.sma.smartv3.util.xoIox.OxI(null, TimePeriod.DAY, 0, 5, null);
        this.range = OxI2;
        HeartRateDao heartRateDao = this.mHeartRateDao;
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
        List<HeartRate> heartRates = heartRateDao.getHeartRates(j, jArr2[1]);
        if (heartRates.isEmpty()) {
            DINCondBold dINCondBold2 = this.tvTime;
            if (dINCondBold2 == null) {
                IIX0o.XOxIOxOx("tvTime");
                dINCondBold2 = null;
            }
            dINCondBold2.setText(R.string.data_none);
            DINCondBold dINCondBold3 = this.tvBpm;
            if (dINCondBold3 == null) {
                IIX0o.XOxIOxOx("tvBpm");
                dINCondBold3 = null;
            }
            dINCondBold3.setText(R.string.data_none);
            LineChart lineChart = this.lineChart;
            if (lineChart == null) {
                IIX0o.XOxIOxOx("lineChart");
                lineChart = null;
            }
            lineChart.setVisibility(8);
            DINCondBold dINCondBold4 = this.noData;
            if (dINCondBold4 == null) {
                IIX0o.XOxIOxOx("noData");
                dINCondBold4 = null;
            }
            dINCondBold4.setVisibility(0);
            if (ProjectManager.f19822oIX0oI.xX0IIXIx0()) {
                LineChart lineChart2 = this.lineChart;
                if (lineChart2 == null) {
                    IIX0o.XOxIOxOx("lineChart");
                    lineChart2 = null;
                }
                lineChart2.getXAxis().I0oOIX(false);
                LineChart lineChart3 = this.lineChart;
                if (lineChart3 == null) {
                    IIX0o.XOxIOxOx("lineChart");
                    lineChart3 = null;
                }
                lineChart3.setVisibility(0);
                DINCondBold dINCondBold5 = this.noData;
                if (dINCondBold5 == null) {
                    IIX0o.XOxIOxOx("noData");
                    dINCondBold5 = null;
                }
                dINCondBold5.setVisibility(8);
                HeartRateDao heartRateDao2 = this.mHeartRateDao;
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
                initChart(heartRateDao2.getTestHeartRates(j2, jArr[1]));
                return;
            }
            return;
        }
        LineChart lineChart4 = this.lineChart;
        if (lineChart4 == null) {
            IIX0o.XOxIOxOx("lineChart");
            lineChart4 = null;
        }
        lineChart4.getXAxis().I0oOIX(true);
        LineChart lineChart5 = this.lineChart;
        if (lineChart5 == null) {
            IIX0o.XOxIOxOx("lineChart");
            lineChart5 = null;
        }
        lineChart5.setVisibility(0);
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
        dINCondBold7.setText(com.sma.smartv3.util.xoIox.oxxXoxO(false, false, 3, null).format(new Date(((HeartRate) CollectionsKt___CollectionsKt.O0O0Io00X(heartRates)).getMTime())));
        DINCondBold dINCondBold8 = this.tvBpm;
        if (dINCondBold8 == null) {
            IIX0o.XOxIOxOx("tvBpm");
        } else {
            dINCondBold = dINCondBold8;
        }
        dINCondBold.setText(String.valueOf(((HeartRate) CollectionsKt___CollectionsKt.O0O0Io00X(heartRates)).getMBpm()));
        initChart(heartRates);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.status_item_heart_rate;
    }

    @XO0.XO(tag = x0xO0oo.f24567II0xO0)
    public final void onHeartRateChanged(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onHeartRateChanged");
        initView();
    }
}
