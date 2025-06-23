package androidx.media2.session;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.ParcelImplListSlice;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.VideoSize;
import androidx.media2.session.IMediaSession;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaSession;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
class ConnectionResult extends CustomVersionedParcelable {
    SessionCommandGroup mAllowedCommands;
    long mBufferedPositionMs;
    int mBufferingState;
    MediaItem mCurrentMediaItem;
    int mCurrentMediaItemIndex;
    int mNextMediaItemIndex;
    MediaItem mParcelableCurrentMediaItem;
    MediaController.PlaybackInfo mPlaybackInfo;
    float mPlaybackSpeed;
    int mPlayerState;
    MediaMetadata mPlaylistMetadata;
    ParcelImplListSlice mPlaylistSlice;
    long mPositionEventTimeMs;
    long mPositionMs;
    int mPreviousMediaItemIndex;
    int mRepeatMode;
    SessionPlayer.TrackInfo mSelectedAudioTrack;
    SessionPlayer.TrackInfo mSelectedMetadataTrack;
    SessionPlayer.TrackInfo mSelectedSubtitleTrack;
    SessionPlayer.TrackInfo mSelectedVideoTrack;
    PendingIntent mSessionActivity;
    IBinder mSessionBinder;
    IMediaSession mSessionStub;
    int mShuffleMode;
    Bundle mTokenExtras;
    List<SessionPlayer.TrackInfo> mTracks;
    int mVersion;
    VideoSize mVideoSize;

    public ConnectionResult() {
    }

    public SessionCommandGroup getAllowedCommands() {
        return this.mAllowedCommands;
    }

    public long getBufferedPositionMs() {
        return this.mBufferedPositionMs;
    }

    public int getBufferingState() {
        return this.mBufferingState;
    }

    public MediaItem getCurrentMediaItem() {
        return this.mCurrentMediaItem;
    }

    public int getCurrentMediaItemIndex() {
        return this.mCurrentMediaItemIndex;
    }

    public int getNextMediaItemIndex() {
        return this.mNextMediaItemIndex;
    }

    public MediaController.PlaybackInfo getPlaybackInfo() {
        return this.mPlaybackInfo;
    }

    public float getPlaybackSpeed() {
        return this.mPlaybackSpeed;
    }

    public int getPlayerState() {
        return this.mPlayerState;
    }

    @Nullable
    public MediaMetadata getPlaylistMetadata() {
        return this.mPlaylistMetadata;
    }

    public ParcelImplListSlice getPlaylistSlice() {
        return this.mPlaylistSlice;
    }

    public long getPositionEventTimeMs() {
        return this.mPositionEventTimeMs;
    }

    public long getPositionMs() {
        return this.mPositionMs;
    }

    public int getPreviousMediaItemIndex() {
        return this.mPreviousMediaItemIndex;
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public SessionPlayer.TrackInfo getSelectedAudioTrack() {
        return this.mSelectedAudioTrack;
    }

    public SessionPlayer.TrackInfo getSelectedMetadataTrack() {
        return this.mSelectedMetadataTrack;
    }

    public SessionPlayer.TrackInfo getSelectedSubtitleTrack() {
        return this.mSelectedSubtitleTrack;
    }

    public SessionPlayer.TrackInfo getSelectedVideoTrack() {
        return this.mSelectedVideoTrack;
    }

    public PendingIntent getSessionActivity() {
        return this.mSessionActivity;
    }

    public IMediaSession getSessionStub() {
        return this.mSessionStub;
    }

    public int getShuffleMode() {
        return this.mShuffleMode;
    }

    public Bundle getTokenExtras() {
        return this.mTokenExtras;
    }

    @NonNull
    public List<SessionPlayer.TrackInfo> getTracks() {
        List<SessionPlayer.TrackInfo> list = this.mTracks;
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public VideoSize getVideoSize() {
        return this.mVideoSize;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPostParceling() {
        this.mSessionStub = IMediaSession.Stub.asInterface(this.mSessionBinder);
        this.mCurrentMediaItem = this.mParcelableCurrentMediaItem;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPreParceling(boolean z) {
        synchronized (this.mSessionStub) {
            try {
                if (this.mSessionBinder == null) {
                    this.mSessionBinder = (IBinder) this.mSessionStub;
                    this.mParcelableCurrentMediaItem = MediaUtils.upcastForPreparceling(this.mCurrentMediaItem);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ConnectionResult(@NonNull MediaSessionStub mediaSessionStub, @NonNull MediaSession.MediaSessionImpl mediaSessionImpl, @NonNull SessionCommandGroup sessionCommandGroup) {
        this.mSessionStub = mediaSessionStub;
        this.mPlayerState = mediaSessionImpl.getPlayerState();
        this.mCurrentMediaItem = mediaSessionImpl.getCurrentMediaItem();
        this.mPositionEventTimeMs = SystemClock.elapsedRealtime();
        this.mPositionMs = mediaSessionImpl.getCurrentPosition();
        this.mPlaybackSpeed = mediaSessionImpl.getPlaybackSpeed();
        this.mBufferedPositionMs = mediaSessionImpl.getBufferedPosition();
        this.mPlaybackInfo = mediaSessionImpl.getPlaybackInfo();
        this.mRepeatMode = mediaSessionImpl.getRepeatMode();
        this.mShuffleMode = mediaSessionImpl.getShuffleMode();
        this.mSessionActivity = mediaSessionImpl.getSessionActivity();
        this.mCurrentMediaItemIndex = mediaSessionImpl.getCurrentMediaItemIndex();
        this.mPreviousMediaItemIndex = mediaSessionImpl.getPreviousMediaItemIndex();
        this.mNextMediaItemIndex = mediaSessionImpl.getNextMediaItemIndex();
        this.mTokenExtras = mediaSessionImpl.getToken().getExtras();
        this.mVideoSize = mediaSessionImpl.getVideoSize();
        this.mTracks = mediaSessionImpl.getTracks();
        this.mSelectedVideoTrack = mediaSessionImpl.getSelectedTrack(1);
        this.mSelectedAudioTrack = mediaSessionImpl.getSelectedTrack(2);
        this.mSelectedSubtitleTrack = mediaSessionImpl.getSelectedTrack(4);
        this.mSelectedMetadataTrack = mediaSessionImpl.getSelectedTrack(5);
        if (sessionCommandGroup.hasCommand(10005)) {
            this.mPlaylistSlice = MediaUtils.convertMediaItemListToParcelImplListSlice(mediaSessionImpl.getPlaylist());
        } else {
            this.mPlaylistSlice = null;
        }
        if (!sessionCommandGroup.hasCommand(10005) && !sessionCommandGroup.hasCommand(SessionCommand.COMMAND_CODE_PLAYER_GET_PLAYLIST_METADATA)) {
            this.mPlaylistMetadata = null;
        } else {
            this.mPlaylistMetadata = mediaSessionImpl.getPlaylistMetadata();
        }
        this.mBufferingState = mediaSessionImpl.getBufferingState();
        this.mAllowedCommands = sessionCommandGroup;
        this.mVersion = 0;
    }
}
