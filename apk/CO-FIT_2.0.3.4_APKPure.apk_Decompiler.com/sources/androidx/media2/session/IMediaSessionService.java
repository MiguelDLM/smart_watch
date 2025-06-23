package androidx.media2.session;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.media2.session.IMediaController;
import androidx.versionedparcelable.ParcelImpl;

public interface IMediaSessionService extends IInterface {

    public static class Default implements IMediaSessionService {
        public IBinder asBinder() {
            return null;
        }

        public void connect(IMediaController iMediaController, ParcelImpl parcelImpl) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IMediaSessionService {
        private static final String DESCRIPTOR = "androidx.media2.session.IMediaSessionService";
        static final int TRANSACTION_connect = 1;

        public static class Proxy implements IMediaSessionService {
            public static IMediaSessionService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void connect(IMediaController iMediaController, ParcelImpl parcelImpl) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().connect(iMediaController, parcelImpl);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaSessionService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMediaSessionService)) {
                return new Proxy(iBinder);
            }
            return (IMediaSessionService) queryLocalInterface;
        }

        public static IMediaSessionService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMediaSessionService iMediaSessionService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iMediaSessionService == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iMediaSessionService;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            ParcelImpl parcelImpl;
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                IMediaController asInterface = IMediaController.Stub.asInterface(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    parcelImpl = ParcelImpl.CREATOR.createFromParcel(parcel);
                } else {
                    parcelImpl = null;
                }
                connect(asInterface, parcelImpl);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void connect(IMediaController iMediaController, ParcelImpl parcelImpl) throws RemoteException;
}
