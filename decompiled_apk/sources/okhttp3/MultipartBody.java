package okhttp3;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import XO0OX.x0XOIxOo;
import XO0OX.xoIox;
import XO0OX.xxIXOIIO;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* loaded from: classes6.dex */
public final class MultipartBody extends RequestBody {

    @OOXIXo
    @XO
    public static final MediaType ALTERNATIVE;

    @OOXIXo
    private static final byte[] COLONSPACE;

    @OOXIXo
    private static final byte[] CRLF;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final byte[] DASHDASH;

    @OOXIXo
    @XO
    public static final MediaType DIGEST;

    @OOXIXo
    @XO
    public static final MediaType FORM;

    @OOXIXo
    @XO
    public static final MediaType MIXED;

    @OOXIXo
    @XO
    public static final MediaType PARALLEL;

    @OOXIXo
    private final ByteString boundaryByteString;
    private long contentLength;

    @OOXIXo
    private final MediaType contentType;

    @OOXIXo
    private final List<Part> parts;

    @OOXIXo
    private final MediaType type;

    @XX({"SMAP\nMultipartBody.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultipartBody.kt\nokhttp3/MultipartBody$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,345:1\n1#2:346\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class Builder {

        @OOXIXo
        private final ByteString boundary;

        @OOXIXo
        private final List<Part> parts;

        @OOXIXo
        private MediaType type;

        /* JADX WARN: Multi-variable type inference failed */
        @xoIox
        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @OOXIXo
        public final Builder addFormDataPart(@OOXIXo String name, @OOXIXo String value) {
            IIX0o.x0xO0oo(name, "name");
            IIX0o.x0xO0oo(value, "value");
            addPart(Part.Companion.createFormData(name, value));
            return this;
        }

        @OOXIXo
        public final Builder addPart(@OOXIXo RequestBody body) {
            IIX0o.x0xO0oo(body, "body");
            addPart(Part.Companion.create(body));
            return this;
        }

        @OOXIXo
        public final MultipartBody build() {
            if (!this.parts.isEmpty()) {
                return new MultipartBody(this.boundary, this.type, Util.toImmutableList(this.parts));
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }

        @OOXIXo
        public final Builder setType(@OOXIXo MediaType type) {
            IIX0o.x0xO0oo(type, "type");
            if (IIX0o.Oxx0IOOO(type.type(), "multipart")) {
                this.type = type;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + type).toString());
        }

        @xoIox
        public Builder(@OOXIXo String boundary) {
            IIX0o.x0xO0oo(boundary, "boundary");
            this.boundary = ByteString.Companion.encodeUtf8(boundary);
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
        }

        @OOXIXo
        public final Builder addFormDataPart(@OOXIXo String name, @oOoXoXO String str, @OOXIXo RequestBody body) {
            IIX0o.x0xO0oo(name, "name");
            IIX0o.x0xO0oo(body, "body");
            addPart(Part.Companion.createFormData(name, str, body));
            return this;
        }

        @OOXIXo
        public final Builder addPart(@oOoXoXO Headers headers, @OOXIXo RequestBody body) {
            IIX0o.x0xO0oo(body, "body");
            addPart(Part.Companion.create(headers, body));
            return this;
        }

        @OOXIXo
        public final Builder addPart(@OOXIXo Part part) {
            IIX0o.x0xO0oo(part, "part");
            this.parts.add(part);
            return this;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ Builder(java.lang.String r1, int r2, kotlin.jvm.internal.IIXOooo r3) {
            /*
                r0 = this;
                r2 = r2 & 1
                if (r2 == 0) goto L11
                java.util.UUID r1 = java.util.UUID.randomUUID()
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "randomUUID().toString()"
                kotlin.jvm.internal.IIX0o.oO(r1, r2)
            L11:
                r0.<init>(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.MultipartBody.Builder.<init>(java.lang.String, int, kotlin.jvm.internal.IIXOooo):void");
        }
    }

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        public final void appendQuotedString$okhttp(@OOXIXo StringBuilder sb, @OOXIXo String key) {
            IIX0o.x0xO0oo(sb, "<this>");
            IIX0o.x0xO0oo(key, "key");
            sb.append('\"');
            int length = key.length();
            for (int i = 0; i < length; i++) {
                char charAt = key.charAt(i);
                if (charAt == '\n') {
                    sb.append("%0A");
                } else if (charAt == '\r') {
                    sb.append("%0D");
                } else if (charAt == '\"') {
                    sb.append("%22");
                } else {
                    sb.append(charAt);
                }
            }
            sb.append('\"');
        }

        private Companion() {
        }
    }

    /* loaded from: classes6.dex */
    public static final class Part {

        @OOXIXo
        public static final Companion Companion = new Companion(null);

        @OOXIXo
        private final RequestBody body;

        @oOoXoXO
        private final Headers headers;

        @XX({"SMAP\nMultipartBody.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultipartBody.kt\nokhttp3/MultipartBody$Part$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,345:1\n1#2:346\n*E\n"})
        /* loaded from: classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @x0XOIxOo
            @OOXIXo
            public final Part create(@OOXIXo RequestBody body) {
                IIX0o.x0xO0oo(body, "body");
                return create(null, body);
            }

            @x0XOIxOo
            @OOXIXo
            public final Part createFormData(@OOXIXo String name, @OOXIXo String value) {
                IIX0o.x0xO0oo(name, "name");
                IIX0o.x0xO0oo(value, "value");
                return createFormData(name, null, RequestBody.Companion.create$default(RequestBody.Companion, value, (MediaType) null, 1, (Object) null));
            }

            private Companion() {
            }

            @x0XOIxOo
            @OOXIXo
            public final Part create(@oOoXoXO Headers headers, @OOXIXo RequestBody body) {
                IIX0o.x0xO0oo(body, "body");
                IIXOooo iIXOooo = null;
                if ((headers != null ? headers.get("Content-Type") : null) == null) {
                    if ((headers != null ? headers.get("Content-Length") : null) == null) {
                        return new Part(headers, body, iIXOooo);
                    }
                    throw new IllegalArgumentException("Unexpected header: Content-Length");
                }
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }

            @x0XOIxOo
            @OOXIXo
            public final Part createFormData(@OOXIXo String name, @oOoXoXO String str, @OOXIXo RequestBody body) {
                IIX0o.x0xO0oo(name, "name");
                IIX0o.x0xO0oo(body, "body");
                StringBuilder sb = new StringBuilder();
                sb.append("form-data; name=");
                Companion companion = MultipartBody.Companion;
                companion.appendQuotedString$okhttp(sb, name);
                if (str != null) {
                    sb.append("; filename=");
                    companion.appendQuotedString$okhttp(sb, str);
                }
                String sb2 = sb.toString();
                IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
                return create(new Headers.Builder().addUnsafeNonAscii("Content-Disposition", sb2).build(), body);
            }
        }

        public /* synthetic */ Part(Headers headers, RequestBody requestBody, IIXOooo iIXOooo) {
            this(headers, requestBody);
        }

        @x0XOIxOo
        @OOXIXo
        public static final Part create(@oOoXoXO Headers headers, @OOXIXo RequestBody requestBody) {
            return Companion.create(headers, requestBody);
        }

        @x0XOIxOo
        @OOXIXo
        public static final Part createFormData(@OOXIXo String str, @OOXIXo String str2) {
            return Companion.createFormData(str, str2);
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "body", imports = {}))
        @OOXIXo
        @xxIXOIIO(name = "-deprecated_body")
        /* renamed from: -deprecated_body, reason: not valid java name */
        public final RequestBody m383deprecated_body() {
            return this.body;
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = TTDownloadField.TT_HEADERS, imports = {}))
        @xxIXOIIO(name = "-deprecated_headers")
        @oOoXoXO
        /* renamed from: -deprecated_headers, reason: not valid java name */
        public final Headers m384deprecated_headers() {
            return this.headers;
        }

        @OOXIXo
        @xxIXOIIO(name = "body")
        public final RequestBody body() {
            return this.body;
        }

        @xxIXOIIO(name = TTDownloadField.TT_HEADERS)
        @oOoXoXO
        public final Headers headers() {
            return this.headers;
        }

        private Part(Headers headers, RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }

        @x0XOIxOo
        @OOXIXo
        public static final Part create(@OOXIXo RequestBody requestBody) {
            return Companion.create(requestBody);
        }

        @x0XOIxOo
        @OOXIXo
        public static final Part createFormData(@OOXIXo String str, @oOoXoXO String str2, @OOXIXo RequestBody requestBody) {
            return Companion.createFormData(str, str2, requestBody);
        }
    }

    static {
        MediaType.Companion companion = MediaType.Companion;
        MIXED = companion.get("multipart/mixed");
        ALTERNATIVE = companion.get("multipart/alternative");
        DIGEST = companion.get("multipart/digest");
        PARALLEL = companion.get("multipart/parallel");
        FORM = companion.get("multipart/form-data");
        COLONSPACE = new byte[]{58, 32};
        CRLF = new byte[]{13, 10};
        DASHDASH = new byte[]{45, 45};
    }

    public MultipartBody(@OOXIXo ByteString boundaryByteString, @OOXIXo MediaType type, @OOXIXo List<Part> parts) {
        IIX0o.x0xO0oo(boundaryByteString, "boundaryByteString");
        IIX0o.x0xO0oo(type, "type");
        IIX0o.x0xO0oo(parts, "parts");
        this.boundaryByteString = boundaryByteString;
        this.type = type;
        this.parts = parts;
        this.contentType = MediaType.Companion.get(type + "; boundary=" + boundary());
        this.contentLength = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long writeOrCountBytes(BufferedSink bufferedSink, boolean z) throws IOException {
        Buffer buffer;
        if (z) {
            bufferedSink = new Buffer();
            buffer = bufferedSink;
        } else {
            buffer = 0;
        }
        int size = this.parts.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            Part part = this.parts.get(i);
            Headers headers = part.headers();
            RequestBody body = part.body();
            IIX0o.ooOOo0oXI(bufferedSink);
            bufferedSink.write(DASHDASH);
            bufferedSink.write(this.boundaryByteString);
            bufferedSink.write(CRLF);
            if (headers != null) {
                int size2 = headers.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    bufferedSink.writeUtf8(headers.name(i2)).write(COLONSPACE).writeUtf8(headers.value(i2)).write(CRLF);
                }
            }
            MediaType contentType = body.contentType();
            if (contentType != null) {
                bufferedSink.writeUtf8("Content-Type: ").writeUtf8(contentType.toString()).write(CRLF);
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                bufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(contentLength).write(CRLF);
            } else if (z) {
                IIX0o.ooOOo0oXI(buffer);
                buffer.clear();
                return -1L;
            }
            byte[] bArr = CRLF;
            bufferedSink.write(bArr);
            if (z) {
                j += contentLength;
            } else {
                body.writeTo(bufferedSink);
            }
            bufferedSink.write(bArr);
        }
        IIX0o.ooOOo0oXI(bufferedSink);
        byte[] bArr2 = DASHDASH;
        bufferedSink.write(bArr2);
        bufferedSink.write(this.boundaryByteString);
        bufferedSink.write(bArr2);
        bufferedSink.write(CRLF);
        if (z) {
            IIX0o.ooOOo0oXI(buffer);
            long size3 = j + buffer.size();
            buffer.clear();
            return size3;
        }
        return j;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "boundary", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_boundary")
    /* renamed from: -deprecated_boundary, reason: not valid java name */
    public final String m379deprecated_boundary() {
        return boundary();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "parts", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_parts")
    /* renamed from: -deprecated_parts, reason: not valid java name */
    public final List<Part> m380deprecated_parts() {
        return this.parts;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE, imports = {}))
    @xxIXOIIO(name = "-deprecated_size")
    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m381deprecated_size() {
        return size();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "type", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_type")
    /* renamed from: -deprecated_type, reason: not valid java name */
    public final MediaType m382deprecated_type() {
        return this.type;
    }

    @OOXIXo
    @xxIXOIIO(name = "boundary")
    public final String boundary() {
        return this.boundaryByteString.utf8();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        long j = this.contentLength;
        if (j == -1) {
            long writeOrCountBytes = writeOrCountBytes(null, true);
            this.contentLength = writeOrCountBytes;
            return writeOrCountBytes;
        }
        return j;
    }

    @Override // okhttp3.RequestBody
    @OOXIXo
    public MediaType contentType() {
        return this.contentType;
    }

    @OOXIXo
    public final Part part(int i) {
        return this.parts.get(i);
    }

    @OOXIXo
    @xxIXOIIO(name = "parts")
    public final List<Part> parts() {
        return this.parts;
    }

    @xxIXOIIO(name = MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE)
    public final int size() {
        return this.parts.size();
    }

    @OOXIXo
    @xxIXOIIO(name = "type")
    public final MediaType type() {
        return this.type;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(@OOXIXo BufferedSink sink) throws IOException {
        IIX0o.x0xO0oo(sink, "sink");
        writeOrCountBytes(sink, false);
    }
}
