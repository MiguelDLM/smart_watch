package androidx.core.util;

import Oox.oOoXoXO;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nAtomicFile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AtomicFile.kt\nandroidx/core/util/AtomicFileKt\n*L\n1#1,76:1\n30#1,13:77\n*S KotlinDebug\n*F\n+ 1 AtomicFile.kt\nandroidx/core/util/AtomicFileKt\n*L\n48#1:77,13\n*E\n"})
/* loaded from: classes.dex */
public final class AtomicFileKt {
    @OXOo.OOXIXo
    public static final byte[] readBytes(@OXOo.OOXIXo android.util.AtomicFile atomicFile) {
        return atomicFile.readFully();
    }

    @OXOo.OOXIXo
    public static final String readText(@OXOo.OOXIXo android.util.AtomicFile atomicFile, @OXOo.OOXIXo Charset charset) {
        return new String(atomicFile.readFully(), charset);
    }

    public static /* synthetic */ String readText$default(android.util.AtomicFile atomicFile, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        return readText(atomicFile, charset);
    }

    public static final void tryWrite(@OXOo.OOXIXo android.util.AtomicFile atomicFile, @OXOo.OOXIXo oOoXoXO<? super FileOutputStream, oXIO0o0XI> oooxoxo) {
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            oooxoxo.invoke(startWrite);
            xxX.oxoX(1);
            atomicFile.finishWrite(startWrite);
            xxX.I0Io(1);
        } catch (Throwable th) {
            xxX.oxoX(1);
            atomicFile.failWrite(startWrite);
            xxX.I0Io(1);
            throw th;
        }
    }

    public static final void writeBytes(@OXOo.OOXIXo android.util.AtomicFile atomicFile, @OXOo.OOXIXo byte[] bArr) {
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            startWrite.write(bArr);
            atomicFile.finishWrite(startWrite);
        } catch (Throwable th) {
            atomicFile.failWrite(startWrite);
            throw th;
        }
    }

    public static final void writeText(@OXOo.OOXIXo android.util.AtomicFile atomicFile, @OXOo.OOXIXo String str, @OXOo.OOXIXo Charset charset) {
        byte[] bytes = str.getBytes(charset);
        IIX0o.oO(bytes, "this as java.lang.String).getBytes(charset)");
        writeBytes(atomicFile, bytes);
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile atomicFile, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        writeText(atomicFile, str, charset);
    }
}
