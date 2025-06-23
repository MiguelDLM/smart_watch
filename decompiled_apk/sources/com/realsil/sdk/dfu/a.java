package com.realsil.sdk.dfu;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.realsil.sdk.dfu.b;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.Throughput;
import com.realsil.sdk.dfu.params.QcConfig;

/* loaded from: classes11.dex */
public interface a extends IInterface {
    int a() throws RemoteException;

    void a(String str, b bVar) throws RemoteException;

    boolean a(String str, DfuConfig dfuConfig, QcConfig qcConfig) throws RemoteException;

    boolean a(boolean z) throws RemoteException;

    Throughput b() throws RemoteException;

    boolean b(String str, b bVar) throws RemoteException;

    boolean c() throws RemoteException;

    /* renamed from: com.realsil.sdk.dfu.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static abstract class AbstractBinderC0910a extends Binder implements a {
        public AbstractBinderC0910a() {
            attachInterface(this, "com.realsil.sdk.dfu.IRealsilDfu");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.realsil.sdk.dfu.IRealsilDfu");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0911a(iBinder);
        }

        public static a d() {
            return C0911a.b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            DfuConfig dfuConfig;
            if (i != 1598968902) {
                boolean z = false;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.realsil.sdk.dfu.IRealsilDfu");
                        String readString = parcel.readString();
                        QcConfig qcConfig = null;
                        if (parcel.readInt() != 0) {
                            dfuConfig = DfuConfig.CREATOR.createFromParcel(parcel);
                        } else {
                            dfuConfig = null;
                        }
                        if (parcel.readInt() != 0) {
                            qcConfig = QcConfig.CREATOR.createFromParcel(parcel);
                        }
                        boolean a2 = a(readString, dfuConfig, qcConfig);
                        parcel2.writeNoException();
                        parcel2.writeInt(a2 ? 1 : 0);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.realsil.sdk.dfu.IRealsilDfu");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        boolean a3 = a(z);
                        parcel2.writeNoException();
                        parcel2.writeInt(a3 ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.realsil.sdk.dfu.IRealsilDfu");
                        boolean c = c();
                        parcel2.writeNoException();
                        parcel2.writeInt(c ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.realsil.sdk.dfu.IRealsilDfu");
                        int a4 = a();
                        parcel2.writeNoException();
                        parcel2.writeInt(a4);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.realsil.sdk.dfu.IRealsilDfu");
                        Throughput b = b();
                        parcel2.writeNoException();
                        if (b != null) {
                            parcel2.writeInt(1);
                            b.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 6:
                        parcel.enforceInterface("com.realsil.sdk.dfu.IRealsilDfu");
                        boolean b2 = b(parcel.readString(), b.a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(b2 ? 1 : 0);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.realsil.sdk.dfu.IRealsilDfu");
                        a(parcel.readString(), b.a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.realsil.sdk.dfu.IRealsilDfu");
            return true;
        }

        /* renamed from: com.realsil.sdk.dfu.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C0911a implements a {
            public static a b;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f19527a;

            public C0911a(IBinder iBinder) {
                this.f19527a = iBinder;
            }

            @Override // com.realsil.sdk.dfu.a
            public boolean a(String str, DfuConfig dfuConfig, QcConfig qcConfig) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.realsil.sdk.dfu.IRealsilDfu");
                    obtain.writeString(str);
                    if (dfuConfig != null) {
                        obtain.writeInt(1);
                        dfuConfig.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (qcConfig != null) {
                        obtain.writeInt(1);
                        qcConfig.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f19527a.transact(1, obtain, obtain2, 0) && AbstractBinderC0910a.d() != null) {
                        boolean a2 = AbstractBinderC0910a.d().a(str, dfuConfig, qcConfig);
                        obtain2.recycle();
                        obtain.recycle();
                        return a2;
                    }
                    obtain2.readException();
                    boolean z = obtain2.readInt() != 0;
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f19527a;
            }

            @Override // com.realsil.sdk.dfu.a
            public boolean b(String str, b bVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.realsil.sdk.dfu.IRealsilDfu");
                    obtain.writeString(str);
                    if (bVar != null) {
                        iBinder = bVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    boolean z = false;
                    if (!this.f19527a.transact(6, obtain, obtain2, 0) && AbstractBinderC0910a.d() != null) {
                        boolean b2 = AbstractBinderC0910a.d().b(str, bVar);
                        obtain2.recycle();
                        obtain.recycle();
                        return b2;
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.realsil.sdk.dfu.a
            public boolean c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.realsil.sdk.dfu.IRealsilDfu");
                    boolean z = false;
                    if (!this.f19527a.transact(3, obtain, obtain2, 0) && AbstractBinderC0910a.d() != null) {
                        return AbstractBinderC0910a.d().c();
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

            @Override // com.realsil.sdk.dfu.a
            public boolean a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.realsil.sdk.dfu.IRealsilDfu");
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.f19527a.transact(2, obtain, obtain2, 0) && AbstractBinderC0910a.d() != null) {
                        return AbstractBinderC0910a.d().a(z);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.realsil.sdk.dfu.a
            public int a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.realsil.sdk.dfu.IRealsilDfu");
                    if (!this.f19527a.transact(4, obtain, obtain2, 0) && AbstractBinderC0910a.d() != null) {
                        return AbstractBinderC0910a.d().a();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.realsil.sdk.dfu.a
            public void a(String str, b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.realsil.sdk.dfu.IRealsilDfu");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (!this.f19527a.transact(7, obtain, obtain2, 0) && AbstractBinderC0910a.d() != null) {
                        AbstractBinderC0910a.d().a(str, bVar);
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }
    }
}
