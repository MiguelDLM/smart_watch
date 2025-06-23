package okio;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* loaded from: classes6.dex */
public final class Okio {
    @OXOo.OOXIXo
    public static final Sink appendingSink(@OXOo.OOXIXo File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.appendingSink(file);
    }

    @OXOo.OOXIXo
    public static final FileSystem asResourceFileSystem(@OXOo.OOXIXo ClassLoader classLoader) {
        return Okio__JvmOkioKt.asResourceFileSystem(classLoader);
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "blackhole")
    public static final Sink blackhole() {
        return Okio__OkioKt.blackhole();
    }

    @OXOo.OOXIXo
    public static final BufferedSink buffer(@OXOo.OOXIXo Sink sink) {
        return Okio__OkioKt.buffer(sink);
    }

    @OXOo.OOXIXo
    public static final CipherSink cipherSink(@OXOo.OOXIXo Sink sink, @OXOo.OOXIXo Cipher cipher) {
        return Okio__JvmOkioKt.cipherSink(sink, cipher);
    }

    @OXOo.OOXIXo
    public static final CipherSource cipherSource(@OXOo.OOXIXo Source source, @OXOo.OOXIXo Cipher cipher) {
        return Okio__JvmOkioKt.cipherSource(source, cipher);
    }

    @OXOo.OOXIXo
    public static final HashingSink hashingSink(@OXOo.OOXIXo Sink sink, @OXOo.OOXIXo MessageDigest messageDigest) {
        return Okio__JvmOkioKt.hashingSink(sink, messageDigest);
    }

    @OXOo.OOXIXo
    public static final HashingSource hashingSource(@OXOo.OOXIXo Source source, @OXOo.OOXIXo MessageDigest messageDigest) {
        return Okio__JvmOkioKt.hashingSource(source, messageDigest);
    }

    public static final boolean isAndroidGetsocknameError(@OXOo.OOXIXo AssertionError assertionError) {
        return Okio__JvmOkioKt.isAndroidGetsocknameError(assertionError);
    }

    @OXOo.OOXIXo
    public static final FileSystem openZip(@OXOo.OOXIXo FileSystem fileSystem, @OXOo.OOXIXo Path path) throws IOException {
        return Okio__JvmOkioKt.openZip(fileSystem, path);
    }

    @OXOo.OOXIXo
    @XO0OX.xoIox
    public static final Sink sink(@OXOo.OOXIXo File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink(file);
    }

    @OXOo.OOXIXo
    public static final Source source(@OXOo.OOXIXo File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.source(file);
    }

    public static final <T extends Closeable, R> R use(T t, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> oooxoxo) {
        return (R) Okio__OkioKt.use(t, oooxoxo);
    }

    @OXOo.OOXIXo
    public static final BufferedSource buffer(@OXOo.OOXIXo Source source) {
        return Okio__OkioKt.buffer(source);
    }

    @OXOo.OOXIXo
    public static final HashingSink hashingSink(@OXOo.OOXIXo Sink sink, @OXOo.OOXIXo Mac mac) {
        return Okio__JvmOkioKt.hashingSink(sink, mac);
    }

    @OXOo.OOXIXo
    public static final HashingSource hashingSource(@OXOo.OOXIXo Source source, @OXOo.OOXIXo Mac mac) {
        return Okio__JvmOkioKt.hashingSource(source, mac);
    }

    @OXOo.OOXIXo
    @XO0OX.xoIox
    public static final Sink sink(@OXOo.OOXIXo File file, boolean z) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink(file, z);
    }

    @OXOo.OOXIXo
    public static final Source source(@OXOo.OOXIXo InputStream inputStream) {
        return Okio__JvmOkioKt.source(inputStream);
    }

    @OXOo.OOXIXo
    public static final Sink sink(@OXOo.OOXIXo OutputStream outputStream) {
        return Okio__JvmOkioKt.sink(outputStream);
    }

    @OXOo.OOXIXo
    public static final Source source(@OXOo.OOXIXo Socket socket) throws IOException {
        return Okio__JvmOkioKt.source(socket);
    }

    @OXOo.OOXIXo
    public static final Sink sink(@OXOo.OOXIXo Socket socket) throws IOException {
        return Okio__JvmOkioKt.sink(socket);
    }

    @OXOo.OOXIXo
    public static final Source source(@OXOo.OOXIXo java.nio.file.Path path, @OXOo.OOXIXo OpenOption... openOptionArr) throws IOException {
        return Okio__JvmOkioKt.source(path, openOptionArr);
    }

    @OXOo.OOXIXo
    public static final Sink sink(@OXOo.OOXIXo java.nio.file.Path path, @OXOo.OOXIXo OpenOption... openOptionArr) throws IOException {
        return Okio__JvmOkioKt.sink(path, openOptionArr);
    }
}
