package oXX0IoI;

import X0IOOI.oIX0oI;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes11.dex */
public interface oIX0oI extends IInterface {
    String a() throws RemoteException;

    boolean a(boolean z) throws RemoteException;

    /* renamed from: oXX0IoI.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static abstract class AbstractBinderC1131oIX0oI extends Binder implements oIX0oI {
        public static oIX0oI Oxx0IOOO() {
            return C1132oIX0oI.f32163Oo;
        }

        public static oIX0oI XO(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(oIX0oI.II0xO0.f3239XO);
            if (queryLocalInterface != null && (queryLocalInterface instanceof oIX0oI)) {
                return (oIX0oI) queryLocalInterface;
            }
            return new C1132oIX0oI(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            boolean z;
            if (i != 1) {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(oIX0oI.II0xO0.f3239XO);
                    return true;
                }
                parcel.enforceInterface(oIX0oI.II0xO0.f3239XO);
                if (parcel.readInt() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                boolean a2 = a(z);
                parcel2.writeNoException();
                parcel2.writeInt(a2 ? 1 : 0);
                return true;
            }
            parcel.enforceInterface(oIX0oI.II0xO0.f3239XO);
            String a3 = a();
            parcel2.writeNoException();
            parcel2.writeString(a3);
            return true;
        }

        /* renamed from: oXX0IoI.oIX0oI$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C1132oIX0oI implements oIX0oI {

            /* renamed from: Oo, reason: collision with root package name */
            public static oIX0oI f32163Oo;

            /* renamed from: XO, reason: collision with root package name */
            public IBinder f32164XO;

            public C1132oIX0oI(IBinder iBinder) {
                this.f32164XO = iBinder;
            }

            @Override // oXX0IoI.oIX0oI
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(oIX0oI.II0xO0.f3239XO);
                    if (!this.f32164XO.transact(1, obtain, obtain2, 0) && AbstractBinderC1131oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC1131oIX0oI.Oxx0IOOO().a();
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
                return this.f32164XO;
            }

            @Override // oXX0IoI.oIX0oI
            public boolean a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(oIX0oI.II0xO0.f3239XO);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.f32164XO.transact(2, obtain, obtain2, 0) && AbstractBinderC1131oIX0oI.Oxx0IOOO() != null) {
                        return AbstractBinderC1131oIX0oI.Oxx0IOOO().a(z);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
