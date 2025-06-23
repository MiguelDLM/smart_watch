package androidx.media2.session;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class ThumbRatingParcelizer {
    public static ThumbRating read(VersionedParcel versionedParcel) {
        ThumbRating thumbRating = new ThumbRating();
        thumbRating.mIsRated = versionedParcel.readBoolean(thumbRating.mIsRated, 1);
        thumbRating.mThumbUp = versionedParcel.readBoolean(thumbRating.mThumbUp, 2);
        return thumbRating;
    }

    public static void write(ThumbRating thumbRating, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeBoolean(thumbRating.mIsRated, 1);
        versionedParcel.writeBoolean(thumbRating.mThumbUp, 2);
    }
}
