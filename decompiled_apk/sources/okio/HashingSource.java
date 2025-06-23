package okio;

import XO0OX.x0XOIxOo;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.digest.MessageDigestAlgorithms;
import java.io.IOException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes6.dex */
public final class HashingSource extends ForwardingSource implements Source {

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
        public final HashingSource hmacSha1(@OXOo.OOXIXo Source source, @OXOo.OOXIXo ByteString key) {
            IIX0o.x0xO0oo(source, "source");
            IIX0o.x0xO0oo(key, "key");
            return new HashingSource(source, key, "HmacSHA1");
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final HashingSource hmacSha256(@OXOo.OOXIXo Source source, @OXOo.OOXIXo ByteString key) {
            IIX0o.x0xO0oo(source, "source");
            IIX0o.x0xO0oo(key, "key");
            return new HashingSource(source, key, "HmacSHA256");
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final HashingSource hmacSha512(@OXOo.OOXIXo Source source, @OXOo.OOXIXo ByteString key) {
            IIX0o.x0xO0oo(source, "source");
            IIX0o.x0xO0oo(key, "key");
            return new HashingSource(source, key, "HmacSHA512");
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final HashingSource md5(@OXOo.OOXIXo Source source) {
            IIX0o.x0xO0oo(source, "source");
            return new HashingSource(source, "MD5");
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final HashingSource sha1(@OXOo.OOXIXo Source source) {
            IIX0o.x0xO0oo(source, "source");
            return new HashingSource(source, MessageDigestAlgorithms.SHA_1);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final HashingSource sha256(@OXOo.OOXIXo Source source) {
            IIX0o.x0xO0oo(source, "source");
            return new HashingSource(source, MessageDigestAlgorithms.SHA_256);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final HashingSource sha512(@OXOo.OOXIXo Source source) {
            IIX0o.x0xO0oo(source, "source");
            return new HashingSource(source, MessageDigestAlgorithms.SHA_512);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(@OXOo.OOXIXo Source source, @OXOo.OOXIXo MessageDigest digest) {
        super(source);
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(digest, "digest");
        this.messageDigest = digest;
        this.mac = null;
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final HashingSource hmacSha1(@OXOo.OOXIXo Source source, @OXOo.OOXIXo ByteString byteString) {
        return Companion.hmacSha1(source, byteString);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final HashingSource hmacSha256(@OXOo.OOXIXo Source source, @OXOo.OOXIXo ByteString byteString) {
        return Companion.hmacSha256(source, byteString);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final HashingSource hmacSha512(@OXOo.OOXIXo Source source, @OXOo.OOXIXo ByteString byteString) {
        return Companion.hmacSha512(source, byteString);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final HashingSource md5(@OXOo.OOXIXo Source source) {
        return Companion.md5(source);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final HashingSource sha1(@OXOo.OOXIXo Source source) {
        return Companion.sha1(source);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final HashingSource sha256(@OXOo.OOXIXo Source source) {
        return Companion.sha256(source);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final HashingSource sha512(@OXOo.OOXIXo Source source) {
        return Companion.sha512(source);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = "hash", imports = {}))
    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "-deprecated_hash")
    /* renamed from: -deprecated_hash, reason: not valid java name */
    public final ByteString m455deprecated_hash() {
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

    @Override // okio.ForwardingSource, okio.Source
    public long read(@OXOo.OOXIXo Buffer sink, long j) throws IOException {
        IIX0o.x0xO0oo(sink, "sink");
        long read = super.read(sink, j);
        if (read != -1) {
            long size = sink.size() - read;
            long size2 = sink.size();
            Segment segment = sink.head;
            IIX0o.ooOOo0oXI(segment);
            while (size2 > size) {
                segment = segment.prev;
                IIX0o.ooOOo0oXI(segment);
                size2 -= segment.limit - segment.pos;
            }
            while (size2 < sink.size()) {
                int i = (int) ((segment.pos + size) - size2);
                MessageDigest messageDigest = this.messageDigest;
                if (messageDigest != null) {
                    messageDigest.update(segment.data, i, segment.limit - i);
                } else {
                    Mac mac = this.mac;
                    IIX0o.ooOOo0oXI(mac);
                    mac.update(segment.data, i, segment.limit - i);
                }
                size2 += segment.limit - segment.pos;
                segment = segment.next;
                IIX0o.ooOOo0oXI(segment);
                size = size2;
            }
        }
        return read;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public HashingSource(@OXOo.OOXIXo okio.Source r2, @OXOo.OOXIXo java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            java.lang.String r0 = "algorithm"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)
            java.lang.String r0 = "getInstance(...)"
            kotlin.jvm.internal.IIX0o.oO(r3, r0)
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.HashingSource.<init>(okio.Source, java.lang.String):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(@OXOo.OOXIXo Source source, @OXOo.OOXIXo Mac mac) {
        super(source);
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(mac, "mac");
        this.mac = mac;
        this.messageDigest = null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public HashingSource(@OXOo.OOXIXo okio.Source r3, @OXOo.OOXIXo okio.ByteString r4, @OXOo.OOXIXo java.lang.String r5) {
        /*
            r2 = this;
            java.lang.String r0 = "source"
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
        throw new UnsupportedOperationException("Method not decompiled: okio.HashingSource.<init>(okio.Source, okio.ByteString, java.lang.String):void");
    }
}
