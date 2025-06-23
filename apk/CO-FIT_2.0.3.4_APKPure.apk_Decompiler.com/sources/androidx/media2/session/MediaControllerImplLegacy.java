package androidx.media2.session;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ResultReceiver;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaSession;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

class MediaControllerImplLegacy implements MediaController.MediaControllerImpl {
    static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final int ITEM_NONE = -1;
    private static final long POSITION_DIFF_TOLERANCE = 100;
    static final String SESSION_COMMAND_ON_CAPTIONING_ENABLED_CHANGED = "android.media.session.command.ON_CAPTIONING_ENALBED_CHANGED";
    static final String SESSION_COMMAND_ON_EXTRAS_CHANGED = "android.media.session.command.ON_EXTRAS_CHANGED";
    private static final String TAG = "MC2ImplLegacy";
    @GuardedBy("mLock")
    SessionCommandGroup mAllowedCommands;
    @GuardedBy("mLock")
    MediaBrowserCompat mBrowserCompat;
    @GuardedBy("mLock")
    long mBufferedPosition;
    @GuardedBy("mLock")
    int mBufferingState;
    @GuardedBy("mLock")
    boolean mClosed;
    @GuardedBy("mLock")
    boolean mConnected;
    final Context mContext;
    @GuardedBy("mLock")
    MediaControllerCompat mControllerCompat;
    @GuardedBy("mLock")
    ControllerCompatCallback mControllerCompatCallback;
    @GuardedBy("mLock")
    MediaItem mCurrentMediaItem;
    int mCurrentMediaItemIndex;
    @GuardedBy("mLock")
    List<MediaSession.CommandButton> mCustomLayout;
    final Handler mHandler;
    final HandlerThread mHandlerThread;
    MediaController mInstance;
    final Object mLock;
    @GuardedBy("mLock")
    MediaMetadataCompat mMediaMetadataCompat;
    @GuardedBy("mLock")
    MediaController.PlaybackInfo mPlaybackInfo;
    @GuardedBy("mLock")
    PlaybackStateCompat mPlaybackStateCompat;
    @GuardedBy("mLock")
    int mPlayerState;
    @GuardedBy("mLock")
    List<MediaItem> mPlaylist;
    @GuardedBy("mLock")
    MediaMetadata mPlaylistMetadata;
    List<MediaSessionCompat.QueueItem> mQueue;
    @GuardedBy("mLock")
    int mRepeatMode;
    @GuardedBy("mLock")
    int mShuffleMode;
    @GuardedBy("mLock")
    int mSkipToPlaylistIndex = -1;
    final SessionToken mToken;

    public class ConnectionCallback extends MediaBrowserCompat.ConnectionCallback {
        public ConnectionCallback() {
        }

        public void onConnected() {
            MediaBrowserCompat browserCompat = MediaControllerImplLegacy.this.getBrowserCompat();
            if (browserCompat != null) {
                MediaControllerImplLegacy.this.connectToSession(browserCompat.getSessionToken());
            } else if (MediaControllerImplLegacy.DEBUG) {
                Log.d(MediaControllerImplLegacy.TAG, "Controller is closed prematually", new IllegalStateException());
            }
        }

        public void onConnectionFailed() {
            MediaControllerImplLegacy.this.close();
        }

        public void onConnectionSuspended() {
            MediaControllerImplLegacy.this.close();
        }
    }

    public final class ControllerCompatCallback extends MediaControllerCompat.Callback {
        public ControllerCompatCallback() {
        }

