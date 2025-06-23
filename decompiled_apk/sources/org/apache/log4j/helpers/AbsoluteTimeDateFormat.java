package org.apache.log4j.helpers;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes6.dex */
public class AbsoluteTimeDateFormat extends DateFormat {
    public static final String ABS_TIME_DATE_FORMAT = "ABSOLUTE";
    public static final String DATE_AND_TIME_DATE_FORMAT = "DATE";
    public static final String ISO8601_DATE_FORMAT = "ISO8601";
    private static long previousTime;
    private static char[] previousTimeWithoutMillis = new char[9];

    public AbsoluteTimeDateFormat() {
        setCalendar(Calendar.getInstance());
    }

    @Override // java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        long time = date.getTime();
        int i = (int) (time % 1000);
        long j = time - i;
        if (j != previousTime) {
            ((DateFormat) this).calendar.setTime(date);
            int length = stringBuffer.length();
            int i2 = ((DateFormat) this).calendar.get(11);
            if (i2 < 10) {
                stringBuffer.append('0');
            }
            stringBuffer.append(i2);
            stringBuffer.append(':');
            int i3 = ((DateFormat) this).calendar.get(12);
            if (i3 < 10) {
                stringBuffer.append('0');
            }
            stringBuffer.append(i3);
            stringBuffer.append(':');
            int i4 = ((DateFormat) this).calendar.get(13);
            if (i4 < 10) {
                stringBuffer.append('0');
            }
            stringBuffer.append(i4);
            stringBuffer.append(',');
            stringBuffer.getChars(length, stringBuffer.length(), previousTimeWithoutMillis, 0);
            previousTime = j;
        } else {
            stringBuffer.append(previousTimeWithoutMillis);
        }
        if (i < 100) {
            stringBuffer.append('0');
        }
        if (i < 10) {
            stringBuffer.append('0');
        }
        stringBuffer.append(i);
        return stringBuffer;
    }

    @Override // java.text.DateFormat
    public Date parse(String str, ParsePosition parsePosition) {
        return null;
    }

    public AbsoluteTimeDateFormat(TimeZone timeZone) {
        setCalendar(Calendar.getInstance(timeZone));
    }
}
