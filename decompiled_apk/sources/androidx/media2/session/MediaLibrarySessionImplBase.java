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
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class MediaLibrarySessionImplBase extends MediaSessionImplBase implements MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl {

    @GuardedBy("mLock")
    private final ArrayMap<MediaSession.ControllerCb, Set<String>> mSubscriptions;

    public MediaLibrarySessionImplBase(MediaSession mediaSession, Context context, String str, SessionPlayer sessionPlayer, PendingIntent pendingIntent, Executor executor, MediaSession.SessionCallback sessionCallback, Bundle bundle) {
        super(mediaSession, context, str, sessionPlayer, pendingIntent, executor, sessionCallback, bundle);
        this.mSubscriptions = new ArrayMap<>();
    }

    private LibraryResult ensureNonNullResult(LibraryResult libraryResult) {
        if (libraryResult != null) {
            return libraryResult;
        }
        throw new RuntimeException("LibraryResult shouldn't be null");
    }

    private LibraryResult ensureNonNullResultWithValidItem(LibraryResult libraryResult) {
        LibraryResult ensureNonNullResult = ensureNonNullResult(libraryResult);
        if (ensureNonNullResult.getResultCode() == 0 && !isValidItem(ensureNonNullResult.getMediaItem())) {
            return new LibraryResult(-1);
        }
        return ensureNonNullResult;
    }

    private LibraryResult ensureNonNullResultWithValidList(LibraryResult libraryResult, int i) {
        LibraryResult ensureNonNullResult = ensureNonNullResult(libraryResult);
        if (ensureNonNullResult.getResultCode() == 0) {
            List<MediaItem> mediaItems = ensureNonNullResult.getMediaItems();
            if (mediaItems != null) {
                if (mediaItems.size() <= i) {
                    Iterator<MediaItem> it = mediaItems.iterator();
                    while (it.hasNext()) {
                        if (!isValidItem(it.next())) {
                            return new LibraryResult(-1);
                        }
                    }
                } else {
                    throw new RuntimeException("List shouldn't contain items more than pageSize, size=" + ensureNonNullResult.getMediaItems().size() + ", pageSize" + i);
                }
            } else {
                throw new RuntimeException("List shouldn't be null for the success");
            }
        }
        return ensureNonNullResult;
    }

    private boolean isValidItem(MediaItem mediaItem) {
        if (mediaItem != null) {
            if (!TextUtils.isEmpty(mediaItem.getMediaId())) {
                MediaMetadata metadata = mediaItem.getMetadata();
                if (metadata != null) {
                    if (metadata.containsKey(MediaMetadata.METADATA_KEY_BROWSABLE)) {
                        if (metadata.containsKey(MediaMetadata.METADATA_KEY_PLAYABLE)) {
                            return true;
                        }
                        throw new RuntimeException("METADATA_KEY_PLAYABLE should be specified in metadata of an item");
                    }
                    throw new RuntimeException("METADATA_KEY_BROWSABLE should be specified in metadata of an item");
                }
                throw new RuntimeException("Metadata of an item shouldn't be null for the success");
            }
            throw new RuntimeException("Media ID of an item shouldn't be empty for the success");
        }
        throw new RuntimeException("Item shouldn't be null for the success");
    }

    @Override // androidx.media2.session.MediaSessionImplBase
    public MediaBrowserServiceCompat createLegacyBrowserServiceLocked(Context context, SessionToken sessionToken, MediaSessionCompat.Token token) {
        return new MediaLibraryServiceLegacyStub(context, this, token);
    }

    @Override // androidx.media2.session.MediaSessionImplBase
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
        if (!MediaSessionImplBase.DEBUG) {
            return;
        }
        synchronized (this.mLock) {
            try {
                Log.d("MSImplBase", "Dumping subscription, controller sz=" + this.mSubscriptions.size());
                for (int i = 0; i < this.mSubscriptions.size(); i++) {
                    Log.d("MSImplBase", "  controller " + this.mSubscriptions.valueAt(i));
                    Iterator<String> it = this.mSubscriptions.valueAt(i).iterator();
                    while (it.hasNext()) {
                        Log.d("MSImplBase", "  - " + it.next());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media2.session.MediaSessionImplBase, androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public List<MediaSession.ControllerInfo> getConnectedControllers() {
        List<MediaSession.ControllerInfo> connectedControllers = super.getConnectedControllers();
        MediaLibraryServiceLegacyStub legacyBrowserService = getLegacyBrowserService();
        if (legacyBrowserService != null) {
            connectedControllers.addAll(legacyBrowserService.getConnectedControllersManager().getConnectedControllers());
        }
        return connectedControllers;
    }

    @Override // androidx.media2.session.MediaSessionImplBase, androidx.media2.session.MediaSession.MediaSessionImpl
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

    public boolean isSubscribed(MediaSession.ControllerCb controllerCb, String str) {
        synchronized (this.mLock) {
            try {
                Set<String> set = this.mSubscriptions.get(controllerCb);
                if (set != null && set.contains(str)) {
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public void notifyChildrenChanged(@NonNull final String str, final int i, final MediaLibraryService.LibraryParams libraryParams) {
        dispatchRemoteControllerTaskWithoutReturn(new MediaSessionImplBase.RemoteControllerTask() { // from class: androidx.media2.session.MediaLibrarySessionImplBase.1
            @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
            public void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                if (MediaLibrarySessionImplBase.this.isSubscribed(controllerCb, str)) {
                    controllerCb.onChildrenChanged(i2, str, i, libraryParams);
                }
            }
        });
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public void notifySearchResultChanged(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull final String str, final int i, final MediaLibraryService.LibraryParams libraryParams) {
        dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new MediaSessionImplBase.RemoteControllerTask() { // from class: androidx.media2.session.MediaLibrarySessionImplBase.3
            @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
            public void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                controllerCb.onSearchResultChanged(i2, str, i, libraryParams);
            }
        });
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public LibraryResult onGetChildrenOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, int i, int i2, MediaLibraryService.LibraryParams libraryParams) {
        return ensureNonNullResultWithValidList(getCallback().onGetChildren(getInstance(), controllerInfo, str, i, i2, libraryParams), i2);
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public LibraryResult onGetItemOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str) {
        return ensureNonNullResultWithValidItem(getCallback().onGetItem(getInstance(), controllerInfo, str));
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public LibraryResult onGetLibraryRootOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, MediaLibraryService.LibraryParams libraryParams) {
        return ensureNonNullResultWithValidItem(getCallback().onGetLibraryRoot(getInstance(), controllerInfo, libraryParams));
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public LibraryResult onGetSearchResultOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, int i, int i2, MediaLibraryService.LibraryParams libraryParams) {
        return ensureNonNullResultWithValidList(getCallback().onGetSearchResult(getInstance(), controllerInfo, str, i, i2, libraryParams), i2);
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public int onSearchOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, MediaLibraryService.LibraryParams libraryParams) {
        return getCallback().onSearch(getInstance(), controllerInfo, str, libraryParams);
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public int onSubscribeOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, MediaLibraryService.LibraryParams libraryParams) {
        synchronized (this.mLock) {
            try {
                Set<String> set = this.mSubscriptions.get(controllerInfo.getControllerCb());
                if (set == null) {
                    set = new HashSet<>();
                    this.mSubscriptions.put(controllerInfo.getControllerCb(), set);
                }
                set.add(str);
            } finally {
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

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public int onUnsubscribeOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str) {
        int onUnsubscribe = getCallback().onUnsubscribe(getInstance(), controllerInfo, str);
        synchronized (this.mLock) {
            this.mSubscriptions.remove(controllerInfo.getControllerCb());
        }
        return onUnsubscribe;
    }

    @Override // androidx.media2.session.MediaSessionImplBase, androidx.media2.session.MediaSession.MediaSessionImpl
    public MediaLibraryService.MediaLibrarySession.MediaLibrarySessionCallback getCallback() {
        return (MediaLibraryService.MediaLibrarySession.MediaLibrarySessionCallback) super.getCallback();
    }

    @Override // androidx.media2.session.MediaSessionImplBase, androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public MediaLibraryService.MediaLibrarySession getInstance() {
        return (MediaLibraryService.MediaLibrarySession) super.getInstance();
    }

    @Override // androidx.media2.session.MediaSessionImplBase
    public MediaLibraryServiceLegacyStub getLegacyBrowserService() {
        return (MediaLibraryServiceLegacyStub) super.getLegacyBrowserService();
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public void notifyChildrenChanged(@NonNull final MediaSession.ControllerInfo controllerInfo, @NonNull final String str, final int i, final MediaLibraryService.LibraryParams libraryParams) {
        dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new MediaSessionImplBase.RemoteControllerTask() { // from class: androidx.media2.session.MediaLibrarySessionImplBase.2
            @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
            public void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                if (!MediaLibrarySessionImplBase.this.isSubscribed(controllerCb, str)) {
                    if (MediaSessionImplBase.DEBUG) {
                        Log.d("MSImplBase", "Skipping notifyChildrenChanged() to " + controllerInfo + " because it hasn't subscribed");
                        MediaLibrarySessionImplBase.this.dumpSubscription();
                        return;
                    }
                    return;
                }
                controllerCb.onChildrenChanged(i2, str, i, libraryParams);
            }
        });
    }
}
