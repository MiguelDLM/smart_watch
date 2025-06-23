package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Pair;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes13.dex */
public final class aj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    protected int f26541a;
    protected long b;
    protected long c;
    private int d;
    private int e;
    private final Context f;
    private final int g;
    private final byte[] h;
    private final aa i;
    private final ac j;
    private final af k;
    private final ai l;
    private final int m;
    private final ah n;
    private final ah o;
    private String p;
    private final String q;
    private final Map<String, String> r;
    private boolean s;

    public aj(Context context, int i, int i2, byte[] bArr, String str, String str2, ah ahVar, boolean z) {
        this(context, i, i2, bArr, str, str2, ahVar, 2, 30000, z);
    }

    private static void a(String str) {
        al.e("[Upload] Failed to upload(%d): %s", 1, str);
    }

    public final void b(long j) {
        this.c += j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        ac acVar;
        int length;
        Pair pair;
        boolean z;
        try {
            this.f26541a = 0;
            this.b = 0L;
            this.c = 0L;
            if (ab.c(this.f) == null) {
                str = "network is not available";
            } else {
                byte[] bArr = this.h;
                if (bArr != null && bArr.length != 0) {
                    if (this.f != null && this.i != null && (acVar = this.j) != null && this.k != null) {
                        if (acVar.c() == null) {
                            str = "illegal local strategy";
                        } else {
                            str = null;
                        }
                    }
                    str = "illegal access error";
                }
                str = "request package is empty!";
            }
            if (str != null) {
                a(false, 0, str);
                return;
            }
            byte[] a2 = ap.a(this.h);
            if (a2 == null) {
                a(false, 0, "failed to zip request body");
                return;
            }
            HashMap hashMap = new HashMap(10);
            hashMap.put("tls", "1");
            hashMap.put("prodId", this.i.e());
            hashMap.put("bundleId", this.i.c);
            hashMap.put("appVer", this.i.o);
            Map<String, String> map = this.r;
            if (map != null) {
                hashMap.putAll(map);
            }
            hashMap.put("cmd", Integer.toString(this.g));
            hashMap.put(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, Byte.toString((byte) 1));
            hashMap.put(com.huawei.openalliance.ad.constant.aw.aQ, this.i.h);
            hashMap.put("strategylastUpdateTime", Long.toString(this.j.c().o));
            this.l.a(this.m, System.currentTimeMillis());
            String str2 = this.p;
            this.j.c();
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = i + 1;
                if (i < this.d) {
                    if (i3 > 1) {
                        al.d("[Upload] Failed to upload last time, wait and try(%d) again.", Integer.valueOf(i3));
                        ap.b(this.e);
                        if (i3 == this.d) {
                            al.d("[Upload] Use the back-up url at the last time: %s", this.q);
                            str2 = this.q;
                        }
                    }
                    al.c("[Upload] Send %d bytes", Integer.valueOf(a2.length));
                    str2 = b(str2);
                    al.c("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", str2, Integer.valueOf(this.g), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    byte[] a3 = this.k.a(str2, a2, this, hashMap);
                    Map<String, String> map2 = this.k.c;
                    Pair<Boolean, Boolean> a4 = a(a3, map2);
                    if (!((Boolean) a4.first).booleanValue()) {
                        z = ((Boolean) a4.second).booleanValue();
                    } else {
                        Pair<Boolean, Boolean> a5 = a(map2);
                        if (!((Boolean) a5.first).booleanValue()) {
                            z = ((Boolean) a5.second).booleanValue();
                        } else {
                            byte[] b = ap.b(a3);
                            if (b != null) {
                                a3 = b;
                            }
                            br a6 = ae.a(a3);
                            if (a6 == null) {
                                a(false, 1, "failed to decode response package");
                                Boolean bool = Boolean.FALSE;
                                pair = new Pair(bool, bool);
                            } else {
                                Integer valueOf = Integer.valueOf(a6.b);
                                byte[] bArr2 = a6.c;
                                if (bArr2 == null) {
                                    length = 0;
                                } else {
                                    length = bArr2.length;
                                }
                                al.c("[Upload] Response cmd is: %d, length of sBuffer is: %d", valueOf, Integer.valueOf(length));
                                if (!a(a6, this.i, this.j)) {
                                    a(false, 2, "failed to process response package");
                                    Boolean bool2 = Boolean.FALSE;
                                    pair = new Pair(bool2, bool2);
                                } else {
                                    a(true, 2, "successfully uploaded");
                                    Boolean bool3 = Boolean.TRUE;
                                    pair = new Pair(bool3, bool3);
                                }
                            }
                            if (!((Boolean) pair.first).booleanValue()) {
                                z = ((Boolean) pair.second).booleanValue();
                            } else {
                                z = false;
                            }
                        }
                    }
                    if (z) {
                        i = i3;
                        i2 = 1;
                    } else {
                        return;
                    }
                } else {
                    a(false, i2, "failed after many attempts");
                    return;
                }
            }
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
    }

    public aj(Context context, int i, int i2, byte[] bArr, String str, String str2, ah ahVar, int i3, int i4, boolean z) {
        this.d = 2;
        this.e = 30000;
        this.p = null;
        this.f26541a = 0;
        this.b = 0L;
        this.c = 0L;
        this.s = false;
        this.f = context;
        this.i = aa.a(context);
        this.h = bArr;
        this.j = ac.a();
        if (af.f26528a == null) {
            af.f26528a = new af(context);
        }
        this.k = af.f26528a;
        ai a2 = ai.a();
        this.l = a2;
        this.m = i;
        this.p = str;
        this.q = str2;
        this.n = ahVar;
        this.o = a2.f26535a;
        this.g = i2;
        if (i3 > 0) {
            this.d = i3;
        }
        if (i4 > 0) {
            this.e = i4;
        }
        this.s = z;
        this.r = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(boolean r5, int r6, java.lang.String r7) {
        /*
            r4 = this;
            r0 = 0
            r1 = 1
            int r2 = r4.g
            r3 = 630(0x276, float:8.83E-43)
            if (r2 == r3) goto L1d
            r3 = 640(0x280, float:8.97E-43)
            if (r2 == r3) goto L19
            r3 = 830(0x33e, float:1.163E-42)
            if (r2 == r3) goto L1d
            r3 = 840(0x348, float:1.177E-42)
            if (r2 == r3) goto L19
            java.lang.String r2 = java.lang.String.valueOf(r2)
            goto L1f
        L19:
            java.lang.String r2 = "userinfo"
            goto L1f
        L1d:
            java.lang.String r2 = "crash"
        L1f:
            if (r5 == 0) goto L2b
            java.lang.String r6 = "[Upload] Success: %s"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r2
            com.tencent.bugly.proguard.al.a(r6, r1)
            goto L3e
        L2b:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r0] = r6
            r3[r1] = r2
            r6 = 2
            r3[r6] = r7
            java.lang.String r6 = "[Upload] Failed to upload(%d) %s: %s"
            com.tencent.bugly.proguard.al.e(r6, r3)
        L3e:
            long r0 = r4.b
            long r2 = r4.c
            long r0 = r0 + r2
            r2 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 <= 0) goto L5e
            com.tencent.bugly.proguard.ai r6 = r4.l
            boolean r0 = r4.s
            long r0 = r6.a(r0)
            long r2 = r4.b
            long r0 = r0 + r2
            long r2 = r4.c
            long r0 = r0 + r2
            com.tencent.bugly.proguard.ai r6 = r4.l
            boolean r2 = r4.s
            r6.a(r0, r2)
        L5e:
            com.tencent.bugly.proguard.ah r6 = r4.n
            if (r6 == 0) goto L65
            r6.a(r5, r7)
        L65:
            com.tencent.bugly.proguard.ah r6 = r4.o
            if (r6 == 0) goto L6c
            r6.a(r5, r7)
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.aj.a(boolean, int, java.lang.String):void");
    }

    private static String b(String str) {
        if (ap.b(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            al.a(th);
            return str;
        }
    }

    private static boolean a(br brVar, aa aaVar, ac acVar) {
        if (brVar == null) {
            al.d("resp == null!", new Object[0]);
            return false;
        }
        byte b = brVar.f26603a;
        if (b != 0) {
            al.e("resp result error %d", Byte.valueOf(b));
            return false;
        }
        try {
            if (!ap.b(brVar.g) && !aa.b().i().equals(brVar.g)) {
                w.a().a(ac.f26526a, DeviceRequestsHelper.DEVICE_INFO_DEVICE, brVar.g.getBytes("UTF-8"), true);
                aaVar.d(brVar.g);
            }
        } catch (Throwable th) {
            al.a(th);
        }
        aaVar.m = brVar.e;
        int i = brVar.b;
        if (i == 510) {
            byte[] bArr = brVar.c;
            if (bArr == null) {
                al.e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(i));
                return false;
            }
            bt btVar = (bt) ae.a(bArr, bt.class);
            if (btVar == null) {
                al.e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(brVar.b));
                return false;
            }
            acVar.a(btVar);
        }
        return true;
    }

    private Pair<Boolean, Boolean> a(byte[] bArr, Map<String, String> map) {
        if (bArr == null) {
            a("Failed to upload for no response!");
            return new Pair<>(Boolean.FALSE, Boolean.TRUE);
        }
        al.c("[Upload] Received %d bytes", Integer.valueOf(bArr.length));
        if (bArr.length == 0) {
            a(false, 1, "response data from server is empty");
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    al.c("[Upload] HTTP headers from server: key = %s, value = %s", entry.getKey(), entry.getValue());
                }
            }
            Boolean bool = Boolean.FALSE;
            return new Pair<>(bool, bool);
        }
        Boolean bool2 = Boolean.TRUE;
        return new Pair<>(bool2, bool2);
    }

    public final void a(long j) {
        this.f26541a++;
        this.b += j;
    }

    private Pair<Boolean, Boolean> a(Map<String, String> map) {
        int i;
        if (map != null && map.size() != 0) {
            if (!map.containsKey("status")) {
                al.d("[Upload] Headers does not contain %s", "status");
            } else if (!map.containsKey("Bugly-Version")) {
                al.d("[Upload] Headers does not contain %s", "Bugly-Version");
            } else {
                String str = map.get("Bugly-Version");
                if (!str.contains("bugly")) {
                    al.d("[Upload] Bugly version is not valid: %s", str);
                } else {
                    al.c("[Upload] Bugly version from headers is: %s", str);
                    try {
                        i = Integer.parseInt(map.get("status"));
                        try {
                            al.c("[Upload] Status from server is %d (pid=%d | tid=%d).", Integer.valueOf(i), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                            if (i != 0) {
                                a(false, 1, "status of server is ".concat(String.valueOf(i)));
                                Boolean bool = Boolean.FALSE;
                                return new Pair<>(bool, bool);
                            }
                            Boolean bool2 = Boolean.TRUE;
                            return new Pair<>(bool2, bool2);
                        } catch (Throwable unused) {
                            a("[Upload] Failed to upload for format of status header is invalid: " + Integer.toString(i));
                            return new Pair<>(Boolean.FALSE, Boolean.TRUE);
                        }
                    } catch (Throwable unused2) {
                        i = -1;
                    }
                }
            }
        } else {
            al.d("[Upload] Headers is empty.", new Object[0]);
        }
        al.c("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        a("[Upload] Failed to upload for no status header.");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                al.c(String.format("[key]: %s, [value]: %s", entry.getKey(), entry.getValue()), new Object[0]);
            }
        }
        al.c("[Upload] Failed to upload for no status header.", new Object[0]);
        return new Pair<>(Boolean.FALSE, Boolean.TRUE);
    }
}
