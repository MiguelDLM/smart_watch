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

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MediaBrowserImplBase extends MediaControllerImplBase implements MediaBrowser.MediaBrowserImpl {
    private static final LibraryResult RESULT_WHEN_CLOSED = new LibraryResult(1);

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface RemoteLibrarySessionTask {
        void run(IMediaSession iMediaSession, int i) throws RemoteException;
    }

    public MediaBrowserImplBase(Context context, MediaController mediaController, SessionToken sessionToken, @Nullable Bundle bundle) {
        super(context, mediaController, sessionToken, bundle);
    }

    private ListenableFuture<LibraryResult> dispatchRemoteLibrarySessionTask(int i, RemoteLibrarySessionTask remoteLibrarySessionTask) {
        IMediaSession sessionInterfaceIfAble = getSessionInterfaceIfAble(i);
        if (sessionInterfaceIfAble != null) {
            SequencedFutureManager.SequencedFuture createSequencedFuture = this.mSequencedFutureManager.createSequencedFuture(RESULT_WHEN_CLOSED);
            try {
                remoteLibrarySessionTask.run(sessionInterfaceIfAble, createSequencedFuture.getSequenceNumber());
            } catch (RemoteException e) {
                Log.w("MC2ImplBase", "Cannot connect to the service or the session is gone", e);
                createSequencedFuture.set(new LibraryResult(-100));
            }
            return createSequencedFuture;
        }
        return LibraryResult.createFutureWithResult(-4);
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> getChildren(final String str, final int i, final int i2, final MediaLibraryService.LibraryParams libraryParams) {
        return dispatchRemoteLibrarySessionTask(50003, new RemoteLibrarySessionTask() { // from class: androidx.media2.session.MediaBrowserImplBase.4
            @Override // androidx.media2.session.MediaBrowserImplBase.RemoteLibrarySessionTask
            public void run(IMediaSession iMediaSession, int i3) throws RemoteException {
                iMediaSession.getChildren(MediaBrowserImplBase.this.mControllerStub, i3, str, i, i2, MediaParcelUtils.toParcelable(libraryParams));
            }
        });
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> getItem(final String str) {
        return dispatchRemoteLibrarySessionTask(SessionCommand.COMMAND_CODE_LIBRARY_GET_ITEM, new RemoteLibrarySessionTask() { // from class: androidx.media2.session.MediaBrowserImplBase.5
            @Override // androidx.media2.session.MediaBrowserImplBase.RemoteLibrarySessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.getItem(MediaBrowserImplBase.this.mControllerStub, i, str);
            }
        });
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> getLibraryRoot(final MediaLibraryService.LibraryParams libraryParams) {
        return dispatchRemoteLibrarySessionTask(50000, new RemoteLibrarySessionTask() { // from class: androidx.media2.session.MediaBrowserImplBase.1
            @Override // androidx.media2.session.MediaBrowserImplBase.RemoteLibrarySessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.getLibraryRoot(MediaBrowserImplBase.this.mControllerStub, i, MediaParcelUtils.toParcelable(libraryParams));
            }
        });
    }

    @NonNull
    public MediaBrowser getMediaBrowser() {
        return (MediaBrowser) this.mInstance;
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> getSearchResult(final String str, final int i, final int i2, final MediaLibraryService.LibraryParams libraryParams) {
        return dispatchRemoteLibrarySessionTask(50006, new RemoteLibrarySessionTask() { // from class: androidx.media2.session.MediaBrowserImplBase.7
            @Override // androidx.media2.session.MediaBrowserImplBase.RemoteLibrarySessionTask
            public void run(IMediaSession iMediaSession, int i3) throws RemoteException {
                iMediaSession.getSearchResult(MediaBrowserImplBase.this.mControllerStub, i3, str, i, i2, MediaParcelUtils.toParcelable(libraryParams));
            }
        });
    }

    public void notifyChildrenChanged(final String str, final int i, final MediaLibraryService.LibraryParams libraryParams) {
        getMediaBrowser().notifyBrowserCallback(new MediaBrowser.BrowserCallbackRunnable() { // from class: androidx.media2.session.MediaBrowserImplBase.9
            @Override // androidx.media2.session.MediaBrowser.BrowserCallbackRunnable
            public void run(@NonNull MediaBrowser.BrowserCallback browserCallback) {
                browserCallback.onChildrenChanged(MediaBrowserImplBase.this.getMediaBrowser(), str, i, libraryParams);
            }
        });
    }

    public void notifySearchResultChanged(final String str, final int i, final MediaLibraryService.LibraryParams libraryParams) {
        getMediaBrowser().notifyBrowserCallback(new MediaBrowser.BrowserCallbackRunnable() { // from class: androidx.media2.session.MediaBrowserImplBase.8
            @Override // androidx.media2.session.MediaBrowser.BrowserCallbackRunnable
            public void run(@NonNull MediaBrowser.BrowserCallback browserCallback) {
                browserCallback.onSearchResultChanged(MediaBrowserImplBase.this.getMediaBrowser(), str, i, libraryParams);
            }
        });
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> search(final String str, final MediaLibraryService.LibraryParams libraryParams) {
        return dispatchRemoteLibrarySessionTask(50005, new RemoteLibrarySessionTask() { // from class: androidx.media2.session.MediaBrowserImplBase.6
            @Override // androidx.media2.session.MediaBrowserImplBase.RemoteLibrarySessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.search(MediaBrowserImplBase.this.mControllerStub, i, str, MediaParcelUtils.toParcelable(libraryParams));
            }
        });
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> subscribe(final String str, final MediaLibraryService.LibraryParams libraryParams) {
        return dispatchRemoteLibrarySessionTask(50001, new RemoteLibrarySessionTask() { // from class: androidx.media2.session.MediaBrowserImplBase.2
            @Override // androidx.media2.session.MediaBrowserImplBase.RemoteLibrarySessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.subscribe(MediaBrowserImplBase.this.mControllerStub, i, str, MediaParcelUtils.toParcelable(libraryParams));
            }
        });
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> unsubscribe(final String str) {
        return dispatchRemoteLibrarySessionTask(50002, new RemoteLibrarySessionTask() { // from class: androidx.media2.session.MediaBrowserImplBase.3
            @Override // androidx.media2.session.MediaBrowserImplBase.RemoteLibrarySessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                iMediaSession.unsubscribe(MediaBrowserImplBase.this.mControllerStub, i, str);
            }
        });
    }
}
