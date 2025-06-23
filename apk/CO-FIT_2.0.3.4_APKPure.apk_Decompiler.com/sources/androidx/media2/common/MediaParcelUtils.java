package androidx.media2.common;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.ParcelImpl;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MediaParcelUtils {
    public static final String TAG = "MediaParcelUtils";

    @SuppressLint({"RestrictedApi"})
    public static class MediaItemParcelImpl extends ParcelImpl {
        private final MediaItem mItem;

        public MediaItemParcelImpl(MediaItem mediaItem) {
            super((VersionedParcelable) new MediaItem(mediaItem));
            this.mItem = mediaItem;
        }

        public MediaItem getVersionedParcel() {
            return this.mItem;
        }
    }

    private MediaParcelUtils() {
    }

    @Nullable
    public static <T extends VersionedParcelable> T fromParcelable(@NonNull ParcelImpl parcelImpl) {
        return ParcelUtils.fromParcelable(parcelImpl);
    }

    @NonNull
    public static <T extends VersionedParcelable> List<T> fromParcelableList(@NonNull List<ParcelImpl> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(fromParcelable(list.get(i)));
        }
        return arrayList;
    }

    @NonNull
    public static ParcelImpl toParcelable(@Nullable VersionedParcelable versionedParcelable) {
        if (versionedParcelable instanceof MediaItem) {
            return new MediaItemParcelImpl((MediaItem) versionedParcelable);
        }
        return (ParcelImpl) ParcelUtils.toParcelable(versionedParcelable);
    }

    @NonNull
    public static List<ParcelImpl> toParcelableList(@NonNull List<? extends VersionedParcelable> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(toParcelable((VersionedParcelable) list.get(i)));
        }
        return arrayList;
    }
}
