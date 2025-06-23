package androidx.media2.session;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media2.common.MediaParcelUtils;
import androidx.media2.session.MediaBrowser;
import androidx.media2.session.MediaLibraryService;
import androidx.media2.session.SequencedFutureManager;
import com.google.common.util.concurrent.ListenableFuture;

class MediaBrowserImplBase extends MediaControllerImplBase implements MediaBrowser.MediaBrowserImpl {
    private static final LibraryResult RESULT_WHEN_CLOSED = new LibraryResult(1);

    @FunctionalInterface
    public interface RemoteLibrarySessionTask {
        void run(IMediaSession iMediaSession, int i) throws RemoteException;
    }

    public MediaBrowserImplBase(Context context, MediaController mediaController, SessionToken sessionToken, @Nullable Bundle bundle) {
        super(context, mediaController, sessionToken, bundle);
    }

    private ListenableFuture<LibraryResult> dispatchRemoteLibrarySessionTask(int i, RemoteLibrarySessionTask remoteLibrarySessionTask) {
        IMediaSession sessionInterfaceIfAble = getSessionInterfaceIfAble(i);
        if (sessionInterfaceIfAble == null) {
            return LibraryResult.createFutureWithResult(-4);
        }
        SequencedFutureManager.SequencedFuture createSequencedFuture = this.mSequencedFutureManager.createSequencedFuture(RESULT_WHEN_CLOSED);
        try {
            remoteLibrarySessionTask.run(sessionInterfaceIfAble, createSequencedFuture.getSequenceNumber());
        } catch (RemoteException e) {
            Log.w("MC2ImplBase", "Cannot connect to the service or the session is gone", e);
            createSequencedFuture.set(new LibraryResult(-100));
        }
        return createSequencedFuture;
    }

    public ListenableFuture<LibraryResult> getChildren(String str, int i, int i2, MediaLibraryService.LibraryParams libraryParams) {
        final String str2 = str;
        final int i3 = i;
        final int i4 = i2;
        final MediaLibraryService.LibraryParams libraryParams2 = libraryParams;
        return dispatchRemoteLibrarySessionTask(50003, new RemoteLibrarySessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.getChildren(MediaBrowserImplBase.this.mControllerStub, i, str2, i3, i4, MediaParcelUtils.toParcelable(libraryParams2));
            }
        });
    }

    public ListenableFuture<LibraryResult> getItem(final String str) {
        return dispatchRemoteLibrarySessionTask(SessionCommand.COMMAND_CODE_LIBRARY_GET_ITEM, new RemoteLibrarySessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.getItem(MediaBrowserImplBase.this.mControllerStub, i, str);
            }
        });
    }

    public ListenableFuture<LibraryResult> getLibraryRoot(final MediaLibraryService.LibraryParams libraryParams) {
        return dispatchRemoteLibrarySessionTask(50000, new RemoteLibrarySessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.getLibraryRoot(MediaBrowserImplBase.this.mControllerStub, i, MediaParcelUtils.toParcelable(libraryParams));
            }
        });
    }

    @NonNull
    public MediaBrowser getMediaBrowser() {
        return (MediaBrowser) this.mInstance;
    }

    public ListenableFuture<LibraryResult> getSearchResult(String str, int i, int i2, MediaLibraryService.LibraryParams libraryParams) {
        final String str2 = str;
        final int i3 = i;
        final int i4 = i2;
        final MediaLibraryService.LibraryParams libraryParams2 = libraryParams;
        return dispatchRemoteLibrarySessionTask(50006, new RemoteLibrarySessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.getSearchResult(MediaBrowserImplBase.this.mControllerStub, i, str2, i3, i4, MediaParcelUtils.toParcelable(libraryParams2));
            }
        });
    }

    public void notifyChildrenChanged(final String str, final int i, final MediaLibraryService.LibraryParams libraryParams) {
        getMediaBrowser().notifyBrowserCallback(new MediaBrowser.BrowserCallbackRunnable() {
            public void run(@NonNull MediaBrowser.BrowserCallback browserCallback) {
                browserCallback.onChildrenChanged(MediaBrowserImplBase.this.getMediaBrowser(), str, i, libraryParams);
            }
        });
    }

    public void notifySearchResultChanged(final String str, final int i, final MediaLibraryService.LibraryParams libraryParams) {
        getMediaBrowser().notifyBrowserCallback(new MediaBrowser.BrowserCallbackRunnable() {
            public void run(@NonNull MediaBrowser.BrowserCallback browserCallback) {
                browserCallback.onSearchResultChanged(MediaBrowserImplBase.this.getMediaBrowser(), str, i, libraryParams);
            }
        });
    }

    public ListenableFuture<LibraryResult> search(final String str, final MediaLibraryService.LibraryParams libraryParams) {
        return dispatchRemoteLibrarySessionTask(50005, new RemoteLibrarySessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.search(MediaBrowserImplBase.this.mControllerStub, i, str, MediaParcelUtils.toParcelable(libraryParams));
            }
        });
    }

    public ListenableFuture<LibraryResult> subscribe(final String str, final MediaLibraryService.LibraryParams libraryParams) {
        return dispatchRemoteLibrarySessionTask(50001, new RemoteLibrarySessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.subscribe(MediaBrowserImplBase.this.mControllerStub, i, str, MediaParcelUtils.toParcelable(libraryParams));
            }
        });
    }

    public ListenableFuture<LibraryResult> unsubscribe(final String str) {
        return dispatchRemoteLibrarySessionTask(50002, new RemoteLibrarySessionTask() {
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.unsubscribe(MediaBrowserImplBase.this.mControllerStub, i, str);
            }
        });
    }
}
