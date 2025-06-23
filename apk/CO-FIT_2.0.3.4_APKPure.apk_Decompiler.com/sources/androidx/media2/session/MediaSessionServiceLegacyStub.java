package androidx.media2.session;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaSessionManager;
import androidx.media2.session.MediaSession;
import java.util.List;

class MediaSessionServiceLegacyStub extends MediaBrowserServiceCompat {
    private final ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> mConnectedControllersManager;
    final MediaSessionManager mManager;
    private final MediaSession.MediaSessionImpl mSessionImpl;

    public MediaSessionServiceLegacyStub(Context context, MediaSession.MediaSessionImpl mediaSessionImpl, MediaSessionCompat.Token token) {
        attachToBaseContext(context);
        onCreate();
        setSessionToken(token);
        this.mManager = MediaSessionManager.getSessionManager(context);
        this.mSessionImpl = mediaSessionImpl;
        this.mConnectedControllersManager = new ConnectedControllersManager<>(mediaSessionImpl);
    }

    public MediaSession.ControllerInfo createControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        return new MediaSession.ControllerInfo(remoteUserInfo, -1, this.mManager.isTrustedForMediaControl(remoteUserInfo), (MediaSession.ControllerCb) null, (Bundle) null);
    }

    public ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> getConnectedControllersManager() {
        return this.mConnectedControllersManager;
    }

    public MediaBrowserServiceCompat.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
        MediaSessionManager.RemoteUserInfo currentBrowserInfo = getCurrentBrowserInfo();
        MediaSession.ControllerInfo createControllerInfo = createControllerInfo(currentBrowserInfo);
        SessionCommandGroup onConnect = this.mSessionImpl.getCallback().onConnect(this.mSessionImpl.getInstance(), createControllerInfo);
        if (onConnect == null) {
            return null;
        }
        this.mConnectedControllersManager.addController(currentBrowserInfo, createControllerInfo, onConnect);
        return MediaUtils.sDefaultBrowserRoot;
    }

    public void onLoadChildren(String str, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
        result.sendResult(null);
    }
}
