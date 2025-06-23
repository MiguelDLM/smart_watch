package com.baidu.navisdk.cmdrequest;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Deprecated
/* loaded from: classes7.dex */
public class b {
    private g b;
    private final d c = new a();

    /* renamed from: a, reason: collision with root package name */
    private final f f6681a = new f("msgqueue");

    /* loaded from: classes7.dex */
    public class a implements d {
        public a() {
        }

        @Override // com.baidu.navisdk.cmdrequest.b.d
        public void a(i iVar, com.baidu.navisdk.cmdrequest.f fVar) {
            Handler handler;
            Handler handler2;
            if (fVar.a()) {
                if (iVar != null && !iVar.f && (handler2 = iVar.e) != null) {
                    Message obtainMessage = handler2.obtainMessage(iVar.g);
                    obtainMessage.arg1 = 0;
                    obtainMessage.obj = new j(iVar, null);
                    obtainMessage.sendToTarget();
                    iVar.f = true;
                }
            } else if (iVar != null && !iVar.f && (handler = iVar.e) != null) {
                Message obtainMessage2 = handler.obtainMessage(iVar.g);
                obtainMessage2.arg1 = fVar.f6693a;
                obtainMessage2.obj = new j(iVar, null);
                obtainMessage2.sendToTarget();
                iVar.f = true;
            }
            b.this.f6681a.b(iVar);
        }
    }

    /* renamed from: com.baidu.navisdk.cmdrequest.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class CallableC0175b implements Callable<com.baidu.navisdk.cmdrequest.f> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f6683a;

        public CallableC0175b(i iVar) {
            this.f6683a = iVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.baidu.navisdk.cmdrequest.f call() throws Exception {
            i iVar = this.f6683a;
            com.baidu.navisdk.cmdrequest.f a2 = b.a(iVar, iVar.f6694a);
            i iVar2 = this.f6683a;
            iVar2.l.a(iVar2, a2);
            return a2;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Callable<com.baidu.navisdk.cmdrequest.f> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f6684a;
        final /* synthetic */ g b;

