package org.apache.log4j.config;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import org.apache.log4j.IIXOooo;
import org.apache.log4j.Level;
import org.apache.log4j.config.oIX0oI;
import org.apache.log4j.oO;
import org.apache.log4j.x0xO0oo;

/* loaded from: classes6.dex */
public class II0xO0 implements oIX0oI.InterfaceC1139oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public Hashtable f33220I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Hashtable f33221II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f33222X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f33223oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public PrintWriter f33224oxoX;

    public II0xO0(PrintWriter printWriter) {
        this(printWriter, false);
    }

    public static String II0xO0(String str) {
        if (Character.isLowerCase(str.charAt(0))) {
            if (str.length() == 1 || Character.isLowerCase(str.charAt(1))) {
                StringBuffer stringBuffer = new StringBuffer(str);
                stringBuffer.setCharAt(0, Character.toUpperCase(str.charAt(0)));
                return stringBuffer.toString();
            }
            return str;
        }
        return str;
    }

    public static void X0o0xo(String[] strArr) {
        new II0xO0(new PrintWriter(System.out));
    }

    public String I0Io() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("A");
        int i = this.f33223oIX0oI;
        this.f33223oIX0oI = i + 1;
        stringBuffer.append(i);
        return stringBuffer.toString();
    }

    public void II0XooXoX(PrintWriter printWriter, x0xO0oo x0xo0oo) {
        String oxxIIOOXO;
        String stringBuffer;
        Enumeration OOXIXo2 = x0xo0oo.OOXIXo();
        Level XI0IXoo2 = x0xo0oo.XI0IXoo();
        if (XI0IXoo2 == null) {
            oxxIIOOXO = "";
        } else {
            oxxIIOOXO = XI0IXoo2.toString();
        }
        while (OOXIXo2.hasMoreElements()) {
            org.apache.log4j.oIX0oI oix0oi = (org.apache.log4j.oIX0oI) OOXIXo2.nextElement();
            String str = (String) this.f33221II0xO0.get(oix0oi);
            if (str == null) {
                str = oix0oi.getName();
                if (str == null || oxoX(str)) {
                    str = I0Io();
                }
                this.f33221II0xO0.put(oix0oi, str);
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(IIXOooo.f33165OOXIXo);
                stringBuffer2.append(str);
                Oxx0IOOO(printWriter, oix0oi, stringBuffer2.toString());
                if (oix0oi.Oxx0xo() != null) {
                    Object Oxx0xo2 = oix0oi.Oxx0xo();
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append(IIXOooo.f33165OOXIXo);
                    stringBuffer3.append(str);
                    stringBuffer3.append(".layout");
                    Oxx0IOOO(printWriter, Oxx0xo2, stringBuffer3.toString());
                }
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(oxxIIOOXO);
            stringBuffer4.append(", ");
            stringBuffer4.append(str);
            oxxIIOOXO = stringBuffer4.toString();
        }
        if (x0xo0oo == x0xO0oo.I0X0x0oIo()) {
            stringBuffer = IIXOooo.f33175xoIox;
        } else {
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append(IIXOooo.f33169XO);
            stringBuffer5.append(x0xo0oo.xxX());
            stringBuffer = stringBuffer5.toString();
        }
        if (oxxIIOOXO != "") {
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append(stringBuffer);
            stringBuffer6.append("=");
            stringBuffer6.append(oxxIIOOXO);
            printWriter.println(stringBuffer6.toString());
        }
        if (!x0xo0oo.oI0IIXIo() && x0xo0oo != x0xO0oo.I0X0x0oIo()) {
            StringBuffer stringBuffer7 = new StringBuffer();
            stringBuffer7.append(IIXOooo.f33163II0XooXoX);
            stringBuffer7.append(x0xo0oo.xxX());
            stringBuffer7.append("=false");
            printWriter.println(stringBuffer7.toString());
        }
    }

    public void Oxx0IOOO(PrintWriter printWriter, Object obj, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("=");
        stringBuffer.append(obj.getClass().getName());
        printWriter.println(stringBuffer.toString());
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(str);
        stringBuffer2.append(FileUtils.FILE_EXTENSION_SEPARATOR);
        oIX0oI.II0xO0(obj, this, stringBuffer2.toString());
    }

    public void XO(PrintWriter printWriter) {
        II0XooXoX(printWriter, x0xO0oo.I0X0x0oIo());
        Enumeration II0xO02 = oO.II0xO0();
        while (II0xO02.hasMoreElements()) {
            II0XooXoX(printWriter, (x0xO0oo) II0xO02.nextElement());
        }
    }

    @Override // org.apache.log4j.config.oIX0oI.InterfaceC1139oIX0oI
    public void oIX0oI(Object obj, String str, String str2, Object obj2) {
        if ((obj instanceof org.apache.log4j.oIX0oI) && "name".equals(str2)) {
            return;
        }
        if (this.f33222X0o0xo) {
            str2 = II0xO0(str2);
        }
        PrintWriter printWriter = this.f33224oxoX;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        stringBuffer.append("=");
        stringBuffer.append(obj2.toString());
        printWriter.println(stringBuffer.toString());
    }

    public boolean oxoX(String str) {
        if (str.length() >= 2 && str.charAt(0) == 'A') {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                }
            }
            return true;
        }
        return false;
    }

    public II0xO0(PrintWriter printWriter, boolean z) {
        this.f33223oIX0oI = 0;
        this.f33221II0xO0 = new Hashtable();
        this.f33220I0Io = new Hashtable();
        this.f33224oxoX = printWriter;
        this.f33222X0o0xo = z;
        XO(printWriter);
        printWriter.flush();
    }
}
