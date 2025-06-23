package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.util.Arrays;
import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlin.jvm.internal.IIX0o;

@kotlin.OOXIXo(message = "changed in Okio 2.x")
/* renamed from: okio.-DeprecatedOkio, reason: invalid class name */
/* loaded from: classes6.dex */
public final class DeprecatedOkio {

    @OXOo.OOXIXo
    public static final DeprecatedOkio INSTANCE = new DeprecatedOkio();

    private DeprecatedOkio() {
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @XX(expression = "file.appendingSink()", imports = {"okio.appendingSink"}))
    @OXOo.OOXIXo
    public final Sink appendingSink(@OXOo.OOXIXo File file) {
        IIX0o.x0xO0oo(file, "file");
        return Okio.appendingSink(file);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @XX(expression = "blackholeSink()", imports = {"okio.blackholeSink"}))
    @OXOo.OOXIXo
    public final Sink blackhole() {
        return Okio.blackhole();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @XX(expression = "sink.buffer()", imports = {"okio.buffer"}))
    @OXOo.OOXIXo
    public final BufferedSink buffer(@OXOo.OOXIXo Sink sink) {
        IIX0o.x0xO0oo(sink, "sink");
        return Okio.buffer(sink);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @XX(expression = "file.sink()", imports = {"okio.sink"}))
    @OXOo.OOXIXo
    public final Sink sink(@OXOo.OOXIXo File file) {
        Sink sink$default;
        IIX0o.x0xO0oo(file, "file");
        sink$default = Okio__JvmOkioKt.sink$default(file, false, 1, null);
        return sink$default;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @XX(expression = "file.source()", imports = {"okio.source"}))
    @OXOo.OOXIXo
    public final Source source(@OXOo.OOXIXo File file) {
        IIX0o.x0xO0oo(file, "file");
        return Okio.source(file);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @XX(expression = "source.buffer()", imports = {"okio.buffer"}))
    @OXOo.OOXIXo
    public final BufferedSource buffer(@OXOo.OOXIXo Source source) {
        IIX0o.x0xO0oo(source, "source");
        return Okio.buffer(source);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @XX(expression = "outputStream.sink()", imports = {"okio.sink"}))
    @OXOo.OOXIXo
    public final Sink sink(@OXOo.OOXIXo OutputStream outputStream) {
        IIX0o.x0xO0oo(outputStream, "outputStream");
        return Okio.sink(outputStream);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @XX(expression = "inputStream.source()", imports = {"okio.source"}))
    @OXOo.OOXIXo
    public final Source source(@OXOo.OOXIXo InputStream inputStream) {
        IIX0o.x0xO0oo(inputStream, "inputStream");
        return Okio.source(inputStream);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @XX(expression = "path.sink(*options)", imports = {"okio.sink"}))
    @OXOo.OOXIXo
    public final Sink sink(@OXOo.OOXIXo java.nio.file.Path path, @OXOo.OOXIXo OpenOption... options) {
        IIX0o.x0xO0oo(path, "path");
        IIX0o.x0xO0oo(options, "options");
        return Okio.sink(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @XX(expression = "path.source(*options)", imports = {"okio.source"}))
    @OXOo.OOXIXo
    public final Source source(@OXOo.OOXIXo java.nio.file.Path path, @OXOo.OOXIXo OpenOption... options) {
        IIX0o.x0xO0oo(path, "path");
        IIX0o.x0xO0oo(options, "options");
        return Okio.source(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @XX(expression = "socket.sink()", imports = {"okio.sink"}))
    @OXOo.OOXIXo
    public final Sink sink(@OXOo.OOXIXo Socket socket) {
        IIX0o.x0xO0oo(socket, "socket");
        return Okio.sink(socket);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @XX(expression = "socket.source()", imports = {"okio.source"}))
    @OXOo.OOXIXo
    public final Source source(@OXOo.OOXIXo Socket socket) {
        IIX0o.x0xO0oo(socket, "socket");
        return Okio.source(socket);
    }
}
