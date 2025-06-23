package IOoo;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes11.dex */
public interface oIX0oI extends IInterface {

    /* renamed from: IOoo.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static abstract class AbstractBinderC0017oIX0oI extends Binder implements oIX0oI {

        /* renamed from: IOoo.oIX0oI$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C0018oIX0oI implements oIX0oI {

            /* renamed from: Oo, reason: collision with root package name */
            public static oIX0oI f622Oo;

            /* renamed from: XO, reason: collision with root package name */
            public IBinder f623XO;

            public C0018oIX0oI(IBinder iBinder) {
                this.f623XO = iBinder;
            }

            @Override // IOoo.oIX0oI
            public boolean a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    boolean z = false;
                    if (!this.f623XO.transact(1, obtain, obtain2, 0) && AbstractBinderC0017oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0017oIX0oI.Oxx0IOOO().a();
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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f623XO;
            }

            @Override // IOoo.oIX0oI
            public boolean b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    boolean z = false;
                    if (!this.f623XO.transact(2, obtain, obtain2, 0) && AbstractBinderC0017oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0017oIX0oI.Oxx0IOOO().b();
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

            @Override // IOoo.oIX0oI
            public String c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.f623XO.transact(3, obtain, obtain2, 0) && AbstractBinderC0017oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0017oIX0oI.Oxx0IOOO().c();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // IOoo.oIX0oI
            public String d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.f623XO.transact(4, obtain, obtain2, 0) && AbstractBinderC0017oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0017oIX0oI.Oxx0IOOO().d();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // IOoo.oIX0oI
            public String e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.f623XO.transact(5, obtain, obtain2, 0) && AbstractBinderC0017oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0017oIX0oI.Oxx0IOOO().e();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // IOoo.oIX0oI
            public void f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.f623XO.transact(6, obtain, obtain2, 0) && AbstractBinderC0017oIX0oI.Oxx0IOOO() != null) {
                        AbstractBinderC0017oIX0oI.Oxx0IOOO().f();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static oIX0oI Oxx0IOOO() {
            return C0018oIX0oI.f622Oo;
        }

        public static oIX0oI XO(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof oIX0oI)) {
                return (oIX0oI) queryLocalInterface;
            }
            return new C0018oIX0oI(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        boolean a2 = a();
                        parcel2.writeNoException();
                        parcel2.writeInt(a2 ? 1 : 0);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        boolean b = b();
                        parcel2.writeNoException();
                        parcel2.writeInt(b ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        String c = c();
                        parcel2.writeNoException();
                        parcel2.writeString(c);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        String d = d();
                        parcel2.writeNoException();
                        parcel2.writeString(d);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        String e = e();
                        parcel2.writeNoException();
                        parcel2.writeString(e);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        f();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.bun.lib.MsaIdInterface");
            return true;
        }
    }

    boolean a() throws RemoteException;

    boolean b() throws RemoteException;

    String c() throws RemoteException;

    String d() throws RemoteException;

    String e() throws RemoteException;

    void f() throws RemoteException;
}
