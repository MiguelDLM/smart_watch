package com.sma.smartv3.ui.status.item;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.Utils;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.SleepDao;
import com.sma.smartv3.db.entity.Sleep;
import com.sma.smartv3.model.SleepAllDayData;
import com.sma.smartv3.model.SleepAllDayDataParse;
import com.sma.smartv3.model.SleepDataParse;
import com.sma.smartv3.model.SleepDayData;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.text.DINCondBold;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleSleepQuality;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class SleepItem extends BaseDslItem {
    private BarChart barChart;
    private SimpleDateFormat format;
    private Context mContext;
    private DINCondBold noData;
    private RelativeLayout sleepBarChartRl;
    private TextView sleepEndTime;
    private DINCondBold sleepHour;
    private DINCondBold sleepMinute;
    private TextView sleepStartTime;
    private DINCondBold sleepTime;

    @OXOo.OOXIXo
    private List<BarEntry> values = new ArrayList();
    private final int block = 3;
    private final float blockHeight = 300.0f / 3;

    @OXOo.OOXIXo
    private final SleepDao mSleepDao = MyDb.INSTANCE.getMDatabase().sleepDao();
    private final boolean initEvent = true;

    private final void noData() {
        DINCondBold dINCondBold = this.sleepTime;
        DINCondBold dINCondBold2 = null;
        if (dINCondBold == null) {
            IIX0o.XOxIOxOx("sleepTime");
            dINCondBold = null;
        }
        dINCondBold.setText(R.string.data_none);
        DINCondBold dINCondBold3 = this.sleepHour;
        if (dINCondBold3 == null) {
            IIX0o.XOxIOxOx("sleepHour");
            dINCondBold3 = null;
        }
        dINCondBold3.setText(R.string.data_none);
        DINCondBold dINCondBold4 = this.sleepMinute;
        if (dINCondBold4 == null) {
            IIX0o.XOxIOxOx("sleepMinute");
            dINCondBold4 = null;
        }
        dINCondBold4.setText(R.string.data_none);
        RelativeLayout relativeLayout = this.sleepBarChartRl;
        if (relativeLayout == null) {
            IIX0o.XOxIOxOx("sleepBarChartRl");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(8);
        DINCondBold dINCondBold5 = this.noData;
        if (dINCondBold5 == null) {
            IIX0o.XOxIOxOx("noData");
        } else {
            dINCondBold2 = dINCondBold5;
        }
        dINCondBold2.setVisibility(0);
    }

    private final void setXAxis(int i, int i2) {
        BarChart barChart = this.barChart;
        SimpleDateFormat simpleDateFormat = null;
        TextView textView = null;
        if (barChart == null) {
            IIX0o.XOxIOxOx("barChart");
            barChart = null;
        }
        XAxis xAxis = barChart.getXAxis();
        IIX0o.x0XOIxOo(xAxis, "null cannot be cast to non-null type com.github.mikephil.charting.components.XAxis");
        ArrayList arrayList = new ArrayList();
        if (i2 >= 0) {
            int i3 = 0;
            while (true) {
                arrayList.add("");
                if (i3 == i2) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        if (i2 == 0) {
            TextView textView2 = this.sleepStartTime;
            if (textView2 == null) {
                IIX0o.XOxIOxOx("sleepStartTime");
                textView2 = null;
            }
            textView2.setText("");
            TextView textView3 = this.sleepEndTime;
            if (textView3 == null) {
                IIX0o.XOxIOxOx("sleepEndTime");
            } else {
                textView = textView3;
            }
            textView.setText("");
        } else {
            TextView textView4 = this.sleepStartTime;
            if (textView4 == null) {
                IIX0o.XOxIOxOx("sleepStartTime");
                textView4 = null;
            }
            long j = i * 1000;
            SimpleDateFormat simpleDateFormat2 = this.format;
            if (simpleDateFormat2 == null) {
                IIX0o.XOxIOxOx("format");
                simpleDateFormat2 = null;
            }
            textView4.setText(TimeUtils.millis2String(j, simpleDateFormat2));
            TextView textView5 = this.sleepEndTime;
            if (textView5 == null) {
                IIX0o.XOxIOxOx("sleepEndTime");
                textView5 = null;
            }
            long j2 = (i + (i2 * 60)) * 1000;
            SimpleDateFormat simpleDateFormat3 = this.format;
            if (simpleDateFormat3 == null) {
                IIX0o.XOxIOxOx("format");
            } else {
                simpleDateFormat = simpleDateFormat3;
            }
            textView5.setText(TimeUtils.millis2String(j2, simpleDateFormat));
        }
        xAxis.o0xxxXXxX(new ox.oOoXoXO(arrayList));
    }

    private final void showSleep() {
        TextView textView = null;
        long[] OxI2 = com.sma.smartv3.util.xoIox.OxI(null, TimePeriod.DAY, 0, 5, null);
        SleepDao sleepDao = this.mSleepDao;
        long j = OxI2[0];
        long j2 = com.sma.smartv3.util.xoIox.f24684IO;
        List<Sleep> sleeps = sleepDao.getSleeps(j - j2, OxI2[1] - j2);
        BleSleepQuality bleSleepQuality = new BleSleepQuality(0, 0, 0, 7, null);
        if (sleeps.isEmpty()) {
            noData();
            if (ProjectManager.f19822oIX0oI.xX0IIXIx0()) {
                RelativeLayout relativeLayout = this.sleepBarChartRl;
                if (relativeLayout == null) {
                    IIX0o.XOxIOxOx("sleepBarChartRl");
                    relativeLayout = null;
                }
                relativeLayout.setVisibility(0);
                DINCondBold dINCondBold = this.noData;
                if (dINCondBold == null) {
                    IIX0o.XOxIOxOx("noData");
                    dINCondBold = null;
                }
                dINCondBold.setVisibility(8);
                List<Sleep> testSleeps = this.mSleepDao.getTestSleeps(OxI2[0] - j2, OxI2[1] - j2);
                this.values.clear();
                SleepDayData filterData = SleepDataParse.INSTANCE.filterData(testSleeps, this.blockHeight, this.values);
                setXAxis(filterData.getStartTime(), filterData.getTotal());
                updateData(this.values);
                TextView textView2 = this.sleepStartTime;
                if (textView2 == null) {
                    IIX0o.XOxIOxOx("sleepStartTime");
                    textView2 = null;
                }
                textView2.setText("");
                TextView textView3 = this.sleepEndTime;
                if (textView3 == null) {
                    IIX0o.XOxIOxOx("sleepEndTime");
                } else {
                    textView = textView3;
                }
                textView.setText("");
            }
        } else {
            RelativeLayout relativeLayout2 = this.sleepBarChartRl;
            if (relativeLayout2 == null) {
                IIX0o.XOxIOxOx("sleepBarChartRl");
                relativeLayout2 = null;
            }
            relativeLayout2.setVisibility(0);
            DINCondBold dINCondBold2 = this.noData;
            if (dINCondBold2 == null) {
                IIX0o.XOxIOxOx("noData");
                dINCondBold2 = null;
            }
            dINCondBold2.setVisibility(8);
            this.values.clear();
            SleepDayData filterData2 = SleepDataParse.INSTANCE.filterData(sleeps, this.blockHeight, this.values);
            if ((filterData2.getTotal() != 0 && filterData2.getTotal() < 60) || this.values.isEmpty()) {
                noData();
            } else {
                setXAxis(filterData2.getStartTime(), filterData2.getTotal());
                updateData(this.values);
                int total = filterData2.getTotal() / 60;
                DINCondBold dINCondBold3 = this.sleepHour;
                if (dINCondBold3 == null) {
                    IIX0o.XOxIOxOx("sleepHour");
                    dINCondBold3 = null;
                }
                dINCondBold3.setText(String.valueOf(total));
                DINCondBold dINCondBold4 = this.sleepMinute;
                if (dINCondBold4 == null) {
                    IIX0o.XOxIOxOx("sleepMinute");
                    dINCondBold4 = null;
                }
                dINCondBold4.setText(String.valueOf(filterData2.getTotal() - (total * 60)));
                DINCondBold dINCondBold5 = this.sleepTime;
                if (dINCondBold5 == null) {
                    IIX0o.XOxIOxOx("sleepTime");
                } else {
                    textView = dINCondBold5;
                }
                textView.setText(TimeUtils.millis2String(filterData2.getStartTime() * 1000, com.sma.smartv3.util.xoIox.oo0xXOI0I()));
                if (ProductManager.f20544oIX0oI.XIXIxO()) {
                    SparseIntArray status = filterData2.getStatus();
                    bleSleepQuality.setMLight(status.get(2));
                    bleSleepQuality.setMDeep(status.get(1));
                    bleSleepQuality.setMTotal(filterData2.getTotal());
                }
            }
        }
        if (ProductManager.f20544oIX0oI.XIXIxO()) {
            BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.SLEEP_QUALITY, BleKeyFlag.UPDATE, bleSleepQuality, false, false, 24, null);
        }
    }

    private final void showSleepAllDay() {
        SimpleDateFormat simpleDateFormat = null;
        TextView textView = null;
        int i = 0;
        long[] OxI2 = com.sma.smartv3.util.xoIox.OxI(null, TimePeriod.DAY, 0, 5, null);
        SleepDao sleepDao = this.mSleepDao;
        long j = OxI2[0];
        long j2 = com.sma.smartv3.util.xoIox.f24684IO;
        List<Sleep> sleeps = sleepDao.getSleeps(j - j2, OxI2[1]);
        if (sleeps.isEmpty()) {
            noData();
            if (ProjectManager.f19822oIX0oI.xX0IIXIx0()) {
                RelativeLayout relativeLayout = this.sleepBarChartRl;
                if (relativeLayout == null) {
                    IIX0o.XOxIOxOx("sleepBarChartRl");
                    relativeLayout = null;
                }
                relativeLayout.setVisibility(0);
                DINCondBold dINCondBold = this.noData;
                if (dINCondBold == null) {
                    IIX0o.XOxIOxOx("noData");
                    dINCondBold = null;
                }
                dINCondBold.setVisibility(8);
                List<Sleep> testSleeps = this.mSleepDao.getTestSleeps(OxI2[0] - j2, OxI2[1]);
                this.values.clear();
                SleepAllDayData filterData = SleepAllDayDataParse.INSTANCE.filterData(testSleeps, 300.0f, this.values, OxI2[0]);
                setXAxis(filterData.getStartTime(), filterData.getTotal());
                updateData(this.values);
                TextView textView2 = this.sleepStartTime;
                if (textView2 == null) {
                    IIX0o.XOxIOxOx("sleepStartTime");
                    textView2 = null;
                }
                textView2.setText("");
                TextView textView3 = this.sleepEndTime;
                if (textView3 == null) {
                    IIX0o.XOxIOxOx("sleepEndTime");
                } else {
                    textView = textView3;
                }
                textView.setText("");
                return;
            }
            return;
        }
        RelativeLayout relativeLayout2 = this.sleepBarChartRl;
        if (relativeLayout2 == null) {
            IIX0o.XOxIOxOx("sleepBarChartRl");
            relativeLayout2 = null;
        }
        relativeLayout2.setVisibility(0);
        DINCondBold dINCondBold2 = this.noData;
        if (dINCondBold2 == null) {
            IIX0o.XOxIOxOx("noData");
            dINCondBold2 = null;
        }
        dINCondBold2.setVisibility(8);
        this.values.clear();
        SleepAllDayData filterData2 = SleepAllDayDataParse.INSTANCE.filterData(sleeps, 300.0f, this.values, OxI2[0]);
        if (filterData2.getTotal() != 0 && !this.values.isEmpty()) {
            BarChart barChart = this.barChart;
            if (barChart == null) {
                IIX0o.XOxIOxOx("barChart");
                barChart = null;
            }
            XAxis xAxis = barChart.getXAxis();
            IIX0o.x0XOIxOo(xAxis, "null cannot be cast to non-null type com.github.mikephil.charting.components.XAxis");
            ArrayList arrayList = new ArrayList();
            int total = filterData2.getTotal();
            if (total >= 0) {
                while (true) {
                    arrayList.add("");
                    if (i == total) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            xAxis.o0xxxXXxX(new ox.oOoXoXO(arrayList));
            updateData(this.values);
            int total2 = filterData2.getTotal() / 60;
            DINCondBold dINCondBold3 = this.sleepHour;
            if (dINCondBold3 == null) {
                IIX0o.XOxIOxOx("sleepHour");
                dINCondBold3 = null;
            }
            dINCondBold3.setText(String.valueOf(total2));
            DINCondBold dINCondBold4 = this.sleepMinute;
            if (dINCondBold4 == null) {
                IIX0o.XOxIOxOx("sleepMinute");
                dINCondBold4 = null;
            }
            dINCondBold4.setText(String.valueOf(filterData2.getTotal() - (total2 * 60)));
            DINCondBold dINCondBold5 = this.sleepTime;
            if (dINCondBold5 == null) {
                IIX0o.XOxIOxOx("sleepTime");
                dINCondBold5 = null;
            }
            dINCondBold5.setText(TimeUtils.millis2String(filterData2.getStartTime() * 1000, com.sma.smartv3.util.xoIox.oo0xXOI0I()));
            TextView textView4 = this.sleepStartTime;
            if (textView4 == null) {
                IIX0o.XOxIOxOx("sleepStartTime");
                textView4 = null;
            }
            long startTime = filterData2.getStartTime() * 1000;
            SimpleDateFormat simpleDateFormat2 = this.format;
            if (simpleDateFormat2 == null) {
                IIX0o.XOxIOxOx("format");
                simpleDateFormat2 = null;
            }
            textView4.setText(TimeUtils.millis2String(startTime, simpleDateFormat2));
            TextView textView5 = this.sleepEndTime;
            if (textView5 == null) {
                IIX0o.XOxIOxOx("sleepEndTime");
                textView5 = null;
            }
            long endTime = filterData2.getEndTime() * 1000;
            SimpleDateFormat simpleDateFormat3 = this.format;
            if (simpleDateFormat3 == null) {
                IIX0o.XOxIOxOx("format");
            } else {
                simpleDateFormat = simpleDateFormat3;
            }
            textView5.setText(TimeUtils.millis2String(endTime, simpleDateFormat));
            return;
        }
        noData();
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
        o0xxxXXxX.II0xO0 iI0xO0 = new o0xxxXXxX.II0xO0(list, "SleepData");
        iI0xO0.OOxOI(0.0f);
        iI0xO0.xxxI(0.0f);
        o0xxxXXxX.oIX0oI oix0oi = new o0xxxXXxX.oIX0oI(iI0xO0);
        oix0oi.oo0xXOI0I(false);
        iI0xO0.o0IXXIx(CollectionsKt__CollectionsKt.X00IoxXI(0, Integer.valueOf(ContextCompat.getColor(Utils.getApp(), R.color.colorAccent))));
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
        View v = itemHolder.v(R.id.sleepBarChart);
        IIX0o.ooOOo0oXI(v);
        this.barChart = (BarChart) v;
        View v2 = itemHolder.v(R.id.sleepTime);
        IIX0o.ooOOo0oXI(v2);
        this.sleepTime = (DINCondBold) v2;
        View v3 = itemHolder.v(R.id.sleepHour);
        IIX0o.ooOOo0oXI(v3);
        this.sleepHour = (DINCondBold) v3;
        View v4 = itemHolder.v(R.id.sleepMinute);
        IIX0o.ooOOo0oXI(v4);
        this.sleepMinute = (DINCondBold) v4;
        View v5 = itemHolder.v(R.id.noData);
        IIX0o.ooOOo0oXI(v5);
        this.noData = (DINCondBold) v5;
        View v6 = itemHolder.v(R.id.sleepBarChartRl);
        IIX0o.ooOOo0oXI(v6);
        this.sleepBarChartRl = (RelativeLayout) v6;
        View v7 = itemHolder.v(R.id.sleepStartTime);
        IIX0o.ooOOo0oXI(v7);
        this.sleepStartTime = (TextView) v7;
        View v8 = itemHolder.v(R.id.sleepEndTime);
        IIX0o.ooOOo0oXI(v8);
        this.sleepEndTime = (TextView) v8;
        BarChart barChart = this.barChart;
        BarChart barChart2 = null;
        if (barChart == null) {
            IIX0o.XOxIOxOx("barChart");
            barChart = null;
        }
        Context context = barChart.getContext();
        IIX0o.oO(context, "getContext(...)");
        this.mContext = context;
        this.format = com.sma.smartv3.util.xoIox.O0Xx(false, 1, null);
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
        oix0oi.XO(axisLeft, axisRight, 300.0f, 0.0f);
        BarChart barChart6 = this.barChart;
        if (barChart6 == null) {
            IIX0o.XOxIOxOx("barChart");
            barChart6 = null;
        }
        barChart6.getDescription().Oxx0IOOO(false);
        barChart6.getLegend().Oxx0IOOO(false);
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
        IIX0o.x0XOIxOo(xAxis, "null cannot be cast to non-null type com.github.mikephil.charting.components.XAxis");
        Context context3 = this.mContext;
        if (context3 == null) {
            IIX0o.XOxIOxOx("mContext");
            context3 = null;
        }
        oix0oi.X0o0xo(xAxis, true, context3);
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
        iI0xO0.XI0IXoo(this.blockHeight);
        iI0xO0.OxI(this.block);
        Context context5 = this.mContext;
        if (context5 == null) {
            IIX0o.XOxIOxOx("mContext");
            context5 = null;
        }
        int color = ContextCompat.getColor(context5, R.color.sleep_show_5);
        Context context6 = this.mContext;
        if (context6 == null) {
            IIX0o.XOxIOxOx("mContext");
            context6 = null;
        }
        int color2 = ContextCompat.getColor(context6, R.color.sleep_show_6);
        Context context7 = this.mContext;
        if (context7 == null) {
            IIX0o.XOxIOxOx("mContext");
            context7 = null;
        }
        int color3 = ContextCompat.getColor(context7, R.color.sleep_show_3);
        Context context8 = this.mContext;
        if (context8 == null) {
            IIX0o.XOxIOxOx("mContext");
            context8 = null;
        }
        int color4 = ContextCompat.getColor(context8, R.color.sleep_show_4);
        Context context9 = this.mContext;
        if (context9 == null) {
            IIX0o.XOxIOxOx("mContext");
            context9 = null;
        }
        int color5 = ContextCompat.getColor(context9, R.color.sleep_show_1);
        Context context10 = this.mContext;
        if (context10 == null) {
            IIX0o.XOxIOxOx("mContext");
            context10 = null;
        }
        iI0xO0.O0xOxO(new int[]{color, color2, color3, color4, color5, ContextCompat.getColor(context10, R.color.sleep_show_2)});
        iI0xO0.oI0IIXIo(4);
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
        BarChart barChart = null;
        if (ProductManager.f20544oIX0oI.x0oxIIIX()) {
            BarChart barChart2 = this.barChart;
            if (barChart2 == null) {
                IIX0o.XOxIOxOx("barChart");
            } else {
                barChart = barChart2;
            }
            xX0IIXIx0.Oxx0IOOO renderer = barChart.getRenderer();
            IIX0o.x0XOIxOo(renderer, "null cannot be cast to non-null type com.sma.smartv3.view.chart.CustomInfoBarChartRender");
            xxx00.II0xO0 iI0xO0 = (xxx00.II0xO0) renderer;
            iI0xO0.XI0IXoo(300.0f);
            iI0xO0.OxI(1);
            iI0xO0.oI0IIXIo(6);
            iI0xO0.xxX(2.0f);
            showSleepAllDay();
            return;
        }
        BarChart barChart3 = this.barChart;
        if (barChart3 == null) {
            IIX0o.XOxIOxOx("barChart");
        } else {
            barChart = barChart3;
        }
        xX0IIXIx0.Oxx0IOOO renderer2 = barChart.getRenderer();
        IIX0o.x0XOIxOo(renderer2, "null cannot be cast to non-null type com.sma.smartv3.view.chart.CustomInfoBarChartRender");
        xxx00.II0xO0 iI0xO02 = (xxx00.II0xO0) renderer2;
        iI0xO02.XI0IXoo(this.blockHeight);
        iI0xO02.OxI(this.block);
        iI0xO02.oI0IIXIo(4);
        iI0xO02.xxX(1.0f);
        showSleep();
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.status_item_sleep;
    }

    @XO0.XO(tag = x0xO0oo.f24645oxoX)
    public final void onSleepChanged(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onSleepChanged");
        initView();
    }
}
