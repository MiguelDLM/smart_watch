package com.baidu.mapframework.nirvana.assets;

import androidx.annotation.NonNull;
import com.baidu.mapframework.nirvana.ExceptionCallback;
import com.baidu.mapframework.nirvana.NirvanaFramework;
import com.baidu.mapframework.nirvana.Utils;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.monitor.RecordType;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes7.dex */
public class AssetsManager {
    /* JADX INFO: Access modifiers changed from: private */
    public static void b(@NonNull AssetsTask assetsTask) {
        NirvanaFramework.getMonitor().markFinish(assetsTask);
    }

    public static void open(@NonNull Module module, @NonNull final AssetsTask assetsTask, @NonNull ScheduleConfig scheduleConfig) {
        if (!Utils.executeParamCheck(module, assetsTask, scheduleConfig)) {
            return;
        }
        NirvanaFramework.getMonitor().markSubmit(RecordType.ASSETS, assetsTask, module, scheduleConfig);
        NirvanaFramework.getMonitor().markRunning(assetsTask);
        try {
            final InputStream open = assetsTask.b().getAssets().open(assetsTask.c(), assetsTask.a());
            assetsTask.a(new InputStream() { // from class: com.baidu.mapframework.nirvana.assets.AssetsManager.1
                @Override // java.io.InputStream
                public int available() throws IOException {
                    return open.available();
                }

                @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    AssetsManager.b(assetsTask);
                    open.close();
                }

                @Override // java.io.InputStream
                public void mark(int i) {
                    open.mark(i);
                }

                @Override // java.io.InputStream
                public boolean markSupported() {
                    return open.markSupported();
                }

                @Override // java.io.InputStream
                public int read(byte[] bArr) throws IOException {
                    return open.read(bArr);
                }

                @Override // java.io.InputStream
                public synchronized void reset() throws IOException {
                    open.reset();
                }

                @Override // java.io.InputStream
                public long skip(long j) throws IOException {
                    return open.skip(j);
                }

                @Override // java.io.InputStream
                public int read(byte[] bArr, int i, int i2) throws IOException {
                    return open.read(bArr, i, i2);
                }

                @Override // java.io.InputStream
                public int read() throws IOException {
                    return open.read();
                }
            });
        } catch (Exception e) {
            ExceptionCallback exceptionCallback = assetsTask.getExceptionCallback();
            if (exceptionCallback != null) {
                exceptionCallback.onException(e);
            } else {
                NirvanaFramework.onUncaughtException("AssetsManager", e);
            }
        }
    }
}
