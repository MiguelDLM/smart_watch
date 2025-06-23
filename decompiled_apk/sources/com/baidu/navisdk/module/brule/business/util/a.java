package com.baidu.navisdk.module.brule.business.util;

import android.os.Message;

/* loaded from: classes7.dex */
public class a {
    private static a c;

    /* renamed from: a, reason: collision with root package name */
    int f7045a = 4;
    private com.baidu.navisdk.util.worker.loop.a b = new HandlerC0228a("behavRules");

    /* renamed from: com.baidu.navisdk.module.brule.business.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class HandlerC0228a extends com.baidu.navisdk.util.worker.loop.a {
        public HandlerC0228a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            int i = message.arg1;
            if (message.what == 5556) {
                if (i != 3) {
                    if (i == 4 && a.this.f7045a == 3) {
                        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_s_call_idle"));
                    }
                } else if (a.this.f7045a == 4) {
                    com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_s_call_offhook"));
                }
                a.this.f7045a = i;
            }
        }
    }

    private a() {
    }

    public static a c() {
        if (c == null) {
            c = new a();
        }
        return c;
    }

    public void a() {
        com.baidu.navisdk.util.listener.a.a(this.b);
    }

    public void b() {
        com.baidu.navisdk.util.listener.a.b(this.b);
    }
}
