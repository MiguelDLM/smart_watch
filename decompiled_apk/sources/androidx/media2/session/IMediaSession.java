package androidx.media2.session;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;
import androidx.media2.session.IMediaController;
import androidx.versionedparcelable.ParcelImpl;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public interface IMediaSession extends IInterface {

    /* loaded from: classes.dex */
    public static class Default implements IMediaSession {
        @Override // androidx.media2.session.IMediaSession
        public void addPlaylistItem(IMediaController iMediaController, int i, int i2, String str) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void adjustVolume(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.media2.session.IMediaSession
        public void connect(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void deselectTrack(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void fastForward(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void getChildren(IMediaController iMediaController, int i, String str, int i2, int i3, ParcelImpl parcelImpl) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void getItem(IMediaController iMediaController, int i, String str) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void getLibraryRoot(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void getSearchResult(IMediaController iMediaController, int i, String str, int i2, int i3, ParcelImpl parcelImpl) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void movePlaylistItem(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void onControllerResult(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void onCustomCommand(IMediaController iMediaController, int i, ParcelImpl parcelImpl, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void pause(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void play(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void prepare(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void release(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void removePlaylistItem(IMediaController iMediaController, int i, int i2) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void replacePlaylistItem(IMediaController iMediaController, int i, int i2, String str) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void rewind(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void search(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void seekTo(IMediaController iMediaController, int i, long j) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void selectTrack(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void setMediaItem(IMediaController iMediaController, int i, String str) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void setMediaUri(IMediaController iMediaController, int i, Uri uri, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void setPlaybackSpeed(IMediaController iMediaController, int i, float f) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void setPlaylist(IMediaController iMediaController, int i, List<String> list, ParcelImpl parcelImpl) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void setRating(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void setRepeatMode(IMediaController iMediaController, int i, int i2) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void setShuffleMode(IMediaController iMediaController, int i, int i2) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void setSurface(IMediaController iMediaController, int i, Surface surface) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void setVolumeTo(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void skipBackward(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void skipForward(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void skipToNextItem(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void skipToPlaylistItem(IMediaController iMediaController, int i, int i2) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void skipToPreviousItem(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void subscribe(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void unsubscribe(IMediaController iMediaController, int i, String str) throws RemoteException {
        }

        @Override // androidx.media2.session.IMediaSession
        public void updatePlaylistMetadata(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IMediaSession {
        private static final String DESCRIPTOR = "androidx.media2.session.IMediaSession";
        static final int TRANSACTION_addPlaylistItem = 25;
        static final int TRANSACTION_adjustVolume = 4;
        static final int TRANSACTION_connect = 1;
        static final int TRANSACTION_deselectTrack = 43;
        static final int TRANSACTION_fastForward = 8;
        static final int TRANSACTION_getChildren = 36;
        static final int TRANSACTION_getItem = 35;
        static final int TRANSACTION_getLibraryRoot = 34;
        static final int TRANSACTION_getSearchResult = 38;
        static final int TRANSACTION_movePlaylistItem = 44;
        static final int TRANSACTION_onControllerResult = 33;
        static final int TRANSACTION_onCustomCommand = 13;
        static final int TRANSACTION_pause = 6;
        static final int TRANSACTION_play = 5;
        static final int TRANSACTION_prepare = 7;
        static final int TRANSACTION_release = 2;
        static final int TRANSACTION_removePlaylistItem = 26;
        static final int TRANSACTION_replacePlaylistItem = 27;
        static final int TRANSACTION_rewind = 9;
        static final int TRANSACTION_search = 37;
        static final int TRANSACTION_seekTo = 12;
        static final int TRANSACTION_selectTrack = 42;
        static final int TRANSACTION_setMediaItem = 23;
        static final int TRANSACTION_setMediaUri = 45;
        static final int TRANSACTION_setPlaybackSpeed = 21;
        static final int TRANSACTION_setPlaylist = 22;
        static final int TRANSACTION_setRating = 20;
        static final int TRANSACTION_setRepeatMode = 31;
        static final int TRANSACTION_setShuffleMode = 32;
        static final int TRANSACTION_setSurface = 41;
        static final int TRANSACTION_setVolumeTo = 3;
        static final int TRANSACTION_skipBackward = 11;
        static final int TRANSACTION_skipForward = 10;
        static final int TRANSACTION_skipToNextItem = 30;
        static final int TRANSACTION_skipToPlaylistItem = 28;
        static final int TRANSACTION_skipToPreviousItem = 29;
        static final int TRANSACTION_subscribe = 39;
        static final int TRANSACTION_unsubscribe = 40;
        static final int TRANSACTION_updatePlaylistMetadata = 24;

        /* loaded from: classes.dex */
        public static class Proxy implements IMediaSession {
            public static IMediaSession sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // androidx.media2.session.IMediaSession
            public void addPlaylistItem(IMediaController iMediaController, int i, int i2, String str) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(25, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().addPlaylistItem(iMediaController, i, i2, str);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void adjustVolume(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (!this.mRemote.transact(4, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().adjustVolume(iMediaController, i, i2, i3);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // androidx.media2.session.IMediaSession
            public void connect(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().connect(iMediaController, i, parcelImpl);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void deselectTrack(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(43, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().deselectTrack(iMediaController, i, parcelImpl);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void fastForward(IMediaController iMediaController, int i) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(8, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().fastForward(iMediaController, i);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void getChildren(IMediaController iMediaController, int i, String str, int i2, int i3, ParcelImpl parcelImpl) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(36, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().getChildren(iMediaController, i, str, i2, i3, parcelImpl);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // androidx.media2.session.IMediaSession
            public void getItem(IMediaController iMediaController, int i, String str) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(35, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().getItem(iMediaController, i, str);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void getLibraryRoot(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(34, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().getLibraryRoot(iMediaController, i, parcelImpl);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void getSearchResult(IMediaController iMediaController, int i, String str, int i2, int i3, ParcelImpl parcelImpl) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(38, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().getSearchResult(iMediaController, i, str, i2, i3, parcelImpl);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void movePlaylistItem(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (!this.mRemote.transact(44, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().movePlaylistItem(iMediaController, i, i2, i3);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void onControllerResult(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(33, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onControllerResult(iMediaController, i, parcelImpl);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void onCustomCommand(IMediaController iMediaController, int i, ParcelImpl parcelImpl, Bundle bundle) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
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
                    if (!this.mRemote.transact(13, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onCustomCommand(iMediaController, i, parcelImpl, bundle);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void pause(IMediaController iMediaController, int i) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(6, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().pause(iMediaController, i);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void play(IMediaController iMediaController, int i) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(5, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().play(iMediaController, i);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void prepare(IMediaController iMediaController, int i) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(7, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().prepare(iMediaController, i);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void release(IMediaController iMediaController, int i) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(2, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().release(iMediaController, i);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void removePlaylistItem(IMediaController iMediaController, int i, int i2) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(26, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().removePlaylistItem(iMediaController, i, i2);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void replacePlaylistItem(IMediaController iMediaController, int i, int i2, String str) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(27, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().replacePlaylistItem(iMediaController, i, i2, str);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void rewind(IMediaController iMediaController, int i) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(9, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().rewind(iMediaController, i);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void search(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(37, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().search(iMediaController, i, str, parcelImpl);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void seekTo(IMediaController iMediaController, int i, long j) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (!this.mRemote.transact(12, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().seekTo(iMediaController, i, j);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void selectTrack(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(42, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().selectTrack(iMediaController, i, parcelImpl);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setMediaItem(IMediaController iMediaController, int i, String str) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(23, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setMediaItem(iMediaController, i, str);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setMediaUri(IMediaController iMediaController, int i, Uri uri, Bundle bundle) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(45, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setMediaUri(iMediaController, i, uri, bundle);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setPlaybackSpeed(IMediaController iMediaController, int i, float f) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeFloat(f);
                    if (!this.mRemote.transact(21, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setPlaybackSpeed(iMediaController, i, f);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setPlaylist(IMediaController iMediaController, int i, List<String> list, ParcelImpl parcelImpl) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeStringList(list);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(22, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setPlaylist(iMediaController, i, list, parcelImpl);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setRating(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(20, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setRating(iMediaController, i, str, parcelImpl);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setRepeatMode(IMediaController iMediaController, int i, int i2) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(31, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setRepeatMode(iMediaController, i, i2);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setShuffleMode(IMediaController iMediaController, int i, int i2) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(32, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setShuffleMode(iMediaController, i, i2);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setSurface(IMediaController iMediaController, int i, Surface surface) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    if (surface != null) {
                        obtain.writeInt(1);
                        surface.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(41, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setSurface(iMediaController, i, surface);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setVolumeTo(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (!this.mRemote.transact(3, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setVolumeTo(iMediaController, i, i2, i3);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void skipBackward(IMediaController iMediaController, int i) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(11, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().skipBackward(iMediaController, i);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void skipForward(IMediaController iMediaController, int i) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(10, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().skipForward(iMediaController, i);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void skipToNextItem(IMediaController iMediaController, int i) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(30, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().skipToNextItem(iMediaController, i);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void skipToPlaylistItem(IMediaController iMediaController, int i, int i2) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(28, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().skipToPlaylistItem(iMediaController, i, i2);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void skipToPreviousItem(IMediaController iMediaController, int i) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(29, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().skipToPreviousItem(iMediaController, i);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void subscribe(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(39, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().subscribe(iMediaController, i, str, parcelImpl);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void unsubscribe(IMediaController iMediaController, int i, String str) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(40, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unsubscribe(iMediaController, i, str);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void updatePlaylistMetadata(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMediaController != null) {
                        iBinder = iMediaController.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    if (parcelImpl != null) {
                        obtain.writeInt(1);
                        parcelImpl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(24, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().updatePlaylistMetadata(iMediaController, i, parcelImpl);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaSession asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IMediaSession)) {
                return (IMediaSession) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IMediaSession getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMediaSession iMediaSession) {
            if (Proxy.sDefaultImpl == null) {
                if (iMediaSession != null) {
                    Proxy.sDefaultImpl = iMediaSession;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            ParcelImpl parcelImpl;
            Uri uri;
            if (i != 1598968902) {
                ParcelImpl parcelImpl2 = null;
                Bundle bundle = null;
                ParcelImpl parcelImpl3 = null;
                ParcelImpl parcelImpl4 = null;
                Surface surface = null;
                ParcelImpl parcelImpl5 = null;
                ParcelImpl parcelImpl6 = null;
                ParcelImpl parcelImpl7 = null;
                ParcelImpl parcelImpl8 = null;
                ParcelImpl parcelImpl9 = null;
                ParcelImpl parcelImpl10 = null;
                ParcelImpl parcelImpl11 = null;
                ParcelImpl parcelImpl12 = null;
                ParcelImpl parcelImpl13 = null;
                Bundle bundle2 = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        IMediaController asInterface = IMediaController.Stub.asInterface(parcel.readStrongBinder());
                        int readInt = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            parcelImpl2 = ParcelImpl.CREATOR.createFromParcel(parcel);
                        }
                        connect(asInterface, readInt, parcelImpl2);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        release(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        setVolumeTo(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt());
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        adjustVolume(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt());
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        play(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        pause(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        prepare(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        fastForward(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        rewind(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        skipForward(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        skipBackward(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        seekTo(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readLong());
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        IMediaController asInterface2 = IMediaController.Stub.asInterface(parcel.readStrongBinder());
                        int readInt2 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            parcelImpl = ParcelImpl.CREATOR.createFromParcel(parcel);
                        } else {
                            parcelImpl = null;
                        }
                        if (parcel.readInt() != 0) {
                            bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        onCustomCommand(asInterface2, readInt2, parcelImpl, bundle2);
                        return true;
                    default:
                        switch (i) {
                            case 20:
                                parcel.enforceInterface(DESCRIPTOR);
                                IMediaController asInterface3 = IMediaController.Stub.asInterface(parcel.readStrongBinder());
                                int readInt3 = parcel.readInt();
                                String readString = parcel.readString();
                                if (parcel.readInt() != 0) {
                                    parcelImpl13 = ParcelImpl.CREATOR.createFromParcel(parcel);
                                }
                                setRating(asInterface3, readInt3, readString, parcelImpl13);
                                return true;
                            case 21:
                                parcel.enforceInterface(DESCRIPTOR);
                                setPlaybackSpeed(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readFloat());
                                return true;
                            case 22:
                                parcel.enforceInterface(DESCRIPTOR);
                                IMediaController asInterface4 = IMediaController.Stub.asInterface(parcel.readStrongBinder());
                                int readInt4 = parcel.readInt();
                                ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                                if (parcel.readInt() != 0) {
                                    parcelImpl12 = ParcelImpl.CREATOR.createFromParcel(parcel);
                                }
                                setPlaylist(asInterface4, readInt4, createStringArrayList, parcelImpl12);
                                return true;
                            case 23:
                                parcel.enforceInterface(DESCRIPTOR);
                                setMediaItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                                return true;
                            case 24:
                                parcel.enforceInterface(DESCRIPTOR);
                                IMediaController asInterface5 = IMediaController.Stub.asInterface(parcel.readStrongBinder());
                                int readInt5 = parcel.readInt();
                                if (parcel.readInt() != 0) {
                                    parcelImpl11 = ParcelImpl.CREATOR.createFromParcel(parcel);
                                }
                                updatePlaylistMetadata(asInterface5, readInt5, parcelImpl11);
                                return true;
                            case 25:
                                parcel.enforceInterface(DESCRIPTOR);
                                addPlaylistItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readString());
                                return true;
                            case 26:
                                parcel.enforceInterface(DESCRIPTOR);
                                removePlaylistItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                                return true;
                            case 27:
                                parcel.enforceInterface(DESCRIPTOR);
                                replacePlaylistItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readString());
                                return true;
                            case 28:
                                parcel.enforceInterface(DESCRIPTOR);
                                skipToPlaylistItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                                return true;
                            case 29:
                                parcel.enforceInterface(DESCRIPTOR);
                                skipToPreviousItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                                return true;
                            case 30:
                                parcel.enforceInterface(DESCRIPTOR);
                                skipToNextItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                                return true;
                            case 31:
                                parcel.enforceInterface(DESCRIPTOR);
                                setRepeatMode(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                                return true;
                            case 32:
                                parcel.enforceInterface(DESCRIPTOR);
                                setShuffleMode(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                                return true;
                            case 33:
                                parcel.enforceInterface(DESCRIPTOR);
                                IMediaController asInterface6 = IMediaController.Stub.asInterface(parcel.readStrongBinder());
                                int readInt6 = parcel.readInt();
                                if (parcel.readInt() != 0) {
                                    parcelImpl10 = ParcelImpl.CREATOR.createFromParcel(parcel);
                                }
                                onControllerResult(asInterface6, readInt6, parcelImpl10);
                                return true;
                            case 34:
                                parcel.enforceInterface(DESCRIPTOR);
                                IMediaController asInterface7 = IMediaController.Stub.asInterface(parcel.readStrongBinder());
                                int readInt7 = parcel.readInt();
                                if (parcel.readInt() != 0) {
                                    parcelImpl9 = ParcelImpl.CREATOR.createFromParcel(parcel);
                                }
                                getLibraryRoot(asInterface7, readInt7, parcelImpl9);
                                return true;
                            case 35:
                                parcel.enforceInterface(DESCRIPTOR);
                                getItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                                return true;
                            case 36:
                                parcel.enforceInterface(DESCRIPTOR);
                                IMediaController asInterface8 = IMediaController.Stub.asInterface(parcel.readStrongBinder());
                                int readInt8 = parcel.readInt();
                                String readString2 = parcel.readString();
                                int readInt9 = parcel.readInt();
                                int readInt10 = parcel.readInt();
                                if (parcel.readInt() != 0) {
                                    parcelImpl8 = ParcelImpl.CREATOR.createFromParcel(parcel);
                                }
                                getChildren(asInterface8, readInt8, readString2, readInt9, readInt10, parcelImpl8);
                                return true;
                            case 37:
                                parcel.enforceInterface(DESCRIPTOR);
                                IMediaController asInterface9 = IMediaController.Stub.asInterface(parcel.readStrongBinder());
                                int readInt11 = parcel.readInt();
                                String readString3 = parcel.readString();
                                if (parcel.readInt() != 0) {
                                    parcelImpl7 = ParcelImpl.CREATOR.createFromParcel(parcel);
                                }
                                search(asInterface9, readInt11, readString3, parcelImpl7);
                                return true;
                            case 38:
                                parcel.enforceInterface(DESCRIPTOR);
                                IMediaController asInterface10 = IMediaController.Stub.asInterface(parcel.readStrongBinder());
                                int readInt12 = parcel.readInt();
                                String readString4 = parcel.readString();
                                int readInt13 = parcel.readInt();
                                int readInt14 = parcel.readInt();
                                if (parcel.readInt() != 0) {
                                    parcelImpl6 = ParcelImpl.CREATOR.createFromParcel(parcel);
                                }
                                getSearchResult(asInterface10, readInt12, readString4, readInt13, readInt14, parcelImpl6);
                                return true;
                            case 39:
                                parcel.enforceInterface(DESCRIPTOR);
                                IMediaController asInterface11 = IMediaController.Stub.asInterface(parcel.readStrongBinder());
                                int readInt15 = parcel.readInt();
                                String readString5 = parcel.readString();
                                if (parcel.readInt() != 0) {
                                    parcelImpl5 = ParcelImpl.CREATOR.createFromParcel(parcel);
                                }
                                subscribe(asInterface11, readInt15, readString5, parcelImpl5);
                                return true;
                            case 40:
                                parcel.enforceInterface(DESCRIPTOR);
                                unsubscribe(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                                return true;
                            case 41:
                                parcel.enforceInterface(DESCRIPTOR);
                                IMediaController asInterface12 = IMediaController.Stub.asInterface(parcel.readStrongBinder());
                                int readInt16 = parcel.readInt();
                                if (parcel.readInt() != 0) {
                                    surface = (Surface) Surface.CREATOR.createFromParcel(parcel);
                                }
                                setSurface(asInterface12, readInt16, surface);
                                return true;
                            case 42:
                                parcel.enforceInterface(DESCRIPTOR);
                                IMediaController asInterface13 = IMediaController.Stub.asInterface(parcel.readStrongBinder());
                                int readInt17 = parcel.readInt();
                                if (parcel.readInt() != 0) {
                                    parcelImpl4 = ParcelImpl.CREATOR.createFromParcel(parcel);
                                }
                                selectTrack(asInterface13, readInt17, parcelImpl4);
                                return true;
                            case 43:
                                parcel.enforceInterface(DESCRIPTOR);
                                IMediaController asInterface14 = IMediaController.Stub.asInterface(parcel.readStrongBinder());
                                int readInt18 = parcel.readInt();
                                if (parcel.readInt() != 0) {
                                    parcelImpl3 = ParcelImpl.CREATOR.createFromParcel(parcel);
                                }
                                deselectTrack(asInterface14, readInt18, parcelImpl3);
                                return true;
                            case 44:
                                parcel.enforceInterface(DESCRIPTOR);
                                movePlaylistItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt());
                                return true;
                            case 45:
                                parcel.enforceInterface(DESCRIPTOR);
                                IMediaController asInterface15 = IMediaController.Stub.asInterface(parcel.readStrongBinder());
                                int readInt19 = parcel.readInt();
                                if (parcel.readInt() != 0) {
                                    uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                                } else {
                                    uri = null;
                                }
                                if (parcel.readInt() != 0) {
                                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                                }
                                setMediaUri(asInterface15, readInt19, uri, bundle);
                                return true;
                            default:
                                return super.onTransact(i, parcel, parcel2, i2);
                        }
                }
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    void addPlaylistItem(IMediaController iMediaController, int i, int i2, String str) throws RemoteException;

    void adjustVolume(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException;

    void connect(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException;

    void deselectTrack(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException;

    void fastForward(IMediaController iMediaController, int i) throws RemoteException;

    void getChildren(IMediaController iMediaController, int i, String str, int i2, int i3, ParcelImpl parcelImpl) throws RemoteException;

    void getItem(IMediaController iMediaController, int i, String str) throws RemoteException;

    void getLibraryRoot(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException;

    void getSearchResult(IMediaController iMediaController, int i, String str, int i2, int i3, ParcelImpl parcelImpl) throws RemoteException;

    void movePlaylistItem(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException;

    void onControllerResult(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException;

    void onCustomCommand(IMediaController iMediaController, int i, ParcelImpl parcelImpl, Bundle bundle) throws RemoteException;

    void pause(IMediaController iMediaController, int i) throws RemoteException;

    void play(IMediaController iMediaController, int i) throws RemoteException;

    void prepare(IMediaController iMediaController, int i) throws RemoteException;

    void release(IMediaController iMediaController, int i) throws RemoteException;

    void removePlaylistItem(IMediaController iMediaController, int i, int i2) throws RemoteException;

    void replacePlaylistItem(IMediaController iMediaController, int i, int i2, String str) throws RemoteException;

    void rewind(IMediaController iMediaController, int i) throws RemoteException;

    void search(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) throws RemoteException;

    void seekTo(IMediaController iMediaController, int i, long j) throws RemoteException;

    void selectTrack(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException;

    void setMediaItem(IMediaController iMediaController, int i, String str) throws RemoteException;

    void setMediaUri(IMediaController iMediaController, int i, Uri uri, Bundle bundle) throws RemoteException;

    void setPlaybackSpeed(IMediaController iMediaController, int i, float f) throws RemoteException;

    void setPlaylist(IMediaController iMediaController, int i, List<String> list, ParcelImpl parcelImpl) throws RemoteException;

    void setRating(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) throws RemoteException;

    void setRepeatMode(IMediaController iMediaController, int i, int i2) throws RemoteException;

    void setShuffleMode(IMediaController iMediaController, int i, int i2) throws RemoteException;

    void setSurface(IMediaController iMediaController, int i, Surface surface) throws RemoteException;

    void setVolumeTo(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException;

    void skipBackward(IMediaController iMediaController, int i) throws RemoteException;

    void skipForward(IMediaController iMediaController, int i) throws RemoteException;

    void skipToNextItem(IMediaController iMediaController, int i) throws RemoteException;

    void skipToPlaylistItem(IMediaController iMediaController, int i, int i2) throws RemoteException;

    void skipToPreviousItem(IMediaController iMediaController, int i) throws RemoteException;

    void subscribe(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) throws RemoteException;

    void unsubscribe(IMediaController iMediaController, int i, String str) throws RemoteException;

    void updatePlaylistMetadata(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException;
}
