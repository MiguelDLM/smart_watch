package androidx.sqlite.util;

import IXI.oxoX;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.util.Log;
import androidx.annotation.RestrictTo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@XX({"SMAP\nProcessLock.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProcessLock.kt\nandroidx/sqlite/util/ProcessLock\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,103:1\n1#2:104\n*E\n"})
public final class ProcessLock {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @OOXIXo
    private static final String TAG = "SupportSQLiteLock";
    /* access modifiers changed from: private */
    @OOXIXo
    public static final Map<String, Lock> threadLocksMap = new HashMap();
    @oOoXoXO
    private FileChannel lockChannel;
    @oOoXoXO
    private final File lockFile;
    private final boolean processLock;
    @OOXIXo
    private final Lock threadLock;

    @XX({"SMAP\nProcessLock.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProcessLock.kt\nandroidx/sqlite/util/ProcessLock$Companion\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,103:1\n361#2,7:104\n*S KotlinDebug\n*F\n+ 1 ProcessLock.kt\nandroidx/sqlite/util/ProcessLock$Companion\n*L\n99#1:104,7\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* access modifiers changed from: private */
        public final Lock getThreadLock(String str) {
            Lock lock;
            synchronized (ProcessLock.threadLocksMap) {
                try {
                    Map access$getThreadLocksMap$cp = ProcessLock.threadLocksMap;
                    Object obj = access$getThreadLocksMap$cp.get(str);
                    if (obj == null) {
                        obj = new ReentrantLock();
                        access$getThreadLocksMap$cp.put(str, obj);
                    }
                    lock = (Lock) obj;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return lock;
        }

        private Companion() {
        }
    }

    public ProcessLock(@OOXIXo String str, @oOoXoXO File file, boolean z) {
        File file2;
        IIX0o.x0xO0oo(str, "name");
        this.processLock = z;
        if (file != null) {
            file2 = new File(file, str + oxoX.f15239XO);
        } else {
            file2 = null;
        }
        this.lockFile = file2;
        this.threadLock = Companion.getThreadLock(str);
    }

    public static /* synthetic */ void lock$default(ProcessLock processLock2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = processLock2.processLock;
        }
        processLock2.lock(z);
    }

    public final void lock(boolean z) {
        this.threadLock.lock();
        if (z) {
            try {
                File file = this.lockFile;
                if (file != null) {
                    File parentFile = file.getParentFile();
                    if (parentFile != null) {
                        parentFile.mkdirs();
                    }
                    FileChannel channel = new FileOutputStream(this.lockFile).getChannel();
                    channel.lock();
                    this.lockChannel = channel;
                    return;
                }
                throw new IOException("No lock directory was provided.");
            } catch (IOException e) {
                this.lockChannel = null;
                Log.w(TAG, "Unable to grab file lock.", e);
            }
        }
    }

    public final void unlock() {
        try {
            FileChannel fileChannel = this.lockChannel;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.threadLock.unlock();
    }
}
