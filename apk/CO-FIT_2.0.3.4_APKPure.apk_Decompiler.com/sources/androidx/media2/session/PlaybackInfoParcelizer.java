package androidx.media2.session;

import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesCompat;
import androidx.media2.session.MediaController;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class PlaybackInfoParcelizer {
    public static MediaController.PlaybackInfo read(VersionedParcel versionedParcel) {
        MediaController.PlaybackInfo playbackInfo = new MediaController.PlaybackInfo();
        playbackInfo.mPlaybackType = versionedParcel.readInt(playbackInfo.mPlaybackType, 1);
        playbackInfo.mControlType = versionedParcel.readInt(playbackInfo.mControlType, 2);
        playbackInfo.mMaxVolume = versionedParcel.readInt(playbackInfo.mMaxVolume, 3);
        playbackInfo.mCurrentVolume = versionedParcel.readInt(playbackInfo.mCurrentVolume, 4);
        playbackInfo.mAudioAttrsCompat = (AudioAttributesCompat) versionedParcel.readVersionedParcelable(playbackInfo.mAudioAttrsCompat, 5);
        return playbackInfo;
    }

    public static void write(MediaController.PlaybackInfo playbackInfo, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeInt(playbackInfo.mPlaybackType, 1);
        versionedParcel.writeInt(playbackInfo.mControlType, 2);
        versionedParcel.writeInt(playbackInfo.mMaxVolume, 3);
        versionedParcel.writeInt(playbackInfo.mCurrentVolume, 4);
        versionedParcel.writeVersionedParcelable(playbackInfo.mAudioAttrsCompat, 5);
    }
}
