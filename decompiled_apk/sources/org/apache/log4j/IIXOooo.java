package org.apache.log4j;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.StringTokenizer;

/* loaded from: classes6.dex */
public class IIXOooo implements org.apache.log4j.spi.II0xO0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final String f33163II0XooXoX = "log4j.additivity.";

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static /* synthetic */ Class f33164IXxxXO = null;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final String f33165OOXIXo = "log4j.appender.";

    /* renamed from: Oo, reason: collision with root package name */
    public static /* synthetic */ Class f33166Oo = null;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f33167Oxx0IOOO = "log4j.factory";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String f33168X0o0xo = "log4j.category.";

    /* renamed from: XO, reason: collision with root package name */
    public static final String f33169XO = "log4j.logger.";

    /* renamed from: oO, reason: collision with root package name */
    public static final String f33170oO = "root";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final String f33171oOoXoXO = "log4j.renderer.";

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final String f33172ooOOo0oXI = "log4j.threshold";

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final String f33173x0XOIxOo = "log4j.loggerFactory";

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static /* synthetic */ Class f33174x0xO0oo = null;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final String f33175xoIox = "log4j.rootLogger";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final String f33176xxIXOIIO = "log4j.rootCategory";

    /* renamed from: I0Io, reason: collision with root package name */
    public Hashtable f33177I0Io = new Hashtable(11);

    /* renamed from: oxoX, reason: collision with root package name */
    public org.apache.log4j.spi.II0XooXoX f33178oxoX = new xxIXOIIO();

    public static void I0Io(String str) {
        new IIXOooo().xoIox(str, oO.XO());
    }

    public static /* synthetic */ Class II0xO0(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static void Oxx0IOOO(String str, long j) {
        xoXoI xoxoi = new xoXoI(str);
        xoxoi.I0Io(j);
        xoxoi.start();
    }

    public static void X0o0xo(Properties properties) {
        new IIXOooo().OOXIXo(properties, oO.XO());
    }

    public static void XO(String str) {
        Oxx0IOOO(str, 60000L);
    }

    public static void oxoX(URL url) {
        new IIXOooo().oIX0oI(url, oO.XO());
    }

    public void II0XooXoX(Properties properties) {
        String oxoX2 = org.apache.log4j.helpers.oOoXoXO.oxoX(f33173x0XOIxOo, properties);
        if (oxoX2 != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Setting category factory to [");
            stringBuffer.append(oxoX2);
            stringBuffer.append("].");
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
            Class cls = f33174x0xO0oo;
            if (cls == null) {
                cls = II0xO0("org.apache.log4j.spi.LoggerFactory");
                f33174x0xO0oo = cls;
            }
            org.apache.log4j.spi.II0XooXoX iI0XooXoX = (org.apache.log4j.spi.II0XooXoX) org.apache.log4j.helpers.oOoXoXO.XO(oxoX2, cls, this.f33178oxoX);
            this.f33178oxoX = iI0XooXoX;
            org.apache.log4j.config.I0Io.XO(iI0XooXoX, properties, "log4j.factory.");
        }
    }

    public void OOXIXo(Properties properties, org.apache.log4j.spi.xxIXOIIO xxixoiio) {
        String property = properties.getProperty(org.apache.log4j.helpers.xxIXOIIO.f33336oIX0oI);
        if (property == null && (property = properties.getProperty(org.apache.log4j.helpers.xxIXOIIO.f33332II0xO0)) != null) {
            org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO("[log4j.configDebug] is deprecated. Use [log4j.debug] instead.");
        }
        if (property != null) {
            org.apache.log4j.helpers.xxIXOIIO.X0o0xo(org.apache.log4j.helpers.oOoXoXO.xoIox(property, true));
        }
        String oxoX2 = org.apache.log4j.helpers.oOoXoXO.oxoX(f33172ooOOo0oXI, properties);
        if (oxoX2 != null) {
            xxixoiio.ooOOo0oXI(org.apache.log4j.helpers.oOoXoXO.ooOOo0oXI(oxoX2, Level.ALL));
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Hierarchy threshold set to [");
            stringBuffer.append(xxixoiio.xoIox());
            stringBuffer.append("].");
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
        }
        xxIXOIIO(properties, xxixoiio);
        II0XooXoX(properties);
        oO(properties, xxixoiio);
        org.apache.log4j.helpers.xxIXOIIO.oIX0oI("Finished configuring.");
        this.f33177I0Io.clear();
    }

    public void Oo(oIX0oI oix0oi) {
        this.f33177I0Io.put(oix0oi.getName(), oix0oi);
    }

    @Override // org.apache.log4j.spi.II0xO0
    public void oIX0oI(URL url, org.apache.log4j.spi.xxIXOIIO xxixoiio) {
        Properties properties = new Properties();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Reading configuration from URL ");
        stringBuffer.append(url);
        org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
        try {
            properties.load(url.openStream());
            OOXIXo(properties, xxixoiio);
        } catch (IOException e) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Could not read configuration file from URL [");
            stringBuffer2.append(url);
            stringBuffer2.append("].");
            org.apache.log4j.helpers.xxIXOIIO.oxoX(stringBuffer2.toString(), e);
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Ignoring configuration file [");
            stringBuffer3.append(url);
            stringBuffer3.append("].");
            org.apache.log4j.helpers.xxIXOIIO.I0Io(stringBuffer3.toString());
        }
    }

    public void oO(Properties properties, org.apache.log4j.spi.xxIXOIIO xxixoiio) {
        String str;
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str2 = (String) propertyNames.nextElement();
            if (!str2.startsWith(f33168X0o0xo) && !str2.startsWith(f33169XO)) {
                if (str2.startsWith(f33171oOoXoXO)) {
                    String substring = str2.substring(15);
                    String oxoX2 = org.apache.log4j.helpers.oOoXoXO.oxoX(str2, properties);
                    if (xxixoiio instanceof org.apache.log4j.spi.oOoXoXO) {
                        Xxx0oXX.I0Io.oIX0oI((org.apache.log4j.spi.oOoXoXO) xxixoiio, substring, oxoX2);
                    }
                }
            } else {
                if (str2.startsWith(f33168X0o0xo)) {
                    str = str2.substring(15);
                } else if (str2.startsWith(f33169XO)) {
                    str = str2.substring(13);
                } else {
                    str = null;
                }
                String oxoX3 = org.apache.log4j.helpers.oOoXoXO.oxoX(str2, properties);
                x0xO0oo x0XOIxOo2 = xxixoiio.x0XOIxOo(str, this.f33178oxoX);
                synchronized (x0XOIxOo2) {
                    x0XOIxOo(properties, x0XOIxOo2, str2, str, oxoX3);
                    oOoXoXO(properties, x0XOIxOo2, str);
                }
            }
        }
    }

    public void oOoXoXO(Properties properties, x0xO0oo x0xo0oo, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(f33163II0XooXoX);
        stringBuffer.append(str);
        String oxoX2 = org.apache.log4j.helpers.oOoXoXO.oxoX(stringBuffer.toString(), properties);
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Handling log4j.additivity.");
        stringBuffer2.append(str);
        stringBuffer2.append("=[");
        stringBuffer2.append(oxoX2);
        stringBuffer2.append("]");
        org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer2.toString());
        if (oxoX2 != null && !oxoX2.equals("")) {
            boolean xoIox2 = org.apache.log4j.helpers.oOoXoXO.xoIox(oxoX2, true);
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Setting additivity for \"");
            stringBuffer3.append(str);
            stringBuffer3.append("\" to ");
            stringBuffer3.append(xoIox2);
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer3.toString());
            x0xo0oo.OI0(xoIox2);
        }
    }

    public oIX0oI ooOOo0oXI(Properties properties, String str) {
        oIX0oI x0xO0oo2 = x0xO0oo(str);
        if (x0xO0oo2 != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Appender \"");
            stringBuffer.append(str);
            stringBuffer.append("\" was already parsed.");
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
            return x0xO0oo2;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(f33165OOXIXo);
        stringBuffer2.append(str);
        String stringBuffer3 = stringBuffer2.toString();
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append(stringBuffer3);
        stringBuffer4.append(".layout");
        String stringBuffer5 = stringBuffer4.toString();
        Class cls = f33166Oo;
        if (cls == null) {
            cls = II0xO0("org.apache.log4j.Appender");
            f33166Oo = cls;
        }
        oIX0oI oix0oi = (oIX0oI) org.apache.log4j.helpers.oOoXoXO.Oxx0IOOO(properties, stringBuffer3, cls, null);
        if (oix0oi == null) {
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append("Could not instantiate appender named \"");
            stringBuffer6.append(str);
            stringBuffer6.append("\".");
            org.apache.log4j.helpers.xxIXOIIO.I0Io(stringBuffer6.toString());
            return null;
        }
        oix0oi.setName(str);
        if (oix0oi instanceof org.apache.log4j.spi.OOXIXo) {
            if (oix0oi.ooOOo0oXI()) {
                Class cls2 = f33164IXxxXO;
                if (cls2 == null) {
                    cls2 = II0xO0("org.apache.log4j.Layout");
                    f33164IXxxXO = cls2;
                }
                x0XOIxOo x0xoixoo = (x0XOIxOo) org.apache.log4j.helpers.oOoXoXO.Oxx0IOOO(properties, stringBuffer5, cls2, null);
                if (x0xoixoo != null) {
                    oix0oi.oxoX(x0xoixoo);
                    StringBuffer stringBuffer7 = new StringBuffer();
                    stringBuffer7.append("Parsing layout options for \"");
                    stringBuffer7.append(str);
                    stringBuffer7.append("\".");
                    org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer7.toString());
                    StringBuffer stringBuffer8 = new StringBuffer();
                    stringBuffer8.append(stringBuffer5);
                    stringBuffer8.append(FileUtils.FILE_EXTENSION_SEPARATOR);
                    org.apache.log4j.config.I0Io.XO(x0xoixoo, properties, stringBuffer8.toString());
                    StringBuffer stringBuffer9 = new StringBuffer();
                    stringBuffer9.append("End of parsing for \"");
                    stringBuffer9.append(str);
                    stringBuffer9.append("\".");
                    org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer9.toString());
                }
            }
            StringBuffer stringBuffer10 = new StringBuffer();
            stringBuffer10.append(stringBuffer3);
            stringBuffer10.append(FileUtils.FILE_EXTENSION_SEPARATOR);
            org.apache.log4j.config.I0Io.XO(oix0oi, properties, stringBuffer10.toString());
            StringBuffer stringBuffer11 = new StringBuffer();
            stringBuffer11.append("Parsed \"");
            stringBuffer11.append(str);
            stringBuffer11.append("\" options.");
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer11.toString());
        }
        Oo(oix0oi);
        return oix0oi;
    }

    public void x0XOIxOo(Properties properties, x0xO0oo x0xo0oo, String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Parsing for [");
        stringBuffer.append(str2);
        stringBuffer.append("] with value=[");
        stringBuffer.append(str3);
        stringBuffer.append("].");
        org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
        StringTokenizer stringTokenizer = new StringTokenizer(str3, ",");
        if (!str3.startsWith(",") && !str3.equals("")) {
            if (!stringTokenizer.hasMoreTokens()) {
                return;
            }
            String nextToken = stringTokenizer.nextToken();
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Level token is [");
            stringBuffer2.append(nextToken);
            stringBuffer2.append("].");
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer2.toString());
            if (!org.apache.log4j.spi.II0xO0.f33489oIX0oI.equalsIgnoreCase(nextToken) && !"null".equalsIgnoreCase(nextToken)) {
                x0xo0oo.o0(org.apache.log4j.helpers.oOoXoXO.ooOOo0oXI(nextToken, Level.DEBUG));
            } else if (str2.equals("root")) {
                org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO("The root logger cannot be set to null.");
            } else {
                x0xo0oo.o0(null);
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Category ");
            stringBuffer3.append(str2);
            stringBuffer3.append(" set to ");
            stringBuffer3.append(x0xo0oo.XI0IXoo());
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer3.toString());
        }
        x0xo0oo.oO();
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if (trim != null && !trim.equals(",")) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("Parsing appender named \"");
                stringBuffer4.append(trim);
                stringBuffer4.append("\".");
                org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer4.toString());
                oIX0oI ooOOo0oXI2 = ooOOo0oXI(properties, trim);
                if (ooOOo0oXI2 != null) {
                    x0xo0oo.oIX0oI(ooOOo0oXI2);
                }
            }
        }
    }

    public oIX0oI x0xO0oo(String str) {
        return (oIX0oI) this.f33177I0Io.get(str);
    }

    public void xoIox(String str, org.apache.log4j.spi.xxIXOIIO xxixoiio) {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            properties.load(fileInputStream);
            fileInputStream.close();
            OOXIXo(properties, xxixoiio);
        } catch (IOException e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not read configuration file [");
            stringBuffer.append(str);
            stringBuffer.append("].");
            org.apache.log4j.helpers.xxIXOIIO.oxoX(stringBuffer.toString(), e);
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Ignoring configuration file [");
            stringBuffer2.append(str);
            stringBuffer2.append("].");
            org.apache.log4j.helpers.xxIXOIIO.I0Io(stringBuffer2.toString());
        }
    }

    public void xxIXOIIO(Properties properties, org.apache.log4j.spi.xxIXOIIO xxixoiio) {
        String str = f33175xoIox;
        String oxoX2 = org.apache.log4j.helpers.oOoXoXO.oxoX(f33175xoIox, properties);
        if (oxoX2 == null) {
            oxoX2 = org.apache.log4j.helpers.oOoXoXO.oxoX(f33176xxIXOIIO, properties);
            str = f33176xxIXOIIO;
        }
        String str2 = str;
        String str3 = oxoX2;
        if (str3 == null) {
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI("Could not find root logger information. Is this OK?");
            return;
        }
        x0xO0oo oO2 = xxixoiio.oO();
        synchronized (oO2) {
            x0XOIxOo(properties, oO2, str2, "root", str3);
        }
    }
}
