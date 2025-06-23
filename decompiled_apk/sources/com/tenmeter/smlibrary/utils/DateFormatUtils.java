package com.tenmeter.smlibrary.utils;

import android.text.TextUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes13.dex */
public class DateFormatUtils {
    public static final String DD = "dd";
    public static final String HH = "HH";
    public static final String HH_MM_12 = "KK:mm";
    public static final String HH_MM_24 = "HH:mm";
    public static final String HH_MM_SS_SSS = "HH.mm.ss.SSS";
    public static final String HH_mm_ss = "HH：mm：ss";
    public static final String MIN = "mm";
    public static final String MM = "MM";
    public static final String MMDDHHMM2 = "MM/dd HH:mm";
    public static final String MM_DD = "MM-dd";
    public static final String MM_DD2 = "MM月dd日";
    public static final String MM_DD2_HH_MM = "MM月dd日 HH:mm";
    public static final String MM_DD_HH_MM = "MM-dd HH:mm";
    public static final String MM_SS = "mm:ss";
    public static final String YYYY = "yyyy";
    public static final String YYYYMM = "yyyyMM";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYYMMDD2 = "yyyy/MM/dd";
    public static final String YYYYMMDDHHMMSS2 = "yyyy/MM/dd HH:mm:ss";
    public static final String YYYY_MM = "yyyy-MM";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD2 = "yyyy-MM-dd";
    public static final String YYYY_MM_DD2_HH_MM = "yyyy年MM月dd日HH:mm";
    public static final String YYYY_MM_DD2_HH_MM2 = "yyyy.MM.dd HH:mm";
    public static final String YYYY_MM_DD2_HH_MM_SS = "yyyy年MM月dd日 HH:mm:ss";
    public static final String YYYY_MM_DD3 = "yyyy年MM月";
    public static final String YYYY_MM_DD4 = "yyyy.MM.dd";
    public static final String YYYY_MM_DD5 = "yyyy年MM月dd日";
    public static final String YYYY_MM_DD_EEEE_HH_MM_SS = "yyyy-MM-dd EEEE hh:mm:ss";
    public static final String YYYY_MM_DD_EE_HH_MM_SS = "yyyy年MM月dd EE hh:mm";
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";

    /* renamed from: com.tenmeter.smlibrary.utils.DateFormatUtils$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tenmeter$smlibrary$utils$DateFormatUtils$TimeName;

        static {
            int[] iArr = new int[TimeName.values().length];
            $SwitchMap$com$tenmeter$smlibrary$utils$DateFormatUtils$TimeName = iArr;
            try {
                iArr[TimeName.TODAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tenmeter$smlibrary$utils$DateFormatUtils$TimeName[TimeName.YESTERDAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tenmeter$smlibrary$utils$DateFormatUtils$TimeName[TimeName.THE_DAY_BEFORE_YESTERDAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tenmeter$smlibrary$utils$DateFormatUtils$TimeName[TimeName.THE_DAY_BEFORE_YESTERDAY_MORE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tenmeter$smlibrary$utils$DateFormatUtils$TimeName[TimeName.LAST_MONTH_MORE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$tenmeter$smlibrary$utils$DateFormatUtils$TimeName[TimeName.LAST_MONTH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes13.dex */
    public enum HoursFormat {
        H12,
        H24
    }

    /* loaded from: classes13.dex */
    public enum TimeName {
        TODAY,
        YESTERDAY,
        THE_DAY_BEFORE_YESTERDAY,
        THE_DAY_BEFORE_YESTERDAY_MORE,
        TOMORROW,
        THE_DAY_AFTER_TOMORROW,
        THE_DAY_AFTER_TOMORROW_MORE,
        LAST_MONTH,
        LAST_MONTH_MORE,
        NEXT_MONTH,
        NEXT_MONTH_MORE,
        LAST_YEAR,
        LAST_YEAR_MORE,
        NEXT_YEAR,
        NEXT_YEAR_MORE
    }

    /* loaded from: classes13.dex */
    public enum TimeQuantum {
        WEE_HOURS,
        FORENOON,
        NOONING,
        AFTERNOON,
        NIGHT
    }

    private DateFormatUtils() {
        throw new AssertionError();
    }

