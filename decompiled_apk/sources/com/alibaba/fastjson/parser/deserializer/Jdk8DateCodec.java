package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.ContextObjectSerializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAmount;
import java.util.Locale;
import java.util.TimeZone;
import okhttp3.internal.connection.RealConnection;

/* loaded from: classes.dex */
public class Jdk8DateCodec extends ContextObjectDeserializer implements ObjectSerializer, ContextObjectSerializer, ObjectDeserializer {
    private static final DateTimeFormatter ISO_FIXED_FORMAT;
    private static final DateTimeFormatter defaultFormatter;
    private static final DateTimeFormatter defaultFormatter_23;
    private static final String defaultPatttern = "yyyy-MM-dd HH:mm:ss";
    private static final DateTimeFormatter formatter_d10_cn;
    private static final DateTimeFormatter formatter_d10_de;
    private static final DateTimeFormatter formatter_d10_eur;
    private static final DateTimeFormatter formatter_d10_in;
    private static final DateTimeFormatter formatter_d10_kr;
    private static final DateTimeFormatter formatter_d10_tw;
    private static final DateTimeFormatter formatter_d10_us;
    private static final DateTimeFormatter formatter_d8;
    private static final DateTimeFormatter formatter_dt19_cn;
    private static final DateTimeFormatter formatter_dt19_cn_1;
    private static final DateTimeFormatter formatter_dt19_de;
    private static final DateTimeFormatter formatter_dt19_eur;
    private static final DateTimeFormatter formatter_dt19_in;
    private static final DateTimeFormatter formatter_dt19_kr;
    private static final DateTimeFormatter formatter_dt19_tw;
    private static final DateTimeFormatter formatter_dt19_us;
    private static final DateTimeFormatter formatter_iso8601;
    private static final String formatter_iso8601_pattern = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String formatter_iso8601_pattern_23 = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    private static final String formatter_iso8601_pattern_29 = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS";
    public static final Jdk8DateCodec instance = new Jdk8DateCodec();

    static {
        DateTimeFormatter ofPattern;
        DateTimeFormatter ofPattern2;
        DateTimeFormatter ofPattern3;
        DateTimeFormatter ofPattern4;
        DateTimeFormatter ofPattern5;
        DateTimeFormatter ofPattern6;
        DateTimeFormatter ofPattern7;
        DateTimeFormatter ofPattern8;
        DateTimeFormatter ofPattern9;
        DateTimeFormatter ofPattern10;
        DateTimeFormatter ofPattern11;
        DateTimeFormatter ofPattern12;
        DateTimeFormatter ofPattern13;
        DateTimeFormatter ofPattern14;
        DateTimeFormatter ofPattern15;
        DateTimeFormatter ofPattern16;
        DateTimeFormatter ofPattern17;
        DateTimeFormatter ofPattern18;
        DateTimeFormatter ofPattern19;
        ZoneId systemDefault;
        DateTimeFormatter withZone;
        DateTimeFormatter ofPattern20;
        ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        defaultFormatter = ofPattern;
        ofPattern2 = DateTimeFormatter.ofPattern(DateFormatUtils.YYYY_MM_DD_HH_MM_SS_SSS);
        defaultFormatter_23 = ofPattern2;
        ofPattern3 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        formatter_dt19_tw = ofPattern3;
        ofPattern4 = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm:ss");
        formatter_dt19_cn = ofPattern4;
        ofPattern5 = DateTimeFormatter.ofPattern("yyyy年M月d日 H时m分s秒");
        formatter_dt19_cn_1 = ofPattern5;
        ofPattern6 = DateTimeFormatter.ofPattern("yyyy년M월d일 HH:mm:ss");
        formatter_dt19_kr = ofPattern6;
        ofPattern7 = DateTimeFormatter.ofPattern(com.sma.smartv3.util.xoIox.f24685IXxxXO);
        formatter_dt19_us = ofPattern7;
        ofPattern8 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        formatter_dt19_eur = ofPattern8;
        ofPattern9 = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        formatter_dt19_de = ofPattern9;
        ofPattern10 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        formatter_dt19_in = ofPattern10;
        ofPattern11 = DateTimeFormatter.ofPattern("yyyyMMdd");
        formatter_d8 = ofPattern11;
        ofPattern12 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        formatter_d10_tw = ofPattern12;
        ofPattern13 = DateTimeFormatter.ofPattern("yyyy年M月d日");
        formatter_d10_cn = ofPattern13;
        ofPattern14 = DateTimeFormatter.ofPattern("yyyy년M월d일");
        formatter_d10_kr = ofPattern14;
        ofPattern15 = DateTimeFormatter.ofPattern(com.sma.smartv3.util.xoIox.f24693OxxIIOOXO);
        formatter_d10_us = ofPattern15;
        ofPattern16 = DateTimeFormatter.ofPattern(com.sma.smartv3.util.xoIox.f24683IIXOooo);
        formatter_d10_eur = ofPattern16;
        ofPattern17 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        formatter_d10_de = ofPattern17;
        ofPattern18 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        formatter_d10_in = ofPattern18;
        ofPattern19 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        systemDefault = ZoneId.systemDefault();
        withZone = ofPattern19.withZone(systemDefault);
        ISO_FIXED_FORMAT = withZone;
        ofPattern20 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        formatter_iso8601 = ofPattern20;
    }