        public void onAudioInfoChanged(MediaControllerCompat.PlaybackInfo playbackInfo) {
            final MediaController.PlaybackInfo playbackInfo2 = MediaUtils.toPlaybackInfo2(playbackInfo);
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed) {
                    if (mediaControllerImplLegacy.mConnected) {
                        mediaControllerImplLegacy.mPlaybackInfo = playbackInfo2;
                        mediaControllerImplLegacy.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onPlaybackInfoChanged(MediaControllerImplLegacy.this.mInstance, playbackInfo2);
                            }
                        });
                    }
                }
            }
        }

        public void onCaptioningEnabledChanged(final boolean z) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed) {
                    if (mediaControllerImplLegacy.mConnected) {
                        mediaControllerImplLegacy.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable() {
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                Bundle bundle = new Bundle();
                                bundle.putBoolean("androidx.media2.argument.CAPTIONING_ENABLED", z);
                                controllerCallback.onCustomCommand(MediaControllerImplLegacy.this.mInstance, new SessionCommand(MediaControllerImplLegacy.SESSION_COMMAND_ON_CAPTIONING_ENABLED_CHANGED, (Bundle) null), bundle);
                            }
                        });
                    }
                }
            }
        }

        public void onExtrasChanged(final Bundle bundle) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed) {
                    if (mediaControllerImplLegacy.mConnected) {
                        mediaControllerImplLegacy.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable() {
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onCustomCommand(MediaControllerImplLegacy.this.mInstance, new SessionCommand(MediaControllerImplLegacy.SESSION_COMMAND_ON_EXTRAS_CHANGED, (Bundle) null), bundle);
                            }
                        });
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
            if (r2 == r1) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
            r4.mInstance.notifyAllControllerCallbacks(new androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.AnonymousClass10(r3));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onMetadataChanged(android.support.v4.media.MediaMetadataCompat r4) {
            /*
                r3 = this;
                androidx.media2.session.MediaControllerImplLegacy r0 = androidx.media2.session.MediaControllerImplLegacy.this
                java.lang.Object r0 = r0.mLock
                monitor-enter(r0)
                androidx.media2.session.MediaControllerImplLegacy r1 = androidx.media2.session.MediaControllerImplLegacy.this     // Catch:{ all -> 0x0027 }
                boolean r2 = r1.mClosed     // Catch:{ all -> 0x0027 }
                if (r2 != 0) goto L_0x0029
                boolean r2 = r1.mConnected     // Catch:{ all -> 0x0027 }
                if (r2 != 0) goto L_0x0010
                goto L_0x0029
            L_0x0010:
                androidx.media2.common.MediaItem r2 = r1.mCurrentMediaItem     // Catch:{ all -> 0x0027 }
                r1.setCurrentMediaItemLocked(r4)     // Catch:{ all -> 0x0027 }
                androidx.media2.session.MediaControllerImplLegacy r4 = androidx.media2.session.MediaControllerImplLegacy.this     // Catch:{ all -> 0x0027 }
                androidx.media2.common.MediaItem r1 = r4.mCurrentMediaItem     // Catch:{ all -> 0x0027 }
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                if (r2 == r1) goto L_0x0026
                androidx.media2.session.MediaController r4 = r4.mInstance
                androidx.media2.session.MediaControllerImplLegacy$ControllerCompatCallback$10 r0 = new androidx.media2.session.MediaControllerImplLegacy$ControllerCompatCallback$10
                r0.<init>(r1)
                r4.notifyAllControllerCallbacks(r0)
            L_0x0026:
                return
            L_0x0027:
                r4 = move-exception
                goto L_0x002b
            L_0x0029:
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                return
            L_0x002b:
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.onMetadataChanged(android.support.v4.media.MediaMetadataCompat):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0090, code lost:
            if (r2 == r5) goto L_0x009c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0092, code lost:
            r1.mInstance.notifyAllControllerCallbacks(new androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.AnonymousClass2(r14));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x009c, code lost:
            if (r15 != null) goto L_0x00ad;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x009e, code lost:
            if (r3 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a0, code lost:
            r14.this$0.mInstance.notifyAllControllerCallbacks(new androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.AnonymousClass3(r14));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ad, code lost:
            if (r3 == null) goto L_0x00b9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b7, code lost:
            if (r3.getState() == r15.getState()) goto L_0x00c5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b9, code lost:
            r14.this$0.mInstance.notifyAllControllerCallbacks(new androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.AnonymousClass4(r14));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c5, code lost:
            if (r3 == null) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d1, code lost:
            if (r3.getPlaybackSpeed() == r15.getPlaybackSpeed()) goto L_0x00df;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d3, code lost:
            r14.this$0.mInstance.notifyAllControllerCallbacks(new androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.AnonymousClass5(r14));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00df, code lost:
            if (r3 == null) goto L_0x010d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e1, code lost:
            r0 = r15.getCurrentPosition(r14.this$0.mInstance.mTimeDiff);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ff, code lost:
            if (java.lang.Math.abs(r0 - r3.getCurrentPosition(r14.this$0.mInstance.mTimeDiff)) <= 100) goto L_0x010d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0101, code lost:
            r14.this$0.mInstance.notifyAllControllerCallbacks(new androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.AnonymousClass6(r14));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0111, code lost:
            if (r8.equals(r9) != false) goto L_0x011f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0113, code lost:
            r14.this$0.mInstance.notifyAllControllerCallbacks(new androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.AnonymousClass7(r14));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0127, code lost:
            if (r6.size() != r7.size()) goto L_0x014e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0129, code lost:
            r0 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x012e, code lost:
            if (r0 >= r7.size()) goto L_0x015a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0148, code lost:
            if (androidx.core.util.ObjectsCompat.equals(r6.get(r0).getCommand(), r7.get(r0).getCommand()) != false) goto L_0x014b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x014b, code lost:
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x014e, code lost:
            r14.this$0.mInstance.notifyPrimaryControllerCallback(new androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.AnonymousClass8(r14));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x015a, code lost:
            if (r5 != null) goto L_0x015d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x015c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x015d, code lost:
            r15 = androidx.media2.session.MediaUtils.toBufferingState(r15.getState());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0165, code lost:
            if (r3 != null) goto L_0x0168;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0168, code lost:
            r4 = androidx.media2.session.MediaUtils.toBufferingState(r3.getState());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0170, code lost:
            if (r15 == r4) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0172, code lost:
            r14.this$0.mInstance.notifyAllControllerCallbacks(new androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.AnonymousClass9(r14));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPlaybackStateChanged(final android.support.v4.media.session.PlaybackStateCompat r15) {
            /*
                r14 = this;
                androidx.media2.session.MediaControllerImplLegacy r0 = androidx.media2.session.MediaControllerImplLegacy.this
                java.lang.Object r0 = r0.mLock
                monitor-enter(r0)
                androidx.media2.session.MediaControllerImplLegacy r1 = androidx.media2.session.MediaControllerImplLegacy.this     // Catch:{ all -> 0x0063 }
                boolean r2 = r1.mClosed     // Catch:{ all -> 0x0063 }
                if (r2 != 0) goto L_0x017f
                boolean r2 = r1.mConnected     // Catch:{ all -> 0x0063 }
                if (r2 != 0) goto L_0x0011
                goto L_0x017f
            L_0x0011:
                androidx.media2.common.MediaItem r2 = r1.mCurrentMediaItem     // Catch:{ all -> 0x0063 }
                android.support.v4.media.session.PlaybackStateCompat r3 = r1.mPlaybackStateCompat     // Catch:{ all -> 0x0063 }
                r1.mPlaybackStateCompat = r15     // Catch:{ all -> 0x0063 }
                int r4 = androidx.media2.session.MediaUtils.convertToPlayerState(r15)     // Catch:{ all -> 0x0063 }
                r1.mPlayerState = r4     // Catch:{ all -> 0x0063 }
                androidx.media2.session.MediaControllerImplLegacy r1 = androidx.media2.session.MediaControllerImplLegacy.this     // Catch:{ all -> 0x0063 }
                if (r15 != 0) goto L_0x0024
                r4 = -9223372036854775808
                goto L_0x0028
            L_0x0024:
                long r4 = r15.getBufferedPosition()     // Catch:{ all -> 0x0063 }
            L_0x0028:
                r1.mBufferedPosition = r4     // Catch:{ all -> 0x0063 }
                androidx.media2.session.MediaControllerImplLegacy r1 = androidx.media2.session.MediaControllerImplLegacy.this     // Catch:{ all -> 0x0063 }
                java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r1 = r1.mQueue     // Catch:{ all -> 0x0063 }
                r4 = 0
                if (r1 == 0) goto L_0x0069
                if (r15 == 0) goto L_0x0069
                r1 = 0
            L_0x0034:
                androidx.media2.session.MediaControllerImplLegacy r5 = androidx.media2.session.MediaControllerImplLegacy.this     // Catch:{ all -> 0x0063 }
                java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r5 = r5.mQueue     // Catch:{ all -> 0x0063 }
                int r5 = r5.size()     // Catch:{ all -> 0x0063 }
                if (r1 >= r5) goto L_0x0069
                androidx.media2.session.MediaControllerImplLegacy r5 = androidx.media2.session.MediaControllerImplLegacy.this     // Catch:{ all -> 0x0063 }
                java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r5 = r5.mQueue     // Catch:{ all -> 0x0063 }
                java.lang.Object r5 = r5.get(r1)     // Catch:{ all -> 0x0063 }
                android.support.v4.media.session.MediaSessionCompat$QueueItem r5 = (android.support.v4.media.session.MediaSessionCompat.QueueItem) r5     // Catch:{ all -> 0x0063 }
                long r5 = r5.getQueueId()     // Catch:{ all -> 0x0063 }
                long r7 = r15.getActiveQueueItemId()     // Catch:{ all -> 0x0063 }
                int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r9 != 0) goto L_0x0066
                androidx.media2.session.MediaControllerImplLegacy r5 = androidx.media2.session.MediaControllerImplLegacy.this     // Catch:{ all -> 0x0063 }
                r5.mCurrentMediaItemIndex = r1     // Catch:{ all -> 0x0063 }
                java.util.List<androidx.media2.common.MediaItem> r6 = r5.mPlaylist     // Catch:{ all -> 0x0063 }
                java.lang.Object r6 = r6.get(r1)     // Catch:{ all -> 0x0063 }
                androidx.media2.common.MediaItem r6 = (androidx.media2.common.MediaItem) r6     // Catch:{ all -> 0x0063 }
                r5.mCurrentMediaItem = r6     // Catch:{ all -> 0x0063 }
                goto L_0x0066
            L_0x0063:
                r15 = move-exception
                goto L_0x0181
            L_0x0066:
                int r1 = r1 + 1
                goto L_0x0034
            L_0x0069:
                androidx.media2.session.MediaControllerImplLegacy r1 = androidx.media2.session.MediaControllerImplLegacy.this     // Catch:{ all -> 0x0063 }
                androidx.media2.common.MediaItem r5 = r1.mCurrentMediaItem     // Catch:{ all -> 0x0063 }
                java.util.List<androidx.media2.session.MediaSession$CommandButton> r6 = r1.mCustomLayout     // Catch:{ all -> 0x0063 }
                java.util.List r7 = androidx.media2.session.MediaUtils.convertToCustomLayout(r15)     // Catch:{ all -> 0x0063 }
                r1.mCustomLayout = r7     // Catch:{ all -> 0x0063 }
                androidx.media2.session.MediaControllerImplLegacy r1 = androidx.media2.session.MediaControllerImplLegacy.this     // Catch:{ all -> 0x0063 }
                java.util.List<androidx.media2.session.MediaSession$CommandButton> r7 = r1.mCustomLayout     // Catch:{ all -> 0x0063 }
                androidx.media2.session.SessionCommandGroup r8 = r1.mAllowedCommands     // Catch:{ all -> 0x0063 }
                android.support.v4.media.session.MediaControllerCompat r9 = r1.mControllerCompat     // Catch:{ all -> 0x0063 }
                long r9 = r9.getFlags()     // Catch:{ all -> 0x0063 }
                androidx.media2.session.MediaControllerImplLegacy r11 = androidx.media2.session.MediaControllerImplLegacy.this     // Catch:{ all -> 0x0063 }
                android.support.v4.media.session.PlaybackStateCompat r11 = r11.mPlaybackStateCompat     // Catch:{ all -> 0x0063 }
                androidx.media2.session.SessionCommandGroup r9 = androidx.media2.session.MediaUtils.convertToSessionCommandGroup(r9, r11)     // Catch:{ all -> 0x0063 }
                r1.mAllowedCommands = r9     // Catch:{ all -> 0x0063 }
                androidx.media2.session.MediaControllerImplLegacy r1 = androidx.media2.session.MediaControllerImplLegacy.this     // Catch:{ all -> 0x0063 }
                androidx.media2.session.SessionCommandGroup r9 = r1.mAllowedCommands     // Catch:{ all -> 0x0063 }
                monitor-exit(r0)     // Catch:{ all -> 0x0063 }
                if (r2 == r5) goto L_0x009c
                androidx.media2.session.MediaController r0 = r1.mInstance
                androidx.media2.session.MediaControllerImplLegacy$ControllerCompatCallback$2 r1 = new androidx.media2.session.MediaControllerImplLegacy$ControllerCompatCallback$2
                r1.<init>(r5)
                r0.notifyAllControllerCallbacks(r1)
            L_0x009c:
                if (r15 != 0) goto L_0x00ad
                if (r3 == 0) goto L_0x00ac
                androidx.media2.session.MediaControllerImplLegacy r15 = androidx.media2.session.MediaControllerImplLegacy.this
                androidx.media2.session.MediaController r15 = r15.mInstance
                androidx.media2.session.MediaControllerImplLegacy$ControllerCompatCallback$3 r0 = new androidx.media2.session.MediaControllerImplLegacy$ControllerCompatCallback$3
                r0.<init>()
                r15.notifyAllControllerCallbacks(r0)
            L_0x00ac:
                return
            L_0x00ad:
                if (r3 == 0) goto L_0x00b9
                int r0 = r3.getState()
                int r1 = r15.getState()
                if (r0 == r1) goto L_0x00c5
            L_0x00b9:
                androidx.media2.session.MediaControllerImplLegacy r0 = androidx.media2.session.MediaControllerImplLegacy.this
                androidx.media2.session.MediaController r0 = r0.mInstance
                androidx.media2.session.MediaControllerImplLegacy$ControllerCompatCallback$4 r1 = new androidx.media2.session.MediaControllerImplLegacy$ControllerCompatCallback$4
                r1.<init>(r15)
                r0.notifyAllControllerCallbacks(r1)
            L_0x00c5:
                if (r3 == 0) goto L_0x00d3
                float r0 = r3.getPlaybackSpeed()
                float r1 = r15.getPlaybackSpeed()
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x00df
            L_0x00d3:
                androidx.media2.session.MediaControllerImplLegacy r0 = androidx.media2.session.MediaControllerImplLegacy.this
                androidx.media2.session.MediaController r0 = r0.mInstance
                androidx.media2.session.MediaControllerImplLegacy$ControllerCompatCallback$5 r1 = new androidx.media2.session.MediaControllerImplLegacy$ControllerCompatCallback$5
                r1.<init>(r15)
                r0.notifyAllControllerCallbacks(r1)
            L_0x00df:
                if (r3 == 0) goto L_0x010d
                androidx.media2.session.MediaControllerImplLegacy r0 = androidx.media2.session.MediaControllerImplLegacy.this
                androidx.media2.session.MediaController r0 = r0.mInstance
                java.lang.Long r0 = r0.mTimeDiff
                long r0 = r15.getCurrentPosition(r0)
                androidx.media2.session.MediaControllerImplLegacy r2 = androidx.media2.session.MediaControllerImplLegacy.this
                androidx.media2.session.MediaController r2 = r2.mInstance
                java.lang.Long r2 = r2.mTimeDiff
                long r10 = r3.getCurrentPosition(r2)
                long r10 = r0 - r10
                long r10 = java.lang.Math.abs(r10)
                r12 = 100
                int r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
                if (r2 <= 0) goto L_0x010d
                androidx.media2.session.MediaControllerImplLegacy r2 = androidx.media2.session.MediaControllerImplLegacy.this
                androidx.media2.session.MediaController r2 = r2.mInstance
                androidx.media2.session.MediaControllerImplLegacy$ControllerCompatCallback$6 r10 = new androidx.media2.session.MediaControllerImplLegacy$ControllerCompatCallback$6
                r10.<init>(r0)
                r2.notifyAllControllerCallbacks(r10)
            L_0x010d:
                boolean r0 = r8.equals(r9)
                if (r0 != 0) goto L_0x011f
                androidx.media2.session.MediaControllerImplLegacy r0 = androidx.media2.session.MediaControllerImplLegacy.this
                androidx.media2.session.MediaController r0 = r0.mInstance
                androidx.media2.session.MediaControllerImplLegacy$ControllerCompatCallback$7 r1 = new androidx.media2.session.MediaControllerImplLegacy$ControllerCompatCallback$7
                r1.<init>(r9)
                r0.notifyAllControllerCallbacks(r1)
            L_0x011f:
                int r0 = r6.size()
                int r1 = r7.size()
                if (r0 != r1) goto L_0x014e
                r0 = 0
            L_0x012a:
                int r1 = r7.size()
                if (r0 >= r1) goto L_0x015a
                java.lang.Object r1 = r6.get(r0)
                androidx.media2.session.MediaSession$CommandButton r1 = (androidx.media2.session.MediaSession.CommandButton) r1
                androidx.media2.session.SessionCommand r1 = r1.getCommand()
                java.lang.Object r2 = r7.get(r0)
                androidx.media2.session.MediaSession$CommandButton r2 = (androidx.media2.session.MediaSession.CommandButton) r2
                androidx.media2.session.SessionCommand r2 = r2.getCommand()
                boolean r1 = androidx.core.util.ObjectsCompat.equals(r1, r2)
                if (r1 != 0) goto L_0x014b
                goto L_0x014e
            L_0x014b:
                int r0 = r0 + 1
                goto L_0x012a
            L_0x014e:
                androidx.media2.session.MediaControllerImplLegacy r0 = androidx.media2.session.MediaControllerImplLegacy.this
                androidx.media2.session.MediaController r0 = r0.mInstance
                androidx.media2.session.MediaControllerImplLegacy$ControllerCompatCallback$8 r1 = new androidx.media2.session.MediaControllerImplLegacy$ControllerCompatCallback$8
                r1.<init>(r7)
                r0.notifyPrimaryControllerCallback(r1)
            L_0x015a:
                if (r5 != 0) goto L_0x015d
                return
            L_0x015d:
                int r15 = r15.getState()
                int r15 = androidx.media2.session.MediaUtils.toBufferingState(r15)
                if (r3 != 0) goto L_0x0168
                goto L_0x0170
            L_0x0168:
                int r0 = r3.getState()
                int r4 = androidx.media2.session.MediaUtils.toBufferingState(r0)
            L_0x0170:
                if (r15 == r4) goto L_0x017e
                androidx.media2.session.MediaControllerImplLegacy r0 = androidx.media2.session.MediaControllerImplLegacy.this
                androidx.media2.session.MediaController r0 = r0.mInstance
                androidx.media2.session.MediaControllerImplLegacy$ControllerCompatCallback$9 r1 = new androidx.media2.session.MediaControllerImplLegacy$ControllerCompatCallback$9
                r1.<init>(r5, r15)
                r0.notifyAllControllerCallbacks(r1)
            L_0x017e:
                return
            L_0x017f:
                monitor-exit(r0)     // Catch:{ all -> 0x0063 }
                return
            L_0x0181:
                monitor-exit(r0)     // Catch:{ all -> 0x0063 }
                throw r15
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.onPlaybackStateChanged(android.support.v4.media.session.PlaybackStateCompat):void");
        }

        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                try {
                    MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                    if (!mediaControllerImplLegacy.mClosed) {
                        if (mediaControllerImplLegacy.mConnected) {
                            mediaControllerImplLegacy.mQueue = MediaUtils.removeNullElements(list);
                            List<MediaSessionCompat.QueueItem> list2 = MediaControllerImplLegacy.this.mQueue;
                            if (list2 != null) {
                                if (list2.size() != 0) {
                                    MediaControllerImplLegacy mediaControllerImplLegacy2 = MediaControllerImplLegacy.this;
                                    mediaControllerImplLegacy2.mPlaylist = MediaUtils.convertQueueItemListToMediaItemList(mediaControllerImplLegacy2.mQueue);
                                    MediaControllerImplLegacy mediaControllerImplLegacy3 = MediaControllerImplLegacy.this;
                                    final List<MediaItem> list3 = mediaControllerImplLegacy3.mPlaylist;
                                    final MediaMetadata mediaMetadata = mediaControllerImplLegacy3.mPlaylistMetadata;
                                    mediaControllerImplLegacy3.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
                                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                            controllerCallback.onPlaylistChanged(MediaControllerImplLegacy.this.mInstance, list3, mediaMetadata);
                                        }
                                    });
                                }
                            }
                            MediaControllerImplLegacy mediaControllerImplLegacy4 = MediaControllerImplLegacy.this;
                            mediaControllerImplLegacy4.mQueue = null;
                            mediaControllerImplLegacy4.mPlaylist = null;
                            MediaControllerImplLegacy mediaControllerImplLegacy32 = MediaControllerImplLegacy.this;
                            final List<MediaItem> list32 = mediaControllerImplLegacy32.mPlaylist;
                            final MediaMetadata mediaMetadata2 = mediaControllerImplLegacy32.mPlaylistMetadata;
                            mediaControllerImplLegacy32.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
                                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                    controllerCallback.onPlaylistChanged(MediaControllerImplLegacy.this.mInstance, list32, mediaMetadata2);
                                }
                            });
                        }
                    }
                } finally {
                }
            }
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed) {
                    if (mediaControllerImplLegacy.mConnected) {
                        mediaControllerImplLegacy.mPlaylistMetadata = MediaUtils.convertToMediaMetadata(charSequence);
                        MediaControllerImplLegacy mediaControllerImplLegacy2 = MediaControllerImplLegacy.this;
                        final MediaMetadata mediaMetadata = mediaControllerImplLegacy2.mPlaylistMetadata;
                        mediaControllerImplLegacy2.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onPlaylistMetadataChanged(MediaControllerImplLegacy.this.mInstance, mediaMetadata);
                            }
                        });
                    }
                }
            }
        }

        public void onRepeatModeChanged(final int i) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed) {
                    if (mediaControllerImplLegacy.mConnected) {
                        mediaControllerImplLegacy.mRepeatMode = i;
                        mediaControllerImplLegacy.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onRepeatModeChanged(MediaControllerImplLegacy.this.mInstance, i);
                            }
                        });
                    }
                }
            }
        }

        public void onSessionDestroyed() {
            MediaControllerImplLegacy.this.close();
        }

        public void onSessionEvent(final String str, final Bundle bundle) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed) {
                    if (mediaControllerImplLegacy.mConnected) {
                        mediaControllerImplLegacy.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable() {
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onCustomCommand(MediaControllerImplLegacy.this.mInstance, new SessionCommand(str, (Bundle) null), bundle);
                            }
                        });
                    }
                }
            }
        }

        public void onSessionReady() {
            MediaControllerImplLegacy mediaControllerImplLegacy;
            boolean z;
            PlaybackStateCompat playbackState;
            int shuffleMode;
            int repeatMode;
            boolean isCaptioningEnabled;
            synchronized (MediaControllerImplLegacy.this.mLock) {
                mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                z = mediaControllerImplLegacy.mConnected;
            }
            if (!z) {
                mediaControllerImplLegacy.onConnectedNotLocked();
                return;
            }
            synchronized (mediaControllerImplLegacy.mLock) {
                playbackState = MediaControllerImplLegacy.this.mControllerCompat.getPlaybackState();
                shuffleMode = MediaControllerImplLegacy.this.mControllerCompat.getShuffleMode();
                repeatMode = MediaControllerImplLegacy.this.mControllerCompat.getRepeatMode();
                isCaptioningEnabled = MediaControllerImplLegacy.this.mControllerCompat.isCaptioningEnabled();
            }
            onPlaybackStateChanged(playbackState);
            onShuffleModeChanged(shuffleMode);
            onRepeatModeChanged(repeatMode);
            onCaptioningEnabledChanged(isCaptioningEnabled);
        }

        public void onShuffleModeChanged(final int i) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                if (!mediaControllerImplLegacy.mClosed) {
                    if (mediaControllerImplLegacy.mConnected) {
                        mediaControllerImplLegacy.mShuffleMode = i;
                        mediaControllerImplLegacy.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onShuffleModeChanged(MediaControllerImplLegacy.this.mInstance, i);
                            }
                        });
                    }
                }
            }
        }
    }

    public MediaControllerImplLegacy(@NonNull Context context, @NonNull MediaController mediaController, @NonNull SessionToken sessionToken) {
        Object obj = new Object();
        this.mLock = obj;
        this.mContext = context;
        this.mInstance = mediaController;
        HandlerThread handlerThread = new HandlerThread("MediaController_Thread");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        this.mToken = sessionToken;
        if (sessionToken.getType() == 0) {
            synchronized (obj) {
                this.mBrowserCompat = null;
            }
            connectToSession((MediaSessionCompat.Token) sessionToken.getBinder());
            return;
        }
        connectToService();
    }

    private void connectToService() {
        this.mHandler.post(new Runnable() {
            public void run() {
                synchronized (MediaControllerImplLegacy.this.mLock) {
                    MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                    MediaControllerImplLegacy mediaControllerImplLegacy2 = MediaControllerImplLegacy.this;
                    mediaControllerImplLegacy.mBrowserCompat = new MediaBrowserCompat(mediaControllerImplLegacy2.mContext, mediaControllerImplLegacy2.mToken.getComponentName(), new ConnectionCallback(), (Bundle) null);
                    MediaControllerImplLegacy.this.mBrowserCompat.connect();
                }
            }
        });
    }

    private ListenableFuture<SessionResult> createFutureWithResult(int i) {
        MediaItem mediaItem;
        synchronized (this.mLock) {
            mediaItem = this.mCurrentMediaItem;
        }
        ResolvableFuture create = ResolvableFuture.create();
        create.set(new SessionResult(i, (Bundle) null, mediaItem));
        return create;
    }

    public ListenableFuture<SessionResult> addPlaylistItem(int i, @NonNull String str) {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    ListenableFuture<SessionResult> createFutureWithResult = createFutureWithResult(-100);
                    return createFutureWithResult;
                }
                this.mControllerCompat.addQueueItem(MediaUtils.createMediaDescriptionCompat(str), i);
                return createFutureWithResult(0);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public ListenableFuture<SessionResult> adjustVolume(int i, int i2) {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    ListenableFuture<SessionResult> createFutureWithResult = createFutureWithResult(-100);
                    return createFutureWithResult;
                }
                this.mControllerCompat.adjustVolume(i, i2);
                return createFutureWithResult(0);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public void close() {
        if (DEBUG) {
            Log.d(TAG, "close from " + this.mToken);
        }
        synchronized (this.mLock) {
            try {
                if (!this.mClosed) {
                    this.mHandler.removeCallbacksAndMessages((Object) null);
                    this.mHandlerThread.quitSafely();
                    this.mClosed = true;
                    MediaBrowserCompat mediaBrowserCompat = this.mBrowserCompat;
                    if (mediaBrowserCompat != null) {
                        mediaBrowserCompat.disconnect();
                        this.mBrowserCompat = null;
                    }
                    MediaControllerCompat mediaControllerCompat = this.mControllerCompat;
                    if (mediaControllerCompat != null) {
                        mediaControllerCompat.unregisterCallback(this.mControllerCompatCallback);
                        this.mControllerCompat = null;
                    }
                    this.mConnected = false;
                    this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() {
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            controllerCallback.onDisconnected(MediaControllerImplLegacy.this.mInstance);
                        }
                    });
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public void connectToSession(MediaSessionCompat.Token token) {
        boolean isSessionReady;
        MediaControllerCompat mediaControllerCompat = new MediaControllerCompat(this.mContext, token);
        synchronized (this.mLock) {
            this.mControllerCompat = mediaControllerCompat;
            this.mControllerCompatCallback = new ControllerCompatCallback();
            isSessionReady = this.mControllerCompat.isSessionReady();
            this.mControllerCompat.registerCallback(this.mControllerCompatCallback, this.mHandler);
        }
        if (!isSessionReady) {
            onConnectedNotLocked();
        }
    }

    @NonNull
    public ListenableFuture<SessionResult> deselectTrack(@NonNull SessionPlayer.TrackInfo trackInfo) {
        Log.w(TAG, "Session doesn't support deselecting track");
        return createFutureWithResult(-6);
    }

    public ListenableFuture<SessionResult> fastForward() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    ListenableFuture<SessionResult> createFutureWithResult = createFutureWithResult(-100);
                    return createFutureWithResult;
                }
                this.mControllerCompat.getTransportControls().fastForward();
                return createFutureWithResult(0);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public SessionCommandGroup getAllowedCommands() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return null;
                }
                SessionCommandGroup sessionCommandGroup = this.mAllowedCommands;
                return sessionCommandGroup;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public MediaBrowserCompat getBrowserCompat() {
        MediaBrowserCompat mediaBrowserCompat;
        synchronized (this.mLock) {
            mediaBrowserCompat = this.mBrowserCompat;
        }
        return mediaBrowserCompat;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getBufferedPosition() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mLock
            monitor-enter(r0)
            boolean r1 = r6.mConnected     // Catch:{ all -> 0x0017 }
            r2 = -9223372036854775808
            if (r1 != 0) goto L_0x0019
            java.lang.String r1 = "MC2ImplLegacy"
            java.lang.String r4 = "Session isn't active"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0017 }
            r5.<init>()     // Catch:{ all -> 0x0017 }
            android.util.Log.w(r1, r4, r5)     // Catch:{ all -> 0x0017 }
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return r2
        L_0x0017:
            r1 = move-exception
            goto L_0x0024
        L_0x0019:
            android.support.v4.media.session.PlaybackStateCompat r1 = r6.mPlaybackStateCompat     // Catch:{ all -> 0x0017 }
            if (r1 != 0) goto L_0x001e
            goto L_0x0022
        L_0x001e:
            long r2 = r1.getBufferedPosition()     // Catch:{ all -> 0x0017 }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return r2
        L_0x0024:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.MediaControllerImplLegacy.getBufferedPosition():long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getBufferingState() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.mLock
            monitor-enter(r0)
            boolean r1 = r5.mConnected     // Catch:{ all -> 0x0016 }
            r2 = 0
            if (r1 != 0) goto L_0x0018
            java.lang.String r1 = "MC2ImplLegacy"
            java.lang.String r3 = "Session isn't active"
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0016 }
            r4.<init>()     // Catch:{ all -> 0x0016 }
            android.util.Log.w(r1, r3, r4)     // Catch:{ all -> 0x0016 }
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            return r2
        L_0x0016:
            r1 = move-exception
            goto L_0x0027
        L_0x0018:
            android.support.v4.media.session.PlaybackStateCompat r1 = r5.mPlaybackStateCompat     // Catch:{ all -> 0x0016 }
            if (r1 != 0) goto L_0x001d
            goto L_0x0025
        L_0x001d:
            int r1 = r1.getState()     // Catch:{ all -> 0x0016 }
            int r2 = androidx.media2.session.MediaUtils.toBufferingState(r1)     // Catch:{ all -> 0x0016 }
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            return r2
        L_0x0027:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.MediaControllerImplLegacy.getBufferingState():int");
    }

    @Nullable
    public SessionToken getConnectedToken() {
        SessionToken sessionToken;
        synchronized (this.mLock) {
            try {
                if (this.mConnected) {
                    sessionToken = this.mToken;
                } else {
                    sessionToken = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sessionToken;
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    public MediaItem getCurrentMediaItem() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return null;
                }
                MediaItem mediaItem = this.mCurrentMediaItem;
                return mediaItem;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int getCurrentMediaItemIndex() {
        return this.mCurrentMediaItemIndex;
    }

    public long getCurrentPosition() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return Long.MIN_VALUE;
                }
                PlaybackStateCompat playbackStateCompat = this.mPlaybackStateCompat;
                if (playbackStateCompat == null) {
                    return Long.MIN_VALUE;
                }
                long currentPosition = playbackStateCompat.getCurrentPosition(this.mInstance.mTimeDiff);
                return currentPosition;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        return Long.MIN_VALUE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getDuration() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mLock
            monitor-enter(r0)
            boolean r1 = r6.mConnected     // Catch:{ all -> 0x0017 }
            r2 = -9223372036854775808
            if (r1 != 0) goto L_0x0019
            java.lang.String r1 = "MC2ImplLegacy"
            java.lang.String r4 = "Session isn't active"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0017 }
            r5.<init>()     // Catch:{ all -> 0x0017 }
            android.util.Log.w(r1, r4, r5)     // Catch:{ all -> 0x0017 }
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return r2
        L_0x0017:
            r1 = move-exception
            goto L_0x0031
        L_0x0019:
            android.support.v4.media.MediaMetadataCompat r1 = r6.mMediaMetadataCompat     // Catch:{ all -> 0x0017 }
            if (r1 == 0) goto L_0x002f
            java.lang.String r4 = "android.media.metadata.DURATION"
            boolean r1 = r1.containsKey(r4)     // Catch:{ all -> 0x0017 }
            if (r1 == 0) goto L_0x002f
            android.support.v4.media.MediaMetadataCompat r1 = r6.mMediaMetadataCompat     // Catch:{ all -> 0x0017 }
            java.lang.String r2 = "android.media.metadata.DURATION"
            long r1 = r1.getLong(r2)     // Catch:{ all -> 0x0017 }
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return r1
        L_0x002f:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return r2
        L_0x0031:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.MediaControllerImplLegacy.getDuration():long");
    }

    public int getNextMediaItemIndex() {
        return -1;
    }

    @Nullable
    public MediaController.PlaybackInfo getPlaybackInfo() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return null;
                }
                MediaController.PlaybackInfo playbackInfo = this.mPlaybackInfo;
                return playbackInfo;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public float getPlaybackSpeed() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.mLock
            monitor-enter(r0)
            boolean r1 = r5.mConnected     // Catch:{ all -> 0x0016 }
            r2 = 0
            if (r1 != 0) goto L_0x0018
            java.lang.String r1 = "MC2ImplLegacy"
            java.lang.String r3 = "Session isn't active"
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0016 }
            r4.<init>()     // Catch:{ all -> 0x0016 }
            android.util.Log.w(r1, r3, r4)     // Catch:{ all -> 0x0016 }
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            return r2
        L_0x0016:
            r1 = move-exception
            goto L_0x0023
        L_0x0018:
            android.support.v4.media.session.PlaybackStateCompat r1 = r5.mPlaybackStateCompat     // Catch:{ all -> 0x0016 }
            if (r1 != 0) goto L_0x001d
            goto L_0x0021
        L_0x001d:
            float r2 = r1.getPlaybackSpeed()     // Catch:{ all -> 0x0016 }
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            return r2
        L_0x0023:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.MediaControllerImplLegacy.getPlaybackSpeed():float");
    }

    public int getPlayerState() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return 3;
                }
                int i = this.mPlayerState;
                return i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
        return r2;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<androidx.media2.common.MediaItem> getPlaylist() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.mLock
            monitor-enter(r0)
            boolean r1 = r5.mConnected     // Catch:{ all -> 0x0016 }
            r2 = 0
            if (r1 != 0) goto L_0x0018
            java.lang.String r1 = "MC2ImplLegacy"
            java.lang.String r3 = "Session isn't active"
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0016 }
            r4.<init>()     // Catch:{ all -> 0x0016 }
            android.util.Log.w(r1, r3, r4)     // Catch:{ all -> 0x0016 }
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            return r2
        L_0x0016:
            r1 = move-exception
            goto L_0x002c
        L_0x0018:
            java.util.List<androidx.media2.common.MediaItem> r1 = r5.mPlaylist     // Catch:{ all -> 0x0016 }
            if (r1 == 0) goto L_0x002a
            int r1 = r1.size()     // Catch:{ all -> 0x0016 }
            if (r1 != 0) goto L_0x0023
            goto L_0x002a
        L_0x0023:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0016 }
            java.util.List<androidx.media2.common.MediaItem> r1 = r5.mPlaylist     // Catch:{ all -> 0x0016 }
            r2.<init>(r1)     // Catch:{ all -> 0x0016 }
        L_0x002a:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            return r2
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.MediaControllerImplLegacy.getPlaylist():java.util.List");
    }

    @Nullable
    public MediaMetadata getPlaylistMetadata() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return null;
                }
                MediaMetadata mediaMetadata = this.mPlaylistMetadata;
                return mediaMetadata;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int getPreviousMediaItemIndex() {
        return -1;
    }

    public int getRepeatMode() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return 0;
                }
                int i = this.mRepeatMode;
                return i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public SessionPlayer.TrackInfo getSelectedTrack(int i) {
        Log.w(TAG, "Session doesn't support getting selected track");
        return null;
    }

    @Nullable
    public PendingIntent getSessionActivity() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return null;
                }
                PendingIntent sessionActivity = this.mControllerCompat.getSessionActivity();
                return sessionActivity;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int getShuffleMode() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return 0;
                }
                int i = this.mShuffleMode;
                return i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public List<SessionPlayer.TrackInfo> getTracks() {
        Log.w(TAG, "Session doesn't support getting TrackInfo");
        return Collections.emptyList();
    }

    @NonNull
    public VideoSize getVideoSize() {
        Log.w(TAG, "Session doesn't support getting VideoSize");
        return new VideoSize(0, 0);
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mConnected;
        }
        return z;
    }

    public ListenableFuture<SessionResult> movePlaylistItem(int i, int i2) {
        return createFutureWithResult(-6);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00b8, code lost:
        r4.mInstance.notifyAllControllerCallbacks(new androidx.media2.session.MediaControllerImplLegacy.AnonymousClass3(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c6, code lost:
        if (r1.isEmpty() != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c8, code lost:
        r4.mInstance.notifyPrimaryControllerCallback(new androidx.media2.session.MediaControllerImplLegacy.AnonymousClass4(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onConnectedNotLocked() {
        /*
            r4 = this;
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x001c
            java.lang.String r0 = "MC2ImplLegacy"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onConnectedNotLocked token="
            r1.append(r2)
            androidx.media2.session.SessionToken r2 = r4.mToken
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
        L_0x001c:
            java.lang.Object r0 = r4.mLock
            monitor-enter(r0)
            boolean r1 = r4.mClosed     // Catch:{ all -> 0x0098 }
            if (r1 != 0) goto L_0x00d3
            boolean r1 = r4.mConnected     // Catch:{ all -> 0x0098 }
            if (r1 == 0) goto L_0x0029
            goto L_0x00d3
        L_0x0029:
            android.support.v4.media.session.MediaControllerCompat r1 = r4.mControllerCompat     // Catch:{ all -> 0x0098 }
            android.support.v4.media.session.PlaybackStateCompat r1 = r1.getPlaybackState()     // Catch:{ all -> 0x0098 }
            r4.mPlaybackStateCompat = r1     // Catch:{ all -> 0x0098 }
            android.support.v4.media.session.MediaControllerCompat r1 = r4.mControllerCompat     // Catch:{ all -> 0x0098 }
            long r1 = r1.getFlags()     // Catch:{ all -> 0x0098 }
            android.support.v4.media.session.PlaybackStateCompat r3 = r4.mPlaybackStateCompat     // Catch:{ all -> 0x0098 }
            androidx.media2.session.SessionCommandGroup r1 = androidx.media2.session.MediaUtils.convertToSessionCommandGroup(r1, r3)     // Catch:{ all -> 0x0098 }
            r4.mAllowedCommands = r1     // Catch:{ all -> 0x0098 }
            android.support.v4.media.session.PlaybackStateCompat r1 = r4.mPlaybackStateCompat     // Catch:{ all -> 0x0098 }
            int r1 = androidx.media2.session.MediaUtils.convertToPlayerState(r1)     // Catch:{ all -> 0x0098 }
            r4.mPlayerState = r1     // Catch:{ all -> 0x0098 }
            android.support.v4.media.session.PlaybackStateCompat r1 = r4.mPlaybackStateCompat     // Catch:{ all -> 0x0098 }
            if (r1 != 0) goto L_0x004e
            r1 = -9223372036854775808
            goto L_0x0052
        L_0x004e:
            long r1 = r1.getBufferedPosition()     // Catch:{ all -> 0x0098 }
        L_0x0052:
            r4.mBufferedPosition = r1     // Catch:{ all -> 0x0098 }
            android.support.v4.media.session.PlaybackStateCompat r1 = r4.mPlaybackStateCompat     // Catch:{ all -> 0x0098 }
            java.util.List r1 = androidx.media2.session.MediaUtils.convertToCustomLayout(r1)     // Catch:{ all -> 0x0098 }
            r4.mCustomLayout = r1     // Catch:{ all -> 0x0098 }
            androidx.media2.session.SessionCommandGroup r2 = r4.mAllowedCommands     // Catch:{ all -> 0x0098 }
            android.support.v4.media.session.MediaControllerCompat r3 = r4.mControllerCompat     // Catch:{ all -> 0x0098 }
            android.support.v4.media.session.MediaControllerCompat$PlaybackInfo r3 = r3.getPlaybackInfo()     // Catch:{ all -> 0x0098 }
            androidx.media2.session.MediaController$PlaybackInfo r3 = androidx.media2.session.MediaUtils.toPlaybackInfo2(r3)     // Catch:{ all -> 0x0098 }
            r4.mPlaybackInfo = r3     // Catch:{ all -> 0x0098 }
            android.support.v4.media.session.MediaControllerCompat r3 = r4.mControllerCompat     // Catch:{ all -> 0x0098 }
            int r3 = r3.getRepeatMode()     // Catch:{ all -> 0x0098 }
            r4.mRepeatMode = r3     // Catch:{ all -> 0x0098 }
            android.support.v4.media.session.MediaControllerCompat r3 = r4.mControllerCompat     // Catch:{ all -> 0x0098 }
            int r3 = r3.getShuffleMode()     // Catch:{ all -> 0x0098 }
            r4.mShuffleMode = r3     // Catch:{ all -> 0x0098 }
            android.support.v4.media.session.MediaControllerCompat r3 = r4.mControllerCompat     // Catch:{ all -> 0x0098 }
            java.util.List r3 = r3.getQueue()     // Catch:{ all -> 0x0098 }
            java.util.List r3 = androidx.media2.session.MediaUtils.removeNullElements(r3)     // Catch:{ all -> 0x0098 }
            r4.mQueue = r3     // Catch:{ all -> 0x0098 }
            if (r3 == 0) goto L_0x009a
            int r3 = r3.size()     // Catch:{ all -> 0x0098 }
            if (r3 != 0) goto L_0x008f
            goto L_0x009a
        L_0x008f:
            java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r3 = r4.mQueue     // Catch:{ all -> 0x0098 }
            java.util.List r3 = androidx.media2.session.MediaUtils.convertQueueItemListToMediaItemList(r3)     // Catch:{ all -> 0x0098 }
            r4.mPlaylist = r3     // Catch:{ all -> 0x0098 }
            goto L_0x009f
        L_0x0098:
            r1 = move-exception
            goto L_0x00d5
        L_0x009a:
            r3 = 0
            r4.mQueue = r3     // Catch:{ all -> 0x0098 }
            r4.mPlaylist = r3     // Catch:{ all -> 0x0098 }
        L_0x009f:
            android.support.v4.media.session.MediaControllerCompat r3 = r4.mControllerCompat     // Catch:{ all -> 0x0098 }
            java.lang.CharSequence r3 = r3.getQueueTitle()     // Catch:{ all -> 0x0098 }
            androidx.media2.common.MediaMetadata r3 = androidx.media2.session.MediaUtils.convertToMediaMetadata(r3)     // Catch:{ all -> 0x0098 }
            r4.mPlaylistMetadata = r3     // Catch:{ all -> 0x0098 }
            android.support.v4.media.session.MediaControllerCompat r3 = r4.mControllerCompat     // Catch:{ all -> 0x0098 }
            android.support.v4.media.MediaMetadataCompat r3 = r3.getMetadata()     // Catch:{ all -> 0x0098 }
            r4.setCurrentMediaItemLocked(r3)     // Catch:{ all -> 0x0098 }
            r3 = 1
            r4.mConnected = r3     // Catch:{ all -> 0x0098 }
            monitor-exit(r0)     // Catch:{ all -> 0x0098 }
            androidx.media2.session.MediaController r0 = r4.mInstance
            androidx.media2.session.MediaControllerImplLegacy$3 r3 = new androidx.media2.session.MediaControllerImplLegacy$3
            r3.<init>(r2)
            r0.notifyAllControllerCallbacks(r3)
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x00d2
            androidx.media2.session.MediaController r0 = r4.mInstance
            androidx.media2.session.MediaControllerImplLegacy$4 r2 = new androidx.media2.session.MediaControllerImplLegacy$4
            r2.<init>(r1)
            r0.notifyPrimaryControllerCallback(r2)
        L_0x00d2:
            return
        L_0x00d3:
            monitor-exit(r0)     // Catch:{ all -> 0x0098 }
            return
        L_0x00d5:
            monitor-exit(r0)     // Catch:{ all -> 0x0098 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.MediaControllerImplLegacy.onConnectedNotLocked():void");
    }

    public ListenableFuture<SessionResult> pause() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    ListenableFuture<SessionResult> createFutureWithResult = createFutureWithResult(-100);
                    return createFutureWithResult;
                }
                this.mControllerCompat.getTransportControls().pause();
                return createFutureWithResult(0);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public ListenableFuture<SessionResult> play() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    ListenableFuture<SessionResult> createFutureWithResult = createFutureWithResult(-100);
                    return createFutureWithResult;
                }
                this.mControllerCompat.getTransportControls().play();
                return createFutureWithResult(0);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public ListenableFuture<SessionResult> prepare() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    ListenableFuture<SessionResult> createFutureWithResult = createFutureWithResult(-100);
                    return createFutureWithResult;
                }
                this.mControllerCompat.getTransportControls().prepare();
                return createFutureWithResult(0);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public ListenableFuture<SessionResult> removePlaylistItem(int i) {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    ListenableFuture<SessionResult> createFutureWithResult = createFutureWithResult(-100);
                    return createFutureWithResult;
                }
                List<MediaSessionCompat.QueueItem> list = this.mQueue;
                if (list != null && i >= 0) {
                    if (i < list.size()) {
                        this.mControllerCompat.removeQueueItem(this.mQueue.get(i).getDescription());
                        return createFutureWithResult(0);
                    }
                }
                ListenableFuture<SessionResult> createFutureWithResult2 = createFutureWithResult(-3);
                return createFutureWithResult2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ListenableFuture<SessionResult> replacePlaylistItem(int i, @NonNull String str) {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    ListenableFuture<SessionResult> createFutureWithResult = createFutureWithResult(-100);
                    return createFutureWithResult;
                }
                List<MediaSessionCompat.QueueItem> list = this.mQueue;
                if (list != null && i >= 0) {
                    if (i < list.size()) {
                        this.mControllerCompat.removeQueueItem(this.mQueue.get(i).getDescription());
                        this.mControllerCompat.addQueueItem(MediaUtils.createMediaDescriptionCompat(str), i);
                        return createFutureWithResult(0);
                    }
                }
                ListenableFuture<SessionResult> createFutureWithResult2 = createFutureWithResult(-3);
                return createFutureWithResult2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ListenableFuture<SessionResult> rewind() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    ListenableFuture<SessionResult> createFutureWithResult = createFutureWithResult(-100);
                    return createFutureWithResult;
                }
                this.mControllerCompat.getTransportControls().rewind();
                return createFutureWithResult(0);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public ListenableFuture<SessionResult> seekTo(long j) {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    ListenableFuture<SessionResult> createFutureWithResult = createFutureWithResult(-100);
                    return createFutureWithResult;
                }
                this.mControllerCompat.getTransportControls().seekTo(j);
                return createFutureWithResult(0);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    @NonNull
    public ListenableFuture<SessionResult> selectTrack(@NonNull SessionPlayer.TrackInfo trackInfo) {
        Log.w(TAG, "Session doesn't support selecting track");
        return createFutureWithResult(-6);
    }

    public ListenableFuture<SessionResult> sendCustomCommand(@NonNull SessionCommand sessionCommand, @Nullable Bundle bundle) {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    ListenableFuture<SessionResult> createFutureWithResult = createFutureWithResult(-100);
                    return createFutureWithResult;
                } else if (this.mAllowedCommands.hasCommand(sessionCommand)) {
                    this.mControllerCompat.getTransportControls().sendCustomAction(sessionCommand.getCustomAction(), bundle);
                    ListenableFuture<SessionResult> createFutureWithResult2 = createFutureWithResult(0);
                    return createFutureWithResult2;
                } else {
                    final ResolvableFuture create = ResolvableFuture.create();
                    this.mControllerCompat.sendCommand(sessionCommand.getCustomAction(), bundle, new ResultReceiver(this.mHandler) {
                        public void onReceiveResult(int i, Bundle bundle) {
                            create.set(new SessionResult(i, bundle));
                        }
                    });
                    return create;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setCurrentMediaItemLocked(MediaMetadataCompat mediaMetadataCompat) {
        this.mMediaMetadataCompat = mediaMetadataCompat;
        if (mediaMetadataCompat == null) {
            this.mCurrentMediaItemIndex = -1;
            this.mCurrentMediaItem = null;
        } else if (this.mQueue == null) {
            this.mCurrentMediaItemIndex = -1;
            this.mCurrentMediaItem = MediaUtils.convertToMediaItem(mediaMetadataCompat);
        } else {
            PlaybackStateCompat playbackStateCompat = this.mPlaybackStateCompat;
            if (playbackStateCompat != null) {
                long activeQueueItemId = playbackStateCompat.getActiveQueueItemId();
                for (int i = 0; i < this.mQueue.size(); i++) {
                    if (this.mQueue.get(i).getQueueId() == activeQueueItemId) {
                        this.mCurrentMediaItem = MediaUtils.convertToMediaItem(mediaMetadataCompat);
                        this.mCurrentMediaItemIndex = i;
                        return;
                    }
                }
            }
            String string = mediaMetadataCompat.getString("android.media.metadata.MEDIA_ID");
            if (string == null) {
                this.mCurrentMediaItemIndex = -1;
                this.mCurrentMediaItem = MediaUtils.convertToMediaItem(mediaMetadataCompat);
                return;
            }
            int i2 = this.mSkipToPlaylistIndex;
            if (i2 < 0 || i2 >= this.mQueue.size() || !TextUtils.equals(string, this.mQueue.get(this.mSkipToPlaylistIndex).getDescription().getMediaId())) {
                for (int i3 = 0; i3 < this.mQueue.size(); i3++) {
                    if (TextUtils.equals(string, this.mQueue.get(i3).getDescription().getMediaId())) {
                        this.mCurrentMediaItemIndex = i3;
                        this.mCurrentMediaItem = MediaUtils.convertToMediaItem(mediaMetadataCompat);
                        return;
                    }
                }
                this.mCurrentMediaItemIndex = -1;
                this.mCurrentMediaItem = MediaUtils.convertToMediaItem(this.mMediaMetadataCompat);
                return;
            }
            this.mCurrentMediaItem = MediaUtils.convertToMediaItem(mediaMetadataCompat);
            this.mCurrentMediaItemIndex = this.mSkipToPlaylistIndex;
            this.mSkipToPlaylistIndex = -1;
        }
    }

    public ListenableFuture<SessionResult> setMediaItem(@NonNull String str) {
        return createFutureWithResult(-6);
    }

    public ListenableFuture<SessionResult> setMediaUri(@NonNull Uri uri, @Nullable Bundle bundle) {
        return createFutureWithResult(-6);
    }

    public ListenableFuture<SessionResult> setPlaybackSpeed(float f) {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    ListenableFuture<SessionResult> createFutureWithResult = createFutureWithResult(-100);
                    return createFutureWithResult;
                }
                this.mControllerCompat.getTransportControls().setPlaybackSpeed(f);
                return createFutureWithResult(0);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public ListenableFuture<SessionResult> setPlaylist(@NonNull List<String> list, @Nullable MediaMetadata mediaMetadata) {
        return createFutureWithResult(-6);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
        return createFutureWithResult(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.common.util.concurrent.ListenableFuture<androidx.media2.session.SessionResult> setRating(@androidx.annotation.NonNull java.lang.String r3, @androidx.annotation.NonNull androidx.media2.common.Rating r4) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.mLock
            monitor-enter(r0)
            boolean r1 = r2.mConnected     // Catch:{ all -> 0x001b }
            if (r1 != 0) goto L_0x001d
            java.lang.String r3 = "MC2ImplLegacy"
            java.lang.String r4 = "Session isn't active"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x001b }
            r1.<init>()     // Catch:{ all -> 0x001b }
            android.util.Log.w(r3, r4, r1)     // Catch:{ all -> 0x001b }
            r3 = -100
            com.google.common.util.concurrent.ListenableFuture r3 = r2.createFutureWithResult(r3)     // Catch:{ all -> 0x001b }
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            return r3
        L_0x001b:
            r3 = move-exception
            goto L_0x003f
        L_0x001d:
            androidx.media2.common.MediaItem r1 = r2.mCurrentMediaItem     // Catch:{ all -> 0x001b }
            if (r1 == 0) goto L_0x0038
            java.lang.String r1 = r1.getMediaId()     // Catch:{ all -> 0x001b }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x001b }
            if (r3 == 0) goto L_0x0038
            android.support.v4.media.session.MediaControllerCompat r3 = r2.mControllerCompat     // Catch:{ all -> 0x001b }
            android.support.v4.media.session.MediaControllerCompat$TransportControls r3 = r3.getTransportControls()     // Catch:{ all -> 0x001b }
            android.support.v4.media.RatingCompat r4 = androidx.media2.session.MediaUtils.convertToRatingCompat(r4)     // Catch:{ all -> 0x001b }
            r3.setRating(r4)     // Catch:{ all -> 0x001b }
        L_0x0038:
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            r3 = 0
            com.google.common.util.concurrent.ListenableFuture r3 = r2.createFutureWithResult(r3)
            return r3
        L_0x003f:
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.session.MediaControllerImplLegacy.setRating(java.lang.String, androidx.media2.common.Rating):com.google.common.util.concurrent.ListenableFuture");
    }

    public ListenableFuture<SessionResult> setRepeatMode(int i) {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    ListenableFuture<SessionResult> createFutureWithResult = createFutureWithResult(-100);
                    return createFutureWithResult;
                }
                this.mControllerCompat.getTransportControls().setRepeatMode(i);
                return createFutureWithResult(0);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public ListenableFuture<SessionResult> setShuffleMode(int i) {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    ListenableFuture<SessionResult> createFutureWithResult = createFutureWithResult(-100);
                    return createFutureWithResult;
                }
                this.mControllerCompat.getTransportControls().setShuffleMode(i);
                return createFutureWithResult(0);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public ListenableFuture<SessionResult> setSurface(@Nullable Surface surface) {
        Log.w(TAG, "Session doesn't support setting Surface");
        return createFutureWithResult(-6);
    }

    public ListenableFuture<SessionResult> setVolumeTo(int i, int i2) {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    ListenableFuture<SessionResult> createFutureWithResult = createFutureWithResult(-100);
                    return createFutureWithResult;
                }
                this.mControllerCompat.setVolumeTo(i, i2);
                return createFutureWithResult(0);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public ListenableFuture<SessionResult> skipBackward() {
        return createFutureWithResult(-6);
    }

    public ListenableFuture<SessionResult> skipForward() {
        return createFutureWithResult(-6);
    }

    public ListenableFuture<SessionResult> skipToNextItem() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    ListenableFuture<SessionResult> createFutureWithResult = createFutureWithResult(-100);
                    return createFutureWithResult;
                }
                this.mControllerCompat.getTransportControls().skipToNext();
                return createFutureWithResult(0);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public ListenableFuture<SessionResult> skipToPlaylistItem(int i) {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    ListenableFuture<SessionResult> createFutureWithResult = createFutureWithResult(-100);
                    return createFutureWithResult;
                }
                this.mSkipToPlaylistIndex = i;
                this.mControllerCompat.getTransportControls().skipToQueueItem(this.mQueue.get(i).getQueueId());
                return createFutureWithResult(0);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public ListenableFuture<SessionResult> skipToPreviousItem() {
        synchronized (this.mLock) {
            try {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    ListenableFuture<SessionResult> createFutureWithResult = createFutureWithResult(-100);
                    return createFutureWithResult;
                }
                this.mControllerCompat.getTransportControls().skipToPrevious();
                return createFutureWithResult(0);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public ListenableFuture<SessionResult> updatePlaylistMetadata(@Nullable MediaMetadata mediaMetadata) {
        return createFutureWithResult(-6);
    }
}
