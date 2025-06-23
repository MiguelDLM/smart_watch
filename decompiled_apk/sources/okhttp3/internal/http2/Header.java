package okhttp3.internal.http2;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import okio.ByteString;

/* loaded from: classes6.dex */
public final class Header {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    @XO
    public static final ByteString PSEUDO_PREFIX;

    @OOXIXo
    @XO
    public static final ByteString RESPONSE_STATUS;

    @OOXIXo
    public static final String RESPONSE_STATUS_UTF8 = ":status";

    @OOXIXo
    @XO
    public static final ByteString TARGET_AUTHORITY;

    @OOXIXo
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";

    @OOXIXo
    @XO
    public static final ByteString TARGET_METHOD;

    @OOXIXo
    public static final String TARGET_METHOD_UTF8 = ":method";

    @OOXIXo
    @XO
    public static final ByteString TARGET_PATH;

    @OOXIXo
    public static final String TARGET_PATH_UTF8 = ":path";

    @OOXIXo
    @XO
    public static final ByteString TARGET_SCHEME;

    @OOXIXo
    public static final String TARGET_SCHEME_UTF8 = ":scheme";

    @XO
    public final int hpackSize;

    @OOXIXo
    @XO
    public final ByteString name;

    @OOXIXo
    @XO
    public final ByteString value;

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    static {
        ByteString.Companion companion = ByteString.Companion;
        PSEUDO_PREFIX = companion.encodeUtf8(":");
        RESPONSE_STATUS = companion.encodeUtf8(RESPONSE_STATUS_UTF8);
        TARGET_METHOD = companion.encodeUtf8(TARGET_METHOD_UTF8);
        TARGET_PATH = companion.encodeUtf8(TARGET_PATH_UTF8);
        TARGET_SCHEME = companion.encodeUtf8(TARGET_SCHEME_UTF8);
        TARGET_AUTHORITY = companion.encodeUtf8(TARGET_AUTHORITY_UTF8);
    }

    public Header(@OOXIXo ByteString name, @OOXIXo ByteString value) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(value, "value");
        this.name = name;
        this.value = value;
        this.hpackSize = name.size() + 32 + value.size();
    }

    public static /* synthetic */ Header copy$default(Header header, ByteString byteString, ByteString byteString2, int i, Object obj) {
        if ((i & 1) != 0) {
            byteString = header.name;
        }
        if ((i & 2) != 0) {
            byteString2 = header.value;
        }
        return header.copy(byteString, byteString2);
    }

    @OOXIXo
    public final ByteString component1() {
        return this.name;
    }

    @OOXIXo
    public final ByteString component2() {
        return this.value;
    }

    @OOXIXo
    public final Header copy(@OOXIXo ByteString name, @OOXIXo ByteString value) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(value, "value");
        return new Header(name, value);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return IIX0o.Oxx0IOOO(this.name, header.name) && IIX0o.Oxx0IOOO(this.value, header.value);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.value.hashCode();
    }

    @OOXIXo
    public String toString() {
        return this.name.utf8() + ": " + this.value.utf8();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Header(@OXOo.OOXIXo java.lang.String r2, @OXOo.OOXIXo java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            okio.ByteString$Companion r0 = okio.ByteString.Companion
            okio.ByteString r2 = r0.encodeUtf8(r2)
            okio.ByteString r3 = r0.encodeUtf8(r3)
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Header.<init>(java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(@OOXIXo ByteString name, @OOXIXo String value) {
        this(name, ByteString.Companion.encodeUtf8(value));
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(value, "value");
    }
}
