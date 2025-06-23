package com.goodix.ble.libcomx.task;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHeaders;

/* loaded from: classes9.dex */
public class TaskError extends Error {
    private String extMessage;
    private ITask task;

    /* loaded from: classes9.dex */
    public static class Abort extends TaskError {
        public Abort(ITask iTask) {
            super(iTask, "Abort");
        }

        public Abort(ITask iTask, String str) {
            super(iTask, str);
        }
    }

    /* loaded from: classes9.dex */
    public static class Timeout extends TaskError {
        public Timeout(ITask iTask) {
            super(iTask, HttpHeaders.TIMEOUT);
        }

        public Timeout(ITask iTask, String str) {
            super(iTask, str);
        }
    }

    public TaskError(ITask iTask) {
        this.task = iTask;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.extMessage == null) {
            this.extMessage = "[" + this.task.getName() + "]: " + super.getMessage();
        }
        return this.extMessage;
    }

    public String getRawMessage() {
        return super.getMessage();
    }

    public Throwable getRootCause() {
        Throwable th = this;
        for (int i = 65535; th.getCause() != null && i != 0; i--) {
            th = th.getCause();
        }
        return th;
    }

    public ITask getTask() {
        return this.task;
    }

    public TaskError(ITask iTask, String str) {
        super(str);
        this.task = iTask;
    }

    public TaskError(ITask iTask, String str, Throwable th) {
        super(str, th);
        this.task = iTask;
    }

    public TaskError(ITask iTask, Throwable th) {
        super(th);
        this.task = iTask;
    }
}
