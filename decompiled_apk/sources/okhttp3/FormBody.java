package okhttp3;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import XO0OX.xxIXOIIO;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.utils.URLEncodedUtils;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

/* loaded from: classes6.dex */
public final class FormBody extends RequestBody {

    @OOXIXo
    private final List<String> encodedNames;

    @OOXIXo
    private final List<String> encodedValues;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final MediaType CONTENT_TYPE = MediaType.Companion.get(URLEncodedUtils.CONTENT_TYPE);

    /* loaded from: classes6.dex */
    public static final class Builder {

        @oOoXoXO
        private final Charset charset;

        @OOXIXo
        private final List<String> names;

        @OOXIXo
        private final List<String> values;

        /* JADX WARN: Multi-variable type inference failed */
        @xoIox
        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @OOXIXo
        public final Builder add(@OOXIXo String name, @OOXIXo String value) {
            IIX0o.x0xO0oo(name, "name");
            IIX0o.x0xO0oo(value, "value");
            List<String> list = this.names;
            HttpUrl.Companion companion = HttpUrl.Companion;
            list.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, name, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, this.charset, 91, null));
            this.values.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, value, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, this.charset, 91, null));
            return this;
        }

        @OOXIXo
        public final Builder addEncoded(@OOXIXo String name, @OOXIXo String value) {
            IIX0o.x0xO0oo(name, "name");
            IIX0o.x0xO0oo(value, "value");
            List<String> list = this.names;
            HttpUrl.Companion companion = HttpUrl.Companion;
            list.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, name, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, null));
            this.values.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, value, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, null));
            return this;
        }

        @OOXIXo
        public final FormBody build() {
            return new FormBody(this.names, this.values);
        }

        @xoIox
        public Builder(@oOoXoXO Charset charset) {
            this.charset = charset;
            this.names = new ArrayList();
            this.values = new ArrayList();
        }

        public /* synthetic */ Builder(Charset charset, int i, IIXOooo iIXOooo) {
            this((i & 1) != 0 ? null : charset);
        }
    }

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public FormBody(@OOXIXo List<String> encodedNames, @OOXIXo List<String> encodedValues) {
        IIX0o.x0xO0oo(encodedNames, "encodedNames");
        IIX0o.x0xO0oo(encodedValues, "encodedValues");
        this.encodedNames = Util.toImmutableList(encodedNames);
        this.encodedValues = Util.toImmutableList(encodedValues);
    }

    private final long writeOrCountBytes(BufferedSink bufferedSink, boolean z) {
        Buffer buffer;
        if (z) {
            buffer = new Buffer();
        } else {
            IIX0o.ooOOo0oXI(bufferedSink);
            buffer = bufferedSink.getBuffer();
        }
        int size = this.encodedNames.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8(this.encodedNames.get(i));
            buffer.writeByte(61);
            buffer.writeUtf8(this.encodedValues.get(i));
        }
        if (z) {
            long size2 = buffer.size();
            buffer.clear();
            return size2;
        }
        return 0L;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE, imports = {}))
    @xxIXOIIO(name = "-deprecated_size")
    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m341deprecated_size() {
        return size();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return writeOrCountBytes(null, true);
    }

    @Override // okhttp3.RequestBody
    @OOXIXo
    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    @OOXIXo
    public final String encodedName(int i) {
        return this.encodedNames.get(i);
    }

    @OOXIXo
    public final String encodedValue(int i) {
        return this.encodedValues.get(i);
    }

    @OOXIXo
    public final String name(int i) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedName(i), 0, 0, true, 3, null);
    }

    @xxIXOIIO(name = MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE)
    public final int size() {
        return this.encodedNames.size();
    }

    @OOXIXo
    public final String value(int i) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedValue(i), 0, 0, true, 3, null);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(@OOXIXo BufferedSink sink) throws IOException {
        IIX0o.x0xO0oo(sink, "sink");
        writeOrCountBytes(sink, false);
    }
}
