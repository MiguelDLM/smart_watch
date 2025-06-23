package androidx.room.util;

import OXOo.OOXIXo;
import XO0OX.xxIXOIIO;
import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.RestrictTo;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@xxIXOIIO(name = "FileUtil")
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@XX({"SMAP\nFileUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileUtil.kt\nandroidx/room/util/FileUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,59:1\n1#2:60\n*E\n"})
public final class FileUtil {
    @SuppressLint({"LambdaLast"})
    public static final void copy(@OOXIXo ReadableByteChannel readableByteChannel, @OOXIXo FileChannel fileChannel) throws IOException {
        IIX0o.x0xO0oo(readableByteChannel, "input");
        IIX0o.x0xO0oo(fileChannel, "output");
        try {
            if (Build.VERSION.SDK_INT <= 23) {
                InputStream newInputStream = Channels.newInputStream(readableByteChannel);
                OutputStream newOutputStream = Channels.newOutputStream(fileChannel);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = newInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    newOutputStream.write(bArr, 0, read);
                }
            } else {
                fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
            }
            fileChannel.force(false);
            readableByteChannel.close();
            fileChannel.close();
        } catch (Throwable th) {
            readableByteChannel.close();
            fileChannel.close();
            throw th;
        }
    }
}
