package com.jd.ad.sdk.jad_ud;

import com.jd.ad.sdk.jad_js.jad_zm;
import java.io.Closeable;
import java.util.Arrays;

/* loaded from: classes10.dex */
public abstract class jad_cp implements Closeable {
    public static final String[] jad_er = new String[128];
    public int jad_an;
    public int[] jad_bo = new int[32];
    public String[] jad_cp = new String[32];
    public int[] jad_dq = new int[32];

    /* loaded from: classes10.dex */
    public static final class jad_an {
        public final String[] jad_an;
        public final com.jd.ad.sdk.jad_zi.jad_fs jad_bo;

        public jad_an(String[] strArr, com.jd.ad.sdk.jad_zi.jad_fs jad_fsVar) {
            this.jad_an = strArr;
            this.jad_bo = jad_fsVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x003c A[Catch: IOException -> 0x002b, TryCatch #0 {IOException -> 0x002b, blocks: (B:2:0x0000, B:3:0x000a, B:5:0x000d, B:7:0x001e, B:9:0x0026, B:13:0x0048, B:15:0x003c, B:16:0x003f, B:27:0x004d, B:28:0x0050, B:30:0x0058, B:31:0x005e, B:34:0x0067, B:35:0x006c, B:38:0x006d), top: B:1:0x0000, inners: #1 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static com.jd.ad.sdk.jad_ud.jad_cp.jad_an jad_an(java.lang.String... r12) {
            /*
                int r0 = r12.length     // Catch: java.io.IOException -> L2b
                com.jd.ad.sdk.jad_zi.jad_cp[] r0 = new com.jd.ad.sdk.jad_zi.jad_cp[r0]     // Catch: java.io.IOException -> L2b
                com.jd.ad.sdk.jad_zi.jad_an r1 = new com.jd.ad.sdk.jad_zi.jad_an     // Catch: java.io.IOException -> L2b
                r1.<init>()     // Catch: java.io.IOException -> L2b
                r2 = 0
                r3 = 0
            La:
                int r4 = r12.length     // Catch: java.io.IOException -> L2b
                if (r3 >= r4) goto L6d
                r4 = r12[r3]     // Catch: java.io.IOException -> L2b
                java.lang.String[] r5 = com.jd.ad.sdk.jad_ud.jad_cp.jad_er     // Catch: java.io.IOException -> L2b
                r6 = 34
                r1.jad_bo(r6)     // Catch: java.io.IOException -> L2b
                int r7 = r4.length()     // Catch: java.io.IOException -> L2b
                r8 = 0
                r9 = 0
            L1c:
                if (r8 >= r7) goto L4b
                char r10 = r4.charAt(r8)     // Catch: java.io.IOException -> L2b
                r11 = 128(0x80, float:1.8E-43)
                if (r10 >= r11) goto L2d
                r10 = r5[r10]     // Catch: java.io.IOException -> L2b
                if (r10 != 0) goto L3a
                goto L48
            L2b:
                r12 = move-exception
                goto L7d
            L2d:
                r11 = 8232(0x2028, float:1.1535E-41)
                if (r10 != r11) goto L34
                java.lang.String r10 = "\\u2028"
                goto L3a
            L34:
                r11 = 8233(0x2029, float:1.1537E-41)
                if (r10 != r11) goto L48
                java.lang.String r10 = "\\u2029"
            L3a:
                if (r9 >= r8) goto L3f
                r1.jad_an(r4, r9, r8)     // Catch: java.io.IOException -> L2b
            L3f:
                int r9 = r10.length()     // Catch: java.io.IOException -> L2b
                r1.jad_an(r10, r2, r9)     // Catch: java.io.IOException -> L2b
                int r9 = r8 + 1
            L48:
                int r8 = r8 + 1
                goto L1c
            L4b:
                if (r9 >= r7) goto L50
                r1.jad_an(r4, r9, r7)     // Catch: java.io.IOException -> L2b
            L50:
                r1.jad_bo(r6)     // Catch: java.io.IOException -> L2b
                r1.jad_bo()     // Catch: java.io.IOException -> L2b
                com.jd.ad.sdk.jad_zi.jad_cp r4 = new com.jd.ad.sdk.jad_zi.jad_cp     // Catch: java.io.IOException -> L2b
                long r5 = r1.jad_bo     // Catch: java.io.IOException -> L2b java.io.EOFException -> L66
                byte[] r5 = r1.jad_cp(r5)     // Catch: java.io.IOException -> L2b java.io.EOFException -> L66
                r4.<init>(r5)     // Catch: java.io.IOException -> L2b
                r0[r3] = r4     // Catch: java.io.IOException -> L2b
                int r3 = r3 + 1
                goto La
            L66:
                r12 = move-exception
                java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch: java.io.IOException -> L2b
                r0.<init>(r12)     // Catch: java.io.IOException -> L2b
                throw r0     // Catch: java.io.IOException -> L2b
            L6d:
                com.jd.ad.sdk.jad_ud.jad_cp$jad_an r1 = new com.jd.ad.sdk.jad_ud.jad_cp$jad_an     // Catch: java.io.IOException -> L2b
                java.lang.Object r12 = r12.clone()     // Catch: java.io.IOException -> L2b
                java.lang.String[] r12 = (java.lang.String[]) r12     // Catch: java.io.IOException -> L2b
                com.jd.ad.sdk.jad_zi.jad_fs r0 = com.jd.ad.sdk.jad_zi.jad_fs.jad_an(r0)     // Catch: java.io.IOException -> L2b
                r1.<init>(r12, r0)     // Catch: java.io.IOException -> L2b
                return r1
            L7d:
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>(r12)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_ud.jad_cp.jad_an.jad_an(java.lang.String[]):com.jd.ad.sdk.jad_ud.jad_cp$jad_an");
        }
    }

    static {
        for (int i = 0; i <= 31; i++) {
            jad_er[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = jad_er;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public abstract int jad_an(jad_an jad_anVar);

    public final jad_bo jad_an(String str) {
        throw new jad_bo(str + " at path " + jad_fs());
    }

    public abstract void jad_bo();

    public abstract void jad_cp();

    public abstract void jad_dq();

    public abstract void jad_er();

    public final String jad_fs() {
        int i = this.jad_an;
        int[] iArr = this.jad_bo;
        String[] strArr = this.jad_cp;
        int[] iArr2 = this.jad_dq;
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (i3 != 1 && i3 != 2) {
                if (i3 == 3 || i3 == 4 || i3 == 5) {
                    sb.append('.');
                    String str = strArr[i2];
                    if (str != null) {
                        sb.append(str);
                    }
                }
            } else {
                sb.append('[');
                sb.append(iArr2[i2]);
                sb.append(']');
            }
        }
        return sb.toString();
    }

    public abstract boolean jad_hu();

    public abstract double jad_iv();

    public abstract boolean jad_jt();

    public abstract int jad_jw();

    public abstract String jad_kx();

    public abstract String jad_ly();

    public abstract int jad_mz();

    public abstract void jad_na();

    public abstract void jad_ob();

    public final void jad_an(int i) {
        int i2 = this.jad_an;
        int[] iArr = this.jad_bo;
        if (i2 == iArr.length) {
            if (i2 == 256) {
                StringBuilder jad_an2 = jad_zm.jad_an("Nesting too deep at ");
                jad_an2.append(jad_fs());
                throw new com.jd.ad.sdk.jad_ud.jad_an(jad_an2.toString());
            }
            this.jad_bo = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.jad_cp;
            this.jad_cp = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.jad_dq;
            this.jad_dq = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.jad_bo;
        int i3 = this.jad_an;
        this.jad_an = i3 + 1;
        iArr3[i3] = i;
    }
}
