package okhttp3;

import OXOo.OOXIXo;
import XO0OX.XO;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public interface CookieJar {

    @OOXIXo
    public static final Companion Companion = Companion.$$INSTANCE;

    @OOXIXo
    @XO
    public static final CookieJar NO_COOKIES = new Companion.NoCookies();

    /* loaded from: classes6.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* loaded from: classes6.dex */
        public static final class NoCookies implements CookieJar {
            @Override // okhttp3.CookieJar
            @OOXIXo
            public List<Cookie> loadForRequest(@OOXIXo HttpUrl url) {
                IIX0o.x0xO0oo(url, "url");
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }

            @Override // okhttp3.CookieJar
            public void saveFromResponse(@OOXIXo HttpUrl url, @OOXIXo List<Cookie> cookies) {
                IIX0o.x0xO0oo(url, "url");
                IIX0o.x0xO0oo(cookies, "cookies");
            }
        }

        private Companion() {
        }
    }

    @OOXIXo
    List<Cookie> loadForRequest(@OOXIXo HttpUrl httpUrl);

    void saveFromResponse(@OOXIXo HttpUrl httpUrl, @OOXIXo List<Cookie> list);
}
