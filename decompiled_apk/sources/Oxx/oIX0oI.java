package Oxx;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes11.dex */
public interface oIX0oI extends IInterface {

    /* renamed from: Oxx.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static abstract class AbstractBinderC0044oIX0oI extends Binder implements oIX0oI {

        /* renamed from: Oxx.oIX0oI$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C0045oIX0oI implements oIX0oI {

            /* renamed from: Oo, reason: collision with root package name */
            public static oIX0oI f3011Oo;

            /* renamed from: XO, reason: collision with root package name */
            public IBinder f3012XO;

            public C0045oIX0oI(IBinder iBinder) {
                this.f3012XO = iBinder;
            }

            @Override // Oxx.oIX0oI
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    if (!this.f3012XO.transact(1, obtain, obtain2, 0) && AbstractBinderC0044oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0044oIX0oI.Oxx0IOOO().a();
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
                return this.f3012XO;
            }

            @Override // Oxx.oIX0oI
            public boolean b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    boolean z = false;
                    if (!this.f3012XO.transact(2, obtain, obtain2, 0) && AbstractBinderC0044oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0044oIX0oI.Oxx0IOOO().b();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static oIX0oI Oxx0IOOO() {
            return C0045oIX0oI.f3011Oo;
        }

        public static oIX0oI XO(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof oIX0oI)) {
                return (oIX0oI) queryLocalInterface;
            }
            return new C0045oIX0oI(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    return true;
                }
                parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                boolean b = b();
                parcel2.writeNoException();
                parcel2.writeInt(b ? 1 : 0);
                return true;
            }
            parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            String a2 = a();
            parcel2.writeNoException();
            parcel2.writeString(a2);
            return true;
        }
    }

    String a() throws RemoteException;

    boolean b() throws RemoteException;
}
