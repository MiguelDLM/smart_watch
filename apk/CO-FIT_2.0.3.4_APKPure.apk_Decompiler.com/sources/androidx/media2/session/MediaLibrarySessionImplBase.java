package androidx.media2.session;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.SessionPlayer;
import androidx.media2.session.MediaLibraryService;
import androidx.media2.session.MediaSession;
import androidx.media2.session.MediaSessionImplBase;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

class MediaLibrarySessionImplBase extends MediaSessionImplBase implements MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl {
    @GuardedBy("mLock")
    private final ArrayMap<MediaSession.ControllerCb, Set<String>> mSubscriptions = new ArrayMap<>();

    public MediaLibrarySessionImplBase(MediaSession mediaSession, Context context, String str, SessionPlayer sessionPlayer, PendingIntent pendingIntent, Executor executor, MediaSession.SessionCallback sessionCallback, Bundle bundle) {
        super(mediaSession, context, str, sessionPlayer, pendingIntent, executor, sessionCallback, bundle);
    }

    private LibraryResult ensureNonNullResult(LibraryResult libraryResult) {
        if (libraryResult != null) {
            return libraryResult;
        }
        throw new RuntimeException("LibraryResult shouldn't be null");
    }

    private LibraryResult ensureNonNullResultWithValidItem(LibraryResult libraryResult) {
        LibraryResult ensureNonNullResult = ensureNonNullResult(libraryResult);
        if (ensureNonNullResult.getResultCode() != 0 || isValidItem(ensureNonNullResult.getMediaItem())) {
            return ensureNonNullResult;
        }
        return new LibraryResult(-1);
    }

    private LibraryResult ensureNonNullResultWithValidList(LibraryResult libraryResult, int i) {
        LibraryResult ensureNonNullResult = ensureNonNullResult(libraryResult);
        if (ensureNonNullResult.getResultCode() == 0) {
            List<MediaItem> mediaItems = ensureNonNullResult.getMediaItems();
            if (mediaItems == null) {
                throw new RuntimeException("List shouldn't be null for the success");
            } else if (mediaItems.size() <= i) {
                for (MediaItem isValidItem : mediaItems) {
                    if (!isValidItem(isValidItem)) {
                        return new LibraryResult(-1);
                    }
                }
            } else {
                throw new RuntimeException("List shouldn't contain items more than pageSize, size=" + ensureNonNullResult.getMediaItems().size() + ", pageSize" + i);
            }
        }
        return ensureNonNullResult;
    }

    private boolean isValidItem(MediaItem mediaItem) {
        if (mediaItem == null) {
            throw new RuntimeException("Item shouldn't be null for the success");
        } else if (!TextUtils.isEmpty(mediaItem.getMediaId())) {
            MediaMetadata metadata = mediaItem.getMetadata();
            if (metadata == null) {
                throw new RuntimeException("Metadata of an item shouldn't be null for the success");
            } else if (!metadata.containsKey(MediaMetadata.METADATA_KEY_BROWSABLE)) {
                throw new RuntimeException("METADATA_KEY_BROWSABLE should be specified in metadata of an item");
            } else if (metadata.containsKey(MediaMetadata.METADATA_KEY_PLAYABLE)) {
                return true;
            } else {
                throw new RuntimeException("METADATA_KEY_PLAYABLE should be specified in metadata of an item");
            }
        } else {
            throw new RuntimeException("Media ID of an item shouldn't be empty for the success");
        }
    }

    public MediaBrowserServiceCompat createLegacyBrowserServiceLocked(Context context, SessionToken sessionToken, MediaSessionCompat.Token token) {
        return new MediaLibraryServiceLegacyStub(context, this, token);
    }

    public void dispatchRemoteControllerTaskWithoutReturn(@NonNull MediaSessionImplBase.RemoteControllerTask remoteControllerTask) {
        super.dispatchRemoteControllerTaskWithoutReturn(remoteControllerTask);
        MediaLibraryServiceLegacyStub legacyBrowserService = getLegacyBrowserService();
        if (legacyBrowserService != null) {
            try {
                remoteControllerTask.run(legacyBrowserService.getBrowserLegacyCbForBroadcast(), 0);
            } catch (RemoteException e) {
                Log.e("MSImplBase", "Exception in using media1 API", e);
            }
        }
    }

