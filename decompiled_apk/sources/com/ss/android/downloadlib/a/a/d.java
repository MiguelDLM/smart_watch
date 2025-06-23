package com.ss.android.downloadlib.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.k;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public interface d extends IInterface {

    /* loaded from: classes11.dex */
    public static abstract class a extends Binder implements d {

        /* renamed from: a, reason: collision with root package name */
        private static String f25948a = "";

        /* renamed from: com.ss.android.downloadlib.a.a.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C1039a implements d {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f25949a;

            public C1039a(IBinder iBinder) {
                if (TextUtils.isEmpty(a.f25948a)) {
                    JSONObject j = k.j();
                    String unused = a.f25948a = com.ss.android.socialbase.appdownloader.f.c.a(j.optString("t"), j.optString("s"));
                }
                this.f25949a = iBinder;
            }

            @Override // com.ss.android.downloadlib.a.a.d
            public void a(b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f25948a);
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f25949a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25949a;
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            b bVar;
            if (i == 1) {
                parcel.enforceInterface(f25948a);
                if (parcel.readInt() != 0) {
                    bVar = b.CREATOR.createFromParcel(parcel);
                } else {
                    bVar = null;
                }
                a(bVar);
                parcel2.writeNoException();
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(f25948a);
            return true;
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f25948a);
            if (queryLocalInterface != null && (queryLocalInterface instanceof d)) {
                return (d) queryLocalInterface;
            }
            return new C1039a(iBinder);
        }
    }

    void a(b bVar) throws RemoteException;
}
