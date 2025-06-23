package com.facebook.internal;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.login.CustomTabLoginMethodHandler;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class InstagramCustomTab extends CustomTab {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final Uri getURIForAction(@OXOo.OOXIXo String action, @OXOo.oOoXoXO Bundle bundle) {
            IIX0o.x0xO0oo(action, "action");
            if (IIX0o.Oxx0IOOO(action, CustomTabLoginMethodHandler.OAUTH_DIALOG)) {
                Utility utility = Utility.INSTANCE;
                ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
                return Utility.buildUri(ServerProtocol.getInstagramDialogAuthority(), ServerProtocol.INSTAGRAM_OAUTH_PATH, bundle);
            }
            Utility utility2 = Utility.INSTANCE;
            ServerProtocol serverProtocol2 = ServerProtocol.INSTANCE;
            String instagramDialogAuthority = ServerProtocol.getInstagramDialogAuthority();
            StringBuilder sb = new StringBuilder();
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            sb.append(FacebookSdk.getGraphApiVersion());
            sb.append("/dialog/");
            sb.append(action);
            return Utility.buildUri(instagramDialogAuthority, sb.toString(), bundle);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstagramCustomTab(@OXOo.OOXIXo String action, @OXOo.oOoXoXO Bundle bundle) {
        super(action, bundle);
        IIX0o.x0xO0oo(action, "action");
        setUri(Companion.getURIForAction(action, bundle == null ? new Bundle() : bundle));
    }
}
