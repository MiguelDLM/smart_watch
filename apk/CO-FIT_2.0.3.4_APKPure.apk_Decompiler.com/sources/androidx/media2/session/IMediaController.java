package androidx.media2.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.media2.common.ParcelImplListSlice;
import androidx.versionedparcelable.ParcelImpl;
import java.util.List;

public interface IMediaController extends IInterface {

    public static class Default implements IMediaController {
        public IBinder asBinder() {
            return null;
        }

        public void onAllowedCommandsChanged(int i, ParcelImpl parcelImpl) throws RemoteException {
        }

        public void onBufferingStateChanged(int i, ParcelImpl parcelImpl, int i2, long j, long j2, long j3) throws RemoteException {
        }

        public void onChildrenChanged(int i, String str, int i2, ParcelImpl parcelImpl) throws RemoteException {
        }

        public void onConnected(int i, ParcelImpl parcelImpl) throws RemoteException {
        }

        public void onCurrentMediaItemChanged(int i, ParcelImpl parcelImpl, int i2, int i3, int i4) throws RemoteException {
        }

        public void onCustomCommand(int i, ParcelImpl parcelImpl, Bundle bundle) throws RemoteException {
        }

        public void onDisconnected(int i) throws RemoteException {
        }

        public void onLibraryResult(int i, ParcelImpl parcelImpl) throws RemoteException {
        }

        public void onPlaybackCompleted(int i) throws RemoteException {
        }

        public void onPlaybackInfoChanged(int i, ParcelImpl parcelImpl) throws RemoteException {
        }

        public void onPlaybackSpeedChanged(int i, long j, long j2, float f) throws RemoteException {
        }

        public void onPlayerStateChanged(int i, long j, long j2, int i2) throws RemoteException {
        }

        public void onPlaylistChanged(int i, ParcelImplListSlice parcelImplListSlice, ParcelImpl parcelImpl, int i2, int i3, int i4) throws RemoteException {
        }

        public void onPlaylistMetadataChanged(int i, ParcelImpl parcelImpl) throws RemoteException {
        }

        public void onRepeatModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
        }

        public void onSearchResultChanged(int i, String str, int i2, ParcelImpl parcelImpl) throws RemoteException {
        }

        public void onSeekCompleted(int i, long j, long j2, long j3) throws RemoteException {
        }

        public void onSessionResult(int i, ParcelImpl parcelImpl) throws RemoteException {
        }

        public void onSetCustomLayout(int i, List<ParcelImpl> list) throws RemoteException {
        }

