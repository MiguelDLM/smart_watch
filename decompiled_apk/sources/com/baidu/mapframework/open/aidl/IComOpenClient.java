package com.baidu.mapframework.open.aidl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes7.dex */
public interface IComOpenClient extends IInterface {
    String a(String str) throws RemoteException;

    boolean a(String str, String str2, Bundle bundle) throws RemoteException;

    /* loaded from: classes7.dex */
    public static abstract class a extends Binder implements IComOpenClient {
        public static IComOpenClient a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.mapframework.open.aidl.IComOpenClient");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IComOpenClient)) {
                return (IComOpenClient) queryLocalInterface;
            }
            return new C0134a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Bundle bundle;
            if (i != 1) {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.baidu.mapframework.open.aidl.IComOpenClient");
                    return true;
                }
                parcel.enforceInterface("com.baidu.mapframework.open.aidl.IComOpenClient");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle = null;
                }
                boolean a2 = a(readString, readString2, bundle);
                parcel2.writeNoException();
                parcel2.writeInt(a2 ? 1 : 0);
                return true;
            }
            parcel.enforceInterface("com.baidu.mapframework.open.aidl.IComOpenClient");
            String a3 = a(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(a3);
            return true;
        }

        public static IComOpenClient a() {
            return C0134a.f6123a;
        }

        /* renamed from: com.baidu.mapframework.open.aidl.IComOpenClient$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0134a implements IComOpenClient {

            /* renamed from: a, reason: collision with root package name */
            public static IComOpenClient f6123a;
            private IBinder b;

            public C0134a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.baidu.mapframework.open.aidl.IComOpenClient
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.mapframework.open.aidl.IComOpenClient");
                    obtain.writeString(str);
                    if (!this.b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(str);
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
                return this.b;
            }

            @Override // com.baidu.mapframework.open.aidl.IComOpenClient
            public boolean a(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.mapframework.open.aidl.IComOpenClient");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.b.transact(2, obtain, obtain2, 0) && a.a() != null) {
                        boolean a2 = a.a().a(str, str2, bundle);
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
        }
    }
}
