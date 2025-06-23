package Ox0XO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes6.dex */
public class ooOOo0oXI {

    /* renamed from: I0Io, reason: collision with root package name */
    public Object f2923I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public RandomAccessFile f2924II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public File f2925oIX0oI;

    public ooOOo0oXI(File file, String str) throws Exception {
        this.f2925oIX0oI = new File(file, str);
        if (oOoXoXO.I0Io("java.nio.channels.FileLock")) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.f2925oIX0oI, "rw");
                this.f2924II0xO0 = randomAccessFile;
                Object invoke = randomAccessFile.getClass().getMethod("getChannel", null).invoke(this.f2924II0xO0, null);
                this.f2923I0Io = invoke.getClass().getMethod("tryLock", null).invoke(invoke, null);
            } catch (IllegalAccessException unused) {
                this.f2923I0Io = null;
            } catch (IllegalArgumentException unused2) {
                this.f2923I0Io = null;
            } catch (NoSuchMethodException unused3) {
                this.f2923I0Io = null;
            }
            if (this.f2923I0Io == null) {
                oIX0oI();
                throw new Exception("Problem obtaining file lock");
            }
        }
    }

    public void oIX0oI() {
        try {
            Object obj = this.f2923I0Io;
            if (obj != null) {
                obj.getClass().getMethod("release", null).invoke(this.f2923I0Io, null);
                this.f2923I0Io = null;
            }
        } catch (Exception unused) {
        }
        RandomAccessFile randomAccessFile = this.f2924II0xO0;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
            this.f2924II0xO0 = null;
        }
        File file = this.f2925oIX0oI;
        if (file != null && file.exists()) {
            this.f2925oIX0oI.delete();
        }
        this.f2925oIX0oI = null;
    }
}
