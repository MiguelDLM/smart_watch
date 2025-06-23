package androidx.media2.session;

import android.content.Context;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaSessionManager;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaLibraryService;
import androidx.media2.session.MediaSession;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MediaLibraryServiceLegacyStub extends MediaSessionServiceLegacyStub {
    private static final boolean DEBUG = false;
    private static final String TAG = "MLS2LegacyStub";
    private final MediaSession.ControllerCb mBrowserLegacyCbForBroadcast;
    final MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl mLibrarySessionImpl;

    /* loaded from: classes.dex */
    public static abstract class BaseBrowserLegacyCb extends MediaSession.ControllerCb {
        private BaseBrowserLegacyCb() {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onAllowedCommandsChanged(int i, @NonNull SessionCommandGroup sessionCommandGroup) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onBufferingStateChanged(int i, @NonNull MediaItem mediaItem, int i2, long j, long j2, long j3) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onCurrentMediaItemChanged(int i, MediaItem mediaItem, int i2, int i3, int i4) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onDisconnected(int i) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onLibraryResult(int i, LibraryResult libraryResult) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onPlaybackCompleted(int i) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onPlaybackInfoChanged(int i, @NonNull MediaController.PlaybackInfo playbackInfo) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onPlaybackSpeedChanged(int i, long j, long j2, float f) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlayerResult(int i, SessionPlayer.PlayerResult playerResult) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onPlayerStateChanged(int i, long j, long j2, int i2) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onPlaylistChanged(int i, @NonNull List<MediaItem> list, MediaMetadata mediaMetadata, int i2, int i3, int i4) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onPlaylistMetadataChanged(int i, MediaMetadata mediaMetadata) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onRepeatModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onSeekCompleted(int i, long j, long j2, long j3) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSessionResult(int i, SessionResult sessionResult) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onShuffleModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onSubtitleData(int i, @NonNull MediaItem mediaItem, @NonNull SessionPlayer.TrackInfo trackInfo, @NonNull SubtitleData subtitleData) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onTrackDeselected(int i, SessionPlayer.TrackInfo trackInfo) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onTrackSelected(int i, SessionPlayer.TrackInfo trackInfo) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTracksChanged(int i, List<SessionPlayer.TrackInfo> list, SessionPlayer.TrackInfo trackInfo, SessionPlayer.TrackInfo trackInfo2, SessionPlayer.TrackInfo trackInfo3, SessionPlayer.TrackInfo trackInfo4) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onVideoSizeChanged(int i, @NonNull VideoSize videoSize) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void sendCustomCommand(int i, @NonNull SessionCommand sessionCommand, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void setCustomLayout(int i, @NonNull List<MediaSession.CommandButton> list) throws RemoteException {
        }
    }

    /* loaded from: classes.dex */
    public final class BrowserLegacyCb extends BaseBrowserLegacyCb {
        private final Object mLock;
        private final MediaSessionManager.RemoteUserInfo mRemoteUserInfo;

        @GuardedBy("mLock")
        private final List<SearchRequest> mSearchRequests;

        public BrowserLegacyCb(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            super();
            this.mLock = new Object();
            this.mSearchRequests = new ArrayList();
            this.mRemoteUserInfo = remoteUserInfo;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BrowserLegacyCb)) {
                return false;
            }
            return ObjectsCompat.equals(this.mRemoteUserInfo, ((BrowserLegacyCb) obj).mRemoteUserInfo);
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.mRemoteUserInfo);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onChildrenChanged(int i, @NonNull String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
            Bundle bundle;
            if (libraryParams != null) {
                bundle = libraryParams.getExtras();
            } else {
                bundle = null;
            }
            MediaLibraryServiceLegacyStub.this.notifyChildrenChanged(this.mRemoteUserInfo, str, bundle);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSearchResultChanged(int i, @NonNull String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
            final ArrayList arrayList = new ArrayList();
            synchronized (this.mLock) {
                try {
                    for (int size = this.mSearchRequests.size() - 1; size >= 0; size--) {
                        SearchRequest searchRequest = this.mSearchRequests.get(size);
                        if (ObjectsCompat.equals(this.mRemoteUserInfo, searchRequest.mRemoteUserInfo) && searchRequest.mQuery.equals(str)) {
                            arrayList.add(searchRequest);
                            this.mSearchRequests.remove(size);
                        }
                    }
                    if (arrayList.size() == 0) {
                        return;
                    }
                    MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getCallbackExecutor().execute(new Runnable() { // from class: androidx.media2.session.MediaLibraryServiceLegacyStub.BrowserLegacyCb.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int i3;
                            int i4;
                            int i5;
                            int i6;
                            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                                SearchRequest searchRequest2 = (SearchRequest) arrayList.get(i7);
                                Bundle bundle = searchRequest2.mExtras;
                                if (bundle != null) {
                                    try {
                                        bundle.setClassLoader(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getContext().getClassLoader());
                                        i3 = searchRequest2.mExtras.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
                                        i4 = searchRequest2.mExtras.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
                                    } catch (BadParcelableException unused) {
                                        searchRequest2.mResult.sendResult(null);
                                        return;
                                    }
                                } else {
                                    i3 = 0;
                                    i4 = Integer.MAX_VALUE;
                                }
                                if (i3 >= 0 && i4 >= 1) {
                                    i5 = i3;
                                    i6 = i4;
                                } else {
                                    i5 = 0;
                                    i6 = Integer.MAX_VALUE;
                                }
                                LibraryResult onGetSearchResult = MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getCallback().onGetSearchResult(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getInstance(), searchRequest2.mController, searchRequest2.mQuery, i5, i6, MediaUtils.convertToLibraryParams(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getContext(), searchRequest2.mExtras));
                                if (onGetSearchResult != null && onGetSearchResult.getResultCode() == 0) {
                                    searchRequest2.mResult.sendResult(MediaUtils.truncateListBySize(MediaUtils.convertToMediaItemList(onGetSearchResult.getMediaItems()), 262144));
                                } else {
                                    searchRequest2.mResult.sendResult(null);
                                }
                            }
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void registerSearchRequest(MediaSession.ControllerInfo controllerInfo, String str, Bundle bundle, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
            synchronized (this.mLock) {
                this.mSearchRequests.add(new SearchRequest(controllerInfo, controllerInfo.getRemoteUserInfo(), str, bundle, result));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class BrowserLegacyCbForBroadcast extends BaseBrowserLegacyCb {
        private final MediaBrowserServiceCompat mService;

        public BrowserLegacyCbForBroadcast(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            super();
            this.mService = mediaBrowserServiceCompat;
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onChildrenChanged(int i, @NonNull String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
            if (libraryParams != null && libraryParams.getExtras() != null) {
                this.mService.notifyChildrenChanged(str, libraryParams.getExtras());
            } else {
                this.mService.notifyChildrenChanged(str);
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSearchResultChanged(int i, @NonNull String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
        }
    }

    /* loaded from: classes.dex */
    public static class SearchRequest {
        public final MediaSession.ControllerInfo mController;
        public final Bundle mExtras;
        public final String mQuery;
        public final MediaSessionManager.RemoteUserInfo mRemoteUserInfo;
        public final MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> mResult;

        public SearchRequest(MediaSession.ControllerInfo controllerInfo, MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
            this.mController = controllerInfo;
            this.mRemoteUserInfo = remoteUserInfo;
            this.mQuery = str;
            this.mExtras = bundle;
            this.mResult = result;
        }
    }

    public MediaLibraryServiceLegacyStub(Context context, MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSessionCompat.Token token) {
        super(context, mediaLibrarySessionImpl, token);
        this.mLibrarySessionImpl = mediaLibrarySessionImpl;
        this.mBrowserLegacyCbForBroadcast = new BrowserLegacyCbForBroadcast(this);
    }

    private MediaSession.ControllerInfo getCurrentController() {
        return getConnectedControllersManager().getController(getCurrentBrowserInfo());
    }

    @Override // androidx.media2.session.MediaSessionServiceLegacyStub
    public MediaSession.ControllerInfo createControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        return new MediaSession.ControllerInfo(remoteUserInfo, -1, this.mManager.isTrustedForMediaControl(remoteUserInfo), new BrowserLegacyCb(remoteUserInfo), null);
    }

    public MediaSession.ControllerCb getBrowserLegacyCbForBroadcast() {
        return this.mBrowserLegacyCbForBroadcast;
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onCustomAction(final String str, final Bundle bundle, final MediaBrowserServiceCompat.Result<Bundle> result) {
        if (result != null) {
            result.detach();
        }
        final MediaSession.ControllerInfo currentController = getCurrentController();
        this.mLibrarySessionImpl.getCallbackExecutor().execute(new Runnable() { // from class: androidx.media2.session.MediaLibraryServiceLegacyStub.6
            @Override // java.lang.Runnable
            public void run() {
                SessionCommand sessionCommand = new SessionCommand(str, null);
                if (!MediaLibraryServiceLegacyStub.this.getConnectedControllersManager().isAllowedCommand(currentController, sessionCommand)) {
                    MediaBrowserServiceCompat.Result result2 = result;
                    if (result2 != null) {
                        result2.sendError(null);
                        return;
                    }
                    return;
                }
                SessionResult onCustomCommand = MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getCallback().onCustomCommand(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getInstance(), currentController, sessionCommand, bundle);
                if (onCustomCommand != null) {
                    result.sendResult(onCustomCommand.getCustomCommandResult());
                }
            }
        });
    }

    @Override // androidx.media2.session.MediaSessionServiceLegacyStub, androidx.media.MediaBrowserServiceCompat
    public MediaBrowserServiceCompat.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
        MediaSession.ControllerInfo currentController;
        String str2;
        if (super.onGetRoot(str, i, bundle) == null || (currentController = getCurrentController()) == null) {
            return null;
        }
        if (getConnectedControllersManager().isAllowedCommand(currentController, 50000)) {
            LibraryResult onGetLibraryRoot = this.mLibrarySessionImpl.getCallback().onGetLibraryRoot(this.mLibrarySessionImpl.getInstance(), currentController, MediaUtils.convertToLibraryParams(this.mLibrarySessionImpl.getContext(), bundle));
            if (onGetLibraryRoot != null && onGetLibraryRoot.getResultCode() == 0 && onGetLibraryRoot.getMediaItem() != null) {
                MediaMetadata metadata = onGetLibraryRoot.getMediaItem().getMetadata();
                if (metadata != null) {
                    str2 = metadata.getString("android.media.metadata.MEDIA_ID");
                } else {
                    str2 = "";
                }
                return new MediaBrowserServiceCompat.BrowserRoot(str2, MediaUtils.convertToRootHints(onGetLibraryRoot.getLibraryParams()));
            }
        }
        return MediaUtils.sDefaultBrowserRoot;
    }

    @Override // androidx.media2.session.MediaSessionServiceLegacyStub, androidx.media.MediaBrowserServiceCompat
    public void onLoadChildren(String str, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
        onLoadChildren(str, result, null);
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onLoadItem(final String str, final MediaBrowserServiceCompat.Result<MediaBrowserCompat.MediaItem> result) {
        final MediaSession.ControllerInfo currentController = getCurrentController();
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "Ignoring empty itemId from " + currentController);
            result.sendError(null);
            return;
        }
        result.detach();
        this.mLibrarySessionImpl.getCallbackExecutor().execute(new Runnable() { // from class: androidx.media2.session.MediaLibraryServiceLegacyStub.4
            @Override // java.lang.Runnable
            public void run() {
                if (!MediaLibraryServiceLegacyStub.this.getConnectedControllersManager().isAllowedCommand(currentController, SessionCommand.COMMAND_CODE_LIBRARY_GET_ITEM)) {
                    result.sendError(null);
                    return;
                }
                LibraryResult onGetItem = MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getCallback().onGetItem(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getInstance(), currentController, str);
                if (onGetItem != null && onGetItem.getResultCode() == 0) {
                    result.sendResult(MediaUtils.convertToMediaItem(onGetItem.getMediaItem()));
                } else {
                    result.sendResult(null);
                }
            }
        });
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onSearch(final String str, final Bundle bundle, final MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
        final MediaSession.ControllerInfo currentController = getCurrentController();
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "Ignoring empty query from " + currentController);
            result.sendError(null);
            return;
        }
        if (!(currentController.getControllerCb() instanceof BrowserLegacyCb)) {
            return;
        }
        result.detach();
        this.mLibrarySessionImpl.getCallbackExecutor().execute(new Runnable() { // from class: androidx.media2.session.MediaLibraryServiceLegacyStub.5
            @Override // java.lang.Runnable
            public void run() {
                if (!MediaLibraryServiceLegacyStub.this.getConnectedControllersManager().isAllowedCommand(currentController, 50005)) {
                    result.sendError(null);
                    return;
                }
                ((BrowserLegacyCb) currentController.getControllerCb()).registerSearchRequest(currentController, str, bundle, result);
                MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getCallback().onSearch(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getInstance(), currentController, str, MediaUtils.convertToLibraryParams(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getContext(), bundle));
            }
        });
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onSubscribe(final String str, final Bundle bundle) {
        final MediaSession.ControllerInfo currentController = getCurrentController();
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "onSubscribe(): Ignoring empty id from " + currentController);
            return;
        }
        this.mLibrarySessionImpl.getCallbackExecutor().execute(new Runnable() { // from class: androidx.media2.session.MediaLibraryServiceLegacyStub.1
            @Override // java.lang.Runnable
            public void run() {
                if (!MediaLibraryServiceLegacyStub.this.getConnectedControllersManager().isAllowedCommand(currentController, 50001)) {
                    return;
                }
                MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getCallback().onSubscribe(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getInstance(), currentController, str, MediaUtils.convertToLibraryParams(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getContext(), bundle));
            }
        });
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onUnsubscribe(final String str) {
        final MediaSession.ControllerInfo currentController = getCurrentController();
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "onUnsubscribe(): Ignoring empty id from " + currentController);
            return;
        }
        this.mLibrarySessionImpl.getCallbackExecutor().execute(new Runnable() { // from class: androidx.media2.session.MediaLibraryServiceLegacyStub.2
            @Override // java.lang.Runnable
            public void run() {
                if (!MediaLibraryServiceLegacyStub.this.getConnectedControllersManager().isAllowedCommand(currentController, 50002)) {
                    return;
                }
                MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getCallback().onUnsubscribe(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getInstance(), currentController, str);
            }
        });
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onLoadChildren(final String str, final MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result, final Bundle bundle) {
        final MediaSession.ControllerInfo currentController = getCurrentController();
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "onLoadChildren(): Ignoring empty parentId from " + currentController);
            result.sendError(null);
            return;
        }
        result.detach();
        this.mLibrarySessionImpl.getCallbackExecutor().execute(new Runnable() { // from class: androidx.media2.session.MediaLibraryServiceLegacyStub.3
            @Override // java.lang.Runnable
            public void run() {
                if (!MediaLibraryServiceLegacyStub.this.getConnectedControllersManager().isAllowedCommand(currentController, 50003)) {
                    result.sendError(null);
                    return;
                }
                Bundle bundle2 = bundle;
                if (bundle2 != null) {
                    bundle2.setClassLoader(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getContext().getClassLoader());
                    try {
                        int i = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE);
                        int i2 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE);
                        if (i > 0 && i2 > 0) {
                            LibraryResult onGetChildren = MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getCallback().onGetChildren(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getInstance(), currentController, str, i, i2, MediaUtils.convertToLibraryParams(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getContext(), bundle));
                            if (onGetChildren != null && onGetChildren.getResultCode() == 0) {
                                result.sendResult(MediaUtils.truncateListBySize(MediaUtils.convertToMediaItemList(onGetChildren.getMediaItems()), 262144));
                                return;
                            }
                            result.sendResult(null);
                            return;
                        }
                    } catch (BadParcelableException unused) {
                    }
                }
                LibraryResult onGetChildren2 = MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getCallback().onGetChildren(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getInstance(), currentController, str, 0, Integer.MAX_VALUE, null);
                if (onGetChildren2 != null && onGetChildren2.getResultCode() == 0) {
                    result.sendResult(MediaUtils.truncateListBySize(MediaUtils.convertToMediaItemList(onGetChildren2.getMediaItems()), 262144));
                } else {
                    result.sendResult(null);
                }
            }
        });
    }
}