    public static Object castToLocalDateTime(Object obj, String str) {
        DateTimeFormatter ofPattern;
        LocalDateTime parse;
        if (obj == null) {
            return null;
        }
        if (str == null) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        ofPattern = DateTimeFormatter.ofPattern(str);
        parse = LocalDateTime.parse(obj.toString(), ofPattern);
        return parse;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, String str, int i) {
        Long l;
        Instant ofEpochMilli;
        ZoneId zoneId;
        Instant ofEpochMilli2;
        ZoneId zoneId2;
        LocalDateTime ofInstant;
        Instant ofEpochMilli3;
        ZoneId zoneId3;
        LocalDateTime ofInstant2;
        Instant ofEpochMilli4;
        ZoneId zoneId4;
        DateTimeFormatter dateTimeFormatter;
        Instant instant;
        ZoneId zoneId5;
        Instant ofEpochMilli5;
        ZoneId zoneId6;
        LocalDateTime ofInstant3;
        LocalDateTime parse;
        int hour;
        int minute;
        int second;
        int nano;
        LocalDateTime parse2;
        int year;
        int monthValue;
        int dayOfMonth;
        LocalTime localTime;
        TemporalAmount ofSeconds;
        Object ofEpochSecond;
        Object ofEpochSecond2;
        ChronoLocalDateTime of;
        Object ofEpochMilli6;
        ChronoZonedDateTime ofInstant4;
        Object localTime2;
        ChronoLocalDate localDate;
        ChronoLocalDateTime ofInstant5;
        Object ofEpochMilli7;
        Object parse3;
        TemporalAmount parse4;
        TemporalAmount parse5;
        Object of2;
        Object parse6;
        Object parse7;
        ChronoZonedDateTime ofInstant6;
        Object localTime3;
        Object parse8;
        Object of3;
        ChronoLocalDate of4;
        ChronoLocalDateTime of5;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (jSONLexer.token() == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken();
            if (str != null) {
                if (!"yyyy-MM-dd HH:mm:ss".equals(str)) {
                    dateTimeFormatter = DateTimeFormatter.ofPattern(str);
                } else {
                    dateTimeFormatter = defaultFormatter;
                }
            } else {
                dateTimeFormatter = null;
            }
            if ("".equals(stringVal)) {
                return null;
            }
            if (type == X0o0xo.oIX0oI()) {
                if (stringVal.length() != 10 && stringVal.length() != 8) {
                    return (T) parseDateTime(stringVal, dateTimeFormatter);
                }
                LocalDate parseLocalDate = parseLocalDate(stringVal, str, dateTimeFormatter);
                localTime = LocalTime.MIN;
                of5 = LocalDateTime.of(parseLocalDate, localTime);
                return (T) of5;
            }
            if (type == oxxXoxO.oIX0oI()) {
                if (stringVal.length() == 23) {
                    parse2 = LocalDateTime.parse(stringVal);
                    year = parse2.getYear();
                    monthValue = parse2.getMonthValue();
                    dayOfMonth = parse2.getDayOfMonth();
                    of4 = LocalDate.of(year, monthValue, dayOfMonth);
                    return (T) of4;
                }
                return (T) parseLocalDate(stringVal, str, dateTimeFormatter);
            }
            int i2 = 0;
            if (type == IIXOooo.oIX0oI()) {
                if (stringVal.length() == 23) {
                    parse = LocalDateTime.parse(stringVal);
                    hour = parse.getHour();
                    minute = parse.getMinute();
                    second = parse.getSecond();
                    nano = parse.getNano();
                    of3 = LocalTime.of(hour, minute, second, nano);
                    return (T) of3;
                }
                while (true) {
                    if (i2 < stringVal.length()) {
                        char charAt = stringVal.charAt(i2);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i2++;
                    } else if (stringVal.length() > 8 && stringVal.length() < 19) {
                        ofEpochMilli5 = Instant.ofEpochMilli(Long.parseLong(stringVal));
                        zoneId6 = JSON.defaultTimeZone.toZoneId();
                        ofInstant3 = LocalDateTime.ofInstant(ofEpochMilli5, zoneId6);
                        localTime3 = ofInstant3.toLocalTime();
                        return (T) localTime3;
                    }
                }
                parse8 = LocalTime.parse(stringVal);
                return (T) parse8;
            }
            if (type == xxX.oIX0oI()) {
                if (dateTimeFormatter == defaultFormatter) {
                    dateTimeFormatter = ISO_FIXED_FORMAT;
                }
                if (dateTimeFormatter == null && stringVal.length() <= 19) {
                    JSONScanner jSONScanner = new JSONScanner(stringVal);
                    TimeZone timeZone = defaultJSONParser.lexer.getTimeZone();
                    jSONScanner.setTimeZone(timeZone);
                    if (jSONScanner.scanISO8601DateIfMatch(false)) {
                        instant = jSONScanner.getCalendar().getTime().toInstant();
                        zoneId5 = timeZone.toZoneId();
                        ofInstant6 = ZonedDateTime.ofInstant(instant, zoneId5);
                        return (T) ofInstant6;
                    }
                }
                return (T) parseZonedDateTime(stringVal, dateTimeFormatter);
            }
            if (type == xXxxox0I.oIX0oI()) {
                parse7 = OffsetDateTime.parse(stringVal);
                return (T) parse7;
            }
            if (type == ooXIXxIX.oIX0oI()) {
                parse6 = OffsetTime.parse(stringVal);
                return (T) parse6;
            }
            if (type == oOXoIIIo.oIX0oI()) {
                of2 = ZoneId.of(stringVal);
                return (T) of2;
            }
            if (type == X00IoxXI.oIX0oI()) {
                parse5 = Period.parse(stringVal);
                return (T) parse5;
            }
            if (type == xII.oIX0oI()) {
                parse4 = Duration.parse(stringVal);
                return (T) parse4;
            }
            if (type == XOxIOxOx.oIX0oI()) {
                while (true) {
                    if (i2 < stringVal.length()) {
                        char charAt2 = stringVal.charAt(i2);
                        if (charAt2 < '0' || charAt2 > '9') {
                            break;
                        }
                        i2++;
                    } else if (stringVal.length() > 8 && stringVal.length() < 19) {
                        ofEpochMilli7 = Instant.ofEpochMilli(Long.parseLong(stringVal));
                        return (T) ofEpochMilli7;
                    }
                }
                parse3 = Instant.parse(stringVal);
                return (T) parse3;
            }
        } else {
            if (jSONLexer.token() == 2) {
                long longValue = jSONLexer.longValue();
                jSONLexer.nextToken();
                if ("unixtime".equals(str)) {
                    longValue *= 1000;
                } else if ("yyyyMMddHHmmss".equals(str)) {
                    int i3 = (int) (longValue / RealConnection.IDLE_CONNECTION_HEALTHY_NS);
                    int i4 = (int) ((longValue / 100000000) % 100);
                    int i5 = (int) ((longValue / 1000000) % 100);
                    int i6 = (int) ((longValue / 10000) % 100);
                    int i7 = (int) ((longValue / 100) % 100);
                    int i8 = (int) (longValue % 100);
                    if (type == X0o0xo.oIX0oI()) {
                        of = LocalDateTime.of(i3, i4, i5, i6, i7, i8);
                        return (T) of;
                    }
                }
                if (type == X0o0xo.oIX0oI()) {
                    ofEpochMilli4 = Instant.ofEpochMilli(longValue);
                    zoneId4 = JSON.defaultTimeZone.toZoneId();
                    ofInstant5 = LocalDateTime.ofInstant(ofEpochMilli4, zoneId4);
                    return (T) ofInstant5;
                }
                if (type == oxxXoxO.oIX0oI()) {
                    ofEpochMilli3 = Instant.ofEpochMilli(longValue);
                    zoneId3 = JSON.defaultTimeZone.toZoneId();
                    ofInstant2 = LocalDateTime.ofInstant(ofEpochMilli3, zoneId3);
                    localDate = ofInstant2.toLocalDate();
                    return (T) localDate;
                }
                if (type == IIXOooo.oIX0oI()) {
                    ofEpochMilli2 = Instant.ofEpochMilli(longValue);
                    zoneId2 = JSON.defaultTimeZone.toZoneId();
                    ofInstant = LocalDateTime.ofInstant(ofEpochMilli2, zoneId2);
                    localTime2 = ofInstant.toLocalTime();
                    return (T) localTime2;
                }
                if (type == xxX.oIX0oI()) {
                    ofEpochMilli = Instant.ofEpochMilli(longValue);
                    zoneId = JSON.defaultTimeZone.toZoneId();
                    ofInstant4 = ZonedDateTime.ofInstant(ofEpochMilli, zoneId);
                    return (T) ofInstant4;
                }
                if (type == XOxIOxOx.oIX0oI()) {
                    ofEpochMilli6 = Instant.ofEpochMilli(longValue);
                    return (T) ofEpochMilli6;
                }
                throw new UnsupportedOperationException();
            }
            if (jSONLexer.token() == 12) {
                JSONObject parseObject = defaultJSONParser.parseObject();
                if (type == XOxIOxOx.oIX0oI()) {
                    Object obj2 = parseObject.get("epochSecond");
                    Object obj3 = parseObject.get("nano");
                    boolean z = obj2 instanceof Number;
                    if (z && (obj3 instanceof Number)) {
                        ofEpochSecond2 = Instant.ofEpochSecond(TypeUtils.longExtractValue((Number) obj2), TypeUtils.longExtractValue((Number) obj3));
                        return (T) ofEpochSecond2;
                    }
                    if (z) {
                        ofEpochSecond = Instant.ofEpochSecond(TypeUtils.longExtractValue((Number) obj2));
                        return (T) ofEpochSecond;
                    }
                } else if (type == xII.oIX0oI() && (l = parseObject.getLong("seconds")) != null) {
                    ofSeconds = Duration.ofSeconds(l.longValue(), parseObject.getLongValue("nano"));
                    return (T) ofSeconds;
                }
            } else {
                throw new UnsupportedOperationException();
            }
        }
        return null;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.time.LocalDateTime parseDateTime(java.lang.String r17, java.time.format.DateTimeFormatter r18) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec.parseDateTime(java.lang.String, java.time.format.DateTimeFormatter):java.time.LocalDateTime");
    }

