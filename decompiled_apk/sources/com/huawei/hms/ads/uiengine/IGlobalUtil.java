package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;
import com.huawei.hms.ads.uiengine.b;

/* loaded from: classes10.dex */
public interface IGlobalUtil extends IInterface {

    /* loaded from: classes10.dex */
    public static class a implements IGlobalUtil {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
        public Bundle callMethod(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
        public void getFilePath(String str, IPPSUiEngineCallback iPPSUiEngineCallback) {
        }

        @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
        public String getFilePathDirect(String str) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
        public String getFilePathDirectByCacheType(String str, int i) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
        public com.huawei.hms.ads.uiengine.b getMultiMediaPlayingManager() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
        public boolean isFreedomWindowMode(IObjectWrapper iObjectWrapper) {
            return false;
        }

        @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
        public void registerActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
        }

        @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
        public void unregisterActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class b extends Binder implements IGlobalUtil {
        static final int B = 5;
        static final int C = 6;
        static final int Code = 1;
        private static final String D = "com.huawei.hms.ads.uiengine.IGlobalUtil";
        static final int F = 8;
        static final int I = 3;
        static final int S = 7;
        static final int V = 2;
        static final int Z = 4;

        /* loaded from: classes10.dex */
        public static class a implements IGlobalUtil {
            public static IGlobalUtil Code;
            private IBinder V;

            public a(IBinder iBinder) {
                this.V = iBinder;
            }

            public String Code() {
                return b.D;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.V;
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public Bundle callMethod(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.D);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.V.transact(8, obtain, obtain2, 0) && b.Code() != null) {
                        Bundle callMethod = b.Code().callMethod(str, iObjectWrapper, bundle);
                        obtain2.recycle();
                        obtain.recycle();
                        return callMethod;
                    }
                    obtain2.readException();
                    Bundle bundle2 = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public void getFilePath(String str, IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.D);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.V.transact(1, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.Code().getFilePath(str, iPPSUiEngineCallback);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public String getFilePathDirect(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.D);
                    obtain.writeString(str);
                    if (!this.V.transact(4, obtain, obtain2, 0) && b.Code() != null) {
                        return b.Code().getFilePathDirect(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public String getFilePathDirectByCacheType(String str, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.D);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (!this.V.transact(5, obtain, obtain2, 0) && b.Code() != null) {
                        return b.Code().getFilePathDirectByCacheType(str, i);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public com.huawei.hms.ads.uiengine.b getMultiMediaPlayingManager() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.D);
                    if (!this.V.transact(6, obtain, obtain2, 0) && b.Code() != null) {
                        return b.Code().getMultiMediaPlayingManager();
                    }
                    obtain2.readException();
                    return b.AbstractBinderC0657b.Code(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public boolean isFreedomWindowMode(IObjectWrapper iObjectWrapper) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.D);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (!this.V.transact(7, obtain, obtain2, 0) && b.Code() != null) {
                        boolean isFreedomWindowMode = b.Code().isFreedomWindowMode(iObjectWrapper);
                        obtain2.recycle();
                        obtain.recycle();
                        return isFreedomWindowMode;
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

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public void registerActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.D);
                    obtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.V.transact(2, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.Code().registerActivityStartCallBack(iPPSUiEngineCallback);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public void unregisterActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.D);
                    obtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.V.transact(3, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.Code().unregisterActivityStartCallBack(iPPSUiEngineCallback);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public b() {
            attachInterface(this, D);
        }

        public static IGlobalUtil Code() {
            return a.Code;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(D);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(D);
                    getFilePath(parcel.readString(), IPPSUiEngineCallback.b.Code(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(D);
                    registerActivityStartCallBack(IPPSUiEngineCallback.b.Code(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(D);
                    unregisterActivityStartCallBack(IPPSUiEngineCallback.b.Code(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(D);
                    String filePathDirect = getFilePathDirect(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(filePathDirect);
                    return true;
                case 5:
                    parcel.enforceInterface(D);
                    String filePathDirectByCacheType = getFilePathDirectByCacheType(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(filePathDirectByCacheType);
                    return true;
                case 6:
                    parcel.enforceInterface(D);
                    com.huawei.hms.ads.uiengine.b multiMediaPlayingManager = getMultiMediaPlayingManager();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(multiMediaPlayingManager != null ? multiMediaPlayingManager.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface(D);
                    boolean isFreedomWindowMode = isFreedomWindowMode(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(isFreedomWindowMode ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface(D);
                    Bundle callMethod = callMethod(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (callMethod != null) {
                        parcel2.writeInt(1);
                        callMethod.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        public static IGlobalUtil Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(D);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGlobalUtil)) ? new a(iBinder) : (IGlobalUtil) queryLocalInterface;
        }

        public static boolean Code(IGlobalUtil iGlobalUtil) {
            if (a.Code != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iGlobalUtil == null) {
                return false;
            }
            a.Code = iGlobalUtil;
            return true;
        }
    }

    Bundle callMethod(String str, IObjectWrapper iObjectWrapper, Bundle bundle);

    void getFilePath(String str, IPPSUiEngineCallback iPPSUiEngineCallback);

    String getFilePathDirect(String str);

    String getFilePathDirectByCacheType(String str, int i);

    com.huawei.hms.ads.uiengine.b getMultiMediaPlayingManager();

    boolean isFreedomWindowMode(IObjectWrapper iObjectWrapper);

    void registerActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback);

    void unregisterActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback);
}
