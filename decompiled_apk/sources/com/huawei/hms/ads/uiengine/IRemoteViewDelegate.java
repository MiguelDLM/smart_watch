package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;

/* loaded from: classes10.dex */
public interface IRemoteViewDelegate extends IInterface {

    /* loaded from: classes10.dex */
    public static class a implements IRemoteViewDelegate {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public IObjectWrapper getView() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void onCreate(Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void onDestroy() {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void onPause() {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void onRestart() {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void onResume() {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void onStart() {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void onStop() {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public Bundle sendCommand(String str, Bundle bundle) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void setCallback(IPPSUiEngineCallback iPPSUiEngineCallback) {
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class b extends Binder implements IRemoteViewDelegate {
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
        private static final String f17325a = "com.huawei.hms.ads.uiengine.IRemoteViewDelegate";

        /* loaded from: classes10.dex */
        public static class a implements IRemoteViewDelegate {
            public static IRemoteViewDelegate Code;
            private IBinder V;

            public a(IBinder iBinder) {
                this.V = iBinder;
            }

            public String Code() {
                return b.f17325a;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.V;
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public IObjectWrapper getView() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f17325a);
                    if (!this.V.transact(1, obtain, obtain2, 0) && b.Code() != null) {
                        return b.Code().getView();
                    }
                    obtain2.readException();
                    return IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onCreate(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f17325a);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(2, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.Code().onCreate(bundle);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onDestroy() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f17325a);
                    if (this.V.transact(3, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onDestroy();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onPause() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f17325a);
                    if (this.V.transact(4, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onPause();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onRestart() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f17325a);
                    if (this.V.transact(8, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onRestart();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onResume() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f17325a);
                    if (this.V.transact(5, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onResume();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onStart() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f17325a);
                    if (this.V.transact(6, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onStart();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onStop() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f17325a);
                    if (this.V.transact(7, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onStop();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public Bundle sendCommand(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f17325a);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.V.transact(10, obtain, obtain2, 0) && b.Code() != null) {
                        Bundle sendCommand = b.Code().sendCommand(str, bundle);
                        obtain2.recycle();
                        obtain.recycle();
                        return sendCommand;
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

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void setCallback(IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f17325a);
                    obtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.V.transact(9, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.Code().setCallback(iPPSUiEngineCallback);
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
            attachInterface(this, f17325a);
        }

        public static IRemoteViewDelegate Code() {
            return a.Code;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(f17325a);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(f17325a);
                    IObjectWrapper view = getView();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(view != null ? view.asBinder() : null);
                    return true;
                case 2:
                    parcel.enforceInterface(f17325a);
                    onCreate(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    break;
                case 3:
                    parcel.enforceInterface(f17325a);
                    onDestroy();
                    break;
                case 4:
                    parcel.enforceInterface(f17325a);
                    onPause();
                    break;
                case 5:
                    parcel.enforceInterface(f17325a);
                    onResume();
                    break;
                case 6:
                    parcel.enforceInterface(f17325a);
                    onStart();
                    break;
                case 7:
                    parcel.enforceInterface(f17325a);
                    onStop();
                    break;
                case 8:
                    parcel.enforceInterface(f17325a);
                    onRestart();
                    break;
                case 9:
                    parcel.enforceInterface(f17325a);
                    setCallback(IPPSUiEngineCallback.b.Code(parcel.readStrongBinder()));
                    break;
                case 10:
                    parcel.enforceInterface(f17325a);
                    Bundle sendCommand = sendCommand(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (sendCommand != null) {
                        parcel2.writeInt(1);
                        sendCommand.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeNoException();
            return true;
        }

        public static IRemoteViewDelegate Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f17325a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IRemoteViewDelegate)) ? new a(iBinder) : (IRemoteViewDelegate) queryLocalInterface;
        }

        public static boolean Code(IRemoteViewDelegate iRemoteViewDelegate) {
            if (a.Code != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iRemoteViewDelegate == null) {
                return false;
            }
            a.Code = iRemoteViewDelegate;
            return true;
        }
    }

    IObjectWrapper getView();

    void onCreate(Bundle bundle);

    void onDestroy();

    void onPause();

    void onRestart();

    void onResume();

    void onStart();

    void onStop();

    Bundle sendCommand(String str, Bundle bundle);

    void setCallback(IPPSUiEngineCallback iPPSUiEngineCallback);
}
