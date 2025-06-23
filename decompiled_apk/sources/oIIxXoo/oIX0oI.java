package oIIxXoo;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes11.dex */
public interface oIX0oI extends IInterface {
    String a(String str) throws RemoteException;

    boolean a() throws RemoteException;

    String b() throws RemoteException;

    String b(String str) throws RemoteException;

    String c(String str) throws RemoteException;

    String d(String str) throws RemoteException;

    String e(String str) throws RemoteException;

    /* renamed from: oIIxXoo.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static abstract class AbstractBinderC1123oIX0oI extends Binder implements oIX0oI {
        public static oIX0oI Oxx0IOOO() {
            return C1124oIX0oI.f31614Oo;
        }

        public static oIX0oI XO(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof oIX0oI)) {
                return (oIX0oI) queryLocalInterface;
            }
            return new C1124oIX0oI(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String a2 = a(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(a2);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String b = b(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(b);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String c = c(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(c);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String d = d(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(d);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String e = e(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(e);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        boolean a3 = a();
                        parcel2.writeNoException();
                        parcel2.writeInt(a3 ? 1 : 0);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String b2 = b();
                        parcel2.writeNoException();
                        parcel2.writeString(b2);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.coolpad.deviceidsupport.IDeviceIdManager");
            return true;
        }

        /* renamed from: oIIxXoo.oIX0oI$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C1124oIX0oI implements oIX0oI {

            /* renamed from: Oo, reason: collision with root package name */
            public static oIX0oI f31614Oo;

            /* renamed from: XO, reason: collision with root package name */
            public IBinder f31615XO;

            public C1124oIX0oI(IBinder iBinder) {
                this.f31615XO = iBinder;
            }

            @Override // oIIxXoo.oIX0oI
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (!this.f31615XO.transact(1, obtain, obtain2, 0) && AbstractBinderC1123oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC1123oIX0oI.Oxx0IOOO().a(str);
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
                return this.f31615XO;
            }

            @Override // oIIxXoo.oIX0oI
            public String b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (!this.f31615XO.transact(2, obtain, obtain2, 0) && AbstractBinderC1123oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC1123oIX0oI.Oxx0IOOO().b(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // oIIxXoo.oIX0oI
            public String c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (!this.f31615XO.transact(3, obtain, obtain2, 0) && AbstractBinderC1123oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC1123oIX0oI.Oxx0IOOO().c(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // oIIxXoo.oIX0oI
            public String d(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (!this.f31615XO.transact(4, obtain, obtain2, 0) && AbstractBinderC1123oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC1123oIX0oI.Oxx0IOOO().d(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // oIIxXoo.oIX0oI
            public String e(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (!this.f31615XO.transact(5, obtain, obtain2, 0) && AbstractBinderC1123oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC1123oIX0oI.Oxx0IOOO().e(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // oIIxXoo.oIX0oI
            public boolean a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.f31615XO.transact(6, obtain, obtain2, 0) && AbstractBinderC1123oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC1123oIX0oI.Oxx0IOOO().a();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // oIIxXoo.oIX0oI
            public String b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.f31615XO.transact(7, obtain, obtain2, 0) && AbstractBinderC1123oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC1123oIX0oI.Oxx0IOOO().b();
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
