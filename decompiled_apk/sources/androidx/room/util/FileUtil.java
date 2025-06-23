package androidx.room.util;

import OXOo.OOXIXo;
import XO0OX.xxIXOIIO;
import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.RestrictTo;
import com.huawei.openalliance.ad.utils.r;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@xxIXOIIO(name = r.Code)
@XX({"SMAP\nFileUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileUtil.kt\nandroidx/room/util/FileUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,59:1\n1#2:60\n*E\n"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class FileUtil {
    @SuppressLint({"LambdaLast"})
    public static final void copy(@OOXIXo ReadableByteChannel input, @OOXIXo FileChannel output) throws IOException {
        IIX0o.x0xO0oo(input, "input");
        IIX0o.x0xO0oo(output, "output");
        try {
            if (Build.VERSION.SDK_INT > 23) {
                output.transferFrom(input, 0L, Long.MAX_VALUE);
            } else {
                InputStream newInputStream = Channels.newInputStream(input);
                OutputStream newOutputStream = Channels.newOutputStream(output);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = newInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    } else {
                        newOutputStream.write(bArr, 0, read);
                    }
                }
            }
            output.force(false);
            input.close();
            output.close();
        } catch (Throwable th) {
            input.close();
            output.close();
            throw th;
        }
    }
}
