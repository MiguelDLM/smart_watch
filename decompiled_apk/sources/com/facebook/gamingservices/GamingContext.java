package com.facebook.gamingservices;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class GamingContext {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_TIMEOUT = 5;

    @oOoXoXO
    private static GamingContext currentContext;

    @OOXIXo
    private final String contextID;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @oOoXoXO
        public final GamingContext getCurrentGamingContext() {
            JSONObject jSONObject;
            String string;
            if (!CloudGameLoginHandler.isRunningInCloud()) {
                return GamingContext.currentContext;
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            GraphResponse executeAndWait = DaemonRequest.executeAndWait(FacebookSdk.getApplicationContext(), null, SDKMessageEnum.CONTEXT_GET_ID, 5);
            if (executeAndWait == null || (jSONObject = executeAndWait.getJSONObject()) == null) {
                string = null;
            } else {
                string = jSONObject.getString("id");
            }
            if (string == null) {
                return null;
            }
            return new GamingContext(string);
        }

        @x0XOIxOo
        public final void setCurrentGamingContext(@OOXIXo GamingContext ctx) {
            IIX0o.x0xO0oo(ctx, "ctx");
            if (!CloudGameLoginHandler.isRunningInCloud()) {
                GamingContext.currentContext = ctx;
            }
        }

        private Companion() {
        }
    }

    public GamingContext(@OOXIXo String contextID) {
        IIX0o.x0xO0oo(contextID, "contextID");
        this.contextID = contextID;
    }

    public static /* synthetic */ GamingContext copy$default(GamingContext gamingContext, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gamingContext.contextID;
        }
        return gamingContext.copy(str);
    }

    @x0XOIxOo
    @oOoXoXO
    public static final GamingContext getCurrentGamingContext() {
        return Companion.getCurrentGamingContext();
    }

    @x0XOIxOo
    public static final void setCurrentGamingContext(@OOXIXo GamingContext gamingContext) {
        Companion.setCurrentGamingContext(gamingContext);
    }

    @OOXIXo
    public final String component1() {
        return this.contextID;
    }

    @OOXIXo
    public final GamingContext copy(@OOXIXo String contextID) {
        IIX0o.x0xO0oo(contextID, "contextID");
        return new GamingContext(contextID);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GamingContext) && IIX0o.Oxx0IOOO(this.contextID, ((GamingContext) obj).contextID);
    }

    @OOXIXo
    public final String getContextID() {
        return this.contextID;
    }

    public int hashCode() {
        return this.contextID.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "GamingContext(contextID=" + this.contextID + HexStringBuilder.COMMENT_END_CHAR;
    }
}
