package com.sma.smartv3.ui.timezonepicker;

import android.content.Context;
import android.text.format.Time;
import android.util.SparseArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes12.dex */
public class TimeZoneInfo implements Comparable<TimeZoneInfo>, Serializable {
    private static final char SEPARATOR = ',';
    private boolean isSelected;
    private String mCityName;
    private String mCountry;
    private String mDisplayName;
    private String mEnCityName;
    private String mKey;
    private int mRawoffset;
    private TimeZone mTimeZone;
    private String mTimeZoneId;
    private static long time = System.currentTimeMillis() / 1000;
    public static boolean is24HourFormat = true;
    private Time recycledTime = new Time();
    SparseArray<String> mLocalTimeCache = new SparseArray<>();
    long mLocalTimeCacheReferenceTime = 0;

    public TimeZoneInfo(Context context, TimeZone tz, String country) {
        this.mTimeZone = tz;
        this.mTimeZoneId = tz.getID();
        this.mCountry = country;
        if (tz.inDaylightTime(new Date())) {
            this.mRawoffset = tz.getRawOffset() + 3600000;
            this.mDisplayName = tz.getDisplayName(true, 1);
        } else {
            this.mRawoffset = tz.getRawOffset();
            this.mDisplayName = tz.getDisplayName();
        }
        String[] split = this.mTimeZoneId.split("/");
        if (split.length > 1) {
            this.mEnCityName = split[split.length - 1].replace(HelpFormatter.DEFAULT_OPT_PREFIX, "_").replace("_", " ");
            this.mKey = split[split.length - 1].replace(HelpFormatter.DEFAULT_OPT_PREFIX, "_").toLowerCase();
        } else {
            String str = this.mTimeZoneId;
            this.mEnCityName = str;
            this.mKey = str.toLowerCase();
        }
        this.mCityName = getFinalCityName(context, this.mKey);
    }

    private static String formatTime(DateFormat df, int s) {
        return df.format(new Date(s * 1000));
    }

    public static String getFinalCityName(Context context, String key) {
        try {
            return context.getString(context.getResources().getIdentifier(key, TypedValues.Custom.S_STRING, context.getPackageName()));
        } catch (Exception unused) {
            return key;
        }
    }

    public String getCityName() {
        return this.mCityName;
    }

    public String getCountry() {
        return this.mCountry;
    }

    public String getDisplayName() {
        return this.mDisplayName;
    }

    public String getEnCityName() {
        return this.mEnCityName;
    }

    public String getGMTName() {
        TimeZone timeZone = this.mTimeZone;
        return timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0, Locale.getDefault());
    }

    public String getKey() {
        return this.mKey;
    }

    public String getLocalTime(long referenceTime) {
        String str;
        String str2;
        this.recycledTime.timezone = TimeZone.getDefault().getID();
        this.recycledTime.set(referenceTime);
        Time time2 = this.recycledTime;
        int i = (time2.year * 366) + time2.yearDay;
        time2.timezone = this.mTimeZoneId;
        time2.set(referenceTime);
        Time time3 = this.recycledTime;
        int i2 = (time3.hour * 60) + time3.minute;
        if (this.mLocalTimeCacheReferenceTime != referenceTime) {
            this.mLocalTimeCacheReferenceTime = referenceTime;
            this.mLocalTimeCache.clear();
            str = null;
        } else {
            str = this.mLocalTimeCache.get(i2);
        }
        if (str == null) {
            Time time4 = this.recycledTime;
            if (i != (time4.year * 366) + time4.yearDay) {
                if (is24HourFormat) {
                    str2 = "%b %d %H:%M";
                } else {
                    str2 = "%b %d %I:%M %p";
                }
            } else if (is24HourFormat) {
                str2 = "%H:%M";
            } else {
                str2 = "%I:%M %p";
            }
            String format = time4.format(str2);
            this.mLocalTimeCache.put(i2, format);
            return format;
        }
        return str;
    }

    public int getRawoffset() {
        return this.mRawoffset;
    }

    public String getTimeZoneId() {
        return this.mTimeZoneId;
    }

    public boolean hasSameRules(TimeZoneInfo tzi) {
        return this.mTimeZone.hasSameRules(tzi.mTimeZone);
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setCityName(String mCityName) {
        this.mCityName = mCityName;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.mCountry;
        TimeZone timeZone = this.mTimeZone;
        sb.append(this.mTimeZoneId);
        sb.append(',');
        sb.append(timeZone.getDisplayName(false, 1));
        sb.append(',');
        sb.append(timeZone.getDisplayName(false, 0));
        sb.append(',');
        if (timeZone.useDaylightTime()) {
            sb.append(timeZone.getDisplayName(true, 1));
            sb.append(',');
            sb.append(timeZone.getDisplayName(true, 0));
        } else {
            sb.append(',');
        }
        sb.append(',');
        sb.append(timeZone.getRawOffset() / 3600000.0f);
        sb.append(',');
        sb.append(timeZone.getDSTSavings() / 3600000.0f);
        sb.append(',');
        sb.append(str);
        sb.append(',');
        sb.append(getLocalTime(1357041600000L));
        sb.append(',');
        sb.append(getLocalTime(1363348800000L));
        sb.append(',');
        sb.append(getLocalTime(1372680000000L));
        sb.append(',');
        sb.append(getLocalTime(1383307200000L));
        sb.append(',');
        sb.append('\n');
        return sb.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(TimeZoneInfo other) {
        return this.mTimeZoneId.compareTo(other.mTimeZoneId);
    }
}
