package com.vtrump.vtble;

/* loaded from: classes13.dex */
public class XIxXXX0x0 {

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f27431oxoX = "vtble." + XIxXXX0x0.class.getSimpleName();

    /* renamed from: I0Io, reason: collision with root package name */
    public byte[] f27432I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public byte f27433II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f27434oIX0oI;

    public XIxXXX0x0(int i, byte b, byte[] bArr) {
        this.f27434oIX0oI = i;
        this.f27433II0xO0 = b;
        this.f27432I0Io = bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0017, code lost:
    
        com.vtrump.vtble.Oxx0xo.oIX0oI(r6, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<com.vtrump.vtble.XIxXXX0x0> oIX0oI(byte[] r6) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
        L6:
            int r2 = r6.length
            if (r1 >= r2) goto L60
            int r2 = r1 + 1
            r3 = r6[r1]
            if (r3 != 0) goto L10
            goto L60
        L10:
            int r4 = r6.length
            if (r2 < r4) goto L1b
            java.lang.String r6 = com.vtrump.vtble.XIxXXX0x0.f27431oxoX
            java.lang.String r1 = "parseScanRecord, index >= scanRecord.len"
        L17:
            com.vtrump.vtble.Oxx0xo.oIX0oI(r6, r1)
            goto L60
        L1b:
            int r4 = r2 + r3
            int r5 = r6.length
            if (r4 <= r5) goto L40
            java.lang.String r1 = com.vtrump.vtble.XIxXXX0x0.f27431oxoX
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "parseScanRecord, index + len >= scanRecord.length , "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r3 = " , "
            r2.append(r3)
            int r6 = r6.length
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            com.vtrump.vtble.Oxx0xo.oIX0oI(r1, r6)
            goto L60
        L40:
            r2 = r6[r2]
            if (r2 != 0) goto L49
            java.lang.String r6 = com.vtrump.vtble.XIxXXX0x0.f27431oxoX
            java.lang.String r1 = "parseScanRecord, type == 0"
            goto L17
        L49:
            int r1 = r1 + 2
            if (r1 <= r4) goto L52
            java.lang.String r6 = com.vtrump.vtble.XIxXXX0x0.f27431oxoX
            java.lang.String r1 = "parseScanRecord, index + 1 > index + len"
            goto L17
        L52:
            byte[] r1 = java.util.Arrays.copyOfRange(r6, r1, r4)
            com.vtrump.vtble.XIxXXX0x0 r5 = new com.vtrump.vtble.XIxXXX0x0
            r5.<init>(r3, r2, r1)
            r0.add(r5)
            r1 = r4
            goto L6
        L60:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vtrump.vtble.XIxXXX0x0.oIX0oI(byte[]):java.util.List");
    }

    public int I0Io() {
        return this.f27434oIX0oI;
    }

    public byte[] II0xO0() {
        return this.f27432I0Io;
    }

    public byte X0o0xo() {
        return this.f27433II0xO0;
    }

    public XI0IXoo oxoX() {
        return XI0IXoo.oIX0oI(this);
    }
}
