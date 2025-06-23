package com.garmin.fit;

import androidx.core.provider.FontsContractCompat;
import com.garmin.fit.Decode;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes9.dex */
public class oxOXxoXII {

    /* loaded from: classes9.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f15077oIX0oI;

        static {
            int[] iArr = new int[Decode.RETURN.values().length];
            f15077oIX0oI = iArr;
            try {
                iArr[Decode.RETURN.MESG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15077oIX0oI[Decode.RETURN.END_OF_FILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006a, code lost:
    
        r0.add(java.util.Arrays.copyOfRange(r2, r7, r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Collection<byte[]> II0xO0(java.io.InputStream r7) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = r7.available()     // Catch: java.io.IOException -> L71
            byte[] r2 = new byte[r1]     // Catch: java.io.IOException -> L71
            r7.read(r2)     // Catch: java.io.IOException -> L71
            r7 = 0
        Lf:
            if (r7 >= r1) goto L68
            r3 = r2[r7]     // Catch: java.io.IOException -> L71
            int r4 = r7 + 4
            r4 = r2[r4]     // Catch: java.io.IOException -> L71
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r5 = r7 + 5
            r5 = r2[r5]     // Catch: java.io.IOException -> L71
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << 8
            r4 = r4 | r5
            int r5 = r7 + 6
            r5 = r2[r5]     // Catch: java.io.IOException -> L71
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << 16
            r4 = r4 | r5
            int r5 = r7 + 7
            r5 = r2[r5]     // Catch: java.io.IOException -> L71
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << 24
            r4 = r4 | r5
            int r5 = r7 + 8
            r5 = r2[r5]     // Catch: java.io.IOException -> L71
            r6 = 46
            if (r5 == r6) goto L3d
            goto L68
        L3d:
            int r5 = r7 + 9
            r5 = r2[r5]     // Catch: java.io.IOException -> L71
            r6 = 70
            if (r5 == r6) goto L46
            goto L68
        L46:
            int r5 = r7 + 10
            r5 = r2[r5]     // Catch: java.io.IOException -> L71
            r6 = 73
            if (r5 == r6) goto L4f
            goto L68
        L4f:
            int r5 = r7 + 11
            r5 = r2[r5]     // Catch: java.io.IOException -> L71
            r6 = 84
            if (r5 == r6) goto L58
            goto L68
        L58:
            int r3 = r3 + r4
            int r3 = r3 + 2
            int r3 = r3 + r7
            if (r3 <= r1) goto L5f
            goto L68
        L5f:
            byte[] r7 = java.util.Arrays.copyOfRange(r2, r7, r3)     // Catch: java.io.IOException -> L71
            r0.add(r7)     // Catch: java.io.IOException -> L71
            r7 = r3
            goto Lf
        L68:
            if (r7 >= r1) goto L71
            byte[] r7 = java.util.Arrays.copyOfRange(r2, r7, r1)     // Catch: java.io.IOException -> L71
            r0.add(r7)     // Catch: java.io.IOException -> L71
        L71:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.garmin.fit.oxOXxoXII.II0xO0(java.io.InputStream):java.util.Collection");
    }

    public static Collection<byte[]> oIX0oI(Collection<byte[]> collection, File file, File file2) {
        ArrayList<byte[]> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<byte[]> it = collection.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            byte[] next = it.next();
            Decode decode = new Decode();
            Decode.RETURN r7 = Decode.RETURN.CONTINUE;
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(next);
            while (true) {
                if (z) {
                    break;
                }
                int read = byteArrayInputStream.read();
                if (read < 0) {
                    System.out.println("end of stream");
                    break;
                }
                int i = oIX0oI.f15077oIX0oI[decode.x0XOIxOo((byte) read).ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        z = true;
                    }
                } else {
                    oIXoXx0 xxIXOIIO2 = decode.xxIXOIIO();
                    if (xxIXOIIO2.f14428oIX0oI.equals(FontsContractCompat.Columns.FILE_ID)) {
                        xOOxIO xooxio = new xOOxIO(xxIXOIIO2);
                        if (xooxio.xIXX().equals(file)) {
                            arrayList.add(next);
                        }
                        if (xooxio.xIXX().equals(file2)) {
                            arrayList2.add(next);
                        }
                        z = true;
                    }
                }
            }
        }
        for (byte[] bArr : collection) {
            if (arrayList2.contains(bArr)) {
                int length = bArr.length;
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    length += ((byte[]) it2.next()).length;
                }
                byte[] bArr2 = new byte[length];
                int i2 = 0;
                for (byte[] bArr3 : arrayList) {
                    System.arraycopy(bArr3, 0, bArr2, i2, bArr3.length);
                    i2 += bArr3.length;
                }
                System.arraycopy(bArr, 0, bArr2, i2, bArr.length);
                arrayList3.add(bArr2);
            } else {
                arrayList3.add(bArr);
            }
        }
        return arrayList3;
    }
}
