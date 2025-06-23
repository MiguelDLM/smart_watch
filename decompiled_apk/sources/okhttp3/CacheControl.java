package okhttp3;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import XO0OX.x0XOIxOo;
import XO0OX.xxIXOIIO;
import java.util.concurrent.TimeUnit;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes6.dex */
public final class CacheControl {

    @oOoXoXO
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    @XO
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();

    @OOXIXo
    @XO
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();

    @XX({"SMAP\nCacheControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CacheControl.kt\nokhttp3/CacheControl$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,416:1\n1#2:417\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        private final int clampToInt(long j) {
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) j;
        }

        @OOXIXo
        public final CacheControl build() {
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, null, null);
        }

        @OOXIXo
        public final Builder immutable() {
            this.immutable = true;
            return this;
        }

        @OOXIXo
        public final Builder maxAge(int i, @OOXIXo TimeUnit timeUnit) {
            IIX0o.x0xO0oo(timeUnit, "timeUnit");
            if (i >= 0) {
                this.maxAgeSeconds = clampToInt(timeUnit.toSeconds(i));
                return this;
            }
            throw new IllegalArgumentException(("maxAge < 0: " + i).toString());
        }

        @OOXIXo
        public final Builder maxStale(int i, @OOXIXo TimeUnit timeUnit) {
            IIX0o.x0xO0oo(timeUnit, "timeUnit");
            if (i >= 0) {
                this.maxStaleSeconds = clampToInt(timeUnit.toSeconds(i));
                return this;
            }
            throw new IllegalArgumentException(("maxStale < 0: " + i).toString());
        }

        @OOXIXo
        public final Builder minFresh(int i, @OOXIXo TimeUnit timeUnit) {
            IIX0o.x0xO0oo(timeUnit, "timeUnit");
            if (i >= 0) {
                this.minFreshSeconds = clampToInt(timeUnit.toSeconds(i));
                return this;
            }
            throw new IllegalArgumentException(("minFresh < 0: " + i).toString());
        }

        @OOXIXo
        public final Builder noCache() {
            this.noCache = true;
            return this;
        }

        @OOXIXo
        public final Builder noStore() {
            this.noStore = true;
            return this;
        }

        @OOXIXo
        public final Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        @OOXIXo
        public final Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }
    }

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private final int indexOfElement(String str, String str2, int i) {
            int length = str.length();
            while (i < length) {
                if (StringsKt__StringsKt.xXo(str2, str.charAt(i), false, 2, null)) {
                    return i;
                }
                i++;
            }
            return str.length();
        }

        public static /* synthetic */ int indexOfElement$default(Companion companion, String str, String str2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.indexOfElement(str, str2, i);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00d8 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:85:0x00d0 A[SYNTHETIC] */
        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final okhttp3.CacheControl parse(@OXOo.OOXIXo okhttp3.Headers r31) {
            /*
                Method dump skipped, instructions count: 424
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.CacheControl.Companion.parse(okhttp3.Headers):okhttp3.CacheControl");
        }

        private Companion() {
        }
    }

    public /* synthetic */ CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str, IIXOooo iIXOooo) {
        this(z, z2, i, i2, z3, z4, z5, i3, i4, z6, z7, z8, str);
    }

    @x0XOIxOo
    @OOXIXo
    public static final CacheControl parse(@OOXIXo Headers headers) {
        return Companion.parse(headers);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "immutable", imports = {}))
    @xxIXOIIO(name = "-deprecated_immutable")
    /* renamed from: -deprecated_immutable, reason: not valid java name */
    public final boolean m313deprecated_immutable() {
        return this.immutable;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "maxAgeSeconds", imports = {}))
    @xxIXOIIO(name = "-deprecated_maxAgeSeconds")
    /* renamed from: -deprecated_maxAgeSeconds, reason: not valid java name */
    public final int m314deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "maxStaleSeconds", imports = {}))
    @xxIXOIIO(name = "-deprecated_maxStaleSeconds")
    /* renamed from: -deprecated_maxStaleSeconds, reason: not valid java name */
    public final int m315deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "minFreshSeconds", imports = {}))
    @xxIXOIIO(name = "-deprecated_minFreshSeconds")
    /* renamed from: -deprecated_minFreshSeconds, reason: not valid java name */
    public final int m316deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "mustRevalidate", imports = {}))
    @xxIXOIIO(name = "-deprecated_mustRevalidate")
    /* renamed from: -deprecated_mustRevalidate, reason: not valid java name */
    public final boolean m317deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "noCache", imports = {}))
    @xxIXOIIO(name = "-deprecated_noCache")
    /* renamed from: -deprecated_noCache, reason: not valid java name */
    public final boolean m318deprecated_noCache() {
        return this.noCache;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "noStore", imports = {}))
    @xxIXOIIO(name = "-deprecated_noStore")
    /* renamed from: -deprecated_noStore, reason: not valid java name */
    public final boolean m319deprecated_noStore() {
        return this.noStore;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "noTransform", imports = {}))
    @xxIXOIIO(name = "-deprecated_noTransform")
    /* renamed from: -deprecated_noTransform, reason: not valid java name */
    public final boolean m320deprecated_noTransform() {
        return this.noTransform;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "onlyIfCached", imports = {}))
    @xxIXOIIO(name = "-deprecated_onlyIfCached")
    /* renamed from: -deprecated_onlyIfCached, reason: not valid java name */
    public final boolean m321deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "sMaxAgeSeconds", imports = {}))
    @xxIXOIIO(name = "-deprecated_sMaxAgeSeconds")
    /* renamed from: -deprecated_sMaxAgeSeconds, reason: not valid java name */
    public final int m322deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    @xxIXOIIO(name = "immutable")
    public final boolean immutable() {
        return this.immutable;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    @xxIXOIIO(name = "maxAgeSeconds")
    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @xxIXOIIO(name = "maxStaleSeconds")
    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @xxIXOIIO(name = "minFreshSeconds")
    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @xxIXOIIO(name = "mustRevalidate")
    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    @xxIXOIIO(name = "noCache")
    public final boolean noCache() {
        return this.noCache;
    }

    @xxIXOIIO(name = "noStore")
    public final boolean noStore() {
        return this.noStore;
    }

    @xxIXOIIO(name = "noTransform")
    public final boolean noTransform() {
        return this.noTransform;
    }

    @xxIXOIIO(name = "onlyIfCached")
    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    @xxIXOIIO(name = "sMaxAgeSeconds")
    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    @OOXIXo
    public String toString() {
        String str = this.headerValue;
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            if (this.noCache) {
                sb.append("no-cache, ");
            }
            if (this.noStore) {
                sb.append("no-store, ");
            }
            if (this.maxAgeSeconds != -1) {
                sb.append("max-age=");
                sb.append(this.maxAgeSeconds);
                sb.append(", ");
            }
            if (this.sMaxAgeSeconds != -1) {
                sb.append("s-maxage=");
                sb.append(this.sMaxAgeSeconds);
                sb.append(", ");
            }
            if (this.isPrivate) {
                sb.append("private, ");
            }
            if (this.isPublic) {
                sb.append("public, ");
            }
            if (this.mustRevalidate) {
                sb.append("must-revalidate, ");
            }
            if (this.maxStaleSeconds != -1) {
                sb.append("max-stale=");
                sb.append(this.maxStaleSeconds);
                sb.append(", ");
            }
            if (this.minFreshSeconds != -1) {
                sb.append("min-fresh=");
                sb.append(this.minFreshSeconds);
                sb.append(", ");
            }
            if (this.onlyIfCached) {
                sb.append("only-if-cached, ");
            }
            if (this.noTransform) {
                sb.append("no-transform, ");
            }
            if (this.immutable) {
                sb.append("immutable, ");
            }
            if (sb.length() == 0) {
                return "";
            }
            sb.delete(sb.length() - 2, sb.length());
            String sb2 = sb.toString();
            IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
            this.headerValue = sb2;
            return sb2;
        }
        return str;
    }

    private CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.noCache = z;
        this.noStore = z2;
        this.maxAgeSeconds = i;
        this.sMaxAgeSeconds = i2;
        this.isPrivate = z3;
        this.isPublic = z4;
        this.mustRevalidate = z5;
        this.maxStaleSeconds = i3;
        this.minFreshSeconds = i4;
        this.onlyIfCached = z6;
        this.noTransform = z7;
        this.immutable = z8;
        this.headerValue = str;
    }
}
