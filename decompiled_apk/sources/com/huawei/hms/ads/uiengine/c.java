package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;

/* loaded from: classes10.dex */
public interface c extends IInterface {

    /* loaded from: classes10.dex */
    public static class a implements c {
        @Override // com.huawei.hms.ads.uiengine.c
        public boolean B() {
            return false;
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code() {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public String I() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void V() {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public boolean Z() {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(int i) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void V(String str, long j, long j2, int i, int i2) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(long j, long j2) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void V(String str, Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(IObjectWrapper iObjectWrapper) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(IObjectWrapper iObjectWrapper, int i) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(IObjectWrapper iObjectWrapper, Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(IObjectWrapper iObjectWrapper, String str) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(IObjectWrapper iObjectWrapper, String str, Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(IPPSUiEngineCallback iPPSUiEngineCallback) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(String str, int i) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(String str, long j, long j2, int i, int i2) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(boolean z) {
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class b extends Binder implements c {
        private static final String Code = "com.huawei.hms.ads.uiengine.INativeApi";
        static final int D = 1;
        static final int L = 2;

        /* renamed from: a, reason: collision with root package name */
        static final int f17327a = 3;
        static final int b = 4;
        static final int c = 5;
        static final int d = 6;
        static final int e = 7;
        static final int f = 8;
        static final int g = 9;
        static final int h = 10;
        static final int i = 11;
        static final int j = 12;
        static final int k = 13;
        static final int l = 14;
        static final int m = 15;
        static final int n = 16;
        static final int o = 17;
        static final int p = 18;
        static final int q = 19;
        static final int r = 20;

        /* loaded from: classes10.dex */
        public static class a implements c {
            public static c Code;
            private IBinder V;

            public a(IBinder iBinder) {
                this.V = iBinder;
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public boolean B() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    if (!this.V.transact(10, obtain, obtain2, 0) && b.S() != null) {
                        return b.S().B();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String C() {
                return b.Code;
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    if (this.V.transact(19, obtain, obtain2, 0) || b.S() == null) {
                        obtain2.readException();
                    } else {
                        b.S().Code();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public String I() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    if (!this.V.transact(17, obtain, obtain2, 0) && b.S() != null) {
                        return b.S().I();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void V() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    if (this.V.transact(15, obtain, obtain2, 0) || b.S() == null) {
                        obtain2.readException();
                    } else {
                        b.S().V();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public boolean Z() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    if (!this.V.transact(8, obtain, obtain2, 0) && b.S() != null) {
                        return b.S().Z();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.V;
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    obtain.writeInt(i);
                    if (this.V.transact(13, obtain, obtain2, 0) || b.S() == null) {
                        obtain2.readException();
                    } else {
                        b.S().Code(i);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void V(String str, long j, long j2, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (this.V.transact(3, obtain, obtain2, 0) || b.S() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.S().V(str, j, j2, i, i2);
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

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(long j, long j2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    if (this.V.transact(5, obtain, obtain2, 0) || b.S() == null) {
                        obtain2.readException();
                    } else {
                        b.S().Code(j, j2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void V(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(18, obtain, obtain2, 0) || b.S() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.S().V(str, bundle);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(16, obtain, obtain2, 0) || b.S() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.S().Code(bundle);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(IObjectWrapper iObjectWrapper) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (this.V.transact(6, obtain, obtain2, 0) || b.S() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.S().Code(iObjectWrapper);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(IObjectWrapper iObjectWrapper, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    obtain.writeInt(i);
                    if (this.V.transact(7, obtain, obtain2, 0) || b.S() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.S().Code(iObjectWrapper, i);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(12, obtain, obtain2, 0) || b.S() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.S().Code(iObjectWrapper, bundle);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(IObjectWrapper iObjectWrapper, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    obtain.writeString(str);
                    if (this.V.transact(9, obtain, obtain2, 0) || b.S() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.S().Code(iObjectWrapper, str);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(IObjectWrapper iObjectWrapper, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(11, obtain, obtain2, 0) || b.S() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.S().Code(iObjectWrapper, str, bundle);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    obtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.V.transact(14, obtain, obtain2, 0) || b.S() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.S().Code(iPPSUiEngineCallback);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(String str, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (this.V.transact(1, obtain, obtain2, 0) || b.S() == null) {
                        obtain2.readException();
                    } else {
                        b.S().Code(str, i);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(String str, long j, long j2, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (this.V.transact(2, obtain, obtain2, 0) || b.S() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.S().Code(str, j, j2, i, i2);
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

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(20, obtain, obtain2, 0) || b.S() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.S().Code(str, iObjectWrapper, bundle);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.V.transact(4, obtain, obtain2, 0) || b.S() == null) {
                        obtain2.readException();
                    } else {
                        b.S().Code(z);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, Code);
        }

        public static c Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(Code);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new a(iBinder) : (c) queryLocalInterface;
        }

        public static c S() {
            return a.Code;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1598968902) {
                parcel2.writeString(Code);
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface(Code);
                    Code(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(Code);
                    Code(parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(Code);
                    V(parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(Code);
                    Code(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(Code);
                    Code(parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(Code);
                    Code(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(Code);
                    Code(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(Code);
                    boolean Z = Z();
                    parcel2.writeNoException();
                    parcel2.writeInt(Z ? 1 : 0);
                    return true;
                case 9:
                    parcel.enforceInterface(Code);
                    Code(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(Code);
                    boolean B = B();
                    parcel2.writeNoException();
                    parcel2.writeInt(B ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface(Code);
                    Code(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(Code);
                    Code(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(Code);
                    Code(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(Code);
                    Code(IPPSUiEngineCallback.b.Code(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface(Code);
                    V();
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface(Code);
                    Code(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface(Code);
                    String I = I();
                    parcel2.writeNoException();
                    parcel2.writeString(I);
                    return true;
                case 18:
                    parcel.enforceInterface(Code);
                    V(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface(Code);
                    Code();
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface(Code);
                    Code(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        public static boolean Code(c cVar) {
            if (a.Code != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (cVar == null) {
                return false;
            }
            a.Code = cVar;
            return true;
        }
    }

    boolean B();

    void Code();

    void Code(int i);

    void Code(long j, long j2);

    void Code(Bundle bundle);

    void Code(IObjectWrapper iObjectWrapper);

    void Code(IObjectWrapper iObjectWrapper, int i);

    void Code(IObjectWrapper iObjectWrapper, Bundle bundle);

    void Code(IObjectWrapper iObjectWrapper, String str);

    void Code(IObjectWrapper iObjectWrapper, String str, Bundle bundle);

    void Code(IPPSUiEngineCallback iPPSUiEngineCallback);

    void Code(String str, int i);

    void Code(String str, long j, long j2, int i, int i2);

    void Code(String str, IObjectWrapper iObjectWrapper, Bundle bundle);

    void Code(boolean z);

    String I();

    void V();

    void V(String str, long j, long j2, int i, int i2);

    void V(String str, Bundle bundle);

    boolean Z();
}
