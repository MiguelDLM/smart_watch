package androidx.core.app;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.PendingIntentCompat;

public final /* synthetic */ class oI0IIXIo implements PendingIntent.OnFinished {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ PendingIntentCompat.GatedCallback f294oIX0oI;

    public /* synthetic */ oI0IIXIo(PendingIntentCompat.GatedCallback gatedCallback) {
        this.f294oIX0oI = gatedCallback;
    }

    public final void onSendFinished(PendingIntent pendingIntent, Intent intent, int i, String str, Bundle bundle) {
        this.f294oIX0oI.onSendFinished(pendingIntent, intent, i, str, bundle);
    }
}
