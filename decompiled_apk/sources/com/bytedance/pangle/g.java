package com.bytedance.pangle;

import android.content.ComponentName;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes8.dex */
public interface g extends IInterface {
    int a();

    void a(ComponentName componentName, IBinder iBinder);

    /* loaded from: classes8.dex */
    public static abstract class a extends Binder implements g {
        public a() {
            attachInterface(this, "com.bytedance.pangle.ServiceConnection");
        }

        public static g a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.ServiceConnection");
            if (queryLocalInterface != null && (queryLocalInterface instanceof g)) {
                return (g) queryLocalInterface;
            }
            return new C0559a(iBinder);
        }

        public static g b() {
            return C0559a.f10556a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            ComponentName componentName;
            if (i != 1) {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.bytedance.pangle.ServiceConnection");
                    return true;
                }
                parcel.enforceInterface("com.bytedance.pangle.ServiceConnection");
                int a2 = a();
                parcel2.writeNoException();
                parcel2.writeInt(a2);
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.ServiceConnection");
            if (parcel.readInt() != 0) {
                componentName = (ComponentName) ComponentName.CREATOR.createFromParcel(parcel);
            } else {
                componentName = null;
            }
            a(componentName, parcel.readStrongBinder());
            parcel2.writeNoException();
            return true;
        }

        /* renamed from: com.bytedance.pangle.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static class C0559a implements g {

            /* renamed from: a, reason: collision with root package name */
            public static g f10556a;
            private IBinder b;

            public C0559a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.bytedance.pangle.g
            public final void a(ComponentName componentName, IBinder iBinder) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.ServiceConnection");
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.b.transact(1, obtain, obtain2, 0) && a.b() != null) {
                        a.b().a(componentName, iBinder);
                    } else {
                        obtain2.readException();
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.b;
            }

            @Override // com.bytedance.pangle.g
            public final int a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.ServiceConnection");
                    if (!this.b.transact(2, obtain, obtain2, 0) && a.b() != null) {
                        return a.b().a();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
