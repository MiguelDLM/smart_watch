package com.sma.smartv3.ui.status.fragment;

import android.content.Context;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.github.mikephil.charting.data.Entry;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.PressureDao;
import com.sma.smartv3.db.entity.Pressure;
import com.sma.smartv3.model.PressureDataKt;
import com.sma.smartv3.model.PressureDataParse;
import com.sma.smartv3.model.PressureDayData;
import com.sma.smartv3.ui.status.base.StatusBaseMonthFragment;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.view.segmentedbar.CircleThumbSegmentedBarView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class PressureMonthFragment extends StatusBaseMonthFragment<Pressure> {

    @OXOo.OOXIXo
    private final PressureDao mPressureDao = MyDb.INSTANCE.getMDatabase().pressureDao();

    @OXOo.OOXIXo
    private final List<PressureDayData> pressureDataList = new ArrayList();

    @OXOo.OOXIXo
    private final X0IIOO mSbv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CircleThumbSegmentedBarView>() { // from class: com.sma.smartv3.ui.status.fragment.PressureMonthFragment$mSbv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CircleThumbSegmentedBarView invoke() {
            View mView;
            mView = PressureMonthFragment.this.getMView();
            return (CircleThumbSegmentedBarView) mView.findViewById(R.id.sbv);
        }
    });

    private final CircleThumbSegmentedBarView getMSbv() {
        return (CircleThumbSegmentedBarView) this.mSbv$delegate.getValue();
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    public void filterData(@OXOo.OOXIXo List<? extends Pressure> data) {
        IIX0o.x0xO0oo(data, "data");
        super.filterData(data);
        PressureDataParse.INSTANCE.filterDayData(getMActivity(), data, getMonthData(), this.pressureDataList, getValues());
        updateChartData(getValues());
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment, com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getImage().setImageResource(R.drawable.icon_pressure);
        getValueUnit().setText("");
        getOneTV().setText(R.string.ave_value);
        getOneUnit().setText("");
        getTwoTV().setText(R.string.monitoring_results);
        getTwoUnit().setText("");
        Context context = getContext();
        IIX0o.ooOOo0oXI(context);
        CircleThumbSegmentedBarView mSbv = getMSbv();
        IIX0o.oO(mSbv, "<get-mSbv>(...)");
        PressureDataKt.setPressureSbv(context, mSbv);
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_status_pressure_month;
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
        long[] o002 = com.sma.smartv3.util.xoIox.o00(calendar, timePeriod, i);
        setMonthDays(com.sma.smartv3.util.xoIox.Oo(o002[0]));
        clearCache(o002[0]);
        return this.mPressureDao.getPressures(o002[0], o002[1]);
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    public void setChartRenderer() {
        xxx00.II0xO0 iI0xO0 = new xxx00.II0xO0(getBarChart(), getBarChart().getAnimator(), getBarChart().getViewPortHandler());
        iI0xO0.X0IIOO(oIxOXo.oxoX.I0Io(getMActivity(), R.color.line_color));
        iI0xO0.O0xOxO(new int[]{ContextCompat.getColor(getMActivity(), R.color.p_show_1), ContextCompat.getColor(getMActivity(), R.color.p_show_2)});
        iI0xO0.oI0IIXIo(5);
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
        return "Pressure month Data";
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseMonthFragment
    public void updateItemData(@OXOo.OOXIXo Entry e) {
        IIX0o.x0xO0oo(e, "e");
        PressureDayData pressureDayData = this.pressureDataList.get((int) e.xxIXOIIO());
        getNowValue().setText(UtilsKt.OOXIXo(pressureDayData.getMin(), pressureDayData.getMax()));
        getValueUnit().setText("");
        getOneValue().setText(UtilsKt.OxxIIOOXO(pressureDayData.getAvg()));
        getTwoValue().setText(UtilsKt.IIXOooo(pressureDayData.getStatus()));
        CircleThumbSegmentedBarView mSbv = getMSbv();
        IIX0o.oO(mSbv, "<get-mSbv>(...)");
        PressureDataKt.setPressureSbvValue(mSbv, pressureDayData.getAvg());
    }
}
