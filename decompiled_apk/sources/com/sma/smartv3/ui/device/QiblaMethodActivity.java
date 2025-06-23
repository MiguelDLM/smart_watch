package com.sma.smartv3.ui.device;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.bestmafen.androidbase.list.BaseListActivity;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.PrayerTimeSettings;
import com.sma.smartv3.model.PrayerTimesCalculationMethod;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;

@kotlin.jvm.internal.XX({"SMAP\nQiblaMethodActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QiblaMethodActivity.kt\ncom/sma/smartv3/ui/device/QiblaMethodActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,58:1\n18#2,2:59\n15#2:61\n*S KotlinDebug\n*F\n+ 1 QiblaMethodActivity.kt\ncom/sma/smartv3/ui/device/QiblaMethodActivity\n*L\n19#1:59,2\n19#1:61\n*E\n"})
/* loaded from: classes12.dex */
public final class QiblaMethodActivity extends BaseListActivity<PrayerTimesCalculationMethod> {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    public static final int PICKER_REQUEST = 99;

    @OXOo.OOXIXo
    private final PrayerTimeSettings mSettings;

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public QiblaMethodActivity() {
        Object fromJson = new Gson().fromJson(com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getString(PrayerTimeSettings.class.getName()), (Class<Object>) PrayerTimeSettings.class);
        this.mSettings = (PrayerTimeSettings) (fromJson == null ? PrayerTimeSettings.class.newInstance() : fromJson);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initItem$lambda$0(XIOOI.I0Io holder, QiblaMethodActivity this$0, PrayerTimesCalculationMethod item, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "$holder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "$item");
        ((AppCompatRadioButton) holder.X0o0xo(R.id.rbSelectedState)).setChecked(true);
        this$0.setResult(-1, new Intent().putExtra("method", item));
        this$0.finish();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("mSettings -> " + this.mSettings);
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    @OXOo.OOXIXo
    public List<PrayerTimesCalculationMethod> initList() {
        return CollectionsKt___CollectionsKt.o0Xo0XII(PrayerTimesCalculationMethod.Companion.getMethods());
    }

    @Override // com.bestmafen.androidbase.list.BaseListActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.qibla_calculation_method);
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    public int itemLayoutId() {
        return R.layout.layout_qibla_method_item;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_qibla_method;
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    @Override // com.bestmafen.androidbase.list.I0Io
    public void initItem(@OXOo.OOXIXo final XIOOI.I0Io holder, @OXOo.OOXIXo final PrayerTimesCalculationMethod item, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        ((TextView) holder.X0o0xo(R.id.tv_name)).setText(item.getName());
        ((TextView) holder.X0o0xo(R.id.tv_fajr)).setText("Fair:" + item.getFajrAngle() + kotlin.text.XIxXXX0x0.f29560x0xO0oo);
        ((TextView) holder.X0o0xo(R.id.tv_isha)).setText("lsha'a: " + item.getIshaAngle() + kotlin.text.XIxXXX0x0.f29560x0xO0oo);
        ((AppCompatRadioButton) holder.X0o0xo(R.id.rbSelectedState)).setChecked(this.mSettings.getCalculationMethod() == item.getMethod());
        holder.II0xO0().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.xIx0XO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QiblaMethodActivity.initItem$lambda$0(XIOOI.I0Io.this, this, item, view);
            }
        });
    }
}
