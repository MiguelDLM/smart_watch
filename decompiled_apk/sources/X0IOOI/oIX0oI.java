package X0IOOI;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes13.dex */
public interface oIX0oI extends IInterface {

    /* renamed from: X0IOOI.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0051oIX0oI implements oIX0oI {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // X0IOOI.oIX0oI
        public String getId() throws RemoteException {
            return null;
        }

        @Override // X0IOOI.oIX0oI
        public boolean oxoX(boolean z) throws RemoteException {
            return false;
        }
    }

    String getId() throws RemoteException;

    boolean oxoX(boolean z) throws RemoteException;

    /* loaded from: classes13.dex */
    public static abstract class II0xO0 extends Binder implements oIX0oI {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public static final int f3237IXxxXO = 2;

        /* renamed from: Oo, reason: collision with root package name */
        public static final int f3238Oo = 1;

        /* renamed from: XO, reason: collision with root package name */
        public static final String f3239XO = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";

        /* renamed from: X0IOOI.oIX0oI$II0xO0$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static class C0050oIX0oI implements oIX0oI {

            /* renamed from: Oo, reason: collision with root package name */
            public static oIX0oI f3240Oo;

            /* renamed from: XO, reason: collision with root package name */
            public IBinder f3241XO;

            public C0050oIX0oI(IBinder iBinder) {
                this.f3241XO = iBinder;
            }

            public String XO() {
                return II0xO0.f3239XO;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3241XO;
            }

            @Override // X0IOOI.oIX0oI
            public String getId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(II0xO0.f3239XO);
                    if (!this.f3241XO.transact(1, obtain, obtain2, 0) && II0xO0.Oxx0IOOO() != null) {
                        return II0xO0.Oxx0IOOO().getId();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // X0IOOI.oIX0oI
            public boolean oxoX(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(II0xO0.f3239XO);
                    boolean z2 = true;
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.f3241XO.transact(2, obtain, obtain2, 0) && II0xO0.Oxx0IOOO() != null) {
                        return II0xO0.Oxx0IOOO().oxoX(z);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public II0xO0() {
            attachInterface(this, f3239XO);
        }

        public static boolean II0XooXoX(oIX0oI oix0oi) {
            if (C0050oIX0oI.f3240Oo == null) {
                if (oix0oi != null) {
                    C0050oIX0oI.f3240Oo = oix0oi;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static oIX0oI Oxx0IOOO() {
            return C0050oIX0oI.f3240Oo;
        }

        public static oIX0oI XO(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f3239XO);
            if (queryLocalInterface != null && (queryLocalInterface instanceof oIX0oI)) {
                return (oIX0oI) queryLocalInterface;
            }
            return new C0050oIX0oI(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            boolean z;
            if (i != 1) {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(f3239XO);
                    return true;
                }
                parcel.enforceInterface(f3239XO);
                if (parcel.readInt() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                boolean oxoX2 = oxoX(z);
                parcel2.writeNoException();
                parcel2.writeInt(oxoX2 ? 1 : 0);
                return true;
            }
            parcel.enforceInterface(f3239XO);
            String id = getId();
            parcel2.writeNoException();
            parcel2.writeString(id);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
