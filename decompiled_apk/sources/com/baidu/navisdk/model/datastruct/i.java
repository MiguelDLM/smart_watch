package com.baidu.navisdk.model.datastruct;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.util.common.LogUtil;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class i {
    private static SimpleDateFormat c;

    /* renamed from: a, reason: collision with root package name */
    private long f6932a;
    private ArrayList<j> b;

    static {
        boolean z = LogUtil.LOGGABLE;
        c = new SimpleDateFormat(DateFormatUtils.YYYY_MM_DD_HH_MM);
    }

    @Nullable
    private j e(@NonNull String str) {
        ArrayList<j> arrayList = this.b;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<j> it = this.b.iterator();
            while (it.hasNext()) {
                j next = it.next();
                if (next != null && TextUtils.equals(next.c(), str)) {
                    return next.m91clone();
                }
            }
        }
        return null;
    }

    public void a(ArrayList<j> arrayList) {
        this.b = arrayList;
    }

    public ArrayList<j> b() {
        if (this.b == null) {
            return null;
        }
        return new ArrayList<>(this.b);
    }

    public boolean c() {
        ArrayList<j> arrayList = this.b;
        boolean z = true;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<j> it = this.b.iterator();
            while (it.hasNext()) {
                j next = it.next();
                if (next != null && !next.f()) {
                    z = false;
                }
            }
        }
        return z;
    }

    @Nullable
    public ArrayList<h> d(@NonNull String str) {
        j e = e(str);
        if (e == null) {
            return null;
        }
        return e.e();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        ArrayList<j> arrayList = this.b;
        if (arrayList != null) {
            return arrayList.equals(iVar.b);
        }
        if (iVar.b == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        long j = this.f6932a;
        int i2 = ((int) (j ^ (j >>> 32))) * 31;
        ArrayList<j> arrayList = this.b;
        if (arrayList != null) {
            i = arrayList.hashCode();
        } else {
            i = 0;
        }
        return i2 + i;
    }

    public String toString() {
        return "MeteorsAllRoute{meteorsSingleRouteList=" + this.b + ", latestWeatherUpdateTime=" + this.f6932a + '}';
    }

    @Nullable
    public ArrayList<h> a(int i) {
        j c2 = c(i);
        if (c2 == null) {
            return null;
        }
        return c2.a();
    }

    @Nullable
    public ArrayList<h> b(@NonNull String str) {
        j e = e(str);
        if (e == null) {
            return null;
        }
        return e.a();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public i m90clone() {
        i iVar = new i();
        iVar.f6932a = this.f6932a;
        if (this.b != null) {
            ArrayList<j> arrayList = new ArrayList<>();
            Iterator<j> it = this.b.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().m91clone());
            }
            iVar.b = arrayList;
        }
        return iVar;
    }

    @Nullable
    private j c(int i) {
        ArrayList<j> arrayList = this.b;
        if (arrayList == null || arrayList.isEmpty() || i < 0 || i >= this.b.size()) {
            return null;
        }
        return this.b.get(i);
    }

    public int a(String str) {
        ArrayList<j> arrayList;
        if (!TextUtils.isEmpty(str) && (arrayList = this.b) != null && !arrayList.isEmpty()) {
            for (int i = 0; i < this.b.size(); i++) {
                if (TextUtils.equals(str, this.b.get(i).c())) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Nullable
    public ArrayList<h> b(int i) {
        j c2 = c(i);
        if (c2 == null) {
            return null;
        }
        return c2.d();
    }

    @Nullable
    public ArrayList<h> c(@NonNull String str) {
        j e = e(str);
        if (e == null) {
            return null;
        }
        return e.d();
    }

    public void a(long j) {
        this.f6932a = j;
    }

    public String a() {
        return c.format(new Date(this.f6932a));
    }
}
