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

/* loaded from: classes.dex */
public class LibraryResult extends CustomVersionedParcelable implements RemoteResult {
    long mCompletionTime;
    MediaItem mItem;
    List<MediaItem> mItemList;
    ParcelImplListSlice mItemListSlice;
    MediaLibraryService.LibraryParams mParams;
    MediaItem mParcelableItem;
    int mResultCode;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface ResultCode {
    }

    public LibraryResult() {
    }

    public static ListenableFuture<LibraryResult> createFutureWithResult(int i) {
        ResolvableFuture create = ResolvableFuture.create();
        create.set(new LibraryResult(i));
        return create;
    }

    @Override // androidx.media2.common.BaseResult
    public long getCompletionTime() {
        return this.mCompletionTime;
    }

    @Nullable
    public MediaLibraryService.LibraryParams getLibraryParams() {
        return this.mParams;
    }

    @Override // androidx.media2.common.BaseResult
    @Nullable
    public MediaItem getMediaItem() {
        return this.mItem;
    }

    @Nullable
    public List<MediaItem> getMediaItems() {
        return this.mItemList;
    }

    @Override // androidx.media2.common.BaseResult
    public int getResultCode() {
        return this.mResultCode;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onPostParceling() {
        this.mItem = this.mParcelableItem;
        this.mItemList = MediaUtils.convertParcelImplListSliceToMediaItemList(this.mItemListSlice);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onPreParceling(boolean z) {
        MediaItem mediaItem = this.mItem;
        if (mediaItem != null) {
            synchronized (mediaItem) {
                try {
                    if (this.mParcelableItem == null) {
                        this.mParcelableItem = MediaUtils.upcastForPreparceling(this.mItem);
                    }
                } finally {
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
                } finally {
                }
            }
        }
    }

    public LibraryResult(int i) {
        this(i, null, null, null);
    }

    public LibraryResult(int i, @Nullable MediaItem mediaItem, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        this(i, mediaItem, null, libraryParams);
    }

    public LibraryResult(int i, @Nullable List<MediaItem> list, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        this(i, null, list, libraryParams);
    }

    private LibraryResult(int i, @Nullable MediaItem mediaItem, @Nullable List<MediaItem> list, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        this.mResultCode = i;
        this.mCompletionTime = SystemClock.elapsedRealtime();
        this.mItem = mediaItem;
        this.mItemList = list;
        this.mParams = libraryParams;
    }
}
