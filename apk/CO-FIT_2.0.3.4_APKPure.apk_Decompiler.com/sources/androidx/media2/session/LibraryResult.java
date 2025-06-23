package androidx.media2.session;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.media2.common.MediaItem;
import androidx.media2.common.ParcelImplListSlice;
import androidx.media2.session.MediaLibraryService;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class LibraryResult extends CustomVersionedParcelable implements RemoteResult {
    long mCompletionTime;
    MediaItem mItem;
    List<MediaItem> mItemList;
    ParcelImplListSlice mItemListSlice;
    MediaLibraryService.LibraryParams mParams;
    MediaItem mParcelableItem;
    int mResultCode;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResultCode {
    }

    public LibraryResult() {
    }

    public static ListenableFuture<LibraryResult> createFutureWithResult(int i) {
        ResolvableFuture create = ResolvableFuture.create();
        create.set(new LibraryResult(i));
        return create;
    }

    public long getCompletionTime() {
        return this.mCompletionTime;
    }

    @Nullable
    public MediaLibraryService.LibraryParams getLibraryParams() {
        return this.mParams;
    }

    @Nullable
    public MediaItem getMediaItem() {
        return this.mItem;
    }

    @Nullable
    public List<MediaItem> getMediaItems() {
        return this.mItemList;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onPostParceling() {
        this.mItem = this.mParcelableItem;
        this.mItemList = MediaUtils.convertParcelImplListSliceToMediaItemList(this.mItemListSlice);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onPreParceling(boolean z) {
        MediaItem mediaItem = this.mItem;
        if (mediaItem != null) {
            synchronized (mediaItem) {
                try {
                    if (this.mParcelableItem == null) {
                        this.mParcelableItem = MediaUtils.upcastForPreparceling(this.mItem);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        List<MediaItem> list = this.mItemList;
        if (list != null) {
            synchronized (list) {
                try {
                    if (this.mItemListSlice == null) {
                        this.mItemListSlice = MediaUtils.convertMediaItemListToParcelImplListSlice(this.mItemList);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public LibraryResult(int i) {
        this(i, (MediaItem) null, (List<MediaItem>) null, (MediaLibraryService.LibraryParams) null);
    }

    public LibraryResult(int i, @Nullable MediaItem mediaItem, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        this(i, mediaItem, (List<MediaItem>) null, libraryParams);
    }

    public LibraryResult(int i, @Nullable List<MediaItem> list, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        this(i, (MediaItem) null, list, libraryParams);
    }

    private LibraryResult(int i, @Nullable MediaItem mediaItem, @Nullable List<MediaItem> list, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        this.mResultCode = i;
        this.mCompletionTime = SystemClock.elapsedRealtime();
        this.mItem = mediaItem;
        this.mItemList = list;
        this.mParams = libraryParams;
    }
}
