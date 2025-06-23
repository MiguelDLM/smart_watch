package com.jieli.jl_rcsp.task.contacts;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.interfaces.IHandleResult;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.command.file_op.SmallFileTransferCmd;
import com.jieli.jl_rcsp.task.ITask;
import com.jieli.jl_rcsp.task.SimpleTaskListener;
import com.jieli.jl_rcsp.task.TaskBase;
import com.jieli.jl_rcsp.task.smallfile.AddFileTask;
import com.jieli.jl_rcsp.task.smallfile.DeleteFileTask;
import com.jieli.jl_rcsp.task.smallfile.UpdateFileTask;
import com.jieli.jl_rcsp.tool.CustomRcspActionCallback;
import com.jieli.jl_rcsp.util.JL_Log;
import java.util.List;

/* loaded from: classes10.dex */
public class UpdateContactsBySmallFileTask extends TaskBase {
    public ITask b;
    public final List<DeviceContacts> c;

    public UpdateContactsBySmallFileTask(RcspOpImpl rcspOpImpl, List<DeviceContacts> list) throws RuntimeException {
        super(rcspOpImpl);
        if (list != null) {
            this.c = list;
            return;
        }
        throw new RuntimeException("contacts can not be null.");
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void cancel(byte b) {
        if (!isRun()) {
            return;
        }
        ITask iTask = this.b;
        if (iTask != null) {
            iTask.cancel(b);
        } else {
            callbackCancel(b);
        }
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void start() {
        if (isRun()) {
            JL_Log.w(this.tag, "start", "Task is in progress.");
            return;
        }
        callbackBegin();
        if (!this.c.isEmpty() && this.c.get(0).getFileId() > 0) {
            JL_Log.d(this.tag, "start", "Update");
            this.b = new UpdateFileTask(this.mRcspOp, new UpdateFileTask.Param((byte) 1, this.c.get(0).getFileId(), DeviceContacts.toData(this.c)));
            b();
            return;
        }
        JL_Log.d(this.tag, "start", "Query first, then update");
        a();
    }

    public final void b() {
        this.b.setListener(new SimpleTaskListener() { // from class: com.jieli.jl_rcsp.task.contacts.UpdateContactsBySmallFileTask.3
            @Override // com.jieli.jl_rcsp.task.SimpleTaskListener, com.jieli.jl_rcsp.task.TaskListener
            public void onCancel(int i) {
                UpdateContactsBySmallFileTask.this.callbackCancel(i);
            }

            @Override // com.jieli.jl_rcsp.task.SimpleTaskListener, com.jieli.jl_rcsp.task.TaskListener
            public void onError(int i, String str) {
                UpdateContactsBySmallFileTask.this.callbackError(i, str);
            }

            @Override // com.jieli.jl_rcsp.task.SimpleTaskListener, com.jieli.jl_rcsp.task.TaskListener
            public void onFinish() {
                UpdateContactsBySmallFileTask.this.callbackFinish();
            }

            @Override // com.jieli.jl_rcsp.task.SimpleTaskListener, com.jieli.jl_rcsp.task.TaskListener
            public void onProgress(int i) {
                UpdateContactsBySmallFileTask.this.callbackProgress(i);
            }
        });
        this.b.start();
    }

    public final void a() {
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), new SmallFileTransferCmd(new SmallFileTransferCmd.QueryParam((byte) 1)), new CustomRcspActionCallback("queryContactList", new OnOperationCallback<SmallFileTransferCmd.QueryResponse>() { // from class: com.jieli.jl_rcsp.task.contacts.UpdateContactsBySmallFileTask.1
            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onFailed(BaseError baseError) {
                UpdateContactsBySmallFileTask.this.callbackError(baseError.getSubCode(), baseError.getMessage());
            }

            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onSuccess(SmallFileTransferCmd.QueryResponse queryResponse) {
                UpdateContactsBySmallFileTask.this.a(queryResponse.getFiles());
            }
        }, new IHandleResult<SmallFileTransferCmd.QueryResponse, SmallFileTransferCmd>() { // from class: com.jieli.jl_rcsp.task.contacts.UpdateContactsBySmallFileTask.2
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public int hasResult(BluetoothDevice bluetoothDevice, SmallFileTransferCmd smallFileTransferCmd) {
                return 0;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public SmallFileTransferCmd.QueryResponse handleResult(BluetoothDevice bluetoothDevice, SmallFileTransferCmd smallFileTransferCmd) {
                if (smallFileTransferCmd != null && smallFileTransferCmd.getStatus() == 0 && (smallFileTransferCmd.getResponse() instanceof SmallFileTransferCmd.QueryResponse)) {
                    return (SmallFileTransferCmd.QueryResponse) smallFileTransferCmd.getResponse();
                }
                return null;
            }
        }));
    }

    public final void a(List<SmallFileTransferCmd.QueryResponse.File> list) {
        byte[] data = DeviceContacts.toData(this.c);
        if (data.length == 0 && list.isEmpty()) {
            JL_Log.d(this.tag, "updateByQuery", "No contact data, no contact file, end.");
            callbackFinish();
            return;
        }
        if (data.length == 0) {
            JL_Log.d(this.tag, "updateByQuery", "No contact data and contact files, delete the contact files.");
            this.b = new DeleteFileTask(this.mRcspOp, new DeleteFileTask.Param((byte) 1, list.get(0).id));
        } else if (list.isEmpty()) {
            JL_Log.d(this.tag, "updateByQuery", "There is contact data but no contact file, add the contact file.");
            this.b = new AddFileTask(this.mRcspOp, new AddFileTask.Param((byte) 1, data));
        } else {
            JL_Log.d(this.tag, "updateByQuery", "There is contact data and contact file, update the contact file.");
            this.b = new UpdateFileTask(this.mRcspOp, new UpdateFileTask.Param((byte) 1, list.get(0).id, data));
        }
        b();
    }
}
