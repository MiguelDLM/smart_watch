package androidx.media2.session;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media2.session.MediaSession;
import java.util.List;

public abstract class MediaSessionService extends Service {
    public static final String SERVICE_INTERFACE = "androidx.media2.session.MediaSessionService";
    private final MediaSessionServiceImpl mImpl = createImpl();

    public static class MediaNotification {
        private final Notification mNotification;
        private final int mNotificationId;

        public MediaNotification(int i, @NonNull Notification notification) {
            if (notification != null) {
                this.mNotificationId = i;
                this.mNotification = notification;
                return;
            }
            throw new NullPointerException("notification shouldn't be null");
        }

        @NonNull
        public Notification getNotification() {
            return this.mNotification;
        }

        public int getNotificationId() {
            return this.mNotificationId;
        }
    }

    public interface MediaSessionServiceImpl {
        void addSession(MediaSession mediaSession);

        List<MediaSession> getSessions();

        IBinder onBind(Intent intent);

        void onCreate(MediaSessionService mediaSessionService);

        void onDestroy();

        int onStartCommand(Intent intent, int i, int i2);

        MediaNotification onUpdateNotification(MediaSession mediaSession);

        void removeSession(MediaSession mediaSession);
    }

    public final void addSession(@NonNull MediaSession mediaSession) {
        if (mediaSession == null) {
            throw new NullPointerException("session shouldn't be null");
        } else if (!mediaSession.isClosed()) {
            this.mImpl.addSession(mediaSession);
        } else {
            throw new IllegalArgumentException("session is already closed");
        }
    }

    public MediaSessionServiceImpl createImpl() {
        return new MediaSessionServiceImplBase();
    }

    @NonNull
    public final List<MediaSession> getSessions() {
        return this.mImpl.getSessions();
    }

    @CallSuper
    @Nullable
    public IBinder onBind(@NonNull Intent intent) {
        return this.mImpl.onBind(intent);
    }

    @CallSuper
    public void onCreate() {
        super.onCreate();
        this.mImpl.onCreate(this);
    }

    @CallSuper
    public void onDestroy() {
        super.onDestroy();
        this.mImpl.onDestroy();
    }

    @Nullable
    public abstract MediaSession onGetSession(@NonNull MediaSession.ControllerInfo controllerInfo);

    @CallSuper
    public int onStartCommand(Intent intent, int i, int i2) {
        return this.mImpl.onStartCommand(intent, i, i2);
    }

    @Nullable
    public MediaNotification onUpdateNotification(@NonNull MediaSession mediaSession) {
        if (mediaSession != null) {
            return this.mImpl.onUpdateNotification(mediaSession);
        }
        throw new NullPointerException("session shouldn't be null");
    }

    public final void removeSession(@NonNull MediaSession mediaSession) {
        if (mediaSession != null) {
            this.mImpl.removeSession(mediaSession);
            return;
        }
        throw new NullPointerException("session shouldn't be null");
    }
}
