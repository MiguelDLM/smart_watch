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

public class DateCodec extends AbstractDateDeserializer implements ObjectSerializer, ObjectDeserializer {
    public static final DateCodec instance = new DateCodec();

    public <T> T cast(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof Date) {
            return obj2;
        }
        if (obj2 instanceof BigDecimal) {
            return new Date(TypeUtils.longValue((BigDecimal) obj2));
        }
        if (obj2 instanceof Number) {
            return new Date(((Number) obj2).longValue());
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
                Class<Calendar> cls = Calendar.class;
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    T calendar = jSONScanner.getCalendar();
                    if (type == cls) {
                        return calendar;
                    }
                    T time = calendar.getTime();
                    jSONScanner.close();
                    return time;
                }
                jSONScanner.close();
                String dateFomartPattern = defaultJSONParser.getDateFomartPattern();
                if (str.length() == dateFomartPattern.length() || ((str.length() == 22 && dateFomartPattern.equals("yyyyMMddHHmmssSSSZ")) || (str.indexOf(84) != -1 && dateFomartPattern.contains("'T'") && str.length() + 2 == dateFomartPattern.length()))) {
                    try {
                        return defaultJSONParser.getDateFormat().parse(str);
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
                    if (!xoIox.f21897oIX0oI.equals(timeZone.getID())) {
                        JSONScanner jSONScanner2 = new JSONScanner(str.substring(0, lastIndexOf));
                        try {
                            if (jSONScanner2.scanISO8601DateIfMatch(false)) {
                                T calendar2 = jSONScanner2.getCalendar();
                                calendar2.setTimeZone(timeZone);
                                if (type == cls) {
                                    return calendar2;
                                }
                                T time2 = calendar2.getTime();
                                jSONScanner2.close();
                                return time2;
                            }
                            jSONScanner2.close();
                        } finally {
                            jSONScanner2.close();
                        }
                    }
                }
                return new Date(Long.parseLong(str));
            } finally {
                jSONScanner.close();
            }
        } else {
            throw new JSONException("parse error");
        }
    }

    public int getFastMatchToken() {
        return 2;
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        int i2;
        Date date;
        int i3;
        char[] cArr;
        JSONSerializer jSONSerializer2 = jSONSerializer;
        Object obj3 = obj;
        SerializeWriter serializeWriter = jSONSerializer2.out;
        if (obj3 == null) {
            serializeWriter.writeNull();
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls == java.sql.Date.class && !serializeWriter.isEnabled(SerializerFeature.WriteDateUseDateFormat)) {
            long time = ((java.sql.Date) obj3).getTime();
            if ((time + ((long) jSONSerializer2.timeZone.getOffset(time))) % 86400000 == 0) {
                if (!SerializerFeature.isEnabled(serializeWriter.features, i, SerializerFeature.WriteClassName)) {
                    serializeWriter.writeString(obj.toString());
                    return;
                }
            }
        }
        if (cls == Time.class) {
            long time2 = ((Time) obj3).getTime();
            if ("unixtime".equals(jSONSerializer.getDateFormatPattern())) {
                serializeWriter.writeLong(time2 / 1000);
                return;
            } else if ("millis".equals(jSONSerializer.getDateFormatPattern())) {
                serializeWriter.writeLong(time2);
                return;
            } else if (time2 < 86400000) {
                serializeWriter.writeString(obj.toString());
                return;
            }
        }
        if (cls == Timestamp.class) {
            i2 = ((Timestamp) obj3).getNanos();
        } else {
            i2 = 0;
        }
        if (obj3 instanceof Date) {
            date = (Date) obj3;
        } else {
            date = TypeUtils.castToDate(obj);
        }
        if ("unixtime".equals(jSONSerializer.getDateFormatPattern())) {
            serializeWriter.writeLong(date.getTime() / 1000);
        } else if ("millis".equals(jSONSerializer.getDateFormatPattern())) {
            serializeWriter.writeLong(date.getTime());
        } else if (serializeWriter.isEnabled(SerializerFeature.WriteDateUseDateFormat)) {
            DateFormat dateFormat = jSONSerializer.getDateFormat();
            if (dateFormat == null) {
                String fastJsonConfigDateFormatPattern = jSONSerializer.getFastJsonConfigDateFormatPattern();
                if (fastJsonConfigDateFormatPattern == null) {
                    fastJsonConfigDateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(fastJsonConfigDateFormatPattern, jSONSerializer2.locale);
                simpleDateFormat.setTimeZone(jSONSerializer2.timeZone);
                dateFormat = simpleDateFormat;
            }
            serializeWriter.writeString(dateFormat.format(date));
        } else if (!serializeWriter.isEnabled(SerializerFeature.WriteClassName) || cls == type) {
            long time3 = date.getTime();
            if (serializeWriter.isEnabled(SerializerFeature.UseISO8601DateFormat)) {
                if (serializeWriter.isEnabled(SerializerFeature.UseSingleQuotes)) {
                    i3 = 39;
                } else {
                    i3 = 34;
                }
                serializeWriter.write(i3);
                Calendar instance2 = Calendar.getInstance(jSONSerializer2.timeZone, jSONSerializer2.locale);
                instance2.setTimeInMillis(time3);
                int i4 = instance2.get(1);
                int i5 = instance2.get(2) + 1;
                int i6 = instance2.get(5);
                int i7 = instance2.get(11);
                int i8 = instance2.get(12);
                int i9 = instance2.get(13);
                int i10 = instance2.get(14);
                if (i2 > 0) {
                    cArr = "0000-00-00 00:00:00.000000000".toCharArray();
                    IOUtils.getChars(i2, 29, cArr);
                    IOUtils.getChars(i9, 19, cArr);
                    IOUtils.getChars(i8, 16, cArr);
                    IOUtils.getChars(i7, 13, cArr);
                    IOUtils.getChars(i6, 10, cArr);
                    IOUtils.getChars(i5, 7, cArr);
                    IOUtils.getChars(i4, 4, cArr);
                } else if (i10 != 0) {
                    char[] charArray = "0000-00-00T00:00:00.000".toCharArray();
                    IOUtils.getChars(i10, 23, charArray);
                    IOUtils.getChars(i9, 19, charArray);
                    IOUtils.getChars(i8, 16, charArray);
                    IOUtils.getChars(i7, 13, charArray);
                    IOUtils.getChars(i6, 10, charArray);
                    IOUtils.getChars(i5, 7, charArray);
                    IOUtils.getChars(i4, 4, charArray);
                    cArr = charArray;
                } else if (i9 == 0 && i8 == 0 && i7 == 0) {
                    char[] charArray2 = "0000-00-00".toCharArray();
                    IOUtils.getChars(i6, 10, charArray2);
                    IOUtils.getChars(i5, 7, charArray2);
                    IOUtils.getChars(i4, 4, charArray2);
                    cArr = charArray2;
                } else {
                    cArr = "0000-00-00T00:00:00".toCharArray();
                    IOUtils.getChars(i9, 19, cArr);
                    IOUtils.getChars(i8, 16, cArr);
                    IOUtils.getChars(i7, 13, cArr);
                    IOUtils.getChars(i6, 10, cArr);
                    IOUtils.getChars(i5, 7, cArr);
                    IOUtils.getChars(i4, 4, cArr);
                }
                if (i2 > 0) {
                    int i11 = 0;
                    while (i11 < 9 && cArr[(cArr.length - i11) - 1] == '0') {
                        i11++;
                    }
                    serializeWriter.write(cArr, 0, cArr.length - i11);
                    serializeWriter.write(i3);
                    return;
                }
                serializeWriter.write(cArr);
                float offset = ((float) instance2.getTimeZone().getOffset(instance2.getTimeInMillis())) / 3600000.0f;
                int i12 = (int) offset;
                if (((double) i12) == OOXIXo.f29376XO) {
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
                    serializeWriter.append((CharSequence) String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf((int) (Math.abs(offset - ((float) i12)) * 60.0f))}));
                }
                serializeWriter.write(i3);
                return;
            }
            serializeWriter.writeLong(time3);
        } else if (cls == Date.class) {
            serializeWriter.write("new Date(");
            serializeWriter.writeLong(((Date) obj3).getTime());
            serializeWriter.write(41);
        } else {
            serializeWriter.write(123);
            serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
            jSONSerializer2.write(cls.getName());
            serializeWriter.writeFieldValue(',', "val", ((Date) obj3).getTime());
            serializeWriter.write(125);
        }
    }
}
