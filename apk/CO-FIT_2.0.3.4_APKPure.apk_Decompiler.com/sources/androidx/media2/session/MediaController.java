package androidx.media2.session;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pair;
import androidx.media.AudioAttributesCompat;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.Rating;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaSession;
import androidx.versionedparcelable.VersionedParcelable;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public class MediaController implements Closeable {
    private static final String TAG = "MediaController";
    @GuardedBy("mLock")
    boolean mClosed;
    @GuardedBy("mLock")
    private final List<Pair<ControllerCallback, Executor>> mExtraControllerCallbacks;
    @GuardedBy("mLock")
    MediaControllerImpl mImpl;
    final Object mLock;
    final ControllerCallback mPrimaryCallback;
    final Executor mPrimaryCallbackExecutor;
    Long mTimeDiff;

    public static final class Builder extends BuilderBase<MediaController, Builder, ControllerCallback> {
        public Builder(@NonNull Context context) {
            super(context);
        }

        @NonNull
        public MediaController build() {
            SessionToken sessionToken = this.mToken;
            if (sessionToken == null && this.mCompatToken == null) {
                throw new IllegalArgumentException("token and compat token shouldn't be both null");
            } else if (sessionToken != null) {
                return new MediaController(this.mContext, sessionToken, this.mConnectionHints, this.mCallbackExecutor, this.mCallback);
            } else {
                return new MediaController(this.mContext, this.mCompatToken, this.mConnectionHints, this.mCallbackExecutor, this.mCallback);
            }
        }

        @NonNull
        public Builder setConnectionHints(@NonNull Bundle bundle) {
            return (Builder) super.setConnectionHints(bundle);
        }

        @NonNull
        public Builder setControllerCallback(@NonNull Executor executor, @NonNull ControllerCallback controllerCallback) {
            return (Builder) super.setControllerCallback(executor, controllerCallback);
        }

        @NonNull
        public Builder setSessionCompatToken(@NonNull MediaSessionCompat.Token token) {
            return (Builder) super.setSessionCompatToken(token);
        }

        @NonNull
        public Builder setSessionToken(@NonNull SessionToken sessionToken) {
            return (Builder) super.setSessionToken(sessionToken);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static abstract class BuilderBase<T extends MediaController, U extends BuilderBase<T, U, C>, C extends ControllerCallback> {
        ControllerCallback mCallback;
        Executor mCallbackExecutor;
        MediaSessionCompat.Token mCompatToken;
        Bundle mConnectionHints;
        final Context mContext;
        SessionToken mToken;

        public BuilderBase(@NonNull Context context) {
            if (context != null) {
                this.mContext = context;
                return;
            }
            throw new NullPointerException("context shouldn't be null");
        }

        @NonNull
        public abstract T build();

        @NonNull
        public U setConnectionHints(@NonNull Bundle bundle) {
            if (bundle == null) {
                throw new NullPointerException("connectionHints shouldn't be null");
            } else if (!MediaUtils.doesBundleHaveCustomParcelable(bundle)) {
                this.mConnectionHints = new Bundle(bundle);
                return this;
            } else {
                throw new IllegalArgumentException("connectionHints shouldn't contain any custom parcelables");
            }
        }

        @NonNull
        public U setControllerCallback(@NonNull Executor executor, @NonNull C c) {
            if (executor == null) {
                throw new NullPointerException("executor shouldn't be null");
            } else if (c != null) {
                this.mCallbackExecutor = executor;
                this.mCallback = c;
                return this;
            } else {
                throw new NullPointerException("callback shouldn't be null");
            }
        }

        @NonNull
        public U setSessionCompatToken(@NonNull MediaSessionCompat.Token token) {
            if (token != null) {
                this.mCompatToken = token;
                this.mToken = null;
                return this;
            }
            throw new NullPointerException("compatToken shouldn't be null");
        }

        @NonNull
        public U setSessionToken(@NonNull SessionToken sessionToken) {
            if (sessionToken != null) {
                this.mToken = sessionToken;
                this.mCompatToken = null;
                return this;
            }
            throw new NullPointerException("token shouldn't be null");
        }
    }

    public static abstract class ControllerCallback {
        public void onAllowedCommandsChanged(@NonNull MediaController mediaController, @NonNull SessionCommandGroup sessionCommandGroup) {
        }

        public void onBufferingStateChanged(@NonNull MediaController mediaController, @NonNull MediaItem mediaItem, int i) {
        }

        public void onConnected(@NonNull MediaController mediaController, @NonNull SessionCommandGroup sessionCommandGroup) {
        }

        public void onCurrentMediaItemChanged(@NonNull MediaController mediaController, @Nullable MediaItem mediaItem) {
        }

        @NonNull
        public SessionResult onCustomCommand(@NonNull MediaController mediaController, @NonNull SessionCommand sessionCommand, @Nullable Bundle bundle) {
            return new SessionResult(-6);
        }

        public void onDisconnected(@NonNull MediaController mediaController) {
        }

        public void onPlaybackCompleted(@NonNull MediaController mediaController) {
        }

        public void onPlaybackInfoChanged(@NonNull MediaController mediaController, @NonNull PlaybackInfo playbackInfo) {
        }

        public void onPlaybackSpeedChanged(@NonNull MediaController mediaController, float f) {
        }

        public void onPlayerStateChanged(@NonNull MediaController mediaController, int i) {
        }

        public void onPlaylistChanged(@NonNull MediaController mediaController, @Nullable List<MediaItem> list, @Nullable MediaMetadata mediaMetadata) {
        }

        public void onPlaylistMetadataChanged(@NonNull MediaController mediaController, @Nullable MediaMetadata mediaMetadata) {
        }

        public void onRepeatModeChanged(@NonNull MediaController mediaController, int i) {
        }

        public void onSeekCompleted(@NonNull MediaController mediaController, long j) {
        }

        public int onSetCustomLayout(@NonNull MediaController mediaController, @NonNull List<MediaSession.CommandButton> list) {
            return -6;
        }

        public void onShuffleModeChanged(@NonNull MediaController mediaController, int i) {
        }

        public void onSubtitleData(@NonNull MediaController mediaController, @NonNull MediaItem mediaItem, @NonNull SessionPlayer.TrackInfo trackInfo, @NonNull SubtitleData subtitleData) {
        }

        public void onTrackDeselected(@NonNull MediaController mediaController, @NonNull SessionPlayer.TrackInfo trackInfo) {
        }

        public void onTrackSelected(@NonNull MediaController mediaController, @NonNull SessionPlayer.TrackInfo trackInfo) {
        }

        public void onTracksChanged(@NonNull MediaController mediaController, @NonNull List<SessionPlayer.TrackInfo> list) {
        }

        @Deprecated
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void onVideoSizeChanged(@NonNull MediaController mediaController, @NonNull MediaItem mediaItem, @NonNull VideoSize videoSize) {
        }

        public void onVideoSizeChanged(@NonNull MediaController mediaController, @NonNull VideoSize videoSize) {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public interface ControllerCallbackRunnable {
        void run(@NonNull ControllerCallback controllerCallback);
    }

    public interface MediaControllerImpl extends Closeable {
        ListenableFuture<SessionResult> addPlaylistItem(int i, @NonNull String str);

        ListenableFuture<SessionResult> adjustVolume(int i, int i2);

        ListenableFuture<SessionResult> deselectTrack(SessionPlayer.TrackInfo trackInfo);

        ListenableFuture<SessionResult> fastForward();

        @Nullable
        SessionCommandGroup getAllowedCommands();

        @Nullable
        MediaBrowserCompat getBrowserCompat();

        long getBufferedPosition();

        int getBufferingState();

        @Nullable
        SessionToken getConnectedToken();

        @NonNull
        Context getContext();

        MediaItem getCurrentMediaItem();

        int getCurrentMediaItemIndex();

        long getCurrentPosition();

        long getDuration();

        int getNextMediaItemIndex();

        @Nullable
        PlaybackInfo getPlaybackInfo();

        float getPlaybackSpeed();

        int getPlayerState();

        @Nullable
        List<MediaItem> getPlaylist();

        @Nullable
        MediaMetadata getPlaylistMetadata();

        int getPreviousMediaItemIndex();

        int getRepeatMode();

        @Nullable
        SessionPlayer.TrackInfo getSelectedTrack(int i);

        @Nullable
        PendingIntent getSessionActivity();

        int getShuffleMode();

        @NonNull
        List<SessionPlayer.TrackInfo> getTracks();

        @NonNull
        VideoSize getVideoSize();

        boolean isConnected();

        ListenableFuture<SessionResult> movePlaylistItem(int i, int i2);

        ListenableFuture<SessionResult> pause();

        ListenableFuture<SessionResult> play();

        ListenableFuture<SessionResult> prepare();

        ListenableFuture<SessionResult> removePlaylistItem(int i);

        ListenableFuture<SessionResult> replacePlaylistItem(int i, @NonNull String str);

        ListenableFuture<SessionResult> rewind();

        ListenableFuture<SessionResult> seekTo(long j);

        ListenableFuture<SessionResult> selectTrack(SessionPlayer.TrackInfo trackInfo);

        ListenableFuture<SessionResult> sendCustomCommand(@NonNull SessionCommand sessionCommand, @Nullable Bundle bundle);

        ListenableFuture<SessionResult> setMediaItem(@NonNull String str);

        ListenableFuture<SessionResult> setMediaUri(@NonNull Uri uri, @Nullable Bundle bundle);

        ListenableFuture<SessionResult> setPlaybackSpeed(float f);

        ListenableFuture<SessionResult> setPlaylist(@NonNull List<String> list, @Nullable MediaMetadata mediaMetadata);

        ListenableFuture<SessionResult> setRating(@NonNull String str, @NonNull Rating rating);

        ListenableFuture<SessionResult> setRepeatMode(int i);

        ListenableFuture<SessionResult> setShuffleMode(int i);

        ListenableFuture<SessionResult> setSurface(@Nullable Surface surface);

        ListenableFuture<SessionResult> setVolumeTo(int i, int i2);

        ListenableFuture<SessionResult> skipBackward();

        ListenableFuture<SessionResult> skipForward();

        ListenableFuture<SessionResult> skipToNextItem();

        ListenableFuture<SessionResult> skipToPlaylistItem(int i);

        ListenableFuture<SessionResult> skipToPreviousItem();

        ListenableFuture<SessionResult> updatePlaylistMetadata(@Nullable MediaMetadata mediaMetadata);
    }

    public static final class PlaybackInfo implements VersionedParcelable {
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;
        AudioAttributesCompat mAudioAttrsCompat;
        int mControlType;
        int mCurrentVolume;
        int mMaxVolume;
        int mPlaybackType;

        public PlaybackInfo() {
        }

        public static PlaybackInfo createPlaybackInfo(int i, AudioAttributesCompat audioAttributesCompat, int i2, int i3, int i4) {
            return new PlaybackInfo(i, audioAttributesCompat, i2, i3, i4);
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof PlaybackInfo)) {
                return false;
            }
            PlaybackInfo playbackInfo = (PlaybackInfo) obj;
            if (this.mPlaybackType == playbackInfo.mPlaybackType && this.mControlType == playbackInfo.mControlType && this.mMaxVolume == playbackInfo.mMaxVolume && this.mCurrentVolume == playbackInfo.mCurrentVolume && ObjectsCompat.equals(this.mAudioAttrsCompat, playbackInfo.mAudioAttrsCompat)) {
                return true;
            }
            return false;
        }

        @Nullable
        public AudioAttributesCompat getAudioAttributes() {
            return this.mAudioAttrsCompat;
        }

        public int getControlType() {
            return this.mControlType;
        }

        public int getCurrentVolume() {
            return this.mCurrentVolume;
        }

        public int getMaxVolume() {
            return this.mMaxVolume;
        }

        public int getPlaybackType() {
            return this.mPlaybackType;
        }

        public int hashCode() {
            return ObjectsCompat.hash(Integer.valueOf(this.mPlaybackType), Integer.valueOf(this.mControlType), Integer.valueOf(this.mMaxVolume), Integer.valueOf(this.mCurrentVolume), this.mAudioAttrsCompat);
        }

        public PlaybackInfo(int i, AudioAttributesCompat audioAttributesCompat, int i2, int i3, int i4) {
            this.mPlaybackType = i;
            this.mAudioAttrsCompat = audioAttributesCompat;
            this.mControlType = i2;
            this.mMaxVolume = i3;
            this.mCurrentVolume = i4;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface VolumeDirection {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface VolumeFlags {
    }

    public MediaController(@NonNull Context context, @NonNull SessionToken sessionToken, @Nullable Bundle bundle, @Nullable Executor executor, @Nullable ControllerCallback controllerCallback) {
        Object obj = new Object();
        this.mLock = obj;
        this.mExtraControllerCallbacks = new ArrayList();
        if (context == null) {
            throw new NullPointerException("context shouldn't be null");
        } else if (sessionToken != null) {
            this.mPrimaryCallback = controllerCallback;
            this.mPrimaryCallbackExecutor = executor;
            synchronized (obj) {
                this.mImpl = createImpl(context, sessionToken, bundle);
            }
        } else {
            throw new NullPointerException("token shouldn't be null");
        }
    }

    private static ListenableFuture<SessionResult> createDisconnectedFuture() {
        return SessionResult.createFutureWithResult(-100);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ControllerCallback controllerCallback) {
        controllerCallback.onDisconnected(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(Context context, Bundle bundle, MediaSessionCompat.Token token, SessionToken sessionToken) {
        boolean z;
        synchronized (this.mLock) {
            try {
                z = this.mClosed;
                if (!z) {
                    this.mImpl = createImpl(context, sessionToken, bundle);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (z) {
            notifyAllControllerCallbacks(new II0xO0(this));
        }
    }

    @NonNull
    public ListenableFuture<SessionResult> addPlaylistItem(@IntRange(from = 0) int i, @NonNull String str) {
        if (i < 0) {
            throw new IllegalArgumentException("index shouldn't be negative");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("mediaId shouldn't be empty");
        } else if (isConnected()) {
            return getImpl().addPlaylistItem(i, str);
        } else {
            return createDisconnectedFuture();
        }
    }

    @NonNull
    public ListenableFuture<SessionResult> adjustVolume(int i, int i2) {
        if (isConnected()) {
            return getImpl().adjustVolume(i, i2);
        }
        return createDisconnectedFuture();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0011, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.mLock     // Catch:{ Exception -> 0x0019 }
            monitor-enter(r0)     // Catch:{ Exception -> 0x0019 }
            boolean r1 = r2.mClosed     // Catch:{ all -> 0x0009 }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x0009:
            r1 = move-exception
            goto L_0x0017
        L_0x000b:
            r1 = 1
            r2.mClosed = r1     // Catch:{ all -> 0x0009 }
            androidx.media2.session.MediaController$MediaControllerImpl r1 = r2.mImpl     // Catch:{ all -> 0x0009 }
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            if (r1 == 0) goto L_0x0019
            r1.close()     // Catch:{ Exception -> 0x0019 }
            goto L_0x0019
        L_0x0017:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r1     // Catch:{ Exception -> 0x0019 }
        L_0x0019:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.MediaController.close():void");
    }

    public MediaControllerImpl createImpl(@NonNull Context context, @NonNull SessionToken sessionToken, @Nullable Bundle bundle) {
        if (sessionToken.isLegacySession()) {
            return new MediaControllerImplLegacy(context, this, sessionToken);
        }
        return new MediaControllerImplBase(context, this, sessionToken, bundle);
    }

    @NonNull
    public ListenableFuture<SessionResult> deselectTrack(@NonNull SessionPlayer.TrackInfo trackInfo) {
        if (trackInfo == null) {
            throw new NullPointerException("TrackInfo shouldn't be null");
        } else if (isConnected()) {
            return getImpl().deselectTrack(trackInfo);
        } else {
            return createDisconnectedFuture();
        }
    }

    @NonNull
    public ListenableFuture<SessionResult> fastForward() {
        if (isConnected()) {
            return getImpl().fastForward();
        }
        return createDisconnectedFuture();
    }

    @Nullable
    public SessionCommandGroup getAllowedCommands() {
        if (!isConnected()) {
            return null;
        }
        return getImpl().getAllowedCommands();
    }

    public long getBufferedPosition() {
        if (isConnected()) {
            return getImpl().getBufferedPosition();
        }
        return Long.MIN_VALUE;
    }

    public int getBufferingState() {
        if (isConnected()) {
            return getImpl().getBufferingState();
        }
        return 0;
    }

    @Nullable
    public SessionToken getConnectedToken() {
        if (isConnected()) {
            return getImpl().getConnectedToken();
        }
        return null;
    }

    @Nullable
    public MediaItem getCurrentMediaItem() {
        if (isConnected()) {
            return getImpl().getCurrentMediaItem();
        }
        return null;
    }

    public int getCurrentMediaItemIndex() {
        if (isConnected()) {
            return getImpl().getCurrentMediaItemIndex();
        }
        return -1;
    }

    public long getCurrentPosition() {
        if (isConnected()) {
            return getImpl().getCurrentPosition();
        }
        return Long.MIN_VALUE;
    }

    public long getDuration() {
        if (isConnected()) {
            return getImpl().getDuration();
        }
        return Long.MIN_VALUE;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Pair<ControllerCallback, Executor>> getExtraControllerCallbacks() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mExtraControllerCallbacks);
        }
        return arrayList;
    }

    public MediaControllerImpl getImpl() {
        MediaControllerImpl mediaControllerImpl;
        synchronized (this.mLock) {
            mediaControllerImpl = this.mImpl;
        }
        return mediaControllerImpl;
    }

    public int getNextMediaItemIndex() {
        if (isConnected()) {
            return getImpl().getNextMediaItemIndex();
        }
        return -1;
    }

    @Nullable
    public PlaybackInfo getPlaybackInfo() {
        if (isConnected()) {
            return getImpl().getPlaybackInfo();
        }
        return null;
    }

    public float getPlaybackSpeed() {
        if (isConnected()) {
            return getImpl().getPlaybackSpeed();
        }
        return 0.0f;
    }

    public int getPlayerState() {
        if (isConnected()) {
            return getImpl().getPlayerState();
        }
        return 0;
    }

    @Nullable
    public List<MediaItem> getPlaylist() {
        if (isConnected()) {
            return getImpl().getPlaylist();
        }
        return null;
    }

    @Nullable
    public MediaMetadata getPlaylistMetadata() {
        if (isConnected()) {
            return getImpl().getPlaylistMetadata();
        }
        return null;
    }

    public int getPreviousMediaItemIndex() {
        if (isConnected()) {
            return getImpl().getPreviousMediaItemIndex();
        }
        return -1;
    }

    public int getRepeatMode() {
        if (isConnected()) {
            return getImpl().getRepeatMode();
        }
        return 0;
    }

    @Nullable
    public SessionPlayer.TrackInfo getSelectedTrack(int i) {
        if (isConnected()) {
            return getImpl().getSelectedTrack(i);
        }
        return null;
    }

    @Nullable
    public PendingIntent getSessionActivity() {
        if (isConnected()) {
            return getImpl().getSessionActivity();
        }
        return null;
    }

    public int getShuffleMode() {
        if (isConnected()) {
            return getImpl().getShuffleMode();
        }
        return 0;
    }

    @NonNull
    public List<SessionPlayer.TrackInfo> getTracks() {
        if (isConnected()) {
            return getImpl().getTracks();
        }
        return Collections.emptyList();
    }

    @NonNull
    public VideoSize getVideoSize() {
        if (isConnected()) {
            return getImpl().getVideoSize();
        }
        return new VideoSize(0, 0);
    }

    public boolean isConnected() {
        MediaControllerImpl impl = getImpl();
        if (impl == null || !impl.isConnected()) {
            return false;
        }
        return true;
    }

    @NonNull
    public ListenableFuture<SessionResult> movePlaylistItem(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("indexes shouldn't be negative");
        } else if (isConnected()) {
            return getImpl().movePlaylistItem(i, i2);
        } else {
            return createDisconnectedFuture();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void notifyAllControllerCallbacks(@NonNull final ControllerCallbackRunnable controllerCallbackRunnable) {
        notifyPrimaryControllerCallback(controllerCallbackRunnable);
        for (Pair next : getExtraControllerCallbacks()) {
            final ControllerCallback controllerCallback = (ControllerCallback) next.first;
            Executor executor = (Executor) next.second;
            if (controllerCallback == null) {
                Log.e(TAG, "notifyAllControllerCallbacks: mExtraControllerCallbacks contains a null ControllerCallback! Ignoring.");
            } else if (executor == null) {
                Log.e(TAG, "notifyAllControllerCallbacks: mExtraControllerCallbacks contains a null Executor! Ignoring.");
            } else {
                executor.execute(new Runnable() {
                    public void run() {
                        controllerCallbackRunnable.run(controllerCallback);
                    }
                });
            }
        }
    }

    public void notifyPrimaryControllerCallback(@NonNull final ControllerCallbackRunnable controllerCallbackRunnable) {
        Executor executor;
        if (this.mPrimaryCallback != null && (executor = this.mPrimaryCallbackExecutor) != null) {
            executor.execute(new Runnable() {
                public void run() {
                    controllerCallbackRunnable.run(MediaController.this.mPrimaryCallback);
                }
            });
        }
    }

    @NonNull
    public ListenableFuture<SessionResult> pause() {
        if (isConnected()) {
            return getImpl().pause();
        }
        return createDisconnectedFuture();
    }

    @NonNull
    public ListenableFuture<SessionResult> play() {
        if (isConnected()) {
            return getImpl().play();
        }
        return createDisconnectedFuture();
    }

    @NonNull
    public ListenableFuture<SessionResult> prepare() {
        if (isConnected()) {
            return getImpl().prepare();
        }
        return createDisconnectedFuture();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void registerExtraCallback(@NonNull Executor executor, @NonNull ControllerCallback controllerCallback) {
        boolean z;
        if (executor == null) {
            throw new NullPointerException("executor shouldn't be null");
        } else if (controllerCallback != null) {
            synchronized (this.mLock) {
                try {
                    Iterator<Pair<ControllerCallback, Executor>> it = this.mExtraControllerCallbacks.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().first == controllerCallback) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        this.mExtraControllerCallbacks.add(new Pair(controllerCallback, executor));
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (z) {
                Log.w(TAG, "registerExtraCallback: the callback already exists");
            }
        } else {
            throw new NullPointerException("callback shouldn't be null");
        }
    }

    @NonNull
    public ListenableFuture<SessionResult> removePlaylistItem(@IntRange(from = 0) int i) {
        if (i < 0) {
            throw new IllegalArgumentException("index shouldn't be negative");
        } else if (isConnected()) {
            return getImpl().removePlaylistItem(i);
        } else {
            return createDisconnectedFuture();
        }
    }

    @NonNull
    public ListenableFuture<SessionResult> replacePlaylistItem(@IntRange(from = 0) int i, @NonNull String str) {
        if (i < 0) {
            throw new IllegalArgumentException("index shouldn't be negative");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("mediaId shouldn't be empty");
        } else if (isConnected()) {
            return getImpl().replacePlaylistItem(i, str);
        } else {
            return createDisconnectedFuture();
        }
    }

    @NonNull
    public ListenableFuture<SessionResult> rewind() {
        if (isConnected()) {
            return getImpl().rewind();
        }
        return createDisconnectedFuture();
    }

    @NonNull
    public ListenableFuture<SessionResult> seekTo(long j) {
        if (isConnected()) {
            return getImpl().seekTo(j);
        }
        return createDisconnectedFuture();
    }

    @NonNull
    public ListenableFuture<SessionResult> selectTrack(@NonNull SessionPlayer.TrackInfo trackInfo) {
        if (trackInfo == null) {
            throw new NullPointerException("TrackInfo shouldn't be null");
        } else if (isConnected()) {
            return getImpl().selectTrack(trackInfo);
        } else {
            return createDisconnectedFuture();
        }
    }

    @NonNull
    public ListenableFuture<SessionResult> sendCustomCommand(@NonNull SessionCommand sessionCommand, @Nullable Bundle bundle) {
        if (sessionCommand == null) {
            throw new NullPointerException("command shouldn't be null");
        } else if (sessionCommand.getCommandCode() != 0) {
            throw new IllegalArgumentException("command should be a custom command");
        } else if (isConnected()) {
            return getImpl().sendCustomCommand(sessionCommand, bundle);
        } else {
            return createDisconnectedFuture();
        }
    }

    @NonNull
    public ListenableFuture<SessionResult> setMediaItem(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("mediaId shouldn't be empty");
        } else if (isConnected()) {
            return getImpl().setMediaItem(str);
        } else {
            return createDisconnectedFuture();
        }
    }

    @NonNull
    public ListenableFuture<SessionResult> setMediaUri(@NonNull Uri uri, @Nullable Bundle bundle) {
        if (uri == null) {
            throw new NullPointerException("mediaUri shouldn't be null");
        } else if (isConnected()) {
            return getImpl().setMediaUri(uri, bundle);
        } else {
            return createDisconnectedFuture();
        }
    }

    @NonNull
    public ListenableFuture<SessionResult> setPlaybackSpeed(float f) {
        if (f == 0.0f) {
            throw new IllegalArgumentException("speed must not be zero");
        } else if (isConnected()) {
            return getImpl().setPlaybackSpeed(f);
        } else {
            return createDisconnectedFuture();
        }
    }

    @NonNull
    public ListenableFuture<SessionResult> setPlaylist(@NonNull List<String> list, @Nullable MediaMetadata mediaMetadata) {
        if (list != null) {
            int i = 0;
            while (i < list.size()) {
                if (!TextUtils.isEmpty(list.get(i))) {
                    i++;
                } else {
                    throw new IllegalArgumentException("list shouldn't contain empty id, index=" + i);
                }
            }
            if (isConnected()) {
                return getImpl().setPlaylist(list, mediaMetadata);
            }
            return createDisconnectedFuture();
        }
        throw new NullPointerException("list shouldn't be null");
    }

    @NonNull
    public ListenableFuture<SessionResult> setRating(@NonNull String str, @NonNull Rating rating) {
        if (str == null) {
            throw new NullPointerException("mediaId shouldn't be null");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("mediaId shouldn't be empty");
        } else if (rating == null) {
            throw new NullPointerException("rating shouldn't be null");
        } else if (isConnected()) {
            return getImpl().setRating(str, rating);
        } else {
            return createDisconnectedFuture();
        }
    }

    @NonNull
    public ListenableFuture<SessionResult> setRepeatMode(int i) {
        if (isConnected()) {
            return getImpl().setRepeatMode(i);
        }
        return createDisconnectedFuture();
    }

    @NonNull
    public ListenableFuture<SessionResult> setShuffleMode(int i) {
        if (isConnected()) {
            return getImpl().setShuffleMode(i);
        }
        return createDisconnectedFuture();
    }

    @NonNull
    public ListenableFuture<SessionResult> setSurface(@Nullable Surface surface) {
        if (isConnected()) {
            return getImpl().setSurface(surface);
        }
        return createDisconnectedFuture();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setTimeDiff(Long l) {
        this.mTimeDiff = l;
    }

    @NonNull
    public ListenableFuture<SessionResult> setVolumeTo(int i, int i2) {
        if (isConnected()) {
            return getImpl().setVolumeTo(i, i2);
        }
        return createDisconnectedFuture();
    }

    @NonNull
    public ListenableFuture<SessionResult> skipBackward() {
        if (isConnected()) {
            return getImpl().skipBackward();
        }
        return createDisconnectedFuture();
    }

    @NonNull
    public ListenableFuture<SessionResult> skipForward() {
        if (isConnected()) {
            return getImpl().skipForward();
        }
        return createDisconnectedFuture();
    }

    @NonNull
    public ListenableFuture<SessionResult> skipToNextPlaylistItem() {
        if (isConnected()) {
            return getImpl().skipToNextItem();
        }
        return createDisconnectedFuture();
    }

    @NonNull
    public ListenableFuture<SessionResult> skipToPlaylistItem(@IntRange(from = 0) int i) {
        if (i < 0) {
            throw new IllegalArgumentException("index shouldn't be negative");
        } else if (isConnected()) {
            return getImpl().skipToPlaylistItem(i);
        } else {
            return createDisconnectedFuture();
        }
    }

    @NonNull
    public ListenableFuture<SessionResult> skipToPreviousPlaylistItem() {
        if (isConnected()) {
            return getImpl().skipToPreviousItem();
        }
        return createDisconnectedFuture();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void unregisterExtraCallback(@NonNull ControllerCallback controllerCallback) {
        boolean z;
        if (controllerCallback != null) {
            synchronized (this.mLock) {
                try {
                    z = true;
                    int size = this.mExtraControllerCallbacks.size() - 1;
                    while (true) {
                        if (size < 0) {
                            z = false;
                            break;
                        } else if (this.mExtraControllerCallbacks.get(size).first == controllerCallback) {
                            this.mExtraControllerCallbacks.remove(size);
                            break;
                        } else {
                            size--;
                        }
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (!z) {
                Log.w(TAG, "unregisterExtraCallback: no such callback found");
                return;
            }
            return;
        }
        throw new NullPointerException("callback shouldn't be null");
    }

    @NonNull
    public ListenableFuture<SessionResult> updatePlaylistMetadata(@Nullable MediaMetadata mediaMetadata) {
        if (isConnected()) {
            return getImpl().updatePlaylistMetadata(mediaMetadata);
        }
        return createDisconnectedFuture();
    }

    public MediaController(@NonNull Context context, @NonNull MediaSessionCompat.Token token, @Nullable Bundle bundle, @Nullable Executor executor, @Nullable ControllerCallback controllerCallback) {
        this.mLock = new Object();
        this.mExtraControllerCallbacks = new ArrayList();
        if (context == null) {
            throw new NullPointerException("context shouldn't be null");
        } else if (token != null) {
            this.mPrimaryCallback = controllerCallback;
            this.mPrimaryCallbackExecutor = executor;
            SessionToken.createSessionToken(context, token, new oIX0oI(this, context, bundle));
        } else {
            throw new NullPointerException("token shouldn't be null");
        }
    }
}
