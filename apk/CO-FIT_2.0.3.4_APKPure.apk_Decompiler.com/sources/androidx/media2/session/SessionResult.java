package androidx.media2.session;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.media2.common.MediaItem;
import androidx.media2.common.SessionPlayer;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SessionResult extends CustomVersionedParcelable implements RemoteResult {
    public static final int RESULT_SUCCESS = 0;
    long mCompletionTime;
    Bundle mCustomCommandResult;
    MediaItem mItem;
    MediaItem mParcelableItem;
    int mResultCode;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResultCode {
    }

    public SessionResult(int i, @Nullable Bundle bundle) {
        this(i, bundle, (MediaItem) null, SystemClock.elapsedRealtime());
    }

    public static ListenableFuture<SessionResult> createFutureWithResult(int i) {
        ResolvableFuture create = ResolvableFuture.create();
        create.set(new SessionResult(i));
        return create;
    }

    @Nullable
    public static SessionResult from(@Nullable SessionPlayer.PlayerResult playerResult) {
        if (playerResult == null) {
            return null;
        }
        return new SessionResult(playerResult.getResultCode(), (Bundle) null, playerResult.getMediaItem(), playerResult.getCompletionTime());
    }

    public long getCompletionTime() {
        return this.mCompletionTime;
    }

    @Nullable
    public Bundle getCustomCommandResult() {
        return this.mCustomCommandResult;
    }

    @Nullable
    public MediaItem getMediaItem() {
        return this.mItem;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onPostParceling() {
        this.mItem = this.mParcelableItem;
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
    }

    public SessionResult() {
    }

    public SessionResult(int i) {
        this(i, (Bundle) null);
    }

    public SessionResult(int i, Bundle bundle, MediaItem mediaItem) {
        this(i, bundle, mediaItem, SystemClock.elapsedRealtime());
    }

    public SessionResult(int i, @Nullable Bundle bundle, @Nullable MediaItem mediaItem, long j) {
        this.mResultCode = i;
        this.mCustomCommandResult = bundle;
        this.mItem = mediaItem;
        this.mCompletionTime = j;
    }
}
