package o0oIxXOx;

/* loaded from: classes6.dex */
public final class II0XooXoX extends oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final II0XooXoX f31149I0Io = new II0XooXoX();

    /* JADX WARN: Removed duplicated region for block: B:18:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c A[Catch: UnknownHostException -> 0x0071, TRY_LEAVE, TryCatch #0 {UnknownHostException -> 0x0071, blocks: (B:9:0x0021, B:20:0x005d, B:22:0x0062, B:24:0x0067, B:26:0x006c, B:28:0x0039, B:31:0x0043, B:34:0x004c), top: B:8:0x0021 }] */
    @Override // o0oIxXOx.OxxIIOOXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String lookup(java.lang.String r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L4
            return r0
        L4:
            java.lang.String r1 = r8.trim()
            java.lang.String r2 = "\\|"
            java.lang.String[] r1 = r1.split(r2)
            int r2 = r1.length
            r3 = 0
            r4 = r1[r3]
            java.lang.String r4 = r4.trim()
            r5 = 1
            r6 = 2
            if (r2 >= r6) goto L1b
            goto L21
        L1b:
            r8 = r1[r5]
            java.lang.String r8 = r8.trim()
        L21:
            java.net.InetAddress r8 = java.net.InetAddress.getByName(r8)     // Catch: java.net.UnknownHostException -> L71
            int r1 = r4.hashCode()     // Catch: java.net.UnknownHostException -> L71
            r2 = -1147692044(0xffffffffbb979bf4, float:-0.0046267454)
            if (r1 == r2) goto L4c
            r2 = 3373707(0x337a8b, float:4.72757E-39)
            if (r1 == r2) goto L43
            r2 = 1339224004(0x4fd2efc4, float:7.0778573E9)
            if (r1 == r2) goto L39
            goto L56
        L39:
            java.lang.String r1 = "canonical-name"
            boolean r1 = r4.equals(r1)     // Catch: java.net.UnknownHostException -> L71
            if (r1 == 0) goto L56
            r3 = 1
            goto L57
        L43:
            java.lang.String r1 = "name"
            boolean r1 = r4.equals(r1)     // Catch: java.net.UnknownHostException -> L71
            if (r1 == 0) goto L56
            goto L57
        L4c:
            java.lang.String r1 = "address"
            boolean r1 = r4.equals(r1)     // Catch: java.net.UnknownHostException -> L71
            if (r1 == 0) goto L56
            r3 = 2
            goto L57
        L56:
            r3 = -1
        L57:
            if (r3 == 0) goto L6c
            if (r3 == r5) goto L67
            if (r3 == r6) goto L62
            java.lang.String r8 = r8.getHostAddress()     // Catch: java.net.UnknownHostException -> L71
            return r8
        L62:
            java.lang.String r8 = r8.getHostAddress()     // Catch: java.net.UnknownHostException -> L71
            return r8
        L67:
            java.lang.String r8 = r8.getCanonicalHostName()     // Catch: java.net.UnknownHostException -> L71
            return r8
        L6c:
            java.lang.String r8 = r8.getHostName()     // Catch: java.net.UnknownHostException -> L71
            return r8
        L71:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o0oIxXOx.II0XooXoX.lookup(java.lang.String):java.lang.String");
    }
}
