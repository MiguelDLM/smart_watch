package com.alibaba.fastjson.serializer;

import XIXIX.OOXIXo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import com.google.android.material.timepicker.TimeModel;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.apache.commons.lang3.time.xoIox;

/* loaded from: classes.dex */
public class DateCodec extends AbstractDateDeserializer implements ObjectSerializer, ObjectDeserializer {
    public static final DateCodec instance = new DateCodec();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v19, types: [java.util.Calendar, T] */
    /* JADX WARN: Type inference failed for: r6v25, types: [java.util.Calendar, T] */
    @Override // com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer
    public <T> T cast(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        if (obj2 == 0) {
            return null;
        }
        if (obj2 instanceof Date) {
            return obj2;
        }
        if (obj2 instanceof BigDecimal) {
            return (T) new Date(TypeUtils.longValue((BigDecimal) obj2));
        }
        if (obj2 instanceof Number) {
            return (T) new Date(((Number) obj2).longValue());
        }
        if (obj2 instanceof String) {
            String str = (String) obj2;
            if (str.length() == 0) {
                return null;
            }
            if (str.length() == 23 && str.endsWith(" 000")) {
                str = str.substring(0, 19);
            }
            JSONScanner jSONScanner = new JSONScanner(str);
            try {
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    ?? r6 = (T) jSONScanner.getCalendar();
                    if (type == Calendar.class) {
                        return r6;
                    }
                    return (T) r6.getTime();
                }
                jSONScanner.close();
                String dateFomartPattern = defaultJSONParser.getDateFomartPattern();
                if (str.length() == dateFomartPattern.length() || ((str.length() == 22 && dateFomartPattern.equals("yyyyMMddHHmmssSSSZ")) || (str.indexOf(84) != -1 && dateFomartPattern.contains("'T'") && str.length() + 2 == dateFomartPattern.length()))) {
                    try {
                        return (T) defaultJSONParser.getDateFormat().parse(str);
                    } catch (ParseException unused) {
                    }
                }
                if (str.startsWith("/Date(") && str.endsWith(")/")) {
                    str = str.substring(6, str.length() - 2);
                }
                if ("0000-00-00".equals(str) || "0000-00-00T00:00:00".equalsIgnoreCase(str) || "0001-01-01T00:00:00+08:00".equalsIgnoreCase(str)) {
                    return null;
                }
                int lastIndexOf = str.lastIndexOf(124);
                if (lastIndexOf > 20) {
                    TimeZone timeZone = TimeZone.getTimeZone(str.substring(lastIndexOf + 1));
                    if (!xoIox.f32917oIX0oI.equals(timeZone.getID())) {
                        JSONScanner jSONScanner2 = new JSONScanner(str.substring(0, lastIndexOf));
                        try {
                            if (jSONScanner2.scanISO8601DateIfMatch(false)) {
                                ?? r62 = (T) jSONScanner2.getCalendar();
                                r62.setTimeZone(timeZone);
                                if (type == Calendar.class) {
                                    return r62;
                                }
                                return (T) r62.getTime();
                            }
                        } finally {
                        }
                    }
                }
                return (T) new Date(Long.parseLong(str));
            } finally {
            }
        }
        throw new JSONException("parse error");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        int i2;
        Date castToDate;
        int i3;
        char[] charArray;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls == java.sql.Date.class && !serializeWriter.isEnabled(SerializerFeature.WriteDateUseDateFormat)) {
            if ((((java.sql.Date) obj).getTime() + jSONSerializer.timeZone.getOffset(r9)) % 86400000 == 0 && !SerializerFeature.isEnabled(serializeWriter.features, i, SerializerFeature.WriteClassName)) {
                serializeWriter.writeString(obj.toString());
                return;
            }
        }
        if (cls == Time.class) {
            long time = ((Time) obj).getTime();
            if ("unixtime".equals(jSONSerializer.getDateFormatPattern())) {
                serializeWriter.writeLong(time / 1000);
                return;
            } else if ("millis".equals(jSONSerializer.getDateFormatPattern())) {
                serializeWriter.writeLong(time);
                return;
            } else if (time < 86400000) {
                serializeWriter.writeString(obj.toString());
                return;
            }
        }
        if (cls == Timestamp.class) {
            i2 = ((Timestamp) obj).getNanos();
        } else {
            i2 = 0;
        }
        if (obj instanceof Date) {
            castToDate = (Date) obj;
        } else {
            castToDate = TypeUtils.castToDate(obj);
        }
        if ("unixtime".equals(jSONSerializer.getDateFormatPattern())) {
            serializeWriter.writeLong(castToDate.getTime() / 1000);
            return;
        }
        if ("millis".equals(jSONSerializer.getDateFormatPattern())) {
            serializeWriter.writeLong(castToDate.getTime());
            return;
        }
        if (serializeWriter.isEnabled(SerializerFeature.WriteDateUseDateFormat)) {
            DateFormat dateFormat = jSONSerializer.getDateFormat();
            if (dateFormat == null) {
                String fastJsonConfigDateFormatPattern = jSONSerializer.getFastJsonConfigDateFormatPattern();
                if (fastJsonConfigDateFormatPattern == null) {
                    fastJsonConfigDateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(fastJsonConfigDateFormatPattern, jSONSerializer.locale);
                simpleDateFormat.setTimeZone(jSONSerializer.timeZone);
                dateFormat = simpleDateFormat;
            }
            serializeWriter.writeString(dateFormat.format(castToDate));
            return;
        }
        if (serializeWriter.isEnabled(SerializerFeature.WriteClassName) && cls != type) {
            if (cls == Date.class) {
                serializeWriter.write("new Date(");
                serializeWriter.writeLong(((Date) obj).getTime());
                serializeWriter.write(41);
                return;
            } else {
                serializeWriter.write(123);
                serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
                jSONSerializer.write(cls.getName());
                serializeWriter.writeFieldValue(',', "val", ((Date) obj).getTime());
                serializeWriter.write(125);
                return;
            }
        }
        long time2 = castToDate.getTime();
        if (serializeWriter.isEnabled(SerializerFeature.UseISO8601DateFormat)) {
            if (serializeWriter.isEnabled(SerializerFeature.UseSingleQuotes)) {
                i3 = 39;
            } else {
                i3 = 34;
            }
            serializeWriter.write(i3);
            Calendar calendar = Calendar.getInstance(jSONSerializer.timeZone, jSONSerializer.locale);
            calendar.setTimeInMillis(time2);
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            int i7 = calendar.get(11);
            int i8 = calendar.get(12);
            int i9 = calendar.get(13);
            int i10 = calendar.get(14);
            if (i2 > 0) {
                charArray = "0000-00-00 00:00:00.000000000".toCharArray();
                IOUtils.getChars(i2, 29, charArray);
                IOUtils.getChars(i9, 19, charArray);
                IOUtils.getChars(i8, 16, charArray);
                IOUtils.getChars(i7, 13, charArray);
                IOUtils.getChars(i6, 10, charArray);
                IOUtils.getChars(i5, 7, charArray);
                IOUtils.getChars(i4, 4, charArray);
            } else if (i10 != 0) {
                char[] charArray2 = "0000-00-00T00:00:00.000".toCharArray();
                IOUtils.getChars(i10, 23, charArray2);
                IOUtils.getChars(i9, 19, charArray2);
                IOUtils.getChars(i8, 16, charArray2);
                IOUtils.getChars(i7, 13, charArray2);
                IOUtils.getChars(i6, 10, charArray2);
                IOUtils.getChars(i5, 7, charArray2);
                IOUtils.getChars(i4, 4, charArray2);
                charArray = charArray2;
            } else if (i9 == 0 && i8 == 0 && i7 == 0) {
                char[] charArray3 = "0000-00-00".toCharArray();
                IOUtils.getChars(i6, 10, charArray3);
                IOUtils.getChars(i5, 7, charArray3);
                IOUtils.getChars(i4, 4, charArray3);
                charArray = charArray3;
            } else {
                charArray = "0000-00-00T00:00:00".toCharArray();
                IOUtils.getChars(i9, 19, charArray);
                IOUtils.getChars(i8, 16, charArray);
                IOUtils.getChars(i7, 13, charArray);
                IOUtils.getChars(i6, 10, charArray);
                IOUtils.getChars(i5, 7, charArray);
                IOUtils.getChars(i4, 4, charArray);
            }
            if (i2 > 0) {
                int i11 = 0;
                while (i11 < 9 && charArray[(charArray.length - i11) - 1] == '0') {
                    i11++;
                }
                serializeWriter.write(charArray, 0, charArray.length - i11);
                serializeWriter.write(i3);
                return;
            }
            serializeWriter.write(charArray);
            float offset = calendar.getTimeZone().getOffset(calendar.getTimeInMillis()) / 3600000.0f;
            int i12 = (int) offset;
            if (i12 == OOXIXo.f3760XO) {
                serializeWriter.write(90);
            } else {
                if (i12 > 9) {
                    serializeWriter.write(43);
                    serializeWriter.writeInt(i12);
                } else if (i12 > 0) {
                    serializeWriter.write(43);
                    serializeWriter.write(48);
                    serializeWriter.writeInt(i12);
                } else if (i12 < -9) {
                    serializeWriter.write(45);
                    serializeWriter.writeInt(-i12);
                } else if (i12 < 0) {
                    serializeWriter.write(45);
                    serializeWriter.write(48);
                    serializeWriter.writeInt(-i12);
                }
                serializeWriter.write(58);
                serializeWriter.append((CharSequence) String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf((int) (Math.abs(offset - i12) * 60.0f))));
            }
            serializeWriter.write(i3);
            return;
        }
        serializeWriter.writeLong(time2);
    }
}
