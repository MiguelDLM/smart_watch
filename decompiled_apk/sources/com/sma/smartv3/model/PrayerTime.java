package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.content.res.Resources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.blankj.utilcode.util.Utils;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.Xo0;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.OxI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nPrayerTimes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PrayerTimes.kt\ncom/sma/smartv3/model/PrayerTime\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,413:1\n18#2,2:414\n15#2:416\n*S KotlinDebug\n*F\n+ 1 PrayerTimes.kt\ncom/sma/smartv3/model/PrayerTime\n*L\n286#1:414,2\n286#1:416\n*E\n"})
/* loaded from: classes12.dex */
public final class PrayerTime {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    private final long time;

    @OOXIXo
    private final PrayTimeType type;

    @XX({"SMAP\nPrayerTimes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PrayerTimes.kt\ncom/sma/smartv3/model/PrayerTime$Companion\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,413:1\n76#2:414\n96#2,5:415\n*S KotlinDebug\n*F\n+ 1 PrayerTimes.kt\ncom/sma/smartv3/model/PrayerTime$Companion\n*L\n303#1:414\n303#1:415,5\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @oOoXoXO
        public final PrayerTime findNextTime(@OOXIXo Map<Long, ? extends List<PrayerTime>> datas, long j) {
            IIX0o.x0xO0oo(datas, "datas");
            ArrayList<PrayerTime> arrayList = new ArrayList();
            Iterator<Map.Entry<Long, ? extends List<PrayerTime>>> it = datas.entrySet().iterator();
            while (it.hasNext()) {
                OxI.XIo0oOXIx(arrayList, it.next().getValue());
            }
            for (PrayerTime prayerTime : arrayList) {
                if (j < prayerTime.getTime()) {
                    return prayerTime;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    /* loaded from: classes12.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

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
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PrayerTime(@OOXIXo PrayTimeType type, long j) {
        IIX0o.x0xO0oo(type, "type");
        this.type = type;
        this.time = j;
    }

    public static /* synthetic */ PrayerTime copy$default(PrayerTime prayerTime, PrayTimeType prayTimeType, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            prayTimeType = prayerTime.type;
        }
        if ((i & 2) != 0) {
            j = prayerTime.time;
        }
        return prayerTime.copy(prayTimeType, j);
    }

    @OOXIXo
    public final PrayTimeType component1() {
        return this.type;
    }

    public final long component2() {
        return this.time;
    }

    @OOXIXo
    public final PrayerTime copy(@OOXIXo PrayTimeType type, long j) {
        IIX0o.x0xO0oo(type, "type");
        return new PrayerTime(type, j);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrayerTime)) {
            return false;
        }
        PrayerTime prayerTime = (PrayerTime) obj;
        return this.type == prayerTime.type && this.time == prayerTime.time;
    }

    public final int getAdjustmentMin() {
        Object fromJson = new Gson().fromJson(Xo0.f24349oIX0oI.oIX0oI().getString(PrayerTimeSettings.class.getName()), (Class<Object>) PrayerTimeSettings.class);
        if (fromJson == null) {
            fromJson = PrayerTimeSettings.class.newInstance();
        }
        PrayerTimeSettings prayerTimeSettings = (PrayerTimeSettings) fromJson;
        switch (WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()]) {
            case 1:
                return prayerTimeSettings.getFajrAdjustment();
            case 2:
                return prayerTimeSettings.getSunriseAdjustment();
            case 3:
                return prayerTimeSettings.getDhuhrAdjustment();
            case 4:
                return prayerTimeSettings.getAsrAdjustment();
            case 5:
                return prayerTimeSettings.getMaghribAdjustment();
            case 6:
                return prayerTimeSettings.getIshaAdjustment();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final long getTime() {
        return this.time;
    }

    public final int getTimeHour() {
        String format = new SimpleDateFormat(DateFormatUtils.HH).format(Long.valueOf(this.time));
        IIX0o.oO(format, "format(...)");
        return Integer.parseInt(format);
    }

    public final int getTimeIcon(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        try {
            Resources resources = context.getResources();
            StringBuilder sb = new StringBuilder();
            sb.append("icon_qibla_");
            String lowerCase = this.type.name().toLowerCase(Locale.ROOT);
            IIX0o.oO(lowerCase, "toLowerCase(...)");
            sb.append(lowerCase);
            int identifier = resources.getIdentifier(sb.toString(), "drawable", context.getPackageName());
            if (identifier == 0) {
                return R.drawable.icon_qibla_asr;
            }
            return identifier;
        } catch (Exception e) {
            e.printStackTrace();
            return R.drawable.icon_qibla_asr;
        }
    }

    public final int getTimeMinute() {
        String format = new SimpleDateFormat(DateFormatUtils.MIN).format(Long.valueOf(this.time));
        IIX0o.oO(format, "format(...)");
        return Integer.parseInt(format);
    }

    public final int getTimeName(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        try {
            Resources resources = context.getResources();
            StringBuilder sb = new StringBuilder();
            sb.append("prayer_time_");
            String lowerCase = this.type.name().toLowerCase(Locale.ROOT);
            IIX0o.oO(lowerCase, "toLowerCase(...)");
            sb.append(lowerCase);
            int identifier = resources.getIdentifier(sb.toString(), TypedValues.Custom.S_STRING, Utils.getApp().getPackageName());
            if (identifier == 0) {
                return R.string.prayer_time_asr;
            }
            return identifier;
        } catch (Exception e) {
            e.printStackTrace();
            return R.string.prayer_time_asr;
        }
    }

    @OOXIXo
    public final String getTimeString() {
        String format = new SimpleDateFormat("HH:mm").format(Long.valueOf(this.time));
        IIX0o.oO(format, "format(...)");
        return format;
    }

    @OOXIXo
    public final PrayTimeType getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + androidx.collection.oIX0oI.oIX0oI(this.time);
    }

    @OOXIXo
    public String toString() {
        return this.type.name() + ": " + getTimeString();
    }
}
