package com.sma.smartv3.ui.status.item;

import android.content.Context;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.gson.Gson;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.WeightDao;
import com.sma.smartv3.db.entity.Weight;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFRegular;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nWeightItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WeightItem.kt\ncom/sma/smartv3/ui/status/item/WeightItem\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,193:1\n19#2:194\n15#2:195\n1477#3:196\n1502#3,3:197\n1505#3,3:207\n372#4,7:200\n215#5,2:210\n*S KotlinDebug\n*F\n+ 1 WeightItem.kt\ncom/sma/smartv3/ui/status/item/WeightItem\n*L\n112#1:194\n112#1:195\n126#1:196\n126#1:197,3\n126#1:207,3\n126#1:200,7\n126#1:210,2\n*E\n"})
/* loaded from: classes12.dex */
public final class WeightItem extends BaseDslItem {
    private PFRegular bmiValue;
    private boolean isImperial;
    private LineChart lineChart;
    private Context mContext;
    private DINCondBold noData;
    private DINCondBold weightLastTime;
    private DINCondBold weightLastValue;
    private PFRegular weightUnit;

    @OXOo.OOXIXo
    private final List<Entry> entries = new ArrayList();

    @OXOo.OOXIXo
    private final WeightDao mWeightDao = MyDb.INSTANCE.getMDatabase().weightDao();
    private final boolean initEvent = true;

