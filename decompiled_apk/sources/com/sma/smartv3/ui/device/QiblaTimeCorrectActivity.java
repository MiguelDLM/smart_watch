package com.sma.smartv3.ui.device;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.PrayerTime;
import com.sma.smartv3.model.PrayerTimeSettings;
import com.sma.smartv3.model.PrayerTimesKt;
import com.sma.smartv3.util.UtilsKt;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@kotlin.jvm.internal.XX({"SMAP\nQiblaTimeCorrectActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QiblaTimeCorrectActivity.kt\ncom/sma/smartv3/ui/device/QiblaTimeCorrectActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,120:1\n18#2,2:121\n15#2:123\n*S KotlinDebug\n*F\n+ 1 QiblaTimeCorrectActivity.kt\ncom/sma/smartv3/ui/device/QiblaTimeCorrectActivity\n*L\n109#1:121,2\n109#1:123\n*E\n"})
/* loaded from: classes12.dex */
public final class QiblaTimeCorrectActivity extends BaseActivity {
    private Map<Long, ? extends List<PrayerTime>> mPrayerTimeData;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO recycleView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.device.QiblaTimeCorrectActivity$recycleView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            return (RecyclerView) QiblaTimeCorrectActivity.this.findViewById(R.id.recyclerView);
        }
    });

    @OXOo.OOXIXo
    private com.sma.smartv3.location.oIX0oI mLocation = new com.sma.smartv3.location.oIX0oI(XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, 0.0f, 0, 31, null);

    private final RecyclerView getRecycleView() {
        return (RecyclerView) this.recycleView$delegate.getValue();
    }

    private final void showPrayerTime(long j) {
        Map<Long, ? extends List<PrayerTime>> map = this.mPrayerTimeData;
        if (map == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mPrayerTimeData");
            map = null;
        }
        List<PrayerTime> list = map.get(Long.valueOf(j));
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("showPrayerTime " + com.sma.smartv3.util.xoIox.OO0x0xX().format(Long.valueOf(j)) + " - " + list);
        getRecycleView().setLayoutManager(new LinearLayoutManager(this));
        getRecycleView().setAdapter(new QiblaTimeCorrectActivity$showPrayerTime$1(this, list));
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
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.prayer_time_correct);
        onInfoChange(new Object());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_qibla_time_correct;
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
        showPrayerTime(OxxIIOOXO2);
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
