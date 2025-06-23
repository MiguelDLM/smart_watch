package org.apache.commons.text.lookup;

import o0oIxXOx.OxxIIOOXO;
import o0oIxXOx.XIxXXX0x0;
import org.apache.log4j.helpers.AbsoluteTimeDateFormat;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'BASE64_DECODER' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class DefaultStringLookup {
    private static final /* synthetic */ DefaultStringLookup[] $VALUES;
    public static final DefaultStringLookup BASE64_DECODER;
    public static final DefaultStringLookup BASE64_ENCODER;
    public static final DefaultStringLookup CONST;
    public static final DefaultStringLookup DATE;
    public static final DefaultStringLookup DNS;
    public static final DefaultStringLookup ENVIRONMENT;
    public static final DefaultStringLookup FILE;
    public static final DefaultStringLookup JAVA;
    public static final DefaultStringLookup LOCAL_HOST;
    public static final DefaultStringLookup PROPERTIES;
    public static final DefaultStringLookup RESOURCE_BUNDLE;
    public static final DefaultStringLookup SCRIPT;
    public static final DefaultStringLookup SYSTEM_PROPERTIES;
    public static final DefaultStringLookup URL;
    public static final DefaultStringLookup URL_DECODER;
    public static final DefaultStringLookup URL_ENCODER;
    public static final DefaultStringLookup XML;
    private final String key;
    private final OxxIIOOXO lookup;

    static {
        XIxXXX0x0 xIxXXX0x0 = XIxXXX0x0.f31171oIX0oI;
        DefaultStringLookup defaultStringLookup = new DefaultStringLookup("BASE64_DECODER", 0, XIxXXX0x0.f31165Oxx0IOOO, xIxXXX0x0.X0o0xo());
        BASE64_DECODER = defaultStringLookup;
        DefaultStringLookup defaultStringLookup2 = new DefaultStringLookup("BASE64_ENCODER", 1, XIxXXX0x0.f31159II0XooXoX, xIxXXX0x0.XO());
        BASE64_ENCODER = defaultStringLookup2;
        DefaultStringLookup defaultStringLookup3 = new DefaultStringLookup("CONST", 2, XIxXXX0x0.f31180xxIXOIIO, xIxXXX0x0.xoIox());
        CONST = defaultStringLookup3;
        DefaultStringLookup defaultStringLookup4 = new DefaultStringLookup(AbsoluteTimeDateFormat.DATE_AND_TIME_DATE_FORMAT, 3, XIxXXX0x0.f31178xoIox, xIxXXX0x0.OOXIXo());
        DATE = defaultStringLookup4;
        DefaultStringLookup defaultStringLookup5 = new DefaultStringLookup("DNS", 4, XIxXXX0x0.f31163OOXIXo, xIxXXX0x0.oOoXoXO());
        DNS = defaultStringLookup5;
        DefaultStringLookup defaultStringLookup6 = new DefaultStringLookup("ENVIRONMENT", 5, XIxXXX0x0.f31173oOoXoXO, xIxXXX0x0.ooOOo0oXI());
        ENVIRONMENT = defaultStringLookup6;
        DefaultStringLookup defaultStringLookup7 = new DefaultStringLookup("FILE", 6, "file", xIxXXX0x0.x0XOIxOo());
        FILE = defaultStringLookup7;
        DefaultStringLookup defaultStringLookup8 = new DefaultStringLookup("JAVA", 7, XIxXXX0x0.f31176x0XOIxOo, xIxXXX0x0.oI0IIXIo());
        JAVA = defaultStringLookup8;
        DefaultStringLookup defaultStringLookup9 = new DefaultStringLookup("LOCAL_HOST", 8, XIxXXX0x0.f31172oO, xIxXXX0x0.o00());
        LOCAL_HOST = defaultStringLookup9;
        DefaultStringLookup defaultStringLookup10 = new DefaultStringLookup("PROPERTIES", 9, XIxXXX0x0.f31177x0xO0oo, xIxXXX0x0.X0IIOO());
        PROPERTIES = defaultStringLookup10;
        DefaultStringLookup defaultStringLookup11 = new DefaultStringLookup("RESOURCE_BUNDLE", 10, XIxXXX0x0.f31164Oo, xIxXXX0x0.XI0IXoo());
        RESOURCE_BUNDLE = defaultStringLookup11;
        DefaultStringLookup defaultStringLookup12 = new DefaultStringLookup("SCRIPT", 11, "script", xIxXXX0x0.xxX());
        SCRIPT = defaultStringLookup12;
        DefaultStringLookup defaultStringLookup13 = new DefaultStringLookup("SYSTEM_PROPERTIES", 12, "sys", xIxXXX0x0.XxX0x0xxx());
        SYSTEM_PROPERTIES = defaultStringLookup13;
        DefaultStringLookup defaultStringLookup14 = new DefaultStringLookup("URL", 13, "url", xIxXXX0x0.ooXIXxIX());
        URL = defaultStringLookup14;
        DefaultStringLookup defaultStringLookup15 = new DefaultStringLookup("URL_DECODER", 14, XIxXXX0x0.f31167OxxIIOOXO, xIxXXX0x0.xXxxox0I());
        URL_DECODER = defaultStringLookup15;
        DefaultStringLookup defaultStringLookup16 = new DefaultStringLookup("URL_ENCODER", 15, XIxXXX0x0.f31161IIXOooo, xIxXXX0x0.IIX0o());
        URL_ENCODER = defaultStringLookup16;
        DefaultStringLookup defaultStringLookup17 = new DefaultStringLookup("XML", 16, XIxXXX0x0.f31179xoXoI, xIxXXX0x0.xI());
        XML = defaultStringLookup17;
        $VALUES = new DefaultStringLookup[]{defaultStringLookup, defaultStringLookup2, defaultStringLookup3, defaultStringLookup4, defaultStringLookup5, defaultStringLookup6, defaultStringLookup7, defaultStringLookup8, defaultStringLookup9, defaultStringLookup10, defaultStringLookup11, defaultStringLookup12, defaultStringLookup13, defaultStringLookup14, defaultStringLookup15, defaultStringLookup16, defaultStringLookup17};
    }

    private DefaultStringLookup(String str, int i, String str2, OxxIIOOXO oxxIIOOXO) {
        this.key = str2;
        this.lookup = oxxIIOOXO;
    }

    public static DefaultStringLookup valueOf(String str) {
        return (DefaultStringLookup) Enum.valueOf(DefaultStringLookup.class, str);
    }

    public static DefaultStringLookup[] values() {
        return (DefaultStringLookup[]) $VALUES.clone();
    }

    public String getKey() {
        return this.key;
    }

    public OxxIIOOXO getStringLookup() {
        return this.lookup;
    }
}
