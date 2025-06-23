package XxXX;

/* loaded from: classes13.dex */
public final class xoIox implements Cloneable {

    /* renamed from: XO, reason: collision with root package name */
    public long f4232XO;

    public xoIox(long j) {
        this.f4232XO = j;
    }

    public long II0xO0() {
        return this.f4232XO;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof xoIox) || this.f4232XO != ((xoIox) obj).II0xO0()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (int) this.f4232XO;
    }

    public byte[] oIX0oI() {
        long j = this.f4232XO;
        return new byte[]{(byte) (255 & j), (byte) ((65280 & j) >> 8), (byte) ((com.garmin.fit.Oxx0IOOO.f13303I0Io & j) >> 16), (byte) ((j & 4278190080L) >> 24)};
    }
}
