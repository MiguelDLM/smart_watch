package androidx.media2.session;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;
import androidx.versionedparcelable.ParcelImpl;
import java.util.List;

public interface IMediaSession extends IInterface {

    public static class Default implements IMediaSession {
        public void addPlaylistItem(IMediaController iMediaController, int i, int i2, String str) throws RemoteException {
        }

        public void adjustVolume(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
        }

        public IBinder asBinder() {
            return null;
        }

        public void connect(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
        }

        public void deselectTrack(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
        }

        public void fastForward(IMediaController iMediaController, int i) throws RemoteException {
        }

        public void getChildren(IMediaController iMediaController, int i, String str, int i2, int i3, ParcelImpl parcelImpl) throws RemoteException {
        }

        public void getItem(IMediaController iMediaController, int i, String str) throws RemoteException {
        }

        public void getLibraryRoot(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
        }

        public void getSearchResult(IMediaController iMediaController, int i, String str, int i2, int i3, ParcelImpl parcelImpl) throws RemoteException {
        }

        public void movePlaylistItem(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
        }

        public void onControllerResult(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
        }

        public void onCustomCommand(IMediaController iMediaController, int i, ParcelImpl parcelImpl, Bundle bundle) throws RemoteException {
        }

        public void pause(IMediaController iMediaController, int i) throws RemoteException {
        }

        public void play(IMediaController iMediaController, int i) throws RemoteException {
        }

        public void prepare(IMediaController iMediaController, int i) throws RemoteException {
        }

        public void release(IMediaController iMediaController, int i) throws RemoteException {
        }

        public void removePlaylistItem(IMediaController iMediaController, int i, int i2) throws RemoteException {
        }

        public void replacePlaylistItem(IMediaController iMediaController, int i, int i2, String str) throws RemoteException {
        }

        public void rewind(IMediaController iMediaController, int i) throws RemoteException {
        }

        public void search(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) throws RemoteException {
        }

        public void seekTo(IMediaController iMediaController, int i, long j) throws RemoteException {
        }

        public void selectTrack(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
        }

        public void setMediaItem(IMediaController iMediaController, int i, String str) throws RemoteException {
        }

        public void setMediaUri(IMediaController iMediaController, int i, Uri uri, Bundle bundle) throws RemoteException {
        }

        public void setPlaybackSpeed(IMediaController iMediaController, int i, float f) throws RemoteException {
        }

        public void setPlaylist(IMediaController iMediaController, int i, List<String> list, ParcelImpl parcelImpl) throws RemoteException {
        }

        public void setRating(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) throws RemoteException {
        }

        public void setRepeatMode(IMediaController iMediaController, int i, int i2) throws RemoteException {
        }

        public void setShuffleMode(IMediaController iMediaController, int i, int i2) throws RemoteException {
        }

        public void setSurface(IMediaController iMediaController, int i, Surface surface) throws RemoteException {
        }

        public void setVolumeTo(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
        }

        public void skipBackward(IMediaController iMediaController, int i) throws RemoteException {
        }

        public void skipForward(IMediaController iMediaController, int i) throws RemoteException {
        }

        public void skipToNextItem(IMediaController iMediaController, int i) throws RemoteException {
        }

        public void skipToPlaylistItem(IMediaController iMediaController, int i, int i2) throws RemoteException {
        }

        public void skipToPreviousItem(IMediaController iMediaController, int i) throws RemoteException {
        }

        public void subscribe(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) throws RemoteException {
        }

        public void unsubscribe(IMediaController iMediaController, int i, String str) throws RemoteException {
        }

        public void updatePlaylistMetadata(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
        }
    }

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

