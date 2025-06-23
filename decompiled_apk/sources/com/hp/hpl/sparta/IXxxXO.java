package com.hp.hpl.sparta;

import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import org.apache.log4j.helpers.oI0IIXIo;

/* loaded from: classes10.dex */
public class IXxxXO extends xxIXOIIO {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public StringBuffer f17138Oxx0IOOO;

    public IXxxXO(String str) {
        this.f17138Oxx0IOOO = new StringBuffer(str);
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public Enumeration IIXOooo(String str) {
        throw new Error("Sorry, not implemented");
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public void IXxxXO(Writer writer) throws IOException {
        String stringBuffer = this.f17138Oxx0IOOO.toString();
        if (stringBuffer.length() < 50) {
            xxIXOIIO.Oxx0IOOO(writer, stringBuffer);
            return;
        }
        writer.write(oI0IIXIo.f33271oIX0oI);
        writer.write(stringBuffer);
        writer.write(oI0IIXIo.f33269II0xO0);
    }

    public void O0xOxO(char[] cArr, int i, int i2) {
        this.f17138Oxx0IOOO.append(cArr, i, i2);
        xoIox();
    }

    public void OxI(String str) {
        this.f17138Oxx0IOOO.append(str);
        xoIox();
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public Oxx0IOOO Oxx0xo(String str) {
        throw new Error("Sorry, not implemented");
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public String OxxIIOOXO(String str) {
        throw new Error("Sorry, not implemented");
    }

    public String X0IIOO() {
        return this.f17138Oxx0IOOO.toString();
    }

    public void XI0IXoo(String str) {
        this.f17138Oxx0IOOO = new StringBuffer(str);
        xoIox();
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public Object clone() {
        return new IXxxXO(this.f17138Oxx0IOOO.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IXxxXO)) {
            return false;
        }
        return this.f17138Oxx0IOOO.toString().equals(((IXxxXO) obj).f17138Oxx0IOOO.toString());
    }

    public void o00(char c) {
        this.f17138Oxx0IOOO.append(c);
        xoIox();
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public Enumeration oI0IIXIo(String str) {
        throw new Error("Sorry, not implemented");
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public int oIX0oI() {
        return this.f17138Oxx0IOOO.toString().hashCode();
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public void x0xO0oo(Writer writer) throws IOException {
        writer.write(this.f17138Oxx0IOOO.toString());
    }

    public IXxxXO(char c) {
        StringBuffer stringBuffer = new StringBuffer();
        this.f17138Oxx0IOOO = stringBuffer;
        stringBuffer.append(c);
    }
}
