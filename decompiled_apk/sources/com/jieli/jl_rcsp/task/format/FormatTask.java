package com.jieli.jl_rcsp.task.format;

import android.content.Context;
import com.jieli.jl_filebrowse.bean.SDCardBean;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.task.CallTransferTask;
import com.jieli.jl_rcsp.task.GetFileByNameTask;
import com.jieli.jl_rcsp.task.ITask;
import com.jieli.jl_rcsp.task.TaskBase;
import com.jieli.jl_rcsp.task.TaskListener;
import com.jieli.jl_rcsp.task.TransferTask;
import com.jieli.jl_rcsp.util.JL_Log;
import java.io.File;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* loaded from: classes10.dex */
public class FormatTask extends TaskBase {
    public final Context b;
    public final SDCardBean c;
    public final Queue<ITask> d;

    /* loaded from: classes10.dex */
    public class AddTaskListener extends NextListener {
        public final ITask c;

        public AddTaskListener(ITask iTask, String str) {
            super(str);
            this.c = iTask;
        }

        @Override // com.jieli.jl_rcsp.task.format.FormatTask.NextListener, com.jieli.jl_rcsp.task.TaskListener
        public void onFinish() {
            FormatTask.this.d.add(this.c);
            super.onFinish();
        }
    }

    /* loaded from: classes10.dex */
    public class ErrorStopListener extends NextListener {
        public ErrorStopListener(String str) {
            super(str);
        }

        @Override // com.jieli.jl_rcsp.task.format.FormatTask.NextListener, com.jieli.jl_rcsp.task.TaskListener
        public void onError(int i, String str) {
            JL_Log.w(((TaskBase) FormatTask.this).tag, "onError", "Formatting process stopped：task is --》" + this.f17975a);
            FormatTask.this.callbackError(i, str);
        }
    }

    /* loaded from: classes10.dex */
    public class NextListener implements TaskListener {

        /* renamed from: a, reason: collision with root package name */
        public String f17975a;

        public NextListener(String str) {
            this.f17975a = str;
        }

        @Override // com.jieli.jl_rcsp.task.TaskListener
        public void onBegin() {
            JL_Log.i(((TaskBase) FormatTask.this).tag, "onBegin", " Task begin :" + this.f17975a);
        }

        @Override // com.jieli.jl_rcsp.task.TaskListener
        public void onCancel(int i) {
            onError(i, "cancel");
        }

        @Override // com.jieli.jl_rcsp.task.TaskListener
        public void onError(int i, String str) {
            JL_Log.w(((TaskBase) FormatTask.this).tag, "onError", "The formatting task is error, do next task: error task --》" + this.f17975a);
            FormatTask.this.a();
        }

        @Override // com.jieli.jl_rcsp.task.TaskListener
        public void onFinish() {
            FormatTask.this.a();
        }

        @Override // com.jieli.jl_rcsp.task.TaskListener
        public void onProgress(int i) {
        }
    }

    public FormatTask(RcspOpImpl rcspOpImpl, Context context, SDCardBean sDCardBean) throws RuntimeException {
        super(rcspOpImpl);
        this.d = new ArrayBlockingQueue(6);
        if (context != null) {
            if (sDCardBean != null) {
                this.b = context;
                this.c = sDCardBean;
                return;
            }
            throw new RuntimeException("Device storage can not be null.");
        }
        throw new RuntimeException("Context can not be null.");
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void cancel(byte b) {
        throw new RuntimeException("can not cancel");
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void start() {
        callbackBegin();
        int devHandler = this.c.getDevHandler();
        boolean z = false;
        FormatBatchCmdTask formatBatchCmdTask = new FormatBatchCmdTask(this.mRcspOp, (byte) 0);
        FormatBatchCmdTask formatBatchCmdTask2 = new FormatBatchCmdTask(this.mRcspOp, Byte.MIN_VALUE);
        FormatCmdTask formatCmdTask = new FormatCmdTask(this.mRcspOp, Byte.MIN_VALUE, devHandler);
        StringBuilder sb = new StringBuilder();
        sb.append(this.b.getCacheDir());
        String str = File.separator;
        sb.append(str);
        sb.append("WMEM.BIN");
        String sb2 = sb.toString();
        GetFileByNameTask getFileByNameTask = new GetFileByNameTask(this.mRcspOp, new GetFileByNameTask.Param(devHandler, "WMEM.BIN", sb2, false));
        String str2 = this.b.getCacheDir() + str + "call.txt";
        GetFileByNameTask getFileByNameTask2 = new GetFileByNameTask(this.mRcspOp, new GetFileByNameTask.Param(devHandler, "call.txt", str2, false));
        TransferTask.Param param = new TransferTask.Param();
        param.devHandler = devHandler;
        if (this.c.getType() == 2) {
            z = true;
        }
        param.useFlash = z;
        TransferTask transferTask = new TransferTask(this.mRcspOp, sb2, param);
        transferTask.setListener(new NextListener("wmenSave task"));
        CallTransferTask callTransferTask = new CallTransferTask(this.mRcspOp, str2, param);
        callTransferTask.setListener(new NextListener("callSave task"));
        this.d.add(formatBatchCmdTask);
        this.d.add(getFileByNameTask);
        this.d.add(getFileByNameTask2);
        this.d.add(formatCmdTask);
        formatBatchCmdTask.setListener(new ErrorStopListener("start format batch cmd task"));
        getFileByNameTask.setListener(new AddTaskListener(transferTask, "wmen read task"));
        getFileByNameTask2.setListener(new AddTaskListener(callTransferTask, "call read  task"));
        formatCmdTask.setListener(new AddTaskListener(formatBatchCmdTask2, "  format cmd task"));
        formatBatchCmdTask2.setListener(new ErrorStopListener("stop format batch cmd task"));
        a();
    }

    public final void a() {
        ITask peek = this.d.peek();
        if (peek != null) {
            peek.start();
            this.d.poll();
        } else {
            callbackFinish();
        }
    }
}
