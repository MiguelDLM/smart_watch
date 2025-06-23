package com.sma.smartv3.ui.device;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.PrayTimeType;
import com.sma.smartv3.model.PrayerTime;
import com.sma.smartv3.model.PrayerTimeSettings;
import com.sma.smartv3.util.UtilsKt;
import java.util.ArrayList;
import java.util.List;

@kotlin.jvm.internal.XX({"SMAP\nQiblaTimeCorrectActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QiblaTimeCorrectActivity.kt\ncom/sma/smartv3/ui/device/QiblaTimeCorrectActivity$showPrayerTime$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,120:1\n1#2:121\n*E\n"})
/* loaded from: classes12.dex */
public final class QiblaTimeCorrectActivity$showPrayerTime$1 extends CommonAdapter<PrayerTime> {
    final /* synthetic */ QiblaTimeCorrectActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QiblaTimeCorrectActivity$showPrayerTime$1(QiblaTimeCorrectActivity qiblaTimeCorrectActivity, List<PrayerTime> list) {
        super(qiblaTimeCorrectActivity, R.layout.item_qibla_time, list);
        this.this$0 = qiblaTimeCorrectActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$3(final QiblaTimeCorrectActivity this$0, int i, final PrayerTime item, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "$item");
        ArrayList arrayList = new ArrayList(121);
        for (int i2 = 0; i2 < 121; i2++) {
            arrayList.add(String.valueOf(i2 - 60));
        }
        com.sma.smartv3.pop.OX00O0xII oX00O0xII = new com.sma.smartv3.pop.OX00O0xII(this$0, arrayList);
        oX00O0xII.oo(R.string.prayer_time_correct);
        oX00O0xII.IoOoX(R.string.minute);
        oX00O0xII.oo0xXOI0I(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.QiblaTimeCorrectActivity$showPrayerTime$1$convert$2$2$1

            /* loaded from: classes12.dex */
            public /* synthetic */ class oIX0oI {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public static final /* synthetic */ int[] f22010oIX0oI;

                static {
                    int[] iArr = new int[PrayTimeType.values().length];
                    try {
                        iArr[PrayTimeType.FAJR.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PrayTimeType.SUNRISE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[PrayTimeType.DHUHR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[PrayTimeType.ASR.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[PrayTimeType.MAGHRIB.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[PrayTimeType.ISHA.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    f22010oIX0oI = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                return invoke(num.intValue());
            }

            @OXOo.OOXIXo
            public final Boolean invoke(int i3) {
                com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
                Object fromJson = new Gson().fromJson(xo0.oIX0oI().getString(PrayerTimeSettings.class.getName()), (Class<Object>) PrayerTimeSettings.class);
                if (fromJson == null) {
                    fromJson = PrayerTimeSettings.class.newInstance();
                }
                PrayerTimeSettings prayerTimeSettings = (PrayerTimeSettings) fromJson;
                int i4 = i3 - 60;
                switch (oIX0oI.f22010oIX0oI[PrayerTime.this.getType().ordinal()]) {
                    case 1:
                        prayerTimeSettings.setFajrAdjustment(i4);
                        break;
                    case 2:
                        prayerTimeSettings.setSunriseAdjustment(i4);
                        break;
                    case 3:
                        prayerTimeSettings.setDhuhrAdjustment(i4);
                        break;
                    case 4:
                        prayerTimeSettings.setAsrAdjustment(i4);
                        break;
                    case 5:
                        prayerTimeSettings.setMaghribAdjustment(i4);
                        break;
                    case 6:
                        prayerTimeSettings.setIshaAdjustment(i4);
                        break;
                }
                xo0.oIX0oI().put(PrayerTimeSettings.class.getName(), new Gson().toJson(prayerTimeSettings));
                this$0.onInfoChange(new Object());
                return Boolean.TRUE;
            }
        });
        oX00O0xII.oOXoIIIo(i + 60);
        oX00O0xII.IIXOooo();
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
    public void convert(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo final PrayerTime item, int i) {
        String str;
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        TextView textView = (TextView) holder.getView(R.id.tv_name);
        Context mContext = ((CommonAdapter) this).mContext;
        kotlin.jvm.internal.IIX0o.oO(mContext, "mContext");
        textView.setText(item.getTimeName(mContext));
        ((TextView) holder.getView(R.id.tv_time)).setText(item.getTimeString());
        final int adjustmentMin = item.getAdjustmentMin();
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
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(view2);
        UtilsKt.x0o(view2, 200.0f);
        view2.setBackgroundDrawable(null);
        Context mContext2 = ((CommonAdapter) this).mContext;
        kotlin.jvm.internal.IIX0o.oO(mContext2, "mContext");
        holder.setImageResource(R.id.iv_icon, item.getTimeIcon(mContext2));
        View convertView = holder.getConvertView();
        final QiblaTimeCorrectActivity qiblaTimeCorrectActivity = this.this$0;
        convertView.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.xOOxI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                QiblaTimeCorrectActivity$showPrayerTime$1.convert$lambda$3(QiblaTimeCorrectActivity.this, adjustmentMin, item, view3);
            }
        });
    }
}
