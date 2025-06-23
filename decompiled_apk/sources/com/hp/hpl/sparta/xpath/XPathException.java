package com.hp.hpl.sparta.xpath;

import O0.oI0IIXIo;
import O0.xxX;
import XXO0.oIX0oI;
import java.io.IOException;

/* loaded from: classes10.dex */
public class XPathException extends Exception {
    private Throwable cause_;

    public XPathException(xxX xxx2, String str) {
        super(xxx2 + " " + str);
        this.cause_ = null;
    }

    private static String toString(oI0IIXIo oi0iixio) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(tokenToString(oi0iixio));
            if (oi0iixio.f1125oIX0oI != -1) {
                oi0iixio.oIX0oI();
                stringBuffer.append(tokenToString(oi0iixio));
                oi0iixio.I0Io();
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            return "(cannot get  info: " + e + oIX0oI.I0Io.f4095I0Io;
        }
    }

    private static String tokenToString(oI0IIXIo oi0iixio) {
        int i = oi0iixio.f1125oIX0oI;
        if (i != -3) {
            if (i != -2) {
                if (i != -1) {
                    return ((char) oi0iixio.f1125oIX0oI) + "";
                }
                return "<end of expression>";
            }
            return oi0iixio.f1121II0xO0 + "";
        }
        return oi0iixio.f1119I0Io;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause_;
    }

    public XPathException(xxX xxx2, String str, oI0IIXIo oi0iixio, String str2) {
        this(xxx2, str + " got \"" + toString(oi0iixio) + "\" instead of expected " + str2);
    }

    public XPathException(xxX xxx2, Exception exc) {
        super(xxx2 + " " + exc);
        this.cause_ = exc;
    }
}
