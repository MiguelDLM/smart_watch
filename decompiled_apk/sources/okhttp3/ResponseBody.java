package okhttp3;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import XO0OX.xxIXOIIO;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.DeprecationLevel;
import kotlin.io.II0xO0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;
import kotlin.text.oxoX;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

@XX({"SMAP\nResponseBody.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResponseBody.kt\nokhttp3/ResponseBody\n*L\n1#1,321:1\n140#1,11:322\n140#1,11:333\n*S KotlinDebug\n*F\n+ 1 ResponseBody.kt\nokhttp3/ResponseBody\n*L\n124#1:322,11\n134#1:333,11\n*E\n"})
/* loaded from: classes6.dex */
public abstract class ResponseBody implements Closeable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @oOoXoXO
    private Reader reader;

    @XX({"SMAP\nResponseBody.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResponseBody.kt\nokhttp3/ResponseBody$BomAwareReader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,321:1\n1#2:322\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class BomAwareReader extends Reader {

        @OOXIXo
        private final Charset charset;
        private boolean closed;

        @oOoXoXO
        private Reader delegate;

        @OOXIXo
        private final BufferedSource source;

        public BomAwareReader(@OOXIXo BufferedSource source, @OOXIXo Charset charset) {
            IIX0o.x0xO0oo(source, "source");
            IIX0o.x0xO0oo(charset, "charset");
            this.source = source;
            this.charset = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            oXIO0o0XI oxio0o0xi;
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
                oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            } else {
                oxio0o0xi = null;
            }
            if (oxio0o0xi == null) {
                this.source.close();
            }
        }

        @Override // java.io.Reader
        public int read(@OOXIXo char[] cbuf, int i, int i2) throws IOException {
            IIX0o.x0xO0oo(cbuf, "cbuf");
            if (!this.closed) {
                Reader reader = this.delegate;
                if (reader == null) {
                    reader = new InputStreamReader(this.source.inputStream(), Util.readBomAsCharset(this.source, this.charset));
                    this.delegate = reader;
                }
                return reader.read(cbuf, i, i2);
            }
            throw new IOException("Stream closed");
        }
    }

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, String str, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        @x0XOIxOo
        @OOXIXo
        @xxIXOIIO(name = "create")
        public final ResponseBody create(@OOXIXo String str, @oOoXoXO MediaType mediaType) {
            IIX0o.x0xO0oo(str, "<this>");
            Charset charset = oxoX.f29581II0xO0;
            if (mediaType != null) {
                Charset charset$default = MediaType.charset$default(mediaType, null, 1, null);
                if (charset$default == null) {
                    mediaType = MediaType.Companion.parse(mediaType + "; charset=utf-8");
                } else {
                    charset = charset$default;
                }
            }
            Buffer writeString = new Buffer().writeString(str, charset);
            return create(writeString, mediaType, writeString.size());
        }

        private Companion() {
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(bArr, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, BufferedSource bufferedSource, MediaType mediaType, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            if ((i & 2) != 0) {
                j = -1;
            }
            return companion.create(bufferedSource, mediaType, j);
        }

        @x0XOIxOo
        @OOXIXo
        @xxIXOIIO(name = "create")
        public final ResponseBody create(@OOXIXo byte[] bArr, @oOoXoXO MediaType mediaType) {
            IIX0o.x0xO0oo(bArr, "<this>");
            return create(new Buffer().write(bArr), mediaType, bArr.length);
        }

        @x0XOIxOo
        @OOXIXo
        @xxIXOIIO(name = "create")
        public final ResponseBody create(@OOXIXo ByteString byteString, @oOoXoXO MediaType mediaType) {
            IIX0o.x0xO0oo(byteString, "<this>");
            return create(new Buffer().write(byteString), mediaType, byteString.size());
        }

        @x0XOIxOo
        @OOXIXo
        @xxIXOIIO(name = "create")
        public final ResponseBody create(@OOXIXo final BufferedSource bufferedSource, @oOoXoXO final MediaType mediaType, final long j) {
            IIX0o.x0xO0oo(bufferedSource, "<this>");
            return new ResponseBody() { // from class: okhttp3.ResponseBody$Companion$asResponseBody$1
                @Override // okhttp3.ResponseBody
                public long contentLength() {
                    return j;
                }

                @Override // okhttp3.ResponseBody
                @oOoXoXO
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // okhttp3.ResponseBody
                @OOXIXo
                public BufferedSource source() {
                    return bufferedSource;
                }
            };
        }

        @x0XOIxOo
        @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @kotlin.XX(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @OOXIXo
        public final ResponseBody create(@oOoXoXO MediaType mediaType, @OOXIXo String content) {
            IIX0o.x0xO0oo(content, "content");
            return create(content, mediaType);
        }

        @x0XOIxOo
        @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @kotlin.XX(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @OOXIXo
        public final ResponseBody create(@oOoXoXO MediaType mediaType, @OOXIXo byte[] content) {
            IIX0o.x0xO0oo(content, "content");
            return create(content, mediaType);
        }

        @x0XOIxOo
        @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @kotlin.XX(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @OOXIXo
        public final ResponseBody create(@oOoXoXO MediaType mediaType, @OOXIXo ByteString content) {
            IIX0o.x0xO0oo(content, "content");
            return create(content, mediaType);
        }

        @x0XOIxOo
        @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @kotlin.XX(expression = "content.asResponseBody(contentType, contentLength)", imports = {"okhttp3.ResponseBody.Companion.asResponseBody"}))
        @OOXIXo
        public final ResponseBody create(@oOoXoXO MediaType mediaType, long j, @OOXIXo BufferedSource content) {
            IIX0o.x0xO0oo(content, "content");
            return create(content, mediaType, j);
        }
    }

    private final Charset charset() {
        Charset charset;
        MediaType contentType = contentType();
        if (contentType == null || (charset = contentType.charset(oxoX.f29581II0xO0)) == null) {
            return oxoX.f29581II0xO0;
        }
        return charset;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.Object] */
    private final <T> T consumeSource(Oox.oOoXoXO<? super BufferedSource, ? extends T> oooxoxo, Oox.oOoXoXO<? super T, Integer> oooxoxo2) {
        long contentLength = contentLength();
        if (contentLength <= 2147483647L) {
            BufferedSource source = source();
            try {
                T invoke = oooxoxo.invoke(source);
                xxX.oxoX(1);
                II0xO0.oIX0oI(source, null);
                xxX.I0Io(1);
                int intValue = oooxoxo2.invoke(invoke).intValue();
                if (contentLength != -1 && contentLength != intValue) {
                    throw new IOException("Content-Length (" + contentLength + ") and stream length (" + intValue + ") disagree");
                }
                return invoke;
            } finally {
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
    }

    @x0XOIxOo
    @OOXIXo
    @xxIXOIIO(name = "create")
    public static final ResponseBody create(@OOXIXo String str, @oOoXoXO MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    @OOXIXo
    public final InputStream byteStream() {
        return source().inputStream();
    }

    @OOXIXo
    public final ByteString byteString() throws IOException {
        long contentLength = contentLength();
        if (contentLength <= 2147483647L) {
            BufferedSource source = source();
            try {
                ByteString readByteString = source.readByteString();
                II0xO0.oIX0oI(source, null);
                int size = readByteString.size();
                if (contentLength != -1 && contentLength != size) {
                    throw new IOException("Content-Length (" + contentLength + ") and stream length (" + size + ") disagree");
                }
                return readByteString;
            } finally {
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
    }

    @OOXIXo
    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength <= 2147483647L) {
            BufferedSource source = source();
            try {
                byte[] readByteArray = source.readByteArray();
                II0xO0.oIX0oI(source, null);
                int length = readByteArray.length;
                if (contentLength != -1 && contentLength != length) {
                    throw new IOException("Content-Length (" + contentLength + ") and stream length (" + length + ") disagree");
                }
                return readByteArray;
            } finally {
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
    }

    @OOXIXo
    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader == null) {
            BomAwareReader bomAwareReader = new BomAwareReader(source(), charset());
            this.reader = bomAwareReader;
            return bomAwareReader;
        }
        return reader;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(source());
    }

    public abstract long contentLength();

    @oOoXoXO
    public abstract MediaType contentType();

    @OOXIXo
    public abstract BufferedSource source();

    @OOXIXo
    public final String string() throws IOException {
        BufferedSource source = source();
        try {
            String readString = source.readString(Util.readBomAsCharset(source, charset()));
            II0xO0.oIX0oI(source, null);
            return readString;
        } finally {
        }
    }

    @x0XOIxOo
    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @kotlin.XX(expression = "content.asResponseBody(contentType, contentLength)", imports = {"okhttp3.ResponseBody.Companion.asResponseBody"}))
    @OOXIXo
    public static final ResponseBody create(@oOoXoXO MediaType mediaType, long j, @OOXIXo BufferedSource bufferedSource) {
        return Companion.create(mediaType, j, bufferedSource);
    }

    @x0XOIxOo
    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @kotlin.XX(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @OOXIXo
    public static final ResponseBody create(@oOoXoXO MediaType mediaType, @OOXIXo String str) {
        return Companion.create(mediaType, str);
    }

    @x0XOIxOo
    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @kotlin.XX(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @OOXIXo
    public static final ResponseBody create(@oOoXoXO MediaType mediaType, @OOXIXo ByteString byteString) {
        return Companion.create(mediaType, byteString);
    }

    @x0XOIxOo
    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @kotlin.XX(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @OOXIXo
    public static final ResponseBody create(@oOoXoXO MediaType mediaType, @OOXIXo byte[] bArr) {
        return Companion.create(mediaType, bArr);
    }

    @x0XOIxOo
    @OOXIXo
    @xxIXOIIO(name = "create")
    public static final ResponseBody create(@OOXIXo BufferedSource bufferedSource, @oOoXoXO MediaType mediaType, long j) {
        return Companion.create(bufferedSource, mediaType, j);
    }

    @x0XOIxOo
    @OOXIXo
    @xxIXOIIO(name = "create")
    public static final ResponseBody create(@OOXIXo ByteString byteString, @oOoXoXO MediaType mediaType) {
        return Companion.create(byteString, mediaType);
    }

    @x0XOIxOo
    @OOXIXo
    @xxIXOIIO(name = "create")
    public static final ResponseBody create(@OOXIXo byte[] bArr, @oOoXoXO MediaType mediaType) {
        return Companion.create(bArr, mediaType);
    }
}