        public static class Proxy implements IMediaSession {
            public static IMediaSession sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

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
                    if (this.mRemote.transact(25, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().addPlaylistItem(iMediaController, i, i2, str);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(4, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().adjustVolume(iMediaController, i, i2, i3);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

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
                    if (this.mRemote.transact(1, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().connect(iMediaController, i, parcelImpl);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(43, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().deselectTrack(iMediaController, i, parcelImpl);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(8, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().fastForward(iMediaController, i);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(36, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().getChildren(iMediaController, i, str, i2, i3, parcelImpl);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

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
                    if (this.mRemote.transact(35, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().getItem(iMediaController, i, str);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(34, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().getLibraryRoot(iMediaController, i, parcelImpl);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(38, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().getSearchResult(iMediaController, i, str, i2, i3, parcelImpl);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(44, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().movePlaylistItem(iMediaController, i, i2, i3);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(33, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onControllerResult(iMediaController, i, parcelImpl);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(13, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onCustomCommand(iMediaController, i, parcelImpl, bundle);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(6, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().pause(iMediaController, i);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(5, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().play(iMediaController, i);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(7, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().prepare(iMediaController, i);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(2, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().release(iMediaController, i);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(26, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().removePlaylistItem(iMediaController, i, i2);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(27, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().replacePlaylistItem(iMediaController, i, i2, str);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(9, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().rewind(iMediaController, i);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(37, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().search(iMediaController, i, str, parcelImpl);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(12, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().seekTo(iMediaController, i, j);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(42, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().selectTrack(iMediaController, i, parcelImpl);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(23, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().setMediaItem(iMediaController, i, str);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(45, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().setMediaUri(iMediaController, i, uri, bundle);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(21, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().setPlaybackSpeed(iMediaController, i, f);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(22, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().setPlaylist(iMediaController, i, list, parcelImpl);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(20, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().setRating(iMediaController, i, str, parcelImpl);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(31, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().setRepeatMode(iMediaController, i, i2);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(32, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().setShuffleMode(iMediaController, i, i2);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(41, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().setSurface(iMediaController, i, surface);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(3, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().setVolumeTo(iMediaController, i, i2, i3);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(11, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().skipBackward(iMediaController, i);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(10, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().skipForward(iMediaController, i);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(30, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().skipToNextItem(iMediaController, i);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(28, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().skipToPlaylistItem(iMediaController, i, i2);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(29, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().skipToPreviousItem(iMediaController, i);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(39, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().subscribe(iMediaController, i, str, parcelImpl);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(40, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().unsubscribe(iMediaController, i, str);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

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
                    if (this.mRemote.transact(24, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().updatePlaylistMetadata(iMediaController, i, parcelImpl);
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

        public static IMediaSession asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMediaSession)) {
                return new Proxy(iBinder);
            }
            return (IMediaSession) queryLocalInterface;
        }

        public static IMediaSession getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMediaSession iMediaSession) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iMediaSession == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iMediaSession;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v49, resolved type: android.os.Bundle} */
        /* JADX WARNING: type inference failed for: r0v1 */
        /* JADX WARNING: type inference failed for: r0v2, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r0v9, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r0v13, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r0v17, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r0v20, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r0v23, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r0v26 */
        /* JADX WARNING: type inference failed for: r0v29, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r0v33 */
        /* JADX WARNING: type inference failed for: r0v36, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r0v40, types: [android.view.Surface] */
        /* JADX WARNING: type inference failed for: r0v43, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r0v46, types: [androidx.versionedparcelable.ParcelImpl] */
        /* JADX WARNING: type inference failed for: r0v53 */
        /* JADX WARNING: type inference failed for: r0v54 */
        /* JADX WARNING: type inference failed for: r0v55 */
        /* JADX WARNING: type inference failed for: r0v56 */
        /* JADX WARNING: type inference failed for: r0v57 */
        /* JADX WARNING: type inference failed for: r0v58 */
        /* JADX WARNING: type inference failed for: r0v59 */
        /* JADX WARNING: type inference failed for: r0v60 */
        /* JADX WARNING: type inference failed for: r0v61 */
        /* JADX WARNING: type inference failed for: r0v62 */
        /* JADX WARNING: type inference failed for: r0v63 */
        /* JADX WARNING: type inference failed for: r0v64 */
        /* JADX WARNING: type inference failed for: r0v65 */
        /* JADX WARNING: type inference failed for: r0v66 */
        /* JADX WARNING: type inference failed for: r0v67 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r10, android.os.Parcel r11, android.os.Parcel r12, int r13) throws android.os.RemoteException {
            /*
                r9 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r1 = 1
                java.lang.String r2 = "androidx.media2.session.IMediaSession"
                if (r10 == r0) goto L_0x0472
                r0 = 0
                switch(r10) {
                    case 1: goto L_0x0450;
                    case 2: goto L_0x043d;
                    case 3: goto L_0x0422;
                    case 4: goto L_0x0407;
                    case 5: goto L_0x03f4;
                    case 6: goto L_0x03e1;
                    case 7: goto L_0x03ce;
                    case 8: goto L_0x03bb;
                    case 9: goto L_0x03a8;
                    case 10: goto L_0x0395;
                    case 11: goto L_0x0382;
                    case 12: goto L_0x036b;
                    case 13: goto L_0x0339;
                    default: goto L_0x000c;
                }
            L_0x000c:
                switch(r10) {
                    case 20: goto L_0x0313;
                    case 21: goto L_0x02fc;
                    case 22: goto L_0x02d6;
                    case 23: goto L_0x02bf;
                    case 24: goto L_0x029d;
                    case 25: goto L_0x0282;
                    case 26: goto L_0x026b;
                    case 27: goto L_0x0250;
                    case 28: goto L_0x0239;
                    case 29: goto L_0x0226;
                    case 30: goto L_0x0213;
                    case 31: goto L_0x01fc;
                    case 32: goto L_0x01e5;
                    case 33: goto L_0x01c3;
                    case 34: goto L_0x01a1;
                    case 35: goto L_0x018a;
                    case 36: goto L_0x015a;
                    case 37: goto L_0x0134;
                    case 38: goto L_0x0104;
                    case 39: goto L_0x00de;
                    case 40: goto L_0x00c7;
                    case 41: goto L_0x00a5;
                    case 42: goto L_0x0083;
                    case 43: goto L_0x0061;
                    case 44: goto L_0x0046;
                    case 45: goto L_0x0014;
                    default: goto L_0x000f;
                }
            L_0x000f:
                boolean r10 = super.onTransact(r10, r11, r12, r13)
                return r10
            L_0x0014:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                int r13 = r11.readInt()
                if (r13 == 0) goto L_0x0032
                android.os.Parcelable$Creator r13 = android.net.Uri.CREATOR
                java.lang.Object r13 = r13.createFromParcel(r11)
                android.net.Uri r13 = (android.net.Uri) r13
                goto L_0x0033
            L_0x0032:
                r13 = r0
            L_0x0033:
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x0042
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r11 = r0.createFromParcel(r11)
                r0 = r11
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0042:
                r9.setMediaUri(r10, r12, r13, r0)
                return r1
            L_0x0046:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                int r13 = r11.readInt()
                int r11 = r11.readInt()
                r9.movePlaylistItem(r10, r12, r13, r11)
                return r1
            L_0x0061:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                int r13 = r11.readInt()
                if (r13 == 0) goto L_0x007f
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r13 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r11 = r13.createFromParcel(r11)
                r0 = r11
                androidx.versionedparcelable.ParcelImpl r0 = (androidx.versionedparcelable.ParcelImpl) r0
            L_0x007f:
                r9.deselectTrack(r10, r12, r0)
                return r1
            L_0x0083:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                int r13 = r11.readInt()
                if (r13 == 0) goto L_0x00a1
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r13 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r11 = r13.createFromParcel(r11)
                r0 = r11
                androidx.versionedparcelable.ParcelImpl r0 = (androidx.versionedparcelable.ParcelImpl) r0
            L_0x00a1:
                r9.selectTrack(r10, r12, r0)
                return r1
            L_0x00a5:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                int r13 = r11.readInt()
                if (r13 == 0) goto L_0x00c3
                android.os.Parcelable$Creator r13 = android.view.Surface.CREATOR
                java.lang.Object r11 = r13.createFromParcel(r11)
                r0 = r11
                android.view.Surface r0 = (android.view.Surface) r0
            L_0x00c3:
                r9.setSurface(r10, r12, r0)
                return r1
            L_0x00c7:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                java.lang.String r11 = r11.readString()
                r9.unsubscribe(r10, r12, r11)
                return r1
            L_0x00de:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                java.lang.String r13 = r11.readString()
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x0100
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r0 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r11 = r0.createFromParcel(r11)
                r0 = r11
                androidx.versionedparcelable.ParcelImpl r0 = (androidx.versionedparcelable.ParcelImpl) r0
            L_0x0100:
                r9.subscribe(r10, r12, r13, r0)
                return r1
            L_0x0104:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r3 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r4 = r11.readInt()
                java.lang.String r5 = r11.readString()
                int r6 = r11.readInt()
                int r7 = r11.readInt()
                int r10 = r11.readInt()
                if (r10 == 0) goto L_0x012e
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r10 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r10 = r10.createFromParcel(r11)
                r0 = r10
                androidx.versionedparcelable.ParcelImpl r0 = (androidx.versionedparcelable.ParcelImpl) r0
            L_0x012e:
                r8 = r0
                r2 = r9
                r2.getSearchResult(r3, r4, r5, r6, r7, r8)
                return r1
            L_0x0134:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                java.lang.String r13 = r11.readString()
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x0156
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r0 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r11 = r0.createFromParcel(r11)
                r0 = r11
                androidx.versionedparcelable.ParcelImpl r0 = (androidx.versionedparcelable.ParcelImpl) r0
            L_0x0156:
                r9.search(r10, r12, r13, r0)
                return r1
            L_0x015a:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r3 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r4 = r11.readInt()
                java.lang.String r5 = r11.readString()
                int r6 = r11.readInt()
                int r7 = r11.readInt()
                int r10 = r11.readInt()
                if (r10 == 0) goto L_0x0184
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r10 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r10 = r10.createFromParcel(r11)
                r0 = r10
                androidx.versionedparcelable.ParcelImpl r0 = (androidx.versionedparcelable.ParcelImpl) r0
            L_0x0184:
                r8 = r0
                r2 = r9
                r2.getChildren(r3, r4, r5, r6, r7, r8)
                return r1
            L_0x018a:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                java.lang.String r11 = r11.readString()
                r9.getItem(r10, r12, r11)
                return r1
            L_0x01a1:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                int r13 = r11.readInt()
                if (r13 == 0) goto L_0x01bf
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r13 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r11 = r13.createFromParcel(r11)
                r0 = r11
                androidx.versionedparcelable.ParcelImpl r0 = (androidx.versionedparcelable.ParcelImpl) r0
            L_0x01bf:
                r9.getLibraryRoot(r10, r12, r0)
                return r1
            L_0x01c3:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                int r13 = r11.readInt()
                if (r13 == 0) goto L_0x01e1
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r13 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r11 = r13.createFromParcel(r11)
                r0 = r11
                androidx.versionedparcelable.ParcelImpl r0 = (androidx.versionedparcelable.ParcelImpl) r0
            L_0x01e1:
                r9.onControllerResult(r10, r12, r0)
                return r1
            L_0x01e5:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                int r11 = r11.readInt()
                r9.setShuffleMode(r10, r12, r11)
                return r1
            L_0x01fc:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                int r11 = r11.readInt()
                r9.setRepeatMode(r10, r12, r11)
                return r1
            L_0x0213:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r11 = r11.readInt()
                r9.skipToNextItem(r10, r11)
                return r1
            L_0x0226:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r11 = r11.readInt()
                r9.skipToPreviousItem(r10, r11)
                return r1
            L_0x0239:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                int r11 = r11.readInt()
                r9.skipToPlaylistItem(r10, r12, r11)
                return r1
            L_0x0250:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                int r13 = r11.readInt()
                java.lang.String r11 = r11.readString()
                r9.replacePlaylistItem(r10, r12, r13, r11)
                return r1
            L_0x026b:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                int r11 = r11.readInt()
                r9.removePlaylistItem(r10, r12, r11)
                return r1
            L_0x0282:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                int r13 = r11.readInt()
                java.lang.String r11 = r11.readString()
                r9.addPlaylistItem(r10, r12, r13, r11)
                return r1
            L_0x029d:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                int r13 = r11.readInt()
                if (r13 == 0) goto L_0x02bb
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r13 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r11 = r13.createFromParcel(r11)
                r0 = r11
                androidx.versionedparcelable.ParcelImpl r0 = (androidx.versionedparcelable.ParcelImpl) r0
            L_0x02bb:
                r9.updatePlaylistMetadata(r10, r12, r0)
                return r1
            L_0x02bf:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                java.lang.String r11 = r11.readString()
                r9.setMediaItem(r10, r12, r11)
                return r1
            L_0x02d6:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                java.util.ArrayList r13 = r11.createStringArrayList()
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x02f8
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r0 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r11 = r0.createFromParcel(r11)
                r0 = r11
                androidx.versionedparcelable.ParcelImpl r0 = (androidx.versionedparcelable.ParcelImpl) r0
            L_0x02f8:
                r9.setPlaylist(r10, r12, r13, r0)
                return r1
            L_0x02fc:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                float r11 = r11.readFloat()
                r9.setPlaybackSpeed(r10, r12, r11)
                return r1
            L_0x0313:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                java.lang.String r13 = r11.readString()
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x0335
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r0 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r11 = r0.createFromParcel(r11)
                r0 = r11
                androidx.versionedparcelable.ParcelImpl r0 = (androidx.versionedparcelable.ParcelImpl) r0
            L_0x0335:
                r9.setRating(r10, r12, r13, r0)
                return r1
            L_0x0339:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                int r13 = r11.readInt()
                if (r13 == 0) goto L_0x0357
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r13 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r13 = r13.createFromParcel(r11)
                androidx.versionedparcelable.ParcelImpl r13 = (androidx.versionedparcelable.ParcelImpl) r13
                goto L_0x0358
            L_0x0357:
                r13 = r0
            L_0x0358:
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x0367
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r11 = r0.createFromParcel(r11)
                r0 = r11
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0367:
                r9.onCustomCommand(r10, r12, r13, r0)
                return r1
            L_0x036b:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                long r2 = r11.readLong()
                r9.seekTo(r10, r12, r2)
                return r1
            L_0x0382:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r11 = r11.readInt()
                r9.skipBackward(r10, r11)
                return r1
            L_0x0395:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r11 = r11.readInt()
                r9.skipForward(r10, r11)
                return r1
            L_0x03a8:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r11 = r11.readInt()
                r9.rewind(r10, r11)
                return r1
            L_0x03bb:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r11 = r11.readInt()
                r9.fastForward(r10, r11)
                return r1
            L_0x03ce:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r11 = r11.readInt()
                r9.prepare(r10, r11)
                return r1
            L_0x03e1:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r11 = r11.readInt()
                r9.pause(r10, r11)
                return r1
            L_0x03f4:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r11 = r11.readInt()
                r9.play(r10, r11)
                return r1
            L_0x0407:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                int r13 = r11.readInt()
                int r11 = r11.readInt()
                r9.adjustVolume(r10, r12, r13, r11)
                return r1
            L_0x0422:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                int r13 = r11.readInt()
                int r11 = r11.readInt()
                r9.setVolumeTo(r10, r12, r13, r11)
                return r1
            L_0x043d:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r11 = r11.readInt()
                r9.release(r10, r11)
                return r1
            L_0x0450:
                r11.enforceInterface(r2)
                android.os.IBinder r10 = r11.readStrongBinder()
                androidx.media2.session.IMediaController r10 = androidx.media2.session.IMediaController.Stub.asInterface(r10)
                int r12 = r11.readInt()
                int r13 = r11.readInt()
                if (r13 == 0) goto L_0x046e
                android.os.Parcelable$Creator<androidx.versionedparcelable.ParcelImpl> r13 = androidx.versionedparcelable.ParcelImpl.CREATOR
                java.lang.Object r11 = r13.createFromParcel(r11)
                r0 = r11
                androidx.versionedparcelable.ParcelImpl r0 = (androidx.versionedparcelable.ParcelImpl) r0
            L_0x046e:
                r9.connect(r10, r12, r0)
                return r1
            L_0x0472:
                r12.writeString(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.IMediaSession.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
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