        public void onShuffleModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
        }

        public void onSubtitleData(int i, ParcelImpl parcelImpl, ParcelImpl parcelImpl2, ParcelImpl parcelImpl3) throws RemoteException {
        }

        public void onTrackDeselected(int i, ParcelImpl parcelImpl) throws RemoteException {
        }

        public void onTrackInfoChanged(int i, List<ParcelImpl> list, ParcelImpl parcelImpl, ParcelImpl parcelImpl2, ParcelImpl parcelImpl3, ParcelImpl parcelImpl4) throws RemoteException {
        }

        public void onTrackSelected(int i, ParcelImpl parcelImpl) throws RemoteException {
        }

        public void onVideoSizeChanged(int i, ParcelImpl parcelImpl, ParcelImpl parcelImpl2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IMediaController {
        private static final String DESCRIPTOR = "androidx.media2.session.IMediaController";
        static final int TRANSACTION_onAllowedCommandsChanged = 15;
        static final int TRANSACTION_onBufferingStateChanged = 4;
        static final int TRANSACTION_onChildrenChanged = 19;
        static final int TRANSACTION_onConnected = 12;
        static final int TRANSACTION_onCurrentMediaItemChanged = 1;
        static final int TRANSACTION_onCustomCommand = 16;
        static final int TRANSACTION_onDisconnected = 13;
        static final int TRANSACTION_onLibraryResult = 18;
        static final int TRANSACTION_onPlaybackCompleted = 10;
        static final int TRANSACTION_onPlaybackInfoChanged = 7;
        static final int TRANSACTION_onPlaybackSpeedChanged = 3;
        static final int TRANSACTION_onPlayerStateChanged = 2;
        static final int TRANSACTION_onPlaylistChanged = 5;
        static final int TRANSACTION_onPlaylistMetadataChanged = 6;
        static final int TRANSACTION_onRepeatModeChanged = 8;
        static final int TRANSACTION_onSearchResultChanged = 20;
        static final int TRANSACTION_onSeekCompleted = 11;
        static final int TRANSACTION_onSessionResult = 17;
        static final int TRANSACTION_onSetCustomLayout = 14;
        static final int TRANSACTION_onShuffleModeChanged = 9;
        static final int TRANSACTION_onSubtitleData = 25;
        static final int TRANSACTION_onTrackDeselected = 24;
        static final int TRANSACTION_onTrackInfoChanged = 22;
        static final int TRANSACTION_onTrackSelected = 23;
        static final int TRANSACTION_onVideoSizeChanged = 21;

        public static class Proxy implements IMediaController {
            public static IMediaController sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void onAllowedCommandsChanged(int i, ParcelImpl parcelImpl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(15, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onAllowedCommandsChanged(i, parcelImpl);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public void onBufferingStateChanged(int i, ParcelImpl parcelImpl, int i2, long j, long j2, long j3) throws RemoteException {
                ParcelImpl parcelImpl2 = parcelImpl;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (parcelImpl2 != null) {
                        obtain.writeInt(1);
                        parcelImpl2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeLong(j3);
                    try {
                        if (this.mRemote.transact(4, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                            obtain.recycle();
                            return;
                        }
                        Stub.getDefaultImpl().onBufferingStateChanged(i, parcelImpl, i2, j, j2, j3);
                        obtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obtain.recycle();
                    throw th;
                }
            }

            public void onChildrenChanged(int i, String str, int i2, ParcelImpl parcelImpl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(19, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onChildrenChanged(i, str, i2, parcelImpl);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public void onConnected(int i, ParcelImpl parcelImpl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(12, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onConnected(i, parcelImpl);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public void onCurrentMediaItemChanged(int i, ParcelImpl parcelImpl, int i2, int i3, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    if (this.mRemote.transact(1, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onCurrentMediaItemChanged(i, parcelImpl, i2, i3, i4);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public void onCustomCommand(int i, ParcelImpl parcelImpl, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(16, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onCustomCommand(i, parcelImpl, bundle);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public void onDisconnected(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(13, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onDisconnected(i);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onLibraryResult(int i, ParcelImpl parcelImpl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(18, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onLibraryResult(i, parcelImpl);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public void onPlaybackCompleted(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(10, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onPlaybackCompleted(i);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onPlaybackInfoChanged(int i, ParcelImpl parcelImpl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(7, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onPlaybackInfoChanged(i, parcelImpl);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public void onPlaybackSpeedChanged(int i, long j, long j2, float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeFloat(f);
                    if (this.mRemote.transact(3, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onPlaybackSpeedChanged(i, j, j2, f);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onPlayerStateChanged(int i, long j, long j2, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(2, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onPlayerStateChanged(i, j, j2, i2);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onPlaylistChanged(int i, ParcelImplListSlice parcelImplListSlice, ParcelImpl parcelImpl, int i2, int i3, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (parcelImplListSlice != null) {
                        obtain.writeInt(1);
                        parcelImplListSlice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    if (this.mRemote.transact(5, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onPlaylistChanged(i, parcelImplListSlice, parcelImpl, i2, i3, i4);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public void onPlaylistMetadataChanged(int i, ParcelImpl parcelImpl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(6, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onPlaylistMetadataChanged(i, parcelImpl);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public void onRepeatModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    if (this.mRemote.transact(8, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onRepeatModeChanged(i, i2, i3, i4, i5);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onSearchResultChanged(int i, String str, int i2, ParcelImpl parcelImpl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(20, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onSearchResultChanged(i, str, i2, parcelImpl);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public void onSeekCompleted(int i, long j, long j2, long j3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    int i2 = i;
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeLong(j3);
                    try {
                        if (this.mRemote.transact(11, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                            obtain.recycle();
                            return;
                        }
                        Stub.getDefaultImpl().onSeekCompleted(i, j, j2, j3);
                        obtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obtain.recycle();
                    throw th;
                }
            }

            public void onSessionResult(int i, ParcelImpl parcelImpl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(17, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onSessionResult(i, parcelImpl);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public void onSetCustomLayout(int i, List<ParcelImpl> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeTypedList(list);
                    if (this.mRemote.transact(14, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onSetCustomLayout(i, list);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onShuffleModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    if (this.mRemote.transact(9, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onShuffleModeChanged(i, i2, i3, i4, i5);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onSubtitleData(int i, ParcelImpl parcelImpl, ParcelImpl parcelImpl2, ParcelImpl parcelImpl3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (parcelImpl2 != null) {
                        obtain.writeInt(1);
                        parcelImpl2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (parcelImpl3 != null) {
                        obtain.writeInt(1);
                        parcelImpl3.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(25, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onSubtitleData(i, parcelImpl, parcelImpl2, parcelImpl3);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public void onTrackDeselected(int i, ParcelImpl parcelImpl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(24, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onTrackDeselected(i, parcelImpl);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public void onTrackInfoChanged(int i, List<ParcelImpl> list, ParcelImpl parcelImpl, ParcelImpl parcelImpl2, ParcelImpl parcelImpl3, ParcelImpl parcelImpl4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeTypedList(list);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (parcelImpl2 != null) {
                        obtain.writeInt(1);
                        parcelImpl2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (parcelImpl3 != null) {
                        obtain.writeInt(1);
                        parcelImpl3.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (parcelImpl4 != null) {
                        obtain.writeInt(1);
                        parcelImpl4.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(22, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onTrackInfoChanged(i, list, parcelImpl, parcelImpl2, parcelImpl3, parcelImpl4);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public void onTrackSelected(int i, ParcelImpl parcelImpl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(23, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onTrackSelected(i, parcelImpl);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public void onVideoSizeChanged(int i, ParcelImpl parcelImpl, ParcelImpl parcelImpl2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (parcelImpl2 != null) {
                        obtain.writeInt(1);
                        parcelImpl2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(21, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onVideoSizeChanged(i, parcelImpl, parcelImpl2);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaController asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMediaController)) {
                return new Proxy(iBinder);
            }
            return (IMediaController) queryLocalInterface;
        }

        public static IMediaController getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMediaController iMediaController) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iMediaController == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iMediaController;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v34, resolved type: android.os.Bundle} */
        /* JADX WARNING: type inference failed for: r2v1 */
        /* JADX WARNING: type inference failed for: r2v2, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r2v3 */
        /* JADX WARNING: type inference failed for: r2v8, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r2v9 */
        /* JADX WARNING: type inference failed for: r2v11, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r2v15, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r2v25, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r2v30, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r2v38, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r2v42, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r2v46, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r2v50, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r2v54, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r2v59, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r2v63, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r2v67, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r2v71 */
        /* JADX WARNING: type inference failed for: r2v72 */
        /* JADX WARNING: type inference failed for: r2v73 */
        /* JADX WARNING: type inference failed for: r2v74 */
        /* JADX WARNING: type inference failed for: r2v75 */
        /* JADX WARNING: type inference failed for: r2v76 */
        /* JADX WARNING: type inference failed for: r2v77 */
        /* JADX WARNING: type inference failed for: r2v78 */
        /* JADX WARNING: type inference failed for: r2v79 */
        /* JADX WARNING: type inference failed for: r2v80 */
        /* JADX WARNING: type inference failed for: r2v81 */
        /* JADX WARNING: type inference failed for: r2v82 */
        /* JADX WARNING: type inference failed for: r2v83 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r15, android.os.Parcel r16, android.os.Parcel r17, int r18) throws android.os.RemoteException {
            /*
                r14 = this;
                r10 = r14
                r0 = r15
                r1 = r16
                r2 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r11 = 1
                java.lang.String r3 = "androidx.media2.session.IMediaController"
                if (r0 == r2) goto L_0x0360
                r2 = 0
                switch(r0) {
                    case 1: goto L_0x0335;
                    case 2: goto L_0x0319;
                    case 3: goto L_0x02fd;
                    case 4: goto L_0x02cd;
                    case 5: goto L_0x028d;
                    case 6: goto L_0x0273;
                    case 7: goto L_0x0259;
                    case 8: goto L_0x0238;
                    case 9: goto L_0x0217;
                    case 10: goto L_0x020c;
                    case 11: goto L_0x01f0;
                    case 12: goto L_0x01d6;
                    case 13: goto L_0x01cb;
                    case 14: goto L_0x01ba;
                    case 15: goto L_0x01a0;
                    case 16: goto L_0x0176;
                    case 17: goto L_0x015c;
                    case 18: goto L_0x0142;
                    case 19: goto L_0x0120;
                    case 20: goto L_0x00fe;
                    case 21: goto L_0x00d4;
                    case 22: goto L_0x0083;
                    case 23: goto L_0x0069;
                    case 24: goto L_0x004f;
                    case 25: goto L_0x0015;
                    default: goto L_0x0010;
                }
            L_0x0010:
                boolean r0 = super.onTransact(r15, r16, r17, r18)
                return r0
            L_0x0015:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                int r3 = r16.readInt()
                if (r3 == 0) goto L_0x002b
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r3 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r3 = r3.createFromParcel(r1)
                androidx.versionedparcelable.ParcelImpl r3 = (androidx.versionedparcelable.ParcelImpl) r3
                goto L_0x002c
            L_0x002b:
                r3 = r2
            L_0x002c:
                int r4 = r16.readInt()
                if (r4 == 0) goto L_0x003b
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r4 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r1)
                androidx.versionedparcelable.ParcelImpl r4 = (androidx.versionedparcelable.ParcelImpl) r4
                goto L_0x003c
            L_0x003b:
                r4 = r2
            L_0x003c:
                int r5 = r16.readInt()
                if (r5 == 0) goto L_0x004b
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r2 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r1 = r2.createFromParcel(r1)
                r2 = r1
                androidx.versionedparcelable.ParcelImpl r2 = (androidx.versionedparcelable.ParcelImpl) r2
            L_0x004b:
                r14.onSubtitleData(r0, r3, r4, r2)
                return r11
            L_0x004f:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                int r3 = r16.readInt()
                if (r3 == 0) goto L_0x0065
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r2 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r1 = r2.createFromParcel(r1)
                r2 = r1
                androidx.versionedparcelable.ParcelImpl r2 = (androidx.versionedparcelable.ParcelImpl) r2
            L_0x0065:
                r14.onTrackDeselected(r0, r2)
                return r11
            L_0x0069:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                int r3 = r16.readInt()
                if (r3 == 0) goto L_0x007f
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r2 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r1 = r2.createFromParcel(r1)
                r2 = r1
                androidx.versionedparcelable.ParcelImpl r2 = (androidx.versionedparcelable.ParcelImpl) r2
            L_0x007f:
                r14.onTrackSelected(r0, r2)
                return r11
            L_0x0083:
                r1.enforceInterface(r3)
                int r3 = r16.readInt()
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r0 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.util.ArrayList r4 = r1.createTypedArrayList(r0)
                int r5 = r16.readInt()
                if (r5 == 0) goto L_0x009d
                java.lang.Object r5 = r0.createFromParcel(r1)
                androidx.versionedparcelable.ParcelImpl r5 = (androidx.versionedparcelable.ParcelImpl) r5
                goto L_0x009e
            L_0x009d:
                r5 = r2
            L_0x009e:
                int r6 = r16.readInt()
                if (r6 == 0) goto L_0x00ab
                java.lang.Object r6 = r0.createFromParcel(r1)
                androidx.versionedparcelable.ParcelImpl r6 = (androidx.versionedparcelable.ParcelImpl) r6
                goto L_0x00ac
            L_0x00ab:
                r6 = r2
            L_0x00ac:
                int r7 = r16.readInt()
                if (r7 == 0) goto L_0x00b9
                java.lang.Object r7 = r0.createFromParcel(r1)
                androidx.versionedparcelable.ParcelImpl r7 = (androidx.versionedparcelable.ParcelImpl) r7
                goto L_0x00ba
            L_0x00b9:
                r7 = r2
            L_0x00ba:
                int r8 = r16.readInt()
                if (r8 == 0) goto L_0x00c8
                java.lang.Object r0 = r0.createFromParcel(r1)
                androidx.versionedparcelable.ParcelImpl r0 = (androidx.versionedparcelable.ParcelImpl) r0
                r8 = r0
                goto L_0x00c9
            L_0x00c8:
                r8 = r2
            L_0x00c9:
                r0 = r14
                r1 = r3
                r2 = r4
                r3 = r5
                r4 = r6
                r5 = r7
                r6 = r8
                r0.onTrackInfoChanged(r1, r2, r3, r4, r5, r6)
                return r11
            L_0x00d4:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                int r3 = r16.readInt()
                if (r3 == 0) goto L_0x00ea
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r3 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r3 = r3.createFromParcel(r1)
                androidx.versionedparcelable.ParcelImpl r3 = (androidx.versionedparcelable.ParcelImpl) r3
                goto L_0x00eb
            L_0x00ea:
                r3 = r2
            L_0x00eb:
                int r4 = r16.readInt()
                if (r4 == 0) goto L_0x00fa
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r2 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r1 = r2.createFromParcel(r1)
                r2 = r1
                androidx.versionedparcelable.ParcelImpl r2 = (androidx.versionedparcelable.ParcelImpl) r2
            L_0x00fa:
                r14.onVideoSizeChanged(r0, r3, r2)
                return r11
            L_0x00fe:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                java.lang.String r3 = r16.readString()
                int r4 = r16.readInt()
                int r5 = r16.readInt()
                if (r5 == 0) goto L_0x011c
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r2 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r1 = r2.createFromParcel(r1)
                r2 = r1
                androidx.versionedparcelable.ParcelImpl r2 = (androidx.versionedparcelable.ParcelImpl) r2
            L_0x011c:
                r14.onSearchResultChanged(r0, r3, r4, r2)
                return r11
            L_0x0120:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                java.lang.String r3 = r16.readString()
                int r4 = r16.readInt()
                int r5 = r16.readInt()
                if (r5 == 0) goto L_0x013e
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r2 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r1 = r2.createFromParcel(r1)
                r2 = r1
                androidx.versionedparcelable.ParcelImpl r2 = (androidx.versionedparcelable.ParcelImpl) r2
            L_0x013e:
                r14.onChildrenChanged(r0, r3, r4, r2)
                return r11
            L_0x0142:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                int r3 = r16.readInt()
                if (r3 == 0) goto L_0x0158
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r2 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r1 = r2.createFromParcel(r1)
                r2 = r1
                androidx.versionedparcelable.ParcelImpl r2 = (androidx.versionedparcelable.ParcelImpl) r2
            L_0x0158:
                r14.onLibraryResult(r0, r2)
                return r11
            L_0x015c:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                int r3 = r16.readInt()
                if (r3 == 0) goto L_0x0172
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r2 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r1 = r2.createFromParcel(r1)
                r2 = r1
                androidx.versionedparcelable.ParcelImpl r2 = (androidx.versionedparcelable.ParcelImpl) r2
            L_0x0172:
                r14.onSessionResult(r0, r2)
                return r11
            L_0x0176:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                int r3 = r16.readInt()
                if (r3 == 0) goto L_0x018c
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r3 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r3 = r3.createFromParcel(r1)
                androidx.versionedparcelable.ParcelImpl r3 = (androidx.versionedparcelable.ParcelImpl) r3
                goto L_0x018d
            L_0x018c:
                r3 = r2
            L_0x018d:
                int r4 = r16.readInt()
                if (r4 == 0) goto L_0x019c
                android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
                java.lang.Object r1 = r2.createFromParcel(r1)
                r2 = r1
                android.os.Bundle r2 = (android.os.Bundle) r2
            L_0x019c:
                r14.onCustomCommand(r0, r3, r2)
                return r11
            L_0x01a0:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                int r3 = r16.readInt()
                if (r3 == 0) goto L_0x01b6
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r2 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r1 = r2.createFromParcel(r1)
                r2 = r1
                androidx.versionedparcelable.ParcelImpl r2 = (androidx.versionedparcelable.ParcelImpl) r2
            L_0x01b6:
                r14.onAllowedCommandsChanged(r0, r2)
                return r11
            L_0x01ba:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r2 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.util.ArrayList r1 = r1.createTypedArrayList(r2)
                r14.onSetCustomLayout(r0, r1)
                return r11
            L_0x01cb:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                r14.onDisconnected(r0)
                return r11
            L_0x01d6:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                int r3 = r16.readInt()
                if (r3 == 0) goto L_0x01ec
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r2 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r1 = r2.createFromParcel(r1)
                r2 = r1
                androidx.versionedparcelable.ParcelImpl r2 = (androidx.versionedparcelable.ParcelImpl) r2
            L_0x01ec:
                r14.onConnected(r0, r2)
                return r11
            L_0x01f0:
                r1.enforceInterface(r3)
                int r2 = r16.readInt()
                long r3 = r16.readLong()
                long r5 = r16.readLong()
                long r7 = r16.readLong()
                r0 = r14
                r1 = r2
                r2 = r3
                r4 = r5
                r6 = r7
                r0.onSeekCompleted(r1, r2, r4, r6)
                return r11
            L_0x020c:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                r14.onPlaybackCompleted(r0)
                return r11
            L_0x0217:
                r1.enforceInterface(r3)
                int r2 = r16.readInt()
                int r3 = r16.readInt()
                int r4 = r16.readInt()
                int r5 = r16.readInt()
                int r6 = r16.readInt()
                r0 = r14
                r1 = r2
                r2 = r3
                r3 = r4
                r4 = r5
                r5 = r6
                r0.onShuffleModeChanged(r1, r2, r3, r4, r5)
                return r11
            L_0x0238:
                r1.enforceInterface(r3)
                int r2 = r16.readInt()
                int r3 = r16.readInt()
                int r4 = r16.readInt()
                int r5 = r16.readInt()
                int r6 = r16.readInt()
                r0 = r14
                r1 = r2
                r2 = r3
                r3 = r4
                r4 = r5
                r5 = r6
                r0.onRepeatModeChanged(r1, r2, r3, r4, r5)
                return r11
            L_0x0259:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                int r3 = r16.readInt()
                if (r3 == 0) goto L_0x026f
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r2 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r1 = r2.createFromParcel(r1)
                r2 = r1
                androidx.versionedparcelable.ParcelImpl r2 = (androidx.versionedparcelable.ParcelImpl) r2
            L_0x026f:
                r14.onPlaybackInfoChanged(r0, r2)
                return r11
            L_0x0273:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                int r3 = r16.readInt()
                if (r3 == 0) goto L_0x0289
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r2 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r1 = r2.createFromParcel(r1)
                r2 = r1
                androidx.versionedparcelable.ParcelImpl r2 = (androidx.versionedparcelable.ParcelImpl) r2
            L_0x0289:
                r14.onPlaylistMetadataChanged(r0, r2)
                return r11
            L_0x028d:
                r1.enforceInterface(r3)
                int r3 = r16.readInt()
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x02a4
                android.os.Parcelable$Creator<androidx.media2.common.ParcelImplListSlice> r0 = androidx.media2.common.ParcelImplListSlice.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r1)
                androidx.media2.common.ParcelImplListSlice r0 = (androidx.media2.common.ParcelImplListSlice) r0
                r4 = r0
                goto L_0x02a5
            L_0x02a4:
                r4 = r2
            L_0x02a5:
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x02b5
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r0 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r1)
                androidx.versionedparcelable.ParcelImpl r0 = (androidx.versionedparcelable.ParcelImpl) r0
                r5 = r0
                goto L_0x02b6
            L_0x02b5:
                r5 = r2
            L_0x02b6:
                int r6 = r16.readInt()
                int r7 = r16.readInt()
                int r8 = r16.readInt()
                r0 = r14
                r1 = r3
                r2 = r4
                r3 = r5
                r4 = r6
                r5 = r7
                r6 = r8
                r0.onPlaylistChanged(r1, r2, r3, r4, r5, r6)
                return r11
            L_0x02cd:
                r1.enforceInterface(r3)
                int r3 = r16.readInt()
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x02e3
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r0 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r1)
                androidx.versionedparcelable.ParcelImpl r0 = (androidx.versionedparcelable.ParcelImpl) r0
                r2 = r0
            L_0x02e3:
                int r4 = r16.readInt()
                long r5 = r16.readLong()
                long r7 = r16.readLong()
                long r12 = r16.readLong()
                r0 = r14
                r1 = r3
                r3 = r4
                r4 = r5
                r6 = r7
                r8 = r12
                r0.onBufferingStateChanged(r1, r2, r3, r4, r6, r8)
                return r11
            L_0x02fd:
                r1.enforceInterface(r3)
                int r2 = r16.readInt()
                long r3 = r16.readLong()
                long r5 = r16.readLong()
                float r7 = r16.readFloat()
                r0 = r14
                r1 = r2
                r2 = r3
                r4 = r5
                r6 = r7
                r0.onPlaybackSpeedChanged(r1, r2, r4, r6)
                return r11
            L_0x0319:
                r1.enforceInterface(r3)
                int r2 = r16.readInt()
                long r3 = r16.readLong()
                long r5 = r16.readLong()
                int r7 = r16.readInt()
                r0 = r14
                r1 = r2
                r2 = r3
                r4 = r5
                r6 = r7
                r0.onPlayerStateChanged(r1, r2, r4, r6)
                return r11
            L_0x0335:
                r1.enforceInterface(r3)
                int r3 = r16.readInt()
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x034b
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r0 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r1)
                androidx.versionedparcelable.ParcelImpl r0 = (androidx.versionedparcelable.ParcelImpl) r0
                r2 = r0
            L_0x034b:
                int r4 = r16.readInt()
                int r5 = r16.readInt()
                int r6 = r16.readInt()
                r0 = r14
                r1 = r3
                r3 = r4
                r4 = r5
                r5 = r6
                r0.onCurrentMediaItemChanged(r1, r2, r3, r4, r5)
                return r11
            L_0x0360:
                r0 = r17
                r0.writeString(r3)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.IMediaController.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void onAllowedCommandsChanged(int i, ParcelImpl parcelImpl) throws RemoteException;

    void onBufferingStateChanged(int i, ParcelImpl parcelImpl, int i2, long j, long j2, long j3) throws RemoteException;

    void onChildrenChanged(int i, String str, int i2, ParcelImpl parcelImpl) throws RemoteException;

    void onConnected(int i, ParcelImpl parcelImpl) throws RemoteException;

    void onCurrentMediaItemChanged(int i, ParcelImpl parcelImpl, int i2, int i3, int i4) throws RemoteException;

    void onCustomCommand(int i, ParcelImpl parcelImpl, Bundle bundle) throws RemoteException;

    void onDisconnected(int i) throws RemoteException;

    void onLibraryResult(int i, ParcelImpl parcelImpl) throws RemoteException;

    void onPlaybackCompleted(int i) throws RemoteException;

    void onPlaybackInfoChanged(int i, ParcelImpl parcelImpl) throws RemoteException;

    void onPlaybackSpeedChanged(int i, long j, long j2, float f) throws RemoteException;

    void onPlayerStateChanged(int i, long j, long j2, int i2) throws RemoteException;

    void onPlaylistChanged(int i, ParcelImplListSlice parcelImplListSlice, ParcelImpl parcelImpl, int i2, int i3, int i4) throws RemoteException;

    void onPlaylistMetadataChanged(int i, ParcelImpl parcelImpl) throws RemoteException;

    void onRepeatModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException;

    void onSearchResultChanged(int i, String str, int i2, ParcelImpl parcelImpl) throws RemoteException;

    void onSeekCompleted(int i, long j, long j2, long j3) throws RemoteException;

    void onSessionResult(int i, ParcelImpl parcelImpl) throws RemoteException;

    void onSetCustomLayout(int i, List<ParcelImpl> list) throws RemoteException;

    void onShuffleModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException;

    void onSubtitleData(int i, ParcelImpl parcelImpl, ParcelImpl parcelImpl2, ParcelImpl parcelImpl3) throws RemoteException;

    void onTrackDeselected(int i, ParcelImpl parcelImpl) throws RemoteException;

    void onTrackInfoChanged(int i, List<ParcelImpl> list, ParcelImpl parcelImpl, ParcelImpl parcelImpl2, ParcelImpl parcelImpl3, ParcelImpl parcelImpl4) throws RemoteException;

    void onTrackSelected(int i, ParcelImpl parcelImpl) throws RemoteException;

    void onVideoSizeChanged(int i, ParcelImpl parcelImpl, ParcelImpl parcelImpl2) throws RemoteException;
}
