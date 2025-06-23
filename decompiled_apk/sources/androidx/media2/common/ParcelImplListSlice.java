package androidx.media2.common;

import android.annotation.SuppressLint;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.ParcelImpl;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class ParcelImplListSlice implements Parcelable {
    public static final Parcelable.Creator<ParcelImplListSlice> CREATOR = new Parcelable.Creator<ParcelImplListSlice>() { // from class: androidx.media2.common.ParcelImplListSlice.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelImplListSlice createFromParcel(Parcel parcel) {
            return new ParcelImplListSlice(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
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

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public List<ParcelImpl> getList() {
        return this.mList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
    
        r7.writeInt(0);
        r7.writeStrongBinder(new androidx.media2.common.ParcelImplListSlice.AnonymousClass1(r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
    
        return;
     */
    @Override // android.os.Parcelable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void writeToParcel(android.os.Parcel r7, int r8) {
        /*
            r6 = this;
            java.util.List<androidx.versionedparcelable.ParcelImpl> r0 = r6.mList
            int r0 = r0.size()
            r7.writeInt(r0)
            if (r0 <= 0) goto L38
            r1 = 0
            r2 = 0
        Ld:
            if (r2 >= r0) goto L2b
            r3 = 1
            if (r2 >= r3) goto L2b
            int r4 = r7.dataSize()
            r5 = 65536(0x10000, float:9.1835E-41)
            if (r4 >= r5) goto L2b
            r7.writeInt(r3)
            java.util.List<androidx.versionedparcelable.ParcelImpl> r3 = r6.mList
            java.lang.Object r3 = r3.get(r2)
            androidx.versionedparcelable.ParcelImpl r3 = (androidx.versionedparcelable.ParcelImpl) r3
            r7.writeParcelable(r3, r8)
            int r2 = r2 + 1
            goto Ld
        L2b:
            if (r2 >= r0) goto L38
            r7.writeInt(r1)
            androidx.media2.common.ParcelImplListSlice$1 r8 = new androidx.media2.common.ParcelImplListSlice$1
            r8.<init>()
            r7.writeStrongBinder(r8)
        L38:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.common.ParcelImplListSlice.writeToParcel(android.os.Parcel, int):void");
    }

    public ParcelImplListSlice(Parcel parcel) {
        int readInt = parcel.readInt();
        this.mList = new ArrayList(readInt);
        if (readInt <= 0) {
            return;
        }
        int i = 0;
        while (i < readInt && parcel.readInt() != 0) {
            this.mList.add((ParcelImpl) parcel.readParcelable(ParcelImpl.class.getClassLoader()));
            i++;
        }
        if (i >= readInt) {
            return;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        while (i < readInt) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInt(i);
                readStrongBinder.transact(1, obtain, obtain2, 0);
                while (i < readInt && obtain2.readInt() != 0) {
                    this.mList.add((ParcelImpl) obtain2.readParcelable(ParcelImpl.class.getClassLoader()));
                    i++;
                }
            } catch (RemoteException e) {
                Log.w(TAG, "Failure retrieving array; only received " + i + " of " + readInt, e);
                return;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
