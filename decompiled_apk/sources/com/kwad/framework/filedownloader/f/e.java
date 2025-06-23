package com.kwad.framework.filedownloader.f;

/* loaded from: classes11.dex */
public class e {
    public final int ajc;
    public final long ajd;
    public final boolean aje;
    public final boolean ajf;
    public final int ajg;
    public final boolean ajh;
    public final boolean aji;

    /* loaded from: classes11.dex */
    public static class a {
        private static final e ajj = new e(0);
    }

    public /* synthetic */ e(byte b) {
        this();
    }

    public static int bL(int i) {
        if (i > 12) {
            d.d(e.class, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", Integer.valueOf(i), 12, 12);
            return 12;
        }
        if (i <= 0) {
            d.d(e.class, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", Integer.valueOf(i), 1, 1);
            return 1;
        }
        return i;
    }

    public static e xr() {
        return a.ajj;
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0052: MOVE (r15 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:95:0x0052 */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0085 A[Catch: all -> 0x0051, TryCatch #0 {all -> 0x0051, blocks: (B:57:0x0033, B:60:0x003a, B:63:0x003e, B:66:0x0042, B:68:0x0046, B:71:0x004a, B:75:0x0081, B:77:0x0085, B:79:0x0089, B:81:0x0091), top: B:4:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0091 A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:57:0x0033, B:60:0x003a, B:63:0x003e, B:66:0x0042, B:68:0x0046, B:71:0x004a, B:75:0x0081, B:77:0x0085, B:79:0x0089, B:81:0x0091), top: B:4:0x0023 }] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private e() {
        /*
            Method dump skipped, instructions count: 491
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.f.e.<init>():void");
    }
}
