package XI;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes11.dex */
public interface oIX0oI extends IInterface {

    /* renamed from: XI.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static abstract class AbstractBinderC0056oIX0oI extends Binder implements oIX0oI {

        /* renamed from: XI.oIX0oI$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C0057oIX0oI implements oIX0oI {

            /* renamed from: Oo, reason: collision with root package name */
            public static oIX0oI f3707Oo;

            /* renamed from: XO, reason: collision with root package name */
            public IBinder f3708XO;

            public C0057oIX0oI(IBinder iBinder) {
                this.f3708XO = iBinder;
            }

            @Override // XI.oIX0oI
            public boolean a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    boolean z = false;
                    if (!this.f3708XO.transact(1, obtain, obtain2, 0) && AbstractBinderC0056oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0056oIX0oI.Oxx0IOOO().a();
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
                return this.f3708XO;
            }

            @Override // XI.oIX0oI
            public String b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    if (!this.f3708XO.transact(2, obtain, obtain2, 0) && AbstractBinderC0056oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0056oIX0oI.Oxx0IOOO().b();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // XI.oIX0oI
            public String c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    if (!this.f3708XO.transact(3, obtain, obtain2, 0) && AbstractBinderC0056oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0056oIX0oI.Oxx0IOOO().c();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // XI.oIX0oI
            public String d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    if (!this.f3708XO.transact(4, obtain, obtain2, 0) && AbstractBinderC0056oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0056oIX0oI.Oxx0IOOO().d();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // XI.oIX0oI
            public String e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    if (!this.f3708XO.transact(5, obtain, obtain2, 0) && AbstractBinderC0056oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC0056oIX0oI.Oxx0IOOO().e();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static oIX0oI Oxx0IOOO() {
            return C0057oIX0oI.f3707Oo;
        }

        public static oIX0oI XO(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof oIX0oI)) {
                return (oIX0oI) queryLocalInterface;
            }
            return new C0057oIX0oI(iBinder);
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
                                parcel2.writeString("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                                return true;
                            }
                            parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                            String e = e();
                            parcel2.writeNoException();
                            parcel2.writeString(e);
                            return true;
                        }
                        parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                        String d = d();
                        parcel2.writeNoException();
                        parcel2.writeString(d);
                        return true;
                    }
                    parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    String c = c();
                    parcel2.writeNoException();
                    parcel2.writeString(c);
                    return true;
                }
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                String b = b();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            }
            parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            boolean a2 = a();
            parcel2.writeNoException();
            parcel2.writeInt(a2 ? 1 : 0);
            return true;
        }
    }

    boolean a() throws RemoteException;

    String b() throws RemoteException;

    String c() throws RemoteException;

    String d() throws RemoteException;

    String e() throws RemoteException;
}
