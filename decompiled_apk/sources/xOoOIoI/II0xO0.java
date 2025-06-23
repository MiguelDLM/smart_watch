package xOoOIoI;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import xOoOIoI.oIX0oI;

/* loaded from: classes10.dex */
public interface II0xO0 extends IInterface {
    void I0Io(xOoOIoI.oIX0oI oix0oi) throws RemoteException;

    void X0o0xo(xOoOIoI.oIX0oI oix0oi) throws RemoteException;

    void oIX0oI(int i, long j, boolean z, float f, double d, String str) throws RemoteException;

    /* renamed from: xOoOIoI.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static abstract class AbstractBinderC1158II0xO0 extends Binder implements II0xO0 {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public static final int f34467IXxxXO = 2;

        /* renamed from: Oo, reason: collision with root package name */
        public static final int f34468Oo = 1;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public static final int f34469Oxx0xo = 3;

        /* renamed from: XO, reason: collision with root package name */
        public static final String f34470XO = "com.hihonor.cloudservice.oaid.IOAIDService";

        /* renamed from: xOoOIoI.II0xO0$II0xO0$oIX0oI */
        /* loaded from: classes10.dex */
        public static class oIX0oI implements II0xO0 {

            /* renamed from: Oo, reason: collision with root package name */
            public static II0xO0 f34471Oo;

            /* renamed from: XO, reason: collision with root package name */
            public IBinder f34472XO;

            public oIX0oI(IBinder iBinder) {
                this.f34472XO = iBinder;
            }

            @Override // xOoOIoI.II0xO0
            public void I0Io(xOoOIoI.oIX0oI oix0oi) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC1158II0xO0.f34470XO);
                    if (oix0oi != null) {
                        iBinder = oix0oi.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.f34472XO.transact(2, obtain, obtain2, 0) && AbstractBinderC1158II0xO0.Oxx0IOOO() != null) {
                        AbstractBinderC1158II0xO0.Oxx0IOOO().I0Io(oix0oi);
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

            @Override // xOoOIoI.II0xO0
            public void X0o0xo(xOoOIoI.oIX0oI oix0oi) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC1158II0xO0.f34470XO);
                    if (oix0oi != null) {
                        iBinder = oix0oi.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.f34472XO.transact(3, obtain, obtain2, 0) && AbstractBinderC1158II0xO0.Oxx0IOOO() != null) {
                        AbstractBinderC1158II0xO0.Oxx0IOOO().X0o0xo(oix0oi);
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
                return AbstractBinderC1158II0xO0.f34470XO;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f34472XO;
            }

            @Override // xOoOIoI.II0xO0
            public void oIX0oI(int i, long j, boolean z, float f, double d, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC1158II0xO0.f34470XO);
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
                    if (!this.f34472XO.transact(1, obtain, obtain2, 0) && AbstractBinderC1158II0xO0.Oxx0IOOO() != null) {
                        AbstractBinderC1158II0xO0.Oxx0IOOO().oIX0oI(i, j, z, f, d, str);
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

        public AbstractBinderC1158II0xO0() {
            attachInterface(this, f34470XO);
        }

        public static boolean II0XooXoX(II0xO0 iI0xO0) {
            if (oIX0oI.f34471Oo == null) {
                if (iI0xO0 != null) {
                    oIX0oI.f34471Oo = iI0xO0;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static II0xO0 Oxx0IOOO() {
            return oIX0oI.f34471Oo;
        }

        public static II0xO0 XO(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f34470XO);
            if (queryLocalInterface != null && (queryLocalInterface instanceof II0xO0)) {
                return (II0xO0) queryLocalInterface;
            }
            return new oIX0oI(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            boolean z;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 1598968902) {
                            return super.onTransact(i, parcel, parcel2, i2);
                        }
                        parcel2.writeString(f34470XO);
                        return true;
                    }
                    parcel.enforceInterface(f34470XO);
                    X0o0xo(oIX0oI.II0xO0.XO(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface(f34470XO);
                I0Io(oIX0oI.II0xO0.XO(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface(f34470XO);
            int readInt = parcel.readInt();
            long readLong = parcel.readLong();
            if (parcel.readInt() != 0) {
                z = true;
            } else {
                z = false;
            }
            oIX0oI(readInt, readLong, z, parcel.readFloat(), parcel.readDouble(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes10.dex */
    public static class oIX0oI implements II0xO0 {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // xOoOIoI.II0xO0
        public void I0Io(xOoOIoI.oIX0oI oix0oi) throws RemoteException {
        }

        @Override // xOoOIoI.II0xO0
        public void X0o0xo(xOoOIoI.oIX0oI oix0oi) throws RemoteException {
        }

        @Override // xOoOIoI.II0xO0
        public void oIX0oI(int i, long j, boolean z, float f, double d, String str) throws RemoteException {
        }
    }
}
