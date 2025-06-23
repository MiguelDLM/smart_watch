package xOoOIoI;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes10.dex */
public interface oIX0oI extends IInterface {
    void II0xO0(int i, Bundle bundle) throws RemoteException;

    void oIX0oI(int i, long j, boolean z, float f, double d, String str) throws RemoteException;

    /* loaded from: classes10.dex */
    public static abstract class II0xO0 extends Binder implements oIX0oI {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public static final int f34473IXxxXO = 2;

        /* renamed from: Oo, reason: collision with root package name */
        public static final int f34474Oo = 1;

        /* renamed from: XO, reason: collision with root package name */
        public static final String f34475XO = "com.hihonor.cloudservice.oaid.IOAIDCallBack";

        /* renamed from: xOoOIoI.oIX0oI$II0xO0$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C1159oIX0oI implements oIX0oI {

            /* renamed from: Oo, reason: collision with root package name */
            public static oIX0oI f34476Oo;

            /* renamed from: XO, reason: collision with root package name */
            public IBinder f34477XO;

            public C1159oIX0oI(IBinder iBinder) {
                this.f34477XO = iBinder;
            }

            @Override // xOoOIoI.oIX0oI
            public void II0xO0(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(II0xO0.f34475XO);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f34477XO.transact(2, obtain, obtain2, 0) && II0xO0.Oxx0IOOO() != null) {
                        II0xO0.Oxx0IOOO().II0xO0(i, bundle);
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

            public String XO() {
                return II0xO0.f34475XO;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f34477XO;
            }

            @Override // xOoOIoI.oIX0oI
            public void oIX0oI(int i, long j, boolean z, float f, double d, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(II0xO0.f34475XO);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeFloat(f);
                    obtain.writeDouble(d);
                    obtain.writeString(str);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (!this.f34477XO.transact(1, obtain, obtain2, 0) && II0xO0.Oxx0IOOO() != null) {
                        II0xO0.Oxx0IOOO().oIX0oI(i, j, z, f, d, str);
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public II0xO0() {
            attachInterface(this, f34475XO);
        }

        public static boolean II0XooXoX(oIX0oI oix0oi) {
            if (C1159oIX0oI.f34476Oo == null) {
                if (oix0oi != null) {
                    C1159oIX0oI.f34476Oo = oix0oi;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static oIX0oI Oxx0IOOO() {
            return C1159oIX0oI.f34476Oo;
        }

        public static oIX0oI XO(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f34475XO);
            if (queryLocalInterface != null && (queryLocalInterface instanceof oIX0oI)) {
                return (oIX0oI) queryLocalInterface;
            }
            return new C1159oIX0oI(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            boolean z;
            Bundle bundle;
            if (i != 1) {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(f34475XO);
                    return true;
                }
                parcel.enforceInterface(f34475XO);
                int readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle = null;
                }
                II0xO0(readInt, bundle);
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface(f34475XO);
            int readInt2 = parcel.readInt();
            long readLong = parcel.readLong();
            if (parcel.readInt() != 0) {
                z = true;
            } else {
                z = false;
            }
            oIX0oI(readInt2, readLong, z, parcel.readFloat(), parcel.readDouble(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* renamed from: xOoOIoI.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C1160oIX0oI implements oIX0oI {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // xOoOIoI.oIX0oI
        public void II0xO0(int i, Bundle bundle) throws RemoteException {
        }

        @Override // xOoOIoI.oIX0oI
        public void oIX0oI(int i, long j, boolean z, float f, double d, String str) throws RemoteException {
        }
    }
}
