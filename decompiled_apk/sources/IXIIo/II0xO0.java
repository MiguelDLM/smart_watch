package IXIIo;

/* loaded from: classes6.dex */
public abstract class II0xO0 extends IIXOooo {
    public II0xO0(byte b) {
        super(b);
    }

    @Override // IXIIo.IIXOooo
    public byte Oo() {
        return (byte) 0;
    }

    @Override // IXIIo.IIXOooo
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(super.toString()));
        stringBuffer.append(" msgId ");
        stringBuffer.append(this.f679II0xO0);
        return stringBuffer.toString();
    }
}
