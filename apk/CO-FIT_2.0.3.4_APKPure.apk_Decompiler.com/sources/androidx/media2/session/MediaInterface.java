package androidx.media2.session;

import android.view.Surface;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.VideoSize;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

class MediaInterface {

    public interface SessionPlaybackControl {
        long getBufferedPosition();

        int getBufferingState();

        long getCurrentPosition();

        long getDuration();

        float getPlaybackSpeed();

        int getPlayerState();

        ListenableFuture<SessionPlayer.PlayerResult> pause();

        ListenableFuture<SessionPlayer.PlayerResult> play();

        ListenableFuture<SessionPlayer.PlayerResult> prepare();

        ListenableFuture<SessionPlayer.PlayerResult> seekTo(long j);

        ListenableFuture<SessionPlayer.PlayerResult> setPlaybackSpeed(float f);
    }

    public interface SessionPlayer extends SessionPlaybackControl, SessionPlaylistControl {
        ListenableFuture<SessionPlayer.PlayerResult> deselectTrack(SessionPlayer.TrackInfo trackInfo);

        SessionPlayer.TrackInfo getSelectedTrack(int i);

        List<SessionPlayer.TrackInfo> getTracks();

        VideoSize getVideoSize();

        ListenableFuture<SessionPlayer.PlayerResult> selectTrack(SessionPlayer.TrackInfo trackInfo);

        ListenableFuture<SessionPlayer.PlayerResult> setSurface(Surface surface);
    }

    public interface SessionPlaylistControl {
        ListenableFuture<SessionPlayer.PlayerResult> addPlaylistItem(int i, MediaItem mediaItem);

        MediaItem getCurrentMediaItem();

        int getCurrentMediaItemIndex();

        int getNextMediaItemIndex();

        List<MediaItem> getPlaylist();

        MediaMetadata getPlaylistMetadata();

        int getPreviousMediaItemIndex();

        int getRepeatMode();

        int getShuffleMode();

        ListenableFuture<SessionPlayer.PlayerResult> movePlaylistItem(int i, int i2);

        ListenableFuture<SessionPlayer.PlayerResult> removePlaylistItem(int i);

        ListenableFuture<SessionPlayer.PlayerResult> replacePlaylistItem(int i, MediaItem mediaItem);

        ListenableFuture<SessionPlayer.PlayerResult> setMediaItem(MediaItem mediaItem);

        ListenableFuture<SessionPlayer.PlayerResult> setPlaylist(List<MediaItem> list, MediaMetadata mediaMetadata);

        ListenableFuture<SessionPlayer.PlayerResult> setRepeatMode(int i);

        ListenableFuture<SessionPlayer.PlayerResult> setShuffleMode(int i);

        ListenableFuture<SessionPlayer.PlayerResult> skipToNextItem();

        ListenableFuture<SessionPlayer.PlayerResult> skipToPlaylistItem(int i);

        ListenableFuture<SessionPlayer.PlayerResult> skipToPreviousItem();

        ListenableFuture<SessionPlayer.PlayerResult> updatePlaylistMetadata(MediaMetadata mediaMetadata);
    }

    private MediaInterface() {
    }
}
