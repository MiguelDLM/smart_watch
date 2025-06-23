package androidx.media2.session;

import android.content.Intent;
import android.os.IBinder;

class MediaLibraryServiceImplBase extends MediaSessionServiceImplBase {
    public IBinder onBind(Intent intent) {
        if (MediaLibraryService.SERVICE_INTERFACE.equals(intent.getAction())) {
            return getServiceBinder();
        }
        return super.onBind(intent);
    }
}
