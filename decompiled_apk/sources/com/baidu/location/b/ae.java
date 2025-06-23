package com.baidu.location.b;

import XIXIX.OOXIXo;
import android.annotation.TargetApi;
import android.location.GnssNavigationMessage;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class ae {

    /* renamed from: a, reason: collision with root package name */
    private static final double[] f5614a = {1999.0d, 8.0d, 22.0d, OOXIXo.f3760XO, OOXIXo.f3760XO, OOXIXo.f3760XO};
    private HashMap<String, c> b = new HashMap<>();
    private HashMap<String, String> c = new HashMap<>();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static ae f5615a = new ae();
    }

    /* loaded from: classes7.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        int f5616a = 0;
        double b = OOXIXo.f3760XO;

        public b() {
        }
    }

    /* loaded from: classes7.dex */
    public class c {
        private boolean b;
        private boolean c;
        private long d;
        private int e;
        private int f;
        private ArrayList<String> g;
        private ArrayList<Integer> h;
        private int i;
        private double j;
        private double k;
        private double l;
        private int m;
        private int n;
        private b o;

        public c(int i, int i2) {
            a(i, i2);
            this.i = 0;
            this.j = OOXIXo.f3760XO;
            this.k = OOXIXo.f3760XO;
            this.l = OOXIXo.f3760XO;
            this.m = 0;
            this.n = 0;
            this.o = new b();
        }

        private b a(int i, double d) {
            b a2 = a(ae.f5614a);
            if (d < -1.0E9d || 1.0E9d < d) {
                d = OOXIXo.f3760XO;
            }
            int i2 = (int) d;
            a2.f5616a += (i * 604800) + i2;
            a2.b = d - i2;
            return a2;
        }

        @TargetApi(24)
        private String b(GnssNavigationMessage gnssNavigationMessage) {
            byte[] data;
            StringBuilder sb = new StringBuilder();
            data = gnssNavigationMessage.getData();
            int length = data.length;
            for (int i = 0; i < length; i++) {
                String replace = String.format("%8s", Integer.toBinaryString(data[i] & 255)).replace(TokenParser.SP, '0');
                if (i % 4 == 0) {
                    replace = replace.substring(2, 8);
                }
                sb.append(replace);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String c() {
            StringBuilder sb = new StringBuilder();
            if (!this.c) {
                return sb.toString();
            }
            if (this.f == 1537) {
                d();
            }
            sb.append(this.o.f5616a);
            sb.append('|');
            boolean z = true;
            for (int i = 0; i < this.g.size(); i++) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                sb.append(this.g.get(i));
            }
            this.b = true;
            return sb.toString();
        }

        private void d() {
            int i;
            b a2 = a(this.i, this.j);
            double d = ((r1.f5616a - a2.f5616a) + a(this.i, this.k).b) - a2.b;
            if (d <= 302400.0d) {
                if (d < -302400.0d) {
                    i = this.i + 1;
                }
                this.o = a(this.i, this.l);
                this.n = this.i + 1024;
            }
            i = this.i - 1;
            this.i = i;
            this.o = a(this.i, this.l);
            this.n = this.i + 1024;
        }

        private void e(String str) {
            this.m = Integer.parseInt(str.substring(42, 46), 2);
        }

        private b a(double[] dArr) {
            int[] iArr = {1, 32, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};
            b bVar = new b();
            int i = (int) dArr[0];
            int i2 = (int) dArr[1];
            int i3 = (int) dArr[2];
            if (i >= 1970 && 2099 >= i && i2 >= 1 && 12 >= i2) {
                int i4 = (((((i - 1970) * 365) + ((i - 1969) / 4)) + iArr[i2 - 1]) + i3) - 2;
                int i5 = (i % 4 != 0 || i2 < 3) ? 0 : 1;
                int floor = (int) Math.floor(dArr[5]);
                bVar.f5616a = ((i4 + i5) * 86400) + (((int) dArr[3]) * 3600) + (((int) dArr[4]) * 60) + floor;
                bVar.b = dArr[5] - floor;
            }
            return bVar;
        }

        private void b(String str) {
            this.i = Integer.parseInt(str.substring(96, 108), 2);
            this.j = Long.parseLong(str.substring(108, 128), 2);
        }

        private void c(String str) {
            this.k = Long.parseLong(str.substring(16, 30), 2) * 60.0d;
        }

        private void d(String str) {
            this.l = Long.parseLong(str.substring(54, 68), 2) * 60;
        }

        @TargetApi(24)
        private String a(GnssNavigationMessage gnssNavigationMessage) {
            byte[] data;
            StringBuilder sb = new StringBuilder();
            data = gnssNavigationMessage.getData();
            for (byte b : data) {
                sb.append(String.format("%8s", Integer.toBinaryString(b & 255)).replace(TokenParser.SP, '0'));
            }
            return sb.toString();
        }

        private boolean b() {
            if (this.h == null) {
                return false;
            }
            for (int i = 0; i < this.h.size(); i++) {
                if (this.h.get(i).intValue() != i) {
                    return false;
                }
            }
            return true;
        }

        private void a() {
            if (this.g.size() != 0) {
                for (int i = 0; i < this.g.size(); i++) {
                    if (!this.g.get(i).contains("None")) {
                    }
                }
                this.c = true;
                return;
            }
            this.c = false;
        }

        private void a(int i, int i2) {
            int i3 = this.f;
            int i4 = 5;
            if (i3 != 257 && i3 != 769) {
                i4 = i3 != 1537 ? i3 != 1281 ? i3 != 1282 ? 0 : 10 : 3 : 6;
            }
            ArrayList<String> arrayList = this.g;
            if (arrayList != null) {
                arrayList.clear();
            } else {
                this.g = new ArrayList<>();
            }
            ArrayList<Integer> arrayList2 = this.h;
            if (arrayList2 != null) {
                arrayList2.clear();
            } else {
                this.h = new ArrayList<>();
            }
            for (int i5 = 0; i5 < i4; i5++) {
                this.g.add("None");
            }
            this.e = i;
            this.f = i2;
            this.b = false;
            this.c = false;
            this.d = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @TargetApi(24)
        public void a(GnssNavigationMessage gnssNavigationMessage, long j) {
            int type;
            int svid;
            int submessageId;
            byte[] data;
            type = gnssNavigationMessage.getType();
            svid = gnssNavigationMessage.getSvid();
            submessageId = gnssNavigationMessage.getSubmessageId();
            data = gnssNavigationMessage.getData();
            if (j - this.d > 1200 || this.b || this.g.size() == 0 || type != this.f || svid != this.e) {
                a(svid, type);
            }
            if ((type == 1282 || type == 1281) && !b()) {
                a(svid, type);
            }
            if (this.g.size() == 0) {
                return;
            }
            int i = this.f;
            boolean z = true;
            int i2 = i == 1537 ? 0 : 1;
            if (i == 1282) {
                if (submessageId != 1) {
                    return;
                }
                e(b(gnssNavigationMessage));
                submessageId = this.m;
            }
            int i3 = submessageId - i2;
            if (i3 >= this.g.size()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (byte b : data) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                sb.append((int) b);
            }
            this.g.set(i3, sb.toString());
            if (type == 1281 || type == 1282) {
                this.h.add(Integer.valueOf(i3));
            }
            if (this.f == 1537) {
                a(a(gnssNavigationMessage));
            }
            a();
            this.d = j;
        }

        private void a(String str) {
            StringBuilder sb;
            int i;
            char charAt = str.charAt(0);
            char charAt2 = str.charAt(120);
            if (charAt == '1' && charAt2 == '0') {
                sb = new StringBuilder();
                sb.append(str.substring(2, 18));
                i = 234;
            } else {
                if (charAt != '0' || charAt2 != '1') {
                    return;
                }
                sb = new StringBuilder();
                sb.append(str.substring(2, 114));
                i = 138;
            }
            sb.append(str.substring(122, i));
            String sb2 = sb.toString();
            int parseInt = Integer.parseInt(sb2.substring(0, 6), 2);
            if (parseInt == 0) {
                b(sb2);
            } else if (parseInt == 1) {
                c(sb2);
            } else if (parseInt == 4) {
                d(sb2);
            }
        }
    }

    public static ae a() {
        return a.f5615a;
    }

    public ArrayList<String> b() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, c> entry : this.b.entrySet()) {
            String key = entry.getKey();
            String c2 = entry.getValue().c();
            if (c2 != null && c2.length() != 0) {
                if (this.c.containsKey(key)) {
                    if (c2.substring(0, 100).equals(this.c.get(key).substring(0, 100))) {
                    }
                } else {
                    this.c.put(key, c2);
                }
                arrayList.add(key + '|' + c2);
            }
        }
        return arrayList;
    }

    @TargetApi(24)
    public void a(GnssNavigationMessage gnssNavigationMessage, long j) {
        int svid;
        int type;
        HashMap<String, c> hashMap;
        svid = gnssNavigationMessage.getSvid();
        type = gnssNavigationMessage.getType();
        String str = (type != 257 ? type != 769 ? type != 1537 ? type != 1281 ? type != 1282 ? "none" : "CT" : "CO" : ExifInterface.LONGITUDE_EAST : "R" : "G") + svid;
        if (str.contains("none") || (hashMap = this.b) == null) {
            return;
        }
        if (!hashMap.containsKey(str)) {
            this.b.put(str, new c(svid, type));
        }
        this.b.get(str).a(gnssNavigationMessage, j);
    }
}
