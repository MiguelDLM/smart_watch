package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.StringsKt__StringsKt;
import okio.internal.ResourceFileSystem;
import okio.internal.ZipFilesKt;

/* loaded from: classes6.dex */
public final /* synthetic */ class Okio__JvmOkioKt {
    private static final Logger logger = Logger.getLogger("okio.Okio");

    @OXOo.OOXIXo
    public static final Sink appendingSink(@OXOo.OOXIXo File file) throws FileNotFoundException {
        IIX0o.x0xO0oo(file, "<this>");
        return Okio.sink(new FileOutputStream(file, true));
    }

    @OXOo.OOXIXo
    public static final FileSystem asResourceFileSystem(@OXOo.OOXIXo ClassLoader classLoader) {
        IIX0o.x0xO0oo(classLoader, "<this>");
        return new ResourceFileSystem(classLoader, true, null, 4, null);
    }

    @OXOo.OOXIXo
    public static final CipherSink cipherSink(@OXOo.OOXIXo Sink sink, @OXOo.OOXIXo Cipher cipher) {
        IIX0o.x0xO0oo(sink, "<this>");
        IIX0o.x0xO0oo(cipher, "cipher");
        return new CipherSink(Okio.buffer(sink), cipher);
    }

    @OXOo.OOXIXo
    public static final CipherSource cipherSource(@OXOo.OOXIXo Source source, @OXOo.OOXIXo Cipher cipher) {
        IIX0o.x0xO0oo(source, "<this>");
        IIX0o.x0xO0oo(cipher, "cipher");
        return new CipherSource(Okio.buffer(source), cipher);
    }

    @OXOo.OOXIXo
    public static final HashingSink hashingSink(@OXOo.OOXIXo Sink sink, @OXOo.OOXIXo Mac mac) {
        IIX0o.x0xO0oo(sink, "<this>");
        IIX0o.x0xO0oo(mac, "mac");
        return new HashingSink(sink, mac);
    }

    @OXOo.OOXIXo
    public static final HashingSource hashingSource(@OXOo.OOXIXo Source source, @OXOo.OOXIXo Mac mac) {
        IIX0o.x0xO0oo(source, "<this>");
        IIX0o.x0xO0oo(mac, "mac");
        return new HashingSource(source, mac);
    }

    public static final boolean isAndroidGetsocknameError(@OXOo.OOXIXo AssertionError assertionError) {
        boolean z;
        IIX0o.x0xO0oo(assertionError, "<this>");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        if (message != null) {
            z = StringsKt__StringsKt.o00xOoIO(message, "getsockname failed", false, 2, null);
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        return true;
    }

    @OXOo.OOXIXo
    public static final FileSystem openZip(@OXOo.OOXIXo FileSystem fileSystem, @OXOo.OOXIXo Path zipPath) throws IOException {
        IIX0o.x0xO0oo(fileSystem, "<this>");
        IIX0o.x0xO0oo(zipPath, "zipPath");
        return ZipFilesKt.openZip$default(zipPath, fileSystem, null, 4, null);
    }

    @OXOo.OOXIXo
    @XO0OX.xoIox
    public static final Sink sink(@OXOo.OOXIXo File file) throws FileNotFoundException {
        Sink sink$default;
        IIX0o.x0xO0oo(file, "<this>");
        sink$default = sink$default(file, false, 1, null);
        return sink$default;
    }

    public static /* synthetic */ Sink sink$default(File file, boolean z, int i, Object obj) throws FileNotFoundException {
        if ((i & 1) != 0) {
            z = false;
        }
        return Okio.sink(file, z);
    }

    @OXOo.OOXIXo
    public static final Source source(@OXOo.OOXIXo InputStream inputStream) {
        IIX0o.x0xO0oo(inputStream, "<this>");
        return new InputStreamSource(inputStream, new Timeout());
    }

    @OXOo.OOXIXo
    public static final HashingSink hashingSink(@OXOo.OOXIXo Sink sink, @OXOo.OOXIXo MessageDigest digest) {
        IIX0o.x0xO0oo(sink, "<this>");
        IIX0o.x0xO0oo(digest, "digest");
        return new HashingSink(sink, digest);
    }

    @OXOo.OOXIXo
    public static final HashingSource hashingSource(@OXOo.OOXIXo Source source, @OXOo.OOXIXo MessageDigest digest) {
        IIX0o.x0xO0oo(source, "<this>");
        IIX0o.x0xO0oo(digest, "digest");
        return new HashingSource(source, digest);
    }

    @OXOo.OOXIXo
    public static final Sink sink(@OXOo.OOXIXo OutputStream outputStream) {
        IIX0o.x0xO0oo(outputStream, "<this>");
        return new OutputStreamSink(outputStream, new Timeout());
    }

    @OXOo.OOXIXo
    public static final Source source(@OXOo.OOXIXo Socket socket) throws IOException {
        IIX0o.x0xO0oo(socket, "<this>");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        InputStream inputStream = socket.getInputStream();
        IIX0o.oO(inputStream, "getInputStream(...)");
        return socketAsyncTimeout.source(new InputStreamSource(inputStream, socketAsyncTimeout));
    }

    @OXOo.OOXIXo
    public static final Sink sink(@OXOo.OOXIXo Socket socket) throws IOException {
        IIX0o.x0xO0oo(socket, "<this>");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        OutputStream outputStream = socket.getOutputStream();
        IIX0o.oO(outputStream, "getOutputStream(...)");
        return socketAsyncTimeout.sink(new OutputStreamSink(outputStream, socketAsyncTimeout));
    }

    @OXOo.OOXIXo
    public static final Source source(@OXOo.OOXIXo File file) throws FileNotFoundException {
        IIX0o.x0xO0oo(file, "<this>");
        return new InputStreamSource(new FileInputStream(file), Timeout.NONE);
    }

    @OXOo.OOXIXo
    @XO0OX.xoIox
    public static final Sink sink(@OXOo.OOXIXo File file, boolean z) throws FileNotFoundException {
        IIX0o.x0xO0oo(file, "<this>");
        return Okio.sink(new FileOutputStream(file, z));
    }

    @OXOo.OOXIXo
    public static final Source source(@OXOo.OOXIXo java.nio.file.Path path, @OXOo.OOXIXo OpenOption... options) throws IOException {
        InputStream newInputStream;
        IIX0o.x0xO0oo(path, "<this>");
        IIX0o.x0xO0oo(options, "options");
        newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        IIX0o.oO(newInputStream, "newInputStream(...)");
        return Okio.source(newInputStream);
    }

    @OXOo.OOXIXo
    public static final Sink sink(@OXOo.OOXIXo java.nio.file.Path path, @OXOo.OOXIXo OpenOption... options) throws IOException {
        OutputStream newOutputStream;
        IIX0o.x0xO0oo(path, "<this>");
        IIX0o.x0xO0oo(options, "options");
        newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        IIX0o.oO(newOutputStream, "newOutputStream(...)");
        return Okio.sink(newOutputStream);
    }
}
