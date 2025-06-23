package OX;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes11.dex */
public interface oIX0oI extends IInterface {
    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b() throws RemoteException;

    String b(String str) throws RemoteException;

    String c(String str) throws RemoteException;

    boolean c() throws RemoteException;

    /* renamed from: OX.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static abstract class AbstractBinderC0036oIX0oI extends Binder implements oIX0oI {
        public static oIX0oI Oxx0IOOO() {
            return C0037oIX0oI.f1891Oo;
        }

        public static oIX0oI XO(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof oIX0oI)) {
                return (oIX0oI) queryLocalInterface;
            }
            return new C0037oIX0oI(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        String a2 = a();
                        parcel2.writeNoException();
                        parcel2.writeString(a2);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        String b = b();
                        parcel2.writeNoException();
                        parcel2.writeString(b);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        boolean c = c();
                        parcel2.writeNoException();
                        parcel2.writeInt(c ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        String a3 = a(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(a3);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        String b2 = b(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(b2);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        String c2 = c(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(c2);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.zui.deviceidservice.IDeviceidInterface");
            return true;
        }

        /* renamed from: OX.oIX0oI$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C0037oIX0oI implements oIX0oI {

            /* renamed from: Oo, reason: collision with root package name */
            public static oIX0oI f1891Oo;

            /* renamed from: XO, reason: collision with root package name */
            public IBinder f1892XO;

            public C0037oIX0oI(IBinder iBinder) {
                this.f1892XO = iBinder;
            }

            @Override // OX.oIX0oI
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    if (!this.f1892XO.transact(1, obtain, obtain2, 0) && AbstractBinderC0036oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0036oIX0oI.Oxx0IOOO().a();
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
                return this.f1892XO;
            }

            @Override // OX.oIX0oI
            public String b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    if (!this.f1892XO.transact(2, obtain, obtain2, 0) && AbstractBinderC0036oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0036oIX0oI.Oxx0IOOO().b();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // OX.oIX0oI
            public boolean c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    if (!this.f1892XO.transact(3, obtain, obtain2, 0) && AbstractBinderC0036oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0036oIX0oI.Oxx0IOOO().c();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // OX.oIX0oI
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    if (!this.f1892XO.transact(4, obtain, obtain2, 0) && AbstractBinderC0036oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0036oIX0oI.Oxx0IOOO().a(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // OX.oIX0oI
            public String b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    if (!this.f1892XO.transact(5, obtain, obtain2, 0) && AbstractBinderC0036oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0036oIX0oI.Oxx0IOOO().b(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // OX.oIX0oI
            public String c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    if (!this.f1892XO.transact(6, obtain, obtain2, 0) && AbstractBinderC0036oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0036oIX0oI.Oxx0IOOO().c(str);
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
