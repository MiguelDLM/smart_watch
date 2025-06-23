package okhttp3;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import XO0OX.xoIox;
import XO0OX.xxIXOIIO;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlin.io.II0xO0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.oxoX;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* loaded from: classes6.dex */
public abstract class RequestBody {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, String str, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        @x0XOIxOo
        @OOXIXo
        @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @XX(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @xoIox
        public final RequestBody create(@oOoXoXO MediaType mediaType, @OOXIXo byte[] content) {
            IIX0o.x0xO0oo(content, "content");
            return create$default(this, mediaType, content, 0, 0, 12, (Object) null);
        }

        private Companion() {
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        @x0XOIxOo
        @OOXIXo
        @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @XX(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @xoIox
        public final RequestBody create(@oOoXoXO MediaType mediaType, @OOXIXo byte[] content, int i) {
            IIX0o.x0xO0oo(content, "content");
            return create$default(this, mediaType, content, i, 0, 8, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return companion.create(bArr, mediaType, i, i2);
        }

        @x0XOIxOo
        @OOXIXo
        @xxIXOIIO(name = "create")
        @xoIox
        public final RequestBody create(@OOXIXo byte[] bArr) {
            IIX0o.x0xO0oo(bArr, "<this>");
            return create$default(this, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        }

        @x0XOIxOo
        @OOXIXo
        @xxIXOIIO(name = "create")
        @xoIox
        public final RequestBody create(@OOXIXo byte[] bArr, @oOoXoXO MediaType mediaType) {
            IIX0o.x0xO0oo(bArr, "<this>");
            return create$default(this, bArr, mediaType, 0, 0, 6, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, File file, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(file, mediaType);
        }

        @x0XOIxOo
        @OOXIXo
        @xxIXOIIO(name = "create")
        @xoIox
        public final RequestBody create(@OOXIXo byte[] bArr, @oOoXoXO MediaType mediaType, int i) {
            IIX0o.x0xO0oo(bArr, "<this>");
            return create$default(this, bArr, mediaType, i, 0, 4, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, MediaType mediaType, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                i = 0;
            }
            if ((i3 & 8) != 0) {
                i2 = bArr.length;
            }
            return companion.create(mediaType, bArr, i, i2);
        }

        @x0XOIxOo
        @OOXIXo
        @xxIXOIIO(name = "create")
        public final RequestBody create(@OOXIXo String str, @oOoXoXO MediaType mediaType) {
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
            byte[] bytes = str.getBytes(charset);
            IIX0o.oO(bytes, "this as java.lang.String).getBytes(charset)");
            return create(bytes, mediaType, 0, bytes.length);
        }

        @x0XOIxOo
        @OOXIXo
        @xxIXOIIO(name = "create")
        public final RequestBody create(@OOXIXo final ByteString byteString, @oOoXoXO final MediaType mediaType) {
            IIX0o.x0xO0oo(byteString, "<this>");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return byteString.size();
                }

                @Override // okhttp3.RequestBody
                @oOoXoXO
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(@OOXIXo BufferedSink sink) {
                    IIX0o.x0xO0oo(sink, "sink");
                    sink.write(byteString);
                }
            };
        }

        @x0XOIxOo
        @OOXIXo
        @xxIXOIIO(name = "create")
        @xoIox
        public final RequestBody create(@OOXIXo final byte[] bArr, @oOoXoXO final MediaType mediaType, final int i, final int i2) {
            IIX0o.x0xO0oo(bArr, "<this>");
            Util.checkOffsetAndCount(bArr.length, i, i2);
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$2
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return i2;
                }

                @Override // okhttp3.RequestBody
                @oOoXoXO
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(@OOXIXo BufferedSink sink) {
                    IIX0o.x0xO0oo(sink, "sink");
                    sink.write(bArr, i, i2);
                }
            };
        }

        @x0XOIxOo
        @OOXIXo
        @xxIXOIIO(name = "create")
        public final RequestBody create(@OOXIXo final File file, @oOoXoXO final MediaType mediaType) {
            IIX0o.x0xO0oo(file, "<this>");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$asRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return file.length();
                }

                @Override // okhttp3.RequestBody
                @oOoXoXO
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(@OOXIXo BufferedSink sink) {
                    IIX0o.x0xO0oo(sink, "sink");
                    Source source = Okio.source(file);
                    try {
                        sink.writeAll(source);
                        II0xO0.oIX0oI(source, null);
                    } finally {
                    }
                }
            };
        }