        public c(i iVar, g gVar) {
            this.f6684a = iVar;
            this.b = gVar;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ com.baidu.navisdk.cmdrequest.f call() throws Exception {
            call();
            throw null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.baidu.navisdk.cmdrequest.f call() throws Exception {
            i iVar = this.f6684a;
            b.a(iVar, iVar.f6694a, this.b);
            throw null;
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a(i iVar, com.baidu.navisdk.cmdrequest.f fVar);
    }

    /* loaded from: classes7.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private static final b f6685a = new b();
    }

    /* loaded from: classes7.dex */
    public class f extends HandlerThread {

        /* renamed from: a, reason: collision with root package name */
        private final Map<i, Future<com.baidu.navisdk.cmdrequest.f>> f6686a;

        /* loaded from: classes7.dex */
        public class a extends com.baidu.navisdk.util.worker.f<String, String> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ i f6687a;

            /* renamed from: com.baidu.navisdk.cmdrequest.b$f$a$a, reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0176a extends com.baidu.navisdk.util.worker.f<Callable<com.baidu.navisdk.cmdrequest.f>, com.baidu.navisdk.cmdrequest.f> {
                public C0176a(a aVar, String str, Callable callable) {
                    super(str, callable);
                }

                @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
                public com.baidu.navisdk.cmdrequest.f execute() {
                    try {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("CommandCenter", "addRequest --> start request data!");
                        }
                        com.baidu.navisdk.cmdrequest.f fVar = (com.baidu.navisdk.cmdrequest.f) ((Callable) this.inData).call();
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("CommandCenter", "addRequest --> result = " + fVar);
                            LogUtil.e("CommandCenter", "addRequest --> end request data!");
                        }
                        return fVar;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, String str2, i iVar) {
                super(str, str2);
                this.f6687a = iVar;
            }

            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                Callable<com.baidu.navisdk.cmdrequest.f> b;
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("CommandCenter", "addRequest --> submit request task to queue!");
                    LogUtil.e("CommandCenter", "addRequest --> reqdata = " + this.f6687a);
                }
                if (b.this.b != null) {
                    b = b.a(this.f6687a, b.this.b);
                } else {
                    b = b.b(this.f6687a);
                }
                if (b == null) {
                    return null;
                }
                try {
                    f.this.f6686a.put(this.f6687a, com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) new C0176a(this, "CommandCenter", b), new com.baidu.navisdk.util.worker.e(99, 0)));
                    return null;
                } catch (Throwable unused) {
                    return null;
                }
            }
        }

        /* renamed from: com.baidu.navisdk.cmdrequest.b$f$b, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0177b extends com.baidu.navisdk.util.worker.f<String, String> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ i f6688a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0177b(String str, String str2, i iVar) {
                super(str, str2);
                this.f6688a = iVar;
            }

            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                Handler handler;
                Handler handler2;
                Handler handler3;
                Handler handler4;
                Handler handler5;
                Handler handler6;
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("CommandCenter", "addRequest --> cancel request task from queue!");
                }
                Future future = (Future) f.this.f6686a.remove(this.f6688a);
                if (future == null) {
                    return null;
                }
                future.cancel(true);
                com.baidu.navisdk.cmdrequest.f fVar = new com.baidu.navisdk.cmdrequest.f();
                try {
                    try {
                        try {
                            try {
                                try {
                                    com.baidu.navisdk.cmdrequest.f fVar2 = (com.baidu.navisdk.cmdrequest.f) future.get();
                                    i iVar = this.f6688a;
                                    if (iVar != null && !iVar.f && (handler6 = iVar.e) != null) {
                                        Message obtainMessage = handler6.obtainMessage(iVar.g);
                                        if (fVar2 != null) {
                                            obtainMessage.arg1 = fVar2.f6693a;
                                        } else {
                                            obtainMessage.arg1 = 4;
                                        }
                                        obtainMessage.obj = new j(this.f6688a, null);
                                        obtainMessage.sendToTarget();
                                        this.f6688a.f = true;
                                    }
                                } catch (ExecutionException e) {
                                    LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "task ExecutionException, reqdata=" + this.f6688a);
                                    fVar.a(-9999, "Exception:reqdata=" + this.f6688a);
                                    if (LogUtil.LOGGABLE) {
                                        e.printStackTrace();
                                    }
                                    i iVar2 = this.f6688a;
                                    if (iVar2 != null && !iVar2.f && (handler4 = iVar2.e) != null) {
                                        Message obtainMessage2 = handler4.obtainMessage(iVar2.g);
                                        obtainMessage2.arg1 = fVar.f6693a;
                                        obtainMessage2.obj = new j(this.f6688a, null);
                                        obtainMessage2.sendToTarget();
                                        this.f6688a.f = true;
                                    }
                                }
                            } catch (InterruptedException e2) {
                                LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "task interrupted because timeout, reqdata=" + this.f6688a);
                                fVar.b(2);
                                if (LogUtil.LOGGABLE) {
                                    e2.printStackTrace();
                                }
                                i iVar3 = this.f6688a;
                                if (iVar3 != null && !iVar3.f && (handler3 = iVar3.e) != null) {
                                    Message obtainMessage3 = handler3.obtainMessage(iVar3.g);
                                    obtainMessage3.arg1 = fVar.f6693a;
                                    obtainMessage3.obj = new j(this.f6688a, null);
                                    obtainMessage3.sendToTarget();
                                    this.f6688a.f = true;
                                }
                            }
                        } catch (Exception e3) {
                            LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "task Exception, reqdata=" + this.f6688a);
                            fVar.a(-9999, "Exception:reqdata=" + this.f6688a);
                            if (LogUtil.LOGGABLE) {
                                e3.printStackTrace();
                            }
                            i iVar4 = this.f6688a;
                            if (iVar4 != null && !iVar4.f && (handler2 = iVar4.e) != null) {
                                Message obtainMessage4 = handler2.obtainMessage(iVar4.g);
                                obtainMessage4.arg1 = fVar.f6693a;
                                obtainMessage4.obj = new j(this.f6688a, null);
                                obtainMessage4.sendToTarget();
                                this.f6688a.f = true;
                            }
                        }
                    } catch (CancellationException e4) {
                        LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "task cancelled because timeout,reqdata=" + this.f6688a);
                        fVar.b(2);
                        if (LogUtil.LOGGABLE) {
                            e4.printStackTrace();
                        }
                        i iVar5 = this.f6688a;
                        if (iVar5 != null && !iVar5.f && (handler = iVar5.e) != null) {
                            Message obtainMessage5 = handler.obtainMessage(iVar5.g);
                            obtainMessage5.arg1 = fVar.f6693a;
                            obtainMessage5.obj = new j(this.f6688a, null);
                            obtainMessage5.sendToTarget();
                            this.f6688a.f = true;
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    i iVar6 = this.f6688a;
                    if (iVar6 != null && !iVar6.f && (handler5 = iVar6.e) != null) {
                        Message obtainMessage6 = handler5.obtainMessage(iVar6.g);
                        obtainMessage6.arg1 = fVar.f6693a;
                        obtainMessage6.obj = new j(this.f6688a, null);
                        obtainMessage6.sendToTarget();
                        this.f6688a.f = true;
                    }
                    throw th;
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c extends com.baidu.navisdk.util.worker.f<String, String> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f6689a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, String str2, int i) {
                super(str, str2);
                this.f6689a = i;
            }

            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                Handler handler;
                Handler handler2;
                Handler handler3;
                Handler handler4;
                Handler handler5;
                Handler handler6;
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("CommandCenter", "cancelRequestInSubSystem --> cancel request task from queue!");
                }
                Iterator it = f.this.f6686a.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    Future future = (Future) entry.getValue();
                    i iVar = (i) entry.getKey();
                    if (iVar.c == this.f6689a) {
                        it.remove();
                        future.cancel(true);
                        com.baidu.navisdk.cmdrequest.f fVar = new com.baidu.navisdk.cmdrequest.f();
                        try {
                            try {
                                try {
                                    try {
                                        try {
                                            com.baidu.navisdk.cmdrequest.f fVar2 = (com.baidu.navisdk.cmdrequest.f) future.get();
                                            if (!iVar.f && (handler6 = iVar.e) != null) {
                                                Message obtainMessage = handler6.obtainMessage(100000);
                                                obtainMessage.arg1 = fVar2.f6693a;
                                                obtainMessage.obj = new j(iVar, null);
                                                obtainMessage.sendToTarget();
                                                iVar.f = true;
                                            }
                                        } catch (CancellationException unused) {
                                            LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "task cancelled because cancel, reqdata=" + iVar);
                                            fVar.a(-3);
                                            if (!iVar.f && (handler4 = iVar.e) != null) {
                                                Message obtainMessage2 = handler4.obtainMessage(100000);
                                                obtainMessage2.arg1 = fVar.f6693a;
                                                obtainMessage2.obj = new j(iVar, null);
                                                obtainMessage2.sendToTarget();
                                                iVar.f = true;
                                            }
                                        }
                                    } catch (ExecutionException unused2) {
                                        LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "task ExecutionException,reqdata=" + iVar);
                                        fVar.a(-9999, "Exception:reqdata=" + iVar);
                                        if (!iVar.f && (handler3 = iVar.e) != null) {
                                            Message obtainMessage3 = handler3.obtainMessage(100000);
                                            obtainMessage3.arg1 = fVar.f6693a;
                                            obtainMessage3.obj = new j(iVar, null);
                                            obtainMessage3.sendToTarget();
                                            iVar.f = true;
                                        }
                                    }
                                } catch (Exception e) {
                                    LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "task Exception,reqdata=" + iVar);
                                    fVar.a(-9999, "Exception:" + e);
                                    if (!iVar.f && (handler2 = iVar.e) != null) {
                                        Message obtainMessage4 = handler2.obtainMessage(100000);
                                        obtainMessage4.arg1 = fVar.f6693a;
                                        obtainMessage4.obj = new j(iVar, null);
                                        obtainMessage4.sendToTarget();
                                        iVar.f = true;
                                    }
                                }
                            } catch (InterruptedException unused3) {
                                LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "task interrupted because cancel, reqdata=" + iVar);
                                fVar.a(-3);
                                if (!iVar.f && (handler = iVar.e) != null) {
                                    Message obtainMessage5 = handler.obtainMessage(100000);
                                    obtainMessage5.arg1 = fVar.f6693a;
                                    obtainMessage5.obj = new j(iVar, null);
                                    obtainMessage5.sendToTarget();
                                    iVar.f = true;
                                }
                            }
                        } catch (Throwable th) {
                            if (!iVar.f && (handler5 = iVar.e) != null) {
                                Message obtainMessage6 = handler5.obtainMessage(100000);
                                obtainMessage6.arg1 = fVar.f6693a;
                                obtainMessage6.obj = new j(iVar, null);
                                obtainMessage6.sendToTarget();
                                iVar.f = true;
                            }
                            throw th;
                        }
                    }
                }
                return null;
            }
        }

        /* loaded from: classes7.dex */
        public class d extends com.baidu.navisdk.util.worker.f<String, String> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ i f6690a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(String str, String str2, i iVar) {
                super(str, str2);
                this.f6690a = iVar;
            }

            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("CommandCenter", "removeRequest --> remove request task from queue, reqdata = " + this.f6690a);
                }
                f.this.f6686a.remove(this.f6690a);
                return null;
            }
        }

