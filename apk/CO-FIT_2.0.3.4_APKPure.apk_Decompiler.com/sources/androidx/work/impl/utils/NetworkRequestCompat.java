package androidx.work.impl.utils;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.net.NetworkRequest;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

public final class NetworkRequestCompat {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    /* access modifiers changed from: private */
    @OOXIXo
    public static final String TAG;
    @oOoXoXO
    private final Object wrapped;

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final String getTAG() {
            return NetworkRequestCompat.TAG;
        }

        private Companion() {
        }
    }

    static {
        String tagWithPrefix = Logger.tagWithPrefix("NetworkRequestCompat");
        IIX0o.oO(tagWithPrefix, "tagWithPrefix(\"NetworkRequestCompat\")");
        TAG = tagWithPrefix;
    }

    public NetworkRequestCompat() {
        this((Object) null, 1, (IIXOooo) null);
    }

    public static /* synthetic */ NetworkRequestCompat copy$default(NetworkRequestCompat networkRequestCompat, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = networkRequestCompat.wrapped;
        }
        return networkRequestCompat.copy(obj);
    }

    @oOoXoXO
    public final Object component1() {
        return this.wrapped;
    }

    @OOXIXo
    public final NetworkRequestCompat copy(@oOoXoXO Object obj) {
        return new NetworkRequestCompat(obj);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NetworkRequestCompat) && IIX0o.Oxx0IOOO(this.wrapped, ((NetworkRequestCompat) obj).wrapped);
    }

    @RequiresApi(21)
    @oOoXoXO
    public final NetworkRequest getNetworkRequest() {
        return (NetworkRequest) this.wrapped;
    }

    @oOoXoXO
    public final Object getWrapped() {
        return this.wrapped;
    }

    public int hashCode() {
        Object obj = this.wrapped;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "NetworkRequestCompat(wrapped=" + this.wrapped + HexStringBuilder.COMMENT_END_CHAR;
    }

    public NetworkRequestCompat(@oOoXoXO Object obj) {
        this.wrapped = obj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NetworkRequestCompat(Object obj, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? null : obj);
    }
}
