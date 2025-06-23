package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes10.dex */
public interface ISplashApi extends IInterface {

    /* loaded from: classes10.dex */
    public static class a implements ISplashApi {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public boolean isDestroyed() {
            return false;
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public boolean isFinishing() {
            return false;
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void notifyAdDismissed() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void notifyAdFailedToLoad(int i) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public String notifyAdLoaded() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onAdFailToDisplay() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onAdShowEnd(long j, int i) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onDisplayTimeUp() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onEasterEggPrepare() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onFeedback(int i) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onMaterialLoadFailed() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onMaterialLoaded() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onSkipAd(int i, int i2) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onStartEasterEggFailed(Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public boolean onTouch(int i, int i2, long j, String str, int i3) {
            return false;
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public boolean processWhyEventUnified() {
            return false;
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void removeExSplashBlock() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void reportEvents(String str, Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void reportShowStartEvent() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void reportSplashEvent(Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void toShowSpare(int i) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void updatePhyShowStart(long j) {
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class b extends Binder implements ISplashApi {
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
        static final int f17326a = 11;
        static final int b = 12;
        static final int c = 13;
        static final int d = 14;
        static final int e = 15;
        static final int f = 16;
        static final int g = 17;
        static final int h = 18;
        static final int i = 19;
        static final int j = 20;
        static final int k = 21;
        static final int l = 22;
        private static final String m = "com.huawei.hms.ads.uiengine.ISplashApi";

        /* loaded from: classes10.dex */
        public static class a implements ISplashApi {
            public static ISplashApi Code;
            private IBinder V;

            public a(IBinder iBinder) {
                this.V = iBinder;
            }

            public String Code() {
                return b.m;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.V;
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public boolean isDestroyed() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.m);
                    if (!this.V.transact(19, obtain, obtain2, 0) && b.Code() != null) {
                        return b.Code().isDestroyed();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public boolean isFinishing() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.m);
                    if (!this.V.transact(18, obtain, obtain2, 0) && b.Code() != null) {
                        return b.Code().isFinishing();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void notifyAdDismissed() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.m);
                    if (this.V.transact(7, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().notifyAdDismissed();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void notifyAdFailedToLoad(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.m);
                    obtain.writeInt(i);
                    if (this.V.transact(9, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().notifyAdFailedToLoad(i);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public String notifyAdLoaded() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.m);
                    if (!this.V.transact(2, obtain, obtain2, 0) && b.Code() != null) {
                        return b.Code().notifyAdLoaded();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onAdFailToDisplay() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.m);
                    if (this.V.transact(6, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onAdFailToDisplay();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onAdShowEnd(long j, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.m);
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    if (this.V.transact(15, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onAdShowEnd(j, i);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onDisplayTimeUp() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.m);
                    if (this.V.transact(12, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onDisplayTimeUp();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onEasterEggPrepare() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.m);
                    if (this.V.transact(20, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onEasterEggPrepare();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onFeedback(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.m);
                    obtain.writeInt(i);
                    if (this.V.transact(14, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onFeedback(i);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onMaterialLoadFailed() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.m);
                    if (this.V.transact(11, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onMaterialLoadFailed();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onMaterialLoaded() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.m);
                    if (this.V.transact(5, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onMaterialLoaded();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onSkipAd(int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.m);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.V.transact(13, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onSkipAd(i, i2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onStartEasterEggFailed(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.m);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(17, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.Code().onStartEasterEggFailed(bundle);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public boolean onTouch(int i, int i2, long j, String str, int i3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.m);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    try {
                        if (!this.V.transact(1, obtain, obtain2, 0) && b.Code() != null) {
                            boolean onTouch = b.Code().onTouch(i, i2, j, str, i3);
                            obtain2.recycle();
                            obtain.recycle();
                            return onTouch;
                        }
                        obtain2.readException();
                        boolean z = obtain2.readInt() != 0;
                        obtain2.recycle();
                        obtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public boolean processWhyEventUnified() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.m);
                    if (!this.V.transact(21, obtain, obtain2, 0) && b.Code() != null) {
                        return b.Code().processWhyEventUnified();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void removeExSplashBlock() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.m);
                    if (this.V.transact(10, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().removeExSplashBlock();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void reportEvents(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.m);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(16, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.Code().reportEvents(str, bundle);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void reportShowStartEvent() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.m);
                    if (this.V.transact(3, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().reportShowStartEvent();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void reportSplashEvent(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.m);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(22, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.Code().reportSplashEvent(bundle);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void toShowSpare(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.m);
                    obtain.writeInt(i);
                    if (this.V.transact(8, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().toShowSpare(i);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void updatePhyShowStart(long j) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.m);
                    obtain.writeLong(j);
                    if (this.V.transact(4, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().updatePhyShowStart(j);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, m);
        }

        public static ISplashApi Code() {
            return a.Code;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1598968902) {
                parcel2.writeString(m);
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface(m);
                    boolean onTouch = onTouch(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(onTouch ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(m);
                    String notifyAdLoaded = notifyAdLoaded();
                    parcel2.writeNoException();
                    parcel2.writeString(notifyAdLoaded);
                    return true;
                case 3:
                    parcel.enforceInterface(m);
                    reportShowStartEvent();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(m);
                    updatePhyShowStart(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(m);
                    onMaterialLoaded();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(m);
                    onAdFailToDisplay();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(m);
                    notifyAdDismissed();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(m);
                    toShowSpare(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(m);
                    notifyAdFailedToLoad(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(m);
                    removeExSplashBlock();
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(m);
                    onMaterialLoadFailed();
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(m);
                    onDisplayTimeUp();
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(m);
                    onSkipAd(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(m);
                    onFeedback(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface(m);
                    onAdShowEnd(parcel.readLong(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface(m);
                    reportEvents(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface(m);
                    onStartEasterEggFailed(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface(m);
                    boolean isFinishing = isFinishing();
                    parcel2.writeNoException();
                    parcel2.writeInt(isFinishing ? 1 : 0);
                    return true;
                case 19:
                    parcel.enforceInterface(m);
                    boolean isDestroyed = isDestroyed();
                    parcel2.writeNoException();
                    parcel2.writeInt(isDestroyed ? 1 : 0);
                    return true;
                case 20:
                    parcel.enforceInterface(m);
                    onEasterEggPrepare();
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface(m);
                    boolean processWhyEventUnified = processWhyEventUnified();
                    parcel2.writeNoException();
                    parcel2.writeInt(processWhyEventUnified ? 1 : 0);
                    return true;
                case 22:
                    parcel.enforceInterface(m);
                    reportSplashEvent(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        public static ISplashApi Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(m);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ISplashApi)) ? new a(iBinder) : (ISplashApi) queryLocalInterface;
        }

        public static boolean Code(ISplashApi iSplashApi) {
            if (a.Code != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iSplashApi == null) {
                return false;
            }
            a.Code = iSplashApi;
            return true;
        }
    }

    boolean isDestroyed();

    boolean isFinishing();

    void notifyAdDismissed();

    void notifyAdFailedToLoad(int i);

    String notifyAdLoaded();

    void onAdFailToDisplay();

    void onAdShowEnd(long j, int i);

    void onDisplayTimeUp();

    void onEasterEggPrepare();

    void onFeedback(int i);

    void onMaterialLoadFailed();

    void onMaterialLoaded();

    void onSkipAd(int i, int i2);

    void onStartEasterEggFailed(Bundle bundle);

    boolean onTouch(int i, int i2, long j, String str, int i3);

    boolean processWhyEventUnified();

    void removeExSplashBlock();

    void reportEvents(String str, Bundle bundle);

    void reportShowStartEvent();

    void reportSplashEvent(Bundle bundle);

    void toShowSpare(int i);

    void updatePhyShowStart(long j);
}
