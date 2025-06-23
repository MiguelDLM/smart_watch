package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.util.Base64;
import com.baidu.location.BDLocation;
import com.baidu.mobads.sdk.internal.cn;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes7.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f5640a = null;
    private boolean b = false;
    private Deque<String> c = new LinkedList();
    private Deque<String> d = new LinkedList();
    private Deque<String> e = new LinkedList();
    private int f = 5;
    private int g = 5;
    private int h = 1;
    private int i = 1;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static h f5641a = new h();
    }

    public static h a() {
        return a.f5641a;
    }

    public String b() {
        return a(this.i, this.h);
    }

    public synchronized String c() {
        return a(this.i, this.h);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a(int r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            r1 = 1
            if (r5 != r1) goto L23
            java.util.Deque<java.lang.String> r5 = r4.e
            java.lang.String r5 = r4.c(r5)
            boolean r2 = r0.equals(r5)
            if (r2 != 0) goto L23
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "&ll_pre="
            r2.append(r3)
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            goto L24
        L23:
            r5 = r0
        L24:
            if (r6 != r1) goto L66
            java.util.Deque<java.lang.String> r6 = r4.c
            java.lang.String r6 = r4.b(r6)
            boolean r1 = r0.equals(r6)
            if (r1 != 0) goto L46
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            java.lang.String r5 = "&cl_pre="
            r1.append(r5)
            r1.append(r6)
            java.lang.String r5 = r1.toString()
        L46:
            java.util.Deque<java.lang.String> r6 = r4.d
            java.lang.String r6 = r4.b(r6)
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L66
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r5 = "&wf_pre="
            r0.append(r5)
            r0.append(r6)
            java.lang.String r5 = r0.toString()
        L66:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.h.a(int, int):java.lang.String");
    }

    private String b(Deque<String> deque) {
        if (deque == null || deque.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String peekFirst = deque.peekFirst();
        if (peekFirst != null) {
            try {
                String[] split = peekFirst.split(",");
                int i = 0;
                for (String str : deque) {
                    if (split.length != 3) {
                        break;
                    }
                    String[] split2 = str.split(",");
                    if (i == 0) {
                        sb.append(peekFirst);
                    } else if (split2.length != 3) {
                        i++;
                    } else {
                        try {
                            sb.append((int) ((Double.parseDouble(split[0]) - Double.parseDouble(split2[0])) * Math.pow(10.0d, 6.0d)));
                            sb.append(",");
                            sb.append((int) ((Double.parseDouble(split[1]) - Double.parseDouble(split2[1])) * Math.pow(10.0d, 6.0d)));
                            sb.append(",");
                            sb.append(Long.parseLong(split[2]) - Long.parseLong(split2[2]));
                        } catch (Exception unused) {
                        }
                    }
                    if (i != deque.size() - 1) {
                        sb.append("|");
                    }
                    i++;
                }
            } catch (Exception unused2) {
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0106 A[Catch: Exception -> 0x0111, TRY_LEAVE, TryCatch #2 {Exception -> 0x0111, blocks: (B:11:0x0019, B:12:0x0023, B:14:0x0029, B:16:0x0035, B:40:0x003c, B:25:0x00fe, B:27:0x0106, B:18:0x0042), top: B:10:0x0019 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String c(java.util.Deque<java.lang.String> r19) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.h.c(java.util.Deque):java.lang.String");
    }

    private void b(String str, Deque<String> deque) {
        if (str == null || "".equals(str)) {
            return;
        }
        deque.addAll(Arrays.asList(new String(Base64.decode(str.getBytes(), 0)).split("\\|")));
    }

    public void a(Context context) {
        if (this.f5640a == null) {
            this.f5640a = ad.a().b(context);
        }
        SharedPreferences sharedPreferences = this.f5640a;
        if (sharedPreferences == null || this.b) {
            return;
        }
        try {
            String string = sharedPreferences.getString("cl_pre", "");
            String string2 = this.f5640a.getString("wf_pre", "");
            String string3 = this.f5640a.getString("ll_pre", "");
            a(string, this.c);
            a(string2, this.d);
            b(string3, this.e);
        } catch (Exception unused) {
        }
        this.b = true;
    }

    public synchronized void a(BDLocation bDLocation, String str, Location location) {
        Deque<String> deque;
        String str2;
        if (bDLocation != null) {
            if ("gcj02".equals(str)) {
                String networkLocationType = bDLocation.getNetworkLocationType();
                int locType = bDLocation.getLocType();
                if (locType == 61 || locType == 161) {
                    if (networkLocationType == null) {
                        networkLocationType = "null";
                    }
                    if (networkLocationType.contains("wf") && this.h == 1) {
                        this.d.offerFirst(bDLocation.getLongitude() + "," + bDLocation.getLatitude() + "," + com.baidu.location.e.o.c(bDLocation.getTime()));
                        deque = this.d;
                        str2 = "wf";
                    } else {
                        if (!networkLocationType.contains("cl") || this.h != 1) {
                            if (locType == 61 && this.i == 1 && location != null) {
                                int radius = (int) bDLocation.getRadius();
                                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                                DecimalFormat decimalFormat2 = new DecimalFormat(cn.d);
                                DecimalFormat decimalFormat3 = new DecimalFormat("0.000000");
                                this.e.offerFirst(bDLocation.getSatelliteNumber() + "," + radius + "," + decimalFormat.format(bDLocation.getAltitude()) + "," + com.baidu.location.e.o.c(bDLocation.getTime()) + "," + decimalFormat2.format(bDLocation.getSpeed()) + "," + decimalFormat3.format(location.getLongitude()) + "," + decimalFormat3.format(location.getLatitude()));
                                a(this.e);
                            }
                        }
                        this.c.offerFirst(bDLocation.getLongitude() + "," + bDLocation.getLatitude() + "," + com.baidu.location.e.o.c(bDLocation.getTime()));
                        deque = this.c;
                        str2 = "cl";
                    }
                    a(deque, str2);
                }
            }
        }
    }

    private void a(String str, Deque<String> deque) {
        if (str == null || "".equals(str)) {
            return;
        }
        deque.addAll(Arrays.asList(new String(Base64.decode(str.getBytes(), 0)).split("\\|")));
    }

    private void a(Deque<String> deque) {
        if (deque == null || deque.isEmpty()) {
            return;
        }
        while (deque.size() > this.g) {
            deque.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = deque.iterator();
        int i = 0;
        while (it.hasNext()) {
            sb.append(it.next());
            if (i != deque.size() - 1) {
                sb.append("|");
            }
            i++;
        }
        try {
            String str = new String(Base64.encode(sb.toString().getBytes(), 0));
            SharedPreferences.Editor edit = this.f5640a.edit();
            edit.putString("ll_pre", str);
            edit.commit();
        } catch (Exception unused) {
        }
    }

    private void a(Deque<String> deque, String str) {
        if (deque == null || deque.isEmpty()) {
            return;
        }
        while (deque.size() > this.f) {
            deque.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = deque.iterator();
        int i = 0;
        while (it.hasNext()) {
            sb.append(it.next());
            if (i != deque.size() - 1) {
                sb.append("|");
            }
            i++;
        }
        try {
            String str2 = new String(Base64.encode(sb.toString().getBytes(), 0));
            SharedPreferences.Editor edit = this.f5640a.edit();
            edit.putString(str + "_pre", str2);
            edit.commit();
        } catch (Exception unused) {
        }
    }
}
