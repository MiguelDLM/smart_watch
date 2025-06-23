package com.jd.ad.sdk.jad_zi;

import XXO0.oIX0oI;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.lang3.xXOx;

/* loaded from: classes10.dex */
public class jad_cp implements Serializable, Comparable<jad_cp> {
    public static final char[] jad_dq = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final jad_cp jad_er = new jad_cp((byte[]) new byte[0].clone());
    public final byte[] jad_an;
    public transient int jad_bo;
    public transient String jad_cp;

    public jad_cp(byte[] bArr) {
        this.jad_an = bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int compareTo(com.jd.ad.sdk.jad_zi.jad_cp r8) {
        /*
            r7 = this;
            com.jd.ad.sdk.jad_zi.jad_cp r8 = (com.jd.ad.sdk.jad_zi.jad_cp) r8
            int r0 = r7.jad_cp()
            int r1 = r8.jad_cp()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        L10:
            if (r4 >= r2) goto L26
            byte r5 = r7.jad_an(r4)
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r6 = r8.jad_an(r4)
            r6 = r6 & 255(0xff, float:3.57E-43)
            if (r5 != r6) goto L23
            int r4 = r4 + 1
            goto L10
        L23:
            if (r5 >= r6) goto L2d
            goto L2b
        L26:
            if (r0 != r1) goto L29
            goto L2e
        L29:
            if (r0 >= r1) goto L2d
        L2b:
            r3 = -1
            goto L2e
        L2d:
            r3 = 1
        L2e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_zi.jad_cp.compareTo(java.lang.Object):int");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof jad_cp) {
            jad_cp jad_cpVar = (jad_cp) obj;
            int jad_cp = jad_cpVar.jad_cp();
            byte[] bArr = this.jad_an;
            if (jad_cp == bArr.length && jad_cpVar.jad_an(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.jad_bo;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.jad_an);
        this.jad_bo = hashCode;
        return hashCode;
    }

    public byte jad_an(int i) {
        return this.jad_an[i];
    }

    public byte[] jad_bo() {
        return this.jad_an;
    }

    public int jad_cp() {
        return this.jad_an.length;
    }

    public String jad_dq() {
        String str = this.jad_cp;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.jad_an, jad_ob.jad_an);
        this.jad_cp = str2;
        return str2;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder jad_an;
        if (this.jad_an.length == 0) {
            return "[size=0]";
        }
        String jad_dq2 = jad_dq();
        int length = jad_dq2.length();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i < length) {
                if (i2 == 64) {
                    break;
                }
                int codePointAt = jad_dq2.codePointAt(i);
                if ((!Character.isISOControl(codePointAt) || codePointAt == 10 || codePointAt == 13) && codePointAt != 65533) {
                    i2++;
                    i += Character.charCount(codePointAt);
                }
            } else {
                i = jad_dq2.length();
                break;
            }
        }
        i = -1;
        if (i == -1) {
            if (this.jad_an.length <= 64) {
                jad_an = jad_pc.jad_an("[hex=");
                jad_an.append(jad_an());
                jad_an.append("]");
            } else {
                jad_an = jad_pc.jad_an("[size=");
                jad_an.append(this.jad_an.length);
                jad_an.append(" hex=");
                jad_an.append(jad_an(0, 64).jad_an());
                jad_an.append("…]");
            }
            return jad_an.toString();
        }
        String replace = jad_dq2.substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace(xXOx.f32950X0o0xo, "\\r");
        if (i < jad_dq2.length()) {
            sb = jad_pc.jad_an("[size=");
            sb.append(this.jad_an.length);
            sb.append(" text=");
            sb.append(replace);
            sb.append("…]");
        } else {
            sb = new StringBuilder();
            sb.append("[text=");
            sb.append(replace);
            sb.append("]");
        }
        return sb.toString();
    }

    public jad_cp jad_an(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.jad_an;
        if (i2 > bArr.length) {
            StringBuilder jad_an = jad_pc.jad_an("endIndex > length(");
            jad_an.append(this.jad_an.length);
            jad_an.append(oIX0oI.I0Io.f4095I0Io);
            throw new IllegalArgumentException(jad_an.toString());
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i == 0 && i2 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return new jad_cp(bArr2);
    }

    public static jad_cp jad_an(String str) {
        jad_cp jad_cpVar = new jad_cp(str.getBytes(jad_ob.jad_an));
        jad_cpVar.jad_cp = str;
        return jad_cpVar;
    }

    public String jad_an() {
        byte[] bArr = this.jad_an;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = jad_dq;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public boolean jad_an(int i, jad_cp jad_cpVar, int i2, int i3) {
        return jad_cpVar.jad_an(i2, this.jad_an, i, i3);
    }

    public boolean jad_an(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.jad_an;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && jad_ob.jad_an(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }
}
