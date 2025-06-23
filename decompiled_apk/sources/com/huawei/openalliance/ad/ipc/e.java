package com.huawei.openalliance.ad.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.fb;

/* loaded from: classes10.dex */
public interface e extends IInterface {

    /* loaded from: classes10.dex */
    public static abstract class a extends Binder implements e {
        static final int Code = 1;
        private static final String I = "com.huawei.android.hms.ppskit.IPPSResultCallback";
        private static final String V = "IPPSResultCallback";

        /* renamed from: com.huawei.openalliance.ad.ipc.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C0666a implements e {
            private IBinder Code;

            public C0666a(IBinder iBinder) {
                this.Code = iBinder;
            }

            public String Code() {
                return a.I;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.Code;
            }

            @Override // com.huawei.openalliance.ad.ipc.e
            public void Code(String str, int i, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.I);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    this.Code.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, I);
        }

        public static e Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            try {
                IInterface queryLocalInterface = iBinder.queryLocalInterface(I);
                return (queryLocalInterface == null || !(queryLocalInterface instanceof e)) ? new C0666a(iBinder) : (e) queryLocalInterface;
            } catch (Throwable th) {
                fb.I(V, "IPPSResultCallback err: " + th.getClass().getSimpleName());
                return null;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(I);
                return true;
            }
            parcel.enforceInterface(I);
            Code(parcel.readString(), parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void Code(String str, int i, String str2);
}
