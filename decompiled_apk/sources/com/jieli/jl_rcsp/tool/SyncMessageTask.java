package com.jieli.jl_rcsp.tool;

import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.interfaces.listener.ThreadStateListener;
import com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback;
import com.jieli.jl_rcsp.model.NotificationMsg;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.command.watch.PushInfoDataToDeviceCmd;
import com.jieli.jl_rcsp.model.device.MessageInfo;
import com.jieli.jl_rcsp.task.SimpleTaskListener;
import com.jieli.jl_rcsp.task.smallfile.AddFileTask;
import com.jieli.jl_rcsp.task.smallfile.DeleteFileTask;
import com.jieli.jl_rcsp.util.CommandBuilder;
import com.jieli.jl_rcsp.util.JL_Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes10.dex */
public class SyncMessageTask extends Thread {
    public static final String i = "SyncMessageTask";

    /* renamed from: a, reason: collision with root package name */
    public final RcspOpImpl f18030a;
    public final LinkedBlockingQueue<SyncTask> b;
    public final ThreadStateListener c;
    public volatile boolean d;
    public volatile boolean e;
    public boolean f;
    public boolean g;
    public final Map<String, Short> h;

    /* loaded from: classes10.dex */
    public static class SyncTask {

        /* renamed from: a, reason: collision with root package name */
        public final int f18036a;
        public final NotificationMsg b;
        public final OnWatchOpCallback<Boolean> c;

        public SyncTask(int i, NotificationMsg notificationMsg, OnWatchOpCallback<Boolean> onWatchOpCallback) {
            this.f18036a = i;
            this.b = notificationMsg;
            this.c = onWatchOpCallback;
        }

        public OnWatchOpCallback<Boolean> getCallback() {
            return this.c;
        }

        public NotificationMsg getMessage() {
            return this.b;
        }

        public int getTaskOp() {
            return this.f18036a;
        }

        public String toString() {
            return "SyncTask{taskOp=" + this.f18036a + ", message=" + this.b + ", callback=" + this.c + '}';
        }
    }

    public SyncMessageTask(RcspOpImpl rcspOpImpl, ThreadStateListener threadStateListener) {
        super(i);
        this.b = new LinkedBlockingQueue<>();
        this.h = new HashMap();
        if (rcspOpImpl != null) {
            this.f18030a = rcspOpImpl;
            this.c = threadStateListener;
            return;
        }
        throw new NullPointerException("RcspOpImpl can not be null.");
    }

    public final void b(final NotificationMsg notificationMsg, final OnWatchOpCallback<Boolean> onWatchOpCallback) {
        if (notificationMsg == null) {
            return;
        }
        if (this.f18030a.getDeviceInfo() == null) {
            this.b.clear();
            return;
        }
        this.g = true;
        final AddFileTask addFileTask = new AddFileTask(this.f18030a, new AddFileTask.Param((byte) 6, new MessageInfo(notificationMsg.getAppName(), notificationMsg.getFlag(), notificationMsg.getTitle(), notificationMsg.getContent(), notificationMsg.getTime()).beanToData()));
        addFileTask.setListener(new SimpleTaskListener() { // from class: com.jieli.jl_rcsp.tool.SyncMessageTask.4
            @Override // com.jieli.jl_rcsp.task.SimpleTaskListener, com.jieli.jl_rcsp.task.TaskListener
            public void onCancel(int i2) {
                SyncMessageTask.this.g = false;
                SyncMessageTask.this.c();
                OnWatchOpCallback onWatchOpCallback2 = onWatchOpCallback;
                if (onWatchOpCallback2 != null) {
                    onWatchOpCallback2.onFailed(new BaseError(4098, "User cancel. reason : " + i2));
                }
            }

            @Override // com.jieli.jl_rcsp.task.SimpleTaskListener, com.jieli.jl_rcsp.task.TaskListener
            public void onError(int i2, String str) {
                SyncMessageTask.this.g = false;
                SyncMessageTask.this.c();
                OnWatchOpCallback onWatchOpCallback2 = onWatchOpCallback;
                if (onWatchOpCallback2 != null) {
                    onWatchOpCallback2.onFailed(new BaseError(i2, str));
                }
            }

            @Override // com.jieli.jl_rcsp.task.SimpleTaskListener, com.jieli.jl_rcsp.task.TaskListener
            public void onFinish() {
                SyncMessageTask syncMessageTask = SyncMessageTask.this;
                syncMessageTask.a(syncMessageTask.a(notificationMsg.getAppName(), notificationMsg.getTime()), addFileTask.getFile().id);
                SyncMessageTask.this.g = false;
                SyncMessageTask.this.c();
                OnWatchOpCallback onWatchOpCallback2 = onWatchOpCallback;
                if (onWatchOpCallback2 != null) {
                    onWatchOpCallback2.onSuccess(Boolean.TRUE);
                }
            }
        });
        addFileTask.start();
        if (this.g) {
            b();
        }
    }

