package com.alibaba.fastjson.serializer;

import XIXIX.OOXIXo;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class CalendarCodec extends ContextObjectDeserializer implements ObjectSerializer, ObjectDeserializer, ContextObjectSerializer {
    public static final CalendarCodec instance = new CalendarCodec();
    private DatatypeFactory dateFactory;

    public XMLGregorianCalendar createXMLGregorianCalendar(Calendar calendar) {
        if (this.dateFactory == null) {
            try {
                this.dateFactory = DatatypeFactory.newInstance();
            } catch (DatatypeConfigurationException e) {
                throw new IllegalStateException("Could not obtain an instance of DatatypeFactory.", e);
            }
        }
        return this.dateFactory.newXMLGregorianCalendar((GregorianCalendar) calendar);
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return deserialze(defaultJSONParser, type, obj, (String) null, 0);
    }

    public int getFastMatchToken() {
        return 2;
    }

    public void write(JSONSerializer jSONSerializer, Object obj, BeanContext beanContext) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        String format = beanContext.getFormat();
        Calendar calendar = (Calendar) obj;
        if (format.equals("unixtime")) {
            serializeWriter.writeInt((int) (calendar.getTimeInMillis() / 1000));
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        simpleDateFormat.setTimeZone(jSONSerializer.timeZone);
        serializeWriter.writeString(simpleDateFormat.format(calendar.getTime()));
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, String str, int i) {
        T deserialze = DateCodec.instance.deserialze(defaultJSONParser, type, obj, str, i);
        if (deserialze instanceof Calendar) {
            return deserialze;
        }
        Date date = (Date) deserialze;
        if (date == null) {
            return null;
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        T instance2 = Calendar.getInstance(jSONLexer.getTimeZone(), jSONLexer.getLocale());
        instance2.setTime(date);
        return type == XMLGregorianCalendar.class ? createXMLGregorianCalendar((GregorianCalendar) instance2) : instance2;
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        Calendar calendar;
        char[] cArr;
        JSONSerializer jSONSerializer2 = jSONSerializer;
        Object obj3 = obj;
        SerializeWriter serializeWriter = jSONSerializer2.out;
        if (obj3 == null) {
            serializeWriter.writeNull();
            return;
        }
        if (obj3 instanceof XMLGregorianCalendar) {
            calendar = ((XMLGregorianCalendar) obj3).toGregorianCalendar();
        } else {
            calendar = (Calendar) obj3;
        }
        if (serializeWriter.isEnabled(SerializerFeature.UseISO8601DateFormat)) {
            char c = serializeWriter.isEnabled(SerializerFeature.UseSingleQuotes) ? '\'' : '\"';
            serializeWriter.append(c);
            int i2 = calendar.get(1);
            int i3 = calendar.get(2) + 1;
            int i4 = calendar.get(5);
            int i5 = calendar.get(11);
            int i6 = calendar.get(12);
            int i7 = calendar.get(13);
            int i8 = calendar.get(14);
            if (i8 != 0) {
                cArr = "0000-00-00T00:00:00.000".toCharArray();
                IOUtils.getChars(i8, 23, cArr);
                IOUtils.getChars(i7, 19, cArr);
                IOUtils.getChars(i6, 16, cArr);
                IOUtils.getChars(i5, 13, cArr);
                IOUtils.getChars(i4, 10, cArr);
                IOUtils.getChars(i3, 7, cArr);
                IOUtils.getChars(i2, 4, cArr);
            } else if (i7 == 0 && i6 == 0 && i5 == 0) {
                cArr = "0000-00-00".toCharArray();
                IOUtils.getChars(i4, 10, cArr);
                IOUtils.getChars(i3, 7, cArr);
                IOUtils.getChars(i2, 4, cArr);
            } else {
                cArr = "0000-00-00T00:00:00".toCharArray();
                IOUtils.getChars(i7, 19, cArr);
                IOUtils.getChars(i6, 16, cArr);
                IOUtils.getChars(i5, 13, cArr);
                IOUtils.getChars(i4, 10, cArr);
                IOUtils.getChars(i3, 7, cArr);
                IOUtils.getChars(i2, 4, cArr);
            }
            serializeWriter.write(cArr);
            float offset = ((float) calendar.getTimeZone().getOffset(calendar.getTimeInMillis())) / 3600000.0f;
            int i9 = (int) offset;
            if (((double) i9) == OOXIXo.f29376XO) {
                serializeWriter.write(90);
            } else {
                if (i9 > 9) {
                    serializeWriter.write(43);
                    serializeWriter.writeInt(i9);
                } else if (i9 > 0) {
                    serializeWriter.write(43);
                    serializeWriter.write(48);
                    serializeWriter.writeInt(i9);
                } else if (i9 < -9) {
                    serializeWriter.write(45);
                    serializeWriter.writeInt(i9);
                } else if (i9 < 0) {
                    serializeWriter.write(45);
                    serializeWriter.write(48);
                    serializeWriter.writeInt(-i9);
                }
                serializeWriter.write(58);
                serializeWriter.append((CharSequence) String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf((int) ((offset - ((float) i9)) * 60.0f))}));
            }
            serializeWriter.append(c);
            return;
        }
        jSONSerializer2.write((Object) calendar.getTime());
    }
}
