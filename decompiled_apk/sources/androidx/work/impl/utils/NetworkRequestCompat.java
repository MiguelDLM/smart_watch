package androidx.work.impl.utils;

import android.net.NetworkRequest;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes.dex */
public final class NetworkRequestCompat {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private static final String TAG;

    @OXOo.oOoXoXO
    private final Object wrapped;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
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

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public NetworkRequestCompat() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.NetworkRequestCompat.<init>():void");
    }

    public static /* synthetic */ NetworkRequestCompat copy$default(NetworkRequestCompat networkRequestCompat, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = networkRequestCompat.wrapped;
        }
        return networkRequestCompat.copy(obj);
    }

    @OXOo.oOoXoXO
    public final Object component1() {
        return this.wrapped;
    }

    @OXOo.OOXIXo
    public final NetworkRequestCompat copy(@OXOo.oOoXoXO Object obj) {
        return new NetworkRequestCompat(obj);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NetworkRequestCompat) && IIX0o.Oxx0IOOO(this.wrapped, ((NetworkRequestCompat) obj).wrapped);
    }

    @RequiresApi(21)
    @OXOo.oOoXoXO
    public final NetworkRequest getNetworkRequest() {
        return (NetworkRequest) this.wrapped;
    }

    @OXOo.oOoXoXO
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

    @OXOo.OOXIXo
    public String toString() {
        return "NetworkRequestCompat(wrapped=" + this.wrapped + HexStringBuilder.COMMENT_END_CHAR;
    }

    public NetworkRequestCompat(@OXOo.oOoXoXO Object obj) {
        this.wrapped = obj;
    }

    public /* synthetic */ NetworkRequestCompat(Object obj, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? null : obj);
    }
}
