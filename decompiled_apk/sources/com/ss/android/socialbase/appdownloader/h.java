package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes13.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final Queue<Integer> f26194a;
    private boolean b;
    private long c;
    private long d;
    private SoftReference<JumpUnknownSourceActivity> e;
    private Handler f;
    private Runnable g;

    /* loaded from: classes13.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final h f26199a = new h();
    }

    private h() {
        this.f26194a = new ArrayDeque();
        this.b = false;
        this.f = new Handler(Looper.getMainLooper());
        this.g = new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.c();
            }
        };
        com.ss.android.socialbase.downloader.a.a.a().a(new a.InterfaceC1053a() { // from class: com.ss.android.socialbase.appdownloader.h.2
            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1053a
            public void b() {
                boolean hasCallbacks;
                if (h.this.f26194a.isEmpty()) {
                    return;
                }
                long a2 = com.ss.android.socialbase.downloader.g.a.c().a("install_on_resume_install_interval", 120000L);
                long currentTimeMillis = System.currentTimeMillis() - h.this.d;
                if (currentTimeMillis < a2) {
                    hasCallbacks = h.this.f.hasCallbacks(h.this.g);
                    if (!hasCallbacks) {
                        h.this.f.postDelayed(h.this.g, a2 - currentTimeMillis);
                        return;
                    }
                    return;
                }
                h.this.d = System.currentTimeMillis();
                h.this.c();
            }

            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1053a
            public void c() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(Context context, int i, boolean z) {
        int b = c.b(context, i, z);
        if (b == 1) {
            this.b = true;
        }
        this.c = System.currentTimeMillis();
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        final Integer poll;
        if (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.a.a.a().b()) {
            synchronized (this.f26194a) {
                poll = this.f26194a.poll();
            }
            this.f.removeCallbacks(this.g);
            if (poll != null) {
                final Context O = com.ss.android.socialbase.downloader.downloader.c.O();
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    this.f.post(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.3
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.b(O, poll.intValue(), false);
                        }
                    });
                } else {
                    b(O, poll.intValue(), false);
                }
                this.f.postDelayed(this.g, 20000L);
                return;
            }
            this.b = false;
        }
    }

    private boolean d() {
        return System.currentTimeMillis() - this.c < 1000;
    }

    public void a(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        c();
    }

    public JumpUnknownSourceActivity b() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.e;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.e = null;
        return jumpUnknownSourceActivity;
    }

    public static h a() {
        return a.f26199a;
    }

    public int a(final Context context, final int i, final boolean z) {
        if (z) {
            return b(context, i, z);
        }
        if (d()) {
            this.f.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.4
                @Override // java.lang.Runnable
                public void run() {
                    h.this.a(context, i, z);
                }
            }, 1000L);
            return 1;
        }
        if (com.ss.android.socialbase.downloader.a.a.a().b()) {
            com.ss.android.socialbase.downloader.c.a.c("leaves", "on Foreground");
            return b(context, i, z);
        }
        if (b.a()) {
            return 1;
        }
        boolean z2 = Build.VERSION.SDK_INT < 29;
        if (this.f26194a.isEmpty() && !this.b && z2) {
            return b(context, i, z);
        }
        int a2 = com.ss.android.socialbase.downloader.g.a.c().a("install_queue_size", 3);
        synchronized (this.f26194a) {
            while (this.f26194a.size() > a2) {
                try {
                    this.f26194a.poll();
                } finally {
                }
            }
        }
        if (z2) {
            this.f.removeCallbacks(this.g);
            this.f.postDelayed(this.g, com.ss.android.socialbase.downloader.g.a.a(i).a("install_queue_timeout", 20000L));
        }
        synchronized (this.f26194a) {
            try {
                if (!this.f26194a.contains(Integer.valueOf(i))) {
                    this.f26194a.offer(Integer.valueOf(i));
                }
            } finally {
            }
        }
        return 1;
    }

    public void a(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.e = new SoftReference<>(jumpUnknownSourceActivity);
    }
}
