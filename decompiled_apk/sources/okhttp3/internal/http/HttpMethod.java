package okhttp3.internal.http;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpDelete;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpHead;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpPatch;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpPut;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class HttpMethod {

    @OOXIXo
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    @x0XOIxOo
    public static final boolean permitsRequestBody(@OOXIXo String method) {
        IIX0o.x0xO0oo(method, "method");
        if (!IIX0o.Oxx0IOOO(method, "GET") && !IIX0o.Oxx0IOOO(method, HttpHead.METHOD_NAME)) {
            return true;
        }
        return false;
    }

    @x0XOIxOo
    public static final boolean requiresRequestBody(@OOXIXo String method) {
        IIX0o.x0xO0oo(method, "method");
        if (!IIX0o.Oxx0IOOO(method, "POST") && !IIX0o.Oxx0IOOO(method, HttpPut.METHOD_NAME) && !IIX0o.Oxx0IOOO(method, HttpPatch.METHOD_NAME) && !IIX0o.Oxx0IOOO(method, "PROPPATCH") && !IIX0o.Oxx0IOOO(method, "REPORT")) {
            return false;
        }
        return true;
    }

    public final boolean invalidatesCache(@OOXIXo String method) {
        IIX0o.x0xO0oo(method, "method");
        if (!IIX0o.Oxx0IOOO(method, "POST") && !IIX0o.Oxx0IOOO(method, HttpPatch.METHOD_NAME) && !IIX0o.Oxx0IOOO(method, HttpPut.METHOD_NAME) && !IIX0o.Oxx0IOOO(method, HttpDelete.METHOD_NAME) && !IIX0o.Oxx0IOOO(method, "MOVE")) {
            return false;
        }
        return true;
    }

    public final boolean redirectsToGet(@OOXIXo String method) {
        IIX0o.x0xO0oo(method, "method");
        return !IIX0o.Oxx0IOOO(method, "PROPFIND");
    }

    public final boolean redirectsWithBody(@OOXIXo String method) {
        IIX0o.x0xO0oo(method, "method");
        return IIX0o.Oxx0IOOO(method, "PROPFIND");
    }
}