        @x0XOIxOo
        @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @XX(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @OOXIXo
        public final RequestBody create(@oOoXoXO MediaType mediaType, @OOXIXo String content) {
            IIX0o.x0xO0oo(content, "content");
            return create(content, mediaType);
        }

        @x0XOIxOo
        @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @XX(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @OOXIXo
        public final RequestBody create(@oOoXoXO MediaType mediaType, @OOXIXo ByteString content) {
            IIX0o.x0xO0oo(content, "content");
            return create(content, mediaType);
        }

        @x0XOIxOo
        @OOXIXo
        @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @XX(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @xoIox
        public final RequestBody create(@oOoXoXO MediaType mediaType, @OOXIXo byte[] content, int i, int i2) {
            IIX0o.x0xO0oo(content, "content");
            return create(content, mediaType, i, i2);
        }

        @x0XOIxOo
        @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @XX(expression = "file.asRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.asRequestBody"}))
        @OOXIXo
        public final RequestBody create(@oOoXoXO MediaType mediaType, @OOXIXo File file) {
            IIX0o.x0xO0oo(file, "file");
            return create(file, mediaType);
        }
    }

    @x0XOIxOo
    @OOXIXo
    @xxIXOIIO(name = "create")
    public static final RequestBody create(@OOXIXo File file, @oOoXoXO MediaType mediaType) {
        return Companion.create(file, mediaType);
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    @oOoXoXO
    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(@OOXIXo BufferedSink bufferedSink) throws IOException;

    @x0XOIxOo
    @OOXIXo
    @xxIXOIIO(name = "create")
    public static final RequestBody create(@OOXIXo String str, @oOoXoXO MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    @x0XOIxOo
    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @XX(expression = "file.asRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.asRequestBody"}))
    @OOXIXo
    public static final RequestBody create(@oOoXoXO MediaType mediaType, @OOXIXo File file) {
        return Companion.create(mediaType, file);
    }

    @x0XOIxOo
    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @XX(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @OOXIXo
    public static final RequestBody create(@oOoXoXO MediaType mediaType, @OOXIXo String str) {
        return Companion.create(mediaType, str);
    }

    @x0XOIxOo
    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @XX(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @OOXIXo
    public static final RequestBody create(@oOoXoXO MediaType mediaType, @OOXIXo ByteString byteString) {
        return Companion.create(mediaType, byteString);
    }

    @x0XOIxOo
    @OOXIXo
    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @XX(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @xoIox
    public static final RequestBody create(@oOoXoXO MediaType mediaType, @OOXIXo byte[] bArr) {
        return Companion.create(mediaType, bArr);
    }

    @x0XOIxOo
    @OOXIXo
    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @XX(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @xoIox
    public static final RequestBody create(@oOoXoXO MediaType mediaType, @OOXIXo byte[] bArr, int i) {
        return Companion.create(mediaType, bArr, i);
    }

    @x0XOIxOo
    @OOXIXo
    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @XX(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @xoIox
    public static final RequestBody create(@oOoXoXO MediaType mediaType, @OOXIXo byte[] bArr, int i, int i2) {
        return Companion.create(mediaType, bArr, i, i2);
    }

    @x0XOIxOo
    @OOXIXo
    @xxIXOIIO(name = "create")
    public static final RequestBody create(@OOXIXo ByteString byteString, @oOoXoXO MediaType mediaType) {
        return Companion.create(byteString, mediaType);
    }

    @x0XOIxOo
    @OOXIXo
    @xxIXOIIO(name = "create")
    @xoIox
    public static final RequestBody create(@OOXIXo byte[] bArr) {
        return Companion.create(bArr);
    }

    @x0XOIxOo
    @OOXIXo
    @xxIXOIIO(name = "create")
    @xoIox
    public static final RequestBody create(@OOXIXo byte[] bArr, @oOoXoXO MediaType mediaType) {
        return Companion.create(bArr, mediaType);
    }

    @x0XOIxOo
    @OOXIXo
    @xxIXOIIO(name = "create")
    @xoIox
    public static final RequestBody create(@OOXIXo byte[] bArr, @oOoXoXO MediaType mediaType, int i) {
        return Companion.create(bArr, mediaType, i);
    }

    @x0XOIxOo
    @OOXIXo
    @xxIXOIIO(name = "create")
    @xoIox
    public static final RequestBody create(@OOXIXo byte[] bArr, @oOoXoXO MediaType mediaType, int i, int i2) {
        return Companion.create(bArr, mediaType, i, i2);
    }
}
