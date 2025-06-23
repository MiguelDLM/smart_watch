package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class LoginStatusClient extends PlatformServiceClient {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final long DEFAULT_TOAST_DURATION_MS = 5000;

    @OXOo.OOXIXo
    private final String graphApiVersion;

    @OXOo.OOXIXo
    private final String loggerRef;
    private final long toastDurationMs;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final LoginStatusClient newInstance$facebook_common_release(@OXOo.OOXIXo Context context, @OXOo.OOXIXo String applicationId, @OXOo.OOXIXo String loggerRef, @OXOo.OOXIXo String graphApiVersion, long j, @OXOo.oOoXoXO String str) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(applicationId, "applicationId");
            IIX0o.x0xO0oo(loggerRef, "loggerRef");
            IIX0o.x0xO0oo(graphApiVersion, "graphApiVersion");
            return new LoginStatusClient(context, applicationId, loggerRef, graphApiVersion, j, str);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginStatusClient(@OXOo.OOXIXo Context context, @OXOo.OOXIXo String applicationId, @OXOo.OOXIXo String loggerRef, @OXOo.OOXIXo String graphApiVersion, long j, @OXOo.oOoXoXO String str) {
        super(context, NativeProtocol.MESSAGE_GET_LOGIN_STATUS_REQUEST, NativeProtocol.MESSAGE_GET_LOGIN_STATUS_REPLY, NativeProtocol.PROTOCOL_VERSION_20170411, applicationId, str);
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(applicationId, "applicationId");
        IIX0o.x0xO0oo(loggerRef, "loggerRef");
        IIX0o.x0xO0oo(graphApiVersion, "graphApiVersion");
        this.loggerRef = loggerRef;
        this.graphApiVersion = graphApiVersion;
        this.toastDurationMs = j;
    }

    @Override // com.facebook.internal.PlatformServiceClient
    public void populateRequestBundle(@OXOo.OOXIXo Bundle data) {
        IIX0o.x0xO0oo(data, "data");
        data.putString(NativeProtocol.EXTRA_LOGGER_REF, this.loggerRef);
        data.putString(NativeProtocol.EXTRA_GRAPH_API_VERSION, this.graphApiVersion);
        data.putLong(NativeProtocol.EXTRA_TOAST_DURATION_MS, this.toastDurationMs);
    }
}
