package XxXX;

/* loaded from: classes13.dex */
public final class OOXIXo implements Cloneable {

    /* renamed from: XO, reason: collision with root package name */
    public int f4222XO;

    public OOXIXo(byte[] bArr) {
        this(bArr, 0);
    }

    public int II0xO0() {
        return this.f4222XO;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof OOXIXo) || this.f4222XO != ((OOXIXo) obj).II0xO0()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f4222XO;
    }

    public byte[] oIX0oI() {
        int i = this.f4222XO;
        return new byte[]{(byte) (i & 255), (byte) ((i & 65280) >> 8)};
    }

    public OOXIXo(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] << 8) & 65280;
        this.f4222XO = i2;
        this.f4222XO = i2 + (bArr[i] & 255);
    }

    public OOXIXo(int i) {
        this.f4222XO = i;
    }
}
