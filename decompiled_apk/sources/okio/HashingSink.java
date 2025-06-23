package okio;

import XO0OX.x0XOIxOo;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.digest.MessageDigestAlgorithms;
import java.io.IOException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nHashingSink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HashingSink.kt\nokio/HashingSink\n+ 2 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,148:1\n86#2:149\n*S KotlinDebug\n*F\n+ 1 HashingSink.kt\nokio/HashingSink\n*L\n75#1:149\n*E\n"})
/* loaded from: classes6.dex */
public final class HashingSink extends ForwardingSink implements Sink {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.oOoXoXO
    private final Mac mac;

    @OXOo.oOoXoXO
    private final MessageDigest messageDigest;

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final HashingSink hmacSha1(@OXOo.OOXIXo Sink sink, @OXOo.OOXIXo ByteString key) {
            IIX0o.x0xO0oo(sink, "sink");
            IIX0o.x0xO0oo(key, "key");
            return new HashingSink(sink, key, "HmacSHA1");
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final HashingSink hmacSha256(@OXOo.OOXIXo Sink sink, @OXOo.OOXIXo ByteString key) {
            IIX0o.x0xO0oo(sink, "sink");
            IIX0o.x0xO0oo(key, "key");
            return new HashingSink(sink, key, "HmacSHA256");
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final HashingSink hmacSha512(@OXOo.OOXIXo Sink sink, @OXOo.OOXIXo ByteString key) {
            IIX0o.x0xO0oo(sink, "sink");
            IIX0o.x0xO0oo(key, "key");
            return new HashingSink(sink, key, "HmacSHA512");
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final HashingSink md5(@OXOo.OOXIXo Sink sink) {
            IIX0o.x0xO0oo(sink, "sink");
            return new HashingSink(sink, "MD5");
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final HashingSink sha1(@OXOo.OOXIXo Sink sink) {
            IIX0o.x0xO0oo(sink, "sink");
            return new HashingSink(sink, MessageDigestAlgorithms.SHA_1);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final HashingSink sha256(@OXOo.OOXIXo Sink sink) {
            IIX0o.x0xO0oo(sink, "sink");
            return new HashingSink(sink, MessageDigestAlgorithms.SHA_256);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final HashingSink sha512(@OXOo.OOXIXo Sink sink) {
            IIX0o.x0xO0oo(sink, "sink");
            return new HashingSink(sink, MessageDigestAlgorithms.SHA_512);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(@OXOo.OOXIXo Sink sink, @OXOo.OOXIXo MessageDigest digest) {
        super(sink);
        IIX0o.x0xO0oo(sink, "sink");
        IIX0o.x0xO0oo(digest, "digest");
        this.messageDigest = digest;
        this.mac = null;
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final HashingSink hmacSha1(@OXOo.OOXIXo Sink sink, @OXOo.OOXIXo ByteString byteString) {
        return Companion.hmacSha1(sink, byteString);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final HashingSink hmacSha256(@OXOo.OOXIXo Sink sink, @OXOo.OOXIXo ByteString byteString) {
        return Companion.hmacSha256(sink, byteString);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final HashingSink hmacSha512(@OXOo.OOXIXo Sink sink, @OXOo.OOXIXo ByteString byteString) {
        return Companion.hmacSha512(sink, byteString);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final HashingSink md5(@OXOo.OOXIXo Sink sink) {
        return Companion.md5(sink);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final HashingSink sha1(@OXOo.OOXIXo Sink sink) {
        return Companion.sha1(sink);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final HashingSink sha256(@OXOo.OOXIXo Sink sink) {
        return Companion.sha256(sink);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final HashingSink sha512(@OXOo.OOXIXo Sink sink) {
        return Companion.sha512(sink);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "hash", imports = {}))
    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "-deprecated_hash")
    /* renamed from: -deprecated_hash, reason: not valid java name */
    public final ByteString m454deprecated_hash() {
        return hash();
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "hash")
    public final ByteString hash() {
        byte[] doFinal;
        MessageDigest messageDigest = this.messageDigest;
        if (messageDigest != null) {
            doFinal = messageDigest.digest();
        } else {
            Mac mac = this.mac;
            IIX0o.ooOOo0oXI(mac);
            doFinal = mac.doFinal();
        }
        IIX0o.ooOOo0oXI(doFinal);
        return new ByteString(doFinal);
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(@OXOo.OOXIXo Buffer source, long j) throws IOException {
        IIX0o.x0xO0oo(source, "source");
        SegmentedByteString.checkOffsetAndCount(source.size(), 0L, j);
        Segment segment = source.head;
        IIX0o.ooOOo0oXI(segment);
        long j2 = 0;
        while (j2 < j) {
            int min = (int) Math.min(j - j2, segment.limit - segment.pos);
            MessageDigest messageDigest = this.messageDigest;
            if (messageDigest != null) {
                messageDigest.update(segment.data, segment.pos, min);
            } else {
                Mac mac = this.mac;
                IIX0o.ooOOo0oXI(mac);
                mac.update(segment.data, segment.pos, min);
            }
            j2 += min;
            segment = segment.next;
            IIX0o.ooOOo0oXI(segment);
        }
        super.write(source, j);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public HashingSink(@OXOo.OOXIXo okio.Sink r2, @OXOo.OOXIXo java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            java.lang.String r0 = "algorithm"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)
            java.lang.String r0 = "getInstance(...)"
            kotlin.jvm.internal.IIX0o.oO(r3, r0)
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.HashingSink.<init>(okio.Sink, java.lang.String):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(@OXOo.OOXIXo Sink sink, @OXOo.OOXIXo Mac mac) {
        super(sink);
        IIX0o.x0xO0oo(sink, "sink");
        IIX0o.x0xO0oo(mac, "mac");
        this.mac = mac;
        this.messageDigest = null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public HashingSink(@OXOo.OOXIXo okio.Sink r3, @OXOo.OOXIXo okio.ByteString r4, @OXOo.OOXIXo java.lang.String r5) {
        /*
            r2 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
            java.lang.String r0 = "algorithm"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r0)
            javax.crypto.Mac r0 = javax.crypto.Mac.getInstance(r5)     // Catch: java.security.InvalidKeyException -> L28
            javax.crypto.spec.SecretKeySpec r1 = new javax.crypto.spec.SecretKeySpec     // Catch: java.security.InvalidKeyException -> L28
            byte[] r4 = r4.toByteArray()     // Catch: java.security.InvalidKeyException -> L28
            r1.<init>(r4, r5)     // Catch: java.security.InvalidKeyException -> L28
            r0.init(r1)     // Catch: java.security.InvalidKeyException -> L28
            kotlin.oXIO0o0XI r4 = kotlin.oXIO0o0XI.f29392oIX0oI     // Catch: java.security.InvalidKeyException -> L28
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r0)
            r2.<init>(r3, r0)
            return
        L28:
            r3 = move-exception
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.HashingSink.<init>(okio.Sink, okio.ByteString, java.lang.String):void");
    }
}
