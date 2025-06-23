package org.apache.log4j.helpers;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes6.dex */
public class DateTimeDateFormat extends AbsoluteTimeDateFormat {
    String[] shortMonths;

    public DateTimeDateFormat() {
        this.shortMonths = new DateFormatSymbols().getShortMonths();
    }

    @Override // org.apache.log4j.helpers.AbsoluteTimeDateFormat, java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        ((DateFormat) this).calendar.setTime(date);
        int i = ((DateFormat) this).calendar.get(5);
        if (i < 10) {
            stringBuffer.append('0');
        }
        stringBuffer.append(i);
        stringBuffer.append(TokenParser.SP);
        stringBuffer.append(this.shortMonths[((DateFormat) this).calendar.get(2)]);
        stringBuffer.append(TokenParser.SP);
        stringBuffer.append(((DateFormat) this).calendar.get(1));
        stringBuffer.append(TokenParser.SP);
        return super.format(date, stringBuffer, fieldPosition);
    }

    @Override // org.apache.log4j.helpers.AbsoluteTimeDateFormat, java.text.DateFormat
    public Date parse(String str, ParsePosition parsePosition) {
        return null;
    }

    public DateTimeDateFormat(TimeZone timeZone) {
        this();
        setCalendar(Calendar.getInstance(timeZone));
    }
}
