package com.huawei.hms.ads.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes10.dex */
public interface IObjectWrapper extends IInterface {

    /* loaded from: classes10.dex */
    public static class Default implements IObjectWrapper {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class Stub extends Binder implements IObjectWrapper {

        /* renamed from: a, reason: collision with root package name */
        private static final String f17269a = "com.huawei.hms.ads.dynamic.IObjectWrapper";

        /* loaded from: classes10.dex */
        public static class Proxy implements IObjectWrapper {
            public static IObjectWrapper sDefaultImpl;

            /* renamed from: a, reason: collision with root package name */
            private IBinder f17270a;

            public Proxy(IBinder iBinder) {
                this.f17270a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f17270a;
            }

            public String getInterfaceDescriptor() {
                return Stub.f17269a;
            }
        }

        public Stub() {
            attachInterface(this, f17269a);
        }

        public static IObjectWrapper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f17269a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IObjectWrapper)) ? new Proxy(iBinder) : (IObjectWrapper) queryLocalInterface;
        }

        public static IObjectWrapper getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IObjectWrapper iObjectWrapper) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iObjectWrapper == null) {
                return false;
            }
            Proxy.sDefaultImpl = iObjectWrapper;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(f17269a);
            return true;
        }
    }
}
