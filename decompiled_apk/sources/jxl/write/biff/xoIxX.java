package jxl.write.biff;

/* loaded from: classes6.dex */
public class xoIxX extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f29036X0o0xo;

    public xoIxX(jxl.read.biff.oxXx0IX oxxx0ix) {
        super(OoIXo.xII.f2492oOoIIO0);
        this.f29036X0o0xo = oxxx0ix.xo0x();
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        return this.f29036X0o0xo;
    }

    public xoIxX(xoIxX xoixx) {
        super(OoIXo.xII.f2492oOoIIO0);
        byte[] bArr = new byte[xoixx.f29036X0o0xo.length];
        this.f29036X0o0xo = bArr;
        System.arraycopy(xoixx.f29036X0o0xo, 0, bArr, 0, bArr.length);
    }
}
