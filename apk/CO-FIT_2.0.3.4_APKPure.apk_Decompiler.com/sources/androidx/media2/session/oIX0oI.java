package androidx.media2.session;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.media2.session.SessionToken;

public final /* synthetic */ class oIX0oI implements SessionToken.OnSessionTokenCreatedListener {

    /* renamed from: I0Io  reason: collision with root package name */
    public final /* synthetic */ Bundle f414I0Io;

    /* renamed from: II0xO0  reason: collision with root package name */
    public final /* synthetic */ Context f415II0xO0;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ MediaController f416oIX0oI;

    public /* synthetic */ oIX0oI(MediaController mediaController, Context context, Bundle bundle) {
        this.f416oIX0oI = mediaController;
        this.f415II0xO0 = context;
        this.f414I0Io = bundle;
    }

    public final void onSessionTokenCreated(MediaSessionCompat.Token token, SessionToken sessionToken) {
        this.f416oIX0oI.lambda$new$1(this.f415II0xO0, this.f414I0Io, token, sessionToken);
    }
}
