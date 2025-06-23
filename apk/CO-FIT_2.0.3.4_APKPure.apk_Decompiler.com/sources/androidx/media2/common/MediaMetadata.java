package androidx.media2.common;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.versionedparcelable.CustomVersionedParcelable;
import androidx.versionedparcelable.ParcelImpl;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class MediaMetadata extends CustomVersionedParcelable {
    public static final long BROWSABLE_TYPE_ALBUMS = 2;
    public static final long BROWSABLE_TYPE_ARTISTS = 3;
    public static final long BROWSABLE_TYPE_GENRES = 4;
    public static final long BROWSABLE_TYPE_MIXED = 0;
    public static final long BROWSABLE_TYPE_NONE = -1;
    public static final long BROWSABLE_TYPE_PLAYLISTS = 5;
    public static final long BROWSABLE_TYPE_TITLES = 1;
    public static final long BROWSABLE_TYPE_YEARS = 6;
    static final ArrayMap<String, Integer> METADATA_KEYS_TYPE;
    public static final String METADATA_KEY_ADVERTISEMENT = "androidx.media2.metadata.ADVERTISEMENT";
    public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final String METADATA_KEY_BROWSABLE = "androidx.media2.metadata.BROWSABLE";
    public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final String METADATA_KEY_DOWNLOAD_STATUS = "androidx.media2.metadata.DOWNLOAD_STATUS";
    public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final String METADATA_KEY_EXTRAS = "androidx.media2.metadata.EXTRAS";
    public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
    public static final String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
    public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final String METADATA_KEY_PLAYABLE = "androidx.media2.metadata.PLAYABLE";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String METADATA_KEY_RADIO_FREQUENCY = "androidx.media2.metadata.RADIO_FREQUENCY";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String METADATA_KEY_RADIO_PROGRAM_NAME = "androidx.media2.metadata.RADIO_PROGRAM_NAME";
    public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
    static final int METADATA_TYPE_BITMAP = 2;
    static final int METADATA_TYPE_BUNDLE = 5;
    static final int METADATA_TYPE_FLOAT = 4;
    static final int METADATA_TYPE_LONG = 0;
    static final int METADATA_TYPE_RATING = 3;
    static final int METADATA_TYPE_TEXT = 1;
    public static final long STATUS_DOWNLOADED = 2;
    public static final long STATUS_DOWNLOADING = 1;
    public static final long STATUS_NOT_DOWNLOADED = 0;
    private static final String TAG = "MediaMetadata";
    ParcelImplListSlice mBitmapListSlice;
    Bundle mBundle;
    Bundle mParcelableWithoutBitmapBundle;

    public static final class BitmapEntry implements VersionedParcelable {
        static final int BITMAP_SIZE_LIMIT_IN_BYTES = 262144;
        Bitmap mBitmap;
        String mKey;

        public BitmapEntry() {
        }

        private int getBitmapSizeInBytes(Bitmap bitmap) {
            return bitmap.getAllocationByteCount();
        }

        public Bitmap getBitmap() {
            return this.mBitmap;
        }

        public String getKey() {
            return this.mKey;
        }

        public BitmapEntry(@NonNull String str, @NonNull Bitmap bitmap) {
            this.mKey = str;
            this.mBitmap = bitmap;
            int bitmapSizeInBytes = getBitmapSizeInBytes(bitmap);
            if (bitmapSizeInBytes > 262144) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                double sqrt = Math.sqrt(262144.0d / ((double) bitmapSizeInBytes));
                int i = (int) (((double) width) * sqrt);
                int i2 = (int) (((double) height) * sqrt);
                Log.i(MediaMetadata.TAG, "Scaling large bitmap of " + width + "x" + height + " into " + i + "x" + i2);
                this.mBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface BitmapKey {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface BundleKey {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FloatKey {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LongKey {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface RatingKey {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TextKey {
    }

    static {
        ArrayMap<String, Integer> arrayMap = new ArrayMap<>();
        METADATA_KEYS_TYPE = arrayMap;
        arrayMap.put("android.media.metadata.TITLE", 1);
        arrayMap.put("android.media.metadata.ARTIST", 1);
        arrayMap.put("android.media.metadata.DURATION", 0);
        arrayMap.put("android.media.metadata.ALBUM", 1);
        arrayMap.put("android.media.metadata.AUTHOR", 1);
        arrayMap.put("android.media.metadata.WRITER", 1);
        arrayMap.put("android.media.metadata.COMPOSER", 1);
        arrayMap.put("android.media.metadata.COMPILATION", 1);
        arrayMap.put("android.media.metadata.DATE", 1);
        arrayMap.put("android.media.metadata.YEAR", 0);
        arrayMap.put("android.media.metadata.GENRE", 1);
        arrayMap.put("android.media.metadata.TRACK_NUMBER", 0);
        arrayMap.put("android.media.metadata.NUM_TRACKS", 0);
        arrayMap.put("android.media.metadata.DISC_NUMBER", 0);
        arrayMap.put("android.media.metadata.ALBUM_ARTIST", 1);
        arrayMap.put("android.media.metadata.ART", 2);
        arrayMap.put("android.media.metadata.ART_URI", 1);
        arrayMap.put("android.media.metadata.ALBUM_ART", 2);
        arrayMap.put("android.media.metadata.ALBUM_ART_URI", 1);
        arrayMap.put("android.media.metadata.USER_RATING", 3);
        arrayMap.put("android.media.metadata.RATING", 3);
        arrayMap.put("android.media.metadata.DISPLAY_TITLE", 1);
        arrayMap.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        arrayMap.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        arrayMap.put("android.media.metadata.DISPLAY_ICON", 2);
        arrayMap.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        arrayMap.put("android.media.metadata.MEDIA_ID", 1);
        arrayMap.put("android.media.metadata.MEDIA_URI", 1);
        arrayMap.put(METADATA_KEY_RADIO_FREQUENCY, 4);
        arrayMap.put(METADATA_KEY_RADIO_PROGRAM_NAME, 1);
        arrayMap.put(METADATA_KEY_BROWSABLE, 0);
        arrayMap.put(METADATA_KEY_PLAYABLE, 0);
        arrayMap.put(METADATA_KEY_ADVERTISEMENT, 0);
        arrayMap.put(METADATA_KEY_DOWNLOAD_STATUS, 0);
        arrayMap.put(METADATA_KEY_EXTRAS, 5);
    }

    public MediaMetadata() {
    }

    public boolean containsKey(@NonNull String str) {
        if (str != null) {
            return this.mBundle.containsKey(str);
        }
        throw new NullPointerException("key shouldn't be null");
    }

    @Nullable
    public Bitmap getBitmap(@NonNull String str) {
        if (str != null) {
            try {
                return (Bitmap) this.mBundle.getParcelable(str);
            } catch (Exception e) {
                Log.w(TAG, "Failed to retrieve a key as Bitmap.", e);
                return null;
            }
        } else {
            throw new NullPointerException("key shouldn't be null");
        }
    }

    @Nullable
    public Bundle getExtras() {
        try {
            return this.mBundle.getBundle(METADATA_KEY_EXTRAS);
        } catch (Exception unused) {
            Log.w(TAG, "Failed to retrieve an extra");
            return null;
        }
    }

    public float getFloat(@NonNull String str) {
        if (str != null) {
            return this.mBundle.getFloat(str);
        }
        throw new NullPointerException("key shouldn't be null");
    }

    public long getLong(@NonNull String str) {
        if (str != null) {
            return this.mBundle.getLong(str, 0);
        }
        throw new NullPointerException("key shouldn't be null");
    }

    @Nullable
    public String getMediaId() {
        return getString("android.media.metadata.MEDIA_ID");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Object getObject(@NonNull String str) {
        if (str != null) {
            return this.mBundle.get(str);
        }
        throw new NullPointerException("key shouldn't be null");
    }

    @Nullable
    public Rating getRating(@NonNull String str) {
        if (str != null) {
            try {
                return (Rating) ParcelUtils.getVersionedParcelable(this.mBundle, str);
            } catch (Exception e) {
                Log.w(TAG, "Failed to retrieve a key as Rating.", e);
                return null;
            }
        } else {
            throw new NullPointerException("key shouldn't be null");
        }
    }

    @Nullable
    public String getString(@NonNull String str) {
        if (str != null) {
            CharSequence charSequence = this.mBundle.getCharSequence(str);
            if (charSequence != null) {
                return charSequence.toString();
            }
            return null;
        }
        throw new NullPointerException("key shouldn't be null");
    }

    @Nullable
    public CharSequence getText(@NonNull String str) {
        if (str != null) {
            return this.mBundle.getCharSequence(str);
        }
        throw new NullPointerException("key shouldn't be null");
    }

    @NonNull
    public Set<String> keySet() {
        return this.mBundle.keySet();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onPostParceling() {
        Bundle bundle = this.mParcelableWithoutBitmapBundle;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.mBundle = bundle;
        ParcelImplListSlice parcelImplListSlice = this.mBitmapListSlice;
        if (parcelImplListSlice != null) {
            for (ParcelImpl fromParcelable : parcelImplListSlice.getList()) {
                BitmapEntry bitmapEntry = (BitmapEntry) MediaParcelUtils.fromParcelable(fromParcelable);
                this.mBundle.putParcelable(bitmapEntry.getKey(), bitmapEntry.getBitmap());
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onPreParceling(boolean z) {
        synchronized (this.mBundle) {
            try {
                if (this.mParcelableWithoutBitmapBundle == null) {
                    this.mParcelableWithoutBitmapBundle = new Bundle(this.mBundle);
                    ArrayList arrayList = new ArrayList();
                    for (String next : this.mBundle.keySet()) {
                        Object obj = this.mBundle.get(next);
                        if (obj instanceof Bitmap) {
                            arrayList.add(MediaParcelUtils.toParcelable(new BitmapEntry(next, (Bitmap) obj)));
                            this.mParcelableWithoutBitmapBundle.remove(next);
                        }
                    }
                    this.mBitmapListSlice = new ParcelImplListSlice((List<ParcelImpl>) arrayList);
                }
            } finally {
            }
        }
    }

    public int size() {
        return this.mBundle.size();
    }

    public String toString() {
        return this.mBundle.toString();
    }

    public static final class Builder {
        final Bundle mBundle;

        public Builder() {
            this.mBundle = new Bundle();
        }

        @NonNull
        public MediaMetadata build() {
            return new MediaMetadata(this.mBundle);
        }

        @NonNull
        public Builder putBitmap(@NonNull String str, @Nullable Bitmap bitmap) {
            if (str != null) {
                ArrayMap<String, Integer> arrayMap = MediaMetadata.METADATA_KEYS_TYPE;
                if (!arrayMap.containsKey(str) || arrayMap.get(str).intValue() == 2) {
                    this.mBundle.putParcelable(str, bitmap);
                    return this;
                }
                throw new IllegalArgumentException("The " + str + " key cannot be used to put a Bitmap");
            }
            throw new NullPointerException("key shouldn't be null");
        }

        @NonNull
        public Builder putFloat(@NonNull String str, float f) {
            if (str != null) {
                ArrayMap<String, Integer> arrayMap = MediaMetadata.METADATA_KEYS_TYPE;
                if (!arrayMap.containsKey(str) || arrayMap.get(str).intValue() == 4) {
                    this.mBundle.putFloat(str, f);
                    return this;
                }
                throw new IllegalArgumentException("The " + str + " key cannot be used to put a float");
            }
            throw new NullPointerException("key shouldn't be null");
        }

        @NonNull
        public Builder putLong(@NonNull String str, long j) {
            if (str != null) {
                ArrayMap<String, Integer> arrayMap = MediaMetadata.METADATA_KEYS_TYPE;
                if (!arrayMap.containsKey(str) || arrayMap.get(str).intValue() == 0) {
                    this.mBundle.putLong(str, j);
                    return this;
                }
                throw new IllegalArgumentException("The " + str + " key cannot be used to put a long");
            }
            throw new NullPointerException("key shouldn't be null");
        }

        @NonNull
        public Builder putRating(@NonNull String str, @Nullable Rating rating) {
            if (str != null) {
                ArrayMap<String, Integer> arrayMap = MediaMetadata.METADATA_KEYS_TYPE;
                if (!arrayMap.containsKey(str) || arrayMap.get(str).intValue() == 3) {
                    ParcelUtils.putVersionedParcelable(this.mBundle, str, rating);
                    return this;
                }
                throw new IllegalArgumentException("The " + str + " key cannot be used to put a Rating");
            }
            throw new NullPointerException("key shouldn't be null");
        }

        @NonNull
        public Builder putString(@NonNull String str, @Nullable String str2) {
            if (str != null) {
                ArrayMap<String, Integer> arrayMap = MediaMetadata.METADATA_KEYS_TYPE;
                if (!arrayMap.containsKey(str) || arrayMap.get(str).intValue() == 1) {
                    this.mBundle.putCharSequence(str, str2);
                    return this;
                }
                throw new IllegalArgumentException("The " + str + " key cannot be used to put a String");
            }
            throw new NullPointerException("key shouldn't be null");
        }

        @NonNull
        public Builder putText(@NonNull String str, @Nullable CharSequence charSequence) {
            if (str != null) {
                ArrayMap<String, Integer> arrayMap = MediaMetadata.METADATA_KEYS_TYPE;
                if (!arrayMap.containsKey(str) || arrayMap.get(str).intValue() == 1) {
                    this.mBundle.putCharSequence(str, charSequence);
                    return this;
                }
                throw new IllegalArgumentException("The " + str + " key cannot be used to put a CharSequence");
            }
            throw new NullPointerException("key shouldn't be null");
        }

        @NonNull
        public Builder setExtras(@Nullable Bundle bundle) {
            this.mBundle.putBundle(MediaMetadata.METADATA_KEY_EXTRAS, bundle);
            return this;
        }

        public Builder(@NonNull MediaMetadata mediaMetadata) {
            this.mBundle = new Bundle(mediaMetadata.mBundle);
        }

        public Builder(Bundle bundle) {
            this.mBundle = new Bundle(bundle);
        }
    }

    public MediaMetadata(Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        this.mBundle = bundle2;
        bundle2.setClassLoader(MediaMetadata.class.getClassLoader());
    }
}
