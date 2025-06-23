package com.jd.ad.sdk.jad_mz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_dq {
    public static final int[] jad_an = {2, 3, 4, 5, 6, 7, 8, 9};

    /* loaded from: classes10.dex */
    public static class jad_an {
        public static final jad_dq jad_an = new jad_dq();
    }

    public int jad_an(boolean z, int i) {
        if (i == 1) {
            return z ? 6 : 2;
        }
        if (i == 2) {
            return z ? 9 : 5;
        }
        if (i == 4) {
            return z ? 7 : 3;
        }
        if (i != 5) {
            return -1;
        }
        return z ? 8 : 4;
    }

    public final boolean jad_an(List<com.jd.ad.sdk.jad_na.jad_hu> list) {
        if (list.size() == 0) {
            return false;
        }
        Iterator<com.jd.ad.sdk.jad_na.jad_hu> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().jad_an == 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        r0 = r4.jad_bo;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003f, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0054, code lost:
    
        r7 = jad_an(r7, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
    
        if (r7 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005e, code lost:
    
        if (r7.size() > 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
    
        if (r7.contains(r8) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0042, code lost:
    
        r1 = new java.util.ArrayList();
        r1.addAll(java.util.Arrays.asList(r0.split(",")));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean jad_an(int r7, java.lang.String r8) {
        /*
            r6 = this;
            com.jd.ad.sdk.jad_na.jad_cp r0 = com.jd.ad.sdk.jad_pc.jad_an.jad_cp()
            r1 = 0
            if (r0 != 0) goto L9
            r0 = r1
            goto Lb
        L9:
            java.util.List<com.jd.ad.sdk.jad_na.jad_hu> r0 = r0.jad_hu
        Lb:
            r2 = 0
            if (r0 == 0) goto L74
            int r3 = r0.size()
            if (r3 != 0) goto L15
            goto L74
        L15:
            boolean r3 = r6.jad_an(r0)     // Catch: java.lang.Exception -> L68
            if (r3 != 0) goto L6f
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> L68
        L1f:
            boolean r4 = r0.hasNext()     // Catch: java.lang.Exception -> L68
            if (r4 == 0) goto L6f
            java.lang.Object r4 = r0.next()     // Catch: java.lang.Exception -> L68
            com.jd.ad.sdk.jad_na.jad_hu r4 = (com.jd.ad.sdk.jad_na.jad_hu) r4     // Catch: java.lang.Exception -> L68
            int r5 = r4.jad_an     // Catch: java.lang.Exception -> L68
            if (r5 != r7) goto L1f
            r0 = 0
        L30:
            int[] r3 = com.jd.ad.sdk.jad_mz.jad_dq.jad_an     // Catch: java.lang.Exception -> L68
            int r5 = r3.length     // Catch: java.lang.Exception -> L68
            if (r0 >= r5) goto L6d
            r3 = r3[r0]     // Catch: java.lang.Exception -> L68
            if (r7 != r3) goto L6a
            java.lang.String r0 = r4.jad_bo     // Catch: java.lang.Exception -> L68
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L68
            if (r3 == 0) goto L42
            goto L54
        L42:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Exception -> L68
            r1.<init>()     // Catch: java.lang.Exception -> L68
            java.lang.String r3 = ","
            java.lang.String[] r0 = r0.split(r3)     // Catch: java.lang.Exception -> L68
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch: java.lang.Exception -> L68
            r1.addAll(r0)     // Catch: java.lang.Exception -> L68
        L54:
            java.util.List r7 = r6.jad_an(r7, r1)     // Catch: java.lang.Exception -> L68
            if (r7 == 0) goto L6d
            int r0 = r7.size()     // Catch: java.lang.Exception -> L68
            if (r0 > 0) goto L61
            goto L6d
        L61:
            boolean r7 = r7.contains(r8)     // Catch: java.lang.Exception -> L68
            if (r7 == 0) goto L70
            goto L6d
        L68:
            r7 = move-exception
            goto L71
        L6a:
            int r0 = r0 + 1
            goto L30
        L6d:
            r2 = 1
            goto L70
        L6f:
            r2 = r3
        L70:
            return r2
        L71:
            r7.printStackTrace()
        L74:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_mz.jad_dq.jad_an(int, java.lang.String):boolean");
    }

    public List<String> jad_an(int i, List<String> list) {
        int i2;
        ArrayList arrayList;
        List<com.jd.ad.sdk.jad_na.jad_er> list2;
        if (list != null && list.size() > 0) {
            switch (i) {
                case 2:
                case 6:
                    i2 = 1;
                    break;
                case 3:
                case 7:
                    i2 = 4;
                    break;
                case 4:
                case 8:
                    i2 = 5;
                    break;
                case 5:
                case 9:
                    i2 = 2;
                    break;
                default:
                    i2 = -1;
                    break;
            }
            com.jd.ad.sdk.jad_na.jad_cp jad_cp = com.jd.ad.sdk.jad_pc.jad_an.jad_cp();
            if (jad_cp == null || (list2 = jad_cp.jad_jt) == null || list2.size() <= 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                for (com.jd.ad.sdk.jad_na.jad_er jad_erVar : list2) {
                    if (jad_erVar != null && i2 == jad_erVar.jad_bo) {
                        arrayList.add(jad_erVar.jad_an);
                    }
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (String str : list) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (str.equals((String) it.next())) {
                            arrayList2.add(str);
                        }
                    }
                }
                return arrayList2;
            }
        }
        return null;
    }
}
