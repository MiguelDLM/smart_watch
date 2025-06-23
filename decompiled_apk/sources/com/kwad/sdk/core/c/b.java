package com.kwad.sdk.core.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.KSLifecycleListener;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.bp;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes11.dex */
public class b implements c<Activity> {
    private static volatile b awp;
    private static final List<c> mListeners = new CopyOnWriteArrayList();
    private final AtomicBoolean Kc = new AtomicBoolean(false);

    @Nullable
    private Application mApplication;

    private b() {
    }

    public static b En() {
        if (awp == null) {
            synchronized (b.class) {
                try {
                    if (awp == null) {
                        awp = new b();
                    }
                } finally {
                }
            }
        }
        return awp;
    }

    public static boolean Eo() {
        try {
            if (bp.ay(((f) ServiceProvider.get(f.class)).getApiVersion(), "3.3.26")) {
                return KSLifecycleObserver.getInstance().isEnable();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Nullable
    public static Activity getCurrentActivity() {
        if (Eo()) {
            return KSLifecycleObserver.getInstance().getCurrentActivity();
        }
        if (a.El().isEnable()) {
            return a.El().getCurrentActivity();
        }
        return null;
    }

    public static boolean isAppOnForeground() {
        if (Eo()) {
            return KSLifecycleObserver.getInstance().isAppOnForeground();
        }
        if (a.El().isEnable()) {
            return a.El().isAppOnForeground();
        }
        return false;
    }

    public static boolean isEnable() {
        if (!Eo() && !a.El().isEnable()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.c.c
    /* renamed from: onActivityCreated, reason: merged with bridge method [inline-methods] */
    public void a(final Activity activity, final Bundle bundle) {
        c(new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.f.a
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(activity, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.c.c
    /* renamed from: onActivityDestroyed, reason: merged with bridge method [inline-methods] */
    public void b(final Activity activity) {
        c(new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.f.a
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.b(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.c.c
    /* renamed from: onActivityPaused, reason: merged with bridge method [inline-methods] */
    public void c(final Activity activity) {
        c(new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.f.a
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.c(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.c.c
    /* renamed from: onActivityResumed, reason: merged with bridge method [inline-methods] */
    public void d(final Activity activity) {
        c(new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.f.a
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.d(activity);
            }
        });
    }

    @Nullable
    public final Application getApplication() {
        return this.mApplication;
    }

    public final void init(Context context) {
        if (!this.Kc.get() && context != null) {
            this.Kc.set(true);
            try {
                if (bp.ay(((f) ServiceProvider.get(f.class)).getApiVersion(), "3.3.26")) {
                    this.mApplication = KSLifecycleObserver.getInstance().getApplication();
                    KSLifecycleObserver.getInstance().registerLifecycleListener(new KSLifecycleListener() { // from class: com.kwad.sdk.core.c.b.1
                        @Override // com.kwad.sdk.api.core.KSLifecycleListener
                        public final void onActivityCreated(final Activity activity, final Bundle bundle) {
                            b bVar = b.this;
                            b.c(new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.1.1
                                /* JADX INFO: Access modifiers changed from: private */
                                @Override // com.kwad.sdk.f.a
                                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                                public void accept(c cVar) {
                                    cVar.a(activity, bundle);
                                }
                            });
                        }

                        @Override // com.kwad.sdk.api.core.KSLifecycleListener
                        public final void onActivityDestroyed(final Activity activity) {
                            b bVar = b.this;
                            b.c(new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.1.4
                                /* JADX INFO: Access modifiers changed from: private */
                                @Override // com.kwad.sdk.f.a
                                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                                public void accept(c cVar) {
                                    cVar.b(activity);
                                }
                            });
                        }

                        @Override // com.kwad.sdk.api.core.KSLifecycleListener
                        public final void onActivityPaused(final Activity activity) {
                            b bVar = b.this;
                            b.c(new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.1.3
                                /* JADX INFO: Access modifiers changed from: private */
                                @Override // com.kwad.sdk.f.a
                                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                                public void accept(c cVar) {
                                    cVar.c(activity);
                                }
                            });
                        }

                        @Override // com.kwad.sdk.api.core.KSLifecycleListener
                        public final void onActivityResumed(final Activity activity) {
                            b bVar = b.this;
                            b.c(new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.1.2
                                /* JADX INFO: Access modifiers changed from: private */
                                @Override // com.kwad.sdk.f.a
                                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                                public void accept(c cVar) {
                                    cVar.d(activity);
                                }
                            });
                        }

                        @Override // com.kwad.sdk.api.core.KSLifecycleListener
                        public final void onBackToBackground() {
                            com.kwad.sdk.core.e.c.T("LifecycleHolder", "onBackToBackground");
                            b bVar = b.this;
                            b.c(new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.1.6
                                private static void c(c cVar) {
                                    cVar.onBackToBackground();
                                }

                                @Override // com.kwad.sdk.f.a
                                public final /* synthetic */ void accept(c cVar) {
                                    c(cVar);
                                }
                            });
                        }

                        @Override // com.kwad.sdk.api.core.KSLifecycleListener
                        public final void onBackToForeground() {
                            com.kwad.sdk.core.e.c.T("LifecycleHolder", "onBackToForeground");
                            b bVar = b.this;
                            b.c(new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.1.5
                                private static void c(c cVar) {
                                    cVar.onBackToForeground();
                                }

                                @Override // com.kwad.sdk.f.a
                                public final /* synthetic */ void accept(c cVar) {
                                    c(cVar);
                                }
                            });
                        }
                    });
                } else {
                    com.kwad.sdk.core.e.c.T("LifecycleHolder", "init KSLifecycleObserver not support");
                }
            } catch (Throwable unused) {
            }
            Application ON = l.ON();
            if (ON != null) {
                this.mApplication = ON;
                a.El().init(this.mApplication);
                a.El().a(this);
            }
        }
    }

    @Override // com.kwad.sdk.core.c.c
    public final void onBackToBackground() {
        com.kwad.sdk.core.e.c.T("LifecycleHolder", "onBackToBackground old");
        c(new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.7
            private static void c(c cVar) {
                cVar.onBackToBackground();
            }

            @Override // com.kwad.sdk.f.a
            public final /* synthetic */ void accept(c cVar) {
                c(cVar);
            }
        });
    }

    @Override // com.kwad.sdk.core.c.c
    public final void onBackToForeground() {
        com.kwad.sdk.core.e.c.T("LifecycleHolder", "onBackToForeground old");
        c(new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.6
            private static void c(c cVar) {
                cVar.onBackToForeground();
            }

            @Override // com.kwad.sdk.f.a
            public final /* synthetic */ void accept(c cVar) {
                c(cVar);
            }
        });
    }

    public static void b(c cVar) {
        mListeners.remove(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void c(com.kwad.sdk.f.a<c> aVar) {
        for (c cVar : mListeners) {
            if (cVar != null) {
                aVar.accept(cVar);
            }
        }
    }

    public static void a(c cVar) {
        mListeners.add(cVar);
    }
}
