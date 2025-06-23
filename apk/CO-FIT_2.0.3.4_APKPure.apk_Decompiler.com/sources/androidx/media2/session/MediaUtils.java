package androidx.media2.session;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.MediaParcelUtils;
import androidx.media2.common.ParcelImplListSlice;
import androidx.media2.common.Rating;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaLibraryService;
import androidx.media2.session.MediaSession;
import androidx.media2.session.SessionCommandGroup;
import androidx.versionedparcelable.ParcelImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class MediaUtils {
    public static final int CURRENT_VERSION = 0;
    public static final Executor DIRECT_EXECUTOR = new Executor() {
        public void execute(Runnable runnable) {
            runnable.run();
        }
    };
    private static final Map<String, String> METADATA_COMPAT_KEY_TO_METADATA_KEY;
    private static final Map<String, String> METADATA_KEY_TO_METADATA_COMPAT_KEY = new HashMap();
    public static final String TAG = "MediaUtils";
    public static final int TRANSACTION_SIZE_LIMIT_IN_BYTES = 262144;
    public static final int VERSION_0 = 0;
    public static final int VERSION_UNKNOWN = -1;
    public static final MediaBrowserServiceCompat.BrowserRoot sDefaultBrowserRoot = new MediaBrowserServiceCompat.BrowserRoot(MediaLibraryService.SERVICE_INTERFACE, (Bundle) null);

    static {
        HashMap hashMap = new HashMap();
        METADATA_COMPAT_KEY_TO_METADATA_KEY = hashMap;
        hashMap.put("android.media.metadata.ADVERTISEMENT", MediaMetadata.METADATA_KEY_ADVERTISEMENT);
        hashMap.put(MediaMetadataCompat.METADATA_KEY_BT_FOLDER_TYPE, MediaMetadata.METADATA_KEY_BROWSABLE);
        hashMap.put(MediaMetadataCompat.METADATA_KEY_DOWNLOAD_STATUS, MediaMetadata.METADATA_KEY_DOWNLOAD_STATUS);
        for (Map.Entry entry : hashMap.entrySet()) {
            Map<String, String> map = METADATA_KEY_TO_METADATA_COMPAT_KEY;
            if (!map.containsKey(entry.getValue())) {
                map.put((String) entry.getValue(), (String) entry.getKey());
            } else {
                throw new RuntimeException("Shouldn't map to the same value");
            }
        }
    }

    private MediaUtils() {
    }

    public static List<ParcelImpl> convertCommandButtonListToParcelImplList(List<MediaSession.CommandButton> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(MediaParcelUtils.toParcelable(list.get(i)));
        }
        return arrayList;
    }

    public static List<MediaItem> convertMediaItemListToMediaItemList(List<MediaBrowserCompat.MediaItem> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(convertToMediaItem(list.get(i)));
        }
        return arrayList;
    }

    public static ParcelImplListSlice convertMediaItemListToParcelImplListSlice(List<MediaItem> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            MediaItem mediaItem = list.get(i);
            if (mediaItem != null) {
                arrayList.add(MediaParcelUtils.toParcelable(mediaItem));
            }
        }
        return new ParcelImplListSlice((List<ParcelImpl>) arrayList);
    }

    public static List<MediaItem> convertParcelImplListSliceToMediaItemList(ParcelImplListSlice parcelImplListSlice) {
        if (parcelImplListSlice == null) {
            return null;
        }
        List<ParcelImpl> list = parcelImplListSlice.getList();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            ParcelImpl parcelImpl = list.get(i);
            if (parcelImpl != null) {
                arrayList.add((MediaItem) MediaParcelUtils.fromParcelable(parcelImpl));
            }
        }
        return arrayList;
    }

    public static List<MediaItem> convertQueueItemListToMediaItemList(List<MediaSessionCompat.QueueItem> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            MediaItem convertToMediaItem = convertToMediaItem(list.get(i));
            if (convertToMediaItem != null) {
                arrayList.add(convertToMediaItem);
            }
        }
        return arrayList;
    }

    @NonNull
    public static List<MediaSession.CommandButton> convertToCustomLayout(@Nullable PlaybackStateCompat playbackStateCompat) {
        ArrayList arrayList = new ArrayList();
        if (playbackStateCompat == null) {
            return arrayList;
        }
        for (PlaybackStateCompat.CustomAction next : playbackStateCompat.getCustomActions()) {
            arrayList.add(new MediaSession.CommandButton.Builder().setCommand(new SessionCommand(next.getAction(), next.getExtras())).setDisplayName(next.getName()).setEnabled(true).setIconResId(next.getIcon()).build());
        }
        return arrayList;
    }

    @Nullable
    public static MediaLibraryService.LibraryParams convertToLibraryParams(@NonNull Context context, @Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        try {
            bundle.setClassLoader(context.getClassLoader());
            return new MediaLibraryService.LibraryParams.Builder().setExtras(bundle).setRecent(bundle.getBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_RECENT)).setOffline(bundle.getBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_OFFLINE)).setSuggested(bundle.getBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_SUGGESTED)).build();
        } catch (Exception unused) {
            return new MediaLibraryService.LibraryParams.Builder().setExtras(bundle).build();
        }
    }

    @Nullable
    public static MediaBrowserCompat.MediaItem convertToMediaItem(@Nullable MediaItem mediaItem) {
        MediaDescriptionCompat mediaDescriptionCompat;
        if (mediaItem == null) {
            return null;
        }
        MediaMetadata metadata = mediaItem.getMetadata();
        int i = 0;
        if (metadata == null) {
            mediaDescriptionCompat = new MediaDescriptionCompat.Builder().setMediaId(mediaItem.getMediaId()).build();
        } else {
            MediaDescriptionCompat.Builder extras = new MediaDescriptionCompat.Builder().setMediaId(mediaItem.getMediaId()).setSubtitle(metadata.getText("android.media.metadata.DISPLAY_SUBTITLE")).setDescription(metadata.getText("android.media.metadata.DISPLAY_DESCRIPTION")).setIconBitmap(metadata.getBitmap("android.media.metadata.DISPLAY_ICON")).setExtras(metadata.getExtras());
            String string = metadata.getString("android.media.metadata.TITLE");
            if (string != null) {
                extras.setTitle(string);
            } else {
                extras.setTitle(metadata.getString("android.media.metadata.DISPLAY_TITLE"));
            }
            String string2 = metadata.getString("android.media.metadata.DISPLAY_ICON_URI");
            if (string2 != null) {
                extras.setIconUri(Uri.parse(string2));
            }
            String string3 = metadata.getString("android.media.metadata.MEDIA_URI");
            if (string3 != null) {
                extras.setMediaUri(Uri.parse(string3));
            }
            mediaDescriptionCompat = extras.build();
            boolean z = true;
            int i2 = (!metadata.containsKey(MediaMetadata.METADATA_KEY_BROWSABLE) || metadata.getLong(MediaMetadata.METADATA_KEY_BROWSABLE) == -1) ? 0 : 1;
            if (metadata.getLong(MediaMetadata.METADATA_KEY_PLAYABLE) == 0) {
                z = false;
            }
            if (z) {
                i = 2;
            }
            i |= i2;
        }
        return new MediaBrowserCompat.MediaItem(mediaDescriptionCompat, i);
    }

    @Nullable
    public static List<MediaBrowserCompat.MediaItem> convertToMediaItemList(@Nullable List<MediaItem> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(convertToMediaItem(list.get(i)));
        }
        return arrayList;
    }

    private static MediaMetadata convertToMediaMetadata(MediaDescriptionCompat mediaDescriptionCompat, boolean z, boolean z2) {
        if (mediaDescriptionCompat == null) {
            return null;
        }
        MediaMetadata.Builder builder = new MediaMetadata.Builder();
        builder.putString("android.media.metadata.MEDIA_ID", mediaDescriptionCompat.getMediaId());
        CharSequence title = mediaDescriptionCompat.getTitle();
        if (title != null) {
            builder.putText("android.media.metadata.DISPLAY_TITLE", title);
        }
        if (mediaDescriptionCompat.getDescription() != null) {
            builder.putText("android.media.metadata.DISPLAY_DESCRIPTION", mediaDescriptionCompat.getDescription());
        }
        CharSequence subtitle = mediaDescriptionCompat.getSubtitle();
        if (subtitle != null) {
            builder.putText("android.media.metadata.DISPLAY_SUBTITLE", subtitle);
        }
        Bitmap iconBitmap = mediaDescriptionCompat.getIconBitmap();
        if (iconBitmap != null) {
            builder.putBitmap("android.media.metadata.DISPLAY_ICON", iconBitmap);
        }
        Uri iconUri = mediaDescriptionCompat.getIconUri();
        if (iconUri != null) {
            builder.putText("android.media.metadata.DISPLAY_ICON_URI", iconUri.toString());
        }
        Bundle extras = mediaDescriptionCompat.getExtras();
        if (extras != null) {
            builder.setExtras(extras);
        }
        Uri mediaUri = mediaDescriptionCompat.getMediaUri();
        if (mediaUri != null) {
            builder.putText("android.media.metadata.MEDIA_URI", mediaUri.toString());
        }
        long j = 0;
        if (extras != null && extras.containsKey(MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE)) {
            builder.putLong(MediaMetadata.METADATA_KEY_BROWSABLE, extras.getLong(MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE));
        } else if (z) {
            builder.putLong(MediaMetadata.METADATA_KEY_BROWSABLE, 0);
        } else {
            builder.putLong(MediaMetadata.METADATA_KEY_BROWSABLE, -1);
        }
        if (z2) {
            j = 1;
        }
        builder.putLong(MediaMetadata.METADATA_KEY_PLAYABLE, j);
        return builder.build();
    }

    public static MediaMetadataCompat convertToMediaMetadataCompat(MediaMetadata mediaMetadata) {
        String str;
        if (mediaMetadata == null) {
            return null;
        }
        MediaMetadataCompat.Builder builder = new MediaMetadataCompat.Builder();
        for (String next : mediaMetadata.keySet()) {
            Map<String, String> map = METADATA_KEY_TO_METADATA_COMPAT_KEY;
            if (map.containsKey(next)) {
                str = map.get(next);
            } else {
                str = next;
            }
            Object object = mediaMetadata.getObject(next);
            if (object instanceof CharSequence) {
                builder.putText(str, (CharSequence) object);
            } else if (object instanceof Bitmap) {
                builder.putBitmap(str, (Bitmap) object);
            } else if (object instanceof Long) {
                builder.putLong(str, ((Long) object).longValue());
            } else if ((object instanceof Bundle) && !TextUtils.equals(next, MediaMetadata.METADATA_KEY_EXTRAS)) {
                try {
                    builder.putRating(str, convertToRatingCompat(mediaMetadata.getRating(next)));
                } catch (Exception unused) {
                }
            }
        }
        return builder.build();
    }

    public static int convertToPlaybackStateCompatState(int i, int i2) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return 7;
        }
        return i2 != 2 ? 3 : 6;
    }

    public static int convertToPlayerState(PlaybackStateCompat playbackStateCompat) {
        if (playbackStateCompat == null) {
            return 0;
        }
        switch (playbackStateCompat.getState()) {
            case 0:
                return 0;
            case 1:
            case 2:
            case 6:
                return 1;
            case 3:
            case 4:
            case 5:
            case 8:
            case 9:
            case 10:
            case 11:
                return 2;
            default:
                return 3;
        }
    }

    public static long convertToQueueItemId(int i) {
        if (i == -1) {
            return -1;
        }
        return (long) i;
    }

    public static List<MediaSessionCompat.QueueItem> convertToQueueItemList(List<MediaItem> list) {
        MediaDescriptionCompat mediaDescriptionCompat;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            MediaItem mediaItem = list.get(i);
            if (mediaItem.getMetadata() == null) {
                mediaDescriptionCompat = new MediaDescriptionCompat.Builder().setMediaId(mediaItem.getMediaId()).build();
            } else {
                mediaDescriptionCompat = convertToMediaMetadataCompat(mediaItem.getMetadata()).getDescription();
            }
            arrayList.add(new MediaSessionCompat.QueueItem(mediaDescriptionCompat, convertToQueueItemId(i)));
        }
        return arrayList;
    }

    public static Rating convertToRating(RatingCompat ratingCompat) {
        if (ratingCompat == null) {
            return null;
        }
        switch (ratingCompat.getRatingStyle()) {
            case 1:
                if (ratingCompat.isRated()) {
                    return new HeartRating(ratingCompat.hasHeart());
                }
                return new HeartRating();
            case 2:
                if (ratingCompat.isRated()) {
                    return new ThumbRating(ratingCompat.isThumbUp());
                }
                return new ThumbRating();
            case 3:
                if (ratingCompat.isRated()) {
                    return new StarRating(3, ratingCompat.getStarRating());
                }
                return new StarRating(3);
            case 4:
                if (ratingCompat.isRated()) {
                    return new StarRating(4, ratingCompat.getStarRating());
                }
                return new StarRating(4);
            case 5:
                if (ratingCompat.isRated()) {
                    return new StarRating(5, ratingCompat.getStarRating());
                }
                return new StarRating(5);
            case 6:
                if (ratingCompat.isRated()) {
                    return new PercentageRating(ratingCompat.getPercentRating());
                }
                return new PercentageRating();
            default:
                return null;
        }
    }

    @SuppressLint({"WrongConstant"})
    public static RatingCompat convertToRatingCompat(Rating rating) {
        if (rating == null) {
            return null;
        }
        int ratingCompatStyle = getRatingCompatStyle(rating);
        if (!rating.isRated()) {
            return RatingCompat.newUnratedRating(ratingCompatStyle);
        }
        switch (ratingCompatStyle) {
            case 1:
                return RatingCompat.newHeartRating(((HeartRating) rating).hasHeart());
            case 2:
                return RatingCompat.newThumbRating(((ThumbRating) rating).isThumbUp());
            case 3:
            case 4:
            case 5:
                return RatingCompat.newStarRating(ratingCompatStyle, ((StarRating) rating).getStarRating());
            case 6:
                return RatingCompat.newPercentageRating(((PercentageRating) rating).getPercentRating());
            default:
                return null;
        }
    }

    @Nullable
    public static Bundle convertToRootHints(@Nullable MediaLibraryService.LibraryParams libraryParams) {
        Bundle bundle;
        if (libraryParams == null) {
            return null;
        }
        if (libraryParams.getExtras() == null) {
            bundle = new Bundle();
        } else {
            bundle = new Bundle(libraryParams.getExtras());
        }
        bundle.putBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_RECENT, libraryParams.isRecent());
        bundle.putBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_OFFLINE, libraryParams.isOffline());
        bundle.putBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_SUGGESTED, libraryParams.isSuggested());
        return bundle;
    }

    @NonNull
    public static SessionCommandGroup convertToSessionCommandGroup(long j, @Nullable PlaybackStateCompat playbackStateCompat) {
        SessionCommandGroup.Builder builder = new SessionCommandGroup.Builder();
        builder.addAllPlayerBasicCommands(1);
        if ((j & 4) != 0) {
            builder.addAllPlayerPlaylistCommands(1);
        }
        builder.addAllVolumeCommands(1);
        builder.addAllSessionCommands(1);
        builder.removeCommand(new SessionCommand(10004));
        builder.removeCommand(new SessionCommand(11000));
        builder.removeCommand(new SessionCommand(11001));
        builder.removeCommand(new SessionCommand(11002));
        if (!(playbackStateCompat == null || playbackStateCompat.getCustomActions() == null)) {
            for (PlaybackStateCompat.CustomAction next : playbackStateCompat.getCustomActions()) {
                builder.addCommand(new SessionCommand(next.getAction(), next.getExtras()));
            }
        }
        return builder.build();
    }

    public static MediaDescriptionCompat createMediaDescriptionCompat(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new MediaDescriptionCompat.Builder().setMediaId(str).build();
    }

    /* JADX INFO: finally extract failed */
    public static boolean doesBundleHaveCustomParcelable(@NonNull Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeBundle(bundle);
            obtain.setDataPosition(0);
            Bundle readBundle = obtain.readBundle((ClassLoader) null);
            if (readBundle != null) {
                readBundle.isEmpty();
            }
            obtain.recycle();
            return false;
        } catch (BadParcelableException e) {
            Log.d(TAG, "Custom parcelables are not allowed", e);
            obtain.recycle();
            return true;
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }

    private static int getRatingCompatStyle(Rating rating) {
        if (rating instanceof HeartRating) {
            return 1;
        }
        if (rating instanceof ThumbRating) {
            return 2;
        }
        if (rating instanceof StarRating) {
            int maxStars = ((StarRating) rating).getMaxStars();
            int i = 3;
            if (maxStars != 3) {
                i = 4;
                if (maxStars != 4) {
                    i = 5;
                    if (maxStars != 5) {
                        return 0;
                    }
                }
            }
            return i;
        } else if (rating instanceof PercentageRating) {
            return 6;
        } else {
            return 0;
        }
    }

    public static boolean isUnparcelableBundle(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        bundle.setClassLoader(MediaUtils.class.getClassLoader());
        try {
            bundle.size();
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static void keepUnparcelableBundlesOnly(List<Bundle> list) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (isUnparcelableBundle(list.get(size))) {
                    list.remove(size);
                }
            }
        }
    }

    @Nullable
    public static <T> List<T> removeNullElements(@Nullable List<T> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static int toBufferingState(int i) {
        if (i != 3) {
            return i != 6 ? 0 : 2;
        }
        return 3;
    }

    public static MediaController.PlaybackInfo toPlaybackInfo2(MediaControllerCompat.PlaybackInfo playbackInfo) {
        return MediaController.PlaybackInfo.createPlaybackInfo(playbackInfo.getPlaybackType(), new AudioAttributesCompat.Builder().setLegacyStreamType(playbackInfo.getAudioAttributes().getLegacyStreamType()).build(), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
    }

    public static <T extends Parcelable> List<T> truncateListBySize(List<T> list, int i) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Parcel obtain = Parcel.obtain();
        int i2 = 0;
        while (i2 < list.size()) {
            try {
                Parcelable parcelable = (Parcelable) list.get(i2);
                obtain.writeParcelable(parcelable, 0);
                if (obtain.dataSize() >= i) {
                    break;
                }
                arrayList.add(parcelable);
                i2++;
            } finally {
                obtain.recycle();
            }
        }
        return arrayList;
    }

    @Nullable
    public static MediaItem upcastForPreparceling(@Nullable MediaItem mediaItem) {
        return (mediaItem == null || mediaItem.getClass() == MediaItem.class) ? mediaItem : new MediaItem.Builder().setStartPosition(mediaItem.getStartPosition()).setEndPosition(mediaItem.getEndPosition()).setMetadata(mediaItem.getMetadata()).build();
    }

    @Nullable
    public static VideoSize upcastForPreparceling(@Nullable VideoSize videoSize) {
        return (videoSize == null || videoSize.getClass() == VideoSize.class) ? videoSize : new VideoSize(videoSize.getWidth(), videoSize.getHeight());
    }

    @Nullable
    public static SessionPlayer.TrackInfo upcastForPreparceling(@Nullable SessionPlayer.TrackInfo trackInfo) {
        return (trackInfo == null || trackInfo.getClass() == SessionPlayer.TrackInfo.class) ? trackInfo : new SessionPlayer.TrackInfo(trackInfo.getId(), trackInfo.getTrackType(), trackInfo.getFormat(), trackInfo.isSelectable());
    }

    @Nullable
    public static List<SessionPlayer.TrackInfo> upcastForPreparceling(@Nullable List<SessionPlayer.TrackInfo> list) {
        if (list == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(upcastForPreparceling(list.get(i)));
        }
        return arrayList;
    }

    public static MediaItem convertToMediaItem(MediaBrowserCompat.MediaItem mediaItem) {
        if (mediaItem == null) {
            return null;
        }
        return new MediaItem.Builder().setMetadata(convertToMediaMetadata(mediaItem.getDescription(), mediaItem.isBrowsable(), mediaItem.isPlayable())).build();
    }

    public static MediaMetadata convertToMediaMetadata(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        return new MediaMetadata.Builder().putString("android.media.metadata.TITLE", charSequence.toString()).putLong(MediaMetadata.METADATA_KEY_BROWSABLE, 0).putLong(MediaMetadata.METADATA_KEY_PLAYABLE, 1).build();
    }

    public static MediaItem convertToMediaItem(MediaSessionCompat.QueueItem queueItem) {
        if (queueItem == null) {
            return null;
        }
        return new MediaItem.Builder().setMetadata(convertToMediaMetadata(queueItem.getDescription(), false, true)).build();
    }

    public static MediaItem convertToMediaItem(MediaMetadataCompat mediaMetadataCompat) {
        if (mediaMetadataCompat == null) {
            return null;
        }
        MediaMetadata.Builder putLong = new MediaMetadata.Builder().putLong(MediaMetadata.METADATA_KEY_PLAYABLE, 1);
        for (String next : mediaMetadataCompat.keySet()) {
            Object obj = mediaMetadataCompat.getBundle().get(next);
            Map<String, String> map = METADATA_COMPAT_KEY_TO_METADATA_KEY;
            String str = map.containsKey(next) ? map.get(next) : next;
            if (obj instanceof CharSequence) {
                putLong.putText(str, (CharSequence) obj);
            } else if (obj instanceof Bitmap) {
                putLong.putBitmap(str, (Bitmap) obj);
            } else if (obj instanceof Long) {
                putLong.putLong(str, ((Long) obj).longValue());
            } else if ((obj instanceof RatingCompat) || (obj instanceof android.media.Rating)) {
                try {
                    putLong.putRating(str, convertToRating(mediaMetadataCompat.getRating(next)));
                } catch (Exception unused) {
                }
            }
        }
        return new MediaItem.Builder().setMetadata(putLong.build()).build();
    }

    public static MediaItem convertToMediaItem(MediaDescriptionCompat mediaDescriptionCompat) {
        MediaMetadata convertToMediaMetadata = convertToMediaMetadata(mediaDescriptionCompat, false, true);
        if (convertToMediaMetadata == null) {
            return null;
        }
        return new MediaItem.Builder().setMetadata(convertToMediaMetadata).build();
    }
}