    public static Date addDate(long j, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j + (i * 86400000));
        return calendar.getTime();
    }

    private static TimeName compareDay(int i) {
        if (i == 0) {
            return TimeName.TODAY;
        }
        if (i == -1) {
            return TimeName.YESTERDAY;
        }
        if (i == -2) {
            return TimeName.THE_DAY_BEFORE_YESTERDAY;
        }
        if (i < -2) {
            return TimeName.THE_DAY_BEFORE_YESTERDAY_MORE;
        }
        if (i == 1) {
            return TimeName.TOMORROW;
        }
        if (i == 2) {
            return TimeName.THE_DAY_AFTER_TOMORROW;
        }
        return TimeName.THE_DAY_AFTER_TOMORROW_MORE;
    }

    private static TimeName compareMonth(Calendar calendar, Calendar calendar2) {
        int i = calendar.get(2) - calendar2.get(2);
        int i2 = calendar.get(6) - calendar2.get(6);
        if (i == 0) {
            return compareDay(i2);
        }
        if (i == -1) {
            if (i2 >= -3) {
                return compareDay(i2);
            }
            return TimeName.LAST_MONTH;
        }
        if (i <= -2) {
            return TimeName.LAST_MONTH_MORE;
        }
        if (i == 1) {
            if (i2 <= 3) {
                return compareDay(i2);
            }
            return TimeName.NEXT_MONTH;
        }
        return TimeName.NEXT_MONTH_MORE;
    }

    public static TimeName compareTime(long j) {
        return compareTime(j, System.currentTimeMillis());
    }

    public static String format(long j, String str) {
        return new SimpleDateFormat(str, Locale.CHINA).format(new Date(j));
    }

    public static String formatForRecent(long j, HoursFormat hoursFormat) {
        TimeName compareTime = compareTime(j);
        getTimeQuantumName(getTimeQuantum(j));
        if (compareTime == TimeName.TODAY) {
            return "今日";
        }
        if (compareTime == TimeName.YESTERDAY) {
            return "昨日";
        }
        if (compareTime == TimeName.THE_DAY_BEFORE_YESTERDAY) {
            return format(j, MM_DD);
        }
        if (compareTime != TimeName.THE_DAY_BEFORE_YESTERDAY_MORE && compareTime != TimeName.LAST_MONTH && compareTime != TimeName.LAST_MONTH_MORE) {
            if (compareTime != TimeName.LAST_YEAR && compareTime != TimeName.LAST_YEAR_MORE) {
                return format(j, YYYY_MM_DD_HH_MM);
            }
            return format(j, "yyyy-MM-dd");
        }
        return format(j, MM_DD);
    }

    public static int getAge(Date date) throws Exception {
        Calendar calendar = Calendar.getInstance();
        if (!calendar.before(date)) {
            int i = calendar.get(1);
            int i2 = calendar.get(2);
            int i3 = calendar.get(5);
            calendar.setTime(date);
            int i4 = calendar.get(1);
            int i5 = calendar.get(2);
            int i6 = calendar.get(5);
            int i7 = i - i4;
            if (i2 <= i5) {
                if (i2 != i5 || i3 < i6) {
                    return i7 - 1;
                }
                return i7;
            }
            return i7;
        }
        throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
    }

    public static long getCurrentBeiJingTimeInMillis(long j) {
        return getCurrentTimeInMillis(j, TimeZone.getTimeZone("GMT+8"));
    }

    public static long getCurrentTimeInMillis(long j, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(timeZone);
        calendar.setTimeInMillis(j);
        return calendar.getTimeInMillis();
    }

    public static String getDateToString(long j) {
        Date date = new Date(j);
        int intValue = Integer.valueOf(new SimpleDateFormat(YYYY).format(date)).intValue();
        int intValue2 = Integer.valueOf(new SimpleDateFormat("d").format(date)).intValue();
        Date date2 = new Date(System.currentTimeMillis());
        int intValue3 = Integer.valueOf(new SimpleDateFormat(YYYY).format(date2)).intValue();
        int intValue4 = Integer.valueOf(new SimpleDateFormat("d").format(date2)).intValue();
        String str = "昨天";
        String str2 = "";
        if (intValue3 - intValue == 1) {
            if (intValue4 == 1) {
                int i = 366;
                if (intValue % 400 != 0 && (intValue % 4 != 0 || intValue % 100 == 0)) {
                    i = 365;
                }
                if (intValue2 != i) {
                    str = "";
                }
                str2 = str;
            }
        } else {
            int i2 = intValue4 - intValue2;
            if (i2 != 1) {
                str = "";
            }
            if (i2 == 0) {
                str2 = "今天";
            } else {
                str2 = str;
            }
            if (i2 == -1) {
                str2 = "明天";
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return new SimpleDateFormat(YYYY_MM_DD_HH_MM).format(date);
        }
        return str2 + " " + new SimpleDateFormat("HH:mm").format(date);
    }

    public static String getDateToString2(long j) {
        Date date = new Date(j);
        int intValue = Integer.valueOf(new SimpleDateFormat(YYYY).format(date)).intValue();
        int intValue2 = Integer.valueOf(new SimpleDateFormat("d").format(date)).intValue();
        Date date2 = new Date(System.currentTimeMillis());
        int intValue3 = Integer.valueOf(new SimpleDateFormat(YYYY).format(date2)).intValue();
        int intValue4 = Integer.valueOf(new SimpleDateFormat("d").format(date2)).intValue();
        String str = "";
        if (intValue3 - intValue == 1) {
            if (intValue4 == 1) {
                int i = 366;
                if (intValue % 400 != 0 && (intValue % 4 != 0 || intValue % 100 == 0)) {
                    i = 365;
                }
                if (intValue2 == i) {
                    str = "昨天";
                }
            }
        } else if (intValue4 - intValue2 == 0) {
            str = "今天";
        }
        if (TextUtils.isEmpty(str)) {
            return new SimpleDateFormat(YYYY_MM_DD_HH_MM).format(date);
        }
        return new SimpleDateFormat("HH:mm").format(date);
    }

    public static long getEndTimes(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.set(10, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return calendar.getTime().getTime();
    }

    public static long getMillis(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    public static String getMonthAndDay(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.substring(5, str.length()).replaceFirst(HelpFormatter.DEFAULT_OPT_PREFIX, "月") + "日";
    }

    public static String getNearTime(int i) {
        if (i <= 0) {
            return "刚刚";
        }
        if (i < 60) {
            return i + "分钟前";
        }
        if (i < 1440) {
            return (i / 60) + "小时前";
        }
        if (i < 525600) {
            return (i / 1440) + "天前";
        }
        return (i / 525600) + "年前";
    }

    public static long getSecondsFromDate(String str, String str2) {
        if (str != null && !str.trim().equals("")) {
            try {
                return new SimpleDateFormat(str2).parse(str).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    public static String getTime(long j) {
        if (isSameDay(j, System.currentTimeMillis())) {
            return format(j, "HH:mm");
        }
        return format(j, MM_DD_HH_MM);
    }

    public static TimeQuantum getTimeQuantum(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(11);
        if (i >= 0 && i < 6) {
            return TimeQuantum.WEE_HOURS;
        }
        if (i >= 6 && i < 12) {
            return TimeQuantum.FORENOON;
        }
        if (i >= 12 && i < 14) {
            return TimeQuantum.NOONING;
        }
        if (i >= 14 && i < 18) {
            return TimeQuantum.AFTERNOON;
        }
        return TimeQuantum.NIGHT;
    }

    private static String getTimeQuantumName(TimeQuantum timeQuantum) {
        if (timeQuantum == TimeQuantum.WEE_HOURS) {
            return "凌晨";
        }
        if (timeQuantum == TimeQuantum.FORENOON) {
            return "上午";
        }
        if (timeQuantum == TimeQuantum.NOONING) {
            return "中午";
        }
        if (timeQuantum == TimeQuantum.AFTERNOON) {
            return "下午";
        }
        return "晚上";
    }

    public static String getTimeToExploreRecord(long j) {
        int currentTimeMillis = (int) ((System.currentTimeMillis() / 1000) - j);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        Calendar calendar2 = Calendar.getInstance();
        long j2 = j * 1000;
        calendar2.setTimeInMillis(j2);
        int i = calendar2.get(1) - calendar.get(1);
        if (compareTime(j2) == TimeName.TODAY && currentTimeMillis < 86400) {
            return format(j2, "HH:mm");
        }
        if (compareTime(j2) == TimeName.YESTERDAY) {
            return "昨天";
        }
        if (compareTime(j2) == TimeName.THE_DAY_BEFORE_YESTERDAY) {
            return "前天";
        }
        if (i == 0) {
            return format(j2, MM_DD);
        }
        return format(j2, "yyyy-MM-dd");
    }

    public static long getTimesmorning(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.set(11, 0);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static String getWeekFormatOfDate(Date date) {
        return format(date, "yyyy-MM-dd") + " " + format(date, "HH:mm") + " " + getWeekOfDate(date);
    }

    public static String getWeekOfDate(Date date) {
        String[] strArr = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(7) - 1;
        if (i < 0) {
            i = 0;
        }
        return strArr[i];
    }

    public static String getYear(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.substring(0, 4);
    }

    public static boolean isSameDay(long j, long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j2);
        if (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5)) {
            return true;
        }
        return false;
    }

    public static boolean isSameYear(long j, long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j2);
        if (calendar.get(1) == calendar2.get(1)) {
            return true;
        }
        return false;
    }

    public static Date parseDate(String str, String str2) {
        try {
            return new SimpleDateFormat(str2).parse(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String stringForTime(long j) {
        if (j <= 0) {
            return "00:00:00";
        }
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.getDefault());
        long j2 = j % 60;
        long j3 = j / 60;
        long j4 = j3 % 60;
        long j5 = j3 / 60;
        long j6 = j / 3600;
        long j7 = j6 / 24;
        sb.setLength(0);
        return j7 > 0 ? formatter.format("%d天:%02d:%02d:%02d", Long.valueOf(j7), Long.valueOf(j6 % 24), Long.valueOf(j4), Long.valueOf(j2)).toString() : formatter.format("%02d:%02d:%02d", Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j2)).toString();
    }

    public static String timestampToDate(long j, String str) {
        return new SimpleDateFormat(str).format(new Date(j * 1000));
    }

    public static TimeName compareTime(long j, long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j2);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j);
        int i = calendar2.get(1) - calendar.get(1);
        if (i == 0) {
            return compareMonth(calendar2, calendar);
        }
        if (i == -1) {
            if (calendar2.get(2) - (calendar.get(2) + 12) == -1) {
                int i2 = calendar2.get(5) - (calendar.get(5) + 31);
                if (i2 >= -3) {
                    return compareDay(i2);
                }
                return TimeName.LAST_MONTH;
            }
            return TimeName.LAST_YEAR;
        }
        if (i <= -2) {
            return TimeName.LAST_YEAR_MORE;
        }
        if (i == 1) {
            if ((calendar2.get(2) + 12) - calendar.get(2) == 1) {
                int i3 = (calendar2.get(5) + 31) - calendar.get(5);
                if (i3 <= 3) {
                    return compareDay(i3);
                }
                return TimeName.NEXT_MONTH;
            }
            return TimeName.NEXT_YEAR;
        }
        return TimeName.NEXT_YEAR_MORE;
    }

    public static String getWeekFormatOfDate(String str) {
        try {
            Date parse = new SimpleDateFormat(YYYY_MM_DD_HH_MM).parse(str);
            return format(parse, "yyyy-MM-dd") + " " + format(parse, "HH:mm") + " " + getWeekOfDate(parse);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String format(Date date, String str) {
        return new SimpleDateFormat(str).format(date);
    }

    public static String format(long j, HoursFormat hoursFormat) {
        TimeName compareTime = compareTime(j);
        String timeQuantumName = getTimeQuantumName(getTimeQuantum(j));
        if (compareTime == TimeName.TODAY) {
            if (hoursFormat == HoursFormat.H12) {
                return timeQuantumName + format(j, HH_MM_12);
            }
            return format(j, "HH:mm");
        }
        if (compareTime == TimeName.YESTERDAY) {
            return "昨天";
        }
        if (compareTime == TimeName.THE_DAY_BEFORE_YESTERDAY) {
            return "前天";
        }
        if (compareTime != TimeName.THE_DAY_BEFORE_YESTERDAY_MORE && compareTime != TimeName.LAST_MONTH && compareTime != TimeName.LAST_MONTH_MORE) {
            if (compareTime != TimeName.LAST_YEAR && compareTime != TimeName.LAST_YEAR_MORE) {
                return format(j, YYYY_MM_DD_HH_MM);
            }
            return format(j, "yyyy-MM-dd");
        }
        return format(j, MM_DD);
    }

    public static String getNearTime(long j) {
        int currentTimeMillis = (int) ((System.currentTimeMillis() / 1000) - j);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        Calendar calendar2 = Calendar.getInstance();
        long j2 = j * 1000;
        calendar2.setTimeInMillis(j2);
        int i = calendar2.get(1) - calendar.get(1);
        if (currentTimeMillis <= 5) {
            return "刚刚";
        }
        if (currentTimeMillis < 60) {
            return currentTimeMillis + "秒前";
        }
        if (currentTimeMillis < 3600) {
            return (currentTimeMillis / 60) + "分钟前";
        }
        if (compareTime(j2) == TimeName.TODAY && currentTimeMillis < 86400) {
            return (currentTimeMillis / 3600) + "小时前";
        }
        if (compareTime(j2) == TimeName.YESTERDAY) {
            return "昨天";
        }
        if (compareTime(j2) == TimeName.THE_DAY_BEFORE_YESTERDAY) {
            return "前天";
        }
        if (i == 0) {
            return format(j2, MM_DD);
        }
        return format(j2, "yyyy-MM-dd");
    }

    public static String stringForTime(int i) {
        if (i <= 0) {
            return "00:00";
        }
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.getDefault());
        long j = i % 60;
        sb.setLength(0);
        return formatter.format("%02d:%02d", Long.valueOf((i / 60) % 60), Long.valueOf(j)).toString();
    }

    public static String format(long j) {
        switch (AnonymousClass1.$SwitchMap$com$tenmeter$smlibrary$utils$DateFormatUtils$TimeName[compareTime(j).ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return format(j, MM_DD_HH_MM);
            default:
                return format(j, YYYY_MM_DD_HH_MM);
        }
    }
}
