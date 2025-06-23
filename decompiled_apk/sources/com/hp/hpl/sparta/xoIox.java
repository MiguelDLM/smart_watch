package com.hp.hpl.sparta;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* loaded from: classes10.dex */
public class xoIox {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final Integer f17225I0Io = new Integer(1);

    /* renamed from: oxoX, reason: collision with root package name */
    public static final Integer f17232oxoX = new Integer(2);

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final Integer f17229X0o0xo = new Integer(3);

    /* renamed from: XO, reason: collision with root package name */
    public static final Integer f17230XO = new Integer(4);

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final Integer f17228Oxx0IOOO = new Integer(5);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final Integer f17226II0XooXoX = new Integer(6);

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final Integer f17234xxIXOIIO = new Integer(7);

    /* renamed from: xoIox, reason: collision with root package name */
    public static final Integer f17233xoIox = new Integer(8);

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final Integer f17227OOXIXo = new Integer(9);

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final Integer f17231oOoXoXO = new Integer(10);

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Vector f17236oIX0oI = new Vector();

    /* renamed from: II0xO0, reason: collision with root package name */
    public Hashtable f17235II0xO0 = new Hashtable();

    public static Integer I0Io(xxIXOIIO xxixoiio) {
        return new Integer(System.identityHashCode(xxixoiio));
    }

    public void II0xO0(String str) {
        this.f17236oIX0oI.addElement(str);
    }

    public int X0o0xo(xxIXOIIO xxixoiio) {
        return ((Integer) this.f17235II0xO0.get(I0Io(xxixoiio))).intValue();
    }

    public void XO() {
        this.f17236oIX0oI.removeAllElements();
        this.f17235II0xO0.clear();
    }

    public void oIX0oI(xxIXOIIO xxixoiio, int i) {
        Integer num;
        this.f17236oIX0oI.addElement(xxixoiio);
        switch (i) {
            case 1:
                num = f17225I0Io;
                break;
            case 2:
                num = f17232oxoX;
                break;
            case 3:
                num = f17229X0o0xo;
                break;
            case 4:
                num = f17230XO;
                break;
            case 5:
                num = f17228Oxx0IOOO;
                break;
            case 6:
                num = f17226II0XooXoX;
                break;
            case 7:
                num = f17234xxIXOIIO;
                break;
            case 8:
                num = f17233xoIox;
                break;
            case 9:
                num = f17227OOXIXo;
                break;
            case 10:
                num = f17231oOoXoXO;
                break;
            default:
                num = new Integer(i);
                break;
        }
        this.f17235II0xO0.put(I0Io(xxixoiio), num);
    }

    public Enumeration oxoX() {
        return this.f17236oIX0oI.elements();
    }

    public String toString() {
        try {
            StringBuffer stringBuffer = new StringBuffer("{ ");
            Enumeration elements = this.f17236oIX0oI.elements();
            while (elements.hasMoreElements()) {
                Object nextElement = elements.nextElement();
                if (nextElement instanceof String) {
                    stringBuffer.append("String(" + nextElement + ") ");
                } else {
                    xxIXOIIO xxixoiio = (xxIXOIIO) nextElement;
                    stringBuffer.append("Node(" + xxixoiio.Oo() + ")[" + this.f17235II0xO0.get(I0Io(xxixoiio)) + "] ");
                }
            }
            stringBuffer.append(org.apache.commons.text.ooOOo0oXI.f33074oOoXoXO);
            return stringBuffer.toString();
        } catch (IOException e) {
            return e.toString();
        }
    }
}