    /* JADX WARN: Multi-variable type inference failed */
    private final void initChart(List<Weight> list) {
        this.entries.clear();
        Iterator<Weight> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            this.entries.add(new Entry(i, it.next().getMWeight()));
            i++;
        }
        setXAxis(list);
        LineChart lineChart = this.lineChart;
        LineChart lineChart2 = null;
        if (lineChart == null) {
            IIX0o.XOxIOxOx("lineChart");
            lineChart = null;
        }
        T OOXIXo2 = ((o0xxxXXxX.ooOOo0oXI) lineChart.getData()).OOXIXo(0);
        IIX0o.x0XOIxOo(OOXIXo2, "null cannot be cast to non-null type com.github.mikephil.charting.data.LineDataSet");
        ((LineDataSet) OOXIXo2).oX0ooo0I0(this.entries);
        LineChart lineChart3 = this.lineChart;
        if (lineChart3 == null) {
            IIX0o.XOxIOxOx("lineChart");
            lineChart3 = null;
        }
        ((o0xxxXXxX.ooOOo0oXI) lineChart3.getData()).XxX0x0xxx();
        LineChart lineChart4 = this.lineChart;
        if (lineChart4 == null) {
            IIX0o.XOxIOxOx("lineChart");
        } else {
            lineChart2 = lineChart4;
        }
        lineChart2.invalidate();
    }

    private final void setXAxis(List<Weight> list) {
        LineChart lineChart = this.lineChart;
        if (lineChart == null) {
            IIX0o.XOxIOxOx("lineChart");
            lineChart = null;
        }
        XAxis xAxis = lineChart.getXAxis();
        IIX0o.x0XOIxOo(xAxis, "null cannot be cast to non-null type com.github.mikephil.charting.components.XAxis");
        SimpleDateFormat xI2 = com.sma.smartv3.util.xoIox.xI();
        ArrayList arrayList = new ArrayList();
        Iterator<Weight> it = list.iterator();
        while (it.hasNext()) {
            String millis2String = TimeUtils.millis2String(it.next().getMTime(), xI2);
            IIX0o.oO(millis2String, "millis2String(...)");
            arrayList.add(millis2String);
        }
        xAxis.o0xxxXXxX(new ox.oOoXoXO(arrayList));
        xAxis.I0X0x0oIo(0.0f);
        xAxis.OO(1.0f);
        xAxis.xXOx(list.size());
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OXOo.OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.weightChart);
        IIX0o.ooOOo0oXI(v);
        this.lineChart = (LineChart) v;
        View v2 = itemHolder.v(R.id.weightLastTime);
        IIX0o.ooOOo0oXI(v2);
        this.weightLastTime = (DINCondBold) v2;
        View v3 = itemHolder.v(R.id.weightLastValue);
        IIX0o.ooOOo0oXI(v3);
        this.weightLastValue = (DINCondBold) v3;
        View v4 = itemHolder.v(R.id.weightUnit);
        IIX0o.ooOOo0oXI(v4);
        this.weightUnit = (PFRegular) v4;
        View v5 = itemHolder.v(R.id.bmi);
        IIX0o.ooOOo0oXI(v5);
        this.bmiValue = (PFRegular) v5;
        View v6 = itemHolder.v(R.id.noData);
        IIX0o.ooOOo0oXI(v6);
        this.noData = (DINCondBold) v6;
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
        XAxis xAxis = lineChart6.getXAxis();
        IIX0o.oO(xAxis, "getXAxis(...)");
        LineChart lineChart7 = this.lineChart;
        if (lineChart7 == null) {
            IIX0o.XOxIOxOx("lineChart");
            lineChart7 = null;
        }
        Context context2 = lineChart7.getContext();
        IIX0o.oO(context2, "getContext(...)");
        oix0oi.X0o0xo(xAxis, true, context2);
        LineChart lineChart8 = this.lineChart;
        if (lineChart8 == null) {
            IIX0o.XOxIOxOx("lineChart");
            lineChart8 = null;
        }
        lineChart8.setTouchEnabled(false);
        lineChart8.getDescription().Oxx0IOOO(false);
        lineChart8.getLegend().Oxx0IOOO(false);
        YAxis axisLeft2 = lineChart8.getAxisLeft();
        Context context3 = this.mContext;
        if (context3 == null) {
            IIX0o.XOxIOxOx("mContext");
            context3 = null;
        }
        axisLeft2.ooOOo0oXI(oix0oi.I0Io(context3));
        LineDataSet lineDataSet = new LineDataSet(this.entries, "Weight item Data");
        Context context4 = this.mContext;
        if (context4 == null) {
            IIX0o.XOxIOxOx("mContext");
            context4 = null;
        }
        lineDataSet.OX(ContextCompat.getColor(context4, R.color.weight_show_1));
        Context context5 = this.mContext;
        if (context5 == null) {
            IIX0o.XOxIOxOx("mContext");
            context5 = null;
        }
        lineDataSet.X0ooXIooI(ContextCompat.getColor(context5, R.color.weight_show_1));
        lineDataSet.oXxx000(1.5f);
        lineDataSet.xIXIOX(3.5f);
        lineDataSet.XOxoX(2.0f);
        lineDataSet.xox(LineDataSet.Mode.CUBIC_BEZIER);
        Context context6 = this.mContext;
        if (context6 == null) {
            IIX0o.XOxIOxOx("mContext");
            context6 = null;
        }
        lineDataSet.x0oxIIIX(ContextCompat.getColor(context6, R.color.weight_show_0));
        lineDataSet.X0IOOI(true);
        lineDataSet.ooOOo0oXI(false);
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

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        boolean z;
        float mWeight;
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        AppUser appUser2 = (AppUser) appUser;
        if (appUser2.getUnit() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isImperial = z;
        Calendar calendar = Calendar.getInstance();
        IIX0o.ooOOo0oXI(calendar);
        oOXoIIIo.II0xO0.OxxIIOOXO(calendar, 0);
        oOXoIIIo.II0xO0.O0xOxO(calendar, 0);
        oOXoIIIo.II0xO0.IIXOooo(calendar, 0);
        oOXoIIIo.II0xO0.oI0IIXIo(calendar, 0);
        calendar.setMinimalDaysInFirstWeek(7);
        oOXoIIIo.II0xO0.Oxx0xo(calendar, calendar.getFirstDayOfWeek());
        IIX0o.oO(calendar, "apply(...)");
        long[] o002 = com.sma.smartv3.util.xoIox.o00(calendar, TimePeriod.WEEK, 0);
        List<Weight> weightsASC = this.mWeightDao.getWeightsASC(o002[0], o002[1]);
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : weightsASC) {
            String format = com.sma.smartv3.util.xoIox.xoIxX().format(Long.valueOf(((Weight) obj).getMTime()));
            Object obj2 = linkedHashMap.get(format);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(format, obj2);
            }
            ((List) obj2).add(obj);
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.addAll(CollectionsKt___CollectionsKt.oxXIOXO((List) ((Map.Entry) it.next()).getValue(), 1));
        }
        PFRegular pFRegular = null;
        if (arrayList.isEmpty()) {
            DINCondBold dINCondBold = this.weightLastTime;
            if (dINCondBold == null) {
                IIX0o.XOxIOxOx("weightLastTime");
                dINCondBold = null;
            }
            dINCondBold.setText(R.string.data_none);
            DINCondBold dINCondBold2 = this.weightLastValue;
            if (dINCondBold2 == null) {
                IIX0o.XOxIOxOx("weightLastValue");
                dINCondBold2 = null;
            }
            dINCondBold2.setText(R.string.data_none);
            PFRegular pFRegular2 = this.bmiValue;
            if (pFRegular2 == null) {
                IIX0o.XOxIOxOx("bmiValue");
                pFRegular2 = null;
            }
            pFRegular2.setText(R.string.data_none);
            LineChart lineChart = this.lineChart;
            if (lineChart == null) {
                IIX0o.XOxIOxOx("lineChart");
                lineChart = null;
            }
            lineChart.setVisibility(8);
            DINCondBold dINCondBold3 = this.noData;
            if (dINCondBold3 == null) {
                IIX0o.XOxIOxOx("noData");
                dINCondBold3 = null;
            }
            dINCondBold3.setVisibility(0);
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
                DINCondBold dINCondBold4 = this.noData;
                if (dINCondBold4 == null) {
                    IIX0o.XOxIOxOx("noData");
                    dINCondBold4 = null;
                }
                dINCondBold4.setVisibility(8);
                initChart(this.mWeightDao.getTestWeights(o002[0], o002[1]));
            }
        } else {
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
            DINCondBold dINCondBold5 = this.noData;
            if (dINCondBold5 == null) {
                IIX0o.XOxIOxOx("noData");
                dINCondBold5 = null;
            }
            dINCondBold5.setVisibility(8);
            Weight weight = (Weight) CollectionsKt___CollectionsKt.O0O0Io00X(arrayList);
            if (IIX0o.Oxx0IOOO(TimeUtils.millis2String(weight.getMTime(), com.sma.smartv3.util.xoIox.I0Io()), weight.getMLocalTime())) {
                DINCondBold dINCondBold6 = this.weightLastTime;
                if (dINCondBold6 == null) {
                    IIX0o.XOxIOxOx("weightLastTime");
                    dINCondBold6 = null;
                }
                dINCondBold6.setText(TimeUtils.millis2String(weight.getMTime(), com.sma.smartv3.util.xoIox.oo0xXOI0I()));
            } else {
                DINCondBold dINCondBold7 = this.weightLastTime;
                if (dINCondBold7 == null) {
                    IIX0o.XOxIOxOx("weightLastTime");
                    dINCondBold7 = null;
                }
                dINCondBold7.setText(com.sma.smartv3.util.xoIox.oxxXoxO(false, false, 3, null).format(new Date(TimeUtils.string2Millis(weight.getMLocalTime(), "yyyy/MM/dd HH:mm:ss"))));
            }
            DINCondBold dINCondBold8 = this.weightLastValue;
            if (dINCondBold8 == null) {
                IIX0o.XOxIOxOx("weightLastValue");
                dINCondBold8 = null;
            }
            if (this.isImperial) {
                mWeight = Xx000oIo.XO.I0Io(weight.getMWeight());
            } else {
                mWeight = weight.getMWeight();
            }
            dINCondBold8.setText(TextConvertKt.oo0xXOI0I(mWeight, true));
            PFRegular pFRegular3 = this.bmiValue;
            if (pFRegular3 == null) {
                IIX0o.XOxIOxOx("bmiValue");
                pFRegular3 = null;
            }
            pFRegular3.setText(TextConvertKt.Oxx0IOOO(weight.getMWeight(), appUser2.getHeight()));
            initChart(arrayList);
        }
        PFRegular pFRegular4 = this.weightUnit;
        if (pFRegular4 == null) {
            IIX0o.XOxIOxOx("weightUnit");
        } else {
            pFRegular = pFRegular4;
        }
        pFRegular.setText(TextConvertKt.xxX(appUser2.getUnit()));
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.status_item_weight;
    }

    @XO0.XO(tag = x0xO0oo.f24612XO)
    public final void onWeightChanged(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onWeightChanged");
        initView();
    }
}