    public final void c(NotificationMsg notificationMsg, final OnWatchOpCallback<Boolean> onWatchOpCallback) {
        if (this.f18030a.getDeviceInfo() == null) {
            this.b.clear();
            return;
        }
        this.g = true;
        RcspOpImpl rcspOpImpl = this.f18030a;
        rcspOpImpl.sendRcspCommand(rcspOpImpl.getTargetDevice(), CommandBuilder.buildRemoveMessageCmd(new PushInfoDataToDeviceCmd.RemoveMsg(notificationMsg.getAppName(), notificationMsg.getTime())), new BooleanRcspActionCallback("removeMessage", new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.tool.SyncMessageTask.3
            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onFailed(BaseError baseError) {
                JL_Log.e(SyncMessageTask.i, "removeMessage", "onFailed ---> " + baseError);
                SyncMessageTask.this.g = false;
                SyncMessageTask.this.c();
                OnWatchOpCallback onWatchOpCallback2 = onWatchOpCallback;
                if (onWatchOpCallback2 != null) {
                    onWatchOpCallback2.onFailed(baseError);
                }
            }

            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onSuccess(Boolean bool) {
                SyncMessageTask.this.g = false;
                SyncMessageTask.this.c();
                OnWatchOpCallback onWatchOpCallback2 = onWatchOpCallback;
                if (onWatchOpCallback2 != null) {
                    onWatchOpCallback2.onSuccess(Boolean.TRUE);
                }
            }
        }));
        if (this.g) {
            b();
        }
    }

    public final void d(NotificationMsg notificationMsg, final OnWatchOpCallback<Boolean> onWatchOpCallback) {
        if (notificationMsg == null) {
            return;
        }
        if (this.f18030a.getDeviceInfo() == null) {
            this.b.clear();
            return;
        }
        final String a2 = a(notificationMsg.getAppName(), notificationMsg.getTime());
        Short a3 = a(a2);
        JL_Log.d(i, "removeMessageBySFT", "key = " + a2 + ", id = " + a3);
        if (a3 == null) {
            return;
        }
        this.g = true;
        DeleteFileTask deleteFileTask = new DeleteFileTask(this.f18030a, new DeleteFileTask.Param((byte) 6, a3.shortValue()));
        deleteFileTask.setListener(new SimpleTaskListener() { // from class: com.jieli.jl_rcsp.tool.SyncMessageTask.5
            @Override // com.jieli.jl_rcsp.task.SimpleTaskListener, com.jieli.jl_rcsp.task.TaskListener
            public void onCancel(int i2) {
                SyncMessageTask.this.g = false;
                SyncMessageTask.this.c();
                OnWatchOpCallback onWatchOpCallback2 = onWatchOpCallback;
                if (onWatchOpCallback2 != null) {
                    onWatchOpCallback2.onFailed(new BaseError(4098, "Cancel operation. reason : " + i2));
                }
            }

            @Override // com.jieli.jl_rcsp.task.SimpleTaskListener, com.jieli.jl_rcsp.task.TaskListener
            public void onError(int i2, String str) {
                SyncMessageTask.this.g = false;
                SyncMessageTask.this.c();
                OnWatchOpCallback onWatchOpCallback2 = onWatchOpCallback;
                if (onWatchOpCallback2 != null) {
                    onWatchOpCallback2.onFailed(new BaseError(i2, str));
                }
            }

            @Override // com.jieli.jl_rcsp.task.SimpleTaskListener, com.jieli.jl_rcsp.task.TaskListener
            public void onFinish() {
                SyncMessageTask.this.b(a2);
                SyncMessageTask.this.g = false;
                SyncMessageTask.this.c();
                OnWatchOpCallback onWatchOpCallback2 = onWatchOpCallback;
                if (onWatchOpCallback2 != null) {
                    onWatchOpCallback2.onSuccess(Boolean.TRUE);
                }
            }
        });
        deleteFileTask.start();
        if (!this.g) {
            return;
        }
        b();
    }

    public void exit() {
        this.d = false;
        c();
    }

    public boolean isRunning() {
        return this.d;
    }

    public void putNotification(SyncTask syncTask) {
        if (!this.f18030a.isRcspInit()) {
            return;
        }
        try {
            this.b.put(syncTask);
            if (this.e) {
                this.e = false;
                c();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.d = true;
        ThreadStateListener threadStateListener = this.c;
        if (threadStateListener != null) {
            threadStateListener.onStart(getId());
        }
        synchronized (this.b) {
            while (this.d) {
                try {
                    this.e = this.b.isEmpty();
                    if (this.e) {
                        b();
                    } else {
                        SyncTask poll = this.b.poll();
                        if (!this.f18030a.isRcspInit()) {
                            this.b.clear();
                            this.d = false;
                            return;
                        } else if (poll != null) {
                            if (poll.getTaskOp() == 0) {
                                if (!this.f18030a.getDeviceInfo().isContactsTransferBySmallFile()) {
                                    a(poll.getMessage(), poll.getCallback());
                                } else {
                                    b(poll.getMessage(), poll.getCallback());
                                }
                            } else if (!this.f18030a.getDeviceInfo().isContactsTransferBySmallFile()) {
                                c(poll.getMessage(), poll.getCallback());
                            } else {
                                d(poll.getMessage(), poll.getCallback());
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.b.clear();
            this.h.clear();
            this.d = false;
            this.e = false;
            this.g = false;
            ThreadStateListener threadStateListener2 = this.c;
            if (threadStateListener2 != null) {
                threadStateListener2.onFinish(getId());
            }
            String str = i;
            JL_Log.w(str, str, "thread end");
        }
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        super.start();
    }

    public final void a(NotificationMsg notificationMsg, final OnWatchOpCallback<Boolean> onWatchOpCallback) {
        byte[] bArr;
        if (notificationMsg == null) {
            return;
        }
        if (this.f18030a.getDeviceInfo() == null) {
            this.b.clear();
            return;
        }
        JL_Log.i(i, "pushMessageInfo", "" + notificationMsg);
        byte[] beanToData = new MessageInfo(notificationMsg.getAppName(), notificationMsg.getFlag(), notificationMsg.getTitle(), notificationMsg.getContent(), notificationMsg.getTime()).beanToData();
        if (beanToData.length > 240) {
            int length = beanToData.length / 240;
            if (beanToData.length % 240 != 0) {
                length++;
            }
            int i2 = 0;
            for (final int i3 = length - 1; i3 >= 0; i3--) {
                int length2 = beanToData.length - i2;
                if (length2 <= 0) {
                    return;
                }
                if (length2 > 240) {
                    bArr = new byte[240];
                } else {
                    bArr = new byte[length2];
                }
                System.arraycopy(beanToData, i2, bArr, 0, bArr.length);
                i2 += bArr.length;
                a(i3, bArr, new OnWatchOpCallback<Boolean>() { // from class: com.jieli.jl_rcsp.tool.SyncMessageTask.1
                    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                    public void onFailed(BaseError baseError) {
                        OnWatchOpCallback onWatchOpCallback2 = onWatchOpCallback;
                        if (onWatchOpCallback2 != null) {
                            onWatchOpCallback2.onFailed(baseError);
                        }
                    }

                    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                    public void onSuccess(Boolean bool) {
                        OnWatchOpCallback onWatchOpCallback2;
                        if (i3 != 0 || (onWatchOpCallback2 = onWatchOpCallback) == null) {
                            return;
                        }
                        onWatchOpCallback2.onSuccess(Boolean.TRUE);
                    }
                });
            }
            return;
        }
        a(0, beanToData, onWatchOpCallback);
    }

    public final void c() {
        synchronized (this.b) {
            try {
                if (this.f) {
                    this.b.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.b) {
            try {
                if (!this.f) {
                    this.f = true;
                    this.b.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.f = false;
        }
    }

    public final void b(String str) {
        if (str != null) {
            this.h.remove(str);
        }
    }

    public final void a(int i2, byte[] bArr, final OnWatchOpCallback<Boolean> onWatchOpCallback) {
        PushInfoDataToDeviceCmd.MessageData messageData = new PushInfoDataToDeviceCmd.MessageData(i2, bArr);
        this.g = true;
        RcspOpImpl rcspOpImpl = this.f18030a;
        rcspOpImpl.sendRcspCommand(rcspOpImpl.getTargetDevice(), CommandBuilder.buildPushMessageInfoCmd(messageData), new BooleanRcspActionCallback("pushMessageInfo", new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.tool.SyncMessageTask.2
            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onFailed(BaseError baseError) {
                JL_Log.e(SyncMessageTask.i, "pushMessageInfo", "onFailed ---> " + baseError);
                SyncMessageTask.this.g = false;
                SyncMessageTask.this.c();
                OnWatchOpCallback onWatchOpCallback2 = onWatchOpCallback;
                if (onWatchOpCallback2 != null) {
                    onWatchOpCallback2.onFailed(baseError);
                }
            }

            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onSuccess(Boolean bool) {
                JL_Log.d(SyncMessageTask.i, "pushMessageInfo", "" + bool);
                SyncMessageTask.this.g = false;
                SyncMessageTask.this.c();
                OnWatchOpCallback onWatchOpCallback2 = onWatchOpCallback;
                if (onWatchOpCallback2 != null) {
                    onWatchOpCallback2.onSuccess(Boolean.TRUE);
                }
            }
        }));
        if (this.g) {
            b();
        }
    }

    public final String a(String str, long j) {
        return str + "_" + j;
    }

    public final void a(String str, short s) {
        if (str != null) {
            this.h.put(str, Short.valueOf(s));
        }
    }

    public final Short a(String str) {
        if (str == null) {
            return null;
        }
        return this.h.get(str);
    }
}
