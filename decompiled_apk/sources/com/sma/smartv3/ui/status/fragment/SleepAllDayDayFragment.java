package com.sma.smartv3.ui.status.fragment;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.SleepDao;
import com.sma.smartv3.db.entity.Sleep;
import com.sma.smartv3.model.SleepAllDayData;
import com.sma.smartv3.model.SleepAllDayDataParse;
import com.sma.smartv3.ui.status.base.BaseDetailDaysFragment;
import com.sma.smartv3.util.HeathReportsUtils;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import com.szabh.smable3.entity.BleSleep;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.Triple;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nSleepAllDayDayFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SleepAllDayDayFragment.kt\ncom/sma/smartv3/ui/status/fragment/SleepAllDayDayFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,323:1\n1855#2,2:324\n*S KotlinDebug\n*F\n+ 1 SleepAllDayDayFragment.kt\ncom/sma/smartv3/ui/status/fragment/SleepAllDayDayFragment\n*L\n276#1:324,2\n*E\n"})
/* loaded from: classes12.dex */
public final class SleepAllDayDayFragment extends BaseDetailDaysFragment<Sleep> {

    @OXOo.oOoXoXO
    private SleepAllDayData curSleepAllDayData;
    private xxx00.II0xO0 infoBarChartRender;
    public o0xxxXXxX.II0xO0 setValue;