    public LocalDate parseLocalDate(String str, String str2, DateTimeFormatter dateTimeFormatter) {
        LocalDate parse;
        LocalDate parse2;
        Instant ofEpochMilli;
        ZoneId zoneId;
        LocalDateTime ofInstant;
        LocalDate localDate;
        DateTimeFormatter dateTimeFormatter2;
        DateTimeFormatter dateTimeFormatter3;
        if (dateTimeFormatter == null) {
            if (str.length() == 8) {
                dateTimeFormatter = formatter_d8;
            }
            int i = 0;
            if (str.length() == 10) {
                char charAt = str.charAt(4);
                char charAt2 = str.charAt(7);
                if (charAt == '/' && charAt2 == '/') {
                    dateTimeFormatter = formatter_d10_tw;
                }
                char charAt3 = str.charAt(0);
                char charAt4 = str.charAt(1);
                char charAt5 = str.charAt(2);
                char charAt6 = str.charAt(3);
                char charAt7 = str.charAt(5);
                if (charAt5 == '/' && charAt7 == '/') {
                    int i2 = ((charAt6 - '0') * 10) + (charAt - '0');
                    if (((charAt3 - '0') * 10) + (charAt4 - '0') > 12) {
                        dateTimeFormatter3 = formatter_d10_eur;
                    } else if (i2 > 12) {
                        dateTimeFormatter3 = formatter_d10_us;
                    } else {
                        String country = Locale.getDefault().getCountry();
                        if (country.equals("US")) {
                            dateTimeFormatter3 = formatter_d10_us;
                        } else if (country.equals("BR") || country.equals("AU")) {
                            dateTimeFormatter3 = formatter_d10_eur;
                        }
                    }
                    dateTimeFormatter = dateTimeFormatter3;
                } else if (charAt5 == '.' && charAt7 == '.') {
                    dateTimeFormatter = formatter_d10_de;
                } else if (charAt5 == '-' && charAt7 == '-') {
                    dateTimeFormatter = formatter_d10_in;
                }
            }
            if (str.length() >= 9) {
                char charAt8 = str.charAt(4);
                if (charAt8 == 24180) {
                    dateTimeFormatter2 = formatter_d10_cn;
                } else if (charAt8 == 45380) {
                    dateTimeFormatter2 = formatter_d10_kr;
                }
                dateTimeFormatter = dateTimeFormatter2;
            }
            while (true) {
                if (i < str.length()) {
                    char charAt9 = str.charAt(i);
                    if (charAt9 < '0' || charAt9 > '9') {
                        break;
                    }
                    i++;
                } else if (str.length() > 8 && str.length() < 19) {
                    ofEpochMilli = Instant.ofEpochMilli(Long.parseLong(str));
                    zoneId = JSON.defaultTimeZone.toZoneId();
                    ofInstant = LocalDateTime.ofInstant(ofEpochMilli, zoneId);
                    localDate = ofInstant.toLocalDate();
                    return localDate;
                }
            }
        }
        if (dateTimeFormatter == null) {
            parse2 = LocalDate.parse(str);
            return parse2;
        }
        parse = LocalDate.parse(str, dateTimeFormatter);
        return parse;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.time.ZonedDateTime parseZonedDateTime(java.lang.String r16, java.time.format.DateTimeFormatter r17) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec.parseZonedDateTime(java.lang.String, java.time.format.DateTimeFormatter):java.time.ZonedDateTime");
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        ZoneId zoneId;
        ZonedDateTime atZone;
        long epochMilli;
        int nano;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        if (type == null) {
            type = obj.getClass();
        }
        if (type == X0o0xo.oIX0oI()) {
            SerializerFeature serializerFeature = SerializerFeature.UseISO8601DateFormat;
            int mask = serializerFeature.getMask();
            LocalDateTime oIX0oI2 = XO.oIX0oI(obj);
            String dateFormatPattern = jSONSerializer.getDateFormatPattern();
            if (dateFormatPattern == null) {
                dateFormatPattern = "yyyy-MM-dd'T'HH:mm:ss";
                if ((i & mask) == 0 && !jSONSerializer.isEnabled(serializerFeature)) {
                    if (!jSONSerializer.isEnabled(SerializerFeature.WriteDateUseDateFormat)) {
                        nano = oIX0oI2.getNano();
                        if (nano != 0) {
                            dateFormatPattern = nano % 1000000 == 0 ? formatter_iso8601_pattern_23 : formatter_iso8601_pattern_29;
                        }
                    } else {
                        dateFormatPattern = (jSONSerializer.getFastJsonConfigDateFormatPattern() == null || jSONSerializer.getFastJsonConfigDateFormatPattern().length() <= 0) ? JSON.DEFFAULT_DATE_FORMAT : jSONSerializer.getFastJsonConfigDateFormatPattern();
                    }
                }
            }
            if (dateFormatPattern == null) {
                zoneId = JSON.defaultTimeZone.toZoneId();
                atZone = oIX0oI2.atZone(zoneId);
                epochMilli = atZone.toInstant().toEpochMilli();
                serializeWriter.writeLong(epochMilli);
                return;
            }
            write(serializeWriter, oIX0oI2, dateFormatPattern);
            return;
        }
        serializeWriter.writeString(obj.toString());
    }

