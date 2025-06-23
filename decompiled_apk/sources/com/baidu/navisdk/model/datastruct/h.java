package com.baidu.navisdk.model.datastruct;

import android.text.TextUtils;
import com.baidu.navisdk.util.common.l0;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes7.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public int f6927a;
    public boolean b;
    public b c = new b();
    public a d = new a();
    public c e = new c();
    public d f = new d();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f6928a;
        public String b;
        public String c;
        public int d;

        public void a(int i) {
            this.d = this.f6928a - i;
            a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass() && this.f6928a == ((a) obj).f6928a) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f6928a;
        }

        public String toString() {
            return "DistanceInfo{distance=" + this.f6928a + ", remainDistStr='" + this.b + ", remainDistUnit='" + this.c + ", remainDist=" + this.d + '}';
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public a m86clone() {
            a aVar = new a();
            aVar.f6928a = this.f6928a;
            aVar.b = this.b;
            aVar.c = this.c;
            aVar.d = this.d;
            return aVar;
        }

        public void a() {
            StringBuilder sb = new StringBuilder();
            this.c = l0.a(this.d, sb);
            if (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0' && sb.charAt(sb.length() - 2) == '.') {
                this.b = sb.substring(0, sb.length() - 2);
            } else {
                this.b = sb.toString();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f6929a;
        public int b;
        public String c;
        public com.baidu.nplatform.comapi.basestruct.c d;
        public GeoPoint e;
        public int f = 0;
        public long g;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.b != bVar.b || this.f != bVar.f || this.g != bVar.g) {
                return false;
            }
            String str = this.f6929a;
            if (str == null ? bVar.f6929a != null : !str.equals(bVar.f6929a)) {
                return false;
            }
            String str2 = this.c;
            if (str2 == null ? bVar.c != null : !str2.equals(bVar.c)) {
                return false;
            }
            com.baidu.nplatform.comapi.basestruct.c cVar = this.d;
            if (cVar == null ? bVar.d != null : !cVar.equals(bVar.d)) {
                return false;
            }
            GeoPoint geoPoint = this.e;
            GeoPoint geoPoint2 = bVar.e;
            if (geoPoint != null) {
                return geoPoint.equals(geoPoint2);
            }
            if (geoPoint2 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2;
            int i3;
            String str = this.f6929a;
            int i4 = 0;
            if (str != null) {
                i = str.hashCode();
            } else {
                i = 0;
            }
            int i5 = i * 31;
            String str2 = this.c;
            if (str2 != null) {
                i2 = str2.hashCode();
            } else {
                i2 = 0;
            }
            int i6 = (((i5 + i2) * 31) + this.b) * 31;
            com.baidu.nplatform.comapi.basestruct.c cVar = this.d;
            if (cVar != null) {
                i3 = cVar.hashCode();
            } else {
                i3 = 0;
            }
            int i7 = (i6 + i3) * 31;
            GeoPoint geoPoint = this.e;
            if (geoPoint != null) {
                i4 = geoPoint.hashCode();
            }
            int i8 = (((i7 + i4) * 31) + this.f) * 31;
            long j = this.g;
            return i8 + ((int) (j ^ (j >>> 32)));
        }

        public String toString() {
            return "LocationInfo{cityName='" + this.f6929a + ", cityRoadName='" + this.c + ", cityId=" + this.b + ", point=" + this.d + ", geoPoint=" + this.e + ", priority=" + this.f + ", arriveTime=" + this.g + '}';
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public b m87clone() {
            b bVar = new b();
            bVar.f6929a = this.f6929a;
            bVar.b = this.b;
            bVar.c = this.c;
            com.baidu.nplatform.comapi.basestruct.c cVar = this.d;
            bVar.d = cVar == null ? null : new com.baidu.nplatform.comapi.basestruct.c(cVar);
            GeoPoint geoPoint = this.e;
            bVar.e = geoPoint != null ? new GeoPoint(geoPoint) : null;
            bVar.f = this.f;
            bVar.g = this.g;
            return bVar;
        }
    }

    /* loaded from: classes7.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public long f6930a;
        public String b;
        public int c;
        public String d;
        public String e;
        public int f;
        public boolean g;

        public c() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f6930a != cVar.f6930a || this.c != cVar.c || this.f != cVar.f || this.g != cVar.g) {
                return false;
            }
            String str = this.b;
            if (str == null ? cVar.b != null : !str.equals(cVar.b)) {
                return false;
            }
            String str2 = this.e;
            if (str2 == null ? cVar.e != null : !str2.equals(cVar.e)) {
                return false;
            }
            String str3 = this.d;
            String str4 = cVar.d;
            if (str3 != null) {
                return str3.equals(str4);
            }
            if (str4 == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "PavementUgcInfo{id=" + this.f6930a + ", roadName='" + this.b + ", description='" + this.d + ", visDescription='" + this.e + ", severityType=" + this.c + ", eventType=" + this.f + ", isUsePavementIcon='" + this.g + '}';
        }

        public c(int i, String str, String str2) {
            this.c = i;
            this.d = str;
            this.e = str2;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public c m88clone() {
            c cVar = new c();
            cVar.f6930a = this.f6930a;
            cVar.b = this.b;
            cVar.c = this.c;
            cVar.d = this.d;
            cVar.e = this.e;
            cVar.f = this.f;
            cVar.g = this.g;
            return cVar;
        }
    }

    /* loaded from: classes7.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public String f6931a;
        public String b;
        public String c;
        public String d;
        public boolean e;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.e != dVar.e) {
                return false;
            }
            String str = this.f6931a;
            if (str == null ? dVar.f6931a != null : !str.equals(dVar.f6931a)) {
                return false;
            }
            String str2 = this.b;
            if (str2 == null ? dVar.b != null : !str2.equals(dVar.b)) {
                return false;
            }
            String str3 = this.c;
            if (str3 == null ? dVar.c != null : !str3.equals(dVar.c)) {
                return false;
            }
            String str4 = this.d;
            String str5 = dVar.d;
            if (str4 != null) {
                return str4.equals(str5);
            }
            if (str5 == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "WeatherInfo{climate='" + this.f6931a + ", temperature='" + this.b + ", dayIconUrl='" + this.c + ", nightIconUrl='" + this.d + ", isCritical='" + this.e + '}';
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public d m89clone() {
            d dVar = new d();
            dVar.f6931a = this.f6931a;
            dVar.b = this.b;
            dVar.c = this.c;
            dVar.d = this.d;
            dVar.e = this.e;
            return dVar;
        }
    }

    public int a() {
        a aVar = this.d;
        if (aVar == null) {
            return -1;
        }
        return aVar.f6928a;
    }

    public int b() {
        a aVar = this.d;
        if (aVar == null) {
            return -1;
        }
        return aVar.d;
    }

    public String c() {
        a aVar = this.d;
        if (aVar == null) {
            return "";
        }
        return aVar.b;
    }

    public String d() {
        a aVar = this.d;
        if (aVar == null) {
            return "";
        }
        return aVar.c;
    }

    public boolean e() {
        if (!f() && !g()) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f6927a != hVar.f6927a) {
            return false;
        }
        d dVar = this.f;
        if (dVar == null ? hVar.f != null : !dVar.equals(hVar.f)) {
            return false;
        }
        b bVar = this.c;
        if (bVar == null ? hVar.c != null : !bVar.equals(hVar.c)) {
            return false;
        }
        a aVar = this.d;
        if (aVar == null ? hVar.d != null : !aVar.equals(hVar.d)) {
            return false;
        }
        c cVar = this.e;
        c cVar2 = hVar.e;
        if (cVar != null) {
            return cVar.equals(cVar2);
        }
        if (cVar2 == null) {
            return true;
        }
        return false;
    }

    public boolean f() {
        c cVar = this.e;
        if (cVar != null && cVar.c >= 4) {
            return true;
        }
        return false;
    }

    public boolean g() {
        d dVar = this.f;
        if (dVar != null && dVar.e) {
            return true;
        }
        return false;
    }

    public boolean h() {
        c cVar = this.e;
        if (cVar != null && cVar.c >= 4 && (!TextUtils.isEmpty(cVar.d) || !TextUtils.isEmpty(this.e.e))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4 = this.f6927a * 31;
        d dVar = this.f;
        int i5 = 0;
        if (dVar != null) {
            i = dVar.hashCode();
        } else {
            i = 0;
        }
        int i6 = (i4 + i) * 31;
        b bVar = this.c;
        if (bVar != null) {
            i2 = bVar.hashCode();
        } else {
            i2 = 0;
        }
        int i7 = (i6 + i2) * 31;
        a aVar = this.d;
        if (aVar != null) {
            i3 = aVar.hashCode();
        } else {
            i3 = 0;
        }
        int i8 = (i7 + i3) * 31;
        c cVar = this.e;
        if (cVar != null) {
            i5 = cVar.hashCode();
        }
        return i8 + i5;
    }

    public String toString() {
        return "MeteorInfo{type=" + this.f6927a + ", isCityToPavement=" + this.b + ", locationInfo=" + this.c + ", distanceInfo=" + this.d + ", pavementUgcInfo=" + this.e + ",  weatherInfo=" + this.f + ooOOo0oXI.f33074oOoXoXO;
    }

    public void a(int i) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void b(int i) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.d = i;
            aVar.a();
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public h m85clone() {
        h hVar = new h();
        hVar.f6927a = this.f6927a;
        b bVar = this.c;
        hVar.c = bVar == null ? null : bVar.m87clone();
        a aVar = this.d;
        hVar.d = aVar == null ? null : aVar.m86clone();
        c cVar = this.e;
        hVar.e = cVar == null ? null : cVar.m88clone();
        d dVar = this.f;
        hVar.f = dVar != null ? dVar.m89clone() : null;
        return hVar;
    }
}
