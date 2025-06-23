package com.ss.android.downloadlib.g;

import android.annotation.TargetApi;
import android.os.AsyncTask;

/* loaded from: classes11.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    static final a f26118a = new C1047b();

    /* loaded from: classes11.dex */
    public static class a {
        private a() {
        }

        public <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.execute(tArr);
            } catch (Throwable unused) {
            }
        }
    }

    @TargetApi(11)
    /* renamed from: com.ss.android.downloadlib.g.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C1047b extends a {
        private C1047b() {
            super();
        }

        @Override // com.ss.android.downloadlib.g.b.a
        public <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        f26118a.a(asyncTask, tArr);
    }
}
