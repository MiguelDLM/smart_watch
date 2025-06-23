package OoIXo;

/* loaded from: classes6.dex */
public class OxI {
    public static double II0xO0(byte[] bArr, int i) {
        boolean z;
        int oxoX2 = oo0xXOI0I.oxoX(bArr[i], bArr[i + 1], bArr[i + 2], bArr[i + 3]);
        if ((Integer.MIN_VALUE & oo0xXOI0I.oxoX(bArr[i + 4], bArr[i + 5], bArr[i + 6], bArr[i + 7])) != 0) {
            z = true;
        } else {
            z = false;
        }
        long j = (r7 & Integer.MAX_VALUE) * 4294967296L;
        long j2 = oxoX2;
        if (oxoX2 < 0) {
            j2 += 4294967296L;
        }
        double longBitsToDouble = Double.longBitsToDouble(j + j2);
        if (z) {
            return -longBitsToDouble;
        }
        return longBitsToDouble;
    }

    public static void oIX0oI(double d, byte[] bArr, int i) {
        long doubleToLongBits = Double.doubleToLongBits(d);
        bArr[i] = (byte) (255 & doubleToLongBits);
        bArr[i + 1] = (byte) ((65280 & doubleToLongBits) >> 8);
        bArr[i + 2] = (byte) ((com.garmin.fit.Oxx0IOOO.f13303I0Io & doubleToLongBits) >> 16);
        bArr[i + 3] = (byte) (((-16777216) & doubleToLongBits) >> 24);
        bArr[i + 4] = (byte) ((1095216660480L & doubleToLongBits) >> 32);
        bArr[i + 5] = (byte) ((280375465082880L & doubleToLongBits) >> 40);
        bArr[i + 6] = (byte) ((71776119061217280L & doubleToLongBits) >> 48);
        bArr[i + 7] = (byte) ((doubleToLongBits & (-72057594037927936L)) >> 56);
    }
}
