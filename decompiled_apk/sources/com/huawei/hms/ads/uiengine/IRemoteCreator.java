package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.uiengine.IGlobalUtil;
import com.huawei.hms.ads.uiengine.IRemoteViewDelegate;
import com.huawei.hms.ads.uiengine.ISplashApi;
import com.huawei.hms.ads.uiengine.c;
import com.huawei.hms.ads.uiengine.d;

/* loaded from: classes10.dex */
public interface IRemoteCreator extends IInterface {

    /* loaded from: classes10.dex */
    public static class a implements IRemoteCreator {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public void bindData(IObjectWrapper iObjectWrapper, String str) {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public void destroyView(IObjectWrapper iObjectWrapper) {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public d getUiEngineUtil() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public String getVersion() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public IObjectWrapper newBannerTemplateView(Bundle bundle) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public IObjectWrapper newNativeTemplateView(Bundle bundle, c cVar) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public IRemoteViewDelegate newRemoteViewDelegate(IObjectWrapper iObjectWrapper, String str, Bundle bundle) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public IObjectWrapper newRewardTemplateView() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public IObjectWrapper newSplashTemplateView(Bundle bundle, ISplashApi iSplashApi) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public void setGlobalUtil(IGlobalUtil iGlobalUtil) {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public void setSdkInfo(int i, int i2, Bundle bundle) {
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class b extends Binder implements IRemoteCreator {
        static final int B = 5;
        static final int C = 6;
        static final int Code = 1;
        static final int D = 9;
        static final int F = 8;
        static final int I = 3;
        static final int L = 10;
        static final int S = 7;
        static final int V = 2;
        static final int Z = 4;

        /* renamed from: a, reason: collision with root package name */
        static final int f17324a = 11;
        private static final String b = "com.huawei.hms.ads.uiengine.IRemoteCreator";

        /* loaded from: classes10.dex */
        public static class a implements IRemoteCreator {
            public static IRemoteCreator Code;
            private IBinder V;

            public a(IBinder iBinder) {
                this.V = iBinder;
            }

            public String Code() {
                return b.b;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.V;
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public void bindData(IObjectWrapper iObjectWrapper, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.b);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    obtain.writeString(str);
                    if (this.V.transact(6, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.Code().bindData(iObjectWrapper, str);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public void destroyView(IObjectWrapper iObjectWrapper) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.b);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (this.V.transact(8, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.Code().destroyView(iObjectWrapper);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public d getUiEngineUtil() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.b);
                    if (!this.V.transact(9, obtain, obtain2, 0) && b.Code() != null) {
                        return b.Code().getUiEngineUtil();
                    }
                    obtain2.readException();
                    return d.b.Code(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public String getVersion() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.b);
                    if (!this.V.transact(1, obtain, obtain2, 0) && b.Code() != null) {
                        return b.Code().getVersion();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public IObjectWrapper newBannerTemplateView(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.b);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.V.transact(5, obtain, obtain2, 0) && b.Code() != null) {
                        IObjectWrapper newBannerTemplateView = b.Code().newBannerTemplateView(bundle);
                        obtain2.recycle();
                        obtain.recycle();
                        return newBannerTemplateView;
                    }
                    obtain2.readException();
                    IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return asInterface;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public IObjectWrapper newNativeTemplateView(Bundle bundle, c cVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.b);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    if (!this.V.transact(4, obtain, obtain2, 0) && b.Code() != null) {
                        IObjectWrapper newNativeTemplateView = b.Code().newNativeTemplateView(bundle, cVar);
                        obtain2.recycle();
                        obtain.recycle();
                        return newNativeTemplateView;
                    }
                    obtain2.readException();
                    IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return asInterface;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public IRemoteViewDelegate newRemoteViewDelegate(IObjectWrapper iObjectWrapper, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.b);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.V.transact(7, obtain, obtain2, 0) && b.Code() != null) {
                        IRemoteViewDelegate newRemoteViewDelegate = b.Code().newRemoteViewDelegate(iObjectWrapper, str, bundle);
                        obtain2.recycle();
                        obtain.recycle();
                        return newRemoteViewDelegate;
                    }
                    obtain2.readException();
                    IRemoteViewDelegate Code2 = IRemoteViewDelegate.b.Code(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return Code2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public IObjectWrapper newRewardTemplateView() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.b);
                    if (!this.V.transact(10, obtain, obtain2, 0) && b.Code() != null) {
                        return b.Code().newRewardTemplateView();
                    }
                    obtain2.readException();
                    return IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public IObjectWrapper newSplashTemplateView(Bundle bundle, ISplashApi iSplashApi) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.b);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iSplashApi != null ? iSplashApi.asBinder() : null);
                    if (!this.V.transact(3, obtain, obtain2, 0) && b.Code() != null) {
                        IObjectWrapper newSplashTemplateView = b.Code().newSplashTemplateView(bundle, iSplashApi);
                        obtain2.recycle();
                        obtain.recycle();
                        return newSplashTemplateView;
                    }
                    obtain2.readException();
                    IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return asInterface;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public void setGlobalUtil(IGlobalUtil iGlobalUtil) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.b);
                    obtain.writeStrongBinder(iGlobalUtil != null ? iGlobalUtil.asBinder() : null);
                    if (this.V.transact(2, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.Code().setGlobalUtil(iGlobalUtil);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public void setSdkInfo(int i, int i2, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.b);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(11, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.Code().setSdkInfo(i, i2, bundle);
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
            attachInterface(this, b);
        }

        public static IRemoteCreator Code() {
            return a.Code;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(b);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(b);
                    String version = getVersion();
                    parcel2.writeNoException();
                    parcel2.writeString(version);
                    return true;
                case 2:
                    parcel.enforceInterface(b);
                    setGlobalUtil(IGlobalUtil.b.Code(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(b);
                    IObjectWrapper newSplashTemplateView = newSplashTemplateView(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, ISplashApi.b.Code(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(newSplashTemplateView != null ? newSplashTemplateView.asBinder() : null);
                    return true;
                case 4:
                    parcel.enforceInterface(b);
                    IObjectWrapper newNativeTemplateView = newNativeTemplateView(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, c.b.Code(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(newNativeTemplateView != null ? newNativeTemplateView.asBinder() : null);
                    return true;
                case 5:
                    parcel.enforceInterface(b);
                    IObjectWrapper newBannerTemplateView = newBannerTemplateView(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(newBannerTemplateView != null ? newBannerTemplateView.asBinder() : null);
                    return true;
                case 6:
                    parcel.enforceInterface(b);
                    bindData(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(b);
                    IRemoteViewDelegate newRemoteViewDelegate = newRemoteViewDelegate(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(newRemoteViewDelegate != null ? newRemoteViewDelegate.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface(b);
                    destroyView(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(b);
                    d uiEngineUtil = getUiEngineUtil();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(uiEngineUtil != null ? uiEngineUtil.asBinder() : null);
                    return true;
                case 10:
                    parcel.enforceInterface(b);
                    IObjectWrapper newRewardTemplateView = newRewardTemplateView();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(newRewardTemplateView != null ? newRewardTemplateView.asBinder() : null);
                    return true;
                case 11:
                    parcel.enforceInterface(b);
                    setSdkInfo(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        public static IRemoteCreator Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(b);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IRemoteCreator)) ? new a(iBinder) : (IRemoteCreator) queryLocalInterface;
        }

        public static boolean Code(IRemoteCreator iRemoteCreator) {
            if (a.Code != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iRemoteCreator == null) {
                return false;
            }
            a.Code = iRemoteCreator;
            return true;
        }
    }

    void bindData(IObjectWrapper iObjectWrapper, String str);

    void destroyView(IObjectWrapper iObjectWrapper);

    d getUiEngineUtil();

    String getVersion();

    IObjectWrapper newBannerTemplateView(Bundle bundle);

    IObjectWrapper newNativeTemplateView(Bundle bundle, c cVar);

    IRemoteViewDelegate newRemoteViewDelegate(IObjectWrapper iObjectWrapper, String str, Bundle bundle);

    IObjectWrapper newRewardTemplateView();

    IObjectWrapper newSplashTemplateView(Bundle bundle, ISplashApi iSplashApi);

    void setGlobalUtil(IGlobalUtil iGlobalUtil);

    void setSdkInfo(int i, int i2, Bundle bundle);
}
