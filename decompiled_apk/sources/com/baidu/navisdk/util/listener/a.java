package com.baidu.navisdk.util.listener;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.worker.c;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final List<Handler> f9315a = new ArrayList();
    private static Context b = null;
    private static volatile boolean c = false;
    private static AudioManager d;
    private static b e;

    /* renamed from: com.baidu.navisdk.util.listener.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0500a extends f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f9316a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0500a(String str, String str2, Context context) {
            super(str, str2);
            this.f9316a = context;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            a.a(this.f9316a);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements AudioManager.OnAudioFocusChangeListener {
        /* JADX WARN: Removed duplicated region for block: B:12:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0089  */
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onAudioFocusChange(int r9) {
            /*
                r8 = this;
                android.content.Context r9 = com.baidu.navisdk.util.listener.a.a()
                android.media.AudioManager r0 = com.baidu.navisdk.util.listener.a.b()
                if (r0 != 0) goto L17
                if (r9 == 0) goto L17
                java.lang.String r0 = "audio"
                java.lang.Object r9 = r9.getSystemService(r0)
                android.media.AudioManager r9 = (android.media.AudioManager) r9
                com.baidu.navisdk.util.listener.a.a(r9)
            L17:
                android.media.AudioManager r9 = com.baidu.navisdk.util.listener.a.b()
                r0 = 4
                r1 = 3
                r2 = 1
                if (r9 == 0) goto L33
                int r3 = r9.getMode()
                if (r3 != r2) goto L28
                r3 = 1
                goto L34
            L28:
                r4 = -2
                if (r3 == r4) goto L33
                r4 = -1
                if (r3 == r4) goto L33
                if (r3 != 0) goto L31
                goto L33
            L31:
                r3 = 3
                goto L34
            L33:
                r3 = 4
            L34:
                com.baidu.navisdk.util.common.g r4 = com.baidu.navisdk.util.common.g.COMMON
                boolean r5 = r4.d()
                java.lang.String r6 = "PhoneStatusReceiver"
                if (r5 == 0) goto L5a
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r7 = "onAudioFocusChange type = "
                r5.append(r7)
                r5.append(r3)
                java.lang.String r7 = ", am = "
                r5.append(r7)
                r5.append(r9)
                java.lang.String r9 = r5.toString()
                r4.e(r6, r9)
            L5a:
                if (r3 == r2) goto L89
                if (r3 == r1) goto L75
                if (r3 == r0) goto L61
                goto L9b
            L61:
                boolean r9 = r4.d()
                if (r9 == 0) goto L6c
                java.lang.String r9 = "phone state change to CALL_STATE_IDLE"
                r4.e(r6, r9)
            L6c:
                com.baidu.navisdk.util.common.b r9 = com.baidu.navisdk.util.common.b.b()
                r0 = 0
                r9.a(r0)
                goto L9b
            L75:
                boolean r9 = r4.d()
                if (r9 == 0) goto L80
                java.lang.String r9 = "phone state change to CALL_STATE_OFFHOOK"
                r4.e(r6, r9)
            L80:
                com.baidu.navisdk.util.common.b r9 = com.baidu.navisdk.util.common.b.b()
                r0 = 2
                r9.a(r0)
                goto L9b
            L89:
                boolean r9 = r4.d()
                if (r9 == 0) goto L94
                java.lang.String r9 = "phone state change to CALL_STATE_RINGING"
                r4.e(r6, r9)
            L94:
                com.baidu.navisdk.util.common.b r9 = com.baidu.navisdk.util.common.b.b()
                r9.a(r2)
            L9b:
                com.baidu.navisdk.util.listener.a.a(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.listener.a.b.onAudioFocusChange(int):void");
        }
    }

    public static synchronized void c() {
        synchronized (a.class) {
            try {
                if (!c) {
                    return;
                }
                Context context = b;
                if (d == null && context != null) {
                    d = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
                }
                AudioManager audioManager = d;
                if (audioManager != null) {
                    audioManager.abandonAudioFocus(e);
                }
                c = false;
                b = null;
                e = null;
                d = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b(Handler handler) {
        if (handler == null) {
            return;
        }
        List<Handler> list = f9315a;
        synchronized (list) {
            list.remove(handler);
        }
    }

    public static void a(Handler handler) {
        if (handler == null) {
            return;
        }
        List<Handler> list = f9315a;
        synchronized (list) {
            try {
                if (!list.contains(handler)) {
                    list.add(handler);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i) {
        ArrayList<Handler> arrayList;
        List<Handler> list = f9315a;
        synchronized (list) {
            try {
                arrayList = !list.isEmpty() ? new ArrayList(list) : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        for (Handler handler : arrayList) {
            if (handler != null) {
                Message.obtain(handler, 5556, i, 0, null).sendToTarget();
            }
        }
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            try {
                b = context;
                if (c) {
                    return;
                }
                if (context == null) {
                    return;
                }
                AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
                d = audioManager;
                if (audioManager != null && !audioManager.isMusicActive()) {
                    b bVar = new b();
                    e = bVar;
                    if (audioManager.requestAudioFocus(bVar, 3, 2) == 1) {
                        g gVar = g.COMMON;
                        if (gVar.d()) {
                            gVar.e("PhoneStatusReceiver", "checkAudioFocus, result is 1");
                        }
                    } else {
                        g gVar2 = g.COMMON;
                        if (gVar2.d()) {
                            gVar2.e("PhoneStatusReceiver", "checkAudioFocus, result is not 1");
                        }
                    }
                }
                c = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b(Context context) {
        c.a().a((f) new C0500a("PhoneStatus-onCreateView", null, context), new e(2, 1));
    }
}