    public void dumpSubscription() {
        if (MediaSessionImplBase.DEBUG) {
            synchronized (this.mLock) {
                try {
                    Log.d("MSImplBase", "Dumping subscription, controller sz=" + this.mSubscriptions.size());
                    for (int i = 0; i < this.mSubscriptions.size(); i++) {
                        Log.d("MSImplBase", "  controller " + this.mSubscriptions.valueAt(i));
                        for (String str : this.mSubscriptions.valueAt(i)) {
                            Log.d("MSImplBase", "  - " + str);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @NonNull
    public List<MediaSession.ControllerInfo> getConnectedControllers() {
        List<MediaSession.ControllerInfo> connectedControllers = super.getConnectedControllers();
        MediaLibraryServiceLegacyStub legacyBrowserService = getLegacyBrowserService();
        if (legacyBrowserService != null) {
            connectedControllers.addAll(legacyBrowserService.getConnectedControllersManager().getConnectedControllers());
        }
        return connectedControllers;
    }

    public boolean isConnected(@NonNull MediaSession.ControllerInfo controllerInfo) {
        if (super.isConnected(controllerInfo)) {
            return true;
        }
        MediaLibraryServiceLegacyStub legacyBrowserService = getLegacyBrowserService();
        if (legacyBrowserService != null) {
            return legacyBrowserService.getConnectedControllersManager().isConnected(controllerInfo);
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isSubscribed(androidx.media2.session.MediaSession.ControllerCb r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.mLock
            monitor-enter(r0)
            androidx.collection.ArrayMap<androidx.media2.session.MediaSession$ControllerCb, java.util.Set<java.lang.String>> r1 = r2.mSubscriptions     // Catch:{ all -> 0x0017 }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x0017 }
            java.util.Set r3 = (java.util.Set) r3     // Catch:{ all -> 0x0017 }
            if (r3 == 0) goto L_0x0019
            boolean r3 = r3.contains(r4)     // Catch:{ all -> 0x0017 }
            if (r3 != 0) goto L_0x0014
            goto L_0x0019
        L_0x0014:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            r3 = 1
            return r3
        L_0x0017:
            r3 = move-exception
            goto L_0x001c
        L_0x0019:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            r3 = 0
            return r3
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.MediaLibrarySessionImplBase.isSubscribed(androidx.media2.session.MediaSession$ControllerCb, java.lang.String):boolean");
    }

    public void notifyChildrenChanged(@NonNull final String str, final int i, final MediaLibraryService.LibraryParams libraryParams) {
        dispatchRemoteControllerTaskWithoutReturn(new MediaSessionImplBase.RemoteControllerTask() {
            public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                if (MediaLibrarySessionImplBase.this.isSubscribed(controllerCb, str)) {
                    controllerCb.onChildrenChanged(i, str, i, libraryParams);
                }
            }
        });
    }

    public void notifySearchResultChanged(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull final String str, final int i, final MediaLibraryService.LibraryParams libraryParams) {
        dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new MediaSessionImplBase.RemoteControllerTask() {
            public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.onSearchResultChanged(i, str, i, libraryParams);
            }
        });
    }

    public LibraryResult onGetChildrenOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, int i, int i2, MediaLibraryService.LibraryParams libraryParams) {
        return ensureNonNullResultWithValidList(getCallback().onGetChildren(getInstance(), controllerInfo, str, i, i2, libraryParams), i2);
    }

    public LibraryResult onGetItemOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str) {
        return ensureNonNullResultWithValidItem(getCallback().onGetItem(getInstance(), controllerInfo, str));
    }

    public LibraryResult onGetLibraryRootOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, MediaLibraryService.LibraryParams libraryParams) {
        return ensureNonNullResultWithValidItem(getCallback().onGetLibraryRoot(getInstance(), controllerInfo, libraryParams));
    }

    public LibraryResult onGetSearchResultOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, int i, int i2, MediaLibraryService.LibraryParams libraryParams) {
        return ensureNonNullResultWithValidList(getCallback().onGetSearchResult(getInstance(), controllerInfo, str, i, i2, libraryParams), i2);
    }

    public int onSearchOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, MediaLibraryService.LibraryParams libraryParams) {
        return getCallback().onSearch(getInstance(), controllerInfo, str, libraryParams);
    }

    public int onSubscribeOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, MediaLibraryService.LibraryParams libraryParams) {
        synchronized (this.mLock) {
            try {
                Set set = this.mSubscriptions.get(controllerInfo.getControllerCb());
                if (set == null) {
                    set = new HashSet();
                    this.mSubscriptions.put(controllerInfo.getControllerCb(), set);
                }
                set.add(str);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        int onSubscribe = getCallback().onSubscribe(getInstance(), controllerInfo, str, libraryParams);
        if (onSubscribe != 0) {
            synchronized (this.mLock) {
                this.mSubscriptions.remove(controllerInfo.getControllerCb());
            }
        }
        return onSubscribe;
    }

    public int onUnsubscribeOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str) {
        int onUnsubscribe = getCallback().onUnsubscribe(getInstance(), controllerInfo, str);
        synchronized (this.mLock) {
            this.mSubscriptions.remove(controllerInfo.getControllerCb());
        }
        return onUnsubscribe;
    }

    public MediaLibraryService.MediaLibrarySession.MediaLibrarySessionCallback getCallback() {
        return (MediaLibraryService.MediaLibrarySession.MediaLibrarySessionCallback) super.getCallback();
    }

    @NonNull
    public MediaLibraryService.MediaLibrarySession getInstance() {
        return (MediaLibraryService.MediaLibrarySession) super.getInstance();
    }

    public MediaLibraryServiceLegacyStub getLegacyBrowserService() {
        return (MediaLibraryServiceLegacyStub) super.getLegacyBrowserService();
    }

    public void notifyChildrenChanged(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, int i, MediaLibraryService.LibraryParams libraryParams) {
        final String str2 = str;
        final MediaSession.ControllerInfo controllerInfo2 = controllerInfo;
        final int i2 = i;
        final MediaLibraryService.LibraryParams libraryParams2 = libraryParams;
        dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new MediaSessionImplBase.RemoteControllerTask() {
            public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                if (MediaLibrarySessionImplBase.this.isSubscribed(controllerCb, str2)) {
                    controllerCb.onChildrenChanged(i, str2, i2, libraryParams2);
                } else if (MediaSessionImplBase.DEBUG) {
                    Log.d("MSImplBase", "Skipping notifyChildrenChanged() to " + controllerInfo2 + " because it hasn't subscribed");
                    MediaLibrarySessionImplBase.this.dumpSubscription();
                }
            }
        });
    }
}
