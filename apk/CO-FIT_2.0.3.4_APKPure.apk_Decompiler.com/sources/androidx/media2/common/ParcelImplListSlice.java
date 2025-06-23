package androidx.media2.common;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.ParcelImpl;
import java.util.List;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelImplListSlice implements Parcelable {
    public static final Parcelable.Creator<ParcelImplListSlice> CREATOR = new Parcelable.Creator<ParcelImplListSlice>() {
        public ParcelImplListSlice createFromParcel(Parcel parcel) {
            return new ParcelImplListSlice(parcel);
        }

        public ParcelImplListSlice[] newArray(int i) {
            return new ParcelImplListSlice[i];
        }
    };
    private static final boolean DEBUG = false;
    private static final int INLINE_COUNT_LIMIT = 1;
    private static final int MAX_IPC_SIZE = 65536;
    private static final String TAG = "ParcelImplListSlice";
    final List<ParcelImpl> mList;

    public ParcelImplListSlice(@NonNull List<ParcelImpl> list) {
        if (list != null) {
            this.mList = list;
            return;
        }
        throw new NullPointerException("list shouldn't be null");
    }

    public int describeContents() {
        return 0;
    }

    @NonNull
    public List<ParcelImpl> getList() {
        return this.mList;
    }

    public void writeToParcel(Parcel parcel, int i) {
        final int size = this.mList.size();
        parcel.writeInt(size);
        if (size > 0) {
            int i2 = 0;
            while (i2 < size && i2 < 1 && parcel.dataSize() < 65536) {
                parcel.writeInt(1);
                parcel.writeParcelable(this.mList.get(i2), i);
                i2++;
            }
            if (i2 < size) {
                parcel.writeInt(0);
                parcel.writeStrongBinder(new Binder() {
                    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
                        if (i != 1) {
                            return super.onTransact(i, parcel, parcel2, i2);
                        }
                        int readInt = parcel.readInt();
                        while (readInt < size && parcel2.dataSize() < 65536) {
                            parcel2.writeInt(1);
                            parcel2.writeParcelable(ParcelImplListSlice.this.mList.get(readInt), i2);
                            readInt++;
                        }
                        if (readInt < size) {
                            parcel2.writeInt(0);
                        }
                        return true;
                    }
                });
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0032 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ParcelImplListSlice(android.os.Parcel r9) {
        /*
            r8 = this;
            r8.<init>()
            int r0 = r9.readInt()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            r8.mList = r1
            if (r0 > 0) goto L_0x0011
            return
        L_0x0011:
            r1 = 0
            r2 = 0
        L_0x0013:
            java.lang.Class<androidx.versionedparcelable.ParcelImpl> r3 = androidx.versionedparcelable.ParcelImpl.class
            if (r2 >= r0) goto L_0x0030
            int r4 = r9.readInt()
            if (r4 != 0) goto L_0x001e
            goto L_0x0030
        L_0x001e:
            java.lang.ClassLoader r3 = r3.getClassLoader()
            android.os.Parcelable r3 = r9.readParcelable(r3)
            androidx.versionedparcelable.ParcelImpl r3 = (androidx.versionedparcelable.ParcelImpl) r3
            java.util.List<androidx.versionedparcelable.ParcelImpl> r4 = r8.mList
            r4.add(r3)
            int r2 = r2 + 1
            goto L_0x0013
        L_0x0030:
            if (r2 < r0) goto L_0x0033
            return
        L_0x0033:
            android.os.IBinder r9 = r9.readStrongBinder()
        L_0x0037:
            if (r2 >= r0) goto L_0x0098
            android.os.Parcel r4 = android.os.Parcel.obtain()
            android.os.Parcel r5 = android.os.Parcel.obtain()
            r4.writeInt(r2)     // Catch:{ all -> 0x0062 }
            r6 = 1
            r9.transact(r6, r4, r5, r1)     // Catch:{ RemoteException -> 0x006b }
        L_0x0048:
            if (r2 >= r0) goto L_0x0064
            int r6 = r5.readInt()     // Catch:{ all -> 0x0062 }
            if (r6 == 0) goto L_0x0064
            java.lang.ClassLoader r6 = r3.getClassLoader()     // Catch:{ all -> 0x0062 }
            android.os.Parcelable r6 = r5.readParcelable(r6)     // Catch:{ all -> 0x0062 }
            androidx.versionedparcelable.ParcelImpl r6 = (androidx.versionedparcelable.ParcelImpl) r6     // Catch:{ all -> 0x0062 }
            java.util.List<androidx.versionedparcelable.ParcelImpl> r7 = r8.mList     // Catch:{ all -> 0x0062 }
            r7.add(r6)     // Catch:{ all -> 0x0062 }
            int r2 = r2 + 1
            goto L_0x0048
        L_0x0062:
            r9 = move-exception
            goto L_0x0091
        L_0x0064:
            r5.recycle()
            r4.recycle()
            goto L_0x0037
        L_0x006b:
            r9 = move-exception
            java.lang.String r1 = "ParcelImplListSlice"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0062 }
            r3.<init>()     // Catch:{ all -> 0x0062 }
            java.lang.String r6 = "Failure retrieving array; only received "
            r3.append(r6)     // Catch:{ all -> 0x0062 }
            r3.append(r2)     // Catch:{ all -> 0x0062 }
            java.lang.String r2 = " of "
            r3.append(r2)     // Catch:{ all -> 0x0062 }
            r3.append(r0)     // Catch:{ all -> 0x0062 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0062 }
            android.util.Log.w(r1, r0, r9)     // Catch:{ all -> 0x0062 }
            r5.recycle()
            r4.recycle()
            return
        L_0x0091:
            r5.recycle()
            r4.recycle()
            throw r9
        L_0x0098:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.common.ParcelImplListSlice.<init>(android.os.Parcel):void");
    }
}