        public f(String str) {
            super(str);
            this.f6686a = Collections.synchronizedMap(new HashMap());
            start();
        }

        public void b(i iVar) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("CommandCenter", "removeRequest() --> reqdata = " + iVar);
            }
            com.baidu.navisdk.util.worker.c.a().b(new d("CommandCenter2", null, iVar), new com.baidu.navisdk.util.worker.e(200, 0));
        }

        public void a(i iVar) {
            LogUtil.e("CommandCenter", "task added to request queue,reqdata=" + iVar.toString());
            int i = iVar.c;
            if (i != 5 && i != 4 && i != 7) {
                a(i);
            }
            com.baidu.navisdk.util.worker.c.a().b(new a("CommandCenter2", null, iVar), new com.baidu.navisdk.util.worker.e(200, 0));
            com.baidu.navisdk.util.worker.c.a().c(new C0177b("CommandCenter3", null, iVar), new com.baidu.navisdk.util.worker.e(200, 0), iVar.h);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("CommandCenter", "cancelRequestInSubSystem() --> subsystem = " + i);
            }
            com.baidu.navisdk.util.worker.c.a().b(new c("CommandCenter2", null, i), new com.baidu.navisdk.util.worker.e(200, 0));
        }
    }

    public static b a() {
        return e.f6685a;
    }

    public static Callable<com.baidu.navisdk.cmdrequest.f> b(i iVar) {
        return new CallableC0175b(iVar);
    }

    public int a(i iVar) {
        iVar.l = this.c;
        this.f6681a.a(iVar);
        return 0;
    }

    public int a(int i) {
        this.f6681a.a(i);
        return 0;
    }

    public static com.baidu.navisdk.cmdrequest.f a(i iVar, String str) throws Exception {
        com.baidu.navisdk.cmdrequest.f fVar = new com.baidu.navisdk.cmdrequest.f();
        com.baidu.navisdk.cmdrequest.a a2 = com.baidu.navisdk.cmdrequest.e.a(iVar);
        if (a2 != null) {
            return a2.a(iVar);
        }
        fVar.a(-9999);
        return fVar;
    }

    public static com.baidu.navisdk.cmdrequest.f a(i iVar, String str, g gVar) throws Exception {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("CommandCenter", "doTask() --> start, reqdata = " + iVar + ", cmd = " + str + ", dispatcher = " + gVar);
        }
        new com.baidu.navisdk.cmdrequest.f();
        gVar.a(str);
        throw null;
    }

    public static Callable<com.baidu.navisdk.cmdrequest.f> a(i iVar, g gVar) {
        return new c(iVar, gVar);
    }
}
