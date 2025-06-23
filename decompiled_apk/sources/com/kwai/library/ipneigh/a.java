package com.kwai.library.ipneigh;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes11.dex */
final class a {

    /* renamed from: com.kwai.library.ipneigh.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0879a extends Thread {
        private final InputStream aVD;

        public C0879a(InputStream inputStream) {
            super("NoopStreamConsumer");
            this.aVD = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            BufferedReader bufferedReader;
            Throwable th;
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(this.aVD));
                do {
                    try {
                    } catch (IOException unused) {
                        bufferedReader2 = bufferedReader;
                        a.closeQuietly(bufferedReader2);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        a.closeQuietly(bufferedReader);
                        throw th;
                    }
                } while (bufferedReader.readLine() != null);
                a.closeQuietly(bufferedReader);
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface b<T> {
        T b(BufferedReader bufferedReader);
    }

    private static <T> T a(String str, b<T> bVar) {
        BufferedReader bufferedReader;
        Process process = null;
        try {
            Process exec = Runtime.getRuntime().exec(str);
            try {
                C0879a c0879a = new C0879a(exec.getErrorStream());
                c0879a.start();
                bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                try {
                    T b2 = bVar.b(bufferedReader);
                    c0879a.join();
                    exec.waitFor();
                    exec.destroy();
                    closeQuietly(bufferedReader);
                    return b2;
                } catch (Throwable th) {
                    th = th;
                    process = exec;
                    if (process != null) {
                        process.destroy();
                    }
                    closeQuietly(bufferedReader);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String hy(String str) {
        try {
            return (String) a(str, new b<String>() { // from class: com.kwai.library.ipneigh.a.1
                private static String a(BufferedReader bufferedReader) {
                    String readLine = bufferedReader.readLine();
                    do {
                    } while (bufferedReader.readLine() != null);
                    return readLine;
                }

                @Override // com.kwai.library.ipneigh.a.b
                public final /* synthetic */ String b(BufferedReader bufferedReader) {
                    return a(bufferedReader);
                }
            });
        } catch (IOException | InterruptedException unused) {
            return null;
        }
    }
}
