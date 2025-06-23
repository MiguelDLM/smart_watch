package I0xX0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes11.dex */
public interface oIX0oI extends IInterface {
    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b(String str) throws RemoteException;

    /* renamed from: I0xX0.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static abstract class AbstractBinderC0002oIX0oI extends Binder implements oIX0oI {
        public static oIX0oI Oxx0IOOO() {
            return C0003oIX0oI.f95Oo;
        }

        public static oIX0oI XO(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof oIX0oI)) {
                return (oIX0oI) queryLocalInterface;
            }
            return new C0003oIX0oI(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 1598968902) {
                            return super.onTransact(i, parcel, parcel2, i2);
                        }
                        parcel2.writeString("com.samsung.android.deviceidservice.IDeviceIdService");
                        return true;
                    }
                    parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                    String b = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(b);
                    return true;
                }
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                String a2 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            }
            parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            String a3 = a();
            parcel2.writeNoException();
            parcel2.writeString(a3);
            return true;
        }

        /* renamed from: I0xX0.oIX0oI$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C0003oIX0oI implements oIX0oI {

            /* renamed from: Oo, reason: collision with root package name */
            public static oIX0oI f95Oo;

            /* renamed from: XO, reason: collision with root package name */
            public IBinder f96XO;

            public C0003oIX0oI(IBinder iBinder) {
                this.f96XO = iBinder;
            }

            @Override // I0xX0.oIX0oI
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    if (!this.f96XO.transact(1, obtain, obtain2, 0) && AbstractBinderC0002oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0002oIX0oI.Oxx0IOOO().a();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f96XO;
            }

            @Override // I0xX0.oIX0oI
            public String b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    obtain.writeString(str);
                    if (!this.f96XO.transact(3, obtain, obtain2, 0) && AbstractBinderC0002oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0002oIX0oI.Oxx0IOOO().b(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // I0xX0.oIX0oI
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    obtain.writeString(str);
                    if (!this.f96XO.transact(2, obtain, obtain2, 0) && AbstractBinderC0002oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0002oIX0oI.Oxx0IOOO().a(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