    @OXOo.OOXIXo
    private final X0IIOO barChart$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<BarChart>() { // from class: com.sma.smartv3.ui.status.fragment.SleepAllDayDayFragment$barChart$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final BarChart invoke() {
            View mView;
            mView = SleepAllDayDayFragment.this.getMView();
            return (BarChart) mView.findViewById(R.id.barChart);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO deepValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.SleepAllDayDayFragment$deepValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = SleepAllDayDayFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.deepValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO lightValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.SleepAllDayDayFragment$lightValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = SleepAllDayDayFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.lightValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO awakeValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.SleepAllDayDayFragment$awakeValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = SleepAllDayDayFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.awakeValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO remValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.SleepAllDayDayFragment$remValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = SleepAllDayDayFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.remValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO piecemealValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.SleepAllDayDayFragment$piecemealValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = SleepAllDayDayFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.piecemealValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sleepStartTime$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.fragment.SleepAllDayDayFragment$sleepStartTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SleepAllDayDayFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.sleepStartTime);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sleepEndTime$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.fragment.SleepAllDayDayFragment$sleepEndTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SleepAllDayDayFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.sleepEndTime);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO llInfoRem$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ViewGroup>() { // from class: com.sma.smartv3.ui.status.fragment.SleepAllDayDayFragment$llInfoRem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ViewGroup invoke() {
            View mView;
            mView = SleepAllDayDayFragment.this.getMView();
            return (ViewGroup) mView.findViewById(R.id.ll_info_rem);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO llInfoPiecemeal$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ViewGroup>() { // from class: com.sma.smartv3.ui.status.fragment.SleepAllDayDayFragment$llInfoPiecemeal$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ViewGroup invoke() {
            View mView;
            mView = SleepAllDayDayFragment.this.getMView();
            return (ViewGroup) mView.findViewById(R.id.ll_info_piecemeal);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO llPiecemeal$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ViewGroup>() { // from class: com.sma.smartv3.ui.status.fragment.SleepAllDayDayFragment$llPiecemeal$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ViewGroup invoke() {
            View mView;
            mView = SleepAllDayDayFragment.this.getMView();
            return (ViewGroup) mView.findViewById(R.id.ll_piecemeal);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO totalPiecemealTime$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.fragment.SleepAllDayDayFragment$totalPiecemealTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SleepAllDayDayFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_total_piecemeal_time);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO piemealCount$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.fragment.SleepAllDayDayFragment$piemealCount$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SleepAllDayDayFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_piecemeal_count);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO piemealAvg$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.fragment.SleepAllDayDayFragment$piemealAvg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SleepAllDayDayFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_piecemeal_avg);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO rvPiecemeal$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.status.fragment.SleepAllDayDayFragment$rvPiecemeal$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            View mView;
            mView = SleepAllDayDayFragment.this.getMView();
            return (RecyclerView) mView.findViewById(R.id.rv_piecemeal);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO healthLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.status.fragment.SleepAllDayDayFragment$healthLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = SleepAllDayDayFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.item_health_btn_layout);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO healthBtn$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.status.fragment.SleepAllDayDayFragment$healthBtn$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            View mView;
            mView = SleepAllDayDayFragment.this.getMView();
            return (Button) mView.findViewById(R.id.btn_common_heathy);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO healthTv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.fragment.SleepAllDayDayFragment$healthTv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = SleepAllDayDayFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.tv_common_heathy);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO healthTipLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.status.fragment.SleepAllDayDayFragment$healthTipLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = SleepAllDayDayFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.questions_healthy_tip_layout);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO healthQuestions$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.fragment.SleepAllDayDayFragment$healthQuestions$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = SleepAllDayDayFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.tv_common_healthy_questions);
        }
    });

    @OXOo.OOXIXo
    private final List<BarEntry> values = new ArrayList();
    private final int block = 1;
    private final float blockHeight = 400.0f / 1;

    @OXOo.OOXIXo
    private final SleepDao mSleepDao = MyDb.INSTANCE.getMDatabase().sleepDao();

    private final void filterData(List<Sleep> list) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        String str;
        this.values.clear();
        xxx00.II0xO0 iI0xO0 = null;
        this.curSleepAllDayData = null;
        List<Sleep> list2 = list;
        if (!list2.isEmpty()) {
            SleepAllDayData filterData = SleepAllDayDataParse.INSTANCE.filterData(list, this.blockHeight, this.values, getRange()[0]);
            this.curSleepAllDayData = filterData;
            LogUtils.d(filterData.toString());
            i2 = filterData.getStatus().get(1);
            i3 = filterData.getStatus().get(2);
            i4 = filterData.getStatus().get(3);
            i5 = filterData.getStatus().get(9);
            i6 = filterData.getStatus().get(8);
            int total = filterData.getTotal();
            if (total > 0) {
                setXAxis(filterData, total);
            }
            i = total;
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if (i == 0) {
            getSleepStartTime().setText("");
            getSleepEndTime().setText("");
            getBarChart().getXAxis().o0xxxXXxX(new ox.oOoXoXO(CollectionsKt__CollectionsKt.ooXIXxIX()));
        }
        DINCondBold deepValue = getDeepValue();
        IIX0o.oO(deepValue, "<get-deepValue>(...)");
        TextConvertKt.xXxxox0I(i2, deepValue, getMActivity(), 30, R.color.light);
        DINCondBold lightValue = getLightValue();
        IIX0o.oO(lightValue, "<get-lightValue>(...)");
        TextConvertKt.xXxxox0I(i3, lightValue, getMActivity(), 30, R.color.light);
        DINCondBold awakeValue = getAwakeValue();
        IIX0o.oO(awakeValue, "<get-awakeValue>(...)");
        TextConvertKt.xXxxox0I(i4, awakeValue, getMActivity(), 30, R.color.light);
        DINCondBold remValue = getRemValue();
        IIX0o.oO(remValue, "<get-remValue>(...)");
        TextConvertKt.xXxxox0I(i5, remValue, getMActivity(), 30, R.color.light);
        DINCondBold piecemealValue = getPiecemealValue();
        IIX0o.oO(piecemealValue, "<get-piecemealValue>(...)");
        TextConvertKt.xXxxox0I(i6, piecemealValue, getMActivity(), 30, R.color.light);
        DINCondBold nowValue = getNowValue();
        IIX0o.oO(nowValue, "<get-nowValue>(...)");
        TextConvertKt.IIX0o(i, nowValue, getMActivity(), 0, 0, 24, null);
        if (1 <= i && i < 121) {
            xxx00.II0xO0 iI0xO02 = this.infoBarChartRender;
            if (iI0xO02 == null) {
                IIX0o.XOxIOxOx("infoBarChartRender");
            } else {
                iI0xO0 = iI0xO02;
            }
            iI0xO0.xxX(6.0f);
        } else {
            xxx00.II0xO0 iI0xO03 = this.infoBarChartRender;
            if (iI0xO03 == null) {
                IIX0o.XOxIOxOx("infoBarChartRender");
            } else {
                iI0xO0 = iI0xO03;
            }
            iI0xO0.xxX(2.0f);
        }
        updateChartData(this.values);
        showSleepPiecemeal();
        if (i5 > 0) {
            getLlInfoRem().setVisibility(0);
        } else {
            getLlInfoRem().setVisibility(8);
        }
        if (!list2.isEmpty()) {
            Sleep sleep = (Sleep) CollectionsKt___CollectionsKt.O0O0Io00X(list);
            if (sleep.getMAlgorithmType() == 0) {
                Button healthBtn = getHealthBtn();
                if (healthBtn != null) {
                    healthBtn.setEnabled(false);
                    return;
                }
                return;
            }
            if (i6 != 0) {
                str = getString(R.string.night_sleep) + ':' + (i2 / 60) + getString(R.string.h) + (i2 % 60) + getString(R.string.h_m) + '\n' + getString(R.string.piecemeal) + ':' + (i6 / 60) + getString(R.string.h) + (i6 % 60) + getString(R.string.h_m);
            } else {
                str = getString(R.string.night_sleep) + ':' + (i2 / 60) + getString(R.string.h) + (i2 % 60) + getString(R.string.h_m);
            }
            String str2 = str;
            HeathReportsUtils heathReportsUtils = HeathReportsUtils.f24217oIX0oI;
            long mTime = sleep.getMTime();
            Button healthBtn2 = getHealthBtn();
            IIX0o.oO(healthBtn2, "<get-healthBtn>(...)");
            PFMedium healthTv = getHealthTv();
            IIX0o.oO(healthTv, "<get-healthTv>(...)");
            LinearLayout healthTipLayout = getHealthTipLayout();
            IIX0o.oO(healthTipLayout, "<get-healthTipLayout>(...)");
            PFMedium healthQuestions = getHealthQuestions();
            IIX0o.oO(healthQuestions, "<get-healthQuestions>(...)");
            heathReportsUtils.Io("sleep", mTime, healthBtn2, healthTv, healthTipLayout, healthQuestions, getMActivity());
            LinearLayout healthLayout = getHealthLayout();
            IIX0o.oO(healthLayout, "<get-healthLayout>(...)");
            Button healthBtn3 = getHealthBtn();
            IIX0o.oO(healthBtn3, "<get-healthBtn>(...)");
            PFMedium healthTv2 = getHealthTv();
            IIX0o.oO(healthTv2, "<get-healthTv>(...)");
            heathReportsUtils.x0o(healthLayout, healthBtn3, healthTv2, getMActivity(), "sleep", str2, sleep.getMTime());
        }
    }

    private final DINCondBold getAwakeValue() {
        return (DINCondBold) this.awakeValue$delegate.getValue();
    }

    private final BarChart getBarChart() {
        return (BarChart) this.barChart$delegate.getValue();
    }

    private final DINCondBold getDeepValue() {
        return (DINCondBold) this.deepValue$delegate.getValue();
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

    private final DINCondBold getLightValue() {
        return (DINCondBold) this.lightValue$delegate.getValue();
    }

    private final ViewGroup getLlInfoPiecemeal() {
        return (ViewGroup) this.llInfoPiecemeal$delegate.getValue();
    }

    private final ViewGroup getLlInfoRem() {
        return (ViewGroup) this.llInfoRem$delegate.getValue();
    }

    private final ViewGroup getLlPiecemeal() {
        return (ViewGroup) this.llPiecemeal$delegate.getValue();
    }

    private final DINCondBold getPiecemealValue() {
        return (DINCondBold) this.piecemealValue$delegate.getValue();
    }

    private final TextView getPiemealAvg() {
        return (TextView) this.piemealAvg$delegate.getValue();
    }

    private final TextView getPiemealCount() {
        return (TextView) this.piemealCount$delegate.getValue();
    }

    private final DINCondBold getRemValue() {
        return (DINCondBold) this.remValue$delegate.getValue();
    }

    private final RecyclerView getRvPiecemeal() {
        return (RecyclerView) this.rvPiecemeal$delegate.getValue();
    }

    private final TextView getSleepEndTime() {
        return (TextView) this.sleepEndTime$delegate.getValue();
    }

    private final TextView getSleepStartTime() {
        return (TextView) this.sleepStartTime$delegate.getValue();
    }

    private final TextView getTotalPiecemealTime() {
        return (TextView) this.totalPiecemealTime$delegate.getValue();
    }

    private final void setXAxis(SleepAllDayData sleepAllDayData, int i) {
        XAxis xAxis = getBarChart().getXAxis();
        IIX0o.x0XOIxOo(xAxis, "null cannot be cast to non-null type com.github.mikephil.charting.components.XAxis");
        int i2 = 0;
        SimpleDateFormat oxXx0IX2 = com.sma.smartv3.util.xoIox.oxXx0IX(false, 1, null);
        ArrayList arrayList = new ArrayList();
        if (i >= 0) {
            while (true) {
                arrayList.add("");
                if (i2 == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        getSleepStartTime().setText(TimeUtils.millis2String(sleepAllDayData.getStartTime() * 1000, oxXx0IX2));
        getSleepEndTime().setText(TimeUtils.millis2String(sleepAllDayData.getEndTime() * 1000, oxXx0IX2));
        xAxis.o0xxxXXxX(new ox.oOoXoXO(arrayList));
        xAxis.f4025ooXIXxIX = 0.0f;
        xAxis.OO(arrayList.size() / 4);
        xAxis.f4006IIX0o = arrayList.size();
    }

    private final void showSleepPiecemeal() {
        getLlPiecemeal().setVisibility(8);
        SleepAllDayData sleepAllDayData = this.curSleepAllDayData;
        if (sleepAllDayData != null && !sleepAllDayData.getAnalyseSleep().isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            int i2 = 0;
            for (List<BleSleep> list : BleSleep.Companion.getSleepAllDaySegments(sleepAllDayData.getAnalyseSleep())) {
                Integer num = BleSleep.Companion.getSleepAllDaySegmentStatus(list).get(8);
                if (num == null) {
                    num = 0;
                }
                IIX0o.ooOOo0oXI(num);
                int intValue = num.intValue();
                if (intValue > 0) {
                    i++;
                    i2 += intValue;
                    arrayList.add(new Triple(getString(R.string.sleep_nap) + i, TextConvertKt.ooXIXxIX(intValue), com.sma.smartv3.util.xoIox.oxXx0IX(false, 1, null).format(Long.valueOf(((BleSleep) CollectionsKt___CollectionsKt.O0OOX0IIx(list)).getMLocalTime())) + '-' + com.sma.smartv3.util.xoIox.oxXx0IX(false, 1, null).format(Long.valueOf(((BleSleep) CollectionsKt___CollectionsKt.O0O0Io00X(list)).getMLocalTime()))));
                }
            }
            if (i == 0) {
                return;
            }
            getLlPiecemeal().setVisibility(0);
            getTotalPiecemealTime().setText(TextConvertKt.ooXIXxIX(i2));
            getPiemealCount().setText(getString(R.string.d_times, Integer.valueOf(i)));
            getPiemealAvg().setText(TextConvertKt.ooXIXxIX(i2 / i));
            getRvPiecemeal().setLayoutManager(new LinearLayoutManager(getMActivity(), 1, false));
            RecyclerView rvPiecemeal = getRvPiecemeal();
            final Activity mActivity = getMActivity();
            final List OOoOoO0o2 = CollectionsKt___CollectionsKt.OOoOoO0o(arrayList);
            rvPiecemeal.setAdapter(new CommonAdapter<Triple<? extends String, ? extends String, ? extends String>>(mActivity, OOoOoO0o2) { // from class: com.sma.smartv3.ui.status.fragment.SleepAllDayDayFragment$showSleepPiecemeal$1$2
                @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
                public /* bridge */ /* synthetic */ void convert(ViewHolder viewHolder, Triple<? extends String, ? extends String, ? extends String> triple, int i3) {
                    convert2(viewHolder, (Triple<String, String, String>) triple, i3);
                }

                /* renamed from: convert, reason: avoid collision after fix types in other method */
                public void convert2(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo Triple<String, String, String> item, int i3) {
                    IIX0o.x0xO0oo(holder, "holder");
                    IIX0o.x0xO0oo(item, "item");
                    ((TextView) holder.getView(R.id.tv_name)).setText(item.getFirst());
                    ((TextView) holder.getView(R.id.tv_time)).setText(item.getSecond());
                    ((TextView) holder.getView(R.id.tv_date)).setText(item.getThird());
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateChartData(List<BarEntry> list) {
        if (getBarChart().getData() != 0 && ((o0xxxXXxX.oIX0oI) getBarChart().getData()).ooOOo0oXI() > 0) {
            ((o0xxxXXxX.oIX0oI) getBarChart().getData()).xXxxox0I(0);
        }
        o0xxxXXxX.II0xO0 iI0xO0 = new o0xxxXXxX.II0xO0(list, "SleepAllDayData");
        iI0xO0.OOxOI(0.0f);
        iI0xO0.xxxI(0.0f);
        o0xxxXXxX.oIX0oI oix0oi = new o0xxxXXxX.oIX0oI(iI0xO0);
        oix0oi.oo0xXOI0I(false);
        setColor(iI0xO0);
        getBarChart().setData(oix0oi);
        getBarChart().invalidate();
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

    @OXOo.OOXIXo
    public final List<BarEntry> getValues() {
        return this.values;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        getBarChart().xOoOIoI(0.0f, 0.0f, 0.0f, 0.0f);
        BarChart barChart = getBarChart();
        barChart.setTouchEnabled(false);
        barChart.getDescription().Oxx0IOOO(false);
        barChart.getLegend().Oxx0IOOO(false);
        YAxis axisLeft = barChart.getAxisLeft();
        axisLeft.XoI0Ixx0(false);
        axisLeft.xXOx(this.blockHeight);
        axisLeft.I0oOIX(false);
        axisLeft.Xo0(false);
        axisLeft.XoI0Ixx0(false);
        axisLeft.I0X0x0oIo(0.0f);
        axisLeft.o0oIxOo(0.0f);
        YAxis axisRight = barChart.getAxisRight();
        axisRight.Oxx0IOOO(false);
        axisRight.I0X0x0oIo(0.0f);
        axisRight.o0oIxOo(0.0f);
        axisRight.I0oOIX(false);
        axisRight.XoI0Ixx0(false);
        XAxis xAxis = barChart.getXAxis();
        xxx00.oIX0oI oix0oi = xxx00.oIX0oI.f35574oIX0oI;
        IIX0o.ooOOo0oXI(xAxis);
        oix0oi.X0o0xo(xAxis, true, getMActivity());
        xAxis.I0oOIX(false);
        xAxis.XoI0Ixx0(false);
        xxx00.II0xO0 iI0xO0 = new xxx00.II0xO0(getBarChart(), getBarChart().getAnimator(), getBarChart().getViewPortHandler());
        this.infoBarChartRender = iI0xO0;
        iI0xO0.X0IIOO(oIxOXo.oxoX.I0Io(getMActivity(), R.color.line_color));
        xxx00.II0xO0 iI0xO02 = this.infoBarChartRender;
        xxx00.II0xO0 iI0xO03 = null;
        if (iI0xO02 == null) {
            IIX0o.XOxIOxOx("infoBarChartRender");
            iI0xO02 = null;
        }
        iI0xO02.XI0IXoo(this.blockHeight);
        xxx00.II0xO0 iI0xO04 = this.infoBarChartRender;
        if (iI0xO04 == null) {
            IIX0o.XOxIOxOx("infoBarChartRender");
            iI0xO04 = null;
        }
        iI0xO04.OxI(this.block);
        xxx00.II0xO0 iI0xO05 = this.infoBarChartRender;
        if (iI0xO05 == null) {
            IIX0o.XOxIOxOx("infoBarChartRender");
            iI0xO05 = null;
        }
        iI0xO05.oI0IIXIo(6);
        BarChart barChart2 = getBarChart();
        xxx00.II0xO0 iI0xO06 = this.infoBarChartRender;
        if (iI0xO06 == null) {
            IIX0o.XOxIOxOx("infoBarChartRender");
        } else {
            iI0xO03 = iI0xO06;
        }
        barChart2.setRenderer(iI0xO03);
        super.initView();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_status_sleep_all_day;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    public void onDataChange(@OXOo.OOXIXo List<Sleep> data) {
        IIX0o.x0xO0oo(data, "data");
        filterData(data);
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    @OXOo.OOXIXo
    public List<Sleep> onTimePeriodChange(@OXOo.OOXIXo Calendar calendar, int i, @OXOo.OOXIXo TimePeriod timePeriod) {
        IIX0o.x0xO0oo(calendar, "calendar");
        IIX0o.x0xO0oo(timePeriod, "timePeriod");
        setRange(com.sma.smartv3.util.xoIox.o00(calendar, timePeriod, i));
        LogUtils.d("day => " + getRange()[0] + '-' + getRange()[1]);
        StringBuilder sb = new StringBuilder();
        sb.append("day => ");
        SimpleDateFormat OO0x0xX2 = com.sma.smartv3.util.xoIox.OO0x0xX();
        long j = getRange()[0];
        long j2 = (long) com.sma.smartv3.util.xoIox.f24684IO;
        sb.append(OO0x0xX2.format(Long.valueOf(j - j2)));
        sb.append('-');
        sb.append(com.sma.smartv3.util.xoIox.OO0x0xX().format(Long.valueOf(getRange()[1])));
        LogUtils.d(sb.toString());
        return this.mSleepDao.getSleeps(getRange()[0] - j2, getRange()[1]);
    }

    public final void setColor(@OXOo.OOXIXo o0xxxXXxX.II0xO0 value) {
        IIX0o.x0xO0oo(value, "value");
        value.o0IXXIx(CollectionsKt__CollectionsKt.X00IoxXI(0, Integer.valueOf(ContextCompat.getColor(getMActivity(), R.color.colorAccent))));
    }

    @OXOo.OOXIXo
    public final String setDataLabel() {
        return "sleep day Data";
    }

    public final void setSetValue(@OXOo.OOXIXo o0xxxXXxX.II0xO0 iI0xO0) {
        IIX0o.x0xO0oo(iI0xO0, "<set-?>");
        this.setValue = iI0xO0;
    }
}
