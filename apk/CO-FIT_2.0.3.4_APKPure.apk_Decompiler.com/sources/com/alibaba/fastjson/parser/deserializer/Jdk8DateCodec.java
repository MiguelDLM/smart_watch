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
import com.sma.smartv3.util.xoIox;
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
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.TimeZone;
import okhttp3.internal.connection.RealConnection;

public class Jdk8DateCodec extends ContextObjectDeserializer implements ObjectSerializer, ContextObjectSerializer, ObjectDeserializer {
    private static final DateTimeFormatter ISO_FIXED_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
    private static final DateTimeFormatter defaultFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter defaultFormatter_23 = DateTimeFormatter.ofPattern(DateFormatUtils.YYYY_MM_DD_HH_MM_SS_SSS);
    private static final String defaultPatttern = "yyyy-MM-dd HH:mm:ss";
    private static final DateTimeFormatter formatter_d10_cn = DateTimeFormatter.ofPattern("yyyy年M月d日");
    private static final DateTimeFormatter formatter_d10_de = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final DateTimeFormatter formatter_d10_eur = DateTimeFormatter.ofPattern(xoIox.f10968IIXOooo);
    private static final DateTimeFormatter formatter_d10_in = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter formatter_d10_kr = DateTimeFormatter.ofPattern("yyyy년M월d일");
    private static final DateTimeFormatter formatter_d10_tw = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private static final DateTimeFormatter formatter_d10_us = DateTimeFormatter.ofPattern(xoIox.f10978OxxIIOOXO);
    private static final DateTimeFormatter formatter_d8 = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final DateTimeFormatter formatter_dt19_cn = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_cn_1 = DateTimeFormatter.ofPattern("yyyy年M月d日 H时m分s秒");
    private static final DateTimeFormatter formatter_dt19_de = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_eur = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_in = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_kr = DateTimeFormatter.ofPattern("yyyy년M월d일 HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_tw = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_us = DateTimeFormatter.ofPattern(xoIox.f10970IXxxXO);
    private static final DateTimeFormatter formatter_iso8601 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    private static final String formatter_iso8601_pattern = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String formatter_iso8601_pattern_23 = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    private static final String formatter_iso8601_pattern_29 = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS";
    public static final Jdk8DateCodec instance = new Jdk8DateCodec();

    public static Object castToLocalDateTime(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        if (str == null) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        return LocalDateTime.parse(obj.toString(), DateTimeFormatter.ofPattern(str));
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, String str, int i) {
        Long l;
        DateTimeFormatter dateTimeFormatter;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (jSONLexer.token() == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken();
            if (str == null) {
                dateTimeFormatter = null;
            } else if ("yyyy-MM-dd HH:mm:ss".equals(str)) {
                dateTimeFormatter = defaultFormatter;
            } else {
                dateTimeFormatter = DateTimeFormatter.ofPattern(str);
            }
            if ("".equals(stringVal)) {
                return null;
            }
            if (type == X0o0xo.oIX0oI()) {
                if (stringVal.length() == 10 || stringVal.length() == 8) {
                    return LocalDateTime.of(parseLocalDate(stringVal, str, dateTimeFormatter), LocalTime.MIN);
                }
                return parseDateTime(stringVal, dateTimeFormatter);
            } else if (type != oxxXoxO.oIX0oI()) {
                int i2 = 0;
                if (type == IIXOooo.oIX0oI()) {
                    if (stringVal.length() == 23) {
                        LocalDateTime oIX0oI2 = LocalDateTime.parse(stringVal);
                        return LocalTime.of(oIX0oI2.getHour(), oIX0oI2.getMinute(), oIX0oI2.getSecond(), oIX0oI2.getNano());
                    }
                    while (true) {
                        if (i2 < stringVal.length()) {
                            char charAt = stringVal.charAt(i2);
                            if (charAt < '0' || charAt > '9') {
                                break;
                            }
                            i2++;
                        } else if (stringVal.length() > 8 && stringVal.length() < 19) {
                            return LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(stringVal)), JSON.defaultTimeZone.toZoneId()).toLocalTime();
                        }
                    }
                    return LocalTime.parse(stringVal);
                } else if (type == xxX.oIX0oI()) {
                    if (dateTimeFormatter == defaultFormatter) {
                        dateTimeFormatter = ISO_FIXED_FORMAT;
                    }
                    if (dateTimeFormatter == null && stringVal.length() <= 19) {
                        JSONScanner jSONScanner = new JSONScanner(stringVal);
                        TimeZone timeZone = defaultJSONParser.lexer.getTimeZone();
                        jSONScanner.setTimeZone(timeZone);
                        if (jSONScanner.scanISO8601DateIfMatch(false)) {
                            return ZonedDateTime.ofInstant(jSONScanner.getCalendar().getTime().toInstant(), timeZone.toZoneId());
                        }
                    }
                    return parseZonedDateTime(stringVal, dateTimeFormatter);
                } else if (type == xXxxox0I.oIX0oI()) {
                    return OffsetDateTime.parse(stringVal);
                } else {
                    if (type == ooXIXxIX.oIX0oI()) {
                        return OffsetTime.parse(stringVal);
                    }
                    if (type == oOXoIIIo.oIX0oI()) {
                        return ZoneId.of(stringVal);
                    }
                    if (type == X00IoxXI.oIX0oI()) {
                        return Period.parse(stringVal);
                    }
                    if (type == xII.oIX0oI()) {
                        return Duration.parse(stringVal);
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
                                return Instant.ofEpochMilli(Long.parseLong(stringVal));
                            }
                        }
                        return Instant.parse(stringVal);
                    }
                }
            } else if (stringVal.length() != 23) {
                return parseLocalDate(stringVal, str, dateTimeFormatter);
            } else {
                LocalDateTime oIX0oI3 = LocalDateTime.parse(stringVal);
                return LocalDate.of(oIX0oI3.getYear(), oIX0oI3.getMonthValue(), oIX0oI3.getDayOfMonth());
            }
        } else if (jSONLexer.token() == 2) {
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
                    return LocalDateTime.of(i3, i4, i5, i6, i7, i8);
                }
            }
            if (type == X0o0xo.oIX0oI()) {
                return LocalDateTime.ofInstant(Instant.ofEpochMilli(longValue), JSON.defaultTimeZone.toZoneId());
            }
            if (type == oxxXoxO.oIX0oI()) {
                return LocalDateTime.ofInstant(Instant.ofEpochMilli(longValue), JSON.defaultTimeZone.toZoneId()).toLocalDate();
            }
            if (type == IIXOooo.oIX0oI()) {
                return LocalDateTime.ofInstant(Instant.ofEpochMilli(longValue), JSON.defaultTimeZone.toZoneId()).toLocalTime();
            }
            if (type == xxX.oIX0oI()) {
                return ZonedDateTime.ofInstant(Instant.ofEpochMilli(longValue), JSON.defaultTimeZone.toZoneId());
            }
            if (type == XOxIOxOx.oIX0oI()) {
                return Instant.ofEpochMilli(longValue);
            }
            throw new UnsupportedOperationException();
        } else if (jSONLexer.token() == 12) {
            JSONObject parseObject = defaultJSONParser.parseObject();
            if (type == XOxIOxOx.oIX0oI()) {
                Object obj2 = parseObject.get("epochSecond");
                Object obj3 = parseObject.get("nano");
                boolean z = obj2 instanceof Number;
                if (z && (obj3 instanceof Number)) {
                    return Instant.ofEpochSecond(TypeUtils.longExtractValue((Number) obj2), TypeUtils.longExtractValue((Number) obj3));
                }
                if (z) {
                    return Instant.ofEpochSecond(TypeUtils.longExtractValue((Number) obj2));
                }
            } else if (type == xII.oIX0oI() && (l = parseObject.getLong("seconds")) != null) {
                return Duration.ofSeconds(l.longValue(), parseObject.getLongValue("nano"));
            }
        } else {
            throw new UnsupportedOperationException();
        }
        return null;
    }

    public int getFastMatchToken() {
        return 4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.time.LocalDateTime parseDateTime(java.lang.String r17, java.time.format.DateTimeFormatter r18) {
        /*
            r16 = this;
            r0 = r17
            r1 = 0
            r2 = 19
            r3 = 48
            if (r18 != 0) goto L_0x0119
            int r4 = r17.length()
            r5 = 32
            r6 = 16
            r7 = 13
            r8 = 7
            r9 = 46
            r10 = 1
            r11 = 4
            r12 = 58
            r13 = 10
            r14 = 45
            if (r4 != r2) goto L_0x00bd
            char r4 = r0.charAt(r11)
            char r8 = r0.charAt(r8)
            char r15 = r0.charAt(r13)
            char r7 = r0.charAt(r7)
            char r6 = r0.charAt(r6)
            if (r7 != r12) goto L_0x00ec
            if (r6 != r12) goto L_0x00ec
            if (r4 != r14) goto L_0x004c
            if (r8 != r14) goto L_0x004c
            r4 = 84
            if (r15 != r4) goto L_0x0046
            java.time.format.DateTimeFormatter r4 = java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME
            goto L_0x00ee
        L_0x0046:
            if (r15 != r5) goto L_0x00ec
            java.time.format.DateTimeFormatter r4 = defaultFormatter
            goto L_0x00ee
        L_0x004c:
            r5 = 47
            if (r4 != r5) goto L_0x0056
            if (r8 != r5) goto L_0x0056
            java.time.format.DateTimeFormatter r4 = formatter_dt19_tw
            goto L_0x00ee
        L_0x0056:
            char r6 = r0.charAt(r1)
            char r7 = r0.charAt(r10)
            r8 = 2
            char r8 = r0.charAt(r8)
            r12 = 3
            char r12 = r0.charAt(r12)
            r15 = 5
            char r15 = r0.charAt(r15)
            if (r8 != r5) goto L_0x00af
            if (r15 != r5) goto L_0x00af
            int r6 = r6 - r3
            int r6 = r6 * 10
            int r7 = r7 - r3
            int r6 = r6 + r7
            int r12 = r12 - r3
            int r12 = r12 * 10
            int r4 = r4 - r3
            int r12 = r12 + r4
            r4 = 12
            if (r6 <= r4) goto L_0x0083
            java.time.format.DateTimeFormatter r4 = formatter_dt19_eur
            goto L_0x00ee
        L_0x0083:
            if (r12 <= r4) goto L_0x0089
            java.time.format.DateTimeFormatter r4 = formatter_dt19_us
            goto L_0x00ee
        L_0x0089:
            java.util.Locale r4 = java.util.Locale.getDefault()
            java.lang.String r4 = r4.getCountry()
            java.lang.String r5 = "US"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x009c
            java.time.format.DateTimeFormatter r4 = formatter_dt19_us
            goto L_0x00ee
        L_0x009c:
            java.lang.String r5 = "BR"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x00ac
            java.lang.String r5 = "AU"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00ec
        L_0x00ac:
            java.time.format.DateTimeFormatter r4 = formatter_dt19_eur
            goto L_0x00ee
        L_0x00af:
            if (r8 != r9) goto L_0x00b6
            if (r15 != r9) goto L_0x00b6
            java.time.format.DateTimeFormatter r4 = formatter_dt19_de
            goto L_0x00ee
        L_0x00b6:
            if (r8 != r14) goto L_0x00ec
            if (r15 != r14) goto L_0x00ec
            java.time.format.DateTimeFormatter r4 = formatter_dt19_in
            goto L_0x00ee
        L_0x00bd:
            int r4 = r17.length()
            r15 = 23
            if (r4 != r15) goto L_0x00ec
            char r4 = r0.charAt(r11)
            char r8 = r0.charAt(r8)
            char r13 = r0.charAt(r13)
            char r7 = r0.charAt(r7)
            char r6 = r0.charAt(r6)
            char r15 = r0.charAt(r2)
            if (r7 != r12) goto L_0x00ec
            if (r6 != r12) goto L_0x00ec
            if (r4 != r14) goto L_0x00ec
            if (r8 != r14) goto L_0x00ec
            if (r13 != r5) goto L_0x00ec
            if (r15 != r9) goto L_0x00ec
            java.time.format.DateTimeFormatter r4 = defaultFormatter_23
            goto L_0x00ee
        L_0x00ec:
            r4 = r18
        L_0x00ee:
            int r5 = r17.length()
            r6 = 17
            if (r5 < r6) goto L_0x011b
            char r5 = r0.charAt(r11)
            r6 = 24180(0x5e74, float:3.3883E-41)
            if (r5 != r6) goto L_0x0111
            int r4 = r17.length()
            int r4 = r4 - r10
            char r4 = r0.charAt(r4)
            r5 = 31186(0x79d2, float:4.3701E-41)
            if (r4 != r5) goto L_0x010e
            java.time.format.DateTimeFormatter r4 = formatter_dt19_cn_1
            goto L_0x011b
        L_0x010e:
            java.time.format.DateTimeFormatter r4 = formatter_dt19_cn
            goto L_0x011b
        L_0x0111:
            r6 = 45380(0xb144, float:6.3591E-41)
            if (r5 != r6) goto L_0x011b
            java.time.format.DateTimeFormatter r4 = formatter_dt19_kr
            goto L_0x011b
        L_0x0119:
            r4 = r18
        L_0x011b:
            if (r4 != 0) goto L_0x016e
            com.alibaba.fastjson.parser.JSONScanner r5 = new com.alibaba.fastjson.parser.JSONScanner
            r5.<init>(r0)
            boolean r6 = r5.scanISO8601DateIfMatch(r1)
            if (r6 == 0) goto L_0x0139
            java.util.Calendar r0 = r5.getCalendar()
            java.time.Instant r0 = r0.toInstant()
            java.time.ZoneId r1 = java.time.ZoneId.systemDefault()
            java.time.LocalDateTime r0 = java.time.LocalDateTime.ofInstant(r0, r1)
            return r0
        L_0x0139:
            int r5 = r17.length()
            if (r1 >= r5) goto L_0x014d
            char r5 = r0.charAt(r1)
            if (r5 < r3) goto L_0x016e
            r6 = 57
            if (r5 <= r6) goto L_0x014a
            goto L_0x016e
        L_0x014a:
            int r1 = r1 + 1
            goto L_0x0139
        L_0x014d:
            int r1 = r17.length()
            r3 = 8
            if (r1 <= r3) goto L_0x016e
            int r1 = r17.length()
            if (r1 >= r2) goto L_0x016e
            long r0 = java.lang.Long.parseLong(r17)
            java.time.Instant r0 = java.time.Instant.ofEpochMilli(r0)
            java.util.TimeZone r1 = com.alibaba.fastjson.JSON.defaultTimeZone
            java.time.ZoneId r1 = r1.toZoneId()
            java.time.LocalDateTime r0 = java.time.LocalDateTime.ofInstant(r0, r1)
            return r0
        L_0x016e:
            if (r4 != 0) goto L_0x0175
            java.time.LocalDateTime r0 = java.time.LocalDateTime.parse(r17)
            goto L_0x0179
        L_0x0175:
            java.time.LocalDateTime r0 = java.time.LocalDateTime.parse(r0, r4)
        L_0x0179:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec.parseDateTime(java.lang.String, java.time.format.DateTimeFormatter):java.time.LocalDateTime");
    }

    public LocalDate parseLocalDate(String str, String str2, DateTimeFormatter dateTimeFormatter) {
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
                    return LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(str)), JSON.defaultTimeZone.toZoneId()).toLocalDate();
                }
            }
        }
        if (dateTimeFormatter == null) {
            return LocalDate.parse(str);
        }
        return LocalDate.parse(str, dateTimeFormatter);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00fb A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.time.ZonedDateTime parseZonedDateTime(java.lang.String r16, java.time.format.DateTimeFormatter r17) {
        /*
            r15 = this;
            r0 = r16
            if (r17 != 0) goto L_0x011c
            int r1 = r16.length()
            r2 = 0
            r3 = 4
            r4 = 19
            r5 = 1
            r6 = 48
            if (r1 != r4) goto L_0x00bb
            char r1 = r0.charAt(r3)
            r7 = 7
            char r7 = r0.charAt(r7)
            r8 = 10
            char r9 = r0.charAt(r8)
            r10 = 13
            char r10 = r0.charAt(r10)
            r11 = 16
            char r11 = r0.charAt(r11)
            r12 = 58
            if (r10 != r12) goto L_0x00bb
            if (r11 != r12) goto L_0x00bb
            r10 = 45
            if (r1 != r10) goto L_0x004a
            if (r7 != r10) goto L_0x004a
            r1 = 84
            if (r9 != r1) goto L_0x0042
            java.time.format.DateTimeFormatter r1 = java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME
            goto L_0x00bd
        L_0x0042:
            r1 = 32
            if (r9 != r1) goto L_0x00bb
            java.time.format.DateTimeFormatter r1 = defaultFormatter
            goto L_0x00bd
        L_0x004a:
            r9 = 47
            if (r1 != r9) goto L_0x0054
            if (r7 != r9) goto L_0x0054
            java.time.format.DateTimeFormatter r1 = formatter_dt19_tw
            goto L_0x00bd
        L_0x0054:
            char r7 = r0.charAt(r2)
            char r11 = r0.charAt(r5)
            r12 = 2
            char r12 = r0.charAt(r12)
            r13 = 3
            char r13 = r0.charAt(r13)
            r14 = 5
            char r14 = r0.charAt(r14)
            if (r12 != r9) goto L_0x00ab
            if (r14 != r9) goto L_0x00ab
            int r7 = r7 - r6
            int r7 = r7 * 10
            int r11 = r11 - r6
            int r7 = r7 + r11
            int r13 = r13 - r6
            int r13 = r13 * 10
            int r1 = r1 - r6
            int r13 = r13 + r1
            r1 = 12
            if (r7 <= r1) goto L_0x0080
            java.time.format.DateTimeFormatter r1 = formatter_dt19_eur
            goto L_0x00bd
        L_0x0080:
            if (r13 <= r1) goto L_0x0085
            java.time.format.DateTimeFormatter r1 = formatter_dt19_us
            goto L_0x00bd
        L_0x0085:
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r1 = r1.getCountry()
            java.lang.String r7 = "US"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x0098
            java.time.format.DateTimeFormatter r1 = formatter_dt19_us
            goto L_0x00bd
        L_0x0098:
            java.lang.String r7 = "BR"
            boolean r7 = r1.equals(r7)
            if (r7 != 0) goto L_0x00a8
            java.lang.String r7 = "AU"
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x00bb
        L_0x00a8:
            java.time.format.DateTimeFormatter r1 = formatter_dt19_eur
            goto L_0x00bd
        L_0x00ab:
            r1 = 46
            if (r12 != r1) goto L_0x00b4
            if (r14 != r1) goto L_0x00b4
            java.time.format.DateTimeFormatter r1 = formatter_dt19_de
            goto L_0x00bd
        L_0x00b4:
            if (r12 != r10) goto L_0x00bb
            if (r14 != r10) goto L_0x00bb
            java.time.format.DateTimeFormatter r1 = formatter_dt19_in
            goto L_0x00bd
        L_0x00bb:
            r1 = r17
        L_0x00bd:
            int r7 = r16.length()
            r8 = 17
            if (r7 < r8) goto L_0x00e7
            char r3 = r0.charAt(r3)
            r7 = 24180(0x5e74, float:3.3883E-41)
            if (r3 != r7) goto L_0x00e0
            int r1 = r16.length()
            int r1 = r1 - r5
            char r1 = r0.charAt(r1)
            r3 = 31186(0x79d2, float:4.3701E-41)
            if (r1 != r3) goto L_0x00dd
            java.time.format.DateTimeFormatter r1 = formatter_dt19_cn_1
            goto L_0x00e7
        L_0x00dd:
            java.time.format.DateTimeFormatter r1 = formatter_dt19_cn
            goto L_0x00e7
        L_0x00e0:
            r5 = 45380(0xb144, float:6.3591E-41)
            if (r3 != r5) goto L_0x00e7
            java.time.format.DateTimeFormatter r1 = formatter_dt19_kr
        L_0x00e7:
            int r3 = r16.length()
            if (r2 >= r3) goto L_0x00fb
            char r3 = r0.charAt(r2)
            if (r3 < r6) goto L_0x011e
            r5 = 57
            if (r3 <= r5) goto L_0x00f8
            goto L_0x011e
        L_0x00f8:
            int r2 = r2 + 1
            goto L_0x00e7
        L_0x00fb:
            int r2 = r16.length()
            r3 = 8
            if (r2 <= r3) goto L_0x011e
            int r2 = r16.length()
            if (r2 >= r4) goto L_0x011e
            long r0 = java.lang.Long.parseLong(r16)
            java.time.Instant r0 = java.time.Instant.ofEpochMilli(r0)
            java.util.TimeZone r1 = com.alibaba.fastjson.JSON.defaultTimeZone
            java.time.ZoneId r1 = r1.toZoneId()
            java.time.ZonedDateTime r0 = java.time.ZonedDateTime.ofInstant(r0, r1)
            return r0
        L_0x011c:
            r1 = r17
        L_0x011e:
            if (r1 != 0) goto L_0x0125
            java.time.ZonedDateTime r0 = java.time.ZonedDateTime.parse(r16)
            goto L_0x0129
        L_0x0125:
            java.time.ZonedDateTime r0 = java.time.ZonedDateTime.parse(r0, r1)
        L_0x0129:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec.parseZonedDateTime(java.lang.String, java.time.format.DateTimeFormatter):java.time.ZonedDateTime");
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
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
                    if (jSONSerializer.isEnabled(SerializerFeature.WriteDateUseDateFormat)) {
                        dateFormatPattern = (jSONSerializer.getFastJsonConfigDateFormatPattern() == null || jSONSerializer.getFastJsonConfigDateFormatPattern().length() <= 0) ? JSON.DEFFAULT_DATE_FORMAT : jSONSerializer.getFastJsonConfigDateFormatPattern();
                    } else {
                        int oIX0oI3 = oIX0oI2.getNano();
                        if (oIX0oI3 != 0) {
                            dateFormatPattern = oIX0oI3 % 1000000 == 0 ? formatter_iso8601_pattern_23 : formatter_iso8601_pattern_29;
                        }
                    }
                }
            }
            if (dateFormatPattern != null) {
                write(serializeWriter, (TemporalAccessor) oIX0oI2, dateFormatPattern);
            } else {
                serializeWriter.writeLong(oIX0oI2.atZone(JSON.defaultTimeZone.toZoneId()).toInstant().toEpochMilli());
            }
        } else {
            serializeWriter.writeString(obj.toString());
        }
    }

    public void write(JSONSerializer jSONSerializer, Object obj, BeanContext beanContext) throws IOException {
        write(jSONSerializer.out, xoIox.oIX0oI(obj), beanContext.getFormat());
    }

    private void write(SerializeWriter serializeWriter, TemporalAccessor temporalAccessor, String str) {
        DateTimeFormatter dateTimeFormatter;
        Instant instant;
        if ("unixtime".equals(str)) {
            if (OOXIXo.oIX0oI(temporalAccessor)) {
                serializeWriter.writeInt((int) oO.oIX0oI(temporalAccessor).toEpochSecond());
                return;
            } else if (ooOOo0oXI.oIX0oI(temporalAccessor)) {
                serializeWriter.writeInt((int) XO.oIX0oI(temporalAccessor).atZone(JSON.defaultTimeZone.toZoneId()).toEpochSecond());
                return;
            }
        }
        if ("millis".equals(str)) {
            if (OOXIXo.oIX0oI(temporalAccessor)) {
                instant = oO.oIX0oI(temporalAccessor).toInstant();
            } else {
                instant = ooOOo0oXI.oIX0oI(temporalAccessor) ? XO.oIX0oI(temporalAccessor).atZone(JSON.defaultTimeZone.toZoneId()).toInstant() : null;
            }
            if (instant != null) {
                serializeWriter.writeLong(instant.toEpochMilli());
                return;
            }
        }
        if (str == "yyyy-MM-dd'T'HH:mm:ss") {
            dateTimeFormatter = formatter_iso8601;
        } else {
            dateTimeFormatter = DateTimeFormatter.ofPattern(str);
        }
        serializeWriter.writeString(dateTimeFormatter.format(temporalAccessor));
    }
}
