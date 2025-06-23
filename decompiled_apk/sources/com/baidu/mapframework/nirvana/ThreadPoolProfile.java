package com.baidu.mapframework.nirvana;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class ThreadPoolProfile {

    /* renamed from: a, reason: collision with root package name */
    List<ProfileItem> f6081a = new ArrayList();

    /* loaded from: classes7.dex */
    public static class ProfileItem {
        public long endTime;
        public String name;
        public long startTime;

        public String toString() {
            return "[" + this.name + "|" + this.startTime + "," + this.endTime + ", dur:" + TimeUnit.NANOSECONDS.toMillis(this.endTime - this.startTime) + " ms ]";
        }
    }

    private long a() {
        long j = 0;
        for (ProfileItem profileItem : this.f6081a) {
            j += profileItem.endTime - profileItem.startTime;
        }
        return j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Task size:");
        sb.append(this.f6081a.size());
        sb.append(", Total execution time:");
        sb.append(TimeUnit.NANOSECONDS.toMillis(a()) + " ms");
        sb.append("\n");
        Iterator<ProfileItem> it = this.f6081a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append("\n");
        }
        return sb.toString();
    }
}
