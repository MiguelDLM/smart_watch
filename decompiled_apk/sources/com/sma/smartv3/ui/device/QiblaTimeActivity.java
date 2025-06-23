package com.sma.smartv3.ui.device;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.bestmafen.androidbase.base.BaseActivity;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.PrayerTime;
import com.sma.smartv3.model.PrayerTimeSettings;
import com.sma.smartv3.model.PrayerTimesKt;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.view.CountDownView;
import com.sma.smartv3.view.FutureCalendarView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;

@kotlin.jvm.internal.XX({"SMAP\nQiblaTimeActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QiblaTimeActivity.kt\ncom/sma/smartv3/ui/device/QiblaTimeActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,129:1\n1#2:130\n18#3,2:131\n15#3:133\n*S KotlinDebug\n*F\n+ 1 QiblaTimeActivity.kt\ncom/sma/smartv3/ui/device/QiblaTimeActivity\n*L\n100#1:131,2\n100#1:133\n*E\n"})
/* loaded from: classes12.dex */
public final class QiblaTimeActivity extends BaseActivity {

    @OXOo.oOoXoXO
    private PrayerTime mNextPrayerTime;
    private Map<Long, ? extends List<PrayerTime>> mPrayerTimeData;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO calendarView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<FutureCalendarView>() { // from class: com.sma.smartv3.ui.device.QiblaTimeActivity$calendarView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final FutureCalendarView invoke() {
            return (FutureCalendarView) QiblaTimeActivity.this.findViewById(R.id.calendarView);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO recycleView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.device.QiblaTimeActivity$recycleView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            return (RecyclerView) QiblaTimeActivity.this.findViewById(R.id.recyclerView);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvNextTimeName$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.QiblaTimeActivity$tvNextTimeName$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) QiblaTimeActivity.this.findViewById(R.id.tv_next_time_name);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvNextTimeValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.QiblaTimeActivity$tvNextTimeValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) QiblaTimeActivity.this.findViewById(R.id.tv_next_time_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvCountDownView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CountDownView>() { // from class: com.sma.smartv3.ui.device.QiblaTimeActivity$tvCountDownView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CountDownView invoke() {
            return (CountDownView) QiblaTimeActivity.this.findViewById(R.id.tv_count_down);
        }
    });

    @OXOo.OOXIXo
    private com.sma.smartv3.location.oIX0oI mLocation = new com.sma.smartv3.location.oIX0oI(XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, 0.0f, 0, 31, null);

    @kotlin.jvm.internal.XX({"SMAP\nQiblaTimeActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QiblaTimeActivity.kt\ncom/sma/smartv3/ui/device/QiblaTimeActivity$initView$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,129:1\n1#2:130\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class oIX0oI implements FutureCalendarView.oIX0oI {
        public oIX0oI() {
        }

        @Override // com.sma.smartv3.view.FutureCalendarView.oIX0oI
        public void oIX0oI(@OXOo.oOoXoXO Calendar calendar, int i, int i2, int i3) {
            if (calendar != null) {
                QiblaTimeActivity.this.showPrayerTime(calendar.getTimeInMillis());
            }
        }
    }

    private final FutureCalendarView getCalendarView() {
        return (FutureCalendarView) this.calendarView$delegate.getValue();
    }

    private final RecyclerView getRecycleView() {
        return (RecyclerView) this.recycleView$delegate.getValue();
    }

    private final CountDownView getTvCountDownView() {
        return (CountDownView) this.tvCountDownView$delegate.getValue();
    }

    private final TextView getTvNextTimeName() {
        return (TextView) this.tvNextTimeName$delegate.getValue();
    }

    private final TextView getTvNextTimeValue() {
        return (TextView) this.tvNextTimeValue$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPrayerTime(long j) {
        Map<Long, ? extends List<PrayerTime>> map = this.mPrayerTimeData;
        if (map == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mPrayerTimeData");
            map = null;
        }
        List<PrayerTime> list = map.get(Long.valueOf(j));
        if (list == null) {
            list = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        final List<PrayerTime> list2 = list;
        getRecycleView().setLayoutManager(new LinearLayoutManager(this));
        getRecycleView().setAdapter(new CommonAdapter<PrayerTime>(list2) { // from class: com.sma.smartv3.ui.device.QiblaTimeActivity$showPrayerTime$1
            @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
            public void convert(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo PrayerTime item, int i) {
                String str;
                PrayerTime prayerTime;
                kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
                kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
                TextView textView = (TextView) holder.getView(R.id.tv_name);
                Context mContext = ((CommonAdapter) this).mContext;
                kotlin.jvm.internal.IIX0o.oO(mContext, "mContext");
                textView.setText(item.getTimeName(mContext));
                ((TextView) holder.getView(R.id.tv_time)).setText(item.getTimeString());
                int adjustmentMin = item.getAdjustmentMin();
                TextView textView2 = (TextView) holder.getView(R.id.tv_min);
                if (adjustmentMin != 0) {
                    str = com.sma.smartv3.util.xoIox.X0o0xo(adjustmentMin, R.string.minute);
                } else {
                    str = "";
                }
                textView2.setText(str);
                View view = holder.getView(R.id.ll_content);
                kotlin.jvm.internal.IIX0o.oO(view, "getView(...)");
                UtilsKt.x0o(view, 200.0f);
                View view2 = holder.getView(R.id.container);
                QiblaTimeActivity qiblaTimeActivity = QiblaTimeActivity.this;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(view2);
                UtilsKt.x0o(view2, 200.0f);
                prayerTime = qiblaTimeActivity.mNextPrayerTime;
                if (prayerTime != null && prayerTime.getTime() == item.getTime()) {
                    view2.setBackgroundResource(R.color.colorAccent);
                } else {
                    view2.setBackgroundDrawable(null);
                }
                Context mContext2 = ((CommonAdapter) this).mContext;
                kotlin.jvm.internal.IIX0o.oO(mContext2, "mContext");
                holder.setImageResource(R.id.iv_icon, item.getTimeIcon(mContext2));
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    @RequiresApi(26)
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.prayer_time);
        getCalendarView().setOnDateSelectedListener(new oIX0oI());
        getCalendarView().I0Io(true);
        onInfoChange(new Object());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_qibla_time;
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getTvCountDownView().cancelCountDown();
    }

    @XO0.XO(tag = com.sma.smartv3.util.XoI0Ixx0.f24423XX)
    public final void onInfoChange(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        this.mLocation = UtilsKt.ooOOo0oXI();
        Calendar calendar = Calendar.getInstance();
        kotlin.jvm.internal.IIX0o.oO(calendar, "getInstance(...)");
        long OxxIIOOXO2 = com.sma.smartv3.util.xoIox.OxxIIOOXO(calendar);
        Object fromJson = new Gson().fromJson(com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getString(PrayerTimeSettings.class.getName()), (Class<Object>) PrayerTimeSettings.class);
        if (fromJson == null) {
            fromJson = PrayerTimeSettings.class.newInstance();
        }
        this.mPrayerTimeData = PrayerTimesKt.getPrayerTimeMap$default((PrayerTimeSettings) fromJson, this.mLocation.II0xO0(), this.mLocation.I0Io(), OxxIIOOXO2, 0, 16, null);
        long currentTimeMillis = System.currentTimeMillis();
        PrayerTime.Companion companion = PrayerTime.Companion;
        Map<Long, ? extends List<PrayerTime>> map = this.mPrayerTimeData;
        if (map == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mPrayerTimeData");
            map = null;
        }
        this.mNextPrayerTime = companion.findNextTime(map, currentTimeMillis);
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        sb.append("onLocationInfoChange ");
        sb.append(this.mLocation);
        sb.append(TokenParser.SP);
        sb.append(this.mNextPrayerTime);
        sb.append(", ");
        Map<Long, ? extends List<PrayerTime>> map2 = this.mPrayerTimeData;
        if (map2 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mPrayerTimeData");
            map2 = null;
        }
        sb.append(map2);
        oix0oi.oIX0oI(sb.toString());
        showPrayerTime(OxxIIOOXO2);
        if (this.mNextPrayerTime != null) {
            TextView tvNextTimeName = getTvNextTimeName();
            PrayerTime prayerTime = this.mNextPrayerTime;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(prayerTime);
            tvNextTimeName.setText(prayerTime.getTimeName(getMContext()));
            TextView tvNextTimeValue = getTvNextTimeValue();
            SimpleDateFormat oxxXoxO2 = com.sma.smartv3.util.xoIox.oxxXoxO(false, false, 3, null);
            PrayerTime prayerTime2 = this.mNextPrayerTime;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(prayerTime2);
            tvNextTimeValue.setText(oxxXoxO2.format(Long.valueOf(prayerTime2.getTime())));
            CountDownView tvCountDownView = getTvCountDownView();
            kotlin.jvm.internal.IIX0o.oO(tvCountDownView, "<get-tvCountDownView>(...)");
            PrayerTime prayerTime3 = this.mNextPrayerTime;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(prayerTime3);
            CountDownView.startCountDown$default(tvCountDownView, prayerTime3.getTime() - currentTimeMillis, 0L, 2, null);
            if (Build.VERSION.SDK_INT >= 26) {
                TextView tvNextTimeValue2 = getTvNextTimeValue();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(com.sma.smartv3.util.xoIox.xXxxox0I().format(Long.valueOf(currentTimeMillis)));
                sb2.append(TokenParser.SP);
                PrayerTime prayerTime4 = this.mNextPrayerTime;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(prayerTime4);
                sb2.append(com.sma.smartv3.util.xoIox.x0xO0oo(prayerTime4.getTime(), 0, 2, null));
                sb2.append(" (");
                SimpleDateFormat oo0xXOI0I2 = com.sma.smartv3.util.xoIox.oo0xXOI0I();
                PrayerTime prayerTime5 = this.mNextPrayerTime;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(prayerTime5);
                sb2.append(oo0xXOI0I2.format(Long.valueOf(prayerTime5.getTime())));
                sb2.append(HexStringBuilder.COMMENT_END_CHAR);
                tvNextTimeValue2.setText(sb2.toString());
            }
        }
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
