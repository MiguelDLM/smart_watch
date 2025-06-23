package androidx.media2.session;

import android.content.Intent;
import android.os.IBinder;

/* loaded from: classes.dex */
class MediaLibraryServiceImplBase extends MediaSessionServiceImplBase {
    @Override // androidx.media2.session.MediaSessionServiceImplBase, androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public IBinder onBind(Intent intent) {
        if (MediaLibraryService.SERVICE_INTERFACE.equals(intent.getAction())) {
            return getServiceBinder();
        }
        return super.onBind(intent);
    }
}
