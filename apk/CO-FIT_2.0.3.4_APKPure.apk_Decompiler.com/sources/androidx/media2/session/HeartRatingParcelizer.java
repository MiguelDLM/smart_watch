package androidx.media2.session;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class HeartRatingParcelizer {
    public static HeartRating read(VersionedParcel versionedParcel) {
        HeartRating heartRating = new HeartRating();
        heartRating.mIsRated = versionedParcel.readBoolean(heartRating.mIsRated, 1);
        heartRating.mHasHeart = versionedParcel.readBoolean(heartRating.mHasHeart, 2);
        return heartRating;
    }

    public static void write(HeartRating heartRating, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeBoolean(heartRating.mIsRated, 1);
        versionedParcel.writeBoolean(heartRating.mHasHeart, 2);
    }
}
