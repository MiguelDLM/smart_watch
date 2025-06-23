package com.vtrump.vtble;

import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerPacket;

/* loaded from: classes13.dex */
public class ooXIXxIX {
    public static byte[] I0Io(X0IIOO x0iioo, byte[] bArr, double d, float f, float f2) {
        byte[] bArr2 = new byte[23];
        bArr2[0] = -1;
        bArr2[1] = -1;
        bArr2[2] = -2;
        if (x0iioo != null) {
            bArr2[3] = (byte) x0iioo.oxoX();
            bArr2[4] = (byte) x0iioo.I0Io();
            bArr2[5] = (byte) x0iioo.II0xO0();
            bArr2[6] = (byte) x0iioo.X0o0xo();
        }
        if (bArr != null) {
            bArr2[7] = bArr[0];
            bArr2[8] = bArr[1];
            bArr2[9] = bArr[2];
            bArr2[10] = bArr[3];
            bArr2[11] = bArr[4];
            bArr2[12] = bArr[5];
        }
        bArr2[13] = TransportLayerPacket.SYNC_WORD;
        bArr2[14] = 2;
        byte[] OxxIIOOXO2 = xxX.OxxIIOOXO(xxX.I0Io(d, 100));
        bArr2[15] = OxxIIOOXO2[0];
        bArr2[16] = OxxIIOOXO2[1];
        bArr2[17] = OxxIIOOXO2[2];
        bArr2[18] = OxxIIOOXO2[3];
        byte[] xoIox2 = xxX.xoIox((int) f);
        byte[] xoIox3 = xxX.xoIox((int) f2);
        bArr2[19] = xoIox2[0];
        bArr2[20] = xoIox2[1];
        bArr2[21] = xoIox3[0];
        bArr2[22] = xoIox3[1];
        return bArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01ce, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static OIoxIx.X0o0xo II0xO0(byte[] r19, int r20, java.lang.String r21, com.vtrump.vtble.X0IIOO r22) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vtrump.vtble.ooXIXxIX.II0xO0(byte[], int, java.lang.String, com.vtrump.vtble.X0IIOO):OIoxIx.X0o0xo");
    }

    public static OIoxIx.X0o0xo oIX0oI(byte[] bArr, int i) {
        double d;
        OIoxIx.X0o0xo x0o0xo = new OIoxIx.X0o0xo();
        if (i == 2002) {
            int i2 = (bArr[11] >> 4) & 15;
            double d2 = ((bArr[12] & 255) << 8) | (bArr[13] & 255);
            if (i2 == 1) {
                d = 10.0d;
            } else {
                if (i2 == 2) {
                    d = 100.0d;
                }
                x0o0xo.II0XooXoX(bArr).Oxx0IOOO(bArr[10] & 255).x0XOIxOo(bArr[3] & 255).I0Io((bArr[11] >> 4) & 15).oO(bArr[11] & 15).OOXIXo(d2).II0xO0(((bArr[14] & 255) << 24) | ((bArr[15] & 255) << 16) | ((bArr[16] & 255) << 8) | (bArr[17] & 255));
                byte[] bArr2 = new byte[6];
                System.arraycopy(bArr, 4, bArr2, 0, 6);
                x0o0xo.oxoX(xxX.OxI(bArr2));
                x0o0xo.X0o0xo(bArr);
            }
            d2 /= d;
            x0o0xo.II0XooXoX(bArr).Oxx0IOOO(bArr[10] & 255).x0XOIxOo(bArr[3] & 255).I0Io((bArr[11] >> 4) & 15).oO(bArr[11] & 15).OOXIXo(d2).II0xO0(((bArr[14] & 255) << 24) | ((bArr[15] & 255) << 16) | ((bArr[16] & 255) << 8) | (bArr[17] & 255));
            byte[] bArr22 = new byte[6];
            System.arraycopy(bArr, 4, bArr22, 0, 6);
            x0o0xo.oxoX(xxX.OxI(bArr22));
            x0o0xo.X0o0xo(bArr);
        }
        return x0o0xo;
    }

    public static byte[] oxoX(byte[] bArr, int i) {
        switch (i) {
            case 2001:
                return new byte[]{-1, -2, 23, 15, 0, 1, 2, 3, 4, 5, TransportLayerPacket.SYNC_WORD, bArr[3], bArr[4], bArr[5], bArr[6], bArr[7], bArr[8], bArr[9]};
            case 2002:
            case 2005:
                return bArr;
            case 2003:
                return new byte[]{-1, -2, 26, 65, 0, 1, 2, 3, 4, 5, TransportLayerPacket.SYNC_WORD, bArr[3], bArr[4], bArr[5], bArr[6], bArr[7], bArr[8], bArr[9]};
            case 2004:
            default:
                return new byte[0];
        }
    }
}
