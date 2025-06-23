package com.kwad.framework.filedownloader.d;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.sdk.utils.aq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes11.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.kwad.framework.filedownloader.d.b.1
        private static b b(Parcel parcel) {
            return new b(parcel);
        }

        private static b[] bC(int i) {
            return new b[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b createFromParcel(Parcel parcel) {
            return b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b[] newArray(int i) {
            return bC(i);
        }
    };
    private HashMap<String, List<String>> ait;

    public b() {
    }

    public final void bp(String str) {
        HashMap<String, List<String>> hashMap = this.ait;
        if (hashMap == null) {
            return;
        }
        hashMap.remove(str);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return this.ait.toString();
    }

    public final HashMap<String, List<String>> wO() {
        return this.ait;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.ait);
    }

    public final void x(String str, String str2) {
        aq.gR(str);
        aq.gR(str2);
        if (this.ait == null) {
            this.ait = new HashMap<>();
        }
        List<String> list = this.ait.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.ait.put(str, list);
        }
        if (!list.contains(str2)) {
            list.add(str2);
        }
    }

    public b(Parcel parcel) {
        this.ait = parcel.readHashMap(String.class.getClassLoader());
    }
}
