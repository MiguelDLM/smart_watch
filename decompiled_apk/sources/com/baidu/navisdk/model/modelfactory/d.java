package com.baidu.navisdk.model.modelfactory;

import com.baidu.navisdk.model.datastruct.k;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class d extends a {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<k> f6950a = new ArrayList<>();
    private ArrayList<k> b = new ArrayList<>();

    public String toString() {
        StringBuilder sb = new StringBuilder("\nOfflineDataModel{");
        if (this.f6950a == null) {
            sb.append("\n\tmUnDownloadList is null!!!");
        } else {
            sb.append("\n\tmUnDownloadList: ");
            Iterator<k> it = this.f6950a.iterator();
            while (it.hasNext()) {
                k next = it.next();
                sb.append("\n\t\t");
                sb.append(next);
            }
        }
        if (this.b == null) {
            sb.append("\n\n\tmDownloadedList is null!!!");
        } else {
            sb.append("\n\n\tmDownloadedList: ");
            Iterator<k> it2 = this.b.iterator();
            while (it2.hasNext()) {
                k next2 = it2.next();
                sb.append("\n\t\t");
                sb.append(next2);
            }
        }
        sb.append("\n}");
        return sb.toString();
    }
}
