package com.jieli.jl_rcsp.task.contacts;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.interfaces.IHandleResult;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.command.file_op.SmallFileTransferCmd;
import com.jieli.jl_rcsp.task.SimpleTaskListener;
import com.jieli.jl_rcsp.task.TaskBase;
import com.jieli.jl_rcsp.task.smallfile.ReadFileTask;
import com.jieli.jl_rcsp.tool.CustomRcspActionCallback;
import com.jieli.jl_rcsp.util.JL_Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class ReadContactsBySmallFileTask extends TaskBase {
    public ReadFileTask b;
    public List<DeviceContacts> c;

    public ReadContactsBySmallFileTask(RcspOpImpl rcspOpImpl) throws RuntimeException {
        super(rcspOpImpl);
        this.c = new ArrayList();
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void cancel(byte b) {
        if (!isRun()) {
            return;
        }
        ReadFileTask readFileTask = this.b;
        if (readFileTask != null) {
            readFileTask.cancel(b);
        } else {
            callbackCancel(b);
        }
    }

    public List<DeviceContacts> getContacts() {
        return this.c;
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void start() {
        if (isRun()) {
            JL_Log.w(this.tag, "start", "Task is in progress.");
            return;
        }
        callbackBegin();
        SmallFileTransferCmd smallFileTransferCmd = new SmallFileTransferCmd(new SmallFileTransferCmd.QueryParam((byte) 1));
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), smallFileTransferCmd, new CustomRcspActionCallback(this.tag + "#SmallFileTransfer", new OnOperationCallback<SmallFileTransferCmd.QueryResponse>() { // from class: com.jieli.jl_rcsp.task.contacts.ReadContactsBySmallFileTask.1
            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onFailed(BaseError baseError) {
                ReadContactsBySmallFileTask.this.callbackError(baseError.getSubCode(), baseError.getMessage());
            }

            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onSuccess(SmallFileTransferCmd.QueryResponse queryResponse) {
                List<SmallFileTransferCmd.QueryResponse.File> files = queryResponse.getFiles();
                if (files.isEmpty()) {
                    ReadContactsBySmallFileTask.this.a((short) 0, new byte[0]);
                    ReadContactsBySmallFileTask.this.callbackFinish();
                } else {
                    final SmallFileTransferCmd.QueryResponse.File file = files.get(0);
                    ReadFileTask.Param param = new ReadFileTask.Param((byte) 1, file.id, file.size, 0);
                    ReadContactsBySmallFileTask.this.b = new ReadFileTask(((TaskBase) ReadContactsBySmallFileTask.this).mRcspOp, param);
                    ReadContactsBySmallFileTask.this.b.setListener(new SimpleTaskListener() { // from class: com.jieli.jl_rcsp.task.contacts.ReadContactsBySmallFileTask.1.1
                        @Override // com.jieli.jl_rcsp.task.SimpleTaskListener, com.jieli.jl_rcsp.task.TaskListener
                        public void onCancel(int i) {
                            ReadContactsBySmallFileTask.this.callbackCancel(i);
                        }

                        @Override // com.jieli.jl_rcsp.task.SimpleTaskListener, com.jieli.jl_rcsp.task.TaskListener
                        public void onError(int i, String str) {
                            ReadContactsBySmallFileTask.this.callbackError(i, str);
                        }

                        @Override // com.jieli.jl_rcsp.task.SimpleTaskListener, com.jieli.jl_rcsp.task.TaskListener
                        public void onFinish() {
                            ReadContactsBySmallFileTask.this.a(file.id, ReadContactsBySmallFileTask.this.b.getReadData());
                            ReadContactsBySmallFileTask.this.callbackFinish();
                        }

                        @Override // com.jieli.jl_rcsp.task.SimpleTaskListener, com.jieli.jl_rcsp.task.TaskListener
                        public void onProgress(int i) {
                            ReadContactsBySmallFileTask.this.callbackProgress(i);
                        }
                    });
                    ReadContactsBySmallFileTask.this.b.start();
                }
            }
        }, new IHandleResult<SmallFileTransferCmd.QueryResponse, SmallFileTransferCmd>() { // from class: com.jieli.jl_rcsp.task.contacts.ReadContactsBySmallFileTask.2
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public int hasResult(BluetoothDevice bluetoothDevice, SmallFileTransferCmd smallFileTransferCmd2) {
                return 0;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public SmallFileTransferCmd.QueryResponse handleResult(BluetoothDevice bluetoothDevice, SmallFileTransferCmd smallFileTransferCmd2) {
                if (smallFileTransferCmd2 != null && smallFileTransferCmd2.getStatus() == 0 && (smallFileTransferCmd2.getResponse() instanceof SmallFileTransferCmd.QueryResponse)) {
                    return (SmallFileTransferCmd.QueryResponse) smallFileTransferCmd2.getResponse();
                }
                return null;
            }
        }));
    }

    public final void a(short s, byte[] bArr) {
        this.c = DeviceContacts.fromData(s, bArr);
    }
}