    @Override // com.alibaba.fastjson.serializer.ContextObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, BeanContext beanContext) throws IOException {
        write(jSONSerializer.out, xoIox.oIX0oI(obj), beanContext.getFormat());
    }

    private void write(SerializeWriter serializeWriter, TemporalAccessor temporalAccessor, String str) {
        DateTimeFormatter ofPattern;
        String format;
        Instant instant;
        ZoneId zoneId;
        ZonedDateTime atZone;
        long epochMilli;
        ZoneId zoneId2;
        ZonedDateTime atZone2;
        long epochSecond;
        if ("unixtime".equals(str)) {
            if (OOXIXo.oIX0oI(temporalAccessor)) {
                epochSecond = oO.oIX0oI(temporalAccessor).toEpochSecond();
                serializeWriter.writeInt((int) epochSecond);
                return;
            } else if (ooOOo0oXI.oIX0oI(temporalAccessor)) {
                LocalDateTime oIX0oI2 = XO.oIX0oI(temporalAccessor);
                zoneId2 = JSON.defaultTimeZone.toZoneId();
                atZone2 = oIX0oI2.atZone(zoneId2);
                serializeWriter.writeInt((int) atZone2.toEpochSecond());
                return;
            }
        }
        if ("millis".equals(str)) {
            if (OOXIXo.oIX0oI(temporalAccessor)) {
                instant = oO.oIX0oI(temporalAccessor).toInstant();
            } else if (ooOOo0oXI.oIX0oI(temporalAccessor)) {
                LocalDateTime oIX0oI3 = XO.oIX0oI(temporalAccessor);
                zoneId = JSON.defaultTimeZone.toZoneId();
                atZone = oIX0oI3.atZone(zoneId);
                instant = atZone.toInstant();
            } else {
                instant = null;
            }
            if (instant != null) {
                epochMilli = instant.toEpochMilli();
                serializeWriter.writeLong(epochMilli);
                return;
            }
        }
        if (str != "yyyy-MM-dd'T'HH:mm:ss") {
            ofPattern = DateTimeFormatter.ofPattern(str);
        } else {
            ofPattern = formatter_iso8601;
        }
        format = ofPattern.format(temporalAccessor);
        serializeWriter.writeString(format);
    }
}
