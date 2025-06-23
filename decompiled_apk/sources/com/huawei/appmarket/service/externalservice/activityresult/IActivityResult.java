package com.huawei.appmarket.service.externalservice.activityresult;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes10.dex */
public interface IActivityResult extends IInterface {

    /* loaded from: classes10.dex */
    public static abstract class II0xO0 extends Binder implements IActivityResult {
        static final int Code = 1;
        private static final String V = "com.huawei.appmarket.service.externalservice.activityresult.IActivityResult";

        /* loaded from: classes10.dex */
        public static class oIX0oI implements IActivityResult {

            /* renamed from: Oo, reason: collision with root package name */
            public static IActivityResult f17248Oo;

            /* renamed from: XO, reason: collision with root package name */
            public IBinder f17249XO;

            public oIX0oI(IBinder iBinder) {
                this.f17249XO = iBinder;
            }

            public String XO() {
                return II0xO0.V;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f17249XO;
            }

            @Override // com.huawei.appmarket.service.externalservice.activityresult.IActivityResult
            public void onActivityCancel(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(II0xO0.V);
                    obtain.writeInt(i);
                    if (this.f17249XO.transact(1, obtain, obtain2, 0) || II0xO0.Code() == null) {
                        obtain2.readException();
                    } else {
                        II0xO0.Code().onActivityCancel(i);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public II0xO0() {
            attachInterface(this, V);
        }

        public static IActivityResult Code() {
            return oIX0oI.f17248Oo;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(V);
                return true;
            }
            parcel.enforceInterface(V);
            onActivityCancel(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        public static IActivityResult Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(V);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IActivityResult)) ? new oIX0oI(iBinder) : (IActivityResult) queryLocalInterface;
        }

        public static boolean Code(IActivityResult iActivityResult) {
            if (oIX0oI.f17248Oo != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iActivityResult == null) {
                return false;
            }
            oIX0oI.f17248Oo = iActivityResult;
            return true;
        }
    }

    /* loaded from: classes10.dex */
    public static class oIX0oI implements IActivityResult {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.appmarket.service.externalservice.activityresult.IActivityResult
        public void onActivityCancel(int i) {
        }
    }

    void onActivityCancel(int i);
}
