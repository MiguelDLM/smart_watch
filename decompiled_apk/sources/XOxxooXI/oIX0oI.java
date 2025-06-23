package XOxxooXI;

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

    String c() throws RemoteException;

    /* renamed from: XOxxooXI.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static abstract class AbstractBinderC0061oIX0oI extends Binder implements oIX0oI {
        public static oIX0oI Oxx0IOOO() {
            return C0062oIX0oI.f3986Oo;
        }

        public static oIX0oI XO(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.creator.IdsSupplier");
            if (queryLocalInterface != null && (queryLocalInterface instanceof oIX0oI)) {
                return (oIX0oI) queryLocalInterface;
            }
            return new C0062oIX0oI(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (i != 1598968902) {
                                    return super.onTransact(i, parcel, parcel2, i2);
                                }
                                parcel2.writeString("com.android.creator.IdsSupplier");
                                return true;
                            }
                            parcel.enforceInterface("com.android.creator.IdsSupplier");
                            String b = b(parcel.readString());
                            parcel2.writeNoException();
                            parcel2.writeString(b);
                            return true;
                        }
                        parcel.enforceInterface("com.android.creator.IdsSupplier");
                        String c = c();
                        parcel2.writeNoException();
                        parcel2.writeString(c);
                        return true;
                    }
                    parcel.enforceInterface("com.android.creator.IdsSupplier");
                    String b2 = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b2);
                    return true;
                }
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                String a2 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            }
            parcel.enforceInterface("com.android.creator.IdsSupplier");
            boolean a3 = a();
            parcel2.writeNoException();
            parcel2.writeInt(a3 ? 1 : 0);
            return true;
        }

        /* renamed from: XOxxooXI.oIX0oI$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C0062oIX0oI implements oIX0oI {

            /* renamed from: Oo, reason: collision with root package name */
            public static oIX0oI f3986Oo;

            /* renamed from: XO, reason: collision with root package name */
            public IBinder f3987XO;

            public C0062oIX0oI(IBinder iBinder) {
                this.f3987XO = iBinder;
            }

            @Override // XOxxooXI.oIX0oI
            public boolean a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    if (!this.f3987XO.transact(1, obtain, obtain2, 0) && AbstractBinderC0061oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0061oIX0oI.Oxx0IOOO().a();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3987XO;
            }

            @Override // XOxxooXI.oIX0oI
            public String b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    if (!this.f3987XO.transact(3, obtain, obtain2, 0) && AbstractBinderC0061oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0061oIX0oI.Oxx0IOOO().b();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // XOxxooXI.oIX0oI
            public String c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    if (!this.f3987XO.transact(4, obtain, obtain2, 0) && AbstractBinderC0061oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0061oIX0oI.Oxx0IOOO().c();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // XOxxooXI.oIX0oI
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    obtain.writeString(str);
                    if (!this.f3987XO.transact(2, obtain, obtain2, 0) && AbstractBinderC0061oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0061oIX0oI.Oxx0IOOO().a(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // XOxxooXI.oIX0oI
            public String b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    obtain.writeString(str);
                    if (!this.f3987XO.transact(5, obtain, obtain2, 0) && AbstractBinderC0061oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0061oIX0oI.Oxx0IOOO().b(str);
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
