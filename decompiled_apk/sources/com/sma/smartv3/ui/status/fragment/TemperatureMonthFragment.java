package com.sma.smartv3.ui.status.fragment;

import android.view.MotionEvent;
import androidx.core.content.ContextCompat;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.TemperatureDao;
import com.sma.smartv3.db.entity.Temperature;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.TemperatureDataParse;
import com.sma.smartv3.model.TemperatureDayData;
import com.sma.smartv3.ui.status.base.StatusBaseMonthFragment;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.view.CustomBarChartView;
import com.sma.smartv3.view.text.PFMedium;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nTemperatureMonthFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemperatureMonthFragment.kt\ncom/sma/smartv3/ui/status/fragment/TemperatureMonthFragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,133:1\n19#2:134\n15#2:135\n*S KotlinDebug\n*F\n+ 1 TemperatureMonthFragment.kt\ncom/sma/smartv3/ui/status/fragment/TemperatureMonthFragment\n*L\n29#1:134\n29#1:135\n*E\n"})
/* loaded from: classes12.dex */
public final class TemperatureMonthFragment extends StatusBaseMonthFragment<Temperature> {
    private boolean isImperial;

    @OXOo.OOXIXo
    private final AppUser mAppUser;

    @OXOo.OOXIXo
    private final TemperatureDao mTemperatureDao = MyDb.INSTANCE.getMDatabase().temperatureDao();

    @OXOo.OOXIXo
    private final List<TemperatureDayData> temperatureDayDataList = new ArrayList();

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements CustomBarChartView.oIX0oI {
        public oIX0oI() {
        }

        @Override // com.sma.smartv3.view.CustomBarChartView.oIX0oI
        public void oIX0oI(@OXOo.OOXIXo MotionEvent motionEvent) {
            IIX0o.x0xO0oo(motionEvent, "motionEvent");
            if (motionEvent.getAction() == 1) {
                TemperatureMonthFragment.this.getScrollView().requestDisallowInterceptTouchEvent(false);
            } else {
                TemperatureMonthFragment.this.getScrollView().requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    public TemperatureMonthFragment() {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.mAppUser = (AppUser) (fromJson != null ? fromJson : appUser);
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    public void filterData(@OXOo.OOXIXo List<? extends Temperature> data) {
        float f;
        IIX0o.x0xO0oo(data, "data");
        super.filterData(data);
        getBarChart().oX();
        LogUtils.d(data);
        TemperatureDataParse.INSTANCE.filterDayData(this.isImperial, data, getMonthData(), this.temperatureDayDataList, getValues());
        if (!data.isEmpty()) {
            if (this.isImperial) {
                f = 96.0f;
            } else {
                f = 36.0f;
            }
            getBarChart().IoIOOxIIo(0.0f, 10.0f, 0.0f, f);
            getBarChart().OX00O0xII(0.0f, f + 0.5f, YAxis.AxisDependency.LEFT, 500L);
        }
        updateChartData(getValues());
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment, com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        int i;
        boolean z = true;
        if (TextConvertKt.XI0IXoo(this.mAppUser.getUnit()) != 1) {
            z = false;
        }
        this.isImperial = z;
        setAxisMinimum(20.0f);
        super.initView();
        getOneLl().setVisibility(8);
        getImage().setImageResource(R.drawable.icon_temperature);
        PFMedium valueUnit = getValueUnit();
        boolean z2 = this.isImperial;
        int i2 = R.string.degree_centigrade;
        if (z2) {
            i = R.string.fahrenheit;
        } else {
            i = R.string.degree_centigrade;
        }
        valueUnit.setText(i);
        getNowValue().setText(HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
        getTwoTV().setText(R.string.ave_temp);
        PFMedium twoUnit = getTwoUnit();
        if (this.isImperial) {
            i2 = R.string.fahrenheit;
        }
        twoUnit.setText(i2);
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    public void onDataChange(@OXOo.OOXIXo List<Temperature> data) {
        IIX0o.x0xO0oo(data, "data");
        filterData(data);
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    @OXOo.OOXIXo
    public List<Temperature> onTimePeriodChange(@OXOo.OOXIXo Calendar calendar, int i, @OXOo.OOXIXo TimePeriod timePeriod) {
        IIX0o.x0xO0oo(calendar, "calendar");
        IIX0o.x0xO0oo(timePeriod, "timePeriod");
        long[] o002 = com.sma.smartv3.util.xoIox.o00(calendar, timePeriod, i);
        LogUtils.d(o002);
        setMonthDays(com.sma.smartv3.util.xoIox.Oo(o002[0]));
        clearCache(o002[0]);
        return this.mTemperatureDao.getListDesc(o002[0], o002[1]);
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    public void setChartRenderer() {
        getBarChart().setScaleEnabled(true);
        getBarChart().getAxisRight().OO(0.5f);
        getBarChart().setOnChartTouchListener(new oIX0oI());
        xxx00.II0xO0 iI0xO0 = new xxx00.II0xO0(getBarChart(), getBarChart().getAnimator(), getBarChart().getViewPortHandler());
        iI0xO0.X0IIOO(oIxOXo.oxoX.I0Io(getMActivity(), R.color.line_color));
        iI0xO0.O0xOxO(new int[]{ContextCompat.getColor(getMActivity(), R.color.temp_day_item_center_7), ContextCompat.getColor(getMActivity(), R.color.temp_day_item_center_8)});
        iI0xO0.oI0IIXIo(1);
        getBarChart().setRenderer(iI0xO0);
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    public void setColor(@OXOo.OOXIXo o0xxxXXxX.II0xO0 value) {
        IIX0o.x0xO0oo(value, "value");
        value.o0IXXIx(CollectionsKt__CollectionsKt.X00IoxXI(0, Integer.valueOf(ContextCompat.getColor(getMActivity(), R.color.colorAccent))));
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    @OXOo.OOXIXo
    public String setDataLabel() {
        return "temp month Data";
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    public void updateItemData(@OXOo.OOXIXo Entry e) {
        IIX0o.x0xO0oo(e, "e");
        TemperatureDayData temperatureDayData = this.temperatureDayDataList.get((int) e.xxIXOIIO());
        getNowValue().setText(UtilsKt.xxIXOIIO(temperatureDayData.getMin(), temperatureDayData.getMax()));
        getTwoValue().setText(UtilsKt.II0XooXoX(temperatureDayData.getAvg()));
    }
}
