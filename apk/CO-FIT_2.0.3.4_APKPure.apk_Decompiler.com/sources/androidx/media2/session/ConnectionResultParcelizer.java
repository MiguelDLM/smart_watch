package androidx.media2.session;

import android.app.PendingIntent;
import androidx.annotation.RestrictTo;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.ParcelImplListSlice;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class ConnectionResultParcelizer {
    public static ConnectionResult read(VersionedParcel versionedParcel) {
        ConnectionResult connectionResult = new ConnectionResult();
        connectionResult.mVersion = versionedParcel.readInt(connectionResult.mVersion, 0);
        connectionResult.mSessionBinder = versionedParcel.readStrongBinder(connectionResult.mSessionBinder, 1);
        connectionResult.mRepeatMode = versionedParcel.readInt(connectionResult.mRepeatMode, 10);
        connectionResult.mShuffleMode = versionedParcel.readInt(connectionResult.mShuffleMode, 11);
        connectionResult.mPlaylistSlice = (ParcelImplListSlice) versionedParcel.readParcelable(connectionResult.mPlaylistSlice, 12);
        connectionResult.mAllowedCommands = (SessionCommandGroup) versionedParcel.readVersionedParcelable(connectionResult.mAllowedCommands, 13);
        connectionResult.mCurrentMediaItemIndex = versionedParcel.readInt(connectionResult.mCurrentMediaItemIndex, 14);
        connectionResult.mPreviousMediaItemIndex = versionedParcel.readInt(connectionResult.mPreviousMediaItemIndex, 15);
        connectionResult.mNextMediaItemIndex = versionedParcel.readInt(connectionResult.mNextMediaItemIndex, 16);
        connectionResult.mTokenExtras = versionedParcel.readBundle(connectionResult.mTokenExtras, 17);
        connectionResult.mVideoSize = (VideoSize) versionedParcel.readVersionedParcelable(connectionResult.mVideoSize, 18);
        connectionResult.mTracks = versionedParcel.readList(connectionResult.mTracks, 19);
        connectionResult.mSessionActivity = (PendingIntent) versionedParcel.readParcelable(connectionResult.mSessionActivity, 2);
        connectionResult.mSelectedVideoTrack = (SessionPlayer.TrackInfo) versionedParcel.readVersionedParcelable(connectionResult.mSelectedVideoTrack, 20);
        connectionResult.mSelectedAudioTrack = (SessionPlayer.TrackInfo) versionedParcel.readVersionedParcelable(connectionResult.mSelectedAudioTrack, 21);
        connectionResult.mSelectedSubtitleTrack = (SessionPlayer.TrackInfo) versionedParcel.readVersionedParcelable(connectionResult.mSelectedSubtitleTrack, 23);
        connectionResult.mSelectedMetadataTrack = (SessionPlayer.TrackInfo) versionedParcel.readVersionedParcelable(connectionResult.mSelectedMetadataTrack, 24);
        connectionResult.mPlaylistMetadata = (MediaMetadata) versionedParcel.readVersionedParcelable(connectionResult.mPlaylistMetadata, 25);
        connectionResult.mBufferingState = versionedParcel.readInt(connectionResult.mBufferingState, 26);
        connectionResult.mPlayerState = versionedParcel.readInt(connectionResult.mPlayerState, 3);
        connectionResult.mParcelableCurrentMediaItem = (MediaItem) versionedParcel.readVersionedParcelable(connectionResult.mParcelableCurrentMediaItem, 4);
        connectionResult.mPositionEventTimeMs = versionedParcel.readLong(connectionResult.mPositionEventTimeMs, 5);
        connectionResult.mPositionMs = versionedParcel.readLong(connectionResult.mPositionMs, 6);
        connectionResult.mPlaybackSpeed = versionedParcel.readFloat(connectionResult.mPlaybackSpeed, 7);
        connectionResult.mBufferedPositionMs = versionedParcel.readLong(connectionResult.mBufferedPositionMs, 8);
        connectionResult.mPlaybackInfo = (MediaController.PlaybackInfo) versionedParcel.readVersionedParcelable(connectionResult.mPlaybackInfo, 9);
        connectionResult.onPostParceling();
        return connectionResult;
    }

    public static void write(ConnectionResult connectionResult, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        connectionResult.onPreParceling(versionedParcel.isStream());
        versionedParcel.writeInt(connectionResult.mVersion, 0);
        versionedParcel.writeStrongBinder(connectionResult.mSessionBinder, 1);
        versionedParcel.writeInt(connectionResult.mRepeatMode, 10);
        versionedParcel.writeInt(connectionResult.mShuffleMode, 11);
        versionedParcel.writeParcelable(connectionResult.mPlaylistSlice, 12);
        versionedParcel.writeVersionedParcelable(connectionResult.mAllowedCommands, 13);
        versionedParcel.writeInt(connectionResult.mCurrentMediaItemIndex, 14);
        versionedParcel.writeInt(connectionResult.mPreviousMediaItemIndex, 15);
        versionedParcel.writeInt(connectionResult.mNextMediaItemIndex, 16);
        versionedParcel.writeBundle(connectionResult.mTokenExtras, 17);
        versionedParcel.writeVersionedParcelable(connectionResult.mVideoSize, 18);
        versionedParcel.writeList(connectionResult.mTracks, 19);
        versionedParcel.writeParcelable(connectionResult.mSessionActivity, 2);
        versionedParcel.writeVersionedParcelable(connectionResult.mSelectedVideoTrack, 20);
        versionedParcel.writeVersionedParcelable(connectionResult.mSelectedAudioTrack, 21);
        versionedParcel.writeVersionedParcelable(connectionResult.mSelectedSubtitleTrack, 23);
        versionedParcel.writeVersionedParcelable(connectionResult.mSelectedMetadataTrack, 24);
        versionedParcel.writeVersionedParcelable(connectionResult.mPlaylistMetadata, 25);
        versionedParcel.writeInt(connectionResult.mBufferingState, 26);
        versionedParcel.writeInt(connectionResult.mPlayerState, 3);
        versionedParcel.writeVersionedParcelable(connectionResult.mParcelableCurrentMediaItem, 4);
        versionedParcel.writeLong(connectionResult.mPositionEventTimeMs, 5);
        versionedParcel.writeLong(connectionResult.mPositionMs, 6);
        versionedParcel.writeFloat(connectionResult.mPlaybackSpeed, 7);
        versionedParcel.writeLong(connectionResult.mBufferedPositionMs, 8);
        versionedParcel.writeVersionedParcelable(connectionResult.mPlaybackInfo, 9);
    }
}
